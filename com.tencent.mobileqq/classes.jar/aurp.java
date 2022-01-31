import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class aurp
  extends BroadcastReceiver
{
  aurp(aurm paramaurm) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("BROAD_CAST_CALL_PAGE_SHARE".equals(paramIntent.getAction()))) {
      aurm.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aurp
 * JD-Core Version:    0.7.0.1
 */