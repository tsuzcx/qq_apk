import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Rsp;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class apqx
  implements View.OnClickListener
{
  public apqx(IntimatePlayTogetherMiniGameCardView paramIntimatePlayTogetherMiniGameCardView, MISC.StGetFriendPlayListV2Rsp paramStGetFriendPlayListV2Rsp) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_NS_MINI_APP_MISCMISC$StGetFriendPlayListV2Rsp.total.get() <= 1)
    {
      QLog.d("IntimatePlayTogetherMin", 1, new Object[] { "onClick", "will not jump because total count less than 2" });
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_NS_MINI_APP_MISCMISC$StGetFriendPlayListV2Rsp.moreJumpLink.get()))
    {
      QLog.e("IntimatePlayTogetherMin", 1, new Object[] { "onClick", "Could not launch with empty jump url" });
      return;
    }
    MiniAppLauncher.startMiniApp(this.jdField_a_of_type_ComTencentMobileqqFriendsIntimateIntimatePlayTogetherMiniGameCardView.getContext(), this.jdField_a_of_type_NS_MINI_APP_MISCMISC$StGetFriendPlayListV2Rsp.moreJumpLink.get(), 2064, new apqy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apqx
 * JD-Core Version:    0.7.0.1
 */