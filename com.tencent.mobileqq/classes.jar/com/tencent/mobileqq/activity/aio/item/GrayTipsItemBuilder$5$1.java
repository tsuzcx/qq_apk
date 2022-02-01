package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GrayTipsItemBuilder$5$1
  implements ActionSheet.OnButtonClickListener
{
  GrayTipsItemBuilder$5$1(GrayTipsItemBuilder.5 param5, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0) {
      return;
    }
    if (this.b.b.d.a == 3000) {}
    try
    {
      long l = Long.valueOf(this.b.b.d.b).longValue();
      paramView = (ITroopMngHandler)this.b.b.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
      if (paramView != null) {
        paramView.a(l);
      }
      ReportController.b(this.b.b.a, "P_CliOper", "Grp_discuss", "", "grey", "Clk", 0, 0, "", String.valueOf(this.b.a), "", "");
      return;
    }
    catch (NumberFormatException paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.5.1
 * JD-Core Version:    0.7.0.1
 */