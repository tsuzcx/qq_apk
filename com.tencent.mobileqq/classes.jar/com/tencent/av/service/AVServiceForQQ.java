package com.tencent.av.service;

import android.app.Notification;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.widget.Toast;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class AVServiceForQQ
  extends AppService
{
  VideoAppInterface a = null;
  Notification b = null;
  public String c;
  private TraeHelper d;
  private int e = 10;
  private int f = 13;
  private AVServiceForQQ.AVServiceForQQStub g = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    if ((this.app instanceof VideoAppInterface)) {
      this.a = ((VideoAppInterface)this.app);
    }
    paramIntent = this.a;
    boolean bool2 = false;
    boolean bool1;
    if (paramIntent != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.g != null) {
      bool2 = true;
    }
    AVLog.printAllUserLog("AVServiceForQQ", String.format("onBind, appInterface[%b], AVServiceForQQ[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    return this.g;
  }
  
  public void onCreate()
  {
    boolean bool2 = false;
    Object localObject;
    try
    {
      super.onCreate();
      if (this.g == null) {
        this.g = new AVServiceForQQ.AVServiceForQQStub(this, null);
      }
    }
    catch (Exception localException1)
    {
      QLog.d("AVServiceForQQ", 1, "AVServiceForQQ onCreate, Fail", localException1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(super.getString(2131917844));
      ((StringBuilder)localObject).append(" 0x0a");
      localObject = ((StringBuilder)localObject).toString();
    }
    try
    {
      Toast.makeText(super.getBaseContext(), (CharSequence)localObject, 0).show();
    }
    catch (Exception localException2)
    {
      try
      {
        for (;;)
        {
          if (Build.VERSION.SDK_INT < 18) {
            startForeground(3886, new Notification());
          }
          label104:
          boolean bool1;
          if (this.a != null) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (this.g != null) {
            bool2 = true;
          }
          AVLog.printAllUserLog("AVServiceForQQ", String.format("onCreate, appInterface[%b], AVServiceForQQ[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
          return;
          localException2 = localException2;
        }
      }
      catch (Exception localException3)
      {
        break label104;
      }
    }
  }
  
  public void onDestroy()
  {
    try
    {
      if ((Build.VERSION.SDK_INT < 18) || (this.b != null))
      {
        stopForeground(true);
        this.b = null;
      }
    }
    catch (Exception localException)
    {
      label25:
      VideoAppInterface localVideoAppInterface;
      boolean bool2;
      boolean bool1;
      break label25;
    }
    super.onDestroy();
    localVideoAppInterface = this.a;
    bool2 = false;
    if (localVideoAppInterface != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (this.g != null) {
      bool2 = true;
    }
    AVLog.printAllUserLog("AVServiceForQQ", String.format("onDestroy, appInterface[%b], AVServiceForQQ[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((this.app instanceof VideoAppInterface)) {
      this.a = ((VideoAppInterface)this.app);
    }
    boolean bool1;
    if (QLog.isDevelopLevel())
    {
      if (this.a != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (this.g != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      QLog.d("AVServiceForQQ", 4, String.format("onCreate, appInterface[%b], AVServiceForQQ[%b], flags[%d], startId[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("setForeground", false)))
    {
      bool1 = paramIntent.getBooleanExtra("foreground", false);
      paramIntent = (Notification)paramIntent.getParcelableExtra("notification");
      try
      {
        if (this.g != null)
        {
          this.g.a(bool1, paramIntent);
          return 2;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("AVServiceForQQ", 1, "", paramIntent);
      }
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ
 * JD-Core Version:    0.7.0.1
 */