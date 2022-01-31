import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bgtw
  extends BroadcastReceiver
{
  private bgtw(bgtr parambgtr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("cooperation.qqreader.start_reader_act_completed".equals(paramIntent.getAction())) {
      bgtr.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgtw
 * JD-Core Version:    0.7.0.1
 */