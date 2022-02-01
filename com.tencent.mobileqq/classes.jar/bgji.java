import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment;

public class bgji
  implements bhle
{
  public bgji(QQVipFeedWedFragment paramQQVipFeedWedFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      paramView = new Intent(this.a.getActivity(), AccountDetailActivity.class);
      paramView.putExtra("uin", AppConstants.QQ_VIP_UIN);
      paramView.putExtra("fromQGamePub", true);
      this.a.startActivity(paramView);
    }
    while (paramInt != 1) {
      return;
    }
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgji
 * JD-Core Version:    0.7.0.1
 */