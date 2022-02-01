package com.tencent.biz.qqcircle.widgets;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.lang.ref.WeakReference;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;

class QCirclePushRankTopView$PushRankTopViewPagerListener
  implements ViewPager.OnPageChangeListener
{
  private WeakReference<QCirclePushRankTopView> a;
  
  public QCirclePushRankTopView$PushRankTopViewPagerListener(QCirclePushRankTopView paramQCirclePushRankTopView)
  {
    this.a = new WeakReference(paramQCirclePushRankTopView);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (QCirclePushRankTopView)((WeakReference)localObject).get();
      if (localObject != null)
      {
        paramInt %= QCirclePushRankTopView.a((QCirclePushRankTopView)localObject).a().size();
        if (QCirclePushRankTopView.b((QCirclePushRankTopView)localObject) != null) {
          QCirclePushRankTopView.b((QCirclePushRankTopView)localObject).a(paramInt);
        }
        QCirclePushRankTopView.a((QCirclePushRankTopView)localObject, paramInt);
        QCirclePushRankTopView.a((QCirclePushRankTopView)localObject, (QQCircleDitto.StItemContainer)QCirclePushRankTopView.c((QCirclePushRankTopView)localObject).get(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView.PushRankTopViewPagerListener
 * JD-Core Version:    0.7.0.1
 */