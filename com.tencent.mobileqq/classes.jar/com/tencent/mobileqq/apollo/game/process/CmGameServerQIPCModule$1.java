package com.tencent.mobileqq.apollo.game.process;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.ApolloGameResManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import org.json.JSONObject;

class CmGameServerQIPCModule$1
  implements Runnable
{
  CmGameServerQIPCModule$1(CmGameServerQIPCModule paramCmGameServerQIPCModule, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = ApolloGameResManager.a(this.a, this.b);
      Object localObject;
      if (localJSONObject != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("resData", localJSONObject.toString());
        localObject = EIPCResult.createSuccessResult((Bundle)localObject);
        this.this$0.callbackResult(this.c, (EIPCResult)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" ACTION_GET_ACTION_DATA callbackResult retJson:");
        ((StringBuilder)localObject).append(localJSONObject);
        QLog.d("cmgame_process.CmGameServerQIPCModule", 2, new Object[] { "[cmshow]apollo_cmGame_", ((StringBuilder)localObject).toString() });
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameServerQIPCModule", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule.1
 * JD-Core Version:    0.7.0.1
 */