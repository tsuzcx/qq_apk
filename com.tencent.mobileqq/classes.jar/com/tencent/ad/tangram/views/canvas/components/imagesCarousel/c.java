package com.tencent.ad.tangram.views.canvas.components.imagesCarousel;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ad.tangram.log.AdLog;
import java.util.List;

public class c
  extends PagerAdapter
{
  private static final String TAG = "AdImagesCarouselPagerAdapter";
  private int pageLimit;
  private List<View> viewList;
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.viewList.get(paramInt));
  }
  
  public int getCount()
  {
    return this.viewList.size();
  }
  
  public float getPageWidth(int paramInt)
  {
    return 1.0F / this.pageLimit;
  }
  
  public View getView(int paramInt)
  {
    List localList = this.viewList;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return (View)this.viewList.get(paramInt);
    }
    return null;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("instantiateItem: position: ");
    localStringBuilder.append(paramInt);
    AdLog.i("AdImagesCarouselPagerAdapter", localStringBuilder.toString());
    paramViewGroup.addView((View)this.viewList.get(paramInt));
    return this.viewList.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setPageLimit(int paramInt)
  {
    this.pageLimit = paramInt;
  }
  
  public void setViewList(List<View> paramList)
  {
    this.viewList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.imagesCarousel.c
 * JD-Core Version:    0.7.0.1
 */