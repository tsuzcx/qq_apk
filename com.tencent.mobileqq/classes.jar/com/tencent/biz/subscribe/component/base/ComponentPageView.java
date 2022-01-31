package com.tencent.biz.subscribe.component.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.SubScribeSwipeRefreshLayout;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import woz;
import wpc;
import wpf;
import wpg;
import wph;
import wpi;
import wpj;
import wpn;
import wpo;

public class ComponentPageView
  extends FrameLayout
{
  private static final String jdField_a_of_type_JavaLangString = ComponentPageView.class.getSimpleName();
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  protected SubScribeSwipeRefreshLayout a;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  protected NestScrollRecyclerView a;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  public wpc a;
  private boolean jdField_a_of_type_Boolean;
  
  public ComponentPageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ComponentPageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ComponentPageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131364009));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setNestedScrollingEnabled(false);
    this.jdField_a_of_type_Wpc = new wpc(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setAdapter(this.jdField_a_of_type_Wpc);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.addItemDecoration(new wpj(this, this.jdField_a_of_type_Wpc));
    setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.addOnScrollListener(new wph(this));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = ((StatusView)paramFrameLayout.findViewById(2131364588));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout = ((SubScribeSwipeRefreshLayout)findViewById(2131376414));
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.setOnRefreshListener(new wpi(this));
    }
  }
  
  public Fragment a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragment == null) {}
    return this.jdField_a_of_type_AndroidSupportV4AppFragment;
  }
  
  public SubScribeSwipeRefreshLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout;
  }
  
  public ExtraTypeInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo();
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public NestScrollRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView;
  }
  
  public StatusView a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(2131558667, this);
    a(this);
  }
  
  public void a(woz paramwoz)
  {
    if (this.jdField_a_of_type_Wpc != null) {
      this.jdField_a_of_type_Wpc.a(paramwoz);
    }
  }
  
  public void a(wpg paramwpg)
  {
    if (this.jdField_a_of_type_Wpc != null) {
      this.jdField_a_of_type_Wpc.a(paramwpg);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Wpc != null) {
      return this.jdField_a_of_type_Wpc.a();
    }
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager instanceof LinearLayoutManager)) {
      if ((((LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).findLastVisibleItemPosition() >= this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.getItemCount() - 1) && (this.jdField_a_of_type_Wpc != null)) {
        this.jdField_a_of_type_Wpc.c();
      }
    }
    label147:
    label155:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager instanceof StaggeredGridLayoutManager))
      {
        StaggeredGridLayoutManager localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
        int i = localStaggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
        if (i == 1) {
          break;
        }
        int[] arrayOfInt = new int[i];
        localStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(arrayOfInt);
        if (arrayOfInt[1] >= arrayOfInt[0])
        {
          i = arrayOfInt[1];
          if (localStaggeredGridLayoutManager.getItemCount() - 1 - 10 >= 0) {
            break label147;
          }
        }
        for (int j = 0;; j = localStaggeredGridLayoutManager.getItemCount() - 1)
        {
          if ((i < j) || (this.jdField_a_of_type_Wpc == null)) {
            break label155;
          }
          this.jdField_a_of_type_Wpc.c();
          return;
          i = arrayOfInt[0];
          break;
        }
      }
    }
  }
  
  public void b(woz paramwoz)
  {
    if (this.jdField_a_of_type_Wpc != null) {
      this.jdField_a_of_type_Wpc.b(paramwoz);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Wpc != null) {
      this.jdField_a_of_type_Wpc.d();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().setImageDrawable(null);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = null;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Wpc != null) {
      this.jdField_a_of_type_Wpc.e();
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
  
  public void setEnableLoadMore(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setEnableRefresh(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.setEnabled(paramBoolean);
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
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new wpn(getContext(), 1, false);
      continue;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new GridLayoutManager(getContext(), paramInt2);
      ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setSpanSizeLookup(this.jdField_a_of_type_Wpc.a());
      continue;
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setHasFixedSize(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new wpo(paramInt2, 1);
      ((wpo)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setGapStrategy(0);
    }
  }
  
  public void setParentFragment(Fragment paramFragment)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout != null)
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.isRefreshing())) {
        this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.setRefreshing(true);
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.isRefreshing())) {
        this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.setRefreshing(false);
      }
    }
  }
  
  public void setShareData(String paramString, wpf paramwpf)
  {
    if (this.jdField_a_of_type_Wpc != null) {
      this.jdField_a_of_type_Wpc.a(paramString, paramwpf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.base.ComponentPageView
 * JD-Core Version:    0.7.0.1
 */