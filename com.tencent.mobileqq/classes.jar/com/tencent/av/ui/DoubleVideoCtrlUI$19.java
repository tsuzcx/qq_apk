package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareManager;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DoubleVideoCtrlUI$19
  implements ActionSheet.OnButtonClickListener
{
  DoubleVideoCtrlUI$19(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong, View paramView, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
      return;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.f(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidViewView);
      ScreenShareReportHelper.a("0X800AD8D");
      continue;
      ((ScreenShareManager)this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a.a(16)).b();
      ScreenShareReportHelper.a("0X800B8A2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.19
 * JD-Core Version:    0.7.0.1
 */