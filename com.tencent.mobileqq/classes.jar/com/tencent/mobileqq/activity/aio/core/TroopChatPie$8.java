package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class TroopChatPie$8
  extends RoamSettingObserver
{
  TroopChatPie$8(TroopChatPie paramTroopChatPie) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString = this.a.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSetGenralSettingsTroopFilter: isSuc = ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(", size = ");
        int i;
        if (paramMap == null) {
          i = 0;
        } else {
          i = paramMap.size();
        }
        localStringBuilder.append(i);
        QLog.d(paramString, 2, localStringBuilder.toString());
      }
      if (paramMap != null)
      {
        if (paramMap.size() == 0) {
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume())
        {
          if (paramBoolean)
          {
            QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719976), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
            return;
          }
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719975), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.8
 * JD-Core Version:    0.7.0.1
 */