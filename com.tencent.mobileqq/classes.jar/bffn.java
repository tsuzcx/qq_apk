import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkBridgeActivity;

public class bffn
  implements DialogInterface.OnDismissListener
{
  public bffn(QlinkBridgeActivity paramQlinkBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffn
 * JD-Core Version:    0.7.0.1
 */