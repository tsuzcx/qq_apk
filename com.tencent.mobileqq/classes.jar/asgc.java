import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment.11.1;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

public class asgc
  implements View.OnClickListener
{
  public asgc(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView)
  {
    double d2 = 0.0D;
    int i = paramView.getId();
    if (i == 2131365799)
    {
      paramView = avtz.a();
      paramView = new avtv(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, paramView);
      paramView.a(this.a.jdField_a_of_type_Avty);
      paramView.a(bdaq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 18.0F), bdaq.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 67.0F) + this.a.b.getHeight(), 0.2F);
      new azqx(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app).a("dc00899").b("grp_lbs").c("home").d("pub_download_exp").a();
      auwz.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_pub", 1);
    }
    while (i != 2131373562) {
      return;
    }
    avbh localavbh = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    paramView = localavbh.a(10);
    avsp localavsp = new avsp();
    if (paramView != null) {}
    for (;;)
    {
      try
      {
        i = Integer.valueOf(paramView.red_content.get()).intValue();
        Intent localIntent;
        paramView.printStackTrace();
      }
      catch (Exception paramView)
      {
        try
        {
          localavsp.a(paramView);
          QLog.d("nearby.redpoint", 1, "click red info, isOfficialNotify=" + localavsp.jdField_b_of_type_Boolean + " redContentType = " + localavsp.jdField_b_of_type_Int + " redTopicId = " + localavsp.jdField_b_of_type_JavaLangString);
          paramView = localavbh.a();
          if ((paramView == null) || (paramView.jdField_b_of_type_Int != i)) {
            break label590;
          }
          localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
          if (i != 1) {
            break label527;
          }
          if (localavsp.jdField_b_of_type_Int != 2) {
            break label499;
          }
          paramView = "https://nearby.qq.com/nearby-rcmd-content/people.html?_bid=4227&msg_id=" + avso.a();
          localIntent.putExtra("url", paramView);
          QLog.d("nearby.redpoint", 1, "click OfficialNotify, url" + paramView);
          this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
          avsn.a().a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "home", "news_slip_click");
          localavbh.a(38);
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyHybridFragment.11.1(this), 500L);
          auwz.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_msg", 0);
          azqs.b(null, "dc00899", "grp_lbs", "", "home", "push_red_click", 0, 0, String.valueOf(((Integer)auwq.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
          return;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            continue;
            double d1 = 0.0D;
          }
        }
        paramView = paramView;
        i = 0;
      }
      continue;
      label499:
      paramView = "https://nearby.qq.com/nearby-rcmd-content/detail.html?_bid=4227&_wv=16777218&topic_tag=" + localavsp.jdField_b_of_type_JavaLangString;
      continue;
      label527:
      paramView = ampk.a("nearby_recommend");
      if ((paramView != null) && (paramView.a != null))
      {
        d2 = paramView.a.a;
        d1 = paramView.a.b;
        paramView = "https://nearby.qq.com/h5/helper/index.html?_wv=3&_bid=4234&latitude=$LATITUDE$&longitude=$LONGITUDE$".replace("$LATITUDE$", String.valueOf(d2)).replace("$LONGITUDE$", String.valueOf(d1));
        continue;
        label590:
        paramView = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
        paramView.putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html?_wv=1031&_bid=3027");
        this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(paramView);
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgc
 * JD-Core Version:    0.7.0.1
 */