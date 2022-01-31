import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bcai
  extends BroadcastReceiver
{
  bcai(bcag parambcag) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action".equals(paramContext)) {
      this.a.b(bcag.a(this.a));
    }
    while (!"com.tencent.mobileqq.troop.homework.xmediaeditor.ui.action_play_video".equals(paramContext)) {
      return;
    }
    this.a.b(bcag.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcai
 * JD-Core Version:    0.7.0.1
 */