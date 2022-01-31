package com.tencent.biz.qrcode.activity;

import alto;
import alud;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import anif;
import arrr;
import auew;
import azqs;
import azri;
import bdgc;
import bdhe;
import bety;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import nrc;
import org.json.JSONObject;
import yae;
import yag;
import yah;
import yai;
import yak;
import yap;
import yas;
import yat;
import yau;
import zha;

public class ScannerActivity
  extends BaseActivity
{
  public static boolean a;
  private long jdField_a_of_type_Long;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new yai(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private bety jdField_a_of_type_Bety;
  public ScannerParams a;
  public ARScanAR a;
  public OcrConfig a;
  private String jdField_a_of_type_JavaLangString;
  private yap jdField_a_of_type_Yap;
  private yas jdField_a_of_type_Yas = new yag(this);
  private yat jdField_a_of_type_Yat;
  private zha jdField_a_of_type_Zha = new yae(this);
  private long b;
  public boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g = true;
  private boolean h;
  private boolean i;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public ScannerActivity()
  {
    this.jdField_b_of_type_Long = -1L;
  }
  
  private String a(String paramString)
  {
    alto localalto = (alto)this.app.getManager(51);
    if (localalto == null) {}
    do
    {
      return "";
      paramString = localalto.b(paramString);
      if (paramString == null) {
        return "";
      }
    } while (paramString.strProvince == null);
    return "" + paramString.strProvince;
  }
  
  private JSONObject a()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = getIntent();
    String str = this.jdField_a_of_type_JavaLangString;
    if ((localObject3 == null) && (TextUtils.isEmpty(str))) {
      return localObject1;
    }
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((Intent)localObject3).hasExtra("report_params"))
      {
        localObject3 = ((Intent)localObject3).getStringExtra("report_params");
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject1 = new JSONObject((String)localObject3);
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new JSONObject();
      if (TextUtils.isEmpty(str)) {
        break label270;
      }
      ((JSONObject)localObject2).put("type", 9);
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(((JSONObject)localObject2).optString("md5"))) && (!TextUtils.isEmpty(str)) && (new File(str).exists()))
      {
        long l = System.currentTimeMillis();
        localObject1 = bdhe.a(arrr.d(str));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((JSONObject)localObject2).put("md5", ((String)localObject1).toUpperCase());
        }
        if (QLog.isColorLevel()) {
          QLog.d("ScannerActivity", 2, "buildQRReportParams md5:" + (String)localObject1 + " cost:" + (System.currentTimeMillis() - l));
        }
      }
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ScannerActivity", 2, "buildQRReportParams params:" + ((JSONObject)localObject2).toString());
      return localObject2;
      label270:
      ((JSONObject)localObject2).put("type", 8);
    }
  }
  
  private void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("ScannerActivity", 1, "handleScannerResult scannerResult:" + paramString2 + "  scannerType:" + paramString1 + " resultType:" + paramInt1 + " reqType:" + paramInt2);
    }
    if ((paramInt1 & 0x1) == 1) {
      if (nrc.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        localIntent = new Intent("com.tencent.biz.pubaccount.scanResultAction");
        if (paramString1 != null)
        {
          if (paramString1.equalsIgnoreCase("QR_CODE")) {
            localIntent.putExtra("com.tencent.biz.pubaccount.scanResultType", 2);
          }
        }
        else
        {
          localIntent.putExtra("com.tencent.biz.pubaccount.scanResultData", paramString2);
          sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
          if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_Boolean) {
            break label402;
          }
          getIntent().putExtra("scanResult", paramString2);
          setResult(-1, getIntent());
          finish();
        }
      }
    }
    label328:
    while ((paramInt1 & 0x2) != 2)
    {
      do
      {
        for (;;)
        {
          return;
          localIntent.putExtra("com.tencent.biz.pubaccount.scanResultType", 1);
          continue;
          if (!anif.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString)) {
            break;
          }
          localIntent = new Intent("com.tencent.mobileqq.ark.API.scanResultAction");
          localIntent.putExtra("com.tencent.ark.scanResultData", paramString2);
          localIntent.putExtra("com.tencent.ark.scanResultType", paramString1);
          sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
          finish();
        }
        if ("micro_app".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
        {
          localIntent = new Intent("com.tencent.mobileqq.microapp.out.plugins.scanResultAction");
          if (paramString1 != null)
          {
            if (!paramString1.equalsIgnoreCase("QR_CODE")) {
              break label328;
            }
            localIntent.putExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultType", 2);
          }
          for (;;)
          {
            localIntent.putExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultData", paramString2);
            sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
            finish();
            break;
            localIntent.putExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultType", 1);
          }
        }
      } while (!"mini_app".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString));
      Intent localIntent = new Intent("com.tencent.mobileqq.mini.out.plugins.scanResultAction");
      localIntent.putExtra("com.tencent.mobileqq.mini.out.plugins.scanResultType", paramString1);
      localIntent.putExtra("com.tencent.mobileqq.mini.out.plugins.scanResultData", paramString2);
      sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      finish();
      return;
      yak.a(paramString1, paramString2, this, this.app, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams, this.jdField_a_of_type_Yas);
      return;
    }
    label402:
    auew.a(paramString2, this);
    finish();
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_Yat == null) {
      this.jdField_a_of_type_Yat = new yat(this, this.jdField_a_of_type_Zha);
    }
    int j = paramInt;
    if (paramInt == 0) {
      j = 3;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Yat.a(paramString1, j, paramString2);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams = new ScannerParams();
    Intent localIntent = getIntent();
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("from");
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("subfrom");
    if ("addcontacts".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString)) {
      azri.a(getApplicationContext()).b(this.app, "", "addfriend_QR", 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.e = localIntent.getBooleanExtra("QRDecode", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_Int = localIntent.getIntExtra("detectType", 1);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("preResult");
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.h = "qlink".equalsIgnoreCase(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.g = super.getPackageManager().hasSystemFeature("android.hardware.camera");
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("scanForResult", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("finishAfterSucc", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.i = false;
      this.jdField_a_of_type_AndroidViewView = findViewById(2131376154);
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidViewView, 2);
      if (("Conversation".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString)) || ("web-ar".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))) {
        this.h = true;
      }
      this.i = localIntent.getBooleanExtra("hide_album", false);
      this.jdField_b_of_type_Long = localIntent.getLongExtra("start_time", -1L);
      QLog.i("ScannerActivity", 1, "mScannerParams: " + this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.toString());
      return;
      if ("ImagePreviewActivity".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        azri.a(getApplicationContext()).b(this.app, "", "bigpicture_QR", 1);
      }
      else if ("Conversation".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.f = true;
        azri.a(getApplicationContext()).b(this.app, "", "bulb_QR", 1);
      }
      else if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        azri.a(getApplicationContext()).b(this.app, "", "find_QR", 1);
      }
      else if ("publicAccountNew".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_Boolean = true;
      }
      else if ((!ScanTorchActivity.class.getSimpleName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString)) && ("QRDisplayActivity".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.f = true;
      }
    }
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.e = NearbyFakeActivity.a();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
    }
    if (this.jdField_a_of_type_Yap == null) {
      this.jdField_a_of_type_Yap = new yap(this);
    }
    QLog.d("ScannerActivity", 2, "launchAr time pre: " + (System.currentTimeMillis() - l));
    this.jdField_a_of_type_Yap.a("qr", 5000L, new yah(this, l));
  }
  
  public void b()
  {
    QLog.d("ScannerActivity", 2, String.format("doLaunchAr", new Object[0]));
    if (this.jdField_a_of_type_Yap != null)
    {
      this.jdField_a_of_type_Yap.a();
      this.jdField_a_of_type_Yap = null;
    }
    Object localObject;
    if ((this.app instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)this.app.getManager(13);
      if (localObject != null) {
        ((WebProcessManager)localObject).e();
      }
      localObject = new Intent(this, WebProcessReceiver.class);
      ((Intent)localObject).setAction("action_download_tbs");
      sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    }
    Intent localIntent = new Intent(this, ScanTorchActivity.class);
    localIntent.addFlags(67108864);
    localIntent.addFlags(65536);
    localIntent.putExtra("click_time", this.jdField_a_of_type_Long);
    localIntent.putExtra("launch_time", System.currentTimeMillis());
    localIntent.putExtra("first_click", jdField_a_of_type_Boolean);
    localIntent.putExtra("proc_exist", this.e);
    localIntent.putExtra("software", getSharedPreferences("immerse_ar", 0).getBoolean("software", false));
    jdField_a_of_type_Boolean = false;
    localIntent.putExtra("log_on", ScanTorchActivity.i);
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanAR != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.e)) {
        break label626;
      }
      localIntent.putExtra("icon_text", "QQ-AR");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.jdField_c_of_type_JavaLangString)) {
        localIntent.putExtra("icon_url", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.jdField_c_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.f)) {
        localIntent.putExtra("scan_ar_default_tips", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.f);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.g)) {
        localIntent.putExtra("scan_ar_default_tips2", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.g);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
        localIntent.putExtra("key_ocr_config", this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig);
      }
      localIntent.putExtra("key_ar_config", this.jdField_a_of_type_ComTencentMobileqqArARScanAR);
      localIntent.putExtra("CurrentNickname", bdgc.k(this.app, this.app.getCurrentAccountUin()));
      localIntent.putExtra("CurrentLocInfo", a(this.app.c()));
      localIntent.putExtra("from_qr", true);
      localIntent.putExtra("ar_enabled", this.h);
      localIntent.putExtra("hide_album", this.i);
      localIntent.putExtra("from", this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString);
      if ((TextUtils.equals("web-ar", this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString)) && (getIntent() != null))
      {
        localIntent.putExtra("click_time", getIntent().getLongExtra("click_time", this.jdField_a_of_type_Long));
        localIntent.putExtra("web_url_switch", getIntent().getIntExtra("web_url_switch", 0));
        localIntent.putExtra("jump_from_web", getIntent().getBooleanExtra("jump_from_web", true));
        localIntent.putExtra("icon_text", getIntent().getStringExtra("icon_text"));
        localIntent.putExtra("icon_url", getIntent().getStringExtra("icon_url"));
      }
      localIntent.putExtra("start_time", this.jdField_b_of_type_Long);
      Bundle localBundle = getIntent().getBundleExtra("web_invoke_params");
      localObject = localBundle;
      if (localBundle == null) {
        localObject = new Bundle();
      }
      localIntent.putExtra("web_invoke_params", (Bundle)localObject);
      startActivityForResult(localIntent, 10);
      overridePendingTransition(0, 0);
      this.jdField_b_of_type_Boolean = true;
      return;
      label626:
      localIntent.putExtra("icon_text", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.e);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "showProgress mProgressShowing:" + this.jdField_d_of_type_Boolean);
    }
    if (this.jdField_d_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_Bety == null)
        {
          this.jdField_a_of_type_Bety = new bety(this, getTitleBarHeight());
          this.jdField_a_of_type_Bety.a(alud.a(2131713905));
          this.jdField_a_of_type_Bety.c(false);
        }
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_Bety.show();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("ScannerActivity", 2, "");
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "hideProgress  mProgressShowing:" + this.jdField_d_of_type_Boolean);
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.dismiss();
      }
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScannerActivity", 2, "hide init check progress:" + localException.getMessage());
      }
      localException.printStackTrace();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "doOnActivityResult requestCode:" + paramInt1 + ", resultCode:" + paramInt2);
    }
    d();
    switch (paramInt1)
    {
    default: 
      if (this.jdField_c_of_type_Boolean) {
        finish();
      }
      break;
    }
    do
    {
      return;
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("retdata");
        if (!TextUtils.isEmpty(paramIntent)) {
          QWalletHelper.doQWalletQRCodeRet(this, paramIntent);
        }
      }
      finish();
      return;
      finish();
      return;
      this.f = true;
      switch (paramInt2)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("ScannerActivity", 2, "doOnActivityResult default finish.");
        }
        finish();
        return;
      case 11: 
        finish();
        return;
      case 12: 
        finish();
        overridePendingTransition(0, 0);
        return;
      case 13: 
        paramInt1 = paramIntent.getIntExtra("detectType", 1);
        String str1 = paramIntent.getStringExtra("scannerResult");
        String str2 = paramIntent.getStringExtra("scannerType");
        this.jdField_a_of_type_JavaLangString = null;
        if (paramIntent.hasExtra("filePath")) {
          this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("filePath");
        }
        if (paramInt1 == 2)
        {
          finish();
          return;
        }
        a(paramInt1, str2, str1, 3);
        return;
      }
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel()) {
        QLog.d("ScannerActivity", 2, "doOnActivityResult RESULT_QR_PHOTO_PATH path: " + paramIntent);
      }
      if (TextUtils.isEmpty(paramIntent)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = paramIntent;
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_Boolean = true;
    } while (!isResume());
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    a(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = null;
    return;
    finish();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onCreate");
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2131560240);
    e();
    this.f = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("hansSavedState", false);
      j = bool;
      if (QLog.isColorLevel())
      {
        QLog.d("ScannerActivity", 2, "hansSavedState : " + bool);
        j = bool;
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString)) && (j == 0)) {
        a();
      }
      paramBundle = (yau)this.app.getManager(243);
      if (paramBundle != null) {
        paramBundle.a(getApplicationContext(), this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams);
      }
      yak.a(this.app);
      return true;
      if (getIntent().getBooleanExtra("from_+", false)) {
        azqs.b(null, "dc00898", "", "", "0X80085A9", "0X80085A9", 0, 0, "", "", "", "");
      } else {
        azqs.b(null, "dc00898", "", "", "0X80085AA", "0X80085AA", 0, 0, "", "", this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString, "");
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onDestroy mHasARBack:" + this.f + "  mHasStartedAR:" + this.jdField_b_of_type_Boolean);
    }
    if ((!this.jdField_b_of_type_Boolean) || (this.f))
    {
      if (anif.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        localObject = new Intent("com.tencent.mobileqq.ark.API.scanResultAction");
        ((Intent)localObject).putExtra("com.tencent.ark.scanResultData", "");
        ((Intent)localObject).putExtra("com.tencent.ark.scanResultType", "");
        sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      }
      Object localObject = (yau)this.app.getManager(243);
      if (localObject != null) {
        ((yau)localObject).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScannerActivity", 2, "doOnDestroy in onScannerDestroy");
      }
    }
    if (this.jdField_a_of_type_Yat != null)
    {
      this.jdField_a_of_type_Yat.a();
      this.jdField_a_of_type_Yat = null;
    }
    if (this.jdField_a_of_type_Yap != null)
    {
      this.jdField_a_of_type_Yap.a();
      this.jdField_a_of_type_Yap = null;
    }
    if (this.jdField_a_of_type_Bety != null)
    {
      this.jdField_a_of_type_Bety.dismiss();
      this.jdField_a_of_type_Bety = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    super.doOnDestroy();
    yak.a(this);
    this.app = null;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "doOnNewIntent");
    }
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onPause");
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onResume");
    }
    super.doOnResume();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = null;
    }
    if ((QLog.isColorLevel()) && (this.g) && (this.jdField_b_of_type_Long > 0L))
    {
      QLog.d("ScannerActivity", 2, new Object[] { Long.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long) });
      this.g = false;
    }
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "doOnSaveInstanceState");
    }
    paramBundle.putBoolean("hansSavedState", true);
    super.doOnSaveInstanceState(paramBundle);
  }
  
  public void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "doOnStop");
    }
    super.doOnStop();
    d();
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "finish");
    }
    super.finish();
  }
  
  public void startActivity(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "startActivity  mHasGetResult:" + this.jdField_c_of_type_Boolean);
    }
    super.startActivity(paramIntent);
    if (this.jdField_c_of_type_Boolean) {
      finish();
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "startActivityForResult requestCode:" + paramInt);
    }
    super.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity
 * JD-Core Version:    0.7.0.1
 */