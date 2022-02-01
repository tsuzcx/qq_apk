package com.tencent.biz.richframework.part.block;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.IRecyclerViewPoolProvider;
import com.tencent.biz.richframework.part.IRefreshViewProvider;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class BlockContainer
  extends FrameLayout
{
  protected NestScrollRecyclerView a;
  protected BlockMerger b;
  private IStatusViewProvider c;
  private RecyclerView.LayoutManager d;
  private Fragment e;
  private Serializable f;
  private boolean g;
  
  public BlockContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BlockContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BlockContainer(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    this.a = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131444761));
    this.a.setHasFixedSize(true);
    this.a.setNestedScrollingEnabled(false);
    this.b = b();
    this.a.setAdapter(this.b);
    this.a.addItemDecoration(new BlockContainer.MergeItemDecorationDelegate(this, this.b));
    setLayoutManagerType(1, 1);
    this.a.setItemAnimator(null);
    this.a.setOverScrollMode(2);
  }
  
  public void a(MultiViewBlock paramMultiViewBlock)
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramMultiViewBlock);
    }
  }
  
  public void a(ArrayList<MultiViewBlock> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((MultiViewBlock)paramArrayList.next());
    }
  }
  
  protected BlockMerger b()
  {
    return new BlockMerger(this);
  }
  
  protected void c()
  {
    try
    {
      LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initView error:");
      localStringBuilder.append(localThrowable.toString());
      QLog.d("BlockContainer", 1, localStringBuilder.toString());
    }
    a(this);
  }
  
  public boolean d()
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      return localBlockMerger.i();
    }
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if ((((NestScrollRecyclerView)localObject).getLayoutManager() instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)this.a.getLayoutManager()).setRecycleChildrenOnDetach(true);
      }
      this.a.setAdapter(null);
    }
    localObject = this.b;
    if (localObject != null) {
      ((BlockMerger)localObject).g();
    }
    this.e = null;
  }
  
  public boolean f()
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      return localBlockMerger.s();
    }
    return false;
  }
  
  public void g()
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      localBlockMerger.k();
    }
  }
  
  public BlockMerger getBlockMerger()
  {
    return this.b;
  }
  
  public Serializable getExtraTypeInfo()
  {
    return this.f;
  }
  
  public Fragment getFragment()
  {
    if ((this.e == null) && (RFApplication.isDebug())) {
      throw new RuntimeException("please setParentFragment for ComponentPageView");
    }
    return this.e;
  }
  
  public int getLayoutId()
  {
    return 2131629200;
  }
  
  public RecyclerView.LayoutManager getLayoutManager()
  {
    return this.d;
  }
  
  public NestScrollRecyclerView getRecyclerView()
  {
    return this.a;
  }
  
  public IStatusViewProvider getStatusInterface()
  {
    return this.c;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setBlockWrapper(BlockPart paramBlockPart)
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramBlockPart);
    }
  }
  
  public void setEnableLoadMore(boolean paramBoolean)
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      localBlockMerger.d(paramBoolean);
    }
  }
  
  public void setEnablePageRecyclerViewPool(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if ((paramBoolean) && ((getContext() instanceof IRecyclerViewPoolProvider)))
    {
      getRecyclerView().setRecycledViewPool(((IRecyclerViewPoolProvider)getContext()).e());
      return;
    }
    getRecyclerView().setRecycledViewPool(new RecyclerView.RecycledViewPool());
  }
  
  public void setEnableRefresh(boolean paramBoolean)
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      localBlockMerger.b(paramBoolean);
    }
  }
  
  public void setExtraTypeInfo(Serializable paramSerializable)
  {
    this.f = paramSerializable;
  }
  
  public void setLayoutManagerType(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 2)
    {
      if (paramInt1 != 3)
      {
        this.d = new SafeLinearLayoutManager(getContext(), 1, false);
      }
      else
      {
        this.a.setHasFixedSize(false);
        this.d = new SafeStaggeredGridLayoutManager(paramInt2, 1);
        ((SafeStaggeredGridLayoutManager)this.d).setGapStrategy(0);
      }
    }
    else
    {
      this.d = new SafeGridLayoutManager(getContext(), paramInt2);
      ((SafeGridLayoutManager)this.d).setSpanSizeLookup(this.b.j());
    }
    this.a.setLayoutManager(this.d);
    this.b.a(this.d);
  }
  
  public void setParentFragment(Fragment paramFragment)
  {
    this.e = paramFragment;
  }
  
  public void setRefreshHeader(IRefreshViewProvider paramIRefreshViewProvider)
  {
    if (paramIRefreshViewProvider != null)
    {
      BlockMerger localBlockMerger = this.b;
      if ((localBlockMerger != null) && (localBlockMerger.h() != null))
      {
        if (this.b.h().b == null) {
          return;
        }
        this.b.h().b.a(paramIRefreshViewProvider);
      }
    }
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null)
    {
      if ((paramBoolean) && (!localBlockMerger.q())) {
        this.b.c(true);
      }
      if ((!paramBoolean) && (this.b.q())) {
        this.b.c(false);
      }
    }
  }
  
  public void setShareData(String paramString, BlockMerger.ShareData paramShareData)
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramString, paramShareData);
    }
  }
  
  public void setStatusViewInterface(IStatusViewProvider paramIStatusViewProvider)
  {
    if (paramIStatusViewProvider != null)
    {
      this.c = paramIStatusViewProvider;
      paramIStatusViewProvider = paramIStatusViewProvider.getStatusView();
      if ((paramIStatusViewProvider != null) && (paramIStatusViewProvider.getParent() != null)) {
        ((ViewGroup)paramIStatusViewProvider.getParent()).removeView(paramIStatusViewProvider);
      }
      addView(paramIStatusViewProvider, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
    throw new RuntimeException("IStatusViewInterface can't be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.BlockContainer
 * JD-Core Version:    0.7.0.1
 */