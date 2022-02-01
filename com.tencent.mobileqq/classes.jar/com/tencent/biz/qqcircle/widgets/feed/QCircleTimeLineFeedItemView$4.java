package com.tencent.biz.qqcircle.widgets.feed;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.List;

class QCircleTimeLineFeedItemView$4
  implements View.OnAttachStateChangeListener
{
  QCircleTimeLineFeedItemView$4(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    if ((QCircleTimeLineFeedItemView.access$100(this.this$0) != null) && (QCircleTimeLineFeedItemView.access$100(this.this$0).getVisibility() == 0))
    {
      paramView = QCircleTimeLineFeedItemView.access$100(this.this$0).getHashTagList().iterator();
      while (paramView.hasNext())
      {
        String str = (String)paramView.next();
        QCircleTimeLineFeedItemView.access$000(this.this$0, 16, 1, this.val$feed, str);
      }
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView.4
 * JD-Core Version:    0.7.0.1
 */