import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class ayms
  implements bliz
{
  ayms(aymr paramaymr, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_Blir != null) {
        this.jdField_a_of_type_Blir.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_Aymr.a.f = true;
    Object localObject1 = this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    paramView = (View)localObject1;
    if (bhsr.a((String)localObject1))
    {
      paramView = (View)localObject1;
      if (aymj.a(this.jdField_a_of_type_Aymr.a) != null) {
        paramView = aymj.a(this.jdField_a_of_type_Aymr.a).uin;
      }
    }
    if (bhsr.a(paramView)) {
      paramView = "0";
    }
    for (;;)
    {
      long l;
      if (this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_Long == 0L) {
        if (aymj.a(this.jdField_a_of_type_Aymr.a) != null)
        {
          l = aymj.a(this.jdField_a_of_type_Aymr.a).tinyId;
          label160:
          if ((!"0".equals(paramView)) || (l != 0L))
          {
            Object localObject2 = null;
            paramInt = 20003;
            localObject1 = null;
            if (this.jdField_a_of_type_Aymr.a.a.app != null) {
              localObject1 = this.jdField_a_of_type_Aymr.a.a.app.a(false);
            }
            if (((localObject1 == null) || (!((HotChatManager)localObject1).b(this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d))) && (this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 33) && (this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 4))
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 31) {}
            }
            else
            {
              paramInt = 20012;
              localObject1 = this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
            }
            aber.a(this.jdField_a_of_type_Aymr.a.a, this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_Long, paramView, (String)localObject1, paramInt, "", this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle);
          }
          bdll.b(this.jdField_a_of_type_Aymr.a.a.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
          if ((aymj.a(this.jdField_a_of_type_Aymr.a) != null) && (aymj.a(this.jdField_a_of_type_Aymr.a).iIsGodFlag == 1))
          {
            if (aymj.a(this.jdField_a_of_type_Aymr.a).gender != 0) {
              break label622;
            }
            bdll.b(this.jdField_a_of_type_Aymr.a.a.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        bdll.b(this.jdField_a_of_type_Aymr.a.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_report", 0, 0, "", "", "", "");
        if (!ProfileActivity.c(this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
          break;
        }
        bdll.b(this.jdField_a_of_type_Aymr.a.a.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
        break;
        l = 0L;
        break label160;
        l = this.jdField_a_of_type_Aymr.a.a.jdField_a_of_type_Long;
        break label160;
        label622:
        if (aymj.a(this.jdField_a_of_type_Aymr.a).gender == 1) {
          bdll.b(this.jdField_a_of_type_Aymr.a.a.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayms
 * JD-Core Version:    0.7.0.1
 */