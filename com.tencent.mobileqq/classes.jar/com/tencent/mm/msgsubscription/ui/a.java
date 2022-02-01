package com.tencent.mm.msgsubscription.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "isSingleMode", "", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;Z)V", "_position", "", "value", "", "actionDesc", "getActionDesc", "()Ljava/lang/String;", "setActionDesc", "(Ljava/lang/String;)V", "actionTv", "Landroid/widget/TextView;", "adapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "alwaysKeepCb", "Landroid/widget/CheckBox;", "alwaysKeepText", "getAlwaysKeepText", "setAlwaysKeepText", "alwaysKeepTv", "alwaysKeepView", "Landroid/view/View;", "alwaysRejectText", "getAlwaysRejectText", "setAlwaysRejectText", "alwaysRejectTv", "appName", "getAppName", "setAppName", "appNameTv", "cancelBtn", "Landroid/widget/Button;", "cancelBtnText", "getCancelBtnText", "setCancelBtnText", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "defaultIconRes", "getDefaultIconRes", "()I", "setDefaultIconRes", "(I)V", "desc", "getDesc", "setDesc", "descTV", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "dialogListener", "getDialogListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "setDialogListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;)V", "dialogView", "dialogViewContainer", "Landroid/widget/FrameLayout;", "iconIv", "Landroid/widget/ImageView;", "iconUrl", "getIconUrl", "setIconUrl", "", "mRootView", "okBtn", "okBtnText", "getOkBtnText", "setOkBtnText", "recyclerViewContainer", "sampleBack", "sampleRoot", "sampleShowing", "sampleTitle", "getSampleTitle", "setSampleTitle", "sampleViewId", "Ljava/lang/Integer;", "sampleViewTitle", "scrollView", "Landroid/widget/ScrollView;", "showAlwaysKeepView", "getShowAlwaysKeepView", "()Z", "setShowAlwaysKeepView", "(Z)V", "showAlwaysRejectView", "getShowAlwaysRejectView", "setShowAlwaysRejectView", "templateShowSampleListener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "getTemplateShowSampleListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "setTemplateShowSampleListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;)V", "tip", "getTip", "setTip", "tipTv", "topSampleBtn", "addRecyclerView", "", "alwaysKeepSelected", "applyRotation", "rotation", "cancel", "closeSampleView", "dismiss", "dispatchCancelEvent", "dispatchEvent", "event", "getContentView", "getPosition", "getRotation", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onCheckedCountChanged", "size", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setPosition", "position", "showSample", "item", "startSampleAnimation", "show", "Landroid/animation/Animator$AnimatorListener;", "setBoldStyle", "Companion", "Item", "ItemAdapter", "Listener", "SubscribeRequestDialogListener", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  implements i
{
  public static final a.a a = new a.a(null);
  @Nullable
  private a.a.a A;
  @NotNull
  private String B;
  @NotNull
  private String C;
  @NotNull
  private String D;
  @NotNull
  private String E;
  private boolean F;
  @NotNull
  private String G;
  private boolean H;
  @NotNull
  private String I;
  @NotNull
  private String J;
  @NotNull
  private String K;
  @NotNull
  private String L;
  @NotNull
  private String M;
  private int N;
  @Nullable
  private a.e O;
  private int P;
  private final Context Q;
  private a.d R;
  private View b;
  private FrameLayout c;
  private ScrollView d;
  private a.c e;
  private ImageView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private Button k;
  private Button l;
  private View m;
  private FrameLayout n;
  private View o;
  private View p;
  private TextView q;
  private TextView r;
  private View s;
  private CheckBox t;
  private TextView u;
  private View v;
  private List<a.b> w;
  private boolean x;
  private Integer y;
  private l z;
  
  public a(@NotNull Context paramContext, @NotNull List<a.b> paramList, @Nullable a.d paramd, boolean paramBoolean)
  {
    this.Q = paramContext;
    this.R = paramd;
    paramContext = LayoutInflater.from(this.Q).inflate(2131629347, null);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "LayoutInflater.from(cont…msg_request_dialog, null)");
    this.b = paramContext;
    this.w = ((List)new ArrayList());
    this.B = "";
    this.C = "";
    this.D = "";
    this.E = "";
    this.F = true;
    this.G = "";
    this.H = true;
    this.I = "";
    this.J = "";
    this.K = "";
    this.L = "";
    this.M = "";
    paramContext = this.b.findViewById(2131436063);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.item_list_container)");
    this.c = ((FrameLayout)paramContext);
    paramContext = this.b.findViewById(2131445370);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.scroll_view)");
    this.d = ((ScrollView)paramContext);
    paramContext = this.b.findViewById(2131435246);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.icon_iv)");
    this.f = ((ImageView)paramContext);
    paramContext = this.b.findViewById(2131427499);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.action)");
    this.g = ((TextView)paramContext);
    paramContext = this.b.findViewById(2131431733);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.desc)");
    this.i = ((TextView)paramContext);
    paramContext = this.b.findViewById(2131447403);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.tip)");
    this.j = ((TextView)paramContext);
    paramContext = this.b.findViewById(2131428633);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.app_name_tv)");
    this.h = ((TextView)paramContext);
    paramContext = this.b.findViewById(2131431893);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.dialog_cancel)");
    this.k = ((Button)paramContext);
    paramContext = this.b.findViewById(2131431904);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.dialog_ok)");
    this.l = ((Button)paramContext);
    paramContext = this.b.findViewById(2131445226);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.sample_root)");
    this.m = paramContext;
    paramContext = this.b.findViewById(2131445227);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.sample_view_title)");
    this.u = ((TextView)paramContext);
    paramContext = this.b.findViewById(2131431917);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.dialog_view_container)");
    this.n = ((FrameLayout)paramContext);
    paramContext = this.b.findViewById(2131431916);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.dialog_view)");
    this.o = paramContext;
    paramContext = this.b.findViewById(2131445225);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.sample_back)");
    this.p = paramContext;
    paramContext = this.b.findViewById(2131428295);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.always_keep_tv)");
    this.q = ((TextView)paramContext);
    paramContext = this.b.findViewById(2131439558);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R…_type_always_keep_layout)");
    this.s = paramContext;
    paramContext = this.b.findViewById(2131428294);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.always_keep_checkbox)");
    this.t = ((CheckBox)paramContext);
    paramContext = this.b.findViewById(2131428296);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.always_reject_tv)");
    this.r = ((TextView)paramContext);
    paramContext = this.b.findViewById(2131447743);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "mRootView.findViewById(R.id.top_sample)");
    this.v = paramContext;
    this.b.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new a.1(this));
    this.n.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new a.2(this));
    this.w.addAll((Collection)paramList);
    if (paramBoolean)
    {
      this.c.setVisibility(8);
      this.v.setVisibility(0);
      this.v.setOnClickListener((View.OnClickListener)new a.3(this, paramList));
    }
    a(paramList);
    this.l.setOnClickListener((View.OnClickListener)new a.4(this));
    this.k.setOnClickListener((View.OnClickListener)new a.5(this));
    this.s.setOnClickListener((View.OnClickListener)new a.6(this, paramList));
    this.r.setOnClickListener((View.OnClickListener)new a.7(this));
    this.P = 2;
  }
  
  private final void a(@NotNull TextView paramTextView)
  {
    TextPaint localTextPaint = paramTextView.getPaint();
    Intrinsics.checkExpressionValueIsNotNull(localTextPaint, "paint");
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    paramTextView = paramTextView.getPaint();
    Intrinsics.checkExpressionValueIsNotNull(paramTextView, "paint");
    paramTextView.setStrokeWidth(0.8F);
  }
  
  private final void a(a.b paramb)
  {
    if (!this.x)
    {
      Object localObject = com.tencent.luggage.wxa.ik.c.a(com.tencent.luggage.wxa.ik.c.a, this.Q, paramb.c(), 0, 4, null);
      ((View)localObject).setId(View.generateViewId());
      this.y = Integer.valueOf(((View)localObject).getId());
      ((LinearLayout)this.m.findViewById(2131431280)).addView((View)localObject);
      this.m.setVisibility(0);
      this.u.setText((CharSequence)this.D);
      this.p.setOnClickListener((View.OnClickListener)new a.j(this));
      this.m.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new a.k(this));
      localObject = this.A;
      if (localObject != null) {
        ((a.a.a)localObject).a(paramb.d(), paramb.a(), this.w.indexOf(paramb));
      }
      this.x = true;
    }
  }
  
  private final void a(List<a.b> paramList)
  {
    RecyclerView localRecyclerView = new RecyclerView(this.Q);
    this.c.removeAllViews();
    this.c.addView((View)localRecyclerView, new ViewGroup.LayoutParams(-1, -2));
    this.e = new a.c(paramList, this);
    paramList = this.e;
    if (paramList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.Adapter)paramList);
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this.Q));
    localRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)new a.f(this));
  }
  
  private final void a(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject;
    ObjectAnimator localObjectAnimator;
    if (paramBoolean)
    {
      localObject = ObjectAnimator.ofFloat(this.n, View.TRANSLATION_X, new float[] { 0.0F, -this.n.getWidth() }).setDuration(200L);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.luggage.wxa.ij.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.m, View.TRANSLATION_X, new float[] { this.m.getWidth(), 0.0F }).setDuration(200L);
      Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator, "it");
      localObjectAnimator.setInterpolator((TimeInterpolator)new com.tencent.luggage.wxa.ij.a());
      localAnimatorSet.playTogether(new Animator[] { localObject, (Animator)localObjectAnimator });
    }
    else
    {
      localObject = ObjectAnimator.ofFloat(this.n, View.TRANSLATION_X, new float[] { -this.n.getWidth(), 0.0F }).setDuration(200L);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.luggage.wxa.ij.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.m, View.TRANSLATION_X, new float[] { 0.0F, this.m.getWidth() }).setDuration(200L);
      Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator, "it");
      localObjectAnimator.setInterpolator((TimeInterpolator)new com.tencent.luggage.wxa.ij.a());
      localAnimatorSet.playTogether(new Animator[] { localObject, (Animator)localObjectAnimator });
    }
    if (paramAnimatorListener != null) {
      localAnimatorSet.addListener(paramAnimatorListener);
    }
    localAnimatorSet.start();
  }
  
  private final int c()
  {
    Object localObject = this.Q.getSystemService("window");
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(context.getSystemServic…owManager).defaultDisplay");
      return ((Display)localObject).getRotation();
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
  }
  
  private final void d(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dispatchEvent ");
    ((StringBuilder)localObject).append(paramInt);
    o.d("SubscribeMsgRequestDialog", ((StringBuilder)localObject).toString());
    localObject = this.R;
    if (localObject != null)
    {
      List localList = (List)new ArrayList();
      localList.addAll((Collection)this.w);
      ((a.d)localObject).a(paramInt, localList);
    }
  }
  
  private final boolean d()
  {
    if (this.x)
    {
      a(false, (Animator.AnimatorListener)new a.i(this));
      this.x = false;
      return true;
    }
    return false;
  }
  
  private final void e(int paramInt)
  {
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramInt != 1) && (paramInt != 3))
    {
      if (b.a(this.Q))
      {
        b.a(this.b, (Function0)new a.g(this));
      }
      else
      {
        localObject = this.b;
        localLayoutParams = ((View)localObject).getLayoutParams();
        localLayoutParams.width = -1;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      if (this.n.indexOfChild(this.o) == -1)
      {
        localObject = this.o.getParent();
        if (localObject != null) {
          if (localObject != null) {
            ((ViewGroup)localObject).removeView(this.o);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
          }
        }
        this.n.addView(this.o);
        this.d.setVisibility(8);
      }
    }
    else
    {
      localObject = this.b;
      localLayoutParams = ((View)localObject).getLayoutParams();
      localLayoutParams.width = b.a(this.Q, 375);
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (this.d.indexOfChild(this.o) == -1)
      {
        localObject = this.o.getParent();
        if (localObject != null) {
          if (localObject != null) {
            ((ViewGroup)localObject).removeView(this.o);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
          }
        }
        this.d.addView(this.o);
        this.d.setVisibility(0);
      }
    }
    this.b.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new a.h(this));
  }
  
  private final void f(int paramInt)
  {
    Button localButton = this.l;
    boolean bool;
    if (paramInt != 0) {
      bool = true;
    } else {
      bool = false;
    }
    localButton.setEnabled(bool);
  }
  
  private final void j()
  {
    d(2);
  }
  
  public void a(int paramInt)
  {
    e(paramInt);
  }
  
  public final void a(@Nullable a.a.a parama)
  {
    this.A = parama;
  }
  
  public void a(@Nullable l paraml)
  {
    AppBrandSimpleImageLoader.instance().attach(this.f, this.B, this.N, (AppBrandSimpleImageLoader.h)new com.tencent.mm.modelappbrand.image.c());
    this.z = paraml;
    e(c());
    paraml = this.O;
    if (paraml != null) {
      paraml.a();
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.B = paramString;
  }
  
  public final boolean a()
  {
    return this.t.isChecked();
  }
  
  public void b()
  {
    a.e locale = this.O;
    if (locale != null) {
      locale.b();
    }
  }
  
  public final void b(int paramInt)
  {
    this.N = paramInt;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.C = paramString;
    this.h.setText((CharSequence)this.C);
    a(this.h);
  }
  
  public final void c(int paramInt)
  {
    this.P = paramInt;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      localView = this.b.findViewById(2131431918);
      Intrinsics.checkExpressionValueIsNotNull(localView, "mRootView.findViewById<V…alog_view_root_container)");
      localView.setBackground(ContextCompat.getDrawable(this.Q, 2130852709));
      return;
    }
    View localView = this.b.findViewById(2131431918);
    Intrinsics.checkExpressionValueIsNotNull(localView, "mRootView.findViewById<V…alog_view_root_container)");
    localView.setBackground(ContextCompat.getDrawable(this.Q, 2130852710));
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.D = paramString;
  }
  
  public void cancel()
  {
    e();
    dismiss();
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.E = paramString;
    this.s.setVisibility(0);
    this.q.setText((CharSequence)this.E);
    this.r.setVisibility(8);
  }
  
  public void dismiss()
  {
    l locall = this.z;
    if (locall != null) {
      locall.b((i)this);
    }
    b();
  }
  
  public void e()
  {
    j();
  }
  
  public final void e(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.G = paramString;
    this.r.setVisibility(0);
    this.r.setText((CharSequence)this.G);
    this.s.setVisibility(8);
  }
  
  public final void f(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.I = paramString;
    this.g.setText((CharSequence)this.I);
    a(this.g);
  }
  
  public boolean f()
  {
    return false;
  }
  
  public final void g(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.J = paramString;
    this.i.setText((CharSequence)this.J);
  }
  
  public boolean g()
  {
    return false;
  }
  
  @NotNull
  public View getContentView()
  {
    return this.b;
  }
  
  public int h()
  {
    return this.P;
  }
  
  public final void h(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.K = paramString;
    this.l.setText((CharSequence)this.K);
  }
  
  public final void i(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.L = paramString;
    this.k.setText((CharSequence)this.L);
  }
  
  public boolean i()
  {
    return d();
  }
  
  public final void j(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    this.M = paramString;
    this.j.setText((CharSequence)this.M);
    paramString = this.j;
    int i1 = ((CharSequence)this.M).length();
    int i2 = 0;
    if (i1 == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      i2 = 8;
    }
    paramString.setVisibility(i2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a
 * JD-Core Version:    0.7.0.1
 */