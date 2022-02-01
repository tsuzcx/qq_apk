package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.luggage.wxa.pd.f;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberAddLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "onDone", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "mPhoneNumberAddView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddView;", "getView", "Landroid/view/View;", "init", "sendSms", "mobile", "sendSmsInner", "showErrorTips", "errMsg", "uninit", "verifyCode", "isCheck", "", "code", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class t
  implements l
{
  public static final t.a a = new t.a(null);
  @NotNull
  private static final String f = "PhoneNumberAddLogic";
  private m b;
  private final Context c;
  private final String d;
  private final Function0<Unit> e;
  
  public t(@NotNull Context paramContext, @NotNull String paramString, @NotNull Function0<Unit> paramFunction0)
  {
    this.c = paramContext;
    this.d = paramString;
    this.e = paramFunction0;
  }
  
  private final void b(String paramString)
  {
    Object localObject1 = f;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sendSms appId:");
    ((StringBuilder)localObject2).append(this.d);
    ((StringBuilder)localObject2).append(", mobile:");
    ((StringBuilder)localObject2).append(paramString);
    o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.b;
    if (localObject1 != null) {
      ((m)localObject1).b();
    }
    localObject2 = this.c;
    Object localObject3 = (CharSequence)((Context)localObject2).getString(2131886977);
    localObject1 = null;
    localObject2 = f.a((Context)localObject2, (CharSequence)localObject3, true, null);
    localObject3 = aa.a.d(this.d);
    if (localObject3 != null)
    {
      z localz = aa.a.d(this.d);
      if (localz != null) {
        localObject1 = Long.valueOf(localz.k());
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((z)localObject3).l(((Long)localObject1).longValue() + 1L);
    }
    new e(this.d, paramString).a((Function1)new t.d(this, (ProgressDialog)localObject2));
  }
  
  private final void c(String paramString)
  {
    Context localContext = this.c;
    f.a(localContext, paramString, localContext.getString(2131886801), (DialogInterface.OnClickListener)t.e.a);
  }
  
  public void a()
  {
    this.b = ((m)new u(this.c, (l)this));
    aa.a.c(this.d);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "mobile");
    if (!af.c(paramString))
    {
      Context localContext = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.getString(2131886813));
      localStringBuilder.append(paramString);
      f.a(localContext, localStringBuilder.toString(), this.c.getString(2131886812), this.c.getString(2131886982), this.c.getString(2131886983), (DialogInterface.OnClickListener)new t.b(this, paramString), (DialogInterface.OnClickListener)t.c.a);
      return;
    }
    paramString = this.c.getString(2131886967);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "mContext.getString(R.str…_number_format_err_title)");
    c(paramString);
  }
  
  public void a(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "mobile");
    Intrinsics.checkParameterIsNotNull(paramString2, "code");
    Object localObject2 = aa.a.d(this.d);
    if (localObject2 != null)
    {
      localObject1 = aa.a.d(this.d);
      if (localObject1 != null) {
        localObject1 = Long.valueOf(((z)localObject1).n());
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((z)localObject2).o(((Long)localObject1).longValue() + 1L);
    }
    if (paramBoolean)
    {
      localObject2 = aa.a.d(this.d);
      if (localObject2 != null)
      {
        localObject1 = aa.a.d(this.d);
        if (localObject1 != null) {
          localObject1 = Long.valueOf(((z)localObject1).q());
        } else {
          localObject1 = null;
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((z)localObject2).r(((Long)localObject1).longValue() + 1L);
      }
    }
    else
    {
      localObject2 = aa.a.d(this.d);
      if (localObject2 != null)
      {
        localObject1 = aa.a.d(this.d);
        if (localObject1 != null) {
          localObject1 = Long.valueOf(((z)localObject1).r());
        } else {
          localObject1 = null;
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((z)localObject2).s(((Long)localObject1).longValue() + 1L);
      }
    }
    Object localObject1 = f;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("verifyCode mAppId:");
    ((StringBuilder)localObject2).append(this.d);
    ((StringBuilder)localObject2).append(", mobile:");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(" code:");
    ((StringBuilder)localObject2).append(paramString2);
    o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = this.c;
    localObject1 = f.a((Context)localObject1, (CharSequence)((Context)localObject1).getString(2131886979), true, null);
    new b(this.d, paramString1, paramString2).a((Function1)new t.f(this, paramBoolean, paramString1, (ProgressDialog)localObject1));
  }
  
  @Nullable
  public View b()
  {
    m localm = this.b;
    if (localm != null) {
      return localm.a();
    }
    return null;
  }
  
  public void c()
  {
    m localm = this.b;
    if (localm != null) {
      localm.c();
    }
    aa.a.b(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.t
 * JD-Core Version:    0.7.0.1
 */