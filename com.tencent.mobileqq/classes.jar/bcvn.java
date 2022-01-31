import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;

public class bcvn
  implements DialogInterface.OnDismissListener
{
  public bcvn(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareActionSheetV2", 2, "onDismiss() called with: dialog = [" + paramDialogInterface + "] #this = " + Integer.toHexString(System.identityHashCode(this)));
    }
    ShareActionSheetV2.a(this.a);
    if (ShareActionSheetV2.a(this.a) != null) {
      ShareActionSheetV2.a(this.a).onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcvn
 * JD-Core Version:    0.7.0.1
 */