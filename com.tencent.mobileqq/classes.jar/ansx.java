import IMMsgBodyPack.MsgType0x210SubMsgType0x13;
import IMMsgBodyPack.MsgType0x210SubMsgType0x13_MsgItem;
import IMMsgBodyPack.Type_1_QQDataTextMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class ansx
  extends ansr
{
  public ansx(QQAppInterface paramQQAppInterface)
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
    if (paramMsgType0x210SubMsgType0x13.uint32_type != 1L) {}
    bcqc localbcqc;
    do
    {
      return;
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid)))
      {
        localbcqc = new bcqc(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint32_size), Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid), localbcqc);
      }
      for (;;)
      {
        Type_1_QQDataTextMsg localType_1_QQDataTextMsg = new Type_1_QQDataTextMsg();
        localType_1_QQDataTextMsg.readFrom(new JceInputStream(paramMsgType0x210SubMsgType0x13.bytes_buf));
        localObject = new String();
        int i = 0;
        while (i < localType_1_QQDataTextMsg.msg_item.size())
        {
          String str = new String(((MsgType0x210SubMsgType0x13_MsgItem)localType_1_QQDataTextMsg.msg_item.get(i)).bytes_text);
          localObject = (String)localObject + str;
          if (QLog.isColorLevel()) {
            QLog.d("DataLineHandler", 2, str);
          }
          i += 1;
        }
        localbcqc = (bcqc)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
      }
      localbcqc.a((int)paramMsgType0x210SubMsgType0x13.uint32_index, (String)localObject);
    } while (!localbcqc.a());
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramMsgType0x210SubMsgType0x13.uint64_sessionid));
    Object localObject = new DataLineMsgRecord();
    ((DataLineMsgRecord)localObject).msgId = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).sessionid = paramMsgType0x210SubMsgType0x13.uint64_sessionid;
    ((DataLineMsgRecord)localObject).msg = localbcqc.a();
    ((DataLineMsgRecord)localObject).msgtype = -1000;
    ((DataLineMsgRecord)localObject).issend = 0;
    ((DataLineMsgRecord)localObject).isread = false;
    ((DataLineMsgRecord)localObject).time = paramInt;
    ((DataLineMsgRecord)localObject).issuc = true;
    ((DataLineMsgRecord)localObject).sessionid = ((DataLineMsgRecord)localObject).msgId;
    ((DataLineMsgRecord)localObject).shmsgseq = paramShort;
    paramShort = DataLineMsgRecord.getDevTypeBySeId(((DataLineMsgRecord)localObject).sessionid);
    this.app.getMessageFacade().getDatalineMessageManager(paramShort).a((DataLineMsgRecord)localObject, true);
    this.app.handleReceivedMessage(1, true, true);
    a(8, true, new Object[] { Integer.valueOf(paramInt), localbcqc.a(), Long.valueOf(((DataLineMsgRecord)localObject).sessionid) });
  }
  
  /* Error */
  public void a(msf.msgcomm.msg_comm.Msg paramMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 207	ansr:a	(Lmsf/msgcomm/msg_comm$Msg;)V
    //   5: new 209	msf/msgcomm/msg_comm$MsgType0x210
    //   8: dup
    //   9: invokespecial 210	msf/msgcomm/msg_comm$MsgType0x210:<init>	()V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_1
    //   15: getfield 216	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   18: invokevirtual 221	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   21: checkcast 218	tencent/im/msg/im_msg_body$MsgBody
    //   24: getfield 225	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   27: invokevirtual 230	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   30: invokevirtual 236	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   33: invokevirtual 240	msf/msgcomm/msg_comm$MsgType0x210:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   36: checkcast 209	msf/msgcomm/msg_comm$MsgType0x210
    //   39: astore_3
    //   40: aload_3
    //   41: astore_2
    //   42: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +11 -> 56
    //   48: ldc 110
    //   50: iconst_2
    //   51: ldc 242
    //   53: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: new 57	com/qq/taf/jce/JceInputStream
    //   59: dup
    //   60: aload_2
    //   61: getfield 243	msf/msgcomm/msg_comm$MsgType0x210:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   64: invokevirtual 230	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   67: invokevirtual 236	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   70: invokespecial 64	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   73: astore_3
    //   74: new 245	IMMsgBodyPack/MsgType0x210
    //   77: dup
    //   78: invokespecial 246	IMMsgBodyPack/MsgType0x210:<init>	()V
    //   81: astore_2
    //   82: aload_2
    //   83: aload_3
    //   84: invokevirtual 247	IMMsgBodyPack/MsgType0x210:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   87: new 130	com/tencent/mobileqq/data/DataLineMsgRecord
    //   90: dup
    //   91: invokespecial 131	com/tencent/mobileqq/data/DataLineMsgRecord:<init>	()V
    //   94: astore_3
    //   95: aload_3
    //   96: aload_1
    //   97: getfield 251	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   100: invokevirtual 254	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   103: checkcast 253	msf/msgcomm/msg_comm$MsgHead
    //   106: getfield 258	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 262	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: i2l
    //   113: putfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   116: aload_3
    //   117: aload_1
    //   118: getfield 251	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   121: invokevirtual 254	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   124: checkcast 253	msf/msgcomm/msg_comm$MsgHead
    //   127: getfield 265	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 262	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: i2l
    //   134: putfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   137: aload_3
    //   138: aload_1
    //   139: getfield 251	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   142: invokevirtual 254	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   145: checkcast 253	msf/msgcomm/msg_comm$MsgHead
    //   148: getfield 269	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   151: invokevirtual 274	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   154: putfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   157: aload_0
    //   158: aload_3
    //   159: iconst_1
    //   160: invokevirtual 277	ansx:a	(Lcom/tencent/mobileqq/data/DataLineMsgRecord;I)Z
    //   163: ifeq +78 -> 241
    //   166: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +51 -> 220
    //   172: ldc 110
    //   174: iconst_2
    //   175: new 93	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 279
    //   185: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload_3
    //   189: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   192: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: ldc_w 284
    //   198: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_3
    //   202: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   205: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: ldc_w 286
    //   211: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: return
    //   221: astore_3
    //   222: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +13 -> 238
    //   228: ldc 110
    //   230: iconst_2
    //   231: ldc_w 288
    //   234: aload_3
    //   235: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: goto -196 -> 42
    //   241: aload_0
    //   242: getfield 171	ansx:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   245: getstatic 297	com/tencent/mobileqq/app/BusinessHandlerFactory:REGPRXYSVCPACK_HANDLER	I
    //   248: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   251: checkcast 303	aocn
    //   254: astore_1
    //   255: aload_1
    //   256: ifnull +16 -> 272
    //   259: aload_1
    //   260: invokevirtual 305	aocn:d	()I
    //   263: iconst_1
    //   264: if_icmpeq +8 -> 272
    //   267: aload_1
    //   268: iconst_1
    //   269: invokevirtual 308	aocn:e	(I)V
    //   272: aload_2
    //   273: getfield 311	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   276: ldc2_w 312
    //   279: lcmp
    //   280: ifne +69 -> 349
    //   283: aload_0
    //   284: aload_2
    //   285: getfield 317	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   288: getfield 320	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_app_id	J
    //   291: l2i
    //   292: aload_2
    //   293: getfield 317	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   296: getfield 323	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_src_inst_id	J
    //   299: l2i
    //   300: invokevirtual 326	ansx:a	(II)Z
    //   303: ifne -83 -> 220
    //   306: aload_0
    //   307: aload_2
    //   308: getfield 317	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   311: getfield 329	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_app_id	J
    //   314: l2i
    //   315: aload_2
    //   316: getfield 317	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   319: getfield 332	IMMsgBodyPack/MsgType0x210SubMsgType0x13:uint32_dst_inst_id	J
    //   322: l2i
    //   323: invokevirtual 334	ansx:b	(II)Z
    //   326: ifeq -106 -> 220
    //   329: aload_0
    //   330: aload_3
    //   331: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   334: l2i
    //   335: aload_3
    //   336: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   339: l2i
    //   340: i2s
    //   341: aload_2
    //   342: getfield 317	IMMsgBodyPack/MsgType0x210:stMsgInfo0x13	LIMMsgBodyPack/MsgType0x210SubMsgType0x13;
    //   345: invokespecial 336	ansx:a	(ISLIMMsgBodyPack/MsgType0x210SubMsgType0x13;)V
    //   348: return
    //   349: aload_2
    //   350: getfield 311	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   353: ldc2_w 337
    //   356: lcmp
    //   357: ifne +161 -> 518
    //   360: aload_0
    //   361: aload_2
    //   362: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   365: getfield 347	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcAppId	J
    //   368: l2i
    //   369: aload_2
    //   370: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   373: getfield 350	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uSrcInstId	J
    //   376: l2i
    //   377: invokevirtual 326	ansx:a	(II)Z
    //   380: ifne -160 -> 220
    //   383: aload_0
    //   384: aload_2
    //   385: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   388: getfield 353	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstAppId	J
    //   391: l2i
    //   392: aload_2
    //   393: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   396: getfield 356	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstInstId	J
    //   399: l2i
    //   400: invokevirtual 334	ansx:b	(II)Z
    //   403: ifeq -183 -> 220
    //   406: aload_0
    //   407: getfield 359	ansx:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   410: aload_2
    //   411: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   414: getfield 362	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lSessionId	J
    //   417: aload_2
    //   418: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   421: getfield 365	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uOriginfiletype	J
    //   424: aload_2
    //   425: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   428: getfield 368	IMMsgBodyPack/MsgType0x210SubMsgType0x2:uDstUin	J
    //   431: new 70	java/lang/String
    //   434: dup
    //   435: aload_2
    //   436: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   439: getfield 371	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileName	[B
    //   442: invokespecial 91	java/lang/String:<init>	([B)V
    //   445: aload_2
    //   446: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   449: getfield 374	IMMsgBodyPack/MsgType0x210SubMsgType0x2:lFileLen	J
    //   452: aload_2
    //   453: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   456: getfield 377	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileMd5	[B
    //   459: new 70	java/lang/String
    //   462: dup
    //   463: aload_2
    //   464: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   467: getfield 380	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strFileIndex	[B
    //   470: invokespecial 91	java/lang/String:<init>	([B)V
    //   473: aload_2
    //   474: getfield 342	IMMsgBodyPack/MsgType0x210:stMsgInfo0x2	LIMMsgBodyPack/MsgType0x210SubMsgType0x2;
    //   477: getfield 383	IMMsgBodyPack/MsgType0x210SubMsgType0x2:strOriginfile_md5	[B
    //   480: iconst_0
    //   481: iconst_0
    //   482: iconst_0
    //   483: iconst_0
    //   484: aload_3
    //   485: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   488: l2i
    //   489: i2l
    //   490: aload_3
    //   491: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   494: l2i
    //   495: i2s
    //   496: i2l
    //   497: aload_3
    //   498: getfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   501: iconst_0
    //   502: invokevirtual 389	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFTNNotify_0x210	(JJJLjava/lang/String;J[BLjava/lang/String;[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   505: astore_1
    //   506: aload_0
    //   507: getfield 392	ansx:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   510: aload_1
    //   511: invokevirtual 398	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   514: return
    //   515: astore_1
    //   516: aload_1
    //   517: athrow
    //   518: aload_2
    //   519: getfield 311	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   522: ldc2_w 399
    //   525: lcmp
    //   526: ifne +172 -> 698
    //   529: aload_0
    //   530: aload_2
    //   531: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   534: getfield 407	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcAppId	J
    //   537: l2i
    //   538: aload_2
    //   539: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   542: getfield 408	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uSrcInstId	J
    //   545: l2i
    //   546: invokevirtual 326	ansx:a	(II)Z
    //   549: ifne -329 -> 220
    //   552: aload_0
    //   553: aload_2
    //   554: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   557: getfield 409	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstAppId	J
    //   560: l2i
    //   561: aload_2
    //   562: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   565: getfield 410	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstInstId	J
    //   568: l2i
    //   569: invokevirtual 334	ansx:b	(II)Z
    //   572: ifeq -352 -> 220
    //   575: aload_0
    //   576: getfield 359	ansx:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   579: aload_2
    //   580: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   583: getfield 411	IMMsgBodyPack/MsgType0x210SubMsgType0xa:lSessionId	J
    //   586: aload_2
    //   587: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   590: getfield 412	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uOriginfiletype	J
    //   593: aload_2
    //   594: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   597: getfield 413	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uDstUin	J
    //   600: new 70	java/lang/String
    //   603: dup
    //   604: aload_2
    //   605: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   608: getfield 414	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strFileName	[B
    //   611: invokespecial 91	java/lang/String:<init>	([B)V
    //   614: aload_2
    //   615: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   618: getfield 417	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uFileLen	J
    //   621: aload_2
    //   622: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   625: getfield 420	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vMd5	[B
    //   628: aload_2
    //   629: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   632: getfield 423	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerIp	J
    //   635: aload_2
    //   636: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   639: getfield 426	IMMsgBodyPack/MsgType0x210SubMsgType0xa:uServerPort	J
    //   642: aload_2
    //   643: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   646: getfield 429	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vUrlNotify	[B
    //   649: aload_2
    //   650: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   653: getfield 432	IMMsgBodyPack/MsgType0x210SubMsgType0xa:vTokenKey	[B
    //   656: aload_2
    //   657: getfield 404	IMMsgBodyPack/MsgType0x210:stMsgInfo0xa	LIMMsgBodyPack/MsgType0x210SubMsgType0xa;
    //   660: getfield 433	IMMsgBodyPack/MsgType0x210SubMsgType0xa:strOriginfile_md5	[B
    //   663: iconst_0
    //   664: iconst_0
    //   665: iconst_0
    //   666: iconst_0
    //   667: aload_3
    //   668: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   671: l2i
    //   672: i2l
    //   673: aload_3
    //   674: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   677: l2i
    //   678: i2s
    //   679: i2l
    //   680: aload_3
    //   681: getfield 134	com/tencent/mobileqq/data/DataLineMsgRecord:msgId	J
    //   684: iconst_0
    //   685: invokevirtual 437	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromNFCNotify_0x210	(JJJLjava/lang/String;J[BJJ[B[B[BIIIIJJJZ)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   688: astore_1
    //   689: aload_0
    //   690: getfield 392	ansx:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   693: aload_1
    //   694: invokevirtual 398	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   697: return
    //   698: aload_2
    //   699: getfield 311	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   702: ldc2_w 438
    //   705: lcmp
    //   706: ifne -486 -> 220
    //   709: aload_0
    //   710: aload_2
    //   711: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   714: getfield 446	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_app_id	J
    //   717: l2i
    //   718: aload_2
    //   719: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   722: getfield 447	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_src_inst_id	J
    //   725: l2i
    //   726: invokevirtual 326	ansx:a	(II)Z
    //   729: ifne -509 -> 220
    //   732: aload_0
    //   733: aload_2
    //   734: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   737: getfield 448	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_app_id	J
    //   740: l2i
    //   741: aload_2
    //   742: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   745: getfield 449	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_dst_inst_id	J
    //   748: l2i
    //   749: invokevirtual 334	ansx:b	(II)Z
    //   752: ifeq -532 -> 220
    //   755: aload_0
    //   756: getfield 359	ansx:jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper	Lcom/tencent/litetransfersdk/ProtocolHelper;
    //   759: aload_2
    //   760: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   763: getfield 450	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint64_sessionid	J
    //   766: aload_2
    //   767: getfield 443	IMMsgBodyPack/MsgType0x210:stMsgInfo0xe	LIMMsgBodyPack/MsgType0x210SubMsgType0xe;
    //   770: getfield 453	IMMsgBodyPack/MsgType0x210SubMsgType0xe:uint32_operate	J
    //   773: iconst_0
    //   774: aload_3
    //   775: getfield 157	com/tencent/mobileqq/data/DataLineMsgRecord:time	J
    //   778: l2i
    //   779: aload_3
    //   780: getfield 163	com/tencent/mobileqq/data/DataLineMsgRecord:shmsgseq	J
    //   783: l2i
    //   784: i2s
    //   785: invokevirtual 457	com/tencent/litetransfersdk/ProtocolHelper:MsgCSBodyFromFileControl_0x210	(JJIIS)Lcom/tencent/litetransfersdk/MsgCSBody;
    //   788: astore_1
    //   789: aload_0
    //   790: getfield 392	ansx:jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper	Lcom/tencent/litetransfersdk/LiteTransferWrapper;
    //   793: aload_1
    //   794: invokevirtual 398	com/tencent/litetransfersdk/LiteTransferWrapper:OnPbMsgReceive	(Lcom/tencent/litetransfersdk/MsgCSBody;)V
    //   797: return
    //   798: astore_1
    //   799: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	800	0	this	ansx
    //   0	800	1	paramMsg	msf.msgcomm.msg_comm.Msg
    //   12	755	2	localObject1	Object
    //   39	163	3	localObject2	Object
    //   221	559	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   13	40	221	java/lang/Exception
    //   82	220	515	finally
    //   241	255	515	finally
    //   259	272	515	finally
    //   272	348	515	finally
    //   349	514	515	finally
    //   518	697	515	finally
    //   698	797	515	finally
    //   82	220	798	java/lang/Exception
    //   241	255	798	java/lang/Exception
    //   259	272	798	java/lang/Exception
    //   272	348	798	java/lang/Exception
    //   349	514	798	java/lang/Exception
    //   518	697	798	java/lang/Exception
    //   698	797	798	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansx
 * JD-Core Version:    0.7.0.1
 */