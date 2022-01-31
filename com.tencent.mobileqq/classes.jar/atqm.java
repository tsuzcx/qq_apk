import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;

class atqm
  implements ViewPager.OnPageChangeListener
{
  atqm(atpi paramatpi) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      atbp.a("onPageSelected", new Object[] { Integer.valueOf(paramInt) });
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, true);
    Object localObject = (NearbyBaseFragment)this.a.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("android:switcher:2131379339:" + paramInt);
    if (localObject != null) {
      ((NearbyBaseFragment)localObject).aT_();
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2)
    {
      if (paramInt == 0) {
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else
    {
      if (paramInt != 0) {
        break label289;
      }
      localaxra = new axra(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("datatab_exp");
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 2) {
        break label283;
      }
    }
    label283:
    for (localObject = "1";; localObject = "2")
    {
      localaxra.a(new String[] { localObject }).a();
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localaxra = new axra(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_pub").e(atpi.a(this.a).uin);
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2) {}
      for (localObject = "1";; localObject = "2")
      {
        localaxra.a(new String[] { localObject }).a();
        break;
      }
    }
    label289:
    axra localaxra = new axra(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp").e(atpi.a(this.a).uin);
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2) {}
    for (localObject = "1";; localObject = "2")
    {
      localaxra.a(new String[] { localObject }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqm
 * JD-Core Version:    0.7.0.1
 */