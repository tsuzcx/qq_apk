package com.tencent.biz.qqcircle.publish.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

class QCirclePublishContentPart$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QCirclePublishContentPart$2(QCirclePublishContentPart paramQCirclePublishContentPart, RelativeLayout paramRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    Rect localRect = new Rect();
    this.a.getWindowVisibleDisplayFrame(localRect);
    int i = localRect.height();
    if (QCirclePublishContentPart.a(this.b) - i > 150)
    {
      QCirclePublishContentPart.b(this.b).requestLayout();
      QCirclePublishContentPart.b(this.b).setVisibility(0);
    }
    else if ((i - QCirclePublishContentPart.a(this.b) > 150) && (!this.b.k))
    {
      QCirclePublishContentPart.b(this.b).setVisibility(8);
    }
    QCirclePublishContentPart.a(this.b, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCirclePublishContentPart.2
 * JD-Core Version:    0.7.0.1
 */