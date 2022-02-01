import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axsf
  implements View.OnClickListener
{
  axsf(axsd paramaxsd, String paramString) {}
  
  public void onClick(View paramView)
  {
    bcsy localbcsy = new bcsy(this.jdField_a_of_type_Axsd.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("nonlive_clk").e(axsd.a(this.jdField_a_of_type_Axsd).uin);
    Object localObject;
    if (axsd.a(this.jdField_a_of_type_Axsd).gender == 0)
    {
      localObject = "1";
      localbcsy.a(new String[] { localObject }).a();
      if (!this.jdField_a_of_type_JavaLangString.startsWith("mqqapi:")) {
        break label188;
      }
      localObject = bgng.a(this.jdField_a_of_type_Axsd.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_Axsd.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        break label157;
      }
      ((bgmp)localObject).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (axsd.a(this.jdField_a_of_type_Axsd).gender == 1)
      {
        localObject = "2";
        break;
      }
      localObject = "0";
      break;
      label157:
      QLog.i("NearbyProfileDisplayPanel", 1, "ja==null, jumpUrl=" + this.jdField_a_of_type_JavaLangString);
      continue;
      label188:
      localObject = new Intent(this.jdField_a_of_type_Axsd.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Axsd.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsf
 * JD-Core Version:    0.7.0.1
 */