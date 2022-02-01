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
    Iterator localIterator = this.this$0.d.iterator();
    long l2 = -1L;
    while (localIterator.hasNext())
    {
      AnimationPath.Values localValues = (AnimationPath.Values)localIterator.next();
      long l1;
      if (l3 < localValues.j)
      {
        l1 = localValues.j - l3;
      }
      else if (!localValues.k)
      {
        l1 = localValues.m.a(localValues, localValues.l.getWidth(), localValues.l.getHeight(), this.this$0.a.getWidth(), this.this$0.a.getHeight());
        localValues.k = true;
      }
      else
      {
        l1 = localValues.m.a(l3 - localValues.j, localValues);
      }
      if (l1 >= 0L)
      {
        if (l2 >= 0L) {
          l1 = Math.min(l2, l1);
        }
        this.this$0.a(localValues.l, localValues);
        l2 = l1;
      }
      else
      {
        this.this$0.a.removeViewInLayout(localValues.l);
        localIterator.remove();
      }
    }
    if (l2 >= 0L)
    {
      this.this$0.b.postDelayed(this, l2);
      this.this$0.a.invalidate();
      return;
    }
    this.this$0.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.PathAnimation.Animator
 * JD-Core Version:    0.7.0.1
 */