package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper.MenuClickListener;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper.MenuType;
import com.tencent.biz.qqcircle.utils.QCircleCopyUtils;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleFeedItemDesPresenter$6
  implements QCirclePopupWindowHelper.MenuClickListener
{
  QCircleFeedItemDesPresenter$6(QCircleFeedItemDesPresenter paramQCircleFeedItemDesPresenter, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    if (paramInt == QCirclePopupWindowHelper.MenuType.c)
    {
      if ((QCircleFeedItemDesPresenter.access$200(this.b) != null) && (QCircleFeedItemDesPresenter.access$200(this.b).getSourceTextView() != null))
      {
        QCircleCopyUtils.a(this.b.mContainer.getContext(), QCircleFeedItemDesPresenter.access$200(this.b).getSourceTextView().getText().toString());
        return;
      }
      QCircleCopyUtils.a(this.b.mContainer.getContext(), this.a.content.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemDesPresenter.6
 * JD-Core Version:    0.7.0.1
 */