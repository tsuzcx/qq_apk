import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axyf
  implements View.OnClickListener
{
  public axyf(ShortVideoCommentsView paramShortVideoCommentsView, LocationInfo paramLocationInfo) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.getContext(), QQBrowserActivity.class);
    String str3 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.lng;
    String str4 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.lat;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.name;
    String str1;
    if (TextUtils.isEmpty(str2))
    {
      str1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getCity();
      str1 = String.format("https://3gimg.qq.com/lightmap/v1/marker/?key=%s&referer=qqnearby&marker=coord:%s,%s;title:%s;addr:%s", new Object[] { "25TBZ-W4HCP-2BKDM-LBYH3-L4QRT-G3BDP", str4, str3, str1, str2 });
      ((Intent)localObject).putExtra("url", str1);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.getContext().startActivity((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoComments", 2, "when click location label ; the url is :" + str1);
      }
      localObject = new bdlf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.a).a("dc00899").b("grp_lbs").c("data_card").d("clk_lbs").e(String.valueOf(ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).jdField_a_of_type_Long));
      if (!TextUtils.equals(String.valueOf(ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.a.getCurrentAccountUin())) {
        break label292;
      }
      str1 = "1";
      label228:
      if (ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView) == null) {
        break label298;
      }
    }
    label292:
    label298:
    for (str2 = ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).jdField_a_of_type_JavaLangString;; str2 = "0")
    {
      ((bdlf)localObject).a(new String[] { str1, "", "", str2 }).a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      str1 = str2;
      break;
      str1 = "2";
      break label228;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyf
 * JD-Core Version:    0.7.0.1
 */