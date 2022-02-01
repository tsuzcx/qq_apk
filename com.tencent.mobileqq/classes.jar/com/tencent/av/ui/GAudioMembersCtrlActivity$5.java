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
    if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().M)
    {
      if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().k == 1) {
        ReportController.b(null, "CliOper", "", "", "0X8005C28", "0X8005C28", 0, 0, "", "", "", "");
      } else if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().k == 3000) {
        ReportController.b(null, "CliOper", "", "", "0X8005C23", "0X8005C23", 0, 0, "", "", "", "");
      }
    }
    else if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().k == 1) {
      ReportController.b(null, "CliOper", "", "", "0X8005C27", "0X8005C27", 0, 0, "", "", "", "");
    } else if (this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().k == 3000) {
      ReportController.b(null, "CliOper", "", "", "0X8005C22", "0X8005C22", 0, 0, "", "", "", "");
    }
    boolean bool = this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().M ^ true;
    this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.b(bool);
    this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a.a().c("OnClick", bool);
    this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.a();
    this.jdField_a_of_type_ComTencentAvUiGAudioMembersCtrlActivity.b();
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.5
 * JD-Core Version:    0.7.0.1
 */