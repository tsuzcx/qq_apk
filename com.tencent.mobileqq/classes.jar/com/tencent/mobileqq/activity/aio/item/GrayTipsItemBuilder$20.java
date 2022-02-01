package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GrayTipsItemBuilder$20
  implements ActionSheet.OnButtonClickListener
{
  GrayTipsItemBuilder$20(GrayTipsItemBuilder paramGrayTipsItemBuilder, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0) {
      return;
    }
    if (this.b.d.a == 1006)
    {
      str = this.b.d.b;
      paramView = null;
    }
    else
    {
      paramView = this.b.d.b;
      str = null;
    }
    ChatActivityUtils.a(this.b.a, (Activity)this.b.c, this.b.d.a, paramView, this.b.d.e, str, true, this.b.d.c, true, true, null, null);
    String str = ChatActivityUtils.b(this.b.d.a);
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    ReportController.b(this.b.a, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "12", paramView, "", "");
    ReportController.b(this.b.a, "CliOper", "", "", "0X8005974", "0X8005974", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.20
 * JD-Core Version:    0.7.0.1
 */