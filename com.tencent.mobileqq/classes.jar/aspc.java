import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;

public class aspc
  implements DialogInterface.OnClickListener
{
  public aspc(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ExtendFriendFragment.a(this.a).dismiss();
    ExtendFriendFragment.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspc
 * JD-Core Version:    0.7.0.1
 */