import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class bauj
  implements AdapterView.OnItemClickListener
{
  bauj(baui parambaui) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = 0;
    paramAdapterView = paramView.getTag();
    if ((paramAdapterView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null)) {
      return;
    }
    this.a.jdField_a_of_type_Bbjq.b();
    switch (((bbjv)paramAdapterView).a.c)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = ((int)paramLong);
      if (paramLong != 7L) {
        break;
      }
      paramAdapterView = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, Face2FaceAddFriendActivity.class);
      paramAdapterView.putExtra("activity_from_type", 1);
      paramAdapterView.putExtra("activity_troop_uin", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramAdapterView);
      return;
      paramLong = 0L;
      continue;
      paramLong = 1L;
      continue;
      paramLong = 3L;
      continue;
      paramLong = 2L;
      continue;
      paramLong = 4L;
      continue;
      paramLong = 5L;
      continue;
      paramLong = 7L;
    }
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().a()) {
        i = 2131720917;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        this.a.b(false);
        bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.a.jdField_a_of_type_Int = -1;
        this.a.b = -1;
        if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          break;
        }
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        return;
        if (WXShareHelper.a().b()) {
          break label680;
        }
        i = 2131720918;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
      }
      if ((this.a.jdField_a_of_type_Int == 5) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
      {
        this.a.g();
        if (!(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          break;
        }
        ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        return;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (!TroopInfo.isQidianPrivateTroop((QQAppInterface)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
      {
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          this.a.jdField_a_of_type_Boolean = true;
        }
        if ((TroopInfo.hasPayPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
        for (paramInt = 1;; paramInt = 0)
        {
          i = j;
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) {
            i = 1;
          }
          if ((paramInt | i) == 0) {
            break;
          }
          this.a.b(true);
          this.a.c();
          return;
        }
        this.a.e();
        return;
      }
      this.a.b(true);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
        this.a.jdField_a_of_type_Boolean = false;
      }
      this.a.b = 0;
      baui.a(this.a);
      return;
      label680:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bauj
 * JD-Core Version:    0.7.0.1
 */