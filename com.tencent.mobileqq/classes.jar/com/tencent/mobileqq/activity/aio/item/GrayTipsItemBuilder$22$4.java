package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GrayTipsItemBuilder$22$4
  implements ActionSheet.OnButtonClickListener
{
  GrayTipsItemBuilder$22$4(GrayTipsItemBuilder.22 param22, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0) {
      return;
    }
    ChatActivityUtils.a(this.b.c.a, (Activity)this.b.c.c, this.b.c.d.a, this.b.c.d.b, true, true, null, null);
    ReportController.b(this.b.c.a, "CliOper", "", "", "0X8005976", "0X8005976", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.22.4
 * JD-Core Version:    0.7.0.1
 */