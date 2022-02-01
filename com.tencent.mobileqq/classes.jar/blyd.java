import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.QQCustomDialog;

class blyd
  extends BroadcastReceiver
{
  blyd(blyb paramblyb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (blyb.a(this.a) != null))
    {
      blyb.a(this.a).dismiss();
      blyb.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     blyd
 * JD-Core Version:    0.7.0.1
 */