package com.tencent.biz.pubaccount.weishi_new;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import blsv;
import blte;
import bltq;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import ucj;
import ucm;
import ucq;
import uml;

public abstract class WSBaseHomeFragment<V extends ucj, P extends ucm<V>, M>
  extends WSBaseFragment<V, P>
  implements uml<M>
{
  public Context a;
  protected View a;
  public XRecyclerView a;
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
    if (this.jdField_b_of_type_Boolean) {
      paramView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165343));
    }
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368080);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView = ((XRecyclerView)paramView.findViewById(2131381508));
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
      if (paramView != null) {
        paramView.a(12);
      }
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(new ucq(this));
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
  
  protected abstract blsv a();
  
  public abstract void a();
  
  public void a(int paramInt, String paramString) {}
  
  protected abstract void a(Bundle paramBundle);
  
  protected abstract void a(View paramView);
  
  public abstract void a(XRecyclerView paramXRecyclerView, int paramInt);
  
  public abstract void a(XRecyclerView paramXRecyclerView, boolean paramBoolean);
  
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
    return ((bltq)localRecyclerViewWithHeaderFooter.getAdapter()).a();
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.jdField_b_of_type_AndroidViewView.isShown())) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public abstract void d();
  
  public void e()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.isShown())) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
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
    for (this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);; this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560004, paramViewGroup, false))
    {
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidViewView);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseHomeFragment
 * JD-Core Version:    0.7.0.1
 */