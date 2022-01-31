import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bfni
  extends BroadcastReceiver
{
  private bfni(bfng parambfng) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("RECEIVER_JUMP_SSR_ACTIVITY_COMPLETED".equals(paramIntent.getAction())) {
      bfng.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfni
 * JD-Core Version:    0.7.0.1
 */