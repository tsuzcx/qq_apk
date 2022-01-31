import ActionMsg.MsgBody;
import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import PushNotifyPack.RequestPushNotify;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPubAccount;
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
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbBindUinGetMsgReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmResp;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumReq.ThirdQQReqInfo;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp;
import msf.msgsvc.msg_svc.PbThirdQQUnReadMsgNumResp.ThirdQQRespInfo;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqReq;
import msf.msgsvc.msg_svc.PbUnReadMsgSeqResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import oicq.wlogin_sdk.request.Ticket;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.ReqBody;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class amll
  extends absu
{
  public amll(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
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
    paramMsg.sendername = alud.a(2131720450);
    paramMsg.msg = "";
    paramPbPushMsg = (badd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
    if (paramPbPushMsg != null)
    {
      paramPbPushMsg.a(paramMsg);
      paramPbPushMsg.b(paramMsg);
      paramPbPushMsg.c(paramMsg.subUin);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubAccountMessageProcessor", 2, new Object[] { "processSubAccountTroopMessage bindUin:", Long.valueOf(l3), " fromUin:", Long.valueOf(l1), " msgTime:", Long.valueOf(l2) });
    }
    paramMsg = new bade();
    paramMsg.jdField_b_of_type_JavaLangString = paramFromServiceMsg.getUin();
    paramMsg.jdField_c_of_type_JavaLangString = String.valueOf(l3);
    paramMsg.jdField_c_of_type_Boolean = true;
    paramMsg.d = true;
    paramMsg.jdField_a_of_type_Int = 0;
    a(8003, true, paramMsg);
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
      label16:
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
                paramToServiceMsg = (badd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
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
              break label16;
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
  
  /* Error */
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: new 148	bade
    //   3: dup
    //   4: invokespecial 149	bade:<init>	()V
    //   7: astore 29
    //   9: aload_1
    //   10: getfield 269	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   13: ldc_w 279
    //   16: invokevirtual 277	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 30
    //   21: aload_1
    //   22: invokevirtual 296	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   25: astore 31
    //   27: aload 29
    //   29: aload 31
    //   31: putfield 157	bade:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   34: aload 29
    //   36: aload 30
    //   38: putfield 159	bade:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   44: ifeq +30 -> 74
    //   47: ldc 237
    //   49: iconst_2
    //   50: new 219	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 298
    //   60: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload 30
    //   65: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: new 300	msf/msgsvc/msg_svc$PbGetMsgResp
    //   77: dup
    //   78: invokespecial 301	msf/msgsvc/msg_svc$PbGetMsgResp:<init>	()V
    //   81: astore 26
    //   83: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +20 -> 106
    //   89: ldc_w 303
    //   92: iconst_2
    //   93: aload_3
    //   94: checkcast 179	[B
    //   97: checkcast 179	[B
    //   100: invokestatic 308	bdhe:a	([B)Ljava/lang/String;
    //   103: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload 26
    //   108: aload_3
    //   109: checkcast 179	[B
    //   112: checkcast 179	[B
    //   115: invokevirtual 309	msf/msgsvc/msg_svc$PbGetMsgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   118: checkcast 300	msf/msgsvc/msg_svc$PbGetMsgResp
    //   121: astore_3
    //   122: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +111 -> 236
    //   128: new 219	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 311
    //   138: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: astore 27
    //   143: aload_1
    //   144: ifnonnull +195 -> 339
    //   147: ldc 174
    //   149: astore 26
    //   151: aload 27
    //   153: aload 26
    //   155: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: ldc_w 313
    //   161: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: astore 27
    //   166: aload_3
    //   167: ifnonnull +184 -> 351
    //   170: ldc 174
    //   172: astore 26
    //   174: aload 27
    //   176: aload 26
    //   178: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: ldc_w 315
    //   184: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: astore 27
    //   189: aload_3
    //   190: ifnonnull +176 -> 366
    //   193: ldc 174
    //   195: astore 26
    //   197: aload 27
    //   199: aload 26
    //   201: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   204: ldc_w 317
    //   207: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: astore 27
    //   212: aload_3
    //   213: ifnonnull +168 -> 381
    //   216: ldc 174
    //   218: astore 26
    //   220: ldc 237
    //   222: iconst_2
    //   223: aload 27
    //   225: aload 26
    //   227: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_3
    //   237: ifnonnull +159 -> 396
    //   240: new 319	java/util/HashMap
    //   243: dup
    //   244: invokespecial 320	java/util/HashMap:<init>	()V
    //   247: astore_1
    //   248: aload_1
    //   249: ldc_w 322
    //   252: ldc_w 324
    //   255: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   258: pop
    //   259: aload_1
    //   260: ldc_w 330
    //   263: ldc_w 332
    //   266: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   269: pop
    //   270: aload_1
    //   271: ldc_w 334
    //   274: ldc_w 336
    //   277: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   280: pop
    //   281: invokestatic 342	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   284: invokestatic 347	azri:a	(Landroid/content/Context;)Lazri;
    //   287: aload_0
    //   288: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   291: invokevirtual 350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   294: ldc_w 352
    //   297: iconst_0
    //   298: lconst_0
    //   299: lconst_0
    //   300: aload_1
    //   301: ldc 123
    //   303: invokevirtual 355	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   306: aload_0
    //   307: sipush 8003
    //   310: iconst_0
    //   311: aload 29
    //   313: invokevirtual 169	amll:a	(IZLjava/lang/Object;)V
    //   316: return
    //   317: astore_3
    //   318: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +13 -> 334
    //   324: ldc 58
    //   326: iconst_2
    //   327: ldc_w 357
    //   330: aload_3
    //   331: invokestatic 290	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   334: aconst_null
    //   335: astore_3
    //   336: goto -214 -> 122
    //   339: aload_1
    //   340: invokevirtual 293	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   343: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: astore 26
    //   348: goto -197 -> 151
    //   351: aload_3
    //   352: getfield 358	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   358: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   361: astore 26
    //   363: goto -189 -> 174
    //   366: aload_3
    //   367: getfield 359	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   370: invokevirtual 195	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   373: invokestatic 364	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   376: astore 26
    //   378: goto -181 -> 197
    //   381: aload_3
    //   382: getfield 368	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   385: invokevirtual 371	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   388: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   391: astore 26
    //   393: goto -173 -> 220
    //   396: aload_0
    //   397: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   400: bipush 61
    //   402: invokevirtual 132	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   405: checkcast 134	badd
    //   408: astore 32
    //   410: aload_3
    //   411: getfield 358	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   414: invokevirtual 372	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   417: ifeq +13 -> 430
    //   420: aload_3
    //   421: getfield 358	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   424: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   427: ifeq +619 -> 1046
    //   430: aload_3
    //   431: getfield 358	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   434: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   437: istore 5
    //   439: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +30 -> 472
    //   445: ldc 237
    //   447: iconst_2
    //   448: new 219	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   455: ldc_w 374
    //   458: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: iload 5
    //   463: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   466: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   472: new 319	java/util/HashMap
    //   475: dup
    //   476: invokespecial 320	java/util/HashMap:<init>	()V
    //   479: astore_1
    //   480: aload_1
    //   481: ldc_w 322
    //   484: ldc_w 376
    //   487: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   490: pop
    //   491: aload_1
    //   492: ldc_w 330
    //   495: new 219	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 378
    //   505: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: iload 5
    //   510: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   513: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   519: pop
    //   520: aload_1
    //   521: ldc_w 334
    //   524: ldc_w 336
    //   527: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   530: pop
    //   531: invokestatic 342	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   534: invokestatic 347	azri:a	(Landroid/content/Context;)Lazri;
    //   537: aload_0
    //   538: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   541: invokevirtual 350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   544: ldc_w 352
    //   547: iconst_0
    //   548: lconst_0
    //   549: lconst_0
    //   550: aload_1
    //   551: ldc 123
    //   553: invokevirtual 355	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   556: iload 5
    //   558: bipush 100
    //   560: if_icmple +3946 -> 4506
    //   563: iload 5
    //   565: bipush 100
    //   567: isub
    //   568: istore 5
    //   570: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   573: ifeq +30 -> 603
    //   576: ldc 237
    //   578: iconst_2
    //   579: new 219	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 380
    //   589: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: iload 5
    //   594: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   597: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: iload 5
    //   605: lookupswitch	default:+35->640, 1:+419->1024, 1000:+368->973, 1001:+389->994
    //   641: iconst_2
    //   642: sipush 1200
    //   645: if_icmpeq +75 -> 720
    //   648: iload 5
    //   650: sipush 1214
    //   653: if_icmpeq +67 -> 720
    //   656: iload 5
    //   658: sipush 1215
    //   661: if_icmpeq +59 -> 720
    //   664: iload 5
    //   666: sipush 1218
    //   669: if_icmpeq +51 -> 720
    //   672: iload 5
    //   674: sipush 1232
    //   677: if_icmpeq +43 -> 720
    //   680: iload 5
    //   682: sipush 1233
    //   685: if_icmpeq +35 -> 720
    //   688: iload 5
    //   690: sipush 1240
    //   693: if_icmpeq +27 -> 720
    //   696: iload 5
    //   698: sipush 1241
    //   701: if_icmpeq +19 -> 720
    //   704: iload 5
    //   706: sipush 1242
    //   709: if_icmpeq +11 -> 720
    //   712: iload 5
    //   714: sipush 1221
    //   717: if_icmpne +318 -> 1035
    //   720: aload 29
    //   722: sipush 1004
    //   725: putfield 166	bade:jdField_a_of_type_Int	I
    //   728: aload 29
    //   730: iload 5
    //   732: putfield 382	bade:jdField_b_of_type_Int	I
    //   735: aload 29
    //   737: aload_3
    //   738: getfield 383	msf/msgsvc/msg_svc$PbGetMsgResp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   741: invokevirtual 217	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   744: putfield 385	bade:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   747: aload 29
    //   749: iconst_1
    //   750: putfield 162	bade:jdField_c_of_type_Boolean	Z
    //   753: aload_0
    //   754: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   757: iconst_0
    //   758: aload 30
    //   760: invokestatic 390	bacu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;BLjava/lang/String;)V
    //   763: aload_0
    //   764: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   767: aload 30
    //   769: bipush 6
    //   771: invokestatic 393	bacu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   774: aload 29
    //   776: iconst_1
    //   777: putfield 164	bade:d	Z
    //   780: aload 32
    //   782: aload 30
    //   784: aconst_null
    //   785: iconst_1
    //   786: invokevirtual 396	badd:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   789: aload 32
    //   791: aload 30
    //   793: iconst_3
    //   794: invokevirtual 399	badd:a	(Ljava/lang/String;I)Z
    //   797: istore 12
    //   799: aload 32
    //   801: aload 30
    //   803: iload 5
    //   805: aload_3
    //   806: getfield 383	msf/msgsvc/msg_svc$PbGetMsgResp:errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   809: invokevirtual 217	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   812: invokevirtual 401	badd:a	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: aload 32
    //   817: aload 30
    //   819: invokevirtual 404	badd:f	(Ljava/lang/String;)V
    //   822: iload 12
    //   824: ifeq +102 -> 926
    //   827: iconst_1
    //   828: aload_0
    //   829: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   832: invokevirtual 407	com/tencent/mobileqq/app/QQAppInterface:a	()Labta;
    //   835: aload 30
    //   837: sipush 7000
    //   840: invokevirtual 412	abta:a	(Ljava/lang/String;I)I
    //   843: isub
    //   844: istore 5
    //   846: iload 5
    //   848: ifeq +45 -> 893
    //   851: aload_0
    //   852: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   855: invokevirtual 407	com/tencent/mobileqq/app/QQAppInterface:a	()Labta;
    //   858: aload 30
    //   860: sipush 7000
    //   863: iload 5
    //   865: invokevirtual 415	abta:d	(Ljava/lang/String;II)V
    //   868: aload_0
    //   869: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   872: invokevirtual 418	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   875: iconst_2
    //   876: anewarray 85	java/lang/String
    //   879: dup
    //   880: iconst_0
    //   881: getstatic 423	alof:x	Ljava/lang/String;
    //   884: aastore
    //   885: dup
    //   886: iconst_1
    //   887: aload 30
    //   889: aastore
    //   890: invokevirtual 428	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/Object;)V
    //   893: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   896: ifeq +30 -> 926
    //   899: ldc 237
    //   901: iconst_2
    //   902: new 219	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   909: ldc_w 430
    //   912: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload 30
    //   917: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   926: aload_0
    //   927: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   930: aload 30
    //   932: iconst_0
    //   933: invokevirtual 434	com/tencent/mobileqq/app/QQAppInterface:updateSubAccountLogin	(Ljava/lang/String;Z)V
    //   936: aload_0
    //   937: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   940: invokevirtual 438	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   943: invokevirtual 444	mqq/app/MobileQQ:refreAccountList	()Ljava/util/List;
    //   946: pop
    //   947: aload_0
    //   948: sipush 8003
    //   951: iconst_0
    //   952: aload 29
    //   954: invokevirtual 169	amll:a	(IZLjava/lang/Object;)V
    //   957: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   960: ifeq -644 -> 316
    //   963: ldc 237
    //   965: iconst_2
    //   966: ldc_w 446
    //   969: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   972: return
    //   973: aload 29
    //   975: sipush 1008
    //   978: putfield 166	bade:jdField_a_of_type_Int	I
    //   981: aload_0
    //   982: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   985: ldc_w 448
    //   988: invokestatic 451	bacu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   991: goto -44 -> 947
    //   994: aload 29
    //   996: sipush 1002
    //   999: putfield 166	bade:jdField_a_of_type_Int	I
    //   1002: aload_0
    //   1003: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1006: iconst_0
    //   1007: aload 30
    //   1009: invokestatic 390	bacu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;BLjava/lang/String;)V
    //   1012: aload_0
    //   1013: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1016: aload 30
    //   1018: invokestatic 451	bacu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   1021: goto -74 -> 947
    //   1024: aload 29
    //   1026: sipush 1006
    //   1029: putfield 166	bade:jdField_a_of_type_Int	I
    //   1032: goto -85 -> 947
    //   1035: aload 29
    //   1037: sipush 1000
    //   1040: putfield 166	bade:jdField_a_of_type_Int	I
    //   1043: goto -96 -> 947
    //   1046: aload 32
    //   1048: aload 30
    //   1050: iconst_1
    //   1051: invokevirtual 399	badd:a	(Ljava/lang/String;I)Z
    //   1054: pop
    //   1055: aload_2
    //   1056: invokevirtual 155	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   1059: astore 26
    //   1061: ldc2_w 452
    //   1064: lstore 16
    //   1066: aload 30
    //   1068: invokestatic 457	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1071: lstore 14
    //   1073: aload 26
    //   1075: ifnonnull +128 -> 1203
    //   1078: aload_0
    //   1079: sipush 8003
    //   1082: iconst_0
    //   1083: aload 29
    //   1085: invokevirtual 169	amll:a	(IZLjava/lang/Object;)V
    //   1088: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1091: ifeq +12 -> 1103
    //   1094: ldc 237
    //   1096: iconst_2
    //   1097: ldc_w 459
    //   1100: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1103: new 319	java/util/HashMap
    //   1106: dup
    //   1107: invokespecial 320	java/util/HashMap:<init>	()V
    //   1110: astore_1
    //   1111: aload_1
    //   1112: ldc_w 322
    //   1115: ldc_w 324
    //   1118: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1121: pop
    //   1122: aload_1
    //   1123: ldc_w 330
    //   1126: ldc_w 461
    //   1129: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1132: pop
    //   1133: aload_1
    //   1134: ldc_w 334
    //   1137: ldc_w 336
    //   1140: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1143: pop
    //   1144: invokestatic 342	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1147: invokestatic 347	azri:a	(Landroid/content/Context;)Lazri;
    //   1150: aload_0
    //   1151: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1154: invokevirtual 350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1157: ldc_w 352
    //   1160: iconst_0
    //   1161: lconst_0
    //   1162: lconst_0
    //   1163: aload_1
    //   1164: ldc 123
    //   1166: invokevirtual 355	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1169: return
    //   1170: astore 27
    //   1172: aload 27
    //   1174: invokevirtual 464	java/lang/Exception:printStackTrace	()V
    //   1177: lload 16
    //   1179: lstore 14
    //   1181: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1184: ifeq -111 -> 1073
    //   1187: ldc 237
    //   1189: iconst_2
    //   1190: ldc_w 466
    //   1193: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1196: lload 16
    //   1198: lstore 14
    //   1200: goto -127 -> 1073
    //   1203: aload_2
    //   1204: invokevirtual 155	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   1207: invokestatic 469	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1210: invokevirtual 472	java/lang/Long:longValue	()J
    //   1213: lstore 16
    //   1215: lload 16
    //   1217: ldc2_w 452
    //   1220: lcmp
    //   1221: ifne +119 -> 1340
    //   1224: aload_0
    //   1225: sipush 8003
    //   1228: iconst_0
    //   1229: aload 29
    //   1231: invokevirtual 169	amll:a	(IZLjava/lang/Object;)V
    //   1234: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1237: ifeq +12 -> 1249
    //   1240: ldc 237
    //   1242: iconst_2
    //   1243: ldc_w 474
    //   1246: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1249: new 319	java/util/HashMap
    //   1252: dup
    //   1253: invokespecial 320	java/util/HashMap:<init>	()V
    //   1256: astore_1
    //   1257: aload_1
    //   1258: ldc_w 322
    //   1261: ldc_w 324
    //   1264: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1267: pop
    //   1268: aload_1
    //   1269: ldc_w 330
    //   1272: ldc_w 476
    //   1275: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1278: pop
    //   1279: aload_1
    //   1280: ldc_w 334
    //   1283: ldc_w 336
    //   1286: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1289: pop
    //   1290: invokestatic 342	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1293: invokestatic 347	azri:a	(Landroid/content/Context;)Lazri;
    //   1296: aload_0
    //   1297: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1300: invokevirtual 350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1303: ldc_w 352
    //   1306: iconst_0
    //   1307: lconst_0
    //   1308: lconst_0
    //   1309: aload_1
    //   1310: ldc 123
    //   1312: invokevirtual 355	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1315: return
    //   1316: astore_2
    //   1317: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1320: ifeq +12 -> 1332
    //   1323: ldc 237
    //   1325: iconst_2
    //   1326: ldc_w 478
    //   1329: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1332: ldc2_w 452
    //   1335: lstore 16
    //   1337: goto -122 -> 1215
    //   1340: aload 32
    //   1342: invokevirtual 480	badd:a	()Z
    //   1345: ifne +19 -> 1364
    //   1348: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1351: ifeq -1035 -> 316
    //   1354: ldc 237
    //   1356: iconst_2
    //   1357: ldc_w 482
    //   1360: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1363: return
    //   1364: aload_3
    //   1365: getfield 359	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1368: invokevirtual 195	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1371: ifeq +3129 -> 4500
    //   1374: aload_3
    //   1375: getfield 359	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1378: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1381: invokevirtual 204	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1384: astore 26
    //   1386: aload_3
    //   1387: getfield 368	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   1390: invokevirtual 483	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   1393: ifeq +3101 -> 4494
    //   1396: aload_3
    //   1397: getfield 368	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   1400: invokevirtual 371	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   1403: istore 5
    //   1405: iload 5
    //   1407: iconst_2
    //   1408: if_icmpge +3077 -> 4485
    //   1411: iconst_1
    //   1412: i2b
    //   1413: istore 4
    //   1415: iconst_0
    //   1416: istore 6
    //   1418: aload_3
    //   1419: getfield 484	msf/msgsvc/msg_svc$PbGetMsgResp:bind_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1422: invokevirtual 208	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1425: ifeq +3054 -> 4479
    //   1428: aload_3
    //   1429: getfield 484	msf/msgsvc/msg_svc$PbGetMsgResp:bind_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1432: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1435: lstore 18
    //   1437: aload 32
    //   1439: ifnull +3034 -> 4473
    //   1442: aload 32
    //   1444: lload 18
    //   1446: invokestatic 486	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1449: invokevirtual 489	badd:a	(Ljava/lang/String;)Ljava/util/List;
    //   1452: astore 27
    //   1454: aload_1
    //   1455: getfield 269	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1458: ldc_w 491
    //   1461: invokevirtual 495	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   1464: astore 28
    //   1466: aload 28
    //   1468: ifnonnull +3002 -> 4470
    //   1471: new 497	java/util/ArrayList
    //   1474: dup
    //   1475: invokespecial 498	java/util/ArrayList:<init>	()V
    //   1478: astore 28
    //   1480: new 319	java/util/HashMap
    //   1483: dup
    //   1484: invokespecial 320	java/util/HashMap:<init>	()V
    //   1487: astore 33
    //   1489: aload_3
    //   1490: getfield 502	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1493: invokevirtual 506	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1496: astore 34
    //   1498: iconst_0
    //   1499: istore 7
    //   1501: iload 7
    //   1503: aload 34
    //   1505: invokeinterface 511 1 0
    //   1510: if_icmpge +2425 -> 3935
    //   1513: aload 34
    //   1515: iload 7
    //   1517: invokeinterface 514 2 0
    //   1522: checkcast 516	msf/msgcomm/msg_comm$UinPairMsg
    //   1525: astore_2
    //   1526: aload_2
    //   1527: getfield 519	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1530: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1533: lstore 24
    //   1535: aload_2
    //   1536: getfield 522	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1539: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1542: i2l
    //   1543: lstore 20
    //   1545: aload_2
    //   1546: getfield 524	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1549: invokevirtual 506	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1552: astore_3
    //   1553: iload 6
    //   1555: ifne +14 -> 1569
    //   1558: aload 28
    //   1560: lload 24
    //   1562: invokestatic 486	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1565: invokevirtual 528	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1568: pop
    //   1569: aload_2
    //   1570: getfield 531	msf/msgcomm/msg_comm$UinPairMsg:unread_msg_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1573: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1576: istore 9
    //   1578: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1581: ifeq +30 -> 1611
    //   1584: ldc 237
    //   1586: iconst_2
    //   1587: new 219	java/lang/StringBuilder
    //   1590: dup
    //   1591: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1594: ldc_w 533
    //   1597: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: lload 24
    //   1602: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1605: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1608: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1611: aload_3
    //   1612: ifnull +17 -> 1629
    //   1615: aload_3
    //   1616: invokeinterface 511 1 0
    //   1621: ifeq +8 -> 1629
    //   1624: iload 9
    //   1626: ifne +129 -> 1755
    //   1629: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1632: ifeq +30 -> 1662
    //   1635: ldc 237
    //   1637: iconst_2
    //   1638: new 219	java/lang/StringBuilder
    //   1641: dup
    //   1642: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1645: ldc_w 535
    //   1648: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: lload 24
    //   1653: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1656: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1659: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1662: aload 27
    //   1664: ifnull +82 -> 1746
    //   1667: aload 27
    //   1669: invokeinterface 539 1 0
    //   1674: astore_2
    //   1675: aload_2
    //   1676: invokeinterface 544 1 0
    //   1681: ifeq +65 -> 1746
    //   1684: aload_2
    //   1685: invokeinterface 548 1 0
    //   1690: checkcast 78	com/tencent/mobileqq/data/SubAccountMessage
    //   1693: astore_3
    //   1694: aload_3
    //   1695: ifnull -20 -> 1675
    //   1698: aload_3
    //   1699: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   1702: astore_3
    //   1703: aload_3
    //   1704: ifnull -29 -> 1675
    //   1707: aload_3
    //   1708: lload 24
    //   1710: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1713: invokevirtual 552	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1716: ifeq -41 -> 1675
    //   1719: aload 28
    //   1721: lload 24
    //   1723: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1726: invokevirtual 528	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1729: pop
    //   1730: aload 33
    //   1732: lload 24
    //   1734: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1737: iload 9
    //   1739: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1742: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1745: pop
    //   1746: iload 7
    //   1748: iconst_1
    //   1749: iadd
    //   1750: istore 7
    //   1752: goto -251 -> 1501
    //   1755: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1758: ifeq +45 -> 1803
    //   1761: ldc 237
    //   1763: iconst_2
    //   1764: new 219	java/lang/StringBuilder
    //   1767: dup
    //   1768: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1771: ldc_w 554
    //   1774: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: lload 24
    //   1779: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1782: ldc_w 556
    //   1785: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: aload_3
    //   1789: invokeinterface 511 1 0
    //   1794: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1797: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1800: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1803: new 558	ayzj
    //   1806: dup
    //   1807: lload 14
    //   1809: lload 24
    //   1811: iconst_0
    //   1812: iconst_0
    //   1813: iconst_0
    //   1814: iconst_1
    //   1815: invokespecial 561	ayzj:<init>	(JJZZZZ)V
    //   1818: astore 35
    //   1820: aload_3
    //   1821: ifnull -75 -> 1746
    //   1824: aload_3
    //   1825: invokeinterface 511 1 0
    //   1830: ifle -84 -> 1746
    //   1833: aload_3
    //   1834: new 563	amlm
    //   1837: dup
    //   1838: aload_0
    //   1839: invokespecial 566	amlm:<init>	(Lamll;)V
    //   1842: invokestatic 572	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   1845: aload_2
    //   1846: getfield 575	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1849: invokevirtual 372	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1852: ifeq +358 -> 2210
    //   1855: aload_2
    //   1856: getfield 575	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1859: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1862: ifeq +348 -> 2210
    //   1865: iconst_1
    //   1866: istore 12
    //   1868: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1871: ifeq +71 -> 1942
    //   1874: ldc 237
    //   1876: iconst_2
    //   1877: new 219	java/lang/StringBuilder
    //   1880: dup
    //   1881: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   1884: ldc_w 554
    //   1887: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: lload 24
    //   1892: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1895: ldc_w 577
    //   1898: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1901: aload_3
    //   1902: invokeinterface 511 1 0
    //   1907: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1910: ldc_w 579
    //   1913: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: iload 12
    //   1918: invokevirtual 582	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1921: ldc_w 584
    //   1924: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1927: lload 20
    //   1929: ldc2_w 585
    //   1932: land
    //   1933: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1936: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1939: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1942: aload_3
    //   1943: invokeinterface 539 1 0
    //   1948: astore 36
    //   1950: aload 36
    //   1952: invokeinterface 544 1 0
    //   1957: ifeq -211 -> 1746
    //   1960: aload 36
    //   1962: invokeinterface 548 1 0
    //   1967: checkcast 17	msf/msgcomm/msg_comm$Msg
    //   1970: astore 37
    //   1972: aload 37
    //   1974: ifnull -24 -> 1950
    //   1977: aload 37
    //   1979: getfield 21	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1982: invokevirtual 27	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1985: checkcast 23	msf/msgcomm/msg_comm$MsgHead
    //   1988: astore 38
    //   1990: aload 38
    //   1992: getfield 589	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1995: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1998: istore 8
    //   2000: aconst_null
    //   2001: astore_2
    //   2002: aload 37
    //   2004: getfield 21	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   2007: invokevirtual 27	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2010: checkcast 23	msf/msgcomm/msg_comm$MsgHead
    //   2013: getfield 592	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2016: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2019: istore 10
    //   2021: sipush 193
    //   2024: iload 8
    //   2026: if_icmpeq +11 -> 2037
    //   2029: sipush 734
    //   2032: iload 8
    //   2034: if_icmpne +305 -> 2339
    //   2037: lload 14
    //   2039: lload 24
    //   2041: lcmp
    //   2042: ifne +174 -> 2216
    //   2045: aload_2
    //   2046: ifnull +64 -> 2110
    //   2049: aload_2
    //   2050: invokeinterface 595 1 0
    //   2055: ifne +55 -> 2110
    //   2058: aload 27
    //   2060: ifnull +50 -> 2110
    //   2063: aload 27
    //   2065: invokeinterface 595 1 0
    //   2070: ifne +40 -> 2110
    //   2073: aload_2
    //   2074: iconst_0
    //   2075: invokeinterface 514 2 0
    //   2080: checkcast 597	com/tencent/mobileqq/data/MessageRecord
    //   2083: getfield 598	com/tencent/mobileqq/data/MessageRecord:time	J
    //   2086: aload 27
    //   2088: iconst_0
    //   2089: invokeinterface 514 2 0
    //   2094: checkcast 78	com/tencent/mobileqq/data/SubAccountMessage
    //   2097: getfield 103	com/tencent/mobileqq/data/SubAccountMessage:time	J
    //   2100: lcmp
    //   2101: ifge +9 -> 2110
    //   2104: aload_2
    //   2105: invokeinterface 601 1 0
    //   2110: aload_2
    //   2111: ifnull +12 -> 2123
    //   2114: aload_2
    //   2115: invokeinterface 511 1 0
    //   2120: ifne +637 -> 2757
    //   2123: aload 27
    //   2125: ifnull -175 -> 1950
    //   2128: aload 27
    //   2130: invokeinterface 539 1 0
    //   2135: astore_2
    //   2136: aload_2
    //   2137: invokeinterface 544 1 0
    //   2142: ifeq -192 -> 1950
    //   2145: aload_2
    //   2146: invokeinterface 548 1 0
    //   2151: checkcast 78	com/tencent/mobileqq/data/SubAccountMessage
    //   2154: astore_3
    //   2155: aload_3
    //   2156: ifnull -20 -> 2136
    //   2159: aload_3
    //   2160: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   2163: astore_3
    //   2164: aload_3
    //   2165: ifnull -29 -> 2136
    //   2168: aload_3
    //   2169: lload 24
    //   2171: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2174: invokevirtual 552	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2177: ifeq -41 -> 2136
    //   2180: aload 28
    //   2182: lload 24
    //   2184: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2187: invokevirtual 528	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2190: pop
    //   2191: aload 33
    //   2193: lload 24
    //   2195: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2198: iload 9
    //   2200: invokestatic 284	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2203: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2206: pop
    //   2207: goto -257 -> 1950
    //   2210: iconst_0
    //   2211: istore 12
    //   2213: goto -345 -> 1868
    //   2216: new 497	java/util/ArrayList
    //   2219: dup
    //   2220: invokespecial 498	java/util/ArrayList:<init>	()V
    //   2223: astore_2
    //   2224: sipush 193
    //   2227: invokestatic 606	azaf:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2230: astore_3
    //   2231: aload_3
    //   2232: lload 14
    //   2234: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2237: putfield 609	com/tencent/mobileqq/data/MessageRecord:selfuin	Ljava/lang/String;
    //   2240: aload_3
    //   2241: lload 24
    //   2243: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2246: putfield 610	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2249: aload_3
    //   2250: lload 24
    //   2252: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2255: putfield 611	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   2258: aload_3
    //   2259: aload 38
    //   2261: getfield 614	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2264: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2267: i2l
    //   2268: putfield 617	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   2271: aload_3
    //   2272: aload 38
    //   2274: getfield 620	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2277: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2280: putfield 623	com/tencent/mobileqq/data/MessageRecord:msgUid	J
    //   2283: aload_3
    //   2284: aload 38
    //   2286: getfield 40	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2289: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2292: i2l
    //   2293: putfield 598	com/tencent/mobileqq/data/MessageRecord:time	J
    //   2296: aload_3
    //   2297: iconst_0
    //   2298: putfield 624	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2301: aload_3
    //   2302: aload_0
    //   2303: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2306: invokevirtual 627	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2309: invokevirtual 631	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2312: ldc_w 632
    //   2315: invokevirtual 636	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2318: putfield 637	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   2321: aload_3
    //   2322: sipush 193
    //   2325: putfield 638	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   2328: aload_2
    //   2329: aload_3
    //   2330: invokeinterface 639 2 0
    //   2335: pop
    //   2336: goto -291 -> 2045
    //   2339: iload 8
    //   2341: invokestatic 644	azah:c	(I)Z
    //   2344: ifeq +331 -> 2675
    //   2347: aload 38
    //   2349: getfield 592	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2352: invokevirtual 372	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2355: ifeq +320 -> 2675
    //   2358: iload 10
    //   2360: sipush 169
    //   2363: if_icmpeq +51 -> 2414
    //   2366: iload 10
    //   2368: sipush 241
    //   2371: if_icmpeq +43 -> 2414
    //   2374: iload 10
    //   2376: sipush 242
    //   2379: if_icmpeq +35 -> 2414
    //   2382: iload 10
    //   2384: sipush 243
    //   2387: if_icmpeq +27 -> 2414
    //   2390: iload 10
    //   2392: sipush 129
    //   2395: if_icmpeq +19 -> 2414
    //   2398: iload 10
    //   2400: sipush 131
    //   2403: if_icmpeq +11 -> 2414
    //   2406: iload 10
    //   2408: sipush 133
    //   2411: if_icmpne +264 -> 2675
    //   2414: iload 10
    //   2416: sipush 129
    //   2419: if_icmpeq -469 -> 1950
    //   2422: iload 10
    //   2424: sipush 131
    //   2427: if_icmpeq -477 -> 1950
    //   2430: iload 10
    //   2432: sipush 133
    //   2435: if_icmpeq -485 -> 1950
    //   2438: iload 10
    //   2440: sipush 135
    //   2443: if_icmpeq -493 -> 1950
    //   2446: iload 10
    //   2448: sipush 243
    //   2451: if_icmpeq -501 -> 1950
    //   2454: aload 37
    //   2456: getfield 648	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   2459: invokevirtual 651	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2462: checkcast 650	tencent/im/msg/im_msg_body$MsgBody
    //   2465: getfield 655	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   2468: invokevirtual 658	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2471: checkcast 657	tencent/im/msg/im_msg_body$RichText
    //   2474: getfield 662	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   2477: invokevirtual 665	tencent/im/msg/im_msg_body$NotOnlineFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2480: checkcast 664	tencent/im/msg/im_msg_body$NotOnlineFile
    //   2483: getfield 668	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2486: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2489: invokevirtual 671	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2492: astore_2
    //   2493: aload_2
    //   2494: astore_3
    //   2495: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2498: ifeq +31 -> 2529
    //   2501: ldc 237
    //   2503: iconst_2
    //   2504: new 219	java/lang/StringBuilder
    //   2507: dup
    //   2508: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   2511: ldc_w 673
    //   2514: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2517: aload_2
    //   2518: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2521: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2524: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2527: aload_2
    //   2528: astore_3
    //   2529: aload_3
    //   2530: astore_2
    //   2531: aload_3
    //   2532: invokestatic 678	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2535: ifeq +20 -> 2555
    //   2538: aload_0
    //   2539: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2542: invokevirtual 627	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2545: invokevirtual 631	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   2548: ldc_w 679
    //   2551: invokevirtual 636	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   2554: astore_2
    //   2555: sipush -2005
    //   2558: invokestatic 606	azaf:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2561: astore_3
    //   2562: aload_3
    //   2563: lload 14
    //   2565: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2568: putfield 609	com/tencent/mobileqq/data/MessageRecord:selfuin	Ljava/lang/String;
    //   2571: aload_3
    //   2572: lload 24
    //   2574: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2577: putfield 610	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2580: aload_3
    //   2581: lload 24
    //   2583: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2586: putfield 611	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   2589: aload_3
    //   2590: aload 38
    //   2592: getfield 614	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2595: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2598: i2l
    //   2599: putfield 617	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   2602: aload_3
    //   2603: aload 38
    //   2605: getfield 620	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2608: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2611: putfield 623	com/tencent/mobileqq/data/MessageRecord:msgUid	J
    //   2614: aload_3
    //   2615: aload 38
    //   2617: getfield 40	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2620: invokevirtual 45	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2623: i2l
    //   2624: putfield 598	com/tencent/mobileqq/data/MessageRecord:time	J
    //   2627: aload_3
    //   2628: iconst_0
    //   2629: putfield 624	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2632: aload_3
    //   2633: aload_2
    //   2634: putfield 637	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   2637: aload_3
    //   2638: sipush -2005
    //   2641: putfield 638	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   2644: new 497	java/util/ArrayList
    //   2647: dup
    //   2648: invokespecial 498	java/util/ArrayList:<init>	()V
    //   2651: astore_2
    //   2652: aload_2
    //   2653: aload_3
    //   2654: invokeinterface 639 2 0
    //   2659: pop
    //   2660: goto -615 -> 2045
    //   2663: astore_3
    //   2664: aconst_null
    //   2665: astore_2
    //   2666: aload_3
    //   2667: invokevirtual 464	java/lang/Exception:printStackTrace	()V
    //   2670: aload_2
    //   2671: astore_3
    //   2672: goto -143 -> 2529
    //   2675: aload_0
    //   2676: aload 37
    //   2678: aload 35
    //   2680: invokevirtual 682	amll:a	(Lmsf/msgcomm/msg_comm$Msg;Lazai;)Ljava/util/ArrayList;
    //   2683: astore_2
    //   2684: aload_2
    //   2685: ifnull +47 -> 2732
    //   2688: aload_2
    //   2689: invokeinterface 511 1 0
    //   2694: ifle +38 -> 2732
    //   2697: aload_2
    //   2698: iconst_0
    //   2699: invokeinterface 514 2 0
    //   2704: checkcast 597	com/tencent/mobileqq/data/MessageRecord
    //   2707: astore_3
    //   2708: aload_3
    //   2709: getfield 624	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2712: sipush 1033
    //   2715: if_icmpeq -765 -> 1950
    //   2718: aload_3
    //   2719: getfield 624	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   2722: istore 8
    //   2724: iload 8
    //   2726: sipush 1034
    //   2729: if_icmpeq -779 -> 1950
    //   2732: goto -687 -> 2045
    //   2735: astore_3
    //   2736: aconst_null
    //   2737: astore_2
    //   2738: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2741: ifeq +13 -> 2754
    //   2744: ldc 58
    //   2746: iconst_2
    //   2747: ldc_w 684
    //   2750: aload_3
    //   2751: invokestatic 687	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2754: goto -709 -> 2045
    //   2757: new 689	java/lang/StringBuffer
    //   2760: dup
    //   2761: invokespecial 690	java/lang/StringBuffer:<init>	()V
    //   2764: astore 39
    //   2766: aload_2
    //   2767: iconst_0
    //   2768: invokeinterface 514 2 0
    //   2773: checkcast 597	com/tencent/mobileqq/data/MessageRecord
    //   2776: astore 38
    //   2778: aload 38
    //   2780: getfield 598	com/tencent/mobileqq/data/MessageRecord:time	J
    //   2783: lstore 22
    //   2785: aload_2
    //   2786: invokeinterface 539 1 0
    //   2791: astore 40
    //   2793: iconst_0
    //   2794: istore 12
    //   2796: aload 40
    //   2798: invokeinterface 544 1 0
    //   2803: ifeq +1661 -> 4464
    //   2806: aload 40
    //   2808: invokeinterface 548 1 0
    //   2813: checkcast 597	com/tencent/mobileqq/data/MessageRecord
    //   2816: astore_2
    //   2817: aload_2
    //   2818: ifnull -22 -> 2796
    //   2821: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2824: ifeq +29 -> 2853
    //   2827: ldc 237
    //   2829: iconst_2
    //   2830: new 219	java/lang/StringBuilder
    //   2833: dup
    //   2834: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   2837: ldc_w 692
    //   2840: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2843: aload_2
    //   2844: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2847: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2850: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2853: aload_2
    //   2854: getfield 637	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   2857: astore_3
    //   2858: aload_3
    //   2859: ifnull +18 -> 2877
    //   2862: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2865: ifeq +12 -> 2877
    //   2868: ldc 237
    //   2870: iconst_2
    //   2871: ldc_w 694
    //   2874: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2877: aload_2
    //   2878: getfield 610	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2881: ifnull -85 -> 2796
    //   2884: getstatic 697	alof:G	Ljava/lang/String;
    //   2887: invokestatic 260	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2890: aload_2
    //   2891: getfield 610	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   2894: invokevirtual 552	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2897: ifeq +78 -> 2975
    //   2900: iconst_1
    //   2901: istore 8
    //   2903: aload_0
    //   2904: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2907: aload_3
    //   2908: aload_2
    //   2909: getfield 638	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   2912: aload_2
    //   2913: getfield 611	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   2916: invokestatic 700	bacu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   2919: astore_2
    //   2920: aload_2
    //   2921: ifnonnull +44 -> 2965
    //   2924: aload 39
    //   2926: ifnull +11 -> 2937
    //   2929: aload 39
    //   2931: invokevirtual 703	java/lang/StringBuffer:length	()I
    //   2934: ifne +101 -> 3035
    //   2937: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2940: ifeq -990 -> 1950
    //   2943: ldc 237
    //   2945: iconst_2
    //   2946: ldc_w 705
    //   2949: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2952: goto -1002 -> 1950
    //   2955: astore 41
    //   2957: aload 41
    //   2959: invokevirtual 464	java/lang/Exception:printStackTrace	()V
    //   2962: goto -85 -> 2877
    //   2965: aload 39
    //   2967: aload_2
    //   2968: invokevirtual 708	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   2971: pop
    //   2972: goto -48 -> 2924
    //   2975: aload_2
    //   2976: getfield 638	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   2979: sipush -5004
    //   2982: if_icmpne +1479 -> 4461
    //   2985: aload_2
    //   2986: instanceof 710
    //   2989: ifeq +1472 -> 4461
    //   2992: ldc_w 712
    //   2995: aload 38
    //   2997: getfield 611	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   3000: invokevirtual 715	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3003: ifeq +1458 -> 4461
    //   3006: iconst_1
    //   3007: istore 12
    //   3009: aload_0
    //   3010: aload_2
    //   3011: aload_3
    //   3012: invokespecial 719	amll:g	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)Ljava/lang/String;
    //   3015: astore_3
    //   3016: aload_3
    //   3017: astore_2
    //   3018: aload_3
    //   3019: ifnonnull +6 -> 3025
    //   3022: ldc 123
    //   3024: astore_2
    //   3025: aload 39
    //   3027: aload_2
    //   3028: invokevirtual 708	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   3031: pop
    //   3032: goto -236 -> 2796
    //   3035: aload 27
    //   3037: ifnull +71 -> 3108
    //   3040: iload 8
    //   3042: ifne +66 -> 3108
    //   3045: aload 27
    //   3047: invokeinterface 539 1 0
    //   3052: astore_2
    //   3053: aload_2
    //   3054: invokeinterface 544 1 0
    //   3059: ifeq +49 -> 3108
    //   3062: aload_2
    //   3063: invokeinterface 548 1 0
    //   3068: checkcast 78	com/tencent/mobileqq/data/SubAccountMessage
    //   3071: astore_3
    //   3072: aload_3
    //   3073: ifnull -20 -> 3053
    //   3076: aload_3
    //   3077: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   3080: astore_3
    //   3081: aload_3
    //   3082: ifnull -29 -> 3053
    //   3085: aload_3
    //   3086: lload 24
    //   3088: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3091: invokevirtual 552	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   3094: ifeq -41 -> 3053
    //   3097: aload 28
    //   3099: lload 24
    //   3101: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3104: invokevirtual 528	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3107: pop
    //   3108: aload 37
    //   3110: getfield 21	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   3113: invokevirtual 27	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3116: checkcast 23	msf/msgcomm/msg_comm$MsgHead
    //   3119: astore_2
    //   3120: aload_2
    //   3121: ifnull +1335 -> 4456
    //   3124: aload_2
    //   3125: getfield 722	msf/msgcomm/msg_comm$MsgHead:from_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3128: invokevirtual 215	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   3131: ifeq +1325 -> 4456
    //   3134: aload_2
    //   3135: getfield 722	msf/msgcomm/msg_comm$MsgHead:from_nick	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3138: invokevirtual 217	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3141: astore_2
    //   3142: iload 8
    //   3144: ifeq +20 -> 3164
    //   3147: aload_0
    //   3148: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3151: invokevirtual 627	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3154: invokevirtual 631	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   3157: ldc_w 723
    //   3160: invokevirtual 636	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   3163: astore_2
    //   3164: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3167: ifeq +30 -> 3197
    //   3170: ldc 237
    //   3172: iconst_2
    //   3173: new 219	java/lang/StringBuilder
    //   3176: dup
    //   3177: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   3180: ldc_w 725
    //   3183: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3186: iload 12
    //   3188: invokevirtual 582	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3191: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3194: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3197: aload 29
    //   3199: iconst_1
    //   3200: putfield 162	bade:jdField_c_of_type_Boolean	Z
    //   3203: new 78	com/tencent/mobileqq/data/SubAccountMessage
    //   3206: dup
    //   3207: invokespecial 81	com/tencent/mobileqq/data/SubAccountMessage:<init>	()V
    //   3210: astore 37
    //   3212: iload 8
    //   3214: ifeq +688 -> 3902
    //   3217: aload 37
    //   3219: getstatic 697	alof:G	Ljava/lang/String;
    //   3222: invokestatic 260	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   3225: putfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   3228: iload 12
    //   3230: ifeq +685 -> 3915
    //   3233: iconst_1
    //   3234: istore 13
    //   3236: aload 37
    //   3238: iload 13
    //   3240: putfield 728	com/tencent/mobileqq/data/SubAccountMessage:isread	Z
    //   3243: aload 37
    //   3245: aload 39
    //   3247: invokevirtual 729	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   3250: putfield 126	com/tencent/mobileqq/data/SubAccountMessage:msg	Ljava/lang/String;
    //   3253: aload 37
    //   3255: aload 38
    //   3257: getfield 732	com/tencent/mobileqq/data/MessageRecord:extInt	I
    //   3260: putfield 733	com/tencent/mobileqq/data/SubAccountMessage:extInt	I
    //   3263: aload 37
    //   3265: aload 38
    //   3267: getfield 736	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   3270: putfield 737	com/tencent/mobileqq/data/SubAccountMessage:extLong	I
    //   3273: aload 37
    //   3275: aload 38
    //   3277: getfield 740	com/tencent/mobileqq/data/MessageRecord:extraflag	I
    //   3280: putfield 741	com/tencent/mobileqq/data/SubAccountMessage:extraflag	I
    //   3283: aload 37
    //   3285: aload 38
    //   3287: getfield 744	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   3290: putfield 745	com/tencent/mobileqq/data/SubAccountMessage:extStr	Ljava/lang/String;
    //   3293: aload 37
    //   3295: aload 38
    //   3297: getfield 624	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3300: putfield 112	com/tencent/mobileqq/data/SubAccountMessage:istroop	I
    //   3303: aload 37
    //   3305: aload 38
    //   3307: getfield 748	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   3310: putfield 749	com/tencent/mobileqq/data/SubAccountMessage:isValid	Z
    //   3313: aload 37
    //   3315: aload 38
    //   3317: getfield 752	com/tencent/mobileqq/data/MessageRecord:longMsgCount	I
    //   3320: putfield 753	com/tencent/mobileqq/data/SubAccountMessage:longMsgCount	I
    //   3323: aload 37
    //   3325: aload 38
    //   3327: getfield 756	com/tencent/mobileqq/data/MessageRecord:longMsgId	I
    //   3330: putfield 757	com/tencent/mobileqq/data/SubAccountMessage:longMsgId	I
    //   3333: aload 37
    //   3335: aload 38
    //   3337: getfield 760	com/tencent/mobileqq/data/MessageRecord:longMsgIndex	I
    //   3340: putfield 761	com/tencent/mobileqq/data/SubAccountMessage:longMsgIndex	I
    //   3343: aload 37
    //   3345: aload 38
    //   3347: getfield 623	com/tencent/mobileqq/data/MessageRecord:msgUid	J
    //   3350: putfield 762	com/tencent/mobileqq/data/SubAccountMessage:msgUid	J
    //   3353: aload 37
    //   3355: aload 38
    //   3357: getfield 617	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   3360: putfield 763	com/tencent/mobileqq/data/SubAccountMessage:shmsgseq	J
    //   3363: aload 37
    //   3365: aload 38
    //   3367: getfield 766	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   3370: putfield 767	com/tencent/mobileqq/data/SubAccountMessage:uniseq	J
    //   3373: aload 37
    //   3375: aload 38
    //   3377: getfield 770	com/tencent/mobileqq/data/MessageRecord:msgseq	J
    //   3380: putfield 771	com/tencent/mobileqq/data/SubAccountMessage:msgseq	J
    //   3383: iload 12
    //   3385: ifeq +536 -> 3921
    //   3388: iconst_0
    //   3389: istore 8
    //   3391: aload 37
    //   3393: iload 8
    //   3395: putfield 96	com/tencent/mobileqq/data/SubAccountMessage:unreadNum	I
    //   3398: aload 37
    //   3400: sipush -1000
    //   3403: putfield 99	com/tencent/mobileqq/data/SubAccountMessage:msgtype	I
    //   3406: aload 37
    //   3408: lload 16
    //   3410: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3413: putfield 772	com/tencent/mobileqq/data/SubAccountMessage:selfuin	Ljava/lang/String;
    //   3416: aload_2
    //   3417: ifnull +12 -> 3429
    //   3420: aload_2
    //   3421: astore_3
    //   3422: aload_2
    //   3423: invokevirtual 773	java/lang/String:length	()I
    //   3426: ifne +9 -> 3435
    //   3429: aload 37
    //   3431: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   3434: astore_3
    //   3435: aload 37
    //   3437: aload_3
    //   3438: putfield 121	com/tencent/mobileqq/data/SubAccountMessage:sendername	Ljava/lang/String;
    //   3441: aload 37
    //   3443: lload 24
    //   3445: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3448: putfield 106	com/tencent/mobileqq/data/SubAccountMessage:senderuin	Ljava/lang/String;
    //   3451: aload 37
    //   3453: lload 18
    //   3455: invokestatic 486	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3458: putfield 109	com/tencent/mobileqq/data/SubAccountMessage:subUin	Ljava/lang/String;
    //   3461: lload 22
    //   3463: lconst_0
    //   3464: lcmp
    //   3465: ifne +463 -> 3928
    //   3468: invokestatic 778	java/lang/System:currentTimeMillis	()J
    //   3471: ldc2_w 779
    //   3474: ldiv
    //   3475: lstore 20
    //   3477: aload 37
    //   3479: lload 20
    //   3481: putfield 103	com/tencent/mobileqq/data/SubAccountMessage:time	J
    //   3484: aload 37
    //   3486: aload_0
    //   3487: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3490: getfield 783	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   3493: putfield 786	com/tencent/mobileqq/data/SubAccountMessage:needNotify	Z
    //   3496: aload 37
    //   3498: ldc2_w 779
    //   3501: lload 22
    //   3503: lmul
    //   3504: iconst_1
    //   3505: getstatic 787	bacu:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3508: invokestatic 792	bdns:a	(JZLjava/lang/String;)Ljava/lang/String;
    //   3511: putfield 795	com/tencent/mobileqq/data/SubAccountMessage:mTimeString	Ljava/lang/String;
    //   3514: aload 37
    //   3516: new 797	bamp
    //   3519: dup
    //   3520: aload 37
    //   3522: getfield 126	com/tencent/mobileqq/data/SubAccountMessage:msg	Ljava/lang/String;
    //   3525: iconst_3
    //   3526: bipush 16
    //   3528: invokespecial 800	bamp:<init>	(Ljava/lang/CharSequence;II)V
    //   3531: putfield 804	com/tencent/mobileqq/data/SubAccountMessage:mEmoRecentMsg	Ljava/lang/CharSequence;
    //   3534: aload 38
    //   3536: invokestatic 810	com/tencent/mobileqq/data/MessageForQQWalletMsg:isRedPacketMsg	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   3539: ifeq +11 -> 3550
    //   3542: aload 37
    //   3544: ldc_w 812
    //   3547: putfield 815	com/tencent/mobileqq/data/SubAccountMessage:subExtr	Ljava/lang/String;
    //   3550: aload 38
    //   3552: instanceof 817
    //   3555: ifeq +11 -> 3566
    //   3558: aload 37
    //   3560: ldc_w 812
    //   3563: putfield 815	com/tencent/mobileqq/data/SubAccountMessage:subExtr	Ljava/lang/String;
    //   3566: aload 32
    //   3568: ifnull +10 -> 3578
    //   3571: aload 32
    //   3573: aload 37
    //   3575: invokevirtual 140	badd:b	(Lcom/tencent/mobileqq/data/SubAccountMessage;)V
    //   3578: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3581: ifeq +78 -> 3659
    //   3584: ldc 237
    //   3586: iconst_2
    //   3587: new 219	java/lang/StringBuilder
    //   3590: dup
    //   3591: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   3594: ldc_w 819
    //   3597: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3600: aload 37
    //   3602: getfield 96	com/tencent/mobileqq/data/SubAccountMessage:unreadNum	I
    //   3605: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3608: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3611: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3614: aload 37
    //   3616: getfield 126	com/tencent/mobileqq/data/SubAccountMessage:msg	Ljava/lang/String;
    //   3619: invokestatic 678	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3622: ifne +37 -> 3659
    //   3625: ldc 237
    //   3627: iconst_2
    //   3628: new 219	java/lang/StringBuilder
    //   3631: dup
    //   3632: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   3635: ldc_w 821
    //   3638: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3641: aload 37
    //   3643: getfield 126	com/tencent/mobileqq/data/SubAccountMessage:msg	Ljava/lang/String;
    //   3646: iconst_0
    //   3647: invokevirtual 825	java/lang/String:charAt	(I)C
    //   3650: invokevirtual 828	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3653: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3656: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3659: aload_0
    //   3660: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3663: aload 30
    //   3665: bipush 6
    //   3667: invokestatic 393	bacu:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   3670: aload 29
    //   3672: iconst_1
    //   3673: putfield 164	bade:d	Z
    //   3676: aload 38
    //   3678: getfield 638	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   3681: invokestatic 606	azaf:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3684: astore_2
    //   3685: aload_2
    //   3686: aload 38
    //   3688: invokestatic 832	com/tencent/mobileqq/data/MessageRecord:copyMessageRecordBaseField	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   3691: aload_2
    //   3692: sipush 7000
    //   3695: putfield 624	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3698: aload_2
    //   3699: aload 30
    //   3701: putfield 610	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   3704: aload_0
    //   3705: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3708: invokevirtual 407	com/tencent/mobileqq/app/QQAppInterface:a	()Labta;
    //   3711: aload_2
    //   3712: getfield 610	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   3715: aload_2
    //   3716: getfield 624	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3719: invokevirtual 412	abta:a	(Ljava/lang/String;I)I
    //   3722: istore 10
    //   3724: iconst_0
    //   3725: istore 8
    //   3727: aload 32
    //   3729: ifnull +12 -> 3741
    //   3732: aload 32
    //   3734: aload 30
    //   3736: invokevirtual 835	badd:c	(Ljava/lang/String;)I
    //   3739: istore 8
    //   3741: iload 8
    //   3743: iload 10
    //   3745: isub
    //   3746: istore 11
    //   3748: iload 11
    //   3750: ifeq +35 -> 3785
    //   3753: aload_0
    //   3754: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3757: invokevirtual 407	com/tencent/mobileqq/app/QQAppInterface:a	()Labta;
    //   3760: aload_2
    //   3761: getfield 610	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   3764: aload_2
    //   3765: getfield 624	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   3768: iload 11
    //   3770: invokevirtual 415	abta:d	(Ljava/lang/String;II)V
    //   3773: aload 32
    //   3775: ifnull +10 -> 3785
    //   3778: aload 32
    //   3780: aload 30
    //   3782: invokevirtual 144	badd:c	(Ljava/lang/String;)V
    //   3785: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3788: ifeq +63 -> 3851
    //   3791: ldc 237
    //   3793: iconst_2
    //   3794: new 219	java/lang/StringBuilder
    //   3797: dup
    //   3798: invokespecial 220	java/lang/StringBuilder:<init>	()V
    //   3801: ldc_w 837
    //   3804: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3807: aload 30
    //   3809: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3812: ldc_w 839
    //   3815: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3818: iload 8
    //   3820: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3823: ldc_w 841
    //   3826: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3829: iload 10
    //   3831: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3834: ldc_w 843
    //   3837: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3840: iload 11
    //   3842: invokevirtual 253	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3845: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3848: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3851: new 497	java/util/ArrayList
    //   3854: dup
    //   3855: invokespecial 498	java/util/ArrayList:<init>	()V
    //   3858: astore_3
    //   3859: aload_3
    //   3860: aload_2
    //   3861: invokevirtual 528	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3864: pop
    //   3865: aload_0
    //   3866: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3869: invokevirtual 418	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   3872: aload_3
    //   3873: aload 31
    //   3875: iconst_0
    //   3876: iconst_0
    //   3877: iconst_1
    //   3878: invokevirtual 846	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/util/ArrayList;Ljava/lang/String;ZZZ)V
    //   3881: iload 12
    //   3883: ifne -1933 -> 1950
    //   3886: aload_0
    //   3887: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3890: aload_3
    //   3891: invokevirtual 847	java/util/ArrayList:size	()I
    //   3894: iconst_1
    //   3895: iconst_1
    //   3896: invokevirtual 850	com/tencent/mobileqq/app/QQAppInterface:a	(IZZ)V
    //   3899: goto -1949 -> 1950
    //   3902: aload 37
    //   3904: lload 24
    //   3906: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   3909: putfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   3912: goto -684 -> 3228
    //   3915: iconst_0
    //   3916: istore 13
    //   3918: goto -682 -> 3236
    //   3921: iload 9
    //   3923: istore 8
    //   3925: goto -534 -> 3391
    //   3928: lload 22
    //   3930: lstore 20
    //   3932: goto -455 -> 3477
    //   3935: aload 27
    //   3937: ifnull +292 -> 4229
    //   3940: aload 27
    //   3942: invokeinterface 511 1 0
    //   3947: ifle +282 -> 4229
    //   3950: iload 6
    //   3952: ifeq +277 -> 4229
    //   3955: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3958: ifeq +12 -> 3970
    //   3961: ldc 237
    //   3963: iconst_2
    //   3964: ldc_w 852
    //   3967: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3970: iconst_0
    //   3971: istore 6
    //   3973: iload 6
    //   3975: aload 27
    //   3977: invokeinterface 511 1 0
    //   3982: if_icmpge +247 -> 4229
    //   3985: aload 27
    //   3987: iload 6
    //   3989: invokeinterface 514 2 0
    //   3994: checkcast 78	com/tencent/mobileqq/data/SubAccountMessage
    //   3997: astore_2
    //   3998: aload_2
    //   3999: ifnull +10 -> 4009
    //   4002: aload_2
    //   4003: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4006: ifnonnull +12 -> 4018
    //   4009: iload 6
    //   4011: iconst_1
    //   4012: iadd
    //   4013: istore 6
    //   4015: goto -42 -> 3973
    //   4018: aload_2
    //   4019: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4022: getstatic 697	alof:G	Ljava/lang/String;
    //   4025: invokestatic 260	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   4028: invokevirtual 715	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4031: ifne -22 -> 4009
    //   4034: aload_2
    //   4035: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4038: ldc2_w 82
    //   4041: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4044: invokevirtual 715	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4047: ifne -38 -> 4009
    //   4050: iconst_0
    //   4051: istore 8
    //   4053: aload 28
    //   4055: invokevirtual 853	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   4058: astore_3
    //   4059: iload 8
    //   4061: istore 7
    //   4063: aload_3
    //   4064: invokeinterface 544 1 0
    //   4069: ifeq +34 -> 4103
    //   4072: aload_3
    //   4073: invokeinterface 548 1 0
    //   4078: checkcast 85	java/lang/String
    //   4081: astore 31
    //   4083: aload 31
    //   4085: ifnull -26 -> 4059
    //   4088: aload_2
    //   4089: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4092: aload 31
    //   4094: invokevirtual 552	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4097: ifeq -38 -> 4059
    //   4100: iconst_1
    //   4101: istore 7
    //   4103: iload 7
    //   4105: ifeq +48 -> 4153
    //   4108: aload 33
    //   4110: aload_2
    //   4111: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4114: invokevirtual 856	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   4117: ifeq +36 -> 4153
    //   4120: aload 32
    //   4122: aload_0
    //   4123: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4126: lload 18
    //   4128: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4131: aload_2
    //   4132: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4135: aload 33
    //   4137: aload_2
    //   4138: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4141: invokevirtual 859	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4144: checkcast 281	java/lang/Integer
    //   4147: invokevirtual 862	java/lang/Integer:intValue	()I
    //   4150: invokevirtual 865	badd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;I)V
    //   4153: iload 7
    //   4155: ifne -146 -> 4009
    //   4158: aload 32
    //   4160: ifnull -151 -> 4009
    //   4163: aload 32
    //   4165: lload 18
    //   4167: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4170: aload_2
    //   4171: getfield 92	com/tencent/mobileqq/data/SubAccountMessage:frienduin	Ljava/lang/String;
    //   4174: invokevirtual 868	badd:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   4177: istore 7
    //   4179: iload 7
    //   4181: ifeq -172 -> 4009
    //   4184: aload_0
    //   4185: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4188: invokevirtual 407	com/tencent/mobileqq/app/QQAppInterface:a	()Labta;
    //   4191: aload 30
    //   4193: sipush 7000
    //   4196: iload 7
    //   4198: invokevirtual 415	abta:d	(Ljava/lang/String;II)V
    //   4201: aload_0
    //   4202: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4205: invokevirtual 418	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   4208: iconst_2
    //   4209: anewarray 85	java/lang/String
    //   4212: dup
    //   4213: iconst_0
    //   4214: getstatic 423	alof:x	Ljava/lang/String;
    //   4217: aastore
    //   4218: dup
    //   4219: iconst_1
    //   4220: aload 30
    //   4222: aastore
    //   4223: invokevirtual 428	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/Object;)V
    //   4226: goto -217 -> 4009
    //   4229: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4232: ifeq +17 -> 4249
    //   4235: aload 26
    //   4237: ifnull +152 -> 4389
    //   4240: ldc 237
    //   4242: iconst_2
    //   4243: ldc_w 870
    //   4246: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4249: aload 32
    //   4251: ifnull +12 -> 4263
    //   4254: aload 32
    //   4256: aload 30
    //   4258: aload 26
    //   4260: invokevirtual 263	badd:a	(Ljava/lang/String;[B)V
    //   4263: new 319	java/util/HashMap
    //   4266: dup
    //   4267: invokespecial 320	java/util/HashMap:<init>	()V
    //   4270: astore_2
    //   4271: aload_2
    //   4272: ldc_w 322
    //   4275: ldc_w 872
    //   4278: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4281: pop
    //   4282: aload_2
    //   4283: ldc_w 330
    //   4286: ldc_w 874
    //   4289: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4292: pop
    //   4293: aload_2
    //   4294: ldc_w 334
    //   4297: ldc_w 336
    //   4300: invokevirtual 328	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4303: pop
    //   4304: invokestatic 342	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4307: invokestatic 347	azri:a	(Landroid/content/Context;)Lazri;
    //   4310: aload_0
    //   4311: getfield 14	amll:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4314: invokevirtual 350	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4317: ldc_w 352
    //   4320: iconst_1
    //   4321: lconst_0
    //   4322: lconst_0
    //   4323: aload_2
    //   4324: ldc 123
    //   4326: invokevirtual 355	azri:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   4329: iload 4
    //   4331: ifle +85 -> 4416
    //   4334: lload 18
    //   4336: lconst_0
    //   4337: lcmp
    //   4338: ifle +63 -> 4401
    //   4341: aload_1
    //   4342: getfield 269	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4345: ldc_w 876
    //   4348: invokevirtual 277	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4351: astore_1
    //   4352: aload_1
    //   4353: ifnull +63 -> 4416
    //   4356: aload_0
    //   4357: iload 4
    //   4359: iload 5
    //   4361: lload 18
    //   4363: invokestatic 88	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4366: aload_1
    //   4367: aload 28
    //   4369: invokevirtual 879	amll:a	(BILjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   4372: aload 29
    //   4374: iconst_0
    //   4375: putfield 881	bade:jdField_a_of_type_Boolean	Z
    //   4378: aload_0
    //   4379: sipush 8003
    //   4382: iconst_1
    //   4383: aload 29
    //   4385: invokevirtual 169	amll:a	(IZLjava/lang/Object;)V
    //   4388: return
    //   4389: ldc 237
    //   4391: iconst_2
    //   4392: ldc_w 883
    //   4395: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4398: goto -149 -> 4249
    //   4401: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4404: ifeq +12 -> 4416
    //   4407: ldc 58
    //   4409: iconst_2
    //   4410: ldc_w 885
    //   4413: invokestatic 887	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4416: aload 29
    //   4418: iconst_0
    //   4419: putfield 166	bade:jdField_a_of_type_Int	I
    //   4422: aload_0
    //   4423: sipush 8003
    //   4426: iconst_1
    //   4427: aload 29
    //   4429: invokevirtual 169	amll:a	(IZLjava/lang/Object;)V
    //   4432: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4435: ifeq -4119 -> 316
    //   4438: ldc 237
    //   4440: iconst_2
    //   4441: ldc_w 889
    //   4444: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4447: return
    //   4448: astore_3
    //   4449: goto -1711 -> 2738
    //   4452: astore_3
    //   4453: goto -1787 -> 2666
    //   4456: aconst_null
    //   4457: astore_2
    //   4458: goto -1316 -> 3142
    //   4461: goto -1452 -> 3009
    //   4464: iconst_0
    //   4465: istore 8
    //   4467: goto -1543 -> 2924
    //   4470: goto -2990 -> 1480
    //   4473: aconst_null
    //   4474: astore 27
    //   4476: goto -3022 -> 1454
    //   4479: lconst_0
    //   4480: lstore 18
    //   4482: goto -3045 -> 1437
    //   4485: iconst_1
    //   4486: istore 6
    //   4488: iconst_0
    //   4489: istore 4
    //   4491: goto -3073 -> 1418
    //   4494: iconst_2
    //   4495: istore 5
    //   4497: goto -3092 -> 1405
    //   4500: aconst_null
    //   4501: astore 26
    //   4503: goto -3117 -> 1386
    //   4506: goto -3936 -> 570
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4509	0	this	amll
    //   0	4509	1	paramToServiceMsg	ToServiceMsg
    //   0	4509	2	paramFromServiceMsg	FromServiceMsg
    //   0	4509	3	paramObject	Object
    //   1413	3077	4	b	byte
    //   437	4059	5	i	int
    //   1416	3071	6	j	int
    //   1499	2698	7	k	int
    //   1998	2468	8	m	int
    //   1576	2346	9	n	int
    //   2019	1811	10	i1	int
    //   3746	95	11	i2	int
    //   797	3085	12	bool1	boolean
    //   3234	683	13	bool2	boolean
    //   1071	1493	14	l1	long
    //   1064	2345	16	l2	long
    //   1435	3046	18	l3	long
    //   1543	2388	20	l4	long
    //   2783	1146	22	l5	long
    //   1533	2372	24	l6	long
    //   81	4421	26	localObject1	Object
    //   141	83	27	localStringBuilder	StringBuilder
    //   1170	3	27	localException1	Exception
    //   1452	3023	27	localList1	List
    //   1464	2904	28	localArrayList	ArrayList
    //   7	4421	29	localbade	bade
    //   19	4238	30	str1	String
    //   25	4068	31	str2	String
    //   408	3847	32	localbadd	badd
    //   1487	2649	33	localHashMap	java.util.HashMap
    //   1496	18	34	localList2	List
    //   1818	861	35	localayzj	ayzj
    //   1948	13	36	localIterator1	Iterator
    //   1970	1933	37	localObject2	Object
    //   1988	1699	38	localObject3	Object
    //   2764	482	39	localStringBuffer	java.lang.StringBuffer
    //   2791	16	40	localIterator2	Iterator
    //   2955	3	41	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   83	106	317	java/lang/Exception
    //   106	122	317	java/lang/Exception
    //   1066	1073	1170	java/lang/Exception
    //   1203	1215	1316	java/lang/Exception
    //   2454	2493	2663	java/lang/Exception
    //   2675	2684	2735	java/lang/Exception
    //   2862	2877	2955	java/lang/Exception
    //   2688	2724	4448	java/lang/Exception
    //   2495	2527	4452	java/lang/Exception
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {}
    Object localObject;
    label222:
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
            if ((localObject != null) && (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null) && (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get() == 1)) {
              break label222;
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
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"0".equals(localObject)) && (TextUtils.equals((CharSequence)localObject, paramToServiceMsg)) && (TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
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
    new amln(this, paramObject, str, (String)localObject, i, j).execute(new Void[0]);
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
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691352);
      return f(paramMessageRecord, paramString);
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131720320);
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
      paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131720446);
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
    paramArrayList = (badd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
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
            localPbBindUinGetMsgReq.bind_uin_sig.set(ByteStringMicro.copyFrom(bdqa.a(paramString2)));
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
    paramFromServiceMsg = new bade();
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
    aors localaors;
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
      localaors = (aors)aoks.a().a(607);
    } while ((localaors == null) || (localaors.jdField_a_of_type_Boolean));
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
      localObject = ayzd.a(((MsgInfo)localObject).vMsg);
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
        azad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localReqBody, paramRequestPushNotify.lBindedUin, true);
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
    paramToServiceMsg = new badf();
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
    paramFromServiceMsg = new badf();
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
    long l = ayzl.a();
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
      bacu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, str, arrayOfByte, k, m, n, i1, i2);
      i += 1;
    }
    bacu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, j);
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
      localObject = (badd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
      if (localObject == null) {}
    }
    for (Object localObject = ((badd)localObject).a(paramString1);; localObject = null)
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
      paramArrayList = new badf();
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
    long l1 = ayzl.a();
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
            Ticket localTicket = localWtloginManager.GetLocalTicket((String)localObject2, 16L, 64);
            if ((localTicket == null) || (l1 > localTicket._expire_time)) {
              continue;
            }
            long l2 = Long.parseLong((String)localObject2);
            localThirdQQReqInfo.third_uin.set(l2);
            localThirdQQReqInfo.third_uin_sig.set(ByteStringMicro.copyFrom(bdqa.a((String)localObject3)));
            localObject3 = bacu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject2);
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
      paramArrayList = new badf();
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
      paramArrayList = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "PbMessageSvc.PbUnReadMsgSeq");
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
      ((Oidb_0x5d0.ReqBody)localObject1).uint32_start_time.set(bacu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramSubAccountInfo.subuin));
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
    if (alse.a(paramMessageRecord)) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691347);
    }
    if ((paramMessageRecord instanceof MessageForPic)) {
      return ((MessageForPic)paramMessageRecord).getSummaryMsg();
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691351);
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
    paramFromServiceMsg = new bade();
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
    paramToServiceMsg = new badf();
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
      } while (paramMessageRecord.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691346)));
    }
    if (TextUtils.isEmpty(paramMessageRecord))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691346);
      return paramString;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131691346) + paramMessageRecord;
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
      if (bdex.a(paramMessageRecord.msgtype))
      {
        paramMessageRecord = bdex.a(paramMessageRecord.msg);
        localObject = paramString;
        if (paramMessageRecord != null)
        {
          if ((paramMessageRecord.actMsgContentValue != null) && (paramMessageRecord.actMsgContentValue.length() > 0)) {
            return paramMessageRecord.actMsgContentValue;
          }
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(bdff.a(paramMessageRecord.shareAppID));
          return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690195) + paramMessageRecord.messagetail + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690196);
        }
      }
      else
      {
        localObject = paramString;
        if (!bdex.b(paramMessageRecord.msgtype))
        {
          localObject = paramString;
          if (paramMessageRecord.msg != null)
          {
            localObject = paramString;
            if (paramMessageRecord.msg.indexOf("http://maps.google.com/maps?q=") != -1)
            {
              localObject = azah.a(paramMessageRecord.msg);
              paramString = "";
              paramMessageRecord = paramString;
              if (localObject != null)
              {
                paramMessageRecord = paramString;
                if (localObject[2] != null) {
                  paramMessageRecord = localObject[2];
                }
              }
              paramMessageRecord = "[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131720922) + "] " + paramMessageRecord;
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
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131692099);
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getString(2131692099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amll
 * JD-Core Version:    0.7.0.1
 */