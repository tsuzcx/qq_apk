import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.utils.QQCustomDialog;

class bkmv
  extends BroadcastReceiver
{
  bkmv(bkmt parambkmt) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.qlink.finishworkingdlg".equalsIgnoreCase(paramIntent.getAction())) && (bkmt.a(this.a) != null))
    {
      bkmt.a(this.a).dismiss();
      bkmt.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bkmv
 * JD-Core Version:    0.7.0.1
 */