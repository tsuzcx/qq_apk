import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axch
  implements View.OnClickListener
{
  axch(axcb paramaxcb) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.getIntExtra("param_mode", 0) == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 1)
      {
        bjmm.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694064));
        }
        else if (axcb.a(this.a))
        {
          this.a.b();
          boolean bool1 = this.a.a();
          boolean bool2 = ((Boolean)awka.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
          Object localObject;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
          {
            localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694058, new Object[] { this.a.jdField_a_of_type_JavaLangString });
            localObject = bfur.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
            ((QQCustomDialog)localObject).setPositiveButton(amtj.a(2131706393), new axci(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).setNegativeButton(amtj.a(2131706388), new axcj(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).show();
          }
          else if ((bool1) && (bool2))
          {
            localObject = amtj.a(2131706417);
            localObject = bfur.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
            ((QQCustomDialog)localObject).setPositiveButton(amtj.a(2131706439), new axck(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).setNegativeButton(amtj.a(2131706472), new axcl(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).show();
            awka.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
          }
          else if (bool1)
          {
            this.a.e();
            localObject = new Intent("tribe_profile_edit_finish");
            BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
          }
          else
          {
            bcef.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
            this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axch
 * JD-Core Version:    0.7.0.1
 */