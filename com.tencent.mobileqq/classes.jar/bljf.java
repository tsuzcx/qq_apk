import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bljf
  implements DialogInterface.OnDismissListener
{
  bljf(blja paramblja) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.a.b) {
      blja.a(this.a, 1);
    }
    this.a.b = false;
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljf
 * JD-Core Version:    0.7.0.1
 */