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
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt != 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder$5.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {}
    try
    {
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder$5.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      paramView = (ITroopMngHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder$5.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
      if (paramView != null) {
        paramView.a(l);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder$5.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_discuss", "", "grey", "Clk", 0, 0, "", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder$5.jdField_a_of_type_Int), "", "");
      return;
    }
    catch (NumberFormatException paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.5.1
 * JD-Core Version:    0.7.0.1
 */