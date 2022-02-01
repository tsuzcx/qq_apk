package com.tencent.mobileqq.apollo.process.data;

import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CmGameNetInfoHandler
  implements INetInfoHandler
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  
  public CmGameNetInfoHandler(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameNetInfoHandler", 2, "[notifyEngineNetChange], type:" + paramInt);
      }
      try
      {
        IApolloCmdChannel localIApolloCmdChannel = CmGameUtil.a();
        if (localIApolloCmdChannel != null)
        {
          Object localObject = CmGameUtil.a(this.jdField_a_of_type_Int);
          if (localObject != null)
          {
            localObject = ((CmGameLauncher)localObject).a();
            if (localObject != null)
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("type", paramInt);
              localIApolloCmdChannel.callbackFromRequest(((ApolloSurfaceView)localObject).getLuaState(), 0, "sc.network_change.local", localJSONObject.toString());
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameNetInfoHandler", 1, "errInfo->" + localException.getMessage());
      }
    }
  }
  
  public void onNetMobile2None()
  {
    a(4);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    a(3);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    a(1);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    a(2);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    a(6);
  }
  
  public void onNetWifi2None()
  {
    a(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */