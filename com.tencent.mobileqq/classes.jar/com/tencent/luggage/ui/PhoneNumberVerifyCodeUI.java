package com.tencent.luggage.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.pp.w;
import com.tencent.luggage.wxa.qx.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.phonenumber.e;
import com.tencent.mm.plugin.appbrand.phonenumber.h;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.phonenumber.r.a;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/PhoneNumberVerifyCodeUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "()V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "appId", "", "ext_desc", "mContentView", "Landroid/widget/LinearLayout;", "mKeyboard", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandNumberKeyboardView;", "mobileTV", "Landroid/widget/TextView;", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/luggage/ui/PhoneNumberVerifyCodeUI$VertifyTimer;", "verifyView", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "doVerifyCode", "code", "getLayoutId", "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "initKeyboard", "initVerifyView", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "showErrorTips", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "updateSendText", "Companion", "VertifyTimer", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class PhoneNumberVerifyCodeUI
  extends com.tencent.mm.ui.base.c
{
  public static final PhoneNumberVerifyCodeUI.a a = new PhoneNumberVerifyCodeUI.a(null);
  private LinearLayout b;
  private String c = "";
  private z d;
  private String e = "";
  private r f;
  private View g;
  private View h;
  private EditVerifyCodeView i;
  private TextView j;
  private TextView k;
  private PhoneNumberVerifyCodeUI.b l;
  private final int m = 60000;
  private final int n = 1000;
  private w o;
  
  private final void a()
  {
    this.b = ((LinearLayout)findViewById(2131449349));
    c();
    b();
    LinearLayout localLinearLayout = this.b;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(0);
    }
  }
  
  private final void a(int paramInt, String paramString1, String paramString2)
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", "handleCheckVerifyCodeStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    int i1 = h.a.f();
    Object localObject1 = null;
    z localz = null;
    Object localObject3 = null;
    Object localObject2 = null;
    if (paramInt == i1)
    {
      localz = this.d;
      if (localz != null)
      {
        localObject1 = localObject2;
        if (localz != null) {
          localObject1 = Long.valueOf(localz.x());
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localz.y(((Long)localObject1).longValue() + 1L);
      }
      a(paramString1, paramString2);
      return;
    }
    if (paramInt == h.a.g())
    {
      paramString1 = getString(2131886805);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "getString(R.string.app_b…end_verify_code_frequent)");
      a(paramString1);
      paramString2 = this.d;
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
      paramString1 = getString(2131886810);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "getString(R.string.app_b…_number_verify_code_fail)");
      a(paramString1);
      paramString2 = this.d;
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
      com.tencent.luggage.wxa.pd.f.a((Context)this, getString(2131886807), "", false, (DialogInterface.OnClickListener)new PhoneNumberVerifyCodeUI.g(this));
      paramString2 = this.d;
      if (paramString2 != null)
      {
        paramString1 = localObject3;
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
    h();
    com.tencent.luggage.wxa.pd.f.a((Context)this, paramString, "", false, (DialogInterface.OnClickListener)new PhoneNumberVerifyCodeUI.k(this));
  }
  
  private final void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (paramString1 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("encryptedData", paramString1);
    if (paramString2 == null) {
      paramString2 = "";
    }
    localIntent.putExtra("iv", paramString2);
    setResult(-1, localIntent);
    finish();
  }
  
  private final void a(boolean paramBoolean)
  {
    if (this.f == null) {
      return;
    }
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", "doSendVerifyCode");
    ProgressDialog localProgressDialog = com.tencent.luggage.wxa.pd.f.a((Context)this, (CharSequence)getString(2131886977), true, null);
    Object localObject = this.f;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    if (((r)localObject).i())
    {
      localObject = this.c;
      localr = this.f;
      if (localr == null) {
        Intrinsics.throwNpe();
      }
      new com.tencent.mm.plugin.appbrand.phonenumber.f((String)localObject, localr.b()).a((Function1)new PhoneNumberVerifyCodeUI.c(this, localProgressDialog, paramBoolean));
      return;
    }
    localObject = this.c;
    r localr = this.f;
    if (localr == null) {
      Intrinsics.throwNpe();
    }
    new e((String)localObject, localr.b()).a((Function1)new PhoneNumberVerifyCodeUI.d(this, localProgressDialog, paramBoolean));
  }
  
  private final void b()
  {
    Object localObject = (Context)this;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, a.e((Context)localObject, 240));
    localLayoutParams.topMargin = a.e((Context)localObject, 10);
    this.o = new w((Context)localObject);
    w localw = this.o;
    if (localw != null)
    {
      localObject = this.i;
      if (localObject != null) {
        localObject = ((EditVerifyCodeView)localObject).getEditText();
      } else {
        localObject = null;
      }
      localw.a((com.tencent.luggage.wxa.pu.b)localObject);
    }
    localObject = this.b;
    if (localObject != null) {
      ((LinearLayout)localObject).addView((View)this.o, (ViewGroup.LayoutParams)localLayoutParams);
    }
  }
  
  private final void b(int paramInt)
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", "handleSendVerifyCodeStatus:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == h.a.c())
    {
      g();
      return;
    }
    if (paramInt == h.a.d())
    {
      str = getString(2131886804);
      Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.app_b…er_send_verify_code_fail)");
      a(str);
      return;
    }
    if (paramInt == h.a.e())
    {
      str = getString(2131886805);
      Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.app_b…end_verify_code_frequent)");
      a(str);
      return;
    }
    String str = getString(2131886804);
    Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.app_b…er_send_verify_code_fail)");
    a(str);
  }
  
  private final void b(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("errMsg", paramString);
    setResult(1, localIntent);
    finish();
  }
  
  private final void c()
  {
    Object localObject1 = getSystemService("layout_inflater");
    if (localObject1 != null)
    {
      localObject1 = (LayoutInflater)localObject1;
      Object localObject2 = null;
      this.h = ((LayoutInflater)localObject1).inflate(2131624234, null);
      localObject1 = this.h;
      if (localObject1 != null) {
        localObject1 = (EditVerifyCodeView)((View)localObject1).findViewById(2131428602);
      } else {
        localObject1 = null;
      }
      this.i = ((EditVerifyCodeView)localObject1);
      localObject1 = this.h;
      if (localObject1 != null) {
        localObject1 = (TextView)((View)localObject1).findViewById(2131428603);
      } else {
        localObject1 = null;
      }
      this.k = ((TextView)localObject1);
      localObject1 = this.h;
      if (localObject1 != null) {
        localObject1 = (TextView)((View)localObject1).findViewById(2131428591);
      } else {
        localObject1 = null;
      }
      this.j = ((TextView)localObject1);
      localObject1 = this.i;
      if (localObject1 != null) {
        ((EditVerifyCodeView)localObject1).setText("");
      }
      Object localObject3 = this.k;
      if (localObject3 != null)
      {
        localObject1 = this.f;
        if (localObject1 != null) {
          localObject1 = ((r)localObject1).c();
        } else {
          localObject1 = null;
        }
        ((TextView)localObject3).setText((CharSequence)getString(2131886811, new Object[] { localObject1 }));
      }
      f();
      localObject1 = this.h;
      if (localObject1 != null)
      {
        if (localObject1 != null) {
          localObject1 = ((View)localObject1).getParent();
        } else {
          localObject1 = null;
        }
        if ((localObject1 instanceof ViewGroup))
        {
          localObject3 = this.h;
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = ((View)localObject3).getParent();
          }
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView(this.h);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
          }
        }
      }
      localObject1 = new MMAlertDialog.Builder((Context)this).setTitle(getString(2131886814)).create();
      ((MMAlertDialog)localObject1).setCustomTitleView(this.h);
      ((MMAlertDialog)localObject1).setOnDismissListener((DialogInterface.OnDismissListener)new PhoneNumberVerifyCodeUI.h(this));
      ((MMAlertDialog)localObject1).setPositiveButton((CharSequence)getString(2131886982), false, (DialogInterface.OnClickListener)new PhoneNumberVerifyCodeUI.i(this));
      ((MMAlertDialog)localObject1).setNegativeButton((CharSequence)getString(2131886983), true, (DialogInterface.OnClickListener)new PhoneNumberVerifyCodeUI.j(this));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "smsDialog");
      this.g = ((MMAlertDialog)localObject1).getContentView();
      localObject1 = this.b;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).addView(this.g);
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
  }
  
  private final void c(String paramString)
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", "doVerifyCode");
    Object localObject2 = this.d;
    if (localObject2 != null)
    {
      if (localObject2 != null) {
        localObject1 = Long.valueOf(((z)localObject2).w());
      } else {
        localObject1 = null;
      }
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((z)localObject2).x(((Long)localObject1).longValue() + 1L);
    }
    Object localObject1 = com.tencent.luggage.wxa.pd.f.a((Context)this, (CharSequence)getString(2131886979), true, null);
    localObject2 = this.f;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    if (((r)localObject2).i())
    {
      localObject2 = this.c;
      localr = this.f;
      if (localr == null) {
        Intrinsics.throwNpe();
      }
      new com.tencent.mm.plugin.appbrand.phonenumber.c((String)localObject2, localr.b(), paramString).a((Function1)new PhoneNumberVerifyCodeUI.e(this, (ProgressDialog)localObject1));
      return;
    }
    localObject2 = this.c;
    r localr = this.f;
    if (localr == null) {
      Intrinsics.throwNpe();
    }
    new com.tencent.mm.plugin.appbrand.phonenumber.b((String)localObject2, localr.b(), paramString).a((Function1)new PhoneNumberVerifyCodeUI.f(this, (ProgressDialog)localObject1));
  }
  
  private final void e()
  {
    LinearLayout localLinearLayout = this.b;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(0);
    }
  }
  
  private final void f()
  {
    Object localObject2 = getString(2131886800);
    String str = getString(2131886803);
    Object localObject1 = new SpannableStringBuilder();
    ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2);
    ((SpannableStringBuilder)localObject1).append((CharSequence)str);
    int i1 = ((String)localObject2).length();
    int i2 = str.length();
    localObject2 = new PhoneNumberVerifyCodeUI.l(this);
    i2 += i1;
    ((SpannableStringBuilder)localObject1).setSpan(localObject2, i1, i2, 17);
    ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(ContextCompat.getColor((Context)this, 2131165304)), i1, i2, 17);
    localObject2 = this.j;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)localObject1);
    }
    localObject1 = this.j;
    if (localObject1 != null) {
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
    }
  }
  
  private final void g()
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", "startSmsListener");
    PhoneNumberVerifyCodeUI.b localb = this.l;
    if (localb != null)
    {
      if (localb != null) {
        localb.cancel();
      }
    }
    else {
      this.l = new PhoneNumberVerifyCodeUI.b(this, this.m, this.n);
    }
    localb = this.l;
    if (localb != null) {
      localb.start();
    }
  }
  
  private final void h()
  {
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", "stopSmsListener");
    PhoneNumberVerifyCodeUI.b localb = this.l;
    if (localb != null) {
      localb.cancel();
    }
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
    return 2131624043;
  }
  
  public void onBackPressed()
  {
    b("fail");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  @TargetApi(5)
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.overridePendingTransition(0, 0);
    paramBundle = getWindow();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "decorView");
    paramBundle.setSystemUiVisibility(1280);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "window");
      paramBundle.setStatusBarColor(getResources().getColor(17170445));
    }
    paramBundle = getIntent().getStringExtra("APPID");
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "intent.getStringExtra(APPID)");
    this.c = paramBundle;
    paramBundle = r.a;
    String str = getIntent().getStringExtra("PHONEITEM");
    Intrinsics.checkExpressionValueIsNotNull(str, "intent.getStringExtra(PHONEITEM)");
    this.f = paramBundle.a(str);
    if (this.f == null) {
      return;
    }
    this.e = getIntent().getStringExtra("EXTDESC");
    paramBundle = new StringBuilder();
    paramBundle.append("onCreate() appId:");
    paramBundle.append(this.c);
    o.d("MicroMsg.PhoneNumberVerifyCodeUI", paramBundle.toString());
    a();
    a(true);
  }
  
  protected void onDestroy()
  {
    super.overridePendingTransition(0, 0);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    overridePendingTransition(0, 0);
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.PhoneNumberVerifyCodeUI
 * JD-Core Version:    0.7.0.1
 */