import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqpim.QQPimBridgeActivity;

public class bgsh
  implements DialogInterface.OnDismissListener
{
  public bgsh(QQPimBridgeActivity paramQQPimBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsh
 * JD-Core Version:    0.7.0.1
 */