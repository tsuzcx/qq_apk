package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeLogic;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class MiniECommerceExposeDataReportHelper
  implements ILifeCycleHelper
{
  private AIOMessageRecordExposeLogic jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic;
  private MiniPie jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MiniECommerceExposeDataReportHelper.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  MiniECommerceExposeDataReportHelper(MiniPie paramMiniPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie = paramMiniPie;
  }
  
  private ListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  }
  
  public String getTag()
  {
    return "ECommerceExposeDataReportHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 15, 20, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 7)
      {
        if (paramInt != 15)
        {
          if (paramInt != 20) {
            return;
          }
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic.b(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          }
        }
        else
        {
          this.jdField_a_of_type_Boolean = false;
          this.b = false;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic = null;
          ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
      }
      else if (!this.b)
      {
        this.b = true;
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 800L);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic = new AIOMessageRecordExposeLogic();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper
 * JD-Core Version:    0.7.0.1
 */