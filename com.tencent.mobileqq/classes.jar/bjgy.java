import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;

public class bjgy
  implements DialogInterface.OnShowListener
{
  public bjgy(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    ShareActionSheetV2.a(this.a, false);
    if (ShareActionSheetV2.a(this.a) != null) {
      ShareActionSheetV2.a(this.a).onShow(paramDialogInterface);
    }
    ShareActionSheetV2.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgy
 * JD-Core Version:    0.7.0.1
 */