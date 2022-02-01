package com.tencent.mobileqq.apollo.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.game.CmGameAudioManager;
import com.tencent.mobileqq.apollo.game.CmGameConnManager;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.game.process.data.CmGameLifeCycle;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.ApolloPandora;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportReceiver;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.RequestParams;
import com.tencent.mobileqq.emosm.web.RequestRoute;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public class CmShowWebIPCModule
{
  private void a(MessengerService paramMessengerService, QQAppInterface paramQQAppInterface, Bundle paramBundle1, Bundle paramBundle2, StartCheckParam paramStartCheckParam)
  {
    if ((paramMessengerService != null) && (paramQQAppInterface != null) && (paramBundle1 != null) && (paramBundle2 != null))
    {
      if (paramStartCheckParam == null) {
        return;
      }
      if (paramStartCheckParam.gameId != 1000) {
        return;
      }
      b(paramMessengerService, paramQQAppInterface, paramBundle1, paramBundle2, paramStartCheckParam);
      paramBundle2.putInt("result", 0);
      paramBundle1.putBundle("response", paramBundle2);
      paramMessengerService.a(paramBundle1);
    }
  }
  
  private void b(@NonNull MessengerService paramMessengerService, @NonNull QQAppInterface paramQQAppInterface, @NonNull Bundle paramBundle1, @NonNull Bundle paramBundle2, @NonNull StartCheckParam paramStartCheckParam)
  {
    ApolloGameData localApolloGameData = ((IApolloDaoManagerService)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(paramStartCheckParam.gameId);
    if (localApolloGameData == null)
    {
      paramBundle2.putInt("result", 1);
      paramBundle1.putBundle("response", paramBundle2);
      paramMessengerService.a(paramBundle1);
      return;
    }
    paramMessengerService = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    paramStartCheckParam.game = localApolloGameData;
    paramStartCheckParam.startT = System.currentTimeMillis();
    paramStartCheckParam.version = paramMessengerService.getApolloGameLocalVersion(paramStartCheckParam.gameId);
    paramMessengerService = CmGameServerQIPCModule.a().a(paramStartCheckParam.gameId);
    paramQQAppInterface = ApolloGameUtil.a();
    if (paramMessengerService != null) {
      paramMessengerService.a(paramQQAppInterface, paramStartCheckParam);
    }
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      try
      {
        paramMessengerService = BaseApplicationImpl.getContext();
        paramMessengerService = new Intent(paramMessengerService, ApolloWebGameActivity.class);
        paramMessengerService.setFlags(196608);
        paramMessengerService.putExtra("extra_startcheckparam", paramStartCheckParam);
        paramQQAppInterface.startActivity(paramMessengerService);
        return;
      }
      catch (Exception paramMessengerService)
      {
        QLog.e("[cmshow]CmShowHandler", 1, "[startIsland] exception=", paramMessengerService);
        return;
      }
      paramMessengerService = paramQQAppInterface;
    }
  }
  
  @RequestRoute(a="ipc_apollo_add_cm_face")
  public void addCmFace(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    QQAppInterface localQQAppInterface = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = localBundle.getBundle("request").getString("faceIdList");
    paramRequestParams = new Bundle();
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = new JSONArray((String)localObject1);
        if (((JSONArray)localObject2).length() > 0)
        {
          localObject1 = new ArrayList();
          ArrayList localArrayList = ApolloUtilImpl.getAddedFaceList(localQQAppInterface);
          int j = ((JSONArray)localObject2).length();
          i = 0;
          if (i < j)
          {
            int k = QQSysFaceUtil.convertToLocal(((JSONArray)localObject2).getInt(i));
            if (!com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(k)) {
              break label541;
            }
            ((ArrayList)localObject1).add(Integer.valueOf(k));
            if ((localArrayList == null) || (!localArrayList.contains(Integer.valueOf(k)))) {
              break label541;
            }
            k = localArrayList.indexOf(Integer.valueOf(k));
            if (k == -1) {
              break label541;
            }
            localArrayList.remove(k);
            break label541;
          }
          if (((ArrayList)localObject1).size() > 0) {
            if (localQQAppInterface != null)
            {
              localObject2 = (ICommonUsedSystemEmojiManagerService)localQQAppInterface.getRuntimeService(ICommonUsedSystemEmojiManagerService.class);
              if (localObject2 != null)
              {
                Iterator localIterator = ((ArrayList)localObject1).iterator();
                if (localIterator.hasNext())
                {
                  Integer localInteger = (Integer)localIterator.next();
                  EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
                  localSmallYellowItem.id.set(localInteger.intValue());
                  localSmallYellowItem.type.set(1);
                  localSmallYellowItem.ts.set(System.currentTimeMillis());
                  ((ICommonUsedSystemEmojiManagerService)localObject2).saveSystemEmojiInfoToCahce(localSmallYellowItem);
                  continue;
                }
                ((ICommonUsedSystemEmojiManagerService)localObject2).saveSystemEmojiInfoToFile();
                localObject2 = localQQAppInterface.getHandler(ChatActivity.class);
                if (localObject2 != null) {
                  ((MqqHandler)localObject2).obtainMessage(10).sendToTarget();
                }
                paramRequestParams.putInt("result", 0);
                paramRequestParams.putString("msg", HardCodeUtil.a(2131706700));
                if ((localArrayList != null) && (localArrayList.size() > 0)) {
                  ((ArrayList)localObject1).addAll(localArrayList);
                }
                ApolloUtilImpl.saveAddedFaceList(localQQAppInterface, (ArrayList)localObject1);
              }
              else
              {
                paramRequestParams.putInt("result", 1);
                paramRequestParams.putString("msg", HardCodeUtil.a(2131706717));
              }
            }
            else
            {
              paramRequestParams.putInt("result", 1);
              paramRequestParams.putString("msg", HardCodeUtil.a(2131706713));
            }
          }
        }
        else
        {
          paramRequestParams.putInt("result", 1);
          paramRequestParams.putString("msg", HardCodeUtil.a(2131706716));
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]CmShowHandler", 1, "IPC_APOLLO_ADD_CM_FACE, exception=", localException);
        paramRequestParams.putInt("result", 1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131706707));
        ((StringBuilder)localObject1).append(localException.getMessage());
        paramRequestParams.putString("msg", ((StringBuilder)localObject1).toString());
      }
      paramRequestParams.putInt("result", 1);
      paramRequestParams.putString("msg", HardCodeUtil.a(2131706718));
      localBundle.putBundle("response", paramRequestParams);
      localMessengerService.a(localBundle);
      return;
      label541:
      i += 1;
    }
  }
  
  @RequestRoute(a="ipc_apollo_add_fav_action")
  public void addFavAction(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Bundle localBundle2 = localBundle1.getBundle("request");
    ThreadManager.post(new CmShowWebIPCModule.10(this, paramRequestParams, localBundle2.getInt("actionId"), localBundle2.getString("actionText"), localBundle2.getInt("textType"), localBundle2.getInt("audioId"), localBundle2.getInt("playOriginalAudio"), localBundle2.getFloat("audioStartTime"), localBundle1, localMessengerService), 5, null, false);
  }
  
  @RequestRoute(a="ipc_apollo_clear_bubble")
  public void apolloClearBubble(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l = localBundle.getBundle("request").getLong("bubble_id");
    paramRequestParams = (ApolloDaoManagerServiceImpl)paramRequestParams.getRuntimeService(IApolloDaoManagerService.class, "all");
    if (l == 0L)
    {
      paramRequestParams.removeAllS2CPushItem();
      return;
    }
    paramRequestParams.clearBubble(String.valueOf(l));
  }
  
  @RequestRoute(a="ipc_apollo_changerole")
  public void changeRole(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    QQAppInterface localQQAppInterface = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramRequestParams = localBundle2.getIntArray("apollo_dressIds");
    int j = localBundle2.getInt("apollo_roleId");
    int k = localBundle2.getInt("apollo_fromSelf");
    if (j > 0)
    {
      if (k != 1) {
        ApolloBaseInfo.saveSelfApolloDress(localQQAppInterface, localBundle2.getString("apollo_userData"));
      }
      if ((j > 0) && (paramRequestParams != null) && (paramRequestParams.length > 0))
      {
        boolean bool1 = CMResUtil.b(j);
        int m = paramRequestParams.length;
        int i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (i >= m) {
            break;
          }
          int n = paramRequestParams[i];
          if ((bool1) && (CMResUtil.a(n))) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          i += 1;
        }
      }
      boolean bool2 = false;
      if (bool2)
      {
        localBundle2 = new Bundle();
        localBundle2.putInt("apollo_result", 0);
        localBundle2.putInt("apollo_roleId", j);
        localBundle2.putInt("apollo_fromSelf", k);
        localBundle2.putIntArray("apollo_dressIds", paramRequestParams);
        localBundle1.putBundle("response", localBundle2);
        localMessengerService.a(localBundle1);
        return;
      }
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), new CmShowWebIPCModule.7(this, k, localBundle1, localMessengerService), j, paramRequestParams, -1, -1, false);
      return;
    }
    paramRequestParams = new Bundle();
    paramRequestParams.putInt("apollo_result", 1);
    paramRequestParams.putInt("apollo_fromSelf", k);
    localBundle1.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle1);
  }
  
  @RequestRoute(a="ipc_apollo_check_action")
  public void checkAction(@NonNull RequestParams paramRequestParams)
  {
    ApolloContentUpdateHandler.a(paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmShowHandler", 2, "ipc call check_action");
    }
  }
  
  @RequestRoute(a="ipc_apollo_check_avatar_res")
  public void checkAvatarRes(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject1 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmShowHandler", 2, "IPC_APOLLO_CHECK_AVATAR_RES");
    }
    ArrayList localArrayList = (ArrayList)localBundle2.getSerializable("apolloList");
    if ((localArrayList != null) && (localArrayList.size() != 0))
    {
      int j = localBundle2.getInt("from");
      paramRequestParams = localArrayList.iterator();
      while (paramRequestParams.hasNext())
      {
        ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)paramRequestParams.next();
        if (android.text.TextUtils.isEmpty(localApolloWebAvatarParam.uin))
        {
          paramRequestParams = new Bundle();
          paramRequestParams.putInt("result", 1);
          paramRequestParams.putString("msg", "uin为空");
          localBundle1.putBundle("response", paramRequestParams);
          localMessengerService.a(localBundle1);
          return;
        }
        Object localObject2;
        Object localObject3;
        if ((localApolloWebAvatarParam.roleId > 0) && (localApolloWebAvatarParam.dressIds != null) && (localApolloWebAvatarParam.dressIds.length > 0))
        {
          localObject2 = (IApolloManagerService)((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
          localObject3 = ((IApolloDaoManagerService)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(localApolloWebAvatarParam.uin);
          if ((localObject3 != null) && (((ApolloBaseInfo)localObject3).getApolloDress() == null)) {
            ((IApolloManagerService)localObject2).addToBulkPullMap(localApolloWebAvatarParam.uin, 2);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]CmShowHandler", 2, "IPC_APOLLO_CHECK_AVATAR_RES, roleId=0 or no dressIds");
          }
          localObject2 = (IApolloManagerService)((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
          localObject3 = ((IApolloDaoManagerService)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(localApolloWebAvatarParam.uin);
          if (localObject3 != null)
          {
            localObject3 = ((ApolloBaseInfo)localObject3).getApolloDress();
            if (localObject3 != null)
            {
              localApolloWebAvatarParam.roleId = ((ApolloDress)localObject3).roleId;
              localApolloWebAvatarParam.dressIds = ((ApolloDress)localObject3).getDressIds();
            }
            else
            {
              ((IApolloManagerService)localObject2).addToBulkPullMap(localApolloWebAvatarParam.uin, 2);
            }
          }
          int i;
          if (localApolloWebAvatarParam.roleId == 0)
          {
            localObject2 = ((FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localApolloWebAvatarParam.uin);
            if (localObject2 != null)
            {
              if ((((Friends)localObject2).gender != 1) && (((Friends)localObject2).gender != 0)) {
                i = 2;
              } else {
                i = 1;
              }
              localApolloWebAvatarParam.roleId = i;
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]CmShowHandler", 2, new Object[] { "IPC_APOLLO_CHECK_AVATAR_RES, roleId=", Integer.valueOf(localApolloWebAvatarParam.roleId), ", apolloId=", localApolloWebAvatarParam.apolloId });
              }
            }
          }
          if ((localApolloWebAvatarParam.roleId > 0) && (localApolloWebAvatarParam.dressIds != null) && (localApolloWebAvatarParam.dressIds.length > 0))
          {
            boolean bool = CMResUtil.b(localApolloWebAvatarParam.roleId);
            localObject2 = localApolloWebAvatarParam.dressIds;
            int k = localObject2.length;
            i = 0;
            while (i < k)
            {
              int m = localObject2[i];
              if ((bool) && (CMResUtil.a(m))) {
                bool = true;
              } else {
                bool = false;
              }
              i += 1;
            }
            localApolloWebAvatarParam.isResExist = bool;
          }
        }
      }
      paramRequestParams = new Bundle();
      localObject1 = localBundle2.getString("reqUrl");
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        paramRequestParams.putString("reqUrl", (String)localObject1);
      }
      paramRequestParams.putInt("result", 0);
      paramRequestParams.putInt("from", j);
      paramRequestParams.putSerializable("apolloList", localArrayList);
      localBundle1.putBundle("response", paramRequestParams);
      localMessengerService.a(localBundle1);
      return;
    }
    QLog.e("[cmshow]CmShowHandler", 1, "IPC_APOLLO_CHECK_AVATAR_RES, no avatar params");
    paramRequestParams = new Bundle();
    paramRequestParams.putInt("result", 1);
    paramRequestParams.putString("msg", HardCodeUtil.a(2131706714));
    localBundle1.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle1);
  }
  
  @RequestRoute(a="ipc_apollo_clean_mine_redtouch")
  public void cleanMineRedTouch(@NonNull RequestParams paramRequestParams)
  {
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramRequestParams == null) {
      return;
    }
    ((IRedTouchManager)paramRequestParams.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("103100.103200.103201.103204");
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmShowHandler", 2, "IPC_APOLLO_CLEAN_MINE_REDTOUCH cmd get");
    }
  }
  
  @RequestRoute(a="ipc_cm_game_conn_connected")
  public void cmGameConnConnected(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn", 2, "IPC_CM_GAME_CONN_CONNECTED");
    }
    boolean bool = ((ApolloGameManagerImpl)paramRequestParams.getRuntimeService(IApolloGameManager.class, "all")).getCmGameConnManager().a();
    paramRequestParams = new Bundle();
    paramRequestParams.putInt("result", 0);
    paramRequestParams.putBoolean("isConnected", bool);
    localBundle.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle);
  }
  
  @RequestRoute(a="ipc_cm_game_match_page_report_status")
  public void cmGameMatchPageReportStatus(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localBundle = localBundle.getBundle("request");
    boolean bool1 = localBundle.getBoolean("isAlive");
    boolean bool2 = localBundle.getBoolean("wakeup");
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn", 2, new Object[] { "IPC_CM_GAME_MATCH_PAGE_REPORT_STATUS, isAlive=", Boolean.valueOf(bool1), ", wakeup=", Boolean.valueOf(bool2) });
    }
    ((ApolloGameManagerImpl)paramRequestParams.getRuntimeService(IApolloGameManager.class, "all")).getCmGameConnManager().a(bool1, bool2);
  }
  
  @RequestRoute(a="ipc_trace_report")
  public void cmsTraceReport(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramRequestParams = localBundle.getBundle("request");
    TraceReportReceiver.a(paramRequestParams.getString("action"), paramRequestParams);
  }
  
  @RequestRoute(a="ipc_apollo_del_fav_action")
  public void delFavAction(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Bundle localBundle2 = localBundle1.getBundle("request");
    int i = localBundle2.getInt("actionId");
    ThreadManager.post(new CmShowWebIPCModule.11(this, paramRequestParams, localBundle2.getLong("seq"), i, localBundle1, localMessengerService), 5, null, false);
  }
  
  @RequestRoute(a="ipc_apollo_del_fav_list")
  public void delFavList(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManager.post(new CmShowWebIPCModule.12(this, paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle.getBundle("request").getString("delJson"), localBundle, localMessengerService), 5, null, false);
  }
  
  @RequestRoute(a="IPC_APOLLO_DOWNLOAD_GAME")
  public void downloadGame(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = localBundle.getBundle("request").getInt("gameId");
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
    paramRequestParams = new StartCheckParam(i, false, "check", 0L, 4, 1, 0, 0, "", 0, null);
    localObject = ((IApolloDaoManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(i);
    if (localObject != null)
    {
      paramRequestParams.game = ((ApolloGameData)localObject);
    }
    else
    {
      localObject = paramRequestParams;
      ((StartCheckParam)localObject).game = new ApolloGameData();
      ((StartCheckParam)localObject).game.gameId = i;
    }
    paramRequestParams.version = localIApolloManagerService.getApolloGameLocalVersion(paramRequestParams.game.gameId);
    localObject = new Bundle();
    ((Bundle)localObject).putSerializable("StartCheckParam", paramRequestParams);
    localBundle.putBundle("response", (Bundle)localObject);
    localMessengerService.a(localBundle);
  }
  
  @RequestRoute(a="ipc_apollo_downloadImageOnFrame")
  public void downloadIPC(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramRequestParams.b;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Bundle localBundle3 = new Bundle();
    localBundle3.putInt("apollo_previewAction", localBundle2.getInt("apollo_previewAction"));
    localBundle1.putBundle("response", localBundle3);
    paramRequestParams.a(localBundle1);
  }
  
  @RequestRoute(a="ipc_apollo_get_apollo_data")
  public void getApolloData(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    QQAppInterface localQQAppInterface = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int m = 1;
    ApolloContentUpdateHandler.a(localQQAppInterface, 1);
    paramRequestParams = ((IApolloDaoManagerService)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(localQQAppInterface.getCurrentAccountUin());
    if (paramRequestParams != null)
    {
      j = paramRequestParams.apolloStatus;
      ApolloDress localApolloDress = paramRequestParams.getApolloDress();
      if (localApolloDress != null)
      {
        k = localApolloDress.roleId;
        i = localApolloDress.mRoleGender;
        paramRequestParams = localApolloDress.getDressIds();
        boolean bool = localApolloDress.isAIRole;
        break label117;
      }
    }
    else
    {
      j = 0;
    }
    paramRequestParams = null;
    int k = 0;
    int i = 0;
    label117:
    int n = localBundle2.getInt("apollo_initFrom");
    localBundle2 = new Bundle();
    localBundle2.putInt("apollo_result", 0);
    localBundle2.putInt("apollo_initFrom", n);
    localBundle2.putInt("apollo_roleId", k);
    localBundle2.putIntArray("apollo_dressIds", paramRequestParams);
    localBundle2.putInt("apollo_apolloStatus", j);
    int j = m;
    if (k == 0)
    {
      paramRequestParams = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localQQAppInterface.getCurrentAccountUin());
      j = m;
      if (paramRequestParams != null) {
        j = paramRequestParams.gender;
      }
    }
    k = i;
    if (i == 0) {
      k = j;
    }
    localBundle2.putInt("apollo_roleGender", k);
    localBundle2.putInt("apollo_gender", j);
    localBundle1.putBundle("response", localBundle2);
    localMessengerService.a(localBundle1);
  }
  
  @RequestRoute(a="ipc_apollo_getfav_action")
  public void getFavAction(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManager.post(new CmShowWebIPCModule.9(this, paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle, localMessengerService), 5, null, true);
  }
  
  /* Error */
  @RequestRoute(a="ipc_apollo_get_openapollo_friends")
  public void getOpenApolloFriends(@NonNull RequestParams paramRequestParams)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 152	com/tencent/mobileqq/emosm/web/RequestParams:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   4: astore 5
    //   6: aload_1
    //   7: getfield 155	com/tencent/mobileqq/emosm/web/RequestParams:jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   10: astore 6
    //   12: aload_1
    //   13: getfield 158	com/tencent/mobileqq/emosm/web/RequestParams:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   16: astore 7
    //   18: aload 7
    //   20: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   23: ifeq +372 -> 395
    //   26: aload 7
    //   28: invokevirtual 698	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   31: invokevirtual 704	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   34: iconst_1
    //   35: ldc_w 706
    //   38: iconst_1
    //   39: anewarray 393	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc_w 707
    //   47: aastore
    //   48: ldc_w 709
    //   51: iconst_1
    //   52: anewarray 393	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: ldc_w 711
    //   60: aastore
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: invokevirtual 717	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull +310 -> 380
    //   73: aload_1
    //   74: invokeinterface 722 1 0
    //   79: ifeq +301 -> 380
    //   82: aload 7
    //   84: getstatic 520	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   87: invokevirtual 524	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   90: checkcast 526	com/tencent/mobileqq/app/FriendsManager
    //   93: astore 8
    //   95: aload_1
    //   96: ldc_w 707
    //   99: invokeinterface 725 2 0
    //   104: istore 4
    //   106: iload 4
    //   108: iflt +254 -> 362
    //   111: new 179	org/json/JSONArray
    //   114: dup
    //   115: invokespecial 726	org/json/JSONArray:<init>	()V
    //   118: astore 7
    //   120: iconst_0
    //   121: istore_2
    //   122: aload_1
    //   123: iload 4
    //   125: invokeinterface 728 2 0
    //   130: astore 9
    //   132: aload 8
    //   134: aload 9
    //   136: invokevirtual 529	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   139: astore 10
    //   141: iload_2
    //   142: istore_3
    //   143: aload 10
    //   145: ifnull +275 -> 420
    //   148: iload_2
    //   149: istore_3
    //   150: aload 10
    //   152: invokevirtual 731	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   155: ifeq +265 -> 420
    //   158: new 733	org/json/JSONObject
    //   161: dup
    //   162: invokespecial 734	org/json/JSONObject:<init>	()V
    //   165: astore 11
    //   167: aload 11
    //   169: ldc_w 707
    //   172: aload 9
    //   174: invokevirtual 738	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   177: pop
    //   178: aload 11
    //   180: ldc_w 740
    //   183: aload 10
    //   185: getfield 743	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   188: invokevirtual 738	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   191: pop
    //   192: aload 7
    //   194: aload 11
    //   196: invokevirtual 746	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   199: pop
    //   200: iload_2
    //   201: iconst_1
    //   202: iadd
    //   203: istore_3
    //   204: goto +216 -> 420
    //   207: iload_3
    //   208: istore_2
    //   209: aload_1
    //   210: invokeinterface 749 1 0
    //   215: ifne -93 -> 122
    //   218: new 28	android/os/Bundle
    //   221: dup
    //   222: invokespecial 171	android/os/Bundle:<init>	()V
    //   225: astore 8
    //   227: aload 8
    //   229: ldc_w 429
    //   232: iconst_0
    //   233: invokevirtual 32	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   236: new 733	org/json/JSONObject
    //   239: dup
    //   240: invokespecial 734	org/json/JSONObject:<init>	()V
    //   243: astore 9
    //   245: aload 9
    //   247: ldc_w 751
    //   250: aload 7
    //   252: invokevirtual 738	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload 8
    //   258: ldc_w 753
    //   261: aload 9
    //   263: invokevirtual 754	org/json/JSONObject:toString	()Ljava/lang/String;
    //   266: invokevirtual 316	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: aload 5
    //   271: ldc 34
    //   273: aload 8
    //   275: invokevirtual 38	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   278: aload 6
    //   280: aload 5
    //   282: invokevirtual 43	com/tencent/mobileqq/emosm/web/MessengerService:a	(Landroid/os/Bundle;)V
    //   285: invokestatic 463	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +43 -> 331
    //   291: new 331	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 332	java/lang/StringBuilder:<init>	()V
    //   298: astore 6
    //   300: aload 6
    //   302: ldc_w 756
    //   305: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 6
    //   311: aload 7
    //   313: invokevirtual 757	org/json/JSONArray:toString	()Ljava/lang/String;
    //   316: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: ldc 134
    //   322: iconst_2
    //   323: aload 6
    //   325: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 469	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: aload_1
    //   332: invokeinterface 760 1 0
    //   337: return
    //   338: astore 5
    //   340: goto +31 -> 371
    //   343: astore 6
    //   345: invokestatic 463	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +14 -> 362
    //   351: ldc 134
    //   353: iconst_2
    //   354: aload 6
    //   356: invokevirtual 341	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   359: invokestatic 763	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload_1
    //   363: invokeinterface 760 1 0
    //   368: goto +27 -> 395
    //   371: aload_1
    //   372: invokeinterface 760 1 0
    //   377: aload 5
    //   379: athrow
    //   380: invokestatic 463	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +12 -> 395
    //   386: ldc 134
    //   388: iconst_2
    //   389: ldc_w 765
    //   392: invokestatic 469	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: new 28	android/os/Bundle
    //   398: dup
    //   399: invokespecial 171	android/os/Bundle:<init>	()V
    //   402: astore_1
    //   403: aload_1
    //   404: ldc_w 429
    //   407: iconst_1
    //   408: invokevirtual 32	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   411: aload 5
    //   413: ldc 34
    //   415: aload_1
    //   416: invokevirtual 38	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   419: return
    //   420: iload_3
    //   421: bipush 10
    //   423: if_icmplt -216 -> 207
    //   426: goto -208 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	CmShowWebIPCModule
    //   0	429	1	paramRequestParams	RequestParams
    //   121	88	2	i	int
    //   142	282	3	j	int
    //   104	20	4	k	int
    //   4	277	5	localBundle	Bundle
    //   338	74	5	localObject1	Object
    //   10	314	6	localObject2	Object
    //   343	12	6	localException	Exception
    //   16	296	7	localObject3	Object
    //   93	181	8	localObject4	Object
    //   130	132	9	localObject5	Object
    //   139	45	10	localFriends	Friends
    //   165	30	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   82	106	338	finally
    //   111	120	338	finally
    //   122	141	338	finally
    //   150	200	338	finally
    //   209	218	338	finally
    //   218	331	338	finally
    //   345	362	338	finally
    //   82	106	343	java/lang/Exception
    //   111	120	343	java/lang/Exception
    //   122	141	343	java/lang/Exception
    //   150	200	343	java/lang/Exception
    //   209	218	343	java/lang/Exception
    //   218	331	343	java/lang/Exception
  }
  
  @RequestRoute(a="ipc_apollo_is_cm_face_added")
  public void isCmFaceAdded(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject3 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = localBundle.getBundle("request").getString("faceIdList");
    paramRequestParams = new Bundle();
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if (((JSONArray)localObject1).length() > 0)
        {
          localObject2 = new JSONArray();
          localObject3 = ApolloUtilImpl.getAddedFaceList((QQAppInterface)localObject3);
          int j = ((JSONArray)localObject1).length();
          int i = 0;
          while (i < j)
          {
            int k = ((JSONArray)localObject1).getInt(i);
            JSONObject localJSONObject = new JSONObject();
            int m = QQSysFaceUtil.convertToLocal(k);
            boolean bool = com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(m);
            if (bool)
            {
              if ((localObject3 != null) && (((ArrayList)localObject3).contains(Integer.valueOf(m))))
              {
                localJSONObject.put("id", k);
                localJSONObject.put("status", 2);
              }
              else
              {
                localJSONObject.put("id", k);
                localJSONObject.put("status", 1);
              }
            }
            else
            {
              localJSONObject.put("id", k);
              localJSONObject.put("status", 0);
            }
            ((JSONArray)localObject2).put(i, localJSONObject);
            i += 1;
          }
          paramRequestParams.putInt("result", 0);
          paramRequestParams.putString("status", ((JSONArray)localObject2).toString());
          paramRequestParams.putString("msg", HardCodeUtil.a(2131706722));
        }
        else
        {
          paramRequestParams.putInt("result", 1);
          paramRequestParams.putString("msg", HardCodeUtil.a(2131706706));
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]CmShowHandler", 1, "IPC_APOLLO_IS_CM_FACE_ADDED, exception=", localException);
        paramRequestParams.putInt("result", 1);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131706708));
        ((StringBuilder)localObject2).append(localException.getMessage());
        paramRequestParams.putString("msg", ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      paramRequestParams.putInt("result", 1);
      paramRequestParams.putString("msg", HardCodeUtil.a(2131706712));
    }
    localBundle.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle);
  }
  
  @RequestRoute(a="ipc_apollo_play_last_record_msg")
  public void playLastRecordMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManagerV2.executeOnSubThread(new CmShowWebIPCModule.3(this, paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle2, localBundle1, localMessengerService));
  }
  
  @RequestRoute(a="ipc_apollo_preview")
  public void preview(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Object localObject = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = ((Bundle)localObject).getIntArray("apollo_dressIds");
    if ((localObject != null) && (localObject.length > 0))
    {
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(paramRequestParams, paramRequestParams.getCurrentUin(), new CmShowWebIPCModule.4(this, localBundle, localMessengerService), -1, (int[])localObject, -1, -1, false);
      return;
    }
    paramRequestParams = new Bundle();
    paramRequestParams.putInt("apollo_result", 1);
    localBundle.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle);
  }
  
  @RequestRoute(a="ipc_apollo_preview_action")
  public void previewAction(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Object localObject1 = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = ((Bundle)localObject1).getInt("apollo_previewAction");
    paramRequestParams = ((Bundle)localObject1).getString("apollo_json");
    int k = ((Bundle)localObject1).getInt("apollo_type");
    int m = ((Bundle)localObject1).getInt("apollo_isSpecial");
    boolean bool = ((Bundle)localObject1).getBoolean("apollo_previewOnFrame");
    String str2 = ((Bundle)localObject1).getString("apollo_id");
    int i = ((Bundle)localObject1).getInt("apollo_partnerRoleId");
    String str1 = ((Bundle)localObject1).getString("title");
    localObject1 = ((Bundle)localObject1).getString("subTitle");
    if (i == 0) {
      i = -1;
    }
    if (j > 0)
    {
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder((AppRuntime)localObject2, "", new CmShowWebIPCModule.5(this, m, (QQAppInterface)localObject2, paramRequestParams, j, bool, str2, str1, (String)localObject1, localBundle, localMessengerService), i, null, j, k, false);
      return;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("apollo_result", 1);
    ((Bundle)localObject2).putString("apollo_json", paramRequestParams);
    ((Bundle)localObject2).putString("title", str1);
    ((Bundle)localObject2).putString("subTitle", (String)localObject1);
    localBundle.putBundle("response", (Bundle)localObject2);
    localMessengerService.a(localBundle);
  }
  
  @RequestRoute(a="ipc_apollo_preview_audio_action")
  public void previewAudioAction(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Object localObject1 = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = ((Bundle)localObject1).getInt("apollo_audioId");
    paramRequestParams = ((Bundle)localObject1).getString("apollo_json");
    int j = ((Bundle)localObject1).getInt("apollo_previewAction");
    boolean bool = ((Bundle)localObject1).getBoolean("apollo_previewOnFrame");
    int k = ((Bundle)localObject1).getInt("apollo_partnerRoleId");
    int m = ((Bundle)localObject1).getInt("apollo_apolloVipFlag");
    int n = ((Bundle)localObject1).getInt("apollo_apolloVipLevel");
    String str2 = ((Bundle)localObject1).getString("apollo_id");
    String str1 = ((Bundle)localObject1).getString("title");
    localObject1 = ((Bundle)localObject1).getString("subTitle");
    if (i > 0)
    {
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloAudio((AppInterface)localObject2, new CmShowWebIPCModule.6(this, m, n, k, paramRequestParams, j, bool, str2, str1, (String)localObject1, localBundle, localMessengerService), i, false);
      return;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("apollo_result", 1);
    ((Bundle)localObject2).putInt("apollo_audioId", i);
    ((Bundle)localObject2).putString("apollo_json", paramRequestParams);
    ((Bundle)localObject2).putString("title", str1);
    ((Bundle)localObject2).putString("subTitle", (String)localObject1);
    localBundle.putBundle("response", (Bundle)localObject2);
    localMessengerService.a(localBundle);
  }
  
  @RequestRoute(a="ipc_apollo_query_mine_redinfo")
  public void queryMineRedInfo(@NonNull RequestParams paramRequestParams)
  {
    Object localObject = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramRequestParams == null) {
      return;
    }
    paramRequestParams = ((IRedTouchManager)paramRequestParams.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("103100.103200.103201.103204");
    if (paramRequestParams != null)
    {
      if (localObject == null) {
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putInt("isNewFlag", paramRequestParams.iNewFlag.get());
      ((Bundle)localObject).putBundle("response", localBundle);
      localMessengerService.a((Bundle)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("IPC_APOLLO_QUERY_MINE_REDINFO cmd get and isNewFlag=");
        ((StringBuilder)localObject).append(paramRequestParams.iNewFlag.get());
        QLog.d("[cmshow]CmShowHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  @RequestRoute(a="ipc_apollo_refresh_action")
  public void refreshAction(@NonNull RequestParams paramRequestParams)
  {
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ((ApolloExtensionHandler)paramRequestParams.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramRequestParams.getCurrentUin(), 128L, "refreshAction");
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmShowHandler", 2, "ipc call refreshAction");
    }
  }
  
  @RequestRoute(a="ipc_apollo_setcapsule")
  public void setCapule(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Object localObject = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = ((Bundle)localObject).getString("apollo_uin");
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject)) {
      ThreadManager.executeOnSubThread(new CmShowWebIPCModule.8(this, paramRequestParams, (String)localObject));
    }
    paramRequestParams = new Bundle();
    paramRequestParams.putInt("result", 0);
    localBundle.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle);
  }
  
  @RequestRoute(a="ipc_apollo_setup")
  public void setupUser(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.b;
    ApolloBaseInfo.saveSelfApolloDress(paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle.getString("apollo_userData"));
  }
  
  @RequestRoute(a="ipc_apollo_start_apollo_game")
  public void startApolloGame(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = localBundle1.getBundle("request");
    Bundle localBundle2 = new Bundle();
    localObject = (StartCheckParam)((Bundle)localObject).getSerializable("StartCheckParam");
    if (localObject == null)
    {
      QLog.e("ApolloGameActivity", 1, "IPC_APOLLO_START_APOLLO_GAME startCheckParam == null || startCheckParam.game == null");
      localBundle2.putInt("result", 1);
      localBundle1.putBundle("response", localBundle2);
      localMessengerService.a(localBundle1);
      return;
    }
    if (ApolloGameUtil.a() == null)
    {
      Intent localIntent = new Intent(BaseApplication.getContext(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.addFlags(268500992);
      BaseApplication.getContext().startActivity(localIntent);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CmShowWebIPCModule.14(this, localMessengerService, paramRequestParams, localBundle1, localBundle2, (StartCheckParam)localObject), 1000L);
      return;
    }
    a(localMessengerService, paramRequestParams, localBundle1, localBundle2, (StartCheckParam)localObject);
  }
  
  @RequestRoute(a="ipc_apollo_start_record_msg")
  public void startRecordMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = localBundle2.getInt("maxDuration");
    int i = j;
    if (j < 5) {
      i = 5;
    }
    localBundle2 = new Bundle();
    ((ApolloGameManagerImpl)paramRequestParams.getRuntimeService(IApolloGameManager.class, "all")).getCmGameAudioManager().a(i, new CmShowWebIPCModule.1(this, localBundle2, localBundle1, localMessengerService));
  }
  
  @RequestRoute(a="ipc_apollo_stop_last_record_msg")
  public void stopLastRecordMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    boolean bool = ((ApolloGameManagerImpl)paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloGameManager.class, "all")).getCmGameAudioManager().c();
    paramRequestParams = new Bundle();
    int i;
    if (bool) {
      i = 0;
    } else {
      i = -1;
    }
    paramRequestParams.putInt("result", i);
    localBundle.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle);
  }
  
  @RequestRoute(a="ipc_apollo_stop_record_msg")
  public void stopRecordMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    boolean bool = ((ApolloGameManagerImpl)paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloGameManager.class, "all")).getCmGameAudioManager().b();
    paramRequestParams = new Bundle();
    paramRequestParams.putInt("result", bool ^ true);
    localBundle.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle);
  }
  
  @RequestRoute(a="ipc_apollo_update_apollopandora")
  public void updateApolloPandora(@NonNull RequestParams paramRequestParams)
  {
    Object localObject1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    localObject1 = paramRequestParams.b;
    Object localObject2 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject2 = (IApolloManagerService)paramRequestParams.getRuntimeService(IApolloManagerService.class, "all");
    paramRequestParams = (ApolloDaoManagerServiceImpl)paramRequestParams.getRuntimeService(IApolloDaoManagerService.class, "all");
    localObject2 = ((Bundle)localObject1).getString("apollo_uin");
    long l = ((Bundle)localObject1).getLong("apollo_checkPoint");
    short s = ((Bundle)localObject1).getShort("apollo_hadStolen");
    localObject1 = paramRequestParams.getApolloPandora((String)localObject2, true);
    if (localObject1 != null)
    {
      ((ApolloPandora)localObject1).checkPoint = l;
      ((ApolloPandora)localObject1).updateTime = System.currentTimeMillis();
      ((ApolloPandora)localObject1).hadStolen = s;
      paramRequestParams.saveOrUpdateApolloPandora((ApolloPandora)localObject1);
    }
  }
  
  @RequestRoute(a="ipc_apollo_update_avatar_info")
  public void updateUseAvatarInfo(@NonNull RequestParams paramRequestParams)
  {
    Object localObject1 = paramRequestParams.b;
    Object localObject2 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramRequestParams = ((Bundle)localObject1).getString("uin");
    long l = ((Bundle)localObject1).getLong("avatarTs", 0L);
    localObject1 = ((Bundle)localObject1).getIntArray("dressId");
    StringBuilder localStringBuilder = new StringBuilder("apollo info uin: ");
    localStringBuilder.append(paramRequestParams);
    localStringBuilder.append(", avatarTs: ");
    localStringBuilder.append(l);
    if (!android.text.TextUtils.isEmpty(paramRequestParams))
    {
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
      localObject2 = ((IApolloDaoManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramRequestParams);
      int j = 1;
      int i = j;
      if (localObject2 != null)
      {
        i = j;
        if (((ApolloBaseInfo)localObject2).getApolloDress() != null) {
          if (((ApolloBaseInfo)localObject2).apolloLocalTS != ((ApolloBaseInfo)localObject2).apolloServerTS)
          {
            i = j;
          }
          else if ((l != 0L) && (l != ((ApolloBaseInfo)localObject2).apolloServerTS))
          {
            i = j;
          }
          else
          {
            if (localObject1 != null)
            {
              localObject2 = ((ApolloBaseInfo)localObject2).getApolloDress().getDressIds();
              if ((localObject2 != null) && (!ApolloUtilImpl.isSameDress((int[])localObject2, (int[])localObject1)))
              {
                i = j;
                break label217;
              }
            }
            i = 0;
          }
        }
      }
      label217:
      if (i != 0)
      {
        localIApolloManagerService.addToBulkPullMap(paramRequestParams, 2);
        localStringBuilder.append(", sendReq");
      }
    }
    QLog.d("[cmshow]CmShowHandler", 2, localStringBuilder.toString());
  }
  
  @RequestRoute(a="ipc_apollo_upload_record_msg")
  public void uploadRecordMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ThreadManagerV2.getUIHandlerV2().post(new CmShowWebIPCModule.2(this, paramRequestParams, localBundle, localMessengerService));
  }
  
  @RequestRoute(a="ipc_apollo_write_local")
  public void writeLocal(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManager.post(new CmShowWebIPCModule.13(this, paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle.getBundle("request").getString("writeData"), localBundle, localMessengerService), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule
 * JD-Core Version:    0.7.0.1
 */