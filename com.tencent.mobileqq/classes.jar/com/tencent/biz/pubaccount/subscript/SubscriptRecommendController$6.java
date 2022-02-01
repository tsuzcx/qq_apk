package com.tencent.biz.pubaccount.subscript;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class SubscriptRecommendController$6
  implements View.OnClickListener
{
  SubscriptRecommendController$6(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005733", "0X8005733", 0, 0, "", "", "", "");
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006430", "0X8006430", 0, 0, "", "", "", "");
    Object localObject = this.a;
    ((SubscriptRecommendController)localObject).jdField_a_of_type_Boolean = false;
    ((SubscriptRecommendController)localObject).jdField_a_of_type_AndroidWidgetImageButton.setEnabled(false);
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.6.1(this));
    if (this.a.jdField_a_of_type_Int == 1)
    {
      SubscriptRecommendController.a(this.a);
    }
    else if (this.a.jdField_a_of_type_Int == 3)
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(SubscriptFeedsActivity.class);
      if ((localObject != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && ((this.a.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof SubscriptFeedsActivity))) {
        ((MqqHandler)localObject).sendEmptyMessage(1006);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.6
 * JD-Core Version:    0.7.0.1
 */