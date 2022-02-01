import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;

public class asov
  implements DialogInterface.OnClickListener
{
  public asov(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = "";
    paramDialogInterface = str;
    if (ExtendFriendEditFragment.a(this.a) != null)
    {
      paramDialogInterface = str;
      if (ExtendFriendEditFragment.a(this.a).app != null) {
        paramDialogInterface = ((aslo)ExtendFriendEditFragment.a(this.a).app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f();
      }
    }
    assp.a(this.a.getActivity(), paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asov
 * JD-Core Version:    0.7.0.1
 */