import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkBridgeActivity;

public class bmix
  implements DialogInterface.OnDismissListener
{
  public bmix(QlinkBridgeActivity paramQlinkBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmix
 * JD-Core Version:    0.7.0.1
 */