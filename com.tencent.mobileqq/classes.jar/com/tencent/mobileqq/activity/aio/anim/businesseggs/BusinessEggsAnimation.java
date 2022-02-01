package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.AIOAnimator;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationRule;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.utils.RandomUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BusinessEggsAnimation
  extends AIOAnimationConatiner.AIOAnimator
{
  private BusinessEggsAnimation.BusinessEggsQueueDriver jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsAnimation$BusinessEggsQueueDriver;
  private Map<Long, AioAnimationRule> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Queue<BusinessEggsElement> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private Queue<BusinessEggsElement> b = new LinkedList();
  private Queue<BusinessEggsElement> c = new LinkedList();
  
  public BusinessEggsAnimation(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private BusinessEggsElement a(Object... paramVarArgs)
  {
    BusinessEggsElement localBusinessEggsElement = new BusinessEggsElement(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this.jdField_a_of_type_ComTencentWidgetListView);
    try
    {
      Drawable localDrawable = (Drawable)paramVarArgs[0];
      paramVarArgs = (AioAnimationRule)paramVarArgs[1];
      long l = RandomUtils.a();
      this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), paramVarArgs);
      localBusinessEggsElement.a = l;
      localBusinessEggsElement.a(localDrawable);
      if (QLog.isColorLevel()) {
        QLog.d("BusinessEggsAnimation", 2, "[parseEggsAnimationInfo] sig: " + l + ", rule id: " + paramVarArgs.b);
      }
      return localBusinessEggsElement;
    }
    catch (Exception paramVarArgs) {}
    return null;
  }
  
  private void a(BusinessEggsElement paramBusinessEggsElement, ChatMessage paramChatMessage)
  {
    paramBusinessEggsElement.a(new BusinessEggsAnimation.1(this, paramBusinessEggsElement, paramChatMessage));
    paramBusinessEggsElement.a(new BusinessEggsAnimation.2(this));
  }
  
  private void a(Queue<BusinessEggsElement> paramQueue)
  {
    if (!paramQueue.isEmpty())
    {
      Iterator localIterator = paramQueue.iterator();
      while (localIterator.hasNext())
      {
        BusinessEggsElement localBusinessEggsElement = (BusinessEggsElement)localIterator.next();
        if (localBusinessEggsElement.a()) {
          localBusinessEggsElement.b();
        }
        localBusinessEggsElement.a(null);
        localBusinessEggsElement.a(null);
      }
      paramQueue.clear();
    }
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_JavaUtilQueue.isEmpty()) {
      this.jdField_a_of_type_JavaUtilQueue.clear();
    }
    a(this.b);
    if (!this.c.isEmpty()) {
      this.c.clear();
    }
  }
  
  public void a() {}
  
  public boolean a(int paramInt)
  {
    return paramInt == 8;
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  public boolean a(Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessEggsAnimation", 2, "[start] start animation");
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() >= 10) {}
    BusinessEggsElement localBusinessEggsElement;
    do
    {
      return false;
      localBusinessEggsElement = a(paramVarArgs);
    } while (localBusinessEggsElement == null);
    try
    {
      paramVarArgs = (ChatMessage)paramVarArgs[2];
      a(localBusinessEggsElement, paramVarArgs);
      this.jdField_a_of_type_JavaUtilQueue.add(localBusinessEggsElement);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsAnimation$BusinessEggsQueueDriver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsAnimation$BusinessEggsQueueDriver = new BusinessEggsAnimation.BusinessEggsQueueDriver(this, null);
        this.jdField_a_of_type_ComTencentWidgetListView.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsAnimation$BusinessEggsQueueDriver);
      }
      return true;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        QLog.e("BusinessEggsAnimation", 1, "[start] message is null");
        paramVarArgs = null;
      }
    }
  }
  
  public void b() {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BusinessEggsAnimation", 2, "[stop] stop animation");
    }
    e();
    this.jdField_a_of_type_ComTencentWidgetListView.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimBusinesseggsBusinessEggsAnimation$BusinessEggsQueueDriver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsAnimation
 * JD-Core Version:    0.7.0.1
 */