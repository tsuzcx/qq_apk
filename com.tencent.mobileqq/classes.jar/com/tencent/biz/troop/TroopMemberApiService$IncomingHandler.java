package com.tencent.biz.troop;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.apiproxy.QQMusicService;
import com.tencent.biz.apiproxy.WebPushService;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.api.IPublicAccountH5Manager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GameLoadData;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.Doraemon.DoraemonBridge;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoTaskV2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.intervideo.groupvideo.IGroupVideoManager;
import com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.mobileqq.kandian.ad.api.INativeAdPreloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.FirstCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentCreateData;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEmotionUtil;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.ITweetTopicEntranceShouldShowActionUtil;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoySkinHelper;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoySkinHelperFactory;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJDeliverUGCUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService;
import com.tencent.mobileqq.kandian.biz.video.upload.api.IVideoUploadManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngineFactory;
import com.tencent.mobileqq.kandian.repo.account.api.IRIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.api.IFaceScoreUtils;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.studyroom.api.IStudyRoomReporter;
import com.tencent.mobileqq.studyroom.api.IStudyRoomUploader;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopTokenHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.association.api.ITroopAssociationHandler;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.essence.api.ITroopEssenceHandler;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerBizHandler;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
import com.tencent.mobileqq.troop.utils.TroopAppShortcutUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.webview.UrlSecurityCheckManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopPluginManager;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.JudgeTopicVideoNumReq;
import tencent.im.oidb.cmd0xe2a.oidb_0xe2a.ReqBody;

class TroopMemberApiService$IncomingHandler
  extends Handler
{
  TroopMemberApiService$IncomingHandler(TroopMemberApiService paramTroopMemberApiService) {}
  
  private void a(int paramInt1, Bundle paramBundle, int paramInt2, String paramString)
  {
    paramBundle.putInt("resultCode", paramInt2);
    paramBundle.putString("resultMsg", paramString);
    this.a.a(paramInt1, paramBundle);
  }
  
  private void a(Bundle paramBundle)
  {
    paramBundle.putString("iid", ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getEncryptUin());
    a(162, paramBundle, 0, "success");
  }
  
  private void b(Bundle paramBundle)
  {
    int i = Aladdin.getConfig(410).getIntegerFromString("publish_enable_mode", 0);
    if (i == 0)
    {
      a(160, paramBundle, 2, "all close");
      return;
    }
    if (i == 1)
    {
      a(160, paramBundle, 1, "success");
      ((ITweetTopicEntranceShouldShowActionUtil)QRoute.api(ITweetTopicEntranceShouldShowActionUtil.class)).doShowEntranceReport();
      return;
    }
    ((IRIJUserLevelModule)QRoute.api(IRIJUserLevelModule.class)).requestUserLevel(10, new TroopMemberApiService.IncomingHandler.12(this, paramBundle));
  }
  
  private void c(Bundle paramBundle)
  {
    oidb_0xe2a.ReqBody localReqBody = new oidb_0xe2a.ReqBody();
    localReqBody.msg_judge_topic_video_num_req = new oidb_0xe2a.JudgeTopicVideoNumReq();
    ProtoUtils.a(TroopMemberApiService.k(this.a), new TroopMemberApiService.IncomingHandler.13(this, true, paramBundle), localReqBody.toByteArray(), "OidbSvc.0xe2a", 3626, 8, null, 0L);
  }
  
  private void d(Bundle paramBundle)
  {
    Object localObject = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    TroopMemberApiService.IncomingHandler.14 local14 = new TroopMemberApiService.IncomingHandler.14(this, paramBundle, (QQAppInterface)localObject);
    if (localObject != null) {
      ((IRIJUgcVideoPublishService)((QQAppInterface)localObject).getRuntimeService(IRIJUgcVideoPublishService.class)).addVideoPublishCallback(local14);
    }
    localObject = new JSONObject();
    try
    {
      paramBundle = new JSONObject(paramBundle.getString("extra"));
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
      paramBundle = (Bundle)localObject;
    }
    ((IRIJDeliverUGCUtils)QRoute.api(IRIJDeliverUGCUtils.class)).openSelectVideoPage(BaseApplicationImpl.getContext(), paramBundle, 5);
  }
  
  private void e(Bundle paramBundle)
  {
    String str = paramBundle.getString("ALD_CONFIG_RESULT");
    try
    {
      localJSONObject = new JSONObject(str);
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject;
      label19:
      break label19;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopMemberApiService", 2, "handleGetALDConfig result parse error.");
    }
    localJSONObject = null;
    if (str != null)
    {
      if (localJSONObject == null) {
        return;
      }
      paramBundle.putString("ALD_CONFIG_RESULT", Aladdin.getConfig(localJSONObject.optInt("id")).getString(localJSONObject.optString("key", ""), ""));
      this.a.a(154, paramBundle);
    }
  }
  
  private void f(Bundle paramBundle)
  {
    paramBundle.putString("key_emotion_data", ((IRIJCommentEmotionUtil)QRoute.api(IRIJCommentEmotionUtil.class)).getCommentEmotionDataForWeb());
    this.a.a(163, paramBundle);
  }
  
  private void g(Bundle paramBundle)
  {
    String str = paramBundle.getString("BUNDLE_KEY_JS_OBJ");
    Object localObject2 = null;
    boolean bool2 = true;
    boolean bool1 = true;
    try
    {
      localObject1 = new JSONObject(str);
    }
    catch (JSONException localJSONException)
    {
      Object localObject1;
      label31:
      Parcelable localParcelable;
      int i;
      CommentData localCommentData;
      JSONArray localJSONArray;
      int j;
      break label31;
    }
    QLog.e("TroopMemberApiService", 1, "handleCommentEditorNativeResult(server) result parse error.");
    localObject1 = null;
    if ((str != null) && (localObject1 != null))
    {
      localParcelable = paramBundle.getParcelable("BUNDLE_KEY_CREATE_COMMENT_DATA");
      i = ((JSONObject)localObject1).optInt("biuAfterComment", 0);
      localCommentData = new CommentData();
      ((IRIJCommentRptDataUtil)QRoute.api(IRIJCommentRptDataUtil.class)).parseCommentContentFromJson((JSONObject)localObject1, localCommentData);
      localJSONArray = ((JSONObject)localObject1).optJSONArray("linkList");
      if (localJSONArray != null)
      {
        localObject2 = new TroopMemberApiService.IncomingHandler.15(this).getType();
        localObject2 = (List)new Gson().fromJson(localJSONArray.toString(), (Type)localObject2);
      }
      j = ((JSONObject)localObject1).optInt("feedsType");
      paramBundle = new TroopMemberApiService.IncomingHandler.16(this, (JSONObject)localObject1, localCommentData, localJSONArray, paramBundle);
      if ((localParcelable instanceof FirstCommentCreateData))
      {
        localObject1 = (FirstCommentCreateData)localParcelable;
        ((FirstCommentCreateData)localObject1).a(localCommentData.commentContent);
        ((FirstCommentCreateData)localObject1).a(localCommentData.commentRptDataList);
        ((FirstCommentCreateData)localObject1).b((List)localObject2);
        localObject2 = (IRIJCommentNetworkHelper)QRoute.api(IRIJCommentNetworkHelper.class);
        if (i != 1) {
          bool1 = false;
        }
        ((IRIJCommentNetworkHelper)localObject2).createFirstComment((FirstCommentCreateData)localObject1, paramBundle, str, j, false, bool1);
        return;
      }
      if ((localParcelable instanceof SubCommentCreateData))
      {
        localObject1 = (SubCommentCreateData)localParcelable;
        ((SubCommentCreateData)localObject1).d(localCommentData.commentContent);
        ((SubCommentCreateData)localObject1).a(localCommentData.commentRptDataList);
        ((SubCommentCreateData)localObject1).b((List)localObject2);
        localObject2 = (IRIJCommentNetworkHelper)QRoute.api(IRIJCommentNetworkHelper.class);
        if (i == 1) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        ((IRIJCommentNetworkHelper)localObject2).createSubComment((SubCommentCreateData)localObject1, paramBundle, str, j, false, bool1);
      }
      return;
    }
  }
  
  private void h(Bundle paramBundle)
  {
    Object localObject2 = (QQAppInterface)TroopMemberApiService.l(this.a);
    Object localObject1 = TroopMemberApiService.m(this.a);
    String str1 = "";
    localObject1 = ((IPhoneContactService)((AppRuntime)localObject1).getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
    if (localObject1 != null) {
      localObject1 = ((RespondQueryQQBindingStat)localObject1).mobileNo;
    } else {
      localObject1 = "";
    }
    String str3 = ((QQAppInterface)localObject2).getCurrentNickname();
    localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0).getString("cur_city", null);
    if (localObject2 != null)
    {
      String[] arrayOfString = ((String)localObject2).split("-");
      if (arrayOfString.length > 0)
      {
        String str2 = arrayOfString[0];
        localObject2 = str2;
        if (arrayOfString.length < 2) {
          break label132;
        }
        str1 = arrayOfString[1];
        localObject2 = str2;
        break label132;
      }
    }
    localObject2 = "";
    label132:
    paramBundle.putString("phone", (String)localObject1);
    paramBundle.putString("name", str3);
    paramBundle.putString("city", (String)localObject2);
    paramBundle.putString("area", str1);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject11 = TroopMemberApiService.j(this.a);
    boolean bool4 = localObject11 instanceof QQAppInterface;
    Object localObject1;
    Object localObject9;
    Object localObject7;
    Object localObject5;
    if (bool4)
    {
      localObject1 = (QQAppInterface)localObject11;
      localObject9 = (LBSHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER);
      localObject7 = (ITroopMemberListHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
      localObject5 = (ITroopModifyHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.TROOP_MODIFY_HANDLER);
      localObject1 = (ITroopManagerBizHandler)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
    }
    else
    {
      localObject1 = null;
      localObject7 = null;
      localObject9 = null;
      localObject5 = null;
    }
    if ((paramMessage != null) && (localObject11 != null))
    {
      if (!bool4) {
        return;
      }
      Object localObject10 = paramMessage.getData();
      if (localObject10 == null) {
        return;
      }
      ((Bundle)localObject10).setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
      int i = paramMessage.what;
      Object localObject8 = "";
      boolean bool2 = true;
      boolean bool3 = true;
      boolean bool1 = true;
      switch (i)
      {
      }
      for (;;)
      {
        break;
        f((Bundle)localObject10);
        continue;
        a((Bundle)localObject10);
        continue;
        c((Bundle)localObject10);
        continue;
        b((Bundle)localObject10);
        continue;
        ((IStudyRoomUploader)QRoute.api(IStudyRoomUploader.class)).cancelPicUpload((Bundle)localObject10);
        continue;
        ((IStudyRoomUploader)QRoute.api(IStudyRoomUploader.class)).startPicUpload((Bundle)localObject10, new TroopMemberApiService.IncomingHandler.8(this, (Bundle)localObject10));
        continue;
        localObject1 = (ITroopAssociationHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_ASSOCIATION_HANDLER);
        if (localObject1 != null)
        {
          ((ITroopAssociationHandler)localObject1).a(((Bundle)localObject10).getString("troopUin", ""), ((Bundle)localObject10).getInt("opType", 0), ((Bundle)localObject10).getString("startTroopUin", ""));
          continue;
          localObject1 = (ITroopEssenceHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_ESSENCE_MSG_HANDLER);
          if (localObject1 != null)
          {
            ((ITroopEssenceHandler)localObject1).a(((Bundle)localObject10).getString("troopUin"), ((Bundle)localObject10).getBoolean("isChecked"));
            continue;
            e((Bundle)localObject10);
            continue;
            g((Bundle)localObject10);
            continue;
            if (localObject1 != null)
            {
              ((ITroopManagerBizHandler)localObject1).b(((Bundle)localObject10).getString("troopUin"), ((Bundle)localObject10).getBoolean("isChecked"));
              continue;
              short s = ((Bundle)localObject10).getShort("tmpPushType");
              bool1 = ((Bundle)localObject10).getBoolean("enable");
              ((TempMsgManager)((AppRuntime)localObject11).getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(s, bool1, true);
              ((Bundle)localObject10).putBoolean("enable", bool1);
              ((Bundle)localObject10).putBoolean("success", true);
              ((Bundle)localObject10).putInt("seq", ((Bundle)localObject10).getInt("seq"));
              this.a.a(152, (Bundle)localObject10);
              continue;
              s = ((Bundle)localObject10).getShort("tmpPushType");
              ((Bundle)localObject10).putBoolean("enable", ((TempMsgManager)((AppRuntime)localObject11).getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(s));
              ((Bundle)localObject10).putInt("seq", ((Bundle)localObject10).getInt("seq"));
              this.a.a(151, (Bundle)localObject10);
              continue;
              localObject5 = ((Bundle)localObject10).getString("groupCode");
              localObject7 = ((Bundle)localObject10).getString("appID");
              localObject8 = ((Bundle)localObject10).getString("url");
              localObject1 = ((Bundle)localObject10).getString("source");
              if (QLog.isColorLevel()) {
                QLog.d("TroopMemberApiService", 2, String.format("MSG_LAUNCH_GROUP_APP, groupCode: %s, appID: %s, url: %s, source: %s", new Object[] { localObject5, localObject7, localObject8, localObject1 }));
              }
              if (BaseActivity.sTopActivity != null) {
                localObject1 = BaseActivity.sTopActivity;
              } else {
                localObject1 = this.a.getApplicationContext();
              }
              if (!(localObject1 instanceof BaseActivity)) {
                localObject1 = null;
              }
              TroopAppShortcutUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), BaseApplicationImpl.getContext(), (BaseActivity)localObject1, (String)localObject5, Long.parseLong((String)localObject7), (String)localObject8, 1, 0);
              continue;
              ((Bundle)localObject10).getString("fromId");
              ((IGroupVideoManager)((AppRuntime)localObject11).getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(null, 10L);
              continue;
              localObject5 = ((Bundle)localObject10).getString("code");
              localObject1 = new String[4];
              localObject1[0] = "0";
              localObject1[1] = "0";
              localObject1[2] = "0";
              localObject1[3] = "0";
              try
              {
                if (!TextUtils.isEmpty((CharSequence)localObject5))
                {
                  localObject5 = new JSONObject((String)localObject5);
                  localObject1[0] = ((JSONObject)localObject5).optString("country", "0");
                  localObject1[1] = ((JSONObject)localObject5).optString("province", "0");
                  localObject1[2] = ((JSONObject)localObject5).optString("city", "0");
                  localObject1[3] = ((JSONObject)localObject5).optString("area", "0");
                }
              }
              catch (JSONException localJSONException)
              {
                localJSONException.printStackTrace();
              }
              if (this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager == null)
              {
                this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager = ((ConditionSearchManager)((AppRuntime)localObject11).getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER));
                this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(this);
              }
              Object localObject6 = new Intent(BaseApplicationImpl.getContext(), LocationSelectActivity.class);
              ((Intent)localObject6).putExtra("param_is_popup", false);
              ((Intent)localObject6).putExtra("param_req_type", 2);
              ((Intent)localObject6).putExtra("param_location", (String[])localObject1);
              ((Intent)localObject6).putExtra("param_location_param", this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b((String[])localObject1));
              BaseApplicationImpl.getContext().startActivity((Intent)localObject6);
              continue;
              this.a.a().a((AppRuntime)localObject11, (Bundle)localObject10);
              continue;
              localObject1 = (UrlSecurityCheckManager)((AppRuntime)localObject11).getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
              localObject6 = ((Bundle)localObject10).getString("appid");
              localObject7 = ((Bundle)localObject10).getString("openid");
              localObject8 = ((Bundle)localObject10).getString("troopuin");
              i = ((Bundle)localObject10).getInt("seq");
              localObject9 = ((Bundle)localObject10).getString("processName");
              if (localObject1 != null)
              {
                ((UrlSecurityCheckManager)localObject1).a((String)localObject6, (String)localObject7, (String)localObject8, new TroopMemberApiService.IncomingHandler.11(this, i, (String)localObject9));
              }
              else
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putInt("seq", i);
                ((Bundle)localObject1).putString("processName", (String)localObject9);
                ((Bundle)localObject1).putInt("result", -1);
                this.a.a(146, (Bundle)localObject1);
                continue;
                bool1 = ((Bundle)localObject10).getBoolean("isOpen");
                localObject1 = ((Bundle)localObject10).getString("troopUin");
                if (QLog.isColorLevel()) {
                  QLog.d("TroopHonor.jsapi", 2, String.format("switch troop honor aio, troopUin: %s, isOpen: %s", new Object[] { localObject1, Boolean.valueOf(bool1) }));
                }
                ((ITroopHonorService)((AppRuntime)localObject11).getRuntimeService(ITroopHonorService.class, "")).updateTroopHonorAIOSwitch((String)localObject1, bool1);
                continue;
                if (BaseActivity.sTopActivity != null) {
                  localObject1 = BaseActivity.sTopActivity;
                } else {
                  localObject1 = this.a.getApplicationContext();
                }
                if (localObject1 != null)
                {
                  ((IKandianDailyManager)QRoute.api(IKandianDailyManager.class)).launchKandianDaily((Context)localObject1);
                  continue;
                  localObject1 = ((Bundle)localObject10).getString("uin");
                  SubscribeFollowUserUtil.c(BaseApplicationImpl.getContext(), (String)localObject1, null);
                  continue;
                  try
                  {
                    localObject1 = (UrlSecurityCheckManager)((AppRuntime)localObject11).getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
                    if (localObject1 != null)
                    {
                      ((UrlSecurityCheckManager)localObject1).a((Bundle)localObject10);
                      continue;
                    }
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("TroopMemberApiService", 2, "report passwd forbid fail");
                  }
                  catch (Throwable localThrowable)
                  {
                    QLog.e("TroopMemberApiService", 2, localThrowable, new Object[0]);
                  }
                  continue;
                  h((Bundle)localObject10);
                  this.a.a(141, (Bundle)localObject10);
                  continue;
                  ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doGdtWebClickReport();
                  continue;
                  Object localObject2 = ((IRIJAdService)QRoute.api(IRIJAdService.class)).getAdCache(2);
                  if ((localObject2 != null) && ((localObject2 instanceof GameLoadData)))
                  {
                    ((GameLoadData)localObject2).a((Bundle)localObject10);
                    continue;
                    bool1 = ((Bundle)localObject10).getBoolean("isSuccess");
                    localObject2 = ((Bundle)localObject10).getString("pkgname");
                    ReadInJoyLogicEngineEventDispatcher.a().a(null, 101, bool1, new String[] { localObject2 });
                    continue;
                    i = ((Bundle)localObject10).getInt("deleteType");
                    localObject2 = ((Bundle)localObject10).getString("uin");
                    int j = ((Bundle)localObject10).getInt("msgType");
                    TroopMemberApiService.SayHiMessageHelper.b((QQAppInterface)localObject11, (String)localObject2, i, j);
                    continue;
                    i = ((Bundle)localObject10).getInt("clearType");
                    j = ((Bundle)localObject10).getInt("msgType");
                    localObject2 = ((Bundle)localObject10).getString("uin");
                    TroopMemberApiService.SayHiMessageHelper.a((QQAppInterface)localObject11, (String)localObject2, i, j);
                    continue;
                    i = ((Bundle)localObject10).getInt("start");
                    j = ((Bundle)localObject10).getInt("msgType");
                    int k = ((Bundle)localObject10).getInt("count");
                    localObject2 = TroopMemberApiService.SayHiMessageHelper.a(this.a.getApplicationContext(), (QQAppInterface)localObject11, i, j, k);
                    if (localObject2 != null) {
                      ((Bundle)localObject10).putString("sayhiinfo", ((JSONObject)localObject2).toString());
                    }
                    this.a.a(129, (Bundle)localObject10);
                    continue;
                    ((Bundle)localObject10).putString("nickName", ((QQAppInterface)localObject11).getCurrentNickname());
                    this.a.a(128, (Bundle)localObject10);
                    continue;
                    if (((Bundle)localObject10).getBoolean("open_readinjoy_tab"))
                    {
                      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateLocalCacheSwitch(1);
                      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateKandianTabConfigSwitchSp(true);
                      ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateHasSetSwitch(true);
                    }
                    if (BaseActivity.sTopActivity != null) {
                      localObject2 = BaseActivity.sTopActivity;
                    } else {
                      localObject2 = this.a.getApplicationContext();
                    }
                    if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowMainRecommendTab())
                    {
                      j = 12;
                      try
                      {
                        localObject6 = ((Bundle)localObject10).getString("from");
                        i = j;
                        if (!TextUtils.isEmpty((CharSequence)localObject6))
                        {
                          i = j;
                          if (TextUtils.isDigitsOnly((CharSequence)localObject6)) {
                            i = Integer.valueOf((String)localObject6).intValue();
                          }
                        }
                        ((Context)localObject2).startActivity(((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent((Context)localObject2, i));
                      }
                      catch (Exception localException1) {}
                      if (QLog.isColorLevel()) {
                        QLog.e("JumpAction", 1, "jump activity error1 ", localException1);
                      }
                    }
                    else
                    {
                      localObject6 = (QQAppInterface)localObject11;
                      if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle())
                      {
                        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(localException1, 2, 0);
                      }
                      else
                      {
                        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(localException1, null, -1L, 2);
                        continue;
                        i = ((Bundle)localObject10).getInt("seq");
                        Object localObject3 = (QQAppInterface)localObject11;
                        localObject6 = ((FriendsManager)((AppRuntime)localObject11).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(((QQAppInterface)localObject3).getCurrentUin());
                        if (localObject6 != null)
                        {
                          if (QLog.isColorLevel())
                          {
                            localObject7 = new StringBuilder();
                            ((StringBuilder)localObject7).append("get user gender:");
                            ((StringBuilder)localObject7).append(((Card)localObject6).shGender);
                            QLog.d("TroopMemberApiService", 2, ((StringBuilder)localObject7).toString());
                          }
                          ((Bundle)localObject10).putShort("gender", ((Card)localObject6).shGender);
                        }
                        ((Bundle)localObject10).putString("facePath", ((QQAppInterface)localObject3).getCustomFaceFilePath(1, ((QQAppInterface)localObject3).getCurrentAccountUin(), 0));
                        ((Bundle)localObject10).putInt("seq", i);
                        this.a.a(126, (Bundle)localObject10);
                        continue;
                        ((QQStoryHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).c(((Bundle)localObject10).getInt("reqUserSetEnableAlbumScan"));
                        continue;
                        if (BaseActivity.sTopActivity != null) {
                          localObject3 = BaseActivity.sTopActivity;
                        } else {
                          localObject3 = this.a.getApplicationContext();
                        }
                        ((IKandianSubscribeManager)((AppRuntime)localObject11).getRuntimeService(IKandianSubscribeManager.class, "")).lanuchKandianSubscribeActivity((Context)localObject3, 3, 4);
                        continue;
                        localObject3 = ((Bundle)localObject10).getString("content");
                        i = ((Bundle)localObject10).getInt("seq");
                        localObject6 = (DataLineHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
                        if ((localObject6 == null) || (((DataLineHandler)localObject6).a((String)localObject3, 0).longValue() <= 0L)) {
                          bool1 = false;
                        }
                        localObject3 = new Bundle();
                        ((Bundle)localObject3).putBoolean("isSuccess", bool1);
                        ((Bundle)localObject3).putInt("seq", i);
                        this.a.a(122, (Bundle)localObject3);
                        continue;
                        localObject6 = ((Bundle)localObject10).getString("url");
                        i = ((Bundle)localObject10).getInt("type", -1);
                        j = ((Bundle)localObject10).getInt("msgfrom", 0);
                        localObject7 = ((Bundle)localObject10).getString("senderUin");
                        localObject8 = ((Bundle)localObject10).getString("chatId");
                        localObject9 = ((Bundle)localObject10).getString("source");
                        k = ((Bundle)localObject10).getInt("seq");
                        localObject3 = ((Bundle)localObject10).getString("processName");
                        String str1 = ((Bundle)localObject10).getString("originUrl");
                        String str2 = ((Bundle)localObject10).getString("ark_business_name");
                        bool1 = ((Bundle)localObject10).getBoolean("is_page_finish", false);
                        localObject10 = ((Bundle)localObject10).getStringArrayList("pre_jump_urls");
                        localObject11 = (UrlSecurityCheckManager)((AppRuntime)localObject11).getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
                        if (localObject11 != null)
                        {
                          ((UrlSecurityCheckManager)localObject11).a((String)localObject6, i, j, (String)localObject7, (String)localObject8, (String)localObject9, str1, str2, bool1, (ArrayList)localObject10, new TroopMemberApiService.IncomingHandler.10(this, k, (String)localObject3));
                        }
                        else
                        {
                          localObject6 = new Bundle();
                          ((Bundle)localObject6).putInt("seq", k);
                          ((Bundle)localObject6).putString("processName", (String)localObject3);
                          this.a.a(121, (Bundle)localObject6);
                          continue;
                          localObject6 = ((Bundle)localObject10).getString("troopUin");
                          bool1 = ((Bundle)localObject10).getBoolean("isChecked");
                          if (localObject3 != null)
                          {
                            ((ITroopManagerBizHandler)localObject3).a((String)localObject6, bool1);
                            continue;
                            long l1 = ((Bundle)localObject10).getLong("followUin");
                            i = ((Bundle)localObject10).getInt("followInfo");
                            if ((i == 2) || (i == 1))
                            {
                              localObject3 = ReadInJoyLogicEngineEventDispatcher.a();
                              if (i == 2) {
                                bool1 = true;
                              } else {
                                bool1 = false;
                              }
                              ((ReadInJoyLogicEngineEventDispatcher)localObject3).b(l1, bool1);
                              ThreadManager.post(new TroopMemberApiService.IncomingHandler.9(this, l1, i), 8, null, true);
                              continue;
                              i = ((Bundle)localObject10).getInt("seq");
                              if (this.a.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonBridge == null) {
                                this.a.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonBridge = new DoraemonBridge((AppRuntime)localObject11);
                              }
                              localObject7 = this.a.jdField_b_of_type_AndroidOsMessenger;
                              if (localObject10 != null) {
                                localObject3 = ((Bundle)localObject10).getString("processName");
                              } else {
                                localObject3 = null;
                              }
                              localObject6 = localObject7;
                              if (localObject3 != null)
                              {
                                localObject6 = localObject7;
                                if (this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
                                {
                                  localObject6 = localObject7;
                                  if (this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject3) != null) {
                                    localObject6 = (Messenger)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject3);
                                  }
                                }
                              }
                              this.a.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonBridge.a(118, (Bundle)localObject10, i, (Messenger)localObject6);
                              continue;
                              if (QLog.isColorLevel()) {
                                QLog.d("TroopMemberApiService", 2, "MSG_STUDY_ROOM_BEACON_REPORT");
                              }
                              ((IStudyRoomReporter)QRoute.api(IStudyRoomReporter.class)).reportWithBundle(((Bundle)localObject10).getBundle("reportData"));
                              continue;
                              if (QLog.isColorLevel()) {
                                QLog.d("TroopMemberApiService", 2, "MSG_STUDY_ROOM_PRELOAD");
                              }
                              if (bool4)
                              {
                                ((StudyRoomManager)((AppRuntime)localObject11).getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(BaseApplicationImpl.getContext());
                                continue;
                                if (QLog.isColorLevel()) {
                                  QLog.d("TroopMemberApiService", 2, "MSG_HOMEWORK_TROOP_CLEAR_RED_POINT");
                                }
                                localObject3 = ((Bundle)localObject10).getString("troopUin");
                                localObject6 = ((Bundle)localObject10).getString("type");
                                if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (String.valueOf(1104445552).equals(localObject6)))
                                {
                                  localObject6 = (IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class);
                                  localObject7 = (QQAppInterface)localObject11;
                                  if (((IHWTroopUtilsApi)localObject6).getAIOHomeworkBtnRedPoint((AppRuntime)localObject7, (String)localObject3) != 0)
                                  {
                                    ((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).clearHomeworkTroopRedPoint((AppInterface)localObject7, (String)localObject3);
                                    continue;
                                    localObject3 = (QQAppInterface)localObject11;
                                    localObject6 = new Intent(((QQAppInterface)localObject3).getApp().getApplicationContext(), SplashActivity.class);
                                    ((Intent)localObject6).putExtras((Bundle)localObject10);
                                    localObject6 = AIOUtils.a((Intent)localObject6, null);
                                    localObject7 = ForwardUtils.a((Intent)localObject6);
                                    ForwardUtils.a((QQAppInterface)localObject3, ((QQAppInterface)localObject3).getApp().getApplicationContext(), (SessionInfo)localObject7, (Intent)localObject6);
                                    continue;
                                    ((Bundle)localObject10).putInt("readinjoy_to_wx_config", ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getReadInjoyShareToWxAtSwitch());
                                    this.a.a(113, (Bundle)localObject10);
                                    continue;
                                    this.a.jdField_c_of_type_JavaLangString = ((Bundle)localObject10).getString("callback");
                                    this.a.g = ((Bundle)localObject10).getInt("seq");
                                    localObject3 = ((Bundle)localObject10).getString("troopUin");
                                    localObject6 = ((Bundle)localObject10).getString("chatType");
                                    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && ("group".equals(localObject6)))
                                    {
                                      localObject6 = (ITroopInfoHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
                                      if (localObject6 != null) {
                                        ((ITroopInfoHandler)localObject6).a((String)localObject3, false, "TroopMemberApiService.create_troop", true, true, false, false);
                                      }
                                    }
                                    else
                                    {
                                      if (QLog.isColorLevel())
                                      {
                                        localObject7 = new StringBuilder();
                                        ((StringBuilder)localObject7).append("notifyTroopCreate error. troopCode=");
                                        ((StringBuilder)localObject7).append((String)localObject3);
                                        ((StringBuilder)localObject7).append(", chatType=");
                                        ((StringBuilder)localObject7).append((String)localObject6);
                                        QLog.i("TroopMemberApiService", 2, ((StringBuilder)localObject7).toString());
                                      }
                                      localObject3 = new Bundle();
                                      ((Bundle)localObject3).putBoolean("isSuccess", false);
                                      ((Bundle)localObject3).putInt("seq", this.a.g);
                                      ((Bundle)localObject3).putString("callback", this.a.jdField_c_of_type_JavaLangString);
                                      this.a.a(112, (Bundle)localObject3);
                                      continue;
                                      if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper == null) {
                                        this.a.jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper = ((IReadInJoySkinHelperFactory)QRoute.api(IReadInJoySkinHelperFactory.class)).createReadInJoySkinHelper((AppRuntime)localObject11, this.a);
                                      }
                                      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper.c((Bundle)localObject10);
                                      continue;
                                      if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper == null) {
                                        this.a.jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper = ((IReadInJoySkinHelperFactory)QRoute.api(IReadInJoySkinHelperFactory.class)).createReadInJoySkinHelper((AppRuntime)localObject11, this.a);
                                      }
                                      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper.b((Bundle)localObject10);
                                      continue;
                                      if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper == null) {
                                        this.a.jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper = ((IReadInJoySkinHelperFactory)QRoute.api(IReadInJoySkinHelperFactory.class)).createReadInJoySkinHelper((AppRuntime)localObject11, this.a);
                                      }
                                      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizSkinApiIReadInJoySkinHelper.a((Bundle)localObject10);
                                      continue;
                                      i = ((Bundle)localObject10).getInt("topicId");
                                      j = ((Bundle)localObject10).getInt("followInfo");
                                      if (!((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().a(i, j))
                                      {
                                        ((IReadInJoyLogicEngineFactory)QRoute.api(IReadInJoyLogicEngineFactory.class)).createReadInJoyLogicEngine().d(i, j);
                                        continue;
                                        bool1 = ((Bundle)localObject10).getBoolean("isTroopProfileAppListChanged");
                                        localObject3 = ((Bundle)localObject10).getString("profileAppListChangedTroopUin");
                                        ((ITroopAppService)((AppRuntime)localObject11).getRuntimeService(ITroopAppService.class, "all")).setProfileAppListChangedFromWebOperate(bool1, (String)localObject3);
                                        continue;
                                        localObject3 = (INativeAdPreloadService)((AppRuntime)localObject11).getRuntimeService(INativeAdPreloadService.class, "all");
                                        if (localObject3 != null)
                                        {
                                          ((INativeAdPreloadService)localObject3).clearPreloadList();
                                          continue;
                                          localObject3 = ((Bundle)localObject10).getStringArrayList("preloadList");
                                          localObject6 = (INativeAdPreloadService)((AppRuntime)localObject11).getRuntimeService(INativeAdPreloadService.class, "all");
                                          if (localObject6 != null)
                                          {
                                            ((INativeAdPreloadService)localObject6).addImagesToPreload((ArrayList)localObject3);
                                            continue;
                                            this.a.f = ((Bundle)localObject10).getInt("seq", -1);
                                            localObject3 = ((Bundle)localObject10).getStringArrayList("tinyIdList");
                                            localObject6 = (IHotChatHandler)((QQAppInterface)localObject11).getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
                                            if (localObject6 != null)
                                            {
                                              ((IHotChatHandler)localObject6).getUinByTinyId((ArrayList)localObject3);
                                              continue;
                                              ((Bundle)localObject10).getString("troopCode");
                                              localObject3 = ((Bundle)localObject10).getString("rid");
                                              localObject6 = new TroopMemberApiService.IncomingHandler.7(this, (Bundle)localObject10);
                                              ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatSCHelper((QQAppInterface)localObject11, (IHotChatSCHelper.OnShowNoteListener)localObject6, (String)localObject3);
                                              this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper.startCheck(10000L);
                                              continue;
                                              localObject3 = ((Bundle)localObject10).getString("troopCode");
                                              localObject6 = ((Bundle)localObject10).getString("uin");
                                              localObject7 = (IHotChatHandler)((QQAppInterface)localObject11).getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
                                              if (localObject7 != null)
                                              {
                                                ((IHotChatHandler)localObject7).openHotChatMemberProfileCard((String)localObject3, (String)localObject6);
                                                continue;
                                                localObject3 = ((Bundle)localObject10).getString("troopCode");
                                                localObject6 = ((Bundle)localObject10).getString("uin");
                                                localObject7 = ((Bundle)localObject10).getString("nick");
                                                localObject8 = (IHotChatHandler)((QQAppInterface)localObject11).getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
                                                if (localObject8 != null)
                                                {
                                                  ((IHotChatHandler)localObject8).deleteMember((String)localObject3, (String)localObject6, (String)localObject7);
                                                  continue;
                                                  localObject3 = ((Bundle)localObject10).getString("troopCode");
                                                  localObject6 = (IHotChatHandler)((QQAppInterface)localObject11).getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
                                                  if (localObject6 != null)
                                                  {
                                                    ((IHotChatHandler)localObject6).closeHotChatPie((String)localObject3);
                                                    continue;
                                                    localObject3 = ((Bundle)localObject10).getString("troopCode");
                                                    localObject6 = ((Bundle)localObject10).getString("uin");
                                                    localObject7 = (IHotChatHandler)((QQAppInterface)localObject11).getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
                                                    if (localObject7 != null)
                                                    {
                                                      ((IHotChatHandler)localObject7).sendGiftToPerson((String)localObject3, (String)localObject6);
                                                      continue;
                                                      localObject3 = ((Bundle)localObject10).getString("troopCode");
                                                      localObject6 = ((Bundle)localObject10).getString("uin");
                                                      localObject7 = ((Bundle)localObject10).getString("nick");
                                                      localObject8 = (IHotChatHandler)((QQAppInterface)localObject11).getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
                                                      if (localObject8 != null)
                                                      {
                                                        ((IHotChatHandler)localObject8).insertAtTroopMem((String)localObject3, (String)localObject6, (String)localObject7);
                                                        continue;
                                                        localObject3 = ((Bundle)localObject10).getString("uin");
                                                        i = ((Bundle)localObject10).getInt("index");
                                                        localObject3 = AdvertisementRecentUserManager.a().a((String)localObject3);
                                                        if (localObject3 != null)
                                                        {
                                                          localObject6 = (AdvertisementVideoPreloadManager)((AppRuntime)localObject11).getManager(QQManagerFactory.PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER);
                                                          if (localObject6 != null)
                                                          {
                                                            ((AdvertisementVideoPreloadManager)localObject6).a((AdvertisementItem)localObject3, i);
                                                            continue;
                                                            i = ((Bundle)localObject10).getInt("isGroupCode");
                                                            localObject3 = ((Bundle)localObject10).getString("roomId");
                                                            localObject6 = ((Bundle)localObject10).getString("action");
                                                            localObject7 = ((Bundle)localObject10).getString("fromId");
                                                            localObject8 = ((Bundle)localObject10).getString("backType");
                                                            localObject9 = ((Bundle)localObject10).getString("openType");
                                                            localObject10 = ((Bundle)localObject10).getString("extra");
                                                            ((IGroupVideoManager)((AppRuntime)localObject11).getManager(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER)).a(this.a, (String)localObject3, ((QQAppInterface)localObject11).getCurrentAccountUin(), i, (String)localObject6, (String)localObject7, (String)localObject8, (String)localObject9, (String)localObject10);
                                                            continue;
                                                            if (this.a.jdField_b_of_type_Boolean) {
                                                              return;
                                                            }
                                                            this.a.jdField_b_of_type_Boolean = true;
                                                            bool1 = NetworkUtil.isNetworkAvailable(null);
                                                            localObject3 = new StringBuilder();
                                                            ((StringBuilder)localObject3).append("startDownloadConfig netUsable=");
                                                            ((StringBuilder)localObject3).append(bool1);
                                                            VideoEnvironment.LogDownLoad("TroopMemberApiService", ((StringBuilder)localObject3).toString(), null);
                                                            if (bool1)
                                                            {
                                                              VideoEnvironment.LogDownLoad("TroopMemberApiService", HardCodeUtil.a(2131715421), null);
                                                              ShortVideoResourceManager.b((QQAppInterface)localObject11, new TroopMemberApiService.IncomingHandler.6(this, (AppRuntime)localObject11, (Bundle)localObject10));
                                                            }
                                                            else
                                                            {
                                                              ((Bundle)localObject10).putInt("result", -1);
                                                              this.a.a(93, (Bundle)localObject10);
                                                              continue;
                                                              ((IDynamicNowManager)((AppRuntime)localObject11).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).c((Bundle)localObject10);
                                                              continue;
                                                              l1 = ((Bundle)localObject10).getLong("roomId");
                                                              localObject3 = new Bundle();
                                                              ((Bundle)localObject3).putInt("jumpType", 1);
                                                              ((Bundle)localObject3).putString("roomid", String.valueOf(l1));
                                                              ((IDynamicNowManager)((AppRuntime)localObject11).getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a((Bundle)localObject3);
                                                              continue;
                                                              localObject3 = ((Bundle)localObject10).getString("troopUin");
                                                              localObject6 = ((Bundle)localObject10).getString("path");
                                                              i = ((Bundle)localObject10).getInt("msgTailType", 0);
                                                              localObject7 = new Intent();
                                                              ((Intent)localObject7).putExtra("send_in_background", true);
                                                              ((Intent)localObject7).putExtra("file_send_path", (String)localObject6);
                                                              ((Intent)localObject7).putExtra("file_send_size", new File((String)localObject6).length());
                                                              ((Intent)localObject7).putExtra("file_send_duration", ShortVideoUtils.getDurationOfVideo((String)localObject6));
                                                              ((Intent)localObject7).putExtra("uin", (String)localObject3);
                                                              ((Intent)localObject7).putExtra("uintype", 1);
                                                              ((Intent)localObject7).putExtra("file_source", "album_flow");
                                                              ((Intent)localObject7).putExtra("short_video_msg_tail_type", i);
                                                              new SendVideoTaskV2((Intent)localObject7).execute(new Void[0]);
                                                              this.a.a(87, (Bundle)localObject10);
                                                              continue;
                                                              localObject3 = new Bundle();
                                                              ((Bundle)localObject3).putInt("seq", ((Bundle)localObject10).getInt("seq", -1));
                                                              localObject6 = ((DownloaderFactory)((AppRuntime)localObject11).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
                                                              localObject7 = new StringBuilder();
                                                              ((StringBuilder)localObject7).append(NearbyConstants.jdField_c_of_type_JavaLangString);
                                                              ((StringBuilder)localObject7).append(File.separator);
                                                              ((StringBuilder)localObject7).append("nearby_heart.mp4");
                                                              localObject7 = new File(((StringBuilder)localObject7).toString());
                                                              if (!((File)localObject7).exists()) {
                                                                ((File)localObject7).mkdirs();
                                                              } else {
                                                                ((File)localObject7).delete();
                                                              }
                                                              ((DownloaderInterface)localObject6).startDownload(new DownloadTask("https://pub.idqqimg.com/pc/misc/nearby/nearby_heart.gif", (File)localObject7), new TroopMemberApiService.IncomingHandler.5(this, (Bundle)localObject3), new Bundle());
                                                              continue;
                                                              i = ((Bundle)localObject10).getInt("subCmd");
                                                              localObject3 = (ITroopEnterEffectService)((AppRuntime)localObject11).getRuntimeService(ITroopEnterEffectService.class, "all");
                                                              if (i != 1)
                                                              {
                                                                if (i == 2)
                                                                {
                                                                  localObject6 = ((Bundle)localObject10).getStringArrayList("statusList");
                                                                  if (localObject6 != null) {
                                                                    ((ITroopEnterEffectService)localObject3).updateEffectStatus((ArrayList)localObject6);
                                                                  }
                                                                }
                                                              }
                                                              else
                                                              {
                                                                i = ((Bundle)localObject10).getInt("effectId");
                                                                localObject7 = ((Bundle)localObject10).getIntegerArrayList("groupCodeList");
                                                                localObject6 = ((Bundle)localObject10).getString("effectName");
                                                                j = ((Bundle)localObject10).getInt("svipLevel");
                                                                k = ((Bundle)localObject10).getInt("svipType");
                                                                if (((ArrayList)localObject7).size() == 0)
                                                                {
                                                                  ((ITroopEnterEffectService)localObject3).updateGlobalEffectInfo(i, (String)localObject6, j, k);
                                                                }
                                                                else
                                                                {
                                                                  localObject7 = ((ArrayList)localObject7).iterator();
                                                                  while (((Iterator)localObject7).hasNext()) {
                                                                    ((ITroopEnterEffectService)localObject3).updateEffectInfo(((Integer)((Iterator)localObject7).next()).intValue(), i, (String)localObject6, j, k);
                                                                  }
                                                                }
                                                              }
                                                              this.a.a(87, (Bundle)localObject10);
                                                              continue;
                                                              localObject3 = new Bundle();
                                                              ((Bundle)localObject3).putInt("seq", ((Bundle)localObject10).getInt("seq", -1));
                                                              if (bool4)
                                                              {
                                                                localObject6 = (QQAppInterface)localObject11;
                                                                if ((((QQAppInterface)localObject6).isVideoChatting()) && (!((QQAppInterface)localObject6).getAVNotifyCenter().k()))
                                                                {
                                                                  bool1 = bool2;
                                                                  break label5757;
                                                                }
                                                              }
                                                              bool1 = false;
                                                              label5757:
                                                              ((Bundle)localObject3).putBoolean("isOtherTypeChatting", bool1);
                                                              this.a.a(84, (Bundle)localObject3);
                                                              continue;
                                                              localObject3 = (IVideoUploadManager)((AppRuntime)localObject11).getManager(QQManagerFactory.READINJOY_VIDEO_UPLOAD_MANAGER);
                                                              ((IVideoUploadManager)localObject3).a(this.a);
                                                              ((IVideoUploadManager)localObject3).a(((Bundle)localObject10).getString("videoPath"), (Bundle)localObject10);
                                                              continue;
                                                              ((Bundle)localObject10).putInt("currentFragment", SplashActivity.currentFragment);
                                                              this.a.a(80, (Bundle)localObject10);
                                                              continue;
                                                              if (bool4)
                                                              {
                                                                bool1 = PtvFilterSoLoad.a((QQAppInterface)localObject11, BaseApplicationImpl.getContext());
                                                                if (QLog.isColorLevel())
                                                                {
                                                                  localObject3 = new StringBuilder();
                                                                  ((StringBuilder)localObject3).append("isPtvFilterDownloadOK:");
                                                                  ((StringBuilder)localObject3).append(bool1);
                                                                  QLog.e("TroopMemberApiService", 2, ((StringBuilder)localObject3).toString());
                                                                  continue;
                                                                  localObject3 = new Bundle();
                                                                  ((Bundle)localObject3).putInt("seq", ((Bundle)localObject10).getInt("seq", -1));
                                                                  if (bool4)
                                                                  {
                                                                    localObject7 = (NearbyVideoChatManager)((AppRuntime)localObject11).getManager(QQManagerFactory.NEARBY_VIDEO_CHAT);
                                                                    if (localObject7 != null)
                                                                    {
                                                                      localObject6 = ((NearbyVideoChatManager)localObject7).a();
                                                                      localObject7 = ((NearbyVideoChatManager)localObject7).b();
                                                                      ((Bundle)localObject3).putString("nearbyVideoConfig", (String)localObject6);
                                                                      ((Bundle)localObject3).putString("title", (String)localObject7);
                                                                    }
                                                                  }
                                                                  this.a.a(76, (Bundle)localObject3);
                                                                  continue;
                                                                  localObject3 = ((Bundle)localObject10).getString("path");
                                                                  this.a.jdField_a_of_type_JavaLangString = ((Bundle)localObject10).getString("photoPath");
                                                                  this.a.jdField_c_of_type_Int = ((Bundle)localObject10).getInt("seq", -1);
                                                                  ((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).upload640Video((QQAppInterface)localObject11, (String)localObject3, this.a.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
                                                                  continue;
                                                                  localObject3 = ((Bundle)localObject10).getString("schoolName");
                                                                  i = ((Bundle)localObject10).getInt("isValid");
                                                                  localObject6 = (INearbyCardHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
                                                                  if (localObject6 != null)
                                                                  {
                                                                    ((INearbyCardHandler)localObject6).a((String)localObject3, i);
                                                                    continue;
                                                                    localObject7 = ((Bundle)localObject10).getByteArray("xmlData");
                                                                    localObject3 = ((Bundle)localObject10).getString("friendUin");
                                                                    i = ((Bundle)localObject10).getInt("directionFlag");
                                                                    j = ((Bundle)localObject10).getInt("from");
                                                                    if (bool4)
                                                                    {
                                                                      localObject6 = (QQAppInterface)localObject11;
                                                                      if (!((IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class)).getHasInsertMsgFlag((AppInterface)localObject6, (String)localObject3))
                                                                      {
                                                                        l1 = MessageCache.a();
                                                                        localObject8 = ((QQAppInterface)localObject6).getCurrentAccountUin();
                                                                        localObject9 = StructMsgFactory.a((byte[])localObject7, -1);
                                                                        if (localObject9 != null)
                                                                        {
                                                                          ((AbsStructMsg)localObject9).mMsgServiceID = 98;
                                                                          localObject7 = (MessageForStructing)MessageRecordFactory.a(-2011);
                                                                          ((MessageForStructing)localObject7).init((String)localObject8, (String)localObject3, (String)localObject3, "MarketTrans", l1, -2011, j, l1);
                                                                          ((MessageForStructing)localObject7).structingMsg = ((AbsStructMsg)localObject9);
                                                                          ((MessageForStructing)localObject7).msgData = ((MessageForStructing)localObject7).structingMsg.getBytes();
                                                                          ((MessageForStructing)localObject7).isread = true;
                                                                          ((IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class)).setHasInsertMsgFlag((AppInterface)localObject6, (String)localObject3);
                                                                          localObject8 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
                                                                          localObject9 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
                                                                          ((IFaceScoreUtils)localObject8).setFaceScoreFlag((MessageRecord)localObject7, "isFaceScoreBubbleMsg", true);
                                                                          localObject8 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
                                                                          localObject9 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
                                                                          ((IFaceScoreUtils)localObject8).setFaceScoreFlag((MessageRecord)localObject7, "isFaceScoreSecondMember", true);
                                                                          localObject8 = (IFaceScoreUtils)QRoute.api(IFaceScoreUtils.class);
                                                                          IFaceScoreUtils.sNeedInsertGrayMsgUins.add(localObject3);
                                                                          if (i == 1) {
                                                                            bool1 = bool3;
                                                                          } else {
                                                                            bool1 = false;
                                                                          }
                                                                          MsgProxyUtils.a((MessageRecord)localObject7, bool1);
                                                                          ((QQAppInterface)localObject6).getMessageFacade().a((MessageRecord)localObject7, ((MessageForStructing)localObject7).selfuin);
                                                                          if (QLog.isColorLevel())
                                                                          {
                                                                            localObject3 = new StringBuilder();
                                                                            ((StringBuilder)localObject3).append("TroopMemberApiService.IncomingHandler.handlerMessage(). insert faceScore obj message., msg = ");
                                                                            ((StringBuilder)localObject3).append(localObject7);
                                                                            QLog.d("Q..troop.faceScore", 2, ((StringBuilder)localObject3).toString());
                                                                            continue;
                                                                            localObject3 = ((Bundle)localObject10).getString("groupCode");
                                                                            localObject6 = ((Bundle)localObject10).getString("groupMemberUin");
                                                                            i = ((Bundle)localObject10).getInt("seq");
                                                                            localObject7 = (TroopManager)((AppRuntime)localObject11).getManager(QQManagerFactory.TROOP_MANAGER);
                                                                            ThreadManager.post(new TroopMemberApiService.IncomingHandler.4(this, (AppRuntime)localObject11, (String)localObject3, (String)localObject6, (Bundle)localObject10, i), 8, null, true);
                                                                            continue;
                                                                            localObject3 = ((Bundle)localObject10).getString("pluginPackageName");
                                                                            localObject6 = ((Bundle)localObject10).getString("appType");
                                                                            ((IFactoryApi)QRoute.api(IFactoryApi.class)).getHuaYangDownLoadHelper((QQAppInterface)localObject11, (String)localObject3, (String)localObject6).canceLauncher();
                                                                            continue;
                                                                            localObject3 = ((Bundle)localObject10).getString("troopUin");
                                                                            localObject6 = ((Bundle)localObject10).getString("memUin");
                                                                            i = ((Bundle)localObject10).getInt("serviceType");
                                                                            localObject7 = (IHotChatHandler)((QQAppInterface)localObject11).getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
                                                                            if (localObject7 != null)
                                                                            {
                                                                              localObject8 = new ArrayList();
                                                                              ((List)localObject8).add(Long.valueOf(Long.parseLong((String)localObject6)));
                                                                              ((IHotChatHandler)localObject7).setHotChatAdminFlag((AppInterface)localObject11, (String)localObject3, (List)localObject8, i);
                                                                              continue;
                                                                              localObject3 = ((Bundle)localObject10).getString("troopUin");
                                                                              i = ((Bundle)localObject10).getInt("statOption");
                                                                              localObject6 = ((Bundle)localObject10).getString("authKey");
                                                                              ((ITroopMngHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).a((String)localObject3, "", i, (String)localObject6, null, null, null);
                                                                              continue;
                                                                              localObject3 = ((Bundle)localObject10).getString("appType");
                                                                              localObject6 = ((Bundle)localObject10).getString("openType");
                                                                              localObject7 = ((Bundle)localObject10).getString("uri");
                                                                              localObject8 = ((Bundle)localObject10).getString("action");
                                                                              localObject9 = ((Bundle)localObject10).getString("pluginPackageName");
                                                                              localObject10 = ((Bundle)localObject10).getString("pluginParams");
                                                                              ((IHuayangOpenHelper)QRoute.api(IHuayangOpenHelper.class)).open((QQAppInterface)localObject11, (String)localObject3, (String)localObject6, (String)localObject7, "web", (String)localObject8, (String)localObject9, (String)localObject10);
                                                                              continue;
                                                                              localObject3 = ((Bundle)localObject10).getString("hashName");
                                                                              ((Bundle)localObject10).putByteArray("decryptResult", PreloadManager.a().b((String)localObject3));
                                                                              this.a.a(66, (Bundle)localObject10);
                                                                              continue;
                                                                              localObject3 = ((Bundle)localObject10).getString("appid");
                                                                              localObject6 = ((Bundle)localObject10).getString("pkgname");
                                                                              this.a.a((String)localObject6, (String)localObject3);
                                                                              continue;
                                                                              i = ((Bundle)localObject10).getInt("appid");
                                                                              localObject3 = ((Bundle)localObject10).getString("token");
                                                                              localObject6 = ((Bundle)localObject10).getString("openId");
                                                                              j = ((Bundle)localObject10).getInt("seq");
                                                                              ((ITroopTokenHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).a(i, (String)localObject6, (String)localObject3, j);
                                                                              continue;
                                                                              localObject3 = (TroopPluginManager)((AppRuntime)localObject11).getManager(QQManagerFactory.TROOP_PLUGIN_MANAGER);
                                                                              localObject6 = ((Bundle)localObject10).getString("troopUin");
                                                                              i = ((Bundle)localObject10).getInt("seq");
                                                                              localObject7 = ((Bundle)localObject10).getString("processName");
                                                                              localObject8 = (ITroopManagerBizHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
                                                                              if (localObject3 != null)
                                                                              {
                                                                                ((TroopPluginManager)localObject3).a("troop_manage_plugin.apk", new TroopMemberApiService.IncomingHandler.3(this, (ITroopManagerBizHandler)localObject8, (String)localObject6, i, (String)localObject7));
                                                                                continue;
                                                                                localObject3 = ((Bundle)localObject10).getString("troopUin");
                                                                                localObject6 = ((Bundle)localObject10).getString("filePath");
                                                                                localObject7 = ((Bundle)localObject10).getString("fileName");
                                                                                i = ((Bundle)localObject10).getInt("size");
                                                                                j = ((Bundle)localObject10).getInt("busId");
                                                                                TroopFileTransferManager.a((QQAppInterface)localObject11, Long.parseLong((String)localObject3)).a((String)localObject6, (String)localObject7, j, i);
                                                                                continue;
                                                                                localObject3 = ((Bundle)localObject10).getString("troopUin");
                                                                                localObject6 = ((Bundle)localObject10).getString("largeImageFile");
                                                                                localObject7 = ((Bundle)localObject10).getString("fileName");
                                                                                l1 = ((Bundle)localObject10).getLong("progressTotal");
                                                                                i = ((Bundle)localObject10).getInt("busId");
                                                                                TroopFileTransferManager.a((QQAppInterface)localObject11, Long.parseLong((String)localObject3)).a((String)localObject6, (String)localObject7, l1, i);
                                                                                continue;
                                                                                localObject3 = ((Bundle)localObject10).getString("troopUin");
                                                                                localObject6 = ((Bundle)localObject10).getString("rewardId");
                                                                                localObject3 = ((TroopRewardMgr)((AppRuntime)localObject11).getManager(QQManagerFactory.TROOP_REWARD_MGR)).a((String)localObject3, (String)localObject6);
                                                                                if (localObject3 != null) {
                                                                                  localObject8 = ((MessageForTroopReward)localObject3).mediaPath;
                                                                                }
                                                                                ((Bundle)localObject10).putString("videoPath", (String)localObject8);
                                                                                this.a.a(55, (Bundle)localObject10);
                                                                                continue;
                                                                                localObject3 = ((Bundle)localObject10).getString("troopUin");
                                                                                i = ((Bundle)localObject10).getInt("rewardMoney");
                                                                                localObject6 = ((Bundle)localObject10).getString("rewardContent");
                                                                                localObject7 = ((Bundle)localObject10).getString("mediaPath");
                                                                                j = ((Bundle)localObject10).getInt("rewardType");
                                                                                TroopRewardMgr.a = ((Bundle)localObject10).getInt("imageMaxWidthPixels", 1080);
                                                                                TroopRewardMgr.b = ((Bundle)localObject10).getInt("imageMaxHeightPixels", 1920);
                                                                                ((TroopRewardMgr)((AppRuntime)localObject11).getManager(QQManagerFactory.TROOP_REWARD_MGR)).a((String)localObject3, i, (String)localObject6, (String)localObject7, j);
                                                                                continue;
                                                                                i = ((Bundle)localObject10).getInt("fontSize", 1);
                                                                                localObject3 = (QQAppInterface)localObject11;
                                                                                QQAppInterface.curBrowserFontSizeIndex = i;
                                                                                ThreadManager.executeOnSubThread(new TroopMemberApiService.IncomingHandler.2(this, i));
                                                                                continue;
                                                                                localObject3 = (QQAppInterface)localObject11;
                                                                                ((Bundle)localObject10).putInt("fontSize", QQAppInterface.curBrowserFontSizeIndex);
                                                                                this.a.a(52, (Bundle)localObject10);
                                                                                continue;
                                                                                l1 = ((Bundle)localObject10).getLong("troopUin");
                                                                                i = ((Bundle)localObject10).getInt("flag");
                                                                                ((ITroopMngHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).a(l1, i);
                                                                                continue;
                                                                                localObject3 = ((Bundle)localObject10).getString("localFilePath");
                                                                                localObject6 = ((Bundle)localObject10).getString("fileDisPlayName");
                                                                                HWTroopUtils.a(this.a, (String)localObject3, (String)localObject6);
                                                                                continue;
                                                                                localObject3 = ((Bundle)localObject10).getString("troopUin");
                                                                                localObject6 = (TroopManager)((AppRuntime)localObject11).getManager(QQManagerFactory.TROOP_MANAGER);
                                                                                if (localObject6 != null)
                                                                                {
                                                                                  localObject3 = ((TroopManager)localObject6).b((String)localObject3);
                                                                                  if ((localObject3 != null) && (((TroopInfo)localObject3).hasOrgs()))
                                                                                  {
                                                                                    bool1 = true;
                                                                                    break label7645;
                                                                                  }
                                                                                }
                                                                                bool1 = false;
                                                                                label7645:
                                                                                ((Bundle)localObject10).putBoolean("hasOrgs", bool1);
                                                                                this.a.a(46, (Bundle)localObject10);
                                                                                continue;
                                                                                try
                                                                                {
                                                                                  l1 = ((Bundle)localObject10).getLong("troopPubAccountUin");
                                                                                  localObject3 = ((Bundle)localObject10).getLongArray("troopUinList");
                                                                                  if ((localObject3 == null) || (localObject3.length <= 0)) {
                                                                                    continue;
                                                                                  }
                                                                                  localObject6 = (TroopManager)((AppRuntime)localObject11).getManager(QQManagerFactory.TROOP_MANAGER);
                                                                                  i = 0;
                                                                                  while (i < localObject3.length)
                                                                                  {
                                                                                    localObject7 = new StringBuilder();
                                                                                    ((StringBuilder)localObject7).append(localObject3[i]);
                                                                                    ((StringBuilder)localObject7).append("");
                                                                                    localObject7 = ((TroopManager)localObject6).b(((StringBuilder)localObject7).toString());
                                                                                    if (localObject7 != null) {
                                                                                      ((TroopInfo)localObject7).associatePubAccount = l1;
                                                                                    }
                                                                                    ((TroopManager)localObject6).b((TroopInfo)localObject7);
                                                                                    i += 1;
                                                                                  }
                                                                                  if (!QLog.isColorLevel()) {
                                                                                    continue;
                                                                                  }
                                                                                }
                                                                                catch (Exception localException2) {}
                                                                                localObject6 = new StringBuilder();
                                                                                ((StringBuilder)localObject6).append("updateTroopBindedPubAccount:");
                                                                                ((StringBuilder)localObject6).append(localException2.toString());
                                                                                QLog.e("AccountDetailActivity.bindTroop", 2, ((StringBuilder)localObject6).toString());
                                                                                continue;
                                                                                this.a.d = ((Bundle)localObject10).getInt("appId");
                                                                                this.a.e = ((Bundle)localObject10).getInt("seq");
                                                                                if (this.a.d != 0)
                                                                                {
                                                                                  Object localObject4 = (ITroopAppService)((AppRuntime)localObject11).getRuntimeService(ITroopAppService.class, "all");
                                                                                  localObject6 = new ArrayList();
                                                                                  if ((((ITroopAppService)localObject4).isCheckedUpdateAfterLogined(0)) && (!((ITroopAppService)localObject4).getAppListChangedFromWebOperate(0)))
                                                                                  {
                                                                                    localObject7 = ((ITroopAppService)localObject4).getTroopAppList(false, 0);
                                                                                    if ((localObject7 != null) && (!((List)localObject7).isEmpty()))
                                                                                    {
                                                                                      localObject7 = ((List)localObject7).iterator();
                                                                                      while (((Iterator)localObject7).hasNext())
                                                                                      {
                                                                                        localObject8 = (TroopAIOAppInfo)((Iterator)localObject7).next();
                                                                                        ((ArrayList)localObject6).add(Integer.valueOf(((TroopAIOAppInfo)localObject8).appid));
                                                                                        if (((TroopAIOAppInfo)localObject8).appid == this.a.d)
                                                                                        {
                                                                                          QQToast.a(BaseApplication.getContext(), 2, 2131719765, 0).b(this.a.getResources().getDimensionPixelSize(2131299168));
                                                                                          return;
                                                                                        }
                                                                                      }
                                                                                    }
                                                                                    ((ArrayList)localObject6).add(Integer.valueOf(this.a.d));
                                                                                    localObject7 = new ArrayList();
                                                                                    ((ArrayList)localObject7).add(Integer.valueOf(this.a.d));
                                                                                    ((ITroopAppService)localObject4).addTroopApp((ArrayList)localObject6, (ArrayList)localObject7);
                                                                                  }
                                                                                  else
                                                                                  {
                                                                                    this.a.jdField_a_of_type_Boolean = true;
                                                                                    ((ITroopAppService)localObject4).getTroopAppList(true, 0);
                                                                                    continue;
                                                                                    localObject4 = ((Bundle)localObject10).getString("troopUin");
                                                                                    localObject6 = (TroopManager)((AppRuntime)localObject11).getManager(QQManagerFactory.TROOP_MANAGER);
                                                                                    if (localObject6 != null)
                                                                                    {
                                                                                      localObject4 = ((TroopManager)localObject6).b((String)localObject4);
                                                                                      if (localObject4 != null)
                                                                                      {
                                                                                        ((TroopInfo)localObject4).troopPrivilegeFlag |= 0x800;
                                                                                        ((TroopManager)localObject6).b((TroopInfo)localObject4);
                                                                                      }
                                                                                    }
                                                                                    ((IStudyRoomReporter)QRoute.api(IStudyRoomReporter.class)).reportWithBundle(((Bundle)localObject10).getBundle("reportData"));
                                                                                    continue;
                                                                                    localObject4 = ((Bundle)localObject10).getString("troopUin");
                                                                                    localObject6 = ((Bundle)localObject10).getString("troopCode");
                                                                                    if (localObject7 != null) {
                                                                                      ((ITroopMemberListHandler)localObject7).a(true, (String)localObject4, (String)localObject6, 0);
                                                                                    }
                                                                                    if (QLog.isColorLevel())
                                                                                    {
                                                                                      localObject4 = new StringBuilder();
                                                                                      ((StringBuilder)localObject4).append("MSG_ON_GET_TROOP_MEM_LIST troopuin: ");
                                                                                      ((StringBuilder)localObject4).append((String)localObject6);
                                                                                      QLog.d("TroopMemberApiService", 2, ((StringBuilder)localObject4).toString());
                                                                                      continue;
                                                                                      localObject4 = ((Bundle)localObject10).getString("troopUin");
                                                                                      localObject6 = ((Bundle)localObject10).getString("processName");
                                                                                      localObject7 = (ITroopManagerBizHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
                                                                                      if (localObject7 != null)
                                                                                      {
                                                                                        ((ITroopManagerBizHandler)localObject7).a((String)localObject4, (String)localObject6);
                                                                                        continue;
                                                                                        l1 = ((Bundle)localObject10).getLong("dwGroupCode");
                                                                                        long l2 = ((Bundle)localObject10).getLong("cGroupOption");
                                                                                        long l3 = ((Bundle)localObject10).getLong("dwGroupClass");
                                                                                        localObject4 = ((Bundle)localObject10).getString("strGroupName");
                                                                                        i = ((Bundle)localObject10).getInt("wGroupFace");
                                                                                        localObject7 = ((Bundle)localObject10).getString("strGroupMemo");
                                                                                        localObject8 = ((Bundle)localObject10).getString("strFingerMemo");
                                                                                        j = ((Bundle)localObject10).getInt("nFlag");
                                                                                        if (localObject6 != null)
                                                                                        {
                                                                                          ((ITroopModifyHandler)localObject6).a(l1, l2, l3, (String)localObject4, i, (String)localObject7, (String)localObject8, j);
                                                                                          continue;
                                                                                          localObject4 = ((Bundle)localObject10).getString("troopUin");
                                                                                          localObject6 = (ITroopInfoHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
                                                                                          if (localObject6 != null) {
                                                                                            ((ITroopInfoHandler)localObject6).a((String)localObject4);
                                                                                          }
                                                                                          if (QLog.isDevelopLevel())
                                                                                          {
                                                                                            QLog.i("TroopMngTest", 4, String.format("MSG_GET_GROUP_INFO_REQ [%s]", new Object[] { localObject4 }));
                                                                                            continue;
                                                                                            localObject6 = ((Bundle)localObject10).getString("troopUin");
                                                                                            bool1 = ((Bundle)localObject10).getBoolean("isChecked");
                                                                                            if (localObject4 != null)
                                                                                            {
                                                                                              ((ITroopManagerBizHandler)localObject4).c((String)localObject6, bool1);
                                                                                              continue;
                                                                                              localObject6 = ((Bundle)localObject10).getString("troopUin");
                                                                                              if (localObject4 != null)
                                                                                              {
                                                                                                ((ITroopManagerBizHandler)localObject4).b((String)localObject6);
                                                                                                continue;
                                                                                                localObject4 = ((Bundle)localObject10).getString("troopUin");
                                                                                                localObject6 = (ITroopManagerBizHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_MANAGER_BIZ_HANDLER);
                                                                                                if (localObject6 != null)
                                                                                                {
                                                                                                  ((ITroopManagerBizHandler)localObject6).a((String)localObject4);
                                                                                                  continue;
                                                                                                  l1 = ((Bundle)localObject10).getLong("roomid", 0L);
                                                                                                  localObject4 = ((Bundle)localObject10).getString("roomname");
                                                                                                  localObject6 = ((Bundle)localObject10).getString("userdata");
                                                                                                  localObject7 = ((Bundle)localObject10).getString("vasname");
                                                                                                  i = ((Bundle)localObject10).getInt("fromid", 0);
                                                                                                  ((ODProxy)((QQAppInterface)localObject11).getManager(QQManagerFactory.ODPROXY_MGR)).a(this.a, l1, (String)localObject4, (String)localObject7, (String)localObject6, i);
                                                                                                  continue;
                                                                                                  localObject4 = ((Bundle)localObject10).getString("troopUin");
                                                                                                  localObject6 = ((Bundle)localObject10).getString("opn");
                                                                                                  if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject4))) {
                                                                                                    if (((String)localObject6).equals("g_homework"))
                                                                                                    {
                                                                                                      l1 = Long.parseLong((String)localObject4);
                                                                                                      if (TroopFileUtils.a((QQAppInterface)localObject11, l1)) {
                                                                                                        localObject8 = "role=teacher&";
                                                                                                      }
                                                                                                      localObject6 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
                                                                                                      localObject7 = new StringBuilder();
                                                                                                      ((StringBuilder)localObject7).append("https://qun.qq.com/homework/features/index.html?_wv=1027&_bid=2146#");
                                                                                                      ((StringBuilder)localObject7).append((String)localObject8);
                                                                                                      ((StringBuilder)localObject7).append("gid=");
                                                                                                      ((StringBuilder)localObject7).append((String)localObject4);
                                                                                                      ((StringBuilder)localObject7).append("&src=0");
                                                                                                      ((Intent)localObject6).putExtra("url", ((StringBuilder)localObject7).toString());
                                                                                                      ((Intent)localObject6).setFlags(268435456);
                                                                                                      this.a.startActivity((Intent)localObject6);
                                                                                                    }
                                                                                                    else if (((String)localObject6).equals("g_troop_reward"))
                                                                                                    {
                                                                                                      TroopRewardMgr.a((QQAppInterface)localObject11, this.a, (String)localObject4, true);
                                                                                                      continue;
                                                                                                      bool1 = ((Bundle)localObject10).getBoolean("isTroopAppListChanged");
                                                                                                      ((ITroopAppService)((AppRuntime)localObject11).getRuntimeService(ITroopAppService.class, "all")).setAppListChangedFromWebOperate(bool1);
                                                                                                      continue;
                                                                                                      localObject4 = ((Bundle)localObject10).getString("troopUin");
                                                                                                      localObject6 = ((Bundle)localObject10).getString("memberUin");
                                                                                                      i = ((Bundle)localObject10).getInt("titleId");
                                                                                                      localObject7 = (TroopManager)((AppRuntime)localObject11).getManager(QQManagerFactory.TROOP_MANAGER);
                                                                                                      if ((localObject7 != null) && (i > 0))
                                                                                                      {
                                                                                                        ((TroopManager)localObject7).a((String)localObject4, (String)localObject6, null, i, null, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
                                                                                                        ((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER).notifyUI(TroopObserver.TYPE_NOTIFY_TROOP_RANK_TITLE_UPDATE, true, new Object[] { localObject4, localObject6, Integer.valueOf(i) });
                                                                                                        continue;
                                                                                                        i = ((Bundle)localObject10).getInt("appid");
                                                                                                        localObject4 = ((Bundle)localObject10).getString("token");
                                                                                                        localObject6 = ((Bundle)localObject10).getString("openGroupId");
                                                                                                        localObject7 = ((Bundle)localObject10).getString("url");
                                                                                                        j = ((Bundle)localObject10).getInt("seq");
                                                                                                        ((ITroopTokenHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).a(i, (String)localObject6, (String)localObject4, (String)localObject7, j);
                                                                                                        continue;
                                                                                                        if (this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager != null)
                                                                                                        {
                                                                                                          this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager.cancleAllTask();
                                                                                                          continue;
                                                                                                          if ((bool4) && (localObject10 != null))
                                                                                                          {
                                                                                                            if (this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager == null)
                                                                                                            {
                                                                                                              this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager = ((IPublicAccountH5Manager)QRoute.api(IPublicAccountH5Manager.class));
                                                                                                              this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager.init(this.a, (QQAppInterface)localObject11);
                                                                                                            }
                                                                                                            if (((Bundle)localObject10).getBoolean("is_pic_or_voice"))
                                                                                                            {
                                                                                                              this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager.startDownloadPic((Bundle)localObject10);
                                                                                                            }
                                                                                                            else
                                                                                                            {
                                                                                                              this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager.downloadPtt((Bundle)localObject10);
                                                                                                              continue;
                                                                                                              if ((bool4) && (localObject10 != null))
                                                                                                              {
                                                                                                                if (this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager == null)
                                                                                                                {
                                                                                                                  this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager = ((IPublicAccountH5Manager)QRoute.api(IPublicAccountH5Manager.class));
                                                                                                                  this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager.init(this.a, (QQAppInterface)localObject11);
                                                                                                                }
                                                                                                                if (((Bundle)localObject10).getBoolean("is_pic_or_voice"))
                                                                                                                {
                                                                                                                  this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager.startUploadPic((Bundle)localObject10);
                                                                                                                }
                                                                                                                else
                                                                                                                {
                                                                                                                  this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountH5Manager.uploadPtt((Bundle)localObject10);
                                                                                                                  continue;
                                                                                                                  if ((bool4) && (localObject10 != null))
                                                                                                                  {
                                                                                                                    l1 = ((Bundle)localObject10).getLong("troopCode");
                                                                                                                    localObject6 = ((Bundle)localObject10).getString("filePath");
                                                                                                                    localObject7 = ((Bundle)localObject10).getString("fileName");
                                                                                                                    l2 = ((Bundle)localObject10).getLong("fileSize");
                                                                                                                    i = ((Bundle)localObject10).getInt("busid");
                                                                                                                    localObject4 = (QQAppInterface)localObject11;
                                                                                                                    localObject6 = TroopFileUtils.a((QQAppInterface)localObject4, l1, null, (String)localObject6, (String)localObject7, l2, i);
                                                                                                                    localObject7 = new Bundle();
                                                                                                                    ((Bundle)localObject7).putInt("seq", ((Bundle)localObject10).getInt("seq", -1));
                                                                                                                    if (!TextUtils.isEmpty(((Bundle)localObject10).getString("callback"))) {
                                                                                                                      ((Bundle)localObject7).putString("callback", ((Bundle)localObject10).getString("callback"));
                                                                                                                    }
                                                                                                                    ((Bundle)localObject7).putString("method", "getFileInfo");
                                                                                                                    TroopMemberApiService.a(this.a, (QQAppInterface)localObject4, l1, HWTroopFileStatusInfo.parse((TroopFileStatusInfo)localObject6), (Bundle)localObject7);
                                                                                                                    continue;
                                                                                                                    localObject7 = ((Bundle)localObject10).getString("troopUin");
                                                                                                                    localObject9 = ((Bundle)localObject10).getString("troopName");
                                                                                                                    ((Bundle)localObject10).getInt("troopTypeId");
                                                                                                                    localObject8 = (TroopManager)((AppRuntime)localObject11).getManager(QQManagerFactory.TROOP_MANAGER);
                                                                                                                    if (localObject8 != null)
                                                                                                                    {
                                                                                                                      localObject6 = ((TroopManager)localObject8).b((String)localObject7);
                                                                                                                      localObject4 = localObject6;
                                                                                                                      if (localObject6 == null)
                                                                                                                      {
                                                                                                                        localObject4 = new TroopInfo();
                                                                                                                        ((TroopInfo)localObject4).troopuin = ((String)localObject7);
                                                                                                                        ((TroopInfo)localObject4).troopname = ((String)localObject9);
                                                                                                                        ((TroopInfo)localObject4).Administrator = ((QQAppInterface)localObject11).getCurrentAccountUin();
                                                                                                                        ((TroopInfo)localObject4).dwAdditionalFlag = 1L;
                                                                                                                        ((TroopManager)localObject8).b((TroopInfo)localObject4);
                                                                                                                      }
                                                                                                                    }
                                                                                                                    else
                                                                                                                    {
                                                                                                                      localObject4 = null;
                                                                                                                    }
                                                                                                                    localObject6 = (ITroopInfoHandler)((QQAppInterface)localObject11).getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
                                                                                                                    if (localObject6 != null) {
                                                                                                                      ((ITroopInfoHandler)localObject6).a((String)localObject7);
                                                                                                                    }
                                                                                                                    if ((localObject8 != null) && (localObject4 != null)) {
                                                                                                                      ((TroopManager)localObject8).e((TroopInfo)localObject4);
                                                                                                                    }
                                                                                                                    if (bool4)
                                                                                                                    {
                                                                                                                      this.a.a(19, (Bundle)localObject10);
                                                                                                                      continue;
                                                                                                                      l1 = ((Bundle)localObject10).getLong("uiResId");
                                                                                                                      localObject4 = (ILebaHelperService)((AppRuntime)localObject11).getRuntimeService(ILebaHelperService.class, "multi");
                                                                                                                      if (localObject4 != null)
                                                                                                                      {
                                                                                                                        localObject4 = ((ILebaHelperService)localObject4).getLebaViewItemById(l1);
                                                                                                                      }
                                                                                                                      else
                                                                                                                      {
                                                                                                                        QLog.d("TroopMemberApiService", 1, "MSG_LEBA_SEARCH_GET_PLUGIN_BY_TYPE lebaHelperService == null");
                                                                                                                        localObject4 = null;
                                                                                                                      }
                                                                                                                      if ((localObject4 != null) && (((LebaViewItem)localObject4).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo != null))
                                                                                                                      {
                                                                                                                        ((Bundle)localObject10).putString("packageName", ((LebaViewItem)localObject4).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strPkgName);
                                                                                                                        ((Bundle)localObject10).putString("imageUrl", ((LebaViewItem)localObject4).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResURL);
                                                                                                                        ((Bundle)localObject10).putString("name", ((LebaViewItem)localObject4).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
                                                                                                                        if (((LebaViewItem)localObject4).jdField_a_of_type_Byte == 0) {
                                                                                                                          bool1 = true;
                                                                                                                        } else {
                                                                                                                          bool1 = false;
                                                                                                                        }
                                                                                                                        ((Bundle)localObject10).putBoolean("isOpen", bool1);
                                                                                                                        ((Bundle)localObject10).putInt("type", 0);
                                                                                                                        ((Bundle)localObject10).putBoolean("has", true);
                                                                                                                      }
                                                                                                                      else
                                                                                                                      {
                                                                                                                        ((Bundle)localObject10).putBoolean("has", false);
                                                                                                                      }
                                                                                                                      this.a.a(18, (Bundle)localObject10);
                                                                                                                      continue;
                                                                                                                      localObject4 = (ILebaHelperService)((AppRuntime)localObject11).getRuntimeService(ILebaHelperService.class, "multi");
                                                                                                                      if (localObject4 != null) {
                                                                                                                        ((ILebaHelperService)localObject4).setFlagBackFromMgr();
                                                                                                                      } else {
                                                                                                                        QLog.d("TroopMemberApiService", 1, "MSG_LEBA_SEARCH_UPDATE_PLUGIN lebaHelperService == null");
                                                                                                                      }
                                                                                                                      bool1 = ((Bundle)localObject10).getBoolean("isChecked");
                                                                                                                      l1 = ((Bundle)localObject10).getLong("uiResId");
                                                                                                                      ((Bundle)localObject10).putBoolean("result", TroopMemberApiService.a(this.a, l1, bool1));
                                                                                                                      this.a.a(17, (Bundle)localObject10);
                                                                                                                      continue;
                                                                                                                      if (!TroopMemberApiService.a((AppRuntime)localObject11, new TroopMemberApiService.IncomingHandler.1(this, (Bundle)localObject10)))
                                                                                                                      {
                                                                                                                        this.a.a(16, (Bundle)localObject10);
                                                                                                                        continue;
                                                                                                                        this.a.a((Bundle)localObject10);
                                                                                                                        continue;
                                                                                                                        localObject4 = new Bundle();
                                                                                                                        ((Bundle)localObject4).putString("method", "changeAnonymousNick");
                                                                                                                        ((Bundle)localObject4).putInt("seq", ((Bundle)localObject10).getInt("seq", -1));
                                                                                                                        localObject6 = ((Bundle)localObject10).getString("troopUin");
                                                                                                                        l1 = ((Bundle)localObject10).getLong("bubbleId");
                                                                                                                        i = ((Bundle)localObject10).getInt("headId");
                                                                                                                        localObject7 = ((Bundle)localObject10).getString("nickName");
                                                                                                                        j = ((Bundle)localObject10).getInt("expireTime");
                                                                                                                        localObject8 = ((Bundle)localObject10).getString("rankColor");
                                                                                                                        if ((!TextUtils.isEmpty((CharSequence)localObject6)) && (!TextUtils.isEmpty((CharSequence)localObject7)))
                                                                                                                        {
                                                                                                                          AnonymousChatHelper.a().a((String)localObject6, l1, i, (String)localObject7, j, "", (String)localObject8);
                                                                                                                          ((Bundle)localObject4).putBoolean("result", true);
                                                                                                                        }
                                                                                                                        else
                                                                                                                        {
                                                                                                                          ((Bundle)localObject4).putBoolean("result", false);
                                                                                                                        }
                                                                                                                        this.a.a(13, (Bundle)localObject4);
                                                                                                                        continue;
                                                                                                                        new Bundle().putInt("seq", ((Bundle)localObject10).getInt("seq", -1));
                                                                                                                        localObject4 = ((Bundle)localObject10).getString("path");
                                                                                                                        if (bool4)
                                                                                                                        {
                                                                                                                          ((IRedTouchManager)((AppRuntime)localObject11).getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick((String)localObject4);
                                                                                                                          continue;
                                                                                                                          localObject4 = new Bundle();
                                                                                                                          ((Bundle)localObject4).putInt("seq", ((Bundle)localObject10).getInt("seq", -1));
                                                                                                                          localObject6 = ((Bundle)localObject10).getStringArray("paths");
                                                                                                                          if ((bool4) && (localObject6 != null) && (localObject6.length > 0))
                                                                                                                          {
                                                                                                                            localObject7 = (IRedTouchManager)((AppRuntime)localObject11).getRuntimeService(IRedTouchManager.class, "");
                                                                                                                            localObject8 = new int[localObject6.length];
                                                                                                                            localObject9 = new int[localObject6.length];
                                                                                                                            i = 0;
                                                                                                                            while (i < localObject9.length)
                                                                                                                            {
                                                                                                                              localObject10 = ((IRedTouchManager)localObject7).getAppInfoByPath(localObject6[i]);
                                                                                                                              if (localObject10 != null)
                                                                                                                              {
                                                                                                                                localObject8[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject10).iNewFlag.get();
                                                                                                                                localObject9[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject10).type.get();
                                                                                                                              }
                                                                                                                              else
                                                                                                                              {
                                                                                                                                localObject8[i] = 0;
                                                                                                                                localObject9[i] = -1;
                                                                                                                              }
                                                                                                                              i += 1;
                                                                                                                            }
                                                                                                                            ((Bundle)localObject4).putIntArray("iNewFlags", (int[])localObject8);
                                                                                                                            ((Bundle)localObject4).putIntArray("types", (int[])localObject9);
                                                                                                                          }
                                                                                                                          this.a.a(11, (Bundle)localObject4);
                                                                                                                          continue;
                                                                                                                          if (localObject9 != null)
                                                                                                                          {
                                                                                                                            localObject4 = ((Bundle)localObject10).getString("methord_name");
                                                                                                                            if ("getGroupInArea".equals(localObject4))
                                                                                                                            {
                                                                                                                              ((LBSHandler)localObject9).a(((Bundle)localObject10).getString("areaName"), ((Bundle)localObject10).getInt("lat"), ((Bundle)localObject10).getInt("lon"), ((Bundle)localObject10).getInt("startIndex"), ((Bundle)localObject10).getInt("count"), ((Bundle)localObject10).getInt("iFilterId"));
                                                                                                                            }
                                                                                                                            else if ("getNearbyTroops".equals(localObject4))
                                                                                                                            {
                                                                                                                              ((LBSHandler)localObject9).a(((Bundle)localObject10).getBoolean("isFirst"), ((Bundle)localObject10).getInt("lat"), ((Bundle)localObject10).getInt("lon"), ((Bundle)localObject10).getInt("sortType"), ((Bundle)localObject10).getString("strGroupArea"), ((Bundle)localObject10).getInt("iFilterId"));
                                                                                                                            }
                                                                                                                            else if ("getAreaList".equals(localObject4))
                                                                                                                            {
                                                                                                                              ((LBSHandler)localObject9).a(((Bundle)localObject10).getInt("lat"), ((Bundle)localObject10).getInt("lon"), ((Bundle)localObject10).getInt("radius"), ((Bundle)localObject10).getBoolean("isClickable"));
                                                                                                                            }
                                                                                                                            else if ("getNewNearbyTroop".equals(localObject4))
                                                                                                                            {
                                                                                                                              ((LBSHandler)localObject9).a(((Bundle)localObject10).getInt("lat"), ((Bundle)localObject10).getInt("lon"));
                                                                                                                              continue;
                                                                                                                              this.a.a().a((AppRuntime)localObject11, (Bundle)localObject10);
                                                                                                                              continue;
                                                                                                                              localObject4 = ((Bundle)localObject10).getString("gcode");
                                                                                                                              localObject6 = String.valueOf(8000000);
                                                                                                                              localObject7 = AnonymousChatHelper.a().a((String)localObject4, (String)localObject6);
                                                                                                                              if ((!TextUtils.isEmpty((CharSequence)localObject7)) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject6)))
                                                                                                                              {
                                                                                                                                this.a.a((String)localObject4, (String)localObject6, ((AppRuntime)localObject11).getAccount(), (String)localObject7);
                                                                                                                                if (QLog.isDevelopLevel())
                                                                                                                                {
                                                                                                                                  QLog.i("com.tencent.biz.troop.TroopMemberApiService", 4, "anonymous report.");
                                                                                                                                  continue;
                                                                                                                                  this.a.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(((AppRuntime)localObject11).getAccount());
                                                                                                                                  continue;
                                                                                                                                  this.a.jdField_b_of_type_AndroidOsMessenger = null;
                                                                                                                                  if (paramMessage.obj != null)
                                                                                                                                  {
                                                                                                                                    localObject4 = ((Bundle)paramMessage.obj).getString("processName");
                                                                                                                                    if (localObject4 != null)
                                                                                                                                    {
                                                                                                                                      this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject4);
                                                                                                                                      break;
                                                                                                                                      this.a.jdField_b_of_type_AndroidOsMessenger = paramMessage.replyTo;
                                                                                                                                      if (paramMessage.obj != null)
                                                                                                                                      {
                                                                                                                                        localObject4 = ((Bundle)paramMessage.obj).getString("processName");
                                                                                                                                        if (localObject4 != null) {
                                                                                                                                          this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject4, paramMessage.replyTo);
                                                                                                                                        }
                                                                                                                                      }
                                                                                                                                    }
                                                                                                                                  }
                                                                                                                                }
                                                                                                                              }
                                                                                                                            }
                                                                                                                          }
                                                                                                                        }
                                                                                                                      }
                                                                                                                    }
                                                                                                                  }
                                                                                                                }
                                                                                                              }
                                                                                                            }
                                                                                                          }
                                                                                                        }
                                                                                                      }
                                                                                                    }
                                                                                                  }
                                                                                                }
                                                                                              }
                                                                                            }
                                                                                          }
                                                                                        }
                                                                                      }
                                                                                    }
                                                                                  }
                                                                                }
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      super.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */