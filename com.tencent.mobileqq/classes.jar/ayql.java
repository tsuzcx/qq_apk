import PushNotifyPack.GroupMsgReadedNotify;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;

public class ayql
  extends akaf
{
  public Comparator b = new ayqm(this);
  
  public ayql(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  /* Error */
  private long a(ArrayList<msg_comm.Msg> paramArrayList, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 26	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 29	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 32	ayql:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:a	()Lawao;
    //   16: aload 4
    //   18: invokevirtual 42	awao:b	(Ljava/lang/String;)J
    //   21: lstore 9
    //   23: aload_1
    //   24: ifnonnull +6 -> 30
    //   27: lload 9
    //   29: lreturn
    //   30: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +41 -> 74
    //   36: ldc 50
    //   38: iconst_2
    //   39: new 52	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   46: ldc 55
    //   48: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload 4
    //   53: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc 61
    //   58: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual 65	java/util/ArrayList:size	()I
    //   65: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_1
    //   75: invokevirtual 80	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   78: astore 25
    //   80: aload 25
    //   82: invokeinterface 85 1 0
    //   87: ifeq +678 -> 765
    //   90: aload 25
    //   92: invokeinterface 89 1 0
    //   97: checkcast 91	msf/msgcomm/msg_comm$Msg
    //   100: astore 26
    //   102: aload 26
    //   104: ifnull -24 -> 80
    //   107: aload 26
    //   109: getfield 95	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   112: invokevirtual 101	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   115: checkcast 97	msf/msgcomm/msg_comm$MsgHead
    //   118: astore_1
    //   119: aload_1
    //   120: getfield 105	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   123: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   126: i2l
    //   127: lstore 11
    //   129: aload_1
    //   130: getfield 113	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   133: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   136: lstore 13
    //   138: aload_1
    //   139: getfield 121	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   142: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   145: lstore 15
    //   147: aload_1
    //   148: getfield 124	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   151: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   154: lstore 17
    //   156: aload_1
    //   157: getfield 127	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   160: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   163: i2l
    //   164: lstore 19
    //   166: aload_1
    //   167: getfield 130	msf/msgcomm/msg_comm$MsgHead:user_active	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   170: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   173: istore 6
    //   175: aload_1
    //   176: getfield 133	msf/msgcomm/msg_comm$MsgHead:from_instid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   182: istore 7
    //   184: aload_1
    //   185: getfield 137	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   188: invokevirtual 140	msf/msgcomm/msg_comm$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   191: checkcast 139	msf/msgcomm/msg_comm$GroupInfo
    //   194: astore_1
    //   195: aload_1
    //   196: getfield 143	msf/msgcomm/msg_comm$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   199: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   202: istore 8
    //   204: aload_1
    //   205: getfield 146	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   208: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   211: lstore 21
    //   213: aload_1
    //   214: getfield 149	msf/msgcomm/msg_comm$GroupInfo:group_info_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   217: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   220: lstore 23
    //   222: new 151	aylt
    //   225: dup
    //   226: invokespecial 152	aylt:<init>	()V
    //   229: astore 27
    //   231: aload_1
    //   232: getfield 156	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 161	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   238: ifeq +497 -> 735
    //   241: aload_1
    //   242: getfield 156	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   245: invokevirtual 164	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   248: ifnull +487 -> 735
    //   251: aload_1
    //   252: getfield 156	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 164	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 170	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: astore_1
    //   262: new 172	java/lang/String
    //   265: dup
    //   266: aload_1
    //   267: ldc 174
    //   269: invokespecial 177	java/lang/String:<init>	([BLjava/lang/String;)V
    //   272: astore_1
    //   273: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +173 -> 449
    //   279: ldc 50
    //   281: iconst_2
    //   282: new 52	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   289: ldc 55
    //   291: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload 4
    //   296: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc 179
    //   301: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: lload 17
    //   306: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   309: ldc 184
    //   311: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: lload 15
    //   316: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   319: ldc 186
    //   321: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: lload 19
    //   326: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   329: ldc 188
    //   331: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: lload 11
    //   336: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   339: ldc 190
    //   341: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: lload 13
    //   346: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   349: ldc 192
    //   351: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: iload 6
    //   356: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc 194
    //   361: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 7
    //   366: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: ldc 196
    //   371: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: lload 21
    //   376: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   379: ldc 198
    //   381: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: iload 8
    //   386: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: ldc 200
    //   391: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: lload 23
    //   396: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   399: ldc 202
    //   401: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: aload_1
    //   405: invokestatic 207	azzz:a	(Ljava/lang/String;)Ljava/lang/String;
    //   408: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: ldc 209
    //   413: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 26
    //   418: getfield 213	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   421: invokevirtual 216	msf/msgcomm/msg_comm$AppShareInfo:has	()Z
    //   424: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   427: ldc 221
    //   429: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 26
    //   434: getfield 225	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   437: invokevirtual 228	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   440: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   443: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   446: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   449: new 26	java/util/ArrayList
    //   452: dup
    //   453: invokespecial 29	java/util/ArrayList:<init>	()V
    //   456: astore 28
    //   458: new 230	awbl
    //   461: dup
    //   462: invokespecial 231	awbl:<init>	()V
    //   465: astore_1
    //   466: aload_1
    //   467: aload 4
    //   469: invokestatic 237	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   472: invokevirtual 240	java/lang/Long:longValue	()J
    //   475: putfield 244	awbl:e	J
    //   478: aload_1
    //   479: iconst_1
    //   480: putfield 248	awbl:jdField_c_of_type_Int	I
    //   483: aload_1
    //   484: iload 8
    //   486: putfield 250	awbl:d	I
    //   489: aload 26
    //   491: getfield 254	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   494: invokevirtual 257	msf/msgcomm/msg_comm$ContentHead:has	()Z
    //   497: ifeq +112 -> 609
    //   500: aload 26
    //   502: getfield 254	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   505: invokevirtual 258	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   508: checkcast 256	msf/msgcomm/msg_comm$ContentHead
    //   511: astore 29
    //   513: aload 29
    //   515: getfield 261	msf/msgcomm/msg_comm$ContentHead:div_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   518: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   521: istore 6
    //   523: aload 29
    //   525: getfield 264	msf/msgcomm/msg_comm$ContentHead:pkg_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   528: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   531: istore 7
    //   533: aload 29
    //   535: getfield 267	msf/msgcomm/msg_comm$ContentHead:pkg_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   538: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   541: istore 8
    //   543: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +63 -> 609
    //   549: ldc 50
    //   551: iconst_2
    //   552: new 52	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 269
    //   562: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: aload 4
    //   567: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: ldc_w 271
    //   573: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: iload 6
    //   578: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: ldc_w 273
    //   584: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: iload 7
    //   589: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   592: ldc_w 275
    //   595: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: iload 8
    //   600: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   603: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: invokestatic 280	java/lang/System:currentTimeMillis	()J
    //   612: lstore 13
    //   614: aload_0
    //   615: aload 26
    //   617: aload 28
    //   619: aload_1
    //   620: iconst_1
    //   621: aload 27
    //   623: invokevirtual 283	ayql:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/util/ArrayList;Lawbl;ZLaylt;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   626: astore_1
    //   627: aload_1
    //   628: ifnull +10 -> 638
    //   631: aload 5
    //   633: aload_1
    //   634: invokevirtual 287	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   637: pop
    //   638: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   641: ifeq +49 -> 690
    //   644: invokestatic 280	java/lang/System:currentTimeMillis	()J
    //   647: lstore 15
    //   649: ldc 50
    //   651: iconst_2
    //   652: new 52	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 289
    //   662: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload 4
    //   667: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc_w 291
    //   673: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: lload 15
    //   678: lload 13
    //   680: lsub
    //   681: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   684: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: aload 28
    //   692: ifnull -612 -> 80
    //   695: aload 28
    //   697: invokevirtual 65	java/util/ArrayList:size	()I
    //   700: ifeq -620 -> 80
    //   703: aload 28
    //   705: invokestatic 296	ajml:a	(Ljava/util/List;)V
    //   708: aload_3
    //   709: aload 28
    //   711: invokevirtual 300	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   714: pop
    //   715: lload 11
    //   717: lload 9
    //   719: lcmp
    //   720: ifle +42 -> 762
    //   723: lload 11
    //   725: lstore 9
    //   727: goto -647 -> 80
    //   730: astore_1
    //   731: aload_1
    //   732: invokevirtual 303	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   735: aconst_null
    //   736: astore_1
    //   737: goto -464 -> 273
    //   740: astore_1
    //   741: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   744: ifeq +13 -> 757
    //   747: ldc 50
    //   749: iconst_2
    //   750: ldc_w 305
    //   753: aload_1
    //   754: invokestatic 309	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   757: aconst_null
    //   758: astore_1
    //   759: goto -132 -> 627
    //   762: goto -35 -> 727
    //   765: invokestatic 280	java/lang/System:currentTimeMillis	()J
    //   768: lstore 11
    //   770: aload_0
    //   771: getfield 32	ayql:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   774: bipush 52
    //   776: invokevirtual 313	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   779: checkcast 315	com/tencent/mobileqq/app/TroopManager
    //   782: aload 5
    //   784: invokevirtual 318	com/tencent/mobileqq/app/TroopManager:a	(Ljava/util/List;)Z
    //   787: pop
    //   788: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   791: ifeq +119 -> 910
    //   794: invokestatic 280	java/lang/System:currentTimeMillis	()J
    //   797: lstore 13
    //   799: ldc 50
    //   801: iconst_2
    //   802: new 52	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   809: ldc_w 320
    //   812: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload 4
    //   817: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: ldc_w 291
    //   823: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: lload 13
    //   828: lload 11
    //   830: lsub
    //   831: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   834: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   840: lload 13
    //   842: lstore 11
    //   844: aload_3
    //   845: ifnull +10 -> 855
    //   848: aload_0
    //   849: aload_3
    //   850: aload_2
    //   851: iconst_1
    //   852: invokevirtual 323	ayql:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V
    //   855: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   858: ifeq +49 -> 907
    //   861: invokestatic 280	java/lang/System:currentTimeMillis	()J
    //   864: lstore 13
    //   866: ldc 50
    //   868: iconst_2
    //   869: new 52	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   876: ldc_w 325
    //   879: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload 4
    //   884: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: ldc_w 291
    //   890: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: lload 13
    //   895: lload 11
    //   897: lsub
    //   898: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   901: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   907: lload 9
    //   909: lreturn
    //   910: goto -66 -> 844
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	913	0	this	ayql
    //   0	913	1	paramArrayList	ArrayList<msg_comm.Msg>
    //   0	913	2	paramArrayList1	ArrayList<MessageRecord>
    //   0	913	3	paramArrayList2	ArrayList<MessageRecord>
    //   0	913	4	paramString1	String
    //   0	913	5	paramString2	String
    //   173	404	6	i	int
    //   182	406	7	j	int
    //   202	397	8	k	int
    //   21	887	9	l1	long
    //   127	769	11	l2	long
    //   136	758	13	l3	long
    //   145	532	15	l4	long
    //   154	151	17	l5	long
    //   164	161	19	l6	long
    //   211	164	21	l7	long
    //   220	175	23	l8	long
    //   78	13	25	localIterator	java.util.Iterator
    //   100	516	26	localMsg	msg_comm.Msg
    //   229	393	27	localaylt	aylt
    //   456	254	28	localArrayList	ArrayList
    //   511	23	29	localContentHead	msg_comm.ContentHead
    // Exception table:
    //   from	to	target	type
    //   262	273	730	java/io/UnsupportedEncodingException
    //   614	627	740	java/lang/Exception
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList<msg_comm.Msg> paramArrayList, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, String paramString)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("groupuin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = String.valueOf(paramPbGetGroupMsgResp.group_code.get());
    }
    localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1);
    if (paramArrayList != null) {
      l1 = a(paramArrayList, (ArrayList)localObject2, (ArrayList)localObject3, (String)localObject1, paramString);
    }
    for (;;)
    {
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).e((String)localObject1);
      boolean bool2 = false;
      boolean bool1 = false;
      long l2;
      if ((paramPbGetGroupMsgResp.result.get() == 104) && (((ArrayList)localObject2).size() == 0))
      {
        l2 = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetGroupMsgResp.return_end_seq.get());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "initGetPullTroopMsg reply 104 !! reqEndSeq = " + l2);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1, l2);
      }
      for (int j = 1;; j = 0)
      {
        paramArrayList = new StringBuilder(128);
        int i;
        label693:
        boolean bool3;
        if (((ArrayList)localObject2).size() > 0)
        {
          Collections.sort((List)localObject2, this.b);
          paramToServiceMsg = new ArrayList();
          paramPbGetGroupMsgResp = new ArrayList();
          i = ((ArrayList)localObject2).size() - 1;
          if (i >= 0)
          {
            localObject3 = (MessageRecord)((ArrayList)localObject2).get(i);
            if (QLog.isColorLevel())
            {
              paramArrayList.setLength(0);
              paramArrayList.append("----------initGetPullTroopMsg update send message  mr.senderuin: ").append(((MessageRecord)localObject3).senderuin).append(" mr.msgtype: ").append(((MessageRecord)localObject3).msgtype).append(" mr.frienduin: ").append(((MessageRecord)localObject3).frienduin).append(" mr.shmsgseq: ").append(((MessageRecord)localObject3).shmsgseq).append(" mr.time:").append(((MessageRecord)localObject3).time).append(" mr.msg: ").append(((MessageRecord)localObject3).getLogColorContent());
              QLog.d("Q.msg.TroopMessageProcessor", 2, paramArrayList.toString());
            }
            if (((((MessageRecord)localObject3).senderuin != null) && (((MessageRecord)localObject3).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || ((mnf.a((MessageRecord)localObject3)) && (mnf.b((MessageRecord)localObject3))))
            {
              if (mnf.a((MessageRecord)localObject3))
              {
                ((MessageRecord)localObject3).senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
                localObject4 = mnf.a((MessageRecord)localObject3);
                mnf.a().a(((MessageRecord)localObject3).frienduin, ((MessageRecord)localObject3).vipBubbleID, ((mng)localObject4).jdField_b_of_type_Int, ((mng)localObject4).jdField_b_of_type_JavaLangString, ((mng)localObject4).jdField_c_of_type_Int, ((mng)localObject4).a, ((mng)localObject4).jdField_c_of_type_JavaLangString);
              }
              Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject3).frienduin, 1, (MessageRecord)localObject3);
              if (localObject4 == null) {
                break label693;
              }
              if (((localObject3 instanceof MessageForText)) && ((localObject4 instanceof MessageForText)) && (((MessageRecord)localObject3).getRepeatCount() > 0))
              {
                ((MessageRecord)localObject4).setRepeatCount(((MessageRecord)localObject3).getRepeatCount());
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.TroopMessageProcessor", 2, "<---initGetPullTroopMsg_PB ===> update findMr.repeatCount=" + ((MessageRecord)localObject3).getRepeatCount());
                }
              }
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d()) {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject4).frienduin, ((MessageRecord)localObject4).istroop, ((MessageRecord)localObject4).uniseq);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject3).frienduin, 1, ((MessageRecord)localObject4).uniseq, ((MessageRecord)localObject3).shmsgseq, ((MessageRecord)localObject3).time);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, ((MessageRecord)localObject3).shmsgseq);
            }
            for (;;)
            {
              i -= 1;
              break;
              if (!paramPbGetGroupMsgResp.contains(((MessageRecord)localObject3).senderuin)) {
                paramPbGetGroupMsgResp.add(((MessageRecord)localObject3).senderuin);
              }
              paramToServiceMsg.add(0, localObject3);
            }
          }
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (paramPbGetGroupMsgResp != null) && (paramPbGetGroupMsgResp.size() > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (awao.a == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              awao.a = new awat();
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if (awao.a.a == null)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
              awao.a.a = new ConcurrentHashMap();
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            awao.a.a.put(localObject1, paramPbGetGroupMsgResp);
          }
          if (paramToServiceMsg.size() > 0)
          {
            paramPbGetGroupMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1);
            if (paramPbGetGroupMsgResp == null) {
              break label1359;
            }
            paramArrayList = (akab)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1);
            l2 = ((Long)paramPbGetGroupMsgResp[0]).longValue();
            int k = paramToServiceMsg.size();
            i = 0;
            while (i < k)
            {
              paramPbGetGroupMsgResp = (MessageRecord)paramToServiceMsg.get(i);
              if ((paramPbGetGroupMsgResp instanceof MessageForMarketFace)) {
                arny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)paramPbGetGroupMsgResp);
              }
              if ((((MessageRecord)paramToServiceMsg.get(i)).senderuin != null) && (((MessageRecord)paramToServiceMsg.get(i)).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
              {
                ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
                ((MessageRecord)paramToServiceMsg.get(i)).issend = 2;
              }
              if (l2 >= ((MessageRecord)paramToServiceMsg.get(i)).shmsgseq) {
                ((MessageRecord)paramToServiceMsg.get(i)).isread = true;
              }
              i += 1;
            }
            if (paramArrayList.a((String)localObject1, 1, paramToServiceMsg, paramString)) {
              break label1359;
            }
            bool2 = ajml.a(paramToServiceMsg);
            bool3 = ajml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg);
            i = akbm.a(paramToServiceMsg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramPbGetGroupMsgResp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
            if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop))
            {
              bool1 = true;
              paramPbGetGroupMsgResp.a(paramToServiceMsg, paramString, bool1, false);
              paramArrayList.c((String)localObject1, 1, l2);
              paramArrayList.a((String)localObject1, paramToServiceMsg);
              bool1 = bool3;
            }
          }
        }
        for (;;)
        {
          if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1) == 1))
          {
            paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1);
            if (paramArrayList != null)
            {
              l2 = ((Long)paramArrayList[0]).longValue();
              ((akab)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1)).c((String)localObject1, 1, l2);
            }
          }
          if (l1 >= 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.TroopMessageProcessor", 2, "groupMsgRecordHandle info.lGroupCode: " + (String)localObject1 + " info.lsMsgSeq: " + l1);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, l1);
          }
          bool3 = ajml.b(paramToServiceMsg);
          a("initGetPullTroopMsg", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool1, bool3, paramToServiceMsg), false);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg);
          ((baov)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a(paramToServiceMsg);
          if (paramToServiceMsg.size() > 0) {
            akbf.a((MessageRecord)paramToServiceMsg.get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          return;
          bool1 = false;
          break;
          j = 1;
          i = 0;
          bool1 = false;
          bool2 = false;
          continue;
          j = 1;
          paramToServiceMsg = (ToServiceMsg)localObject2;
          i = 0;
          continue;
          label1359:
          i = 0;
          bool1 = false;
          bool2 = false;
        }
      }
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, ArrayList<msg_comm.Msg> paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 26	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 29	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: new 151	aylt
    //   12: dup
    //   13: invokespecial 152	aylt:<init>	()V
    //   16: astore 22
    //   18: aload_3
    //   19: ifnull +685 -> 704
    //   22: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +32 -> 57
    //   28: ldc 50
    //   30: iconst_2
    //   31: new 52	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 609
    //   41: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_3
    //   45: invokevirtual 65	java/util/ArrayList:size	()I
    //   48: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: new 26	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 29	java/util/ArrayList:<init>	()V
    //   64: astore 23
    //   66: aload_3
    //   67: invokevirtual 80	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   70: astore 24
    //   72: aload 24
    //   74: invokeinterface 85 1 0
    //   79: ifeq +607 -> 686
    //   82: aload 24
    //   84: invokeinterface 89 1 0
    //   89: checkcast 91	msf/msgcomm/msg_comm$Msg
    //   92: astore 25
    //   94: aload 25
    //   96: ifnull -24 -> 72
    //   99: aload 25
    //   101: getfield 95	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   104: invokevirtual 101	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   107: checkcast 97	msf/msgcomm/msg_comm$MsgHead
    //   110: astore_3
    //   111: aload_3
    //   112: getfield 105	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   118: i2l
    //   119: lstore 8
    //   121: aload_3
    //   122: getfield 113	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   125: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   128: lstore 10
    //   130: aload_3
    //   131: getfield 121	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   134: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   137: lstore 12
    //   139: aload_3
    //   140: getfield 124	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   143: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   146: lstore 14
    //   148: aload_3
    //   149: getfield 127	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   152: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   155: i2l
    //   156: lstore 16
    //   158: aload_3
    //   159: getfield 130	msf/msgcomm/msg_comm$MsgHead:user_active	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   162: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   165: istore 5
    //   167: aload_3
    //   168: getfield 133	msf/msgcomm/msg_comm$MsgHead:from_instid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   171: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   174: istore 6
    //   176: aload_3
    //   177: getfield 137	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   180: invokevirtual 140	msf/msgcomm/msg_comm$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   183: checkcast 139	msf/msgcomm/msg_comm$GroupInfo
    //   186: astore 26
    //   188: aload 26
    //   190: getfield 143	msf/msgcomm/msg_comm$GroupInfo:group_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   193: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   196: istore 7
    //   198: aload 26
    //   200: getfield 146	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   203: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   206: lstore 18
    //   208: aload 26
    //   210: getfield 149	msf/msgcomm/msg_comm$GroupInfo:group_info_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   213: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   216: lstore 20
    //   218: aload 26
    //   220: getfield 156	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   223: invokevirtual 161	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   226: ifeq +433 -> 659
    //   229: aload 26
    //   231: getfield 156	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   234: invokevirtual 164	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   237: ifnull +422 -> 659
    //   240: aload 26
    //   242: getfield 156	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   245: invokevirtual 164	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   248: invokevirtual 170	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   251: astore_3
    //   252: new 172	java/lang/String
    //   255: dup
    //   256: aload_3
    //   257: ldc 174
    //   259: invokespecial 177	java/lang/String:<init>	([BLjava/lang/String;)V
    //   262: astore_3
    //   263: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   266: ifeq +181 -> 447
    //   269: ldc 50
    //   271: iconst_2
    //   272: new 52	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 611
    //   282: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: lload 14
    //   287: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   290: ldc 184
    //   292: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: lload 12
    //   297: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: ldc 186
    //   302: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: lload 16
    //   307: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   310: ldc 188
    //   312: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: lload 8
    //   317: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   320: ldc 190
    //   322: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: lload 10
    //   327: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   330: ldc 192
    //   332: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload 5
    //   337: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc 194
    //   342: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: iload 6
    //   347: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc 196
    //   352: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: lload 18
    //   357: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   360: ldc 198
    //   362: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: iload 7
    //   367: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   370: ldc 200
    //   372: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: lload 20
    //   377: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: ldc_w 613
    //   383: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 26
    //   388: getfield 156	msf/msgcomm/msg_comm$GroupInfo:group_card	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   391: invokevirtual 161	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   394: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   397: ldc 202
    //   399: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_3
    //   403: invokestatic 207	azzz:a	(Ljava/lang/String;)Ljava/lang/String;
    //   406: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc 209
    //   411: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 25
    //   416: getfield 213	msf/msgcomm/msg_comm$Msg:appshare_info	Lmsf/msgcomm/msg_comm$AppShareInfo;
    //   419: invokevirtual 216	msf/msgcomm/msg_comm$AppShareInfo:has	()Z
    //   422: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   425: ldc 221
    //   427: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 25
    //   432: getfield 225	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   435: invokevirtual 228	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   438: invokevirtual 219	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   441: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: new 26	java/util/ArrayList
    //   450: dup
    //   451: invokespecial 29	java/util/ArrayList:<init>	()V
    //   454: astore 26
    //   456: new 230	awbl
    //   459: dup
    //   460: invokespecial 231	awbl:<init>	()V
    //   463: astore_3
    //   464: aload_3
    //   465: aload_2
    //   466: getfield 344	msf/msgsvc/msg_svc$PbGetGroupMsgResp:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   469: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   472: putfield 244	awbl:e	J
    //   475: aload_3
    //   476: iconst_1
    //   477: putfield 248	awbl:jdField_c_of_type_Int	I
    //   480: aload_3
    //   481: iload 7
    //   483: putfield 250	awbl:d	I
    //   486: aload 25
    //   488: getfield 254	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   491: invokevirtual 257	msf/msgcomm/msg_comm$ContentHead:has	()Z
    //   494: ifeq +101 -> 595
    //   497: aload 25
    //   499: getfield 254	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   502: invokevirtual 258	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   505: checkcast 256	msf/msgcomm/msg_comm$ContentHead
    //   508: astore 27
    //   510: aload 27
    //   512: getfield 261	msf/msgcomm/msg_comm$ContentHead:div_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   515: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   518: istore 5
    //   520: aload 27
    //   522: getfield 264	msf/msgcomm/msg_comm$ContentHead:pkg_index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   525: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   528: istore 6
    //   530: aload 27
    //   532: getfield 267	msf/msgcomm/msg_comm$ContentHead:pkg_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   535: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   538: istore 7
    //   540: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +52 -> 595
    //   546: ldc 50
    //   548: iconst_2
    //   549: new 52	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 615
    //   559: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload 5
    //   564: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   567: ldc_w 273
    //   570: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: iload 6
    //   575: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   578: ldc_w 275
    //   581: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: iload 7
    //   586: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: aload_0
    //   596: aload 25
    //   598: aload 26
    //   600: aload_3
    //   601: iconst_1
    //   602: aload 22
    //   604: invokevirtual 283	ayql:a	(Lmsf/msgcomm/msg_comm$Msg;Ljava/util/ArrayList;Lawbl;ZLaylt;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   607: astore_3
    //   608: aload_3
    //   609: ifnull +15 -> 624
    //   612: aload_3
    //   613: iconst_m1
    //   614: putfield 620	com/tencent/mobileqq/data/TroopMemberInfo:level	I
    //   617: aload 23
    //   619: aload_3
    //   620: invokevirtual 287	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   623: pop
    //   624: aload 26
    //   626: invokevirtual 65	java/util/ArrayList:size	()I
    //   629: ifeq -557 -> 72
    //   632: aload 26
    //   634: invokestatic 296	ajml:a	(Ljava/util/List;)V
    //   637: aload 4
    //   639: ifnull -567 -> 72
    //   642: aload_0
    //   643: aload 26
    //   645: aload 4
    //   647: iconst_1
    //   648: invokevirtual 323	ayql:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V
    //   651: goto -579 -> 72
    //   654: astore_3
    //   655: aload_3
    //   656: invokevirtual 303	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   659: aconst_null
    //   660: astore_3
    //   661: goto -398 -> 263
    //   664: astore_3
    //   665: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq +13 -> 681
    //   671: ldc 50
    //   673: iconst_2
    //   674: ldc_w 305
    //   677: aload_3
    //   678: invokestatic 309	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   681: aconst_null
    //   682: astore_3
    //   683: goto -75 -> 608
    //   686: aload_0
    //   687: getfield 32	ayql:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   690: bipush 52
    //   692: invokevirtual 313	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   695: checkcast 315	com/tencent/mobileqq/app/TroopManager
    //   698: aload 23
    //   700: invokevirtual 318	com/tencent/mobileqq/app/TroopManager:a	(Ljava/util/List;)Z
    //   703: pop
    //   704: aload 4
    //   706: invokevirtual 80	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   709: astore_3
    //   710: aload_3
    //   711: invokeinterface 85 1 0
    //   716: ifeq +55 -> 771
    //   719: aload_3
    //   720: invokeinterface 89 1 0
    //   725: checkcast 383	com/tencent/mobileqq/data/MessageRecord
    //   728: astore 23
    //   730: aload 23
    //   732: getfield 392	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   735: ifnull +27 -> 762
    //   738: aload 23
    //   740: getfield 392	com/tencent/mobileqq/data/MessageRecord:senderuin	Ljava/lang/String;
    //   743: aload_0
    //   744: getfield 32	ayql:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   747: invokevirtual 420	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   750: invokevirtual 539	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   753: ifeq +9 -> 762
    //   756: aload 23
    //   758: iconst_2
    //   759: putfield 546	com/tencent/mobileqq/data/MessageRecord:issend	I
    //   762: aload 23
    //   764: iconst_1
    //   765: putfield 543	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   768: goto -58 -> 710
    //   771: aload 4
    //   773: aload_0
    //   774: getfield 17	ayql:b	Ljava/util/Comparator;
    //   777: invokestatic 378	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   780: aload_2
    //   781: getfield 344	msf/msgsvc/msg_svc$PbGetGroupMsgResp:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   784: invokevirtual 623	java/lang/Object:toString	()Ljava/lang/String;
    //   787: astore_3
    //   788: aload_0
    //   789: getfield 32	ayql:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   792: bipush 37
    //   794: invokevirtual 313	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   797: checkcast 625	arom
    //   800: aload_3
    //   801: aload 22
    //   803: invokevirtual 628	arom:a	(Ljava/lang/String;Laylt;)Laylt;
    //   806: pop
    //   807: aload_1
    //   808: getfield 334	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   811: ldc_w 630
    //   814: invokevirtual 634	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   817: astore_1
    //   818: new 26	java/util/ArrayList
    //   821: dup
    //   822: invokespecial 29	java/util/ArrayList:<init>	()V
    //   825: astore_3
    //   826: aload_1
    //   827: ifnull +39 -> 866
    //   830: aload_1
    //   831: ldc_w 636
    //   834: aload_2
    //   835: getfield 639	msf/msgsvc/msg_svc$PbGetGroupMsgResp:return_begin_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   838: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   841: invokevirtual 642	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   844: aload_1
    //   845: ldc_w 644
    //   848: aload_2
    //   849: getfield 360	msf/msgsvc/msg_svc$PbGetGroupMsgResp:return_end_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   852: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   855: invokevirtual 642	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   858: aload_1
    //   859: ldc_w 646
    //   862: iconst_1
    //   863: invokevirtual 650	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   866: aload_0
    //   867: getfield 32	ayql:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   870: invokevirtual 456	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   873: aload_2
    //   874: getfield 344	msf/msgsvc/msg_svc$PbGetGroupMsgResp:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   877: invokevirtual 118	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   880: invokestatic 347	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   883: iconst_1
    //   884: aload 4
    //   886: aload_3
    //   887: aload_1
    //   888: invokevirtual 653	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Landroid/os/Bundle;)V
    //   891: aload_0
    //   892: getfield 485	ayql:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   895: aload_3
    //   896: invokevirtual 592	com/tencent/mobileqq/app/MessageHandler:b	(Ljava/util/ArrayList;)V
    //   899: aload_0
    //   900: getfield 32	ayql:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   903: sipush 235
    //   906: invokevirtual 313	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   909: checkcast 594	baov
    //   912: getfield 597	baov:a	Lanbw;
    //   915: aload 4
    //   917: invokevirtual 600	anbw:a	(Ljava/util/List;)V
    //   920: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	921	0	this	ayql
    //   0	921	1	paramToServiceMsg	ToServiceMsg
    //   0	921	2	paramPbGetGroupMsgResp	msg_svc.PbGetGroupMsgResp
    //   0	921	3	paramArrayList	ArrayList<msg_comm.Msg>
    //   0	921	4	paramString	String
    //   165	398	5	i	int
    //   174	400	6	j	int
    //   196	389	7	k	int
    //   119	197	8	l1	long
    //   128	198	10	l2	long
    //   137	159	12	l3	long
    //   146	140	14	l4	long
    //   156	150	16	l5	long
    //   206	150	18	l6	long
    //   216	160	20	l7	long
    //   16	786	22	localaylt	aylt
    //   64	699	23	localObject1	Object
    //   70	13	24	localIterator	java.util.Iterator
    //   92	505	25	localMsg	msg_comm.Msg
    //   186	458	26	localObject2	Object
    //   508	23	27	localContentHead	msg_comm.ContentHead
    // Exception table:
    //   from	to	target	type
    //   252	263	654	java/io/UnsupportedEncodingException
    //   595	608	664	java/lang/Exception
  }
  
  private void a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---TroopMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.TroopMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, boolean paramBoolean)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).group_info.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
    }
    long l1;
    Object localObject3;
    long l2;
    long l3;
    long l5;
    int n;
    label178:
    long l4;
    Object localObject4;
    int k;
    int i;
    int j;
    label302:
    String str;
    awbl localawbl;
    Object localObject5;
    boolean bool1;
    label587:
    Object localObject2;
    for (;;)
    {
      return;
      l1 = System.currentTimeMillis();
      localObject3 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
      l2 = ((msg_comm.MsgHead)localObject1).from_uin.get();
      long l6 = ((msg_comm.MsgHead)localObject1).to_uin.get();
      l3 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
      l5 = ((msg_comm.MsgHead)localObject1).msg_time.get();
      long l7 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
      int i1 = ((msg_comm.MsgHead)localObject1).user_active.get();
      int i2 = ((msg_comm.MsgHead)localObject1).from_instid.get();
      long l8 = ((msg_comm.GroupInfo)localObject3).group_code.get();
      n = ((msg_comm.GroupInfo)localObject3).group_type.get();
      long l9 = ((msg_comm.GroupInfo)localObject3).group_info_seq.get();
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        l4 = ((Long)localObject1).longValue();
        if ((!((msg_comm.GroupInfo)localObject3).group_card.has()) || (((msg_comm.GroupInfo)localObject3).group_card.get() == null)) {
          break label587;
        }
        localObject1 = ((msg_comm.GroupInfo)localObject3).group_card.get().toByteArray();
      }
      for (;;)
      {
        try
        {
          localObject1 = new String((byte[])localObject1, "utf-8");
          localObject3 = new ArrayList();
          if (!paramMsg.content_head.has()) {
            break label2860;
          }
          localObject4 = (msg_comm.ContentHead)paramMsg.content_head.get();
          k = ((msg_comm.ContentHead)localObject4).div_seq.get();
          i = ((msg_comm.ContentHead)localObject4).pkg_index.get();
          int m = ((msg_comm.ContentHead)localObject4).pkg_num.get();
          j = i;
          i = m;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int = i1;
          str = String.valueOf(l8);
          if ((localObject1 != null) && (((String)localObject1).length() > 0)) {}
          localObject4 = new ArrayList();
          localawbl = new awbl();
          localawbl.e = l8;
          localawbl.jdField_c_of_type_Int = 1;
          localawbl.d = n;
          if (QLog.isColorLevel())
          {
            localObject5 = new StringBuilder().append("<---handleMsgPush_PB_Group : needAck ").append(paramBoolean).append(" pushMsg ");
            if (paramPbPushMsg == null) {
              break label593;
            }
            bool1 = true;
            QLog.d("Q.msg.TroopMessageProcessor", 2, bool1);
          }
          if ((paramBoolean) && (paramPbPushMsg != null)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l4, paramPbPushMsg.svrip.get(), paramFromServiceMsg.getRequestSsoSeq(), paramPbPushMsg);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str) != 2) {
            break label599;
          }
          paramBoolean = true;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a()) {
            break;
          }
          paramPbPushMsg = (arom)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(37);
          if (MessageHandler.b) {
            break label605;
          }
          if (paramBoolean) {
            break label643;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, new Object[] { paramMsg, paramFromServiceMsg });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : unfinished troopuin=" + str);
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
        break label178;
        localObject2 = null;
        continue;
        label593:
        bool1 = false;
        continue;
        label599:
        paramBoolean = false;
      }
      label605:
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, new Object[] { paramMsg, paramFromServiceMsg });
        return;
      }
      label643:
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder("<---handleMsgPush_PB_Group : before analysis :");
        ((StringBuilder)localObject5).append(" fromUin:").append(l2).append(" toUin:").append(l6).append(" msgTime:").append(l5).append(" msgSeq:").append(l3).append(" msgUid:").append(l7).append(" userActive:").append(i1).append(" fromInstid:").append(i2).append(" groupCode:").append(l8).append(" groupType:").append(n).append(" groupSeq:").append(l9).append(" cardName:").append(azzz.a((String)localObject2)).append(" hasAppShare:").append(paramMsg.appshare_info.has()).append(" bFinished:").append(paramBoolean).append(" divSeq:").append(k).append(" pkgIndex:").append(j).append(" pkgNum:").append(i);
        QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject5).toString());
        if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
        {
          l6 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() / 1000L;
          QLog.d("Q.msg.TroopMessageProcessor", 2, "push_cost=" + (l6 - l5) + ",type=GROUP_PUSH_MSG");
        }
      }
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).e(str);
      paramFromServiceMsg = new aylt();
      try
      {
        a(paramMsg, (ArrayList)localObject3, localawbl, true, paramFromServiceMsg);
        ajml.a((List)localObject3);
        if (((ArrayList)localObject3).size() == 0)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : msg list is empty after decode.");
        }
      }
      catch (Exception paramMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
          }
        }
        if (localObject4 != null) {
          a((ArrayList)localObject3, (ArrayList)localObject4, true);
        }
        localObject2 = new ArrayList();
        if (localObject4 == null) {
          break label2537;
        }
      }
    }
    Object localObject6;
    if (((ArrayList)localObject4).size() > 0)
    {
      k = ((ArrayList)localObject4).size();
      j = 0;
      if (j < k)
      {
        localObject5 = (MessageRecord)((ArrayList)localObject4).get(j);
        if ((l2 == 10000L) && ((localObject5 instanceof MessageForStructing)))
        {
          paramMsg = (MessageForStructing)localObject5;
          if ((paramMsg != null) && (paramMsg.structingMsg != null) && (paramMsg.structingMsg.mMsgServiceID == 60))
          {
            paramMsg = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
            localObject6 = String.valueOf(l4);
            if (paramMsg == null) {
              break label2852;
            }
            paramMsg = paramMsg.b(str);
            if (paramMsg == null) {
              break label2846;
            }
            if ((!TextUtils.isEmpty(paramMsg.troopowneruin)) || (!TextUtils.isEmpty(paramMsg.Administrator))) {
              break label1876;
            }
            i = 0;
            label1179:
            if ((i != 2) || (paramMsg == null)) {
              ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).c(Long.parseLong(str));
            }
          }
        }
        if ((localObject5 instanceof MessageForMarketFace)) {
          arny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)localObject5);
        }
        if (QLog.isColorLevel())
        {
          paramMsg = new StringBuilder("<---handleMsgPush_PB_Group : after analysis :");
          paramMsg.append(" mr.senderuin:").append(((MessageRecord)localObject5).senderuin).append(" mr.msgtype:").append(((MessageRecord)localObject5).msgtype).append(" mr.frienduin:").append(((MessageRecord)localObject5).frienduin).append(" mr.shmsgseq:").append(((MessageRecord)localObject5).shmsgseq).append(" mr.time:").append(((MessageRecord)localObject5).time).append(" mr.msg:").append(((MessageRecord)localObject5).getLogColorContent());
          QLog.d("Q.msg.TroopMessageProcessor", 2, paramMsg.toString());
        }
        if (((((MessageRecord)localObject5).senderuin != null) && (((MessageRecord)localObject5).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) || ((mnf.a((MessageRecord)localObject5)) && (mnf.b((MessageRecord)localObject5))))
        {
          if (mnf.a((MessageRecord)localObject5))
          {
            ((MessageRecord)localObject5).senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            paramMsg = mnf.a((MessageRecord)localObject5);
            mnf.a().a(String.valueOf(localawbl.e), ((MessageRecord)localObject5).vipBubbleID, paramMsg.jdField_b_of_type_Int, paramMsg.jdField_b_of_type_JavaLangString, paramMsg.jdField_c_of_type_Int, paramMsg.a, paramMsg.jdField_c_of_type_JavaLangString);
          }
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, (MessageRecord)localObject5);
          label1829:
          label1850:
          label1867:
          label1876:
          if (localObject6 != null)
          {
            if (((localObject5 instanceof MessageForText)) && ((localObject6 instanceof MessageForText)) && (((MessageRecord)localObject5).getRepeatCount() > 0))
            {
              ((MessageRecord)localObject6).setRepeatCount(((MessageRecord)localObject5).getRepeatCount());
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group ===> update findMr.repeatCount=" + ((MessageRecord)localObject6).getRepeatCount());
              }
            }
            l5 = ((MessageRecord)localObject6).shmsgseq;
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(((MessageRecord)localObject5).frienduin, 1, ((MessageRecord)localObject6).uniseq, ((MessageRecord)localObject5).shmsgseq, ((MessageRecord)localObject5).time);
            if (((MessageRecord)localObject5).msgtype == -2011)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
              paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, ((MessageRecord)localObject5).shmsgseq, -5020);
              if ((paramMsg != null) && ((paramMsg instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramMsg).tipParam != null) && (((MessageForUniteGrayTip)paramMsg).tipParam.jdField_b_of_type_Int == 3276802))
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f(((MessageRecord)localObject5).frienduin, 1, paramMsg.uniseq);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageRecord)localObject5).frienduin, 1, paramMsg);
                QLog.i("Q.msg.TroopMessageProcessor" + axdz.i, 1, "updateGroupMsgSeqAndTime. docs gray msg. shmsgseq = " + ((MessageRecord)localObject5).shmsgseq + ", grayMsgType = " + -5020 + ", grayUniSeq = " + paramMsg.uniseq);
              }
            }
            label1773:
            while (((MessageRecord)localObject5).msgtype != -2000)
            {
              if (((MessageRecord)localObject6).msgtype != -2017) {
                break label2174;
              }
              paramMsg = akbm.a((MessageRecord)localObject6, (MessageRecord)localObject5);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, ((MessageRecord)localObject6).uniseq, paramMsg);
              acvh.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageRecord)localObject6).uniseq);
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject6)) {
                break label2450;
              }
              a((MessageRecord)localObject6);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, ((MessageRecord)localObject5).shmsgseq);
              j += 1;
              break;
              if ((!TextUtils.isEmpty(paramMsg.troopowneruin)) && (paramMsg.troopowneruin.equalsIgnoreCase((String)localObject6)))
              {
                i = 0;
                break label1179;
              }
              if ((TextUtils.isEmpty(paramMsg.Administrator)) || (!paramMsg.Administrator.contains((CharSequence)localObject6))) {
                break label2846;
              }
              i = 1;
              break label1179;
            }
          }
        }
      }
    }
    label2450:
    label2841:
    label2846:
    label2852:
    label2860:
    label2872:
    for (;;)
    {
      try
      {
        paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(((MessageRecord)localObject5).frienduin, 1, l5, -5040);
        if ((paramMsg == null) || (paramMsg.size() <= 0)) {
          break label2841;
        }
        paramMsg = (MessageRecord)paramMsg.get(paramMsg.size() - 1);
        if (!QLog.isColorLevel()) {
          break label2872;
        }
        QLog.i("Q.msg.TroopMessageProcessorTroopGrayTipUtils", 2, "updateGroupMsgSeqAndTime. grayMr = " + paramMsg);
      }
      catch (Exception paramMsg)
      {
        QLog.i("Q.msg.TroopMessageProcessorTroopGrayTipUtils", 1, "update grayTip seq exception", paramMsg);
      }
      if ((paramMsg == null) || (!(paramMsg instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMsg).tipParam == null) || (((MessageForUniteGrayTip)paramMsg).tipParam.jdField_b_of_type_Int != 131086)) {
        break label1773;
      }
      l5 = Long.parseLong(paramMsg.getExtInfoFromExtStr("grayLastUniseq"));
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.TroopMessageProcessorTroopGrayTipUtils", 2, "updateGroupMsgSeqAndTime. TroopGrayTip. grayMr.lastUniseq=" + l5);
      }
      if (l5 != ((MessageRecord)localObject6).uniseq) {
        break label1773;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, paramMsg.uniseq, ((MessageRecord)localObject5).shmsgseq, ((MessageRecord)localObject5).time);
      break label1773;
      break label1773;
      label2174:
      if ((awvt.a((MessageRecord)localObject6)) || (((MessageRecord)localObject6).msgtype == -2048))
      {
        if (((MessageRecord)localObject5).msgtype == -2048)
        {
          paramMsg = (MessageForTroopReward)localObject5;
          paramMsg.mediaPath = ((MessageForTroopReward)localObject6).mediaPath;
          paramMsg.prewrite();
          ((MessageRecord)localObject5).msgData = paramMsg.msgData;
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_reward", 2, "replace msg,rewardId:" + paramMsg.rewardId);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, ((MessageRecord)localObject6).uniseq);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, ((MessageRecord)localObject6).uniseq, ((MessageRecord)localObject5).msgData);
        a(999, true, ((MessageRecord)localObject5).frienduin);
        break label1829;
      }
      if (((MessageRecord)localObject6).msgtype != -1049) {
        break label1829;
      }
      paramMsg = (MessageForReplyText)localObject6;
      ((MessageForReplyText)localObject5).extStr = paramMsg.extStr;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, ((MessageRecord)localObject6).uniseq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, ((MessageRecord)localObject6).uniseq, "extStr", ((MessageRecord)localObject5).extStr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, ((MessageRecord)localObject6).uniseq, "extLong", Integer.valueOf(((MessageRecord)localObject5).extLong));
      break label1829;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((MessageRecord)localObject5, (MessageRecord)localObject6);
      break label1850;
      ((MessageRecord)localObject5).isread = true;
      ((MessageRecord)localObject5).issend = 2;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject5).frienduin, 1, ((MessageRecord)localObject5).shmsgseq);
      ((ArrayList)localObject2).add(localObject5);
      if (!(localObject5 instanceof MessageForTroopFile)) {
        break label1867;
      }
      ((axgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(272)).a((ChatMessage)localObject5);
      break label1867;
      label2537:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject2);
      bool1 = ajml.a((ArrayList)localObject2);
      boolean bool2 = ajml.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)localObject2);
      boolean bool3 = ajml.b((ArrayList)localObject2);
      i = akbm.a((List)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramPbPushMsg.a(str, paramFromServiceMsg);
      paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((bool1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramMsg.a((ArrayList)localObject2, String.valueOf(l4), paramBoolean);
        awqe.a(0, 1, 1, ((ArrayList)localObject2).size());
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, l3);
          paramMsg = (MessageRecord)((ArrayList)localObject3).get(0);
          ((azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203)).c(paramMsg);
        }
        if (n == 127) {
          break;
        }
        a("handleMsgPush_PB_Group", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool1, bool2, bool3, (List)localObject2), false);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
        ((baov)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a((List)localObject4);
        l1 = System.currentTimeMillis() - l1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "decodecMsg cost:" + l1);
        }
        akbf.a("actGroupDecodeCost", l1);
        if (((ArrayList)localObject4).size() <= 0) {
          break;
        }
        akbf.a((MessageRecord)((ArrayList)localObject4).get(0), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      paramMsg = null;
      continue;
      i = 2;
      break label1179;
      paramMsg = null;
      i = 2;
      break label1179;
      i = 0;
      j = 0;
      k = 0;
      break label302;
    }
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, awbl paramawbl)
  {
    return null;
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList;
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2], ((Boolean)paramVarArgs[3]).booleanValue());
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetGroupMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      localArrayList = new ArrayList();
      a((ArrayList)paramVarArgs[2], localArrayList);
      a((ToServiceMsg)paramVarArgs[0], (msg_svc.PbGetGroupMsgResp)paramVarArgs[1], localArrayList, (String)paramVarArgs[3]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    String str = String.valueOf(paramGroupMsgReadedNotify.lGroupCode);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "GroupMsgReadedNotify lGroupCode is " + paramGroupMsgReadedNotify.lGroupCode + ", lMemberSeq  is " + paramGroupMsgReadedNotify.lMemberSeq);
    }
    Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str);
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2))
    {
      long l = ((Long)arrayOfObject[0]).longValue();
      ((Long)arrayOfObject[1]).longValue();
      if (l < paramGroupMsgReadedNotify.lMemberSeq) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, new Object[] { Long.valueOf(paramGroupMsgReadedNotify.lMemberSeq), Long.valueOf(paramGroupMsgReadedNotify.lGroupMsgSeq) });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 1, paramGroupMsgReadedNotify.lMemberSeq);
    if (paramGroupMsgReadedNotify.lMemberSeq >= 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.a(str, 1);
    }
    paramGroupMsgReadedNotify = (azhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132);
    if (paramGroupMsgReadedNotify.b(str))
    {
      paramGroupMsgReadedNotify.d(str);
      if (!paramGroupMsgReadedNotify.a(str)) {
        paramGroupMsgReadedNotify.b(str);
      }
    }
  }
  
  public void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.TroopMessageProcessor", 2, "doSomeAfterGetPullTroopMsg doSome:" + paramInt + " troopUin:" + paramString);
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    }
    ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).a(paramString, paramPbGetGroupMsgResp, paramInt);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayql
 * JD-Core Version:    0.7.0.1
 */