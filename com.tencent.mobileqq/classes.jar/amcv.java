import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class amcv
  implements DialogInterface.OnDismissListener
{
  amcv(amcu paramamcu) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a.a != null) {
      this.a.a.a.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amcv
 * JD-Core Version:    0.7.0.1
 */