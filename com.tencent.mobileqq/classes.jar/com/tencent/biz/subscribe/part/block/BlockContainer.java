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
  private static final String jdField_a_of_type_JavaLangString = "BlockContainer";
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  protected BlockMerger a;
  protected NestScrollRecyclerView a;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  private BaseFragment jdField_a_of_type_ComTencentMobileqqAppBaseFragment;
  
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
    return 2131558738;
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
  
  public BaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(a(), this);
    a(this);
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131364416));
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
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramShareDataChangeListener);
    }
  }
  
  public void a(MultiViewBlock paramMultiViewBlock)
  {
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
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
  
  public boolean a()
  {
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null) {
      return localBlockMerger.a();
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView;
    if (localObject != null)
    {
      if ((((NestScrollRecyclerView)localObject).getLayoutManager() instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
      }
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setAdapter(null);
    }
    localObject = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localObject != null) {
      ((BlockMerger)localObject).d();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().setImageDrawable(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment = null;
  }
  
  public boolean b()
  {
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null) {
      return localBlockMerger.d();
    }
    return false;
  }
  
  public void c()
  {
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null) {
      localBlockMerger.e();
    }
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
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramBlockPart);
    }
  }
  
  public void setEnableLoadMore(boolean paramBoolean)
  {
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null) {
      localBlockMerger.c(paramBoolean);
    }
  }
  
  public void setEnableRefresh(boolean paramBoolean)
  {
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramBoolean);
    }
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setLayoutManagerType(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3)
        {
          this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setHasFixedSize(false);
          this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new SafeStaggeredGridLayoutManager(paramInt2, 1);
          ((SafeStaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setGapStrategy(0);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new SafeGridLayoutManager(getContext(), paramInt2);
        ((SafeGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setSpanSizeLookup(this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.a());
      }
    }
    else {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new SafeLinearLayoutManager(getContext(), 1, false);
    }
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseNestScrollRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
  }
  
  public void setParentFragment(BaseFragment paramBaseFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseFragment = paramBaseFragment;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null)
    {
      if ((paramBoolean) && (!localBlockMerger.c())) {
        this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.b(true);
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.c())) {
        this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger.b(false);
      }
    }
  }
  
  public void setShareData(String paramString, BlockMerger.ShareData paramShareData)
  {
    BlockMerger localBlockMerger = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockMerger;
    if (localBlockMerger != null) {
      localBlockMerger.a(paramString, paramShareData);
    }
  }
  
  public void setStatusView(StatusView paramStatusView)
  {
    StatusView localStatusView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
    if (localStatusView != null) {
      ((ViewGroup)localStatusView.getParent()).removeView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = paramStatusView;
    addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView, new ViewGroup.LayoutParams(-1, -1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.BlockContainer
 * JD-Core Version:    0.7.0.1
 */