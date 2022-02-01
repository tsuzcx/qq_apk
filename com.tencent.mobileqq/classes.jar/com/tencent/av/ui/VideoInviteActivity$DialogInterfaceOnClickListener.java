package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class VideoInviteActivity$DialogInterfaceOnClickListener
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public VideoInviteActivity$DialogInterfaceOnClickListener(VideoInviteActivity paramVideoInviteActivity, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    long l = AudioHelper.b();
    String str = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.jdField_a_of_type_JavaLangString;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClick, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    paramInt = 1;
    QLog.w(str, 1, (String)localObject);
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      paramDialogInterface.dismiss();
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(l, true);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
      return;
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a().n();
    paramDialogInterface = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity;
    paramDialogInterface.d = true;
    paramDialogInterface = paramDialogInterface.a();
    if (!this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b) {
      paramInt = 2;
    }
    paramDialogInterface.a(l, paramInt, false, true);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.DialogInterfaceOnClickListener
 * JD-Core Version:    0.7.0.1
 */