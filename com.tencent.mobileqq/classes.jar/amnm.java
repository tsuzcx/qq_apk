import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkBridgeActivity;

public class amnm
  implements DialogInterface.OnClickListener
{
  public amnm(QlinkBridgeActivity paramQlinkBridgeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnm
 * JD-Core Version:    0.7.0.1
 */