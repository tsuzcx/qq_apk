import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aswj
  extends BroadcastReceiver
{
  aswj(aswg paramaswg) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("BROAD_CAST_CALL_PAGE_SHARE".equals(paramIntent.getAction()))) {
      aswg.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aswj
 * JD-Core Version:    0.7.0.1
 */