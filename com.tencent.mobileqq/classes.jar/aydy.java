import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;

final class aydy
  implements DialogInterface.OnCancelListener
{
  aydy(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.onDismiss(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydy
 * JD-Core Version:    0.7.0.1
 */