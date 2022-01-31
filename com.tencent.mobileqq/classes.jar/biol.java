import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class biol
  extends BroadcastReceiver
{
  biol(bioj parambioj) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (bioj.a(this.a) != null))
    {
      bioj.a(this.a).dismiss();
      bioj.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     biol
 * JD-Core Version:    0.7.0.1
 */