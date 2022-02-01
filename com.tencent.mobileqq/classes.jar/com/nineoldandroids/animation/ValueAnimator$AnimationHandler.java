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
    int i;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      paramMessage = (ArrayList)ValueAnimator.access$4().get();
      if ((localArrayList1.size() > 0) || (localArrayList2.size() > 0))
      {
        i = 0;
        label77:
        if (paramMessage.size() > 0) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      long l = AnimationUtils.currentAnimationTimeMillis();
      Object localObject = (ArrayList)ValueAnimator.access$7().get();
      paramMessage = (ArrayList)ValueAnimator.access$8().get();
      int k = localArrayList2.size();
      int j = 0;
      label119:
      if (j >= k)
      {
        k = ((ArrayList)localObject).size();
        if (k > 0)
        {
          j = 0;
          if (j < k) {
            break label335;
          }
          ((ArrayList)localObject).clear();
        }
        j = localArrayList1.size();
        k = 0;
        if (k < j) {
          break label372;
        }
        if (paramMessage.size() > 0) {
          j = 0;
        }
      }
      for (;;)
      {
        label139:
        label159:
        if (j >= paramMessage.size())
        {
          paramMessage.clear();
          if ((i == 0) || ((localArrayList1.isEmpty()) && (localArrayList2.isEmpty()))) {
            break;
          }
          sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.access$12() - (AnimationUtils.currentAnimationTimeMillis() - l)));
          return;
          localObject = (ArrayList)paramMessage.clone();
          paramMessage.clear();
          k = ((ArrayList)localObject).size();
          j = 0;
          if (j >= k) {
            break label77;
          }
          ValueAnimator localValueAnimator = (ValueAnimator)((ArrayList)localObject).get(j);
          if (ValueAnimator.access$5(localValueAnimator) == 0L) {
            ValueAnimator.access$6(localValueAnimator);
          }
          for (;;)
          {
            j += 1;
            break;
            localArrayList2.add(localValueAnimator);
          }
          localValueAnimator = (ValueAnimator)localArrayList2.get(j);
          if (ValueAnimator.access$9(localValueAnimator, l)) {
            ((ArrayList)localObject).add(localValueAnimator);
          }
          j += 1;
          break label119;
          label335:
          localValueAnimator = (ValueAnimator)((ArrayList)localObject).get(j);
          ValueAnimator.access$6(localValueAnimator);
          ValueAnimator.access$10(localValueAnimator, true);
          localArrayList2.remove(localValueAnimator);
          j += 1;
          break label139;
          label372:
          localObject = (ValueAnimator)localArrayList1.get(k);
          if (((ValueAnimator)localObject).animationFrame(l)) {
            paramMessage.add(localObject);
          }
          if (localArrayList1.size() == j)
          {
            k += 1;
            break label159;
          }
          j -= 1;
          paramMessage.remove(localObject);
          break label159;
        }
        ValueAnimator.access$11((ValueAnimator)paramMessage.get(j));
        j += 1;
      }
      i = 1;
      break label77;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.nineoldandroids.animation.ValueAnimator.AnimationHandler
 * JD-Core Version:    0.7.0.1
 */