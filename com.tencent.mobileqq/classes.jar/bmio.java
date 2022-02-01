import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bmio
  extends BroadcastReceiver
{
  bmio(bmim parambmim) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (bmim.a(this.a) != null))
    {
      bmim.a(this.a).dismiss();
      bmim.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bmio
 * JD-Core Version:    0.7.0.1
 */