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

class ayin
  implements View.OnClickListener
{
  ayin(ayih paramayih) {}
  
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
        bkxz.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694255));
        }
        else if (ayih.a(this.a))
        {
          this.a.b();
          boolean bool1 = this.a.a();
          boolean bool2 = ((Boolean)axqc.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
          Object localObject;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
          {
            localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131694249, new Object[] { this.a.jdField_a_of_type_JavaLangString });
            localObject = bhdj.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
            ((QQCustomDialog)localObject).setPositiveButton(anvx.a(2131706745), new ayio(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).setNegativeButton(anvx.a(2131706740), new ayip(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).show();
          }
          else if ((bool1) && (bool2))
          {
            localObject = anvx.a(2131706769);
            localObject = bhdj.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
            ((QQCustomDialog)localObject).setPositiveButton(anvx.a(2131706791), new ayiq(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).setNegativeButton(anvx.a(2131706824), new ayir(this, (QQCustomDialog)localObject));
            ((QQCustomDialog)localObject).show();
            axqc.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
          }
          else if (bool1)
          {
            this.a.e();
            localObject = new Intent("tribe_profile_edit_finish");
            BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
          }
          else
          {
            bdla.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
            this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.d();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayin
 * JD-Core Version:    0.7.0.1
 */