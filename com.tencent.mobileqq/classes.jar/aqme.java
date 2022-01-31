import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;

public class aqme
  implements DialogInterface.OnDismissListener
{
  public aqme(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.a(null);
    LocalFileBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqme
 * JD-Core Version:    0.7.0.1
 */