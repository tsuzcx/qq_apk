package com.tencent.mobileqq.apollo.message;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.SimplePBElemDecoder;
import com.tencent.mobileqq.apollo.api.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.ThreeDBaseInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.Elem;

public class ApolloElemDecoder
  extends SimplePBElemDecoder
{
  private float a(float paramFloat, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.diy_voice_begin_ts.has()) {
      paramFloat = (float)paramAuthReserve.diy_voice_begin_ts.get() / 1000.0F;
    }
    return paramFloat;
  }
  
  private int a(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.diy_voice_id.has()) {
      paramInt = paramAuthReserve.diy_voice_id.get();
    }
    return paramInt;
  }
  
  private long a(long paramLong, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.room_id.has()) {
      paramLong = paramAuthReserve.room_id.get();
    }
    return paramLong;
  }
  
  private long a(long paramLong, ApolloMsgExtend.AuthReserve paramAuthReserve, QQAppInterface paramQQAppInterface)
  {
    paramLong = paramAuthReserve.action_ver.get();
    if ((paramLong != 0L) && (paramLong > ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloPanelJsonVer(1))) {
      ApolloContentUpdateHandler.a(paramQQAppInterface, 1);
    }
    return paramLong;
  }
  
  private Apollo3DMessage a(Apollo3DMessage paramApollo3DMessage, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.act3d.has())
    {
      paramAuthReserve = (ApolloMsgExtend.ThreeDBaseInfo)paramAuthReserve.act3d.get();
      if (paramAuthReserve.uint32_action_id.has()) {
        paramApollo3DMessage.actionID_3D = paramAuthReserve.uint32_action_id.get();
      }
      if (paramAuthReserve.action_type.has()) {
        paramApollo3DMessage.actionType_3D = paramAuthReserve.action_type.get();
      }
      if (paramAuthReserve.bytes_action_name.has()) {
        paramApollo3DMessage.actionName_3D = new String(paramAuthReserve.bytes_action_name.get().toByteArray());
      }
      if (paramAuthReserve.int32_sender_status.has()) {
        paramApollo3DMessage.senderStatus_3D = paramAuthReserve.int32_sender_status.get();
      }
      if (paramAuthReserve.int32_peer_status.has()) {
        paramApollo3DMessage.peerStatus_3D = paramAuthReserve.int32_peer_status.get();
      }
    }
    return paramApollo3DMessage;
  }
  
  private String a(String paramString, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    String str = paramString;
    if (paramAuthReserve.game_name.has())
    {
      str = paramString;
      if (paramAuthReserve.game_name.get() != null) {
        str = new String(paramAuthReserve.game_name.get().toByteArray());
      }
    }
    return str;
  }
  
  private List<Long> a(List<Long> paramList, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.uin_list.has()) {
      paramList = paramAuthReserve.uin_list.get();
    }
    return paramList;
  }
  
  private void a(ApolloMessage paramApolloMessage, msg_comm.Msg paramMsg, MessageInfo paramMessageInfo, QQAppInterface paramQQAppInterface)
  {
    if (!paramMsg.msg_head.group_info.has()) {}
    while (paramApolloMessage.peer_uin != paramQQAppInterface.getLongAccountUin()) {
      return;
    }
    long l = paramMsg.msg_head.msg_seq.get();
    paramMessageInfo.a.b(24, l);
  }
  
  private void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int i = 0;
    if (i < paramList.size()) {
      if (!((im_msg_body.Elem)paramList.get(i)).apollo_msg.has()) {}
    }
    for (Object localObject3 = (im_msg_body.ApolloActMsg)((im_msg_body.Elem)paramList.get(i)).apollo_msg.get();; localObject3 = null)
    {
      if (localObject3 == null)
      {
        return;
        i += 1;
        break;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:Apollo...\n");
      }
      ApolloMessage localApolloMessage;
      int i5;
      float f2;
      long l6;
      int i3;
      int i8;
      int i6;
      long l4;
      int i7;
      Object localObject8;
      Object localObject4;
      int i9;
      int i4;
      long l5;
      Object localObject6;
      Object localObject9;
      long l1;
      int j;
      Object localObject1;
      int k;
      Object localObject2;
      int m;
      long l2;
      int i1;
      int n;
      long l3;
      float f1;
      int i2;
      label1495:
      try
      {
        localApolloMessage = new ApolloMessage();
        localApolloMessage.id = ((im_msg_body.ApolloActMsg)localObject3).uint32_action_id.get();
        localApolloMessage.name = ((im_msg_body.ApolloActMsg)localObject3).bytes_action_name.get().toByteArray();
        if ((!paramBoolean) && (((im_msg_body.ApolloActMsg)localObject3).bytes_action_text.has())) {
          localApolloMessage.text = ((im_msg_body.ApolloActMsg)localObject3).bytes_action_text.get().toByteArray();
        }
        i5 = -1;
        f2 = 0.0F;
        l6 = 0L;
        i3 = -1;
        i8 = 0;
        i6 = 0;
        l4 = 0L;
        localObject7 = null;
        i7 = 0;
        localObject8 = null;
        localObject4 = null;
        i9 = 0;
        i4 = 0;
        l5 = 0L;
        localObject6 = new Apollo3DMessage();
        localObject9 = new ApolloMsgExtend.AuthReserve();
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
      }
      catch (Throwable paramList) {}
      try
      {
        ((ApolloMsgExtend.AuthReserve)localObject9).mergeFrom(((im_msg_body.ApolloActMsg)localObject3).bytes_pb_reserve.get().toByteArray());
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        i5 = a(-1, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        f2 = a(0.0F, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        i3 = b(-1, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        i8 = c(0, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        l4 = a(0L, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        localObject7 = a(null, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        localObject4 = b(null, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        l6 = b(0L, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        a(0L, (ApolloMsgExtend.AuthReserve)localObject9, localQQAppInterface);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        i6 = d(0, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        localObject8 = c(null, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        i7 = e(0, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        localObject6 = a((Apollo3DMessage)localObject6, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        i4 = f(0, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        i9 = g(0, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        l5 = c(0L, (ApolloMsgExtend.AuthReserve)localObject9);
        paramList = (List<im_msg_body.Elem>)localObject6;
        i = i4;
        l1 = l5;
        j = i9;
        paramStringBuilder = (StringBuilder)localObject4;
        localObject1 = localObject8;
        k = i7;
        localObject2 = localObject7;
        m = i6;
        l2 = l4;
        i1 = i8;
        n = i3;
        l3 = l6;
        f1 = f2;
        i2 = i5;
        localObject9 = a(null, (ApolloMsgExtend.AuthReserve)localObject9);
        n = i3;
        localObject2 = localObject8;
        localObject1 = localObject4;
        paramStringBuilder = (StringBuilder)localObject9;
        paramList = (List<im_msg_body.Elem>)localObject6;
        i2 = i5;
        l3 = l6;
        i1 = i8;
        localObject4 = localObject7;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
        localObject5 = localObject2;
        localObject2 = localObject1;
        localObject1 = paramStringBuilder;
        paramStringBuilder = null;
        i4 = i;
        l5 = l1;
        i9 = j;
        i7 = k;
        i6 = m;
        l4 = l2;
        f2 = f1;
        break label1495;
        ((JSONObject)localObject7).put("welcomeUinList", localObject8);
        localObject8 = paramList.getMessageJSONObject();
        if (localObject8 == null) {
          break label1889;
        }
        ((JSONObject)localObject7).put("mApollo3DMessage", localObject8);
        localApolloMessage.extStr = ((JSONObject)localObject7).toString();
        localApolloMessage.flag = ((im_msg_body.ApolloActMsg)localObject3).uint32_flag.get();
        localApolloMessage.peer_uin = Utils.a(((im_msg_body.ApolloActMsg)localObject3).uint32_peer_uin.get());
        localApolloMessage.sender_ts = Utils.a(((im_msg_body.ApolloActMsg)localObject3).uint32_sender_ts.get());
        localApolloMessage.peer_ts = Utils.a(((im_msg_body.ApolloActMsg)localObject3).uint32_peer_ts.get());
        localApolloMessage.sender_status = ((im_msg_body.ApolloActMsg)localObject3).int32_sender_status.get();
        localApolloMessage.peer_status = ((im_msg_body.ApolloActMsg)localObject3).int32_peer_status.get();
        localObject3 = (MessageForApollo)MessageRecordFactory.a(-2039);
        ((MessageForApollo)localObject3).msgtype = -2039;
        ((MessageForApollo)localObject3).mApolloMessage = localApolloMessage;
        ((MessageForApollo)localObject3).msgData = MessagePkgUtils.a(localApolloMessage);
        ((MessageForApollo)localObject3).inputText = ((String)localObject6);
        ((MessageForApollo)localObject3).audioId = i2;
        ((MessageForApollo)localObject3).audioStartTime = f2;
        ((MessageForApollo)localObject3).msgType = n;
        ((MessageForApollo)localObject3).gameId = i1;
        ((MessageForApollo)localObject3).mGameMode = i6;
        ((MessageForApollo)localObject3).roomId = l4;
        ((MessageForApollo)localObject3).signTs = l3;
        ((MessageForApollo)localObject3).gameName = localObject5;
        ((MessageForApollo)localObject3).actionType = i7;
        ((MessageForApollo)localObject3).extendJson = localObject2;
        ((MessageForApollo)localObject3).gameExtendJson = ((String)localObject1);
        ((MessageForApollo)localObject3).gameStatus = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getJsonIntValue(((MessageForApollo)localObject3).extendJson, "gameStatus");
        ((MessageForApollo)localObject3).mApollo3DMessage = paramList;
        ((MessageForApollo)localObject3).stickerHeight = i4;
        ((MessageForApollo)localObject3).stickerWidth = i9;
        ((MessageForApollo)localObject3).welcomeId = l5;
        ((MessageForApollo)localObject3).welcomeUinList = paramStringBuilder;
        paramList1.add(localObject3);
      }
      Object localObject7 = new JSONObject();
      if (((im_msg_body.ApolloActMsg)localObject3).input_text.has())
      {
        localObject6 = new String(((im_msg_body.ApolloActMsg)localObject3).input_text.get().toByteArray());
        ((JSONObject)localObject7).put("inputText", localObject6);
      }
      for (;;)
      {
        if (i2 > 0)
        {
          ((JSONObject)localObject7).put("audioID", i2);
          ((JSONObject)localObject7).put("audioStartTime", f2);
        }
        if (ApolloGameUtil.a(n))
        {
          ((JSONObject)localObject7).put("gameId", i1);
          ((JSONObject)localObject7).put("gameMode", i6);
          ((JSONObject)localObject7).put("roomid", l4);
          ((JSONObject)localObject7).put("msgTyep", n);
          ((JSONObject)localObject7).put("gameName", localObject4);
          ((JSONObject)localObject7).put("gameExtendJson", localObject1);
        }
        if (!TextUtils.isEmpty(localObject2)) {
          ((JSONObject)localObject7).put("extendJson", localObject2);
        }
        ((JSONObject)localObject7).put("msgTyep", n);
        ((JSONObject)localObject7).put("actionType", i7);
        ((JSONObject)localObject7).put("stickerHeight", i4);
        ((JSONObject)localObject7).put("stickerWidth", i9);
        ((JSONObject)localObject7).put("welcomeId", l5);
        if ((paramStringBuilder != null) && (!paramStringBuilder.isEmpty()))
        {
          localObject8 = new JSONArray();
          localObject9 = paramStringBuilder.iterator();
          for (;;)
          {
            if (((Iterator)localObject9).hasNext())
            {
              ((JSONArray)localObject8).put((Long)((Iterator)localObject9).next());
              continue;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("ApolloElemDecoder", 2, "decode apollo msg failed", paramList);
              return;
            }
          }
        }
        Object localObject5;
        label1889:
        if (QzoneConfig.getInstance().getConfig("CMShow", "CMShowGroupAIOWithAt", 0) == 0) {
          break;
        }
        a(localApolloMessage, paramMsg, paramMessageInfo, localQQAppInterface);
        return;
        localObject6 = null;
      }
    }
  }
  
  private int b(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.sub_type.has()) {
      paramInt = paramAuthReserve.sub_type.get();
    }
    return paramInt;
  }
  
  private long b(long paramLong, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.sign_ts.has()) {
      paramLong = paramAuthReserve.sign_ts.get();
    }
    return paramLong;
  }
  
  private String b(String paramString, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    String str = paramString;
    if (paramAuthReserve.game_share_ark_json.has())
    {
      str = paramString;
      if (paramAuthReserve.game_share_ark_json.get() != null) {
        str = new String(paramAuthReserve.game_share_ark_json.get().toByteArray());
      }
    }
    return str;
  }
  
  private int c(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.game_id.has()) {
      paramInt = paramAuthReserve.game_id.get();
    }
    return paramInt;
  }
  
  private long c(long paramLong, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.welcome_id.has()) {
      paramLong = paramAuthReserve.welcome_id.get();
    }
    return paramLong;
  }
  
  private String c(String paramString, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.extend_json.has()) {
      paramString = new String(paramAuthReserve.extend_json.get().toByteArray());
    }
    return paramString;
  }
  
  private int d(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.game_mode.has()) {
      paramInt = paramAuthReserve.game_mode.get();
    }
    return paramInt;
  }
  
  private int e(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.action_type.has()) {
      paramInt = paramAuthReserve.action_type.get();
    }
    return paramInt;
  }
  
  private int f(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.sticker_height.has()) {
      paramInt = paramAuthReserve.sticker_height.get();
    }
    return paramInt;
  }
  
  private int g(int paramInt, ApolloMsgExtend.AuthReserve paramAuthReserve)
  {
    if (paramAuthReserve.sticker_width.has()) {
      paramInt = paramAuthReserve.sticker_width.get();
    }
    return paramInt;
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    a(paramList, paramMsg, paramList1, paramStringBuilder, paramBoolean2, paramMessageInfo);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.apollo_msg.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.message.ApolloElemDecoder
 * JD-Core Version:    0.7.0.1
 */