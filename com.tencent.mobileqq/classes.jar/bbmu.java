import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class bbmu
  implements DialogInterface.OnDismissListener
{
  bbmu(bbms parambbms) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == this.a.a) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmu
 * JD-Core Version:    0.7.0.1
 */