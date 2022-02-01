package com.tencent.hippy.qq.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
  SharedPreferences mSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("hippy_error", 4);
  
  private HippyErrorManager()
  {
    if ((isQQVerChanged()) || (isHippyLibraryChenaged()))
    {
      clearAllFlags();
      return;
    }
    checkAllFlags();
  }
  
  private void checkAllFlags()
  {
    Object localObject = this.mSharedPreferences.getAll();
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((Map)localObject).keySet();
      if (localObject != null)
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          if (str1.startsWith("flag_"))
          {
            String str2 = str1.substring("flag_".length());
            String str3 = "errcount_" + str2;
            int i = this.mSharedPreferences.getInt(str3, 0) + 1;
            this.mSharedPreferences.edit().putInt(str3, i).remove(str1).commit();
            QLog.i("HippyErrorManager", 1, "checkAllFlags " + str2 + " errorCount:" + i);
            HippyReporter.getInstance().reportStepCrash(str2);
          }
        }
      }
    }
  }
  
  private void clearAllFlags()
  {
    QLog.i("HippyErrorManager", 1, "clearAllFlags");
    this.mSharedPreferences.edit().clear().commit();
    this.mSharedPreferences.edit().putString("qqVersion", "8.5.5.5105").commit();
    int i = HippyQQLibraryManager.getInstance().getHippyLibrayId();
    if (i != 0) {
      this.mSharedPreferences.edit().putInt("soVersion", i).commit();
    }
  }
  
  public static HippyErrorManager getInstance()
  {
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new HippyErrorManager();
      }
      return INSTANCE;
    }
    finally {}
  }
  
  private boolean isHippyLibraryChenaged()
  {
    int i = HippyQQLibraryManager.getInstance().getHippyLibrayId();
    int j = this.mSharedPreferences.getInt("soVersion", 0);
    if ((j == 0) || (i == 0)) {
      if (i != 0) {
        this.mSharedPreferences.edit().putInt("soVersion", i).commit();
      }
    }
    while (i == j) {
      return false;
    }
    return true;
  }
  
  private boolean isQQVerChanged()
  {
    String str = this.mSharedPreferences.getString("qqVersion", null);
    if (TextUtils.isEmpty(str)) {
      this.mSharedPreferences.edit().putString("qqVersion", "8.5.5.5105").commit();
    }
    while ("8.5.5.5105".equals(str)) {
      return false;
    }
    return true;
  }
  
  public void endAllOperation()
  {
    int i = 0;
    while (i < STEPNAMES.length)
    {
      operationEnd(STEPNAMES[i]);
      i += 1;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < STEPNAMES.length)
      {
        if (STEPNAMES[i].hashCode() == paramMessage.what)
        {
          paramMessage = STEPNAMES[i];
          String str = "timeoutcount_" + paramMessage;
          i = this.mSharedPreferences.getInt(str, 0) + 1;
          QLog.i("HippyErrorManager", 1, "handleMessage timeout " + paramMessage + " count:" + i);
          this.mSharedPreferences.edit().putInt(str, i).remove("flag_" + paramMessage).remove("errcount_" + paramMessage).remove("timeoutcount_" + paramMessage).commit();
          HippyReporter.getInstance().reportStepTimeOut(paramMessage);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean isContinuouslyCrash(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.mSharedPreferences.getInt("errcount_" + paramString, 0) < 3) {
      return false;
    }
    return true;
  }
  
  public void operationEnd(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHandler.removeMessages(paramString.hashCode());
    this.mSharedPreferences.edit().remove("flag_" + paramString).remove("errcount_" + paramString).remove("timeoutcount_" + paramString).commit();
  }
  
  public void operationStart(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHandler.removeMessages(paramString.hashCode());
    this.mHandler.sendEmptyMessageDelayed(paramString.hashCode(), 5000L);
    this.mSharedPreferences.edit().putBoolean("flag_" + paramString, true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyErrorManager
 * JD-Core Version:    0.7.0.1
 */