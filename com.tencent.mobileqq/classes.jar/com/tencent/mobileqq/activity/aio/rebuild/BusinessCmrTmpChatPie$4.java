package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BusinessCmrTmpChatPie$4
  implements View.OnClickListener
{
  BusinessCmrTmpChatPie$4(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof Integer)))
    {
      Object localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int i = ((Integer)localObject1).intValue();
      boolean bool = true;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            if (this.a.jdField_a_of_type_ComTencentQidianQidianManager.f(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
            {
              localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
              localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
              String str = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690706);
              if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("param_return_addr") == null) {
                bool = false;
              }
              ChatActivityUtils.a((Activity)localObject1, (SessionInfo)localObject2, str, bool);
            }
            else
            {
              this.a.at();
            }
          }
        }
        else {
          ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject2, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
        }
      }
      else {
        ChatActivityUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (String)localObject2, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.4
 * JD-Core Version:    0.7.0.1
 */