import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;

public class arkw
  implements DialogInterface.OnClickListener
{
  public arkw(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ExtendFriendFragment.a(this.a).dismiss();
    ExtendFriendFragment.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkw
 * JD-Core Version:    0.7.0.1
 */