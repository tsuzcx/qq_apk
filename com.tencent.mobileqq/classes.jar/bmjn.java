import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkShareJumpActivity;

public class bmjn
  implements DialogInterface.OnClickListener
{
  public bmjn(QlinkShareJumpActivity paramQlinkShareJumpActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bmjn
 * JD-Core Version:    0.7.0.1
 */