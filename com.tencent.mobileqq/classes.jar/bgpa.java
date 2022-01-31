import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqdataline.DatalineBridgeActivity;

public class bgpa
  implements DialogInterface.OnDismissListener
{
  public bgpa(DatalineBridgeActivity paramDatalineBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgpa
 * JD-Core Version:    0.7.0.1
 */