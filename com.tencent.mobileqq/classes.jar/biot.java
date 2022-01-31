import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkBridgeActivity;

public class biot
  implements DialogInterface.OnClickListener
{
  public biot(QlinkBridgeActivity paramQlinkBridgeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biot
 * JD-Core Version:    0.7.0.1
 */