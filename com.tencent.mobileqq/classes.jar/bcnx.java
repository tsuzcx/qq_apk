import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bcnx
  extends BroadcastReceiver
{
  bcnx(bcnw parambcnw) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    bcnt.c("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bcnw.a(this.a) != null) {
      bcnw.a(this.a).c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcnx
 * JD-Core Version:    0.7.0.1
 */