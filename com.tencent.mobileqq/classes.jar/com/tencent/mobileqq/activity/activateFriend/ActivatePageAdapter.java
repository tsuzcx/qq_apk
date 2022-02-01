package com.tencent.mobileqq.activity.activateFriend;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

public class ActivatePageAdapter
  extends PagerAdapter
{
  private ArrayList<ActivateBasePage> a = new ArrayList();
  private WeakReference<ViewPager> b = null;
  
  public ActivatePageAdapter(ViewPager paramViewPager)
  {
    this.b = new WeakReference(paramViewPager);
  }
  
  public ArrayList<ActivateBasePage> a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((ArrayList)localObject).isEmpty()) {
        return;
      }
      if (paramInt >= 0)
      {
        if (paramInt >= this.a.size()) {
          return;
        }
        localObject = (ActivateBasePage)this.a.get(paramInt);
        if (localObject != null) {
          ((ActivateBasePage)localObject).d();
        }
      }
    }
  }
  
  public void a(ActivateBasePage paramActivateBasePage)
  {
    this.a.add(paramActivateBasePage);
    notifyDataSetChanged();
  }
  
  public void a(ActivateBasePage paramActivateBasePage, int paramInt)
  {
    this.a.add(paramInt, paramActivateBasePage);
    notifyDataSetChanged();
  }
  
  public void b()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ActivateBasePage)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ActivateBasePage)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    WeakReference localWeakReference = this.b;
    if (localWeakReference != null)
    {
      if (localWeakReference.get() == null) {
        return;
      }
      ((ViewPager)this.b.get()).setAdapter(null);
      this.a.clear();
      ((ViewPager)this.b.get()).setAdapter(this);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivatePageAdapter", 4, "destroy item");
    }
    if (this.a.size() > paramInt)
    {
      ActivateBasePage localActivateBasePage = (ActivateBasePage)this.a.get(paramInt);
      if ((localActivateBasePage instanceof ReminderCardItemPage)) {
        localActivateBasePage.b();
      }
    }
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ActivateBasePage localActivateBasePage = (ActivateBasePage)this.a.get(paramInt);
    if (localActivateBasePage.getParent() != null)
    {
      ((ViewGroup)localActivateBasePage.getParent()).removeView(localActivateBasePage);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("instantiateItem page already has parent pos:");
        localStringBuilder.append(paramInt);
        QLog.i("ActivatePageAdapter", 2, localStringBuilder.toString());
      }
    }
    try
    {
      paramViewGroup.addView(localActivateBasePage);
      return localActivateBasePage;
    }
    catch (Exception paramViewGroup)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ActivatePageAdapter", 2, paramViewGroup.getMessage(), paramViewGroup);
      }
    }
    return localActivateBasePage;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivatePageAdapter
 * JD-Core Version:    0.7.0.1
 */