package com.tencent.mobileqq.activity.aio.messageexpose;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie;
import com.tencent.widget.ListView;

public class AIOMessageRecordExposeDataReportHelper
  implements ILifeCycleHelper
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private AIOMessageRecordExposeLogic jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic;
  private boolean jdField_a_of_type_Boolean = false;
  
  public AIOMessageRecordExposeDataReportHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private ListView a()
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if ((localBaseChatPie instanceof MultiForwardChatPie)) {
      return ((MultiForwardChatPie)localBaseChatPie).a();
    }
    return localBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  }
  
  public String getTag()
  {
    return "AIOMessageRecordExposeDataReportHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15, 20 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15)
        {
          if (paramInt != 20) {
            return;
          }
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
          }
        }
        else
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic = null;
        }
      }
      else
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMessageexposeAIOMessageRecordExposeLogic = new AIOMessageRecordExposeLogic();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeDataReportHelper
 * JD-Core Version:    0.7.0.1
 */