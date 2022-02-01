package com.tencent.biz.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public abstract class TabLayout$TabAdapter<T>
  extends BaseAdapter
{
  protected Context a;
  protected List<T> b;
  protected TabLayout c;
  
  public TabLayout$TabAdapter(Context paramContext, List<T> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject2 = this.c.a(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = LayoutInflater.from(this.a).inflate(a(), paramViewGroup, false);
      if (c())
      {
        paramViewGroup = ((View)localObject1).getLayoutParams();
        paramViewGroup.width = e();
        ((View)localObject1).setLayoutParams(paramViewGroup);
      }
      ((View)localObject1).post(new TabLayout.TabAdapter.1(this, paramInt, (View)localObject1));
    }
    paramViewGroup = null;
    localObject2 = new TabLayout.TabAdapter.TabViewHolder((View)localObject1, null);
    ((View)localObject1).setTranslationX(0.0F);
    List localList = this.b;
    if (localList != null) {
      paramViewGroup = localList.get(paramInt);
    }
    a((TabLayout.TabAdapter.TabViewHolder)localObject2, paramViewGroup, paramInt);
    return localObject1;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(this.a).inflate(2131626280, paramViewGroup, false);
  }
  
  private int e()
  {
    return (this.c.getMeasuredWidth() - this.c.getPaddingLeft() - this.c.getPaddingRight()) / this.b.size();
  }
  
  protected abstract int a();
  
  protected abstract void a(TabLayout.TabAdapter.TabViewHolder paramTabViewHolder, T paramT, int paramInt);
  
  public void a(TabLayout paramTabLayout)
  {
    this.c = paramTabLayout;
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    return false;
  }
  
  protected void d() {}
  
  public int getCount()
  {
    boolean bool = b();
    int j = 0;
    int i = 0;
    if (bool)
    {
      localList = this.b;
      if (localList != null) {
        i = localList.size() + 1;
      }
      return i;
    }
    List localList = this.b;
    i = j;
    if (localList != null) {
      i = localList.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (b())
    {
      if (paramInt < getCount() - 1) {
        localView = a(paramInt, paramViewGroup);
      } else {
        localView = a(paramViewGroup);
      }
    }
    else {
      localView = a(paramInt, paramViewGroup);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.TabAdapter
 * JD-Core Version:    0.7.0.1
 */