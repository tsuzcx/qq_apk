package com.tencent.biz.richframework.part.block.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.richframework.part.IRefreshViewProvider.OnRefreshListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class PullLoadMoreAdapter<E>
  extends BaseListViewAdapter<E>
  implements IRefreshViewProvider.OnRefreshListener
{
  public static int g = 8;
  public static int h = 15;
  public static int i = 16;
  private static String m = "PullLoadMoreAdapter";
  protected final Handler a = new Handler(Looper.getMainLooper());
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String j = this.e;
  protected RecyclerView k;
  protected RecyclerView.LayoutManager l;
  private boolean n = false;
  private boolean o;
  private boolean p = true;
  private IRefreshViewProvider q;
  private boolean r;
  private boolean s;
  private boolean t;
  private View u;
  private boolean v = true;
  
  private void a(Context paramContext)
  {
    this.b = paramContext.getResources().getString(2131915713);
    this.c = paramContext.getResources().getString(2131915711);
    this.d = paramContext.getResources().getString(2131915711);
    this.e = paramContext.getResources().getString(2131915714);
    this.f = paramContext.getResources().getString(2131915712);
  }
  
  private void a(LinearLayoutManager paramLinearLayoutManager)
  {
    int i1 = paramLinearLayoutManager.getItemCount() - paramLinearLayoutManager.findLastVisibleItemPosition();
    if (((paramLinearLayoutManager instanceof GridLayoutManager)) && (i1 < h))
    {
      e();
      return;
    }
    if (i1 < g) {
      e();
    }
  }
  
  protected abstract RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt);
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    this.l = paramLayoutManager;
  }
  
  protected void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof PullLoadMoreAdapter.RefreshViewHolder))
    {
      paramViewHolder = (PullLoadMoreAdapter.RefreshViewHolder)paramViewHolder;
      if ((paramViewHolder.itemView instanceof IRefreshViewProvider))
      {
        this.q = ((IRefreshViewProvider)paramViewHolder.itemView);
        this.q.setOnRefreshListener(this);
      }
    }
  }
  
  protected abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
  
  public void a(IRefreshViewProvider paramIRefreshViewProvider)
  {
    this.q = paramIRefreshViewProvider;
  }
  
  public void a(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (s())
    {
      boolean bool2 = false;
      this.s = false;
      this.n = paramBoolean2;
      this.r = paramBoolean1;
      if (paramBoolean2) {
        str = this.e;
      } else {
        str = "";
      }
      this.j = str;
      boolean bool1;
      if (StringUtil.isEmpty(this.j))
      {
        bool1 = bool2;
        if (paramBoolean2)
        {
          bool1 = bool2;
          if (this.u == null) {}
        }
      }
      else
      {
        bool1 = true;
      }
      this.t = bool1;
      if (!paramBoolean1)
      {
        if ((NetworkUtil.isNetworkAvailable() ^ true)) {
          str = this.d;
        } else {
          str = this.c;
        }
        this.j = str;
        this.t = this.v;
      }
      RFThreadManager.getUIHandler().post(new PullLoadMoreAdapter.1(this));
      String str = m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLoadMoreCompleted: hashCode:");
      localStringBuilder.append(hashCode());
      localStringBuilder.append(" ,isSuccess:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", isFinish:");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" , isShow:");
      localStringBuilder.append(this.t);
      QLog.i(str, 1, localStringBuilder.toString());
    }
  }
  
  protected RecyclerView.ViewHolder b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.q;
    if (paramViewGroup != null)
    {
      if (paramViewGroup.getRefreshView() != null)
      {
        this.q.setOnRefreshListener(this);
        return new PullLoadMoreAdapter.RefreshViewHolder(this.q.getRefreshView());
      }
      throw new RuntimeException("createRefreshViewHolder mRefreshViewProvider getRefreshView can't be null");
    }
    throw new RuntimeException("createRefreshViewHolder mRefreshViewProvider can't be null");
  }
  
  public void b() {}
  
  protected void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof PullLoadMoreAdapter.LoadMoreViewHolder))
    {
      paramViewHolder = (PullLoadMoreAdapter.LoadMoreViewHolder)paramViewHolder;
      if (!this.t)
      {
        PullLoadMoreAdapter.LoadMoreViewHolder.b(paramViewHolder).setVisibility(8);
        if (this.u != null) {
          PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(8);
        }
        QLog.i(m, 1, "onBindProgressViewHolder hideLoadingFooter");
        return;
      }
      boolean bool;
      if ((this.s) && (getItemCount() > o())) {
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
      if ((this.u != null) && (PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder) != null) && (this.n))
      {
        PullLoadMoreAdapter.LoadMoreViewHolder.b(paramViewHolder).setVisibility(8);
        PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(0);
        QLog.i(m, 1, "onBindProgressViewHolder show CustomNoMoreDataView");
        return;
      }
      PullLoadMoreAdapter.LoadMoreViewHolder.b(paramViewHolder).setVisibility(0);
      PullLoadMoreAdapter.LoadMoreViewHolder.d(paramViewHolder).setText(this.j);
      if (this.u != null) {
        PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewHolder).setVisibility(8);
      }
      paramViewHolder = m;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onBindProgressViewHolder show progress text:");
      ((StringBuilder)localObject).append(this.j);
      QLog.i(paramViewHolder, 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  protected int c(int paramInt)
  {
    int i1 = paramInt;
    if (this.o) {
      i1 = paramInt - 1;
    }
    return i1;
  }
  
  protected RecyclerView.ViewHolder c(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new PullLoadMoreAdapter.LoadMoreViewHolder(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131629201, paramViewGroup, false));
    if (this.u != null) {
      PullLoadMoreAdapter.LoadMoreViewHolder.a(paramViewGroup).addView(this.u);
    }
    return paramViewGroup;
  }
  
  public String c()
  {
    return null;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.q != null)
    {
      this.s = q();
      this.q.setRefreshing(paramBoolean);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  protected abstract void e();
  
  public int getItemCount()
  {
    return this.mDataList.size() + n();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.o) && (paramInt == 0)) {
      return -10000;
    }
    if (c(paramInt) < this.mDataList.size()) {
      return 0;
    }
    return -99999;
  }
  
  protected void m()
  {
    this.s = true;
    this.j = this.f;
    this.t = true;
    notifyItemChanged(getItemCount() - 1);
  }
  
  public int n()
  {
    int i1;
    if (this.o) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (this.p) {
      i2 = i1 + 1;
    }
    return i2;
  }
  
  protected int o()
  {
    return 1;
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.k = paramRecyclerView;
    this.l = paramRecyclerView.getLayoutManager();
    this.k.addOnScrollListener(new PullLoadMoreAdapter.2(this));
    a(paramRecyclerView.getContext());
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder != null)
    {
      if (paramInt >= getItemCount()) {
        return;
      }
      int i1 = getItemViewType(paramInt);
      if (-10000 == i1)
      {
        a(paramViewHolder);
        return;
      }
      if (-99999 == i1)
      {
        b(paramViewHolder, paramInt);
        return;
      }
      a(paramViewHolder, c(paramInt));
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == -99999) {
      return c(paramViewGroup, paramInt);
    }
    if (paramInt == -10000) {
      return b(paramViewGroup, paramInt);
    }
    return a(paramViewGroup, paramInt);
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    paramRecyclerView = this.q;
    if (paramRecyclerView != null) {
      paramRecyclerView.j();
    }
    this.a.removeCallbacksAndMessages(null);
  }
  
  public boolean p()
  {
    return this.o;
  }
  
  public boolean q()
  {
    IRefreshViewProvider localIRefreshViewProvider = this.q;
    if (localIRefreshViewProvider != null) {
      return localIRefreshViewProvider.i();
    }
    return false;
  }
  
  public IRefreshViewProvider r()
  {
    return this.q;
  }
  
  public boolean s()
  {
    return this.p;
  }
  
  public void t()
  {
    if (!q())
    {
      RecyclerView localRecyclerView = this.k;
      if (localRecyclerView != null)
      {
        IRefreshViewProvider localIRefreshViewProvider = this.q;
        if (localIRefreshViewProvider != null) {
          localIRefreshViewProvider.a(localRecyclerView);
        }
      }
    }
  }
  
  public boolean u()
  {
    return this.n;
  }
  
  public boolean v()
  {
    return this.s;
  }
  
  protected void w()
  {
    try
    {
      if (this.l == null) {
        this.l = this.k.getLayoutManager();
      }
      if ((this.l instanceof LinearLayoutManager))
      {
        a((LinearLayoutManager)this.l);
        return;
      }
      if ((this.l instanceof StaggeredGridLayoutManager))
      {
        StaggeredGridLayoutManager localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)this.l;
        int i2 = localStaggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
        int[] arrayOfInt;
        if (i2 == 1)
        {
          arrayOfInt = new int[1];
          localStaggeredGridLayoutManager.findLastVisibleItemPositions(arrayOfInt);
          if (arrayOfInt[0] >= localStaggeredGridLayoutManager.getItemCount() - i) {
            e();
          }
        }
        else
        {
          arrayOfInt = new int[i2];
          localStaggeredGridLayoutManager.findLastVisibleItemPositions(arrayOfInt);
          int i1 = arrayOfInt[(i2 - 1)];
          if (arrayOfInt.length == 2) {
            i1 = Math.max(arrayOfInt[1], arrayOfInt[0]);
          }
          if (i1 >= localStaggeredGridLayoutManager.getItemCount() - n() - i2 * i)
          {
            e();
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.base.PullLoadMoreAdapter
 * JD-Core Version:    0.7.0.1
 */