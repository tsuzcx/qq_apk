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
  protected TabLayout a;
  protected List<T> a;
  
  public TabLayout$TabAdapter(Context paramContext, List<T> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(a(), paramViewGroup, false);
      if (b())
      {
        paramViewGroup = ((View)localObject1).getLayoutParams();
        paramViewGroup.width = b();
        ((View)localObject1).setLayoutParams(paramViewGroup);
      }
      ((View)localObject1).post(new TabLayout.TabAdapter.1(this, paramInt, (View)localObject1));
    }
    paramViewGroup = null;
    localObject2 = new TabLayout.TabAdapter.TabViewHolder((View)localObject1, null);
    ((View)localObject1).setTranslationX(0.0F);
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      paramViewGroup = localList.get(paramInt);
    }
    a((TabLayout.TabAdapter.TabViewHolder)localObject2, paramViewGroup, paramInt);
    return localObject1;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560233, paramViewGroup, false);
  }
  
  private int b()
  {
    return (this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getMeasuredWidth() - this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getPaddingLeft() - this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getPaddingRight()) / this.jdField_a_of_type_JavaUtilList.size();
  }
  
  protected abstract int a();
  
  protected void a() {}
  
  protected abstract void a(TabLayout.TabAdapter.TabViewHolder paramTabViewHolder, T paramT, int paramInt);
  
  public void a(TabLayout paramTabLayout)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout = paramTabLayout;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public int getCount()
  {
    boolean bool = a();
    int j = 0;
    int i = 0;
    if (bool)
    {
      localList = this.jdField_a_of_type_JavaUtilList;
      if (localList != null) {
        i = localList.size() + 1;
      }
      return i;
    }
    List localList = this.jdField_a_of_type_JavaUtilList;
    i = j;
    if (localList != null) {
      i = localList.size();
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
    if (a())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.TabAdapter
 * JD-Core Version:    0.7.0.1
 */