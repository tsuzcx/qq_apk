import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ardh
  extends BroadcastReceiver
{
  ardh(ardf paramardf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.media.AUDIO_BECOMING_NOISY")) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardh
 * JD-Core Version:    0.7.0.1
 */