package com.tencent.mobileqq.apollo.handler;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
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
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.api.model.ApolloPandora;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.lightGame.CmGameAudioManager;
import com.tencent.mobileqq.apollo.lightGame.CmGameConnManager;
import com.tencent.mobileqq.apollo.lightGame.CmGameSessionUtil;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportReceiver;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.RequestParams;
import com.tencent.mobileqq.emosm.web.WebRequestRoute;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.CommonUsedSystemEmojiManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CmShowModule
{
  private static final String TAG = "CmShowHandler";
  
  private void startApolloGameInner(MessengerService paramMessengerService, QQAppInterface paramQQAppInterface, Bundle paramBundle1, Bundle paramBundle2, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramMessengerService == null) || (paramQQAppInterface == null) || (paramBundle1 == null) || (paramBundle2 == null) || (paramStartCheckParam == null)) {
      return;
    }
    Activity localActivity = ApolloGameUtil.a();
    if (paramStartCheckParam.gameId == 1000)
    {
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      ApolloGameData localApolloGameData = ((IApolloDaoManagerService)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(paramStartCheckParam.gameId);
      if (localApolloGameData != null)
      {
        paramStartCheckParam.game = localApolloGameData;
        paramStartCheckParam.startT = System.currentTimeMillis();
        paramStartCheckParam.version = localIApolloManagerService.getApolloGameLocalVersion(paramStartCheckParam.gameId);
        paramQQAppInterface = CmGameServerQIPCModule.a().a(paramStartCheckParam.gameId);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(localActivity, paramStartCheckParam);
        }
        if (localActivity != null) {
          break label250;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = BaseApplicationImpl.getContext();
        paramQQAppInterface = new Intent(paramQQAppInterface, ApolloWebGameActivity.class);
        paramQQAppInterface.setFlags(196608);
        paramQQAppInterface.putExtra("extra_startcheckparam", paramStartCheckParam);
        localActivity.startActivity(paramQQAppInterface);
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("CmShowHandler", 1, "[startApolloGameInner] exception=", paramQQAppInterface);
        continue;
      }
      paramBundle2.putInt("result", 0);
      paramBundle1.putBundle("response", paramBundle2);
      paramMessengerService.a(paramBundle1);
      return;
      ApolloGameUtil.a(paramQQAppInterface, 0L);
      paramBundle2.putInt("result", 1);
      paramBundle1.putBundle("response", paramBundle2);
      paramMessengerService.a(paramBundle1);
      return;
      ApolloGameUtil.a(localActivity, paramStartCheckParam);
      continue;
      label250:
      paramQQAppInterface = localActivity;
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_add_cm_face")
  public void addCmFace(@NonNull RequestParams paramRequestParams)
  {
    int i = 0;
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    QQAppInterface localQQAppInterface = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = localBundle.getBundle("request").getString("faceIdList");
    paramRequestParams = new Bundle();
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      Object localObject2;
      ArrayList localArrayList;
      try
      {
        localObject2 = new JSONArray((String)localObject1);
        if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
        {
          localObject1 = new ArrayList();
          localArrayList = ApolloUtilImpl.getAddedFaceList(localQQAppInterface);
          int j = ((JSONArray)localObject2).length();
          if (i < j)
          {
            int k = QQSysFaceUtil.convertToLocal(((JSONArray)localObject2).getInt(i));
            if (!com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(k)) {
              break label538;
            }
            ((ArrayList)localObject1).add(Integer.valueOf(k));
            if ((localArrayList == null) || (!localArrayList.contains(Integer.valueOf(k)))) {
              break label538;
            }
            k = localArrayList.indexOf(Integer.valueOf(k));
            if (k == -1) {
              break label538;
            }
            localArrayList.remove(k);
            break label538;
          }
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            if (localQQAppInterface == null) {
              break label469;
            }
            localObject2 = (CommonUsedSystemEmojiManager)localQQAppInterface.getManager(QQManagerFactory.COMMONUSED_SYSTEM_EMOJI_MANAGERT);
            if (localObject2 == null) {
              break label446;
            }
            Iterator localIterator = ((ArrayList)localObject1).iterator();
            if (localIterator.hasNext())
            {
              Integer localInteger = (Integer)localIterator.next();
              EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
              localSmallYellowItem.id.set(localInteger.intValue());
              localSmallYellowItem.type.set(1);
              localSmallYellowItem.ts.set(System.currentTimeMillis());
              ((CommonUsedSystemEmojiManager)localObject2).saveSystemEmojiInfoToCahce(localSmallYellowItem);
              continue;
            }
          }
          else
          {
            localBundle.putBundle("response", paramRequestParams);
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("CmShowHandler", 1, "IPC_APOLLO_ADD_CM_FACE, exception=", localException);
        paramRequestParams.putInt("result", 1);
        paramRequestParams.putString("msg", HardCodeUtil.a(2131706685) + localException.getMessage());
      }
      for (;;)
      {
        localMessengerService.a(localBundle);
        return;
        ((CommonUsedSystemEmojiManager)localObject2).saveSystemEmojiInfoToFile();
        localObject2 = localException.getHandler(ChatActivity.class);
        if (localObject2 != null) {
          ((MqqHandler)localObject2).obtainMessage(10).sendToTarget();
        }
        paramRequestParams.putInt("result", 0);
        paramRequestParams.putString("msg", HardCodeUtil.a(2131706678));
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          ((ArrayList)localObject1).addAll(localArrayList);
        }
        ApolloUtilImpl.saveAddedFaceList(localException, (ArrayList)localObject1);
        continue;
        label446:
        paramRequestParams.putInt("result", 1);
        paramRequestParams.putString("msg", HardCodeUtil.a(2131706695));
        continue;
        label469:
        paramRequestParams.putInt("result", 1);
        paramRequestParams.putString("msg", HardCodeUtil.a(2131706691));
        continue;
        paramRequestParams.putInt("result", 1);
        paramRequestParams.putString("msg", HardCodeUtil.a(2131706694));
        continue;
        paramRequestParams.putInt("result", 1);
        paramRequestParams.putString("msg", HardCodeUtil.a(2131706696));
      }
      label538:
      i += 1;
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_add_fav_action")
  public void addFavAction(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Bundle localBundle2 = localBundle1.getBundle("request");
    ThreadManager.post(new CmShowModule.9(this, paramRequestParams, localBundle2.getInt("actionId"), localBundle2.getString("actionText"), localBundle2.getInt("textType"), localBundle2.getInt("audioId"), localBundle2.getInt("playOriginalAudio"), localBundle2.getFloat("audioStartTime"), localBundle1, localMessengerService), 5, null, false);
  }
  
  @WebRequestRoute(a="ipc_apollo_add_game")
  public void addGame(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ThreadManager.post(new CmShowModule.13(this, localBundle.getBundle("request").getString("gameListJson"), localBundle, localMessengerService, paramRequestParams), 5, null, false);
  }
  
  @WebRequestRoute(a="ipc_apollo_clear_bubble")
  public void apolloClearBubble(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l = localBundle.getBundle("request").getLong("bubble_id");
    paramRequestParams = (IApolloManagerService)paramRequestParams.getRuntimeService(IApolloManagerService.class, "all");
    if (l == 0L)
    {
      paramRequestParams.removeAllS2CPushItem();
      return;
    }
    paramRequestParams.clearBubble(String.valueOf(l));
  }
  
  @WebRequestRoute(a="ipc_apollo_changerole")
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
      boolean bool2;
      if ((j > 0) && (paramRequestParams != null) && (paramRequestParams.length > 0))
      {
        boolean bool1 = ApolloUtilImpl.checkRoleRes(j);
        int m = paramRequestParams.length;
        int i = 0;
        bool2 = bool1;
        if (i < m)
        {
          int n = paramRequestParams[i];
          if ((bool1) && (ApolloUtilImpl.checkDressRes(n))) {}
          for (bool1 = true;; bool1 = false)
          {
            i += 1;
            break;
          }
        }
      }
      else
      {
        bool2 = false;
      }
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
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), new CmShowModule.7(this, k, localBundle1, localMessengerService), j, paramRequestParams, -1, -1, false);
      return;
    }
    paramRequestParams = new Bundle();
    paramRequestParams.putInt("apollo_result", 1);
    paramRequestParams.putInt("apollo_fromSelf", k);
    localBundle1.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle1);
  }
  
  @WebRequestRoute(a="ipc_apollo_check_action")
  public void checkAction(@NonNull RequestParams paramRequestParams)
  {
    ApolloContentUpdateHandler.a(paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    if (QLog.isColorLevel()) {
      QLog.d("CmShowHandler", 2, "ipc call check_action");
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_check_avatar_res")
  public void checkAvatarRes(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Object localObject1 = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("CmShowHandler", 2, "IPC_APOLLO_CHECK_AVATAR_RES");
    }
    paramRequestParams = (ArrayList)((Bundle)localObject1).getSerializable("apolloList");
    if ((paramRequestParams == null) || (paramRequestParams.size() == 0))
    {
      QLog.e("CmShowHandler", 1, "IPC_APOLLO_CHECK_AVATAR_RES, no avatar params");
      paramRequestParams = new Bundle();
      paramRequestParams.putInt("result", 1);
      paramRequestParams.putString("msg", HardCodeUtil.a(2131706692));
      localBundle.putBundle("response", paramRequestParams);
      localMessengerService.a(localBundle);
      return;
    }
    int j = ((Bundle)localObject1).getInt("from");
    Iterator localIterator = paramRequestParams.iterator();
    while (localIterator.hasNext())
    {
      ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)localIterator.next();
      if (android.text.TextUtils.isEmpty(localApolloWebAvatarParam.uin))
      {
        paramRequestParams = new Bundle();
        paramRequestParams.putInt("result", 1);
        paramRequestParams.putString("msg", "uin为空");
        localBundle.putBundle("response", paramRequestParams);
        localMessengerService.a(localBundle);
        return;
      }
      Object localObject3;
      Object localObject4;
      if ((localApolloWebAvatarParam.roleId <= 0) || (localApolloWebAvatarParam.dressIds == null) || (localApolloWebAvatarParam.dressIds.length <= 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CmShowHandler", 2, "IPC_APOLLO_CHECK_AVATAR_RES, roleId=0 or no dressIds");
        }
        localObject3 = (IApolloManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
        localObject4 = ((IApolloManagerService)localObject3).getApolloBaseInfo(localApolloWebAvatarParam.uin);
        int i;
        if (localObject4 != null)
        {
          localObject4 = ((ApolloBaseInfo)localObject4).getApolloDress();
          if (localObject4 != null)
          {
            localApolloWebAvatarParam.roleId = ((ApolloDress)localObject4).roleId;
            localApolloWebAvatarParam.dressIds = ((ApolloDress)localObject4).getDressIds();
          }
        }
        else
        {
          if (localApolloWebAvatarParam.roleId == 0)
          {
            localObject3 = ((FriendsManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localApolloWebAvatarParam.uin);
            if (localObject3 != null)
            {
              if ((((Friends)localObject3).gender != 1) && (((Friends)localObject3).gender != 0)) {
                break label515;
              }
              i = 1;
              label362:
              localApolloWebAvatarParam.roleId = i;
              if (QLog.isColorLevel()) {
                QLog.d("CmShowHandler", 2, new Object[] { "IPC_APOLLO_CHECK_AVATAR_RES, roleId=", Integer.valueOf(localApolloWebAvatarParam.roleId), ", apolloId=", localApolloWebAvatarParam.apolloId });
              }
            }
          }
          if ((localApolloWebAvatarParam.roleId <= 0) || (localApolloWebAvatarParam.dressIds == null) || (localApolloWebAvatarParam.dressIds.length <= 0)) {
            continue;
          }
          bool = ApolloUtilImpl.checkRoleRes(localApolloWebAvatarParam.roleId);
          localObject3 = localApolloWebAvatarParam.dressIds;
          int k = localObject3.length;
          i = 0;
          label464:
          if (i >= k) {
            break label526;
          }
          int m = localObject3[i];
          if ((!bool) || (!ApolloUtilImpl.checkDressRes(m))) {
            break label520;
          }
        }
        label515:
        label520:
        for (boolean bool = true;; bool = false)
        {
          i += 1;
          break label464;
          ((IApolloManagerService)localObject3).addToBulkPullMap(localApolloWebAvatarParam.uin, 2);
          break;
          i = 2;
          break label362;
        }
        label526:
        localApolloWebAvatarParam.isResExist = bool;
      }
      else
      {
        localObject3 = (IApolloManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
        localObject4 = ((IApolloManagerService)localObject3).getApolloBaseInfo(localApolloWebAvatarParam.uin);
        if ((localObject4 != null) && (((ApolloBaseInfo)localObject4).getApolloDress() == null)) {
          ((IApolloManagerService)localObject3).addToBulkPullMap(localApolloWebAvatarParam.uin, 2);
        }
      }
    }
    localObject2 = new Bundle();
    localObject1 = ((Bundle)localObject1).getString("reqUrl");
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      ((Bundle)localObject2).putString("reqUrl", (String)localObject1);
    }
    ((Bundle)localObject2).putInt("result", 0);
    ((Bundle)localObject2).putInt("from", j);
    ((Bundle)localObject2).putSerializable("apolloList", paramRequestParams);
    localBundle.putBundle("response", (Bundle)localObject2);
    localMessengerService.a(localBundle);
  }
  
  @WebRequestRoute(a="ipc_apollo_choose_friend_play_game")
  public void chooseFriendPlayGame(@NonNull RequestParams paramRequestParams) {}
  
  @WebRequestRoute(a="ipc_apollo_clean_mine_redtouch")
  public void cleanMineRedTouch(@NonNull RequestParams paramRequestParams)
  {
    ((RedTouchManager)paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b(String.valueOf("103100.103200.103201.103204"));
    if (QLog.isColorLevel()) {
      QLog.d("CmShowHandler", 2, "IPC_APOLLO_CLEAN_MINE_REDTOUCH cmd get");
    }
  }
  
  @WebRequestRoute(a="ipc_cm_game_conn_connected")
  public void cmGameConnConnected(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn", 2, "IPC_CM_GAME_CONN_CONNECTED");
    }
    boolean bool = ((IApolloManagerService)paramRequestParams.getRuntimeService(IApolloManagerService.class, "all")).getCmGameConnManager().a();
    paramRequestParams = new Bundle();
    paramRequestParams.putInt("result", 0);
    paramRequestParams.putBoolean("isConnected", bool);
    localBundle.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle);
  }
  
  @WebRequestRoute(a="ipc_open_cm_game_match_page")
  public void cmGameMatchPage(@NonNull RequestParams paramRequestParams)
  {
    int i = 0;
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramRequestParams = localBundle.getBundle("request").getString("url");
    if (QLog.isColorLevel()) {
      QLog.d("CmGameConn", 2, new Object[] { "IPC_OPEN_CM_GAME_MATCH_PAGE, url=", paramRequestParams });
    }
    if (!android.text.TextUtils.isEmpty(paramRequestParams)) {
      CmGameUtil.a(localMessengerService, paramRequestParams);
    }
    for (;;)
    {
      paramRequestParams = new Bundle();
      paramRequestParams.putInt("result", i);
      localBundle.putBundle("response", paramRequestParams);
      localMessengerService.a(localBundle);
      return;
      i = 1;
    }
  }
  
  @WebRequestRoute(a="ipc_cm_game_match_page_report_status")
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
    ((IApolloManagerService)paramRequestParams.getRuntimeService(IApolloManagerService.class, "all")).getCmGameConnManager().a(bool1, bool2);
  }
  
  @WebRequestRoute(a="ipc_open_cm_game_send_game_app_ark_msg")
  public void cmGameSendAppApkMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = localBundle.getBundle("request");
    String str = ((Bundle)localObject).getString("friendUin");
    localObject = ((Bundle)localObject).getString("arkInfo");
    if (QLog.isColorLevel()) {
      QLog.d("CmGame", 2, "IPC_OPEN_CM_GAME_SEND_GAME_APP_ARK_MSG");
    }
    boolean bool = CmGameSessionUtil.a(paramRequestParams, str, (String)localObject);
    paramRequestParams = new Bundle();
    if (bool) {}
    for (int i = 0;; i = 1)
    {
      paramRequestParams.putInt("result", i);
      localBundle.putBundle("response", paramRequestParams);
      localMessengerService.a(localBundle);
      return;
    }
  }
  
  @WebRequestRoute(a="ipc_trace_report")
  public void cmsTraceReport(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramRequestParams = localBundle.getBundle("request");
    TraceReportReceiver.a(paramRequestParams.getString("action"), paramRequestParams);
  }
  
  @WebRequestRoute(a="ipc_apollo_del_fav_action")
  public void delFavAction(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Bundle localBundle2 = localBundle1.getBundle("request");
    int i = localBundle2.getInt("actionId");
    ThreadManager.post(new CmShowModule.10(this, paramRequestParams, localBundle2.getLong("seq"), i, localBundle1, localMessengerService), 5, null, false);
  }
  
  @WebRequestRoute(a="ipc_apollo_del_fav_list")
  public void delFavList(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManager.post(new CmShowModule.11(this, paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle.getBundle("request").getString("delJson"), localBundle, localMessengerService), 5, null, false);
  }
  
  @WebRequestRoute(a="ipc_apollo_del_game")
  public void delGame(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ThreadManager.post(new CmShowModule.16(this, localBundle.getBundle("request").getString("gameListJson"), localBundle, localMessengerService, paramRequestParams), 5, null, false);
  }
  
  @WebRequestRoute(a="IPC_APOLLO_DOWNLOAD_GAME")
  public void downloadGame(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = localBundle.getBundle("request").getInt("gameId");
    Object localObject1 = (IApolloManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
    paramRequestParams = new CmGameStartChecker.StartCheckParam(i, false, "check", 0L, 4, 1, 0, 0, "", 0, null);
    localObject2 = ((IApolloDaoManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(i);
    if (localObject2 != null) {
      paramRequestParams.game = ((ApolloGameData)localObject2);
    }
    for (;;)
    {
      paramRequestParams.version = ((IApolloManagerService)localObject1).getApolloGameLocalVersion(paramRequestParams.game.gameId);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putSerializable("StartCheckParam", paramRequestParams);
      localBundle.putBundle("response", (Bundle)localObject1);
      localMessengerService.a(localBundle);
      return;
      paramRequestParams.game = new ApolloGameData();
      paramRequestParams.game.gameId = i;
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_downloadImageOnFrame")
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
  
  @WebRequestRoute(a="ipc_apollo_get_apollo_data")
  public void getApolloData(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    QQAppInterface localQQAppInterface = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ApolloContentUpdateHandler.a(localQQAppInterface, 1);
    paramRequestParams = ((IApolloManagerService)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(localQQAppInterface.getCurrentAccountUin());
    int j;
    int k;
    int i;
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
      }
    }
    for (;;)
    {
      int m = localBundle2.getInt("apollo_initFrom");
      localBundle2 = new Bundle();
      localBundle2.putInt("apollo_result", 0);
      localBundle2.putInt("apollo_initFrom", m);
      localBundle2.putInt("apollo_roleId", k);
      localBundle2.putIntArray("apollo_dressIds", paramRequestParams);
      localBundle2.putInt("apollo_apolloStatus", j);
      if (k == 0)
      {
        paramRequestParams = ((FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(localQQAppInterface.getCurrentAccountUin());
        if (paramRequestParams == null) {}
      }
      for (j = paramRequestParams.gender;; j = 1)
      {
        k = i;
        if (i == 0) {
          k = j;
        }
        localBundle2.putInt("apollo_roleGender", k);
        localBundle2.putInt("apollo_gender", j);
        localBundle1.putBundle("response", localBundle2);
        localMessengerService.a(localBundle1);
        return;
      }
      paramRequestParams = null;
      k = 0;
      i = 0;
      continue;
      i = 0;
      paramRequestParams = null;
      k = 0;
      j = 0;
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_getfav_action")
  public void getFavAction(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManager.post(new CmShowModule.8(this, paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle, localMessengerService), 5, null, true);
  }
  
  @WebRequestRoute(a="ipc_apollo_get_openapollo_friends")
  public void getOpenApolloFriends(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (((QQAppInterface)localObject2).isLogin())
    {
      paramRequestParams = ((QQAppInterface)localObject2).getEntityManagerFactory().createEntityManager().query(true, "ApolloBaseInfo", new String[] { "uin" }, "apolloStatus=? ", new String[] { "1" }, null, null, null, null);
      if ((paramRequestParams == null) || (!paramRequestParams.moveToFirst())) {
        break label405;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        Object localObject3 = (FriendsManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER);
        int k = paramRequestParams.getColumnIndex("uin");
        if (k >= 0)
        {
          localObject2 = new JSONArray();
          int i = 0;
          Object localObject4 = paramRequestParams.getString(k);
          Friends localFriends = ((FriendsManager)localObject3).b((String)localObject4);
          j = i;
          if (localFriends == null) {
            break label423;
          }
          j = i;
          if (!localFriends.isFriend()) {
            break label423;
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", localObject4);
          localJSONObject.put("nick", localFriends.name);
          ((JSONArray)localObject2).put(localJSONObject);
          j = i + 1;
          break label423;
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt("apollo_result", 0);
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("friends", localObject2);
          ((Bundle)localObject3).putString("apollo_data", ((JSONObject)localObject4).toString());
          localBundle.putBundle("response", (Bundle)localObject3);
          localMessengerService.a(localBundle);
          if (QLog.isColorLevel()) {
            QLog.d("CmShowHandler", 2, "IPC_APOLLO_GET_OPENAPOLLO_FRIENDS array is:" + ((JSONArray)localObject2).toString());
          }
          return;
          boolean bool = paramRequestParams.moveToNext();
          i = j;
          if (bool) {
            continue;
          }
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("CmShowHandler", 2, localException.getMessage());
        paramRequestParams.close();
        continue;
      }
      finally
      {
        paramRequestParams.close();
      }
      paramRequestParams = new Bundle();
      paramRequestParams.putInt("apollo_result", 1);
      localBundle.putBundle("response", paramRequestParams);
      return;
      label405:
      if (QLog.isColorLevel())
      {
        QLog.d("CmShowHandler", 2, "IPC_APOLLO_GET_OPENAPOLLO_FRIENDS cursor is null");
        continue;
        label423:
        if (j < 10) {}
      }
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_get_playmate_msg")
  public void getPlayMateMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Object localObject = paramRequestParams.b;
    localObject = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    QQAppInterface localQQAppInterface = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramRequestParams = localBundle.getBundle("request").getString("uinList");
    if (android.text.TextUtils.isEmpty(paramRequestParams)) {}
    for (;;)
    {
      return;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramRequestParams);
        if (localJSONArray.length() >= 1)
        {
          ThreadManagerV2.excute(new CmShowModule.15(this, localJSONArray, localQQAppInterface, localBundle, (MessengerService)localObject), 16, null, false);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("CmShowHandler", 1, "getPlayMateMsg uinList to json error:  " + localJSONException + " uinList: " + paramRequestParams);
      }
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_is_cm_face_added")
  public void isCmFaceAdded(@NonNull RequestParams paramRequestParams)
  {
    int i = 0;
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    Object localObject2 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = localBundle.getBundle("request").getString("faceIdList");
    paramRequestParams = new Bundle();
    JSONArray localJSONArray;
    int k;
    JSONObject localJSONObject;
    if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          localJSONArray = new JSONArray();
          localObject2 = ApolloUtilImpl.getAddedFaceList((QQAppInterface)localObject2);
          int j = ((JSONArray)localObject1).length();
          if (i < j)
          {
            k = ((JSONArray)localObject1).getInt(i);
            localJSONObject = new JSONObject();
            int m = QQSysFaceUtil.convertToLocal(k);
            if (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(m))
            {
              if ((localObject2 != null) && (((ArrayList)localObject2).contains(Integer.valueOf(m))))
              {
                localJSONObject.put("id", k);
                localJSONObject.put("status", 2);
              }
              for (;;)
              {
                localJSONArray.put(i, localJSONObject);
                i += 1;
                break;
                localJSONObject.put("id", k);
                localJSONObject.put("status", 1);
              }
              localBundle.putBundle("response", paramRequestParams);
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("CmShowHandler", 1, "IPC_APOLLO_IS_CM_FACE_ADDED, exception=", localException);
        paramRequestParams.putInt("result", 1);
        paramRequestParams.putString("msg", HardCodeUtil.a(2131706686) + localException.getMessage());
      }
    }
    for (;;)
    {
      localMessengerService.a(localBundle);
      return;
      localJSONObject.put("id", k);
      localJSONObject.put("status", 0);
      break;
      paramRequestParams.putInt("result", 0);
      paramRequestParams.putString("status", localJSONArray.toString());
      paramRequestParams.putString("msg", HardCodeUtil.a(2131706700));
      continue;
      paramRequestParams.putInt("result", 1);
      paramRequestParams.putString("msg", HardCodeUtil.a(2131706684));
      continue;
      paramRequestParams.putInt("result", 1);
      paramRequestParams.putString("msg", HardCodeUtil.a(2131706690));
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_open_cmgame_aio")
  public void openCmGameAio(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localBundle = localBundle.getBundle("request");
    CmGameSessionUtil.a(paramRequestParams, localBundle.getString("friendUin"), localBundle.getString("nickName"), localBundle.getInt("src"));
  }
  
  @WebRequestRoute(a="ipc_apollo_play_last_record_msg")
  public void playLastRecordMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Bundle localBundle2 = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManagerV2.executeOnSubThread(new CmShowModule.3(this, paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle2, localBundle1, localMessengerService));
  }
  
  @WebRequestRoute(a="ipc_apollo_preview")
  public void preview(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Object localObject = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = ((Bundle)localObject).getIntArray("apollo_dressIds");
    if ((localObject != null) && (localObject.length > 0))
    {
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(paramRequestParams, paramRequestParams.getCurrentUin(), new CmShowModule.4(this, localBundle, localMessengerService), -1, (int[])localObject, -1, -1, false);
      return;
    }
    paramRequestParams = new Bundle();
    paramRequestParams.putInt("apollo_result", 1);
    localBundle.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle);
  }
  
  @WebRequestRoute(a="ipc_apollo_preview_action")
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
    for (;;)
    {
      if (j > 0)
      {
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder((AppRuntime)localObject2, "", new CmShowModule.5(this, m, (QQAppInterface)localObject2, paramRequestParams, j, bool, str2, str1, (String)localObject1, localBundle, localMessengerService), i, null, j, k, false);
        return;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("apollo_result", 1);
      ((Bundle)localObject2).putString("apollo_json", paramRequestParams);
      ((Bundle)localObject2).putString("title", str1);
      ((Bundle)localObject2).putString("subTitle", (String)localObject1);
      localBundle.putBundle("response", (Bundle)localObject2);
      localMessengerService.a(localBundle);
      return;
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_preview_audio_action")
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
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloAudio((AppInterface)localObject2, new CmShowModule.6(this, m, n, k, paramRequestParams, j, bool, str2, str1, (String)localObject1, localBundle, localMessengerService), i, false);
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
  
  @WebRequestRoute(a="ipc_apollo_query_mine_redinfo")
  public void queryMineRedInfo(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = ((RedTouchManager)paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("103100.103200.103201.103204");
    if ((paramRequestParams == null) || (localBundle1 == null)) {}
    do
    {
      return;
      Bundle localBundle2 = new Bundle();
      localBundle2.putInt("isNewFlag", paramRequestParams.iNewFlag.get());
      localBundle1.putBundle("response", localBundle2);
      localMessengerService.a(localBundle1);
    } while (!QLog.isColorLevel());
    QLog.d("CmShowHandler", 2, "IPC_APOLLO_QUERY_MINE_REDINFO cmd get and isNewFlag=" + paramRequestParams.iNewFlag.get());
  }
  
  @WebRequestRoute(a="ipc_apollo_refresh_action")
  public void refreshAction(@NonNull RequestParams paramRequestParams)
  {
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ((ApolloExtensionHandlerImpl)paramRequestParams.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramRequestParams.getCurrentUin(), 128, "refreshAction");
    if (QLog.isColorLevel()) {
      QLog.d("CmShowHandler", 2, "ipc call refreshAction");
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_save_3d_face")
  public void save3DFaceData(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.b;
    Bundle localBundle2 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManagerV2.executeOnSubThread(new CmShowModule.18(this, localBundle1, paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle2, localMessengerService));
  }
  
  @WebRequestRoute(a="ipc_apollo_setcapsule")
  public void setCapule(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Object localObject = paramRequestParams.b;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject = ((Bundle)localObject).getString("apollo_uin");
    ((IApolloManagerService)paramRequestParams.getRuntimeService(IApolloManagerService.class, "all")).setCapsuleHadStolenAsync((String)localObject);
    paramRequestParams = new Bundle();
    paramRequestParams.putInt("result", 0);
    localBundle.putBundle("response", paramRequestParams);
    localMessengerService.a(localBundle);
  }
  
  @WebRequestRoute(a="ipc_apollo_setup")
  public void setupUser(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.b;
    ApolloBaseInfo.saveSelfApolloDress(paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle.getString("apollo_userData"));
  }
  
  @WebRequestRoute(a="ipc_apollo_start_apollo_game")
  public void startApolloGame(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject = localBundle1.getBundle("request");
    Bundle localBundle2 = new Bundle();
    localObject = (CmGameStartChecker.StartCheckParam)((Bundle)localObject).getSerializable("StartCheckParam");
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
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CmShowModule.14(this, localMessengerService, paramRequestParams, localBundle1, localBundle2, (CmGameStartChecker.StartCheckParam)localObject), 1000L);
      return;
    }
    startApolloGameInner(localMessengerService, paramRequestParams, localBundle1, localBundle2, (CmGameStartChecker.StartCheckParam)localObject);
  }
  
  @WebRequestRoute(a="ipc_apollo_start_record_msg")
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
    ((IApolloManagerService)paramRequestParams.getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager().a(i, new CmShowModule.1(this, localBundle2, localBundle1, localMessengerService));
  }
  
  @WebRequestRoute(a="ipc_apollo_stop_last_record_msg")
  public void stopLastRecordMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    boolean bool = ((IApolloManagerService)paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager().d();
    paramRequestParams = new Bundle();
    if (bool) {}
    for (int i = 0;; i = -1)
    {
      paramRequestParams.putInt("result", i);
      localBundle.putBundle("response", paramRequestParams);
      localMessengerService.a(localBundle);
      return;
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_stop_record_msg")
  public void stopRecordMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    boolean bool = ((IApolloManagerService)paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getCmGameAudioManager().c();
    paramRequestParams = new Bundle();
    if (bool) {}
    for (int i = 0;; i = 1)
    {
      paramRequestParams.putInt("result", i);
      localBundle.putBundle("response", paramRequestParams);
      localMessengerService.a(localBundle);
      return;
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_update_apollopandora")
  public void updateApolloPandora(@NonNull RequestParams paramRequestParams)
  {
    Object localObject1 = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    localObject1 = paramRequestParams.b;
    Object localObject2 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = (IApolloManagerService)paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
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
  
  @WebRequestRoute(a="ipc_apollo_update_game_list")
  public void updateGameList(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    Object localObject = paramRequestParams.b;
    localObject = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = localBundle.getBundle("request").getString("gameListJson");
    if (QLog.isColorLevel()) {
      QLog.d("CmShowHandler", 2, new Object[] { "IPC_APOLLO_UPDATE_GAME_LIST, update game list, gameListStr=", str });
    }
    if (!android.text.TextUtils.isEmpty(str)) {
      ThreadManager.post(new CmShowModule.17(this, str, paramRequestParams, localBundle, (MessengerService)localObject), 5, null, false);
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_update_avatar_info")
  public void updateUseAvatarInfo(@NonNull RequestParams paramRequestParams)
  {
    Object localObject1 = paramRequestParams.b;
    Object localObject2 = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramRequestParams = ((Bundle)localObject1).getString("uin");
    long l = ((Bundle)localObject1).getLong("avatarTs", 0L);
    localObject1 = ((Bundle)localObject1).getIntArray("dressId");
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder("apollo info uin: ").append(paramRequestParams).append(", avatarTs: ").append(l);
    Object localObject3;
    int i;
    if (!android.text.TextUtils.isEmpty(paramRequestParams))
    {
      localObject2 = (IApolloManagerService)((QQAppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
      localObject3 = ((IApolloManagerService)localObject2).getApolloBaseInfo(paramRequestParams);
      if ((localObject3 != null) && (((ApolloBaseInfo)localObject3).getApolloDress() != null) && (((ApolloBaseInfo)localObject3).apolloLocalTS == ((ApolloBaseInfo)localObject3).apolloServerTS)) {
        break label165;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        ((IApolloManagerService)localObject2).addToBulkPullMap(paramRequestParams, 2);
        localStringBuilder.append(", sendReq");
      }
      QLog.d("CmShowHandler", 2, localStringBuilder.toString());
      return;
      label165:
      if ((l != 0L) && (l != ((ApolloBaseInfo)localObject3).apolloServerTS))
      {
        i = 1;
      }
      else
      {
        i = j;
        if (localObject1 != null)
        {
          localObject3 = ((ApolloBaseInfo)localObject3).getApolloDress().getDressIds();
          i = j;
          if (localObject3 != null)
          {
            i = j;
            if (!ApolloUtilImpl.isSameDress((int[])localObject3, (int[])localObject1)) {
              i = 1;
            }
          }
        }
      }
    }
  }
  
  @WebRequestRoute(a="ipc_apollo_upload_record_msg")
  public void uploadRecordMsg(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    paramRequestParams = paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    ThreadManagerV2.getUIHandlerV2().post(new CmShowModule.2(this, paramRequestParams, localBundle, localMessengerService));
  }
  
  @WebRequestRoute(a="ipc_apollo_write_local")
  public void writeLocal(@NonNull RequestParams paramRequestParams)
  {
    Bundle localBundle = paramRequestParams.jdField_a_of_type_AndroidOsBundle;
    MessengerService localMessengerService = paramRequestParams.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService;
    ThreadManager.post(new CmShowModule.12(this, paramRequestParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBundle.getBundle("request").getString("writeData"), localBundle, localMessengerService), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule
 * JD-Core Version:    0.7.0.1
 */