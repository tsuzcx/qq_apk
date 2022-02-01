package com.tencent.biz.pubaccount.weishi_new.view.topnav;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/view/topnav/WSTopNavigationBar;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backBtn", "Landroid/widget/ImageView;", "centerContentViewStub", "Landroid/view/ViewStub;", "detailBtn", "underLine", "Landroid/view/View;", "inflateCenterContentLayout", "layoutId", "setBackBtnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setDetailBtnClickListener", "setTopBarBlackStyle", "isShowUnderLine", "", "setTopBarStyle", "barStyle", "backBtnResId", "detailBtnResId", "bgColor", "setTopBarTransparentStyle", "setTopBarWhiteStyle", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSTopNavigationBar
  extends RelativeLayout
{
  public static final WSTopNavigationBar.Companion a = new WSTopNavigationBar.Companion(null);
  private ViewStub b;
  private View c;
  private ImageView d;
  private ImageView e;
  
  @JvmOverloads
  public WSTopNavigationBar(@Nullable Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public WSTopNavigationBar(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public WSTopNavigationBar(@Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    RelativeLayout.inflate(paramContext, 1929773081, (ViewGroup)this);
    paramContext = findViewById(1929707521);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.center_content_container)");
    this.b = ((ViewStub)paramContext);
    paramContext = findViewById(1929707627);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.ws_title_bar_under_line)");
    this.c = paramContext;
    paramContext = findViewById(1929707624);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.ws_iv_back)");
    this.d = ((ImageView)paramContext);
    paramContext = findViewById(1929707625);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.ws_iv_detail)");
    this.e = ((ImageView)paramContext);
  }
  
  private final void a(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @ColorRes int paramInt3, boolean paramBoolean)
  {
    this.d.setImageResource(paramInt1);
    this.e.setImageResource(paramInt2);
    setBackgroundColor(getResources().getColor(paramInt3));
    View localView = this.c;
    if (paramBoolean) {
      paramInt1 = 0;
    } else {
      paramInt1 = 8;
    }
    localView.setVisibility(paramInt1);
  }
  
  private final void setTopBarBlackStyle(boolean paramBoolean)
  {
    a(2130844284, 1929641988, 1929510912, paramBoolean);
  }
  
  private final void setTopBarTransparentStyle(boolean paramBoolean)
  {
    a(2130844284, 1929641988, 1929510917, paramBoolean);
  }
  
  private final void setTopBarWhiteStyle(boolean paramBoolean)
  {
    a(2130844283, 2130841270, 1929510917, paramBoolean);
  }
  
  @NotNull
  public final View a(@LayoutRes int paramInt)
  {
    this.b.setLayoutResource(paramInt);
    View localView = this.b.inflate();
    Intrinsics.checkExpressionValueIsNotNull(localView, "centerContentViewStub.inflate()");
    return localView;
  }
  
  public final void setBackBtnClickListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public final void setDetailBtnClickListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public final void setTopBarStyle(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        setTopBarTransparentStyle(paramBoolean);
        return;
      }
      setTopBarBlackStyle(paramBoolean);
      return;
    }
    setTopBarWhiteStyle(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.topnav.WSTopNavigationBar
 * JD-Core Version:    0.7.0.1
 */