import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

class ardt
  extends BroadcastReceiver
{
  ardt(ards paramards) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) || (ards.a(this.a) == null)) {
      return;
    }
    ards.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ardt
 * JD-Core Version:    0.7.0.1
 */