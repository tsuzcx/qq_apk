package com.tencent.biz.qqcircle.fragments.content;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.image.URLImageView;

class QCircleContentVideo$3
  implements Runnable
{
  QCircleContentVideo$3(QCircleContentVideo paramQCircleContentVideo) {}
  
  public void run()
  {
    if ((this.this$0.o()) && (QCircleContentVideo.b(this.this$0) != null)) {
      QCircleContentVideo.c(this.this$0).setVisibility(8);
    }
    if ((QCircleContentVideo.a(this.this$0) != null) && (QCircleContentVideo.a(this.this$0).l != null))
    {
      QCircleContentVideo.a(this.this$0).l.setVisibility(0);
      if (QCircleContentVideo.d(this.this$0))
      {
        QCircleContentVideo.a(this.this$0, false);
        QCircleContentVideo.a(this.this$0).l.setAlpha(1.0E-004F);
        return;
      }
      QCircleContentVideo.a(this.this$0).l.animate().alpha(1.0E-004F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo.3
 * JD-Core Version:    0.7.0.1
 */