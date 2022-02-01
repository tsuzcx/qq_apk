package com.tencent.mobileqq.apollo.api.handler;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mobileqq.apollo.api.IApolloActionUsedManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionServletImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloActionUsedManagerServiceImpl;
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
import com.tencent.pb.apolloactionused.ApolloActionUsed.EmotionUsedReq;
import com.tencent.pb.apolloactionused.ApolloActionUsed.EmotionUsedRsp;
import com.tencent.pb.apolloactionused.ApolloActionUsed.EmuInfo;
import com.tencent.pb.apolloactionused.ApolloActionUsed.EmuTopo;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;

public class ApolloGetActionUsedListVasHandler
  implements IVasExtensionHandler
{
  private static int a;
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloGetActionUsedListVasHandler", 1, "[getApolloActionUsedListReqFromNetwork] app is null.");
      return;
    }
    a = paramInt;
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new ApolloActionUsed.EmotionUsedReq();
      ((ApolloActionUsed.EmotionUsedReq)localObject).uin.set(Long.parseLong(paramQQAppInterface.getCurrentUin()));
      ((ApolloActionUsed.EmotionUsedReq)localObject).pkgid.set(paramInt);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((ApolloActionUsed.EmotionUsedReq)localObject).toByteArray()));
      localObject = new NewIntent(paramQQAppInterface.getApp(), ApolloExtensionServletImpl.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_light.apollo_emotionsvr_linkcmd_emotionused");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      paramQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGetActionUsedListVasHandler", 1, "[getApolloActionUsedListReqFromNetwork] exception=", paramQQAppInterface);
    }
  }
  
  private void b(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramIApolloExtensionHandler == null)
    {
      QLog.e("ApolloGetActionUsedListVasHandler", 1, "[handleGetApolloActionUsedListNetworkRsp] baseHandler is null");
      return;
    }
    QQAppInterface localQQAppInterface = paramIApolloExtensionHandler.a();
    if (localQQAppInterface == null)
    {
      QLog.e("ApolloGetActionUsedListVasHandler", 1, "[handleGetApolloActionUsedListNetworkRsp] baseHandler.app is null");
      return;
    }
    if (paramIntent == null)
    {
      QLog.e("ApolloGetActionUsedListVasHandler", 1, "[handleGetApolloActionUsedListNetworkRsp] failed. request is null!");
      return;
    }
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()) || (paramArrayOfByte == null))
    {
      QLog.e("ApolloGetActionUsedListVasHandler", 1, "[handleGetApolloActionUsedListNetworkRsp] failed. no response data!");
      return;
    }
    int i;
    for (;;)
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        paramFromServiceMsg = (ApolloActionUsedManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloActionUsedManagerService.class, "all");
        paramArrayOfByte = new ApolloActionUsed.EmotionUsedRsp();
        paramArrayOfByte.mergeFrom(paramIntent.pbRsqData.get().toByteArray());
        paramIntent = paramArrayOfByte.emtps.get();
        if (a == -1)
        {
          i = 1;
          if ((paramIntent != null) && (paramIntent.size() >= 1)) {
            break;
          }
          QLog.e("ApolloGetActionUsedListVasHandler", 1, "[handleGetApolloActionUsedListNetworkRsp] actionUsedList is empty");
          return;
        }
      }
      catch (Exception paramIApolloExtensionHandler)
      {
        QLog.e("ApolloGetActionUsedListVasHandler", 1, "[handleGetApolloActionUsedListNetworkRsp] exception=", paramIApolloExtensionHandler);
        return;
      }
      i = 0;
    }
    Iterator localIterator = paramIntent.iterator();
    int j;
    if (localIterator.hasNext())
    {
      ApolloActionUsed.EmuTopo localEmuTopo = (ApolloActionUsed.EmuTopo)localIterator.next();
      Object localObject = localEmuTopo.emus.get();
      paramIntent = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramIntent.add(Integer.valueOf((int)((ApolloActionUsed.EmuInfo)((Iterator)localObject).next()).id.get()));
      }
      j = localEmuTopo.pkgid.get();
      if ((paramIntent != null) && (paramIntent.size() > 0))
      {
        if (paramIntent.size() <= 48) {
          break label398;
        }
        paramIntent = paramIntent.subList(0, 48);
      }
    }
    label398:
    for (;;)
    {
      paramFromServiceMsg.updateActionIdData(j, paramIntent);
      for (;;)
      {
        if (i != 0) {
          break label377;
        }
        ((BusinessHandler)paramIApolloExtensionHandler).notifyUI(38, true, new Object[] { Integer.valueOf(j), paramIntent });
        break;
        QLog.e("ApolloGetActionUsedListVasHandler", 1, "[handleGetApolloActionUsedListNetworkRsp] emtInfo is null");
      }
      label377:
      break;
      paramFromServiceMsg.saveApolloActionUsedRequestInterval(localQQAppInterface, paramArrayOfByte.refresh_cycle.get() * 1000L);
      return;
    }
  }
  
  public void a(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    b(paramIApolloExtensionHandler, paramIntent, paramFromServiceMsg, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.handler.ApolloGetActionUsedListVasHandler
 * JD-Core Version:    0.7.0.1
 */