import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class aycg
  implements DialogInterface.OnClickListener
{
  public aycg(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SignTextEditFragment.a(this.a, "");
    paramDialogInterface.dismiss();
    this.a.b.obtainMessage(6, null).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycg
 * JD-Core Version:    0.7.0.1
 */