import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqdataline.DatalineBridgeActivity;

public class bkof
  implements DialogInterface.OnDismissListener
{
  public bkof(DatalineBridgeActivity paramDatalineBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkof
 * JD-Core Version:    0.7.0.1
 */