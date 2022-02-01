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
    long l1;
    try
    {
      paramInt = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      localObject1 = paramBundle.getString("extra_callbackid");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      localJSONObject = new JSONObject();
      if (paramBoolean)
      {
        Object localObject3 = paramBundle.getByteArray("extra_data");
        if (localObject3 != null)
        {
          localObject2 = new WebSSOAgent.UniSsoServerRsp();
          ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject3);
          if (!((WebSSOAgent.UniSsoServerRsp)localObject2).comm.has()) {
            break label1158;
          }
          paramBundle = paramBundle.getString("extra_cmd");
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("uniAgent, ret, cmd=");
            ((StringBuilder)localObject3).append(paramBundle);
            QLog.d("SSOWebviewPlugin", 2, ((StringBuilder)localObject3).toString());
          }
          if (TextUtils.isEmpty(paramBundle)) {
            break label1158;
          }
          if (((WebSSOAgent.UniSsoServerRsp)localObject2).comm.delayms.has())
          {
            l1 = Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject2).comm.delayms.get()).longValue();
            if (l1 == 0L) {
              this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.e.put(paramBundle, Integer.valueOf(2147483647));
            } else {
              this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.e.put(paramBundle, Integer.valueOf((int)l1));
            }
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("uniAgent, ret, delay=");
              ((StringBuilder)localObject3).append(l1);
              ((StringBuilder)localObject3).append(", cmd:");
              ((StringBuilder)localObject3).append(paramBundle);
              QLog.d("SSOWebviewPlugin", 2, ((StringBuilder)localObject3).toString());
            }
          }
          if (((WebSSOAgent.UniSsoServerRsp)localObject2).comm.packagesize.has())
          {
            l1 = Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject2).comm.packagesize.get()).longValue();
            this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.b.put(paramBundle, Long.valueOf(l1));
            if (QLog.isColorLevel())
            {
              paramBundle = new StringBuilder();
              paramBundle.append("uniAgent, ret, pkgSize=");
              paramBundle.append(l1);
              QLog.d("SSOWebviewPlugin", 2, paramBundle.toString());
            }
          }
          if (!((WebSSOAgent.UniSsoServerRsp)localObject2).comm.proctime.has()) {
            break label1158;
          }
          l1 = ((WebSSOAgent.UniSsoServerRsp)localObject2).comm.proctime.get();
          if (!QLog.isColorLevel()) {
            break label1155;
          }
          paramBundle = new StringBuilder();
          paramBundle.append("uniAgent, ret, svrCostTime=");
          paramBundle.append(l1);
          QLog.d("SSOWebviewPlugin", 2, paramBundle.toString());
          break label1155;
          localJSONObject.put("ssoRet", 0);
          if (((WebSSOAgent.UniSsoServerRsp)localObject2).ret.has())
          {
            long l2 = ((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get();
            if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
            {
              if (l2 != 0L) {
                SSOWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin, this.jdField_a_of_type_JavaLangString, l2, paramInt);
              } else {
                SSOWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin, this.jdField_a_of_type_JavaLangString, paramInt);
              }
            }
            else {
              QLog.e("SSOWebviewPlugin_apollo_store_stability_", 1, "uniAgent, reportSSOReqRespWatch, cmd is empty");
            }
            localJSONObject.put("businessRet", l2);
            if (QLog.isColorLevel())
            {
              paramBundle = new StringBuilder();
              paramBundle.append("uniAgent, ret, biz ret code=");
              paramBundle.append(l2);
              QLog.d("SSOWebviewPlugin", 2, paramBundle.toString());
            }
          }
          else
          {
            localJSONObject.put("businessRet", 0);
          }
          if (((WebSSOAgent.UniSsoServerRsp)localObject2).errmsg.has())
          {
            paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject2).errmsg.get();
            localJSONObject.put("msg", paramBundle);
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("uniAgent, ret, errmsg=");
              ((StringBuilder)localObject3).append(paramBundle);
              QLog.d("SSOWebviewPlugin", 2, ((StringBuilder)localObject3).toString());
            }
          }
          else
          {
            localJSONObject.put("msg", "SSO发送成功");
          }
          if (!((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.has()) {
            break label1166;
          }
          paramBundle = ((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get();
          localJSONObject.put("data", paramBundle);
          if (!QLog.isColorLevel()) {
            break label1166;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("uniAgent, ret, rspData=");
          ((StringBuilder)localObject2).append(paramBundle);
          QLog.d("SSOWebviewPlugin", 2, ((StringBuilder)localObject2).toString());
          break label1166;
        }
        if (QLog.isColorLevel()) {
          QLog.w("SSOWebviewPlugin", 2, "uniAgent, onReceive, ret success but no data");
        }
        localJSONObject.put("ssoRet", 255);
        localJSONObject.put("businessRet", 0);
        localJSONObject.put("msg", "SSO返回数据包为空");
        l1 = -1L;
        break label1166;
      }
      localObject2 = paramBundle.getString("extra_cmd");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        SSOWebviewPlugin.b(this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin, (String)localObject2, paramInt);
      }
      paramInt = paramBundle.getInt("extra_result_code");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("uniAgent, msfResultCode=");
        paramBundle.append(paramInt);
        QLog.d("SSOWebviewPlugin", 2, paramBundle.toString());
      }
      if (paramInt != 1001) {
        break label1169;
      }
      localJSONObject.put("ssoRet", 201);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", HardCodeUtil.a(2131714144));
    }
    catch (Exception paramBundle)
    {
      JSONObject localJSONObject;
      Object localObject2;
      label898:
      if (!QLog.isColorLevel()) {
        break label1154;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uniAgent, onReceive, Exception: ");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.e("SSOWebviewPlugin", 2, ((StringBuilder)localObject1).toString());
      return;
    }
    localJSONObject.put("ssoRet", 255);
    localJSONObject.put("businessRet", 0);
    localJSONObject.put("msg", HardCodeUtil.a(2131714149));
    break label1186;
    label934:
    localJSONObject.put("ssoRet", 202);
    localJSONObject.put("businessRet", 0);
    localJSONObject.put("msg", HardCodeUtil.a(2131714150));
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("uniAgent, callback Json string=");
        paramBundle.append(localJSONObject.toString());
        QLog.d("SSOWebviewPlugin", 2, paramBundle.toString());
      }
      localObject2 = SSOWebviewPlugin.a(l1);
      localJSONObject.put("speedPoint", localObject2);
      this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.callJs((String)localObject1, new String[] { localJSONObject.toString() });
      localObject1 = "ssoWebView";
      paramBundle = (Bundle)localObject1;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramBundle = (Bundle)localObject1;
        if (this.jdField_a_of_type_JavaLangString.startsWith("apollo")) {
          paramBundle = "apolloSSOWebView";
        }
      }
      SSOWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginSSOWebviewPlugin.mRuntime.a(), this.jdField_a_of_type_JavaLangString, paramBundle, localJSONObject, (JSONObject)localObject2);
      return;
      label1154:
      label1155:
      break;
      label1158:
      l1 = -1L;
      break;
      label1166:
      continue;
      label1169:
      if (paramInt == 1002) {
        break label934;
      }
      if (paramInt != 1013) {
        break label898;
      }
      break label934;
      label1186:
      l1 = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.SSOWebviewPlugin.2
 * JD-Core Version:    0.7.0.1
 */