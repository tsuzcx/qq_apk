import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;

public class asyk
  implements DialogInterface.OnKeyListener
{
  public asyk(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramDialogInterface.dismiss();
      ExtendFriendFragment.a(this.a).finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyk
 * JD-Core Version:    0.7.0.1
 */