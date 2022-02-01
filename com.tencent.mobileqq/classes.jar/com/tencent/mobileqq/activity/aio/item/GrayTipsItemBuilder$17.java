package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.statistics.ReportController;

class GrayTipsItemBuilder$17
  implements FileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$17(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    PermisionPrivacyActivity.a(this.a.jdField_a_of_type_AndroidContentContext);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X800994C", "0X800994C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.17
 * JD-Core Version:    0.7.0.1
 */