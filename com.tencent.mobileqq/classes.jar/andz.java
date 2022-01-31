import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;

public class andz
  implements DialogInterface.OnDismissListener
{
  public andz(EditVideoMusic paramEditVideoMusic) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.a(0);
    VideoEditReport.a("0X80076DD");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     andz
 * JD-Core Version:    0.7.0.1
 */