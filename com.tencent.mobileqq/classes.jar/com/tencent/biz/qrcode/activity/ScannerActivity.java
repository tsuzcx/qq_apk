package com.tencent.biz.qrcode.activity;

import Override;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import anvx;
import apqy;
import auea;
import bdla;
import bhcl;
import bisl;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ar.ARScanAR;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.mobileqq.nearby.NearbyFakeActivity;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import okn;
import org.json.JSONObject;
import zma;
import zmc;
import zmd;
import zme;
import zmf;
import zmh;
import zmi;
import zmk;
import zmp;
import zms;
import zmt;
import zmu;
import zmv;

public class ScannerActivity
  extends BaseActivity
{
  public static boolean a;
  private long jdField_a_of_type_Long;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new zme(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private bisl jdField_a_of_type_Bisl;
  private ScannerMultiResultSelectView jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView;
  public ScannerParams a;
  public ARScanAR a;
  public OcrConfig a;
  private String jdField_a_of_type_JavaLangString;
  private zmi jdField_a_of_type_Zmi = new zmf(this);
  private zmp jdField_a_of_type_Zmp;
  private zms jdField_a_of_type_Zms = new zmc(this);
  private zmt jdField_a_of_type_Zmt;
  private zmu jdField_a_of_type_Zmu = new zma(this);
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
        localObject1 = HexUtil.bytes2HexStr(auea.e(str));
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
      if (okn.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
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
            break label397;
          }
          getIntent().putExtra("scanResult", paramString2);
          setResult(-1, getIntent());
          finish();
        }
      }
    }
    label323:
    while ((paramInt1 & 0x2) != 2)
    {
      do
      {
        for (;;)
        {
          return;
          localIntent.putExtra("com.tencent.biz.pubaccount.scanResultType", 1);
          continue;
          if (!apqy.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString)) {
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
              break label323;
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
      zmk.a(paramString1, paramString2, this, this.app, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams, this.jdField_a_of_type_Zms);
      return;
    }
    label397:
    RecogUtil.jumpMiniCode(paramString2, this);
    finish();
  }
  
  private void a(ScannerResult paramScannerResult, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "handleScannerResult requestType:" + paramInt + " scannerResult:" + paramScannerResult);
    }
    if (paramScannerResult == null) {}
    do
    {
      do
      {
        return;
        if (paramScannerResult.a())
        {
          b(paramScannerResult, paramInt);
          return;
        }
        if (!paramScannerResult.d()) {
          break;
        }
        paramScannerResult = paramScannerResult.a();
      } while (paramScannerResult == null);
      a(1, ((StringBuilder)paramScannerResult.second).toString(), ((StringBuilder)paramScannerResult.first).toString(), paramInt);
      return;
    } while (!paramScannerResult.c());
    a(2, "", paramScannerResult.a(), paramInt);
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Zmt == null) {
      this.jdField_a_of_type_Zmt = new zmt(this, this.jdField_a_of_type_Zmu);
    }
    int j = paramInt;
    if (paramInt == 0) {
      j = 3;
    }
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Zmt.a(paramString, j);
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "handlePreResult detectType:" + this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_Int + " preResult:" + this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_JavaLangString + " preScanResult:" + this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult);
    }
    if ((this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult != null) && (this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.b()))
    {
      a(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_Int);
      return true;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_JavaLangString)) {
      try
      {
        JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_JavaLangString);
        m = this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_Int;
        if ((zmk.a(m)) && (localJSONObject != null))
        {
          j = 1;
          if ((!zmk.b(m)) || (localJSONObject == null)) {
            break label224;
          }
          k = 1;
          if (j == 0) {
            break label229;
          }
          a(1, localJSONObject.optString("scannerType"), localJSONObject.optString("scannerResult"), m);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        int m;
        int k;
        Object localObject;
        for (;;)
        {
          localThrowable.printStackTrace();
          localObject = null;
          continue;
          int j = 0;
          continue;
          label224:
          k = 0;
        }
        label229:
        if (k != 0)
        {
          a(2, "", localObject.optString("strMini"), m);
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(ScannerResult paramScannerResult, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView == null)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView = new ScannerMultiResultSelectView(this);
      this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView.setMultiSelectListener(this.jdField_a_of_type_Zmi);
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131377074);
    zmh localzmh = new zmh();
    localzmh.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView.a(localRelativeLayout, paramScannerResult, paramInt, localzmh, 2);
    if ((!this.app.isRingerVibrate()) && (!this.app.isRingerSilent()) && (!this.app.isRingEqualsZero())) {
      bhcl.b(2131230757, false);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams = new ScannerParams();
    Intent localIntent = getIntent();
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("from");
    this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("subfrom");
    if ("addcontacts".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString)) {
      StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "addfriend_QR", 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("QRDecode", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_Int = localIntent.getIntExtra("detectType", 3);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("preResult");
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult = ((ScannerResult)localIntent.getParcelableExtra("preScanResult"));
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.h = "qlink".equalsIgnoreCase(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.g = super.getPackageManager().hasSystemFeature("android.hardware.camera");
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_Boolean = true;
      }
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("scanForResult", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("finishAfterSucc", false);
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.i = false;
      this.jdField_a_of_type_AndroidViewView = findViewById(2131377073);
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
        StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "bigpicture_QR", 1);
      }
      else if ("Conversation".equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.f = true;
        StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "bulb_QR", 1);
      }
      else if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        StatisticCollector.getInstance(getApplicationContext()).reportButtonClick(this.app, "", "find_QR", 1);
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
    this.jdField_e_of_type_Boolean = NearbyFakeActivity.a();
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
    }
    if (this.jdField_a_of_type_Zmp == null) {
      this.jdField_a_of_type_Zmp = new zmp(this);
    }
    QLog.d("ScannerActivity", 2, "launchAr time pre: " + (System.currentTimeMillis() - l));
    this.jdField_a_of_type_Zmp.a("qr", 5000L, new zmd(this, l));
  }
  
  public void b()
  {
    QLog.d("ScannerActivity", 2, String.format("doLaunchAr", new Object[0]));
    if (this.jdField_a_of_type_Zmp != null)
    {
      this.jdField_a_of_type_Zmp.a();
      this.jdField_a_of_type_Zmp = null;
    }
    Object localObject;
    if ((this.app instanceof QQAppInterface))
    {
      localObject = (WebProcessManager)this.app.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
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
    localIntent.putExtra("proc_exist", this.jdField_e_of_type_Boolean);
    localIntent.putExtra("software", getSharedPreferences("immerse_ar", 0).getBoolean("software", false));
    jdField_a_of_type_Boolean = false;
    localIntent.putExtra("log_on", ScanTorchActivity.h);
    if (this.jdField_a_of_type_ComTencentMobileqqArARScanAR != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArARScanAR.jdField_e_of_type_JavaLangString)) {
        break label608;
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
      localIntent.putExtra("CurrentNickname", ContactUtils.getFriendDisplayNameJustCache(this.app, this.app.getCurrentAccountUin()));
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
      label608:
      localIntent.putExtra("icon_text", this.jdField_a_of_type_ComTencentMobileqqArARScanAR.jdField_e_of_type_JavaLangString);
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
        if (this.jdField_a_of_type_Bisl == null)
        {
          this.jdField_a_of_type_Bisl = new bisl(this, getTitleBarHeight());
          this.jdField_a_of_type_Bisl.a(anvx.a(2131712972));
          this.jdField_a_of_type_Bisl.c(false);
        }
        this.jdField_d_of_type_Boolean = true;
        this.jdField_a_of_type_Bisl.show();
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
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.dismiss();
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
        this.jdField_a_of_type_JavaLangString = null;
        if (paramIntent.hasExtra("filePath")) {
          this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("filePath");
        }
        this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
        paramInt1 = paramIntent.getIntExtra("detectType", 1);
        String str = paramIntent.getStringExtra("scannerResult");
        paramIntent = paramIntent.getStringExtra("scannerType");
        if (QLog.isColorLevel()) {
          QLog.d("ScannerActivity", 2, "doOnActivityResult  scannerResult:" + str + " scannerType：" + paramIntent + " photoPathForMd5:" + this.jdField_a_of_type_JavaLangString);
        }
        if (paramInt1 == 2)
        {
          finish();
          return;
        }
        a(paramInt1, paramIntent, str, 3);
        return;
      }
      paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (QLog.isColorLevel()) {
        QLog.d("ScannerActivity", 2, "doOnActivityResult RESULT_QR_PHOTO_PATH path: " + paramIntent);
      }
      if (TextUtils.isEmpty(paramIntent)) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_e_of_type_JavaLangString = paramIntent;
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString = paramIntent;
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_d_of_type_Boolean = true;
    } while (!isResume());
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    a(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString, 3);
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
    super.setContentView(2131560468);
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
      paramBundle = (zmv)this.app.getManager(QQManagerFactory.QR_MAIN_PROC_MANAGER);
      if (paramBundle != null) {
        paramBundle.a(getApplicationContext(), this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams);
      }
      zmk.a(this.app);
      return true;
      if (getIntent().getBooleanExtra("from_+", false)) {
        bdla.b(null, "dc00898", "", "", "0X80085A9", "0X80085A9", 0, 0, "", "", "", "");
      } else {
        bdla.b(null, "dc00898", "", "", "0X80085AA", "0X80085AA", 0, 0, "", "", this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString, "");
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
      if (apqy.class.getName().equals(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_JavaLangString))
      {
        localObject = new Intent("com.tencent.mobileqq.ark.API.scanResultAction");
        ((Intent)localObject).putExtra("com.tencent.ark.scanResultData", "");
        ((Intent)localObject).putExtra("com.tencent.ark.scanResultType", "");
        sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      }
      Object localObject = (zmv)this.app.getManager(QQManagerFactory.QR_MAIN_PROC_MANAGER);
      if (localObject != null) {
        ((zmv)localObject).a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScannerActivity", 2, "doOnDestroy in onScannerDestroy");
      }
    }
    if (this.jdField_a_of_type_Zmt != null)
    {
      this.jdField_a_of_type_Zmt.a();
      this.jdField_a_of_type_Zmt = null;
    }
    if (this.jdField_a_of_type_Zmp != null)
    {
      this.jdField_a_of_type_Zmp.a();
      this.jdField_a_of_type_Zmp = null;
    }
    if (this.jdField_a_of_type_Bisl != null)
    {
      this.jdField_a_of_type_Bisl.dismiss();
      this.jdField_a_of_type_Bisl = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    super.doOnDestroy();
    zmk.a(this);
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
      this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!a()) {
        a(this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.jdField_a_of_type_Int);
      }
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity
 * JD-Core Version:    0.7.0.1
 */