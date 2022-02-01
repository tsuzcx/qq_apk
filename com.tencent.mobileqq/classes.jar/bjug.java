import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bjug
  extends BroadcastReceiver
{
  bjug(bjuf parambjuf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    bjuc.c("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bjuf.a(this.a) != null) {
      bjuf.a(this.a).c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjug
 * JD-Core Version:    0.7.0.1
 */