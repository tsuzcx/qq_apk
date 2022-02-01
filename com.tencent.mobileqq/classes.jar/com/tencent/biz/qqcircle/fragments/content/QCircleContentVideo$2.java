package com.tencent.biz.qqcircle.fragments.content;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;

class QCircleContentVideo$2
  implements Runnable
{
  QCircleContentVideo$2(QCircleContentVideo paramQCircleContentVideo) {}
  
  public void run()
  {
    if ((QCircleContentVideo.a(this.this$0) != null) && (QCircleContentVideo.a(this.this$0).l != null))
    {
      QCircleContentVideo.a(this.this$0).l.animate().alpha(1.0F);
      QCircleContentVideo.a(this.this$0).l.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo.2
 * JD-Core Version:    0.7.0.1
 */