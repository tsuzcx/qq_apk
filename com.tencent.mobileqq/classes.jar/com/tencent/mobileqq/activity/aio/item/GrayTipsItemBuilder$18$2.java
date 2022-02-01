package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GrayTipsItemBuilder$18$2
  implements ActionSheet.OnButtonClickListener
{
  GrayTipsItemBuilder$18$2(GrayTipsItemBuilder.18 param18, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0) {
      return;
    }
    if (this.b.a.d.a == 1006)
    {
      str = this.b.a.d.b;
      paramView = null;
    }
    else
    {
      paramView = this.b.a.d.b;
      str = null;
    }
    ChatActivityUtils.a(this.b.a.a, (Activity)this.b.a.c, this.b.a.d.a, paramView, this.b.a.d.e, str, true, this.b.a.d.c, true, true, null, "from_internal");
    String str = ChatActivityUtils.b(this.b.a.d.a);
    paramView = str;
    if (str == null) {
      paramView = "";
    }
    ReportController.b(this.b.a.a, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "13", paramView, "", "");
    ReportController.b(this.b.a.a, "CliOper", "", "", "0X8005974", "0X8005974", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.18.2
 * JD-Core Version:    0.7.0.1
 */