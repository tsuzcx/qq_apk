package com.tencent.mobileqq.apollo.handler.api.impl;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.jsp.WebSSOAgentServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

class ApolloWebDataHandlerImpl$WebSSOTask
  implements BusinessObserver
{
  private long jdField_a_of_type_Long;
  private ApolloWebStatistics jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics;
  private final String jdField_a_of_type_JavaLangString;
  private final List<ApolloWebDataHandlerImpl.WebDataCallBack> jdField_a_of_type_JavaUtilList;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public ApolloWebDataHandlerImpl$WebSSOTask(ApolloWebStatistics paramApolloWebStatistics, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics = paramApolloWebStatistics;
  }
  
  public JSONObject a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean)
        {
          Object localObject = paramBundle.getByteArray("extra_data");
          if (localObject != null)
          {
            paramBundle = new WebSSOAgent.UniSsoServerRsp();
            paramBundle.mergeFrom((byte[])localObject);
            localJSONObject.put("ssoRet", 0);
            if (paramBundle.ret.has())
            {
              long l = paramBundle.ret.get();
              localJSONObject.put("businessRet", l);
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("uniAgent, ret, biz ret code=");
                ((StringBuilder)localObject).append(l);
                QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, ((StringBuilder)localObject).toString());
              }
            }
            else
            {
              localJSONObject.put("businessRet", 0);
            }
            if (paramBundle.errmsg.has())
            {
              localObject = paramBundle.errmsg.get();
              localJSONObject.put("msg", localObject);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("uniAgent, ret, errmsg=");
                localStringBuilder.append((String)localObject);
                QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, localStringBuilder.toString());
              }
            }
            else
            {
              localJSONObject.put("msg", "SSO发送成功");
            }
            if (paramBundle.rspdata.has())
            {
              paramBundle = paramBundle.rspdata.get();
              localJSONObject.put("data", paramBundle);
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("uniAgent, ret, rspData=");
                ((StringBuilder)localObject).append(paramBundle);
                QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, ((StringBuilder)localObject).toString());
                return localJSONObject;
              }
            }
          }
          else
          {
            this.jdField_a_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.w("[cmshow]apollo_client_ApolloWebDataHandler", 2, "uniAgent, onReceive, ret success but no data");
            }
            localJSONObject.put("ssoRet", 255);
            localJSONObject.put("businessRet", 0);
            localJSONObject.put("msg", "SSO返回数据包为空");
            return localJSONObject;
          }
        }
        else
        {
          i = paramBundle.getInt("extra_result_code");
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("uniAgent, msfResultCode=");
            paramBundle.append(i);
            QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramBundle.toString());
          }
          if (i != 1001) {
            break label512;
          }
          localJSONObject.put("ssoRet", 201);
          localJSONObject.put("businessRet", 0);
          localJSONObject.put("msg", HardCodeUtil.a(2131700805));
          return localJSONObject;
          localJSONObject.put("ssoRet", 255);
          localJSONObject.put("businessRet", 0);
          localJSONObject.put("msg", HardCodeUtil.a(2131700806));
          return localJSONObject;
          localJSONObject.put("ssoRet", 202);
          localJSONObject.put("businessRet", 0);
          localJSONObject.put("msg", HardCodeUtil.a(2131700802));
        }
        return localJSONObject;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return null;
      }
      label512:
      if (i != 1002) {
        if (i != 1013) {}
      }
    }
  }
  
  public void a()
  {
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ApolloWebDataHandlerImpl.WebDataCallBack)((Iterator)localObject).next()).a(this, this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifySSORsp, mReceivedSSO:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(Context paramContext, String paramString, JSONObject paramJSONObject, AppInterface paramAppInterface)
  {
    if ((paramJSONObject != null) && (paramContext != null) && (paramAppInterface != null)) {}
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendRequest, currentUrl:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" requestJsonObj:requestJsonObj");
        QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramJSONObject.optInt("needCookie") == 1) && (!TextUtils.isEmpty(paramString)))
      {
        localObject = SwiftBrowserCookieMonster.c(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (((String)localObject).indexOf(',') != -1) {
            ((String)localObject).replace(',', ';');
          }
          paramJSONObject.put("Cookie", localObject);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Get cookie:");
          localStringBuilder.append(Util.c((String)localObject, new String[0]));
          localStringBuilder.append(" from ");
          localStringBuilder.append(Util.b(paramString, new String[0]));
          QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, localStringBuilder.toString());
        }
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0");
      paramString = new WebSSOAgent.UniSsoServerReq();
      paramString.comm.set((MessageMicro)localObject);
      paramJSONObject.remove("callback");
      paramJSONObject.remove("cmd");
      paramJSONObject.remove("needCookie");
      paramJSONObject.remove("timeout");
      localObject = new JSONObject();
      ((JSONObject)localObject).put("fingerprint", Build.FINGERPRINT);
      ((JSONObject)localObject).put("model", Build.MODEL);
      ((JSONObject)localObject).put("manufacturer", Build.MANUFACTURER);
      ((JSONObject)localObject).put("brand", Build.BRAND);
      ((JSONObject)localObject).put("device", Build.DEVICE);
      ((JSONObject)localObject).put("product", Build.PRODUCT);
      ((JSONObject)localObject).put("id", Build.ID);
      ((JSONObject)localObject).put("level", Build.VERSION.SDK_INT);
      ((JSONObject)localObject).put("cpu_abi", Build.CPU_ABI);
      ((JSONObject)localObject).put("cpu_abi2", Build.CPU_ABI2);
      paramJSONObject.put("option", localObject);
      paramString.reqdata.set(paramJSONObject.toString());
      paramContext = new NewIntent(paramContext, WebSSOAgentServlet.class);
      paramContext.putExtra("extra_cmd", this.jdField_a_of_type_JavaLangString);
      paramContext.putExtra("extra_data", paramString.toByteArray());
      paramContext.putExtra("extra_timeout", -1L);
      paramContext.setObserver(this);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, "uniAgent, req, send request to msf");
      }
      paramAppInterface.startServlet(paramContext);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics == null) {
        return;
      }
      paramContext = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics;
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Long = l;
      paramContext.jdField_a_of_type_Long = l;
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("sendRequest, requestJsonObj:");
      paramString.append(paramJSONObject);
      paramString.append(" context:");
      paramString.append(paramContext);
      paramString.append(" app:");
      paramString.append(paramAppInterface);
      QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramString.toString());
    }
    return;
  }
  
  public void a(ApolloWebDataHandlerImpl.WebDataCallBack paramWebDataCallBack)
  {
    if (paramWebDataCallBack != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramWebDataCallBack);
    }
  }
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_JavaLangString)) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 10000L) && (this.jdField_a_of_type_Boolean) && (((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_OrgJsonJSONObject != null)) || (!this.jdField_b_of_type_Boolean));
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_OrgJsonJSONObject = a(paramBoolean, paramBundle);
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("WebSSOTask, onReceive, isSuccess: ");
        paramBundle.append(paramBoolean);
        paramBundle.append(" mResultJson:");
        paramBundle.append(this.jdField_a_of_type_OrgJsonJSONObject);
        QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, paramBundle.toString());
      }
      a();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloWebStatistics.b = System.currentTimeMillis();
        return;
      }
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uniAgent, onReceive, Exception: ");
        localStringBuilder.append(paramBundle.getMessage());
        QLog.e("[cmshow]apollo_client_ApolloWebDataHandler", 2, localStringBuilder.toString());
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSSOCmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" mPreloadTS:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" mIsSuccess:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" mReceivedSSO:");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(" mResultJson:");
    localStringBuilder.append(this.jdField_a_of_type_OrgJsonJSONObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.api.impl.ApolloWebDataHandlerImpl.WebSSOTask
 * JD-Core Version:    0.7.0.1
 */