import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayme
  implements View.OnClickListener
{
  ayme(aykx paramaykx, String paramString) {}
  
  public void onClick(View paramView)
  {
    bdlq localbdlq = new bdlq(this.jdField_a_of_type_Aykx.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).b("grp_lbs").c("data_card").d("live_clk").e(aykx.a(this.jdField_a_of_type_Aykx).uin);
    Object localObject;
    if (aykx.a(this.jdField_a_of_type_Aykx).gender == 0)
    {
      localObject = "1";
      localbdlq.a(new String[] { localObject }).a();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label129;
      }
      QLog.i("NearbyProfileDisplayPanel", 1, "jumpUrl is empty");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aykx.a(this.jdField_a_of_type_Aykx).gender == 1)
      {
        localObject = "2";
        break;
      }
      localObject = "0";
      break;
      label129:
      if (this.jdField_a_of_type_JavaLangString.startsWith("mqqapi:"))
      {
        localObject = bhni.a(this.jdField_a_of_type_Aykx.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, this.jdField_a_of_type_Aykx.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          ((bhmr)localObject).a();
        } else {
          QLog.i("NearbyProfileDisplayPanel", 1, "ja==null, jumpUrl=" + this.jdField_a_of_type_JavaLangString);
        }
      }
      else
      {
        localObject = new Intent(this.jdField_a_of_type_Aykx.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_Aykx.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayme
 * JD-Core Version:    0.7.0.1
 */