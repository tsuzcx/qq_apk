package com.tencent.biz.pubaccount.weishi_new;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bieg;
import biep;
import bifb;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import tat;
import taw;
import tba;
import tiv;

public abstract class WSBaseHomeFragment<V extends tat, P extends taw<V>, M>
  extends WSBaseFragment<V, P>
  implements tiv<M>
{
  public Context a;
  protected View a;
  public XRecyclerView a;
  protected boolean a;
  private View b;
  
  private int a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    int m = paramArrayOfInt.length;
    int j = 0;
    if (j < m)
    {
      int k = paramArrayOfInt[j];
      if (k <= i) {
        break label39;
      }
      i = k;
    }
    label39:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  private void b(View paramView)
  {
    this.b = paramView.findViewById(2131367696);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView = ((XRecyclerView)paramView.findViewById(2131380321));
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
      if (paramView != null) {
        paramView.a(12);
      }
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(new tba(this));
      paramView = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
      if (a() != null) {
        paramView.setAdapter(a());
      }
      if (a() != null) {
        paramView.setLayoutManager(a());
      }
    }
  }
  
  protected int a()
  {
    return -1;
  }
  
  protected abstract RecyclerView.LayoutManager a();
  
  protected abstract bieg a();
  
  public abstract void a();
  
  public void a(int paramInt) {}
  
  protected abstract void a(Bundle paramBundle);
  
  protected abstract void a(View paramView);
  
  public abstract void a(XRecyclerView paramXRecyclerView, int paramInt);
  
  public abstract void a(XRecyclerView paramXRecyclerView, boolean paramBoolean);
  
  public void a(boolean paramBoolean) {}
  
  protected int b()
  {
    int j = -1;
    int i = j;
    RecyclerView.LayoutManager localLayoutManager;
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a() != null)
      {
        localLayoutManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getLayoutManager();
        if (!(localLayoutManager instanceof StaggeredGridLayoutManager)) {
          break label71;
        }
        int[] arrayOfInt = new int[((StaggeredGridLayoutManager)localLayoutManager).getSpanCount()];
        ((StaggeredGridLayoutManager)localLayoutManager).findLastVisibleItemPositions(arrayOfInt);
        i = a(arrayOfInt);
      }
    }
    label71:
    do
    {
      return i;
      i = j;
    } while (!(localLayoutManager instanceof LinearLayoutManager));
    return ((LinearLayoutManager)localLayoutManager).findLastVisibleItemPosition();
  }
  
  protected int c()
  {
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter;
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      localRecyclerViewWithHeaderFooter = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
      if ((localRecyclerViewWithHeaderFooter != null) && (localRecyclerViewWithHeaderFooter.getAdapter() != null) && (a() != null)) {}
    }
    else
    {
      return 0;
    }
    return ((bifb)localRecyclerViewWithHeaderFooter.getAdapter()).a();
  }
  
  public abstract void c();
  
  public void d()
  {
    if ((this.b != null) && (this.b.getVisibility() == 0)) {
      this.b.setVisibility(8);
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    if (getArguments() != null) {
      a(getArguments());
    }
    if (a() != -1) {}
    for (this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);; this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559856, paramViewGroup, false)) {
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidViewView);
    c();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.jdField_a_of_type_Boolean = getUserVisibleHint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseHomeFragment
 * JD-Core Version:    0.7.0.1
 */