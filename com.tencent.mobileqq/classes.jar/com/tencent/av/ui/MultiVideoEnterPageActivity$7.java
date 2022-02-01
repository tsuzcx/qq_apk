package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$7
  implements DialogInterface.OnClickListener
{
  MultiVideoEnterPageActivity$7(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.b()) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    Object localObject = this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity;
    ((MultiVideoEnterPageActivity)localObject).b = ((MultiVideoEnterPageActivity)localObject).jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.c, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.f, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_Long);
    localObject = this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kickOutUsers begin, mGAudioRoomId[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.b);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a(1, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.c, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.f, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_Long);
    ReportController.b(null, "CliOper", "", "", "0X8009E2A", "0X8009E2A", 0, 0, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.7
 * JD-Core Version:    0.7.0.1
 */