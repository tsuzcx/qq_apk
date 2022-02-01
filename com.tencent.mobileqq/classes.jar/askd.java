import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;

public class askd
  implements asnu
{
  public askd(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void a(String paramString, int paramInt)
  {
    if (!paramString.equals(this.a.b))
    {
      this.a.b = paramString;
      if (!asfu.a.equals(this.a.b)) {
        break label186;
      }
      ExtendFriendSquareFragment.a(this.a, false);
    }
    label186:
    for (boolean bool1 = ExtendFriendSquareFragment.c(this.a);; bool1 = false)
    {
      boolean bool2 = ExtendFriendSquareFragment.a(this.a, false, paramString);
      long l = Math.abs(System.currentTimeMillis() - ExtendFriendSquareFragment.a(this.a));
      if ((!bool2) || (l > 60000L) || (bool1))
      {
        ExtendFriendSquareFragment.b(this.a, false);
        this.a.jdField_a_of_type_Askg.a();
        this.a.jdField_a_of_type_Askg.notifyDataSetChanged();
        this.a.jdField_a_of_type_Askg.a(false);
        ExtendFriendSquareFragment.c(this.a);
        ExtendFriendSquareFragment.a(this.a).removeMessages(11);
        ExtendFriendSquareFragment.a(this.a).sendEmptyMessageDelayed(11, 500L);
        return;
      }
      ExtendFriendSquareFragment.b(this.a, true);
      return;
    }
  }
  
  public void b()
  {
    PublicFragmentActivity.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ExtendFriendSearchFragment.class, 3);
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2130772333);
    bcst.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009417", "0X8009417", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askd
 * JD-Core Version:    0.7.0.1
 */