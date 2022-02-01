package com.tencent.av.service;

import android.app.Notification;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.widget.Toast;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import lbd;
import lwl;
import mqq.app.AppService;
import muy;

public class AVServiceForQQ
  extends AppService
{
  private int jdField_a_of_type_Int = 10;
  public Notification a;
  public VideoAppInterface a;
  public String a;
  private lwl jdField_a_of_type_Lwl;
  private muy jdField_a_of_type_Muy;
  private boolean jdField_a_of_type_Boolean;
  private int b = 13;
  
  public AVServiceForQQ()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidAppNotification = null;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    boolean bool2 = false;
    if ((this.app instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.jdField_a_of_type_Lwl != null) {
        bool2 = true;
      }
      lbd.g("AVServiceForQQ", String.format("onBind, appInterface[%b], AVServiceForQQ[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return this.jdField_a_of_type_Lwl;
    }
  }
  
  public void onCreate()
  {
    boolean bool2 = false;
    try
    {
      super.onCreate();
      if (this.jdField_a_of_type_Lwl == null) {
        this.jdField_a_of_type_Lwl = new lwl(this, null);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 18) {
          startForeground(3886, new Notification());
        }
        label48:
        if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          for (;;)
          {
            if (this.jdField_a_of_type_Lwl != null) {
              bool2 = true;
            }
            lbd.g("AVServiceForQQ", String.format("onCreate, appInterface[%b], AVServiceForQQ[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
            return;
            localException1 = localException1;
            QLog.d("AVServiceForQQ", 1, "AVServiceForQQ onCreate, Fail", localException1);
            String str = super.getString(2131719926) + " 0x0a";
            try
            {
              Toast.makeText(super.getBaseContext(), str, 0).show();
            }
            catch (Exception localException2) {}
          }
          break;
        }
      }
      catch (Exception localException3)
      {
        break label48;
      }
    }
  }
  
  public void onDestroy()
  {
    boolean bool2 = false;
    try
    {
      if ((Build.VERSION.SDK_INT < 18) || (this.jdField_a_of_type_AndroidAppNotification != null))
      {
        stopForeground(true);
        this.jdField_a_of_type_AndroidAppNotification = null;
      }
    }
    catch (Exception localException)
    {
      label27:
      boolean bool1;
      break label27;
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {}
    for (bool1 = true;; bool1 = false)
    {
      if (this.jdField_a_of_type_Lwl != null) {
        bool2 = true;
      }
      lbd.g("AVServiceForQQ", String.format("onDestroy, appInterface[%b], AVServiceForQQ[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((this.app instanceof VideoAppInterface)) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    }
    boolean bool1;
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
        break label144;
      }
      bool1 = true;
      if (this.jdField_a_of_type_Lwl == null) {
        break label150;
      }
    }
    label144:
    label150:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("AVServiceForQQ", 4, String.format("onCreate, appInterface[%b], AVServiceForQQ[%b], flags[%d], startId[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("setForeground", false)))
      {
        bool1 = paramIntent.getBooleanExtra("foreground", false);
        paramIntent = (Notification)paramIntent.getParcelableExtra("notification");
      }
      try
      {
        if (this.jdField_a_of_type_Lwl != null) {
          this.jdField_a_of_type_Lwl.a(bool1, paramIntent);
        }
        return 2;
      }
      catch (Throwable paramIntent)
      {
        QLog.e("AVServiceForQQ", 1, "", paramIntent);
      }
      bool1 = false;
      break;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ
 * JD-Core Version:    0.7.0.1
 */