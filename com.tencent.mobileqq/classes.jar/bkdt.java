import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bkdt
  extends BroadcastReceiver
{
  bkdt(bkds parambkds) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    bkdp.c("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bkds.a(this.a) != null) {
      bkds.a(this.a).c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdt
 * JD-Core Version:    0.7.0.1
 */