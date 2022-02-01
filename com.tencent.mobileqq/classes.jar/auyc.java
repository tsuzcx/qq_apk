import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class auyc
  extends anvi
{
  public auyc(ShieldFriendsListFragment paramShieldFriendsListFragment) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    super.onUpdateFriendShieldFlag(paramLong, paramBoolean1, paramBoolean2, paramBoolean3, paramString);
    if (!paramBoolean2)
    {
      paramString = this.a;
      if (!paramBoolean1)
      {
        paramBoolean1 = true;
        if (ShieldFriendsListFragment.a(paramString, paramLong, paramBoolean1)) {
          QQToast.a(BaseApplication.getContext(), anvx.a(2131713445), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299080));
        }
      }
    }
    do
    {
      return;
      paramBoolean1 = false;
      break;
      if (ShieldFriendsListFragment.a(this.a).a(String.valueOf(paramLong)))
      {
        ShieldFriendsListFragment.a(this.a, paramLong, paramBoolean1);
        return;
      }
      paramString = ((anvk)this.a.getActivity().app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(String.valueOf(paramLong));
    } while ((paramString == null) || (paramString.isShield()));
    ShieldFriendsListFragment.a(this.a).a(paramString);
    ShieldFriendsListFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyc
 * JD-Core Version:    0.7.0.1
 */