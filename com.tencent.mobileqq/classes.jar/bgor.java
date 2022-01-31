import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkStandardDialogActivity;

public class bgor
  implements DialogInterface.OnDismissListener
{
  public bgor(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgor
 * JD-Core Version:    0.7.0.1
 */