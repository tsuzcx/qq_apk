package com.tencent.biz.subscribe.part.block;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.part.BlockPart;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.subscribe.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.subscribe.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.mobileqq.app.BaseFragment;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public class BlockContainer
  extends FrameLayout
{
  private static final String c = "BlockContainer";
  protected NestScrollRecyclerView a;
  protected BlockMerger b;
  private StatusView d;
  private RecyclerView.LayoutManager e;
  private BaseFragment f;
  private ExtraTypeInfo g;
  
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
    a();
  }
  
  @NotNull
  private BlockMerger f()
  {
    return new BlockMerger(this);
  }
  
  protected StatusView a(View paramView)
  {
    paramView = new StatusView(getContext());
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    paramView.setVisibility(8);
    return paramView;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(getLayoutId(), this);
    a(this);
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    this.a = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131430447));
    this.a.setHasFixedSize(true);
    this.a.setNestedScrollingEnabled(false);
    this.b = f();
    this.a.setAdapter(this.b);
    this.a.addItemDecoration(new BlockContainer.MergeItemDecorationDelegate(this, this.b));
    setLayoutManagerType(1, 1);
    this.a.setItemAnimator(null);
    this.a.setOverScrollMode(2);
  }
  
  public void a(BlockMerger.ShareDataChangeListener paramShareDataChangeListener)
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramShareDataChangeListener);
    }
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
  
  public boolean b()
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      return localBlockMerger.g();
    }
    return false;
  }
  
  public void c()
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
      ((BlockMerger)localObject).e();
    }
    if ((getStatusView() != null) && (getStatusView().getIvLoadingPic() != null)) {
      getStatusView().getIvLoadingPic().setImageDrawable(null);
    }
    this.f = null;
  }
  
  public boolean d()
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      return localBlockMerger.p();
    }
    return false;
  }
  
  public void e()
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      localBlockMerger.i();
    }
  }
  
  public BlockMerger getBlockMerger()
  {
    return this.b;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    if (this.g == null) {
      this.g = new ExtraTypeInfo();
    }
    return this.g;
  }
  
  public BaseFragment getFragment()
  {
    return this.f;
  }
  
  protected int getLayoutId()
  {
    return 2131624358;
  }
  
  public RecyclerView.LayoutManager getLayoutManager()
  {
    return this.e;
  }
  
  public NestScrollRecyclerView getRecyclerView()
  {
    return this.a;
  }
  
  public StatusView getStatusView()
  {
    if (this.d == null)
    {
      this.d = a(this);
      this.d.setVisibility(8);
      addView(this.d, new ViewGroup.LayoutParams(-1, -1));
    }
    return this.d;
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
      localBlockMerger.c(paramBoolean);
    }
  }
  
  public void setEnableRefresh(boolean paramBoolean)
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramBoolean);
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.g = paramExtraTypeInfo;
  }
  
  public void setLayoutManagerType(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3)
        {
          this.a.setHasFixedSize(false);
          this.e = new SafeStaggeredGridLayoutManager(paramInt2, 1);
          ((SafeStaggeredGridLayoutManager)this.e).setGapStrategy(0);
        }
      }
      else
      {
        this.e = new SafeGridLayoutManager(getContext(), paramInt2);
        ((SafeGridLayoutManager)this.e).setSpanSizeLookup(this.b.h());
      }
    }
    else {
      this.e = new SafeLinearLayoutManager(getContext(), 1, false);
    }
    this.a.setLayoutManager(this.e);
    this.b.a(this.e);
  }
  
  public void setParentFragment(BaseFragment paramBaseFragment)
  {
    this.f = paramBaseFragment;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    BlockMerger localBlockMerger = this.b;
    if (localBlockMerger != null)
    {
      if ((paramBoolean) && (!localBlockMerger.n())) {
        this.b.b(true);
      }
      if ((!paramBoolean) && (this.b.n())) {
        this.b.b(false);
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
  
  public void setStatusView(StatusView paramStatusView)
  {
    StatusView localStatusView = this.d;
    if (localStatusView != null) {
      ((ViewGroup)localStatusView.getParent()).removeView(this.d);
    }
    this.d = paramStatusView;
    addView(this.d, new ViewGroup.LayoutParams(-1, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.BlockContainer
 * JD-Core Version:    0.7.0.1
 */