import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bgpo
  implements DialogInterface.OnDismissListener
{
  bgpo(bgpj parambgpj) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.a.b) {
      bgpj.a(this.a, 1);
    }
    this.a.b = false;
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgpo
 * JD-Core Version:    0.7.0.1
 */