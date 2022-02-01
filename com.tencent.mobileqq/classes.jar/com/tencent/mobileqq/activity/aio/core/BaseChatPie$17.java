package com.tencent.mobileqq.activity.aio.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseChatPie$17
  implements View.OnClickListener
{
  BaseChatPie$17(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    SharedPreferences.Editor localEditor = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    localEditor.putInt("funcall_tip_" + this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 4);
    localEditor.commit();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.17
 * JD-Core Version:    0.7.0.1
 */