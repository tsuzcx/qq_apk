package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.qrcode.ipc.PreCallUpToolProc;
import com.tencent.biz.qrcode.ipc.QrHandleResultCallBack;
import com.tencent.biz.qrcode.ipc.QrImageScan;
import com.tencent.biz.qrcode.ipc.QrMainProcManager;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.biz.widgets.ScannerView.FileDecodeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.ark.API.ArkAppDeviceModule;
import com.tencent.mobileqq.binhai.BinHaiHandler;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import oss;
import osu;
import osv;
import osw;

public class ScannerActivity
  extends BaseActivity
{
  public static boolean a;
  private long jdField_a_of_type_Long;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new osw(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private PreCallUpToolProc jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc;
  private QrHandleResultCallBack jdField_a_of_type_ComTencentBizQrcodeIpcQrHandleResultCallBack = new osu(this);
  private QrImageScan jdField_a_of_type_ComTencentBizQrcodeIpcQrImageScan;
  public ScannerParams a;
  private ScannerView.FileDecodeListener jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener = new oss(this);
  public ARScanAR a;
  public OcrConfig a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private long b;
  public boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g = true;
  private boolean h;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public ScannerActivity()
  {
    this.jdField_b_of_type_Long = -1L;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcQrImageScan == null) {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcQrImageScan = new QrImageScan(this, this.jdField_a_of_type_ComTencentBizWidgetsScannerView$FileDecodeListener);
    }
    this.jdField_a_of_type_ComTencentBizQrcodeIpcQrImageScan.a(paramString);
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_c_of_type_Boolean = true;
    QLog.e("ScannerActivity", 1, "handleScannerResult scannerResult:" + paramString2 + "  scannerType" + paramString1);
    Intent localIntent;
    if (PublicAccountManager.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
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
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_Boolean) {
        break label207;
      }
      getIntent().putExtra("scanResult", paramString2);
      setResult(-1, getIntent());
      finish();
      return;
      localIntent.putExtra("com.tencent.biz.pubaccount.scanResultType", 1);
      break;
      if (ArkAppDeviceModule.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        localIntent = new Intent("com.tencent.mobileqq.ark.API.scanResultAction");
        localIntent.putExtra("com.tencent.ark.scanResultData", paramString2);
        localIntent.putExtra("com.tencent.ark.scanResultType", paramString1);
        sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
        finish();
      }
    }
    label207:
    ScannerUtils.a(paramString1, paramString2, this, this.app, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams, this.jdField_a_of_type_ComTencentBizQrcodeIpcQrHandleResultCallBack);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams = new ScannerParams();
    Intent localIntent = getIntent();
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("from");
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("subfrom");
    if ("addcontacts".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString)) {
      StatisticCollector.a(getApplicationContext()).b(this.app, "", "addfriend_QR", 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.e = localIntent.getBooleanExtra("QRDecode", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.h = "qlink".equalsIgnoreCase(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.g = super.getPackageManager().hasSystemFeature("android.hardware.camera");
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.d = true;
      }
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("scanForResult", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("finishAfterSucc", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.i = false;
      this.jdField_a_of_type_AndroidViewView = findViewById(2131367509);
      ViewCompat.setImportantForAccessibility(this.jdField_a_of_type_AndroidViewView, 2);
      if (("Conversation".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString)) || ("web-ar".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))) {
        this.h = true;
      }
      this.jdField_b_of_type_Long = localIntent.getLongExtra("start_time", -1L);
      QLog.i("ScannerActivity", 1, "mScannerParams: " + this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.toString());
      return;
      if ("ImagePreviewActivity".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "bigpicture_QR", 1);
      }
      else if ("Conversation".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.f = true;
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "bulb_QR", 1);
      }
      else if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        StatisticCollector.a(getApplicationContext()).b(this.app, "", "find_QR", 1);
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
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc == null) {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc = new PreCallUpToolProc(this);
    }
    QLog.d("ScannerActivity", 2, "launchAr time pre: " + (System.currentTimeMillis() - l));
    this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc.a("qr", 5000L, new osv(this, l));
  }
  
  public void b()
  {
    QLog.d("ScannerActivity", 2, String.format("doLaunchAr", new Object[0]));
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc != null)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc.a();
      this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc = null;
    }
    Object localObject;
    if ((this.app instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)this.app.getManager(12);
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
        break label629;
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
      localIntent.putExtra("CurrentNickname", this.app.getCurrentNickname());
      localIntent.putExtra("from_qr", true);
      localIntent.putExtra("ar_enabled", this.h);
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
      if (BinHaiHandler.jdField_a_of_type_Boolean)
      {
        localIntent.putExtra("binhai_debug", true);
        localIntent.putExtra("binhai_debug_dalian", BinHaiHandler.jdField_b_of_type_Boolean);
      }
      Bundle localBundle = getIntent().getBundleExtra("ARRelationShipPromotion");
      localObject = localBundle;
      if (localBundle == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putBoolean("hasPromotion", false);
        ((Bundle)localObject).putBoolean("IsFromH5", false);
      }
      localIntent.putExtra("ARRelationShipPromotion", (Bundle)localObject);
      startActivityForResult(localIntent, 10);
      overridePendingTransition(0, 0);
      this.jdField_b_of_type_Boolean = true;
      return;
      label629:
      localIntent.putExtra("icon_text", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.e);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "showProgress mProgressShowing:" + this.d);
    }
    if (this.d) {}
    do
    {
      return;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载...");
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        }
        this.d = true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.d("ScannerActivity", 2, "");
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "hideProgress  mProgressShowing:" + this.d);
    }
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.d = false;
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        String str = paramIntent.getStringExtra("scannerResult");
        a(paramIntent.getStringExtra("scannerType"), str);
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
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.d = true;
    } while (!isResume());
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    a(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = null;
    return;
    finish();
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onCreate");
    }
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentView(2130969698);
    e();
    this.f = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandler$Callback);
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("hansSavedState", false);
      i = bool;
      if (QLog.isColorLevel())
      {
        QLog.d("ScannerActivity", 2, "hansSavedState : " + bool);
        i = bool;
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString)) && (i == 0)) {
        a();
      }
      ((QrMainProcManager)this.app.getManager(242)).a(getApplicationContext(), this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams);
      return true;
      if (getIntent().getBooleanExtra("from_+", false)) {
        ReportController.b(null, "dc00898", "", "", "0X80085A9", "0X80085A9", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "dc00898", "", "", "0X80085AA", "0X80085AA", 0, 0, "", "", this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString, "");
      }
    }
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onDestroy mHasARBack:" + this.f + "  mHasStartedAR:" + this.jdField_b_of_type_Boolean);
    }
    if ((!this.jdField_b_of_type_Boolean) || (this.f))
    {
      if (ArkAppDeviceModule.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        Intent localIntent = new Intent("com.tencent.mobileqq.ark.API.scanResultAction");
        localIntent.putExtra("com.tencent.ark.scanResultData", "");
        localIntent.putExtra("com.tencent.ark.scanResultType", "");
        sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      }
      ((QrMainProcManager)this.app.getManager(242)).a();
      if (QLog.isColorLevel()) {
        QLog.d("ScannerActivity", 2, "doOnDestroy in onScannerDestroy");
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcQrImageScan != null)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcQrImageScan.a();
      this.jdField_a_of_type_ComTencentBizQrcodeIpcQrImageScan = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc != null)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc.a();
      this.jdField_a_of_type_ComTencentBizQrcodeIpcPreCallUpToolProc = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    super.doOnDestroy();
    ScannerUtils.a(this);
    this.app = null;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "doOnNewIntent");
    }
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.d = true;
    }
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onPause");
    }
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "onResume");
    }
    super.doOnResume();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = null;
    }
    if ((QLog.isColorLevel()) && (this.g) && (this.jdField_b_of_type_Long > 0L))
    {
      QLog.d("ScannerActivity", 2, new Object[] { Long.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long) });
      this.g = false;
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "doOnSaveInstanceState");
    }
    paramBundle.putBoolean("hansSavedState", true);
    super.doOnSaveInstanceState(paramBundle);
  }
  
  protected void doOnStop()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity
 * JD-Core Version:    0.7.0.1
 */