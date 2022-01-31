import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class avmo
  implements bhuk
{
  avmo(avmn paramavmn, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_Bhuf != null) {
        this.jdField_a_of_type_Bhuf.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_Avmn.a.f = true;
    Object localObject1 = this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    paramView = (View)localObject1;
    if (bdnn.a((String)localObject1))
    {
      paramView = (View)localObject1;
      if (avmf.a(this.jdField_a_of_type_Avmn.a) != null) {
        paramView = avmf.a(this.jdField_a_of_type_Avmn.a).uin;
      }
    }
    if (bdnn.a(paramView)) {
      paramView = "0";
    }
    for (;;)
    {
      long l;
      if (this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_Long == 0L) {
        if (avmf.a(this.jdField_a_of_type_Avmn.a) != null)
        {
          l = avmf.a(this.jdField_a_of_type_Avmn.a).tinyId;
          label160:
          if ((!"0".equals(paramView)) || (l != 0L))
          {
            Object localObject2 = null;
            paramInt = 20003;
            localObject1 = null;
            if (this.jdField_a_of_type_Avmn.a.a.app != null) {
              localObject1 = this.jdField_a_of_type_Avmn.a.a.app.a(false);
            }
            if (((localObject1 == null) || (!((HotChatManager)localObject1).b(this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d))) && (this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 33) && (this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 4))
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 31) {}
            }
            else
            {
              paramInt = 20012;
              localObject1 = this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
            }
            zdv.a(this.jdField_a_of_type_Avmn.a.a, this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_Long, paramView, (String)localObject1, paramInt, "", this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle);
          }
          azqs.b(this.jdField_a_of_type_Avmn.a.a.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
          if ((avmf.a(this.jdField_a_of_type_Avmn.a) != null) && (avmf.a(this.jdField_a_of_type_Avmn.a).iIsGodFlag == 1))
          {
            if (avmf.a(this.jdField_a_of_type_Avmn.a).gender != 0) {
              break label622;
            }
            azqs.b(this.jdField_a_of_type_Avmn.a.a.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        azqs.b(this.jdField_a_of_type_Avmn.a.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_report", 0, 0, "", "", "", "");
        if (!ProfileActivity.c(this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
          break;
        }
        azqs.b(this.jdField_a_of_type_Avmn.a.a.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
        break;
        l = 0L;
        break label160;
        l = this.jdField_a_of_type_Avmn.a.a.jdField_a_of_type_Long;
        break label160;
        label622:
        if (avmf.a(this.jdField_a_of_type_Avmn.a).gender == 1) {
          azqs.b(this.jdField_a_of_type_Avmn.a.a.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avmo
 * JD-Core Version:    0.7.0.1
 */