package com.tencent.mobileqq.apollo.debug.log;

import aktb;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class CmGameDebugLogPagerAdapter
  extends PagerAdapter
{
  List<aktb> a = new ArrayList();
  List<String> b = new ArrayList();
  
  public CmGameDebugLogPagerAdapter(List<aktb> paramList, List<String> paramList1)
  {
    this.a = paramList;
    this.b = paramList1;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public CharSequence getPageTitle(int paramInt)
  {
    return (CharSequence)this.b.get(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = ((aktb)this.a.get(paramInt)).a();
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogPagerAdapter
 * JD-Core Version:    0.7.0.1
 */