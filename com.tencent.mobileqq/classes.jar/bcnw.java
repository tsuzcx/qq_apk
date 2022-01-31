import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import com.tencent.av.service.QQServiceForAV;

public class bcnw
  implements mhg
{
  private static bcnw jdField_a_of_type_Bcnw;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private bcnz jdField_a_of_type_Bcnz;
  private lme jdField_a_of_type_Lme;
  private mhf jdField_a_of_type_Mhf;
  private boolean jdField_a_of_type_Boolean;
  
  public static bcnw a()
  {
    if (jdField_a_of_type_Bcnw == null) {}
    try
    {
      if (jdField_a_of_type_Bcnw == null) {
        jdField_a_of_type_Bcnw = new bcnw();
      }
      return jdField_a_of_type_Bcnw;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bcnx(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentServiceConnection == null) {
      this.jdField_a_of_type_AndroidContentServiceConnection = new bcny(this);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQServiceForAV.class);
    this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
  }
  
  public void a(Context paramContext)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_Mhf = new mhf(this.jdField_a_of_type_AndroidContentContext, this);
      a();
      b();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(bcnz parambcnz)
  {
    this.jdField_a_of_type_Bcnz = parambcnz;
  }
  
  public void a(boolean paramBoolean)
  {
    bcnt.c("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Bcnz != null) {
      this.jdField_a_of_type_Bcnz.d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lme != null) {
        bool = this.jdField_a_of_type_Lme.f();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bcnt.a("CallingStateMonitor", "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public boolean b()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lme != null) {
        bool = this.jdField_a_of_type_Lme.g();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bcnt.a("CallingStateMonitor", "isPhoneCalling fail.", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcnw
 * JD-Core Version:    0.7.0.1
 */