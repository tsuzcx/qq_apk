import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class biuu
  implements DialogInterface.OnDismissListener
{
  biuu(biup parambiup) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.a.b) {
      biup.a(this.a, 1);
    }
    this.a.b = false;
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biuu
 * JD-Core Version:    0.7.0.1
 */