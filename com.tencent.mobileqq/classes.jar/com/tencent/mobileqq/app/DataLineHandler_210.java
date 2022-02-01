package com.tencent.mobileqq.app;

import IMMsgBodyPack.MsgType0x210SubMsgType0x13;
import IMMsgBodyPack.MsgType0x210SubMsgType0x13_MsgItem;
import IMMsgBodyPack.Type_1_QQDataTextMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.service.TextMsgPush;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class DataLineHandler_210
  extends DataLineHandler
{
  public DataLineHandler_210(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type == 1L) {
      b(paramInt, paramShort, paramMsgType0x210SubMsgType0x13);
    }
  }
  
  private void b(int paramInt, short paramShort, MsgType0x210SubMsgType0x13 paramMsgType0x210SubMsgType0x13)
  {
    if (paramMsgType0x210SubMsgType0x13.uint32_type != 1L) {
      return;
    }
    TextMsgPush localTextMsgPush;
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid)))
    {
      localTextMsgPush = new TextMsgPush(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint32_size), Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid), localTextMsgPush);
    }
    else
    {
      localTextMsgPush = (TextMsgPush)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
    }
    Type_1_QQDataTextMsg localType_1_QQDataTextMsg = new Type_1_QQDataTextMsg();
    localType_1_QQDataTextMsg.readFrom(new JceInputStream(paramMsgType0x210SubMsgType0x13.bytes_buf));
    Object localObject = new String();
    int i = 0;
    while (i < localType_1_QQDataTextMsg.msg_item.size())
    {
      String str = new String(((MsgType0x210SubMsgType0x13_MsgItem)localType_1_QQDataTextMsg.msg_item.get(i)).bytes_text);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str);
      localObject = localStringBuilder.toString();
      if (QLog.isColorLevel()) {
        QLog.d("DataLineHandler", 2, str);
      }
      i += 1;
    }
    localTextMsgPush.a((int)paramMsgType0x210SubMsgType0x13.uint32_index, (String)localObject);
    if (localTextMsgPush.a())
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
      localObject = new DataLineMsgRecord();
      ((DataLineMsgRecord)localObject).msgId = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
      ((DataLineMsgRecord)localObject).sessionid = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
      ((DataLineMsgRecord)localObject).msg = localTextMsgPush.a();
      ((DataLineMsgRecord)localObject).msgtype = -1000;
      ((DataLineMsgRecord)localObject).issend = 0;
      ((DataLineMsgRecord)localObject).isread = false;
      ((DataLineMsgRecord)localObject).time = paramInt;
      ((DataLineMsgRecord)localObject).issuc = true;
      ((DataLineMsgRecord)localObject).sessionid = ((DataLineMsgRecord)localObject).msgId;
      ((DataLineMsgRecord)localObject).shmsgseq = paramShort;
      paramShort = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject).sessionid);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramShort).a((DataLineMsgRecord)localObject, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.handleReceivedMessage(1, true, true);
      a(8, true, new Object[] { Integer.valueOf(paramInt), localTextMsgPush.a(), Long.valueOf(((DataLineMsgRecord)localObject).sessionid) });
    }
  }
  
  /* Error */
  public void a(msf.msgcomm.msg_comm.Msg paramMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 205	com/tencent/mobileqq/app/DataLineHandler:a	(Lmsf/msgcomm/msg_comm$Msg;)V
    //   5: new 207	msf/msgcomm/msg_comm$MsgType0x210
    //   8: dup
    //   9: invokespecial 208	msf/msgcomm/msg_comm$MsgType0x210:<init>	()V
    //   12: astore 12
    //   14: aload 12
    //   16: aload_1
    //   17: getfield 214	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   20: invokevirtual 219	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   23: checkcast 216	tencent/im/msg/im_msg_body$MsgBody
    //   26: getfield 223	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   29: invokevirtual 228	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   32: invokevirtual 234	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   35: invokevirtual 238	msf/msgcomm/msg_comm$MsgType0x210:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   38: checkcast 207	msf/msgcomm/msg_comm$MsgType0x210
    //   41: astore 13
    //   43: aload 13
    //   45: astore 12
    //   47: goto +21 -> 68
    //   50: astore 13
    //   52: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +13 -> 68
    //   58: ldc 113
    //   60: iconst_2
    //   61: ldc 240
    //   63: aload 13
    //   65: invokestatic 244	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   68: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +11 -> 82
    //   74: ldc 113
    //   76: iconst_2
    //   77: ldc 246
    //   79: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: new 61	com/qq/taf/jce/JceInputStream
    //   85: dup
    //   86: aload 12
    //   88: getfield 247	msf/msgcomm/msg_comm$MsgType0x210:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   91: invokevirtual 228	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   94: invokevirtual 234	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   97: invokespecial 68	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   100: astore 12
    //   102: new 249	IMMsgBodyPack/MsgType0x210
    //   105: dup
    //   106: invokespecial 250	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   109: astore 13
    //   111: aload 13
    //   113: aload 12
    //   115: invokevirtual 251	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   118: new 130	com/tencent/mobileqq/data/DataLineMsgRecord
    //   121: dup
    //   122: invokespecial 131	com/tencent/mobileqq/data/DataLineMsgRecord:<init>	()V
    //   125: astore 12
    //   127: aload 12
    //   129: aload_1
    //   130: getfield 255	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   133: invokevirtual 258	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: checkcast 257	msf/msgcomm/msg_comm$MsgHead
    //   139: getfield 262	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 266	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: i2l
    //   146: putfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   149: aload 12
    //   151: aload_1
    //   152: getfield 255	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   155: invokevirtual 258	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 257	msf/msgcomm/msg_comm$MsgHead
    //   161: getfield 269	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: invokevirtual 266	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   167: i2l
    //   168: putfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   171: aload 12
    //   173: aload_1
    //   174: getfield 255	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   177: invokevirtual 258	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   180: checkcast 257	msf/msgcomm/msg_comm$MsgHead
    //   183: getfield 273	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   186: invokevirtual 278	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   189: putfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   192: aload_0
    //   193: aload 12
    //   195: iconst_1
    //   196: invokevirtual 281	com/tencent/mobileqq/app/DataLineHandler_210:a	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;I)Z
    //   199: ifeq +72 -> 271
    //   202: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +750 -> 955
    //   208: new 96	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   215: astore_1
    //   216: aload_1
    //   217: ldc_w 283
    //   220: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: aload 12
    //   227: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   230: invokevirtual 286	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_1
    //   235: ldc_w 288
    //   238: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_1
    //   243: aload 12
    //   245: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   248: invokevirtual 286	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_1
    //   253: ldc_w 290
    //   256: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: ldc 113
    //   262: iconst_2
    //   263: aload_1
    //   264: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: return
    //   271: aload_0
    //   272: getfield 170	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   275: getstatic 295	com/tencent/mobileqq/app/BusinessHandlerFactory:REGPRXYSVCPACK_HANDLER	Ljava/lang/String;
    //   278: invokevirtual 299	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   281: checkcast 301	com/tencent/mobileqq/app/RegisterProxySvcPackHandler
    //   284: astore_1
    //   285: aload_1
    //   286: ifnull +16 -> 302
    //   289: aload_1
    //   290: invokevirtual 303	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:d	()I
    //   293: iconst_1
    //   294: if_icmpeq +8 -> 302
    //   297: aload_1
    //   298: iconst_1
    //   299: invokevirtual 306	com/tencent/mobileqq/app/RegisterProxySvcPackHandler:e	(I)V
    //   302: aload 13
    //   304: getfield 309	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   307: ldc2_w 310
    //   310: lcmp
    //   311: ifne +78 -> 389
    //   314: aload_0
    //   315: aload 13
    //   317: getfield 315	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   320: getfield 318	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_app_id	J
    //   323: l2i
    //   324: aload 13
    //   326: getfield 315	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   329: getfield 321	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_inst_id	J
    //   332: l2i
    //   333: invokevirtual 324	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   336: ifeq +4 -> 340
    //   339: return
    //   340: aload_0
    //   341: aload 13
    //   343: getfield 315	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   346: getfield 327	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_app_id	J
    //   349: l2i
    //   350: aload 13
    //   352: getfield 315	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   355: getfield 330	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_inst_id	J
    //   358: l2i
    //   359: invokevirtual 332	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   362: ifne +4 -> 366
    //   365: return
    //   366: aload_0
    //   367: aload 12
    //   369: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   372: l2i
    //   373: aload 12
    //   375: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   378: l2i
    //   379: i2s
    //   380: aload 13
    //   382: getfield 315	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   385: invokespecial 334	com/tencent/mobileqq/app/DataLineHandler_210:a	(ISLIMMsgBodyPack/MsgType0x210SubMsgType0x13;)V
    //   388: return
    //   389: aload 13
    //   391: getfield 309	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   394: ldc2_w 335
    //   397: lcmp
    //   398: ifne +207 -> 605
    //   401: aload_0
    //   402: aload 13
    //   404: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   407: getfield 345	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcAppId	J
    //   410: l2i
    //   411: aload 13
    //   413: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   416: getfield 348	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcInstId	J
    //   419: l2i
    //   420: invokevirtual 324	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   423: ifeq +4 -> 427
    //   426: return
    //   427: aload_0
    //   428: aload 13
    //   430: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   433: getfield 351	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstAppId	J
    //   436: l2i
    //   437: aload 13
    //   439: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   442: getfield 354	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstInstId	J
    //   445: l2i
    //   446: invokevirtual 332	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   449: ifne +4 -> 453
    //   452: return
    //   453: aload_0
    //   454: getfield 357	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   457: astore_1
    //   458: aload 13
    //   460: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   463: getfield 360	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lSessionId	J
    //   466: lstore_2
    //   467: aload 13
    //   469: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   472: getfield 363	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uOriginfiletype	J
    //   475: lstore 4
    //   477: aload 13
    //   479: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   482: getfield 366	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstUin	J
    //   485: lstore 6
    //   487: new 74	java/lang/String
    //   490: dup
    //   491: aload 13
    //   493: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   496: getfield 369	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileName	[B
    //   499: invokespecial 94	java/lang/String:<init>	([B)V
    //   502: astore 14
    //   504: aload 13
    //   506: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   509: getfield 372	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lFileLen	J
    //   512: lstore 8
    //   514: aload 13
    //   516: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   519: getfield 375	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileMd5	[B
    //   522: astore 15
    //   524: new 74	java/lang/String
    //   527: dup
    //   528: aload 13
    //   530: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   533: getfield 378	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileIndex	[B
    //   536: invokespecial 94	java/lang/String:<init>	([B)V
    //   539: astore 16
    //   541: aload 13
    //   543: getfield 340	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   546: getfield 381	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strOriginfile_md5	[B
    //   549: astore 13
    //   551: aload_1
    //   552: lload_2
    //   553: lload 4
    //   555: lload 6
    //   557: aload 14
    //   559: lload 8
    //   561: aload 15
    //   563: aload 16
    //   565: aload 13
    //   567: iconst_0
    //   568: iconst_0
    //   569: iconst_0
    //   570: iconst_0
    //   571: aload 12
    //   573: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   576: l2i
    //   577: i2l
    //   578: aload 12
    //   580: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   583: l2i
    //   584: i2s
    //   585: i2l
    //   586: aload 12
    //   588: getfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   591: iconst_0
    //   592: invokevirtual 387	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFTNNotify_0x210	(JJJLjava/lang/String;J[BLjava/lang/String;[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   595: astore_1
    //   596: aload_0
    //   597: getfield 390	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   600: aload_1
    //   601: invokevirtual 396	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   604: return
    //   605: aload 13
    //   607: getfield 309	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   610: ldc2_w 397
    //   613: lcmp
    //   614: ifne +220 -> 834
    //   617: aload_0
    //   618: aload 13
    //   620: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   623: getfield 405	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcAppId	J
    //   626: l2i
    //   627: aload 13
    //   629: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   632: getfield 406	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcInstId	J
    //   635: l2i
    //   636: invokevirtual 324	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   639: ifeq +4 -> 643
    //   642: return
    //   643: aload_0
    //   644: aload 13
    //   646: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   649: getfield 407	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstAppId	J
    //   652: l2i
    //   653: aload 13
    //   655: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   658: getfield 408	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstInstId	J
    //   661: l2i
    //   662: invokevirtual 332	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   665: ifne +4 -> 669
    //   668: return
    //   669: aload_0
    //   670: getfield 357	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   673: astore_1
    //   674: aload 13
    //   676: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   679: getfield 409	IMMsgBodyPack/MsgType0x210SubMsgType0xa:lSessionId	J
    //   682: lstore_2
    //   683: aload 13
    //   685: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   688: getfield 410	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uOriginfiletype	J
    //   691: lstore 4
    //   693: aload 13
    //   695: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   698: getfield 411	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstUin	J
    //   701: lstore 6
    //   703: new 74	java/lang/String
    //   706: dup
    //   707: aload 13
    //   709: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   712: getfield 412	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strFileName	[B
    //   715: invokespecial 94	java/lang/String:<init>	([B)V
    //   718: astore 14
    //   720: aload 13
    //   722: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   725: getfield 415	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uFileLen	J
    //   728: lstore 8
    //   730: aload 13
    //   732: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   735: getfield 418	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vMd5	[B
    //   738: astore 15
    //   740: aload 13
    //   742: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   745: getfield 421	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerIp	J
    //   748: lstore 10
    //   750: aload_1
    //   751: lload_2
    //   752: lload 4
    //   754: lload 6
    //   756: aload 14
    //   758: lload 8
    //   760: aload 15
    //   762: lload 10
    //   764: aload 13
    //   766: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   769: getfield 424	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerPort	J
    //   772: aload 13
    //   774: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   777: getfield 427	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vUrlNotify	[B
    //   780: aload 13
    //   782: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   785: getfield 430	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vTokenKey	[B
    //   788: aload 13
    //   790: getfield 402	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   793: getfield 431	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strOriginfile_md5	[B
    //   796: iconst_0
    //   797: iconst_0
    //   798: iconst_0
    //   799: iconst_0
    //   800: aload 12
    //   802: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   805: l2i
    //   806: i2l
    //   807: aload 12
    //   809: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   812: l2i
    //   813: i2s
    //   814: i2l
    //   815: aload 12
    //   817: getfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   820: iconst_0
    //   821: invokevirtual 435	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromNFCNotify_0x210	(JJJLjava/lang/String;J[BJJ[B[B[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   824: astore_1
    //   825: aload_0
    //   826: getfield 390	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   829: aload_1
    //   830: invokevirtual 396	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   833: return
    //   834: aload 13
    //   836: getfield 309	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   839: ldc2_w 436
    //   842: lcmp
    //   843: ifne +105 -> 948
    //   846: aload_0
    //   847: aload 13
    //   849: getfield 441	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   852: getfield 444	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_app_id	J
    //   855: l2i
    //   856: aload 13
    //   858: getfield 441	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   861: getfield 445	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_inst_id	J
    //   864: l2i
    //   865: invokevirtual 324	com/tencent/mobileqq/app/DataLineHandler_210:a	(II)Z
    //   868: ifeq +4 -> 872
    //   871: return
    //   872: aload_0
    //   873: aload 13
    //   875: getfield 441	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   878: getfield 446	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_app_id	J
    //   881: l2i
    //   882: aload 13
    //   884: getfield 441	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   887: getfield 447	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_inst_id	J
    //   890: l2i
    //   891: invokevirtual 332	com/tencent/mobileqq/app/DataLineHandler_210:b	(II)Z
    //   894: ifne +4 -> 898
    //   897: return
    //   898: aload_0
    //   899: getfield 357	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   902: aload 13
    //   904: getfield 441	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   907: getfield 448	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint64_sessionid	J
    //   910: aload 13
    //   912: getfield 441	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   915: getfield 451	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_operate	J
    //   918: iconst_0
    //   919: aload 12
    //   921: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   924: l2i
    //   925: aload 12
    //   927: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   930: l2i
    //   931: i2s
    //   932: invokevirtual 455	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFileControl_0x210	(JJIIS)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   935: astore_1
    //   936: aload_0
    //   937: getfield 390	com/tencent/mobileqq/app/DataLineHandler_210:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   940: aload_1
    //   941: invokevirtual 396	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   944: return
    //   945: astore_1
    //   946: aload_1
    //   947: athrow
    //   948: return
    //   949: astore_1
    //   950: return
    //   951: astore_1
    //   952: goto +8 -> 960
    //   955: return
    //   956: astore_1
    //   957: goto -11 -> 946
    //   960: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	961	0	this	DataLineHandler_210
    //   0	961	1	paramMsg	msf.msgcomm.msg_comm.Msg
    //   466	286	2	l1	long
    //   475	278	4	l2	long
    //   485	270	6	l3	long
    //   512	247	8	l4	long
    //   748	15	10	l5	long
    //   12	914	12	localObject1	Object
    //   41	3	13	localMsgType0x210	msf.msgcomm.msg_comm.MsgType0x210
    //   50	14	13	localException	java.lang.Exception
    //   109	802	13	localObject2	Object
    //   502	255	14	str1	String
    //   522	239	15	arrayOfByte	byte[]
    //   539	25	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   14	43	50	java/lang/Exception
    //   111	270	945	finally
    //   271	285	945	finally
    //   289	302	945	finally
    //   302	339	945	finally
    //   340	365	945	finally
    //   366	388	945	finally
    //   389	426	945	finally
    //   427	452	945	finally
    //   453	551	945	finally
    //   596	604	945	finally
    //   605	642	945	finally
    //   643	668	945	finally
    //   669	750	945	finally
    //   825	833	945	finally
    //   834	871	945	finally
    //   872	897	945	finally
    //   898	944	945	finally
    //   111	270	949	java/lang/Exception
    //   271	285	949	java/lang/Exception
    //   289	302	949	java/lang/Exception
    //   302	339	949	java/lang/Exception
    //   340	365	949	java/lang/Exception
    //   366	388	949	java/lang/Exception
    //   389	426	949	java/lang/Exception
    //   427	452	949	java/lang/Exception
    //   453	551	949	java/lang/Exception
    //   596	604	949	java/lang/Exception
    //   605	642	949	java/lang/Exception
    //   643	668	949	java/lang/Exception
    //   669	750	949	java/lang/Exception
    //   825	833	949	java/lang/Exception
    //   834	871	949	java/lang/Exception
    //   872	897	949	java/lang/Exception
    //   898	944	949	java/lang/Exception
    //   551	596	951	java/lang/Exception
    //   750	825	951	java/lang/Exception
    //   551	596	956	finally
    //   750	825	956	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler_210
 * JD-Core Version:    0.7.0.1
 */