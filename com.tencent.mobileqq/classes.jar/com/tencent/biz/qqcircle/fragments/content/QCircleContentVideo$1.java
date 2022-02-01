package com.tencent.biz.qqcircle.fragments.content;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;

class QCircleContentVideo$1
  implements Runnable
{
  QCircleContentVideo$1(QCircleContentVideo paramQCircleContentVideo) {}
  
  public void run()
  {
    if ((QCircleContentVideo.a(this.this$0) != null) && (QCircleContentVideo.a(this.this$0).b != null))
    {
      QCircleContentVideo.a(this.this$0).b.animate().alpha(1.0F);
      QCircleContentVideo.a(this.this$0).b.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo.1
 * JD-Core Version:    0.7.0.1
 */