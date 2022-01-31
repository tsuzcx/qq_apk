import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;

public class apzo
  implements DialogInterface.OnClickListener
{
  public apzo(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = "";
    paramDialogInterface = str;
    if (ExtendFriendEditFragment.a(this.a) != null)
    {
      paramDialogInterface = str;
      if (ExtendFriendEditFragment.a(this.a).app != null) {
        paramDialogInterface = ((apwx)ExtendFriendEditFragment.a(this.a).app.getManager(264)).f();
      }
    }
    aqcq.b(this.a.getActivity(), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzo
 * JD-Core Version:    0.7.0.1
 */