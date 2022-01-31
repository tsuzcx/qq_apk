import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bfhf
  implements DialogInterface.OnDismissListener
{
  bfhf(bfhb parambfhb) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.a.b) {
      bfhb.a(this.a, 1);
    }
    this.a.b = false;
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfhf
 * JD-Core Version:    0.7.0.1
 */