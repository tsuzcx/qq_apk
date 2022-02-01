import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bfvk
  extends BroadcastReceiver
{
  bfvk(bfvi parambfvi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action".equals(paramContext)) {
      this.a.b(bfvi.a(this.a));
    }
    while (!"com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video".equals(paramContext)) {
      return;
    }
    this.a.b(bfvi.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvk
 * JD-Core Version:    0.7.0.1
 */