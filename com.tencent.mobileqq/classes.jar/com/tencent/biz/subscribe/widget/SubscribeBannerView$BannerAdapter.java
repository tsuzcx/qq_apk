package com.tencent.biz.subscribe.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class SubscribeBannerView$BannerAdapter
  extends PagerAdapter
{
  private final ArrayList a = new ArrayList();
  private final LinkedList<View> b = new LinkedList();
  private int c;
  
  protected abstract View a(View paramView, Object paramObject);
  
  protected abstract View a(ViewGroup paramViewGroup);
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if (this.a.size() > 1)
    {
      localObject = this.a;
      localObject = ((ArrayList)localObject).get(paramInt % ((ArrayList)localObject).size());
    }
    else
    {
      localObject = this.a.get(0);
    }
    View localView;
    if (this.b.size() > 0) {
      localView = (View)this.b.removeFirst();
    } else {
      localView = a(paramViewGroup);
    }
    paramViewGroup.addView(localView);
    return a(localView, localObject);
  }
  
  public ArrayList a()
  {
    return this.a;
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.a.clear();
    notifyDataSetChanged();
    if (paramArrayList != null)
    {
      this.a.addAll(paramArrayList);
      notifyDataSetChanged();
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (View)paramObject;
    paramViewGroup.removeView(paramObject);
    this.b.add(paramObject);
  }
  
  public int getCount()
  {
    if (this.a.size() > 1) {
      return 2147483647;
    }
    return this.a.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    int i = this.c;
    if (i > 0)
    {
      this.c = (i - 1);
      return -2;
    }
    return super.getItemPosition(paramObject);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void notifyDataSetChanged()
  {
    this.c = getCount();
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeBannerView.BannerAdapter
 * JD-Core Version:    0.7.0.1
 */