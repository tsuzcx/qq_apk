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
      paramMessageInfo.c.c(24, l);
    }
  }
  
  /* Error */
  private void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    // Byte code:
    //   0: invokestatic 206	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 210	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   6: checkcast 178	com/tencent/mobileqq/app/QQAppInterface
    //   9: astore 33
    //   11: iconst_0
    //   12: istore 17
    //   14: iconst_0
    //   15: istore 14
    //   17: iconst_0
    //   18: istore 9
    //   20: iload 9
    //   22: aload_1
    //   23: invokeinterface 215 1 0
    //   28: if_icmpge +57 -> 85
    //   31: aload_1
    //   32: iload 9
    //   34: invokeinterface 218 2 0
    //   39: checkcast 220	tencent/im/msg/im_msg_body$Elem
    //   42: getfield 224	tencent/im/msg/im_msg_body$Elem:apollo_msg	Ltencent/im/msg/im_msg_body$ApolloActMsg;
    //   45: invokevirtual 227	tencent/im/msg/im_msg_body$ApolloActMsg:has	()Z
    //   48: ifeq +28 -> 76
    //   51: aload_1
    //   52: iload 9
    //   54: invokeinterface 218 2 0
    //   59: checkcast 220	tencent/im/msg/im_msg_body$Elem
    //   62: getfield 224	tencent/im/msg/im_msg_body$Elem:apollo_msg	Ltencent/im/msg/im_msg_body$ApolloActMsg;
    //   65: invokevirtual 228	tencent/im/msg/im_msg_body$ApolloActMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: checkcast 226	tencent/im/msg/im_msg_body$ApolloActMsg
    //   71: astore 29
    //   73: goto +15 -> 88
    //   76: iload 9
    //   78: iconst_1
    //   79: iadd
    //   80: istore 9
    //   82: goto -62 -> 20
    //   85: aconst_null
    //   86: astore 29
    //   88: aload 29
    //   90: ifnonnull +4 -> 94
    //   93: return
    //   94: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +11 -> 108
    //   100: aload 4
    //   102: ldc 235
    //   104: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: new 172	com/tencent/mobileqq/apollo/model/ApolloMessage
    //   111: dup
    //   112: invokespecial 242	com/tencent/mobileqq/apollo/model/ApolloMessage:<init>	()V
    //   115: astore 32
    //   117: aload 32
    //   119: aload 29
    //   121: getfield 243	tencent/im/msg/im_msg_body$ApolloActMsg:uint32_action_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   124: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   127: putfield 246	com/tencent/mobileqq/apollo/model/ApolloMessage:id	I
    //   130: aload 32
    //   132: aload 29
    //   134: getfield 247	tencent/im/msg/im_msg_body$ApolloActMsg:bytes_action_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   137: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   140: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   143: putfield 251	com/tencent/mobileqq/apollo/model/ApolloMessage:name	[B
    //   146: iload 5
    //   148: ifne +30 -> 178
    //   151: aload 29
    //   153: getfield 254	tencent/im/msg/im_msg_body$ApolloActMsg:bytes_action_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   156: invokevirtual 102	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   159: ifeq +19 -> 178
    //   162: aload 32
    //   164: aload 29
    //   166: getfield 254	tencent/im/msg/im_msg_body$ApolloActMsg:bytes_action_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   169: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   172: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   175: putfield 257	com/tencent/mobileqq/apollo/model/ApolloMessage:text	[B
    //   178: fconst_0
    //   179: fstore 7
    //   181: fconst_0
    //   182: fstore 8
    //   184: new 85	com/tencent/mobileqq/apollo/model/Apollo3DMessage
    //   187: dup
    //   188: invokespecial 258	com/tencent/mobileqq/apollo/model/Apollo3DMessage:<init>	()V
    //   191: astore 31
    //   193: new 13	com/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve
    //   196: dup
    //   197: invokespecial 259	com/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve:<init>	()V
    //   200: astore 27
    //   202: iconst_m1
    //   203: istore 10
    //   205: lconst_0
    //   206: lstore 24
    //   208: aload 27
    //   210: aload 29
    //   212: getfield 262	tencent/im/msg/im_msg_body$ApolloActMsg:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   218: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   221: invokevirtual 266	com/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   224: pop
    //   225: aload_0
    //   226: iconst_m1
    //   227: aload 27
    //   229: invokespecial 268	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   232: istore 9
    //   234: iload 10
    //   236: istore 12
    //   238: aload_0
    //   239: fconst_0
    //   240: aload 27
    //   242: invokespecial 270	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(FLcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)F
    //   245: fstore 7
    //   247: fload 7
    //   249: fstore 8
    //   251: iload 10
    //   253: istore 12
    //   255: aload_0
    //   256: iconst_m1
    //   257: aload 27
    //   259: invokespecial 273	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:b	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   262: istore 10
    //   264: fload 7
    //   266: fstore 8
    //   268: iload 10
    //   270: istore 12
    //   272: aload_0
    //   273: iconst_0
    //   274: aload 27
    //   276: invokespecial 275	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:c	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   279: istore 11
    //   281: aload_0
    //   282: lconst_0
    //   283: aload 27
    //   285: invokespecial 277	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(JLcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)J
    //   288: lstore 20
    //   290: aload_0
    //   291: aconst_null
    //   292: aload 27
    //   294: invokespecial 279	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(Ljava/lang/String;Lcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)Ljava/lang/String;
    //   297: astore_1
    //   298: aload_0
    //   299: aconst_null
    //   300: aload 27
    //   302: invokespecial 281	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:b	(Ljava/lang/String;Lcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)Ljava/lang/String;
    //   305: astore 4
    //   307: aload_0
    //   308: lconst_0
    //   309: aload 27
    //   311: invokespecial 283	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:b	(JLcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)J
    //   314: lstore 18
    //   316: aload_0
    //   317: lconst_0
    //   318: aload 27
    //   320: aload 33
    //   322: invokespecial 285	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(JLcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;Lcom/tencent/mobileqq/app/QQAppInterface;)J
    //   325: pop2
    //   326: aload_0
    //   327: iconst_0
    //   328: aload 27
    //   330: invokespecial 288	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:d	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   333: istore 12
    //   335: aload_0
    //   336: aconst_null
    //   337: aload 27
    //   339: invokespecial 290	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:c	(Ljava/lang/String;Lcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)Ljava/lang/String;
    //   342: astore 26
    //   344: aload_0
    //   345: iconst_0
    //   346: aload 27
    //   348: invokespecial 293	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:e	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   351: istore 13
    //   353: aload 31
    //   355: astore 30
    //   357: aload_0
    //   358: aload 31
    //   360: aload 27
    //   362: invokespecial 295	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(Lcom/tencent/mobileqq/apollo/model/Apollo3DMessage;Lcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)Lcom/tencent/mobileqq/apollo/model/Apollo3DMessage;
    //   365: astore 28
    //   367: aload 28
    //   369: astore 30
    //   371: aload_0
    //   372: iconst_0
    //   373: aload 27
    //   375: invokespecial 298	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:f	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   378: istore 16
    //   380: lload 24
    //   382: lstore 22
    //   384: aload_0
    //   385: iconst_0
    //   386: aload 27
    //   388: invokespecial 301	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:g	(ILcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)I
    //   391: istore 15
    //   393: iload 15
    //   395: istore 14
    //   397: lload 24
    //   399: lstore 22
    //   401: aload_0
    //   402: lconst_0
    //   403: aload 27
    //   405: invokespecial 303	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:c	(JLcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)J
    //   408: lstore 24
    //   410: iload 15
    //   412: istore 14
    //   414: lload 24
    //   416: lstore 22
    //   418: aload_0
    //   419: aconst_null
    //   420: aload 27
    //   422: invokespecial 305	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(Ljava/util/List;Lcom/tencent/pb/apollomsgextend/ApolloMsgExtend$AuthReserve;)Ljava/util/List;
    //   425: astore 31
    //   427: aload 4
    //   429: astore 30
    //   431: iload 12
    //   433: istore 17
    //   435: lload 24
    //   437: lstore 22
    //   439: aload_1
    //   440: astore 27
    //   442: iload 16
    //   444: istore 14
    //   446: aload 31
    //   448: astore 4
    //   450: iload 15
    //   452: istore 12
    //   454: aload 26
    //   456: astore_1
    //   457: iload 17
    //   459: istore 15
    //   461: iload 12
    //   463: istore 16
    //   465: aload 28
    //   467: astore 26
    //   469: aload 30
    //   471: astore 28
    //   473: goto +222 -> 695
    //   476: astore 27
    //   478: iload 12
    //   480: istore 15
    //   482: iload 16
    //   484: istore 12
    //   486: goto +171 -> 657
    //   489: astore 27
    //   491: aload 30
    //   493: astore 28
    //   495: iload 12
    //   497: istore 14
    //   499: goto +143 -> 642
    //   502: astore 27
    //   504: aload 26
    //   506: astore 28
    //   508: goto +119 -> 627
    //   511: astore 27
    //   513: aconst_null
    //   514: astore 28
    //   516: goto +111 -> 627
    //   519: astore 26
    //   521: aconst_null
    //   522: astore 27
    //   524: goto +92 -> 616
    //   527: astore 26
    //   529: aconst_null
    //   530: astore 27
    //   532: goto +18 -> 550
    //   535: astore 26
    //   537: goto +7 -> 544
    //   540: astore 26
    //   542: aconst_null
    //   543: astore_1
    //   544: aconst_null
    //   545: astore 4
    //   547: aconst_null
    //   548: astore 27
    //   550: lconst_0
    //   551: lstore 18
    //   553: goto +63 -> 616
    //   556: astore 26
    //   558: aconst_null
    //   559: astore_1
    //   560: aload_1
    //   561: astore 4
    //   563: aload 4
    //   565: astore 27
    //   567: lconst_0
    //   568: lstore 20
    //   570: lload 20
    //   572: lstore 18
    //   574: goto +42 -> 616
    //   577: astore 26
    //   579: iload 12
    //   581: istore 10
    //   583: goto +12 -> 595
    //   586: astore 26
    //   588: iconst_m1
    //   589: istore 9
    //   591: fload 7
    //   593: fstore 8
    //   595: aconst_null
    //   596: astore 27
    //   598: lconst_0
    //   599: lstore 18
    //   601: aconst_null
    //   602: astore 4
    //   604: aconst_null
    //   605: astore_1
    //   606: lconst_0
    //   607: lstore 20
    //   609: iconst_0
    //   610: istore 11
    //   612: fload 8
    //   614: fstore 7
    //   616: iconst_0
    //   617: istore 12
    //   619: aload 27
    //   621: astore 28
    //   623: aload 26
    //   625: astore 27
    //   627: iconst_0
    //   628: istore 13
    //   630: aload 28
    //   632: astore 26
    //   634: iload 12
    //   636: istore 14
    //   638: aload 31
    //   640: astore 28
    //   642: iconst_0
    //   643: istore 12
    //   645: iload 14
    //   647: istore 15
    //   649: lload 24
    //   651: lstore 22
    //   653: iload 17
    //   655: istore 14
    //   657: aload 27
    //   659: invokevirtual 308	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   662: aload 26
    //   664: astore 30
    //   666: aload 28
    //   668: astore 26
    //   670: aconst_null
    //   671: astore 31
    //   673: aload 4
    //   675: astore 28
    //   677: aload_1
    //   678: astore 27
    //   680: aload 31
    //   682: astore 4
    //   684: iload 14
    //   686: istore 16
    //   688: iload 12
    //   690: istore 14
    //   692: aload 30
    //   694: astore_1
    //   695: new 310	org/json/JSONObject
    //   698: dup
    //   699: invokespecial 311	org/json/JSONObject:<init>	()V
    //   702: astore 31
    //   704: aload 29
    //   706: getfield 314	tencent/im/msg/im_msg_body$ApolloActMsg:input_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   709: invokevirtual 102	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   712: ifeq +568 -> 1280
    //   715: new 104	java/lang/String
    //   718: dup
    //   719: aload 29
    //   721: getfield 314	tencent/im/msg/im_msg_body$ApolloActMsg:input_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   724: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   727: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   730: invokespecial 116	java/lang/String:<init>	([B)V
    //   733: astore 30
    //   735: aload 31
    //   737: ldc_w 316
    //   740: aload 30
    //   742: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   745: pop
    //   746: goto +3 -> 749
    //   749: iload 9
    //   751: ifle +535 -> 1286
    //   754: aload 31
    //   756: ldc_w 322
    //   759: iload 9
    //   761: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   764: pop
    //   765: aload 31
    //   767: ldc_w 327
    //   770: fload 7
    //   772: f2d
    //   773: invokevirtual 330	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   776: pop
    //   777: goto +3 -> 780
    //   780: aload_1
    //   781: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   784: ifne +13 -> 797
    //   787: aload 31
    //   789: ldc_w 338
    //   792: aload_1
    //   793: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   796: pop
    //   797: aload 31
    //   799: ldc_w 340
    //   802: iload 10
    //   804: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   807: pop
    //   808: aload 31
    //   810: ldc_w 342
    //   813: iload 13
    //   815: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   818: pop
    //   819: aload 31
    //   821: ldc_w 344
    //   824: iload 14
    //   826: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   829: pop
    //   830: aload 31
    //   832: ldc_w 346
    //   835: iload 16
    //   837: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   840: pop
    //   841: aload 31
    //   843: ldc_w 348
    //   846: lload 22
    //   848: invokevirtual 351	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   851: pop
    //   852: aload 4
    //   854: ifnull +71 -> 925
    //   857: aload 4
    //   859: invokeinterface 353 1 0
    //   864: ifne +61 -> 925
    //   867: new 355	org/json/JSONArray
    //   870: dup
    //   871: invokespecial 356	org/json/JSONArray:<init>	()V
    //   874: astore 34
    //   876: aload 4
    //   878: invokeinterface 360 1 0
    //   883: astore 35
    //   885: aload 35
    //   887: invokeinterface 365 1 0
    //   892: ifeq +22 -> 914
    //   895: aload 34
    //   897: aload 35
    //   899: invokeinterface 369 1 0
    //   904: checkcast 371	java/lang/Long
    //   907: invokevirtual 374	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   910: pop
    //   911: goto -26 -> 885
    //   914: aload 31
    //   916: ldc_w 376
    //   919: aload 34
    //   921: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   924: pop
    //   925: aload 26
    //   927: invokevirtual 380	com/tencent/mobileqq/apollo/model/Apollo3DMessage:getMessageJSONObject	()Lorg/json/JSONObject;
    //   930: astore 34
    //   932: aload 34
    //   934: ifnull +14 -> 948
    //   937: aload 31
    //   939: ldc_w 382
    //   942: aload 34
    //   944: invokevirtual 320	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   947: pop
    //   948: aload 32
    //   950: aload 31
    //   952: invokevirtual 386	org/json/JSONObject:toString	()Ljava/lang/String;
    //   955: putfield 389	com/tencent/mobileqq/apollo/model/ApolloMessage:extStr	Ljava/lang/String;
    //   958: aload 32
    //   960: aload 29
    //   962: getfield 392	tencent/im/msg/im_msg_body$ApolloActMsg:uint32_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   965: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   968: putfield 395	com/tencent/mobileqq/apollo/model/ApolloMessage:flag	I
    //   971: aload 32
    //   973: aload 29
    //   975: getfield 398	tencent/im/msg/im_msg_body$ApolloActMsg:uint32_peer_uin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   978: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   981: invokestatic 403	com/tencent/mobileqq/util/Utils:a	(I)J
    //   984: putfield 176	com/tencent/mobileqq/apollo/model/ApolloMessage:peerUin	J
    //   987: aload 32
    //   989: aload 29
    //   991: getfield 406	tencent/im/msg/im_msg_body$ApolloActMsg:uint32_sender_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   994: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   997: invokestatic 403	com/tencent/mobileqq/util/Utils:a	(I)J
    //   1000: putfield 409	com/tencent/mobileqq/apollo/model/ApolloMessage:senderTs	J
    //   1003: aload 32
    //   1005: aload 29
    //   1007: getfield 412	tencent/im/msg/im_msg_body$ApolloActMsg:uint32_peer_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1010: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1013: invokestatic 403	com/tencent/mobileqq/util/Utils:a	(I)J
    //   1016: putfield 415	com/tencent/mobileqq/apollo/model/ApolloMessage:peerTs	J
    //   1019: aload 32
    //   1021: aload 29
    //   1023: getfield 416	tencent/im/msg/im_msg_body$ApolloActMsg:int32_sender_status	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1026: invokevirtual 128	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1029: putfield 419	com/tencent/mobileqq/apollo/model/ApolloMessage:senderStatus	I
    //   1032: aload 32
    //   1034: aload 29
    //   1036: getfield 420	tencent/im/msg/im_msg_body$ApolloActMsg:int32_peer_status	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1039: invokevirtual 128	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1042: putfield 423	com/tencent/mobileqq/apollo/model/ApolloMessage:peerStatus	I
    //   1045: sipush -2039
    //   1048: invokestatic 428	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1051: checkcast 430	com/tencent/mobileqq/apollo/model/MessageForApollo
    //   1054: astore 29
    //   1056: aload 29
    //   1058: sipush -2039
    //   1061: putfield 433	com/tencent/mobileqq/apollo/model/MessageForApollo:msgtype	I
    //   1064: aload 29
    //   1066: aload 32
    //   1068: putfield 437	com/tencent/mobileqq/apollo/model/MessageForApollo:mApolloMessage	Lcom/tencent/mobileqq/apollo/model/ApolloMessage;
    //   1071: aload 29
    //   1073: aload 32
    //   1075: invokestatic 442	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   1078: putfield 445	com/tencent/mobileqq/apollo/model/MessageForApollo:msgData	[B
    //   1081: aload 29
    //   1083: aload 30
    //   1085: putfield 447	com/tencent/mobileqq/apollo/model/MessageForApollo:inputText	Ljava/lang/String;
    //   1088: aload 29
    //   1090: iload 9
    //   1092: putfield 450	com/tencent/mobileqq/apollo/model/MessageForApollo:audioId	I
    //   1095: aload 29
    //   1097: fload 7
    //   1099: putfield 453	com/tencent/mobileqq/apollo/model/MessageForApollo:audioStartTime	F
    //   1102: aload 29
    //   1104: iload 10
    //   1106: putfield 456	com/tencent/mobileqq/apollo/model/MessageForApollo:msgType	I
    //   1109: aload 29
    //   1111: iload 11
    //   1113: putfield 459	com/tencent/mobileqq/apollo/model/MessageForApollo:gameId	I
    //   1116: aload 29
    //   1118: iload 15
    //   1120: putfield 462	com/tencent/mobileqq/apollo/model/MessageForApollo:mGameMode	I
    //   1123: aload 29
    //   1125: lload 20
    //   1127: putfield 465	com/tencent/mobileqq/apollo/model/MessageForApollo:roomId	J
    //   1130: aload 29
    //   1132: lload 18
    //   1134: putfield 468	com/tencent/mobileqq/apollo/model/MessageForApollo:signTs	J
    //   1137: aload 29
    //   1139: aload 27
    //   1141: putfield 471	com/tencent/mobileqq/apollo/model/MessageForApollo:gameName	Ljava/lang/String;
    //   1144: aload 29
    //   1146: iload 13
    //   1148: putfield 473	com/tencent/mobileqq/apollo/model/MessageForApollo:actionType	I
    //   1151: aload 29
    //   1153: aload_1
    //   1154: putfield 475	com/tencent/mobileqq/apollo/model/MessageForApollo:extendJson	Ljava/lang/String;
    //   1157: aload 29
    //   1159: aload 28
    //   1161: putfield 478	com/tencent/mobileqq/apollo/model/MessageForApollo:gameExtendJson	Ljava/lang/String;
    //   1164: aload 29
    //   1166: ldc 54
    //   1168: invokestatic 60	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1171: checkcast 54	com/tencent/mobileqq/apollo/utils/api/IApolloUtil
    //   1174: aload 29
    //   1176: getfield 475	com/tencent/mobileqq/apollo/model/MessageForApollo:extendJson	Ljava/lang/String;
    //   1179: ldc_w 480
    //   1182: invokeinterface 484 3 0
    //   1187: putfield 486	com/tencent/mobileqq/apollo/model/MessageForApollo:gameStatus	I
    //   1190: aload 29
    //   1192: aload 26
    //   1194: putfield 489	com/tencent/mobileqq/apollo/model/MessageForApollo:mApollo3DMessage	Lcom/tencent/mobileqq/apollo/model/Apollo3DMessage;
    //   1197: aload 29
    //   1199: iload 14
    //   1201: putfield 491	com/tencent/mobileqq/apollo/model/MessageForApollo:stickerHeight	I
    //   1204: aload 29
    //   1206: iload 16
    //   1208: putfield 493	com/tencent/mobileqq/apollo/model/MessageForApollo:stickerWidth	I
    //   1211: aload 29
    //   1213: lload 22
    //   1215: putfield 495	com/tencent/mobileqq/apollo/model/MessageForApollo:welcomeId	J
    //   1218: aload 29
    //   1220: aload 4
    //   1222: putfield 498	com/tencent/mobileqq/apollo/model/MessageForApollo:welcomeUinList	Ljava/util/List;
    //   1225: aload_3
    //   1226: aload 29
    //   1228: invokeinterface 502 2 0
    //   1233: pop
    //   1234: invokestatic 507	com/tencent/mobileqq/apollo/config/CmShowWnsUtils:ac	()Z
    //   1237: istore 5
    //   1239: iload 5
    //   1241: ifeq +15 -> 1256
    //   1244: aload_0
    //   1245: aload 32
    //   1247: aload_2
    //   1248: aload 6
    //   1250: aload 33
    //   1252: invokespecial 509	com/tencent/mobileqq/apollo/aio/message/ApolloElemDecoder:a	(Lcom/tencent/mobileqq/apollo/model/ApolloMessage;Lmsf/msgcomm/msg_comm$Msg;Lcom/tencent/mobileqq/troop/data/MessageInfo;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   1255: return
    //   1256: return
    //   1257: astore_1
    //   1258: goto +4 -> 1262
    //   1261: astore_1
    //   1262: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1265: ifeq +14 -> 1279
    //   1268: ldc_w 511
    //   1271: iconst_2
    //   1272: ldc_w 513
    //   1275: aload_1
    //   1276: invokestatic 516	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1279: return
    //   1280: aconst_null
    //   1281: astore 30
    //   1283: goto -534 -> 749
    //   1286: goto -506 -> 780
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1289	0	this	ApolloElemDecoder
    //   0	1289	1	paramList	List<im_msg_body.Elem>
    //   0	1289	2	paramMsg	msg_comm.Msg
    //   0	1289	3	paramList1	List<MessageRecord>
    //   0	1289	4	paramStringBuilder	StringBuilder
    //   0	1289	5	paramBoolean	boolean
    //   0	1289	6	paramMessageInfo	MessageInfo
    //   179	919	7	f1	float
    //   182	431	8	f2	float
    //   18	1073	9	i	int
    //   203	902	10	j	int
    //   279	833	11	k	int
    //   236	453	12	m	int
    //   351	796	13	n	int
    //   15	1185	14	i1	int
    //   391	728	15	i2	int
    //   378	829	16	i3	int
    //   12	642	17	i4	int
    //   314	819	18	l1	long
    //   288	838	20	l2	long
    //   382	832	22	l3	long
    //   206	444	24	l4	long
    //   342	163	26	localObject1	java.lang.Object
    //   519	1	26	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   527	1	26	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   535	1	26	localInvalidProtocolBufferMicroException3	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   540	1	26	localInvalidProtocolBufferMicroException4	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   556	1	26	localInvalidProtocolBufferMicroException5	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   577	1	26	localInvalidProtocolBufferMicroException6	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   586	38	26	localInvalidProtocolBufferMicroException7	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   632	561	26	localObject2	java.lang.Object
    //   200	241	27	localObject3	java.lang.Object
    //   476	1	27	localInvalidProtocolBufferMicroException8	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   489	1	27	localInvalidProtocolBufferMicroException9	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   502	1	27	localInvalidProtocolBufferMicroException10	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   511	1	27	localInvalidProtocolBufferMicroException11	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   522	618	27	localObject4	java.lang.Object
    //   365	795	28	localObject5	java.lang.Object
    //   71	1156	29	localObject6	java.lang.Object
    //   355	927	30	localObject7	java.lang.Object
    //   191	760	31	localObject8	java.lang.Object
    //   115	1131	32	localApolloMessage	ApolloMessage
    //   9	1242	33	localQQAppInterface	QQAppInterface
    //   874	69	34	localObject9	java.lang.Object
    //   883	15	35	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   384	393	476	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   401	410	476	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   418	427	476	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   357	367	489	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   371	380	489	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   344	353	502	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   335	344	511	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   316	335	519	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   307	316	527	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   298	307	535	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   290	298	540	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   281	290	556	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   238	247	577	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   255	264	577	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   272	281	577	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   208	234	586	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   695	746	1257	java/lang/Throwable
    //   754	777	1257	java/lang/Throwable
    //   780	797	1257	java/lang/Throwable
    //   797	852	1257	java/lang/Throwable
    //   857	885	1257	java/lang/Throwable
    //   885	911	1257	java/lang/Throwable
    //   914	925	1257	java/lang/Throwable
    //   925	932	1257	java/lang/Throwable
    //   937	948	1257	java/lang/Throwable
    //   948	1239	1257	java/lang/Throwable
    //   108	146	1261	java/lang/Throwable
    //   151	178	1261	java/lang/Throwable
    //   184	202	1261	java/lang/Throwable
    //   208	234	1261	java/lang/Throwable
    //   238	247	1261	java/lang/Throwable
    //   255	264	1261	java/lang/Throwable
    //   272	281	1261	java/lang/Throwable
    //   281	290	1261	java/lang/Throwable
    //   290	298	1261	java/lang/Throwable
    //   298	307	1261	java/lang/Throwable
    //   307	316	1261	java/lang/Throwable
    //   316	335	1261	java/lang/Throwable
    //   335	344	1261	java/lang/Throwable
    //   344	353	1261	java/lang/Throwable
    //   357	367	1261	java/lang/Throwable
    //   371	380	1261	java/lang/Throwable
    //   384	393	1261	java/lang/Throwable
    //   401	410	1261	java/lang/Throwable
    //   418	427	1261	java/lang/Throwable
    //   657	662	1261	java/lang/Throwable
    //   1244	1255	1261	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.message.ApolloElemDecoder
 * JD-Core Version:    0.7.0.1
 */