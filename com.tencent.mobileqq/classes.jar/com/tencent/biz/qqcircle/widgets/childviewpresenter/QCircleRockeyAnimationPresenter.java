package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.RequestPreloadViewListener;
import com.tencent.biz.qqcircle.widgets.QCircleRocketView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

public class QCircleRockeyAnimationPresenter
  extends QCircleBaseFeedChildPresenter
  implements LayoutPreLoader.RequestPreloadViewListener
{
  private static final String TAG = "QCircleRockeyAnimationPresenter";
  private QCircleRocketView mRockeyView;
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if ((this.mData != null) && ((this.mData instanceof FeedBlockData)))
    {
      paramObject = ((FeedBlockData)this.mData).b();
      this.mReportInfo.mDataPosition = this.mPos;
      this.mReportInfo.mFeed = ((FeedBlockData)this.mData).b();
      this.mReportInfo.mPlayScene = 1;
      QCircleRocketView localQCircleRocketView = this.mRockeyView;
      if (localQCircleRocketView != null)
      {
        localQCircleRocketView.setFeedId(paramObject.id.get());
        if ((this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.pageType != 1) && (this.mExtraTypeInfo.pageType != 10))
        {
          this.mRockeyView.setPageType(4);
          return;
        }
        this.mRockeyView.setPageType(1);
      }
    }
  }
  
  protected String getLogTag()
  {
    return "QCircleRockeyAnimationPresenter";
  }
  
  public void initView(View paramView)
  {
    LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440935), this);
  }
  
  public void onPreloadResult(View paramView)
  {
    this.mContainer = paramView;
    this.mRockeyView = ((QCircleRocketView)this.mContainer.findViewById(2131440956));
    if (this.mData != null) {
      bindData(this.mData, this.mPos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleRockeyAnimationPresenter
 * JD-Core Version:    0.7.0.1
 */