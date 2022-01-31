import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;

public class asgg
  implements View.OnClickListener
{
  public asgg(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (String)auwq.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "nearby_mine_page_url", "");
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "onClick, server mine url=" + (String)localObject);
    }
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = "https://nearby.qq.com/nearby-index/mine.html?_bid=3027&_wv=16777218";
    }
    localObject = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramView);
    this.a.getActivity().startActivity((Intent)localObject);
    auwz.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "my_click", 0);
    if (this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {}
    for (boolean bool = false;; bool = this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b())
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(42);
      try
      {
        azqs.b(null, "dc00899", "grp_lbs", "", "entry", "nearby_frag_mine_click_tmp", 0, 0, bool + "", "", "", "");
        return;
      }
      catch (Exception paramView) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgg
 * JD-Core Version:    0.7.0.1
 */