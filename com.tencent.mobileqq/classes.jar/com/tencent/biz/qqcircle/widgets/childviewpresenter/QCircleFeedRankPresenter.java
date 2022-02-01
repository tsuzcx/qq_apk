package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.rank.QCircleRankEventCollector;
import com.tencent.biz.qqcircle.rank.QCircleRawFeedItem;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.RequestPreloadViewListener;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

public class QCircleFeedRankPresenter
  extends QCircleBaseFeedChildPresenter
  implements LayoutPreLoader.RequestPreloadViewListener
{
  private TextView mTvRankInfo;
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if ((this.mData != null) && ((this.mData instanceof FeedBlockData)))
    {
      paramObject = ((FeedBlockData)this.mData).b();
      paramObject = QCircleRankEventCollector.getInstance().getRawFeedItem(paramObject.id.get());
      if (paramObject != null)
      {
        this.mTvRankInfo.setText(paramObject.toString());
        this.mTvRankInfo.setVisibility(0);
        return;
      }
      this.mTvRankInfo.setVisibility(8);
    }
  }
  
  protected String getLogTag()
  {
    return null;
  }
  
  public void initView(View paramView)
  {
    LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131441648), this);
  }
  
  public void onPreloadResult(View paramView)
  {
    this.mContainer = paramView;
    this.mTvRankInfo = ((TextView)this.mContainer.findViewById(2131448683));
    if (this.mData != null) {
      bindData(this.mData, this.mPos);
    }
  }
  
  public void setReportBean(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedRankPresenter
 * JD-Core Version:    0.7.0.1
 */