import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqfav.widget.QfavJumpActivity;

public class ampu
  implements DialogInterface.OnDismissListener
{
  public ampu(QfavJumpActivity paramQfavJumpActivity) {}
  
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
 * Qualified Name:     ampu
 * JD-Core Version:    0.7.0.1
 */