package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUIBase$12
  implements DialogInterface.OnClickListener
{
  MultiVideoCtrlLayerUIBase$12(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.h()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.a().c() == -1)
    {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.r(this.jdField_a_of_type_Long);
    }
    else if (this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.d())
    {
      MultiVideoCtrlLayerUIBase.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase, true);
      this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.i(this.jdField_a_of_type_Long, 16777215);
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.d, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.12
 * JD-Core Version:    0.7.0.1
 */