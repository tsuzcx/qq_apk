import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqpim.QQPimBridgeActivity;

public class blmp
  implements DialogInterface.OnDismissListener
{
  public blmp(QQPimBridgeActivity paramQQPimBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmp
 * JD-Core Version:    0.7.0.1
 */