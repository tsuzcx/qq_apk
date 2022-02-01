package com.tencent.mobileqq.activity.aio.anim;

import afdu;
import afdv;
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
    if (localIterator.hasNext())
    {
      afdv localafdv = (afdv)localIterator.next();
      long l1;
      if (l3 < localafdv.jdField_a_of_type_Long)
      {
        l1 = localafdv.jdField_a_of_type_Long - l3;
        label63:
        if (l1 < 0L) {
          break label195;
        }
        if (l2 >= 0L) {
          break label186;
        }
        label75:
        this.this$0.a(localafdv.jdField_a_of_type_AndroidViewView, localafdv);
      }
      for (;;)
      {
        l2 = l1;
        break;
        if (!localafdv.b)
        {
          l1 = localafdv.jdField_a_of_type_Afdu.a(localafdv, localafdv.jdField_a_of_type_AndroidViewView.getWidth(), localafdv.jdField_a_of_type_AndroidViewView.getHeight(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight());
          localafdv.b = true;
          break label63;
        }
        l1 = localafdv.jdField_a_of_type_Afdu.a(l3 - localafdv.jdField_a_of_type_Long, localafdv);
        break label63;
        label186:
        l1 = Math.min(l2, l1);
        break label75;
        label195:
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(localafdv.jdField_a_of_type_AndroidViewView);
        localIterator.remove();
        l1 = l2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.PathAnimation.Animator
 * JD-Core Version:    0.7.0.1
 */