import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkStandardDialogActivity;

public class amog
  implements DialogInterface.OnClickListener
{
  public amog(QlinkStandardDialogActivity paramQlinkStandardDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amog
 * JD-Core Version:    0.7.0.1
 */