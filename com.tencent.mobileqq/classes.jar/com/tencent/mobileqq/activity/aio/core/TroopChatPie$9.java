package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class TroopChatPie$9
  extends FriendListObserver
{
  TroopChatPie$9(TroopChatPie paramTroopChatPie) {}
  
  public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    int i;
    if (QLog.isColorLevel())
    {
      String str = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder().append("onSetGenralSettingsTroopFilter: isSuc = ").append(paramBoolean).append(", size = ");
      if (paramMap == null)
      {
        i = 0;
        QLog.d(str, 2, i);
      }
    }
    else
    {
      if ((paramMap != null) && (paramMap.size() != 0)) {
        break label83;
      }
    }
    label83:
    while (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume())
    {
      return;
      i = paramMap.size();
      break;
    }
    if (paramBoolean)
    {
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720243), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720242), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.9
 * JD-Core Version:    0.7.0.1
 */