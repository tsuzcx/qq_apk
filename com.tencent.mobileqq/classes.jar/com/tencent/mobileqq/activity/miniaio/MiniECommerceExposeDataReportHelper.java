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
    return new int[] { 4, 6, 14, 20, 13 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 4: 
    case 6: 
    case 20: 
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic = new AIOMessageRecordExposeLogic();
          return;
        } while (this.b);
        this.b = true;
        ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 800L);
        return;
      } while (!this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic.b(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic = null;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper
 * JD-Core Version:    0.7.0.1
 */