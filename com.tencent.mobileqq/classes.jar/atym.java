import PushNotifyPack.C2CMsgReadedNotify;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype34;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype34.GameSession;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class atym
{
  public static long a(long paramLong, msg_comm.UinPairMsg paramUinPairMsg, QQAppInterface paramQQAppInterface)
  {
    if (paramUinPairMsg != null) {
      try
      {
        if ((paramUinPairMsg.service_type.has()) && (paramUinPairMsg.service_type.get() == 164))
        {
          if (paramUinPairMsg.uint64_to_tiny_id.has())
          {
            paramUinPairMsg = String.valueOf(paramUinPairMsg.uint64_to_tiny_id.get());
            if (QLog.isColorLevel()) {
              QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "convertTinyToUin is called, fromTinyId: " + paramLong + "toTinyId :" + paramUinPairMsg);
            }
            return Long.parseLong(paramQQAppInterface.getTinyIdCache().a(String.valueOf(paramLong), paramUinPairMsg));
          }
          if (QLog.isColorLevel())
          {
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "convertTinyToUin is called, but toTinyId is not contained.");
            return paramLong;
          }
        }
      }
      catch (Exception paramUinPairMsg)
      {
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 1, "convertTinyToUin is called", paramUinPairMsg);
      }
    }
    return paramLong;
  }
  
  public static String a(msg_comm.UinPairMsg paramUinPairMsg, QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l = paramUinPairMsg.peer_uin.get();
    if ((paramInt == 10007) && (paramQQAppInterface != null)) {
      return String.valueOf(a(l, paramUinPairMsg, paramQQAppInterface));
    }
    return String.valueOf(l);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = paramQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt);
        if (paramQQAppInterface == null) {
          break;
        }
        paramString = paramQQAppInterface.getExtInfoFromExtStr("ext_key_game_msg_info");
        boolean bool2 = paramQQAppInterface.isSend();
        if (!bool2)
        {
          bool1 = true;
          paramQQAppInterface = new TinyInfo(paramString, bool1);
          paramChatMessage.saveExtInfoToExtStr("ext_key_game_msg_info", paramQQAppInterface.toJsonStr());
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "bindTinyInfo is called, issend: " + bool2 + "tinyInfo :" + paramQQAppInterface);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      boolean bool1 = false;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((atyd)paramQQAppInterface.getManager(358)).a(paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, C2CMsgReadedNotify paramC2CMsgReadedNotify)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "handlePushReadNotify is called peerUin = " + paramString + ", cr.uint64_to_tiny_id = " + paramC2CMsgReadedNotify.uint64_to_tiny_id);
      }
      paramString = paramQQAppInterface.getTinyIdCache().a(paramString, String.valueOf(paramC2CMsgReadedNotify.uint64_to_tiny_id));
      paramQQAppInterface.getMessageFacade().setReadFrom(paramString, 10007, paramC2CMsgReadedNotify.lLastReadTime);
      if (paramC2CMsgReadedNotify.lLastReadTime >= 0L) {
        paramQQAppInterface.getMessageFacade().msgNotifyManager.a(paramString, 10007);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, "handlePushReadNotify error", paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, msg_svc.PbC2CReadedReportReq paramPbC2CReadedReportReq, long paramLong, ConversationInfo paramConversationInfo)
  {
    if ((paramLong == 0L) || (paramConversationInfo == null) || (paramQQAppInterface == null)) {}
    long l1;
    long l2;
    do
    {
      for (;;)
      {
        return;
        paramConversationInfo = paramQQAppInterface.getTinyIdCache().a(paramConversationInfo.uin);
        try
        {
          l1 = Long.valueOf((String)paramConversationInfo.first).longValue();
          l2 = Long.valueOf((String)paramConversationInfo.second).longValue();
          if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "createMsgReadConfirm is called");
          }
          if (paramQQAppInterface.getCurrentAccountUin() != null) {
            if ((l1 == 0L) || (l2 == 0L))
            {
              QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "peeruin & toTinyid exception!");
              return;
            }
          }
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, paramQQAppInterface, new Object[0]);
          return;
        }
      }
      paramQQAppInterface = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      paramQQAppInterface.peer_uin.set(l1);
      paramQQAppInterface.last_read_time.set((int)paramLong);
      paramQQAppInterface.aio_type.set(3);
      paramQQAppInterface.uint64_to_tiny_id.set(l2);
      paramPbC2CReadedReportReq.pair_info.add(paramQQAppInterface);
    } while (!QLog.isColorLevel());
    QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "msgReadedReportUin : " + l1 + ", toIinyId = " + l2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, msg_svc.PbMsgReadedReportReq paramPbMsgReadedReportReq, String paramString, long paramLong)
  {
    if ((paramLong == 0L) || (paramQQAppInterface == null)) {}
    long l1;
    long l2;
    do
    {
      for (;;)
      {
        return;
        localObject = paramQQAppInterface.getTinyIdCache().a(paramString);
        try
        {
          l1 = Long.valueOf((String)((Pair)localObject).first).longValue();
          l2 = Long.valueOf((String)((Pair)localObject).second).longValue();
          if (QLog.isColorLevel()) {
            QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "createMsgReadConfirm is called curFriendUin = " + paramString);
          }
          if (paramQQAppInterface.getCurrentAccountUin() != null) {
            if ((l1 == 0L) || (l2 == 0L))
            {
              QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, "peeruin & toTinyid exception!");
              return;
            }
          }
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          QLog.e("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 1, paramQQAppInterface, new Object[0]);
          return;
        }
      }
      Object localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(l1);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)paramLong);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).aio_type.set(3);
      ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).uint64_to_tiny_id.set(l2);
      paramString = new msg_svc.PbC2CReadedReportReq();
      paramString.pair_info.add((MessageMicro)localObject);
      paramQQAppInterface = paramQQAppInterface.getMsgHandler().a().a();
      if (paramQQAppInterface != null) {
        paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      paramQQAppInterface = paramPbMsgReadedReportReq;
      if (paramPbMsgReadedReportReq == null) {
        paramQQAppInterface = new msg_svc.PbMsgReadedReportReq();
      }
      paramQQAppInterface.c2c_read_report.set(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("Q.tiny_msg.decoder.TinyMsgCodecsendReadConfirm_PB", 2, "msgReadedReportUin : " + l1 + ", toIinyId = " + l2);
  }
  
  private static void a(msg_comm.Msg paramMsg, QQAppInterface paramQQAppInterface, bbkm parambbkm, String paramString1, String paramString2)
  {
    if (paramMsg.msg_head.has())
    {
      paramMsg = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
      if ((!parambbkm.d) && (paramMsg.sig.has()))
      {
        paramMsg = paramMsg.sig.get().toByteArray();
        paramQQAppInterface.getMsgCache().d(paramString1, paramString2, paramMsg);
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 4, "saveTokenSig tempHead.sig.get()----> sig:" + HexUtil.bytes2HexStr(paramMsg) + ",length:" + paramMsg.length);
        }
      }
    }
  }
  
  /* Error */
  public static void a(msg_comm.Msg paramMsg, im_msg_body.Elem paramElem, java.util.List<MessageRecord> paramList, QQAppInterface paramQQAppInterface, bbkm parambbkm)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +20 -> 21
    //   4: aload_2
    //   5: ifnull +16 -> 21
    //   8: aload_3
    //   9: ifnull +12 -> 21
    //   12: aload_2
    //   13: invokeinterface 382 1 0
    //   18: ifgt +4 -> 22
    //   21: return
    //   22: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +12 -> 37
    //   28: ldc 47
    //   30: iconst_2
    //   31: ldc_w 384
    //   34: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload_3
    //   38: invokevirtual 232	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   41: astore 17
    //   43: bipush 34
    //   45: aload_1
    //   46: getfield 390	tencent/im/msg/im_msg_body$Elem:common_elem	Ltencent/im/msg/im_msg_body$CommonElem;
    //   49: getfield 395	tencent/im/msg/im_msg_body$CommonElem:uint32_service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   52: invokevirtual 24	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   55: if_icmpne -34 -> 21
    //   58: aload_1
    //   59: getfield 390	tencent/im/msg/im_msg_body$Elem:common_elem	Ltencent/im/msg/im_msg_body$CommonElem;
    //   62: getfield 398	tencent/im/msg/im_msg_body$CommonElem:uint32_business_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   65: invokevirtual 24	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   68: iconst_1
    //   69: if_icmpne -48 -> 21
    //   72: aload_1
    //   73: getfield 390	tencent/im/msg/im_msg_body$Elem:common_elem	Ltencent/im/msg/im_msg_body$CommonElem;
    //   76: getfield 401	tencent/im/msg/im_msg_body$CommonElem:bytes_pb_elem	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   79: invokevirtual 344	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   82: ifeq -61 -> 21
    //   85: new 403	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34
    //   88: dup
    //   89: invokespecial 404	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:<init>	()V
    //   92: astore 12
    //   94: aload 12
    //   96: aload_1
    //   97: getfield 390	tencent/im/msg/im_msg_body$Elem:common_elem	Ltencent/im/msg/im_msg_body$CommonElem;
    //   100: getfield 401	tencent/im/msg/im_msg_body$CommonElem:bytes_pb_elem	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   106: invokevirtual 350	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   109: invokevirtual 408	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   112: pop
    //   113: aload 12
    //   115: getfield 411	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:from_nickname	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   118: invokevirtual 344	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   121: ifeq +541 -> 662
    //   124: aload 12
    //   126: getfield 411	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:from_nickname	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   129: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   132: invokevirtual 414	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   135: astore_1
    //   136: aload 12
    //   138: getfield 417	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:push_window_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   141: invokevirtual 20	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   144: ifeq +626 -> 770
    //   147: aload 12
    //   149: getfield 417	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:push_window_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   152: invokevirtual 24	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   155: istore 5
    //   157: aload 12
    //   159: getfield 420	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:bytes_ext	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   162: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   165: invokevirtual 414	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   168: astore 13
    //   170: aload_3
    //   171: sipush 358
    //   174: invokevirtual 156	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   177: checkcast 158	atyd
    //   180: astore 14
    //   182: aload 13
    //   184: invokestatic 426	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   187: ifne +23 -> 210
    //   190: aload 14
    //   192: new 428	org/json/JSONObject
    //   195: dup
    //   196: aload 13
    //   198: invokespecial 431	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   201: ldc_w 433
    //   204: invokevirtual 437	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   207: invokevirtual 439	atyd:a	(I)V
    //   210: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +38 -> 251
    //   216: ldc 47
    //   218: iconst_2
    //   219: iconst_4
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: ldc_w 441
    //   228: aastore
    //   229: dup
    //   230: iconst_1
    //   231: aload 13
    //   233: aastore
    //   234: dup
    //   235: iconst_2
    //   236: ldc_w 443
    //   239: aastore
    //   240: dup
    //   241: iconst_3
    //   242: iload 5
    //   244: invokestatic 448	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: invokestatic 451	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   251: aload 12
    //   253: getfield 455	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:game_session	Ltencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession;
    //   256: invokevirtual 458	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:has	()Z
    //   259: ifeq +439 -> 698
    //   262: aload 12
    //   264: getfield 455	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34:game_session	Ltencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession;
    //   267: invokevirtual 459	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   270: checkcast 457	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession
    //   273: astore 13
    //   275: aload 13
    //   277: ifnull +483 -> 760
    //   280: aload 13
    //   282: getfield 462	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_role_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   285: invokevirtual 344	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   288: ifeq +416 -> 704
    //   291: aload 13
    //   293: getfield 462	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_role_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   296: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   299: invokevirtual 414	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   302: astore 12
    //   304: aload 13
    //   306: getfield 465	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   309: invokevirtual 344	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   312: ifeq +464 -> 776
    //   315: aload 13
    //   317: getfield 465	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   320: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   323: invokevirtual 414	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   326: astore 14
    //   328: aload 13
    //   330: getfield 468	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_role_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   333: invokevirtual 344	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   336: ifeq +448 -> 784
    //   339: aload 13
    //   341: getfield 468	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_role_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   344: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   347: invokevirtual 414	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   350: astore 15
    //   352: aload 13
    //   354: getfield 471	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   357: invokevirtual 344	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   360: ifeq +432 -> 792
    //   363: aload 13
    //   365: getfield 471	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_open_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   368: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   371: invokevirtual 414	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   374: astore 16
    //   376: aload 13
    //   378: getfield 474	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:game_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   381: invokevirtual 31	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   384: ifeq +416 -> 800
    //   387: aload 13
    //   389: getfield 474	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:game_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   392: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   395: lstore 6
    //   397: aload 13
    //   399: getfield 477	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   402: invokevirtual 31	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   405: ifeq +401 -> 806
    //   408: aload 13
    //   410: getfield 477	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:from_tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   413: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   416: lstore 8
    //   418: aload 13
    //   420: getfield 480	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   423: invokevirtual 31	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   426: ifeq +386 -> 812
    //   429: aload 13
    //   431: getfield 480	tencent/im/msg/hummer/servtype/hummer_commelem$MsgElemInfo_servtype34$GameSession:to_tiny_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   434: invokevirtual 34	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   437: lstore 10
    //   439: aload_2
    //   440: invokeinterface 484 1 0
    //   445: astore_2
    //   446: aload_2
    //   447: invokeinterface 489 1 0
    //   452: ifeq +273 -> 725
    //   455: aload_2
    //   456: invokeinterface 493 1 0
    //   461: checkcast 117	com/tencent/mobileqq/data/MessageRecord
    //   464: astore 13
    //   466: aload 12
    //   468: aload 14
    //   470: aload 15
    //   472: aload 16
    //   474: lload 6
    //   476: lload 8
    //   478: lload 10
    //   480: iload 5
    //   482: aload_1
    //   483: invokestatic 496	com/tencent/mobileqq/gamecenter/message/TinyInfo:toJsonStr	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJILjava/lang/String;)Ljava/lang/String;
    //   486: astore 18
    //   488: aload_3
    //   489: aload 12
    //   491: invokestatic 498	atym:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   494: aload 13
    //   496: ldc 115
    //   498: aload 18
    //   500: invokevirtual 499	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: aload 4
    //   505: getfield 502	bbkm:i	Z
    //   508: ifne +204 -> 712
    //   511: aload 13
    //   513: aload_3
    //   514: invokevirtual 78	com/tencent/mobileqq/app/QQAppInterface:getTinyIdCache	()Latyk;
    //   517: lload 10
    //   519: invokestatic 40	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   522: lload 8
    //   524: invokestatic 40	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   527: invokevirtual 83	atyk:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   530: putfield 505	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   533: aload_0
    //   534: aload_3
    //   535: aload 4
    //   537: aload 13
    //   539: getfield 505	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   542: aload 17
    //   544: invokestatic 507	atym:a	(Lmsf/msgcomm/msg_comm$Msg;Lcom/tencent/mobileqq/app/QQAppInterface;Lbbkm;Ljava/lang/String;Ljava/lang/String;)V
    //   547: aload 4
    //   549: aload 13
    //   551: getfield 505	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   554: invokestatic 89	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   557: putfield 509	bbkm:e	J
    //   560: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   563: ifeq -117 -> 446
    //   566: ldc_w 511
    //   569: iconst_2
    //   570: new 49	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 513
    //   580: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: lload 10
    //   585: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   588: ldc_w 515
    //   591: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: lload 8
    //   596: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: ldc_w 517
    //   602: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload 4
    //   607: getfield 520	bbkm:b	J
    //   610: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   613: ldc_w 522
    //   616: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload 4
    //   621: getfield 509	bbkm:e	J
    //   624: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   627: ldc_w 524
    //   630: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload 13
    //   635: invokevirtual 527	com/tencent/mobileqq/data/MessageRecord:getBaseInfoString	()Ljava/lang/String;
    //   638: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: goto -201 -> 446
    //   650: astore_0
    //   651: ldc 47
    //   653: iconst_1
    //   654: ldc_w 529
    //   657: aload_0
    //   658: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   661: return
    //   662: ldc_w 531
    //   665: astore_1
    //   666: goto -530 -> 136
    //   669: astore 13
    //   671: ldc 47
    //   673: iconst_1
    //   674: aload 13
    //   676: iconst_0
    //   677: anewarray 4	java/lang/Object
    //   680: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   683: goto -432 -> 251
    //   686: astore_0
    //   687: ldc 47
    //   689: iconst_1
    //   690: ldc_w 529
    //   693: aload_0
    //   694: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   697: return
    //   698: aconst_null
    //   699: astore 13
    //   701: goto -426 -> 275
    //   704: ldc_w 531
    //   707: astore 12
    //   709: goto -405 -> 304
    //   712: aload 4
    //   714: aload 4
    //   716: getfield 509	bbkm:e	J
    //   719: putfield 520	bbkm:b	J
    //   722: goto -162 -> 560
    //   725: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   728: ifeq -707 -> 21
    //   731: ldc 47
    //   733: iconst_2
    //   734: ldc_w 533
    //   737: iconst_2
    //   738: anewarray 4	java/lang/Object
    //   741: dup
    //   742: iconst_0
    //   743: aload_1
    //   744: aastore
    //   745: dup
    //   746: iconst_1
    //   747: iload 5
    //   749: invokestatic 448	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   752: aastore
    //   753: invokestatic 537	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   756: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   759: return
    //   760: ldc 47
    //   762: iconst_1
    //   763: ldc_w 539
    //   766: invokestatic 72	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   769: return
    //   770: iconst_0
    //   771: istore 5
    //   773: goto -616 -> 157
    //   776: ldc_w 531
    //   779: astore 14
    //   781: goto -453 -> 328
    //   784: ldc_w 531
    //   787: astore 15
    //   789: goto -437 -> 352
    //   792: ldc_w 531
    //   795: astore 16
    //   797: goto -421 -> 376
    //   800: lconst_0
    //   801: lstore 6
    //   803: goto -406 -> 397
    //   806: lconst_0
    //   807: lstore 8
    //   809: goto -391 -> 418
    //   812: lconst_0
    //   813: lstore 10
    //   815: goto -376 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	paramMsg	msg_comm.Msg
    //   0	818	1	paramElem	im_msg_body.Elem
    //   0	818	2	paramList	java.util.List<MessageRecord>
    //   0	818	3	paramQQAppInterface	QQAppInterface
    //   0	818	4	parambbkm	bbkm
    //   155	617	5	i	int
    //   395	407	6	l1	long
    //   416	392	8	l2	long
    //   437	377	10	l3	long
    //   92	616	12	localObject1	Object
    //   168	466	13	localObject2	Object
    //   669	6	13	localThrowable	Throwable
    //   699	1	13	localObject3	Object
    //   180	600	14	localObject4	Object
    //   350	438	15	str1	String
    //   374	422	16	str2	String
    //   41	502	17	str3	String
    //   486	13	18	str4	String
    // Exception table:
    //   from	to	target	type
    //   43	136	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	157	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   157	170	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   170	210	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   210	251	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   251	275	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   280	304	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   304	328	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   328	352	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   352	376	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   376	397	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   397	418	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   418	439	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   439	446	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   446	560	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   560	647	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   671	683	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   712	722	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   725	759	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   760	769	650	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   170	210	669	java/lang/Throwable
    //   210	251	669	java/lang/Throwable
    //   43	136	686	java/lang/Exception
    //   136	157	686	java/lang/Exception
    //   157	170	686	java/lang/Exception
    //   170	210	686	java/lang/Exception
    //   210	251	686	java/lang/Exception
    //   251	275	686	java/lang/Exception
    //   280	304	686	java/lang/Exception
    //   304	328	686	java/lang/Exception
    //   328	352	686	java/lang/Exception
    //   352	376	686	java/lang/Exception
    //   376	397	686	java/lang/Exception
    //   397	418	686	java/lang/Exception
    //   418	439	686	java/lang/Exception
    //   439	446	686	java/lang/Exception
    //   446	560	686	java/lang/Exception
    //   560	647	686	java/lang/Exception
    //   671	683	686	java/lang/Exception
    //   712	722	686	java/lang/Exception
    //   725	759	686	java/lang/Exception
    //   760	769	686	java/lang/Exception
  }
  
  public static void a(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
    TinyInfo localTinyInfo = new TinyInfo();
    if (!TextUtils.isEmpty(paramMessageRecord)) {
      localTinyInfo.parseFromJson(paramMessageRecord);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.tiny_msg.decoder.TinyMsgCodecbindTinyInfoElem", 2, "bindTinyInfoElem is called, info: " + localTinyInfo);
    }
    paramMessageRecord = new hummer_commelem.MsgElemInfo_servtype34();
    hummer_commelem.MsgElemInfo_servtype34.GameSession localGameSession = new hummer_commelem.MsgElemInfo_servtype34.GameSession();
    if ((TextUtils.isEmpty(localTinyInfo.fromRoleId)) || (TextUtils.isEmpty(localTinyInfo.toRoleId))) {
      return;
    }
    localGameSession.from_open_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.fromOpenId));
    localGameSession.from_role_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.fromRoleId));
    localGameSession.to_role_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.toRoleId));
    localGameSession.to_open_id.set(ByteStringMicro.copyFromUtf8(localTinyInfo.toOpenId));
    localGameSession.game_appid.set(localTinyInfo.gameAppId);
    localGameSession.from_tiny_id.set(localTinyInfo.fromTinyId);
    localGameSession.to_tiny_id.set(localTinyInfo.toTinyId);
    paramMessageRecord.game_session.set(localGameSession);
    try
    {
      paramQQAppInterface = ((atyd)paramQQAppInterface.getManager(358)).a(localTinyInfo.toRoleId);
      if (QLog.isColorLevel()) {
        QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "rStr:" + paramQQAppInterface);
      }
      paramMessageRecord.bytes_ext.set(ByteStringMicro.copyFromUtf8(paramQQAppInterface));
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("Q.tiny_msg.decoder.TinyMsgCodec", 1, paramQQAppInterface, new Object[0]);
      }
    }
    paramQQAppInterface = new im_msg_body.CommonElem();
    paramQQAppInterface.uint32_service_type.set(34);
    paramQQAppInterface.uint32_business_type.set(1);
    paramQQAppInterface.bytes_pb_elem.set(ByteStringMicro.copyFrom(paramMessageRecord.toByteArray()));
    paramElem.common_elem.set(paramQQAppInterface);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    TinyInfo localTinyInfo;
    if (paramMessageRecord.istroop == 10007)
    {
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
      if (!TextUtils.isEmpty(paramMessageRecord))
      {
        localTinyInfo = new TinyInfo();
        localTinyInfo.parseFromJson(paramMessageRecord);
        if (QLog.isColorLevel()) {
          QLog.d("Q.tiny_msg.decoder.TinyMsgCodec", 2, "isNeedTips windowflag = " + localTinyInfo.windowFlag);
        }
      }
    }
    return (localTinyInfo.windowFlag & 1L) == 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atym
 * JD-Core Version:    0.7.0.1
 */