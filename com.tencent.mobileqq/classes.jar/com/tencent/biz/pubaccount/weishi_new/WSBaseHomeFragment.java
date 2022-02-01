package com.tencent.biz.pubaccount.weishi_new;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSView;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;

public abstract class WSBaseHomeFragment<V extends IWSBaseView, P extends IWSPresenter<V>, M>
  extends WSBaseFragment<V, P>
  implements IWSView<M>
{
  protected Context f;
  protected View g;
  protected XRecyclerView h;
  protected boolean i = false;
  private View j;
  
  private void b(View paramView)
  {
    if (this.e) {
      paramView.setBackgroundColor(this.f.getResources().getColor(2131165564));
    }
    this.j = paramView.findViewById(2131435084);
    this.h = ((XRecyclerView)paramView.findViewById(2131450306));
    paramView = this.h;
    if (paramView != null)
    {
      paramView = paramView.getLoadMoreLayoutHelper();
      if (paramView != null) {
        paramView.setPreLoaderCount(12);
      }
      this.h.setRefreshCallback(new WSBaseHomeFragment.1(this));
      paramView = this.h.getRecyclerView();
      if (p() != null) {
        paramView.setAdapter(p());
      }
      if (q() != null) {
        paramView.setLayoutManager(q());
      }
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  protected abstract void a(Bundle paramBundle);
  
  protected abstract void a(View paramView);
  
  protected abstract void a(XRecyclerView paramXRecyclerView, int paramInt);
  
  protected abstract void a(XRecyclerView paramXRecyclerView, boolean paramBoolean);
  
  protected boolean aN_()
  {
    if (WSComboExpHelper.a.a()) {
      return false;
    }
    return super.aN_();
  }
  
  protected int n()
  {
    return -1;
  }
  
  protected abstract void o();
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.f = getBaseActivity();
    if (getArguments() != null) {
      a(getArguments());
    }
    if (n() != -1) {
      this.g = paramLayoutInflater.inflate(n(), paramViewGroup, false);
    } else {
      this.g = paramLayoutInflater.inflate(2131626058, paramViewGroup, false);
    }
    return this.g;
  }
  
  public void onViewCreated(View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b(this.g);
    a(this.g);
    t();
  }
  
  protected abstract BaseAdapter p();
  
  protected abstract RecyclerView.LayoutManager q();
  
  public void r()
  {
    View localView = this.j;
    if ((localView != null) && (!localView.isShown())) {
      this.j.setVisibility(0);
    }
  }
  
  public void s() {}
  
  public abstract void t();
  
  public void u()
  {
    View localView = this.j;
    if ((localView != null) && (localView.isShown())) {
      this.j.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSBaseHomeFragment
 * JD-Core Version:    0.7.0.1
 */