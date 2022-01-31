import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bivm
  extends BroadcastReceiver
{
  private bivm(bivh parambivh) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("cooperation.qqreader.start_reader_act_completed".equals(paramIntent.getAction())) {
      bivh.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bivm
 * JD-Core Version:    0.7.0.1
 */