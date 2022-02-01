import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

class awux
  extends BroadcastReceiver
{
  awux(awuw paramawuw) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) || (awuw.a(this.a) == null)) {
      return;
    }
    awuw.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awux
 * JD-Core Version:    0.7.0.1
 */