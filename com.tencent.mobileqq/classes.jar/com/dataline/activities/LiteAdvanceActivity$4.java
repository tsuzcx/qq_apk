package com.dataline.activities;

import android.content.Intent;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

class LiteAdvanceActivity$4
  implements ActionSheet.OnButtonClickListener
{
  LiteAdvanceActivity$4(LiteAdvanceActivity paramLiteAdvanceActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      StatisticAssist.a(this.b.app.getApplication().getApplicationContext(), this.b.app.getCurrentAccountUin(), "dl_ckclearmsg");
      paramView = (DataLineHandler)this.b.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      paramView.a(32, true);
      paramView.l();
      this.b.app.getMessageFacade().d(this.b.b).h();
      this.b.getIntent().putExtra("clear_flag", true);
      paramView = this.b;
      paramView.setResult(-1, paramView.getIntent());
      this.b.finish();
    }
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity.4
 * JD-Core Version:    0.7.0.1
 */