import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkBridgeActivity;

public class bmiw
  implements DialogInterface.OnClickListener
{
  public bmiw(QlinkBridgeActivity paramQlinkBridgeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmiw
 * JD-Core Version:    0.7.0.1
 */