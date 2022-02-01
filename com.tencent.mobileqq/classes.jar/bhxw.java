import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.vas.FriendCloneSettingFragment;

public class bhxw
  implements DialogInterface.OnCancelListener
{
  public bhxw(FriendCloneSettingFragment paramFriendCloneSettingFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.a != null) {
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxw
 * JD-Core Version:    0.7.0.1
 */