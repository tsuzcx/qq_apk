package com.tencent.mobileqq.activity.aio.anim;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

class FloorJumperSet$Animator
  implements Runnable
{
  private FloorJumperSet$Animator(FloorJumperSet paramFloorJumperSet) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
    long l1 = -1L;
    while (localIterator.hasNext())
    {
      Object localObject = (FloorJumper)localIterator.next();
      long l2 = ((FloorJumper)localObject).a();
      if (l2 >= 0L)
      {
        if (l1 < 0L) {
          l1 = l2;
        } else {
          l1 = Math.min(l1, l2);
        }
      }
      else
      {
        localIterator.remove();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removed businessId:");
          localStringBuilder.append(((FloorJumper)localObject).c);
          QLog.d("FloorJumperSet", 2, localStringBuilder.toString());
        }
        if (((FloorJumper)localObject).c == 1)
        {
          int j = 0;
          localObject = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
          do
          {
            i = j;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
          } while (((FloorJumper)((Iterator)localObject).next()).c != 1);
          int i = 1;
          if ((i == 0) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a != null)) {
            this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a.b();
          }
        }
      }
    }
    if (l1 >= 0L)
    {
      if (FloorJumperSet.a(this.this$0) == 0L) {
        this.this$0.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this, l1);
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
      return;
    }
    this.this$0.d();
    this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumperSet.Animator
 * JD-Core Version:    0.7.0.1
 */