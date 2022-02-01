package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.logindev.LoginDevicesUtils;
import com.tencent.ims.devlock_verify_scheme.SchemePkg;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.login.TicketChecker;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.agent.util.QRLoginAuthUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import wtlogin.qrlogin.scanresult.QrLogin.RejectInfo;
import wtlogin.qrlogin.scanresult.QrLogin.RiskInfo;
import wtlogin.qrlogin.scanresult.QrLogin.ScanResultInfo;

public class QRLoginAuthActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener
{
  public static final String a = HardCodeUtil.a(2131908817);
  public static final String b = HardCodeUtil.a(2131908818);
  public static final String c = HardCodeUtil.a(2131914040);
  private WtloginManager B;
  private boolean C;
  private WtloginObserver D = new QRLoginAuthActivity.1(this);
  protected String d;
  protected RelativeLayout e;
  protected LinearLayout f;
  protected TextView g;
  protected TextView h;
  protected ImageView i;
  protected ProgressBar j;
  protected Button k;
  protected Button l;
  protected Button m;
  protected boolean n = false;
  protected int o = 0;
  protected byte[] p;
  protected String q;
  protected boolean r = false;
  protected String s = null;
  protected String t = null;
  protected QQProgressDialog u;
  protected String v;
  protected int w = -1;
  protected String x;
  protected long y;
  Handler z = new QRLoginAuthActivity.4(this);
  
  private void d()
  {
    new TicketChecker().a(this, this.app, getString(2131894255), getString(2131894254), "qr_login", null);
  }
  
  public SpannableString a(String paramString1, String paramString2, StringBuilder paramStringBuilder)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramStringBuilder.append(",buildStringByUrl url=");
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append("|");
      paramStringBuilder.append(paramString2);
      paramStringBuilder = new SpannableString(paramString1);
      try
      {
        paramStringBuilder.setSpan(new QRLoginAuthActivity.MyQQBrowserLinkSpan(this, paramString2, true), 0, paramString1.length(), 17);
        paramStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131166411)), 0, paramString1.length(), 33);
        return paramStringBuilder;
      }
      catch (Exception paramString1)
      {
        QLog.e("QRLoginAuthActivity", 1, "buildStringByUrl", paramString1);
        return paramStringBuilder;
      }
    }
    return null;
  }
  
  public QRLoginAuthActivity.VerifyCodeTlvInfo a(byte[] paramArrayOfByte, StringBuilder paramStringBuilder)
  {
    if (paramArrayOfByte == null)
    {
      paramStringBuilder.append("，tlv == null");
      return new QRLoginAuthActivity.VerifyCodeTlvInfo(null, null);
    }
    QrLogin.ScanResultInfo localScanResultInfo = null;
    Object localObject1 = localScanResultInfo;
    int i1 = 0;
    while (i1 < paramArrayOfByte.length)
    {
      int i2 = paramArrayOfByte[i1];
      int i3 = i1 + 1;
      i1 = i2 << 8 & 0xFF00 | paramArrayOfByte[i3] & 0xFF;
      i3 += 1;
      i2 = paramArrayOfByte[i3];
      i3 += 1;
      i2 = 0xFF00 & i2 << 8 | paramArrayOfByte[i3] & 0xFF;
      paramStringBuilder.append(",t=");
      paramStringBuilder.append(i1);
      paramStringBuilder.append(" l=");
      paramStringBuilder.append(i2);
      i3 += 1;
      Object localObject2;
      if (i1 == 3)
      {
        localObject2 = new String(paramArrayOfByte, i3, i2);
      }
      else if (i1 == 5)
      {
        this.t = new String(paramArrayOfByte, i3, i2);
        paramStringBuilder.append("，TLV_5:");
        paramStringBuilder.append(this.t);
        localObject2 = localObject1;
      }
      else if (i1 == 32)
      {
        a(paramArrayOfByte, i3, i2);
        localObject2 = localObject1;
      }
      else if (i1 == 53)
      {
        localObject2 = new byte[4];
        System.arraycopy(paramArrayOfByte, i3, localObject2, 0, i2);
        i1 = localObject2[3];
        int i4 = localObject2[2];
        int i5 = localObject2[1];
        this.w = ((localObject2[0] & 0xFF) << 24 | (i5 & 0xFF) << 16 | i1 & 0xFF | (i4 & 0xFF) << 8);
        paramStringBuilder.append("，TLV_53 wtlogin apptype:");
        paramStringBuilder.append(this.w);
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = localObject1;
        if (i1 == 208)
        {
          localScanResultInfo = a(paramArrayOfByte, i3, i2, paramStringBuilder);
          localObject2 = localObject1;
        }
      }
      i1 = i3 + i2;
      localObject1 = localObject2;
    }
    return new QRLoginAuthActivity.VerifyCodeTlvInfo(localScanResultInfo, (String)localObject1);
  }
  
  public CharSequence a(QrLogin.RiskInfo paramRiskInfo, StringBuilder paramStringBuilder)
  {
    paramRiskInfo = new SpannableString(getString(2131914142, new Object[] { this.s }));
    paramStringBuilder = a(getResources().getString(2131915916), "https://kf.qq.com/touch/sappfaq/200910B7Fz6b200910YBVjIN.html", paramStringBuilder);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(paramRiskInfo);
    if (paramStringBuilder != null) {
      localSpannableStringBuilder.append(paramStringBuilder);
    }
    return localSpannableStringBuilder;
  }
  
  public QrLogin.ScanResultInfo a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(",handleTlv208");
    QrLogin.ScanResultInfo localScanResultInfo = new QrLogin.ScanResultInfo();
    try
    {
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      localScanResultInfo.mergeFrom(arrayOfByte);
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e("QRLoginAuthActivity", 1, paramArrayOfByte, new Object[0]);
    }
    if (localScanResultInfo.scan_result.has())
    {
      paramStringBuilder.append(",scan=");
      paramStringBuilder.append(localScanResultInfo.scan_result.get());
      return localScanResultInfo;
    }
    paramStringBuilder.append(",scan=null");
    return null;
  }
  
  protected void a()
  {
    super.setContentView(2131626483);
    this.e = ((RelativeLayout)super.findViewById(2131437734));
    this.f = ((LinearLayout)super.findViewById(2131442814));
    this.k = ((Button)super.findViewById(2131431219));
    this.l = ((Button)super.findViewById(2131447600));
    this.m = ((Button)super.findViewById(2131429210));
    this.g = ((TextView)super.findViewById(2131437904));
    this.g.setMovementMethod(LinkMovementMethod.getInstance());
    this.h = ((TextView)super.findViewById(2131440528));
    this.i = ((ImageView)super.findViewById(2131431824));
    this.j = ((ProgressBar)super.findViewById(2131442815));
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
  }
  
  public void a(Bundle paramBundle)
  {
    int i1 = paramBundle.getInt("ret", 1);
    byte[] arrayOfByte1 = paramBundle.getByteArray("appName");
    byte[] arrayOfByte2 = paramBundle.getByteArray("tlv");
    Object localObject = paramBundle.getByteArray("errMsg");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new byte[0];
    }
    this.f.setVisibility(0);
    StringBuilder localStringBuilder = new StringBuilder("handleUiSHow");
    this.j.setVisibility(8);
    if (i1 == 0)
    {
      localObject = null;
      try
      {
        paramBundle = a(arrayOfByte2, localStringBuilder);
      }
      catch (Exception paramBundle)
      {
        QLog.e("QRLoginAuthActivity", 1, paramBundle, new Object[0]);
        paramBundle = null;
      }
      if (paramBundle != null) {
        localObject = paramBundle.a;
      }
      boolean bool = a(arrayOfByte1, (QrLogin.ScanResultInfo)localObject, localStringBuilder);
      localStringBuilder.append("，isShowUiByScanResultInfo=");
      localStringBuilder.append(bool);
      if (!bool) {
        a(arrayOfByte1);
      }
    }
    else
    {
      localStringBuilder.append("ret != 0,errMsg = ");
      localStringBuilder.append(new String(paramBundle));
      a(new String(paramBundle));
    }
    QLog.d("QRLoginAuthActivity", 1, localStringBuilder.toString());
    ReportController.b(null, "dc00898", "", "", "0X800A46D", "0X800A46D", LoginDevicesUtils.c(this.w), 0, "", "", "", "");
  }
  
  protected void a(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    Object localObject;
    if (!HttpUtil.isConnect(this))
    {
      localObject = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject).setMessage(2131915918);
      ((QQCustomDialog)localObject).setPositiveButton(2131892267, new QRLoginAuthActivity.3(this));
      ((QQCustomDialog)localObject).show();
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = getString(2131915915);
    }
    this.f.setVisibility(0);
    this.i.setVisibility(0);
    this.i.setImageDrawable(getResources().getDrawable(2130840139));
    this.h.setVisibility(0);
    this.g.setVisibility(8);
    this.h.setText((CharSequence)localObject);
    this.r = true;
    this.k.setText(2131915914);
    this.k.setVisibility(0);
    this.l.setVisibility(8);
  }
  
  protected void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte);
    this.g.setText(getString(2131914143, new Object[] { this.s }));
    this.g.setVisibility(0);
    if (TextUtils.isEmpty(this.t)) {
      this.t = getString(2131917742);
    }
    this.h.setText(getString(2131914149, new Object[] { this.t }));
    this.h.setVisibility(0);
    if (this.n) {
      this.l.setVisibility(0);
    } else {
      this.l.setVisibility(8);
    }
    this.k.setVisibility(0);
    this.k.setText(2131914144);
    this.m.setVisibility(8);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
        paramArrayOfByte = new devlock_verify_scheme.SchemePkg();
        paramArrayOfByte.mergeFrom(arrayOfByte);
        if ((paramArrayOfByte.u32_button2_type.has()) && (paramArrayOfByte.u32_button2_type.get() != 0))
        {
          paramInt1 = 1;
          if ((!paramArrayOfByte.str_button2_caption.has()) || (TextUtils.isEmpty(paramArrayOfByte.str_button2_caption.get()))) {
            break label149;
          }
          paramInt2 = 1;
          if (paramArrayOfByte.u32_button2_auth.has()) {
            this.o = paramArrayOfByte.u32_button2_auth.get();
          }
          if ((paramInt1 != 0) && (paramInt2 != 0) && (this.o == 2))
          {
            this.n = true;
            return;
          }
          this.n = false;
          return;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        QLog.e("QRLoginAuthActivity", 1, paramArrayOfByte, new Object[0]);
        return;
      }
      paramInt1 = 0;
      continue;
      label149:
      paramInt2 = 0;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, QrLogin.ScanResultInfo paramScanResultInfo, StringBuilder paramStringBuilder)
  {
    if (paramScanResultInfo == null) {
      return false;
    }
    if (!paramScanResultInfo.scan_result.has()) {
      return false;
    }
    int i1 = paramScanResultInfo.scan_result.get();
    if (i1 == 0)
    {
      a(paramArrayOfByte);
      ReportController.b(null, "dc00898", "", "", "0X800B6BA", "0X800B6BA", 0, 0, "", "", "", "");
      return true;
    }
    if (i1 == 1)
    {
      a(paramArrayOfByte);
      this.g.setText(a((QrLogin.RiskInfo)paramScanResultInfo.risk_info.get(), paramStringBuilder));
      this.m.setVisibility(0);
      this.m.setText(2131914167);
      ReportController.b(null, "dc00898", "", "", "0X800B5AA", "0X800B5AA", 0, 0, "", "", "", "");
      return true;
    }
    if (i1 == 2)
    {
      this.i.setImageDrawable(getResources().getDrawable(2130847945));
      this.g.setVisibility(0);
      this.h.setVisibility(8);
      if (paramScanResultInfo.reject_info.get() != null)
      {
        paramArrayOfByte = ((QrLogin.RejectInfo)paramScanResultInfo.reject_info.get()).str_tips.get();
        paramStringBuilder.append("，rejectTip=");
        paramStringBuilder.append(paramArrayOfByte);
        this.g.setText(paramArrayOfByte);
      }
      this.m.setVisibility(0);
      this.m.setText(2131914168);
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      ReportController.b(null, "dc00898", "", "", "0X800B5A8", "0X800B5A8", 0, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    if (super.isFinishing()) {
      return;
    }
    Object localObject = super.getIntent();
    this.q = ((Intent)localObject).getStringExtra("QR_CODE_STRING");
    this.C = ((Intent)localObject).getBooleanExtra("KEY_QR_CODE_EXPIRED", false);
    localObject = getIntent().getStringExtra("KEY_ERROR_MSG");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("QRLoginAuthActivity", 1, new Object[] { "requestQRLogin, errorMsg is ", localObject });
      a((String)localObject);
      return;
    }
    try
    {
      int i1 = this.q.indexOf("?k=") + 3;
      localObject = this.q.substring(i1, i1 + 32);
      this.p = QRLoginAuthUtil.a(((String)localObject).getBytes(), ((String)localObject).length());
      this.v = this.q.substring(this.q.indexOf("&f=") + 3);
      localObject = this.B;
      String str = this.d;
      byte[] arrayOfByte = this.p;
      WtloginObserver localWtloginObserver = this.D;
      ((WtloginManager)localObject).verifyCode(str, 16L, true, arrayOfByte, new int[] { 3, 5, 32, 53 }, 1, localWtloginObserver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QRLoginAuthActivity", 1, new Object[] { "qrCodeString illegal, qrCode: ", this.q, " exception: ", localException.getMessage() });
      a(null);
    }
  }
  
  protected void b(byte[] paramArrayOfByte)
  {
    int i1 = this.w;
    if ((i1 != 65793) && (i1 != 77313))
    {
      if (i1 == 5)
      {
        this.s = "Mac";
        this.i.setImageDrawable(getResources().getDrawable(2130848803));
        return;
      }
      if (i1 == 3)
      {
        this.s = "iPad";
        this.i.setImageDrawable(getResources().getDrawable(2130848804));
        return;
      }
      if (LoginDevicesUtils.b(i1))
      {
        this.s = a;
        this.i.setImageDrawable(getResources().getDrawable(2130848806));
        return;
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
        paramArrayOfByte = new String(paramArrayOfByte);
      } else {
        paramArrayOfByte = b;
      }
      this.s = paramArrayOfByte;
      QLog.d("QRLoginAuthActivity", 1, new Object[] { "wtlogin unknown apptype:", Integer.valueOf(this.w), " loginDeviceName is : ", this.s });
      return;
    }
    this.s = "Windows";
    this.i.setImageDrawable(getResources().getDrawable(2130848803));
  }
  
  protected void c()
  {
    if (!isFinishing())
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.setFlags(67108864);
      super.startActivity(localIntent);
    }
    Toast.makeText(getApplicationContext(), 2131915917, 0).show();
    if ((!TextUtils.isEmpty(this.v)) && ("1600000104".equals(this.v.trim())))
    {
      localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      localIntent.putExtra("loginInfo", this.t);
      localIntent.putExtra("loginAppId", this.v);
      localIntent.putExtra("status", "login");
      super.sendBroadcast(localIntent);
      return;
    }
    Intent localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
    localIntent.putExtra("loginInfo", this.t);
    localIntent.putExtra("status", "login");
    localIntent.putExtra("bannerTips", this.x);
    localIntent.putExtra("subappid", this.y);
    localIntent.putExtra("appType", this.w);
    super.sendBroadcast(localIntent);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    this.B.cancelCode(getCurrentAccountUin(), 16L, this.p);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.d = this.app.getCurrentAccountUin();
    this.B = ((WtloginManager)this.app.getManager(1));
    this.A.setOnClickListener(this);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("wtloginManager:");
      paramBundle.append(this.B);
      paramBundle.append(" isLogin:");
      paramBundle.append(this.app.isLogin());
      QLog.d("QRLoginAuthActivity", 2, paramBundle.toString());
    }
    d();
    if (this.app.isLogin())
    {
      b();
      return true;
    }
    a(null);
    return true;
  }
  
  protected void doOnDestroy()
  {
    QQProgressDialog localQQProgressDialog = this.u;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.u.dismiss();
    }
    super.doOnDestroy();
    QRUtils.a(this);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131431219)
    {
      if (this.r)
      {
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        RouteUtils.a(this, localIntent, "/qrscan/scanner");
        if (this.C) {
          finish();
        }
      }
      else
      {
        a(false);
        ReportController.b(null, "dc00898", "", "", "0X800A46E", "0X800A46E", LoginDevicesUtils.c(this.w), 0, "", "", "", "");
      }
    }
    else if (i1 == 2131447600)
    {
      a(true);
      ReportController.b(null, "dc00898", "", "", "0X800A46F", "0X800A46F", LoginDevicesUtils.c(this.w), 0, "", "", "", "");
    }
    else if (i1 == 2131437067)
    {
      finish();
      this.B.cancelCode(getCurrentAccountUin(), 16L, this.p);
    }
    else if (i1 == 2131429210)
    {
      doOnBackPressed();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginAuthActivity
 * JD-Core Version:    0.7.0.1
 */