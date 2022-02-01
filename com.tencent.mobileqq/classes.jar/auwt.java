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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class auwt
  implements View.OnClickListener
{
  public auwt(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = (String)axqc.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "nearby_mine_page_url", "");
    if (QLog.isColorLevel()) {
      QLog.d("nearby.NearbyHybridFragment", 2, "onClick, server mine url=" + (String)localObject2);
    }
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://nearby.qq.com/nearby-index/mine.html?_bid=3027&_wv=16777218";
    }
    localObject2 = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
    ((Intent)localObject2).putExtra("url", (String)localObject1);
    this.a.getActivity().startActivity((Intent)localObject2);
    axql.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "my_click", 0);
    boolean bool;
    if (this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      bool = false;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a().a(42);
      try
      {
        bdla.b(null, "dc00899", "grp_lbs", "", "entry", "nearby_frag_mine_click_tmp", 0, 0, bool + "", "", "", "");
        label188:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        bool = this.a.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.c();
      }
      catch (Exception localException)
      {
        break label188;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwt
 * JD-Core Version:    0.7.0.1
 */