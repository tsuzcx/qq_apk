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
    Object localObject2 = null;
    Object localObject3 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt);
    Object localObject1 = localObject3;
    if (localObject3 == null)
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
    localObject3 = new TabLayout.TabAdapter.TabViewHolder((View)localObject1, null);
    ((View)localObject1).setTranslationX(0.0F);
    paramViewGroup = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      paramViewGroup = this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    a((TabLayout.TabAdapter.TabViewHolder)localObject3, paramViewGroup, paramInt);
    return localObject1;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560345, paramViewGroup, false);
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
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
    }
    notifyDataSetChanged();
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
    int i = 0;
    if (a()) {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        i = this.jdField_a_of_type_JavaUtilList.size() + 1;
      }
    }
    while (this.jdField_a_of_type_JavaUtilList == null) {
      return i;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
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
    if (a()) {
      if (paramInt < getCount() - 1) {
        localView = a(paramInt, paramViewGroup);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = a(paramViewGroup);
      continue;
      localView = a(paramInt, paramViewGroup);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.TabLayout.TabAdapter
 * JD-Core Version:    0.7.0.1
 */