import android.support.v4.app.FragmentActivity;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSearchFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import java.util.HashMap;

public class asqh
  implements asum
{
  public asqh(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void a(String paramString, int paramInt)
  {
    if (!paramString.equals(this.a.b))
    {
      this.a.b = paramString;
      if (!aslo.a.equals(this.a.b)) {
        break label228;
      }
      ExtendFriendSquareFragment.a(this.a, false);
    }
    label228:
    for (boolean bool1 = ExtendFriendSquareFragment.c(this.a);; bool1 = false)
    {
      boolean bool2 = ExtendFriendSquareFragment.a(this.a, false, paramString);
      long l = Math.abs(System.currentTimeMillis() - ExtendFriendSquareFragment.a(this.a));
      if ((!bool2) || (l > 60000L) || (bool1))
      {
        ExtendFriendSquareFragment.b(this.a, false);
        this.a.jdField_a_of_type_Asqk.a();
        this.a.jdField_a_of_type_Asqk.notifyDataSetChanged();
        this.a.jdField_a_of_type_Asqk.a(false);
        ExtendFriendSquareFragment.c(this.a);
        ExtendFriendSquareFragment.a(this.a).removeMessages(11);
        ExtendFriendSquareFragment.a(this.a).sendEmptyMessageDelayed(11, 500L);
      }
      for (;;)
      {
        paramString = new HashMap();
        paramString.put("small_tab_id", this.a.b);
        UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#voice_tab#small_tab", true, -1L, -1L, paramString, true, true);
        return;
        ExtendFriendSquareFragment.b(this.a, true);
      }
    }
  }
  
  public void b()
  {
    PublicFragmentActivity.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ExtendFriendSearchFragment.class, 3);
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2130772330);
    bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009417", "0X8009417", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asqh
 * JD-Core Version:    0.7.0.1
 */