package com.tencent.biz.pubaccount.accountdetail.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
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
    int k = this.a.size();
    int i;
    if (k > 1) {
      i = paramInt % k;
    } else {
      i = paramInt;
    }
    int j = i;
    if (paramInt < 0) {
      j = i + k;
    }
    paramViewGroup.removeView((View)this.a.get(j));
    paramViewGroup.addView((View)this.a.get(j));
    if (QLog.isDevelopLevel())
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("instantiateItem->pos:");
      paramViewGroup.append(paramInt);
      paramViewGroup.append(", newPos:");
      paramViewGroup.append(j);
      QLog.d("AccountDetailBannerViewWrapper", 2, paramViewGroup.toString());
    }
    return this.a.get(j);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == (View)paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailBannerViewWrapper.ViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */