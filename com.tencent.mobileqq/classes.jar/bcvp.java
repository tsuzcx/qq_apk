import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

public class bcvp
  implements DialogInterface.OnCancelListener
{
  public bcvp(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ShareActionSheetV2.a(this.a);
    if (ShareActionSheetV2.a(this.a) != null) {
      ShareActionSheetV2.a(this.a).onCancel(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcvp
 * JD-Core Version:    0.7.0.1
 */