package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$DialogInterfaceOnClickListener
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public MultiVideoEnterPageActivity$DialogInterfaceOnClickListener(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_JavaLangString, 2, "DialogInterfaceOnClickListener-->Wrong type.mode=" + this.jdField_a_of_type_Int);
      }
      paramDialogInterface.dismiss();
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.l()) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.e(true);
      }
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a().F, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a().g, 81);
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.f(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.f);
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.DialogInterfaceOnClickListener
 * JD-Core Version:    0.7.0.1
 */