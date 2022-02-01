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

public class bjct
  implements msc
{
  private static bjct jdField_a_of_type_Bjct;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private bjcw jdField_a_of_type_Bjcw;
  private lwe jdField_a_of_type_Lwe;
  private msb jdField_a_of_type_Msb;
  private boolean jdField_a_of_type_Boolean;
  
  public static bjct a()
  {
    if (jdField_a_of_type_Bjct == null) {}
    try
    {
      if (jdField_a_of_type_Bjct == null) {
        jdField_a_of_type_Bjct = new bjct();
      }
      return jdField_a_of_type_Bjct;
    }
    finally {}
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bjcu(this);
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
      this.jdField_a_of_type_AndroidContentServiceConnection = new bjcv(this);
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
    if (this.jdField_a_of_type_Msb != null)
    {
      this.jdField_a_of_type_Msb.a();
      this.jdField_a_of_type_Msb = null;
    }
    e();
    g();
    this.jdField_a_of_type_Bjcw = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Bjct = null;
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
  
  public void a(bjcw parambjcw)
  {
    this.jdField_a_of_type_Bjcw = parambjcw;
  }
  
  public void a(boolean paramBoolean)
  {
    bjcq.c("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Bjcw != null) {
      this.jdField_a_of_type_Bjcw.d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lwe != null) {
        bool = this.jdField_a_of_type_Lwe.f();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bjcq.a("CallingStateMonitor", "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "clearTillEnd");
    }
    msb localmsb = this.jdField_a_of_type_Msb;
    if (localmsb != null) {
      localmsb.d();
    }
  }
  
  public boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_Msb != null) {
        return this.jdField_a_of_type_Msb.a();
      }
      if (this.jdField_a_of_type_Lwe != null)
      {
        boolean bool = this.jdField_a_of_type_Lwe.g();
        return bool;
      }
    }
    catch (Exception localException)
    {
      bjcq.a("CallingStateMonitor", "isPhoneCalling fail.", localException);
    }
    return false;
  }
  
  public void c()
  {
    msb localmsb = this.jdField_a_of_type_Msb;
    if ((localmsb != null) && (localmsb.a())) {
      localmsb.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjct
 * JD-Core Version:    0.7.0.1
 */