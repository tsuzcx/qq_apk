import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;

class awog
  extends BroadcastReceiver
{
  awog(awof paramawof) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) || (awof.a(this.a) == null)) {
      return;
    }
    awof.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awog
 * JD-Core Version:    0.7.0.1
 */