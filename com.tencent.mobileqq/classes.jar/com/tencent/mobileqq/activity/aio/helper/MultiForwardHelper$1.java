package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class MultiForwardHelper$1
  implements ActionSheet.OnButtonClickListener
{
  MultiForwardHelper$1(MultiForwardHelper paramMultiForwardHelper, List paramList, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperMultiForwardHelper.a(this.jdField_a_of_type_JavaUtilList, 0);
        ECommerceDataReportUtil.a(MultiForwardHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperMultiForwardHelper), this.jdField_a_of_type_JavaUtilList, 3);
      }
    }
    else
    {
      MultiForwardHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperMultiForwardHelper, this.jdField_a_of_type_JavaUtilList);
      ECommerceDataReportUtil.a(MultiForwardHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperMultiForwardHelper), this.jdField_a_of_type_JavaUtilList, 3);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper.1
 * JD-Core Version:    0.7.0.1
 */