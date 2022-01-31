import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bgox
  implements DialogInterface.OnDismissListener
{
  bgox(bgos parambgos) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.a.b) {
      bgos.a(this.a, 1);
    }
    this.a.b = false;
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgox
 * JD-Core Version:    0.7.0.1
 */