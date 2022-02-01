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
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      StatisticAssist.a(this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.getApplication().getApplicationContext(), this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.getCurrentAccountUin(), "dl_ckclearmsg");
      paramView = (DataLineHandler)this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      paramView.a(32, true);
      paramView.e();
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.app.getMessageFacade().a(this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.a).a();
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.getIntent().putExtra("clear_flag", true);
      paramView = this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity;
      paramView.setResult(-1, paramView.getIntent());
      this.jdField_a_of_type_ComDatalineActivitiesLiteAdvanceActivity.finish();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteAdvanceActivity.4
 * JD-Core Version:    0.7.0.1
 */