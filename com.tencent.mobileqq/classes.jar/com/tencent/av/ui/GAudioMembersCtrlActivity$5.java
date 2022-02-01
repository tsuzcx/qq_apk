package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class GAudioMembersCtrlActivity$5
  implements View.OnClickListener
{
  GAudioMembersCtrlActivity$5(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().X) {
      if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().j == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005C28", "0X8005C28", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().X) {
        bool = true;
      }
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.b(bool);
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().c("OnClick", bool);
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a();
      this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.b();
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().j != 3000) {
          continue;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005C23", "0X8005C23", 0, 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().j == 1)
        {
          ReportController.b(null, "CliOper", "", "", "0X8005C27", "0X8005C27", 0, 0, "", "", "", "");
          continue;
        }
        if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().j != 3000) {
          continue;
        }
        ReportController.b(null, "CliOper", "", "", "0X8005C22", "0X8005C22", 0, 0, "", "", "", "");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          localThrowable.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.5
 * JD-Core Version:    0.7.0.1
 */