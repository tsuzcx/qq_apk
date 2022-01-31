import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

class arzw
  extends BroadcastReceiver
{
  arzw(arzv paramarzv) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) || (arzv.a(this.a) == null)) {
      return;
    }
    arzv.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arzw
 * JD-Core Version:    0.7.0.1
 */