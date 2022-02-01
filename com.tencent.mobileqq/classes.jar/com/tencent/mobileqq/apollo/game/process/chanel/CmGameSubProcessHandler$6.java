package com.tencent.mobileqq.apollo.game.process.chanel;

import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.apollo.game.process.data.CmGameInitParams;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class CmGameSubProcessHandler$6
  implements APICallback
{
  CmGameSubProcessHandler$6(CmGameSubProcessHandler paramCmGameSubProcessHandler, CmGameInitParams paramCmGameInitParams, long paramLong) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onPermission], code:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessDataCmGameInitParams;
    if (localObject != null) {
      ((CmGameInitParams)localObject).accessTokenRet = 2;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("ret", paramInt);
      ((JSONObject)localObject).put("type", "unauthorized");
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_login.local", ((JSONObject)localObject).toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onFailure], code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",msg:");
    localStringBuilder.append(paramString);
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, localStringBuilder.toString());
    try
    {
      paramString = new JSONObject();
      paramString.put("ret", paramInt);
      paramString.put("type", "failure");
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_login.local", paramString.toString());
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
      paramJSONObject.put("ret", 0);
      paramJSONObject.put("type", "success");
      CmGameSubProcessHandler.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessChanelCmGameSubProcessHandler, paramJSONObject.optString("access_token"));
      ApolloCmdChannel.getInstance().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_login.local", paramJSONObject.toString());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void b(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameSubProcessHandler.6
 * JD-Core Version:    0.7.0.1
 */