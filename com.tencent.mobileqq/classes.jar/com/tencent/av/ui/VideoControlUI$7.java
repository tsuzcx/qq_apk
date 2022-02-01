package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class VideoControlUI$7
  implements DialogInterface.OnClickListener
{
  VideoControlUI$7(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface arg1, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {}
    long l;
    do
    {
      do
      {
        return;
        QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d, 1, "showPermissionDialog.gotoSetting, seq[" + this.jdField_a_of_type_Long + "]");
        if ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.m) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g != null)) {
          ReportController.b(null, "CliOper", "", "", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g, this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g, 0, 0, "", "", this.jdField_a_of_type_ComTencentAvUiVideoControlUI.h, "");
        }
        UITools.a(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.a());
      } while ((this.jdField_a_of_type_ComTencentAvUiVideoControlUI.z != 2) && (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.z != 1));
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.b.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.jdField_a_of_type_Long) });
      l = Long.valueOf(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue();
      paramInt = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().a(l, 1);
    } while (paramInt == -1);
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().c.remove(paramInt);
    synchronized (this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().d)
    {
      paramInt = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().b(l, 1);
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().d.remove(paramInt);
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.jdField_a_of_type_ComTencentAvVideoController.a().c();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.7
 * JD-Core Version:    0.7.0.1
 */