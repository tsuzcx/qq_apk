import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;

public class arkv
  implements DialogInterface.OnDismissListener
{
  public arkv(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ExtendFriendFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkv
 * JD-Core Version:    0.7.0.1
 */