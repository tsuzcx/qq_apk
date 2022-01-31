import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class beue
  implements DialogInterface.OnDismissListener
{
  beue(beub parambeub) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (beub.a(this.a) != null) {
      beub.a(this.a).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beue
 * JD-Core Version:    0.7.0.1
 */