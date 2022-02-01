import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class bbth
  implements DialogInterface.OnClickListener
{
  public bbth(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new RichStatus(null);
    paramDialogInterface.copyFrom(this.a.a);
    this.a.b.obtainMessage(6, paramDialogInterface).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbth
 * JD-Core Version:    0.7.0.1
 */