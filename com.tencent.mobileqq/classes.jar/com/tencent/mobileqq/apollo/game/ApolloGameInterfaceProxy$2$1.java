package com.tencent.mobileqq.apollo.game;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONObject;

class ApolloGameInterfaceProxy$2$1
  implements EIPCResultCallback
{
  ApolloGameInterfaceProxy$2$1(ApolloGameInterfaceProxy.2 param2) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("type");
    Object localObject;
    StringBuilder localStringBuilder;
    if (i == 1)
    {
      localObject = paramEIPCResult.getString("nickName");
      try
      {
        paramEIPCResult = new JSONObject();
        paramEIPCResult.put("nickname", 1);
        paramEIPCResult.put("data", localObject);
        paramEIPCResult.put("openId", this.a.jdField_a_of_type_JavaLangString);
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameInterfaceProxy;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramEIPCResult.toString());
        localStringBuilder.append("");
        ApolloGameInterfaceProxy.a((ApolloGameInterfaceProxy)localObject, "cs.get_userInfo.local", localStringBuilder.toString());
        return;
      }
      catch (Throwable paramEIPCResult)
      {
        QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramEIPCResult, new Object[0]);
        return;
      }
    }
    if (i == 2)
    {
      localObject = ApolloGameTool.a((Bitmap)paramEIPCResult.getParcelable("head"), 100);
      try
      {
        paramEIPCResult = new JSONObject();
        paramEIPCResult.put("avatar", 1);
        paramEIPCResult.put("data", localObject);
        paramEIPCResult.put("openId", this.a.jdField_a_of_type_JavaLangString);
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqApolloGameApolloGameInterfaceProxy;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramEIPCResult.toString());
        localStringBuilder.append("");
        ApolloGameInterfaceProxy.a((ApolloGameInterfaceProxy)localObject, "cs.get_userInfo.local", localStringBuilder.toString());
        return;
      }
      catch (Throwable paramEIPCResult)
      {
        QLog.e("[cmshow]ApolloGameInterfaceProxy", 1, paramEIPCResult, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy.2.1
 * JD-Core Version:    0.7.0.1
 */