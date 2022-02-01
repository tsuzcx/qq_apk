package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.z;
import com.tencent.luggage.wxa.kc.a.a;
import com.tencent.luggage.wxa.on.f;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageDialog;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/BaseRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "context", "Landroid/content/Context;", "appId", "", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getAppId", "()Ljava/lang/String;", "mItemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "value", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "phoneItems", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "createSecondaryExplainPresenterView", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "content", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "dismiss", "getDialogHeight", "", "onBackPressedEvent", "", "onDismiss", "show", "showPrivacyExplainEntry", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@RequiresApi(8)
public final class w
  extends a
  implements com.tencent.luggage.wxa.kc.a
{
  private q b;
  @NotNull
  private ArrayList<r> c;
  @NotNull
  private Function0<Unit> d;
  @NotNull
  private Function0<Unit> e;
  @NotNull
  private Function0<Unit> f;
  @NotNull
  private Function0<Unit> g;
  @NotNull
  private Function0<Unit> h;
  @NotNull
  private Function0<Unit> i;
  @NotNull
  private Function1<? super r, Unit> j;
  @NotNull
  private final String k;
  private final c l;
  
  public w(@NotNull Context paramContext, @NotNull String paramString, @NotNull c paramc)
  {
    super(paramContext, paramc);
    this.k = paramString;
    this.l = paramc;
    this.c = new ArrayList();
    this.d = ((Function0)w.a.a);
    this.e = ((Function0)w.d.a);
    this.f = ((Function0)w.c.a);
    this.g = ((Function0)w.e.a);
    this.h = ((Function0)w.b.a);
    this.i = ((Function0)w.f.a);
    this.j = ((Function1)w.g.a);
    a((a.b)new w.1(this));
    a((View.OnClickListener)new w.2(this));
    d().setOnClickListener((View.OnClickListener)new w.3(this));
    b().setVisibility(0);
  }
  
  private final int v()
  {
    return a().getMeasuredHeight();
  }
  
  @NotNull
  public f a(@NotNull b paramb, @Nullable String paramString, @Nullable z paramz)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    Context localContext = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "this.context");
    paramString = new k(paramz, paramString, localContext, v(), this.l);
    paramb = paramb.y();
    Intrinsics.checkExpressionValueIsNotNull(paramb, "component.windowAndroid");
    if (paramb.f()) {
      paramString.b(1);
    }
    return (f)paramString;
  }
  
  public void a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "component");
    super.b(super.h());
    b(paramb).a((i)this);
  }
  
  public void a(@NotNull ArrayList<r> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "value");
    m().clear();
    m().addAll((Collection)paramArrayList);
    com.tencent.luggage.wxa.pc.l.a((Runnable)new w.h(this));
  }
  
  public void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.e = paramFunction0;
  }
  
  public void a(@NotNull Function1<? super r, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "<set-?>");
    this.j = paramFunction1;
  }
  
  public void a(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (paramBoolean)
    {
      super.a(ContextCompat.getDrawable(getContext(), 2130838672));
      super.a((View.OnClickListener)new w.i(this));
      return;
    }
    super.a((View.OnClickListener)null);
  }
  
  @NotNull
  public com.tencent.mm.plugin.appbrand.widget.dialog.l b(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "$this$findPromptViewContainer");
    return a.a.a(this, paramb);
  }
  
  public void b(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.f = paramFunction0;
  }
  
  public void c(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.g = paramFunction0;
  }
  
  public void d(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.h = paramFunction0;
  }
  
  public void e(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "<set-?>");
    this.i = paramFunction0;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public void l()
  {
    e();
  }
  
  @NotNull
  public ArrayList<r> m()
  {
    return this.c;
  }
  
  @NotNull
  public Function0<Unit> n()
  {
    return this.d;
  }
  
  @NotNull
  public Function0<Unit> o()
  {
    return this.e;
  }
  
  @NotNull
  public Function0<Unit> p()
  {
    return this.f;
  }
  
  @NotNull
  public Function0<Unit> q()
  {
    return this.g;
  }
  
  @NotNull
  public Function0<Unit> r()
  {
    return this.h;
  }
  
  @NotNull
  public Function0<Unit> s()
  {
    return this.i;
  }
  
  @NotNull
  public Function1<r, Unit> t()
  {
    return this.j;
  }
  
  @NotNull
  public final String u()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.w
 * JD-Core Version:    0.7.0.1
 */