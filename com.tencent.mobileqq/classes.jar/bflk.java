import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bflk
  implements AdapterView.OnItemClickListener
{
  bflk(bflj parambflj) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int j = 0;
    Object localObject = paramView.getTag();
    if ((localObject == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null))
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    switch (((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).sheetItem.action)
    {
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Int = ((int)paramLong);
      if (paramLong != 7L) {
        break label255;
      }
      localObject = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, Face2FaceAddFriendActivity.class);
      ((Intent)localObject).putExtra("activity_from_type", 1);
      ((Intent)localObject).putExtra("activity_troop_uin", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      break;
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
    label255:
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.getInstance().isWXinstalled()) {
        i = 2131719722;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        this.a.b(false);
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.a.jdField_a_of_type_Int = -1;
        this.a.b = -1;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        }
        break;
        if (WXShareHelper.getInstance().isWXsupportApi()) {
          break label711;
        }
        i = 2131719723;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopShareUtility", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
      }
      if ((this.a.jdField_a_of_type_Int == 5) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
      {
        this.a.f();
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
          ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).finish();
        }
      }
      for (;;)
      {
        break;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (!TroopInfo.isQidianPrivateTroop((QQAppInterface)this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime(), this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)))
        {
          if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            this.a.jdField_a_of_type_Boolean = true;
          }
          if ((TroopInfo.hasPayPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
          for (i = 1;; i = 0)
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) {
              j = 1;
            }
            if ((i | j) == 0) {
              break label654;
            }
            this.a.b(true);
            this.a.c();
            break;
          }
          label654:
          bflj.a(this.a);
        }
        else
        {
          this.a.b(true);
          if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof TroopCreateLogicActivity)) {
            this.a.jdField_a_of_type_Boolean = false;
          }
          this.a.b = 0;
          bflj.b(this.a);
        }
      }
      label711:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflk
 * JD-Core Version:    0.7.0.1
 */