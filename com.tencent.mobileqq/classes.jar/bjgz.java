import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

public class bjgz
  implements DialogInterface.OnCancelListener
{
  public bjgz(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ShareActionSheetV2.b(this.a);
    if (ShareActionSheetV2.a(this.a) != null) {
      ShareActionSheetV2.a(this.a).onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgz
 * JD-Core Version:    0.7.0.1
 */