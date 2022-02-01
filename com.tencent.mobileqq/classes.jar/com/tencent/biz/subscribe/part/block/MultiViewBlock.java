package com.tencent.biz.subscribe.part.block;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.part.block.base.BaseListViewAdapter;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.mobileqq.app.BaseFragment;
import java.util.ArrayList;
import javax.annotation.Nullable;

public abstract class MultiViewBlock<E>
  extends BaseListViewAdapter<E>
  implements Application.ActivityLifecycleCallbacks, BlockMerger.ShareDataChangeListener
{
  private static final String a = "MultiViewBlock";
  private final Handler b = new Handler(Looper.getMainLooper());
  private Bundle c;
  private MultiViewBlock.onLoadDataDelegate d;
  private BlockMerger e;
  private final LoadInfo f = new LoadInfo();
  private int g;
  protected boolean h;
  protected boolean i;
  private int k;
  private String l = String.valueOf(hashCode());
  private final RecyclerView.AdapterDataObserver m = new MultiViewBlock.1(this);
  
  public MultiViewBlock(Bundle paramBundle)
  {
    this.c = paramBundle;
    setHasStableIds(true);
  }
  
  private void c(LoadInfo paramLoadInfo)
  {
    MultiViewBlock.onLoadDataDelegate localonLoadDataDelegate = this.d;
    if (localonLoadDataDelegate != null)
    {
      localonLoadDataDelegate.a(paramLoadInfo, this);
      return;
    }
    a(paramLoadInfo);
  }
  
  public BaseFragment A()
  {
    if (I() != null) {
      return I().getFragment();
    }
    return null;
  }
  
  public BlockMerger B()
  {
    return this.e;
  }
  
  public int C()
  {
    return this.g;
  }
  
  public LoadInfo D()
  {
    return this.f;
  }
  
  protected boolean E()
  {
    return false;
  }
  
  public Bundle F()
  {
    return this.c;
  }
  
  protected Activity G()
  {
    if ((I() != null) && (I().getFragment() != null)) {
      return I().getFragment().getBaseActivity();
    }
    return null;
  }
  
  protected Context H()
  {
    return G();
  }
  
  public BlockContainer I()
  {
    if (B() != null) {
      return B().f();
    }
    return null;
  }
  
  public NestScrollRecyclerView J()
  {
    if (I() != null) {
      return I().getRecyclerView();
    }
    return null;
  }
  
  public ExtraTypeInfo K()
  {
    if (I() != null) {
      return I().getExtraTypeInfo();
    }
    return null;
  }
  
  public boolean L()
  {
    BlockMerger localBlockMerger = B();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBlockMerger != null)
    {
      bool1 = bool2;
      if (N().size() > 0)
      {
        bool1 = bool2;
        if (B().N().get(B().N().size() - 1) == this) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public Handler M()
  {
    return this.b;
  }
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  public BlockMerger.ShareData a(String paramString)
  {
    BlockMerger localBlockMerger = this.e;
    if (localBlockMerger != null) {
      return localBlockMerger.a(paramString);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState) {}
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {}
  
  public abstract void a(Bundle paramBundle);
  
  public void a(BlockMerger paramBlockMerger)
  {
    this.e = paramBlockMerger;
  }
  
  public void a(MultiViewBlock.onLoadDataDelegate paramonLoadDataDelegate)
  {
    this.d = paramonLoadDataDelegate;
  }
  
  protected void a(MultiViewBlock paramMultiViewBlock, int paramInt) {}
  
  public abstract void a(LoadInfo paramLoadInfo);
  
  public void a(String paramString, BlockMerger.ShareData paramShareData) {}
  
  public boolean a()
  {
    return true;
  }
  
  public void b(View paramView)
  {
    if (I() != null) {
      I().addView(paramView);
    }
  }
  
  public void b(LoadInfo paramLoadInfo)
  {
    MultiViewBlock.onLoadDataDelegate localonLoadDataDelegate = this.d;
    if (localonLoadDataDelegate != null)
    {
      localonLoadDataDelegate.a(paramLoadInfo, this);
      return;
    }
    c(paramLoadInfo);
  }
  
  public void b(String paramString, BlockMerger.ShareData paramShareData)
  {
    BlockMerger localBlockMerger = this.e;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramString, paramShareData);
    }
  }
  
  public String bA_()
  {
    return this.l;
  }
  
  public abstract int c();
  
  protected FrameLayout c(@Nullable View paramView)
  {
    FrameLayout localFrameLayout = new FrameLayout(H());
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
    return localFrameLayout;
  }
  
  public void d(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((I() != null) && (B() != null))
    {
      D().a(4);
      I().setRefreshing(false);
      if (L()) {
        B().a(paramBoolean, D().a());
      }
    }
  }
  
  public int e(int paramInt)
  {
    return paramInt - this.g;
  }
  
  public int f(int paramInt)
  {
    return this.g + paramInt;
  }
  
  public void g(int paramInt)
  {
    this.k = paramInt;
  }
  
  public abstract int getItemCount();
  
  public boolean i()
  {
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    if (!hasObservers()) {
      registerAdapterDataObserver(this.m);
    }
    this.i = false;
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.i = true;
    if (hasObservers()) {
      unregisterAdapterDataObserver(this.m);
    }
    this.b.removeCallbacksAndMessages(null);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (E()) {
      z();
    }
  }
  
  public void y()
  {
    this.f.a(2);
    this.f.a(null);
    MultiViewBlock.onLoadDataDelegate localonLoadDataDelegate = this.d;
    if (localonLoadDataDelegate != null)
    {
      localonLoadDataDelegate.a(this.f, this);
      return;
    }
    c(this.f);
  }
  
  protected void z()
  {
    if (!this.h)
    {
      a(F());
      this.f.a(1);
      c(this.f);
      this.h = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.MultiViewBlock
 * JD-Core Version:    0.7.0.1
 */