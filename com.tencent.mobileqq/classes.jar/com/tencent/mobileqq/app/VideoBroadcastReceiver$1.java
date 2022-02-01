package com.tencent.mobileqq.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.VideoMsgTools;

class VideoBroadcastReceiver$1
  implements DialogInterface.OnClickListener
{
  VideoBroadcastReceiver$1(VideoBroadcastReceiver paramVideoBroadcastReceiver, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    VideoMsgTools.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean ^ true, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Boolean, null, true, new Object[0]);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    DataReport.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.VideoBroadcastReceiver.1
 * JD-Core Version:    0.7.0.1
 */