import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSyncStoryGuide;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;

public class anfa
  implements DialogInterface.OnDismissListener
{
  public anfa(EditVideoSyncStoryGuide paramEditVideoSyncStoryGuide) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "showSyncStoryGuide ->onDismiss-------");
    }
    SharedPreUtils.b(this.a.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anfa
 * JD-Core Version:    0.7.0.1
 */