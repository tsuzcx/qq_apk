import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import com.tencent.av.service.QQServiceForAV;

public class bdrx
  implements msf
{
  private static bdrx jdField_a_of_type_Bdrx;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private bdsa jdField_a_of_type_Bdsa;
  private lww jdField_a_of_type_Lww;
  private mse jdField_a_of_type_Mse;
  private boolean jdField_a_of_type_Boolean;
  
  public static bdrx a()
  {
    if (jdField_a_of_type_Bdrx == null) {}
    try
    {
      if (jdField_a_of_type_Bdrx == null) {
        jdField_a_of_type_Bdrx = new bdrx();
      }
      return jdField_a_of_type_Bdrx;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bdry(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentServiceConnection == null) {
      this.jdField_a_of_type_AndroidContentServiceConnection = new bdrz(this);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQServiceForAV.class);
    this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
  }
  
  public void a(Context paramContext)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_Mse = new mse(this.jdField_a_of_type_AndroidContentContext, this);
      a();
      b();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(bdsa parambdsa)
  {
    this.jdField_a_of_type_Bdsa = parambdsa;
  }
  
  public void a(boolean paramBoolean)
  {
    bdru.c("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Bdsa != null) {
      this.jdField_a_of_type_Bdsa.d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lww != null) {
        bool = this.jdField_a_of_type_Lww.f();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bdru.a("CallingStateMonitor", "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public boolean b()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lww != null) {
        bool = this.jdField_a_of_type_Lww.g();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bdru.a("CallingStateMonitor", "isPhoneCalling fail.", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdrx
 * JD-Core Version:    0.7.0.1
 */