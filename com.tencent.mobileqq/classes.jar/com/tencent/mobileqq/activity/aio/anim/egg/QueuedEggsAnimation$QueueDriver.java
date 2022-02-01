package com.tencent.mobileqq.activity.aio.anim.egg;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.Queue;

class QueuedEggsAnimation$QueueDriver
  implements Runnable
{
  private QueuedEggsAnimation$QueueDriver(QueuedEggsAnimation paramQueuedEggsAnimation) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    ((QueuedEggsAnimation)localObject1).jdField_a_of_type_Boolean = true;
    if ((((QueuedEggsAnimation)localObject1).jdField_a_of_type_JavaUtilQueue.isEmpty()) && (this.this$0.jdField_b_of_type_JavaUtilQueue.isEmpty()) && (this.this$0.jdField_c_of_type_JavaUtilQueue.isEmpty()))
    {
      localObject1 = this.this$0;
      QueuedEggsAnimation.a((QueuedEggsAnimation)localObject1, QueuedEggsAnimation.a((QueuedEggsAnimation)localObject1));
      localObject1 = this.this$0;
      ((QueuedEggsAnimation)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioAnimEggQueuedEggsAnimation$QueueDriver = null;
      ((QueuedEggsAnimation)localObject1).jdField_a_of_type_Boolean = false;
      QLog.i("QueuedEggsAnimation", 1, "[QueueDriver] queues empty.");
      return;
    }
    if ((!this.this$0.jdField_a_of_type_JavaUtilQueue.isEmpty()) && (this.this$0.jdField_b_of_type_JavaUtilQueue.size() < this.this$0.jdField_b_of_type_Int))
    {
      localObject1 = this.this$0.jdField_a_of_type_JavaUtilQueue.remove();
      this.this$0.jdField_b_of_type_JavaUtilQueue.add(localObject1);
      this.this$0.b(localObject1);
      if ((!this.this$0.jdField_a_of_type_JavaUtilQueue.isEmpty()) && (this.this$0.jdField_b_of_type_JavaUtilQueue.size() < this.this$0.jdField_b_of_type_Int)) {
        QueuedEggsAnimation.a(this.this$0).postDelayed(this, this.this$0.jdField_c_of_type_Int);
      }
    }
    if (!this.this$0.jdField_c_of_type_JavaUtilQueue.isEmpty())
    {
      localObject1 = this.this$0.jdField_c_of_type_JavaUtilQueue.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        this.this$0.a(localObject2);
      }
      this.this$0.jdField_c_of_type_JavaUtilQueue.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.egg.QueuedEggsAnimation.QueueDriver
 * JD-Core Version:    0.7.0.1
 */