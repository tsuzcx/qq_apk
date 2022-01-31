import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bgnm
  extends BroadcastReceiver
{
  bgnm(bgnk parambgnk) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (bgnk.a(this.a) != null))
    {
      bgnk.a(this.a).dismiss();
      bgnk.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgnm
 * JD-Core Version:    0.7.0.1
 */