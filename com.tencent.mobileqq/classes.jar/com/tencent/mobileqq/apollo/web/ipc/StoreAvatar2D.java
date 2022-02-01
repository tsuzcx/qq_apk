package com.tencent.mobileqq.apollo.web.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.game.ApolloGameTool;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.statistics.trace.sdk.TraceReportReceiver;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController.PlayActionData;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.CmStoreUserInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResDownloaderFacade;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.emosm.api.ICommonUsedSystemEmojiManagerService;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.GenderType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/web/ipc/StoreAvatar2D;", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D;", "()V", "app", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "addCmFace", "", "jsonArray", "Lorg/json/JSONArray;", "callback", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$AddCmFaceCallback;", "addFavAction", "actionId", "", "actionText", "", "textType", "audioId", "playOriginalAudio", "audioStartTime", "", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$AddFavActionCallback;", "changeRole", "roleId", "dressIds", "", "fromSelf", "userData", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$ChangeRoleCallback;", "checkAvatarRes", "apolloList", "Ljava/io/Serializable;", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$CheckAvatarResCallback;", "clearBubble", "bubbleId", "", "cmsTraceReport", "reqParam", "Landroid/os/Bundle;", "delFavList", "delJson", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$DelFavListCallback;", "downloadGame", "gameId", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$DownloadGameCallback;", "getApolloData", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$GetApolloDataCallback;", "getFavAction", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$GetFavActionCallback;", "isCmFaceAdded", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$IsCmFaceAddedCallback;", "preview", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$PreviewCallback;", "previewAction", "actionData", "Lcom/tencent/mobileqq/apollo/store/ApolloStoreViewController$PlayActionData;", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$PreviewActionCallback;", "queryMineRedInfo", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$QueryMineRedInfoCallback;", "refreshAction", "setCapsule", "uin", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$SetCapsuleCallback;", "setupUser", "startApolloGame", "startCheckParam", "Lcom/tencent/mobileqq/apollo/model/StartCheckParam;", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$StartApolloGameCallback;", "startApolloGameInner", "qqApp", "updateUseAvatarInfo", "avatarTs", "dressId", "writeLocal", "writeData", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/apollo/web/ipc/IStoreAvatar2D$WriteLocalCallback;", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class StoreAvatar2D
  implements IStoreAvatar2D
{
  public static final StoreAvatar2D.Companion a = new StoreAvatar2D.Companion(null);
  
  private final void a(AppInterface paramAppInterface, StartCheckParam paramStartCheckParam, IStoreAvatar2D.StartApolloGameCallback paramStartApolloGameCallback)
  {
    if ((paramAppInterface != null) && (paramStartCheckParam != null))
    {
      if (paramStartCheckParam.gameId != 1000)
      {
        paramStartApolloGameCallback.a(1);
        return;
      }
      if (ApolloGameTool.a(paramAppInterface, paramStartCheckParam))
      {
        paramStartApolloGameCallback.a(0);
        return;
      }
      paramStartApolloGameCallback.a(1);
      return;
    }
    paramStartApolloGameCallback.a(1);
  }
  
  private final AppInterface b()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      QLog.i("[cmshow]StoreAvatar2D", 2, "onRemoteInvoke cannot get QQAppInterface");
      return null;
    }
    return (AppInterface)localObject;
  }
  
  public void a()
  {
    AppInterface localAppInterface = b();
    if (localAppInterface == null) {
      return;
    }
    BusinessHandler localBusinessHandler = localAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if (localBusinessHandler != null)
    {
      ((ApolloExtensionHandler)localBusinessHandler).a(localAppInterface.getCurrentUin(), '', "refreshAction");
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]StoreAvatar2D", 2, "ipc call refreshAction");
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler");
  }
  
  public void a(int paramInt, @NotNull IStoreAvatar2D.DownloadGameCallback paramDownloadGameCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramDownloadGameCallback, "callback");
    Object localObject1 = b();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((AppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "app!!.getRuntimeService(…ava, ProcessConstant.ALL)");
    localObject1 = (IApolloManagerService)localObject1;
    localObject1 = new StartCheckParam(paramInt, false, "check", 0L, 4, 1, 0, 0, "", 0, null);
    Object localObject2 = b();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = ((IApolloDaoManagerService)((AppInterface)localObject2).getRuntimeService(IApolloDaoManagerService.class, "all")).findGameById(paramInt);
    if (localObject2 != null)
    {
      ((StartCheckParam)localObject1).game = ((ApolloGameData)localObject2);
    }
    else
    {
      ((StartCheckParam)localObject1).game = new ApolloGameData();
      ((StartCheckParam)localObject1).game.gameId = paramInt;
    }
    ((StartCheckParam)localObject1).version = ApolloGameTool.a(((StartCheckParam)localObject1).game.gameId, (AppRuntime)b());
    paramDownloadGameCallback.a((Serializable)localObject1);
  }
  
  public void a(int paramInt1, @NotNull String paramString, int paramInt2, int paramInt3, int paramInt4, float paramFloat, @NotNull IStoreAvatar2D.AddFavActionCallback paramAddFavActionCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "actionText");
    Intrinsics.checkParameterIsNotNull(paramAddFavActionCallback, "callback");
    ThreadManager.post((Runnable)new StoreAvatar2D.addFavAction.1(this, paramAddFavActionCallback, paramInt1, paramString, paramInt2, paramInt3, paramInt4, paramFloat), 5, null, false);
  }
  
  public void a(int paramInt1, @NotNull int[] paramArrayOfInt, int paramInt2, @NotNull String paramString, @NotNull IStoreAvatar2D.ChangeRoleCallback paramChangeRoleCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "dressIds");
    Intrinsics.checkParameterIsNotNull(paramString, "userData");
    Intrinsics.checkParameterIsNotNull(paramChangeRoleCallback, "callback");
    if (paramInt1 <= 0)
    {
      paramChangeRoleCallback.a(1, paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
    if (paramInt2 != 1)
    {
      localObject = b();
      if (localObject != null) {
        localObject = (IApolloDaoManagerService)((AppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
      } else {
        localObject = null;
      }
      if (localObject != null) {
        ((ApolloDaoManagerServiceImpl)localObject).saveSelfApolloDress((AppRuntime)b(), paramString);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl");
      }
    }
    if ((paramInt1 > 0) && (paramArrayOfInt.length > 0))
    {
      paramString = ApolloResManagerFacade.a.a(Scene.WEB_STORE_OR_GAME);
      boolean bool1 = paramString.b(paramInt1);
      int j = paramArrayOfInt.length;
      int i = 0;
      for (;;)
      {
        bool2 = bool1;
        if (i >= j) {
          break;
        }
        int k = paramArrayOfInt[i];
        if ((bool1) && (paramString.a(k))) {
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
      paramChangeRoleCallback.a(0, paramInt1, paramArrayOfInt, paramInt2);
      return;
    }
    paramString = ApolloResDownloaderFacade.a.a(Scene.WEB_STORE_OR_GAME);
    Object localObject = (AppRuntime)b();
    AppInterface localAppInterface = b();
    if (localAppInterface == null) {
      Intrinsics.throwNpe();
    }
    paramString.a((AppRuntime)localObject, localAppInterface.getCurrentAccountUin(), (IApolloResDownloader.OnApolloDownLoadListener)new StoreAvatar2D.changeRole.1(paramChangeRoleCallback, paramInt2), paramInt1, paramArrayOfInt, -1, -1, false);
  }
  
  public void a(long paramLong)
  {
    Object localObject = b();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((AppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
    if (localObject != null)
    {
      localObject = (ApolloDaoManagerServiceImpl)localObject;
      if (paramLong == 0L)
      {
        ((ApolloDaoManagerServiceImpl)localObject).removeAllS2CPushItem();
        return;
      }
      ((ApolloDaoManagerServiceImpl)localObject).clearBubble(String.valueOf(paramLong));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl");
  }
  
  public void a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "reqParam");
    String str = paramBundle.getString("action");
    Intrinsics.checkExpressionValueIsNotNull(str, "reqParam.getString(\"action\")");
    TraceReportReceiver.a(str, paramBundle);
  }
  
  public void a(@NotNull StartCheckParam paramStartCheckParam, @NotNull IStoreAvatar2D.StartApolloGameCallback paramStartApolloGameCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramStartCheckParam, "startCheckParam");
    Intrinsics.checkParameterIsNotNull(paramStartApolloGameCallback, "callback");
    if (ApolloGameUtil.b() == null)
    {
      Intent localIntent = new Intent((Context)BaseApplication.getContext(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      localIntent.addFlags(268500992);
      BaseApplication.getContext().startActivity(localIntent);
      ThreadManagerV2.getUIHandlerV2().postDelayed((Runnable)new StoreAvatar2D.startApolloGame.1(this, paramStartCheckParam, paramStartApolloGameCallback), 1000L);
      return;
    }
    a(b(), paramStartCheckParam, paramStartApolloGameCallback);
  }
  
  public void a(@Nullable ApolloStoreViewController.PlayActionData paramPlayActionData, @Nullable IStoreAvatar2D.PreviewActionCallback paramPreviewActionCallback)
  {
    if (paramPreviewActionCallback == null) {
      return;
    }
    if (paramPlayActionData == null)
    {
      paramPreviewActionCallback.a(1, paramPlayActionData);
      return;
    }
    if (paramPlayActionData.partnerRoleId == 0) {
      paramPlayActionData.partnerRoleId = -1;
    }
    if (paramPlayActionData.activeId <= 0)
    {
      paramPreviewActionCallback.a(1, paramPlayActionData);
      return;
    }
    ApolloResDownloaderFacade.a.a(Scene.WEB_STORE_OR_GAME).a((AppRuntime)b(), "", (IApolloResDownloader.OnApolloDownLoadListener)new StoreAvatar2D.previewAction.1(this, paramPreviewActionCallback, paramPlayActionData), paramPlayActionData.partnerRoleId, null, paramPlayActionData.activeId, paramPlayActionData.actionType, false);
  }
  
  public void a(@NotNull IStoreAvatar2D.GetApolloDataCallback paramGetApolloDataCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramGetApolloDataCallback, "callback");
    Object localObject2 = b();
    if (localObject2 == null)
    {
      paramGetApolloDataCallback.a(1, null);
      return;
    }
    ApolloContentUpdateHandler.a((AppInterface)localObject2, 1);
    Object localObject1 = ((AppInterface)localObject2).getRuntimeService(IApolloDaoManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "qqApp.getRuntimeService(…ava, ProcessConstant.ALL)");
    Object localObject3 = ((IApolloDaoManagerService)localObject1).getApolloBaseInfo(((AppInterface)localObject2).getCurrentAccountUin());
    localObject1 = (int[])null;
    if (localObject3 != null)
    {
      j = ((ApolloBaseInfo)localObject3).apolloStatus;
      localObject3 = ((ApolloBaseInfo)localObject3).getApolloDress();
      if (localObject3 != null)
      {
        k = ((ApolloDress)localObject3).roleId;
        i = ((ApolloDress)localObject3).mRoleGender;
        localObject1 = ((ApolloDress)localObject3).getDressIds();
        m = j;
        break label136;
      }
    }
    else
    {
      j = 0;
    }
    int k = 0;
    int i = 0;
    int m = j;
    label136:
    int j = GenderType.FEMALE.value;
    if (k == 0)
    {
      localObject3 = ((AppInterface)localObject2).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject3 != null)
      {
        localObject2 = ((FriendsManager)localObject3).c(((AppInterface)localObject2).getCurrentAccountUin());
        if (localObject2 != null) {
          j = ((Friends)localObject2).gender;
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
      }
    }
    int n = i;
    if (i == GenderType.DEFAULT.value) {
      n = j;
    }
    localObject2 = new ApolloJsPluginImpl.CmStoreUserInfo();
    ((ApolloJsPluginImpl.CmStoreUserInfo)localObject2).mRoleId = k;
    ((ApolloJsPluginImpl.CmStoreUserInfo)localObject2).mDressIds = ((int[])localObject1);
    ((ApolloJsPluginImpl.CmStoreUserInfo)localObject2).mApolloStatus = m;
    ((ApolloJsPluginImpl.CmStoreUserInfo)localObject2).mRoleGender = n;
    ((ApolloJsPluginImpl.CmStoreUserInfo)localObject2).mUserGender = j;
    paramGetApolloDataCallback.a(0, (ApolloJsPluginImpl.CmStoreUserInfo)localObject2);
  }
  
  public void a(@NotNull IStoreAvatar2D.GetFavActionCallback paramGetFavActionCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramGetFavActionCallback, "callback");
    ThreadManager.post((Runnable)new StoreAvatar2D.getFavAction.1(this, paramGetFavActionCallback), 5, null, true);
  }
  
  public void a(@NotNull IStoreAvatar2D.QueryMineRedInfoCallback paramQueryMineRedInfoCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramQueryMineRedInfoCallback, "callback");
    Object localObject = b();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((AppInterface)localObject).getRuntimeService(IRedTouchManager.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "app!!.getRuntimeService(…va, ProcessConstant.MAIN)");
    localObject = ((IRedTouchManager)localObject).getAppInfoByPath("103100.103200.103201.103204");
    if (localObject == null)
    {
      paramQueryMineRedInfoCallback.a(0);
      return;
    }
    paramQueryMineRedInfoCallback.a(((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get());
    if (QLog.isColorLevel())
    {
      paramQueryMineRedInfoCallback = new StringBuilder();
      paramQueryMineRedInfoCallback.append("IPC_APOLLO_QUERY_MINE_REDINFO cmd get and isNewFlag=");
      paramQueryMineRedInfoCallback.append(((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get());
      QLog.d("[cmshow]StoreAvatar2D", 2, paramQueryMineRedInfoCallback.toString());
    }
  }
  
  public void a(@NotNull Serializable paramSerializable, @NotNull IStoreAvatar2D.CheckAvatarResCallback paramCheckAvatarResCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramSerializable, "apolloList");
    Intrinsics.checkParameterIsNotNull(paramCheckAvatarResCallback, "callback");
    AppInterface localAppInterface = b();
    if (localAppInterface == null)
    {
      paramCheckAvatarResCallback.a(1, "app为空", null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]StoreAvatar2D", 2, "IPC_APOLLO_CHECK_AVATAR_RES");
    }
    Object localObject1 = (ArrayList)paramSerializable;
    if (((ArrayList)localObject1).size() == 0)
    {
      QLog.e("[cmshow]StoreAvatar2D", 1, "IPC_APOLLO_CHECK_AVATAR_RES, no avatar params");
      paramSerializable = HardCodeUtil.a(2131904565);
      Intrinsics.checkExpressionValueIsNotNull(paramSerializable, "HardCodeUtil.qqStr(R.str….qqstr_messenge_c22663cd)");
      paramCheckAvatarResCallback.a(1, paramSerializable, null);
      return;
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)((Iterator)localObject1).next();
      if (android.text.TextUtils.isEmpty((CharSequence)localApolloWebAvatarParam.uin))
      {
        paramCheckAvatarResCallback.a(1, "uin为空", null);
        return;
      }
      Object localObject2;
      Object localObject3;
      if ((localApolloWebAvatarParam.roleId > 0) && (localApolloWebAvatarParam.dressIds != null) && (localApolloWebAvatarParam.dressIds.length > 0))
      {
        localObject2 = localAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "qqApp\n                  …ava, ProcessConstant.ALL)");
        localObject2 = (IApolloManagerService)localObject2;
        localObject3 = localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "qqApp\n                  …ava, ProcessConstant.ALL)");
        localObject3 = ((IApolloDaoManagerService)localObject3).getApolloBaseInfo(localApolloWebAvatarParam.uin);
        if ((localObject3 != null) && (((ApolloBaseInfo)localObject3).getApolloDress() == null)) {
          ((IApolloManagerService)localObject2).addToBulkPullMap(localApolloWebAvatarParam.uin, 2);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]StoreAvatar2D", 2, "IPC_APOLLO_CHECK_AVATAR_RES, roleId=0 or no dressIds");
        }
        localObject2 = localAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "qqApp\n                  …ava, ProcessConstant.ALL)");
        localObject2 = (IApolloManagerService)localObject2;
        localObject3 = localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "qqApp\n                  …ava, ProcessConstant.ALL)");
        localObject3 = ((IApolloDaoManagerService)localObject3).getApolloBaseInfo(localApolloWebAvatarParam.uin);
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
          localObject2 = localAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (localObject2 != null)
          {
            localObject2 = ((FriendsManager)localObject2).c(localApolloWebAvatarParam.uin);
            if (localObject2 != null)
            {
              if ((((Friends)localObject2).gender != 1) && (((Friends)localObject2).gender != 0)) {
                i = 2;
              } else {
                i = 1;
              }
              localApolloWebAvatarParam.roleId = i;
              if (QLog.isColorLevel()) {
                QLog.d("[cmshow]StoreAvatar2D", 2, new Object[] { "IPC_APOLLO_CHECK_AVATAR_RES, roleId=", Integer.valueOf(localApolloWebAvatarParam.roleId), ", apolloId=", localApolloWebAvatarParam.apolloId });
              }
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
          }
        }
        if ((localApolloWebAvatarParam.roleId > 0) && (localApolloWebAvatarParam.dressIds != null) && (localApolloWebAvatarParam.dressIds.length > 0))
        {
          localObject2 = ApolloResManagerFacade.a.a(Scene.WEB_STORE_OR_GAME);
          boolean bool = ((IApolloResManager)localObject2).b(localApolloWebAvatarParam.roleId);
          localObject3 = localApolloWebAvatarParam.dressIds;
          int j = localObject3.length;
          i = 0;
          while (i < j)
          {
            int k = localObject3[i];
            if ((bool) && (((IApolloResManager)localObject2).a(k))) {
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
    paramCheckAvatarResCallback.a(0, "", paramSerializable);
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "userData");
    Object localObject = b();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((AppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all");
    if (localObject != null)
    {
      ((ApolloDaoManagerServiceImpl)localObject).saveSelfApolloDress((AppRuntime)b(), paramString);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl");
  }
  
  public void a(@Nullable String paramString, long paramLong, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "dressId");
    Object localObject2 = b();
    if (localObject2 == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("apollo info uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", avatarTs: ");
    localStringBuilder.append(paramLong);
    if (android.text.TextUtils.isEmpty((CharSequence)paramString)) {
      return;
    }
    Object localObject1 = ((AppInterface)localObject2).getRuntimeService(IApolloManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "qqApp\n            .getRu…ava, ProcessConstant.ALL)");
    localObject1 = (IApolloManagerService)localObject1;
    localObject2 = ((AppInterface)localObject2).getRuntimeService(IApolloDaoManagerService.class, "all");
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "qqApp\n            .getRu…ava, ProcessConstant.ALL)");
    localObject2 = ((IApolloDaoManagerService)localObject2).getApolloBaseInfo(paramString);
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
        else if ((paramLong != 0L) && (paramLong != ((ApolloBaseInfo)localObject2).apolloServerTS))
        {
          i = j;
        }
        else
        {
          localObject2 = ((ApolloBaseInfo)localObject2).getApolloDress();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "apolloDress");
          localObject2 = ((ApolloDress)localObject2).getDressIds();
          if ((localObject2 != null) && (!ApolloUtilImpl.isSameDress((int[])localObject2, paramArrayOfInt))) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
    }
    if (i != 0)
    {
      ((IApolloManagerService)localObject1).addToBulkPullMap(paramString, 2);
      localStringBuilder.append(", sendReq");
    }
    QLog.d("[cmshow]StoreAvatar2D", 2, localStringBuilder.toString());
  }
  
  public void a(@NotNull String paramString, @NotNull IStoreAvatar2D.SetCapsuleCallback paramSetCapsuleCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    Intrinsics.checkParameterIsNotNull(paramSetCapsuleCallback, "callback");
    if (android.text.TextUtils.isEmpty((CharSequence)paramString))
    {
      paramSetCapsuleCallback.a(1);
      return;
    }
    ThreadManager.executeOnSubThread((Runnable)new StoreAvatar2D.setCapsule.1(this, paramString));
    paramSetCapsuleCallback.a(0);
  }
  
  public void a(@Nullable JSONArray paramJSONArray, @NotNull IStoreAvatar2D.AddCmFaceCallback paramAddCmFaceCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramAddCmFaceCallback, "callback");
    if (paramJSONArray == null)
    {
      paramJSONArray = HardCodeUtil.a(2131904569);
      Intrinsics.checkExpressionValueIsNotNull(paramJSONArray, "HardCodeUtil.qqStr(R.str….qqstr_messenge_e24be80e)");
      paramAddCmFaceCallback.a(1, paramJSONArray);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramJSONArray.length() == 0)
        {
          paramJSONArray = HardCodeUtil.a(2131904567);
          Intrinsics.checkExpressionValueIsNotNull(paramJSONArray, "HardCodeUtil.qqStr(R.str….qqstr_messenge_ddd57473)");
          paramAddCmFaceCallback.a(1, paramJSONArray);
          return;
        }
        localObject = new ArrayList();
        ArrayList localArrayList = ApolloUtilImpl.getAddedFaceList(b());
        int j = paramJSONArray.length();
        i = 0;
        if (i < j)
        {
          int k = QQSysFaceUtil.convertToLocal(paramJSONArray.getInt(i));
          if (com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(k))
          {
            ((ArrayList)localObject).add(Integer.valueOf(k));
            if ((localArrayList != null) && (localArrayList.contains(Integer.valueOf(k))))
            {
              k = localArrayList.indexOf(Integer.valueOf(k));
              if (k != -1) {
                localArrayList.remove(Integer.valueOf(k));
              }
            }
          }
        }
        else
        {
          i = ((ArrayList)localObject).size();
          if (i == 0)
          {
            paramJSONArray = HardCodeUtil.a(2131904564);
            Intrinsics.checkExpressionValueIsNotNull(paramJSONArray, "HardCodeUtil.qqStr(R.str….qqstr_messenge_b85098a4)");
            paramAddCmFaceCallback.a(1, paramJSONArray);
            return;
          }
          if (b() == null)
          {
            paramJSONArray = HardCodeUtil.a(2131904564);
            Intrinsics.checkExpressionValueIsNotNull(paramJSONArray, "HardCodeUtil.qqStr(R.str….qqstr_messenge_b85098a4)");
            paramAddCmFaceCallback.a(1, paramJSONArray);
            return;
          }
          paramJSONArray = b();
          if (paramJSONArray == null) {
            Intrinsics.throwNpe();
          }
          paramJSONArray = paramJSONArray.getRuntimeService(ICommonUsedSystemEmojiManagerService.class, "all");
          Intrinsics.checkExpressionValueIsNotNull(paramJSONArray, "app!!\n                .g…ava, ProcessConstant.ALL)");
          paramJSONArray = (ICommonUsedSystemEmojiManagerService)paramJSONArray;
          if (paramJSONArray == null)
          {
            paramJSONArray = HardCodeUtil.a(2131904568);
            Intrinsics.checkExpressionValueIsNotNull(paramJSONArray, "HardCodeUtil.qqStr(R.str….qqstr_messenge_de49f3e7)");
            paramAddCmFaceCallback.a(1, paramJSONArray);
            return;
          }
          Iterator localIterator = ((ArrayList)localObject).iterator();
          if (localIterator.hasNext())
          {
            Integer localInteger = (Integer)localIterator.next();
            EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
            PBUInt32Field localPBUInt32Field = localSmallYellowItem.id;
            Intrinsics.checkExpressionValueIsNotNull(localInteger, "localFaceId");
            localPBUInt32Field.set(localInteger.intValue());
            localSmallYellowItem.type.set(1);
            localSmallYellowItem.ts.set(System.currentTimeMillis());
            paramJSONArray.saveSystemEmojiInfoToCahce(localSmallYellowItem);
            continue;
          }
          paramJSONArray.saveSystemEmojiInfoToFile();
          paramJSONArray = b();
          if (paramJSONArray == null) {
            Intrinsics.throwNpe();
          }
          paramJSONArray = paramJSONArray.getHandler(ChatActivity.class);
          if (paramJSONArray != null)
          {
            paramJSONArray = paramJSONArray.obtainMessage(10);
            if (paramJSONArray != null) {
              paramJSONArray.sendToTarget();
            }
          }
          paramJSONArray = HardCodeUtil.a(2131904551);
          Intrinsics.checkExpressionValueIsNotNull(paramJSONArray, "HardCodeUtil.qqStr(R.str….qqstr_messenge_238a4668)");
          paramAddCmFaceCallback.a(0, paramJSONArray);
          if (localArrayList.size() > 0) {
            ((ArrayList)localObject).addAll((Collection)localArrayList);
          }
          ApolloUtilImpl.saveAddedFaceList(b(), (ArrayList)localObject);
          return;
        }
      }
      catch (Exception paramJSONArray)
      {
        QLog.e("[cmshow]StoreAvatar2D", 1, "IPC_APOLLO_ADD_CM_FACE, exception=", (Throwable)paramJSONArray);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131904558));
        ((StringBuilder)localObject).append(paramJSONArray.getMessage());
        paramAddCmFaceCallback.a(1, ((StringBuilder)localObject).toString());
        return;
      }
      i += 1;
    }
  }
  
  public void a(@Nullable JSONArray paramJSONArray, @NotNull IStoreAvatar2D.DelFavListCallback paramDelFavListCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramDelFavListCallback, "callback");
    ThreadManager.post((Runnable)new StoreAvatar2D.delFavList.1(this, paramJSONArray, paramDelFavListCallback), 5, null, false);
  }
  
  public void a(@Nullable JSONArray paramJSONArray, @NotNull IStoreAvatar2D.IsCmFaceAddedCallback paramIsCmFaceAddedCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIsCmFaceAddedCallback, "callback");
    if (paramJSONArray != null) {}
    try
    {
      if (paramJSONArray.length() != 0)
      {
        localObject = new JSONArray();
        ArrayList localArrayList = ApolloUtilImpl.getAddedFaceList(b());
        int j = paramJSONArray.length();
        int i = 0;
        while (i < j)
        {
          int k = paramJSONArray.getInt(i);
          JSONObject localJSONObject = new JSONObject();
          int m = QQSysFaceUtil.convertToLocal(k);
          boolean bool = com.tencent.mobileqq.text.TextUtils.isApolloEmoticon(m);
          if (bool)
          {
            if ((localArrayList != null) && (localArrayList.contains(Integer.valueOf(m))))
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
          ((JSONArray)localObject).put(i, localJSONObject);
          i += 1;
        }
        paramJSONArray = ((JSONArray)localObject).toString();
        localObject = HardCodeUtil.a(2131904573);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "HardCodeUtil.qqStr(R.str….qqstr_messenge_faceb5d3)");
        paramIsCmFaceAddedCallback.a(0, paramJSONArray, (String)localObject);
        return;
      }
      paramJSONArray = HardCodeUtil.a(2131904557);
      Intrinsics.checkExpressionValueIsNotNull(paramJSONArray, "HardCodeUtil.qqStr(R.str….qqstr_messenge_7e371ae1)");
      paramIsCmFaceAddedCallback.a(1, null, paramJSONArray);
      return;
    }
    catch (Exception paramJSONArray)
    {
      QLog.e("[cmshow]StoreAvatar2D", 1, "IPC_APOLLO_IS_CM_FACE_ADDED, exception=", (Throwable)paramJSONArray);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131904559));
      ((StringBuilder)localObject).append(paramJSONArray.getMessage());
      paramIsCmFaceAddedCallback.a(1, null, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(@NotNull JSONObject paramJSONObject, @NotNull IStoreAvatar2D.WriteLocalCallback paramWriteLocalCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "writeData");
    Intrinsics.checkParameterIsNotNull(paramWriteLocalCallback, "callback");
    ThreadManager.post((Runnable)new StoreAvatar2D.writeLocal.1(this, paramWriteLocalCallback, paramJSONObject), 5, null, false);
  }
  
  public void a(@NotNull int[] paramArrayOfInt, @NotNull IStoreAvatar2D.PreviewCallback paramPreviewCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "dressIds");
    Intrinsics.checkParameterIsNotNull(paramPreviewCallback, "callback");
    AppInterface localAppInterface = b();
    if (paramArrayOfInt.length == 0)
    {
      paramPreviewCallback.a(1, null);
      return;
    }
    IApolloResDownloader localIApolloResDownloader = ApolloResDownloaderFacade.a.a(Scene.WEB_STORE_OR_GAME);
    AppRuntime localAppRuntime = (AppRuntime)localAppInterface;
    if (localAppInterface == null) {
      Intrinsics.throwNpe();
    }
    localIApolloResDownloader.b(localAppRuntime, localAppInterface.getCurrentUin(), (IApolloResDownloader.OnApolloDownLoadListener)new StoreAvatar2D.preview.1(paramPreviewCallback), -1, paramArrayOfInt, -1, -1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.ipc.StoreAvatar2D
 * JD-Core Version:    0.7.0.1
 */