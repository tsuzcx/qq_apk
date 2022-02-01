import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqindividuality.QQIndividualityBridgeActivity;

public class bmmx
  implements DialogInterface.OnDismissListener
{
  public bmmx(QQIndividualityBridgeActivity paramQQIndividualityBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.a)
    {
      this.a.setResult(1001);
      QQIndividualityBridgeActivity.a(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQIndividuality", 2, "dialog dismiss: " + this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmx
 * JD-Core Version:    0.7.0.1
 */