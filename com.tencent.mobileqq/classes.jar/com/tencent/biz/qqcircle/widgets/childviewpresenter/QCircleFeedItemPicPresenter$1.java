package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleFeedItemPicPresenter$1
  implements ViewPager.OnPageChangeListener
{
  QCircleFeedItemPicPresenter$1(QCircleFeedItemPicPresenter paramQCircleFeedItemPicPresenter) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QCircleFeedItemPicPresenter.access$000(this.a, paramInt);
    if ((this.a.getFeedData() != null) && (this.a.getContainerView() != null)) {
      QCircleFeedDataCenter.a().a(this.a.getFeedData().id.get(), paramInt);
    }
    QCircleFeedItemPicPresenter.access$100(this.a, paramInt);
    QCircleFeedItemPicPresenter.access$200(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemPicPresenter.1
 * JD-Core Version:    0.7.0.1
 */