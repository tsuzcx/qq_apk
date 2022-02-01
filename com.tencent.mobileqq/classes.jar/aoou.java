import ActionMsg.MsgBody;
import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import PushNotifyPack.RequestPushNotify;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbBindUinGetMsgReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmResp;
import msf.msgsvc.msg_svc.PbGetMsgResp;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqReq;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import oicq.wlogin_sdk.request.Ticket;
import org.jetbrains.annotations.Nullable;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.ReqBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class aoou
  extends acmp
{
  public aoou(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  @Nullable
  private msg_svc.PbGetMsgResp a(byte[] paramArrayOfByte, msg_svc.PbGetMsgResp paramPbGetMsgResp)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("printPBuffer", 2, HexUtil.bytes2HexStr(paramArrayOfByte));
      }
      paramArrayOfByte = (msg_svc.PbGetMsgResp)paramPbGetMsgResp.mergeFrom(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountMessageProcessor", 2, "subaccount <---handleGetSubC2CMessageResp_PB : decode pb:", paramArrayOfByte);
      }
    }
    return null;
  }
  
  private void a(bdxs parambdxs, long paramLong1, long paramLong2, long paramLong3, int paramInt, StringBuffer paramStringBuffer, boolean paramBoolean1, MessageRecord paramMessageRecord, long paramLong4, boolean paramBoolean2, String paramString)
  {
    SubAccountMessage localSubAccountMessage = new SubAccountMessage();
    if (paramBoolean2)
    {
      localSubAccountMessage.frienduin = String.valueOf(AppConstants.SYSTEM_MSG_UIN);
      if (!paramBoolean1) {
        break label467;
      }
      paramBoolean2 = true;
      label33:
      localSubAccountMessage.isread = paramBoolean2;
      localSubAccountMessage.msg = paramStringBuffer.toString();
      localSubAccountMessage.extInt = paramMessageRecord.extInt;
      localSubAccountMessage.extLong = paramMessageRecord.extLong;
      localSubAccountMessage.extraflag = paramMessageRecord.extraflag;
      localSubAccountMessage.extStr = paramMessageRecord.extStr;
      localSubAccountMessage.istroop = paramMessageRecord.istroop;
      localSubAccountMessage.isValid = paramMessageRecord.isValid;
      localSubAccountMessage.longMsgCount = paramMessageRecord.longMsgCount;
      localSubAccountMessage.longMsgId = paramMessageRecord.longMsgId;
      localSubAccountMessage.longMsgIndex = paramMessageRecord.longMsgIndex;
      localSubAccountMessage.msgUid = paramMessageRecord.msgUid;
      localSubAccountMessage.shmsgseq = paramMessageRecord.shmsgseq;
      localSubAccountMessage.uniseq = paramMessageRecord.uniseq;
      localSubAccountMessage.msgseq = paramMessageRecord.msgseq;
      if (paramBoolean1) {
        paramInt = 0;
      }
      localSubAccountMessage.unreadNum = paramInt;
      localSubAccountMessage.msgtype = -1000;
      localSubAccountMessage.selfuin = String.valueOf(paramLong1);
      if (paramString != null)
      {
        paramStringBuffer = paramString;
        if (paramString.length() != 0) {}
      }
      else
      {
        paramStringBuffer = localSubAccountMessage.frienduin;
      }
      localSubAccountMessage.sendername = paramStringBuffer;
      localSubAccountMessage.senderuin = String.valueOf(paramLong3);
      localSubAccountMessage.subUin = Long.toString(paramLong2);
      if (paramLong4 != 0L) {
        break label473;
      }
    }
    label467:
    label473:
    for (paramLong1 = System.currentTimeMillis() / 1000L;; paramLong1 = paramLong4)
    {
      localSubAccountMessage.time = paramLong1;
      localSubAccountMessage.needNotify = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause;
      localSubAccountMessage.mTimeString = bhid.a(1000L * paramLong4, true, bdxj.jdField_a_of_type_JavaLangString);
      localSubAccountMessage.mEmoRecentMsg = new QQText(localSubAccountMessage.msg, 3, 16);
      if (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord)) {
        localSubAccountMessage.subExtr = "RED_PACKET";
      }
      if ((paramMessageRecord instanceof MessageForFuDai)) {
        localSubAccountMessage.subExtr = "RED_PACKET";
      }
      if (parambdxs != null) {
        parambdxs.b(localSubAccountMessage);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "subaccount set msg read false hasData = false  unreadNum=" + localSubAccountMessage.unreadNum);
        if (!TextUtils.isEmpty(localSubAccountMessage.msg)) {
          QLog.d("SUB_ACCOUNT", 2, "msg=" + localSubAccountMessage.msg.charAt(0));
        }
      }
      return;
      localSubAccountMessage.frienduin = String.valueOf(paramLong3);
      break;
      paramBoolean2 = false;
      break label33;
    }
  }
  
  /* Error */
  private void a(bdxt parambdxt, String paramString1, String paramString2, bdxs parambdxs, long paramLong1, long paramLong2, long paramLong3, List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, HashMap<String, Integer> paramHashMap, long paramLong4, List<msg_comm.Msg> paramList1, int paramInt, bcre parambcre)
  {
    // Byte code:
    //   0: aload 16
    //   2: invokeinterface 266 1 0
    //   7: astore 23
    //   9: aload 23
    //   11: invokeinterface 271 1 0
    //   16: ifeq +677 -> 693
    //   19: aload 23
    //   21: invokeinterface 275 1 0
    //   26: checkcast 277	msf/msgcomm/msg_comm$Msg
    //   29: astore 24
    //   31: aload 24
    //   33: ifnull -24 -> 9
    //   36: aload 24
    //   38: getfield 281	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   41: invokevirtual 287	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   44: checkcast 283	msf/msgcomm/msg_comm$MsgHead
    //   47: astore 25
    //   49: aload 25
    //   51: getfield 291	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   54: invokevirtual 295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   57: istore 19
    //   59: aload 24
    //   61: getfield 281	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   64: invokevirtual 287	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: checkcast 283	msf/msgcomm/msg_comm$MsgHead
    //   70: getfield 298	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   76: istore 20
    //   78: sipush 193
    //   81: iload 19
    //   83: if_icmpeq +11 -> 94
    //   86: sipush 734
    //   89: iload 19
    //   91: if_icmpne +251 -> 342
    //   94: lload 7
    //   96: lload 14
    //   98: lcmp
    //   99: ifne +107 -> 206
    //   102: aconst_null
    //   103: astore 16
    //   105: aload 16
    //   107: ifnull +67 -> 174
    //   110: aload 16
    //   112: invokeinterface 300 1 0
    //   117: ifne +57 -> 174
    //   120: aload 11
    //   122: ifnull +52 -> 174
    //   125: aload 11
    //   127: invokeinterface 300 1 0
    //   132: ifne +42 -> 174
    //   135: aload 16
    //   137: iconst_0
    //   138: invokeinterface 303 2 0
    //   143: checkcast 87	com/tencent/mobileqq/data/MessageRecord
    //   146: getfield 304	com/tencent/mobileqq/data/MessageRecord:time	J
    //   149: aload 11
    //   151: iconst_0
    //   152: invokeinterface 303 2 0
    //   157: checkcast 54	com/tencent/mobileqq/data/SubAccountMessage
    //   160: getfield 181	com/tencent/mobileqq/data/SubAccountMessage:time	J
    //   163: lcmp
    //   164: ifge +10 -> 174
    //   167: aload 16
    //   169: invokeinterface 307 1 0
    //   174: aload 16
    //   176: ifnull +13 -> 189
    //   179: aload 16
    //   181: invokeinterface 310 1 0
    //   186: ifne +479 -> 665
    //   189: aload_0
    //   190: aload 11
    //   192: aload 12
    //   194: aload 13
    //   196: lload 14
    //   198: iload 17
    //   200: invokespecial 313	aoou:a	(Ljava/util/List;Ljava/util/ArrayList;Ljava/util/HashMap;JI)V
    //   203: goto -194 -> 9
    //   206: new 315	java/util/ArrayList
    //   209: dup
    //   210: invokespecial 316	java/util/ArrayList:<init>	()V
    //   213: astore 16
    //   215: sipush 193
    //   218: invokestatic 321	bcsa:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   221: astore 22
    //   223: aload 22
    //   225: lload 7
    //   227: invokestatic 150	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   230: putfield 322	com/tencent/mobileqq/data/MessageRecord:selfuin	Ljava/lang/String;
    //   233: aload 22
    //   235: lload 14
    //   237: invokestatic 150	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   240: putfield 323	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   243: aload 22
    //   245: lload 14
    //   247: invokestatic 150	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   250: putfield 324	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   253: aload 22
    //   255: aload 25
    //   257: getfield 327	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   260: invokevirtual 295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   263: i2l
    //   264: putfield 132	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   267: aload 22
    //   269: aload 25
    //   271: getfield 331	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   274: invokevirtual 335	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   277: putfield 128	com/tencent/mobileqq/data/MessageRecord:msgUid	J
    //   280: aload 22
    //   282: aload 25
    //   284: getfield 338	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   287: invokevirtual 295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   290: i2l
    //   291: putfield 304	com/tencent/mobileqq/data/MessageRecord:time	J
    //   294: aload 22
    //   296: iconst_0
    //   297: putfield 107	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   300: aload 22
    //   302: aload_0
    //   303: getfield 14	aoou:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   306: invokevirtual 342	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   309: invokevirtual 348	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   312: ldc_w 349
    //   315: invokevirtual 355	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   318: putfield 356	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   321: aload 22
    //   323: sipush 193
    //   326: putfield 357	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   329: aload 16
    //   331: aload 22
    //   333: invokeinterface 361 2 0
    //   338: pop
    //   339: goto -234 -> 105
    //   342: aload_0
    //   343: aload 25
    //   345: iload 19
    //   347: iload 20
    //   349: invokespecial 364	aoou:a	(Lmsf/msgcomm/msg_comm$MsgHead;II)Z
    //   352: ifeq +262 -> 614
    //   355: aload_0
    //   356: iload 20
    //   358: invokespecial 367	aoou:a	(I)Z
    //   361: ifne -352 -> 9
    //   364: aload 24
    //   366: getfield 371	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   369: invokevirtual 374	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   372: checkcast 373	tencent/im/msg/im_msg_body$MsgBody
    //   375: getfield 378	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   378: invokevirtual 381	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   381: checkcast 380	tencent/im/msg/im_msg_body$RichText
    //   384: getfield 385	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   387: invokevirtual 388	tencent/im/msg/im_msg_body$NotOnlineFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   390: checkcast 387	tencent/im/msg/im_msg_body$NotOnlineFile
    //   393: getfield 392	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   396: invokevirtual 397	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   399: invokevirtual 402	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   402: astore 16
    //   404: aload 16
    //   406: astore 22
    //   408: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +34 -> 445
    //   414: ldc 231
    //   416: iconst_2
    //   417: new 233	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   424: ldc_w 404
    //   427: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 16
    //   432: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 36	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: aload 16
    //   443: astore 22
    //   445: aload 22
    //   447: astore 16
    //   449: aload 22
    //   451: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   454: ifeq +21 -> 475
    //   457: aload_0
    //   458: getfield 14	aoou:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   461: invokevirtual 342	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   464: invokevirtual 348	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   467: ldc_w 405
    //   470: invokevirtual 355	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   473: astore 16
    //   475: sipush -2005
    //   478: invokestatic 321	bcsa:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   481: astore 22
    //   483: aload 22
    //   485: lload 7
    //   487: invokestatic 150	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   490: putfield 322	com/tencent/mobileqq/data/MessageRecord:selfuin	Ljava/lang/String;
    //   493: aload 22
    //   495: lload 14
    //   497: invokestatic 150	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   500: putfield 323	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   503: aload 22
    //   505: lload 14
    //   507: invokestatic 150	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   510: putfield 324	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   513: aload 22
    //   515: aload 25
    //   517: getfield 327	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   520: invokevirtual 295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   523: i2l
    //   524: putfield 132	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   527: aload 22
    //   529: aload 25
    //   531: getfield 331	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   534: invokevirtual 335	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   537: putfield 128	com/tencent/mobileqq/data/MessageRecord:msgUid	J
    //   540: aload 22
    //   542: aload 25
    //   544: getfield 338	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   547: invokevirtual 295	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   550: i2l
    //   551: putfield 304	com/tencent/mobileqq/data/MessageRecord:time	J
    //   554: aload 22
    //   556: iconst_0
    //   557: putfield 107	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   560: aload 22
    //   562: aload 16
    //   564: putfield 356	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   567: aload 22
    //   569: sipush -2005
    //   572: putfield 357	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   575: new 315	java/util/ArrayList
    //   578: dup
    //   579: invokespecial 316	java/util/ArrayList:<init>	()V
    //   582: astore 16
    //   584: aload 16
    //   586: aload 22
    //   588: invokeinterface 361 2 0
    //   593: pop
    //   594: goto -489 -> 105
    //   597: astore 22
    //   599: aconst_null
    //   600: astore 16
    //   602: aload 22
    //   604: invokevirtual 408	java/lang/Exception:printStackTrace	()V
    //   607: aload 16
    //   609: astore 22
    //   611: goto -166 -> 445
    //   614: aload_0
    //   615: aload 24
    //   617: aload 18
    //   619: invokevirtual 411	aoou:a	(Lmsf/msgcomm/msg_comm$Msg;Lbcsd;)Ljava/util/List;
    //   622: astore 16
    //   624: aload_0
    //   625: aload 16
    //   627: invokespecial 414	aoou:a	(Ljava/util/List;)Z
    //   630: istore 21
    //   632: iload 21
    //   634: ifne -625 -> 9
    //   637: goto -532 -> 105
    //   640: astore 22
    //   642: aconst_null
    //   643: astore 16
    //   645: invokestatic 24	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   648: ifeq +14 -> 662
    //   651: ldc 44
    //   653: iconst_2
    //   654: ldc_w 416
    //   657: aload 22
    //   659: invokestatic 419	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   662: goto -557 -> 105
    //   665: aload_0
    //   666: aload_1
    //   667: aload_2
    //   668: aload_3
    //   669: aload 4
    //   671: lload 5
    //   673: lload 9
    //   675: aload 11
    //   677: aload 12
    //   679: lload 14
    //   681: iload 17
    //   683: aload 24
    //   685: aload 16
    //   687: invokespecial 422	aoou:a	(Lbdxt;Ljava/lang/String;Ljava/lang/String;Lbdxs;JJLjava/util/List;Ljava/util/ArrayList;JILmsf/msgcomm/msg_comm$Msg;Ljava/util/List;)V
    //   690: goto -681 -> 9
    //   693: return
    //   694: astore 22
    //   696: goto -51 -> 645
    //   699: astore 22
    //   701: goto -99 -> 602
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	aoou
    //   0	704	1	parambdxt	bdxt
    //   0	704	2	paramString1	String
    //   0	704	3	paramString2	String
    //   0	704	4	parambdxs	bdxs
    //   0	704	5	paramLong1	long
    //   0	704	7	paramLong2	long
    //   0	704	9	paramLong3	long
    //   0	704	11	paramList	List<SubAccountMessage>
    //   0	704	12	paramArrayList	ArrayList<String>
    //   0	704	13	paramHashMap	HashMap<String, Integer>
    //   0	704	14	paramLong4	long
    //   0	704	16	paramList1	List<msg_comm.Msg>
    //   0	704	17	paramInt	int
    //   0	704	18	parambcre	bcre
    //   57	289	19	i	int
    //   76	281	20	j	int
    //   630	3	21	bool	boolean
    //   221	366	22	localObject	Object
    //   597	6	22	localException1	Exception
    //   609	1	22	localList	List<msg_comm.Msg>
    //   640	18	22	localException2	Exception
    //   694	1	22	localException3	Exception
    //   699	1	22	localException4	Exception
    //   7	13	23	localIterator	Iterator
    //   29	655	24	localMsg	msg_comm.Msg
    //   47	496	25	localMsgHead	msg_comm.MsgHead
    // Exception table:
    //   from	to	target	type
    //   364	404	597	java/lang/Exception
    //   614	624	640	java/lang/Exception
    //   624	632	694	java/lang/Exception
    //   408	441	699	java/lang/Exception
  }
  
  private void a(bdxt parambdxt, String paramString1, String paramString2, bdxs parambdxs, long paramLong1, long paramLong2, List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, long paramLong3, int paramInt, msg_comm.Msg paramMsg, List<MessageRecord> paramList1)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    boolean bool1 = false;
    MessageRecord localMessageRecord = (MessageRecord)paramList1.get(0);
    long l = localMessageRecord.time;
    boolean bool3 = false;
    Iterator localIterator = paramList1.iterator();
    boolean bool2;
    do
    {
      bool2 = bool3;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList1 = (MessageRecord)localIterator.next();
    } while (paramList1 == null);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB mr=" + paramList1);
    }
    String str = paramList1.msg;
    if (str != null) {}
    label321:
    do
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  basemsg  = ");
        }
        if (paramList1.frienduin == null) {
          break;
        }
        if (String.valueOf(AppConstants.SYSTEM_MSG_UIN).equalsIgnoreCase(paramList1.frienduin))
        {
          bool2 = true;
          paramList1 = bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, paramList1.msgtype, paramList1.senderuin);
          if (paramList1 == null)
          {
            if (localStringBuffer.length() != 0) {
              break label321;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB show == null || show.length() == 0; msg is not decode success.");
            }
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          localStringBuffer.append(paramList1);
        }
        bool2 = bool1;
        if (paramList1.msgtype == -5004)
        {
          bool2 = bool1;
          if ((paramList1 instanceof MessageForPubAccount))
          {
            bool2 = bool1;
            if ("2010741172".equals(localMessageRecord.senderuin)) {
              bool2 = true;
            }
          }
        }
        str = g(paramList1, str);
        paramList1 = str;
        if (str == null) {
          paramList1 = "";
        }
        localStringBuffer.append(paramList1);
        bool1 = bool2;
      }
      break;
      a(paramList, paramArrayList, paramLong3, bool2);
      paramMsg = (msg_comm.MsgHead)paramMsg.msg_head.get();
      paramArrayList = null;
      paramList = paramArrayList;
      if (paramMsg != null)
      {
        paramList = paramArrayList;
        if (paramMsg.from_nick.has()) {
          paramList = paramMsg.from_nick.get();
        }
      }
      if (bool2) {
        paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719141);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "sub.account.msg isQQMail=" + bool1);
      }
      parambdxt.jdField_c_of_type_Boolean = true;
      a(parambdxs, paramLong1, paramLong2, paramLong3, paramInt, localStringBuffer, bool1, localMessageRecord, l, bool2, paramList);
      bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, 6);
      parambdxt.d = true;
      parambdxt = bcsa.a(localMessageRecord.msgtype);
      MessageRecord.copyMessageRecordBaseField(parambdxt, localMessageRecord);
      parambdxt.istroop = 7000;
      parambdxt.frienduin = paramString1;
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(parambdxt.frienduin, parambdxt.istroop);
      paramInt = 0;
      if (parambdxs != null) {
        paramInt = parambdxs.c(paramString1);
      }
      int j = paramInt - i;
      if (j != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(parambdxt.frienduin, parambdxt.istroop, j);
        if (parambdxs != null) {
          parambdxs.c(paramString1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "sub.account.msg conversion subUin=" + paramString1 + " target=" + paramInt + " old=" + i + " increase=" + j);
      }
      paramString1 = new ArrayList();
      paramString1.add(parambdxt);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(paramString1, paramString2, false, false, true);
    } while (bool1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.handleReceivedMessage(paramString1.size(), true, true);
  }
  
  private void a(bdxt parambdxt, String paramString1, String paramString2, msg_svc.PbGetMsgResp paramPbGetMsgResp, bdxs parambdxs, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, HashMap<String, Integer> paramHashMap)
  {
    paramPbGetMsgResp = paramPbGetMsgResp.uin_pair_msgs.get();
    int i = 0;
    if (i < paramPbGetMsgResp.size())
    {
      msg_comm.UinPairMsg localUinPairMsg = (msg_comm.UinPairMsg)paramPbGetMsgResp.get(i);
      long l1 = localUinPairMsg.peer_uin.get();
      long l2 = localUinPairMsg.last_read_time.get();
      List localList = localUinPairMsg.msg.get();
      if (!paramBoolean) {
        paramArrayList.add(Long.toString(l1));
      }
      int j = localUinPairMsg.unread_msg_num.get();
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUi cc n:" + l1);
      }
      if ((localList == null) || (localList.size() == 0) || (j == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB msgList == null || msgList.size() == 0 msg is null " + l1);
        }
        a(paramList, paramArrayList, paramHashMap, l1, j);
      }
      bcre localbcre;
      do
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + l1 + ",msgList size:" + localList.size());
        }
        localbcre = new bcre(paramLong2, l1, false, false, false, true);
      } while ((localList == null) || (localList.size() <= 0));
      Collections.sort(localList, new aoov(this));
      if ((localUinPairMsg.msg_completed.has()) && (localUinPairMsg.msg_completed.get() != 0)) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + l1 + "msgList size: " + localList.size() + ",uMsgCompleted:" + bool + ",lastReadTime:" + (l2 & 0xFFFFFFFF));
        }
        a(parambdxt, paramString1, paramString2, parambdxs, paramLong1, paramLong2, paramLong3, paramList, paramArrayList, paramHashMap, l1, localList, j, localbcre);
        break;
      }
    }
  }
  
  private void a(bdxt parambdxt, String paramString, msg_svc.PbGetMsgResp paramPbGetMsgResp, bdxs parambdxs, int paramInt)
  {
    parambdxt.jdField_a_of_type_Int = 1004;
    parambdxt.jdField_b_of_type_Int = paramInt;
    parambdxt.jdField_a_of_type_JavaLangString = paramPbGetMsgResp.errmsg.get();
    parambdxt.jdField_c_of_type_Boolean = true;
    bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, paramString);
    bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 6);
    parambdxt.d = true;
    parambdxs.a(paramString, null, true);
    boolean bool = parambdxs.a(paramString, 3);
    parambdxs.a(paramString, paramInt, paramPbGetMsgResp.errmsg.get());
    parambdxs.f(paramString);
    if (bool)
    {
      paramInt = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, 7000);
      if (paramInt != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(paramString, 7000, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setChangeAndNotify(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, paramString });
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "processSubAccountMessage() hint need to verify,msg num=1, subUin=" + paramString);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateSubAccountLogin(paramString, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().refreAccountList();
  }
  
  private void a(String paramString, bdxs parambdxs, boolean paramBoolean, long paramLong, List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, HashMap<String, Integer> paramHashMap)
  {
    if ((paramList != null) && (paramList.size() > 0) && (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handleGetSubC2CMessageResp_PB dbSubMsgList......");
      }
      int i = 0;
      if (i < paramList.size())
      {
        SubAccountMessage localSubAccountMessage = (SubAccountMessage)paramList.get(i);
        if ((localSubAccountMessage == null) || (localSubAccountMessage.frienduin == null)) {}
        for (;;)
        {
          i += 1;
          break;
          if ((!localSubAccountMessage.frienduin.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) && (!localSubAccountMessage.frienduin.equals(String.valueOf(13002L))))
          {
            int k = 0;
            Iterator localIterator = paramArrayList.iterator();
            String str;
            do
            {
              j = k;
              if (!localIterator.hasNext()) {
                break;
              }
              str = (String)localIterator.next();
            } while ((str == null) || (!localSubAccountMessage.frienduin.equalsIgnoreCase(str)));
            int j = 1;
            if ((j != 0) && (paramHashMap.containsKey(localSubAccountMessage.frienduin)) && (parambdxs != null)) {
              parambdxs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong), localSubAccountMessage.frienduin, ((Integer)paramHashMap.get(localSubAccountMessage.frienduin)).intValue());
            }
            if ((j == 0) && (parambdxs != null))
            {
              j = parambdxs.a(String.valueOf(paramLong), localSubAccountMessage.frienduin);
              if (j != 0)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().d(paramString, 7000, j);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setChangeAndNotify(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, paramString });
              }
            }
          }
        }
      }
    }
  }
  
  private void a(List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, long paramLong, boolean paramBoolean)
  {
    if ((paramList != null) && (!paramBoolean))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (SubAccountMessage)paramList.next();
        if (localObject != null)
        {
          localObject = ((SubAccountMessage)localObject).frienduin;
          if ((localObject != null) && (((String)localObject).equalsIgnoreCase(String.valueOf(paramLong)))) {
            paramArrayList.add(String.valueOf(paramLong));
          }
        }
      }
    }
  }
  
  private void a(List<SubAccountMessage> paramList, ArrayList<String> paramArrayList, HashMap<String, Integer> paramHashMap, long paramLong, int paramInt)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (SubAccountMessage)paramList.next();
        if (localObject != null)
        {
          localObject = ((SubAccountMessage)localObject).frienduin;
          if ((localObject != null) && (((String)localObject).equalsIgnoreCase(String.valueOf(paramLong))))
          {
            paramArrayList.add(String.valueOf(paramLong));
            paramHashMap.put(String.valueOf(paramLong), Integer.valueOf(paramInt));
          }
        }
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    paramMsg = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l1 = paramMsg.from_uin.get();
    long l2 = paramMsg.msg_time.get();
    long l3 = paramPbPushMsg.uint64_bind_uin.get();
    if (l1 == l3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountMessageProcessor", 2, new Object[] { "processSubAccountTroopMessage fromUin = bindUin:", Long.valueOf(l3), " fromUin:", Long.valueOf(l1), " msgTime:", Long.valueOf(l2) });
      }
      return;
    }
    paramMsg = new SubAccountMessage();
    paramMsg.frienduin = String.valueOf(13002L);
    paramMsg.unreadNum = 1;
    paramMsg.msgtype = -1000;
    paramMsg.time = l2;
    paramMsg.senderuin = String.valueOf(13002L);
    paramMsg.subUin = String.valueOf(l3);
    paramMsg.istroop = 1;
    paramMsg.sendername = anvx.a(2131719077);
    paramMsg.msg = "";
    paramPbPushMsg = (bdxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (paramPbPushMsg != null)
    {
      paramPbPushMsg.a(paramMsg);
      paramPbPushMsg.b(paramMsg);
      paramPbPushMsg.c(paramMsg.subUin);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, new Object[] { "processSubAccountTroopMessage bindUin:", Long.valueOf(l3), " fromUin:", Long.valueOf(l1), " msgTime:", Long.valueOf(l2) });
    }
    paramMsg = new bdxt();
    paramMsg.jdField_b_of_type_JavaLangString = paramFromServiceMsg.getUin();
    paramMsg.jdField_c_of_type_JavaLangString = String.valueOf(l3);
    paramMsg.jdField_c_of_type_Boolean = true;
    paramMsg.d = true;
    paramMsg.jdField_a_of_type_Int = 0;
    a(8003, true, paramMsg);
  }
  
  private void a(Oidb_0x5d0.RspBody paramRspBody, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    new aoow(this, paramRspBody, paramString2, paramString1, paramInt1, paramInt2).execute(new Void[0]);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 129) || (paramInt == 131) || (paramInt == 133) || (paramInt == 135) || (paramInt == 243);
  }
  
  private boolean a(bdxt parambdxt, long paramLong)
  {
    boolean bool = false;
    if (paramLong == -1L)
    {
      a(8003, false, parambdxt);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin == -1 ");
      }
      parambdxt = new HashMap();
      parambdxt.put("param_FailCode", "12014");
      parambdxt.put("fail_step", "selfUin_null");
      parambdxt.put("fail_location", "MessageHandler");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, parambdxt, "");
      bool = true;
    }
    return bool;
  }
  
  private boolean a(bdxt parambdxt, String paramString)
  {
    boolean bool = false;
    if (paramString == null)
    {
      a(8003, false, parambdxt);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB tmpBackUin == null ");
      }
      parambdxt = new HashMap();
      parambdxt.put("param_FailCode", "12014");
      parambdxt.put("fail_step", "backuin_null");
      parambdxt.put("fail_location", "MessageHandler");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, parambdxt, "");
      bool = true;
    }
    return bool;
  }
  
  private boolean a(bdxt parambdxt, String paramString, msg_svc.PbGetMsgResp paramPbGetMsgResp, bdxs parambdxs)
  {
    int i;
    if ((!paramPbGetMsgResp.result.has()) || (paramPbGetMsgResp.result.get() != 0))
    {
      i = paramPbGetMsgResp.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB rspResult = " + i);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", "12015");
      localHashMap.put("fail_step", "result_" + i);
      localHashMap.put("fail_location", "MessageHandler");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, localHashMap, "");
      if (i <= 100) {
        break label351;
      }
      i -= 100;
    }
    label351:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB really rspResult = " + i);
      }
      switch (i)
      {
      default: 
        if (b(i)) {
          a(parambdxt, paramString, paramPbGetMsgResp, parambdxs, i);
        }
        break;
      }
      for (;;)
      {
        a(8003, false, parambdxt);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB getMsgResp == null || !getMsgResp.result.has() || getMsgResp.result.get() != 0 ");
        }
        return true;
        parambdxt.jdField_a_of_type_Int = 1008;
        bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sub.uin.all");
        continue;
        parambdxt.jdField_a_of_type_Int = 1002;
        bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, paramString);
        bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        continue;
        parambdxt.jdField_a_of_type_Int = 1006;
        continue;
        parambdxt.jdField_a_of_type_Int = 1000;
      }
      return false;
    }
  }
  
  private boolean a(bdxt parambdxt, msg_svc.PbGetMsgResp paramPbGetMsgResp)
  {
    boolean bool = false;
    if (paramPbGetMsgResp == null)
    {
      paramPbGetMsgResp = new HashMap();
      paramPbGetMsgResp.put("param_FailCode", "12014");
      paramPbGetMsgResp.put("fail_step", "getmsgresp_null");
      paramPbGetMsgResp.put("fail_location", "MessageHandler");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBGetMsg", false, 0L, 0L, paramPbGetMsgResp, "");
      a(8003, false, parambdxt);
      bool = true;
    }
    return bool;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, bdxt parambdxt, byte paramByte, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramByte > 0) {
      if (paramLong > 0L)
      {
        paramToServiceMsg = paramToServiceMsg.extraData.getString("subaccount_a2");
        if (paramToServiceMsg != null)
        {
          a(paramByte, paramInt, String.valueOf(paramLong), paramToServiceMsg, paramArrayList);
          parambdxt.jdField_a_of_type_Boolean = false;
          a(8003, true, parambdxt);
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.e("SubAccountMessageProcessor", 2, "subaccount handleGetSubC2CMessageResp_PB error happen, binduin <= 0 from server");
      }
    }
    return false;
  }
  
  private boolean a(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((paramList.istroop == 1033) || (paramList.istroop == 1034)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(msg_comm.MsgHead paramMsgHead, int paramInt1, int paramInt2)
  {
    return (bcsc.c(paramInt1)) && (paramMsgHead.c2c_cmd.has()) && ((paramInt2 == 169) || (paramInt2 == 241) || (paramInt2 == 242) || (paramInt2 == 243) || (paramInt2 == 129) || (paramInt2 == 131) || (paramInt2 == 133));
  }
  
  private boolean a(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    return (paramOIDBSSOPkg == null) || (!paramOIDBSSOPkg.uint32_result.has()) || (!paramOIDBSSOPkg.bytes_bodybuffer.has()) || (paramOIDBSSOPkg.bytes_bodybuffer.get() == null) || (paramOIDBSSOPkg.uint32_service_type.get() != 1);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1;
    if (paramToServiceMsg == null) {
      str1 = "null";
    }
    for (;;)
    {
      String str2;
      label18:
      int i;
      long l;
      Object localObject2;
      msg_svc.PbBindUinMsgReadedConfirmResp localPbBindUinMsgReadedConfirmResp;
      Object localObject1;
      int j;
      if (paramToServiceMsg == null)
      {
        str2 = "null";
        i = -1;
        l = 0L;
        localObject2 = null;
        paramFromServiceMsg = null;
        localPbBindUinMsgReadedConfirmResp = new msg_svc.PbBindUinMsgReadedConfirmResp();
        localObject1 = localObject2;
        j = i;
      }
      try
      {
        paramObject = (msg_svc.PbBindUinMsgReadedConfirmResp)localPbBindUinMsgReadedConfirmResp.mergeFrom((byte[])paramObject);
        localObject1 = localObject2;
        j = i;
        i = paramObject.result.get();
        localObject1 = localObject2;
        j = i;
        if (paramObject.sync_cookie.has())
        {
          localObject1 = localObject2;
          j = i;
          paramFromServiceMsg = paramObject.sync_cookie.get().toByteArray();
        }
        localObject1 = paramFromServiceMsg;
        j = i;
        if (paramObject.bind_uin.has())
        {
          localObject1 = paramFromServiceMsg;
          j = i;
          l = paramObject.bind_uin.get();
        }
        localObject1 = paramFromServiceMsg;
        j = i;
        if (paramObject.errmsg.has())
        {
          localObject1 = paramFromServiceMsg;
          j = i;
          paramObject = paramObject.errmsg.get();
          localObject2 = paramObject;
          localObject1 = paramFromServiceMsg;
          j = i;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder().append("handleConfirmSubAccountMsgNumReaded() subUin=").append(str2).append(" lSubUin=").append(l).append(" errMsg=").append(paramObject).append(" cookie=");
              if (paramFromServiceMsg == null)
              {
                localObject1 = "null";
                QLog.d("SUB_ACCOUNT", 2, localObject1);
                j = i;
                localObject1 = paramFromServiceMsg;
                localObject2 = paramObject;
              }
            }
            else
            {
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = new StringBuilder().append("handleConfirmSubAccountMsgNumReaded() ssoSeq:");
                if (paramToServiceMsg != null) {
                  continue;
                }
                paramToServiceMsg = "null";
                paramFromServiceMsg = paramFromServiceMsg.append(paramToServiceMsg).append(" result=").append(j).append(" syncCookie=");
                if (localObject1 != null) {
                  continue;
                }
                paramToServiceMsg = "null";
                QLog.d("SUB_ACCOUNT", 2, paramToServiceMsg + " errms=" + String.valueOf(localObject2));
              }
              boolean bool = false;
              if (j == 0)
              {
                paramToServiceMsg = (bdxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
                if (paramToServiceMsg != null) {
                  paramToServiceMsg.a(str2, (byte[])localObject1);
                }
                bool = true;
              }
              a(8011, bool, new String[] { str2, str1 });
              return;
              str1 = paramToServiceMsg.extraData.getString("nextAction");
              break;
              str2 = paramToServiceMsg.extraData.getString("subAccount");
              break label18;
            }
            j = paramFromServiceMsg.length;
            localObject1 = Integer.valueOf(j);
            continue;
            localException1 = localException1;
            paramObject = null;
            i = j;
            paramFromServiceMsg = (FromServiceMsg)localObject1;
          }
          catch (Exception localException2)
          {
            continue;
          }
          localObject2 = paramObject;
          localObject1 = paramFromServiceMsg;
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.e("SUB_ACCOUNT", 2, "handleConfirmSubAccountMsgNumReaded() decode pb:", localException1);
            localObject2 = paramObject;
            localObject1 = paramFromServiceMsg;
            j = i;
            continue;
            paramToServiceMsg = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
            continue;
            paramToServiceMsg = Integer.toString(localObject1.length);
            continue;
            paramObject = null;
          }
        }
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == 1200) || (paramInt == 1214) || (paramInt == 1215) || (paramInt == 1218) || (paramInt == 1232) || (paramInt == 1233) || (paramInt == 1240) || (paramInt == 1241) || (paramInt == 1242) || (paramInt == 1221);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bdxt localbdxt = new bdxt();
    String str1 = paramToServiceMsg.extraData.getString("subAccount");
    String str2 = paramToServiceMsg.getUin();
    localbdxt.jdField_b_of_type_JavaLangString = str2;
    localbdxt.jdField_c_of_type_JavaLangString = str1;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd= CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handleGetSubC2CMessageResp_PB subUin=" + str1);
    }
    Object localObject1 = new msg_svc.PbGetMsgResp();
    msg_svc.PbGetMsgResp localPbGetMsgResp = a((byte[])paramObject, (msg_svc.PbGetMsgResp)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("subaccount <---handleGetSubC2CMessageResp_PB ssoSeq:");
      if (paramToServiceMsg == null)
      {
        paramObject = "null";
        localObject1 = ((StringBuilder)localObject1).append(paramObject).append(" msgStruct.cReplyCode: ");
        if (localPbGetMsgResp != null) {
          break label234;
        }
        paramObject = "null";
        label150:
        localObject1 = ((StringBuilder)localObject1).append(paramObject).append(",hasSyncCookie:");
        if (localPbGetMsgResp != null) {
          break label249;
        }
        paramObject = "null";
        label173:
        localObject1 = ((StringBuilder)localObject1).append(paramObject).append(",syncFlag:");
        if (localPbGetMsgResp != null) {
          break label264;
        }
        paramObject = "null";
        label196:
        QLog.d("SUB_ACCOUNT", 2, paramObject);
      }
    }
    else
    {
      if (!a(localbdxt, localPbGetMsgResp)) {
        break label279;
      }
    }
    label234:
    label249:
    bdxs localbdxs;
    label264:
    label279:
    long l3;
    long l1;
    long l2;
    for (;;)
    {
      return;
      paramObject = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
      break;
      paramObject = Integer.valueOf(localPbGetMsgResp.result.get());
      break label150;
      paramObject = Boolean.valueOf(localPbGetMsgResp.sync_cookie.has());
      break label173;
      paramObject = Integer.valueOf(localPbGetMsgResp.sync_flag.get());
      break label196;
      localbdxs = (bdxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      if (!a(localbdxt, str1, localPbGetMsgResp, localbdxs))
      {
        localbdxs.a(str1, 1);
        paramObject = paramFromServiceMsg.getUin();
        l3 = -1L;
        l1 = -1L;
        try
        {
          l2 = Long.parseLong(str1);
          l1 = l2;
          if (a(localbdxt, paramObject)) {}
        }
        catch (Exception localException)
        {
          try
          {
            l2 = Long.valueOf(paramFromServiceMsg.getUin()).longValue();
            if (!a(localbdxt, l2)) {
              if (!localbdxs.a())
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("SUB_ACCOUNT", 2, "processSubAccountMessage return as notify off");
                return;
                localException = localException;
                localException.printStackTrace();
                QLog.d("SUB_ACCOUNT", 1, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB subAccount parselong error ");
              }
            }
          }
          catch (Exception paramFromServiceMsg)
          {
            for (;;)
            {
              l2 = l3;
              if (QLog.isColorLevel())
              {
                QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin parselong error ");
                l2 = l3;
              }
            }
          }
        }
      }
    }
    if (localPbGetMsgResp.sync_cookie.has()) {}
    for (paramFromServiceMsg = localPbGetMsgResp.sync_cookie.get().toByteArray();; paramFromServiceMsg = null)
    {
      boolean bool = true;
      if (localPbGetMsgResp.sync_flag.has()) {}
      for (int i = localPbGetMsgResp.sync_flag.get();; i = 2)
      {
        byte b;
        if (i < 2)
        {
          b = (byte)1;
          bool = false;
        }
        for (;;)
        {
          l3 = 0L;
          if (localPbGetMsgResp.bind_uin.has()) {
            l3 = localPbGetMsgResp.bind_uin.get();
          }
          List localList = localbdxs.a(Long.toString(l3));
          Object localObject2 = paramToServiceMsg.extraData.getStringArrayList("hadGetMsgListUin");
          paramObject = localObject2;
          if (localObject2 == null) {
            paramObject = new ArrayList();
          }
          localObject2 = new HashMap();
          a(localbdxt, str1, str2, localPbGetMsgResp, localbdxs, l2, l1, bool, l3, localList, paramObject, (HashMap)localObject2);
          a(str1, localbdxs, bool, l3, localList, paramObject, (HashMap)localObject2);
          localbdxs.a(str1, paramFromServiceMsg);
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("param_FailCode", "12016");
          paramFromServiceMsg.put("fail_step", "success");
          paramFromServiceMsg.put("fail_location", "MessageHandler");
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBGetMsg", true, 0L, 0L, paramFromServiceMsg, "");
          if (a(paramToServiceMsg, localbdxt, b, i, l3, paramObject)) {
            break;
          }
          localbdxt.jdField_a_of_type_Int = 0;
          a(8003, true, localbdxt);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB end");
          return;
          b = 0;
        }
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {}
    Object localObject;
    label181:
    String str;
    int i;
    int j;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare() req = " + paramToServiceMsg);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare() resultCode = " + paramFromServiceMsg.getResultCode() + " isSuccess = " + paramFromServiceMsg.isSuccess() + " resp = " + paramFromServiceMsg);
          }
          localObject = new oidb_sso.OIDBSSOPkg();
          try
          {
            localObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
            if (!a((oidb_sso.OIDBSSOPkg)localObject)) {
              break label181;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare ssoPkg check error");
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare ssoPkg.mergeFrom exception");
      return;
      paramObject = new Oidb_0x5d0.RspBody();
      try
      {
        paramObject.mergeFrom(((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get().toByteArray());
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare  contentItem.size=" + paramObject.rpt_msg_contentItem.size());
        }
        localObject = String.valueOf(paramObject.uint64_uin.get());
        paramToServiceMsg = String.valueOf(paramToServiceMsg.getAttribute("subaccount"));
        str = paramFromServiceMsg.getUin();
        i = paramObject.uint32_sys_time.get();
        j = paramObject.uint32_advise_gap.get();
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare  contentItem.size=" + paramObject.rpt_msg_contentItem.get().size() + "  rspBody.uin=" + String.valueOf(paramObject.uint64_uin.get()) + "  resp.getUin()=" + paramFromServiceMsg.getUin() + "  sysTime=" + i + " adviseGap=" + j);
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"0".equals(localObject)) && (TextUtils.equals((CharSequence)localObject, paramToServiceMsg)) && (TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))) {
          break;
        }
        QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare req or resp params error");
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SubAccountMessageProcessor", 2, "handleGetSubAccountSpecialCare  rspBody==null");
    return;
    a(paramObject, (String)localObject, str, i, j);
  }
  
  private String g(MessageRecord paramMessageRecord, String paramString)
  {
    switch (paramMessageRecord.msgtype)
    {
    default: 
      paramString = e(paramMessageRecord, paramString);
    }
    do
    {
      return paramString;
      return a(paramMessageRecord, paramString);
      return b(paramMessageRecord, paramString);
      return c(paramMessageRecord, paramString);
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691258);
      return f(paramMessageRecord, paramString);
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131718981);
      paramMessageRecord = (MessageForApollo)paramMessageRecord;
      paramMessageRecord.parse();
      return ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
      return d(paramMessageRecord, paramString);
    } while (!(paramMessageRecord instanceof MessageForArkBabyqReply));
    paramMessageRecord = (MessageForArkBabyqReply)paramMessageRecord;
    paramMessageRecord.parse();
    return paramMessageRecord.babyqReplyText;
  }
  
  String a(MessageRecord paramMessageRecord, String paramString)
  {
    String str = paramString;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      str = paramString;
      if (paramMessageRecord.structingMsg != null) {
        str = paramMessageRecord.structingMsg.mMsgBrief;
      }
    }
    paramMessageRecord = str;
    if (TextUtils.isEmpty(str)) {
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131719074);
    }
    return paramMessageRecord;
  }
  
  public void a(byte paramByte, int paramInt, String paramString1, String paramString2, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() start, subUin=" + paramString1);
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("MessageSvc.PbBindUinGetMsg");
    localToServiceMsg.extraData.putByte("cChannel", paramByte);
    localToServiceMsg.extraData.putInt("cSyncFlag", paramInt);
    localToServiceMsg.extraData.putBoolean("isSubAccount", true);
    localToServiceMsg.extraData.putString("subAccount", paramString1);
    localToServiceMsg.extraData.putString("subaccount_a2", paramString2);
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localToServiceMsg.extraData.putStringArrayList("hadGetMsgListUin", paramArrayList);
    }
    paramArrayList = (bdxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (paramArrayList != null) {}
    for (paramArrayList = paramArrayList.a(paramString1);; paramArrayList = null)
    {
      msg_svc.PbBindUinGetMsgReq localPbBindUinGetMsgReq = new msg_svc.PbBindUinGetMsgReq();
      if (paramString1 != null) {}
      try
      {
        localPbBindUinGetMsgReq.bind_uin.set(Long.parseLong(paramString1));
        if (paramString2 == null) {}
      }
      catch (Exception paramString1)
      {
        try
        {
          do
          {
            localPbBindUinGetMsgReq.bind_uin_sig.set(ByteStringMicro.copyFrom(PkgTools.hexToBytes(paramString2)));
            if (paramArrayList == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie=" + paramArrayList.length);
            }
            localPbBindUinGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
            localPbBindUinGetMsgReq.sync_flag.set(paramInt);
            localToServiceMsg.putWupBuffer(localPbBindUinGetMsgReq.toByteArray());
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq(localToServiceMsg);
            return;
            paramString1 = paramString1;
            paramString1.printStackTrace();
          } while (!QLog.isColorLevel());
          QLog.e("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() subAccount is null or not a long");
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie = null");
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processError");
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountError end");
    }
    paramFromServiceMsg = new bdxt();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.jdField_b_of_type_JavaLangString = paramToServiceMsg.getUin();
    paramFromServiceMsg.jdField_c_of_type_JavaLangString = str;
    paramFromServiceMsg.jdField_a_of_type_Int = 1001;
    a(8003, false, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processResponse");
    }
    switch (paramInt)
    {
    }
    argg localargg;
    do
    {
      do
      {
        return;
        if ((paramVarArgs != null) && (paramVarArgs.length == 3))
        {
          c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
          return;
        }
        a(getClass().getName(), paramInt);
        return;
        if ((paramVarArgs != null) && (paramVarArgs.length == 3))
        {
          b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
          return;
        }
        a(getClass().getName(), paramInt);
        return;
        if ((paramVarArgs != null) && (paramVarArgs.length == 3))
        {
          d((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd=CMD_MESSAGESERVICE_SUBACCOUNT_SPECIAL_CARE GetSubAccountSpecialCare error");
      return;
      localargg = (argg)aqxe.a().a(607);
    } while ((localargg == null) || (localargg.jdField_a_of_type_Boolean));
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
      return;
    }
    b(getClass().getName(), paramInt);
  }
  
  public void a(RequestPushNotify paramRequestPushNotify)
  {
    Object localObject = paramRequestPushNotify.stMsgInfo;
    if (528 == ((MsgInfo)localObject).shMsgType)
    {
      localObject = acnk.a(((MsgInfo)localObject).vMsg);
      if ((localObject != null) && (((MsgType0x210)localObject).vProtobuf != null)) {
        break label35;
      }
    }
    label35:
    do
    {
      do
      {
        return;
      } while ((((MsgType0x210)localObject).uSubMsgType != 138L) && (((MsgType0x210)localObject).uSubMsgType != 139L));
      Submsgtype0x8a.ReqBody localReqBody = new Submsgtype0x8a.ReqBody();
      try
      {
        localReqBody.mergeFrom(((MsgType0x210)localObject).vProtobuf);
        bctj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localReqBody, paramRequestPushNotify.lBindedUin, true);
        return;
      }
      catch (Exception paramRequestPushNotify) {}
    } while (!QLog.isColorLevel());
    QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b sub account msg, prase reqBody error");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumTimeOut");
    }
    paramToServiceMsg = new bdxu();
    paramToServiceMsg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    paramToServiceMsg.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(8024, false, paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    Object localObject = new msg_svc.PbUnReadMsgSeqResp();
    try
    {
      paramObject = (msg_svc.PbUnReadMsgSeqResp)((msg_svc.PbUnReadMsgSeqResp)localObject).mergeFrom((byte[])paramObject);
      if ((!paramObject.thirdqq_unread_info.has()) || (paramObject.thirdqq_unread_info.get() == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: server did not return thirdqq_unread_info");
        }
        b(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: server did not return a valid response");
      }
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramObject = (msg_svc.PbThirdQQUnReadMsgNumResp)paramObject.thirdqq_unread_info.get();
    if ((paramObject.result.get() != 0) || (paramObject.thirdqq_resp_info.get() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB unreadNumSeqResp.result: " + paramObject.result.get() + " ,unreadNumSeqResp.errmsg: " + paramObject.errmsg.get() + " or thirdqq_resp_info is null");
      }
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramFromServiceMsg = new bdxu();
    int i = paramObject.result.get();
    localObject = paramObject.errmsg.get();
    int j = paramObject.interval.get();
    paramFromServiceMsg.c = j;
    paramFromServiceMsg.jdField_b_of_type_JavaLangString = ((String)localObject);
    paramFromServiceMsg.jdField_b_of_type_Int = i;
    paramToServiceMsg = paramToServiceMsg.extraData.getString("mainAccount");
    paramFromServiceMsg.jdField_a_of_type_JavaLangString = paramToServiceMsg;
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: result  interval=" + j + " errmsg=" + (String)localObject + " result=" + i);
    }
    long l = bcrg.a();
    i = 0;
    while (i < paramObject.thirdqq_resp_info.get().size())
    {
      localObject = (msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)paramObject.thirdqq_resp_info.get().get(i);
      String str = String.valueOf(((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).third_uin.get());
      byte[] arrayOfByte = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).third_uin_cookie.get().toByteArray();
      int k = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).msg_num.get();
      int m = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).msg_flag.get();
      int n = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).redbag_time.get();
      int i1 = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).status.get();
      int i2 = ((msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo)localObject).last_msg_time.get();
      if ((paramFromServiceMsg.d < i2) && (i2 <= l)) {
        paramFromServiceMsg.d = i2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumResp_PB: thirdUin=" + str + " num=" + k + " flag=" + m + " redbagtime=" + n + " status=" + i1 + " lastmsgtime=" + i2 + "  cookie=" + arrayOfByte);
      }
      bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, str, arrayOfByte, k, m, n, i1, i2);
      i += 1;
    }
    bdxj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, j);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(8024, true, paramFromServiceMsg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() subAccount=" + paramString1);
    }
    long l;
    try
    {
      l = Long.parseLong(paramString1);
      if (l <= 10000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() return, lSubUin=" + l);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        l = 0L;
      }
      localObject = (bdxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      if (localObject == null) {}
    }
    for (Object localObject = ((bdxs)localObject).a(paramString1);; localObject = null)
    {
      ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("PbMessageSvc.PbBindUinMsgReadedConfirm");
      localToServiceMsg.extraData.putBoolean("isSubAccount", true);
      localToServiceMsg.extraData.putString("subAccount", paramString1);
      localToServiceMsg.extraData.putString("nextAction", paramString2);
      paramString1 = new msg_svc.PbBindUinMsgReadedConfirmReq();
      paramString1.bind_uin.set(l);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  syncCookie=" + Integer.toString(localObject.length));
        }
        paramString1.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      for (;;)
      {
        localToServiceMsg.putWupBuffer(paramString1.toByteArray());
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq(localToServiceMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  cookie = null");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, ArrayList<SimpleAccount> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("getThirdQQUnreadMsgNum_PB isCronJob = ").append(paramBoolean).append(" thirdAccount size = ");
      if (paramArrayList != null) {
        break label110;
      }
    }
    label110:
    for (int i = 0;; i = paramArrayList.size())
    {
      QLog.d("SubAccountMessageProcessor", 2, i);
      if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
        break;
      }
      paramArrayList = new bdxu();
      paramArrayList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error no third account");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(8024, false, paramArrayList);
      return;
    }
    TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    WtloginManager localWtloginManager = (WtloginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(1);
    Object localObject1 = new msg_svc.PbUnReadMsgSeqReq();
    msg_svc.PbThirdQQUnReadMsgNumReq localPbThirdQQUnReadMsgNumReq = new msg_svc.PbThirdQQUnReadMsgNumReq();
    long l1 = bcrg.a();
    if ((localTicketManager != null) && (localWtloginManager != null))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject2 = (SimpleAccount)paramArrayList.next();
        if (localObject2 != null)
        {
          try
          {
            msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo localThirdQQReqInfo = new msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo();
            localObject2 = ((SimpleAccount)localObject2).getUin();
            Object localObject3 = localTicketManager.getA2((String)localObject2);
            if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty(((String)localObject3).trim()))) {
              continue;
            }
            Ticket localTicket = localWtloginManager.getLocalTicket((String)localObject2, 16L, 64);
            if ((localTicket == null) || (l1 > localTicket._expire_time)) {
              continue;
            }
            long l2 = Long.parseLong((String)localObject2);
            localThirdQQReqInfo.third_uin.set(l2);
            localThirdQQReqInfo.third_uin_sig.set(ByteStringMicro.copyFrom(PkgTools.hexToBytes((String)localObject3)));
            localObject3 = bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
            if (localObject3 != null) {
              localThirdQQReqInfo.third_uin_cookie.set(ByteStringMicro.copyFrom((byte[])localObject3));
            }
            if (QLog.isColorLevel()) {
              QLog.d("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB third uin = " + (String)localObject2);
            }
            localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.add(localThirdQQReqInfo);
          }
          catch (NumberFormatException localNumberFormatException) {}
          if (QLog.isColorLevel()) {
            QLog.e("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error " + localNumberFormatException.getMessage());
          }
        }
      }
    }
    if ((!localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.has()) || (localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.get() == null) || (localPbThirdQQUnReadMsgNumReq.thirdqq_req_info.get().size() == 0))
    {
      paramArrayList = new bdxu();
      paramArrayList.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      if (QLog.isColorLevel()) {
        QLog.e("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB error no third qq info");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(8024, false, paramArrayList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "getThirdQQUnreadMsgNum_PB really send msg to service");
    }
    paramArrayList = localPbThirdQQUnReadMsgNumReq.source;
    if (paramBoolean) {}
    for (i = 1;; i = 2)
    {
      paramArrayList.set(i);
      ((msg_svc.PbUnReadMsgSeqReq)localObject1).thirdqq_unread_info.set(localPbThirdQQUnReadMsgNumReq);
      paramArrayList = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "PbMessageSvc.PbUnReadMsgSeq");
      paramArrayList.extraData.putString("action", "getThirdQQUnreadNum");
      paramArrayList.extraData.putString("mainAccount", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      paramArrayList.putWupBuffer(((msg_svc.PbUnReadMsgSeqReq)localObject1).toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq(paramArrayList);
      return;
    }
  }
  
  public boolean a(SubAccountInfo paramSubAccountInfo)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "getSubAccountSpecialCareList()");
    }
    if ((paramSubAccountInfo == null) || (TextUtils.isEmpty(paramSubAccountInfo.subuin))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      Object localObject1 = new Oidb_0x5d0.ReqBody();
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(Integer.valueOf(9));
      ((Oidb_0x5d0.ReqBody)localObject1).rpt_uint32_fieldlist.set((List)localObject2);
      ((Oidb_0x5d0.ReqBody)localObject1).uint32_start_time.set(bdxj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramSubAccountInfo.subuin));
      try
      {
        long l = Long.parseLong(paramSubAccountInfo.subuin);
        ((Oidb_0x5d0.ReqBody)localObject1).uint64_bind_uin.set(l);
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1488);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d0.ReqBody)localObject1).toByteArray()));
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "getSubAccountSpecialCareList() uin = " + paramSubAccountInfo.subuin);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.createToServiceMsg("OidbSvc.0x5d0_1");
        ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
        ((ToServiceMsg)localObject1).setTimeout(60000L);
        ((ToServiceMsg)localObject1).addAttribute("from_where", "subaccount");
        ((ToServiceMsg)localObject1).addAttribute("subaccount", paramSubAccountInfo.subuin);
        if (QLog.isColorLevel()) {
          QLog.d("SubAccountMessageProcessor", 2, "getSubAccountSpecialCareList() before send request = " + localObject1);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.sendPbReq((ToServiceMsg)localObject1);
        if (QLog.isColorLevel())
        {
          QLog.d("SubAccountMessageProcessor", 2, "getSubAccountSpecialCareList() after send request = " + localObject1);
          return true;
        }
      }
      catch (NumberFormatException paramSubAccountInfo)
      {
        paramSubAccountInfo.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "getSubAccountSpecialCareList subAccount parselong error ");
        }
      }
    }
    return false;
  }
  
  String b(MessageRecord paramMessageRecord, String paramString)
  {
    if (anud.a(paramMessageRecord)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691254);
    }
    if ((paramMessageRecord instanceof MessageForPic)) {
      return ((MessageForPic)paramMessageRecord).getSummaryMsg();
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691257);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageProcessor processTimeOut");
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountTimeout end");
    }
    paramFromServiceMsg = new bdxt();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.jdField_b_of_type_JavaLangString = paramToServiceMsg.getUin();
    paramFromServiceMsg.jdField_c_of_type_JavaLangString = str;
    paramFromServiceMsg.jdField_a_of_type_Int = 1007;
    a(8003, false, paramFromServiceMsg);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "handleGetThirdQQUnreadMsgNumError");
    }
    paramToServiceMsg = new bdxu();
    paramToServiceMsg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.notifyUI(8024, false, paramToServiceMsg);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, "subaccount handleGetSubAccountTroop error");
    }
  }
  
  String c(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = paramMessageRecord.msg;
    paramString = null;
    paramMessageRecord = paramString;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("/");
        paramMessageRecord = paramString;
        if (localObject != null)
        {
          paramMessageRecord = paramString;
          if (localObject.length > 0)
          {
            localObject = localObject[(localObject.length - 1)].split("\\|");
            paramMessageRecord = paramString;
            if (localObject != null)
            {
              paramMessageRecord = paramString;
              if (localObject.length > 0) {
                paramMessageRecord = localObject[0];
              }
            }
          }
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      do
      {
        for (;;)
        {
          paramMessageRecord.printStackTrace();
          paramMessageRecord = paramString;
        }
        paramString = paramMessageRecord;
      } while (paramMessageRecord.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691253)));
    }
    if (TextUtils.isEmpty(paramMessageRecord))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691253);
      return paramString;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691253) + paramMessageRecord;
  }
  
  String d(MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForPubAccount)) {}
    for (;;)
    {
      try
      {
        paramString = ((MessageForPubAccount)paramMessageRecord).mPAMessage;
        if (paramString == null) {
          return null;
        }
        paramMessageRecord = ((PAMessage.Item)paramString.items.get(0)).title;
        if ((((PAMessage.Item)paramString.items.get(0)).cover != null) || (((PAMessage.Item)paramString.items.get(0)).digestList == null)) {
          continue;
        }
        paramMessageRecord = paramMessageRecord + "：" + (String)((PAMessage.Item)paramString.items.get(0)).digestList.get(0);
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + paramMessageRecord.getMessage());
        paramMessageRecord = null;
        continue;
      }
      return paramMessageRecord;
      continue;
      paramMessageRecord = paramString;
    }
  }
  
  String e(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject;
    try
    {
      if (bhca.a(paramMessageRecord.msgtype))
      {
        paramMessageRecord = bhca.a(paramMessageRecord.msg);
        localObject = paramString;
        if (paramMessageRecord != null)
        {
          if ((paramMessageRecord.actMsgContentValue != null) && (paramMessageRecord.actMsgContentValue.length() > 0)) {
            return paramMessageRecord.actMsgContentValue;
          }
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(bhch.a(paramMessageRecord.shareAppID));
          paramString = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690122));
          if (paramMessageRecord == null) {}
          for (paramMessageRecord = "";; paramMessageRecord = paramMessageRecord.messagetail + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690123)) {
            return paramMessageRecord;
          }
        }
      }
      else
      {
        localObject = paramString;
        if (!bhca.b(paramMessageRecord.msgtype))
        {
          localObject = paramString;
          if (paramMessageRecord.msg != null)
          {
            localObject = paramString;
            if (paramMessageRecord.msg.indexOf("http://maps.google.com/maps?q=") != -1)
            {
              localObject = bcsc.a(paramMessageRecord.msg);
              paramString = "";
              paramMessageRecord = paramString;
              if (localObject != null)
              {
                paramMessageRecord = paramString;
                if (localObject[2] != null) {
                  paramMessageRecord = localObject[2];
                }
              }
              paramMessageRecord = "[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131719444) + "] " + paramMessageRecord;
              return paramMessageRecord;
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      paramMessageRecord = null;
      paramString.printStackTrace();
      localObject = paramMessageRecord;
      if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + paramString.getMessage());
        localObject = paramMessageRecord;
      }
    }
    return localObject;
  }
  
  String f(MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForMarketFace))
    {
      paramMessageRecord = ((MessageForMarketFace)paramMessageRecord).mMarkFaceMessage;
      if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.faceName))) {
        return "[" + paramMessageRecord.faceName + "]";
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691876);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoou
 * JD-Core Version:    0.7.0.1
 */