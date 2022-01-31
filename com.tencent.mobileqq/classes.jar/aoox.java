import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;

public class aoox
  implements DialogInterface.OnDismissListener
{
  public aoox(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.a(null);
    LocalFileBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoox
 * JD-Core Version:    0.7.0.1
 */