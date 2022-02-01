package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager;
import com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.widget.XPanelContainer;
import mqq.app.QQPermissionCallback;

class BaseChatPie$31
  implements QQPermissionCallback
{
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.a.a());
    ((SimpleUIAIOHelper)this.a.a(29)).a(2);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AudioTransitionAnimManager.a().a(this.a.jdField_a_of_type_AndroidContentContext);
    this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
    AIOPanelUtiles.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CAC", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.31
 * JD-Core Version:    0.7.0.1
 */