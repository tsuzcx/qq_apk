import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;

public class aooy
  implements DialogInterface.OnCancelListener
{
  public aooy(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a.a(null);
    LocalFileBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aooy
 * JD-Core Version:    0.7.0.1
 */