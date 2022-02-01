package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;

class GrayTipsItemBuilder$10
  implements FileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$10(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 3);
    FileManagerUtil.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */