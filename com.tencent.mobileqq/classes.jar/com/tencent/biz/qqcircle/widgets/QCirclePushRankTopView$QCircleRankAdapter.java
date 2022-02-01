package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;

class QCirclePushRankTopView$QCircleRankAdapter
  extends PagerAdapter
{
  Context a;
  private List<View> c;
  
  public QCirclePushRankTopView$QCircleRankAdapter(Context paramContext, List<View> paramList)
  {
    this.a = paramList;
    Object localObject;
    this.c = localObject;
  }
  
  public List<View> a()
  {
    return this.c;
  }
  
  public int b()
  {
    int i = getCount() / 2;
    return i - i % this.c.size();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return 360;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int i = this.c.size();
    Object localObject = this.b;
    localObject = QCirclePushRankTopView.b((QCirclePushRankTopView)localObject, (QQCircleDitto.StItemContainer)QCirclePushRankTopView.c((QCirclePushRankTopView)localObject).get(paramInt % i));
    paramViewGroup.addView((View)localObject);
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView.QCircleRankAdapter
 * JD-Core Version:    0.7.0.1
 */