import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.BaseApplication;

class attm
  implements View.OnClickListener
{
  attm(attg paramattg) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.getIntExtra("param_mode", 0) == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    do
    {
      do
      {
        return;
      } while (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e != 1);
      bfni.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
      if (!bbfj.d(BaseApplication.getContext()))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694610));
        return;
      }
    } while (!attg.a(this.a));
    this.a.b();
    boolean bool1 = this.a.a();
    boolean bool2 = ((Boolean)atbi.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
    {
      paramView = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694598, new Object[] { this.a.jdField_a_of_type_JavaLangString });
      paramView = bbdj.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView, 0, 0, null, null);
      paramView.setPositiveButton(ajya.a(2131707281), new attn(this, paramView));
      paramView.setNegativeButton(ajya.a(2131707276), new atto(this, paramView));
      paramView.show();
      return;
    }
    if ((bool1) && (bool2))
    {
      paramView = ajya.a(2131707305);
      paramView = bbdj.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, paramView, 0, 0, null, null);
      paramView.setPositiveButton(ajya.a(2131707327), new attp(this, paramView));
      paramView.setNegativeButton(ajya.a(2131707360), new attq(this, paramView));
      paramView.show();
      atbi.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
      return;
    }
    if (bool1)
    {
      this.a.e();
      paramView = new Intent("tribe_profile_edit_finish");
      BaseApplicationImpl.getApplication().sendBroadcast(paramView);
      return;
    }
    axqy.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     attm
 * JD-Core Version:    0.7.0.1
 */