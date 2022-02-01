import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;

public class armx
  implements DialogInterface.OnDismissListener
{
  public armx(ExtendFriendLimitChatMatchFragment paramExtendFriendLimitChatMatchFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ExtendFriendLimitChatMatchFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armx
 * JD-Core Version:    0.7.0.1
 */