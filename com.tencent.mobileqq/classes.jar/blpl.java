import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class blpl
  implements DialogInterface.OnDismissListener
{
  blpl(blpi paramblpi) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (blpi.a(this.a) != null) {
      blpi.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blpl
 * JD-Core Version:    0.7.0.1
 */