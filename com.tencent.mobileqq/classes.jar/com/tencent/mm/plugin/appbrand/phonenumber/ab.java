package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "setReport", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "cloudId", "doVerifyCode", "code", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class ab
{
  public static final ab.a a = new ab.a(null);
  private View b;
  private EditVerifyCodeView c;
  private TextView d;
  private TextView e;
  private ab.c f;
  private final int g;
  private final int h;
  @NotNull
  private final Context i;
  @NotNull
  private final String j;
  @Nullable
  private z k;
  @NotNull
  private final String l;
  @NotNull
  private final r m;
  @Nullable
  private final ab.b n;
  
  public ab(@NotNull Context paramContext, @NotNull String paramString1, @Nullable z paramz, @NotNull String paramString2, @NotNull r paramr, @Nullable ab.b paramb)
  {
    this.i = paramContext;
    this.j = paramString1;
    this.k = paramz;
    this.l = paramString2;
    this.m = paramr;
    this.n = paramb;
    this.g = 60000;
    this.h = 1000;
    paramContext = this.i.getSystemService("layout_inflater");
    if (paramContext != null)
    {
      paramContext = (LayoutInflater)paramContext;
      paramString1 = null;
      this.b = paramContext.inflate(2131624234, null);
      paramContext = this.b;
      if (paramContext != null) {
        paramContext = (EditVerifyCodeView)paramContext.findViewById(2131428602);
      } else {
        paramContext = null;
      }
      this.c = paramContext;
      paramContext = this.b;
      if (paramContext != null) {
        paramContext = (TextView)paramContext.findViewById(2131428603);
      } else {
        paramContext = null;
      }
      this.e = paramContext;
      paramz = this.b;
      paramContext = paramString1;
      if (paramz != null) {
        paramContext = (TextView)paramz.findViewById(2131428591);
      }
      this.d = paramContext;
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
  }
  
  private final void a(int paramInt)
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "handleSendVerifyCodeStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == h.a.c())
    {
      j();
      return;
    }
    if (paramInt == h.a.d())
    {
      str = this.i.getString(2131886804);
      Intrinsics.checkExpressionValueIsNotNull(str, "context.getString(R.stri…er_send_verify_code_fail)");
      b(str);
      return;
    }
    if (paramInt == h.a.e())
    {
      str = this.i.getString(2131886805);
      Intrinsics.checkExpressionValueIsNotNull(str, "context.getString(R.stri…end_verify_code_frequent)");
      b(str);
      return;
    }
    String str = this.i.getString(2131886804);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.getString(R.stri…er_send_verify_code_fail)");
    b(str);
  }
  
  private final void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "handleCheckVerifyCodeStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    int i1 = h.a.f();
    Object localObject1 = null;
    z localz = null;
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramInt == i1)
    {
      localz = this.k;
      if (localz != null)
      {
        localObject1 = localObject3;
        if (localz != null) {
          localObject1 = Long.valueOf(localz.x());
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localz.y(((Long)localObject1).longValue() + 1L);
      }
      a(paramString1, paramString2, paramString3);
      return;
    }
    if (paramInt == h.a.g())
    {
      paramString1 = this.i.getString(2131886805);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "context.getString(R.stri…end_verify_code_frequent)");
      b(paramString1);
      paramString2 = this.k;
      if (paramString2 != null)
      {
        paramString1 = (String)localObject1;
        if (paramString2 != null) {
          paramString1 = Long.valueOf(paramString2.y());
        }
        if (paramString1 == null) {
          Intrinsics.throwNpe();
        }
        paramString2.z(paramString1.longValue() + 1L);
      }
    }
    else if ((paramInt != h.a.h()) && (paramInt != h.a.i()))
    {
      paramString1 = this.i.getString(2131886810);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "context.getString(R.stri…_number_verify_code_fail)");
      b(paramString1);
      paramString2 = this.k;
      if (paramString2 != null)
      {
        paramString1 = localz;
        if (paramString2 != null) {
          paramString1 = Long.valueOf(paramString2.y());
        }
        if (paramString1 == null) {
          Intrinsics.throwNpe();
        }
        paramString2.z(paramString1.longValue() + 1L);
      }
    }
    else
    {
      paramString1 = this.i;
      com.tencent.luggage.wxa.pd.f.a(paramString1, paramString1.getString(2131886807), "", false, (DialogInterface.OnClickListener)new ab.h(this));
      paramString2 = this.k;
      if (paramString2 != null)
      {
        paramString1 = localObject2;
        if (paramString2 != null) {
          paramString1 = Long.valueOf(paramString2.y());
        }
        if (paramString1 == null) {
          Intrinsics.throwNpe();
        }
        paramString2.z(paramString1.longValue() + 1L);
      }
    }
  }
  
  private final void a(String paramString)
  {
    Map localMap = (Map)new HashMap();
    localMap.put("errMsg", paramString);
    paramString = this.n;
    if (paramString != null) {
      paramString.a(false, localMap);
    }
  }
  
  private final void a(String paramString1, String paramString2, String paramString3)
  {
    Map localMap = (Map)new HashMap();
    localMap.put("errMsg", "ok");
    if (paramString1 == null) {
      paramString1 = "";
    }
    localMap.put("encryptedData", paramString1);
    if (paramString2 == null) {
      paramString2 = "";
    }
    localMap.put("iv", paramString2);
    if (paramString3 == null) {
      paramString3 = "";
    }
    localMap.put("cloud_id", paramString3);
    paramString1 = this.n;
    if (paramString1 != null) {
      paramString1.a(true, localMap);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
    Object localObject = this.i;
    localObject = com.tencent.luggage.wxa.pd.f.a((Context)localObject, (CharSequence)((Context)localObject).getString(2131886977), true, null);
    if (this.m.i())
    {
      new f(this.j, this.m.b()).a((Function1)new ab.d(this, (ProgressDialog)localObject, paramBoolean));
      return;
    }
    new e(this.j, this.m.b()).a((Function1)new ab.e(this, (ProgressDialog)localObject, paramBoolean));
  }
  
  private final void b(String paramString)
  {
    i();
    com.tencent.luggage.wxa.pd.f.a(this.i, paramString, "", false, (DialogInterface.OnClickListener)new ab.j(this));
  }
  
  private final void c(String paramString)
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "doVerifyCode");
    z localz = this.k;
    if (localz != null)
    {
      if (localz != null) {
        localObject = Long.valueOf(localz.w());
      } else {
        localObject = null;
      }
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localz.x(((Long)localObject).longValue() + 1L);
    }
    Object localObject = this.i;
    localObject = com.tencent.luggage.wxa.pd.f.a((Context)localObject, (CharSequence)((Context)localObject).getString(2131886979), true, null);
    if (this.m.i())
    {
      new c(this.j, this.m.b(), paramString).a((Function1)new ab.f(this, (ProgressDialog)localObject));
      return;
    }
    new b(this.j, this.m.b(), paramString).a((Function1)new ab.g(this, (ProgressDialog)localObject));
  }
  
  private final void e()
  {
    Object localObject1 = this.c;
    if (localObject1 != null) {
      ((EditVerifyCodeView)localObject1).setText("");
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)this.i.getString(2131886811, new Object[] { this.m.c() }));
    }
    h();
    localObject1 = this.b;
    if (localObject1 != null)
    {
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((View)localObject1).getParent();
      } else {
        localObject1 = null;
      }
      if ((localObject1 instanceof ViewGroup))
      {
        View localView = this.b;
        localObject1 = localObject2;
        if (localView != null) {
          localObject1 = localView.getParent();
        }
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView(this.b);
        } else {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
    }
    localObject1 = new MMAlertDialog.Builder(this.i).setTitle(this.i.getString(2131886814)).setCustomTitle(this.b).create();
    ((MMAlertDialog)localObject1).setOnDismissListener((DialogInterface.OnDismissListener)new ab.l(this));
    ((MMAlertDialog)localObject1).setPositiveButton((CharSequence)this.i.getString(2131886982), false, (DialogInterface.OnClickListener)new ab.m(this));
    ((MMAlertDialog)localObject1).setNegativeButton((CharSequence)this.i.getString(2131886983), true, (DialogInterface.OnClickListener)new ab.n(this));
    ((MMAlertDialog)localObject1).show();
    f();
  }
  
  private final void f()
  {
    View localView = this.b;
    if (localView != null) {
      localView.post((Runnable)new ab.k(this));
    }
  }
  
  private final void g()
  {
    View localView = this.b;
    if (localView != null) {
      localView.post((Runnable)new ab.i(this));
    }
  }
  
  private final void h()
  {
    Object localObject2 = this.i.getString(2131886800);
    String str = this.i.getString(2131886803);
    Object localObject1 = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
    ((SpannableStringBuilder)localObject1).append((CharSequence)str);
    int i1 = ((String)localObject2).length();
    int i2 = str.length();
    localObject2 = new ab.o(this);
    i2 += i1;
    ((SpannableStringBuilder)localObject1).setSpan(localObject2, i1, i2, 17);
    ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.i.getResources().getColor(2131165304)), i1, i2, 17);
    localObject2 = this.d;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.d;
    if (localObject1 != null) {
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  private final void i()
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
    ab.c localc = this.f;
    if (localc != null) {
      localc.cancel();
    }
  }
  
  private final void j()
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeDialog", "startSmsListener");
    ab.c localc = this.f;
    if (localc != null)
    {
      if (localc != null) {
        localc.cancel();
      }
    }
    else {
      this.f = new ab.c(this, this.g, this.h);
    }
    localc = this.f;
    if (localc != null) {
      localc.start();
    }
  }
  
  public final void a()
  {
    a(true);
  }
  
  @NotNull
  public final Context b()
  {
    return this.i;
  }
  
  @Nullable
  public final z c()
  {
    return this.k;
  }
  
  @NotNull
  public final r d()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.ab
 * JD-Core Version:    0.7.0.1
 */