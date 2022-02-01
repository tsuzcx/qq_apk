package com.tencent.biz.qqcircle.fragments.content;

import android.graphics.Point;
import android.view.MotionEvent;
import com.tencent.biz.qqcircle.events.QCircleContentImmersiveEvent;
import com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickLayout;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout;
import com.tencent.biz.qqcircle.widgets.QCircleDoubleClickLayout.OnTapClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QCircleContentHorizontalAdapter$1
  implements QCircleDoubleClickLayout.OnTapClickListener
{
  QCircleContentHorizontalAdapter$1(QCircleContentHorizontalAdapter paramQCircleContentHorizontalAdapter, QCircleDoubleClickLayout paramQCircleDoubleClickLayout) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    SimpleEventBus.getInstance().dispatchEvent(new QCircleContentImmersiveEvent(1));
    Object localObject = this.a;
    if ((localObject != null) && (((QCircleDoubleClickLayout)localObject).getChildCount() > 1))
    {
      int i = 0;
      while (i < this.a.getChildCount())
      {
        localObject = this.a.getChildAt(i);
        if ((localObject instanceof QCircleExpandStickLayout))
        {
          paramMotionEvent = new Point((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
          ((QCircleExpandStickLayout)localObject).a(paramMotionEvent);
          return;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentHorizontalAdapter.1
 * JD-Core Version:    0.7.0.1
 */