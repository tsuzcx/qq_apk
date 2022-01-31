import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bffe
  extends BroadcastReceiver
{
  bffe(bffc parambffc) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (bffc.a(this.a) != null))
    {
      bffc.a(this.a).dismiss();
      bffc.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bffe
 * JD-Core Version:    0.7.0.1
 */