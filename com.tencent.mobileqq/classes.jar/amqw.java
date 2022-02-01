import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class amqw
  implements adea
{
  amqw(amqt paramamqt, CmGameInitParams paramCmGameInitParams, long paramLong) {}
  
  public void onComplete() {}
  
  public void onFailure(int paramInt, String paramString)
  {
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onFailure], code:" + paramInt + ",msg:" + paramString);
    try
    {
      paramString = ampj.a();
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
  
  public void onPermission(int paramInt)
  {
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onPermission], code:" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 2;
    }
    try
    {
      ApolloCmdChannel localApolloCmdChannel = ampj.a();
      if (localApolloCmdChannel != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("ret", paramInt);
        localJSONObject.put("type", "unauthorized");
        localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_login.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, localThrowable, new Object[0]);
    }
  }
  
  public void onSuccess(JSONObject paramJSONObject)
  {
    try
    {
      ApolloCmdChannel localApolloCmdChannel = ampj.a();
      if (localApolloCmdChannel != null)
      {
        paramJSONObject.put("ret", 0);
        paramJSONObject.put("type", "success");
        amqt.a(this.jdField_a_of_type_Amqt, paramJSONObject.optString("access_token"));
        localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_login.local", paramJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("cmgame_process.CmGameSubProcessHandler", 1, paramJSONObject, new Object[0]);
    }
  }
  
  public void onTrigger(JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqw
 * JD-Core Version:    0.7.0.1
 */