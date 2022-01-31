import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class ayxh
  extends BroadcastReceiver
{
  ayxh(ayxe paramayxe) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.innerdns.domainAddressDataUpdateAction".equals(paramIntent.getAction())) {
      ayxe.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxh
 * JD-Core Version:    0.7.0.1
 */