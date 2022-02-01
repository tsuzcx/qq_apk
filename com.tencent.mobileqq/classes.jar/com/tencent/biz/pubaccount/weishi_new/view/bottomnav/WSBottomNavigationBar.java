package com.tencent.biz.pubaccount.weishi_new.view.bottomnav;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barAdapter", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$BarAdapter;", "navigationBarContainer", "Landroid/widget/LinearLayout;", "navigationBarHolderList", "", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$BarHolder;", "observer", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$NavigationBarDataObserver;", "viewLine", "Landroid/view/View;", "addBottomBar", "", "barHolder", "changeBottomBarColor", "offset", "", "setAdapter", "adapter", "setBottomBarBlackStyle", "setBottomBarStyle", "barStyle", "setBottomBarWhiteStyle", "AdapterDataObservable", "AdapterDataObserver", "BarAdapter", "BarHolder", "Companion", "NavigationBarDataObserver", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBottomNavigationBar
  extends RelativeLayout
{
  public static final WSBottomNavigationBar.Companion a = new WSBottomNavigationBar.Companion(null);
  private LinearLayout b;
  private View c;
  private WSBottomNavigationBar.BarAdapter<?> d;
  private final List<WSBottomNavigationBar.BarHolder> e = (List)new ArrayList();
  private final WSBottomNavigationBar.NavigationBarDataObserver f = new WSBottomNavigationBar.NavigationBarDataObserver(this);
  
  @JvmOverloads
  public WSBottomNavigationBar(@Nullable Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public WSBottomNavigationBar(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public WSBottomNavigationBar(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    RelativeLayout.inflate(paramContext, 1929773058, (ViewGroup)this);
    paramContext = findViewById(1929707553);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.ll_bottom_item_view_container)");
    this.b = ((LinearLayout)paramContext);
    paramContext = findViewById(1929707617);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.view_line)");
    this.c = paramContext;
  }
  
  private final void a()
  {
    this.b.setBackgroundColor(Color.parseColor("#FFFFFF"));
    this.c.setVisibility(0);
  }
  
  private final void a(WSBottomNavigationBar.BarHolder paramBarHolder)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    localLayoutParams.gravity = 16;
    this.b.setOrientation(0);
    this.b.addView(paramBarHolder.c(), (ViewGroup.LayoutParams)localLayoutParams);
    this.e.add(paramBarHolder);
  }
  
  private final void b()
  {
    this.b.setBackgroundColor(Color.parseColor("#000000"));
    this.c.setVisibility(8);
  }
  
  public final void a(float paramFloat)
  {
    if (WeishiUtils.a(paramFloat, 0.0F)) {
      return;
    }
    int i = (int)(paramFloat * 'ÿ');
    this.b.setBackgroundColor(Color.rgb(i, i, i));
  }
  
  public final void setAdapter(@NotNull WSBottomNavigationBar.BarAdapter<?> paramBarAdapter)
  {
    Intrinsics.checkParameterIsNotNull(paramBarAdapter, "adapter");
    this.d = paramBarAdapter;
    paramBarAdapter = this.d;
    if (paramBarAdapter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("barAdapter");
    }
    paramBarAdapter.b();
    paramBarAdapter = this.d;
    if (paramBarAdapter == null) {
      Intrinsics.throwUninitializedPropertyAccessException("barAdapter");
    }
    paramBarAdapter.a((WSBottomNavigationBar.AdapterDataObserver)this.f);
  }
  
  public final void setBottomBarStyle(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.bottomnav.WSBottomNavigationBar
 * JD-Core Version:    0.7.0.1
 */