import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkShareJumpActivity;

public class blyy
  implements DialogInterface.OnClickListener
{
  public blyy(QlinkShareJumpActivity paramQlinkShareJumpActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     blyy
 * JD-Core Version:    0.7.0.1
 */