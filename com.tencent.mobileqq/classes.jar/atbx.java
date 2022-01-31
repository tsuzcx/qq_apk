import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherVCtrlFragment;

public class atbx
  implements DialogInterface.OnDismissListener
{
  public atbx(WatchTogetherVCtrlFragment paramWatchTogetherVCtrlFragment, Activity paramActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbx
 * JD-Core Version:    0.7.0.1
 */