package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;

public class AVHelper
  implements ILifeCycleHelper
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver;
  private final BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  protected VideoStatusTipsBar a;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public AVHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramAIOContext.a();
    this.jdField_a_of_type_AndroidContentContext = paramAIOContext.a();
  }
  
  @NonNull
  public String getTag()
  {
    return "AVHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 1, 4, 10, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 4)
      {
        if (paramInt != 10)
        {
          if (paramInt != 15) {
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = null;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(2)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
      }
    }
    else if (this.jdField_a_of_type_ComTencentAvGaudioAVObserver == null) {
      this.jdField_a_of_type_ComTencentAvGaudioAVObserver = new AVHelper.MyAVObserver(this, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVHelper
 * JD-Core Version:    0.7.0.1
 */