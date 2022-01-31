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
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.SubScribeSwipeRefreshLayout;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import java.util.ArrayList;
import java.util.Iterator;
import tvm;
import ydp;
import yds;
import ydw;
import ydx;
import ydy;
import ydz;
import yea;
import yed;
import yee;

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
  public yds a;
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
    b();
  }
  
  protected int a()
  {
    return 2131558703;
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
  
  public yds a()
  {
    return this.jdField_a_of_type_Yds;
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = ((StatusView)paramView.findViewById(2131364666));
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131364070));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setNestedScrollingEnabled(false);
    this.jdField_a_of_type_Yds = new yds(this);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setAdapter(this.jdField_a_of_type_Yds);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.addItemDecoration(new yea(this, this.jdField_a_of_type_Yds));
    setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.addOnScrollListener(new ydy(this));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout = ((SubScribeSwipeRefreshLayout)findViewById(2131376915));
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.setEnabled(false);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerSubScribeSwipeRefreshLayout.setOnRefreshListener(new ydz(this));
    }
    a(paramFrameLayout);
  }
  
  public void a(ArrayList<ydp> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((ydp)paramArrayList.next());
    }
  }
  
  public void a(ydp paramydp)
  {
    if (this.jdField_a_of_type_Yds != null) {
      this.jdField_a_of_type_Yds.a(paramydp);
    }
  }
  
  public void a(ydx paramydx)
  {
    if (this.jdField_a_of_type_Yds != null) {
      this.jdField_a_of_type_Yds.a(paramydx);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Yds != null) {
      return this.jdField_a_of_type_Yds.a();
    }
    return false;
  }
  
  protected void b()
  {
    LayoutInflater.from(getContext()).inflate(a(), this);
    a(this);
  }
  
  public void b(ydp paramydp)
  {
    if (this.jdField_a_of_type_Yds != null) {
      this.jdField_a_of_type_Yds.b(paramydp);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager instanceof LinearLayoutManager)) {
      if ((((LinearLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).findLastVisibleItemPosition() >= this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.getItemCount() - 1) && (this.jdField_a_of_type_Yds != null)) {
        this.jdField_a_of_type_Yds.c();
      }
    }
    label187:
    label195:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager instanceof StaggeredGridLayoutManager))
      {
        StaggeredGridLayoutManager localStaggeredGridLayoutManager = (StaggeredGridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
        int i = localStaggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
        if (i == 1)
        {
          arrayOfInt = new int[1];
          localStaggeredGridLayoutManager.findLastVisibleItemPositions(arrayOfInt);
          if ((arrayOfInt[0] < localStaggeredGridLayoutManager.getItemCount() - 3) || (this.jdField_a_of_type_Yds == null)) {
            break;
          }
          this.jdField_a_of_type_Yds.c();
          return;
        }
        int[] arrayOfInt = new int[i];
        localStaggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(arrayOfInt);
        if (arrayOfInt[1] >= arrayOfInt[0])
        {
          i = arrayOfInt[1];
          if (localStaggeredGridLayoutManager.getItemCount() - 1 - 10 >= 0) {
            break label187;
          }
        }
        for (int j = 0;; j = localStaggeredGridLayoutManager.getItemCount() - 1)
        {
          if ((i < j) || (this.jdField_a_of_type_Yds == null)) {
            break label195;
          }
          this.jdField_a_of_type_Yds.c();
          return;
          i = arrayOfInt[0];
          break;
        }
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Yds != null) {
      this.jdField_a_of_type_Yds.d();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().setImageDrawable(null);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = null;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Yds != null) {
      this.jdField_a_of_type_Yds.e();
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
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new yed(getContext(), 1, false);
      continue;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new GridLayoutManager(getContext(), paramInt2);
      ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setSpanSizeLookup(this.jdField_a_of_type_Yds.a());
      continue;
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setHasFixedSize(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new yee(paramInt2, 1);
      ((yee)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setGapStrategy(0);
    }
  }
  
  public void setParentFragment(Fragment paramFragment)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public void setPartWrapper(tvm paramtvm)
  {
    if (this.jdField_a_of_type_Yds != null) {
      this.jdField_a_of_type_Yds.a(paramtvm);
    }
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
  
  public void setShareData(String paramString, ydw paramydw)
  {
    if (this.jdField_a_of_type_Yds != null) {
      this.jdField_a_of_type_Yds.a(paramString, paramydw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.base.ComponentPageView
 * JD-Core Version:    0.7.0.1
 */