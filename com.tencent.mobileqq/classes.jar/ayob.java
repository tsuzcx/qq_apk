import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.cmd0xac5.cmd0xac5.MasterState;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;

class ayob
  implements View.OnClickListener
{
  ayob(aynp paramaynp) {}
  
  public void onClick(View paramView)
  {
    int i = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.getIntExtra("param_mode", 0);
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(false);
    if ((i == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.finish();
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e == 1)
        {
          blgx.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
          if (bhnv.d(BaseApplication.getContext())) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131693965));
        }
      }
    } while (!aynp.a(this.a));
    this.a.b();
    boolean bool1 = this.a.a();
    boolean bool2 = ((Boolean)axws.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(true))).booleanValue();
    boolean bool3 = this.a.c();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get() != null) && (((cmd0xac5.NearbyNowData)this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get() != null)) {}
    for (i = ((cmd0xac5.MasterState)((cmd0xac5.NearbyNowData)this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nearbyNowData.get()).master_state.get()).uint32_state.get();; i = 0)
    {
      if ((i == 1) || (i == 2)) {}
      for (i = 1;; i = 0)
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null) || (!bool3) || (i == 0)) {
          break label413;
        }
        new bdlq(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app).a("dc00899").b("grp_lbs").c("face_score_vip").d("expert_change").a(new String[] { "", "" + (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender + 1) }).a();
        this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.t = bool3;
        this.a.f();
        break;
      }
      label413:
      Object localObject;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.godFlag) && (bool1))
      {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131693959, new Object[] { this.a.jdField_a_of_type_JavaLangString });
        localObject = bhlq.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
        ((bhpc)localObject).setPositiveButton(anzj.a(2131706135), new ayoc(this, (bhpc)localObject));
        ((bhpc)localObject).setNegativeButton(anzj.a(2131706264), new ayod(this, (bhpc)localObject));
        ((bhpc)localObject).show();
        break;
      }
      if ((bool1) && (bool2))
      {
        localObject = anzj.a(2131706252);
        localObject = bhlq.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, (String)localObject, 0, 0, null, null);
        ((bhpc)localObject).setPositiveButton(anzj.a(2131706201), new ayoe(this, (bhpc)localObject));
        ((bhpc)localObject).setNegativeButton(anzj.a(2131706203), new ayof(this, (bhpc)localObject));
        ((bhpc)localObject).show();
        axws.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getCurrentAccountUin(), "nearby_profile_edit_isFirst", Boolean.valueOf(false));
        break;
      }
      if (bool1)
      {
        this.a.f();
        break;
      }
      bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "dc00899", "grp_lbs", "", "data_card", "return_no", 0, 0, "", "", "", "");
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.c();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayob
 * JD-Core Version:    0.7.0.1
 */