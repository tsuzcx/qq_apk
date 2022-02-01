package com.tencent.mobileqq.activity.aio.anim;

import afee;
import afei;
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
    if (localIterator.hasNext())
    {
      Object localObject = (afee)localIterator.next();
      long l2 = ((afee)localObject).a();
      if (l2 >= 0L)
      {
        if (l1 < 0L) {}
        for (l1 = l2;; l1 = Math.min(l1, l2)) {
          break;
        }
      }
      localIterator.remove();
      if (QLog.isColorLevel()) {
        QLog.d("FloorJumperSet", 2, "removed businessId:" + ((afee)localObject).c);
      }
      if (((afee)localObject).c == 1)
      {
        localObject = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (((afee)((Iterator)localObject).next()).c != 1);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a != null)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a.b();
      }
      break;
      if (l1 >= 0L)
      {
        if (FloorJumperSet.a(this.this$0) == 0L) {
          this.this$0.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this, l1);
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
      }
      do
      {
        return;
        this.this$0.d();
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
      } while (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a == null);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumperSet.Animator
 * JD-Core Version:    0.7.0.1
 */