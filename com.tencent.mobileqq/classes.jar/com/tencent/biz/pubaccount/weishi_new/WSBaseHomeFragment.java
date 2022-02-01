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
      paramView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165327));
    }
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368216);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView = ((XRecyclerView)paramView.findViewById(2131381258));
    paramView = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView;
    if (paramView != null)
    {
      paramView = paramView.getLoadMoreLayoutHelper();
      if (paramView != null) {
        paramView.setPreLoaderCount(12);
      }
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(new WSBaseHomeFragment.1(this));
      paramView = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.getRecyclerView();
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
  
  public void a(int paramInt, String paramString) {}
  
  protected abstract void a(Bundle paramBundle);
  
  protected abstract void a(View paramView);
  
  protected abstract void a(XRecyclerView paramXRecyclerView, int paramInt);
  
  protected abstract void a(XRecyclerView paramXRecyclerView, boolean paramBoolean);
  
  protected abstract void b();
  
  public void c()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && (!localView.isShown())) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void d() {}
  
  public abstract void e();
  
  public void f()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && (localView.isShown())) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = getBaseActivity();
    if (getArguments() != null) {
      a(getArguments());
    }
    if (a() != -1) {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    } else {
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560015, paramViewGroup, false);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b(this.jdField_a_of_type_AndroidViewView);
    a(this.jdField_a_of_type_AndroidViewView);
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseHomeFragment
 * JD-Core Version:    0.7.0.1
 */