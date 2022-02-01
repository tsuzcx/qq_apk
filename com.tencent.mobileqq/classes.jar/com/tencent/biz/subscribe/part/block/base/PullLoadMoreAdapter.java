package com.tencent.biz.subscribe.part.block.base;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public abstract class PullLoadMoreAdapter<E>
  extends BaseListViewAdapter<E>
  implements RefreshHeaderView.OnRefreshListener
{
  private static String k = "PullLoadMoreAdapter";
  protected final Handler a = new Handler(Looper.getMainLooper());
  protected String b = HardCodeUtil.a(2131900456);
  protected String c = HardCodeUtil.a(2131900523);
  protected String d = HardCodeUtil.a(2131900522);
  protected String e = HardCodeUtil.a(2131895810);
  protected String f = HardCodeUtil.a(2131906624);
  protected String g = this.e;
  protected RecyclerView h;
  protected RecyclerView.LayoutManager i;
  private boolean l = false;
  private boolean m;
  private boolean n = true;
  private RecyclerView.ViewHolder o;
  private RefreshHeaderView p;
  private boolean q;
  private boolean r;
  private boolean s;
  private View t;
  private boolean u = true;
  
  protected abstract RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt);
  
  public void a() {}
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.i = paramLayoutManager;
  }
  
  protected abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (p())
    {
      this.r = false;
      this.l = paramBoolean2;
      this.q = paramBoolean1;
      String str;
      if (paramBoolean2) {
        str = this.e;
      } else {
        str = "";
      }
      this.g = str;
      boolean bool;
      if ((StringUtil.isEmpty(this.g)) && ((!paramBoolean2) || (this.t == null))) {
        bool = false;
      } else {
        bool = true;
      }
      this.s = bool;
      if (!paramBoolean1)
      {
        if ((NetworkUtils.isNetworkAvailable(BaseApplication.getContext()) ^ true)) {
          str = this.d;
        } else {
          str = this.c;
        }
        this.g = str;
        this.s = this.u;
      }
      ThreadManager.getUIHandler().post(new PullLoadMoreAdapter.1(this));
      QLog.i(k, 1, String.format("onLoadMoreCompleted: hashCode:%d ,isSuccess:%b, isFinish:%b, isShow:%b", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(this.s) }));
    }
  }
  
  protected RecyclerView.ViewHolder b(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.p == null)
    {
      this.p = new RefreshHeaderView(paramViewGroup.getContext());
      this.p.setMinimumHeight(1);
      this.p.setOnRefreshListener(this);
    }
    return new PullLoadMoreAdapter.RefreshViewHolder(this.p);
  }
  
  protected void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof PullLoadMoreAdapter.LoadMoreViewHolder))
    {
      paramViewHolder = (PullLoadMoreAdapter.LoadMoreViewHolder)paramViewHolder;
      if (!this.s)
      {
        PullLoadMoreAdapter.LoadMoreViewHolder.b(paramViewHolder).setVisibility(8);
        if (this.t != null) {
          PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(8);
        }
        QLog.i(k, 1, "onBindProgressViewHolder hideLoadingFooter");
        return;
      }
      boolean bool;
      if ((this.r) && (getItemCount() > l())) {
        bool = true;
      } else {
        bool = false;
      }
      PullLoadMoreAdapter.LoadMoreViewHolder.c(paramViewHolder).setIndeterminate(bool);
      Object localObject = PullLoadMoreAdapter.LoadMoreViewHolder.c(paramViewHolder);
      if (bool) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      ((ProgressBar)localObject).setVisibility(paramInt);
      if ((this.t != null) && (this.l))
      {
        PullLoadMoreAdapter.LoadMoreViewHolder.b(paramViewHolder).setVisibility(8);
        PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(0);
        QLog.i(k, 1, "onBindProgressViewHolder show CustomNoMoreDataView");
        return;
      }
      PullLoadMoreAdapter.LoadMoreViewHolder.b(paramViewHolder).setVisibility(0);
      PullLoadMoreAdapter.LoadMoreViewHolder.d(paramViewHolder).setText(this.g);
      if (this.t != null) {
        PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(8);
      }
      paramViewHolder = k;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBindProgressViewHolder show progress text:");
      ((StringBuilder)localObject).append(this.g);
      QLog.i(paramViewHolder, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.p != null)
    {
      this.r = n();
      this.p.setRefreshing(paramBoolean);
    }
  }
  
  protected int c(int paramInt)
  {
    int j = paramInt;
    if (this.m) {
      j = paramInt - 1;
    }
    return j;
  }
  
  protected RecyclerView.ViewHolder c(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new PullLoadMoreAdapter.LoadMoreViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626849, paramViewGroup, false));
    if (this.t != null) {
      PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewGroup).addView(this.t);
    }
    return paramViewGroup;
  }
  
  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  protected abstract void d();
  
  public int getItemCount()
  {
    return this.j.size() + k();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.m) && (paramInt == 0)) {
      return -10000;
    }
    if (c(paramInt) < this.j.size()) {
      return 0;
    }
    return -99999;
  }
  
  protected void j()
  {
    this.r = true;
    this.g = this.f;
    this.s = true;
    notifyItemChanged(getItemCount() - 1);
  }
  
  public int k()
  {
    int j;
    if (this.m) {
      j = 1;
    } else {
      j = 0;
    }
    int i1 = j;
    if (this.n) {
      i1 = j + 1;
    }
    return i1;
  }
  
  protected int l()
  {
    return 1;
  }
  
  public boolean m()
  {
    return this.m;
  }
  
  public boolean n()
  {
    RefreshHeaderView localRefreshHeaderView = this.p;
    if (localRefreshHeaderView != null) {
      return localRefreshHeaderView.f();
    }
    return false;
  }
  
  public RefreshHeaderView o()
  {
    return this.p;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.h = paramRecyclerView;
    this.i = paramRecyclerView.getLayoutManager();
    this.h.addOnScrollListener(new PullLoadMoreAdapter.2(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder != null) && (paramInt < getItemCount()) && ((!this.m) || (paramInt != 0))) {
      if (-99999 == getItemViewType(paramInt)) {
        b(paramViewHolder, paramInt);
      } else {
        a(paramViewHolder, c(paramInt));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == -99999) {
      return c(paramViewGroup, paramInt);
    }
    if (paramInt == -10000)
    {
      this.o = b(paramViewGroup, paramInt);
      return this.o;
    }
    return a(paramViewGroup, paramInt);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.p;
    if (paramRecyclerView != null) {
      paramRecyclerView.h();
    }
    this.a.removeCallbacksAndMessages(null);
  }
  
  public boolean p()
  {
    return this.n;
  }
  
  public boolean q()
  {
    return this.l;
  }
  
  protected void r()
  {
    label188:
    label193:
    for (;;)
    {
      int[] arrayOfInt;
      try
      {
        if (this.i == null) {
          this.i = this.h.getLayoutManager();
        }
        if ((this.i instanceof LinearLayoutManager))
        {
          if (((LinearLayoutManager)this.i).findLastVisibleItemPosition() >= this.i.getItemCount() - 3) {
            d();
          }
        }
        else if ((this.i instanceof StaggeredGridLayoutManager))
        {
          StaggeredGridLayoutManager localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)this.i;
          int i1 = localStaggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
          if (i1 == 1)
          {
            arrayOfInt = new int[1];
            localStaggeredGridLayoutManager.findLastVisibleItemPositions(arrayOfInt);
            if (arrayOfInt[0] >= localStaggeredGridLayoutManager.getItemCount() - 3) {
              d();
            }
          }
          else
          {
            arrayOfInt = new int[i1];
            localStaggeredGridLayoutManager.findLastVisibleItemPositions(arrayOfInt);
            j = arrayOfInt[(i1 - 1)];
            if (arrayOfInt.length == 2)
            {
              if (arrayOfInt[1] < arrayOfInt[0]) {
                break label188;
              }
              j = arrayOfInt[1];
              break label193;
            }
            if (j >= localStaggeredGridLayoutManager.getItemCount() - k() - i1 * 3)
            {
              d();
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      int j = arrayOfInt[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.PullLoadMoreAdapter
 * JD-Core Version:    0.7.0.1
 */