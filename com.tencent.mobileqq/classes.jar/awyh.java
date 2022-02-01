import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awyh
  implements View.OnClickListener
{
  awyh(awyf paramawyf, String paramString) {}
  
  public void onClick(View paramView)
  {
    bcek localbcek = new bcek(this.jdField_a_of_type_Awyf.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("nonlive_clk").e(awyf.a(this.jdField_a_of_type_Awyf).uin);
    Object localObject;
    if (awyf.a(this.jdField_a_of_type_Awyf).gender == 0)
    {
      localObject = "1";
      localbcek.a(new String[] { localObject }).a();
      if (!this.jdField_a_of_type_JavaLangString.startsWith("mqqapi:")) {
        break label188;
      }
      localObject = bfwg.a(this.jdField_a_of_type_Awyf.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_Awyf.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        break label157;
      }
      ((bfvp)localObject).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (awyf.a(this.jdField_a_of_type_Awyf).gender == 1)
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
      localObject = new Intent(this.jdField_a_of_type_Awyf.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Awyf.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyh
 * JD-Core Version:    0.7.0.1
 */