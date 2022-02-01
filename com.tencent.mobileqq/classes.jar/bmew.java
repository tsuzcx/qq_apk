import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bmew
  extends BroadcastReceiver
{
  private bmew(bmer parambmer) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("cooperation.qqreader.start_reader_act_completed".equals(paramIntent.getAction())) {
      bmer.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmew
 * JD-Core Version:    0.7.0.1
 */