import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qlink.QlinkShareJumpActivity;

public class bipn
  implements DialogInterface.OnDismissListener
{
  public bipn(QlinkShareJumpActivity paramQlinkShareJumpActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QlinkShareJumpActivity.a(this.a))
    {
      QlinkShareJumpActivity.a(this.a, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bipn
 * JD-Core Version:    0.7.0.1
 */