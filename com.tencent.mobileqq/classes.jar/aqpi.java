import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

class aqpi
  implements DialogInterface.OnCancelListener
{
  aqpi(aqoz paramaqoz) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.d) {
      VasWebviewUtil.reportCommercialDrainage("", "QLbq", "MoreOp", "0", 1, 0, 0, "", "", "6", "", "", "", "", 0, 0, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqpi
 * JD-Core Version:    0.7.0.1
 */