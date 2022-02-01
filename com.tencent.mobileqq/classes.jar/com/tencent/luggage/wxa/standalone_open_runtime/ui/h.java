package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.qx.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandCircleProgressView;
import com.tencent.mm.plugin.appbrand.ui.c;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.ui.base.l;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaUILoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplash;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplashCloseable;", "Lcom/tencent/mm/plugin/appbrand/ui/IAppBrandLoadingSplashEx;", "ctx", "Landroid/content/Context;", "runtime", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "isGame", "", "(Landroid/content/Context;Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;Z)V", "appBrandIcon", "Landroid/widget/ImageView;", "appBrandTypeDesc", "Landroid/widget/TextView;", "brandLayout", "Landroid/widget/LinearLayout;", "loadingSplash", "Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaUILoadingSplash$WxaUILoadingSplashViewInner;", "animateHide", "", "block", "Lkotlin/Function0;", "backgroundColor", "color", "", "getIconRes", "getLoadingView", "getView", "Landroid/view/View;", "initConstraintLayout", "root", "onSplashClosed", "listener", "setAppInfo", "icon", "", "name", "setCanShowHideAnimation", "can", "setProgress", "progress", "setupBrandLayout", "WxaUILoadingSplashViewInner", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class h
  implements com.tencent.mm.plugin.appbrand.ui.d, f, g
{
  private final h.a a;
  private ImageView b;
  private TextView c;
  private LinearLayout d;
  private final Context e;
  private final boolean f;
  
  public h(@NotNull Context paramContext, @Nullable com.tencent.luggage.wxa.ed.d paramd, boolean paramBoolean)
  {
    this.e = paramContext;
    this.f = paramBoolean;
    this.a = new h.a(this.e, paramd, this.f);
    paramContext = getView();
    if (paramContext != null)
    {
      paramContext = (FrameLayout)paramContext;
      a((View)paramContext);
      paramd = new FrameLayout.LayoutParams(-2, -2);
      paramd.gravity = 81;
      paramd.bottomMargin = this.e.getResources().getDimensionPixelSize(2131296342);
      this.b = new ImageView(this.e);
      this.c = new TextView(this.e);
      paramd = new LinearLayout.LayoutParams((int)this.e.getResources().getDimension(2131296336), (int)this.e.getResources().getDimension(2131296336));
      paramd.gravity = 17;
      this.b.setLayoutParams((ViewGroup.LayoutParams)paramd);
      paramd = new LinearLayout.LayoutParams(-2, -2);
      paramd.gravity = 17;
      paramd.leftMargin = ((int)this.e.getResources().getDimension(2131296317));
      this.c.setTextSize(0, this.e.getResources().getDimension(2131296405));
      this.c.setTextColor(ContextCompat.getColor(this.e, 2131165220));
      this.c.setLayoutParams((ViewGroup.LayoutParams)paramd);
      this.c.setGravity(17);
      paramContext = (ViewGroup)paramContext;
      paramd = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
      paramd.setAccessible(true);
      paramd = (View)paramd.newInstance(new Object[] { paramContext.getContext() });
      Intrinsics.checkExpressionValueIsNotNull(paramd, "view");
      Object localObject1 = (LinearLayout)paramd;
      ((LinearLayout)localObject1).setOrientation(1);
      Object localObject2 = FrameLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
      ((Constructor)localObject2).setAccessible(true);
      localObject2 = (ViewGroup.LayoutParams)((Constructor)localObject2).newInstance(new Object[] { Integer.valueOf(-1), Integer.valueOf(-1) });
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "lp");
      Object localObject3 = (FrameLayout.LayoutParams)localObject2;
      ((FrameLayout.LayoutParams)localObject3).width = -1;
      ((FrameLayout.LayoutParams)localObject3).height = -2;
      ((FrameLayout.LayoutParams)localObject3).gravity = 81;
      ((FrameLayout.LayoutParams)localObject3).leftMargin = l.b(this.e, 16);
      ((FrameLayout.LayoutParams)localObject3).rightMargin = l.b(this.e, 16);
      ((FrameLayout.LayoutParams)localObject3).bottomMargin = l.b(this.e, 16);
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = (ViewGroup)localObject1;
      localObject2 = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
      ((Constructor)localObject2).setAccessible(true);
      localObject2 = (View)((Constructor)localObject2).newInstance(new Object[] { ((ViewGroup)localObject1).getContext() });
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "view");
      localObject3 = (LinearLayout)localObject2;
      Object localObject4 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
      ((Constructor)localObject4).setAccessible(true);
      localObject4 = (ViewGroup.LayoutParams)((Constructor)localObject4).newInstance(new Object[] { Integer.valueOf(-1), Integer.valueOf(-1) });
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "lp");
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localObject4;
      localLayoutParams.width = -2;
      localLayoutParams.height = -2;
      localLayoutParams.bottomMargin = l.b(this.e, 8);
      localLayoutParams.gravity = 1;
      ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      this.d = ((LinearLayout)localObject3);
      ((LinearLayout)localObject3).setOrientation(0);
      ((LinearLayout)localObject3).addView((View)this.b, 0);
      ((LinearLayout)localObject3).addView((View)this.c, 1);
      ((LinearLayout)localObject3).setVisibility(8);
      ((ViewGroup)localObject1).addView((View)localObject2);
      localObject2 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
      ((Constructor)localObject2).setAccessible(true);
      localObject2 = (View)((Constructor)localObject2).newInstance(new Object[] { ((ViewGroup)localObject1).getContext() });
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "view");
      localObject3 = (TextView)localObject2;
      l.c((View)localObject3, "gameAddiction");
      ((TextView)localObject3).setTextSize(1, 12.0F);
      ((TextView)localObject3).setTextColor(ContextCompat.getColor(this.e, 2131166379));
      ((TextView)localObject3).setText((CharSequence)this.e.getString(2131891465));
      ((TextView)localObject3).setGravity(17);
      ((TextView)localObject3).setVisibility(8);
      ((ViewGroup)localObject1).addView((View)localObject2);
      paramContext.addView(paramd);
      b();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
  }
  
  private final int a(boolean paramBoolean)
  {
    if ((paramBoolean) && (k.a.a())) {
      return 2130838712;
    }
    if ((paramBoolean) && (!k.a.a())) {
      return 2130838711;
    }
    if ((!paramBoolean) && (k.a.a())) {
      return 2130838716;
    }
    return 2130838715;
  }
  
  private final void a(View paramView)
  {
    paramView = (ConstraintLayout)paramView.findViewById(2131428542);
    Object localObject1 = (TextView)paramView.findViewById(2131428541);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "textView");
    Object localObject2 = new ConstraintLayout.LayoutParams(((TextView)localObject1).getLayoutParams());
    ((ConstraintLayout.LayoutParams)localObject2).endToEnd = 2131428526;
    ((ConstraintLayout.LayoutParams)localObject2).startToStart = 2131428526;
    ((ConstraintLayout.LayoutParams)localObject2).topToBottom = 2131428526;
    getView().getContext();
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (AppBrandCircleProgressView)paramView.findViewById(2131428526);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appBrandCircleProgressView");
    localObject2 = new ConstraintLayout.LayoutParams(((AppBrandCircleProgressView)localObject1).getLayoutParams());
    ((ConstraintLayout.LayoutParams)localObject2).bottomToBottom = 2131428542;
    ((ConstraintLayout.LayoutParams)localObject2).endToEnd = 2131428542;
    ((ConstraintLayout.LayoutParams)localObject2).startToStart = 2131428542;
    ((ConstraintLayout.LayoutParams)localObject2).topToTop = 2131428542;
    TypedValue localTypedValue = new TypedValue();
    Context localContext = ((AppBrandCircleProgressView)localObject1).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "appBrandCircleProgressView.context");
    localContext.getResources().getValue(2131296762, localTypedValue, true);
    ((ConstraintLayout.LayoutParams)localObject2).verticalBias = localTypedValue.getFloat();
    ((AppBrandCircleProgressView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = (ImageView)paramView.findViewById(2131428539);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "imageView");
    localObject2 = new ConstraintLayout.LayoutParams(((ImageView)localObject1).getLayoutParams());
    ((ConstraintLayout.LayoutParams)localObject2).bottomToTop = 2131428526;
    ((ConstraintLayout.LayoutParams)localObject2).endToEnd = 2131428526;
    ((ConstraintLayout.LayoutParams)localObject2).startToStart = 2131428526;
    ((ConstraintLayout.LayoutParams)localObject2).topToBottom = 2131428526;
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramView = (ViewStub)paramView.findViewById(2131428659);
    Intrinsics.checkExpressionValueIsNotNull(paramView, "viewStub");
    localObject1 = new ConstraintLayout.LayoutParams(paramView.getLayoutParams());
    ((ConstraintLayout.LayoutParams)localObject1).bottomToBottom = 2131428542;
    ((ConstraintLayout.LayoutParams)localObject1).endToEnd = 2131428542;
    ((ConstraintLayout.LayoutParams)localObject1).startToStart = 2131428542;
    localObject2 = paramView.getContext();
    ((ConstraintLayout.LayoutParams)localObject1).bottomMargin = a.e((Context)localObject2, a.d((Context)localObject2, 2131296763));
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
  }
  
  private final void b()
  {
    Object localObject1 = this.d;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("brandLayout");
    }
    int i = 0;
    ((LinearLayout)localObject1).setVisibility(0);
    int j = a(this.f);
    this.b.setImageResource(j);
    localObject1 = l.a(getView(), "gameAddiction");
    if (!this.f) {
      i = 8;
    }
    ((View)localObject1).setVisibility(i);
    if (this.f)
    {
      localObject1 = getView().findViewById(2131427569);
      Object localObject2 = getView().findViewById(2131427574);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "actionBarContainer");
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
      localLayoutParams.height = l.b(this.e, 58);
      ((View)localObject2).setLayoutParams(localLayoutParams);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "actionbar");
      localObject2 = (FrameLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (localObject2 != null)
      {
        ((FrameLayout.LayoutParams)localObject2).rightMargin = l.b(this.e, 18);
        ((FrameLayout.LayoutParams)localObject2).topMargin = l.b(this.e, 5);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      c.a(this.e, true);
      this.c.setText((CharSequence)this.e.getString(2131918157));
      return;
    }
    this.c.setText((CharSequence)this.e.getString(2131918156));
  }
  
  @NotNull
  public final h.a a()
  {
    return this.a;
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    this.a.a(paramString1, paramString2);
  }
  
  public void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "listener");
    this.a.a(paramFunction0);
  }
  
  public void b(@Nullable Function0<Unit> paramFunction0)
  {
    this.a.b(paramFunction0);
  }
  
  @NotNull
  public View getView()
  {
    View localView = this.a.getView();
    Intrinsics.checkExpressionValueIsNotNull(localView, "loadingSplash.view");
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.h
 * JD-Core Version:    0.7.0.1
 */