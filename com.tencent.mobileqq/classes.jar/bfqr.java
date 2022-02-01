import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bfqr
  implements DialogInterface.OnDismissListener
{
  bfqr(bfqm parambfqm) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqr
 * JD-Core Version:    0.7.0.1
 */