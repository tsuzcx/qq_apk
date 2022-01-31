import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bgmv
  extends BroadcastReceiver
{
  bgmv(bgmt parambgmt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (bgmt.a(this.a) != null))
    {
      bgmt.a(this.a).dismiss();
      bgmt.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgmv
 * JD-Core Version:    0.7.0.1
 */