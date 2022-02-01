import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.qav.monitor.CallingStateMonitor.1;
import com.tencent.qphone.base.util.QLog;

public class bkds
  implements mta
{
  private static bkds jdField_a_of_type_Bkds;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private bkdv jdField_a_of_type_Bkdv;
  private lxa jdField_a_of_type_Lxa;
  private msz jdField_a_of_type_Msz;
  private boolean jdField_a_of_type_Boolean;
  
  public static bkds a()
  {
    if (jdField_a_of_type_Bkds == null) {}
    try
    {
      if (jdField_a_of_type_Bkds == null) {
        jdField_a_of_type_Bkds = new bkds();
      }
      return jdField_a_of_type_Bkds;
    }
    finally {}
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bkdt(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("CallingStateMonitor", 2, "registerVideoChatReceiver", localThrowable);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.i("CallingStateMonitor", 2, "unregisterVideoChatReceiver", localThrowable);
      }
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "bindQQServiceForAV");
    }
    if (this.jdField_a_of_type_AndroidContentServiceConnection == null) {
      this.jdField_a_of_type_AndroidContentServiceConnection = new bkdu(this);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQServiceForAV.class);
    this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidContentServiceConnection != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
      this.jdField_a_of_type_AndroidContentServiceConnection = null;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "destroy, init[" + this.jdField_a_of_type_Boolean + "]");
    }
    if (this.jdField_a_of_type_Msz != null)
    {
      this.jdField_a_of_type_Msz.a();
      this.jdField_a_of_type_Msz = null;
    }
    e();
    g();
    this.jdField_a_of_type_Bkdv = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Bkds = null;
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "setup, init[" + this.jdField_a_of_type_Boolean + "], bBindQQServiceForAV[" + paramBoolean + "]");
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      new Handler(Looper.getMainLooper()).post(new CallingStateMonitor.1(this));
      d();
      if (paramBoolean) {
        f();
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(bkdv parambkdv)
  {
    this.jdField_a_of_type_Bkdv = parambkdv;
  }
  
  public void a(boolean paramBoolean)
  {
    bkdp.c("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Bkdv != null) {
      this.jdField_a_of_type_Bkdv.d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lxa != null) {
        bool = this.jdField_a_of_type_Lxa.f();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bkdp.a("CallingStateMonitor", "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "clearTillEnd");
    }
    msz localmsz = this.jdField_a_of_type_Msz;
    if (localmsz != null) {
      localmsz.d();
    }
  }
  
  public boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_Msz != null) {
        return this.jdField_a_of_type_Msz.a();
      }
      if (this.jdField_a_of_type_Lxa != null)
      {
        boolean bool = this.jdField_a_of_type_Lxa.g();
        return bool;
      }
    }
    catch (Exception localException)
    {
      bkdp.a("CallingStateMonitor", "isPhoneCalling fail.", localException);
    }
    return false;
  }
  
  public void c()
  {
    msz localmsz = this.jdField_a_of_type_Msz;
    if ((localmsz != null) && (localmsz.a())) {
      localmsz.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkds
 * JD-Core Version:    0.7.0.1
 */