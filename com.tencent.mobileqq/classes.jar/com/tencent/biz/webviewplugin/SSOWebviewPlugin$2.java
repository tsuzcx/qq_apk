package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRspComm;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class SSOWebviewPlugin$2
  implements BusinessObserver
{
  SSOWebviewPlugin$2(SSOWebviewPlugin paramSSOWebviewPlugin, long paramLong, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      long l1;
      try
      {
        paramInt = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        String str = paramBundle.getString("extra_callbackid");
        if (TextUtils.isEmpty(str)) {
          return;
        }
        localJSONObject = new JSONObject();
        long l2 = -1L;
        if (!paramBoolean) {
          break label916;
        }
        byte[] arrayOfByte = paramBundle.getByteArray("extra_data");
        if (arrayOfByte == null) {
          break label867;
        }
        localObject = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(arrayOfByte);
        l1 = l2;
        if (((WebSSOAgent.UniSsoServerRsp)localObject).comm.has())
        {
          paramBundle = paramBundle.getString("extra_cmd");
          if (QLog.isColorLevel()) {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, cmd=" + paramBundle);
          }
          l1 = l2;
          if (!TextUtils.isEmpty(paramBundle))
          {
            if (((WebSSOAgent.UniSsoServerRsp)localObject).comm.delayms.has())
            {
              l1 = Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject).comm.delayms.get()).longValue();
              if (l1 != 0L) {
                break label792;
              }
              this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.e.put(paramBundle, Integer.valueOf(2147483647));
              if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, delay=" + l1 + ", cmd:" + paramBundle);
              }
            }
            if (((WebSSOAgent.UniSsoServerRsp)localObject).comm.packagesize.has())
            {
              l1 = Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject).comm.packagesize.get()).longValue();
              this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.b.put(paramBundle, Long.valueOf(l1));
              if (QLog.isColorLevel()) {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, pkgSize=" + l1);
              }
            }
            l1 = l2;
            if (((WebSSOAgent.UniSsoServerRsp)localObject).comm.proctime.has())
            {
              l2 = ((WebSSOAgent.UniSsoServerRsp)localObject).comm.proctime.get();
              l1 = l2;
              if (QLog.isColorLevel())
              {
                QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, svrCostTime=" + l2);
                l1 = l2;
              }
            }
          }
        }
        localJSONObject.put("ssoRet", 0);
        if (!((WebSSOAgent.UniSsoServerRsp)localObject).ret.has()) {
          break label841;
        }
        l2 = ((WebSSOAgent.UniSsoServerRsp)localObject).ret.get();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label828;
        }
        if (l2 == 0L) {
          break label813;
        }
        SSOWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin, this.jdField_a_of_type_JavaLangString, l2, paramInt);
        localJSONObject.put("businessRet", l2);
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, biz ret code=" + l2);
        }
        if (!((WebSSOAgent.UniSsoServerRsp)localObject).errmsg.has()) {
          break label853;
        }
        paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject).errmsg.get();
        localJSONObject.put("msg", paramBundle);
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, errmsg=" + paramBundle);
        }
        l2 = l1;
        if (((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.has())
        {
          paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject).rspdata.get();
          localJSONObject.put("data", paramBundle);
          l2 = l1;
          if (QLog.isColorLevel())
          {
            QLog.d("SSOWebviewPlugin", 2, "uniAgent, ret, rspData=" + paramBundle);
            l2 = l1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SSOWebviewPlugin", 2, "uniAgent, callback Json string=" + localJSONObject.toString());
        }
        localObject = SSOWebviewPlugin.a(l2);
        localJSONObject.put("speedPoint", localObject);
        this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.callJs(str, new String[] { localJSONObject.toString() });
        str = "ssoWebView";
        paramBundle = str;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          paramBundle = str;
          if (this.jdField_a_of_type_JavaLangString.startsWith("apollo")) {
            paramBundle = "apolloSSOWebView";
          }
        }
        SSOWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.mRuntime.a(), this.jdField_a_of_type_JavaLangString, paramBundle, localJSONObject, (JSONObject)localObject);
        return;
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      QLog.e("SSOWebviewPlugin", 2, "uniAgent, onReceive, Exception: " + paramBundle);
      return;
      label792:
      this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.e.put(paramBundle, Integer.valueOf((int)l1));
      continue;
      label813:
      SSOWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin, this.jdField_a_of_type_JavaLangString, paramInt);
      continue;
      label828:
      QLog.e("SSOWebviewPlugin_apollo_store_stability_", 1, "uniAgent, reportSSOReqRespWatch, cmd is empty");
      continue;
      label841:
      localJSONObject.put("businessRet", 0);
      continue;
      label853:
      localJSONObject.put("msg", "SSO发送成功");
      continue;
      label867:
      if (QLog.isColorLevel()) {
        QLog.w("SSOWebviewPlugin", 2, "uniAgent, onReceive, ret success but no data");
      }
      localJSONObject.put("ssoRet", 255);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", "SSO返回数据包为空");
      continue;
      label916:
      Object localObject = paramBundle.getString("extra_cmd");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        SSOWebviewPlugin.b(this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin, (String)localObject, paramInt);
      }
      paramInt = paramBundle.getInt("extra_result_code");
      if (QLog.isColorLevel()) {
        QLog.d("SSOWebviewPlugin", 2, "uniAgent, msfResultCode=" + paramInt);
      }
      if (paramInt != 1001) {
        break label1101;
      }
      localJSONObject.put("ssoRet", 201);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", HardCodeUtil.a(2131714215));
    }
    for (;;)
    {
      label1026:
      localJSONObject.put("ssoRet", 202);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", HardCodeUtil.a(2131714221));
      break;
      label1101:
      do
      {
        localJSONObject.put("ssoRet", 255);
        localJSONObject.put("businessRet", 0);
        localJSONObject.put("msg", HardCodeUtil.a(2131714220));
        break;
        return;
        if (paramInt == 1002) {
          break label1026;
        }
      } while (paramInt != 1013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SSOWebviewPlugin.2
 * JD-Core Version:    0.7.0.1
 */