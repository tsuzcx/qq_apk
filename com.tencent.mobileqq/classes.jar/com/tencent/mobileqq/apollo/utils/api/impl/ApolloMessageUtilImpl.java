package com.tencent.mobileqq.apollo.utils.api.impl;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.ICmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager.BusinessId;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.script.api.ISpriteUtil;
import com.tencent.mobileqq.apollo.statistics.product.Apollo644ReportUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.ThreeDBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class ApolloMessageUtilImpl
  implements IApolloMessageUtil
{
  private static final String TAG = "[cmshow]ApolloMessageUtilImpl";
  
  @NotNull
  private static MessageForApollo createMessageForApollo(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, ApolloInfo paramApolloInfo, boolean paramBoolean, Apollo3DMessage paramApollo3DMessage, ApolloMessage paramApolloMessage)
  {
    paramQQAppInterface = createSendMsg_ApolloAction(paramQQAppInterface, paramString1, paramString2, paramInt, paramApolloMessage);
    paramQQAppInterface.inputText = paramApolloInfo.mAction.inputText;
    paramQQAppInterface.audioId = paramApolloInfo.mAudioId;
    paramQQAppInterface.audioStartTime = paramApolloInfo.mAudioStartTime;
    paramQQAppInterface.isPlayDefaultAudio = paramApolloInfo.mPlayOriginalAudio;
    paramQQAppInterface.actionType = paramApolloInfo.mAction.actionType;
    paramQQAppInterface.mApollo3DMessage = paramApollo3DMessage;
    if (TextUtils.isEmpty(paramQQAppInterface.inputText)) {
      paramQQAppInterface.inputText = paramApolloInfo.mActionText;
    }
    paramQQAppInterface.mSendSrc = paramApolloInfo.mSendSrc;
    paramQQAppInterface.curUsedIdType = paramApolloInfo.mPackageId;
    if ((paramApolloInfo.mAction != null) && (paramApolloInfo.mAction.isForPlayerAction == 1))
    {
      if (paramBoolean)
      {
        paramQQAppInterface.msgType = 12;
        return paramQQAppInterface;
      }
      paramQQAppInterface.msgType = 10;
    }
    return paramQQAppInterface;
  }
  
  public static MessageForApollo createSendMsg_ApolloAction(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ApolloMessage paramApolloMessage)
  {
    MessageForApollo localMessageForApollo = (MessageForApollo)MessageRecordFactory.a(-2039);
    localMessageForApollo.msgtype = -2039;
    localMessageForApollo.mApolloMessage = paramApolloMessage;
    localMessageForApollo.mIsParsed = true;
    MessageRecordFactory.a(paramQQAppInterface, localMessageForApollo, paramString1, paramString2, paramInt);
    try
    {
      localMessageForApollo.msg = getApolloDescMsg(localMessageForApollo);
      localMessageForApollo.msgData = MessagePkgUtils.a(paramApolloMessage);
      return localMessageForApollo;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return localMessageForApollo;
  }
  
  private void decodeTroopApolloMsgPeerInfo(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, MessageForApollo paramMessageForApollo, ArrayList<ApolloBaseInfo> paramArrayList, IApolloDaoManagerService paramIApolloDaoManagerService, StringBuilder paramStringBuilder)
  {
    if (paramMessageForApollo.isDoubleAction())
    {
      paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMessageForApollo.mApolloMessage.peerUin);
      localStringBuilder.append("");
      if (!TextUtils.equals(paramQQAppInterface, localStringBuilder.toString()))
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(paramMessageForApollo.mApolloMessage.peerUin);
        paramQQAppInterface.append("");
        paramQQAppInterface = paramIApolloDaoManagerService.getApolloBaseInfo(paramQQAppInterface.toString());
        if (QLog.isColorLevel())
        {
          paramStringBuilder.append("\n peer: ");
          paramStringBuilder.append(paramQQAppInterface.uin);
          paramStringBuilder.append(", update time: ");
          paramStringBuilder.append(paramQQAppInterface.apolloUpdateTime);
        }
        if ((paramMessageRecord.time > paramQQAppInterface.apolloUpdateTime) && ((paramQQAppInterface.apolloServerTS < paramMessageForApollo.mApolloMessage.peerTs) || (paramQQAppInterface.apolloStatus != paramMessageForApollo.mApolloMessage.peerStatus) || (paramQQAppInterface.superYellowDiamondFlag != (paramMessageForApollo.mApolloMessage.flag >> 31 & 0x1)) || ((paramMessageForApollo.is3dAction()) && (paramMessageForApollo.mApollo3DMessage != null) && (paramQQAppInterface.cmshow3dFlag != paramMessageForApollo.mApollo3DMessage.peerStatus3D))))
        {
          paramQQAppInterface.apolloStatus = paramMessageForApollo.mApolloMessage.peerStatus;
          paramQQAppInterface.apolloServerTS = paramMessageForApollo.mApolloMessage.peerTs;
          paramQQAppInterface.superYellowDiamondFlag = (paramMessageForApollo.mApolloMessage.flag >> 31 & 0x1);
          if ((paramMessageForApollo.is3dAction()) && (paramMessageForApollo.mApollo3DMessage != null)) {
            paramQQAppInterface.cmshow3dFlag = paramMessageForApollo.mApollo3DMessage.peerStatus3D;
          }
          paramQQAppInterface.apolloUpdateTime = paramMessageRecord.time;
          paramArrayList.add(paramQQAppInterface);
          if (QLog.isColorLevel())
          {
            paramStringBuilder.append("\n save apollo info ");
            paramStringBuilder.append(paramQQAppInterface.apolloVipFlag);
            paramStringBuilder.append("|");
            paramStringBuilder.append(paramQQAppInterface.apolloStatus);
            paramStringBuilder.append("|");
            paramStringBuilder.append(paramQQAppInterface.apolloLocalTS);
            paramStringBuilder.append("|");
            paramStringBuilder.append(paramQQAppInterface.apolloServerTS);
            paramStringBuilder.append("|");
            paramStringBuilder.append(paramQQAppInterface.cmshow3dFlag);
            paramStringBuilder.append("|");
            paramStringBuilder.append(paramQQAppInterface.apolloUpdateTime);
          }
        }
      }
    }
  }
  
  private void decodeTroopApolloMsgSenderInfo(MessageRecord paramMessageRecord, MessageForApollo paramMessageForApollo, ArrayList<ApolloBaseInfo> paramArrayList, IApolloDaoManagerService paramIApolloDaoManagerService, StringBuilder paramStringBuilder)
  {
    if (!paramMessageRecord.isSend())
    {
      paramIApolloDaoManagerService = paramIApolloDaoManagerService.getApolloBaseInfo(paramMessageForApollo.senderuin);
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append(", update time: ");
        paramStringBuilder.append(paramIApolloDaoManagerService.apolloUpdateTime);
      }
      if ((paramMessageRecord.time > paramIApolloDaoManagerService.apolloUpdateTime) && ((paramIApolloDaoManagerService.apolloServerTS < paramMessageForApollo.mApolloMessage.senderTs) || (paramIApolloDaoManagerService.apolloStatus != paramMessageForApollo.mApolloMessage.senderStatus) || (paramIApolloDaoManagerService.superYellowDiamondFlag != (paramMessageForApollo.mApolloMessage.flag >> 30 & 0x1)) || ((paramMessageForApollo.is3dAction()) && (paramMessageForApollo.mApollo3DMessage != null) && (paramIApolloDaoManagerService.cmshow3dFlag != paramMessageForApollo.mApollo3DMessage.senderStatus3D))))
      {
        paramIApolloDaoManagerService.apolloStatus = paramMessageForApollo.mApolloMessage.senderStatus;
        paramIApolloDaoManagerService.apolloServerTS = paramMessageForApollo.mApolloMessage.senderTs;
        paramIApolloDaoManagerService.superYellowDiamondFlag = (paramMessageForApollo.mApolloMessage.flag >> 30 & 0x1);
        if ((paramMessageForApollo.is3dAction()) && (paramMessageForApollo.mApollo3DMessage != null)) {
          paramIApolloDaoManagerService.cmshow3dFlag = paramMessageForApollo.mApollo3DMessage.senderStatus3D;
        }
        paramIApolloDaoManagerService.apolloUpdateTime = paramMessageRecord.time;
        paramArrayList.add(paramIApolloDaoManagerService);
        if (QLog.isColorLevel())
        {
          paramStringBuilder.append("\n save apollo info: ");
          paramStringBuilder.append(paramIApolloDaoManagerService.apolloVipFlag);
          paramStringBuilder.append("|");
          paramStringBuilder.append(paramIApolloDaoManagerService.apolloStatus);
          paramStringBuilder.append("|");
          paramStringBuilder.append(paramIApolloDaoManagerService.apolloLocalTS);
          paramStringBuilder.append("|");
          paramStringBuilder.append(paramIApolloDaoManagerService.apolloServerTS);
          paramStringBuilder.append("|");
          paramStringBuilder.append(paramIApolloDaoManagerService.cmshow3dFlag);
          paramStringBuilder.append("|");
          paramStringBuilder.append(paramIApolloDaoManagerService.apolloUpdateTime);
        }
      }
    }
  }
  
  private static void doRealSendMessage(QQAppInterface paramQQAppInterface, ApolloInfo paramApolloInfo, MessageForApollo paramMessageForApollo)
  {
    ISpriteScriptManager localISpriteScriptManager = (ISpriteScriptManager)paramQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
    int i = paramApolloInfo.mAction.actionType;
    ISpriteScriptManager.BusinessId localBusinessId = ISpriteScriptManager.BusinessId;
    if ((i != 0) && (localISpriteScriptManager != null))
    {
      if (((ISpriteUtil)QRoute.api(ISpriteUtil.class)).getActionScript(paramQQAppInterface) == null)
      {
        paramQQAppInterface.getMessageFacade().a(paramMessageForApollo, null);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("actionScript == null send apollo message msg: ");
        paramQQAppInterface.append(paramApolloInfo.toString());
        QLog.i("[cmshow]ApolloMessageUtilImpl", 2, paramQQAppInterface.toString());
        return;
      }
      paramQQAppInterface = localISpriteScriptManager.getSpriteBridge();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramMessageForApollo);
      }
    }
    else
    {
      paramQQAppInterface.getMessageFacade().a(paramMessageForApollo, null);
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("send apollo message msg: ");
        paramQQAppInterface.append(paramApolloInfo.toString());
        QLog.d("[cmshow]ApolloMessageUtilImpl", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static im_msg_body.RichText encodeRichTextFromApolloText(MessageForApollo paramMessageForApollo)
  {
    im_msg_body.ApolloActMsg localApolloActMsg = new im_msg_body.ApolloActMsg();
    ApolloMessage localApolloMessage = paramMessageForApollo.mApolloMessage;
    localApolloActMsg.uint32_action_id.set(localApolloMessage.id);
    localApolloActMsg.uint32_flag.set(localApolloMessage.flag);
    localApolloActMsg.uint32_peer_uin.set(Utils.a(localApolloMessage.peerUin));
    localApolloActMsg.uint32_sender_ts.set(Utils.a(localApolloMessage.senderTs));
    localApolloActMsg.uint32_peer_ts.set(Utils.a(localApolloMessage.peerTs));
    localApolloActMsg.int32_sender_status.set(localApolloMessage.senderStatus);
    localApolloActMsg.int32_peer_status.set(localApolloMessage.peerStatus);
    Object localObject1 = new ApolloMsgExtend.AuthReserve();
    ((ApolloMsgExtend.AuthReserve)localObject1).diy_voice_id.set(paramMessageForApollo.audioId);
    ((ApolloMsgExtend.AuthReserve)localObject1).diy_voice_begin_ts.set((paramMessageForApollo.audioStartTime * 1000.0F));
    ((ApolloMsgExtend.AuthReserve)localObject1).game_id.set(paramMessageForApollo.gameId);
    ((ApolloMsgExtend.AuthReserve)localObject1).sub_type.set(paramMessageForApollo.msgType);
    ((ApolloMsgExtend.AuthReserve)localObject1).room_id.set(paramMessageForApollo.roomId);
    ((ApolloMsgExtend.AuthReserve)localObject1).welcome_id.set(paramMessageForApollo.welcomeId);
    ((ApolloMsgExtend.AuthReserve)localObject1).cur_used_id_type.set(paramMessageForApollo.curUsedIdType);
    if (!TextUtils.isEmpty(paramMessageForApollo.gameName)) {
      ((ApolloMsgExtend.AuthReserve)localObject1).game_name.set(ByteStringMicro.copyFrom(paramMessageForApollo.gameName.getBytes()));
    }
    if (!TextUtils.isEmpty(paramMessageForApollo.gameExtendJson)) {
      ((ApolloMsgExtend.AuthReserve)localObject1).game_share_ark_json.set(ByteStringMicro.copyFrom(paramMessageForApollo.gameExtendJson.getBytes()));
    }
    ((ApolloMsgExtend.AuthReserve)localObject1).action_type.set(paramMessageForApollo.actionType);
    if (!TextUtils.isEmpty(paramMessageForApollo.extendJson)) {
      ((ApolloMsgExtend.AuthReserve)localObject1).extend_json.set(ByteStringMicro.copyFrom(paramMessageForApollo.extendJson.getBytes()));
    }
    if (paramMessageForApollo.mApollo3DMessage != null)
    {
      localObject2 = paramMessageForApollo.mApollo3DMessage;
      ApolloMsgExtend.ThreeDBaseInfo localThreeDBaseInfo = new ApolloMsgExtend.ThreeDBaseInfo();
      localThreeDBaseInfo.uint32_action_id.set(((Apollo3DMessage)localObject2).actionID3D);
      localThreeDBaseInfo.action_type.set(((Apollo3DMessage)localObject2).actionType3D);
      localThreeDBaseInfo.bytes_action_name.set(ByteStringMicro.copyFrom(((Apollo3DMessage)localObject2).actionName3D.getBytes()));
      localThreeDBaseInfo.int32_sender_status.set(((Apollo3DMessage)localObject2).senderStatus3D);
      localThreeDBaseInfo.int32_peer_status.set(((Apollo3DMessage)localObject2).peerStatus3D);
      ((ApolloMsgExtend.AuthReserve)localObject1).act3d.set(localThreeDBaseInfo);
    }
    localObject1 = ((ApolloMsgExtend.AuthReserve)localObject1).toByteArray();
    if ((localObject1 != null) && (localObject1.length > 0)) {
      localApolloActMsg.bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject1));
    }
    if (localApolloMessage.name != null) {
      localApolloActMsg.bytes_action_name.set(ByteStringMicro.copyFrom(localApolloMessage.name));
    }
    if (localApolloMessage.text != null) {
      localApolloActMsg.bytes_action_text.set(ByteStringMicro.copyFrom(localApolloMessage.text));
    }
    if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
      localApolloActMsg.input_text.set(ByteStringMicro.copyFrom(paramMessageForApollo.inputText.getBytes()));
    }
    Object localObject2 = new im_msg_body.Text();
    localObject1 = HardCodeUtil.a(2131904539);
    paramMessageForApollo = (MessageForApollo)localObject1;
    if (localApolloMessage.name != null)
    {
      paramMessageForApollo = new StringBuilder();
      paramMessageForApollo.append((String)localObject1);
      paramMessageForApollo.append(new String(localApolloMessage.name));
      paramMessageForApollo = paramMessageForApollo.toString();
    }
    ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(paramMessageForApollo));
    paramMessageForApollo = new im_msg_body.RichText();
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).apollo_msg.set(localApolloActMsg);
    paramMessageForApollo.elems.add((MessageMicro)localObject1);
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
    paramMessageForApollo.elems.add((MessageMicro)localObject1);
    return paramMessageForApollo;
  }
  
  public static String getApolloDescMsg(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.mApolloMessage.name != null) && (paramMessageForApollo.mApolloMessage.name.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(new String(paramMessageForApollo.mApolloMessage.name));
      if ((paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
      {
        localStringBuilder.append("：");
        localStringBuilder.append(new String(paramMessageForApollo.mApolloMessage.text));
        if (!TextUtils.isEmpty(paramMessageForApollo.inputText))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(paramMessageForApollo.inputText);
        }
      }
      else if (!TextUtils.isEmpty(paramMessageForApollo.inputText))
      {
        localStringBuilder.append("：");
        localStringBuilder.append(paramMessageForApollo.inputText);
      }
      return localStringBuilder.toString();
    }
    return HardCodeUtil.a(2131898802);
  }
  
  @Nullable
  private static JSONObject getExtStrJson(ApolloInfo paramApolloInfo, boolean paramBoolean, Apollo3DMessage paramApollo3DMessage, ApolloActionData paramApolloActionData, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      try
      {
        localJSONObject = new JSONObject();
      }
      catch (Throwable paramApolloInfo)
      {
        break label239;
      }
    }
    if ((paramBoolean) && (paramApollo3DMessage != null) && (paramApolloActionData != null)) {
      localJSONObject.put("actionType", paramApolloActionData.actionType);
    } else {
      localJSONObject.put("actionType", paramApolloInfo.mAction.actionType);
    }
    if (paramApolloInfo.mAudioId > 0)
    {
      localJSONObject.put("audioID", paramApolloInfo.mAudioId);
      localJSONObject.put("audioStartTime", paramApolloInfo.mAudioStartTime);
    }
    boolean bool = TextUtils.isEmpty(paramApolloInfo.mAction.inputText);
    if (!bool) {
      localJSONObject.put("inputText", paramApolloInfo.mAction.inputText);
    } else if (!TextUtils.isEmpty(paramApolloInfo.mActionText)) {
      localJSONObject.put("inputText", paramApolloInfo.mActionText);
    }
    if (paramApollo3DMessage != null)
    {
      paramApollo3DMessage = paramApollo3DMessage.getMessageJSONObject();
      if (paramApollo3DMessage != null) {
        localJSONObject.put("mApollo3DMessage", paramApollo3DMessage);
      }
    }
    if (paramApolloInfo.mAction != null)
    {
      int i = paramApolloInfo.mAction.isForPlayerAction;
      if (i == 1)
      {
        if (paramBoolean)
        {
          localJSONObject.put("msgTyep", 12);
          return localJSONObject;
        }
        localJSONObject.put("msgTyep", 10);
      }
    }
    return localJSONObject;
    label239:
    QLog.e("[cmshow]ApolloMessageUtilImpl", 1, "[sendApolloMsg] exception2:", paramApolloInfo);
    return null;
  }
  
  public static void markRead(MessageForApollo paramMessageForApollo, AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    if (paramMessageForApollo != null)
    {
      if (!(paramAppRuntime instanceof QQAppInterface)) {
        return;
      }
      ThreadManager.getFileThreadHandler().post(new ApolloMessageUtilImpl.1(paramMessageForApollo, paramAppRuntime, paramString, paramInt));
    }
  }
  
  public static void resendApolloMessage(QQAppInterface paramQQAppInterface, int paramInt, String paramString, long paramLong)
  {
    MessageRecord localMessageRecord = paramQQAppInterface.getMessageFacade().a(paramString, paramInt, paramLong);
    if (localMessageRecord != null)
    {
      paramQQAppInterface.getMessageFacade().h(paramString, paramInt, paramLong);
      paramString = MessageRecordFactory.a(localMessageRecord);
      paramQQAppInterface.getMessageFacade().a(paramString, null, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloMessageUtilImpl", 2, "resendApolloMessage : mr is null.");
    }
  }
  
  private void saveC2CIsUpdateApolloBaseInfo(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, MessageForApollo paramMessageForApollo, IApolloManagerService paramIApolloManagerService, StringBuilder paramStringBuilder)
  {
    paramIApolloManagerService = (IApolloDaoManagerService)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    boolean bool2 = paramMessageForApollo.isSend();
    boolean bool1;
    if (paramMessageForApollo.mApolloMessage.peerUin != 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    long l;
    int i;
    if (((bool2 & bool1)) && (paramMessageForApollo.mApolloMessage.peerUin != paramQQAppInterface.getLongAccountUin()))
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(paramMessageForApollo.mApolloMessage.peerUin);
      paramQQAppInterface.append("");
      paramQQAppInterface = paramIApolloManagerService.getApolloBaseInfo(paramQQAppInterface.toString());
      l = paramMessageForApollo.mApolloMessage.peerTs;
      i = paramMessageForApollo.mApolloMessage.peerStatus;
    }
    else
    {
      paramQQAppInterface = paramIApolloManagerService.getApolloBaseInfo(paramMessageForApollo.senderuin);
      l = paramMessageForApollo.mApolloMessage.senderTs;
      i = paramMessageForApollo.mApolloMessage.senderStatus;
    }
    if ((QLog.isColorLevel()) && (paramQQAppInterface != null))
    {
      paramStringBuilder.append("\n fuin: ");
      paramStringBuilder.append(paramQQAppInterface.uin);
      paramStringBuilder.append(", msg time: ");
      paramStringBuilder.append(paramMessageRecord.time);
      paramStringBuilder.append(", msg ts: ");
      paramStringBuilder.append(l);
      paramStringBuilder.append(", svr ts: ");
      paramStringBuilder.append(paramQQAppInterface.apolloServerTS);
      paramStringBuilder.append(", update time: ");
      paramStringBuilder.append(paramQQAppInterface.apolloUpdateTime);
      paramStringBuilder.append(", status: ");
      paramStringBuilder.append(i);
    }
    if (updateC2CApolloBaseInfo(paramMessageRecord, paramMessageForApollo, paramQQAppInterface, l, i))
    {
      paramIApolloManagerService.saveOrUpdateApolloBaseInfo(paramQQAppInterface);
      if ((QLog.isColorLevel()) && (paramQQAppInterface != null))
      {
        paramStringBuilder.append("\n save apollo info fuin: ");
        paramStringBuilder.append(paramQQAppInterface.uin);
        paramStringBuilder.append("-->");
        paramStringBuilder.append(paramQQAppInterface.apolloVipFlag);
        paramStringBuilder.append("|");
        paramStringBuilder.append(paramQQAppInterface.apolloStatus);
        paramStringBuilder.append("|");
        paramStringBuilder.append(paramQQAppInterface.apolloLocalTS);
        paramStringBuilder.append("|");
        paramStringBuilder.append(paramQQAppInterface.apolloServerTS);
        paramStringBuilder.append("|");
        paramStringBuilder.append(paramQQAppInterface.apolloUpdateTime);
        paramStringBuilder.append("|");
        paramStringBuilder.append(paramQQAppInterface.apolloSignValidTS);
      }
    }
  }
  
  public static void sendApolloMsg(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, ApolloInfo paramApolloInfo)
  {
    if ((paramQQAppInterface != null) && (paramApolloInfo != null) && (paramApolloInfo.mAction != null) && (!TextUtils.isEmpty(paramApolloInfo.mAction.actionName)))
    {
      if ((paramApolloInfo.mAction.personNum > 0) && (TextUtils.isEmpty(paramApolloInfo.mAction.peerUin))) {
        return;
      }
      IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
      updateActionPeerUinApolloState(paramQQAppInterface, paramInt, paramApolloInfo, localIApolloDaoManagerService);
      boolean bool = ApolloActionData.isAction3DModel(paramApolloInfo.mAction.actionId);
      QLog.d("[cmshow]ApolloMessageUtilImpl", 1, new Object[] { "[sendApolloMsg] actionId=", Integer.valueOf(paramApolloInfo.mAction.actionId), ", is3dAction=", Boolean.valueOf(bool) });
      ApolloMessage localApolloMessage = new ApolloMessage();
      Apollo3DMessage localApollo3DMessage;
      if (bool)
      {
        localApollo3DMessage = new Apollo3DMessage();
        if (paramApolloInfo.mAction.personNum > 0) {
          localApolloMessage.id = 1454;
        } else {
          localApolloMessage.id = 1450;
        }
        localObject = localIApolloDaoManagerService.findActionById(localApolloMessage.id);
      }
      else
      {
        localApollo3DMessage = null;
        localObject = localApollo3DMessage;
      }
      updateMessageIdAndName(bool, paramApolloInfo, localApolloMessage, localApollo3DMessage, (ApolloActionData)localObject, localIApolloDaoManagerService);
      updateMessageText(paramInt, paramApolloInfo, localApolloMessage);
      updateMessageSender(paramQQAppInterface, localIApolloDaoManagerService, bool, localApollo3DMessage, localApolloMessage);
      updateMessageRichFlag(paramInt, paramApolloInfo, localIApolloDaoManagerService, bool, localApollo3DMessage, localApolloMessage);
      Object localObject = getExtStrJson(paramApolloInfo, bool, localApollo3DMessage, (ApolloActionData)localObject, null);
      if (localObject == null) {
        return;
      }
      localApolloMessage.extStr = ((JSONObject)localObject).toString();
      doRealSendMessage(paramQQAppInterface, paramApolloInfo, createMessageForApollo(paramQQAppInterface, paramInt, paramString1, paramString2, paramApolloInfo, bool, localApollo3DMessage, localApolloMessage));
    }
  }
  
  private static void updateActionPeerUinApolloState(QQAppInterface paramQQAppInterface, int paramInt, ApolloInfo paramApolloInfo, IApolloDaoManagerService paramIApolloDaoManagerService)
  {
    FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    IApolloExtensionHandler localIApolloExtensionHandler = (IApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    if ((paramInt == 1) && (paramApolloInfo.mAction.personNum > 0) && (!paramApolloInfo.mAction.peerUin.equals(paramQQAppInterface.getCurrentAccountUin())))
    {
      paramQQAppInterface = paramIApolloDaoManagerService.getApolloBaseInfo(paramApolloInfo.mAction.peerUin);
      if (paramQQAppInterface == null)
      {
        localIApolloExtensionHandler.b(paramApolloInfo.mAction.peerUin);
        return;
      }
      if ((!localFriendsManager.n(paramApolloInfo.mAction.peerUin)) && (NetConnInfoCenter.getServerTime() - paramQQAppInterface.apolloUpdateTime >= 300L))
      {
        localIApolloExtensionHandler.b(paramApolloInfo.mAction.peerUin);
        return;
      }
      if ((localFriendsManager.n(paramApolloInfo.mAction.peerUin)) && (paramQQAppInterface.apolloUpdateTime == 0L))
      {
        localIApolloExtensionHandler.b(paramApolloInfo.mAction.peerUin);
        return;
      }
      if (paramQQAppInterface.apolloServerTS != paramQQAppInterface.apolloLocalTS)
      {
        paramQQAppInterface = new ArrayList(1);
        paramQQAppInterface.add(Long.valueOf(Long.parseLong(paramApolloInfo.mAction.peerUin)));
        localIApolloExtensionHandler.a(paramQQAppInterface, "TROOP_AIO");
      }
    }
  }
  
  private boolean updateC2CApolloBaseInfo(MessageRecord paramMessageRecord, MessageForApollo paramMessageForApollo, ApolloBaseInfo paramApolloBaseInfo, long paramLong, int paramInt)
  {
    if ((paramApolloBaseInfo != null) && (paramMessageRecord.time > paramApolloBaseInfo.apolloUpdateTime) && (paramApolloBaseInfo.apolloServerTS < paramLong))
    {
      paramApolloBaseInfo.apolloStatus = paramInt;
      paramApolloBaseInfo.apolloServerTS = paramLong;
      paramApolloBaseInfo.apolloVipFlag = (paramMessageForApollo.mApolloMessage.flag >> 30 & 0x1);
      paramApolloBaseInfo.apolloUpdateTime = paramMessageRecord.time;
      if ((!paramMessageForApollo.isSend()) && (paramMessageForApollo.signTs > NetConnInfoCenter.getServerTime()) && (paramMessageForApollo.signTs != paramApolloBaseInfo.apolloSignValidTS))
      {
        paramApolloBaseInfo.apolloSignValidTS = paramMessageForApollo.signTs;
        paramApolloBaseInfo.apolloSignStr = "";
        return true;
      }
    }
    else if ((paramApolloBaseInfo != null) && (!paramMessageForApollo.isSend()) && (paramMessageForApollo.signTs > NetConnInfoCenter.getServerTime()) && (paramMessageForApollo.signTs != paramApolloBaseInfo.apolloSignValidTS))
    {
      paramApolloBaseInfo.apolloSignValidTS = paramMessageForApollo.signTs;
      paramApolloBaseInfo.apolloSignStr = "";
      return true;
    }
    return false;
  }
  
  private static void updateMessageIdAndName(boolean paramBoolean, ApolloInfo paramApolloInfo, ApolloMessage paramApolloMessage, Apollo3DMessage paramApollo3DMessage, ApolloActionData paramApolloActionData, IApolloDaoManagerService paramIApolloDaoManagerService)
  {
    if (paramBoolean) {}
    try
    {
      paramApollo3DMessage.actionID3D = paramApolloInfo.mAction.actionId;
      paramApollo3DMessage.actionType3D = paramApolloInfo.mAction.actionType;
      paramApollo3DMessage.actionName3D = paramApolloInfo.mAction.actionName;
      if ((paramApolloActionData != null) && (!TextUtils.isEmpty(paramApolloActionData.actionName)))
      {
        paramApolloMessage.name = paramApolloActionData.actionName.getBytes("UTF-8");
        return;
      }
      paramApolloMessage.name = "3D动作".getBytes();
      return;
    }
    catch (Exception paramApolloInfo)
    {
      QLog.e("[cmshow]ApolloMessageUtilImpl", 1, "[sendApolloMsg] exception:", paramApolloInfo);
    }
    paramApolloMessage.id = paramApolloInfo.mAction.actionId;
    paramApolloMessage.name = paramApolloInfo.mAction.actionName.getBytes("UTF-8");
    return;
  }
  
  private static int updateMessagePeerUin(int paramInt1, ApolloInfo paramApolloInfo, IApolloDaoManagerService paramIApolloDaoManagerService, int paramInt2, boolean paramBoolean, Apollo3DMessage paramApollo3DMessage, ApolloMessage paramApolloMessage)
  {
    int i = paramInt2;
    if (paramApolloInfo.mAction.personNum > 0)
    {
      paramApolloMessage.peerUin = Long.valueOf(paramApolloInfo.mAction.peerUin).longValue();
      paramIApolloDaoManagerService = paramIApolloDaoManagerService.getApolloBaseInfo(paramApolloInfo.mAction.peerUin);
      paramApolloMessage.peerTs = Utils.a(paramIApolloDaoManagerService.apolloServerTS);
      paramApolloMessage.peerStatus = paramIApolloDaoManagerService.apolloStatus;
      if ((paramBoolean) && (paramApollo3DMessage != null)) {
        paramApollo3DMessage.peerStatus3D = paramIApolloDaoManagerService.cmshow3dFlag;
      }
      paramInt2 = paramInt2 | 0x4 | 0x2 | 0x10 | 0x40;
      i = paramInt2;
      if (paramBoolean) {
        i = paramInt2 | 0x800;
      }
    }
    if ((paramApolloInfo.mAction.personNum == 0) && (((ICmShowAioMatcher)QRoute.api(ICmShowAioMatcher.class)).isSupported(paramInt1, 1))) {
      paramApolloMessage.peerUin = Long.valueOf(paramApolloInfo.mAction.peerUin).longValue();
    }
    return i;
  }
  
  private static void updateMessageRichFlag(int paramInt, ApolloInfo paramApolloInfo, IApolloDaoManagerService paramIApolloDaoManagerService, boolean paramBoolean, Apollo3DMessage paramApollo3DMessage, ApolloMessage paramApolloMessage)
  {
    if (paramBoolean) {
      i = 1024;
    } else {
      i = 0;
    }
    int i = updateMessagePeerUin(paramInt, paramApolloInfo, paramIApolloDaoManagerService, i | 0x1 | 0x8 | 0x20, paramBoolean, paramApollo3DMessage, paramApolloMessage);
    paramInt = i;
    if (paramApolloInfo.mTextType == 1) {
      paramInt = i | 0x80;
    }
    paramApolloMessage.flag = paramInt;
  }
  
  private static void updateMessageSender(QQAppInterface paramQQAppInterface, IApolloDaoManagerService paramIApolloDaoManagerService, boolean paramBoolean, Apollo3DMessage paramApollo3DMessage, ApolloMessage paramApolloMessage)
  {
    paramQQAppInterface = paramIApolloDaoManagerService.getApolloBaseInfo(paramQQAppInterface.getCurrentAccountUin());
    paramApolloMessage.senderTs = Utils.a(paramQQAppInterface.apolloServerTS);
    paramApolloMessage.senderStatus = paramQQAppInterface.apolloStatus;
    if ((paramBoolean) && (paramApollo3DMessage != null)) {
      paramApollo3DMessage.senderStatus3D = paramQQAppInterface.cmshow3dFlag;
    }
  }
  
  private static void updateMessageText(int paramInt, ApolloInfo paramApolloInfo, ApolloMessage paramApolloMessage)
  {
    if ((!TextUtils.isEmpty(paramApolloInfo.mAction.atNickName)) && ((paramInt == 1) || (paramInt == 3000))) {
      paramApolloMessage.text = paramApolloInfo.mAction.atNickName.getBytes();
    }
  }
  
  public String buildMsgContentForMsg(AppInterface paramAppInterface, Message paramMessage)
  {
    MessageForApollo localMessageForApollo = new MessageForApollo();
    localMessageForApollo.msgData = paramMessage.msgData;
    localMessageForApollo.parse();
    return ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).getApolloMsgTranDec(paramAppInterface, localMessageForApollo);
  }
  
  public void copyChatMessage(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForApollo))
    {
      paramMessageRecord = ((MessageForApollo)paramMessageRecord).mApolloGameArkMsg;
      if (paramMessageRecord != null) {
        paramMessageRecord.arkContainer = null;
      }
    }
  }
  
  public MessageRecord createApolloMsgRecord()
  {
    return new MessageForApollo();
  }
  
  public void decodeBaseMsgApollo(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.msg = HardCodeUtil.a(2131899247);
    if (paramMessageRecord.msgData != null) {
      paramMessageRecord.msg = ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).getApolloMsgTranDec(paramAppRuntime, paramMessageRecord);
    }
  }
  
  public void decodeC2CApolloMsg(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    if (!(paramAppRuntime instanceof QQAppInterface))
    {
      QLog.e("[cmshow]ApolloMessageUtilImpl", 1, "[decodeVasApolloMsg] error! qqAppInterfaceObj is not instance of QQAppInterface");
      return;
    }
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    MessageForApollo localMessageForApollo = (MessageForApollo)paramMessageRecord;
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("decode apollo c2c msg: ");
      localStringBuilder.append(", id: ");
      localStringBuilder.append(localMessageForApollo.mApolloMessage.id);
      localStringBuilder.append(", name: ");
      localStringBuilder.append(new String(localMessageForApollo.mApolloMessage.name));
      localStringBuilder.append(", doubleAction: ");
      localStringBuilder.append(localMessageForApollo.isDoubleAction());
      localStringBuilder.append(", signTS: ");
      localStringBuilder.append(localMessageForApollo.signTs);
    }
    saveC2CIsUpdateApolloBaseInfo(paramAppRuntime, paramMessageRecord, localMessageForApollo, localIApolloManagerService, localStringBuilder);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloMessageUtilImpl", 2, localStringBuilder.toString());
    }
    Apollo644ReportUtil.a(paramAppRuntime, localMessageForApollo, localIApolloManagerService);
  }
  
  public void decodeTroopVasApolloMsg(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    if (!(paramAppRuntime instanceof QQAppInterface))
    {
      QLog.e("[cmshow]ApolloMessageUtilImpl", 1, "[decodeVasApolloMsg] error! qqAppInterfaceObj is not instance of QQAppInterface");
      return;
    }
    paramAppRuntime = (QQAppInterface)paramAppRuntime;
    MessageForApollo localMessageForApollo = (MessageForApollo)paramMessageRecord;
    ArrayList localArrayList = new ArrayList(2);
    IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all");
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("decode apollo troop msg: ");
      localStringBuilder.append(", id: ");
      localStringBuilder.append(localMessageForApollo.mApolloMessage.id);
      localStringBuilder.append(", name: ");
      localStringBuilder.append(new String(localMessageForApollo.mApolloMessage.name));
      localStringBuilder.append(", doubleAction: ");
      localStringBuilder.append(localMessageForApollo.isDoubleAction());
      localStringBuilder.append(", time: ");
      localStringBuilder.append(paramMessageRecord.time);
      localStringBuilder.append("\nsender: ");
      localStringBuilder.append(paramMessageRecord.senderuin);
    }
    decodeTroopApolloMsgSenderInfo(paramMessageRecord, localMessageForApollo, localArrayList, localIApolloDaoManagerService, localStringBuilder);
    decodeTroopApolloMsgPeerInfo(paramAppRuntime, paramMessageRecord, localMessageForApollo, localArrayList, localIApolloDaoManagerService, localStringBuilder);
    if (localArrayList.size() > 0) {
      localIApolloDaoManagerService.bulkSaveOrUpdateApolloBaseInfos(localArrayList);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloMessageUtilImpl", 2, localStringBuilder.toString());
    }
    Apollo644ReportUtil.a(paramAppRuntime, paramMessageRecord, localMessageForApollo, (IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all"));
  }
  
  public void delMsg(Context paramContext, AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForApollo))
    {
      paramMessageRecord = (MessageForApollo)paramMessageRecord;
      if (paramMessageRecord != null)
      {
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopTaskByMsg(paramMessageRecord.uniseq, paramAppInterface, "del_msg");
        if ((paramMessageRecord.mApolloMessage != null) && ((paramContext instanceof BaseActivity)))
        {
          paramContext = ((BaseActivity)paramContext).getChatFragment().k();
          if ((paramContext != null) && (paramContext.ah != null)) {
            VipUtils.a(paramAppInterface, "cmshow", "Apollo", "del_success", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramContext.ah.a), 0, new String[] { Integer.toString(paramMessageRecord.mApolloMessage.id) });
          }
        }
      }
    }
  }
  
  public void delMsgWithNoCheck(Context paramContext, AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord = (MessageForApollo)paramMessageRecord;
    if (paramMessageRecord != null)
    {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopTaskByMsg(paramMessageRecord.uniseq, paramAppInterface, "del_msg");
      if ((paramMessageRecord.mApolloMessage != null) && ((paramContext instanceof BaseActivity)))
      {
        paramContext = ((BaseActivity)paramContext).getChatFragment().k();
        if ((paramContext != null) && (paramContext.ah != null)) {
          VipUtils.a(paramAppInterface, "cmshow", "Apollo", "del_success", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramContext.ah.a), 0, new String[] { Integer.toString(paramMessageRecord.mApolloMessage.id) });
        }
      }
    }
  }
  
  public String getApolloDescMsg(byte[] paramArrayOfByte)
  {
    return getApolloDescMsg(getMessageForApollo(paramArrayOfByte));
  }
  
  public String getApolloMsgTranDec(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return HardCodeUtil.a(2131898795);
    }
    if ((paramMessageRecord instanceof MessageForApollo))
    {
      paramMessageRecord = (MessageForApollo)paramMessageRecord;
    }
    else
    {
      MessageForApollo localMessageForApollo = new MessageForApollo();
      localMessageForApollo.msgData = paramMessageRecord.msgData;
      paramMessageRecord = localMessageForApollo;
    }
    paramMessageRecord.parse();
    paramAppRuntime = ApolloUtilImpl.getDisplayActionName(paramAppRuntime, paramMessageRecord);
    if (ApolloUtilImpl.isApolloAnimationBubble(paramMessageRecord.msgType))
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append(HardCodeUtil.a(2131886725));
      paramMessageRecord.append(paramAppRuntime);
      return paramMessageRecord.toString();
    }
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append(HardCodeUtil.a(2131898796));
    paramMessageRecord.append(paramAppRuntime);
    return paramMessageRecord.toString();
  }
  
  public MessageForApollo getMessageForApollo(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    MessageForApollo localMessageForApollo = new MessageForApollo();
    localMessageForApollo.msgData = paramArrayOfByte;
    localMessageForApollo.parse();
    return localMessageForApollo;
  }
  
  public im_msg_body.RichText getSendApolloBody(MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof MessageForApollo)) {
      return null;
    }
    paramMessageRecord = (MessageForApollo)paramMessageRecord;
    if (paramMessageRecord.mApolloMessage == null) {
      return null;
    }
    return encodeRichTextFromApolloText(paramMessageRecord);
  }
  
  public void handleRevokeRspByType(MessageRecord paramMessageRecord, AppInterface paramAppInterface, int paramInt)
  {
    if ((paramMessageRecord instanceof MessageForApollo))
    {
      paramMessageRecord = (MessageForApollo)paramMessageRecord;
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopTaskByMsg(paramMessageRecord.uniseq, paramAppInterface, "withdraw_msg");
      if (paramMessageRecord.mApolloMessage != null) {
        VipUtils.a(paramAppInterface, "cmshow", "Apollo", "withdraw_success", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramInt), 0, new String[] { Integer.toString(paramMessageRecord.mApolloMessage.id) });
      }
    }
  }
  
  public void setChatHistoryView(TextView paramTextView, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = getMessageForApollo(paramArrayOfByte);
    if (paramArrayOfByte != null)
    {
      paramTextView.setVisibility(0);
      if (!TextUtils.isEmpty(paramArrayOfByte.msg))
      {
        paramTextView.setText(paramArrayOfByte.msg);
        return;
      }
      paramTextView.setText(HardCodeUtil.a(2131899863));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl
 * JD-Core Version:    0.7.0.1
 */