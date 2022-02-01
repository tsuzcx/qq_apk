import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqdataline.DatalineBridgeActivity;

public class blzn
  implements DialogInterface.OnDismissListener
{
  public blzn(DatalineBridgeActivity paramDatalineBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzn
 * JD-Core Version:    0.7.0.1
 */