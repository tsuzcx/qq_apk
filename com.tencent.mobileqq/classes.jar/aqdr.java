import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;

public class aqdr
  implements DialogInterface.OnClickListener
{
  public aqdr(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ExtendFriendEditFragment.a(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdr
 * JD-Core Version:    0.7.0.1
 */