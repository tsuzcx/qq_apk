import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class axro
  extends BroadcastReceiver
{
  axro(axrl paramaxrl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("BROAD_CAST_CALL_PAGE_SHARE".equals(paramIntent.getAction()))) {
      axrl.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axro
 * JD-Core Version:    0.7.0.1
 */