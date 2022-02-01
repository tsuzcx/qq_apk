import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class axkx
  extends BroadcastReceiver
{
  axkx(axku paramaxku) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("BROAD_CAST_CALL_PAGE_SHARE".equals(paramIntent.getAction()))) {
      axku.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkx
 * JD-Core Version:    0.7.0.1
 */