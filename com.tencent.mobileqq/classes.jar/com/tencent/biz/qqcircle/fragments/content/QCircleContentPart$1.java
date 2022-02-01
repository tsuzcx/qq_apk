package com.tencent.biz.qqcircle.fragments.content;

import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout;
import com.tencent.biz.qqcircle.transition.QCircleTransitionLayout.TransitionListner;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QCircleContentPart$1
  implements QCircleTransitionLayout.TransitionListner
{
  QCircleContentPart$1(QCircleContentPart paramQCircleContentPart) {}
  
  public void a()
  {
    if (QCircleContentPart.a(this.a) != null) {
      QCircleContentPart.a(this.a).a(0, 100);
    }
    if (QCircleContentPart.b(this.a) != null) {
      QCircleContentPart.b(this.a).animate().alpha(0.0F).setDuration(100L);
    }
    if (QCircleContentPart.c(this.a) != null) {
      QCircleContentPart.c(this.a).animate().alpha(0.0F).setDuration(100L);
    }
    if (QCircleContentPart.d(this.a) != null) {
      QCircleContentPart.d(this.a).animate().alpha(0.0F).setDuration(100L);
    }
    QCircleContentPart.a(this.a, 1, 0, 100);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleDanmakuEvent(7));
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a.a(paramFloat1, paramFloat2);
  }
  
  public void b()
  {
    if (QCircleContentPart.a(this.a) != null) {
      QCircleContentPart.a(this.a).a(1, 100);
    }
    if (QCircleContentPart.b(this.a) != null) {
      QCircleContentPart.b(this.a).animate().alpha(1.0F).setDuration(100L);
    }
    if (QCircleContentPart.c(this.a) != null) {
      QCircleContentPart.c(this.a).animate().alpha(1.0F).setDuration(100L);
    }
    if (QCircleContentPart.d(this.a) != null) {
      QCircleContentPart.d(this.a).animate().alpha(1.0F).setDuration(100L);
    }
    QCircleContentPart.a(this.a, 0, 1, 100);
    if (QCircleContentPart.e(this.a) != null) {
      QCircleContentPart.e(this.a).a(true);
    }
    SimpleEventBus.getInstance().dispatchEvent(new QCircleDanmakuEvent(8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.1
 * JD-Core Version:    0.7.0.1
 */