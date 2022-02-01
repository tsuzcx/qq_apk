package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUI4Discussion$8
  implements DialogInterface.OnClickListener
{
  MultiVideoCtrlLayerUI4Discussion$8(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, VideoAppInterface paramVideoAppInterface, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showConfirmBoxToHangup, yes, mRelationId[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b);
    localStringBuilder.append("]");
    QLog.w(paramDialogInterface, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.j(0L);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("uin", String.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4, 0, 0, paramDialogInterface, null);
    if (!QAVHrMeeting.a(this.jdField_a_of_type_Int)) {
      MultiVideoCtrlLayerUI4Discussion.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.d, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.valueOf(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUI4Discussion.b), 3000, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695617));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.8
 * JD-Core Version:    0.7.0.1
 */