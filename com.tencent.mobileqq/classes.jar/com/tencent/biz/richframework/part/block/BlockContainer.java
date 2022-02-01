package com.tencent.biz.richframework.part.block;

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
import zxi;
import zxn;
import zxo;
import zxs;
import zxt;
import zxu;
import zyh;
import zyi;
import zyj;

public class BlockContainer
  extends FrameLayout
{
  private static final String jdField_a_of_type_JavaLangString = BlockContainer.class.getSimpleName();
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  protected NestScrollRecyclerView a;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private StatusView jdField_a_of_type_ComTencentBizSubscribeWidgetStatusView;
  public zxo a;
  
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
  private zxo b()
  {
    return new zxo(this);
  }
  
  protected int a()
  {
    return 2131558769;
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
  
  public zxo a()
  {
    return this.jdField_a_of_type_Zxo;
  }
  
  protected void a()
  {
    LayoutInflater.from(getContext()).inflate(a(), this);
    a(this);
  }
  
  protected void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView = ((NestScrollRecyclerView)paramFrameLayout.findViewById(2131364277));
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setNestedScrollingEnabled(false);
    this.jdField_a_of_type_Zxo = b();
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setAdapter(this.jdField_a_of_type_Zxo);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.addItemDecoration(new zxn(this, this.jdField_a_of_type_Zxo));
    setLayoutManagerType(1, 1);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setOverScrollMode(2);
  }
  
  public void a(ArrayList<zxu> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((zxu)paramArrayList.next());
    }
  }
  
  public void a(zxt paramzxt)
  {
    if (this.jdField_a_of_type_Zxo != null) {
      this.jdField_a_of_type_Zxo.a(paramzxt);
    }
  }
  
  public void a(zxu paramzxu)
  {
    if (this.jdField_a_of_type_Zxo != null) {
      this.jdField_a_of_type_Zxo.a(paramzxu);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Zxo != null) {
      return this.jdField_a_of_type_Zxo.a();
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
    if (this.jdField_a_of_type_Zxo != null) {
      this.jdField_a_of_type_Zxo.c();
    }
    if ((a() != null) && (a().a() != null)) {
      a().a().setImageDrawable(null);
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragment = null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Zxo != null) {
      return this.jdField_a_of_type_Zxo.d();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Zxo != null) {
      this.jdField_a_of_type_Zxo.d();
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
  
  public void setBlockWrapper(zxi paramzxi)
  {
    if (this.jdField_a_of_type_Zxo != null) {
      this.jdField_a_of_type_Zxo.a(paramzxi);
    }
  }
  
  public void setEnableLoadMore(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Zxo != null) {
      this.jdField_a_of_type_Zxo.d(paramBoolean);
    }
  }
  
  public void setEnableRefresh(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Zxo != null) {
      this.jdField_a_of_type_Zxo.b(paramBoolean);
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
      this.jdField_a_of_type_Zxo.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
      return;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new zyi(getContext(), 1, false);
      continue;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new zyh(getContext(), paramInt2);
      ((zyh)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setSpanSizeLookup(this.jdField_a_of_type_Zxo.a());
      continue;
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBaseNestScrollRecyclerView.setHasFixedSize(false);
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new zyj(paramInt2, 1);
      ((zyj)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager).setGapStrategy(0);
    }
  }
  
  public void setParentFragment(Fragment paramFragment)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragment = paramFragment;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Zxo != null)
    {
      if ((paramBoolean) && (!this.jdField_a_of_type_Zxo.c())) {
        this.jdField_a_of_type_Zxo.c(true);
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_Zxo.c())) {
        this.jdField_a_of_type_Zxo.c(false);
      }
    }
  }
  
  public void setShareData(String paramString, zxs paramzxs)
  {
    if (this.jdField_a_of_type_Zxo != null) {
      this.jdField_a_of_type_Zxo.a(paramString, paramzxs);
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