package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.troopgag.api.TroopGagObserver;
import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import com.tencent.mobileqq.troop.troopgag.data.GagTroopMemberResult;
import com.tencent.mobileqq.troop.troopgag.data.GagTroopResult;
import com.tencent.mobileqq.troop.troopgag.data.MemberGagInfo;
import com.tencent.mobileqq.troop.troopgag.data.TroopGagInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopGagActivity$2
  extends TroopGagObserver
{
  TroopGagActivity$2(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(GagStatus paramGagStatus)
  {
    if (paramGagStatus != null)
    {
      if (!paramGagStatus.jdField_a_of_type_JavaLangString.equals(this.a.jdField_a_of_type_JavaLangString)) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onTroopGagStatusChange, statuCode=");
        ((StringBuilder)localObject).append(paramGagStatus.jdField_a_of_type_Int);
        QLog.d("TroopGagActivity", 2, ((StringBuilder)localObject).toString());
      }
      TroopGagActivity.GagMemInfo localGagMemInfo;
      if (paramGagStatus.jdField_a_of_type_Int == 3)
      {
        this.a.jdField_a_of_type_JavaUtilList.clear();
        if (paramGagStatus.jdField_a_of_type_JavaUtilArrayList != null)
        {
          paramGagStatus = paramGagStatus.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (paramGagStatus.hasNext())
          {
            localObject = (MemberGagInfo)paramGagStatus.next();
            localGagMemInfo = new TroopGagActivity.GagMemInfo();
            localGagMemInfo.jdField_a_of_type_JavaLangString = ((MemberGagInfo)localObject).jdField_a_of_type_JavaLangString;
            localGagMemInfo.jdField_a_of_type_Long = ((MemberGagInfo)localObject).jdField_a_of_type_Long;
            this.a.jdField_a_of_type_JavaUtilList.add(localGagMemInfo);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter.notifyDataSetChanged();
      }
      else if (paramGagStatus.jdField_a_of_type_Int == 1)
      {
        paramGagStatus = paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopTroopgagDataTroopGagInfo;
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (paramGagStatus.jdField_a_of_type_Long != 0L) {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        } else {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
        }
        this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
      }
      else if (paramGagStatus.jdField_a_of_type_Int == 5)
      {
        if (!paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopTroopgagDataGagTroopMemberResult.jdField_a_of_type_Boolean)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.clear();
          if (paramGagStatus.jdField_a_of_type_JavaUtilArrayList != null)
          {
            paramGagStatus = paramGagStatus.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (paramGagStatus.hasNext())
            {
              localObject = (MemberGagInfo)paramGagStatus.next();
              localGagMemInfo = new TroopGagActivity.GagMemInfo();
              localGagMemInfo.jdField_a_of_type_JavaLangString = ((MemberGagInfo)localObject).jdField_a_of_type_JavaLangString;
              localGagMemInfo.jdField_a_of_type_Long = ((MemberGagInfo)localObject).jdField_a_of_type_Long;
              this.a.jdField_a_of_type_JavaUtilList.add(localGagMemInfo);
            }
          }
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter.notifyDataSetChanged();
        }
      }
      else if (paramGagStatus.jdField_a_of_type_Int == 4)
      {
        paramGagStatus = paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopTroopgagDataGagTroopResult;
        if (!paramGagStatus.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
          if (paramGagStatus.jdField_a_of_type_Long != 0L) {
            this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
          } else {
            this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
          }
          this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
        }
      }
      if (this.a.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2
 * JD-Core Version:    0.7.0.1
 */