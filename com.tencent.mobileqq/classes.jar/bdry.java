import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bdry
  extends BroadcastReceiver
{
  bdry(bdrx parambdrx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = "tencent.av.v2q.StartVideoChat".equals(paramIntent.getAction());
    bdru.c("CallingStateMonitor", String.format("onVideoChattingStateChanged isChatting=%s", new Object[] { Boolean.valueOf(bool) }));
    if (bdrx.a(this.a) != null) {
      bdrx.a(this.a).c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdry
 * JD-Core Version:    0.7.0.1
 */