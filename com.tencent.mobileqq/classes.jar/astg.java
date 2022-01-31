import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

class astg
  implements View.OnClickListener
{
  astg(aste paramaste, String paramString) {}
  
  public void onClick(View paramView)
  {
    awrb localawrb = new awrb(this.jdField_a_of_type_Aste.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("nonlive_clk").e(aste.a(this.jdField_a_of_type_Aste).uin);
    if (aste.a(this.jdField_a_of_type_Aste).gender == 0) {
      paramView = "1";
    }
    for (;;)
    {
      localawrb.a(new String[] { paramView }).a();
      if (!this.jdField_a_of_type_JavaLangString.startsWith("mqqapi:")) {
        break label179;
      }
      paramView = bade.a(this.jdField_a_of_type_Aste.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_Aste.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      if (paramView == null) {
        break;
      }
      paramView.c();
      return;
      if (aste.a(this.jdField_a_of_type_Aste).gender == 1) {
        paramView = "2";
      } else {
        paramView = "0";
      }
    }
    QLog.i("NearbyProfileDisplayPanel", 1, "ja==null, jumpUrl=" + this.jdField_a_of_type_JavaLangString);
    return;
    label179:
    paramView = new Intent(this.jdField_a_of_type_Aste.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Aste.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     astg
 * JD-Core Version:    0.7.0.1
 */