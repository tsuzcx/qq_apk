import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bfvt
  extends BroadcastReceiver
{
  bfvt(bfvs parambfvs) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    bfvp.c("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bfvs.a(this.a) != null) {
      bfvs.a(this.a).c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvt
 * JD-Core Version:    0.7.0.1
 */