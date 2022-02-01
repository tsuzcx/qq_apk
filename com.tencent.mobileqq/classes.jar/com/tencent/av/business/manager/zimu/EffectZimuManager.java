package com.tencent.av.business.manager.zimu;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AudioTransClientInfoHandler;
import com.tencent.av.business.handler.AudioTransClientInterfaceHandler;
import com.tencent.av.business.handler.BusinessHandlerFactory;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.EffectMutexManager.IMutexItem;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class EffectZimuManager
  extends EffectConfigBase<ZimuItem>
  implements EffectMutexManager.IMutexItem
{
  protected boolean k = false;
  boolean l = false;
  boolean m = false;
  
  public EffectZimuManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qav_zimu", 4);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = a(paramContext).edit();
    paramContext.putInt("qav_zimu_is_show", paramInt);
    paramContext.commit();
  }
  
  public static void a(VideoController paramVideoController)
  {
    if (paramVideoController != null)
    {
      String str;
      if (ZimuToolbar.isSupport()) {
        str = "SUPPORT_TRUE";
      } else {
        str = "SUPPORT_FALSE";
      }
      paramVideoController.e(7, str);
    }
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = false;
    if (paramVideoAppInterface == null) {
      return false;
    }
    ((EffectZimuManager)paramVideoAppInterface.c(0)).g();
    if (a(paramVideoAppInterface.getApp()).getInt("qav_zimu_is_show", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private boolean d(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = true;
    if (!bool2) {
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.has("switch")) {
          return bool1;
        }
        paramString = paramString.getString("switch");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parse ZIMU:");
        localStringBuilder.append(paramString);
        AVLog.printColorLog("EffectZimuManager", localStringBuilder.toString());
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase("off")))
        {
          a(this.c.getApplication(), 0);
          return true;
        }
        a(this.c.getApplication(), 1);
        return true;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    } else {
      bool1 = false;
    }
    return bool1;
  }
  
  protected void a()
  {
    super.a();
    EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.c.c(12);
    if (localEffectMutexManager != null) {
      localEffectMutexManager.a(3001, this);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt != 2) && (paramInt != 3)) {
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("onSessionStatusChanged, event[");
    paramString1.append(paramInt);
    paramString1.append("], seq[");
    paramString1.append(paramLong);
    paramString1.append("]");
    QLog.w("EffectZimuManager", 1, paramString1.toString());
    paramString1 = (AudioTransClientInfoHandler)this.c.getBusinessHandler(BusinessHandlerFactory.b);
    if (paramString1 != null) {
      paramString1.b();
    }
    new ControlUIObserver.ZimuRequest(paramLong, "onSessionStatusChanged", 2, null).a(this.c);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.l)
    {
      AudioTransClientInterfaceHandler localAudioTransClientInterfaceHandler = (AudioTransClientInterfaceHandler)this.c.getBusinessHandler(BusinessHandlerFactory.a);
      localAudioTransClientInterfaceHandler.a(paramString, paramLong, "TransInfo.ExitSession", null);
      localAudioTransClientInterfaceHandler.onDestroy();
      ((AudioTransClientInfoHandler)this.c.getBusinessHandler(BusinessHandlerFactory.b)).b();
    }
    this.l = false;
    AVVoiceRecog.b().c(4);
  }
  
  public void a(String paramString1, boolean paramBoolean, long paramLong, String paramString2)
  {
    AVVoiceRecog.b().b(4);
    if (!this.l)
    {
      AudioTransClientInfoHandler localAudioTransClientInfoHandler = (AudioTransClientInfoHandler)this.c.getBusinessHandler(BusinessHandlerFactory.b);
      localAudioTransClientInfoHandler.a(paramString1, "TransInfoCreate.CreateSession", paramLong, paramString2);
      localAudioTransClientInfoHandler.onDestroy();
      this.m = paramBoolean;
    }
    this.l = true;
  }
  
  public boolean a(long paramLong, ZimuItem paramZimuItem)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCurrentItem, seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], item[");
      ((StringBuilder)localObject).append(paramZimuItem);
      ((StringBuilder)localObject).append("]");
      QLog.w("EffectZimuManager", 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
    }
    boolean bool = super.a(paramLong, paramZimuItem);
    if (bool)
    {
      if (paramZimuItem == null) {
        localObject = null;
      } else {
        localObject = paramZimuItem.getId();
      }
      EffectZimuManager.DataReport.a((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurrentItem_");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localStringBuilder.append(paramLong);
      b(localStringBuilder.toString(), false);
    }
    Object localObject = this.c;
    int i;
    if (this.d == null) {
      i = 4;
    } else {
      i = 5;
    }
    ((VideoAppInterface)localObject).a(new Object[] { Integer.valueOf(165), Integer.valueOf(i) });
    if (paramZimuItem != null)
    {
      localObject = (EffectMutexManager)this.c.c(12);
      if (localObject != null) {
        ((EffectMutexManager)localObject).a(3001, paramZimuItem.getId());
      }
    }
    return bool;
  }
  
  protected boolean a(String paramString)
  {
    return d(d());
  }
  
  public int b()
  {
    return 216;
  }
  
  public void b(int paramInt, String paramString)
  {
    if ((paramInt == 3002) || (paramInt == 3003) || (paramInt == 3006)) {
      a(AudioHelper.c(), "");
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    AVVoiceRecog.b().b(4);
    if (this.l)
    {
      AudioTransClientInterfaceHandler localAudioTransClientInterfaceHandler = (AudioTransClientInterfaceHandler)this.c.getBusinessHandler(BusinessHandlerFactory.a);
      localAudioTransClientInterfaceHandler.a(paramString, paramLong, "TransInfo.ChangeSession", null);
      localAudioTransClientInterfaceHandler.onDestroy();
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (this.k != paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setRecievedSentence, from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], mIsRecieveSentence[");
      localStringBuilder.append(this.k);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w("EffectZimuManager", 1, localStringBuilder.toString());
      this.k = paramBoolean;
    }
  }
  
  protected List<ZimuItem> c(int paramInt, String paramString)
  {
    List localList = super.c(paramInt, paramString);
    d(paramString);
    return localList;
  }
  
  public List<ZimuItem> c(String paramString)
  {
    paramString = super.c(paramString);
    ArrayList localArrayList = new ArrayList();
    if (this.e != null) {
      localArrayList.addAll(paramString);
    }
    return localArrayList;
  }
  
  protected Class<?> i()
  {
    return ZimuItem.class;
  }
  
  public boolean j()
  {
    return this.k;
  }
  
  public boolean k()
  {
    return this.m;
  }
  
  public boolean l()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.EffectZimuManager
 * JD-Core Version:    0.7.0.1
 */