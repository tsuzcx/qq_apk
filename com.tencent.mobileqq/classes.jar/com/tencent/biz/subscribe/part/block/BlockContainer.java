package com.tencent.biz.subscribe.part.block;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.part.BlockPart;
import com.tencent.biz.subscribe.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.subscribe.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.subscribe.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.biz.subscribe.widget.StatusView;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public class BlockContainer
  extends FrameLayout
{
  private static final String jdField_a_of_type_JavaLangString = BlockContainer.class.getSimpleName();
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  protected BlockMerger a;
  protected NestScrollRecyclerView a;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  
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
  private BlockMerger b()
  {
    return new BlockMerger(this);
  }
  
  protected int a()
  {
    return 2131558840;
  }
  
  public Fragment a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragment == null) {}
    return this.jdField_a_of_type_AndroidSupportV4AppFragment;
  }
  
  public ExtraTypeInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo();
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public BlockMerger a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
  }
  
  public NestScrollRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView;
  }
  
  public StatusView a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView == null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = a(this);
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
      addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView, new ViewGroup.LayoutParams(-1, -1));
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
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
    LayoutInflater.from(getContext()).inflate(a(), this);
    a(this);
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131364528));
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setNestedScrollingEnabled(false);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger = b();
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.addItemDecoration(new BlockContainer.MergeItemDecorationDelegate(this, this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger));
    setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setOverScrollMode(2);
  }
  
  public void a(BlockMerger.ShareDataChangeListener paramShareDataChangeListener)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.a(paramShareDataChangeListener);
    }
  }
  
  public void a(MultiViewBlock paramMultiViewBlock)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.a(paramMultiViewBlock);
    }
  }
  
  public void a(ArrayList<MultiViewBlock> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((MultiViewBlock)paramArrayList.next());
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null) {
      return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.a();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
      }
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.d();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().setImageDrawable(null);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null) {
      return this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.d();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.e();
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setBlockWrapper(BlockPart paramBlockPart)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.a(paramBlockPart);
    }
  }
  
  public void setEnableLoadMore(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.c(paramBoolean);
    }
  }
  
  public void setEnableRefresh(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.a(paramBoolean);
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setLayoutManagerType(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new SafeLinearLayoutManager(getContext(), 1, false);
      continue;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new SafeGridLayoutManager(getContext(), paramInt2);
      ((SafeGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setSpanSizeLookup(this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.a());
      continue;
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setHasFixedSize(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new SafeStaggeredGridLayoutManager(paramInt2, 1);
      ((SafeStaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setGapStrategy(0);
    }
  }
  
  public void setParentFragment(Fragment paramFragment)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null)
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.c())) {
        this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.b(true);
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.c())) {
        this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.b(false);
      }
    }
  }
  
  public void setShareData(String paramString, BlockMerger.ShareData paramShareData)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger != null) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.a(paramString, paramShareData);
    }
  }
  
  public void setStatusView(StatusView paramStatusView)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView != null) {
      ((ViewGroup)this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = paramStatusView;
    addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView, new ViewGroup.LayoutParams(-1, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.BlockContainer
 * JD-Core Version:    0.7.0.1
 */