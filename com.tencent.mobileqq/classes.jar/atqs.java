import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

class atqs
  extends BroadcastReceiver
{
  atqs(atqr paramatqr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) || (atqr.a(this.a) == null)) {
      return;
    }
    atqr.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atqs
 * JD-Core Version:    0.7.0.1
 */