package com.tencent.mobileqq.apollo.request;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.game.CmGameConnManager;
import com.tencent.mobileqq.apollo.game.CmGameConnManager.GameConnInfo;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.web.RequestRoute;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.Gift;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.LabelInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.RedInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.gamecenter.data.PadFaceManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.pb.apollo.CmGameMsgTunnel.AddrDistribueRsp;
import com.tencent.pb.apollo.GetTinyID.STTinyID2UserAccInfoRsp;
import com.tencent.pb.apollo.GetTinyID.STUserAccInfo;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.RspBody;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAVCtrlParamRsp;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAudioVideoRsp;
import com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/CmGameRequestReceiver;", "", "()V", "handleApolloGameKey", "", "params", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams;", "handleApolloGameLoginCommon", "handleApolloGameLoginList", "handleApolloGameLoginListWhite", "handleCmGameConnInfoRsp", "handleEnterRoomSSORsp", "handleGamePubAccountFeeds", "handleGetPadFaceAd", "handleReportPadFaceShown", "request", "Landroid/content/Intent;", "resp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "handleSaveGameListResult", "handleSpriteFetchFluidSSORsp", "handleTinyId2IdentifierRsp", "isDataSucc", "", "vasHandler", "Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionHandler;", "ret", "", "paMsgId", "", "appId", "data3", "Lorg/json/JSONObject;", "(Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionHandler;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Z", "parseFeedList", "feedList", "Lorg/json/JSONArray;", "dataList", "", "Lcom/tencent/mobileqq/gamecenter/data/FeedsItemData;", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CmGameRequestReceiver
{
  public static final CmGameRequestReceiver.Companion a = new CmGameRequestReceiver.Companion(null);
  
  private final void a(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    if (localObject != null)
    {
      Intent localIntent = paramApolloRequestReceiveParams.jdField_a_of_type_AndroidContentIntent;
      if (localIntent != null)
      {
        byte[] arrayOfByte = paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte;
        if (arrayOfByte != null)
        {
          paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramApolloRequestReceiveParams != null)
          {
            if ((localIntent != null) && (arrayOfByte != null) && (localObject != null) && (((FromServiceMsg)localObject).isSuccess())) {
              try
              {
                localObject = new WebSSOAgent.UniSsoServerRsp();
                ((WebSSOAgent.UniSsoServerRsp)localObject).mergeFrom(arrayOfByte);
                if (QLog.isColorLevel()) {
                  QLog.d("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleApolloGameLoginReq] ret=", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject).ret.get()) });
                }
                if (((WebSSOAgent.UniSsoServerRsp)localObject).ret.get() == 0L)
                {
                  if (paramApolloRequestReceiveParams != null)
                  {
                    paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.getRuntimeService(IApolloGameManager.class, "all");
                    if (paramApolloRequestReceiveParams != null)
                    {
                      ((ApolloGameManagerImpl)paramApolloRequestReceiveParams).onGameLoginRespFromSvr(((WebSSOAgent.UniSsoServerRsp)localObject).ret.get(), ((WebSSOAgent.UniSsoServerRsp)localObject).pbRsqData.get().toByteArray());
                      return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl");
                  }
                  QLog.e("[cmshow]CmGameRequestReceiver", 1, "[handleApolloGameLoginReq] app is null");
                  return;
                }
                QLog.e("[cmshow]CmGameRequestReceiver", 1, new Object[] { "[handleApolloGameLoginReq] failed ret:", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject).ret.get()) });
                return;
              }
              catch (Exception paramApolloRequestReceiveParams)
              {
                QLog.e("[cmshow]CmGameRequestReceiver", 1, "[handleApolloGameLoginReq] exception=", (Throwable)paramApolloRequestReceiveParams);
                return;
              }
            }
            QLog.e("[cmshow]CmGameRequestReceiver", 1, "[handleApolloGameLoginReq] failed");
          }
        }
      }
    }
  }
  
  private final void a(String paramString, JSONArray paramJSONArray, List<FeedsItemData> paramList)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int k = paramJSONArray.length();
      int i = 0;
      while (i < k)
      {
        FeedsItemData localFeedsItemData = new FeedsItemData();
        JSONObject localJSONObject1 = paramJSONArray.getJSONObject(i);
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("feed_info");
        localFeedsItemData.msgId = paramString;
        localFeedsItemData.authorName = localJSONObject2.optString("anchor_name");
        localFeedsItemData.authorIcon = localJSONObject2.optString("anchor_icon");
        localFeedsItemData.type = localJSONObject2.optInt("feed_type");
        localFeedsItemData.feedId = localJSONObject2.optString("feed_id");
        localFeedsItemData.coverImgUrl = localJSONObject2.optString("cover_url");
        localFeedsItemData.commentNum = localJSONObject2.optInt("comment_num");
        localFeedsItemData.title = localJSONObject2.optString("title");
        localFeedsItemData.jumpUrl = localJSONObject2.optString("jump_url");
        localFeedsItemData.algorithmId = localJSONObject2.optString("algorithm_id");
        localFeedsItemData.label = localJSONObject2.optString("label");
        localFeedsItemData.rcmdReason = localJSONObject2.optString("rcmd_reason");
        localFeedsItemData.subTitle = localJSONObject2.optString("sub_title");
        localFeedsItemData.operateText = localJSONObject2.optString("operate_text");
        localFeedsItemData.groupId = localJSONObject2.optString("group_id");
        if (localFeedsItemData.type == 1)
        {
          localFeedsItemData.videoUrl = localJSONObject2.optString("live_stream_url");
          localFeedsItemData.videoViewers = localJSONObject2.optInt("live_online_num");
          localFeedsItemData.videoSrcName = localJSONObject2.optString("video_source");
          localFeedsItemData.videoSrcImg = localJSONObject2.optString("video_source_icon");
        }
        else if (localFeedsItemData.type == 2)
        {
          localFeedsItemData.videoUrl = localJSONObject2.optString("video_url");
          localFeedsItemData.videoDuration = localJSONObject2.optInt("video_duration");
          localFeedsItemData.videoSrcType = localJSONObject2.optInt("video_source_type");
          localFeedsItemData.videoVid = localJSONObject2.optString("video_vid");
        }
        else if (localFeedsItemData.type == 7)
        {
          JSONArray localJSONArray = localJSONObject2.optJSONArray("gift_list");
          localFeedsItemData.giftList = ((List)new ArrayList());
          if (localJSONArray != null)
          {
            int m = localJSONArray.length();
            int j = 0;
            while (j < m)
            {
              FeedsItemData.Gift localGift = new FeedsItemData.Gift();
              localGift.picture = localJSONArray.getJSONObject(j).optString("picture");
              localGift.text = localJSONArray.getJSONObject(j).optString("text");
              localFeedsItemData.giftList.add(localGift);
              j += 1;
            }
          }
        }
        localFeedsItemData.viewersNum = localJSONObject2.optInt("vv");
        localJSONObject1 = localJSONObject1.optJSONObject("game_info");
        localFeedsItemData.gameInfo = new FeedsItemData.GameInfo();
        localFeedsItemData.gameInfo.gameName = localJSONObject1.optString("name");
        localFeedsItemData.gameInfo.gameIcon = localJSONObject1.optString("icon");
        localFeedsItemData.gameInfo.gamePkgName = localJSONObject1.optString("pkg_name");
        localFeedsItemData.gameInfo.gamePkgSize = localJSONObject1.optInt("pkg_size");
        localFeedsItemData.gameInfo.gameStatus = localJSONObject1.optInt("status");
        localFeedsItemData.gameInfo.gameApkUrl = localJSONObject1.optString("apk_url");
        localFeedsItemData.gameInfo.gameAppId = localJSONObject1.optString("appid");
        localFeedsItemData.gameInfo.gameVersionCode = localJSONObject1.optString("version_code");
        localFeedsItemData.gameInfo.gameTicket = localJSONObject1.optString("tickets");
        paramList.add(localFeedsItemData);
        i += 1;
      }
    }
  }
  
  private final boolean a(ApolloExtensionHandler paramApolloExtensionHandler, Object[] paramArrayOfObject, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    Object localObject2 = paramJSONObject.optJSONArray("feed_list");
    Object localObject3 = localObject2;
    Object localObject1 = paramJSONObject.optJSONObject("layer_condition");
    List localList = (List)new ArrayList();
    FeedsItemData.TopCardInfo localTopCardInfo = new FeedsItemData.TopCardInfo();
    Object localObject4 = paramJSONObject.optJSONObject("top_card");
    if (localObject4 != null)
    {
      boolean bool;
      if (((JSONObject)localObject4).optInt("top_card_display_flag", 1) == 0) {
        bool = false;
      } else {
        bool = true;
      }
      localTopCardInfo.showTopCard = bool;
      localTopCardInfo.msgId = paramString1;
      paramJSONObject = ((JSONObject)localObject4).optJSONObject("game_info");
      localTopCardInfo.gameInfo = new FeedsItemData.GameInfo();
      if (paramJSONObject != null)
      {
        localTopCardInfo.gameInfo.gameName = paramJSONObject.optString("name");
        localTopCardInfo.gameInfo.gameIcon = paramJSONObject.optString("icon");
        localTopCardInfo.gameInfo.gamePkgName = paramJSONObject.optString("pkg_name");
        localTopCardInfo.gameInfo.gamePkgSize = paramJSONObject.optInt("pkg_size");
        localTopCardInfo.gameInfo.gameStatus = paramJSONObject.optInt("status");
        localTopCardInfo.gameInfo.gameApkUrl = paramJSONObject.optString("apk_url");
        localTopCardInfo.gameInfo.gameAppId = paramJSONObject.optString("appid");
        localTopCardInfo.gameInfo.gameVersionCode = paramJSONObject.optString("version_code");
        localTopCardInfo.gameInfo.gameTicket = paramJSONObject.optString("tickets");
      }
      localTopCardInfo.actionDesc = ((JSONObject)localObject4).optString("game_info_text");
      localTopCardInfo.prioritiesIconFlag = ((JSONObject)localObject4).optInt("priorities_icon_flag");
      localObject3 = ((JSONObject)localObject4).optJSONArray("entry_list");
      Object localObject5 = new FeedsItemData.LabelInfo();
      localTopCardInfo.labelInfos = ((List)new ArrayList());
      if (((JSONObject)localObject4).optInt("friend_display_flag", 1) == 0) {
        bool = false;
      } else {
        bool = true;
      }
      ((FeedsItemData.LabelInfo)localObject5).showFriend = bool;
      int i;
      int j;
      JSONObject localJSONObject;
      if (((FeedsItemData.LabelInfo)localObject5).showFriend)
      {
        ((FeedsItemData.LabelInfo)localObject5).isFriend = true;
        ((FeedsItemData.LabelInfo)localObject5).friendType = ((JSONObject)localObject4).optInt("friend_type");
        ((FeedsItemData.LabelInfo)localObject5).friendNum = ((JSONObject)localObject4).optInt("game_friend_total_num");
        ((FeedsItemData.LabelInfo)localObject5).reportId = "10001";
        paramJSONObject = ((JSONObject)localObject4).optJSONArray("friend_list");
        localObject6 = (List)new ArrayList();
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
        {
          i = paramJSONObject.length();
          j = 0;
          while (j < i)
          {
            localJSONObject = paramJSONObject.getJSONObject(j);
            FeedsItemData.FriendInfo localFriendInfo = new FeedsItemData.FriendInfo();
            localFriendInfo.icon = localJSONObject.optString("icon");
            localFriendInfo.name = localJSONObject.optString("name");
            localFriendInfo.uin = localJSONObject.optString("uin");
            ((List)localObject6).add(localFriendInfo);
            j += 1;
          }
          paramJSONObject = (JSONObject)localObject1;
          ((FeedsItemData.LabelInfo)localObject5).friendList = ((List)localObject6);
        }
        else
        {
          paramJSONObject = (JSONObject)localObject1;
        }
        localTopCardInfo.labelInfos.add(localObject5);
      }
      else
      {
        paramJSONObject = (JSONObject)localObject1;
      }
      localObject1 = ((JSONObject)localObject4).optJSONObject("friend_red_point");
      ((FeedsItemData.LabelInfo)localObject5).redInfo = new FeedsItemData.RedInfo();
      Object localObject6 = "red_point_id";
      if (localObject1 != null)
      {
        ((FeedsItemData.LabelInfo)localObject5).redInfo.redPointId = ((JSONObject)localObject1).optString("red_point_id");
        ((FeedsItemData.LabelInfo)localObject5).redInfo.redPointStartTime = ((JSONObject)localObject1).optLong("begin_time");
        ((FeedsItemData.LabelInfo)localObject5).redInfo.redPointEndTime = ((JSONObject)localObject1).optLong("end_time");
      }
      localObject5 = localObject4;
      localObject1 = localObject2;
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((JSONArray)localObject3).length() > 0)
        {
          i = ((JSONArray)localObject3).length();
          j = 0;
          localObject4 = localObject6;
          for (;;)
          {
            localObject2 = localObject1;
            if (j >= i) {
              break;
            }
            localObject6 = ((JSONArray)localObject3).getJSONObject(j);
            localObject2 = new FeedsItemData.LabelInfo();
            ((FeedsItemData.LabelInfo)localObject2).iconUrl = ((JSONObject)localObject6).optString("entry_icon");
            ((FeedsItemData.LabelInfo)localObject2).name = ((JSONObject)localObject6).optString("entry_name");
            ((FeedsItemData.LabelInfo)localObject2).jumpUrl = ((JSONObject)localObject6).optString("entry_url");
            ((FeedsItemData.LabelInfo)localObject2).desc = ((JSONObject)localObject6).optString("entry_text");
            ((FeedsItemData.LabelInfo)localObject2).reportId = ((JSONObject)localObject6).optString("report_id");
            ((FeedsItemData.LabelInfo)localObject2).msgId = paramString1;
            ((FeedsItemData.LabelInfo)localObject2).appId = paramString2;
            localJSONObject = ((JSONObject)localObject6).optJSONObject("red_point");
            ((FeedsItemData.LabelInfo)localObject2).redInfo = new FeedsItemData.RedInfo();
            if (localJSONObject != null)
            {
              ((FeedsItemData.LabelInfo)localObject2).redInfo.redPointId = localJSONObject.optString((String)localObject4);
              ((FeedsItemData.LabelInfo)localObject2).redInfo.redPointStartTime = localJSONObject.optLong("begin_time");
              ((FeedsItemData.LabelInfo)localObject2).redInfo.redPointEndTime = localJSONObject.optLong("end_time");
            }
            localObject6 = ((JSONObject)localObject6).optJSONArray("entry_icon_list");
            ((FeedsItemData.LabelInfo)localObject2).icons = ((List)new ArrayList());
            if (localObject6 != null)
            {
              int m = ((JSONArray)localObject6).length();
              int k = 0;
              while (k < m)
              {
                ((FeedsItemData.LabelInfo)localObject2).icons.add(((JSONArray)localObject6).getJSONObject(k).optString("entry_icon"));
                k += 1;
              }
            }
            localTopCardInfo.labelInfos.add(localObject2);
            j += 1;
          }
        }
      }
      localObject1 = ((JSONObject)localObject5).optJSONObject("banner");
      if (localObject1 != null)
      {
        localTopCardInfo.bannerIconZip = ((JSONObject)localObject1).optString("banner_icon_zip");
        localTopCardInfo.bannerGap = ((JSONObject)localObject1).optInt("banner_gap", 60);
        localTopCardInfo.bannerUrl = ((JSONObject)localObject1).optString("banner_url");
        localTopCardInfo.bannerBeginTime = ((JSONObject)localObject1).optLong("begin_time", 0L);
        localTopCardInfo.bannerEndTime = ((JSONObject)localObject1).optLong("end_time", 0L);
      }
      localObject1 = ((JSONObject)localObject5).optJSONArray("priorities");
      if (localObject1 != null)
      {
        localTopCardInfo.priorities = ((List)new ArrayList());
        j = ((JSONArray)localObject1).length();
        i = 0;
        while (i < j)
        {
          localObject3 = ((JSONArray)localObject1).optString(i, "");
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            localTopCardInfo.priorities.add(localObject3);
          }
          i += 1;
        }
      }
      localObject1 = localObject2;
    }
    else
    {
      paramJSONObject = (JSONObject)localObject1;
      localObject1 = localObject3;
    }
    a(paramString1, (JSONArray)localObject1, localList);
    paramArrayOfObject[2] = localList;
    paramArrayOfObject[3] = paramJSONObject;
    paramArrayOfObject[4] = localTopCardInfo;
    paramArrayOfObject[5] = paramString1;
    paramArrayOfObject[6] = paramString2;
    if (paramApolloExtensionHandler == null) {
      Intrinsics.throwNpe();
    }
    paramApolloExtensionHandler.notifyUI(29, true, paramArrayOfObject);
    return true;
  }
  
  @RequestRoute(a="ltgame_addr_distribute.get_iplist")
  private final void handleCmGameConnInfoRsp(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject3 = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject1 = paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte;
    QQAppInterface localQQAppInterface = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramApolloRequestReceiveParams = new StringBuilder();
    paramApolloRequestReceiveParams.append("handleCmGameConnInfoRsp, code=");
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    paramApolloRequestReceiveParams.append(((FromServiceMsg)localObject3).getResultCode());
    QLog.d("[cmshow]CmGameRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
    paramApolloRequestReceiveParams = (CmGameConnManager.GameConnInfo)null;
    if ((localObject1 != null) && (((FromServiceMsg)localObject3).isSuccess())) {
      try
      {
        localObject3 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject3).mergeFrom((byte[])localObject1);
        long l = ((WebSSOAgent.UniSsoServerRsp)localObject3).ret.get();
        QLog.e("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleCmGameConnInfoRsp] unissoRet=", Long.valueOf(l) });
        if (l == 0L)
        {
          localObject1 = new CmGameMsgTunnel.AddrDistribueRsp();
          ((CmGameMsgTunnel.AddrDistribueRsp)localObject1).mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject3).pbRsqData.get().toByteArray());
          int i = ((CmGameMsgTunnel.AddrDistribueRsp)localObject1).port.get();
          localObject1 = new CmGameConnManager.GameConnInfo(((CmGameMsgTunnel.AddrDistribueRsp)localObject1).ip_list.get(), i, ((CmGameMsgTunnel.AddrDistribueRsp)localObject1).aes_key.get(), ((CmGameMsgTunnel.AddrDistribueRsp)localObject1).distribute_ts.get(), ((CmGameMsgTunnel.AddrDistribueRsp)localObject1).sign.get());
          paramApolloRequestReceiveParams = (ApolloRequestReceiveParams)localObject1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]CmGameRequestReceiver", 2, "[handleCmGameConnInfoRsp] failed ", (Throwable)localException);
      }
    }
    if (localQQAppInterface == null) {
      Intrinsics.throwNpe();
    }
    Object localObject2 = localQQAppInterface.getRuntimeService(IApolloGameManager.class, "all");
    if (localObject2 != null)
    {
      localObject2 = ((ApolloGameManagerImpl)localObject2).getCmGameConnManager();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "apolloGameManager.cmGameConnManager");
      if (paramApolloRequestReceiveParams != null)
      {
        ((CmGameConnManager)localObject2).a(paramApolloRequestReceiveParams);
        return;
      }
      ((CmGameConnManager)localObject2).b();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl");
  }
  
  @RequestRoute(a="QQVacCommSvc.get_padface_add")
  private final void handleGetPadFaceAd(ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Object localObject2 = paramApolloRequestReceiveParams.jdField_a_of_type_AndroidContentIntent;
    FromServiceMsg localFromServiceMsg = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject1 = paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte;
    paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject2 != null) && (localObject1 != null) && (localFromServiceMsg != null) && (localFromServiceMsg.isSuccess())) {
      try
      {
        localObject2 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleGetArkAds] ret=", Long.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get()) });
        }
        if (((WebSSOAgent.UniSsoServerRsp)localObject2).ret.get() == 0L)
        {
          localObject1 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject2).rspdata.get()).optJSONObject("12818");
          if ((localObject1 != null) && (((JSONObject)localObject1).optInt("ret", 1) == 0))
          {
            if (paramApolloRequestReceiveParams == null) {
              Intrinsics.throwNpe();
            }
            paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            if (paramApolloRequestReceiveParams != null)
            {
              paramApolloRequestReceiveParams = (GameCenterManagerImp)paramApolloRequestReceiveParams;
              localObject1 = ((JSONObject)localObject1).optJSONObject("data");
              if (localObject1 != null)
              {
                localObject1 = ((JSONObject)localObject1).optJSONObject("rsp");
                if (localObject1 != null) {
                  paramApolloRequestReceiveParams.a().a((JSONObject)localObject1);
                }
              }
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.servlet.GameCenterManagerImp");
            }
          }
        }
      }
      catch (Exception paramApolloRequestReceiveParams)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[handleGetArkAds] err:");
        ((StringBuilder)localObject1).append(paramApolloRequestReceiveParams.getMessage());
        QLog.e("[cmshow]CmGameRequestReceiver", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  @RequestRoute(a="QQVacCommSvc.report_padface_shown")
  private final void handleReportPadFaceShown(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleReportPadFaceShown] ret=", Long.valueOf(paramIntent.ret.get()) });
        }
        if (paramIntent.ret.get() == 0L)
        {
          paramIntent = new JSONObject(paramIntent.rspdata.get()).optJSONObject("12827");
          if (paramIntent != null)
          {
            int i = paramIntent.optInt("ret", 1);
            if (i != 0)
            {
              paramIntent = new StringBuilder();
              paramIntent.append("[handleReportPadFaceShown] ret:");
              paramIntent.append(i);
              QLog.e("[cmshow]CmGameRequestReceiver", 1, paramIntent.toString());
              return;
            }
          }
        }
      }
      catch (Exception paramIntent)
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("[handleReportPadFaceShown] err:");
        paramFromServiceMsg.append(paramIntent.getMessage());
        QLog.e("[cmshow]CmGameRequestReceiver", 1, paramFromServiceMsg.toString());
      }
    }
  }
  
  /* Error */
  @RequestRoute(a="apollo_aio_game.check_game_v2")
  public final void handleApolloGameKey(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 742
    //   4: invokestatic 745	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_1
    //   8: getfield 76	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   11: astore 10
    //   13: aload_1
    //   14: getfield 74	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   17: astore 12
    //   19: aload_1
    //   20: getfield 79	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:jdField_a_of_type_ArrayOfByte	[B
    //   23: astore 11
    //   25: aload_1
    //   26: getfield 82	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: astore 13
    //   31: aload_1
    //   32: getfield 747	com/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams:jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionHandler	Lcom/tencent/mobileqq/apollo/handler/ApolloExtensionHandler;
    //   35: astore 9
    //   37: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +36 -> 76
    //   43: new 604	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 605	java/lang/StringBuilder:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: ldc_w 749
    //   55: invokevirtual 611	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_1
    //   60: aload 11
    //   62: invokevirtual 752	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 102
    //   68: iconst_2
    //   69: aload_1
    //   70: invokevirtual 621	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 623	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload 13
    //   78: ifnull +28 -> 106
    //   81: aload 13
    //   83: ldc_w 754
    //   86: invokevirtual 758	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   89: astore_1
    //   90: aload_1
    //   91: ifnull +15 -> 106
    //   94: aload_1
    //   95: bipush 73
    //   97: invokevirtual 764	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   100: invokevirtual 769	android/os/Message:sendToTarget	()V
    //   103: goto +3 -> 106
    //   106: aload 11
    //   108: ifnull +332 -> 440
    //   111: aload 12
    //   113: ifnull +327 -> 440
    //   116: aload 12
    //   118: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   121: ifeq +319 -> 440
    //   124: new 90	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp
    //   127: dup
    //   128: invokespecial 91	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:<init>	()V
    //   131: astore_1
    //   132: aload_1
    //   133: aload 11
    //   135: invokevirtual 95	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   138: pop
    //   139: aload 10
    //   141: ifnonnull +6 -> 147
    //   144: invokestatic 594	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   147: aload 10
    //   149: ldc_w 771
    //   152: iconst_0
    //   153: invokevirtual 776	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   156: istore_2
    //   157: aload 10
    //   159: ldc_w 778
    //   162: iconst_0
    //   163: invokevirtual 782	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   166: istore 6
    //   168: aload 10
    //   170: ldc_w 784
    //   173: lconst_0
    //   174: invokevirtual 787	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   177: lstore 7
    //   179: aload 10
    //   181: ldc_w 789
    //   184: invokevirtual 792	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 11
    //   189: aload 10
    //   191: ldc_w 794
    //   194: invokevirtual 792	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   197: astore 12
    //   199: aload 10
    //   201: ldc_w 796
    //   204: iconst_0
    //   205: invokevirtual 776	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   208: istore_3
    //   209: aload 10
    //   211: ldc_w 798
    //   214: iconst_0
    //   215: invokevirtual 776	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   218: istore 4
    //   220: aload 10
    //   222: ldc_w 800
    //   225: invokevirtual 792	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   228: astore 13
    //   230: aload 10
    //   232: ldc_w 802
    //   235: iconst_0
    //   236: invokevirtual 776	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   239: istore 5
    //   241: new 804	android/os/Bundle
    //   244: dup
    //   245: invokespecial 805	android/os/Bundle:<init>	()V
    //   248: astore 10
    //   250: aload 10
    //   252: ldc_w 771
    //   255: iload_2
    //   256: invokevirtual 809	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   259: aload 10
    //   261: ldc_w 778
    //   264: iload 6
    //   266: invokevirtual 813	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   269: aload 10
    //   271: ldc_w 784
    //   274: lload 7
    //   276: invokevirtual 817	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   279: aload 10
    //   281: ldc_w 789
    //   284: aload 11
    //   286: invokevirtual 821	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: aload 10
    //   291: ldc_w 823
    //   294: aload 12
    //   296: invokevirtual 821	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload 10
    //   301: ldc_w 798
    //   304: iload 4
    //   306: invokevirtual 809	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   309: aload 10
    //   311: ldc_w 796
    //   314: iload_3
    //   315: invokevirtual 809	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   318: aload 10
    //   320: ldc_w 825
    //   323: aload_1
    //   324: getfield 107	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   327: invokevirtual 113	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   330: invokevirtual 817	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   333: aload 10
    //   335: ldc_w 800
    //   338: aload 13
    //   340: invokevirtual 821	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload 10
    //   345: ldc_w 802
    //   348: iload 5
    //   350: invokevirtual 809	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   353: aload 10
    //   355: ldc_w 712
    //   358: aload_1
    //   359: getfield 139	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:pbRsqData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   362: invokevirtual 144	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   365: invokevirtual 150	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   368: invokevirtual 829	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   371: aload 9
    //   373: ifnonnull +6 -> 379
    //   376: invokestatic 594	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   379: aload 9
    //   381: bipush 21
    //   383: iconst_1
    //   384: aload 10
    //   386: invokevirtual 600	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   389: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +145 -> 537
    //   395: new 604	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 605	java/lang/StringBuilder:<init>	()V
    //   402: astore 10
    //   404: aload 10
    //   406: ldc_w 831
    //   409: invokevirtual 611	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 10
    //   415: aload_1
    //   416: getfield 107	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerRsp:ret	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   419: invokevirtual 113	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   422: invokevirtual 834	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 10
    //   428: invokevirtual 621	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: astore_1
    //   432: ldc 102
    //   434: iconst_2
    //   435: aload_1
    //   436: invokestatic 623	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: return
    //   440: aload 9
    //   442: astore_1
    //   443: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +12 -> 458
    //   449: ldc 102
    //   451: iconst_2
    //   452: ldc_w 836
    //   455: invokestatic 623	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aload_1
    //   459: ifnonnull +6 -> 465
    //   462: invokestatic 594	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   465: aload_1
    //   466: bipush 21
    //   468: iconst_0
    //   469: aconst_null
    //   470: invokevirtual 600	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   473: return
    //   474: astore_1
    //   475: invokestatic 100	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +42 -> 520
    //   481: new 604	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 605	java/lang/StringBuilder:<init>	()V
    //   488: astore 10
    //   490: aload 10
    //   492: ldc_w 838
    //   495: invokevirtual 611	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: aload 10
    //   501: aload_1
    //   502: invokevirtual 729	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   505: invokevirtual 611	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: ldc 102
    //   511: iconst_2
    //   512: aload 10
    //   514: invokevirtual 621	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 623	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   520: aload 9
    //   522: ifnonnull +6 -> 528
    //   525: invokestatic 594	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   528: aload 9
    //   530: bipush 21
    //   532: iconst_0
    //   533: aconst_null
    //   534: invokevirtual 600	com/tencent/mobileqq/apollo/handler/ApolloExtensionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   537: return
    //   538: astore_1
    //   539: goto -64 -> 475
    //   542: astore_1
    //   543: goto +8 -> 551
    //   546: astore_1
    //   547: goto -72 -> 475
    //   550: astore_1
    //   551: goto -76 -> 475
    //   554: astore_1
    //   555: goto -80 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	this	CmGameRequestReceiver
    //   0	558	1	paramApolloRequestReceiveParams	ApolloRequestReceiveParams
    //   156	100	2	i	int
    //   208	107	3	j	int
    //   218	87	4	k	int
    //   239	110	5	m	int
    //   166	99	6	bool	boolean
    //   177	98	7	l	long
    //   35	494	9	localApolloExtensionHandler	ApolloExtensionHandler
    //   11	502	10	localObject1	Object
    //   23	262	11	localObject2	Object
    //   17	278	12	localObject3	Object
    //   29	310	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   432	439	474	java/lang/Exception
    //   443	458	474	java/lang/Exception
    //   462	465	474	java/lang/Exception
    //   465	473	474	java/lang/Exception
    //   81	90	538	java/lang/Exception
    //   94	103	538	java/lang/Exception
    //   116	139	538	java/lang/Exception
    //   144	147	538	java/lang/Exception
    //   147	168	538	java/lang/Exception
    //   379	432	542	java/lang/Exception
    //   189	371	546	java/lang/Exception
    //   376	379	546	java/lang/Exception
    //   179	189	550	java/lang/Exception
    //   168	179	554	java/lang/Exception
  }
  
  @RequestRoute(a="apollo_game_login.get_user_game_list_info")
  public final void handleApolloGameLoginList(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    a(paramApolloRequestReceiveParams);
  }
  
  @RequestRoute(a="apollo_aio_game.get_user_game_list_info")
  public final void handleApolloGameLoginListWhite(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    a(paramApolloRequestReceiveParams);
  }
  
  @RequestRoute(a="apollo_game_av.join_av_room")
  public final void handleEnterRoomSSORsp(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject1 = paramApolloRequestReceiveParams.jdField_a_of_type_AndroidContentIntent;
    Object localObject2 = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    long l = ((Intent)localObject1).getLongExtra("usrdata", 0L);
    if (paramApolloRequestReceiveParams != null)
    {
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      if (((FromServiceMsg)localObject2).isSuccess())
      {
        localObject1 = new WebSSOAgent.UniSsoServerRsp();
        localObject2 = new qqavopensdkSsoTunnel.STAudioVideoRsp();
        try
        {
          ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramApolloRequestReceiveParams);
          ((qqavopensdkSsoTunnel.STAudioVideoRsp)localObject2).mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject1).pbRsqData.get().toByteArray());
          paramApolloRequestReceiveParams = ((qqavopensdkSsoTunnel.RspBody)((qqavopensdkSsoTunnel.STAudioVideoRsp)((qqavopensdkSsoTunnel.STAudioVideoRsp)localObject2).get()).rspbody.get()).bytes_rspbody.get().toByteArray();
          SSOTunnelEvent.a().a(l, true, paramApolloRequestReceiveParams);
          return;
        }
        catch (Exception paramApolloRequestReceiveParams)
        {
          QLog.e("[cmshow]CmGameRequestReceiver", 1, "handleRoomSSOInfoCallback error:", (Throwable)paramApolloRequestReceiveParams);
          return;
        }
      }
    }
    SSOTunnelEvent.a().a(l, false, null);
  }
  
  @RequestRoute(a="QQVacCommSvc.get_feeds")
  public final void handleGamePubAccountFeeds(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject1 = paramApolloRequestReceiveParams.jdField_a_of_type_AndroidContentIntent;
    Object localObject3 = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject2 = paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte;
    paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionHandler;
    Object[] arrayOfObject = new Object[7];
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    arrayOfObject[0] = Long.valueOf(((Intent)localObject1).getLongExtra("msgSeq", 0L));
    arrayOfObject[1] = Boolean.valueOf(((Intent)localObject1).getBooleanExtra("fromBottom", true));
    String str = ((Intent)localObject1).getStringExtra("msgId");
    localObject1 = ((Intent)localObject1).getStringExtra("appId");
    if ((localObject2 != null) && (localObject3 != null) && (((FromServiceMsg)localObject3).isSuccess())) {}
    for (;;)
    {
      try
      {
        localObject3 = new WebSSOAgent.UniSsoServerRsp();
        ((WebSSOAgent.UniSsoServerRsp)localObject3).mergeFrom((byte[])localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(String.valueOf(((WebSSOAgent.UniSsoServerRsp)localObject3).ret.get()));
          ((StringBuilder)localObject2).append(",data:");
          ((StringBuilder)localObject2).append(((WebSSOAgent.UniSsoServerRsp)localObject3).rspdata.get());
          QLog.d("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleGamePubAccountFeeds] ret=", ((StringBuilder)localObject2).toString() });
        }
        if (((WebSSOAgent.UniSsoServerRsp)localObject3).ret.get() != 0L) {
          break label400;
        }
        localObject2 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject3).rspdata.get()).optJSONObject("12787");
        if (localObject2 == null) {
          break label401;
        }
        localObject2 = ((JSONObject)localObject2).optJSONObject("data");
        if (localObject2 == null) {
          break label401;
        }
        localObject2 = ((JSONObject)localObject2).optJSONObject("rsp");
        if (localObject2 == null) {
          break label401;
        }
        Intrinsics.checkExpressionValueIsNotNull(str, "paMsgId");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "appId");
        bool = a(paramApolloRequestReceiveParams, arrayOfObject, str, (String)localObject1, (JSONObject)localObject2);
        if (bool) {
          break label400;
        }
        if (paramApolloRequestReceiveParams == null) {
          Intrinsics.throwNpe();
        }
        paramApolloRequestReceiveParams.notifyUI(29, false, arrayOfObject);
        return;
      }
      catch (Exception localException)
      {
        if (paramApolloRequestReceiveParams == null) {
          Intrinsics.throwNpe();
        }
        paramApolloRequestReceiveParams.notifyUI(29, false, arrayOfObject);
        paramApolloRequestReceiveParams = new StringBuilder();
        paramApolloRequestReceiveParams.append("[handleGamePubAccountFeeds] err:");
        paramApolloRequestReceiveParams.append(localException.getMessage());
        QLog.e("[cmshow]CmGameRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
        return;
      }
      if (paramApolloRequestReceiveParams == null) {
        Intrinsics.throwNpe();
      }
      paramApolloRequestReceiveParams.notifyUI(29, false, arrayOfObject);
      label400:
      return;
      label401:
      boolean bool = false;
    }
  }
  
  @RequestRoute(a="apollo_aio_game.save_user_gamepanel_gamelist")
  public final void handleSaveGameListResult(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    FromServiceMsg localFromServiceMsg = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    Object localObject = paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte;
    paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentMobileqqApolloHandlerApolloExtensionHandler;
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameRequestReceiver", 2, "[handleSaveGameListResult]");
    }
    if (localObject != null)
    {
      if (localFromServiceMsg == null) {
        Intrinsics.throwNpe();
      }
      if (localFromServiceMsg.isSuccess()) {
        try
        {
          paramApolloRequestReceiveParams = new WebSSOAgent.UniSsoServerRsp();
          paramApolloRequestReceiveParams.mergeFrom((byte[])localObject);
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleSaveGameListResult] ret=", Long.valueOf(paramApolloRequestReceiveParams.ret.get()) });
          }
          if (paramApolloRequestReceiveParams.ret.get() == 0L)
          {
            paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.rspdata.get();
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]CmGameRequestReceiver", 2, new Object[] { "[handleSaveGameListResult] respData=", paramApolloRequestReceiveParams });
            }
            paramApolloRequestReceiveParams = new JSONObject(paramApolloRequestReceiveParams).optJSONObject("data");
            if (paramApolloRequestReceiveParams == null) {
              return;
            }
            long l = paramApolloRequestReceiveParams.optLong("timeStamp");
            paramApolloRequestReceiveParams = new StringBuilder();
            paramApolloRequestReceiveParams.append("[handleSaveGameListResult] last timeStamp : ");
            paramApolloRequestReceiveParams.append(l);
            QLog.e("[cmshow]CmGameRequestReceiver", 1, paramApolloRequestReceiveParams.toString());
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[handleSaveGameListResult] ret : ");
          ((StringBuilder)localObject).append(paramApolloRequestReceiveParams.ret.get());
          QLog.e("[cmshow]CmGameRequestReceiver", 1, ((StringBuilder)localObject).toString());
          return;
        }
        catch (Exception paramApolloRequestReceiveParams)
        {
          QLog.e("[cmshow]CmGameRequestReceiver", 1, "[handleGameOnlineCountRsp] exception=", (Throwable)paramApolloRequestReceiveParams);
          return;
        }
      }
    }
    QLog.e("[cmshow]CmGameRequestReceiver", 1, "[handleSaveGameListResult] data null or rsp failed");
    if (paramApolloRequestReceiveParams == null) {
      Intrinsics.throwNpe();
    }
    paramApolloRequestReceiveParams.notifyUI(25, false, null);
  }
  
  @RequestRoute(a="apollo_game_av.get_av_ctrl_param")
  public final void handleSpriteFetchFluidSSORsp(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject1 = paramApolloRequestReceiveParams.jdField_a_of_type_AndroidContentIntent;
    Object localObject2 = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    long l = ((Intent)localObject1).getLongExtra("usrdata", 0L);
    if (paramApolloRequestReceiveParams != null)
    {
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      if (((FromServiceMsg)localObject2).isSuccess())
      {
        localObject1 = new WebSSOAgent.UniSsoServerRsp();
        localObject2 = new qqavopensdkSsoTunnel.STAVCtrlParamRsp();
        try
        {
          ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom(paramApolloRequestReceiveParams);
          ((qqavopensdkSsoTunnel.STAVCtrlParamRsp)localObject2).mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject1).pbRsqData.get().toByteArray());
          paramApolloRequestReceiveParams = ((qqavopensdkSsoTunnel.STAVCtrlParamRsp)((qqavopensdkSsoTunnel.STAVCtrlParamRsp)localObject2).get()).ctrlParam.get().toByteArray();
          SSOTunnelEvent.a().a(l, true, paramApolloRequestReceiveParams);
          return;
        }
        catch (Exception paramApolloRequestReceiveParams)
        {
          QLog.e("[cmshow]CmGameRequestReceiver", 1, "handleRoomSSOInfoCallback error:", (Throwable)paramApolloRequestReceiveParams);
          return;
        }
      }
    }
    SSOTunnelEvent.a().a(l, false, null);
  }
  
  @RequestRoute(a="apollo_game_av.get_usraccinfo")
  public final void handleTinyId2IdentifierRsp(@NotNull ApolloRequestReceiveParams paramApolloRequestReceiveParams)
  {
    Intrinsics.checkParameterIsNotNull(paramApolloRequestReceiveParams, "params");
    Object localObject1 = paramApolloRequestReceiveParams.jdField_a_of_type_AndroidContentIntent;
    localObject1 = paramApolloRequestReceiveParams.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
    paramApolloRequestReceiveParams = paramApolloRequestReceiveParams.jdField_a_of_type_ArrayOfByte;
    if (paramApolloRequestReceiveParams != null)
    {
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (!((FromServiceMsg)localObject1).isSuccess()) {
        return;
      }
      localObject1 = new GetTinyID.STTinyID2UserAccInfoRsp();
      Object localObject2 = new WebSSOAgent.UniSsoServerRsp();
      try
      {
        ((WebSSOAgent.UniSsoServerRsp)localObject2).mergeFrom(paramApolloRequestReceiveParams);
        ((GetTinyID.STTinyID2UserAccInfoRsp)localObject1).mergeFrom(((WebSSOAgent.UniSsoServerRsp)localObject2).pbRsqData.get().toByteArray());
        paramApolloRequestReceiveParams = ((GetTinyID.STTinyID2UserAccInfoRsp)((GetTinyID.STTinyID2UserAccInfoRsp)localObject1).get()).user_acc_info.get();
        if (paramApolloRequestReceiveParams != null)
        {
          if (paramApolloRequestReceiveParams.size() <= 0) {
            return;
          }
          localObject1 = new ArrayList(paramApolloRequestReceiveParams.size());
          localObject2 = new ArrayList(paramApolloRequestReceiveParams.size());
          int i = 0;
          int j = ((Collection)paramApolloRequestReceiveParams).size();
          while (i < j)
          {
            ((ArrayList)localObject1).add(Long.valueOf(((GetTinyID.STUserAccInfo)paramApolloRequestReceiveParams.get(i)).tinyid.get()));
            ((ArrayList)localObject2).add(((GetTinyID.STUserAccInfo)paramApolloRequestReceiveParams.get(i)).identifier.get());
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramApolloRequestReceiveParams)
      {
        QLog.e("[cmshow]CmGameRequestReceiver", 1, "handleRoomSSOInfoCallback error:", (Throwable)paramApolloRequestReceiveParams);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.request.CmGameRequestReceiver
 * JD-Core Version:    0.7.0.1
 */