import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bgwt
  implements DialogInterface.OnDismissListener
{
  bgwt(bgwp parambgwp) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b(paramDialogInterface);
    bgwl.a();
    if (bgwp.a(this.a) != null) {
      bgwp.a(this.a).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgwt
 * JD-Core Version:    0.7.0.1
 */