import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qlink.QlinkShareJumpActivity;

public class bmjl
  implements DialogInterface.OnClickListener
{
  public bmjl(QlinkShareJumpActivity paramQlinkShareJumpActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QlinkShareJumpActivity.a(this.a, false);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bmjl
 * JD-Core Version:    0.7.0.1
 */