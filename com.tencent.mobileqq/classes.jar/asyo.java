import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;

public class asyo
  implements DialogInterface.OnDismissListener
{
  public asyo(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ExtendFriendFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyo
 * JD-Core Version:    0.7.0.1
 */