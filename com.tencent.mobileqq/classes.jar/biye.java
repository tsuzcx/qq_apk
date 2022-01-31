import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qqpim.QQPimBridgeActivity;

public class biye
  implements DialogInterface.OnDismissListener
{
  public biye(QQPimBridgeActivity paramQQPimBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biye
 * JD-Core Version:    0.7.0.1
 */