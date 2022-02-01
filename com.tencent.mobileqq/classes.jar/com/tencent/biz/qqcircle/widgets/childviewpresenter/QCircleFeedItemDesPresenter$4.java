package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.Iterator;
import java.util.List;

class QCircleFeedItemDesPresenter$4
  implements View.OnAttachStateChangeListener
{
  QCircleFeedItemDesPresenter$4(QCircleFeedItemDesPresenter paramQCircleFeedItemDesPresenter, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    if ((QCircleFeedItemDesPresenter.access$200(this.b) != null) && (QCircleFeedItemDesPresenter.access$200(this.b).getVisibility() == 0))
    {
      paramView = QCircleFeedItemDesPresenter.access$200(this.b).getHashTagList().iterator();
      while (paramView.hasNext())
      {
        String str = (String)paramView.next();
        QCircleFeedItemDesPresenter.access$100(this.b, 16, 1, this.a, str);
      }
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemDesPresenter.4
 * JD-Core Version:    0.7.0.1
 */