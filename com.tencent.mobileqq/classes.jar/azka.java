import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class azka
  implements DialogInterface.OnDismissListener
{
  azka(azjy paramazjy) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azka
 * JD-Core Version:    0.7.0.1
 */