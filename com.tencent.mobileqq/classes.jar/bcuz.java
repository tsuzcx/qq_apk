import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

public class bcuz
  implements DialogInterface.OnShowListener
{
  public bcuz(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    ShareActionSheetV2.a(this.a, false);
    if (ShareActionSheetV2.a(this.a) != null) {
      ShareActionSheetV2.a(this.a).onShow(paramDialogInterface);
    }
    ShareActionSheetV2.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcuz
 * JD-Core Version:    0.7.0.1
 */