import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bije
  extends BroadcastReceiver
{
  bije(bijd parambijd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    bija.c("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bijd.a(this.a) != null) {
      bijd.a(this.a).d(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bije
 * JD-Core Version:    0.7.0.1
 */