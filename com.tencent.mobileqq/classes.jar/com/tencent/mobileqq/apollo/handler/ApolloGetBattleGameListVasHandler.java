package com.tencent.mobileqq.apollo.handler;

import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.handler.IVasExtensionHandler;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionServletImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBattleGameInfo;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import trpc.cmshow.game.OpenGameBox.StBoxItem;
import trpc.cmshow.game.OpenGameBox.StOpenGameBoxReq;
import trpc.cmshow.game.OpenGameBox.StOpenGameBoxRsp;
import trpc.cmshow.game.OpenGameBox.StScene;

public class ApolloGetBattleGameListVasHandler
  implements IVasExtensionHandler
{
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ApolloGetBattleGameListVasHandler", 1, "[getApolloBattleGameList] app is null");
    }
    do
    {
      return;
      if (paramInt < 0)
      {
        QLog.e("ApolloGetBattleGameListVasHandler", 1, "[getApolloBattleGameList] sceneIds is invalid: " + paramInt);
        return;
      }
      Object localObject2 = (IApolloDaoManagerService)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      Object localObject1 = null;
      try
      {
        localObject2 = ((IApolloDaoManagerService)localObject2).getBattleGameList(paramInt);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          boolean bool2;
          boolean bool3;
          QLog.e("ApolloGetBattleGameListVasHandler", 1, "[getApolloBattleGameList] failed! exception = " + localThrowable);
          continue;
          boolean bool1 = false;
        }
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        break;
      }
      bool1 = true;
      if (!bool1) {
        paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER).notifyUI(37, true, new Object[] { Integer.valueOf(paramInt), localObject1 });
      }
      bool2 = NetworkUtil.g(paramQQAppInterface.getApp());
      bool3 = ApolloUtilImpl.isApolloPanelCacheExpired(paramQQAppInterface, paramInt);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getApolloBattleGameList] sceneId = ").append(paramInt).append(", isDataEmpty = ").append(bool1).append(", isApolloPanelCacheExpired = ").append(bool3).append(", isNetworkAvailable = ").append(bool2);
      QLog.d("ApolloGetBattleGameListVasHandler", 1, new Object[] { localObject1 });
    } while (((!bool1) && (!bool3)) || (!bool2));
    b(paramQQAppInterface, paramInt);
  }
  
  private void b(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramIApolloExtensionHandler == null)
    {
      QLog.e("ApolloGetBattleGameListVasHandler", 1, "[handleGetApolloBattleGameListNetworkRsp] baseHandler is null");
      return;
    }
    QQAppInterface localQQAppInterface = paramIApolloExtensionHandler.a();
    if (localQQAppInterface == null)
    {
      QLog.e("ApolloGetBattleGameListVasHandler", 1, "[handleGetApolloBattleGameListNetworkRsp] baseHandler.app is null");
      return;
    }
    if (paramIntent == null)
    {
      QLog.e("ApolloGetBattleGameListVasHandler", 1, "[handleGetApolloBattleGameListNetworkRsp] failed. request is null!");
      return;
    }
    if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()) || (paramArrayOfByte == null))
    {
      QLog.e("ApolloGetBattleGameListVasHandler", 1, "[handleGetApolloBattleGameListNetworkRsp] failed. no response data!");
      return;
    }
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      paramFromServiceMsg = new OpenGameBox.StOpenGameBoxRsp();
      paramFromServiceMsg.mergeFrom(paramIntent.pbRsqData.get().toByteArray());
      paramIntent = paramFromServiceMsg.scenes.get();
      if ((paramIntent == null) || (paramIntent.size() < 1))
      {
        QLog.e("ApolloGetBattleGameListVasHandler", 1, "[handleGetApolloBattleGameListNetworkRsp] stSceneList is empty");
        return;
      }
    }
    catch (Exception paramIApolloExtensionHandler)
    {
      QLog.e("ApolloGetBattleGameListVasHandler", 1, "[handleGetApolloBattleGameListNetworkRsp] exception=", paramIApolloExtensionHandler);
      return;
    }
    paramIntent = (OpenGameBox.StScene)paramIntent.get(0);
    if (paramIntent != null)
    {
      int i = paramIntent.scene_id.get();
      paramFromServiceMsg = new ArrayList();
      paramArrayOfByte = paramIntent.items.get().iterator();
      while (paramArrayOfByte.hasNext()) {
        paramFromServiceMsg.add(ApolloBattleGameInfo.mergeFrom(i, (OpenGameBox.StBoxItem)paramArrayOfByte.next()));
      }
      if (paramFromServiceMsg.size() > 0)
      {
        ((IApolloDaoManagerService)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).updateBattleGameInfo(i, paramFromServiceMsg);
        ((BusinessHandler)paramIApolloExtensionHandler).notifyUI(37, true, new Object[] { Integer.valueOf(i), paramFromServiceMsg });
      }
      ApolloUtilImpl.saveApolloPanelBattleGameRequestInterval(localQQAppInterface, i, paramIntent.refresh_interval.get() * 1000L);
      return;
    }
    QLog.e("ApolloGetBattleGameListVasHandler", 1, "[handleGetApolloBattleGameListNetworkRsp] stScene is null");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt < 0)
    {
      QLog.e("ApolloGetBattleGameListVasHandler", 1, "[getApolloBattleGameListReqFromNetwork] invalid sceneId " + paramInt);
      return;
    }
    if (paramQQAppInterface == null)
    {
      QLog.e("ApolloGetBattleGameListVasHandler", 1, "[getApolloBattleGameListReqFromNetwork] app is null. sceneId = " + paramInt);
      return;
    }
    try
    {
      QLog.d("ApolloGetBattleGameListVasHandler", 1, "[getApolloBattleGameListReqFromNetwork] sceneId = " + paramInt);
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new OpenGameBox.StOpenGameBoxReq();
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(Integer.valueOf(paramInt));
      ((OpenGameBox.StOpenGameBoxReq)localObject).scene_ids.set(localArrayList);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((OpenGameBox.StOpenGameBoxReq)localObject).toByteArray()));
      localObject = new NewIntent(paramQQAppInterface.getApp(), ApolloExtensionServletImpl.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_light.cmshow_game_linkcmd_open_game_box");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("scene", paramInt);
      paramQQAppInterface.startServlet((NewIntent)localObject);
      ApolloUtilImpl.saveApolloPanelBattleGameLastRequestTime(paramQQAppInterface, paramInt, System.currentTimeMillis());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGetBattleGameListVasHandler", 1, "[getApolloBattleGameListReqFromNetwork] sceneId = " + paramInt + ", exception = ", paramQQAppInterface);
    }
  }
  
  public void a(IApolloExtensionHandler paramIApolloExtensionHandler, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    b(paramIApolloExtensionHandler, paramIntent, paramFromServiceMsg, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloGetBattleGameListVasHandler
 * JD-Core Version:    0.7.0.1
 */