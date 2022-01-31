import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class biqn
  implements DialogInterface.OnDismissListener
{
  biqn(biqi parambiqi) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.a.b) {
      biqi.a(this.a, 1);
    }
    this.a.b = false;
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biqn
 * JD-Core Version:    0.7.0.1
 */