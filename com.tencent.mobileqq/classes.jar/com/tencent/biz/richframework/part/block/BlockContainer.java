package com.tencent.biz.richframework.part.block;

import aabd;
import aabi;
import aabj;
import aabn;
import aabo;
import aabp;
import aacd;
import aace;
import aacf;
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
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.StatusView;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public class BlockContainer
  extends FrameLayout
{
  private static final String jdField_a_of_type_JavaLangString = BlockContainer.class.getSimpleName();
  public aabj a;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  protected NestScrollRecyclerView a;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
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
  private aabj b()
  {
    return new aabj(this);
  }
  
  protected int a()
  {
    return 2131558767;
  }
  
  public aabj a()
  {
    return this.jdField_a_of_type_Aabj;
  }
  
  public Fragment a()
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragment == null) {}
    return this.jdField_a_of_type_AndroidSupportV4AppFragment;
  }
  
  public RecyclerView.LayoutManager a()
  {
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  }
  
  public NestScrollRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView;
  }
  
  public ExtraTypeInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) {
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = new ExtraTypeInfo();
    }
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
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
  
  public void a(aabo paramaabo)
  {
    if (this.jdField_a_of_type_Aabj != null) {
      this.jdField_a_of_type_Aabj.a(paramaabo);
    }
  }
  
  public void a(aabp paramaabp)
  {
    if (this.jdField_a_of_type_Aabj != null) {
      this.jdField_a_of_type_Aabj.a(paramaabp);
    }
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131364322));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setNestedScrollingEnabled(false);
    this.jdField_a_of_type_Aabj = b();
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setAdapter(this.jdField_a_of_type_Aabj);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.addItemDecoration(new aabi(this, this.jdField_a_of_type_Aabj));
    setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setOverScrollMode(2);
  }
  
  public void a(ArrayList<aabp> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((aabp)paramArrayList.next());
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Aabj != null) {
      return this.jdField_a_of_type_Aabj.a();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
        ((LinearLayoutManager)this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.getLayoutManager()).setRecycleChildrenOnDetach(true);
      }
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Aabj != null) {
      this.jdField_a_of_type_Aabj.c();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().setImageDrawable(null);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aabj != null) {
      return this.jdField_a_of_type_Aabj.d();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aabj != null) {
      this.jdField_a_of_type_Aabj.d();
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
  
  public void setBlockWrapper(aabd paramaabd)
  {
    if (this.jdField_a_of_type_Aabj != null) {
      this.jdField_a_of_type_Aabj.a(paramaabd);
    }
  }
  
  public void setEnableLoadMore(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aabj != null) {
      this.jdField_a_of_type_Aabj.d(paramBoolean);
    }
  }
  
  public void setEnableRefresh(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aabj != null) {
      this.jdField_a_of_type_Aabj.b(paramBoolean);
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
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      this.jdField_a_of_type_Aabj.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new aace(getContext(), 1, false);
      continue;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new aacd(getContext(), paramInt2);
      ((aacd)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setSpanSizeLookup(this.jdField_a_of_type_Aabj.a());
      continue;
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setHasFixedSize(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new aacf(paramInt2, 1);
      ((aacf)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setGapStrategy(0);
    }
  }
  
  public void setParentFragment(Fragment paramFragment)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aabj != null)
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_Aabj.c())) {
        this.jdField_a_of_type_Aabj.c(true);
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_Aabj.c())) {
        this.jdField_a_of_type_Aabj.c(false);
      }
    }
  }
  
  public void setShareData(String paramString, aabn paramaabn)
  {
    if (this.jdField_a_of_type_Aabj != null) {
      this.jdField_a_of_type_Aabj.a(paramString, paramaabn);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.BlockContainer
 * JD-Core Version:    0.7.0.1
 */