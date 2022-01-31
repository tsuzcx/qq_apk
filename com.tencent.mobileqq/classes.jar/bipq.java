import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkStandardDialogActivity;

public class bipq
  implements DialogInterface.OnDismissListener
{
  public bipq(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bipq
 * JD-Core Version:    0.7.0.1
 */