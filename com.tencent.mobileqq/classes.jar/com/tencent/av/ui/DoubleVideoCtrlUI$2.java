package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.mobileqq.statistics.ReportController;

class DoubleVideoCtrlUI$2
  implements Runnable
{
  DoubleVideoCtrlUI$2(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentAvVideoController != null) && (!this.this$0.jdField_a_of_type_ComTencentAvVideoController.a().l()))
    {
      TipsUtil.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1049);
      ReportController.b(null, "CliOper", "", "", "0X8009D02", "0X8009D02", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.2
 * JD-Core Version:    0.7.0.1
 */