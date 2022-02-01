import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class axty
  implements bkhw
{
  axty(axtx paramaxtx, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_Bkho != null) {
        this.jdField_a_of_type_Bkho.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_Axtx.a.f = true;
    Object localObject1 = this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    paramView = (View)localObject1;
    if (bgsp.a((String)localObject1))
    {
      paramView = (View)localObject1;
      if (axtp.a(this.jdField_a_of_type_Axtx.a) != null) {
        paramView = axtp.a(this.jdField_a_of_type_Axtx.a).uin;
      }
    }
    if (bgsp.a(paramView)) {
      paramView = "0";
    }
    for (;;)
    {
      long l;
      if (this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_Long == 0L) {
        if (axtp.a(this.jdField_a_of_type_Axtx.a) != null)
        {
          l = axtp.a(this.jdField_a_of_type_Axtx.a).tinyId;
          label160:
          if ((!"0".equals(paramView)) || (l != 0L))
          {
            Object localObject2 = null;
            paramInt = 20003;
            localObject1 = null;
            if (this.jdField_a_of_type_Axtx.a.a.app != null) {
              localObject1 = this.jdField_a_of_type_Axtx.a.a.app.a(false);
            }
            if (((localObject1 == null) || (!((HotChatManager)localObject1).b(this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d))) && (this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 33) && (this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 4))
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 31) {}
            }
            else
            {
              paramInt = 20012;
              localObject1 = this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
            }
            abao.a(this.jdField_a_of_type_Axtx.a.a, this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_Long, paramView, (String)localObject1, paramInt, "", this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle);
          }
          bcst.b(this.jdField_a_of_type_Axtx.a.a.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
          if ((axtp.a(this.jdField_a_of_type_Axtx.a) != null) && (axtp.a(this.jdField_a_of_type_Axtx.a).iIsGodFlag == 1))
          {
            if (axtp.a(this.jdField_a_of_type_Axtx.a).gender != 0) {
              break label622;
            }
            bcst.b(this.jdField_a_of_type_Axtx.a.a.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        bcst.b(this.jdField_a_of_type_Axtx.a.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_report", 0, 0, "", "", "", "");
        if (!ProfileActivity.c(this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
          break;
        }
        bcst.b(this.jdField_a_of_type_Axtx.a.a.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
        break;
        l = 0L;
        break label160;
        l = this.jdField_a_of_type_Axtx.a.a.jdField_a_of_type_Long;
        break label160;
        label622:
        if (axtp.a(this.jdField_a_of_type_Axtx.a).gender == 1) {
          bcst.b(this.jdField_a_of_type_Axtx.a.a.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axty
 * JD-Core Version:    0.7.0.1
 */