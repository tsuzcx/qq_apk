package com.tencent.biz.qrcode.activity;

import Override;
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
import anvx;
import aohe;
import bdla;
import bhdj;
import bisl;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.ims.devlock_verify_scheme.SchemePkg;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import wtlogin.qrlogin.scanresult.QrLogin.RejectInfo;
import wtlogin.qrlogin.scanresult.QrLogin.RiskInfo;
import wtlogin.qrlogin.scanresult.QrLogin.ScanResultInfo;
import zlj;
import zlk;
import zll;
import zlm;
import zln;
import zlo;
import zmk;
import znj;
import znl;

public class QRLoginAuthActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener
{
  public static final String a;
  static final short[] jdField_a_of_type_ArrayOfShort = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  public static final String b;
  public static final String c;
  protected int a;
  public long a;
  public Handler a;
  protected Button a;
  protected ImageView a;
  public LinearLayout a;
  public ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  public bisl a;
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new zlj(this);
  protected boolean a;
  protected byte[] a;
  public int b;
  protected Button b;
  protected TextView b;
  protected boolean b;
  protected Button c;
  private boolean c;
  public String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  public String i;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131710661);
    jdField_b_of_type_JavaLangString = anvx.a(2131710662);
    jdField_c_of_type_JavaLangString = anvx.a(2131716431);
  }
  
  public QRLoginAuthActivity()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new zlm(this);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[24];
    int i1 = 0;
    int n = 0;
    int j = 0;
    int k = 0;
    int m = paramInt;
    paramInt = i1;
    i1 = m - 1;
    int i2 = j;
    if (m > 0)
    {
      j = k + 1;
      k = paramArrayOfByte[k];
      i2 = k;
      if (k != 0)
      {
        if (k != 95) {
          break label107;
        }
        i2 = k;
      }
    }
    if (i2 == 95)
    {
      j = paramInt;
      switch (n % 4)
      {
      }
    }
    for (;;)
    {
      return arrayOfByte;
      label107:
      m = k;
      if (k == 32) {
        m = 42;
      }
      k = jdField_a_of_type_ArrayOfShort[m];
      if (k < 0)
      {
        m = i1;
        i1 = j;
        j = k;
        k = i1;
        break;
      }
      switch (n % 4)
      {
      }
      for (;;)
      {
        i2 = n + 1;
        m = i1;
        n = k;
        k = j;
        j = n;
        n = i2;
        break;
        arrayOfByte[paramInt] = ((byte)(k << 2));
        continue;
        m = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | k >> 4));
        arrayOfByte[m] = ((byte)((k & 0xF) << 4));
        paramInt = m;
        continue;
        m = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | k >> 2));
        arrayOfByte[m] = ((byte)((k & 0x3) << 6));
        paramInt = m;
        continue;
        m = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | k));
        paramInt = m;
      }
      return null;
      j = paramInt + 1;
      arrayOfByte[j] = 0;
    }
  }
  
  public SpannableString a(String paramString1, String paramString2, StringBuilder paramStringBuilder)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramStringBuilder.append(",buildStringByUrl url=").append(paramString1).append("|").append(paramString2);
    paramStringBuilder = new SpannableString(paramString1);
    try
    {
      paramStringBuilder.setSpan(new zln(this, paramString2, true), 0, paramString1.length(), 17);
      paramStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(2131165802)), 0, paramString1.length(), 33);
      return paramStringBuilder;
    }
    catch (Exception paramString1)
    {
      QLog.e("QRLoginAuthActivity", 1, "buildStringByUrl", paramString1);
    }
    return paramStringBuilder;
  }
  
  public CharSequence a(QrLogin.RiskInfo paramRiskInfo, StringBuilder paramStringBuilder)
  {
    paramRiskInfo = new SpannableString(getString(2131716530, new Object[] { this.f }));
    paramStringBuilder = a(getResources().getString(2131718195), "https://kf.qq.com/touch/sappfaq/200910B7Fz6b200910YBVjIN.html", paramStringBuilder);
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
      if (localScanResultInfo.scan_result.has())
      {
        paramStringBuilder.append(",scan=").append(localScanResultInfo.scan_result.get());
        return localScanResultInfo;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e("QRLoginAuthActivity", 1, paramArrayOfByte, new Object[0]);
      }
      paramStringBuilder.append(",scan=null");
    }
    return null;
  }
  
  public zlo a(byte[] paramArrayOfByte, StringBuilder paramStringBuilder)
  {
    Object localObject1 = null;
    if (paramArrayOfByte == null)
    {
      paramStringBuilder.append("，tlv == null");
      return new zlo(null, null);
    }
    int j = 0;
    QrLogin.ScanResultInfo localScanResultInfo = null;
    if (j < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[j];
      int m = j + 1;
      j = k << 8 & 0xFF00 | paramArrayOfByte[m] & 0xFF;
      m += 1;
      k = paramArrayOfByte[m];
      m += 1;
      k = k << 8 & 0xFF00 | paramArrayOfByte[m] & 0xFF;
      paramStringBuilder.append(",t=").append(j).append(" l=").append(k);
      m += 1;
      Object localObject2;
      if (j == 3) {
        localObject2 = new String(paramArrayOfByte, m, k);
      }
      for (;;)
      {
        j = m + k;
        localObject1 = localObject2;
        break;
        if (j == 5)
        {
          this.g = new String(paramArrayOfByte, m, k);
          paramStringBuilder.append("，TLV_5:").append(this.g);
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
          this.jdField_b_of_type_Int = ((localObject2[0] & 0xFF) << 24 | j & 0xFF | (n & 0xFF) << 8 | (i1 & 0xFF) << 16);
          paramStringBuilder.append("，TLV_53 wtlogin apptype:").append(this.jdField_b_of_type_Int);
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
      }
    }
    return new zlo(localScanResultInfo, localObject1);
  }
  
  protected void a()
  {
    super.setContentView(2131560462);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131370546));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131374752));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131365068));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131379117));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363324));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370714));
    this.jdField_a_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373057));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131365598));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)super.findViewById(2131374753));
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
    localObject = new StringBuilder("handleUiSHow");
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    if (j == 0) {}
    for (;;)
    {
      try
      {
        paramBundle = a(arrayOfByte2, (StringBuilder)localObject);
        if (paramBundle == null) {
          break label235;
        }
        paramBundle = paramBundle.a;
        boolean bool = a(arrayOfByte1, paramBundle, (StringBuilder)localObject);
        ((StringBuilder)localObject).append("，isShowUiByScanResultInfo=").append(bool);
        if (!bool) {
          a(arrayOfByte1);
        }
        QLog.d("QRLoginAuthActivity", 1, ((StringBuilder)localObject).toString());
        bdla.b(null, "dc00898", "", "", "0X800A46D", "0X800A46D", znj.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.e("QRLoginAuthActivity", 1, paramBundle, new Object[0]);
        paramBundle = null;
        continue;
      }
      ((StringBuilder)localObject).append("ret != 0,errMsg = ").append(new String(paramBundle));
      a(new String(paramBundle));
      continue;
      label235:
      paramBundle = null;
    }
  }
  
  public void a(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    Object localObject;
    if (!HttpUtil.isConnect(this))
    {
      localObject = bhdj.a(this, 230);
      ((QQCustomDialog)localObject).setMessage(2131718197);
      ((QQCustomDialog)localObject).setPositiveButton(2131694399, new zll(this));
      ((QQCustomDialog)localObject).show();
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = getString(2131718194);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839717));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131718193);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  protected void a(boolean paramBoolean)
  {
    ((aohe)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).b();
    this.jdField_a_of_type_Bisl = new bisl(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bisl.c(2131716568);
    this.jdField_a_of_type_Bisl.setOnCancelListener(new zlk(this));
    this.jdField_a_of_type_Bisl.show();
    Object localObject1 = znl.a(this.app.getOnlineStauts());
    Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
    ((ByteBuffer)localObject2).putShort((short)2);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    localObject2 = ((ByteBuffer)localObject2).array();
    Object localObject3 = this.app.getUinDisplayNameBeforeLogin(this.d);
    localObject1 = new ArrayList();
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(this.d)))
    {
      localObject3 = ((String)localObject3).getBytes();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localObject3.length + 4);
      localByteBuffer.putShort((short)1);
      localByteBuffer.putShort((short)localObject3.length);
      localByteBuffer.put((byte[])localObject3);
      localObject3 = localByteBuffer.array();
      localByteBuffer = ByteBuffer.allocate(localObject3.length + 4);
      localByteBuffer.putShort((short)4);
      localByteBuffer.putShort((short)localObject3.length);
      localByteBuffer.put((byte[])localObject3);
      localObject3 = localByteBuffer.array();
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr((byte[])localObject2));
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr((byte[])localObject3));
      localObject2 = ByteBuffer.allocate(8);
      ((ByteBuffer)localObject2).putShort((short)21);
      ((ByteBuffer)localObject2).putShort((short)4);
      if (!paramBoolean) {
        break label355;
      }
    }
    label355:
    for (int j = 1;; j = 0)
    {
      ((ByteBuffer)localObject2).putInt(j);
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr(((ByteBuffer)localObject2).array()));
      this.jdField_a_of_type_MqqManagerWtloginManager.closeCode(this.d, 16L, this.jdField_a_of_type_ArrayOfByte, 1, (ArrayList)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr((byte[])localObject2));
      break;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    b(paramArrayOfByte);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131716531, new Object[] { this.f }));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if (TextUtils.isEmpty(this.g)) {
      this.g = getString(2131719807);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131716537, new Object[] { this.g }));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131716532);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
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
        if ((!paramArrayOfByte.u32_button2_type.has()) || (paramArrayOfByte.u32_button2_type.get() == 0)) {
          break label143;
        }
        paramInt1 = 1;
        if ((paramArrayOfByte.str_button2_caption.has()) && (!TextUtils.isEmpty(paramArrayOfByte.str_button2_caption.get())))
        {
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
      paramInt2 = 0;
      continue;
      label143:
      paramInt1 = 0;
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
      bdla.b(null, "dc00898", "", "", "0X800B6BA", "0X800B6BA", 0, 0, "", "", "", "");
      return true;
    }
    if (j == 1)
    {
      a(paramArrayOfByte);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a((QrLogin.RiskInfo)paramScanResultInfo.risk_info.get(), paramStringBuilder));
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131716555);
      bdla.b(null, "dc00898", "", "", "0X800B5AA", "0X800B5AA", 0, 0, "", "", "", "");
      return true;
    }
    if (j == 2)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130846243));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramScanResultInfo.reject_info.get() != null)
      {
        paramArrayOfByte = ((QrLogin.RejectInfo)paramScanResultInfo.reject_info.get()).str_tips.get();
        paramStringBuilder.append("，rejectTip=").append(paramArrayOfByte);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramArrayOfByte);
      }
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131716556);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      bdla.b(null, "dc00898", "", "", "0X800B5A8", "0X800B5A8", 0, 0, "", "", "", "");
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
      this.jdField_a_of_type_ArrayOfByte = a(((String)localObject).getBytes(), ((String)localObject).length());
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
    if ((this.jdField_b_of_type_Int == 65793) || (this.jdField_b_of_type_Int == 77313))
    {
      this.f = "Windows";
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130846997));
      return;
    }
    if (this.jdField_b_of_type_Int == 5)
    {
      this.f = "Mac";
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130846997));
      return;
    }
    if (this.jdField_b_of_type_Int == 3)
    {
      this.f = "iPad";
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130846998));
      return;
    }
    if (znj.b(this.jdField_b_of_type_Int))
    {
      this.f = jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130847000));
      return;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (paramArrayOfByte = jdField_b_of_type_JavaLangString;; paramArrayOfByte = new String(paramArrayOfByte))
    {
      this.f = paramArrayOfByte;
      QLog.d("QRLoginAuthActivity", 1, new Object[] { "wtlogin unknown apptype:", Integer.valueOf(this.jdField_b_of_type_Int), " loginDeviceName is : ", this.f });
      return;
    }
  }
  
  public void c()
  {
    if (!isFinishing())
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      localIntent.setFlags(67108864);
      super.startActivity(localIntent);
    }
    Toast.makeText(getApplicationContext(), 2131718196, 0).show();
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.d = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.app.getManager(1));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginAuthActivity", 2, "wtloginManager:" + this.jdField_a_of_type_MqqManagerWtloginManager + " isLogin:" + this.app.isLogin());
    }
    if (this.app.isLogin())
    {
      b();
      return true;
    }
    a(null);
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      this.jdField_a_of_type_Bisl.dismiss();
    }
    super.doOnDestroy();
    zmk.a(this);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j == 2131365068) {
      if (this.jdField_b_of_type_Boolean)
      {
        Intent localIntent = new Intent(this, ScannerActivity.class);
        localIntent.setFlags(67108864);
        startActivity(localIntent);
        if (this.jdField_c_of_type_Boolean) {
          finish();
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(false);
      bdla.b(null, "dc00898", "", "", "0X800A46E", "0X800A46E", znj.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
      continue;
      if (j == 2131379117)
      {
        a(true);
        bdla.b(null, "dc00898", "", "", "0X800A46F", "0X800A46F", znj.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
      }
      else if (j == 2131369988)
      {
        finish();
        this.jdField_a_of_type_MqqManagerWtloginManager.cancelCode(getCurrentAccountUin(), 16L, this.jdField_a_of_type_ArrayOfByte);
      }
      else if (j == 2131363324)
      {
        doOnBackPressed();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginAuthActivity
 * JD-Core Version:    0.7.0.1
 */