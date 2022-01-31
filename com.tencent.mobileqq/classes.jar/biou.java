import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkBridgeActivity;

public class biou
  implements DialogInterface.OnDismissListener
{
  public biou(QlinkBridgeActivity paramQlinkBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biou
 * JD-Core Version:    0.7.0.1
 */