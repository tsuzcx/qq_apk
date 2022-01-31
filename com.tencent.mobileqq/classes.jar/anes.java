import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import cooperation.thirdpay.NFCPayPluginProxyActivity;

public class anes
  implements DialogInterface.OnClickListener
{
  public anes(NFCPayPluginProxyActivity paramNFCPayPluginProxyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.startActivity(new Intent("android.settings.NFC_SETTINGS"));
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anes
 * JD-Core Version:    0.7.0.1
 */