import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class amya
  implements adaa
{
  amya(amxx paramamxx, CmGameInitParams paramCmGameInitParams, long paramLong) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onPermission], code:" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams.accessTokenRet = 2;
    }
    try
    {
      ApolloCmdChannel localApolloCmdChannel = amwn.a();
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
  
  public void a(int paramInt, String paramString)
  {
    QLog.w("cmgame_process.CmGameSubProcessHandler", 1, "[onFailure], code:" + paramInt + ",msg:" + paramString);
    try
    {
      paramString = amwn.a();
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
      ApolloCmdChannel localApolloCmdChannel = amwn.a();
      if (localApolloCmdChannel != null)
      {
        paramJSONObject.put("ret", 0);
        paramJSONObject.put("type", "success");
        amxx.a(this.jdField_a_of_type_Amxx, paramJSONObject.optString("access_token"));
        localApolloCmdChannel.callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.xy_login.local", paramJSONObject.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amya
 * JD-Core Version:    0.7.0.1
 */