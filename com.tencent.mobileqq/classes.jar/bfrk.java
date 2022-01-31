import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bfrk
  extends BroadcastReceiver
{
  bfrk(bfrj parambfrj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    bfrg.c("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bfrj.a(this.a) != null) {
      bfrj.a(this.a).c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfrk
 * JD-Core Version:    0.7.0.1
 */