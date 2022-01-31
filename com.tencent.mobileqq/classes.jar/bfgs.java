import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqdataline.DatalineBridgeActivity;

public class bfgs
  implements DialogInterface.OnDismissListener
{
  public bfgs(DatalineBridgeActivity paramDatalineBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfgs
 * JD-Core Version:    0.7.0.1
 */