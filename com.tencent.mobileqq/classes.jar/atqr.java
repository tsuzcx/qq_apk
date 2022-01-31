import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

class atqr
  implements View.OnClickListener
{
  atqr(atpk paramatpk, String paramString) {}
  
  public void onClick(View paramView)
  {
    axrc localaxrc = new axrc(this.jdField_a_of_type_Atpk.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("live_clk").e(atpk.a(this.jdField_a_of_type_Atpk).uin);
    if (atpk.a(this.jdField_a_of_type_Atpk).gender == 0) {
      paramView = "1";
    }
    for (;;)
    {
      localaxrc.a(new String[] { paramView }).a();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
      QLog.i("NearbyProfileDisplayPanel", 1, "jumpUrl is empty");
      return;
      if (atpk.a(this.jdField_a_of_type_Atpk).gender == 1) {
        paramView = "2";
      } else {
        paramView = "0";
      }
    }
    if (this.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
    {
      paramView = bbex.a(this.jdField_a_of_type_Atpk.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_Atpk.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      if (paramView != null)
      {
        paramView.c();
        return;
      }
      QLog.i("NearbyProfileDisplayPanel", 1, "ja==null, jumpUrl=" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_Atpk.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Atpk.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqr
 * JD-Core Version:    0.7.0.1
 */