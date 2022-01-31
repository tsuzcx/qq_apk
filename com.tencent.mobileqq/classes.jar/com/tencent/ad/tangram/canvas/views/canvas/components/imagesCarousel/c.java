package com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ad.tangram.log.AdLog;
import java.util.List;

public class c
  extends PagerAdapter
{
  private static final String TAG = "AdImagesCarouselPagerAdapter";
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
    return 0.5F;
  }
  
  public View getView(int paramInt)
  {
    if ((this.viewList == null) || (paramInt < 0) || (paramInt >= this.viewList.size())) {
      return null;
    }
    return (View)this.viewList.get(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AdLog.i("AdImagesCarouselPagerAdapter", "instantiateItem: position: " + paramInt);
    paramViewGroup.addView((View)this.viewList.get(paramInt));
    return this.viewList.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setViewList(List<View> paramList)
  {
    this.viewList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.imagesCarousel.c
 * JD-Core Version:    0.7.0.1
 */