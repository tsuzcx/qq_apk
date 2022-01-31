import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.widget.TabBarView;

class atqk
  implements atvo
{
  atqk(atpi paramatpi, int paramInt) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView != null))
    {
      if (paramInt > 0) {
        this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(1, false);
      }
    }
    else
    {
      this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment.a(null);
      if (this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView != null)
      {
        if (this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a() != 0) {
          break label160;
        }
        localObject = new axra(this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("datatab_exp");
        if (this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 2) {
          break label154;
        }
      }
    }
    label154:
    for (String str = "1";; str = "2")
    {
      ((axra)localObject).a(new String[] { str }).a();
      return;
      this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, false);
      break;
    }
    label160:
    axra localaxra = new axra(this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp");
    if (this.jdField_a_of_type_Atpi.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2)
    {
      str = "1";
      if (paramInt != 0) {
        break label250;
      }
    }
    label250:
    for (Object localObject = "1";; localObject = "2")
    {
      localaxra.a(new String[] { str, localObject }).a();
      return;
      str = "2";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqk
 * JD-Core Version:    0.7.0.1
 */