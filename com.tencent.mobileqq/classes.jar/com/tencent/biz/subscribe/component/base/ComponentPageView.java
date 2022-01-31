package com.tencent.biz.subscribe.component.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import tvw;
import yhy;
import yib;
import yif;
import yig;
import yih;
import yip;
import yiq;

public class ComponentPageView
  extends FrameLayout
{
  private static final String jdField_a_of_type_JavaLangString = ComponentPageView.class.getSimpleName();
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  protected NestScrollRecyclerView a;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  public yib a;
  
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
  
  @NotNull
  private yib b()
  {
    return new yib(this);
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
  
  protected StatusView a(View paramView)
  {
    paramView = new StatusView(getContext());
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    paramView.setVisibility(8);
    return paramView;
  }
  
  public yib a()
  {
    return this.jdField_a_of_type_Yib;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(a(), this);
    a(this);
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131364072));
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setNestedScrollingEnabled(false);
    this.jdField_a_of_type_Yib = b();
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setAdapter(this.jdField_a_of_type_Yib);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.addItemDecoration(new yih(this, this.jdField_a_of_type_Yib));
    setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView = a(paramFrameLayout);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView.setVisibility(8);
    addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void a(ArrayList<yhy> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((yhy)paramArrayList.next());
    }
  }
  
  public void a(yhy paramyhy)
  {
    if (this.jdField_a_of_type_Yib != null) {
      this.jdField_a_of_type_Yib.a(paramyhy);
    }
  }
  
  public void a(yig paramyig)
  {
    if (this.jdField_a_of_type_Yib != null) {
      this.jdField_a_of_type_Yib.a(paramyig);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Yib != null) {
      return this.jdField_a_of_type_Yib.a();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
      }
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Yib != null) {
      this.jdField_a_of_type_Yib.c();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().setImageDrawable(null);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = null;
  }
  
  public void b(yhy paramyhy)
  {
    if (this.jdField_a_of_type_Yib != null) {
      this.jdField_a_of_type_Yib.b(paramyhy);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Yib != null) {
      return this.jdField_a_of_type_Yib.d();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Yib != null) {
      this.jdField_a_of_type_Yib.d();
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
    if (this.jdField_a_of_type_Yib != null) {
      this.jdField_a_of_type_Yib.d(paramBoolean);
    }
  }
  
  public void setEnableRefresh(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Yib != null) {
      this.jdField_a_of_type_Yib.b(paramBoolean);
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
      this.jdField_a_of_type_Yib.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new yip(getContext(), 1, false);
      continue;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new GridLayoutManager(getContext(), paramInt2);
      ((GridLayoutManager)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setSpanSizeLookup(this.jdField_a_of_type_Yib.a());
      continue;
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseNestScrollRecyclerView.setHasFixedSize(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new yiq(paramInt2, 1);
      ((yiq)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setGapStrategy(0);
    }
  }
  
  public void setParentFragment(Fragment paramFragment)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public void setPartWrapper(tvw paramtvw)
  {
    if (this.jdField_a_of_type_Yib != null) {
      this.jdField_a_of_type_Yib.a(paramtvw);
    }
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Yib != null)
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_Yib.c())) {
        this.jdField_a_of_type_Yib.c(true);
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_Yib.c())) {
        this.jdField_a_of_type_Yib.c(false);
      }
    }
  }
  
  public void setShareData(String paramString, yif paramyif)
  {
    if (this.jdField_a_of_type_Yib != null) {
      this.jdField_a_of_type_Yib.a(paramString, paramyif);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.base.ComponentPageView
 * JD-Core Version:    0.7.0.1
 */