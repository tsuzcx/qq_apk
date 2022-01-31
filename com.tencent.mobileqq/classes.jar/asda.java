import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.fragment.ShieldFriendsListFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class asda
  extends alox
{
  public asda(ShieldFriendsListFragment paramShieldFriendsListFragment) {}
  
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
          QQToast.a(BaseApplication.getContext(), alpo.a(2131714375), 0).b(BaseApplication.getContext().getResources().getDimensionPixelSize(2131298914));
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
      paramString = ((aloz)this.a.getActivity().app.getManager(51)).e(String.valueOf(paramLong));
    } while ((paramString == null) || (paramString.isShield()));
    ShieldFriendsListFragment.a(this.a).a(paramString);
    ShieldFriendsListFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asda
 * JD-Core Version:    0.7.0.1
 */