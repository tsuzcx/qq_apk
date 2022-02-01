package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;

class SimpleSlidingIndicator$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SimpleSlidingIndicator$4(SimpleSlidingIndicator paramSimpleSlidingIndicator) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT < 16) {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    } else {
      this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    Object localObject1 = this.a;
    ((SimpleSlidingIndicator)localObject1).b(((SimpleSlidingIndicator)localObject1).e);
    localObject1 = this.a;
    ((SimpleSlidingIndicator)localObject1).c(((SimpleSlidingIndicator)localObject1).e);
    localObject1 = this.a.a.getChildAt(this.a.e);
    if (localObject1 != null)
    {
      this.a.h = ((View)localObject1).getLeft();
      if (((View)localObject1).getMeasuredWidth() == 0)
      {
        Object localObject2 = this.a;
        ((SimpleSlidingIndicator)localObject2).h = (SimpleSlidingIndicator.a((SimpleSlidingIndicator)localObject2) + (SimpleSlidingIndicator.b(this.a) + SimpleSlidingIndicator.c(this.a)) * this.a.e);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onGlobalLayout, x[");
          ((StringBuilder)localObject2).append(this.a.h);
          ((StringBuilder)localObject2).append("], size[");
          ((StringBuilder)localObject2).append(this.a.a.getChildCount());
          ((StringBuilder)localObject2).append("], left[");
          ((StringBuilder)localObject2).append(((View)localObject1).getLeft());
          ((StringBuilder)localObject2).append("], width[");
          ((StringBuilder)localObject2).append(((View)localObject1).getMeasuredWidth());
          ((StringBuilder)localObject2).append("], pos[");
          ((StringBuilder)localObject2).append(this.a.e);
          ((StringBuilder)localObject2).append("], CPlr");
          ((StringBuilder)localObject2).append(SimpleSlidingIndicator.a(this.a));
          ((StringBuilder)localObject2).append("]");
          QLog.i("SimpleSlidingIndicator", 2, ((StringBuilder)localObject2).toString());
        }
      }
      this.a.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.4
 * JD-Core Version:    0.7.0.1
 */