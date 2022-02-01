package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.jj.s.c;
import com.tencent.luggage.wxa.jj.s.c.a;
import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.standalone_open_runtime.e;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaMenuHeader;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getIconRes", "", "isGame", "", "getTradingGuaranteeFlag", "appId", "", "layout", "", "setPage", "page", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class c
  extends LinearLayout
{
  @Deprecated
  public static final c.a a = new c.a(null);
  private static final SparseIntArray c = new SparseIntArray();
  private final Context b;
  
  public c(@NotNull Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    a(this.b);
  }
  
  private final int a(String paramString)
  {
    int i = c.get(paramString.hashCode(), -2147483648);
    if (-2147483648 != i) {
      return i;
    }
    try
    {
      localObject = u.a().b(paramString, new String[] { "dynamicInfo" });
      if (localObject == null) {
        break label115;
      }
      localObject = ((s)localObject).d();
      if (localObject == null) {
        break label115;
      }
      localObject = ((s.c)localObject).a;
      if (localObject == null) {
        break label115;
      }
      i = ((s.c.a)localObject).w;
      c.put(paramString.hashCode(), i);
      return i;
    }
    catch (Exception localException)
    {
      Object localObject;
      label78:
      break label78;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getTradingGuaranteeFlag by ContentProvider with appId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", get exception");
    o.b("Luggage.WxaMenuHeader", ((StringBuilder)localObject).toString());
    label115:
    return 0;
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
  
  private final void a(Context paramContext)
  {
    Object localObject8 = Integer.valueOf(-2);
    Object localObject1 = Integer.valueOf(-1);
    Object localObject2 = new ViewGroup.LayoutParams(-1, -2);
    setGravity(16);
    int i = l.a(paramContext, 2131296336);
    Object localObject9 = Integer.valueOf(0);
    setPadding(0, 0, 0, i);
    Object localObject3 = Unit.INSTANCE;
    setLayoutParams((ViewGroup.LayoutParams)localObject2);
    setOrientation(1);
    localObject2 = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject2).setAccessible(true);
    localObject2 = (View)((Constructor)localObject2).newInstance(new Object[] { getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view");
    localObject3 = (LinearLayout)localObject2;
    i = l.b(paramContext, 68);
    Object localObject4 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject4).setAccessible(true);
    localObject4 = (ViewGroup.LayoutParams)((Constructor)localObject4).newInstance(new Object[] { localObject1, Integer.valueOf(i) });
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "lp");
    ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    l.a((View)localObject3, l.a(paramContext, 2131296329));
    ((LinearLayout)localObject3).setGravity(8388627);
    ((LinearLayout)localObject3).setOrientation(1);
    localObject3 = (ViewGroup)localObject3;
    localObject4 = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject4).setAccessible(true);
    localObject4 = (View)((Constructor)localObject4).newInstance(new Object[] { ((ViewGroup)localObject3).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "view");
    Object localObject5 = (LinearLayout)localObject4;
    Object localObject6 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject6).setAccessible(true);
    localObject6 = (ViewGroup.LayoutParams)((Constructor)localObject6).newInstance(new Object[] { localObject1, localObject8 });
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "lp");
    ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    ((LinearLayout)localObject5).setOrientation(0);
    ((LinearLayout)localObject5).setGravity(8388627);
    localObject5 = (ViewGroup)localObject5;
    localObject6 = RelativeLayout.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject6).setAccessible(true);
    localObject6 = (View)((Constructor)localObject6).newInstance(new Object[] { ((ViewGroup)localObject5).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "view");
    Object localObject7 = (RelativeLayout)localObject6;
    Object localObject10 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject10).setAccessible(true);
    localObject10 = (ViewGroup.LayoutParams)((Constructor)localObject10).newInstance(new Object[] { localObject9, localObject8 });
    Intrinsics.checkExpressionValueIsNotNull(localObject10, "lp");
    ((LinearLayout.LayoutParams)localObject10).weight = 1.0F;
    ((RelativeLayout)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject10);
    ((RelativeLayout)localObject7).setGravity(80);
    localObject7 = (ViewGroup)localObject7;
    localObject10 = ImageView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject10).setAccessible(true);
    localObject10 = (View)((Constructor)localObject10).newInstance(new Object[] { ((ViewGroup)localObject7).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject10, "view");
    Object localObject11 = (ImageView)localObject10;
    l.c((View)localObject11, "icon");
    i = l.a(paramContext, 2131296339);
    int j = l.a(paramContext, 2131296339);
    Object localObject12 = RelativeLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject12).setAccessible(true);
    localObject12 = (ViewGroup.LayoutParams)((Constructor)localObject12).newInstance(new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    Intrinsics.checkExpressionValueIsNotNull(localObject12, "lp");
    Object localObject13 = (RelativeLayout.LayoutParams)localObject12;
    ((RelativeLayout.LayoutParams)localObject13).setMarginEnd(l.a(paramContext, 2131296353));
    ((RelativeLayout.LayoutParams)localObject13).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject13).addRule(10, -1);
    ((ImageView)localObject11).setLayoutParams((ViewGroup.LayoutParams)localObject12);
    ((ViewGroup)localObject7).addView((View)localObject10);
    paramContext = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
    paramContext.setAccessible(true);
    paramContext = (View)paramContext.newInstance(new Object[] { ((ViewGroup)localObject7).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "view");
    localObject10 = (LinearLayout)paramContext;
    l.c((View)localObject10, "name_area");
    localObject11 = RelativeLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject11).setAccessible(true);
    localObject8 = (ViewGroup.LayoutParams)((Constructor)localObject11).newInstance(new Object[] { localObject8, localObject9 });
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "lp");
    localObject9 = (RelativeLayout.LayoutParams)localObject8;
    ((RelativeLayout.LayoutParams)localObject9).addRule(1, "icon".hashCode());
    ((RelativeLayout.LayoutParams)localObject9).addRule(6, "icon".hashCode());
    ((RelativeLayout.LayoutParams)localObject9).addRule(8, "icon".hashCode());
    ((LinearLayout)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject8);
    ((LinearLayout)localObject10).setGravity(16);
    localObject8 = (ViewGroup)localObject10;
    localObject9 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject9).setAccessible(true);
    localObject9 = (View)((Constructor)localObject9).newInstance(new Object[] { ((ViewGroup)localObject8).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "view");
    localObject10 = (TextView)localObject9;
    l.c((View)localObject10, "name");
    localObject11 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject11).setAccessible(true);
    localObject11 = (ViewGroup.LayoutParams)((Constructor)localObject11).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "lp");
    localObject12 = (LinearLayout.LayoutParams)localObject11;
    ((LinearLayout.LayoutParams)localObject12).width = 0;
    ((LinearLayout.LayoutParams)localObject12).height = -2;
    ((LinearLayout.LayoutParams)localObject12).weight = 1.0F;
    ((TextView)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    ((TextView)localObject10).setGravity(8388627);
    localObject11 = ((TextView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "context");
    ((TextView)localObject10).setTextColor(l.c((Context)localObject11, 2131166595));
    localObject11 = ((TextView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "context");
    ((TextView)localObject10).setTextSize(0, l.a((Context)localObject11, 2131296405));
    ((TextView)localObject10).setTypeface(((TextView)localObject10).getTypeface(), 1);
    ((TextView)localObject10).setSingleLine(true);
    ((TextView)localObject10).setEllipsize(TextUtils.TruncateAt.END);
    ((ViewGroup)localObject8).addView((View)localObject9);
    localObject9 = ImageView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject9).setAccessible(true);
    localObject9 = (View)((Constructor)localObject9).newInstance(new Object[] { ((ViewGroup)localObject8).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "view");
    localObject10 = (ImageView)localObject9;
    l.c((View)localObject10, "trading_guarantee_icon");
    localObject11 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject11).setAccessible(true);
    localObject11 = (ViewGroup.LayoutParams)((Constructor)localObject11).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "lp");
    localObject12 = (LinearLayout.LayoutParams)localObject11;
    localObject13 = ((ImageView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject13, "context");
    ((LinearLayout.LayoutParams)localObject12).width = l.a((Context)localObject13, 2131296336);
    localObject13 = ((ImageView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject13, "context");
    ((LinearLayout.LayoutParams)localObject12).height = l.a((Context)localObject13, 2131296336);
    ((LinearLayout.LayoutParams)localObject12).gravity = 16;
    localObject13 = ((ImageView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject13, "context");
    ((LinearLayout.LayoutParams)localObject12).setMarginStart(l.a((Context)localObject13, 2131296409));
    ((ImageView)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    ((ImageView)localObject10).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject10).setBackgroundResource(2130853726);
    ((ImageView)localObject10).setVisibility(8);
    ((ViewGroup)localObject8).addView((View)localObject9);
    localObject9 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject9).setAccessible(true);
    localObject9 = (View)((Constructor)localObject9).newInstance(new Object[] { ((ViewGroup)localObject8).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "view");
    localObject10 = (TextView)localObject9;
    localObject11 = (View)localObject10;
    l.c((View)localObject11, "debug_type_desc");
    localObject12 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject12).setAccessible(true);
    localObject12 = (ViewGroup.LayoutParams)((Constructor)localObject12).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject12, "lp");
    localObject13 = (LinearLayout.LayoutParams)localObject12;
    ((LinearLayout.LayoutParams)localObject13).width = -2;
    ((LinearLayout.LayoutParams)localObject13).height = -2;
    Context localContext = ((TextView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    ((LinearLayout.LayoutParams)localObject13).setMarginStart(l.a(localContext, 2131296258));
    ((TextView)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject12);
    localObject12 = ((TextView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject12, "context");
    l.a((View)localObject11, l.a((Context)localObject12, 2131296258));
    localObject12 = ((TextView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject12, "context");
    l.b((View)localObject11, l.a((Context)localObject12, 2131296258));
    localObject12 = ((TextView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject12, "context");
    l.c((View)localObject11, l.a((Context)localObject12, 2131296392));
    localObject12 = ((TextView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject12, "context");
    l.d((View)localObject11, l.a((Context)localObject12, 2131296392));
    ((TextView)localObject10).setGravity(17);
    ((TextView)localObject10).setVisibility(8);
    ((TextView)localObject10).setText((CharSequence)"develop");
    localObject11 = ((TextView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "context");
    ((TextView)localObject10).setBackground(l.e((Context)localObject11, 2130853722));
    localObject11 = ((TextView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "context");
    ((TextView)localObject10).setTextSize(0, l.b((Context)localObject11, 9));
    localObject11 = ((TextView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "context");
    ((TextView)localObject10).setTextColor(l.c((Context)localObject11, 2131168534));
    ((ViewGroup)localObject8).addView((View)localObject9);
    localObject9 = ImageView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject9).setAccessible(true);
    localObject9 = (View)((Constructor)localObject9).newInstance(new Object[] { ((ViewGroup)localObject8).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "view");
    localObject10 = (ImageView)localObject9;
    l.c((View)localObject10, "original_label");
    localObject11 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject11).setAccessible(true);
    localObject11 = (ViewGroup.LayoutParams)((Constructor)localObject11).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "lp");
    localObject12 = (LinearLayout.LayoutParams)localObject11;
    ((LinearLayout.LayoutParams)localObject12).width = -2;
    ((LinearLayout.LayoutParams)localObject12).height = -2;
    ((LinearLayout.LayoutParams)localObject12).gravity = 16;
    localObject13 = ((ImageView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject13, "context");
    ((LinearLayout.LayoutParams)localObject12).setMarginStart(l.a((Context)localObject13, 2131296258));
    ((ImageView)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    ((ImageView)localObject10).setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((ImageView)localObject10).setVisibility(8);
    localObject11 = ((ImageView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "context");
    ((ImageView)localObject10).setMinimumWidth(l.a((Context)localObject11, 2131296339));
    localObject11 = ((ImageView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "context");
    ((ImageView)localObject10).setMinimumHeight(l.b((Context)localObject11, 14));
    ((ImageView)localObject10).setBackgroundResource(2130853718);
    ((ViewGroup)localObject8).addView((View)localObject9);
    localObject9 = WeImageView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject9).setAccessible(true);
    localObject9 = (View)((Constructor)localObject9).newInstance(new Object[] { ((ViewGroup)localObject8).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "view");
    localObject10 = (WeImageView)localObject9;
    localObject11 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject11).setAccessible(true);
    localObject11 = (ViewGroup.LayoutParams)((Constructor)localObject11).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "lp");
    localObject12 = (LinearLayout.LayoutParams)localObject11;
    localObject13 = ((WeImageView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject13, "context");
    ((LinearLayout.LayoutParams)localObject12).width = l.b((Context)localObject13, 10);
    localObject13 = ((WeImageView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject13, "context");
    ((LinearLayout.LayoutParams)localObject12).height = l.b((Context)localObject13, 20);
    ((LinearLayout.LayoutParams)localObject12).topMargin = 1;
    localObject13 = ((WeImageView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject13, "context");
    ((LinearLayout.LayoutParams)localObject12).leftMargin = l.b((Context)localObject13, 2);
    ((WeImageView)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    localObject11 = ((WeImageView)localObject10).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "context");
    ((WeImageView)localObject10).setIconColor(l.c((Context)localObject11, 2131166303));
    ((WeImageView)localObject10).setBackgroundResource(2130841197);
    ((ViewGroup)localObject8).addView((View)localObject9);
    ((ViewGroup)localObject7).addView(paramContext);
    paramContext = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    paramContext.setAccessible(true);
    paramContext = (View)paramContext.newInstance(new Object[] { ((ViewGroup)localObject7).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "view");
    localObject8 = (TextView)paramContext;
    l.c((View)localObject8, "score");
    localObject9 = RelativeLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject9).setAccessible(true);
    localObject9 = (ViewGroup.LayoutParams)((Constructor)localObject9).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "lp");
    localObject10 = (RelativeLayout.LayoutParams)localObject9;
    ((RelativeLayout.LayoutParams)localObject10).width = -2;
    ((RelativeLayout.LayoutParams)localObject10).height = -2;
    ((RelativeLayout.LayoutParams)localObject10).addRule(18, "name_area".hashCode());
    ((RelativeLayout.LayoutParams)localObject10).addRule(3, "name_area".hashCode());
    ((TextView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    ((TextView)localObject8).setGravity(8388627);
    localObject9 = ((TextView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((TextView)localObject8).setTextColor(l.c((Context)localObject9, 2131165205));
    localObject9 = ((TextView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((TextView)localObject8).setTextSize(0, l.b((Context)localObject9, 12));
    ((ViewGroup)localObject7).addView(paramContext);
    ((ViewGroup)localObject5).addView((View)localObject6);
    paramContext = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
    paramContext.setAccessible(true);
    paramContext = (View)paramContext.newInstance(new Object[] { ((ViewGroup)localObject5).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "view");
    localObject6 = (LinearLayout)paramContext;
    localObject7 = (View)localObject6;
    l.c((View)localObject7, "status_ll");
    localObject8 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject8).setAccessible(true);
    localObject8 = (ViewGroup.LayoutParams)((Constructor)localObject8).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "lp");
    localObject9 = (LinearLayout.LayoutParams)localObject8;
    ((LinearLayout.LayoutParams)localObject9).width = -2;
    localObject10 = ((LinearLayout)localObject6).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject10, "context");
    ((LinearLayout.LayoutParams)localObject9).height = l.b((Context)localObject10, 24);
    localObject10 = ((LinearLayout)localObject6).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject10, "context");
    ((LinearLayout.LayoutParams)localObject9).leftMargin = l.b((Context)localObject10, 30);
    localObject10 = ((LinearLayout)localObject6).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject10, "context");
    ((LinearLayout.LayoutParams)localObject9).rightMargin = l.b((Context)localObject10, 16);
    ((LinearLayout)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject8);
    ((LinearLayout)localObject6).setOrientation(0);
    ((LinearLayout)localObject6).setGravity(16);
    localObject8 = ((LinearLayout)localObject6).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "context");
    l.a((View)localObject7, l.b((Context)localObject8, 6));
    localObject8 = ((LinearLayout)localObject6).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "context");
    l.b((View)localObject7, l.b((Context)localObject8, 6));
    ((LinearLayout)localObject6).setVisibility(8);
    localObject6 = (ViewGroup)localObject6;
    localObject7 = ImageView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject7).setAccessible(true);
    localObject7 = (View)((Constructor)localObject7).newInstance(new Object[] { ((ViewGroup)localObject6).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "view");
    localObject8 = (ImageView)localObject7;
    localObject9 = (View)localObject8;
    l.c((View)localObject9, "status_icon");
    localObject10 = ((ImageView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject10, "context");
    l.a((View)localObject9, l.b((Context)localObject10, 2));
    localObject9 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject9).setAccessible(true);
    localObject9 = (ViewGroup.LayoutParams)((Constructor)localObject9).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "lp");
    localObject10 = (LinearLayout.LayoutParams)localObject9;
    ((LinearLayout.LayoutParams)localObject10).width = -2;
    ((LinearLayout.LayoutParams)localObject10).height = -2;
    ((ImageView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    localObject9 = ((ImageView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((ImageView)localObject8).setMinimumWidth(l.b((Context)localObject9, 14));
    localObject9 = ((ImageView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((ImageView)localObject8).setMinimumHeight(l.b((Context)localObject9, 14));
    ((ViewGroup)localObject6).addView((View)localObject7);
    localObject7 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject7).setAccessible(true);
    localObject7 = (View)((Constructor)localObject7).newInstance(new Object[] { ((ViewGroup)localObject6).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "view");
    localObject8 = (TextView)localObject7;
    l.c((View)localObject8, "status_desc");
    localObject9 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject9).setAccessible(true);
    localObject9 = (ViewGroup.LayoutParams)((Constructor)localObject9).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "lp");
    localObject10 = (LinearLayout.LayoutParams)localObject9;
    ((LinearLayout.LayoutParams)localObject10).width = -2;
    ((LinearLayout.LayoutParams)localObject10).height = -2;
    localObject11 = ((TextView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "context");
    ((LinearLayout.LayoutParams)localObject10).leftMargin = l.b((Context)localObject11, 3);
    ((TextView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    ((TextView)localObject8).setGravity(8388627);
    localObject9 = ((TextView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((TextView)localObject8).setTextColor(l.c((Context)localObject9, 2131168532));
    localObject9 = ((TextView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((TextView)localObject8).setTextSize(0, l.b((Context)localObject9, 12));
    ((TextView)localObject8).setSingleLine();
    ((TextView)localObject8).setEllipsize(TextUtils.TruncateAt.END);
    ((ViewGroup)localObject6).addView((View)localObject7);
    ((ViewGroup)localObject5).addView(paramContext);
    paramContext = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
    paramContext.setAccessible(true);
    paramContext = (View)paramContext.newInstance(new Object[] { ((ViewGroup)localObject5).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "view");
    localObject7 = (LinearLayout)paramContext;
    l.c((View)localObject7, "wxa_brand_ll");
    ((LinearLayout)localObject7).setOrientation(0);
    localObject6 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject6).setAccessible(true);
    localObject6 = (ViewGroup.LayoutParams)((Constructor)localObject6).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "lp");
    localObject8 = (LinearLayout.LayoutParams)localObject6;
    ((LinearLayout.LayoutParams)localObject8).width = -2;
    localObject9 = ((LinearLayout)localObject7).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((LinearLayout.LayoutParams)localObject8).height = l.b((Context)localObject9, 20);
    localObject9 = ((LinearLayout)localObject7).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((LinearLayout.LayoutParams)localObject8).leftMargin = l.b((Context)localObject9, 30);
    localObject9 = ((LinearLayout)localObject7).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((LinearLayout.LayoutParams)localObject8).rightMargin = l.b((Context)localObject9, 16);
    ((LinearLayout)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    localObject6 = (ViewGroup)localObject7;
    localObject8 = ImageView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject8).setAccessible(true);
    localObject8 = (View)((Constructor)localObject8).newInstance(new Object[] { ((ViewGroup)localObject6).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "view");
    localObject9 = (ImageView)localObject8;
    l.c((View)localObject9, "wxa_brand_iv");
    localObject10 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject10).setAccessible(true);
    localObject10 = (ViewGroup.LayoutParams)((Constructor)localObject10).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject10, "lp");
    localObject11 = (LinearLayout.LayoutParams)localObject10;
    localObject12 = ((ImageView)localObject9).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject12, "context");
    ((LinearLayout.LayoutParams)localObject11).width = l.b((Context)localObject12, 16);
    localObject12 = ((ImageView)localObject9).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject12, "context");
    ((LinearLayout.LayoutParams)localObject11).height = l.b((Context)localObject12, 16);
    ((LinearLayout.LayoutParams)localObject11).gravity = 16;
    ((ImageView)localObject9).setLayoutParams((ViewGroup.LayoutParams)localObject10);
    ((LinearLayout)localObject7).setGravity(17);
    ((ViewGroup)localObject6).addView((View)localObject8);
    localObject7 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject7).setAccessible(true);
    localObject7 = (View)((Constructor)localObject7).newInstance(new Object[] { ((ViewGroup)localObject6).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "view");
    localObject8 = (TextView)localObject7;
    l.c((View)localObject8, "wxa_brand_tv");
    localObject9 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject9).setAccessible(true);
    localObject9 = (ViewGroup.LayoutParams)((Constructor)localObject9).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "lp");
    localObject10 = (LinearLayout.LayoutParams)localObject9;
    ((LinearLayout.LayoutParams)localObject10).width = -2;
    ((LinearLayout.LayoutParams)localObject10).height = -2;
    localObject11 = ((TextView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject11, "context");
    ((LinearLayout.LayoutParams)localObject10).setMarginStart(l.b((Context)localObject11, 4));
    ((LinearLayout.LayoutParams)localObject10).gravity = 16;
    ((TextView)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    localObject9 = ((TextView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((TextView)localObject8).setTextSize(0, l.b((Context)localObject9, 14));
    localObject9 = ((TextView)localObject8).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "context");
    ((TextView)localObject8).setTextColor(l.c((Context)localObject9, 2131165220));
    ((ViewGroup)localObject6).addView((View)localObject7);
    ((ViewGroup)localObject5).addView(paramContext);
    ((ViewGroup)localObject3).addView((View)localObject4);
    addView((View)localObject2);
    paramContext = ImageView.class.getDeclaredConstructor(new Class[] { Context.class });
    paramContext.setAccessible(true);
    paramContext = (View)paramContext.newInstance(new Object[] { getContext() });
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "view");
    localObject2 = (ImageView)paramContext;
    l.c((View)localObject2, "menu_line");
    localObject3 = LinearLayout.LayoutParams.class.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
    ((Constructor)localObject3).setAccessible(true);
    localObject1 = (ViewGroup.LayoutParams)((Constructor)localObject3).newInstance(new Object[] { localObject1, localObject1 });
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "lp");
    localObject3 = (LinearLayout.LayoutParams)localObject1;
    ((LinearLayout.LayoutParams)localObject3).width = -1;
    localObject4 = ((ImageView)localObject2).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "context");
    ((LinearLayout.LayoutParams)localObject3).height = l.a((Context)localObject4, 2131296955);
    localObject4 = ((ImageView)localObject2).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "context");
    ((ImageView)localObject2).setBackgroundColor(l.c((Context)localObject4, 2131165269));
    localObject4 = ((ImageView)localObject2).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "context");
    ((LinearLayout.LayoutParams)localObject3).leftMargin = l.b((Context)localObject4, 12);
    ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    addView(paramContext);
  }
  
  public final void setPage(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "page");
    Object localObject1 = parame.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "page.appId");
    int i = a((String)localObject1);
    int j = 8;
    if (i == 1) {
      l.a(this, "trading_guarantee_icon").setVisibility(0);
    } else {
      l.a(this, "trading_guarantee_icon").setVisibility(8);
    }
    localObject1 = (Function0)new c.e(this, parame);
    Object localObject2 = l.a(this, "icon");
    AppBrandSimpleImageLoader localAppBrandSimpleImageLoader = AppBrandSimpleImageLoader.instance();
    ImageView localImageView = (ImageView)l.a((View)localObject2, "icon");
    com.tencent.luggage.wxa.ed.d locald = parame.f();
    Intrinsics.checkExpressionValueIsNotNull(locald, "page.runtime");
    localAppBrandSimpleImageLoader.attach(localImageView, locald.i().K, 2130842125, (AppBrandSimpleImageLoader.h)new WxaIconTransformation());
    ((View)localObject2).setOnClickListener((View.OnClickListener)new c.b(parame, (Function0)localObject1));
    l.a(this, "name_area").setOnClickListener((View.OnClickListener)new c.d((Function0)localObject1));
    localObject1 = (TextView)l.a(this, "name");
    localObject2 = ((TextView)localObject1).getPaint();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "paint");
    ((TextPaint)localObject2).setFakeBoldText(true);
    localObject2 = parame.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "page.runtime");
    ((TextView)localObject1).setText((CharSequence)((com.tencent.luggage.wxa.ed.d)localObject2).i().I);
    localObject2 = (TextView)l.a(this, "debug_type_desc");
    localObject1 = parame.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "page.runtime");
    i = ((com.tencent.luggage.wxa.ed.d)localObject1).i().c();
    if (i != 1)
    {
      if (i != 2) {
        localObject1 = null;
      } else {
        localObject1 = l.d(this.b, 2131886757);
      }
    }
    else {
      localObject1 = l.d(this.b, 2131886758);
    }
    localObject1 = (CharSequence)localObject1;
    ((TextView)localObject2).setText((CharSequence)localObject1);
    if ((localObject1 != null) && (!StringsKt.isBlank((CharSequence)localObject1))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      i = 8;
    } else {
      i = 0;
    }
    ((TextView)localObject2).setVisibility(i);
    localObject1 = (ImageView)l.a(this, "original_label");
    localObject2 = parame.f();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "page.runtime");
    i = j;
    if (((com.tencent.luggage.wxa.ed.d)localObject2).j().J == 1) {
      i = 0;
    }
    ((ImageView)localObject1).setVisibility(i);
    localObject1 = (TextView)l.a(this, "score");
    BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, null, null, (Function2)new c.c((TextView)localObject1, null, parame), 3, null);
    localObject1 = (LinearLayout)l.a(this, "status_ll");
    localObject1 = (ImageView)l.a(this, "status_icon");
    localObject1 = (TextView)l.a(this, "status_desc");
    localObject1 = (LinearLayout)l.a(this, "wxa_brand_ll");
    ((ImageView)l.a(this, "wxa_brand_iv")).setImageResource(a(parame.u()));
    localObject1 = (TextView)l.a(this, "wxa_brand_tv");
    if (parame.u())
    {
      parame = ((TextView)localObject1).getContext();
      Intrinsics.checkExpressionValueIsNotNull(parame, "context");
      parame = (CharSequence)l.d(parame, 2131918157);
    }
    else
    {
      parame = ((TextView)localObject1).getContext();
      Intrinsics.checkExpressionValueIsNotNull(parame, "context");
      parame = (CharSequence)l.d(parame, 2131918156);
    }
    ((TextView)localObject1).setText(parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.c
 * JD-Core Version:    0.7.0.1
 */