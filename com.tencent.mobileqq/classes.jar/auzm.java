import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;

final class auzm
  implements DialogInterface.OnCancelListener
{
  auzm(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.onDismiss(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auzm
 * JD-Core Version:    0.7.0.1
 */