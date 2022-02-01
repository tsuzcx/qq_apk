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
  private static final String jdField_a_of_type_JavaLangString = "MultiViewBlock";
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private final RecyclerView.AdapterDataObserver jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new MultiViewBlock.1(this);
  private BlockMerger jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
  private MultiViewBlock.onLoadDataDelegate jdField_a_of_type_ComTencentBizSubscribePartBlockMultiViewBlock$onLoadDataDelegate;
  private final LoadInfo jdField_a_of_type_ComTencentBizSubscribePartBlockBaseLoadInfo = new LoadInfo();
  protected boolean a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = String.valueOf(hashCode());
  protected boolean b;
  
  public MultiViewBlock(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    setHasStableIds(true);
  }
  
  private void c(LoadInfo paramLoadInfo)
  {
    MultiViewBlock.onLoadDataDelegate localonLoadDataDelegate = this.jdField_a_of_type_ComTencentBizSubscribePartBlockMultiViewBlock$onLoadDataDelegate;
    if (localonLoadDataDelegate != null)
    {
      localonLoadDataDelegate.a(paramLoadInfo, this);
      return;
    }
    a(paramLoadInfo);
  }
  
  public abstract int a();
  
  public int a(int paramInt)
  {
    return 1;
  }
  
  protected Activity a()
  {
    if ((a() != null) && (a().a() != null)) {
      return a().a().getBaseActivity();
    }
    return null;
  }
  
  protected Context a()
  {
    return a();
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  protected FrameLayout a(@Nullable View paramView)
  {
    FrameLayout localFrameLayout = new FrameLayout(a());
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    if (paramView != null) {
      localFrameLayout.addView(paramView);
    }
    return localFrameLayout;
  }
  
  public ExtraTypeInfo a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public BlockContainer a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public BlockMerger.ShareData a(String paramString)
  {
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null) {
      return localBlockMerger.a(paramString);
    }
    return null;
  }
  
  public BlockMerger a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
  }
  
  public LoadInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseLoadInfo;
  }
  
  public NestScrollRecyclerView a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public BaseFragment a()
  {
    if (a() != null) {
      return a().a();
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void a(Canvas paramCanvas, RecyclerView paramRecyclerView, View paramView, RecyclerView.State paramState) {}
  
  protected void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {}
  
  public abstract void a(Bundle paramBundle);
  
  public void a(BlockMerger paramBlockMerger)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger = paramBlockMerger;
  }
  
  public void a(MultiViewBlock.onLoadDataDelegate paramonLoadDataDelegate)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockMultiViewBlock$onLoadDataDelegate = paramonLoadDataDelegate;
  }
  
  protected void a(MultiViewBlock paramMultiViewBlock, int paramInt) {}
  
  public abstract void a(LoadInfo paramLoadInfo);
  
  public void a(String paramString, BlockMerger.ShareData paramShareData) {}
  
  public boolean a()
  {
    return true;
  }
  
  public int b(int paramInt)
  {
    return paramInt - this.jdField_a_of_type_Int;
  }
  
  public void b(View paramView)
  {
    if (a() != null) {
      a().addView(paramView);
    }
  }
  
  public void b(LoadInfo paramLoadInfo)
  {
    MultiViewBlock.onLoadDataDelegate localonLoadDataDelegate = this.jdField_a_of_type_ComTencentBizSubscribePartBlockMultiViewBlock$onLoadDataDelegate;
    if (localonLoadDataDelegate != null)
    {
      localonLoadDataDelegate.a(paramLoadInfo, this);
      return;
    }
    c(paramLoadInfo);
  }
  
  public void b(String paramString, BlockMerger.ShareData paramShareData)
  {
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramString, paramShareData);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int c(int paramInt)
  {
    return this.jdField_a_of_type_Int + paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((a() != null) && (a() != null))
    {
      a().a(4);
      a().setRefreshing(false);
      if (f()) {
        a().a(paramBoolean, a().a());
      }
    }
  }
  
  protected boolean e()
  {
    return false;
  }
  
  public boolean f()
  {
    BlockMerger localBlockMerger = a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localBlockMerger != null)
    {
      bool1 = bool2;
      if (b().size() > 0)
      {
        bool1 = bool2;
        if (a().b().get(a().b().size() - 1) == this) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public abstract int getItemCount();
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseLoadInfo.a(2);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseLoadInfo.a(null);
    MultiViewBlock.onLoadDataDelegate localonLoadDataDelegate = this.jdField_a_of_type_ComTencentBizSubscribePartBlockMultiViewBlock$onLoadDataDelegate;
    if (localonLoadDataDelegate != null)
    {
      localonLoadDataDelegate.a(this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseLoadInfo, this);
      return;
    }
    c(this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseLoadInfo);
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
      registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    this.jdField_b_of_type_Boolean = true;
    if (hasObservers()) {
      unregisterAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onViewAttachedToWindow(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewAttachedToWindow(paramViewHolder);
    if (e()) {
      p();
    }
  }
  
  protected void p()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      a(a());
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseLoadInfo.a(1);
      c(this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseLoadInfo);
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.MultiViewBlock
 * JD-Core Version:    0.7.0.1
 */