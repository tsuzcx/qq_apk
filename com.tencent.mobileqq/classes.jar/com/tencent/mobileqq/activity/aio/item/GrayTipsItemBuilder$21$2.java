package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GrayTipsItemBuilder$21$2
  implements ActionSheet.OnButtonClickListener
{
  GrayTipsItemBuilder$21$2(GrayTipsItemBuilder.21 param21, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0) {
      return;
    }
    ChatActivityUtils.a(this.b.a.a, (Activity)this.b.a.c, this.b.a.d.a, this.b.a.d.b, true, true, null, null);
    ReportController.b(this.b.a.a, "CliOper", "", "", "0X8003F02", "0X8003F02", 0, 0, "", "", "", "");
    ReportController.b(this.b.a.a, "CliOper", "", "", "0X8005976", "0X8005976", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.21.2
 * JD-Core Version:    0.7.0.1
 */