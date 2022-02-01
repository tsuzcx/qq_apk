package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.troop.troopgag.api.TroopGagObserver;
import com.tencent.mobileqq.troop.troopgag.data.GagStatus;
import com.tencent.qphone.base.util.QLog;

class TroopObserversHelper$2
  extends TroopGagObserver
{
  TroopObserversHelper$2(TroopObserversHelper paramTroopObserversHelper) {}
  
  protected void a(GagStatus paramGagStatus)
  {
    if ((paramGagStatus.jdField_a_of_type_Int == 2) && (paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopTroopgagDataSelfGagInfo != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTroopGagStatusChange:");
        localStringBuilder.append(paramGagStatus.jdField_a_of_type_JavaLangString);
        QLog.d("troop_gag", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(TroopObserversHelper.a(this.a).jdField_a_of_type_JavaLangString))
      {
        if (TextUtils.isEmpty(paramGagStatus.jdField_a_of_type_JavaLangString)) {
          return;
        }
        if (TroopObserversHelper.a(this.a).jdField_a_of_type_JavaLangString.equals(paramGagStatus.jdField_a_of_type_JavaLangString)) {
          TroopObserversHelper.a(this.a).a(paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopTroopgagDataSelfGagInfo, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.2
 * JD-Core Version:    0.7.0.1
 */