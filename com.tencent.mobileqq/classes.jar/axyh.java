import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.richstatus.SignatureEditFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class axyh
  implements DialogInterface.OnClickListener
{
  public axyh(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    VasWebviewUtil.reportCommercialDrainage("signature_update", "click_choose", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyh
 * JD-Core Version:    0.7.0.1
 */