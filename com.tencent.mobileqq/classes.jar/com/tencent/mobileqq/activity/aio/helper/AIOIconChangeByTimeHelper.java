package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class AIOIconChangeByTimeHelper
  implements ILifeCycleHelper
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private AIOIconChangeByTimeHelper.TimeChangeReceiver jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOIconChangeByTimeHelper$TimeChangeReceiver;
  private RedpointObserver jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver = new AIOIconChangeByTimeHelper.3(this);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  AIOIconChangeByTimeHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public String getTag()
  {
    return "AIOIconChangeByTimeHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 8, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {}
      try
      {
        ((Runnable)localObject).run();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AIOIconChangeByTimeHelper", 1, localException, new Object[0]);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOIconChangeByTimeHelper$TimeChangeReceiver = new AIOIconChangeByTimeHelper.TimeChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, null);
      AIOIconChangeByTimeHelper.TimeChangeReceiver.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIOIconChangeByTimeHelper$TimeChangeReceiver);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.addObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
      localObject = new AIOIconChangeByTimeHelper.1(this);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
      localObject = new AIOIconChangeByTimeHelper.2(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper
 * JD-Core Version:    0.7.0.1
 */