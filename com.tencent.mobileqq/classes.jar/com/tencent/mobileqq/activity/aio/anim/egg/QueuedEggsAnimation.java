package com.tencent.mobileqq.activity.aio.anim.egg;

import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.AIOAnimator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Queue;

public abstract class QueuedEggsAnimation<A>
  extends AIOAnimationConatiner.AIOAnimator
{
  protected QueuedEggsAnimation<A>.QueueDriver a;
  protected final Queue<A> a;
  protected volatile boolean a;
  protected int b;
  protected final Queue<A> b;
  protected int c;
  protected final Queue<A> c;
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilQueue.clear();
    this.b.clear();
    this.c.clear();
  }
  
  protected abstract A a(Object... paramVarArgs);
  
  protected abstract void a(A paramA);
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    paramVarArgs = a(paramVarArgs);
    this.jdField_a_of_type_JavaUtilQueue.add(paramVarArgs);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[start] prepare animation: ");
    localStringBuilder.append(paramVarArgs.toString());
    QLog.i("QueuedEggsAnimation", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimEggQueuedEggsAnimation$QueueDriver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimEggQueuedEggsAnimation$QueueDriver = new QueuedEggsAnimation.QueueDriver(this, null);
      this.jdField_a_of_type_ComTencentWidgetListView.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimEggQueuedEggsAnimation$QueueDriver);
    }
    return false;
  }
  
  protected abstract void b(A paramA);
  
  protected void c()
  {
    QLog.i("QueuedEggsAnimation", 1, "[stop] animation stop, clear queue.");
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.egg.QueuedEggsAnimation
 * JD-Core Version:    0.7.0.1
 */