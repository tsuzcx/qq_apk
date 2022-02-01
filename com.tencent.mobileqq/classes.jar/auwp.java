import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.fragment.NearbyHybridFragment.11.1;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class auwp
  implements View.OnClickListener
{
  public auwp(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView)
  {
    double d2 = 0.0D;
    int i = paramView.getId();
    if (i == 2131366222)
    {
      localObject1 = aynv.a();
      localObject1 = new aynr(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (ArrayList)localObject1);
      ((aynr)localObject1).a(this.a.jdField_a_of_type_Aynu);
      ((aynr)localObject1).a(DisplayUtil.dip2px(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 18.0F), DisplayUtil.dip2px(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, 67.0F) + this.a.b.getHeight(), 0.2F);
      new bdlf(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app).a("dc00899").b("grp_lbs").c("home").d("pub_download_exp").a();
      axql.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_pub", 1);
    }
    while (i != 2131374407)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    axut localaxut = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a();
    Object localObject1 = localaxut.a(10);
    aymg localaymg = new aymg();
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        i = Integer.valueOf(((BusinessInfoCheckUpdate.RedTypeInfo)localObject1).red_content.get()).intValue();
      }
      catch (Exception localException1)
      {
        try
        {
          localaymg.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
          QLog.d("nearby.redpoint", 1, "click red info, isOfficialNotify=" + localaymg.jdField_b_of_type_Boolean + " redContentType = " + localaymg.jdField_b_of_type_Int + " redTopicId = " + localaymg.jdField_b_of_type_JavaLangString);
          localObject1 = localaxut.a();
          if ((localObject1 == null) || (((aymi)localObject1).jdField_b_of_type_Int != i)) {
            break label630;
          }
          Intent localIntent = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
          if (i != 1) {
            break label561;
          }
          if (localaymg.jdField_b_of_type_Int != 2) {
            break label532;
          }
          localObject1 = "https://nearby.qq.com/nearby-rcmd-content/people.html?_bid=4227&msg_id=" + aymf.a();
          localIntent.putExtra("url", (String)localObject1);
          QLog.d("nearby.redpoint", 1, "click OfficialNotify, url" + (String)localObject1);
          this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity(localIntent);
          ayme.a().a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "home", "news_slip_click");
          localaxut.a(38);
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new NearbyHybridFragment.11.1(this), 500L);
          axql.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface, "clk_msg", 0);
          bdla.b(null, "dc00899", "grp_lbs", "", "home", "push_red_click", 0, 0, String.valueOf(((Integer)axqc.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue()), "", "", "");
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            continue;
            double d1 = 0.0D;
          }
        }
        localException1 = localException1;
        i = 0;
      }
      localException1.printStackTrace();
      continue;
      label532:
      localObject2 = "https://nearby.qq.com/nearby-rcmd-content/detail.html?_bid=4227&_wv=16777218&topic_tag=" + localaymg.jdField_b_of_type_JavaLangString;
      continue;
      label561:
      localObject2 = LbsManagerService.getCachedLbsInfo("nearby_recommend");
      if ((localObject2 != null) && (((SosoInterface.SosoLbsInfo)localObject2).mLocation != null))
      {
        d2 = ((SosoInterface.SosoLbsInfo)localObject2).mLocation.mLat02;
        d1 = ((SosoInterface.SosoLbsInfo)localObject2).mLocation.mLon02;
        localObject2 = "https://nearby.qq.com/h5/helper/index.html?_wv=3&_bid=4234&latitude=$LATITUDE$&longitude=$LONGITUDE$".replace("$LATITUDE$", String.valueOf(d2)).replace("$LONGITUDE$", String.valueOf(d1));
        continue;
        label630:
        localObject2 = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", "https://nearby.qq.com/nearby-index/my_msg.html?_wv=1031&_bid=3027");
        this.a.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivity((Intent)localObject2);
      }
      else
      {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwp
 * JD-Core Version:    0.7.0.1
 */