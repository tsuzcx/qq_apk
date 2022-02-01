package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.z;
import com.tencent.luggage.wxa.on.f;
import com.tencent.luggage.wxa.on.f.a;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.pf.d;
import com.tencent.luggage.wxa.pf.d.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "content", "", "context", "Landroid/content/Context;", "height", "", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;Ljava/lang/String;Landroid/content/Context;ILcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "_position", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getHeight", "()I", "rootView", "titleTv", "applyStyleByRotation", "", "cancel", "dismiss", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "show", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class k
  implements f, i
{
  @Deprecated
  public static final k.a a = new k.a(null);
  private l b;
  private int c;
  private final View d;
  private final ImageView e;
  private final TextView f;
  private final TextView g;
  private final View h;
  private final z i;
  @Nullable
  private final String j;
  @NotNull
  private final Context k;
  private final int l;
  private final c m;
  
  public k(@Nullable z paramz, @Nullable String paramString, @NotNull Context paramContext, int paramInt, @NotNull c paramc)
  {
    this.i = paramz;
    this.j = paramString;
    this.k = paramContext;
    this.l = paramInt;
    this.m = paramc;
    if (this.i == null) {
      o.c("Luggage.FULL.DialogExplainDialog", "<init> get NULL webviewOpener");
    }
    this.c = 2;
    paramz = View.inflate(this.k, 2131624217, null);
    Intrinsics.checkExpressionValueIsNotNull(paramz, "View.inflate(context, R.…ber_explain_dialog, null)");
    this.h = paramz;
    paramz = this.h.findViewById(2131440052);
    Intrinsics.checkExpressionValueIsNotNull(paramz, "rootView.findViewById(R.…e_number_explain_content)");
    this.d = paramz;
    paramz = this.d;
    if (paramz != null) {
      paramz.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, this.l));
    }
    paramz = this.h.findViewById(2131440053);
    Intrinsics.checkExpressionValueIsNotNull(paramz, "rootView.findViewById(R.…mber_explain_dialog_back)");
    this.e = ((ImageView)paramz);
    paramz = this.e;
    if (paramz != null) {
      paramz.setOnClickListener((View.OnClickListener)new k.1(this));
    }
    paramz = this.h.findViewById(2131440055);
    Intrinsics.checkExpressionValueIsNotNull(paramz, "rootView.findViewById(R.…ber_explain_dialog_title)");
    this.f = ((TextView)paramz);
    this.f.setText(this.h.getContext().getText(2131886955));
    paramz = this.h.findViewById(2131440054);
    Intrinsics.checkExpressionValueIsNotNull(paramz, "rootView.findViewById(R.…r_explain_dialog_content)");
    this.g = ((TextView)paramz);
    this.g.setText(d.a(this.j, false, (d.a)new k.2(this)));
    this.g.setMovementMethod(LinkMovementMethod.getInstance());
    this.g.setLinkTextColor(Color.parseColor("#FF576B95"));
  }
  
  private final void b()
  {
    Object localObject2 = this.k.getSystemService("window");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof WindowManager)) {
      localObject1 = null;
    }
    Object localObject3 = (WindowManager)localObject1;
    if (localObject3 != null)
    {
      localObject1 = m.a;
      localObject2 = getContentView().getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "contentView.context");
      View localView = getContentView();
      localObject3 = ((WindowManager)localObject3).getDefaultDisplay();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.defaultDisplay");
      ((m)localObject1).a((Context)localObject2, localView, null, ((Display)localObject3).getRotation(), this.m);
    }
  }
  
  @NotNull
  public final Context a()
  {
    return this.k;
  }
  
  public void a(int paramInt)
  {
    b();
  }
  
  public void a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    b(this.c);
    b(paramb).a((i)this);
  }
  
  public void a(@Nullable l paraml)
  {
    this.b = paraml;
    b();
  }
  
  @NotNull
  public l b(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "$this$findPromptViewContainer");
    return f.a.a(this, paramb);
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      this.h.setBackground(ContextCompat.getDrawable(this.k, 2130838717));
      return;
    }
    this.h.setBackground(ContextCompat.getDrawable(this.k, 2130838718));
  }
  
  public void cancel() {}
  
  public void dismiss()
  {
    l locall = this.b;
    if (locall != null) {
      locall.b((i)this);
    }
  }
  
  public void e() {}
  
  public boolean f()
  {
    return true;
  }
  
  public boolean g()
  {
    return true;
  }
  
  @NotNull
  public View getContentView()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.c;
  }
  
  public boolean i()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.k
 * JD-Core Version:    0.7.0.1
 */