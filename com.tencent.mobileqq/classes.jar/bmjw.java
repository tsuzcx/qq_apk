import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkStandardDialogActivity;

public class bmjw
  implements DialogInterface.OnClickListener
{
  public bmjw(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjw
 * JD-Core Version:    0.7.0.1
 */