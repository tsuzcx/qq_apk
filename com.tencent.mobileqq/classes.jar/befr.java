import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class befr
  implements DialogInterface.OnDismissListener
{
  befr(befp parambefp) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (befp.a(this.a) != null) {
      befp.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befr
 * JD-Core Version:    0.7.0.1
 */