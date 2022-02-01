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

public class banp
  implements Handler.Callback
{
  private volatile Handler jdField_a_of_type_AndroidOsHandler;
  private volatile HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private baex jdField_a_of_type_Baex;
  private baiy jdField_a_of_type_Baiy;
  private volatile band jdField_a_of_type_Band;
  private bant jdField_a_of_type_Bant = new bant();
  private banv jdField_a_of_type_Banv;
  private volatile baoa jdField_a_of_type_Baoa;
  public volatile boolean a;
  private Handler b;
  public volatile boolean b;
  public boolean c;
  public volatile boolean d;
  public volatile boolean e;
  public volatile boolean f;
  public boolean g;
  private boolean h;
  
  private banp()
  {
    bakl.a("HelloQQWake", "WakeManager()");
  }
  
  public static banp a()
  {
    return banu.a();
  }
  
  public static String a()
  {
    try
    {
      String str = bakl.a().getAccount();
      str = "enable" + str;
      return str;
    }
    catch (Exception localException) {}
    return "enable";
  }
  
  private boolean c()
  {
    if (this.f)
    {
      bakl.a("HelloQQWake", "canStart() isBackstage is true");
      return false;
    }
    if (!b())
    {
      bakl.a("HelloQQWake", "canStart() enable is false");
      return false;
    }
    if (!QQWakeAIEngine.jdField_b_of_type_Boolean)
    {
      bakl.a("HelloQQWake", "canStart() QQWakeAIEngine.sCanInit is  false");
      return false;
    }
    if (!this.h)
    {
      bakl.a("HelloQQWake", "canStart() wakeManagerInit is false");
      return false;
    }
    if (bang.c)
    {
      bakl.a("HelloQQWake", "canStart() QQAssistantGuider.isShow");
      return false;
    }
    return true;
  }
  
  private void d()
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
        if (this.jdField_a_of_type_Baoa == null) {
          this.jdField_a_of_type_Baoa = new baoa();
        }
        if (this.jdField_a_of_type_Bant == null) {
          this.jdField_a_of_type_Bant = new bant();
        }
        if (this.jdField_a_of_type_Banv == null) {
          this.jdField_a_of_type_Banv = banv.a();
        }
        if (((this.jdField_a_of_type_Band == null) || (!this.jdField_a_of_type_Band.b())) && (bakt.a(this.jdField_a_of_type_Bant)))
        {
          if (this.jdField_a_of_type_Band == null) {
            this.jdField_a_of_type_Band = new band();
          }
          this.jdField_a_of_type_Band.a(new bans(this));
          this.jdField_a_of_type_Band.a(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
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
  
  private boolean d()
  {
    if (!bakt.a(this.jdField_a_of_type_Bant))
    {
      bakl.a("HelloQQWake", "canInit() no model");
      return false;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      bakl.a("HelloQQWake", "canInit() canOpenInSp false");
      return false;
    }
    if (!AppUtil.isMainProcess())
    {
      bakl.a("HelloQQWake", "canInit() not in MainProcess");
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
        bakl.a("HelloQQWake", "canInit() no record permission");
        return false;
        i = 0;
      }
      else
      {
        QQAppInterface localQQAppInterface = bakl.a();
        if ((localQQAppInterface == null) || (!localQQAppInterface.isLogin()))
        {
          bakl.a("HelloQQWake", "canInit() not login");
          return false;
        }
        return true;
        i = 1;
      }
    }
  }
  
  private void e()
  {
    baiy localbaiy = a();
    if (localbaiy != null)
    {
      this.jdField_b_of_type_Boolean = localbaiy.a(new banr(this));
      if (!this.jdField_b_of_type_Boolean) {
        bakl.a("HelloQQWake", "Recorder init failure");
      }
    }
  }
  
  private boolean e()
  {
    return a().jdField_a_of_type_Boolean;
  }
  
  public baiy a()
  {
    if (this.jdField_a_of_type_Baiy == null) {
      this.jdField_a_of_type_Baiy = new baiy();
    }
    return this.jdField_a_of_type_Baiy;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      bakl.a("HelloQQWake", "release() MSG_RELEASE");
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1003);
    }
  }
  
  /* Error */
  public void a(BaseActivity paramBaseActivity, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 240	bang:jdField_b_of_type_Boolean	Z
    //   5: ifeq +17 -> 22
    //   8: invokestatic 244	bany:b	()Lbanv;
    //   11: astore_3
    //   12: aload_0
    //   13: aload_1
    //   14: aload_2
    //   15: aload_3
    //   16: invokevirtual 247	banp:a	(Lcom/tencent/mobileqq/app/BaseActivity;Ljava/lang/String;Lbanv;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 146	banv:a	()Lbanv;
    //   25: astore_3
    //   26: goto -14 -> 12
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	banp
    //   0	34	1	paramBaseActivity	BaseActivity
    //   0	34	2	paramString	String
    //   11	15	3	localbanv	banv
    // Exception table:
    //   from	to	target	type
    //   2	12	29	finally
    //   12	19	29	finally
    //   22	26	29	finally
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString, banv parambanv)
  {
    for (;;)
    {
      try
      {
        bakl.a("HelloQQWake", "startRecord():from:" + paramString);
        if (c())
        {
          if ((!this.d) || (!bang.a())) {
            continue;
          }
          if ((AppUtil.isMainProcess()) && (paramBaseActivity != null))
          {
            bakl.a("HelloQQWake", "startRecord() guider: " + paramBaseActivity.getActivityName());
            if (!bang.c) {
              paramBaseActivity.runOnUiThread(new WakeManager.2(this, paramBaseActivity));
            }
            bang.c = true;
            bdla.b(null, "dc00898", "", "", "0X800B162", "0X800B162", 0, 0, "", "", "", "");
          }
        }
        return;
        if (a())
        {
          bakl.a("HelloQQWake", "startRecord() no guider");
          this.jdField_a_of_type_Banv = parambanv;
          paramBaseActivity = bakl.a();
          if (paramBaseActivity != null) {
            paramBaseActivity.a(1);
          }
          if (!"firstInit".equals(paramString)) {
            continue;
          }
          bdla.b(null, "dc00898", "", "", "0X800B160", "0X800B160", 0, 0, "", "", "", "");
          continue;
        }
        bakl.a("HelloQQWake", "startRecord() initRecorder");
      }
      finally {}
      d();
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
    bakl.a("HelloQQWake", "setCanOpenInSp:" + paramBoolean);
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
      bakl.a("HelloQQWake", localException.getMessage());
    }
  }
  
  public boolean a()
  {
    if (!this.c)
    {
      bakl.a("HelloQQWake", "allInit() wakeInit false");
      return false;
    }
    if ((this.jdField_a_of_type_Band == null) || (!this.jdField_a_of_type_Band.b()))
    {
      bakl.a("HelloQQWake", "allInit() HelloQQHelper.isInit() false");
      return false;
    }
    bakl.a("HelloQQWake", "allInit() wakeInit true");
    return true;
  }
  
  public banp b()
  {
    bakl.a("HelloQQWake", "init()");
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0);
    this.jdField_a_of_type_Boolean = ((SharedPreferences)localObject).getBoolean("qq_assistant_wake_open", false);
    this.d = ((SharedPreferences)localObject).getBoolean(a(), false);
    this.e = ((SharedPreferences)localObject).getBoolean("ban", false);
    this.g = SoLoadUtil.a();
    if (b())
    {
      localObject = bakl.a();
      if (localObject != null) {
        ((bakx)localObject).a();
      }
    }
    this.jdField_b_of_type_Boolean = false;
    this.f = false;
    this.jdField_a_of_type_Baex = new banq(this);
    localObject = bakl.a();
    if (localObject != null) {
      ((QQAppInterface)localObject).addObserver(this.jdField_a_of_type_Baex);
    }
    this.h = true;
    return this;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1000);
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      bakl.a("HelloQQWake", "stopRecord() from:" + paramString);
      paramString = bakl.a();
      if (paramString != null) {
        paramString.a(5);
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      bakl.a("HelloQQWake", "getEnable() VERSION : " + Build.VERSION.SDK_INT);
      return false;
    }
    if (this.g)
    {
      bakl.a("HelloQQWake", "getEnable() cpuBan true.it is x86 cpu");
      return false;
    }
    if (this.e)
    {
      bakl.a("HelloQQWake", "getEnable() needBan :MANUFACTURER:" + Build.MANUFACTURER + ",BRAND:" + Build.BRAND + ",MODEL:" + Build.MODEL + ",FINGERPRINT:" + Build.FINGERPRINT + ",ANDROID_ID:" + DeviceInfoUtil.getAndroidID());
      return false;
    }
    if ((!this.d) && (!balw.a()))
    {
      bakl.a("HelloQQWake", "getEnable() enable and isPublicVersion: false");
      return false;
    }
    return true;
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null) {
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    }
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
                return false;
                bakl.a("HelloQQWake", "WakeService MSG_START_RECORD");
              } while ((this.jdField_b_of_type_Boolean) && (e()));
              if (this.jdField_a_of_type_Band != null) {
                this.jdField_a_of_type_Band.b();
              }
              e();
              bakl.a("HelloQQWake", "WakeService MSG_START_RECORD isMonitor：" + this.jdField_b_of_type_Boolean);
              if (this.jdField_b_of_type_Boolean)
              {
                paramMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004);
                this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 10000L);
              }
              this.jdField_a_of_type_AndroidOsHandler.post(new WakeManager.3(this));
              return false;
              bakl.a("HelloQQWake", "WakeService stopRecord isMonitor:" + this.jdField_b_of_type_Boolean);
            } while (!this.jdField_b_of_type_Boolean);
            this.jdField_b_of_type_Boolean = false;
            a().b();
          } while (this.jdField_a_of_type_Band == null);
          this.jdField_a_of_type_Band.b();
          return false;
        } while ((!(paramMessage.obj instanceof byte[])) || (this.jdField_a_of_type_Baoa == null) || (this.jdField_a_of_type_Band == null));
        paramMessage = (byte[])paramMessage.obj;
        paramMessage = this.jdField_a_of_type_Baoa.a(paramMessage);
      } while ((paramMessage == null) || (paramMessage.isEmpty()));
      this.jdField_a_of_type_Band.a(paramMessage);
      return false;
      bakl.a("HelloQQWake", "releaseQQWake()");
      if (this.jdField_a_of_type_Band != null)
      {
        bakl.a("HelloQQWake", "releaseQQWake() in");
        this.jdField_a_of_type_Band.a();
        this.jdField_a_of_type_Band = null;
      }
      if (this.jdField_a_of_type_Baoa != null) {
        this.jdField_a_of_type_Baoa.a();
      }
      this.c = false;
      return false;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(1004);
      bakl.a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION");
      if (bakl.a())
      {
        bakl.a("HelloQQWake", "MSG_IS_IN_BACKGROUND_ROTATION isBackground true");
        b("MSG_IS_IN_BACKGROUND_ROTATION");
      }
    } while (!this.jdField_b_of_type_Boolean);
    paramMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(1004);
    this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 10000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banp
 * JD-Core Version:    0.7.0.1
 */