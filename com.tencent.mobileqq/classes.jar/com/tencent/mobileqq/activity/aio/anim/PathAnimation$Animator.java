package com.tencent.mobileqq.activity.aio.anim;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;

class PathAnimation$Animator
  implements Runnable
{
  private PathAnimation$Animator(PathAnimation paramPathAnimation) {}
  
  public void run()
  {
    long l3 = AnimationUtils.currentAnimationTimeMillis();
    Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
    long l2 = -1L;
    while (localIterator.hasNext())
    {
      AnimationPath.Values localValues = (AnimationPath.Values)localIterator.next();
      long l1;
      if (l3 < localValues.jdField_a_of_type_Long)
      {
        l1 = localValues.jdField_a_of_type_Long - l3;
      }
      else if (!localValues.b)
      {
        l1 = localValues.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAnimationPath.a(localValues, localValues.jdField_a_of_type_AndroidViewView.getWidth(), localValues.jdField_a_of_type_AndroidViewView.getHeight(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight());
        localValues.b = true;
      }
      else
      {
        l1 = localValues.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAnimationPath.a(l3 - localValues.jdField_a_of_type_Long, localValues);
      }
      if (l1 >= 0L)
      {
        if (l2 >= 0L) {
          l1 = Math.min(l2, l1);
        }
        this.this$0.a(localValues.jdField_a_of_type_AndroidViewView, localValues);
        l2 = l1;
      }
      else
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(localValues.jdField_a_of_type_AndroidViewView);
        localIterator.remove();
      }
    }
    if (l2 >= 0L)
    {
      this.this$0.jdField_a_of_type_ComTencentWidgetListView.postDelayed(this, l2);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
      return;
    }
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.PathAnimation.Animator
 * JD-Core Version:    0.7.0.1
 */