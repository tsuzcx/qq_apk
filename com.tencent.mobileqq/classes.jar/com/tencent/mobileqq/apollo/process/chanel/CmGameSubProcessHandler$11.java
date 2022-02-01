package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameSubProcessHandler$11
  implements APICallback
{
  CmGameSubProcessHandler$11(CmGameSubProcessHandler paramCmGameSubProcessHandler, CmGameInitParams paramCmGameInitParams, long paramLong) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onPermission], code:" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 2;
    }
    try
    {
      IApolloCmdChannel localIApolloCmdChannel = CmGameUtil.a();
      if (localIApolloCmdChannel != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("type", "unauthorized");
        localIApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_login.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onFailure], code:" + paramInt + ",msg:" + paramString);
    try
    {
      paramString = CmGameUtil.a();
      if (paramString != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("type", "failure");
        paramString.callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_login.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      IApolloCmdChannel localIApolloCmdChannel = CmGameUtil.a();
      if (localIApolloCmdChannel != null)
      {
        paramJSONObject.put("ret", 0);
        paramJSONObject.put("type", "success");
        CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloProcessChanelCmGameSubProcessHandler, paramJSONObject.optString("access_token"));
        localIApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_login.local", paramJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameSubProcessHandler.11
 * JD-Core Version:    0.7.0.1
 */