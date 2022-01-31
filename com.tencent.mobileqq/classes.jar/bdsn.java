import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bdsn
  extends BroadcastReceiver
{
  bdsn(bdsm parambdsm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    bdsj.c("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bdsm.a(this.a) != null) {
      bdsm.a(this.a).c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdsn
 * JD-Core Version:    0.7.0.1
 */