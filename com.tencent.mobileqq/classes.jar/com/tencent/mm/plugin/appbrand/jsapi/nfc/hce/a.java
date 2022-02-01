package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.li.d;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(19)
public class a
{
  public static a a;
  private int b = 0;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private Timer f;
  private TimerTask g;
  private ComponentName h;
  private Activity i;
  private ResultReceiver j;
  private WeUIProgresssDialog k;
  private MMAlertDialog l = null;
  private final Handler m = new Handler();
  
  static
  {
    if (a == null) {
      a = new a();
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt2);
    localBundle.putString("errMsg", paramString);
    this.j.send(10001, localBundle);
  }
  
  private void a(int paramInt, String paramString)
  {
    b(paramInt, paramString);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    c();
    Object localObject = this.i;
    if (localObject == null)
    {
      o.b("MicroMsg.HCEActivityMgr", "alvinluo showErrorDialog mHceActivity is null");
      return;
    }
    localObject = new MMAlertDialog.Builder((Context)localObject);
    ((MMAlertDialog.Builder)localObject).setTitle("");
    ((MMAlertDialog.Builder)localObject).setMsg(paramString2);
    ((MMAlertDialog.Builder)localObject).setPositiveBtnText(this.i.getString(2131891461)).setPositiveBtnListener(new a.7(this, paramInt, paramString1));
    ((MMAlertDialog.Builder)localObject).setCancelable(true);
    this.l = ((MMAlertDialog.Builder)localObject).create();
    this.l.setCanceledOnTouchOutside(false);
    this.l.show();
  }
  
  @TargetApi(19)
  private void a(boolean paramBoolean)
  {
    Object localObject = this.i;
    if (localObject == null)
    {
      o.b("MicroMsg.HCEActivityMgr", "alvinluo checkDefaultNFCApplication mHceActivity is null");
      return;
    }
    localObject = CardEmulation.getInstance(NfcAdapter.getDefaultAdapter((Context)localObject));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("alvinluo component name: ");
    localStringBuilder.append(this.h);
    o.d("MicroMsg.HCEActivityMgr", localStringBuilder.toString());
    if (!((CardEmulation)localObject).isDefaultServiceForCategory(this.h, "payment"))
    {
      o.d("MicroMsg.HCEActivityMgr", "alvinluo not NFC Default Application, isAutoSet: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      if (paramBoolean) {
        b(this.h);
      }
    }
    else
    {
      o.d("MicroMsg.HCEActivityMgr", "alvinluo now is NFC Default Application");
      b(0, "NFC switch has opened and now is NFC default application");
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    this.j.send(10001, localBundle);
  }
  
  @TargetApi(19)
  private void b(ComponentName paramComponentName)
  {
    if (this.i == null)
    {
      o.b("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication mHceActivity is null");
      return;
    }
    o.d("MicroMsg.HCEActivityMgr", "alvinluo request set default NFC application, hasRequestSetDefault: %b", new Object[] { Boolean.valueOf(this.e) });
    if (this.e)
    {
      o.d("MicroMsg.HCEActivityMgr", "alvinluo has request set default NFC application");
      a(13004, "not set default NFC application", this.i.getString(2131891469));
      return;
    }
    this.m.postDelayed(new a.6(this, paramComponentName), 200L);
  }
  
  private void d()
  {
    Activity localActivity = this.i;
    if (localActivity != null)
    {
      this.k = WeUIProgresssDialog.show(localActivity, localActivity.getString(2131891462), false, null);
      return;
    }
    o.b("MicroMsg.HCEActivityMgr", "alvinluo showProgressDialog mHceActivity is null");
  }
  
  private void e()
  {
    WeUIProgresssDialog localWeUIProgresssDialog = this.k;
    if (localWeUIProgresssDialog != null)
    {
      localWeUIProgresssDialog.dismiss();
      this.k = null;
    }
  }
  
  private void f()
  {
    this.g = new a.1(this);
    this.f = new Timer();
    this.f.scheduleAtFixedRate(this.g, 0L, 300L);
    d();
  }
  
  private void g()
  {
    c();
    Timer localTimer = this.f;
    if (localTimer != null) {
      localTimer.cancel();
    }
  }
  
  private void h()
  {
    if (!d.c())
    {
      a(1, 13000, "not support NFC");
      return;
    }
    if (!d.b())
    {
      a(1, 13002, "not support HCE");
      return;
    }
    if (!d.d())
    {
      i();
      return;
    }
    a(true);
  }
  
  private void i()
  {
    Object localObject = this.i;
    if (localObject == null)
    {
      o.b("MicroMsg.HCEActivityMgr", "alvinluo showOpenNFCDialog mHceActivity is null");
      return;
    }
    if (this.c)
    {
      o.d("MicroMsg.HCEActivityMgr", "alvinluo has shown open NFC dialog");
      a(13001, "system NFC switch not opened", this.i.getString(2131891468));
      return;
    }
    localObject = new MMAlertDialog.Builder((Context)localObject);
    ((MMAlertDialog.Builder)localObject).setMsg(this.i.getString(2131891470)).setPositiveBtnText(this.i.getString(2131891466)).setPositiveBtnListener(new a.2(this));
    if (j()) {
      ((MMAlertDialog.Builder)localObject).setNegativeBtnText(this.i.getString(2131891460)).setNegativeBtnListener(new a.3(this));
    } else {
      ((MMAlertDialog.Builder)localObject).setPositiveBtnText(this.i.getString(2131891461));
    }
    ((MMAlertDialog.Builder)localObject).setOnCancelListener(new a.4(this));
    this.l = ((MMAlertDialog.Builder)localObject).create();
    this.l.setCanceledOnTouchOutside(false);
    this.l.show();
    this.c = true;
  }
  
  private boolean j()
  {
    if (this.i == null)
    {
      o.b("MicroMsg.HCEActivityMgr", "alvinluo isCanJumpNFCSetting mHceActivity is null");
      return false;
    }
    Object localObject = new Intent("android.settings.NFC_SETTINGS");
    localObject = this.i.getPackageManager().queryIntentActivities((Intent)localObject, 65536);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("alvinluo NFC activity not null, activities size: ");
      localStringBuilder.append(((List)localObject).size());
      o.d("MicroMsg.HCEActivityMgr", localStringBuilder.toString());
      int n = 0;
      while (n < ((List)localObject).size())
      {
        o.d("MicroMsg.HCEActivityMgr", "alvinluo NFC activity: %s", new Object[] { ((ResolveInfo)((List)localObject).get(n)).activityInfo.name });
        n += 1;
      }
      return true;
    }
    o.b("MicroMsg.HCEActivityMgr", "alvinluo Cannot jump to NFC setting");
    return false;
  }
  
  private void k()
  {
    if (this.i == null)
    {
      o.b("MicroMsg.HCEActivityMgr", "alvinluo jumpNFCSetting mHceActivity is null");
      return;
    }
    Intent localIntent = new Intent("android.settings.NFC_SETTINGS");
    LuggageActivityHelper.FOR(this.i).startActivityForResult(localIntent, new a.5(this));
  }
  
  public void a()
  {
    if (this.d)
    {
      f();
      return;
    }
    h();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      o.d("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_JUMP_NFC_SETTING");
      this.d = true;
      return;
    }
    if (paramInt == 2) {
      o.d("MicroMsg.HCEActivityMgr", "alvinluo back from REQUEST_SET_DEFAULT_NFC_APPLICATION");
    }
  }
  
  public void a(Activity paramActivity, ResultReceiver paramResultReceiver)
  {
    o.d("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity");
    if ((paramActivity == null) || (paramResultReceiver == null)) {
      o.b("MicroMsg.HCEActivityMgr", "alvinluo setHceActivity hceActivity is null, or resultReceiver is null");
    }
    this.i = paramActivity;
    this.j = paramResultReceiver;
  }
  
  public void a(ComponentName paramComponentName)
  {
    o.d("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent");
    if (paramComponentName == null) {
      o.b("MicroMsg.HCEActivityMgr", "alvinluo setPaymentServiceComponent paymentServiceComponent is null");
    }
    this.h = paramComponentName;
  }
  
  public void b()
  {
    this.d = false;
    this.e = false;
    this.c = false;
  }
  
  public void c()
  {
    MMAlertDialog localMMAlertDialog = this.l;
    if ((localMMAlertDialog != null) && (localMMAlertDialog.isShowing()))
    {
      this.l.dismiss();
      this.l = null;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a
 * JD-Core Version:    0.7.0.1
 */