package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.BaseActivity.a;
import com.tencent.mm.ui.base.l;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaProfileActivity;", "Lcom/tencent/mm/ui/BaseActivity;", "()V", "<set-?>", "", "category", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "category$delegate", "Lkotlin/properties/ReadWriteProperty;", "context", "registerBody", "getRegisterBody", "setRegisterBody", "registerBody$delegate", "root", "Landroid/view/ViewGroup;", "", "tradingGuaranteeFlag", "getTradingGuaranteeFlag", "()I", "setTradingGuaranteeFlag", "(I)V", "tradingGuaranteeFlag$delegate", "wxaAppID", "", "wxaAverageScore", "getWxaAverageScore", "()D", "setWxaAverageScore", "(D)V", "wxaAverageScore$delegate", "wxaDesc", "getWxaDesc", "setWxaDesc", "wxaDesc$delegate", "wxaIconUrl", "getWxaIconUrl", "setWxaIconUrl", "wxaIconUrl$delegate", "wxaNickName", "getWxaNickName", "setWxaNickName", "wxaNickName$delegate", "wxaUsername", "fillData", "", "getLayoutId", "layout", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onStart", "Companion", "WxaProfileServiceView", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class WxaProfileActivity
  extends BaseActivity
{
  public static final WxaProfileActivity.Companion Companion = new WxaProfileActivity.Companion(null);
  private ViewGroup b;
  private String c;
  private String d;
  private final WxaProfileActivity e = (WxaProfileActivity)this;
  private final ReadWriteProperty f;
  private final ReadWriteProperty g;
  private final ReadWriteProperty h;
  private final ReadWriteProperty i;
  private final ReadWriteProperty j;
  private final ReadWriteProperty k;
  private final ReadWriteProperty l;
  
  public WxaProfileActivity()
  {
    Object localObject = Delegates.INSTANCE;
    this.f = ((ReadWriteProperty)new WxaProfileActivity..special..inlined.observable.1("", "", this));
    localObject = Delegates.INSTANCE;
    this.g = ((ReadWriteProperty)new WxaProfileActivity..special..inlined.observable.2("", "", this));
    localObject = Delegates.INSTANCE;
    localObject = Integer.valueOf(0);
    this.h = ((ReadWriteProperty)new WxaProfileActivity..special..inlined.observable.3(localObject, localObject, this));
    localObject = Delegates.INSTANCE;
    this.i = ((ReadWriteProperty)new WxaProfileActivity..special..inlined.observable.4("", "", this));
    localObject = Delegates.INSTANCE;
    localObject = Double.valueOf(0.0D);
    this.j = ((ReadWriteProperty)new WxaProfileActivity..special..inlined.observable.5(localObject, localObject, this));
    localObject = Delegates.INSTANCE;
    this.k = ((ReadWriteProperty)new WxaProfileActivity..special..inlined.observable.6("", "", this));
    localObject = Delegates.INSTANCE;
    this.l = ((ReadWriteProperty)new WxaProfileActivity..special..inlined.observable.7("", "", this));
  }
  
  private final void a()
  {
    String str = getIntent().getStringExtra("_key_appid");
    if (str != null) {
      BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, null, null, (Function2)new WxaProfileActivity.fillData..inlined.let.lambda.1(str, null, this), 3, null);
    }
  }
  
  private final void a(double paramDouble)
  {
    this.j.setValue(this, a[4], Double.valueOf(paramDouble));
  }
  
  private final void a(int paramInt)
  {
    this.h.setValue(this, a[2], Integer.valueOf(paramInt));
  }
  
  private final void a(String paramString)
  {
    this.f.setValue(this, a[0], paramString);
  }
  
  private final ViewGroup b()
  {
    Object localObject1 = new ScrollView((Context)this.e);
    ((ScrollView)localObject1).setVerticalScrollBarEnabled(false);
    ((ScrollView)localObject1).setOverScrollMode(2);
    ((ScrollView)localObject1).setBackgroundResource(2131165936);
    ((ScrollView)localObject1).setFillViewport(true);
    localObject1 = (ViewGroup)localObject1;
    Object localObject2 = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject2).setAccessible(true);
    localObject2 = (View)((Constructor)localObject2).newInstance(new Object[] { ((ViewGroup)localObject1).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "view");
    Object localObject3 = (LinearLayout)localObject2;
    ((LinearLayout)localObject3).setFocusableInTouchMode(true);
    ((LinearLayout)localObject3).setFocusable(true);
    ((LinearLayout)localObject3).setOrientation(1);
    ((LinearLayout)localObject3).setBackgroundColor(l.c(this, 2131165188));
    localObject3 = (ViewGroup)localObject3;
    Object localObject4 = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject4).setAccessible(true);
    localObject4 = (View)((Constructor)localObject4).newInstance(new Object[] { ((ViewGroup)localObject3).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "view");
    Object localObject5 = (LinearLayout)localObject4;
    ((LinearLayout)localObject5).setOrientation(1);
    Object localObject6 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject6).gravity = 1;
    Object localObject7 = Unit.INSTANCE;
    ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
    ((LinearLayout)localObject5).setBackgroundColor(l.c(this, 2131168464));
    localObject5 = (ViewGroup)localObject5;
    localObject6 = ImageView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject6).setAccessible(true);
    localObject6 = (View)((Constructor)localObject6).newInstance(new Object[] { ((ViewGroup)localObject5).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "view");
    localObject7 = (ImageView)localObject6;
    l.c((View)localObject7, "wxa_icon");
    Object localObject8 = new LinearLayout.LayoutParams(l.a(this, 2131296351), l.a(this, 2131296351));
    ((LinearLayout.LayoutParams)localObject8).topMargin = l.a(this, 2131296336);
    ((LinearLayout.LayoutParams)localObject8).gravity = 1;
    Object localObject9 = Unit.INSTANCE;
    ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
    ((ViewGroup)localObject5).addView((View)localObject6);
    localObject6 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject6).setAccessible(true);
    localObject6 = (View)((Constructor)localObject6).newInstance(new Object[] { ((ViewGroup)localObject5).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "view");
    localObject7 = (TextView)localObject6;
    l.c((View)localObject7, "wxa_name");
    localObject8 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject8).gravity = 1;
    ((LinearLayout.LayoutParams)localObject8).topMargin = l.a(this, 2131296336);
    ((LinearLayout.LayoutParams)localObject8).setMarginStart(l.a(this, 2131296347));
    ((LinearLayout.LayoutParams)localObject8).setMarginEnd(l.a(this, 2131296347));
    localObject9 = Unit.INSTANCE;
    ((TextView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
    ((TextView)localObject7).setTextSize(0, l.a(this, 2131296390));
    ((TextView)localObject7).setTextColor(l.c(this, 2131166595));
    ((TextView)localObject7).setGravity(17);
    ((TextView)localObject7).setMaxLines(2);
    ((TextView)localObject7).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject7).setTypeface(((TextView)localObject7).getTypeface(), 1);
    ((ViewGroup)localObject5).addView((View)localObject6);
    localObject6 = ImageView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject6).setAccessible(true);
    localObject6 = (View)((Constructor)localObject6).newInstance(new Object[] { ((ViewGroup)localObject5).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "view");
    localObject7 = (ImageView)localObject6;
    l.c((View)localObject7, "trading_guarantee_icon");
    localObject8 = new LinearLayout.LayoutParams(l.a(this, 2131296321), l.a(this, 2131296339));
    ((LinearLayout.LayoutParams)localObject8).gravity = 1;
    ((LinearLayout.LayoutParams)localObject8).topMargin = l.a(this, 2131296329);
    localObject9 = Unit.INSTANCE;
    ((ImageView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
    ((ImageView)localObject7).setVisibility(8);
    ((ImageView)localObject7).setBackgroundResource(2130838681);
    ((ViewGroup)localObject5).addView((View)localObject6);
    localObject6 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject6).setAccessible(true);
    localObject6 = (View)((Constructor)localObject6).newInstance(new Object[] { ((ViewGroup)localObject5).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "view");
    localObject7 = (TextView)localObject6;
    l.c((View)localObject7, "wxa_desc");
    localObject8 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject8).gravity = 1;
    ((LinearLayout.LayoutParams)localObject8).setMarginStart(l.a(this, 2131296347));
    ((LinearLayout.LayoutParams)localObject8).setMarginEnd(l.a(this, 2131296347));
    ((LinearLayout.LayoutParams)localObject8).topMargin = l.a(this, 2131296336);
    localObject9 = Unit.INSTANCE;
    ((TextView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
    ((TextView)localObject7).setLineSpacing(0.0F, 1.4F);
    ((TextView)localObject7).setTextSize(0, l.b(this, 15));
    ((TextView)localObject7).setTextColor(l.c(this, 2131165207));
    ((TextView)localObject7).setGravity(17);
    ((ViewGroup)localObject5).addView((View)localObject6);
    localObject6 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject6).setAccessible(true);
    localObject6 = (View)((Constructor)localObject6).newInstance(new Object[] { ((ViewGroup)localObject5).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "view");
    localObject7 = (TextView)localObject6;
    l.c((View)localObject7, "star_not_enough");
    localObject8 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject8).gravity = 1;
    ((LinearLayout.LayoutParams)localObject8).setMarginStart(l.a(this, 2131296347));
    ((LinearLayout.LayoutParams)localObject8).setMarginEnd(l.a(this, 2131296347));
    ((LinearLayout.LayoutParams)localObject8).topMargin = l.a(this, 2131296336);
    localObject9 = Unit.INSTANCE;
    ((TextView)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
    ((TextView)localObject7).setGravity(17);
    ((TextView)localObject7).setTextSize(0, l.b(this, 15));
    ((TextView)localObject7).setText((CharSequence)l.d(this, 2131918177));
    ((TextView)localObject7).setTextColor(l.c(this, 2131165951));
    ((TextView)localObject7).setVisibility(8);
    ((ViewGroup)localObject5).addView((View)localObject6);
    localObject6 = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject6).setAccessible(true);
    localObject6 = (View)((Constructor)localObject6).newInstance(new Object[] { ((ViewGroup)localObject5).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "view");
    localObject7 = (LinearLayout)localObject6;
    l.c((View)localObject7, "star_layout");
    ((LinearLayout)localObject7).setOrientation(0);
    localObject8 = new LinearLayout.LayoutParams(-1, l.b(this, 20));
    ((LinearLayout.LayoutParams)localObject8).gravity = 17;
    ((LinearLayout.LayoutParams)localObject8).topMargin = l.a(this, 2131296336);
    localObject9 = Unit.INSTANCE;
    ((LinearLayout)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
    ((LinearLayout)localObject7).setGravity(17);
    localObject8 = (ViewGroup)localObject7;
    localObject9 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject9).setAccessible(true);
    localObject9 = (View)((Constructor)localObject9).newInstance(new Object[] { ((ViewGroup)localObject8).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject9, "view");
    Object localObject10 = (TextView)localObject9;
    l.c((View)localObject10, "star_text");
    Object localObject11 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject11).gravity = 17;
    Unit localUnit = Unit.INSTANCE;
    ((TextView)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
    ((TextView)localObject10).setTextSize(0, l.a(this, 2131296390));
    ((TextView)localObject10).setTextColor(l.c(this, 2131166595));
    ((TextView)localObject10).setText((CharSequence)"3.5");
    ((TextView)localObject10).setTypeface(((TextView)localObject10).getTypeface(), 1);
    ((TextView)localObject10).setGravity(17);
    ((ViewGroup)localObject8).addView((View)localObject9);
    LayoutInflater.from(((LinearLayout)localObject7).getContext()).inflate(2131625249, (ViewGroup)localObject8, true);
    ((LinearLayout)localObject7).setVisibility(8);
    ((ViewGroup)localObject5).addView((View)localObject6);
    localObject6 = LinearLayout.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject6).setAccessible(true);
    localObject6 = (View)((Constructor)localObject6).newInstance(new Object[] { ((ViewGroup)localObject5).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "view");
    localObject7 = (LinearLayout)localObject6;
    ((LinearLayout)localObject7).setOrientation(0);
    localObject8 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject8).gravity = 1;
    ((LinearLayout.LayoutParams)localObject8).topMargin = l.a(this, 2131296339);
    ((LinearLayout.LayoutParams)localObject8).bottomMargin = l.a(this, 2131296339);
    localObject9 = Unit.INSTANCE;
    ((LinearLayout)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject8);
    localObject7 = (ViewGroup)localObject7;
    localObject8 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject8).setAccessible(true);
    localObject8 = (View)((Constructor)localObject8).newInstance(new Object[] { ((ViewGroup)localObject7).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "view");
    localObject9 = (TextView)localObject8;
    l.c((View)localObject9, "enter_app_bt");
    localObject10 = new LinearLayout.LayoutParams(-2, -2);
    int m = l.a(this, 2131296336);
    ((TextView)localObject9).setPadding(m, m, m, m);
    localObject11 = Unit.INSTANCE;
    localObject11 = Unit.INSTANCE;
    ((TextView)localObject9).setLayoutParams((ViewGroup.LayoutParams)localObject10);
    ((TextView)localObject9).setText((CharSequence)l.d(this, 2131918173));
    ((TextView)localObject9).setTypeface(((TextView)localObject9).getTypeface(), 1);
    ((TextView)localObject9).setTextColor(l.c(this, 2131165616));
    ((TextView)localObject9).setTextSize(0, l.b(this, 17));
    ((TextView)localObject9).setBackground(getDrawable(2130851742));
    ((ViewGroup)localObject7).addView((View)localObject8);
    localObject8 = View.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject8).setAccessible(true);
    localObject8 = (View)((Constructor)localObject8).newInstance(new Object[] { ((ViewGroup)localObject7).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "view");
    localObject9 = new LinearLayout.LayoutParams(l.b(this, 1), -1);
    ((LinearLayout.LayoutParams)localObject9).topMargin = l.a(this, 2131296336);
    ((LinearLayout.LayoutParams)localObject9).bottomMargin = l.a(this, 2131296336);
    ((LinearLayout.LayoutParams)localObject9).setMarginStart(l.a(this, 2131296342));
    ((LinearLayout.LayoutParams)localObject9).setMarginEnd(l.a(this, 2131296342));
    localObject10 = Unit.INSTANCE;
    ((View)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject9);
    ((View)localObject8).setBackgroundColor(l.c(this, 2131165198));
    ((ViewGroup)localObject7).addView((View)localObject8);
    localObject8 = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject8).setAccessible(true);
    localObject8 = (View)((Constructor)localObject8).newInstance(new Object[] { ((ViewGroup)localObject7).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "view");
    localObject9 = (TextView)localObject8;
    l.c((View)localObject9, "enter_wechat");
    localObject10 = new LinearLayout.LayoutParams(-2, -2);
    m = l.a(this, 2131296336);
    ((TextView)localObject9).setPadding(m, m, m, m);
    localObject11 = Unit.INSTANCE;
    localObject11 = Unit.INSTANCE;
    ((TextView)localObject9).setLayoutParams((ViewGroup.LayoutParams)localObject10);
    ((TextView)localObject9).setText((CharSequence)l.d(this, 2131918174));
    ((TextView)localObject9).setTypeface(((TextView)localObject9).getTypeface(), 1);
    ((TextView)localObject9).setTextColor(l.c(this, 2131165616));
    ((TextView)localObject9).setTextSize(0, l.b(this, 17));
    ((TextView)localObject9).setBackground(getDrawable(2130851742));
    ((ViewGroup)localObject7).addView((View)localObject8);
    ((ViewGroup)localObject5).addView((View)localObject6);
    ((ViewGroup)localObject3).addView((View)localObject4);
    localObject4 = View.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject4).setAccessible(true);
    localObject4 = (View)((Constructor)localObject4).newInstance(new Object[] { ((ViewGroup)localObject3).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "view");
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, l.a(this, 2131296353)));
    ((ViewGroup)localObject3).addView((View)localObject4);
    localObject4 = WxaProfileActivity.WxaProfileServiceView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject4).setAccessible(true);
    localObject4 = (View)((Constructor)localObject4).newInstance(new Object[] { ((ViewGroup)localObject3).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "view");
    localObject5 = (WxaProfileActivity.WxaProfileServiceView)localObject4;
    ((WxaProfileActivity.WxaProfileServiceView)localObject5).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, l.b(this, 52)));
    localObject6 = ((WxaProfileActivity.WxaProfileServiceView)localObject5).getContext().getString(2131918176);
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "context.getString(R.stri…profile_service_category)");
    ((WxaProfileActivity.WxaProfileServiceView)localObject5).setItemHeader((String)localObject6);
    ((WxaProfileActivity.WxaProfileServiceView)localObject5).setItemDesc("");
    ((WxaProfileActivity.WxaProfileServiceView)localObject5).setDescName("service_category");
    ((ViewGroup)localObject3).addView((View)localObject4);
    localObject4 = View.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject4).setAccessible(true);
    localObject4 = (View)((Constructor)localObject4).newInstance(new Object[] { ((ViewGroup)localObject3).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "view");
    localObject5 = new LinearLayout.LayoutParams(-1, 1);
    ((LinearLayout.LayoutParams)localObject5).setMarginStart(l.a(this, 2131296336));
    localObject6 = Unit.INSTANCE;
    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
    ((View)localObject4).setBackgroundColor(l.c(this, 2131165198));
    ((ViewGroup)localObject3).addView((View)localObject4);
    localObject4 = WxaProfileActivity.WxaProfileServiceView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject4).setAccessible(true);
    localObject4 = (View)((Constructor)localObject4).newInstance(new Object[] { ((ViewGroup)localObject3).getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "view");
    localObject5 = (WxaProfileActivity.WxaProfileServiceView)localObject4;
    ((WxaProfileActivity.WxaProfileServiceView)localObject5).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, l.b(this, 52)));
    localObject6 = ((WxaProfileActivity.WxaProfileServiceView)localObject5).getContext().getString(2131918178);
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "context.getString(R.stri…xa_proflie_register_body)");
    ((WxaProfileActivity.WxaProfileServiceView)localObject5).setItemHeader((String)localObject6);
    ((WxaProfileActivity.WxaProfileServiceView)localObject5).setItemDesc("");
    ((WxaProfileActivity.WxaProfileServiceView)localObject5).setDescName("service_desc");
    ((ViewGroup)localObject3).addView((View)localObject4);
    ((ViewGroup)localObject1).addView((View)localObject2);
    localObject2 = Unit.INSTANCE;
    return localObject1;
  }
  
  private final void b(String paramString)
  {
    this.g.setValue(this, a[1], paramString);
  }
  
  private final void c(String paramString)
  {
    this.i.setValue(this, a[3], paramString);
  }
  
  private final void d(String paramString)
  {
    this.k.setValue(this, a[5], paramString);
  }
  
  private final void e(String paramString)
  {
    this.l.setValue(this, a[6], paramString);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return 2131625248;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    setTheme(2131952519);
    super.onCreate(paramBundle);
    this.b = b();
    paramBundle = this.b;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("root");
    }
    setContentView((View)paramBundle, new ViewGroup.LayoutParams(-1, -1));
    setBackBtn((MenuItem.OnMenuItemClickListener)new WxaProfileActivity.onCreate.1(this), 2130837663, BaseActivity.a.b);
    a();
    paramBundle = this.b;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("root");
    }
    ((TextView)l.a((View)paramBundle, "enter_app_bt")).setOnClickListener((View.OnClickListener)new WxaProfileActivity.onCreate.2(this));
    paramBundle = this.b;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("root");
    }
    ((TextView)l.a((View)paramBundle, "enter_wechat")).setOnClickListener((View.OnClickListener)new WxaProfileActivity.onCreate.3(this));
    if ((Build.VERSION.SDK_INT >= 21) && (getSupportActionBar() != null))
    {
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "supportActionBar!!");
      paramBundle.setElevation(0.0F);
    }
    setActionBarColor(l.c((Context)this.e, 2131165190));
  }
  
  protected void onNewIntent(@NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    if (!isFinishing()) {
      a();
    }
  }
  
  public boolean onOptionsItemSelected(@NotNull MenuItem paramMenuItem)
  {
    Intrinsics.checkParameterIsNotNull(paramMenuItem, "item");
    if (paramMenuItem.getItemId() != 16908332) {
      return super.onOptionsItemSelected(paramMenuItem);
    }
    onBackPressed();
    return false;
  }
  
  protected void onStart()
  {
    super.onStart();
    Object localObject = getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null) {
        ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFEFF);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity
 * JD-Core Version:    0.7.0.1
 */