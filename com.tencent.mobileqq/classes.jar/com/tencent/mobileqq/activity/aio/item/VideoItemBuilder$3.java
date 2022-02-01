package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class VideoItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    if (paramInt != 0) {
      return;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo.isVideo;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo.type;
    VideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool, paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForVideo.isVideo)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005642", "0X8005642", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005243", "0X8005243", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.VideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */