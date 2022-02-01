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
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (QLog.isColorLevel())
        {
          String str = this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("DialogInterfaceOnClickListener-->Wrong type.mode=");
          localStringBuilder.append(this.jdField_a_of_type_Int);
          QLog.e(str, 2, localStringBuilder.toString());
        }
        paramDialogInterface.dismiss();
        return;
      }
      paramDialogInterface.dismiss();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a().E, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a().f, 81);
    paramDialogInterface = this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity;
    paramDialogInterface.f(paramDialogInterface.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.DialogInterfaceOnClickListener
 * JD-Core Version:    0.7.0.1
 */