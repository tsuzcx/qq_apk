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

public class asbt
  implements View.OnClickListener
{
  public asbt(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView)
  {
    double d2 = 0.0D;
    int i = paramView.getId();
    if (i == 2131365797)
    {
      paramView = avpq.a();
      paramView = new avpm(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, paramView);
      paramView.a(this.a.jdField_a_of_type_Avpp);
      paramView.a(bcwh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 18.0F), bcwh.a(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 67.0F) + this.a.b.getHeight(), 0.2F);
      new azmo(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app).a("dc00899").b("grp_lbs").c("home").d("pub_download_exp").a();
      ausq.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_pub", 1);
    }
    while (i != 2131373510) {
      return;
    }
    auwy localauwy = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    paramView = localauwy.a(10);
    avog localavog = new avog();
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
          localavog.a(paramView);
          QLog.d("nearby.redpoint", 1, "click red info, isOfficialNotify=" + localavog.jdField_b_of_type_Boolean + " redContentType = " + localavog.jdField_b_of_type_Int + " redTopicId = " + localavog.jdField_b_of_type_JavaLangString);
          paramView = localauwy.a();
          if ((paramView == null) || (paramView.jdField_b_of_type_Int != i)) {
            break label590;
          }
          localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
          if (i != 1) {
            break label527;
          }
          if (localavog.jdField_b_of_type_Int != 2) {
            break label499;
          }
          paramView = "https://nearby.qq.com/nearby-rcmd-content/people.html?_bid=4227&msg_id=" + avof.a();
          localIntent.putExtra("url", paramView);
          QLog.d("nearby.redpoint", 1, "click OfficialNotify, url" + paramView);
          this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
          avoe.a().a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "home", "news_slip_click");
          localauwy.a(38);
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyHybridFragment.11.1(this), 500L);
          ausq.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_msg", 0);
          azmj.b(null, "dc00899", "grp_lbs", "", "home", "push_red_click", 0, 0, String.valueOf(((Integer)aush.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
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
      paramView = "https://nearby.qq.com/nearby-rcmd-content/detail.html?_bid=4227&_wv=16777218&topic_tag=" + localavog.jdField_b_of_type_JavaLangString;
      continue;
      label527:
      paramView = amkv.a("nearby_recommend");
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
 * Qualified Name:     asbt
 * JD-Core Version:    0.7.0.1
 */