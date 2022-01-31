import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkBridgeActivity;

public class bgnu
  implements DialogInterface.OnClickListener
{
  public bgnu(QlinkBridgeActivity paramQlinkBridgeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgnu
 * JD-Core Version:    0.7.0.1
 */