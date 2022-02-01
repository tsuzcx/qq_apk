package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareManager;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DoubleVideoCtrlUI$21
  implements ActionSheet.OnButtonClickListener
{
  DoubleVideoCtrlUI$21(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong, View paramView, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        ((ScreenShareManager)this.d.al.c(18)).b();
        ScreenShareReportHelper.b("0X800B8A2");
      }
    }
    else
    {
      this.d.f(this.a, this.b);
      ScreenShareReportHelper.b("0X800AD8D");
    }
    this.c.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.21
 * JD-Core Version:    0.7.0.1
 */