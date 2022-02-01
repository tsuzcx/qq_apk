package com.tencent.biz.qqcircle.fragments.content;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.List;

class QCircleContentOperationView$3
  implements View.OnAttachStateChangeListener
{
  QCircleContentOperationView$3(QCircleContentOperationView paramQCircleContentOperationView, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    if ((this.b.f != null) && (this.b.f.getVisibility() == 0))
    {
      paramView = this.b.f.getHashTagList().iterator();
      while (paramView.hasNext())
      {
        String str = (String)paramView.next();
        QCircleContentOperationView.a(this.b, 16, 1, this.a, str);
      }
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.3
 * JD-Core Version:    0.7.0.1
 */