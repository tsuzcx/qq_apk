import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bgsm
  implements DialogInterface.OnDismissListener
{
  bgsm(bgsi parambgsi) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b(paramDialogInterface);
    bgse.a();
    if (bgsi.a(this.a) != null) {
      bgsi.a(this.a).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsm
 * JD-Core Version:    0.7.0.1
 */