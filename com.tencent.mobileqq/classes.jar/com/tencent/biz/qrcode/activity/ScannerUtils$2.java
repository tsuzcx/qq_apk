package com.tencent.biz.qrcode.activity;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.QRActionEntity;
import com.tencent.biz.qrcode.QRResultHandler;
import com.tencent.biz.qrcode.ipc.QrHandleResultCallBack;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

final class ScannerUtils$2
  implements BusinessObserver
{
  ScannerUtils$2(AppActivity paramAppActivity, String paramString, QQAppInterface paramQQAppInterface, ScannerParams paramScannerParams, View paramView, QrHandleResultCallBack paramQrHandleResultCallBack) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_MqqAppAppActivity.isResume()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Uri localUri = Uri.parse((String)localObject1);
    Object localObject2;
    label32:
    int k;
    Object localObject3;
    QRActionEntity localQRActionEntity;
    label211:
    int i;
    label240:
    Bundle localBundle;
    label305:
    int j;
    if (localUri == null)
    {
      localObject2 = null;
      if (QLog.isColorLevel()) {
        QLog.i("ScannerUtils", 2, String.format("JumpUrl requestUrlDecode authSig=%s url=%s", new Object[] { localObject2, localObject1 }));
      }
      k = 0;
      if ((!paramBoolean) || (paramBundle == null)) {
        break label981;
      }
      paramBundle = paramBundle.getString("result");
      paramInt = k;
      try
      {
        localObject3 = new JSONObject(paramBundle);
        paramInt = k;
        if (((JSONObject)localObject3).isNull("r")) {
          break label978;
        }
        paramInt = k;
        if (((JSONObject)localObject3).optInt("r") != 0) {
          break label978;
        }
        paramInt = k;
        if (!((JSONObject)localObject3).has("d")) {
          break label683;
        }
        paramInt = k;
        if (((JSONObject)localObject3).isNull("d")) {
          break label683;
        }
        paramInt = k;
        localQRActionEntity = new QRActionEntity(((JSONObject)localObject3).optString("d"));
        paramInt = k;
        if (!((JSONObject)localObject3).has("wpa")) {
          break label652;
        }
        paramInt = k;
        if (((JSONObject)localObject3).isNull("wpa")) {
          break label652;
        }
        paramInt = k;
        if (!"1".equals(((JSONObject)localObject3).optString("wpa"))) {
          break label652;
        }
        paramBoolean = true;
        paramInt = k;
        if (!((JSONObject)localObject3).has("extvalue")) {
          break label657;
        }
        paramInt = k;
        if (((JSONObject)localObject3).isNull("extvalue")) {
          break label657;
        }
        i = 1;
        paramInt = k;
        if (!((JSONObject)localObject3).has("exttype")) {
          break label663;
        }
        paramInt = k;
        if (((JSONObject)localObject3).isNull("exttype")) {
          break label663;
        }
        paramInt = k;
        if ("2".equals(((JSONObject)localObject3).optString("exttype"))) {
          break label986;
        }
        paramInt = k;
        if (!"1".equals(((JSONObject)localObject3).optString("exttype"))) {
          break label663;
        }
      }
      catch (Exception paramBundle) {}
      paramInt = k;
      localBundle = new Bundle();
      if (paramBoolean)
      {
        paramInt = k;
        localBundle.putBoolean("issupportwpa", paramBoolean);
      }
      if ((j != 0) && (i != 0))
      {
        paramInt = k;
        paramBundle = ((JSONObject)localObject3).optString("exttype");
        paramInt = k;
        localObject3 = ((JSONObject)localObject3).optString("extvalue");
        paramInt = k;
        localBundle.putString("exttype", paramBundle);
        paramInt = k;
        localBundle.putString("extvalue", (String)localObject3);
      }
      paramInt = k;
      localBundle.putString("authSig", (String)localObject2);
      if (localUri != null) {
        break label669;
      }
    }
    for (paramBundle = null;; paramBundle = localUri.getQueryParameter("jump_from"))
    {
      if (paramBundle != null)
      {
        paramInt = k;
        if ("webapi".equalsIgnoreCase(paramBundle))
        {
          paramInt = k;
          localBundle.putString("sourceId", "3_40002");
        }
      }
      paramInt = k;
      i = QRResultHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, localQRActionEntity, this.jdField_a_of_type_JavaLangString, localBundle);
      paramInt = i;
      if (this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.b)
      {
        paramInt = i;
        this.jdField_a_of_type_MqqAppAppActivity.finish();
      }
      paramInt = i;
      ScannerUtils.a(i, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramInt = i;
      if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.e) {
        break;
      }
      paramInt = i;
      this.jdField_a_of_type_MqqAppAppActivity.finish();
      return;
      label527:
      QLog.e("ScannerUtils", 1, "handle url error: " + paramBundle.getMessage());
      label555:
      paramBundle = DialogUtil.a(this.jdField_a_of_type_MqqAppAppActivity, 230);
      paramBundle.setTitle(2131717048);
      paramBundle.setMessage((CharSequence)localObject1);
      localObject2 = new ScannerUtils.2.1(this);
      paramBundle.setPositiveButton(2131694615, new ScannerUtils.2.2(this, (String)localObject1));
      paramBundle.setNegativeButton(2131690800, (DialogInterface.OnClickListener)localObject2);
      paramBundle.setOnCancelListener((DialogInterface.OnCancelListener)localObject2);
      paramBundle.show();
      ScannerUtils.a(paramInt, (String)localObject1, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      localObject2 = localUri.getQueryParameter("authKey");
      break label32;
      label652:
      paramBoolean = false;
      break label211;
      label657:
      i = 0;
      break label240;
      label663:
      j = 0;
      break label305;
      label669:
      paramInt = k;
    }
    label683:
    paramInt = k;
    if (((JSONObject)localObject3).has("a_a"))
    {
      paramInt = k;
      if (!((JSONObject)localObject3).isNull("a_a"))
      {
        paramInt = k;
        paramBundle = ((JSONObject)localObject3).optString("a_a");
        paramInt = k;
        paramBundle = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppActivity, paramBundle);
        if (paramBundle == null) {
          break label992;
        }
        paramInt = k;
        paramBundle.a();
        return;
      }
    }
    paramInt = k;
    if (((JSONObject)localObject3).has("url"))
    {
      paramInt = k;
      if (!((JSONObject)localObject3).isNull("url"))
      {
        paramInt = k;
        i = ((JSONObject)localObject3).optInt("url_level");
        paramInt = k;
        paramBundle = ((JSONObject)localObject3).optString("url");
        paramInt = k;
        if (TextUtils.isEmpty(paramBundle)) {
          break label1016;
        }
        if (i != 2) {
          break label1010;
        }
        paramInt = k;
        paramBundle = Uri.parse(paramBundle).toString();
        paramInt = i;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (paramInt != 1)
        {
          localObject1 = paramBundle;
          if (paramInt != 2) {
            break label992;
          }
        }
        try
        {
          localObject1 = new ActivityURIRequest(this.jdField_a_of_type_MqqAppAppActivity, "/pubaccount/browser");
          ((ActivityURIRequest)localObject1).extra().putBoolean("key_isReadModeEnabled", true);
          ((ActivityURIRequest)localObject1).extra().putBoolean("fromQrcode", true);
          ((ActivityURIRequest)localObject1).extra().putString("url", paramBundle);
          ((ActivityURIRequest)localObject1).extra().putString("big_brother_source_key", "biz_src_jc_sacan_qr");
          if (this.jdField_a_of_type_MqqAppAppActivity.getIntent().getBooleanExtra("QRDecode", false))
          {
            QRoute.startUri((URIRequest)localObject1, null);
            this.jdField_a_of_type_MqqAppAppActivity.finish();
          }
          for (;;)
          {
            ScannerUtils.a(0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqAppAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if (!this.jdField_a_of_type_ComTencentBizQrcodeIpcScannerParams.b) {
              break;
            }
            this.jdField_a_of_type_MqqAppAppActivity.finish();
            return;
            QRoute.startUri((URIRequest)localObject1, null);
          }
          label978:
          break label992;
          label981:
          paramInt = 0;
          break label555;
          label986:
          j = 1;
          break label305;
          label992:
          paramInt = 0;
        }
        catch (Exception localException)
        {
          paramInt = 0;
          localObject1 = paramBundle;
          paramBundle = localException;
        }
      }
      break label527;
      label1010:
      paramInt = i;
      continue;
      label1016:
      paramBundle = (Bundle)localObject1;
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerUtils.2
 * JD-Core Version:    0.7.0.1
 */