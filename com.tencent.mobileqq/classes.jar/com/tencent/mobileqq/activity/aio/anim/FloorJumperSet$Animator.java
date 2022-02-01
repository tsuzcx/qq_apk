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
    Iterator localIterator = this.this$0.f.iterator();
    long l1 = -1L;
    while (localIterator.hasNext())
    {
      FloorJumper localFloorJumper = (FloorJumper)localIterator.next();
      long l2 = localFloorJumper.e();
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
          localStringBuilder.append(localFloorJumper.h);
          QLog.d("FloorJumperSet", 2, localStringBuilder.toString());
        }
      }
    }
    if (l1 >= 0L)
    {
      if (FloorJumperSet.a(this.this$0) == 0L) {
        this.this$0.b.postDelayed(this, l1);
      }
      this.this$0.a.invalidate();
      return;
    }
    this.this$0.d();
    this.this$0.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumperSet.Animator
 * JD-Core Version:    0.7.0.1
 */