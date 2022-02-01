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
  public static final String a;
  public static final String b;
  public static final String c;
  protected int a;
  protected long a;
  Handler jdField_a_of_type_AndroidOsHandler = new QRLoginAuthActivity.4(this);
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  protected QQProgressDialog a;
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new QRLoginAuthActivity.1(this);
  protected boolean a;
  protected byte[] a;
  protected int b;
  protected Button b;
  protected TextView b;
  protected boolean b;
  protected Button c;
  private boolean c;
  protected String d;
  protected String e;
  protected String f = null;
  protected String g = null;
  protected String h;
  protected String i;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131711152);
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131711153);
    jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131716577);
  }
  
  public QRLoginAuthActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
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
        paramStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131165795)), 0, paramString1.length(), 33);
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
    int j = 0;
    while (j < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[j];
      int m = j + 1;
      j = k << 8 & 0xFF00 | paramArrayOfByte[m] & 0xFF;
      m += 1;
      k = paramArrayOfByte[m];
      m += 1;
      k = 0xFF00 & k << 8 | paramArrayOfByte[m] & 0xFF;
      paramStringBuilder.append(",t=");
      paramStringBuilder.append(j);
      paramStringBuilder.append(" l=");
      paramStringBuilder.append(k);
      m += 1;
      Object localObject2;
      if (j == 3)
      {
        localObject2 = new String(paramArrayOfByte, m, k);
      }
      else if (j == 5)
      {
        this.g = new String(paramArrayOfByte, m, k);
        paramStringBuilder.append("，TLV_5:");
        paramStringBuilder.append(this.g);
        localObject2 = localObject1;
      }
      else if (j == 32)
      {
        a(paramArrayOfByte, m, k);
        localObject2 = localObject1;
      }
      else if (j == 53)
      {
        localObject2 = new byte[4];
        System.arraycopy(paramArrayOfByte, m, localObject2, 0, k);
        j = localObject2[3];
        int n = localObject2[2];
        int i1 = localObject2[1];
        this.jdField_b_of_type_Int = ((localObject2[0] & 0xFF) << 24 | (i1 & 0xFF) << 16 | j & 0xFF | (n & 0xFF) << 8);
        paramStringBuilder.append("，TLV_53 wtlogin apptype:");
        paramStringBuilder.append(this.jdField_b_of_type_Int);
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = localObject1;
        if (j == 208)
        {
          localScanResultInfo = a(paramArrayOfByte, m, k, paramStringBuilder);
          localObject2 = localObject1;
        }
      }
      j = m + k;
      localObject1 = localObject2;
    }
    return new QRLoginAuthActivity.VerifyCodeTlvInfo(localScanResultInfo, (String)localObject1);
  }
  
  public CharSequence a(QrLogin.RiskInfo paramRiskInfo, StringBuilder paramStringBuilder)
  {
    paramRiskInfo = new SpannableString(getString(2131716678, new Object[] { this.f }));
    paramStringBuilder = a(getResources().getString(2131718417), "https://kf.qq.com/touch/sappfaq/200910B7Fz6b200910YBVjIN.html", paramStringBuilder);
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
    super.setContentView(2131560438);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131370462));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131374639));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365082));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131378898));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363335));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370629));
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372963));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365597));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131374640));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  public void a(Bundle paramBundle)
  {
    int j = paramBundle.getInt("ret", 1);
    byte[] arrayOfByte1 = paramBundle.getByteArray("appName");
    byte[] arrayOfByte2 = paramBundle.getByteArray("tlv");
    Object localObject = paramBundle.getByteArray("errMsg");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = new byte[0];
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    StringBuilder localStringBuilder = new StringBuilder("handleUiSHow");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    if (j == 0)
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
    ReportController.b(null, "dc00898", "", "", "0X800A46D", "0X800A46D", LoginDevicesUtils.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
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
      ((QQCustomDialog)localObject).setMessage(2131718419);
      ((QQCustomDialog)localObject).setPositiveButton(2131694583, new QRLoginAuthActivity.3(this));
      ((QQCustomDialog)localObject).show();
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = getString(2131718416);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839667));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131718415);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  protected void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716679, new Object[] { this.f }));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (TextUtils.isEmpty(this.g)) {
      this.g = getString(2131720116);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131716685, new Object[] { this.g }));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    } else {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131716680);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
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
            this.jdField_a_of_type_Int = paramArrayOfByte.u32_button2_auth.get();
          }
          if ((paramInt1 != 0) && (paramInt2 != 0) && (this.jdField_a_of_type_Int == 2))
          {
            this.jdField_a_of_type_Boolean = true;
            return;
          }
          this.jdField_a_of_type_Boolean = false;
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
    int j = paramScanResultInfo.scan_result.get();
    if (j == 0)
    {
      a(paramArrayOfByte);
      ReportController.b(null, "dc00898", "", "", "0X800B6BA", "0X800B6BA", 0, 0, "", "", "", "");
      return true;
    }
    if (j == 1)
    {
      a(paramArrayOfByte);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a((QrLogin.RiskInfo)paramScanResultInfo.risk_info.get(), paramStringBuilder));
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131716703);
      ReportController.b(null, "dc00898", "", "", "0X800B5AA", "0X800B5AA", 0, 0, "", "", "", "");
      return true;
    }
    if (j == 2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130846472));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramScanResultInfo.reject_info.get() != null)
      {
        paramArrayOfByte = ((QrLogin.RejectInfo)paramScanResultInfo.reject_info.get()).str_tips.get();
        paramStringBuilder.append("，rejectTip=");
        paramStringBuilder.append(paramArrayOfByte);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramArrayOfByte);
      }
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131716704);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
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
    this.e = ((Intent)localObject).getStringExtra("QR_CODE_STRING");
    this.jdField_c_of_type_Boolean = ((Intent)localObject).getBooleanExtra("KEY_QR_CODE_EXPIRED", false);
    localObject = getIntent().getStringExtra("KEY_ERROR_MSG");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("QRLoginAuthActivity", 1, new Object[] { "requestQRLogin, errorMsg is ", localObject });
      a((String)localObject);
      return;
    }
    try
    {
      int j = this.e.indexOf("?k=") + 3;
      localObject = this.e.substring(j, j + 32);
      this.jdField_a_of_type_ArrayOfByte = QRLoginAuthUtil.a(((String)localObject).getBytes(), ((String)localObject).length());
      this.h = this.e.substring(this.e.indexOf("&f=") + 3);
      localObject = this.jdField_a_of_type_MqqManagerWtloginManager;
      String str = this.d;
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
      ((WtloginManager)localObject).verifyCode(str, 16L, true, arrayOfByte, new int[] { 3, 5, 32, 53 }, 1, localWtloginObserver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QRLoginAuthActivity", 1, new Object[] { "qrCodeString illegal, qrCode: ", this.e, " exception: ", localException.getMessage() });
      a(null);
    }
  }
  
  protected void b(byte[] paramArrayOfByte)
  {
    int j = this.jdField_b_of_type_Int;
    if ((j != 65793) && (j != 77313))
    {
      if (j == 5)
      {
        this.f = "Mac";
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847220));
        return;
      }
      if (j == 3)
      {
        this.f = "iPad";
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847221));
        return;
      }
      if (LoginDevicesUtils.b(j))
      {
        this.f = jdField_a_of_type_JavaLangString;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847223));
        return;
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
        paramArrayOfByte = new String(paramArrayOfByte);
      } else {
        paramArrayOfByte = jdField_b_of_type_JavaLangString;
      }
      this.f = paramArrayOfByte;
      QLog.d("QRLoginAuthActivity", 1, new Object[] { "wtlogin unknown apptype:", Integer.valueOf(this.jdField_b_of_type_Int), " loginDeviceName is : ", this.f });
      return;
    }
    this.f = "Windows";
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847220));
  }
  
  protected void c()
  {
    if (!isFinishing())
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
      localIntent.setFlags(67108864);
      super.startActivity(localIntent);
    }
    Toast.makeText(getApplicationContext(), 2131718418, 0).show();
    if ((!TextUtils.isEmpty(this.h)) && ("1600000104".equals(this.h.trim())))
    {
      localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      localIntent.putExtra("loginInfo", this.g);
      localIntent.putExtra("loginAppId", this.h);
      localIntent.putExtra("status", "login");
      super.sendBroadcast(localIntent);
      return;
    }
    Intent localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
    localIntent.putExtra("loginInfo", this.g);
    localIntent.putExtra("status", "login");
    localIntent.putExtra("bannerTips", this.i);
    localIntent.putExtra("subappid", this.jdField_a_of_type_Long);
    localIntent.putExtra("appType", this.jdField_b_of_type_Int);
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
    this.jdField_a_of_type_MqqManagerWtloginManager.cancelCode(getCurrentAccountUin(), 16L, this.jdField_a_of_type_ArrayOfByte);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.d = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.app.getManager(1));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("wtloginManager:");
      paramBundle.append(this.jdField_a_of_type_MqqManagerWtloginManager);
      paramBundle.append(" isLogin:");
      paramBundle.append(this.app.isLogin());
      QLog.d("QRLoginAuthActivity", 2, paramBundle.toString());
    }
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
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    super.doOnDestroy();
    QRUtils.a(this);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131365082)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        Intent localIntent = new Intent();
        localIntent.setFlags(67108864);
        RouteUtils.a(this, localIntent, "/qrscan/scanner");
        if (this.jdField_c_of_type_Boolean) {
          finish();
        }
      }
      else
      {
        a(false);
        ReportController.b(null, "dc00898", "", "", "0X800A46E", "0X800A46E", LoginDevicesUtils.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
      }
    }
    else if (j == 2131378898)
    {
      a(true);
      ReportController.b(null, "dc00898", "", "", "0X800A46F", "0X800A46F", LoginDevicesUtils.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
    }
    else if (j == 2131369926)
    {
      finish();
      this.jdField_a_of_type_MqqManagerWtloginManager.cancelCode(getCurrentAccountUin(), 16L, this.jdField_a_of_type_ArrayOfByte);
    }
    else if (j == 2131363335)
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