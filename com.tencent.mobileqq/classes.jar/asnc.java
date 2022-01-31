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

public class asnc
  implements View.OnClickListener
{
  public asnc(ShortVideoCommentsView paramShortVideoCommentsView, LocationInfo paramLocationInfo) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.getContext(), QQBrowserActivity.class);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.lng;
    String str3 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.lat;
    String str1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.name;
    if (TextUtils.isEmpty(str1))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo.getCity();
      paramView = String.format("http://3gimg.qq.com/lightmap/v1/marker/?key=%s&referer=qqnearby&marker=coord:%s,%s;title:%s;addr:%s", new Object[] { "25TBZ-W4HCP-2BKDM-LBYH3-L4QRT-G3BDP", str3, str2, paramView, str1 });
      ((Intent)localObject).putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.getContext().startActivity((Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoComments", 2, "when click location label ; the url is :" + paramView);
      }
      localObject = new awrb(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.a).a("dc00899").b("grp_lbs").c("data_card").d("clk_lbs").e(String.valueOf(ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).jdField_a_of_type_Long));
      if (!TextUtils.equals(String.valueOf(ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.a.getCurrentAccountUin())) {
        break label280;
      }
      paramView = "1";
      label224:
      if (ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView) == null) {
        break label286;
      }
    }
    label280:
    label286:
    for (str1 = ShortVideoCommentsView.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView).jdField_a_of_type_JavaLangString;; str1 = "0")
    {
      ((awrb)localObject).a(new String[] { paramView, "", "", str1 }).a();
      return;
      paramView = str1;
      break;
      paramView = "2";
      break label224;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asnc
 * JD-Core Version:    0.7.0.1
 */