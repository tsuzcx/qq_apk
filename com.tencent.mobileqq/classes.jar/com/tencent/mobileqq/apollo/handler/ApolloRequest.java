package com.tencent.mobileqq.apollo.handler;

import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.utils.api.IApolloClassFactory;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.apolloactionused.ApolloActionUsed.EmotionUsedReq;
import com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.QQUsrImgReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import trpc.cmshow.game.OpenGameBox.StOpenGameBoxReq;

public class ApolloRequest
{
  public static int a;
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    if (paramAppInterface == null)
    {
      QLog.e("[cmshow]ApolloRequest", 1, "[getApolloBattleGameList] app is null");
      return;
    }
    if (paramInt < 0)
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("[getApolloBattleGameList] sceneIds is invalid: ");
      paramAppInterface.append(paramInt);
      QLog.e("[cmshow]ApolloRequest", 1, paramAppInterface.toString());
      return;
    }
    Object localObject2 = (IApolloDaoManagerService)paramAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject1 = null;
    try
    {
      localObject2 = ((IApolloDaoManagerService)localObject2).getBattleGameList(paramInt);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getApolloBattleGameList] failed! exception = ");
      localStringBuilder.append(localThrowable);
      QLog.e("[cmshow]ApolloRequest", 1, localStringBuilder.toString());
    }
    boolean bool1;
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (!bool1) {
      paramAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER).notifyUI(37, true, new Object[] { Integer.valueOf(paramInt), localObject1 });
    }
    boolean bool2 = NetworkUtil.isNetworkAvailable(paramAppInterface.getApp());
    boolean bool3 = ApolloUtilImpl.isApolloPanelCacheExpired(paramAppInterface, paramInt);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[getApolloBattleGameList] sceneId = ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", isDataEmpty = ");
    ((StringBuilder)localObject1).append(bool1);
    ((StringBuilder)localObject1).append(", isApolloPanelCacheExpired = ");
    ((StringBuilder)localObject1).append(bool3);
    ((StringBuilder)localObject1).append(", isNetworkAvailable = ");
    ((StringBuilder)localObject1).append(bool2);
    QLog.d("[cmshow]ApolloRequest", 1, new Object[] { localObject1 });
    if (((bool1) || (bool3)) && (bool2)) {
      b(paramAppInterface, paramInt);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramAppRuntime == null)
    {
      QLog.e("[cmshow]ApolloRequest", 1, "[getApolloActionUsedList] app is null.");
      return;
    }
    a = paramInt;
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new ApolloActionUsed.EmotionUsedReq();
      ((ApolloActionUsed.EmotionUsedReq)localObject).uin.set(Long.parseLong(paramAppRuntime.getCurrentUin()));
      ((ApolloActionUsed.EmotionUsedReq)localObject).pkgid.set(paramInt);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((ApolloActionUsed.EmotionUsedReq)localObject).toByteArray()));
      localObject = new NewIntent(paramAppRuntime.getApp(), ApolloExtensionServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_light.apollo_emotionsvr_linkcmd_emotionused");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      paramAppRuntime.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("[cmshow]ApolloRequest", 1, "[getApolloActionUsedList] exception=", paramAppRuntime);
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, long paramLong)
  {
    if (paramLong < 0L)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("[getApolloAvatarData] invalid avatarType ");
      paramAppRuntime.append(paramLong);
      QLog.e("[cmshow]ApolloRequest", 1, paramAppRuntime.toString());
      return;
    }
    if (paramAppRuntime == null)
    {
      QLog.e("[cmshow]ApolloRequest", 1, "[getApolloAvatarData] app is null.");
      return;
    }
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getApolloAvatarData] avatarType = ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("[cmshow]ApolloRequest", 1, ((StringBuilder)localObject1).toString());
      Object localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.8.17");
      localObject1 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
      localObject2 = new ApolloQQUsrImg.QQUsrImgReq();
      ((ApolloQQUsrImg.QQUsrImgReq)localObject2).uin.set(Long.parseLong(paramAppRuntime.getCurrentUin()));
      ((ApolloQQUsrImg.QQUsrImgReq)localObject2).type.set(paramLong);
      ((WebSSOAgent.UniSsoServerReq)localObject1).pbReqData.set(ByteStringMicro.copyFrom(((ApolloQQUsrImg.QQUsrImgReq)localObject2).toByteArray()));
      localObject2 = new NewIntent(paramAppRuntime.getApp(), ((IApolloClassFactory)QRoute.api(IApolloClassFactory.class)).getApolloExtensionServletClass());
      ((NewIntent)localObject2).putExtra("cmd", "apollo_router_light.apollo_imglogic_linkcmd_get_avatars");
      ((NewIntent)localObject2).putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
      paramAppRuntime.startServlet((NewIntent)localObject2);
      return;
    }
    catch (Exception paramAppRuntime)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getApolloAvatarData] avatarType = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(", exception = ");
      QLog.e("[cmshow]ApolloRequest", 1, ((StringBuilder)localObject1).toString(), paramAppRuntime);
    }
  }
  
  private static void b(AppRuntime paramAppRuntime, int paramInt)
  {
    if (paramInt < 0)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("[getApolloBattleGameListReqFromNetwork] invalid sceneId ");
      paramAppRuntime.append(paramInt);
      QLog.e("[cmshow]ApolloRequest", 1, paramAppRuntime.toString());
      return;
    }
    if (paramAppRuntime == null)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("[getApolloBattleGameListReqFromNetwork] app is null. sceneId = ");
      paramAppRuntime.append(paramInt);
      QLog.e("[cmshow]ApolloRequest", 1, paramAppRuntime.toString());
      return;
    }
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getApolloBattleGameListReqFromNetwork] sceneId = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("[cmshow]ApolloRequest", 1, ((StringBuilder)localObject1).toString());
      Object localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.8.17");
      localObject1 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
      localObject2 = new OpenGameBox.StOpenGameBoxReq();
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(Integer.valueOf(paramInt));
      ((OpenGameBox.StOpenGameBoxReq)localObject2).scene_ids.set(localArrayList);
      ((WebSSOAgent.UniSsoServerReq)localObject1).pbReqData.set(ByteStringMicro.copyFrom(((OpenGameBox.StOpenGameBoxReq)localObject2).toByteArray()));
      localObject2 = new NewIntent(paramAppRuntime.getApp(), ApolloExtensionServlet.class);
      ((NewIntent)localObject2).putExtra("cmd", "apollo_router_light.cmshow_game_linkcmd_open_game_box");
      ((NewIntent)localObject2).putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
      ((NewIntent)localObject2).putExtra("scene", paramInt);
      paramAppRuntime.startServlet((NewIntent)localObject2);
      ApolloUtilImpl.saveApolloPanelBattleGameLastRequestTime(paramAppRuntime, paramInt, System.currentTimeMillis());
      return;
    }
    catch (Exception paramAppRuntime)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[getApolloBattleGameListReqFromNetwork] sceneId = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", exception = ");
      QLog.e("[cmshow]ApolloRequest", 1, ((StringBuilder)localObject1).toString(), paramAppRuntime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.ApolloRequest
 * JD-Core Version:    0.7.0.1
 */