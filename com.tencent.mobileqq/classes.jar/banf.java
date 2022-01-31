import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.vas.FriendCloneSettingFragment;

public class banf
  implements DialogInterface.OnCancelListener
{
  public banf(FriendCloneSettingFragment paramFriendCloneSettingFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     banf
 * JD-Core Version:    0.7.0.1
 */