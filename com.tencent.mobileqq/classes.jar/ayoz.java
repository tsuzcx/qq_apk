import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayoz
  implements View.OnClickListener
{
  ayoz(ayot paramayot) {}
  
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
        blgx.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
        if (!bhnv.d(BaseApplication.getContext()))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131693965));
        }
        else if (ayot.a(this.a))
        {
          this.a.b();
          boolean bool1 = this.a.a();
          boolean bool2 = ((Boolean)axws.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
          Object localObject;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
          {
            localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131693959, new Object[] { this.a.jdField_a_of_type_JavaLangString });
            localObject = bhlq.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
            ((bhpc)localObject).setPositiveButton(anzj.a(2131706163), new aypa(this, (bhpc)localObject));
            ((bhpc)localObject).setNegativeButton(anzj.a(2131706158), new aypb(this, (bhpc)localObject));
            ((bhpc)localObject).show();
          }
          else if ((bool1) && (bool2))
          {
            localObject = anzj.a(2131706187);
            localObject = bhlq.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
            ((bhpc)localObject).setPositiveButton(anzj.a(2131706209), new aypc(this, (bhpc)localObject));
            ((bhpc)localObject).setNegativeButton(anzj.a(2131706242), new aypd(this, (bhpc)localObject));
            ((bhpc)localObject).show();
            axws.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
          }
          else if (bool1)
          {
            this.a.e();
            localObject = new Intent("tribe_profile_edit_finish");
            BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
          }
          else
          {
            bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
            this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayoz
 * JD-Core Version:    0.7.0.1
 */