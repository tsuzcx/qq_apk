package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader;
import com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.RequestPreloadViewListener;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StVideo;

public class QCircleFeedItemDoublePraisePresenter
  extends QCircleBaseFeedChildPresenter
  implements LayoutPreLoader.RequestPreloadViewListener
{
  private static final String TAG = "QCircleFeedItemDoublePraisePresenter";
  private QCircleDoublePraiseView mDoublePraiseView;
  private float mMaxRate = 1.777778F;
  private float mMinRate = 0.75F;
  private int mWidth = ImmersiveUtils.b();
  
  private void updateLayoutHeight(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed.type.get() != 3) {
      return;
    }
    int i = paramStFeed.video.width.get();
    int k = paramStFeed.video.height.get();
    int j = this.mWidth;
    if ((i != 0) && (k != 0))
    {
      float f1 = i / k;
      float f2 = this.mMaxRate;
      if (f1 >= f2)
      {
        i = (int)(j / f2);
      }
      else
      {
        if ((f1 > this.mMinRate) && (f1 <= f2))
        {
          f2 = j;
        }
        else
        {
          f2 = j;
          f1 = this.mMinRate;
        }
        i = (int)(f2 / f1);
      }
    }
    else
    {
      i = j;
    }
    this.mDoublePraiseView.getLayoutParams().width = j;
    this.mDoublePraiseView.getLayoutParams().height = i;
    paramStFeed = this.mDoublePraiseView;
    paramStFeed.setLayoutParams(paramStFeed.getLayoutParams());
  }
  
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
      QCircleDoublePraiseView localQCircleDoublePraiseView = this.mDoublePraiseView;
      if (localQCircleDoublePraiseView != null)
      {
        localQCircleDoublePraiseView.setFeed(paramObject);
        if (this.mExtraTypeInfo != null) {
          this.mDoublePraiseView.setPageType(this.mExtraTypeInfo.pageType);
        }
        this.mDoublePraiseView.setReportBean(getReportBean());
        updateLayoutHeight(paramObject);
      }
    }
  }
  
  protected String getLogTag()
  {
    return "QCircleFeedItemDoublePraisePresenter";
  }
  
  public void initView(View paramView)
  {
    LayoutPreLoader.a().a((ViewStub)paramView.findViewById(2131440930), this);
  }
  
  public void onPreloadResult(View paramView)
  {
    this.mContainer = paramView;
    this.mDoublePraiseView = ((QCircleDoublePraiseView)this.mContainer.findViewById(2131440922));
    if (this.mData != null) {
      bindData(this.mData, this.mPos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemDoublePraisePresenter
 * JD-Core Version:    0.7.0.1
 */