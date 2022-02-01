import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bjcu
  extends BroadcastReceiver
{
  bjcu(bjct parambjct) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    bjcq.c("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bjct.a(this.a) != null) {
      bjct.a(this.a).c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjcu
 * JD-Core Version:    0.7.0.1
 */