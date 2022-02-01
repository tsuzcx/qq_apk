import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;

public class arkx
  implements DialogInterface.OnClickListener
{
  public arkx(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ExtendFriendFragment.a(this.a).dismiss();
    ExtendFriendFragment.a(this.a, null);
    ExtendFriendFragment.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arkx
 * JD-Core Version:    0.7.0.1
 */