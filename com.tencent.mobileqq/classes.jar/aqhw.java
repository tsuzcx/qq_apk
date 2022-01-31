import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;

public class aqhw
  implements DialogInterface.OnCancelListener
{
  public aqhw(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a.a(null);
    LocalFileBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhw
 * JD-Core Version:    0.7.0.1
 */