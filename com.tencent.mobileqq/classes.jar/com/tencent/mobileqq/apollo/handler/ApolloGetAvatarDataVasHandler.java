package com.tencent.mobileqq.apollo.handler;

import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.handler.IVasExtensionHandler;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionServletImpl;
import com.tencent.mobileqq.apollo.api.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.Action;
import com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.QQUsrImgReq;
import com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.QQUsrImgRsp;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;

public class ApolloGetAvatarDataVasHandler
  implements IVasExtensionHandler
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong < 0L)
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[getApolloAvatarDataReqFromNetwork] invalid avatarType " + paramLong);
      return;
    }
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[getApolloAvatarDataReqFromNetwork] app is null.");
      return;
    }
    try
    {
      QLog.d("ApolloGetAvatarDataVasHandler", 1, "[getApolloAvatarDataReqFromNetwork] avatarType = " + paramLong);
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new ApolloQQUsrImg.QQUsrImgReq();
      ((ApolloQQUsrImg.QQUsrImgReq)localObject).uin.set(Long.parseLong(paramQQAppInterface.getCurrentUin()));
      ((ApolloQQUsrImg.QQUsrImgReq)localObject).type.set(paramLong);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((ApolloQQUsrImg.QQUsrImgReq)localObject).toByteArray()));
      localObject = new NewIntent(paramQQAppInterface.getApp(), ApolloExtensionServletImpl.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_light.apollo_imglogic_linkcmd_get_avatars");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      paramQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[getApolloAvatarDataReqFromNetwork] avatarType = " + paramLong + ", exception = ", paramQQAppInterface);
    }
  }
  
  private void b(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramIApolloExtensionHandler == null)
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[handleGetApolloAvatarDataRsp] baseHandler is null");
      return;
    }
    if (paramIApolloExtensionHandler.a() == null)
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[handleGetApolloAvatarDataRsp] baseHandler.app is null");
      return;
    }
    if (paramIntent == null)
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[handleGetApolloAvatarDataRsp] failed. request is null!");
      return;
    }
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()) || (paramArrayOfByte == null))
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[handleGetApolloAvatarDataRsp] failed. no response data!");
      return;
    }
    int j;
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      localObject = new ApolloQQUsrImg.QQUsrImgRsp();
      ((ApolloQQUsrImg.QQUsrImgRsp)localObject).mergeFrom(paramIntent.pbRsqData.get().toByteArray());
      paramIntent = ((ApolloQQUsrImg.QQUsrImgRsp)localObject).acts.get();
      paramFromServiceMsg = ((ApolloQQUsrImg.QQUsrImgRsp)localObject).jump_more.get();
      paramArrayOfByte = ((ApolloQQUsrImg.QQUsrImgRsp)localObject).jump_mall.get();
      j = ((ApolloQQUsrImg.QQUsrImgRsp)localObject).icon_nums.get();
      if ((paramIntent == null) || (paramIntent.size() < 1))
      {
        QLog.e("ApolloGetAvatarDataVasHandler", 1, "[handleGetApolloAvatarDataRsp] actionList is empty");
        return;
      }
    }
    catch (Exception paramIApolloExtensionHandler)
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[handleGetApolloAvatarActionListNetworkRsp] exception=", paramIApolloExtensionHandler);
      return;
    }
    if ((paramFromServiceMsg == null) || (TextUtils.isEmpty(paramArrayOfByte)))
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[handleGetApolloAvatarDataRsp] jumpMoreUrl is null");
      return;
    }
    if ((paramArrayOfByte == null) || (TextUtils.isEmpty(paramArrayOfByte)))
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[handleGetApolloAvatarDataRsp] jumpMallUrl is null");
      return;
    }
    if (j < 1)
    {
      QLog.e("ApolloGetAvatarDataVasHandler", 1, "[handleGetApolloAvatarDataRsp] counts is null");
      return;
    }
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramIntent.size())
    {
      ApolloQQUsrImg.Action localAction = (ApolloQQUsrImg.Action)paramIntent.get(i);
      CmAvatarFaceInfo localCmAvatarFaceInfo = new CmAvatarFaceInfo();
      localCmAvatarFaceInfo.setActionId((int)localAction.act_id.get());
      localCmAvatarFaceInfo.setIsDynamic((int)localAction.is_dynamic.get());
      localCmAvatarFaceInfo.setType((int)localAction.type.get());
      localCmAvatarFaceInfo.setActionType(localAction.act_type.get());
      localCmAvatarFaceInfo.setIcon(localAction.icon.get());
      ((List)localObject).add(localCmAvatarFaceInfo);
      i += 1;
    }
    ((BusinessHandler)paramIApolloExtensionHandler).notifyUI(39, true, new Object[] { localObject, paramFromServiceMsg, paramArrayOfByte, Integer.valueOf(j) });
  }
  
  public void a(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    b(paramIApolloExtensionHandler, paramIntent, paramFromServiceMsg, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloGetAvatarDataVasHandler
 * JD-Core Version:    0.7.0.1
 */