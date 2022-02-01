package com.tencent.biz.qqcircle.fragments.content;

import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.image.URLImageView;

class QCircleContentVideo$2
  implements Runnable
{
  QCircleContentVideo$2(QCircleContentVideo paramQCircleContentVideo) {}
  
  public void run()
  {
    if ((QCircleContentVideo.a(this.this$0)) && (QCircleContentVideo.a(this.this$0) != null)) {
      QCircleContentVideo.b(this.this$0).setVisibility(8);
    }
    if ((QCircleContentVideo.a(this.this$0) != null) && (QCircleContentVideo.a(this.this$0).b != null))
    {
      QCircleContentVideo.a(this.this$0).b.setVisibility(0);
      QCircleContentVideo.a(this.this$0).b.animate().alpha(1.0E-004F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentVideo.2
 * JD-Core Version:    0.7.0.1
 */