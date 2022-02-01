import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bfdd
  implements DialogInterface.OnDismissListener
{
  bfdd(bfda parambfda) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdd
 * JD-Core Version:    0.7.0.1
 */