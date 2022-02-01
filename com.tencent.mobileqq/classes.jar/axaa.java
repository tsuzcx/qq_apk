import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.utils.StringUtil;

class axaa
  implements bjoe
{
  axaa(awzz paramawzz, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_Bjnw != null) {
        this.jdField_a_of_type_Bjnw.dismiss();
      }
      return;
    }
    this.jdField_a_of_type_Awzz.a.f = true;
    Object localObject1 = this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    paramView = (View)localObject1;
    if (StringUtil.isEmpty((String)localObject1))
    {
      paramView = (View)localObject1;
      if (awzr.a(this.jdField_a_of_type_Awzz.a) != null) {
        paramView = awzr.a(this.jdField_a_of_type_Awzz.a).uin;
      }
    }
    if (StringUtil.isEmpty(paramView)) {
      paramView = "0";
    }
    for (;;)
    {
      long l;
      if (this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_Long == 0L) {
        if (awzr.a(this.jdField_a_of_type_Awzz.a) != null)
        {
          l = awzr.a(this.jdField_a_of_type_Awzz.a).tinyId;
          label160:
          if ((!"0".equals(paramView)) || (l != 0L))
          {
            Object localObject2 = null;
            paramInt = 20003;
            localObject1 = null;
            if (this.jdField_a_of_type_Awzz.a.a.app != null) {
              localObject1 = this.jdField_a_of_type_Awzz.a.a.app.getHotChatMng(false);
            }
            if (((localObject1 == null) || (!((HotChatManager)localObject1).b(this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d))) && (this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 33) && (this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 4))
            {
              localObject1 = localObject2;
              if (this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h != 31) {}
            }
            else
            {
              paramInt = 20012;
              localObject1 = this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
            }
            aabc.a(this.jdField_a_of_type_Awzz.a.a, this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_Long, paramView, (String)localObject1, paramInt, "", this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_AndroidOsBundle);
          }
          bcef.b(this.jdField_a_of_type_Awzz.a.a.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
          if ((awzr.a(this.jdField_a_of_type_Awzz.a) != null) && (awzr.a(this.jdField_a_of_type_Awzz.a).iIsGodFlag == 1))
          {
            if (awzr.a(this.jdField_a_of_type_Awzz.a).gender != 0) {
              break label622;
            }
            bcef.b(this.jdField_a_of_type_Awzz.a.a.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        bcef.b(this.jdField_a_of_type_Awzz.a.a.app, "dc00899", "grp_lbs", "", "data_card", "clk_report", 0, 0, "", "", "", "");
        if (!ProfileActivity.c(this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h)) {
          break;
        }
        bcef.b(this.jdField_a_of_type_Awzz.a.a.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
        break;
        l = 0L;
        break label160;
        l = this.jdField_a_of_type_Awzz.a.a.jdField_a_of_type_Long;
        break label160;
        label622:
        if (awzr.a(this.jdField_a_of_type_Awzz.a).gender == 1) {
          bcef.b(this.jdField_a_of_type_Awzz.a.a.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axaa
 * JD-Core Version:    0.7.0.1
 */