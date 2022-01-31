import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class azoh
  implements DialogInterface.OnDismissListener
{
  azoh(azoc paramazoc) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azoh
 * JD-Core Version:    0.7.0.1
 */