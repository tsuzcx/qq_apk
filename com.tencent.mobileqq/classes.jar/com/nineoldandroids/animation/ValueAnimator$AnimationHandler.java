package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

class ValueAnimator$AnimationHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    ArrayList localArrayList1 = (ArrayList)ValueAnimator.access$2().get();
    ArrayList localArrayList2 = (ArrayList)ValueAnimator.access$3().get();
    int i = paramMessage.what;
    int m = 0;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      i = 1;
    }
    else
    {
      paramMessage = (ArrayList)ValueAnimator.access$4().get();
      if ((localArrayList1.size() <= 0) && (localArrayList2.size() <= 0)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    for (;;)
    {
      ValueAnimator localValueAnimator;
      if (paramMessage.size() <= 0)
      {
        long l = AnimationUtils.currentAnimationTimeMillis();
        localObject = (ArrayList)ValueAnimator.access$7().get();
        paramMessage = (ArrayList)ValueAnimator.access$8().get();
        k = localArrayList2.size();
        j = 0;
        for (;;)
        {
          if (j >= k)
          {
            k = ((ArrayList)localObject).size();
            if (k > 0)
            {
              j = 0;
              for (;;)
              {
                if (j >= k)
                {
                  ((ArrayList)localObject).clear();
                  break;
                }
                localValueAnimator = (ValueAnimator)((ArrayList)localObject).get(j);
                ValueAnimator.access$6(localValueAnimator);
                ValueAnimator.access$10(localValueAnimator, true);
                localArrayList2.remove(localValueAnimator);
                j += 1;
              }
            }
            k = localArrayList1.size();
            j = 0;
            for (;;)
            {
              if (j >= k)
              {
                if (paramMessage.size() > 0)
                {
                  j = m;
                  for (;;)
                  {
                    if (j >= paramMessage.size())
                    {
                      paramMessage.clear();
                      break;
                    }
                    ValueAnimator.access$11((ValueAnimator)paramMessage.get(j));
                    j += 1;
                  }
                }
                if ((i != 0) && ((!localArrayList1.isEmpty()) || (!localArrayList2.isEmpty()))) {
                  sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.access$12() - (AnimationUtils.currentAnimationTimeMillis() - l)));
                }
                return;
              }
              localObject = (ValueAnimator)localArrayList1.get(j);
              if (((ValueAnimator)localObject).animationFrame(l)) {
                paramMessage.add(localObject);
              }
              if (localArrayList1.size() == k)
              {
                j += 1;
              }
              else
              {
                k -= 1;
                paramMessage.remove(localObject);
              }
            }
          }
          localValueAnimator = (ValueAnimator)localArrayList2.get(j);
          if (ValueAnimator.access$9(localValueAnimator, l)) {
            ((ArrayList)localObject).add(localValueAnimator);
          }
          j += 1;
        }
      }
      Object localObject = (ArrayList)paramMessage.clone();
      paramMessage.clear();
      int k = ((ArrayList)localObject).size();
      int j = 0;
      while (j < k)
      {
        localValueAnimator = (ValueAnimator)((ArrayList)localObject).get(j);
        if (ValueAnimator.access$5(localValueAnimator) == 0L) {
          ValueAnimator.access$6(localValueAnimator);
        } else {
          localArrayList2.add(localValueAnimator);
        }
        j += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nineoldandroids.animation.ValueAnimator.AnimationHandler
 * JD-Core Version:    0.7.0.1
 */