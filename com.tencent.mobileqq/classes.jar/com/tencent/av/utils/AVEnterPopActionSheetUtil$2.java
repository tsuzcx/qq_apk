package com.tencent.av.utils;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class AVEnterPopActionSheetUtil$2
  implements ActionSheet.OnButtonClickListener
{
  AVEnterPopActionSheetUtil$2(VideoActionSheet paramVideoActionSheet, int[] paramArrayOfInt, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    switch (this.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt > 0) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A518", "0X800A518", 0, paramInt, "", "", "", "");
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        AVEnterPopActionSheetUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        paramInt = 3;
      }
      else
      {
        AVEnterPopActionSheetUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true, this.jdField_a_of_type_Int, null);
        paramInt = 1;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
        {
          AVEnterPopActionSheetUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
          paramInt = 4;
        }
        else
        {
          AVEnterPopActionSheetUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, this.jdField_a_of_type_Int, null);
          paramInt = 2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.AVEnterPopActionSheetUtil.2
 * JD-Core Version:    0.7.0.1
 */