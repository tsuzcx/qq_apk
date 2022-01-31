import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.dingdong.DingdongPluginBridgeActivity;

public class amsd
  implements DialogInterface.OnDismissListener
{
  public amsd(DingdongPluginBridgeActivity paramDingdongPluginBridgeActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsd
 * JD-Core Version:    0.7.0.1
 */