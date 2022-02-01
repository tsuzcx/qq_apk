package com.tencent.hippy.qq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class HippyErrorManager
  implements Handler.Callback
{
  private static final int CONTINUOS_CRASH_MIN_COUNT = 3;
  private static HippyErrorManager INSTANCE;
  private static final String PREF_KEY_ERROR_COUNT_PREFIX = "errcount_";
  private static final String PREF_KEY_FLAG_PREFIX = "flag_";
  private static final String PREF_KEY_HIPPY_VERSION = "soVersion";
  private static final String PREF_KEY_QQ_VERSION = "qqVersion";
  private static final String PREF_KEY_TIMEOUT_COUNT_PREFIX = "timeoutcount_";
  private static final String PREF_NAME_HIPPY_ERROR = "hippy_error";
  private static final String[] STEPNAMES = { "loadHippySo", "initHippyEngine" };
  private static final String TAG = "HippyErrorManager";
  private static final int TIME_OUT_TIME = 5000;
  private Handler mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  SharedPreferences mSharedPreferences = MobileQQ.getContext().getSharedPreferences("hippy_error", 4);
  
  private HippyErrorManager()
  {
    if ((!isQQVerChanged()) && (!isHippyLibraryChenaged()))
    {
      checkAllFlags();
      return;
    }
    clearAllFlags();
  }
  
  private void checkAllFlags()
  {
    Object localObject1 = this.mSharedPreferences.getAll();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Map)localObject1).keySet();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      if (((String)localObject2).startsWith("flag_"))
      {
        String str = ((String)localObject2).substring(5);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("errcount_");
        ((StringBuilder)localObject3).append(str);
        localObject3 = ((StringBuilder)localObject3).toString();
        int i = this.mSharedPreferences.getInt((String)localObject3, 0) + 1;
        this.mSharedPreferences.edit().putInt((String)localObject3, i).remove((String)localObject2).commit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkAllFlags ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" errorCount:");
        ((StringBuilder)localObject2).append(i);
        QLog.i("HippyErrorManager", 1, ((StringBuilder)localObject2).toString());
        HippyReporter.getInstance().reportStepCrash(str);
      }
    }
  }
  
  private void clearAllFlags()
  {
    QLog.i("HippyErrorManager", 1, "clearAllFlags");
    this.mSharedPreferences.edit().clear().commit();
    this.mSharedPreferences.edit().putString("qqVersion", "8.8.17.5770").commit();
    int i = ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).getHippyLibrayId();
    if (i != 0) {
      this.mSharedPreferences.edit().putInt("soVersion", i).commit();
    }
  }
  
  public static HippyErrorManager getInstance()
  {
    if (INSTANCE == null) {
      try
      {
        if (INSTANCE == null) {
          INSTANCE = new HippyErrorManager();
        }
      }
      finally {}
    }
    return INSTANCE;
  }
  
  private boolean isHippyLibraryChenaged()
  {
    int i = ((IHippyLibrary)QRoute.api(IHippyLibrary.class)).getHippyLibrayId();
    SharedPreferences localSharedPreferences = this.mSharedPreferences;
    boolean bool = false;
    int j = localSharedPreferences.getInt("soVersion", 0);
    if ((j != 0) && (i != 0))
    {
      if (i != j) {
        bool = true;
      }
      return bool;
    }
    if (i != 0) {
      this.mSharedPreferences.edit().putInt("soVersion", i).commit();
    }
    return false;
  }
  
  private boolean isQQVerChanged()
  {
    String str = this.mSharedPreferences.getString("qqVersion", null);
    if (TextUtils.isEmpty(str))
    {
      this.mSharedPreferences.edit().putString("qqVersion", "8.8.17.5770").commit();
      return false;
    }
    return "8.8.17.5770".equals(str) ^ true;
  }
  
  public void endAllOperation()
  {
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = STEPNAMES;
      if (i >= arrayOfString.length) {
        break;
      }
      operationEnd(arrayOfString[i]);
      i += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    for (;;)
    {
      Object localObject = STEPNAMES;
      if (i >= localObject.length) {
        break;
      }
      if (localObject[i].hashCode() == paramMessage.what)
      {
        paramMessage = STEPNAMES[i];
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("timeoutcount_");
        ((StringBuilder)localObject).append(paramMessage);
        localObject = ((StringBuilder)localObject).toString();
        i = this.mSharedPreferences.getInt((String)localObject, 0) + 1;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage timeout ");
        localStringBuilder.append(paramMessage);
        localStringBuilder.append(" count:");
        localStringBuilder.append(i);
        QLog.i("HippyErrorManager", 1, localStringBuilder.toString());
        localObject = this.mSharedPreferences.edit().putInt((String)localObject, i);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("flag_");
        localStringBuilder.append(paramMessage);
        localObject = ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("errcount_");
        localStringBuilder.append(paramMessage);
        localObject = ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("timeoutcount_");
        localStringBuilder.append(paramMessage);
        ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString()).commit();
        HippyReporter.getInstance().reportStepTimeOut(paramMessage);
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isContinuouslyCrash(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    SharedPreferences localSharedPreferences = this.mSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errcount_");
    localStringBuilder.append(paramString);
    if (localSharedPreferences.getInt(localStringBuilder.toString(), 0) >= 3) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void operationEnd(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHandler.removeMessages(paramString.hashCode());
    SharedPreferences.Editor localEditor = this.mSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("flag_");
    localStringBuilder.append(paramString);
    localEditor = localEditor.remove(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("errcount_");
    localStringBuilder.append(paramString);
    localEditor = localEditor.remove(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("timeoutcount_");
    localStringBuilder.append(paramString);
    localEditor.remove(localStringBuilder.toString()).commit();
  }
  
  public void operationStart(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHandler.removeMessages(paramString.hashCode());
    this.mHandler.sendEmptyMessageDelayed(paramString.hashCode(), 5000L);
    SharedPreferences.Editor localEditor = this.mSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("flag_");
    localStringBuilder.append(paramString);
    localEditor.putBoolean(localStringBuilder.toString(), true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyErrorManager
 * JD-Core Version:    0.7.0.1
 */