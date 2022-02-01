package com.tencent.mobileqq.apollo.game.utils;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import org.json.JSONObject;

final class ApolloGameBasicEventUtil$1
  implements ApolloGameBasicEventUtil.NotifyGameDressReady
{
  ApolloGameBasicEventUtil$1(int paramInt) {}
  
  public void a(int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("[notifyRoleDress], uin:");
      paramQQAppInterface.append(paramString1);
      paramQQAppInterface.append(",roleId:");
      paramQQAppInterface.append(paramInt2);
      paramQQAppInterface.append(",from:");
      paramQQAppInterface.append(paramInt3);
      paramQQAppInterface.append(",cmd:");
      paramQQAppInterface.append(paramString3);
      QLog.d("[cmshow]ApolloGameBasicEventUtil", 2, paramQQAppInterface.toString());
    }
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length == 0) {
        return;
      }
      try
      {
        paramQQAppInterface = ApolloGameBasicEventUtil.a(paramInt2, paramArrayOfInt);
        if (paramQQAppInterface == null)
        {
          QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, "errInfo-> jsonObject is NULL");
          return;
        }
        if (this.a == 1000) {
          paramQQAppInterface.put("uin", paramString1);
        }
        paramQQAppInterface.put("openId", paramString2);
        paramString1 = new Bundle();
        paramString1.putString("resData", paramQQAppInterface.toString());
        paramQQAppInterface = EIPCResult.createResult(0, paramString1);
        CmGameServerQIPCModule.a().callbackResult(paramInt1, paramQQAppInterface);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramString1 = new StringBuilder();
        paramString1.append("[notifyRoleDress], errInfo->");
        paramString1.append(paramQQAppInterface.getMessage());
        QLog.e("[cmshow]ApolloGameBasicEventUtil", 1, paramString1.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil.1
 * JD-Core Version:    0.7.0.1
 */