import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
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

class amzm
  implements BusinessObserver
{
  private long jdField_a_of_type_Long;
  private amzn jdField_a_of_type_Amzn;
  private final String jdField_a_of_type_JavaLangString;
  private final List<amzl> jdField_a_of_type_JavaUtilList;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public amzm(amzn paramamzn, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Amzn = paramamzn;
  }
  
  public JSONObject a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        if (!paramBoolean) {
          break label323;
        }
        Object localObject = paramBundle.getByteArray("extra_data");
        if (localObject == null) {
          break;
        }
        paramBundle = new WebSSOAgent.UniSsoServerRsp();
        paramBundle.mergeFrom((byte[])localObject);
        localJSONObject.put("ssoRet", 0);
        if (paramBundle.ret.has())
        {
          long l = paramBundle.ret.get();
          localJSONObject.put("businessRet", l);
          if (QLog.isColorLevel()) {
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "uniAgent, ret, biz ret code=" + l);
          }
          if (paramBundle.errmsg.has())
          {
            localObject = paramBundle.errmsg.get();
            localJSONObject.put("msg", localObject);
            if (QLog.isColorLevel()) {
              QLog.d("apollo_client_ApolloWebDataHandler", 2, "uniAgent, ret, errmsg=" + (String)localObject);
            }
            if (!paramBundle.rspdata.has()) {
              break label473;
            }
            paramBundle = paramBundle.rspdata.get();
            localJSONObject.put("data", paramBundle);
            if (!QLog.isColorLevel()) {
              break label473;
            }
            QLog.d("apollo_client_ApolloWebDataHandler", 2, "uniAgent, ret, rspData=" + paramBundle);
            break label473;
          }
        }
        else
        {
          localJSONObject.put("businessRet", 0);
          continue;
        }
        localJSONObject.put("msg", "SSO发送成功");
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        return null;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.w("apollo_client_ApolloWebDataHandler", 2, "uniAgent, onReceive, ret success but no data");
    }
    localJSONObject.put("ssoRet", 255);
    localJSONObject.put("businessRet", 0);
    localJSONObject.put("msg", "SSO返回数据包为空");
    break label473;
    label323:
    int i = paramBundle.getInt("extra_result_code");
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "uniAgent, msfResultCode=" + i);
    }
    if (i == 1001)
    {
      localJSONObject.put("ssoRet", 201);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", anni.a(2131699393));
    }
    for (;;)
    {
      localJSONObject.put("ssoRet", 202);
      localJSONObject.put("businessRet", 0);
      localJSONObject.put("msg", anni.a(2131699390));
      label473:
      do
      {
        localJSONObject.put("ssoRet", 255);
        localJSONObject.put("businessRet", 0);
        localJSONObject.put("msg", anni.a(2131699394));
        return localJSONObject;
        if (i == 1002) {
          break;
        }
      } while (i != 1013);
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((amzl)localIterator.next()).a(this, this.jdField_a_of_type_Amzn);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "notifySSORsp, mReceivedSSO:" + this.jdField_b_of_type_Boolean);
    }
  }
  
  public void a(amzl paramamzl)
  {
    if (paramamzl != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramamzl);
    }
  }
  
  public void a(Context paramContext, String paramString, JSONObject paramJSONObject, AppInterface paramAppInterface)
  {
    if ((paramJSONObject == null) || (paramContext == null) || (paramAppInterface == null)) {}
    try
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "sendRequest, requestJsonObj:" + paramJSONObject + " context:" + paramContext + " app:" + paramAppInterface);
      return;
    }
    catch (Exception paramContext)
    {
      Object localObject;
      long l;
      paramContext.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "sendRequest, currentUrl:" + paramString + " requestJsonObj:requestJsonObj");
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
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "Get cookie:" + nmj.c((String)localObject, new String[0]) + " from " + nmj.b(paramString, new String[0]));
      }
    }
    localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.1");
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
    paramContext = new NewIntent(paramContext, avqx.class);
    paramContext.putExtra("extra_cmd", this.jdField_a_of_type_JavaLangString);
    paramContext.putExtra("extra_data", paramString.toByteArray());
    paramContext.putExtra("extra_timeout", -1L);
    paramContext.setObserver(this);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "uniAgent, req, send request to msf");
    }
    paramAppInterface.startServlet(paramContext);
    if (this.jdField_a_of_type_Amzn != null)
    {
      paramContext = this.jdField_a_of_type_Amzn;
      l = System.currentTimeMillis();
      this.jdField_a_of_type_Long = l;
      paramContext.jdField_a_of_type_Long = l;
      return;
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
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebSSOTask, onReceive, isSuccess: " + paramBoolean + " mResultJson:" + this.jdField_a_of_type_OrgJsonJSONObject);
      }
      a();
      if (this.jdField_a_of_type_Amzn != null) {
        this.jdField_a_of_type_Amzn.b = System.currentTimeMillis();
      }
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("apollo_client_ApolloWebDataHandler", 2, "uniAgent, onReceive, Exception: " + paramBundle.getMessage());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSSOCmd:").append(this.jdField_a_of_type_JavaLangString).append(" mPreloadTS:").append(this.jdField_a_of_type_Long).append(" mIsSuccess:").append(this.jdField_a_of_type_Boolean).append(" mReceivedSSO:").append(this.jdField_b_of_type_Boolean).append(" mResultJson:").append(this.jdField_a_of_type_OrgJsonJSONObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzm
 * JD-Core Version:    0.7.0.1
 */