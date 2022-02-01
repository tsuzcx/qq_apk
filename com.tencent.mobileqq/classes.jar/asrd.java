import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;

public class asrd
  implements DialogInterface.OnDismissListener
{
  public asrd(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ExtendFriendLimitChatMatchFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrd
 * JD-Core Version:    0.7.0.1
 */