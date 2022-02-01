package com.tencent.av;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.statistics.ReportController;

class VideoController$43
  implements DialogInterface.OnClickListener
{
  VideoController$43(VideoController paramVideoController, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvVideoController.e();
      this.jdField_a_of_type_ComTencentAvVideoController.a("onHowling_click", this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, true, false, -1);
      this.jdField_a_of_type_ComTencentAvVideoController.a(-1L, paramInt, this.jdField_a_of_type_ComTencentAvVideoController.e());
      if (this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
        this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(108) });
      }
    }
    if (this.b) {
      this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_ComTencentAvUtilsTraeHelper.d();
    }
    ReportController.b(null, "CliOper", "", "", "0x8006993", "0x8006993", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.43
 * JD-Core Version:    0.7.0.1
 */