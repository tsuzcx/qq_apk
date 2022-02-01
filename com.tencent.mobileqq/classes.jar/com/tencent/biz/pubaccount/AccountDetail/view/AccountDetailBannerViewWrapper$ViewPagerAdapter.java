package com.tencent.biz.pubaccount.AccountDetail.view;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AccountDetailBannerViewWrapper$ViewPagerAdapter
  extends PagerAdapter
{
  protected ArrayList<View> a = new ArrayList();
  
  public void a(ArrayList<View> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {}
  
  public int getCount()
  {
    if (this.a.size() <= 1) {
      return this.a.size();
    }
    return 2147483647;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int j = this.a.size();
    if (j > 1) {}
    for (int i = paramInt % j;; i = paramInt)
    {
      if (paramInt < 0) {
        i += j;
      }
      for (;;)
      {
        paramViewGroup.removeView((View)this.a.get(i));
        paramViewGroup.addView((View)this.a.get(i));
        if (QLog.isDevelopLevel()) {
          QLog.d("AccountDetailBannerViewWrapper", 2, "instantiateItem->pos:" + paramInt + ", newPos:" + i);
        }
        return this.a.get(i);
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == (View)paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailBannerViewWrapper.ViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */