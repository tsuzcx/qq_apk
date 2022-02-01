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

public class bjuf
  implements mtg
{
  private static bjuf jdField_a_of_type_Bjuf;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private bjui jdField_a_of_type_Bjui;
  private lwy jdField_a_of_type_Lwy;
  private mtf jdField_a_of_type_Mtf;
  private boolean jdField_a_of_type_Boolean;
  
  public static bjuf a()
  {
    if (jdField_a_of_type_Bjuf == null) {}
    try
    {
      if (jdField_a_of_type_Bjuf == null) {
        jdField_a_of_type_Bjuf = new bjuf();
      }
      return jdField_a_of_type_Bjuf;
    }
    finally {}
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bjug(this);
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
      this.jdField_a_of_type_AndroidContentServiceConnection = new bjuh(this);
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
    if (this.jdField_a_of_type_Mtf != null)
    {
      this.jdField_a_of_type_Mtf.a();
      this.jdField_a_of_type_Mtf = null;
    }
    e();
    g();
    this.jdField_a_of_type_Bjui = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Bjuf = null;
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
  
  public void a(bjui parambjui)
  {
    this.jdField_a_of_type_Bjui = parambjui;
  }
  
  public void a(boolean paramBoolean)
  {
    bjuc.c("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Bjui != null) {
      this.jdField_a_of_type_Bjui.d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lwy != null) {
        bool = this.jdField_a_of_type_Lwy.f();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bjuc.a("CallingStateMonitor", "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallingStateMonitor", 2, "clearTillEnd");
    }
    mtf localmtf = this.jdField_a_of_type_Mtf;
    if (localmtf != null) {
      localmtf.d();
    }
  }
  
  public boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_Mtf != null) {
        return this.jdField_a_of_type_Mtf.a();
      }
      if (this.jdField_a_of_type_Lwy != null)
      {
        boolean bool = this.jdField_a_of_type_Lwy.g();
        return bool;
      }
    }
    catch (Exception localException)
    {
      bjuc.a("CallingStateMonitor", "isPhoneCalling fail.", localException);
    }
    return false;
  }
  
  public void c()
  {
    mtf localmtf = this.jdField_a_of_type_Mtf;
    if ((localmtf != null) && (localmtf.a())) {
      localmtf.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjuf
 * JD-Core Version:    0.7.0.1
 */