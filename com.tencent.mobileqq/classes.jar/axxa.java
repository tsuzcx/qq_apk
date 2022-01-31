import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class axxa
  extends BroadcastReceiver
{
  axxa(axwx paramaxwx) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.innerdns.domainAddressDataUpdateAction".equals(paramIntent.getAction())) {
      axwx.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axxa
 * JD-Core Version:    0.7.0.1
 */