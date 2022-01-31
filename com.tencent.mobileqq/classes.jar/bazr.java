import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bazr
  extends BroadcastReceiver
{
  bazr(bazo parambazo) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.innerdns.domainAddressDataUpdateAction".equals(paramIntent.getAction())) {
      bazo.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bazr
 * JD-Core Version:    0.7.0.1
 */