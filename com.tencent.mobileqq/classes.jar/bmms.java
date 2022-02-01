import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqfav.widget.QfavJumpActivity;

public class bmms
  implements DialogInterface.OnDismissListener
{
  public bmms(QfavJumpActivity paramQfavJumpActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QfavJumpActivity.a(this.a))
    {
      QfavJumpActivity.a(this.a, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bmms
 * JD-Core Version:    0.7.0.1
 */