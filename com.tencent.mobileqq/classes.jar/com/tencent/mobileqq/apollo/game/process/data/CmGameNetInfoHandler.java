package com.tencent.mobileqq.apollo.game.process.data;

import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
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
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[notifyEngineNetChange], type:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("cmgame_process.CmGameNetInfoHandler", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = CmGameUtil.a(this.jdField_a_of_type_Int);
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((CmGameLauncher)localObject1).a();
      if (localObject1 == null) {
        return;
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("type", paramInt);
      ApolloCmdChannel.getInstance().callbackFromRequest(((ApolloSurfaceView)localObject1).getLuaState(), 0, "sc.network_change.local", ((JSONObject)localObject2).toString());
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("errInfo->");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("cmgame_process.CmGameNetInfoHandler", 1, ((StringBuilder)localObject2).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */