import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class bbti
  implements DialogInterface.OnClickListener
{
  public bbti(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    SignTextEditFragment.a(this.a, "");
    paramDialogInterface.dismiss();
    this.a.b.obtainMessage(6, null).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbti
 * JD-Core Version:    0.7.0.1
 */