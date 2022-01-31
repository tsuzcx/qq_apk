import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.fragment.NearbyBaseFragment;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;

class avho
  implements ViewPager.OnPageChangeListener
{
  avho(avgk paramavgk) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (QLog.isColorLevel()) {
      ausq.a("onPageSelected", new Object[] { Integer.valueOf(paramInt) });
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(paramInt, true);
    Object localObject = (NearbyBaseFragment)this.a.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("android:switcher:2131380045:" + paramInt);
    if (localObject != null) {
      ((NearbyBaseFragment)localObject).aU_();
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
      localazmo = new azmo(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("datatab_exp");
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 2) {
        break label283;
      }
    }
    label283:
    for (localObject = "1";; localObject = "2")
    {
      localazmo.a(new String[] { localObject }).a();
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localazmo = new azmo(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_pub").e(avgk.a(this.a).uin);
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2) {}
      for (localObject = "1";; localObject = "2")
      {
        localazmo.a(new String[] { localObject }).a();
        break;
      }
    }
    label289:
    azmo localazmo = new azmo(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp").e(avgk.a(this.a).uin);
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 2) {}
    for (localObject = "1";; localObject = "2")
    {
      localazmo.a(new String[] { localObject }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avho
 * JD-Core Version:    0.7.0.1
 */