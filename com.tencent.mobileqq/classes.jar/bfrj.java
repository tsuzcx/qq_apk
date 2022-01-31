import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import com.tencent.av.service.QQServiceForAV;

public class bfrj
  implements muw
{
  private static bfrj jdField_a_of_type_Bfrj;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private bfrm jdField_a_of_type_Bfrm;
  private lzg jdField_a_of_type_Lzg;
  private muv jdField_a_of_type_Muv;
  private boolean jdField_a_of_type_Boolean;
  
  public static bfrj a()
  {
    if (jdField_a_of_type_Bfrj == null) {}
    try
    {
      if (jdField_a_of_type_Bfrj == null) {
        jdField_a_of_type_Bfrj = new bfrj();
      }
      return jdField_a_of_type_Bfrj;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bfrk(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentServiceConnection == null) {
      this.jdField_a_of_type_AndroidContentServiceConnection = new bfrl(this);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQServiceForAV.class);
    this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
  }
  
  public void a(Context paramContext)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_Muv = new muv(this.jdField_a_of_type_AndroidContentContext, this);
      a();
      b();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(bfrm parambfrm)
  {
    this.jdField_a_of_type_Bfrm = parambfrm;
  }
  
  public void a(boolean paramBoolean)
  {
    bfrg.c("CallingStateMonitor", String.format("onPhoneCallingStateChanged isCalling=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_Bfrm != null) {
      this.jdField_a_of_type_Bfrm.d(paramBoolean);
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lzg != null) {
        bool = this.jdField_a_of_type_Lzg.f();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bfrg.a("CallingStateMonitor", "isVideoChatting fail.", localException);
    }
    return false;
  }
  
  public boolean b()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_Lzg != null) {
        bool = this.jdField_a_of_type_Lzg.g();
      }
      return bool;
    }
    catch (Exception localException)
    {
      bfrg.a("CallingStateMonitor", "isPhoneCalling fail.", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfrj
 * JD-Core Version:    0.7.0.1
 */