import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;

class avkv
  implements View.OnClickListener
{
  avkv(avkt paramavkt, String paramString) {}
  
  public void onClick(View paramView)
  {
    azqx localazqx = new azqx(this.jdField_a_of_type_Avkt.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("nonlive_clk").e(avkt.a(this.jdField_a_of_type_Avkt).uin);
    if (avkt.a(this.jdField_a_of_type_Avkt).gender == 0) {
      paramView = "1";
    }
    for (;;)
    {
      localazqx.a(new String[] { paramView }).a();
      if (!this.jdField_a_of_type_JavaLangString.startsWith("mqqapi:")) {
        break label179;
      }
      paramView = bdib.a(this.jdField_a_of_type_Avkt.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_Avkt.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      if (paramView == null) {
        break;
      }
      paramView.c();
      return;
      if (avkt.a(this.jdField_a_of_type_Avkt).gender == 1) {
        paramView = "2";
      } else {
        paramView = "0";
      }
    }
    QLog.i("NearbyProfileDisplayPanel", 1, "ja==null, jumpUrl=" + this.jdField_a_of_type_JavaLangString);
    return;
    label179:
    paramView = new Intent(this.jdField_a_of_type_Avkt.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Avkt.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avkv
 * JD-Core Version:    0.7.0.1
 */