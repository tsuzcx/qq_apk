import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import com.tencent.av.service.QQServiceForAV;

public class bdsm
  implements msc
{
  private static bdsm jdField_a_of_type_Bdsm;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private bdsp jdField_a_of_type_Bdsp;
  private lwr jdField_a_of_type_Lwr;
  private msb jdField_a_of_type_Msb;
  private boolean jdField_a_of_type_Boolean;
  
  public static bdsm a()
  {
    if (jdField_a_of_type_Bdsm == null) {}
    try
    {
      if (jdField_a_of_type_Bdsm == null) {
        jdField_a_of_type_Bdsm = new bdsm();
      }
      return jdField_a_of_type_Bdsm;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bdsn(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentServiceConnection == null) {
      this.jdField_a_of_type_AndroidContentServiceConnection = new bdso(this);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQServiceForAV.class);
    this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
  }
  
  public void a(Context paramContext)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_Msb = new msb(this.jdField_a_of_type_AndroidContentContext, this);
      a();
      b();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(bdsp parambdsp)
  {
    this.jdField_a_of_type_Bdsp = parambdsp;
  }
  
  public void a(boolean paramBoolean)
  {
    bdsj.c("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Bdsp != null) {
      this.jdField_a_of_type_Bdsp.d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lwr != null) {
        bool = this.jdField_a_of_type_Lwr.f();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bdsj.a("CallingStateMonitor", "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public boolean b()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lwr != null) {
        bool = this.jdField_a_of_type_Lwr.g();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bdsj.a("CallingStateMonitor", "isPhoneCalling fail.", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsm
 * JD-Core Version:    0.7.0.1
 */