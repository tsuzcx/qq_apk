import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minigame.utils.AppUtil;
import com.tencent.mobileqq.qassistant.wake.WakeManager.2;
import com.tencent.mobileqq.qassistant.wake.WakeManager.3;
import com.tencent.mobileqq.qassistant.wake.aicore.QQWakeAIEngine;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class azhh
  implements Handler.Callback
{
  private volatile Handler jdField_a_of_type_AndroidOsHandler;
  private volatile HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ayzm jdField_a_of_type_Ayzm;
  private volatile azgv jdField_a_of_type_Azgv;
  private azhl jdField_a_of_type_Azhl = new azhl();
  private azhn jdField_a_of_type_Azhn;
  private volatile azhs jdField_a_of_type_Azhs;
  public volatile boolean a;
  private Handler b;
  public volatile boolean b;
  public boolean c;
  public volatile boolean d;
  public volatile boolean e;
  public volatile boolean f;
  public boolean g;
  private boolean h;
  
  private azhh()
  {
    azeu.a("HelloQQWake", "WakeManager()");
  }
  
  public static azhh a()
  {
    return azhm.a();
  }
  
  public static String a()
  {
    try
    {
      String str = azeu.a().getAccount();
      str = "enable" + str;
      return str;
    }
    catch (Exception localException) {}
    return "enable";
  }
  
  private void b()
  {
    try
    {
      if (d())
      {
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
        }
        if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
        {
          this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("QQWAKE_THREAD");
          this.jdField_a_of_type_AndroidOsHandlerThread.start();
        }
        if (this.jdField_b_of_type_AndroidOsHandler == null) {
          this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
        }
        if (this.jdField_a_of_type_Azhs == null) {
          this.jdField_a_of_type_Azhs = new azhs();
        }
        if (this.jdField_a_of_type_Azhl == null) {
          this.jdField_a_of_type_Azhl = new azhl();
        }
        if (this.jdField_a_of_type_Azhn == null) {
          this.jdField_a_of_type_Azhn = azhn.a();
        }
        if (((this.jdField_a_of_type_Azgv == null) || (!this.jdField_a_of_type_Azgv.b())) && (azfc.a(this.jdField_a_of_type_Azhl)))
        {
          if (this.jdField_a_of_type_Azgv == null) {
            this.jdField_a_of_type_Azgv = new azgv();
          }
          this.jdField_a_of_type_Azgv.a(new azhk(this));
          this.jdField_a_of_type_Azgv.a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        }
        this.c = true;
        if (a()) {
          a("WakeManager init");
        }
      }
      return;
    }
    finally {}
  }
  
  private void c()
  {
    Object localObject = azeu.a();
    if (localObject != null)
    {
      localObject = ((azfg)localObject).a();
      if (localObject != null)
      {
        this.jdField_b_of_type_Boolean = ((azdj)localObject).a(new azhj(this));
        if (!this.jdField_b_of_type_Boolean) {
          azeu.a("HelloQQWake", "Recorder init failure");
        }
      }
    }
  }
  
  private boolean c()
  {
    if (this.f)
    {
      azeu.a("HelloQQWake", "canStart() isBackstage is true");
      return false;
    }
    if (!b())
    {
      azeu.a("HelloQQWake", "canStart() enable is false");
      return false;
    }
    if (!QQWakeAIEngine.jdField_b_of_type_Boolean)
    {
      azeu.a("HelloQQWake", "canStart() QQWakeAIEngine.sCanInit is false");
      return false;
    }
    if (!this.h)
    {
      azeu.a("HelloQQWake", "canStart() wakeManagerInit is false");
      return false;
    }
    return true;
  }
  
  private boolean d()
  {
    if (!azfc.a(this.jdField_a_of_type_Azhl))
    {
      azeu.a("HelloQQWake", "canInit() no model");
      return false;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      azeu.a("HelloQQWake", "canInit() canOpenInSp false");
      return false;
    }
    if (!AppUtil.isMainProcess())
    {
      azeu.a("HelloQQWake", "canInit() not in MainProcess");
      return false;
    }
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        azeu.a("HelloQQWake", "canInit() no record permission");
        return false;
        i = 0;
      }
      else
      {
        QQAppInterface localQQAppInterface = azeu.a();
        if ((localQQAppInterface == null) || (!localQQAppInterface.isLogin()))
        {
          azeu.a("HelloQQWake", "canInit() not login");
          return false;
        }
        return true;
        i = 1;
      }
    }
  }
  
  private boolean e()
  {
    azfg localazfg = azeu.a();
    if ((localazfg != null) && (localazfg.a() != null)) {
      return localazfg.a().jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      azeu.a("HelloQQWake", "release() MSG_RELEASE");
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1003);
    }
  }
  
  /* Error */
  public void a(BaseActivity paramBaseActivity, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 238	azgy:jdField_b_of_type_Boolean	Z
    //   5: ifeq +17 -> 22
    //   8: invokestatic 242	azhq:b	()Lazhn;
    //   11: astore_3
    //   12: aload_0
    //   13: aload_1
    //   14: aload_2
    //   15: aload_3
    //   16: invokevirtual 245	azhh:a	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/lang/String;Lazhn;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 121	azhn:a	()Lazhn;
    //   25: astore_3
    //   26: goto -14 -> 12
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	azhh
    //   0	34	1	paramBaseActivity	BaseActivity
    //   0	34	2	paramString	String
    //   11	15	3	localazhn	azhn
    // Exception table:
    //   from	to	target	type
    //   2	12	29	finally
    //   12	19	29	finally
    //   22	26	29	finally
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString, azhn paramazhn)
  {
    for (;;)
    {
      try
      {
        azeu.a("HelloQQWake", "startRecord():from:" + paramString);
        if (c())
        {
          if ((!this.d) || (!azgy.a())) {
            continue;
          }
          if ((AppUtil.isMainProcess()) && (paramBaseActivity != null))
          {
            azeu.a("HelloQQWake", "startRecord() guider: " + paramBaseActivity.getActivityName());
            paramBaseActivity.runOnUiThread(new WakeManager.2(this, paramBaseActivity));
            bcef.b(null, "dc00898", "", "", "0X800B162", "0X800B162", 0, 0, "", "", "", "");
          }
        }
        return;
        if (a())
        {
          azeu.a("HelloQQWake", "startRecord() no guider");
          this.jdField_a_of_type_Azhn = paramazhn;
          if (this.jdField_b_of_type_AndroidOsHandler == null) {
            continue;
          }
          this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1000);
          if (!"firstInit".equals(paramString)) {
            continue;
          }
          bcef.b(null, "dc00898", "", "", "0X800B160", "0X800B160", 0, 0, "", "", "", "");
          continue;
        }
        azeu.a("HelloQQWake", "startRecord() initRecorder");
      }
      finally {}
      b();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      a(BaseActivity.sTopActivity, paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    azeu.a("HelloQQWake", "setCanOpenInSp:" + paramBoolean);
    this.jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).edit();
      localEditor.putBoolean("qq_assistant_wake_open", paramBoolean);
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      azeu.a("HelloQQWake", localException.getMessage());
    }
  }
  
  public boolean a()
  {
    if (!this.c)
    {
      azeu.a("HelloQQWake", "allInit() wakeInit false");
      return false;
    }
    if ((this.jdField_a_of_type_Azgv == null) || (!this.jdField_a_of_type_Azgv.b()))
    {
      azeu.a("HelloQQWake", "allInit() HelloQQHelper.isInit() false");
      return false;
    }
    azeu.a("HelloQQWake", "allInit() wakeInit true");
    return true;
  }
  
  public azhh b()
  {
    azeu.a("HelloQQWake", "init()");
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0);
    this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("qq_assistant_wake_open", false);
    this.d = ((SharedPreferences)localObject).getBoolean(a(), false);
    this.e = ((SharedPreferences)localObject).getBoolean("ban", false);
    this.g = SoLoadUtil.a();
    if (b())
    {
      localObject = azeu.a();
      if (localObject != null) {
        ((azfg)localObject).a();
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.f = false;
    this.jdField_a_of_type_Ayzm = new azhi(this);
    localObject = azeu.a();
    if (localObject != null) {
      ((QQAppInterface)localObject).addObserver(this.jdField_a_of_type_Ayzm);
    }
    this.h = true;
    return this;
  }
  
  public void b(String paramString)
  {
    try
    {
      azeu.a("HelloQQWake", "stopRecord() from:" + paramString);
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean b()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      azeu.a("HelloQQWake", "getEnable() VERSION : " + Build.VERSION.SDK_INT);
      return false;
    }
    if (this.g)
    {
      azeu.a("HelloQQWake", "getEnable() cpuBan true.it is x86 cpu");
      return false;
    }
    if (this.e)
    {
      azeu.a("HelloQQWake", "getEnable() needBan :MANUFACTURER:" + Build.MANUFACTURER + ",BRAND:" + Build.BRAND + ",MODEL:" + Build.MODEL + ",FINGERPRINT:" + Build.FINGERPRINT + ",ANDROID_ID:" + DeviceInfoUtil.getAndroidID());
      return false;
    }
    if ((!this.d) && (!azgf.a()))
    {
      azeu.a("HelloQQWake", "getEnable() enable and isPublicVersion: false");
      return false;
    }
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return false;
                  azeu.a("HelloQQWake", "WakeService MSG_START_RECORD");
                } while ((this.jdField_b_of_type_Boolean) && (e()));
                if (this.jdField_a_of_type_Azgv != null) {
                  this.jdField_a_of_type_Azgv.b();
                }
                c();
                azeu.a("HelloQQWake", "WakeService MSG_START_RECORD isMonitor：" + this.jdField_b_of_type_Boolean);
                if (this.jdField_b_of_type_Boolean)
                {
                  paramMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004);
                  this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 10000L);
                }
                this.jdField_a_of_type_AndroidOsHandler.post(new WakeManager.3(this));
                return false;
                azeu.a("HelloQQWake", "WakeService stopRecord isMonitor:" + this.jdField_b_of_type_Boolean);
              } while (!this.jdField_b_of_type_Boolean);
              this.jdField_b_of_type_Boolean = false;
              paramMessage = azeu.a();
            } while ((paramMessage == null) || (paramMessage.a() == null));
            paramMessage.a().b();
          } while (this.jdField_a_of_type_Azgv == null);
          this.jdField_a_of_type_Azgv.b();
          return false;
        } while ((!(paramMessage.obj instanceof byte[])) || (this.jdField_a_of_type_Azhs == null) || (this.jdField_a_of_type_Azgv == null));
        paramMessage = (byte[])paramMessage.obj;
        paramMessage = this.jdField_a_of_type_Azhs.a(paramMessage);
      } while ((paramMessage == null) || (paramMessage.isEmpty()));
      this.jdField_a_of_type_Azgv.a(paramMessage);
      return false;
      azeu.a("HelloQQWake", "releaseQQWake()");
      if (this.jdField_a_of_type_Azgv != null)
      {
        azeu.a("HelloQQWake", "releaseQQWake() in");
        this.jdField_a_of_type_Azgv.a();
        this.jdField_a_of_type_Azgv = null;
      }
      if (this.jdField_a_of_type_Azhs != null) {
        this.jdField_a_of_type_Azhs.a();
      }
      this.c = false;
      return false;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(1004);
      azeu.a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION");
      if (azeu.a())
      {
        azeu.a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION isBackground true");
        b("MSG_IS_IN_BACKGROUND_ROTATION");
      }
    } while (!this.jdField_b_of_type_Boolean);
    paramMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 10000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhh
 * JD-Core Version:    0.7.0.1
 */