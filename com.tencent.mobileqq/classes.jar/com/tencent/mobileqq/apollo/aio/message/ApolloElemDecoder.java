package com.tencent.mobileqq.apollo.aio.message;

import com.tencent.imcore.message.ext.codec.decoder.pbelement.SimplePBElemDecoder;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.model.Apollo3DMessage;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.ThreeDBaseInfo;
import java.util.List;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
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
        paramApollo3DMessage.actionID3D = paramAuthReserve.uint32_action_id.get();
      }
      if (paramAuthReserve.action_type.has()) {
        paramApollo3DMessage.actionType3D = paramAuthReserve.action_type.get();
      }
      if (paramAuthReserve.bytes_action_name.has()) {
        paramApollo3DMessage.actionName3D = new String(paramAuthReserve.bytes_action_name.get().toByteArray());
      }
      if (paramAuthReserve.int32_sender_status.has()) {
        paramApollo3DMessage.senderStatus3D = paramAuthReserve.int32_sender_status.get();
      }
      if (paramAuthReserve.int32_peer_status.has()) {
        paramApollo3DMessage.peerStatus3D = paramAuthReserve.int32_peer_status.get();
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
    if (!paramMsg.msg_head.group_info.has()) {
      return;
    }
    if (paramApolloMessage.peerUin == paramQQAppInterface.getLongAccountUin())
    {
      long l = paramMsg.msg_head.msg_seq.get();
      paramMessageInfo.a.b(24, l);
    }
  }
  
  /* Error */
  private void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    // Byte code:
    //   0: invokestatic 206	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 210	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6: checkcast 178	com/tencent/mobileqq/app/QQAppInterface
    //   9: astore 30
    //   11: iconst_0
    //   12: istore 9
    //   14: iload 9
    //   16: aload_1
    //   17: invokeinterface 215 1 0
    //   22: if_icmpge +57 -> 79
    //   25: aload_1
    //   26: iload 9
    //   28: invokeinterface 218 2 0
    //   33: checkcast 220	tencent/im/msg/im_msg_body$Elem
    //   36: getfield 224	tencent/im/msg/im_msg_body$Elem:apollo_msg	Ltencent/im/msg/im_msg_body$ApolloActMsg;
    //   39: invokevirtual 227	tencent/im/msg/im_msg_body$ApolloActMsg:has	()Z
    //   42: ifeq +28 -> 70
    //   45: aload_1
    //   46: iload 9
    //   48: invokeinterface 218 2 0
    //   53: checkcast 220	tencent/im/msg/im_msg_body$Elem
    //   56: getfield 224	tencent/im/msg/im_msg_body$Elem:apollo_msg	Ltencent/im/msg/im_msg_body$ApolloActMsg;
    //   59: invokevirtual 228	tencent/im/msg/im_msg_body$ApolloActMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   62: checkcast 226	tencent/im/msg/im_msg_body$ApolloActMsg
    //   65: astore 27
    //   67: goto +15 -> 82
    //   70: iload 9
    //   72: iconst_1
    //   73: iadd
    //   74: istore 9
    //   76: goto -62 -> 14
    //   79: aconst_null
    //   80: astore 27
    //   82: aload 27
    //   84: ifnonnull +4 -> 88
    //   87: return
    //   88: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +11 -> 102
    //   94: aload 4
    //   96: ldc 235
    //   98: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: new 172	com/tencent/mobileqq/apollo/model/ApolloMessage
    //   105: dup
    //   106: invokespecial 242	com/tencent/mobileqq/apollo/model/ApolloMessage:<init>	()V
    //   109: astore 29
    //   111: aload 29
    //   113: aload 27
    //   115: getfield 243	tencent/im/msg/im_msg_body$ApolloActMsg:uint32_action_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   118: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   121: putfield 246	com/tencent/mobileqq/apollo/model/ApolloMessage:id	I
    //   124: aload 29
    //   126: aload 27
    //   128: getfield 247	tencent/im/msg/im_msg_body$ApolloActMsg:bytes_action_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   131: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   134: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   137: putfield 251	com/tencent/mobileqq/apollo/model/ApolloMessage:name	[B
    //   140: iload 5
    //   142: ifne +30 -> 172
    //   145: aload 27
    //   147: getfield 254	tencent/im/msg/im_msg_body$ApolloActMsg:bytes_action_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   150: invokevirtual 102	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   153: ifeq +19 -> 172
    //   156: aload 29
    //   158: aload 27
    //   160: getfield 254	tencent/im/msg/im_msg_body$ApolloActMsg:bytes_action_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   163: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   166: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   169: putfield 257	com/tencent/mobileqq/apollo/model/ApolloMessage:text	[B
    //   172: fconst_0
    //   173: fstore 7
    //   175: fconst_0
    //   176: fstore 8
    //   178: new 85	com/tencent/mobileqq/apollo/model/Apollo3DMessage
    //   181: dup
    //   182: invokespecial 258	com/tencent/mobileqq/apollo/model/Apollo3DMessage:<init>	()V
    //   185: astore 28
    //   187: new 13	com/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve
    //   190: dup
    //   191: invokespecial 259	com/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve:<init>	()V
    //   194: astore 31
    //   196: iconst_m1
    //   197: istore 10
    //   199: lconst_0
    //   200: lstore 20
    //   202: aload 31
    //   204: aload 27
    //   206: getfield 262	tencent/im/msg/im_msg_body$ApolloActMsg:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   209: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   212: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   215: invokevirtual 266	com/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   218: pop
    //   219: aload_0
    //   220: iconst_m1
    //   221: aload 31
    //   223: invokespecial 268	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   226: istore 9
    //   228: iload 10
    //   230: istore 12
    //   232: aload_0
    //   233: fconst_0
    //   234: aload 31
    //   236: invokespecial 270	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(FLcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)F
    //   239: fstore 7
    //   241: fload 7
    //   243: fstore 8
    //   245: iload 10
    //   247: istore 12
    //   249: aload_0
    //   250: iconst_m1
    //   251: aload 31
    //   253: invokespecial 272	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:b	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   256: istore 10
    //   258: fload 7
    //   260: fstore 8
    //   262: iload 10
    //   264: istore 12
    //   266: aload_0
    //   267: iconst_0
    //   268: aload 31
    //   270: invokespecial 275	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:c	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   273: istore 11
    //   275: aload_0
    //   276: lconst_0
    //   277: aload 31
    //   279: invokespecial 277	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(JLcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)J
    //   282: lstore 18
    //   284: aload_0
    //   285: aconst_null
    //   286: aload 31
    //   288: invokespecial 279	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(Ljava/lang/String;Lcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)Ljava/lang/String;
    //   291: astore_1
    //   292: aload_0
    //   293: aconst_null
    //   294: aload 31
    //   296: invokespecial 281	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:b	(Ljava/lang/String;Lcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)Ljava/lang/String;
    //   299: astore 4
    //   301: aload_0
    //   302: lconst_0
    //   303: aload 31
    //   305: invokespecial 283	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:b	(JLcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)J
    //   308: lstore 16
    //   310: aload_0
    //   311: lconst_0
    //   312: aload 31
    //   314: aload 30
    //   316: invokespecial 285	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(JLcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;Lcom/tencent/mobileqq/app/QQAppInterface;)J
    //   319: pop2
    //   320: aload_0
    //   321: iconst_0
    //   322: aload 31
    //   324: invokespecial 288	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:d	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   327: istore 12
    //   329: aload_0
    //   330: aconst_null
    //   331: aload 31
    //   333: invokespecial 290	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:c	(Ljava/lang/String;Lcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)Ljava/lang/String;
    //   336: astore 24
    //   338: aload_0
    //   339: iconst_0
    //   340: aload 31
    //   342: invokespecial 293	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:e	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   345: istore 13
    //   347: aload 28
    //   349: astore 26
    //   351: aload_0
    //   352: aload 28
    //   354: aload 31
    //   356: invokespecial 295	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(Lcom/tencent/mobileqq/apollo/model/Apollo3DMessage;Lcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)Lcom/tencent/mobileqq/apollo/model/Apollo3DMessage;
    //   359: astore 25
    //   361: aload 25
    //   363: astore 26
    //   365: aload_0
    //   366: iconst_0
    //   367: aload 31
    //   369: invokespecial 298	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:f	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   372: istore 14
    //   374: aload_0
    //   375: iconst_0
    //   376: aload 31
    //   378: invokespecial 301	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:g	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   381: istore 15
    //   383: aload_0
    //   384: lconst_0
    //   385: aload 31
    //   387: invokespecial 303	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:c	(JLcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)J
    //   390: lstore 22
    //   392: lload 22
    //   394: lstore 20
    //   396: aload_0
    //   397: aconst_null
    //   398: aload 31
    //   400: invokespecial 305	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(Ljava/util/List;Lcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)Ljava/util/List;
    //   403: astore 26
    //   405: lload 22
    //   407: lstore 20
    //   409: goto +184 -> 593
    //   412: astore 26
    //   414: goto +171 -> 585
    //   417: astore 26
    //   419: aload 25
    //   421: astore 28
    //   423: goto +155 -> 578
    //   426: astore 25
    //   428: goto +139 -> 567
    //   431: astore 25
    //   433: aload 24
    //   435: astore 26
    //   437: goto +119 -> 556
    //   440: astore 25
    //   442: aconst_null
    //   443: astore 26
    //   445: goto +111 -> 556
    //   448: astore 24
    //   450: aconst_null
    //   451: astore 25
    //   453: goto +92 -> 545
    //   456: astore 24
    //   458: aconst_null
    //   459: astore 25
    //   461: goto +18 -> 479
    //   464: astore 24
    //   466: goto +7 -> 473
    //   469: astore 24
    //   471: aconst_null
    //   472: astore_1
    //   473: aconst_null
    //   474: astore 4
    //   476: aconst_null
    //   477: astore 25
    //   479: lconst_0
    //   480: lstore 16
    //   482: goto +63 -> 545
    //   485: astore 24
    //   487: aconst_null
    //   488: astore_1
    //   489: aload_1
    //   490: astore 4
    //   492: aload 4
    //   494: astore 25
    //   496: lconst_0
    //   497: lstore 18
    //   499: lload 18
    //   501: lstore 16
    //   503: goto +42 -> 545
    //   506: astore 24
    //   508: iload 12
    //   510: istore 10
    //   512: goto +12 -> 524
    //   515: astore 24
    //   517: iconst_m1
    //   518: istore 9
    //   520: fload 7
    //   522: fstore 8
    //   524: aconst_null
    //   525: astore 25
    //   527: lconst_0
    //   528: lstore 16
    //   530: aconst_null
    //   531: astore 4
    //   533: aconst_null
    //   534: astore_1
    //   535: lconst_0
    //   536: lstore 18
    //   538: iconst_0
    //   539: istore 11
    //   541: fload 8
    //   543: fstore 7
    //   545: iconst_0
    //   546: istore 12
    //   548: aload 25
    //   550: astore 26
    //   552: aload 24
    //   554: astore 25
    //   556: iconst_0
    //   557: istore 13
    //   559: aload 26
    //   561: astore 24
    //   563: aload 28
    //   565: astore 26
    //   567: iconst_0
    //   568: istore 14
    //   570: aload 26
    //   572: astore 28
    //   574: aload 25
    //   576: astore 26
    //   578: iconst_0
    //   579: istore 15
    //   581: aload 28
    //   583: astore 25
    //   585: aload 26
    //   587: invokevirtual 308	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   590: aconst_null
    //   591: astore 26
    //   593: new 310	org/json/JSONObject
    //   596: dup
    //   597: invokespecial 311	org/json/JSONObject:<init>	()V
    //   600: astore 31
    //   602: aload 27
    //   604: getfield 314	tencent/im/msg/im_msg_body$ApolloActMsg:input_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   607: invokevirtual 102	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   610: ifeq +660 -> 1270
    //   613: new 104	java/lang/String
    //   616: dup
    //   617: aload 27
    //   619: getfield 314	tencent/im/msg/im_msg_body$ApolloActMsg:input_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   622: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   625: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   628: invokespecial 116	java/lang/String:<init>	([B)V
    //   631: astore 28
    //   633: aload 31
    //   635: ldc_w 316
    //   638: aload 28
    //   640: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   643: pop
    //   644: goto +3 -> 647
    //   647: iload 9
    //   649: ifle +627 -> 1276
    //   652: aload 31
    //   654: ldc_w 322
    //   657: iload 9
    //   659: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   662: pop
    //   663: aload 31
    //   665: ldc_w 327
    //   668: fload 7
    //   670: f2d
    //   671: invokevirtual 330	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   674: pop
    //   675: goto +3 -> 678
    //   678: iload 10
    //   680: invokestatic 335	com/tencent/mobileqq/apollo/game/utils/ApolloGameUtil:a	(I)Z
    //   683: istore 5
    //   685: iload 5
    //   687: ifeq +68 -> 755
    //   690: aload 31
    //   692: ldc_w 337
    //   695: iload 11
    //   697: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   700: pop
    //   701: aload 31
    //   703: ldc_w 339
    //   706: iload 12
    //   708: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   711: pop
    //   712: aload 31
    //   714: ldc_w 341
    //   717: lload 18
    //   719: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   722: pop
    //   723: aload 31
    //   725: ldc_w 346
    //   728: iload 10
    //   730: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   733: pop
    //   734: aload 31
    //   736: ldc_w 348
    //   739: aload_1
    //   740: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   743: pop
    //   744: aload 31
    //   746: ldc_w 350
    //   749: aload 4
    //   751: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   754: pop
    //   755: aload 24
    //   757: invokestatic 356	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   760: ifne +14 -> 774
    //   763: aload 31
    //   765: ldc_w 358
    //   768: aload 24
    //   770: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   773: pop
    //   774: aload 31
    //   776: ldc_w 346
    //   779: iload 10
    //   781: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   784: pop
    //   785: aload 31
    //   787: ldc_w 360
    //   790: iload 13
    //   792: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   795: pop
    //   796: aload 31
    //   798: ldc_w 362
    //   801: iload 14
    //   803: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   806: pop
    //   807: aload 31
    //   809: ldc_w 364
    //   812: iload 15
    //   814: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   817: pop
    //   818: aload 31
    //   820: ldc_w 366
    //   823: lload 20
    //   825: invokevirtual 344	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   828: pop
    //   829: aload 26
    //   831: ifnull +448 -> 1279
    //   834: aload 26
    //   836: invokeinterface 368 1 0
    //   841: ifne +438 -> 1279
    //   844: new 370	org/json/JSONArray
    //   847: dup
    //   848: invokespecial 371	org/json/JSONArray:<init>	()V
    //   851: astore 32
    //   853: aload 26
    //   855: invokeinterface 375 1 0
    //   860: astore 33
    //   862: aload 33
    //   864: invokeinterface 380 1 0
    //   869: ifeq +22 -> 891
    //   872: aload 32
    //   874: aload 33
    //   876: invokeinterface 384 1 0
    //   881: checkcast 386	java/lang/Long
    //   884: invokevirtual 389	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   887: pop
    //   888: goto -26 -> 862
    //   891: aload 31
    //   893: ldc_w 391
    //   896: aload 32
    //   898: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   901: pop
    //   902: goto +3 -> 905
    //   905: aload 25
    //   907: invokevirtual 395	com/tencent/mobileqq/apollo/model/Apollo3DMessage:getMessageJSONObject	()Lorg/json/JSONObject;
    //   910: astore 32
    //   912: aload 32
    //   914: ifnull +14 -> 928
    //   917: aload 31
    //   919: ldc_w 397
    //   922: aload 32
    //   924: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   927: pop
    //   928: aload 29
    //   930: aload 31
    //   932: invokevirtual 401	org/json/JSONObject:toString	()Ljava/lang/String;
    //   935: putfield 404	com/tencent/mobileqq/apollo/model/ApolloMessage:extStr	Ljava/lang/String;
    //   938: aload 29
    //   940: aload 27
    //   942: getfield 407	tencent/im/msg/im_msg_body$ApolloActMsg:uint32_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   945: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   948: putfield 410	com/tencent/mobileqq/apollo/model/ApolloMessage:flag	I
    //   951: aload 29
    //   953: aload 27
    //   955: getfield 413	tencent/im/msg/im_msg_body$ApolloActMsg:uint32_peer_uin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   958: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   961: invokestatic 418	com/tencent/mobileqq/util/Utils:a	(I)J
    //   964: putfield 176	com/tencent/mobileqq/apollo/model/ApolloMessage:peerUin	J
    //   967: aload 29
    //   969: aload 27
    //   971: getfield 421	tencent/im/msg/im_msg_body$ApolloActMsg:uint32_sender_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   974: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   977: invokestatic 418	com/tencent/mobileqq/util/Utils:a	(I)J
    //   980: putfield 424	com/tencent/mobileqq/apollo/model/ApolloMessage:senderTs	J
    //   983: aload 29
    //   985: aload 27
    //   987: getfield 427	tencent/im/msg/im_msg_body$ApolloActMsg:uint32_peer_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   990: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   993: invokestatic 418	com/tencent/mobileqq/util/Utils:a	(I)J
    //   996: putfield 430	com/tencent/mobileqq/apollo/model/ApolloMessage:peerTs	J
    //   999: aload 29
    //   1001: aload 27
    //   1003: getfield 431	tencent/im/msg/im_msg_body$ApolloActMsg:int32_sender_status	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1006: invokevirtual 128	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1009: putfield 434	com/tencent/mobileqq/apollo/model/ApolloMessage:senderStatus	I
    //   1012: aload 29
    //   1014: aload 27
    //   1016: getfield 435	tencent/im/msg/im_msg_body$ApolloActMsg:int32_peer_status	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1019: invokevirtual 128	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1022: putfield 438	com/tencent/mobileqq/apollo/model/ApolloMessage:peerStatus	I
    //   1025: sipush -2039
    //   1028: invokestatic 443	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1031: checkcast 445	com/tencent/mobileqq/apollo/model/MessageForApollo
    //   1034: astore 27
    //   1036: aload 27
    //   1038: sipush -2039
    //   1041: putfield 448	com/tencent/mobileqq/apollo/model/MessageForApollo:msgtype	I
    //   1044: aload 27
    //   1046: aload 29
    //   1048: putfield 452	com/tencent/mobileqq/apollo/model/MessageForApollo:mApolloMessage	Lcom/tencent/mobileqq/apollo/model/ApolloMessage;
    //   1051: aload 27
    //   1053: aload 29
    //   1055: invokestatic 457	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   1058: putfield 460	com/tencent/mobileqq/apollo/model/MessageForApollo:msgData	[B
    //   1061: aload 27
    //   1063: aload 28
    //   1065: putfield 462	com/tencent/mobileqq/apollo/model/MessageForApollo:inputText	Ljava/lang/String;
    //   1068: aload 27
    //   1070: iload 9
    //   1072: putfield 465	com/tencent/mobileqq/apollo/model/MessageForApollo:audioId	I
    //   1075: aload 27
    //   1077: fload 7
    //   1079: putfield 468	com/tencent/mobileqq/apollo/model/MessageForApollo:audioStartTime	F
    //   1082: aload 27
    //   1084: iload 10
    //   1086: putfield 471	com/tencent/mobileqq/apollo/model/MessageForApollo:msgType	I
    //   1089: aload 27
    //   1091: iload 11
    //   1093: putfield 473	com/tencent/mobileqq/apollo/model/MessageForApollo:gameId	I
    //   1096: aload 27
    //   1098: iload 12
    //   1100: putfield 476	com/tencent/mobileqq/apollo/model/MessageForApollo:mGameMode	I
    //   1103: aload 27
    //   1105: lload 18
    //   1107: putfield 479	com/tencent/mobileqq/apollo/model/MessageForApollo:roomId	J
    //   1110: aload 27
    //   1112: lload 16
    //   1114: putfield 482	com/tencent/mobileqq/apollo/model/MessageForApollo:signTs	J
    //   1117: aload 27
    //   1119: aload_1
    //   1120: putfield 484	com/tencent/mobileqq/apollo/model/MessageForApollo:gameName	Ljava/lang/String;
    //   1123: aload 27
    //   1125: iload 13
    //   1127: putfield 486	com/tencent/mobileqq/apollo/model/MessageForApollo:actionType	I
    //   1130: aload 27
    //   1132: aload 24
    //   1134: putfield 488	com/tencent/mobileqq/apollo/model/MessageForApollo:extendJson	Ljava/lang/String;
    //   1137: aload 27
    //   1139: aload 4
    //   1141: putfield 490	com/tencent/mobileqq/apollo/model/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   1144: aload 27
    //   1146: ldc 54
    //   1148: invokestatic 60	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1151: checkcast 54	com/tencent/mobileqq/apollo/utils/api/IApolloUtil
    //   1154: aload 27
    //   1156: getfield 488	com/tencent/mobileqq/apollo/model/MessageForApollo:extendJson	Ljava/lang/String;
    //   1159: ldc_w 492
    //   1162: invokeinterface 496 3 0
    //   1167: putfield 498	com/tencent/mobileqq/apollo/model/MessageForApollo:gameStatus	I
    //   1170: aload 27
    //   1172: aload 25
    //   1174: putfield 501	com/tencent/mobileqq/apollo/model/MessageForApollo:mApollo3DMessage	Lcom/tencent/mobileqq/apollo/model/Apollo3DMessage;
    //   1177: aload 27
    //   1179: iload 14
    //   1181: putfield 503	com/tencent/mobileqq/apollo/model/MessageForApollo:stickerHeight	I
    //   1184: aload 27
    //   1186: iload 15
    //   1188: putfield 505	com/tencent/mobileqq/apollo/model/MessageForApollo:stickerWidth	I
    //   1191: aload 27
    //   1193: lload 20
    //   1195: putfield 507	com/tencent/mobileqq/apollo/model/MessageForApollo:welcomeId	J
    //   1198: aload 27
    //   1200: aload 26
    //   1202: putfield 510	com/tencent/mobileqq/apollo/model/MessageForApollo:welcomeUinList	Ljava/util/List;
    //   1205: aload_3
    //   1206: aload 27
    //   1208: invokeinterface 514 2 0
    //   1213: pop
    //   1214: invokestatic 520	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   1217: ldc_w 522
    //   1220: ldc_w 524
    //   1223: iconst_0
    //   1224: invokevirtual 528	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   1227: istore 9
    //   1229: iload 9
    //   1231: ifeq +15 -> 1246
    //   1234: aload_0
    //   1235: aload 29
    //   1237: aload_2
    //   1238: aload 6
    //   1240: aload 30
    //   1242: invokespecial 530	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(Lcom/tencent/mobileqq/apollo/model/ApolloMessage;Lmsf/msgcomm/msg_comm$Msg;Lcom/tencent/mobileqq/troop/data/MessageInfo;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   1245: return
    //   1246: return
    //   1247: astore_1
    //   1248: goto +4 -> 1252
    //   1251: astore_1
    //   1252: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1255: ifeq +14 -> 1269
    //   1258: ldc_w 532
    //   1261: iconst_2
    //   1262: ldc_w 534
    //   1265: aload_1
    //   1266: invokestatic 537	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1269: return
    //   1270: aconst_null
    //   1271: astore 28
    //   1273: goto -626 -> 647
    //   1276: goto -598 -> 678
    //   1279: goto -374 -> 905
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1282	0	this	ApolloElemDecoder
    //   0	1282	1	paramList	List<im_msg_body.Elem>
    //   0	1282	2	paramMsg	msg_comm.Msg
    //   0	1282	3	paramList1	List<MessageRecord>
    //   0	1282	4	paramStringBuilder	StringBuilder
    //   0	1282	5	paramBoolean	boolean
    //   0	1282	6	paramMessageInfo	MessageInfo
    //   173	905	7	f1	float
    //   176	366	8	f2	float
    //   12	1218	9	i	int
    //   197	888	10	j	int
    //   273	819	11	k	int
    //   230	869	12	m	int
    //   345	781	13	n	int
    //   372	808	14	i1	int
    //   381	806	15	i2	int
    //   308	805	16	l1	long
    //   282	824	18	l2	long
    //   200	994	20	l3	long
    //   390	16	22	l4	long
    //   336	98	24	str	String
    //   448	1	24	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   456	1	24	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   464	1	24	localInvalidProtocolBufferMicroException3	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   469	1	24	localInvalidProtocolBufferMicroException4	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   485	1	24	localInvalidProtocolBufferMicroException5	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   506	1	24	localInvalidProtocolBufferMicroException6	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   515	38	24	localInvalidProtocolBufferMicroException7	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   561	572	24	localObject1	java.lang.Object
    //   359	61	25	localApollo3DMessage	Apollo3DMessage
    //   426	1	25	localInvalidProtocolBufferMicroException8	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   431	1	25	localInvalidProtocolBufferMicroException9	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   440	1	25	localInvalidProtocolBufferMicroException10	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   451	722	25	localObject2	java.lang.Object
    //   349	55	26	localObject3	java.lang.Object
    //   412	1	26	localInvalidProtocolBufferMicroException11	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   417	1	26	localInvalidProtocolBufferMicroException12	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   435	766	26	localObject4	java.lang.Object
    //   65	1142	27	localObject5	java.lang.Object
    //   185	1087	28	localObject6	java.lang.Object
    //   109	1127	29	localApolloMessage	ApolloMessage
    //   9	1232	30	localQQAppInterface	QQAppInterface
    //   194	737	31	localObject7	java.lang.Object
    //   851	72	32	localObject8	java.lang.Object
    //   860	15	33	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   383	392	412	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   396	405	412	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   374	383	417	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   351	361	426	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   365	374	426	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   338	347	431	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   329	338	440	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   310	329	448	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   301	310	456	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   292	301	464	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   284	292	469	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   275	284	485	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   232	241	506	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   249	258	506	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   266	275	506	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   202	228	515	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   593	644	1247	java/lang/Throwable
    //   652	675	1247	java/lang/Throwable
    //   678	685	1247	java/lang/Throwable
    //   690	755	1247	java/lang/Throwable
    //   755	774	1247	java/lang/Throwable
    //   774	818	1247	java/lang/Throwable
    //   818	829	1247	java/lang/Throwable
    //   834	862	1247	java/lang/Throwable
    //   862	888	1247	java/lang/Throwable
    //   891	902	1247	java/lang/Throwable
    //   905	912	1247	java/lang/Throwable
    //   917	928	1247	java/lang/Throwable
    //   928	1229	1247	java/lang/Throwable
    //   102	140	1251	java/lang/Throwable
    //   145	172	1251	java/lang/Throwable
    //   178	196	1251	java/lang/Throwable
    //   202	228	1251	java/lang/Throwable
    //   232	241	1251	java/lang/Throwable
    //   249	258	1251	java/lang/Throwable
    //   266	275	1251	java/lang/Throwable
    //   275	284	1251	java/lang/Throwable
    //   284	292	1251	java/lang/Throwable
    //   292	301	1251	java/lang/Throwable
    //   301	310	1251	java/lang/Throwable
    //   310	329	1251	java/lang/Throwable
    //   329	338	1251	java/lang/Throwable
    //   338	347	1251	java/lang/Throwable
    //   351	361	1251	java/lang/Throwable
    //   365	374	1251	java/lang/Throwable
    //   374	383	1251	java/lang/Throwable
    //   383	392	1251	java/lang/Throwable
    //   396	405	1251	java/lang/Throwable
    //   585	590	1251	java/lang/Throwable
    //   1234	1245	1251	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.message.ApolloElemDecoder
 * JD-Core Version:    0.7.0.1
 */