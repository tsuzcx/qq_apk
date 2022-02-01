package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.widget.QQToast;

class TroopChatPie$17
  extends BizTroopObserver
{
  TroopChatPie$17(TroopChatPie paramTroopChatPie) {}
  
  protected void a(Object paramObject)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) {
      return;
    }
    if (paramBoolean1)
    {
      int i;
      if (paramBoolean2)
      {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        i = 2131696202;
      }
      else
      {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
        i = 2131696111;
      }
      Object localObject = ((BaseActivity)localObject).getString(i);
      QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), 2, (CharSequence)localObject, 1).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), 1, 2131696201, 1).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.17
 * JD-Core Version:    0.7.0.1
 */