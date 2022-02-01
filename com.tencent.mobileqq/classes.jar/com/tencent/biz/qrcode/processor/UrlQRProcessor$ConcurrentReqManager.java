package com.tencent.biz.qrcode.processor;

import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.QRActionEntity;
import com.tencent.mobileqq.qrscan.QRCodeBusinessObserver;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppActivity;
import org.json.JSONObject;

class UrlQRProcessor$ConcurrentReqManager
{
  private UrlQRProcessor.ConcurrentReqManager.MiniAppReqResult jdField_a_of_type_ComTencentBizQrcodeProcessorUrlQRProcessor$ConcurrentReqManager$MiniAppReqResult = null;
  private UrlQRProcessor.ConcurrentReqManager.UrlDecodeReqResult jdField_a_of_type_ComTencentBizQrcodeProcessorUrlQRProcessor$ConcurrentReqManager$UrlDecodeReqResult = null;
  private final MiniAppCmdInterface jdField_a_of_type_ComTencentMobileqqMiniReuseMiniAppCmdInterface = new UrlQRProcessor.ConcurrentReqManager.2(this);
  private final QRCodeBusinessObserver jdField_a_of_type_ComTencentMobileqqQrscanQRCodeBusinessObserver = new UrlQRProcessor.ConcurrentReqManager.1(this);
  private final ScannerParams jdField_a_of_type_ComTencentMobileqqQrscanScannerParams;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private final WeakReference<OnQRHandleResultCallback> b;
  
  public UrlQRProcessor$ConcurrentReqManager(QQAppInterface paramQQAppInterface, ScannerParams paramScannerParams, String paramString, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramOnQRHandleResultCallback);
    this.jdField_a_of_type_ComTencentMobileqqQrscanScannerParams = paramScannerParams;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private int a()
  {
    ScannerParams localScannerParams = this.jdField_a_of_type_ComTencentMobileqqQrscanScannerParams;
    if ((localScannerParams != null) && (localScannerParams.b)) {
      return 1012;
    }
    return 1011;
  }
  
  @Nullable
  private INTERFACE.StApiAppInfo a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentBizQrcodeProcessorUrlQRProcessor$ConcurrentReqManager$MiniAppReqResult.jdField_a_of_type_OrgJsonJSONObject;
    boolean bool = this.jdField_a_of_type_ComTencentBizQrcodeProcessorUrlQRProcessor$ConcurrentReqManager$MiniAppReqResult.jdField_a_of_type_Boolean;
    long l = ((JSONObject)localObject2).optLong("retCode");
    Object localObject1 = ((JSONObject)localObject2).optString("errMsg");
    if ((bool) && (l == 0L))
    {
      localObject1 = (byte[])((JSONObject)localObject2).opt("appInfo_pb");
      if (localObject1 != null)
      {
        if (localObject1.length == 0) {
          return null;
        }
        localObject2 = new INTERFACE.StApiAppInfo();
        try
        {
          ((INTERFACE.StApiAppInfo)localObject2).mergeFrom((byte[])localObject1);
          bool = TextUtils.isEmpty(((INTERFACE.StApiAppInfo)localObject2).appId.get());
          if (!bool) {
            return localObject2;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          QLog.e("IQRScanConst_BaseQRScanResultProcessor", 2, "handleMiniAppReqResult: pb error", localInvalidProtocolBufferMicroException);
        }
      }
      return null;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getMiniAppInfo, retCode=");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(",errMsg = ");
    ((StringBuilder)localObject2).append(localInvalidProtocolBufferMicroException);
    QLog.e("IQRScanConst_BaseQRScanResultProcessor", 2, ((StringBuilder)localObject2).toString());
    return null;
  }
  
  private void a()
  {
    OnQRHandleResultCallback localOnQRHandleResultCallback = (OnQRHandleResultCallback)this.b.get();
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localOnQRHandleResultCallback != null) && (localQQAppInterface != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQrscanScannerParams == null) {
        return;
      }
      AppActivity localAppActivity = (AppActivity)localOnQRHandleResultCallback.a();
      if (((Build.VERSION.SDK_INT >= 17) && (localAppActivity.isDestroyed())) || (localAppActivity.isFinishing())) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQrcodeProcessorUrlQRProcessor$ConcurrentReqManager$UrlDecodeReqResult != null)
      {
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQrcodeProcessorUrlQRProcessor$ConcurrentReqManager$MiniAppReqResult == null)) {
          return;
        }
        if ((this.jdField_a_of_type_Boolean) && (a(localAppActivity, localOnQRHandleResultCallback))) {
          return;
        }
        a(localQQAppInterface, localAppActivity, localOnQRHandleResultCallback);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Activity paramActivity, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Uri localUri = Uri.parse((String)localObject1);
    String str1;
    if (localUri == null) {
      str1 = null;
    } else {
      str1 = localUri.getQueryParameter("authKey");
    }
    if (QLog.isColorLevel()) {
      QLog.i("IQRScanConst_BaseQRScanResultProcessor", 2, String.format("JumpUrl requestUrlDecode authSig=%s url=%s", new Object[] { str1, localObject1 }));
    }
    boolean bool1 = this.jdField_a_of_type_ComTencentBizQrcodeProcessorUrlQRProcessor$ConcurrentReqManager$UrlDecodeReqResult.jdField_a_of_type_Boolean;
    Object localObject4 = this.jdField_a_of_type_ComTencentBizQrcodeProcessorUrlQRProcessor$ConcurrentReqManager$UrlDecodeReqResult.jdField_a_of_type_AndroidOsBundle;
    String str3;
    if ((bool1) && (localObject4 != null)) {
      str3 = ((Bundle)localObject4).getString("result");
    }
    for (;;)
    {
      try
      {
        localObject6 = new JSONObject(str3);
        if ((!((JSONObject)localObject6).isNull("r")) && (((JSONObject)localObject6).optInt("r") == 0))
        {
          bool1 = ((JSONObject)localObject6).has("d");
          if (bool1)
          {
            QRActionEntity localQRActionEntity;
            String str4;
            String str2;
            try
            {
              if (!((JSONObject)localObject6).isNull("d"))
              {
                localQRActionEntity = new QRActionEntity(((JSONObject)localObject6).optString("d"));
                bool1 = ((JSONObject)localObject6).has("wpa");
                if (bool1)
                {
                  localObject4 = localObject1;
                  try
                  {
                    if (!((JSONObject)localObject6).isNull("wpa"))
                    {
                      localObject4 = localObject1;
                      bool1 = "1".equals(((JSONObject)localObject6).optString("wpa"));
                      if (bool1) {
                        bool1 = true;
                      }
                    }
                  }
                  catch (Exception localException1)
                  {
                    localObject1 = localObject4;
                    continue;
                  }
                }
                bool1 = false;
                boolean bool2 = ((JSONObject)localObject6).has("extvalue");
                if (bool2)
                {
                  localObject4 = localObject1;
                  bool2 = ((JSONObject)localObject6).isNull("extvalue");
                  if (!bool2)
                  {
                    i = 1;
                    continue;
                  }
                }
                i = 0;
                if ((!((JSONObject)localObject6).has("exttype")) || (((JSONObject)localObject6).isNull("exttype"))) {
                  break label952;
                }
              }
            }
            catch (Exception localException3) {}
          }
          try
          {
            if ("2".equals(((JSONObject)localObject6).optString("exttype"))) {
              break label946;
            }
            if (!"1".equals(((JSONObject)localObject6).optString("exttype"))) {
              break label952;
            }
          }
          catch (Exception localException4)
          {
            try
            {
              bool1 = ((JSONObject)localObject6).has("a_a");
              if ((!bool1) || (((JSONObject)localObject6).isNull("a_a"))) {
                continue;
              }
              JumpAction localJumpAction = JumpParser.a(paramQQAppInterface, paramActivity, ((JSONObject)localObject6).optString("a_a"));
              if (localJumpAction == null) {
                break label853;
              }
              localJumpAction.a();
              return;
              localException4 = localException4;
              continue;
              if ((!((JSONObject)localObject6).has("url")) || (((JSONObject)localObject6).isNull("url"))) {
                break label853;
              }
              j = ((JSONObject)localObject6).optInt("url_level");
              localObject4 = ((JSONObject)localObject6).optString("url");
              bool1 = TextUtils.isEmpty((CharSequence)localObject4);
              if (bool1) {
                continue;
              }
              i = j;
              Object localObject2 = localObject4;
              if (j != 2) {
                continue;
              }
              localObject2 = Uri.parse((String)localObject4).toString();
              i = j;
              continue;
              i = 0;
              localObject2 = localObject1;
              if ((i == 1) || (i == 2)) {
                continue;
              }
              i = 0;
              localObject1 = localObject2;
              break label856;
              try
              {
                localObject1 = new ActivityURIRequest(paramActivity, "/pubaccount/browser");
                ((ActivityURIRequest)localObject1).extra().putBoolean("key_isReadModeEnabled", true);
                ((ActivityURIRequest)localObject1).extra().putBoolean("fromQrcode", true);
                ((ActivityURIRequest)localObject1).extra().putString("url", (String)localObject2);
                ((ActivityURIRequest)localObject1).extra().putString("big_brother_source_key", "biz_src_jc_sacan_qr");
                QRoute.startUri((URIRequest)localObject1, null);
                localObject4 = localObject2;
                UrlQRProcessor.a(0, str3, paramActivity, paramQQAppInterface);
                localObject4 = localObject2;
                paramOnQRHandleResultCallback.b();
                return;
              }
              catch (Exception localException6)
              {
                localObject1 = localObject2;
              }
            }
            catch (Exception localException5) {}
          }
          localObject4 = new Bundle();
          if (bool1) {
            ((Bundle)localObject4).putBoolean("issupportwpa", bool1);
          }
          if ((j != 0) && (i != 0))
          {
            str4 = ((JSONObject)localObject6).optString("exttype");
            localObject6 = ((JSONObject)localObject6).optString("extvalue");
            ((Bundle)localObject4).putString("exttype", str4);
            ((Bundle)localObject4).putString("extvalue", (String)localObject6);
          }
          ((Bundle)localObject4).putString("authSig", localException1);
          if (localUri == null) {
            str2 = null;
          } else {
            str2 = localUri.getQueryParameter("jump_from");
          }
          if ((str2 != null) && ("webapi".equalsIgnoreCase(str2))) {
            ((Bundle)localObject4).putString("sourceId", "3_40002");
          }
          i = ((IQRJumpApi)QRoute.api(IQRJumpApi.class)).handleResult(paramQQAppInterface, paramActivity, localQRActionEntity, str3, (Bundle)localObject4);
          try
          {
            UrlQRProcessor.a(i, str3, paramActivity, paramQQAppInterface);
            paramOnQRHandleResultCallback.b();
            return;
          }
          catch (Exception localException2) {}
        }
      }
      catch (Exception localException7)
      {
        Object localObject6;
        localObject3 = localException7;
        i = 0;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("handle url error: ");
        ((StringBuilder)localObject5).append(((Exception)localObject3).getMessage());
        QLog.e("IQRScanConst_BaseQRScanResultProcessor", 1, ((StringBuilder)localObject5).toString());
        break label856;
      }
      label853:
      int i = 0;
      label856:
      Object localObject3 = DialogUtil.a(paramActivity, 230);
      ((QQCustomDialog)localObject3).setTitle(2131716701);
      ((QQCustomDialog)localObject3).setMessage((CharSequence)localObject1);
      Object localObject5 = new UrlQRProcessor.ConcurrentReqManager.3(this, paramOnQRHandleResultCallback);
      ((QQCustomDialog)localObject3).setPositiveButton(2131694583, new UrlQRProcessor.ConcurrentReqManager.4(this, (String)localObject1, paramActivity, paramOnQRHandleResultCallback));
      ((QQCustomDialog)localObject3).setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject5);
      ((QQCustomDialog)localObject3).setOnCancelListener((DialogInterface.OnCancelListener)localObject5);
      ((QQCustomDialog)localObject3).show();
      UrlQRProcessor.a(i, (String)localObject1, paramActivity, paramQQAppInterface);
      return;
      label946:
      int j = 1;
      continue;
      label952:
      j = 0;
    }
  }
  
  private boolean a(Activity paramActivity, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQrcodeProcessorUrlQRProcessor$ConcurrentReqManager$UrlDecodeReqResult;
    if ((localObject != null) && (((UrlQRProcessor.ConcurrentReqManager.UrlDecodeReqResult)localObject).jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_ComTencentBizQrcodeProcessorUrlQRProcessor$ConcurrentReqManager$UrlDecodeReqResult.jdField_a_of_type_AndroidOsBundle == null) {
        return false;
      }
      localObject = a();
      if (localObject != null)
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppByApiAppInfo(paramActivity, (INTERFACE.StApiAppInfo)localObject, a());
        paramOnQRHandleResultCallback.b();
        return true;
      }
    }
    return false;
  }
  
  @NonNull
  public MiniAppCmdInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniReuseMiniAppCmdInterface;
  }
  
  @NonNull
  public QRCodeBusinessObserver a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqQrscanQRCodeBusinessObserver;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.UrlQRProcessor.ConcurrentReqManager
 * JD-Core Version:    0.7.0.1
 */