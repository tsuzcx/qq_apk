package com.tencent.biz.pubaccount.weishi_new;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSView;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;

public abstract class WSBaseHomeFragment<V extends IWSBaseView, P extends IWSPresenter<V>, M>
  extends WSBaseFragment<V, P>
  implements IWSView<M>
{
  protected Context a;
  protected View a;
  protected XRecyclerView a;
  private View b;
  protected boolean c = false;
  
  private void b(View paramView)
  {
    if (this.jdField_b_of_type_Boolean) {
      paramView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165357));
    }
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368468);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView = ((XRecyclerView)paramView.findViewById(2131382056));
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
      if (paramView != null) {
        paramView.a(12);
      }
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(new WSBaseHomeFragment.1(this));
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
  
  protected abstract BaseAdapter a();
  
  protected abstract void a();
  
  public void a(int paramInt, String paramString) {}
  
  protected abstract void a(Bundle paramBundle);
  
  protected abstract void a(View paramView);
  
  protected abstract void a(XRecyclerView paramXRecyclerView, int paramInt);
  
  protected abstract void a(XRecyclerView paramXRecyclerView, boolean paramBoolean);
  
  public void c()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (!this.jdField_b_of_type_AndroidViewView.isShown())) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void d() {}
  
  public abstract void e();
  
  public void f()
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
    for (this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);; this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560131, paramViewGroup, false))
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
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseHomeFragment
 * JD-Core Version:    0.7.0.1
 */