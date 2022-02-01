import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.GroupPttUploadProcessor.4;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttReq;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;

public class betz
  extends beru
  implements bilj, INetEventHandler
{
  long jdField_a_of_type_Long;
  aocj jdField_a_of_type_Aocj = new beuc(this);
  beyb jdField_a_of_type_Beyb;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  private boolean g;
  
  public betz(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.jdField_a_of_type_Beyb = parambeyb;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  private bfbe a()
  {
    bfbe localbfbe = new bfbe();
    localbfbe.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localbfbe.jdField_b_of_type_Int = ((int)this.jdField_q_of_type_Long);
    localbfbe.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    localbfbe.jdField_a_of_type_Int = QQRecorder.a(this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    localbfbe.jdField_d_of_type_Int = this.jdField_a_of_type_Beyg.jdField_n_of_type_Int;
    localbfbe.jdField_c_of_type_Int = ((MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).voiceType;
    localbfbe.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_b_of_type_JavaLangString;
    localbfbe.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString;
    localbfbe.e = this.jdField_a_of_type_Beyg.jdField_d_of_type_JavaLangString;
    localbfbe.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1026)
    {
      localbfbe.f = 1;
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    return localbfbe;
  }
  
  private void a(im_msg_body.RichText paramRichText, MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt != null) && (paramRichText != null))
    {
      paramRichText.ptt.uint32_format.set(paramMessageForPtt.voiceType);
      paramRichText.ptt.uint32_time.set(bhjx.a(paramMessageForPtt.voiceLength));
    }
  }
  
  public static byte[] a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = new ptt_reserve.ReserveStruct();
    if (paramMessageForPtt != null)
    {
      ((ptt_reserve.ReserveStruct)localObject).uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
      ((ptt_reserve.ReserveStruct)localObject).uint32_redpack_type.set(aljb.a(paramMessageForPtt));
      ((ptt_reserve.ReserveStruct)localObject).uint32_autototext_voice.set(paramMessageForPtt.autoToText);
      if (paramMessageForPtt.hasSttTxt()) {
        ((ptt_reserve.ReserveStruct)localObject).bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
      }
      ByteStringMicro localByteStringMicro = aljb.a(paramMessageForPtt);
      if (localByteStringMicro != null) {
        ((ptt_reserve.ReserveStruct)localObject).bytes_redpack_score_id.set(localByteStringMicro);
      }
    }
    localObject = ((ptt_reserve.ReserveStruct)localObject).toByteArray();
    if ((QLog.isColorLevel()) && (paramMessageForPtt != null)) {
      QLog.d("pttchangevoice", 2, "change flag is " + paramMessageForPtt.voiceChangeFlag);
    }
    return localObject;
  }
  
  private void f(boolean paramBoolean)
  {
    String str = "Q.richmedia." + bews.b(this.jdField_a_of_type_Beyg.jdField_a_of_type_Int) + "." + bews.a(this.jdField_a_of_type_Beyg.jdField_b_of_type_Int);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long + "  ");
    localStringBuilder.append("errCode:" + this.jdField_k_of_type_Int + "  ");
    localStringBuilder.append("errDesc:" + this.jdField_j_of_type_JavaLangString);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Beyg.o)
    {
      this.jdField_a_of_type_Berr.a(this.jdField_k_of_type_Long);
      this.jdField_b_of_type_Berr.a(this.jdField_k_of_type_Long);
    }
  }
  
  private void u()
  {
    String str;
    if (this.jdField_k_of_type_Int == 9004)
    {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
      if (!"connError_unreachable".equalsIgnoreCase(str)) {
        break label49;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_1");
    }
    label49:
    while (!"connError_noroute".equalsIgnoreCase(str)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_2");
  }
  
  private void v()
  {
    this.jdField_a_of_type_Bete.jdField_a_of_type_Betf.a();
    this.jdField_a_of_type_Bete.b.a();
    this.jdField_a_of_type_Bete.jdField_a_of_type_Betg.a();
    this.jdField_a_of_type_Bete.jdField_c_of_type_Betf.a();
    bete localbete = this.jdField_a_of_type_Bete;
    long l = System.nanoTime();
    localbete.g = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_Bete.h = 0L;
  }
  
  public int a()
  {
    AppNetConnInfo.unregisterNetEventHandler(this);
    return super.a();
  }
  
  /* Error */
  protected im_msg_body.RichText a()
  {
    // Byte code:
    //   0: new 140	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 365	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getfield 368	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 150	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_3
    //   17: getfield 372	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 79	betz:jdField_a_of_type_Beyg	Lbeyg;
    //   24: getfield 105	beyg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokestatic 378	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 382	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_3
    //   34: getfield 385	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 386	betz:jdField_a_of_type_Long	J
    //   41: l2i
    //   42: invokevirtual 150	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 387	betz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +23 -> 74
    //   54: aload_3
    //   55: getfield 390	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 387	betz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: ldc_w 392
    //   65: invokevirtual 395	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 207	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 212	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload_0
    //   75: getfield 41	betz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   78: aload_0
    //   79: getfield 41	betz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   82: invokevirtual 398	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   85: invokestatic 403	bcsa:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   88: istore_1
    //   89: new 405	tencent/im/msg/im_msg_body$Elem
    //   92: dup
    //   93: invokespecial 406	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   96: astore 4
    //   98: new 408	tencent/im/msg/im_msg_body$ElemFlags2
    //   101: dup
    //   102: invokespecial 409	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   105: astore_2
    //   106: aload_2
    //   107: getfield 412	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: iload_1
    //   111: invokevirtual 150	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   114: aload 4
    //   116: getfield 416	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   119: aload_2
    //   120: invokevirtual 419	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   123: aload_3
    //   124: getfield 423	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   127: iconst_1
    //   128: invokevirtual 427	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   131: aload_3
    //   132: getfield 430	tencent/im/msg/im_msg_body$Ptt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   135: aload_0
    //   136: getfield 68	betz:jdField_q_of_type_Long	J
    //   139: l2i
    //   140: invokevirtual 150	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   143: aload_3
    //   144: getfield 433	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   147: aload_0
    //   148: getfield 74	betz:jdField_b_of_type_ArrayOfByte	[B
    //   151: invokestatic 207	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   154: invokevirtual 212	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   157: aload_3
    //   158: getfield 436	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   161: aload_0
    //   162: getfield 63	betz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   165: invokestatic 440	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: invokevirtual 212	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   171: aload_0
    //   172: getfield 79	betz:jdField_a_of_type_Beyg	Lbeyg;
    //   175: getfield 84	beyg:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   178: checkcast 98	com/tencent/mobileqq/data/MessageForPtt
    //   181: invokestatic 442	betz:a	(Lcom/tencent/mobileqq/data/MessageForPtt;)[B
    //   184: astore_2
    //   185: aload_2
    //   186: ifnull +14 -> 200
    //   189: aload_3
    //   190: getfield 445	tencent/im/msg/im_msg_body$Ptt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   193: aload_2
    //   194: invokestatic 207	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   197: invokevirtual 212	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   200: new 134	tencent/im/msg/im_msg_body$RichText
    //   203: dup
    //   204: invokespecial 446	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   207: astore_2
    //   208: aload_2
    //   209: getfield 138	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   212: aload_3
    //   213: invokevirtual 447	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   216: aload_2
    //   217: getfield 451	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   220: aload 4
    //   222: invokevirtual 456	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   225: aload_2
    //   226: areturn
    //   227: astore_3
    //   228: aconst_null
    //   229: astore_2
    //   230: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -8 -> 225
    //   236: ldc_w 458
    //   239: iconst_2
    //   240: ldc_w 460
    //   243: aload_3
    //   244: invokestatic 463	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: aconst_null
    //   248: areturn
    //   249: astore_2
    //   250: goto -176 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	betz
    //   88	23	1	i	int
    //   49	181	2	localObject	Object
    //   249	1	2	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   7	206	3	localPtt	im_msg_body.Ptt
    //   227	17	3	localException	Exception
    //   96	125	4	localElem	tencent.im.msg.im_msg_body.Elem
    // Exception table:
    //   from	to	target	type
    //   0	50	227	java/lang/Exception
    //   54	74	227	java/lang/Exception
    //   74	185	227	java/lang/Exception
    //   189	200	227	java/lang/Exception
    //   200	225	227	java/lang/Exception
    //   54	74	249	java/io/UnsupportedEncodingException
  }
  
  public im_msg_body.RichText a(MessageForPtt paramMessageForPtt)
  {
    im_msg_body.RichText localRichText = a();
    a(localRichText, paramMessageForPtt);
    return localRichText;
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 79	betz:jdField_a_of_type_Beyg	Lbeyg;
    //   6: iconst_1
    //   7: putfield 472	beyg:jdField_m_of_type_Boolean	Z
    //   10: aload_0
    //   11: getfield 79	betz:jdField_a_of_type_Beyg	Lbeyg;
    //   14: getfield 84	beyg:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 98	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 156	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 101	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 474	betz:jdField_b_of_type_Boolean	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokevirtual 476	betz:d	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokevirtual 478	betz:b	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokevirtual 476	betz:d	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokevirtual 478	betz:b	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	betz
    //   0	73	1	paramString	String
    //   0	73	2	paramInt1	int
    //   0	73	3	paramInt2	int
    // Exception table:
    //   from	to	target	type
    //   2	50	68	finally
    //   50	52	68	finally
    //   53	65	68	finally
    //   69	71	68	finally
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      f(paramBoolean);
      u();
      if (this.v == 1)
      {
        this.jdField_c_of_type_Berr.jdField_a_of_type_Int = 1;
        paramBoolean = true;
      }
    }
    for (;;)
    {
      t();
      Object localObject = this.jdField_a_of_type_Berr.a(1) + ";" + this.jdField_b_of_type_Berr.a(2) + ";" + this.jdField_c_of_type_Berr.a(3);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPttUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
      }
      if (this.jdField_a_of_type_Beyg.e == 1030)
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      if ((!paramBoolean) && (bewk.a(this.jdField_k_of_type_Int)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      if ((this.jdField_j_of_type_Boolean) || ((paramBoolean) && ((this.jdField_n_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_n_of_type_Int & 0x1) > 0)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      int j = this.jdField_n_of_type_Int;
      MessageForPtt localMessageForPtt;
      label262:
      long l1;
      label270:
      long l2;
      if (paramBoolean)
      {
        i = 2;
        this.jdField_n_of_type_Int = (i | j);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Beyg.i))
        {
          localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          String str = this.jdField_a_of_type_Beyg.i;
          if (localMessageForPtt != null) {
            break label796;
          }
          i = 0;
          if (localMessageForPtt != null) {
            break label805;
          }
          l1 = 0L;
          bewa.a(str, true, paramBoolean, i, l1);
        }
        this.jdField_l_of_type_Long = System.currentTimeMillis();
        l1 = System.nanoTime();
        l2 = (l1 - this.jdField_k_of_type_Long) / 1000000L;
        Log.i("AutoMonitor", "SendGrpPic, cost=" + (this.jdField_b_of_type_Berr.jdField_b_of_type_Long - this.jdField_b_of_type_Berr.jdField_a_of_type_Long) / 1000000L);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_fileid", String.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_Beyg.jdField_j_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.f + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", akrx.a() + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_NetType", bhnv.a(BaseApplication.getContext()) + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_IsRawPic", this.jdField_n_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_k_of_type_Boolean));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picType", String.valueOf(this.jdField_u_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_Beyg.e));
        localObject = this.jdField_a_of_type_JavaUtilHashMap;
        if (!this.jdField_a_of_type_Beyg.jdField_q_of_type_Boolean) {
          break label815;
        }
      }
      label796:
      label805:
      label815:
      for (int i = 1;; i = 0)
      {
        ((HashMap)localObject).put("param_source_type", String.valueOf(i));
        if (this.g)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_pttNetDown", String.valueOf(this.jdField_b_of_type_Long / 1000000L));
          if (QLog.isColorLevel()) {
            QLog.d("weak_net", 2, String.valueOf(this.jdField_b_of_type_Long / 1000000L));
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(baly.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
        e(paramBoolean);
        a(paramBoolean, l2, l1);
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
        i = 1;
        break;
        i = localMessageForPtt.voiceChangeFlag;
        break label262;
        l1 = localMessageForPtt.fileSize;
        break label270;
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (paramBoolean)
    {
      p();
      if (this.jdField_a_of_type_Beyg.jdField_j_of_type_Boolean)
      {
        long l = 0L;
        if (this.jdField_u_of_type_Long != 0L) {
          l = (paramLong2 - this.jdField_u_of_type_Long) / 1000000L;
        }
        if (this.jdField_a_of_type_Beyg.jdField_k_of_type_Boolean) {
          l = paramLong1;
        }
        double d = l / paramLong1;
        akrx.a(l, this.jdField_q_of_type_Long, this.f, d);
        if ((d >= 0.0D) && (d <= 1.0D)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_AIOPercent", d + "");
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_AIODuration", l + "");
        if (QLog.isColorLevel()) {
          QLog.d("GroupPttUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_k_of_type_Long + ",mEnterAioTime = " + this.jdField_u_of_type_Long + ",finishTime  = " + paramLong2 + ", aioDuration = " + l + ", duration = " + paramLong1 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_Beyg.jdField_k_of_type_Boolean + ",Percent = " + d);
        }
      }
      b(true, paramLong1);
      bdmc.a(BaseApplication.getContext()).a(null, c(), true, paramLong1, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      m();
      return;
      if (this.jdField_k_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long));
      b(false, paramLong1);
      bdmc.a(BaseApplication.getContext()).a(null, c(), false, paramLong1, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 692	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 5
    //   5: new 694	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   8: dup
    //   9: invokespecial 695	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 699	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16: checkcast 694	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   19: getfield 702	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_tryup_ptt_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   22: invokevirtual 705	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +12 -> 39
    //   30: aload_1
    //   31: invokeinterface 710 1 0
    //   36: ifne +366 -> 402
    //   39: new 362	java/lang/Exception
    //   42: dup
    //   43: ldc_w 712
    //   46: invokespecial 715	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 718	java/lang/Exception:printStackTrace	()V
    //   55: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +14 -> 72
    //   61: ldc_w 458
    //   64: iconst_2
    //   65: ldc_w 720
    //   68: aload_1
    //   69: invokestatic 463	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   72: aload_2
    //   73: ldc_w 722
    //   76: invokevirtual 302	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   79: checkcast 197	java/lang/String
    //   82: invokestatic 725	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   85: invokevirtual 728	java/lang/Long:longValue	()J
    //   88: lstore 7
    //   90: aload_2
    //   91: ldc_w 730
    //   94: invokevirtual 302	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 197	java/lang/String
    //   100: invokestatic 725	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   103: invokevirtual 728	java/lang/Long:longValue	()J
    //   106: lstore 9
    //   108: aload_2
    //   109: ldc_w 732
    //   112: invokevirtual 302	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   115: checkcast 197	java/lang/String
    //   118: invokestatic 725	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   121: invokevirtual 728	java/lang/Long:longValue	()J
    //   124: lstore 11
    //   126: aload_2
    //   127: ldc_w 734
    //   130: invokevirtual 302	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   133: checkcast 197	java/lang/String
    //   136: invokestatic 725	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   139: invokevirtual 728	java/lang/Long:longValue	()J
    //   142: lstore 13
    //   144: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +68 -> 215
    //   150: ldc_w 458
    //   153: iconst_2
    //   154: new 225	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 736
    //   164: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: lload 5
    //   169: lload_3
    //   170: lsub
    //   171: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   174: ldc_w 738
    //   177: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 322	betz:jdField_a_of_type_Bete	Lbete;
    //   184: getfield 739	bete:jdField_a_of_type_Long	J
    //   187: invokevirtual 262	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   190: ldc_w 741
    //   193: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_2
    //   197: ldc_w 743
    //   200: invokevirtual 302	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   203: checkcast 197	java/lang/String
    //   206: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_0
    //   216: aload_2
    //   217: invokevirtual 746	betz:b	(Ljava/util/HashMap;)V
    //   220: aload_0
    //   221: getfield 290	betz:jdField_b_of_type_Berr	Lberr;
    //   224: invokevirtual 748	berr:b	()V
    //   227: aload_0
    //   228: getfield 290	betz:jdField_b_of_type_Berr	Lberr;
    //   231: iconst_1
    //   232: putfield 487	berr:jdField_a_of_type_Int	I
    //   235: aload_0
    //   236: aload_0
    //   237: getfield 68	betz:jdField_q_of_type_Long	J
    //   240: putfield 751	betz:jdField_s_of_type_Long	J
    //   243: aload_0
    //   244: monitorenter
    //   245: aload_0
    //   246: getfield 79	betz:jdField_a_of_type_Beyg	Lbeyg;
    //   249: getfield 278	beyg:o	Z
    //   252: ifeq +13 -> 265
    //   255: aload_0
    //   256: getfield 79	betz:jdField_a_of_type_Beyg	Lbeyg;
    //   259: getfield 753	beyg:p	Z
    //   262: ifeq +209 -> 471
    //   265: aload_0
    //   266: invokevirtual 755	betz:g	()V
    //   269: aload_0
    //   270: getfield 322	betz:jdField_a_of_type_Bete	Lbete;
    //   273: invokevirtual 756	bete:a	()V
    //   276: aload_0
    //   277: getfield 79	betz:jdField_a_of_type_Beyg	Lbeyg;
    //   280: getfield 278	beyg:o	Z
    //   283: ifeq +33 -> 316
    //   286: invokestatic 759	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   289: ifeq +13 -> 302
    //   292: ldc_w 761
    //   295: iconst_4
    //   296: ldc_w 763
    //   299: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload_0
    //   303: getfield 41	betz:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   306: invokestatic 768	bamr:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lbamr;
    //   309: aload_0
    //   310: invokevirtual 770	betz:b	()Ljava/lang/String;
    //   313: invokevirtual 772	bamr:a	(Ljava/lang/String;)V
    //   316: aload_0
    //   317: monitorexit
    //   318: new 774	com/tencent/mobileqq/transfile/GroupPttUploadProcessor$1
    //   321: dup
    //   322: aload_0
    //   323: lload 7
    //   325: lload 9
    //   327: lload 11
    //   329: lload 13
    //   331: invokespecial 777	com/tencent/mobileqq/transfile/GroupPttUploadProcessor$1:<init>	(Lbetz;JJJJ)V
    //   334: iconst_5
    //   335: aconst_null
    //   336: iconst_1
    //   337: invokestatic 783	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   340: aload_0
    //   341: getfield 322	betz:jdField_a_of_type_Bete	Lbete;
    //   344: invokevirtual 756	bete:a	()V
    //   347: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   350: ifeq +13 -> 363
    //   353: ldc_w 458
    //   356: iconst_2
    //   357: ldc_w 785
    //   360: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: aload_0
    //   364: ldc_w 787
    //   367: iconst_1
    //   368: iconst_0
    //   369: aload_2
    //   370: ldc_w 789
    //   373: invokevirtual 302	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   376: checkcast 197	java/lang/String
    //   379: aload_2
    //   380: ldc_w 791
    //   383: invokevirtual 302	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   386: checkcast 197	java/lang/String
    //   389: aload_0
    //   390: getfield 792	betz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   393: aload_0
    //   394: getfield 794	betz:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   397: aconst_null
    //   398: invokevirtual 797	betz:a	(Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   401: return
    //   402: aload_1
    //   403: iconst_0
    //   404: invokeinterface 800 2 0
    //   409: checkcast 802	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp
    //   412: astore_1
    //   413: aload_1
    //   414: getfield 805	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint64_fileid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   417: invokevirtual 808	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   420: ifeq +14 -> 434
    //   423: aload_0
    //   424: aload_1
    //   425: getfield 805	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint64_fileid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   428: invokevirtual 810	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   431: putfield 386	betz:jdField_a_of_type_Long	J
    //   434: aload_1
    //   435: getfield 813	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bytes_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   438: invokevirtual 814	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   441: ifeq -369 -> 72
    //   444: aload_0
    //   445: new 197	java/lang/String
    //   448: dup
    //   449: aload_1
    //   450: getfield 813	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bytes_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   453: invokevirtual 817	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   456: invokevirtual 818	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   459: ldc_w 392
    //   462: invokespecial 821	java/lang/String:<init>	([BLjava/lang/String;)V
    //   465: putfield 387	betz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   468: goto -396 -> 72
    //   471: aload_0
    //   472: getfield 79	betz:jdField_a_of_type_Beyg	Lbeyg;
    //   475: iconst_1
    //   476: putfield 753	beyg:p	Z
    //   479: invokestatic 759	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   482: ifeq -166 -> 316
    //   485: ldc_w 761
    //   488: iconst_4
    //   489: ldc_w 823
    //   492: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: goto -179 -> 316
    //   498: astore_1
    //   499: aload_0
    //   500: monitorexit
    //   501: aload_1
    //   502: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	betz
    //   0	503	1	paramArrayOfByte	byte[]
    //   0	503	2	paramHashMap	HashMap<String, String>
    //   0	503	3	paramLong	long
    //   3	165	5	l1	long
    //   88	236	7	l2	long
    //   106	220	9	l3	long
    //   124	204	11	l4	long
    //   142	188	13	l5	long
    // Exception table:
    //   from	to	target	type
    //   5	26	50	java/lang/Exception
    //   30	39	50	java/lang/Exception
    //   39	50	50	java/lang/Exception
    //   402	434	50	java/lang/Exception
    //   434	468	50	java/lang/Exception
    //   245	265	498	finally
    //   265	302	498	finally
    //   302	316	498	finally
    //   316	318	498	finally
    //   471	495	498	finally
    //   499	501	498	finally
  }
  
  public void aN_()
  {
    super.aN_();
    if (!this.jdField_a_of_type_Beyg.jdField_m_of_type_Boolean)
    {
      if (bile.a(this.jdField_a_of_type_Beyg.i, this)) {
        try
        {
          if (this.jdField_b_of_type_Boolean)
          {
            d(1001);
            this.jdField_b_of_type_Boolean = true;
          }
          return;
        }
        finally {}
      }
      if (d() == 0) {
        b(false);
      }
    }
    else
    {
      b(false);
    }
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_Beyg.o) && (this.jdField_a_of_type_Beyg.p))
    {
      j();
      g();
    }
    while (!this.jdField_m_of_type_Boolean) {
      return 0;
    }
    this.jdField_m_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    d(1002);
    if (this.w != 1) {
      this.jdField_m_of_type_JavaLangString = null;
    }
    this.t = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_j_of_type_JavaLangString = "";
    v();
    this.jdField_a_of_type_Beyb.a.post(new GroupPttUploadProcessor.4(this));
    return 0;
  }
  
  protected void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_Bete.a();
    d(1001);
    if ((this.jdField_b_of_type_ArrayOfByte == null) && (!h()))
    {
      d();
      return;
    }
    if (this.jdField_b_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Beyg.i, "r");
        if (this.jdField_b_of_type_JavaIoRandomAccessFile == null)
        {
          b(9303, "read file error");
          d();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.jdField_b_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    String str = this.jdField_a_of_type_Beyg.i;
    int i;
    if (localMessageForPtt == null)
    {
      i = 0;
      if (localMessageForPtt != null) {
        break label184;
      }
    }
    label184:
    for (long l = 0L;; l = localMessageForPtt.fileSize)
    {
      bewa.a(str, false, false, i, l);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
      i = localMessageForPtt.voiceChangeFlag;
      break;
    }
  }
  
  public int c()
  {
    super.c();
    if (!this.jdField_a_of_type_Beyg.jdField_m_of_type_Boolean) {
      return 0;
    }
    return d();
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Beyg.jdField_m_of_type_Boolean) {
      return super.c();
    }
    return 7000L;
  }
  
  protected String c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return "actGrpPttUp";
    }
    return "actDisscusPttUp";
  }
  
  public void c()
  {
    super.c();
    if (!this.jdField_m_of_type_Boolean)
    {
      this.jdField_m_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1006);
      if (this.jdField_a_of_type_Bfau != null)
      {
        bfca.b(this.jdField_a_of_type_Bfau);
        this.jdField_a_of_type_Bfau = null;
      }
    }
    switch (this.w)
    {
    default: 
      return;
    case 0: 
      d("<BDH_LOG> pause() BUT current status is INIT");
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      d("<BDH_LOG> pause() pause BDH channel, transation id=" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().stopTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      return;
    }
    d("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  public void c(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      b("updateDb", "msg null");
    }
    label78:
    Object localObject;
    label316:
    bdqr localbdqr;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
            b("updateDb", "findmsgbyMsgId,need fix");
            break;
            if (localMessageRecord.isMultiMsg)
            {
              b("updateDb", "is multiMsg");
              return;
            }
            if ((this.jdField_a_of_type_Beyg.jdField_b_of_type_Int != 2) || (!(localMessageRecord instanceof MessageForPtt))) {
              break label316;
            }
            localObject = (MessageForPtt)localMessageRecord;
            if (!this.jdField_a_of_type_Beyg.o) {
              ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.jdField_a_of_type_Beyg.i);
            }
            ((MessageForPtt)localObject).fileSize = this.jdField_q_of_type_Long;
            ((MessageForPtt)localObject).urlAtServer = this.jdField_d_of_type_JavaLangString;
            ((MessageForPtt)localObject).itemType = 2;
            ((MessageForPtt)localObject).groupFileID = this.jdField_a_of_type_Long;
            ((MessageForPtt)localObject).groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
            ((MessageForPtt)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPtt)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPtt)localObject).msgData);
          } while ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForPtt)) || (!((bduh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).b((MessageForPtt)localMessageRecord)));
          bdll.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
          ((bdug)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).b((MessageForPtt)localMessageRecord, 2);
          return;
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.jdField_a_of_type_Beyg.i;
            ((MessageForPic)localObject).size = this.jdField_q_of_type_Long;
            ((MessageForPic)localObject).uuid = this.jdField_d_of_type_JavaLangString;
            ((MessageForPic)localObject).groupFileID = this.jdField_a_of_type_Long;
            ((MessageForPic)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localbdqr = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localbdqr == null);
    localbdqr.ae = this.jdField_c_of_type_JavaLangString;
    localbdqr.ad = this.jdField_d_of_type_JavaLangString;
    localbdqr.d = this.jdField_q_of_type_Long;
    localbdqr.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    localbdqr.e = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
  
  protected int d()
  {
    b("uiParam", this.jdField_a_of_type_Beyg.toString());
    switch (this.jdField_a_of_type_Beyg.jdField_a_of_type_Int)
    {
    }
    for (this.jdField_a_of_type_Boolean = false; this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null; this.jdField_a_of_type_Boolean = true)
    {
      b(9302, a(new Exception("message null")));
      d();
      return -1;
    }
    String str = this.jdField_a_of_type_Beyg.i;
    if (TextUtils.isEmpty(str))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      b(9042, a(new Exception("sendFile not exist " + str)));
      d();
      return -1;
    }
    if (!localFile.canRead())
    {
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    this.jdField_b_of_type_JavaLangString = str;
    long l = localFile.length();
    this.jdField_a_of_type_Bete.jdField_a_of_type_Long = l;
    this.jdField_q_of_type_Long = l;
    if (l <= 0L)
    {
      b(9071, a(new Exception("file size 0 " + str)));
      d();
      return -1;
    }
    this.e = "amr";
    return 0;
  }
  
  void d()
  {
    super.d();
    d(1005);
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
    {
      azrh localazrh = new azrh();
      localazrh.jdField_a_of_type_Int = -1;
      localazrh.jdField_b_of_type_Int = this.jdField_k_of_type_Int;
      localazrh.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
    }
    if (this.jdField_a_of_type_Beyg.o) {
      bamr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(b());
    }
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg != null)
    {
      azrh localazrh = new azrh();
      localazrh.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localazrh.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localazrh.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localazrh.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Beyg.i;
      localazrh.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.b(localazrh);
    }
    for (;;)
    {
      d(1003);
      return;
      c(true);
    }
  }
  
  public void f()
  {
    int i = 3;
    if (QLog.isColorLevel()) {
      QLog.d("GroupPttUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.jdField_b_of_type_Berr.a();
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject1 = new cmd0x388.ReqBody();
    ((cmd0x388.ReqBody)localObject1).setHasFlag(true);
    ((cmd0x388.ReqBody)localObject1).uint32_subcmd.set(3);
    int j = bfae.a();
    ((cmd0x388.ReqBody)localObject1).uint32_net_type.set(j);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + j + "]");
    }
    Object localObject2 = a();
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(((bfbe)localObject2).jdField_c_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(((bfbe)localObject2).jdField_d_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_file_id.set(0L);
    localTryUpPttReq.uint64_file_size.set(((bfbe)localObject2).jdField_b_of_type_Int);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(((bfbe)localObject2).jdField_a_of_type_ArrayOfByte));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((bfbe)localObject2).jdField_a_of_type_JavaLangString));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (((bfbe)localObject2).f == 1) {}
    for (;;)
    {
      localPBUInt32Field.set(i);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(bews.a()));
      localTryUpPttReq.uint32_voice_length.set(((bfbe)localObject2).jdField_a_of_type_Int);
      localTryUpPttReq.uint32_codec.set(((bfbe)localObject2).jdField_c_of_type_Int);
      localTryUpPttReq.uint32_voice_type.set(((bfbe)localObject2).jdField_d_of_type_Int);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + ((bfbe)localObject2).jdField_d_of_type_Int + "] type[" + ((bfbe)localObject2).jdField_c_of_type_Int + "] length[" + ((bfbe)localObject2).jdField_a_of_type_Int + "] size[" + ((bfbe)localObject2).jdField_b_of_type_Int + "]");
      }
      ((cmd0x388.ReqBody)localObject1).rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      localObject1 = ((cmd0x388.ReqBody)localObject1).toByteArray();
      localObject2 = new beua(this, l);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 29, this.jdField_b_of_type_JavaLangString, (int)this.jdField_r_of_type_Long, this.jdField_b_of_type_ArrayOfByte, (ITransactionCallback)localObject2, (byte[])localObject1, false);
      localObject1 = new beub(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject1);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPttUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Beyg.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 29);
      }
      if (i == 0) {
        break;
      }
      a(i, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Berr);
      d();
      return;
      i = 4;
    }
  }
  
  void g()
  {
    if (!f()) {
      return;
    }
    this.jdField_c_of_type_Berr.a();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPttUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      h();
      return;
    }
    r();
  }
  
  void h()
  {
    Object localObject2 = a();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Berr);
      d();
    }
    label165:
    label192:
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      if (!e())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_Berr);
        d();
        return;
      }
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject1 instanceof MessageForPtt)) {
          break label192;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label165;
        }
      }
      for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Berr);
        d();
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
        break;
      }
      localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      a((im_msg_body.RichText)localObject2, localMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendGroupMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if ((this.jdField_a_of_type_Beyg.jdField_a_of_type_Int == 1026) && (QLog.isColorLevel())) {
        QLog.i("PttShow", 2, "sendGroupMsg, UIN_TYPE_HOTCHAT_TOPIC");
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if (aljb.a((MessageRecord)localObject1))
        {
          aljb.a().a((MessageRecord)localObject1, this.jdField_a_of_type_Aocj, this.jdField_a_of_type_Long, this.jdField_b_of_type_ArrayOfByte, null, this);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_Aocj);
        return;
      }
    } while (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg == null);
    localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_Beyg.i);
    localMessageForPtt.fileSize = this.jdField_q_of_type_Long;
    localMessageForPtt.urlAtServer = this.jdField_d_of_type_JavaLangString;
    localMessageForPtt.itemType = 2;
    localMessageForPtt.groupFileID = this.jdField_a_of_type_Long;
    localMessageForPtt.groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
    localMessageForPtt.md5 = this.jdField_c_of_type_JavaLangString;
    localMessageForPtt.serial();
    this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.a((im_msg_body.RichText)localObject2);
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_c_of_type_Long > 0L) {
        this.jdField_b_of_type_Long += System.nanoTime() - this.jdField_c_of_type_Long;
      }
    }
    for (this.jdField_c_of_type_Long = 0L;; this.jdField_c_of_type_Long = System.nanoTime())
    {
      this.g = true;
      return;
    }
  }
  
  void r()
  {
    Object localObject2 = a();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Berr);
      d();
    }
    label169:
    label196:
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      if (!e())
      {
        a(9366, "illegal app", null, this.jdField_c_of_type_Berr);
        d();
        return;
      }
      if (this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt))) {
          break label196;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label169;
        }
      }
      for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Berr);
        d();
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Beyg.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Beyg.jdField_a_of_type_Int, this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
        break;
      }
      localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Beyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      a((im_msg_body.RichText)localObject2, localMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendDiscussMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (this.jdField_c_of_type_Boolean)
      {
        if (aljb.a((MessageRecord)localObject1))
        {
          aljb.a().a((MessageRecord)localObject1, this.jdField_a_of_type_Aocj, this.jdField_a_of_type_Long, this.jdField_b_of_type_ArrayOfByte, null, this);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_Aocj);
        return;
      }
    } while (this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg == null);
    localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_Beyg.i);
    localMessageForPtt.fileSize = this.jdField_q_of_type_Long;
    localMessageForPtt.urlAtServer = this.jdField_d_of_type_JavaLangString;
    localMessageForPtt.itemType = 2;
    localMessageForPtt.groupFileID = this.jdField_a_of_type_Long;
    localMessageForPtt.groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
    localMessageForPtt.md5 = this.jdField_c_of_type_JavaLangString;
    localMessageForPtt.serial();
    this.jdField_a_of_type_Beyg.jdField_a_of_type_Azrg.a((im_msg_body.RichText)localObject2);
  }
  
  public void s()
  {
    if (this.jdField_q_of_type_Boolean) {
      return;
    }
    if ((this.jdField_m_of_type_JavaLangString != null) && (this.jdField_a_of_type_Long != 0L))
    {
      if (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long)
      {
        g();
        return;
      }
      if ((this.w == 1) && (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null))
      {
        d("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().resumeTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
        return;
      }
      aN_();
      return;
    }
    aN_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     betz
 * JD-Core Version:    0.7.0.1
 */