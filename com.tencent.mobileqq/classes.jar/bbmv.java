import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bbmv
  implements DialogInterface.OnDismissListener
{
  bbmv(bbms parambbms) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmv
 * JD-Core Version:    0.7.0.1
 */