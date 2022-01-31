import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
import com.tencent.mobileqq.transfile.GroupPttUploadProcessor.3;
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

public class ayrh
  extends aype
  implements bbzu, INetEventHandler
{
  long jdField_a_of_type_Long;
  akav jdField_a_of_type_Akav = new ayrk(this);
  ayvv jdField_a_of_type_Ayvv;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  private boolean g;
  private String n;
  private volatile boolean q;
  
  public ayrh(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
    this.jdField_a_of_type_Ayvv = paramayvv;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
  }
  
  private ayyx a()
  {
    ayyx localayyx = new ayyx();
    localayyx.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localayyx.jdField_b_of_type_Int = ((int)this.jdField_q_of_type_Long);
    localayyx.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localayyx.jdField_a_of_type_Int = QQRecorder.a(this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    localayyx.jdField_d_of_type_Int = this.jdField_a_of_type_Aywa.jdField_n_of_type_Int;
    localayyx.jdField_c_of_type_Int = ((MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).voiceType;
    localayyx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_b_of_type_JavaLangString;
    localayyx.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString;
    localayyx.e = this.jdField_a_of_type_Aywa.jdField_d_of_type_JavaLangString;
    localayyx.f = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int == 1026)
    {
      localayyx.f = 1;
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    return localayyx;
  }
  
  private void a(im_msg_body.RichText paramRichText, MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt != null) && (paramRichText != null))
    {
      paramRichText.ptt.uint32_format.set(paramMessageForPtt.voiceType);
      paramRichText.ptt.uint32_time.set(bbbd.a(paramMessageForPtt.voiceLength));
    }
  }
  
  private byte[] a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = new ptt_reserve.ReserveStruct();
    if (paramMessageForPtt != null)
    {
      ((ptt_reserve.ReserveStruct)localObject).uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
      ((ptt_reserve.ReserveStruct)localObject).uint32_redpack_type.set(ahjm.a(paramMessageForPtt));
      ((ptt_reserve.ReserveStruct)localObject).uint32_autototext_voice.set(paramMessageForPtt.autoToText);
      if (paramMessageForPtt.hasSttTxt()) {
        ((ptt_reserve.ReserveStruct)localObject).bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
      }
      ByteStringMicro localByteStringMicro = ahjm.a(paramMessageForPtt);
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
  
  private void t()
  {
    this.jdField_a_of_type_Ayqm.jdField_a_of_type_Ayqn.a();
    this.jdField_a_of_type_Ayqm.b.a();
    this.jdField_a_of_type_Ayqm.jdField_a_of_type_Ayqo.a();
    this.jdField_a_of_type_Ayqm.jdField_c_of_type_Ayqn.a();
    ayqm localayqm = this.jdField_a_of_type_Ayqm;
    long l = System.nanoTime();
    localayqm.g = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_Ayqm.h = 0L;
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
    //   0: new 142	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 296	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: getfield 299	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_3
    //   17: getfield 303	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 79	ayrh:jdField_a_of_type_Aywa	Laywa;
    //   24: getfield 104	aywa:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokestatic 309	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 314	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_3
    //   34: getfield 317	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 319	ayrh:jdField_a_of_type_Long	J
    //   41: l2i
    //   42: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 320	ayrh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: astore_2
    //   50: aload_2
    //   51: ifnull +23 -> 74
    //   54: aload_3
    //   55: getfield 323	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 320	ayrh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: ldc_w 325
    //   65: invokevirtual 328	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 212	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 217	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload_0
    //   75: getfield 43	ayrh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   78: aload_0
    //   79: getfield 43	ayrh:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   82: invokevirtual 331	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   85: invokestatic 336	axas:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   88: istore_1
    //   89: new 338	tencent/im/msg/im_msg_body$Elem
    //   92: dup
    //   93: invokespecial 339	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   96: astore 4
    //   98: new 341	tencent/im/msg/im_msg_body$ElemFlags2
    //   101: dup
    //   102: invokespecial 342	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   105: astore_2
    //   106: aload_2
    //   107: getfield 345	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: iload_1
    //   111: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   114: aload 4
    //   116: getfield 349	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   119: aload_2
    //   120: invokevirtual 352	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   123: aload_3
    //   124: getfield 356	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   127: iconst_1
    //   128: invokevirtual 361	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   131: aload_3
    //   132: getfield 364	tencent/im/msg/im_msg_body$Ptt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   135: aload_0
    //   136: getfield 69	ayrh:jdField_q_of_type_Long	J
    //   139: l2i
    //   140: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   143: aload_3
    //   144: getfield 367	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   147: aload_0
    //   148: getfield 75	ayrh:jdField_a_of_type_ArrayOfByte	[B
    //   151: invokestatic 212	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   154: invokevirtual 217	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   157: aload_3
    //   158: getfield 370	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   161: aload_0
    //   162: getfield 65	ayrh:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   165: invokestatic 374	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: invokevirtual 217	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   171: aload_0
    //   172: aload_0
    //   173: getfield 79	ayrh:jdField_a_of_type_Aywa	Laywa;
    //   176: getfield 84	aywa:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   179: checkcast 97	com/tencent/mobileqq/data/MessageForPtt
    //   182: invokespecial 376	ayrh:a	(Lcom/tencent/mobileqq/data/MessageForPtt;)[B
    //   185: astore_2
    //   186: aload_2
    //   187: ifnull +14 -> 201
    //   190: aload_3
    //   191: getfield 379	tencent/im/msg/im_msg_body$Ptt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   194: aload_2
    //   195: invokestatic 212	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   198: invokevirtual 217	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   201: new 136	tencent/im/msg/im_msg_body$RichText
    //   204: dup
    //   205: invokespecial 380	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   208: astore_2
    //   209: aload_2
    //   210: getfield 140	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   213: aload_3
    //   214: invokevirtual 381	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   217: aload_2
    //   218: getfield 385	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   221: aload 4
    //   223: invokevirtual 390	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   226: aload_2
    //   227: areturn
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq -8 -> 226
    //   237: ldc_w 392
    //   240: iconst_2
    //   241: ldc_w 394
    //   244: aload_3
    //   245: invokestatic 397	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   248: aconst_null
    //   249: areturn
    //   250: astore_2
    //   251: goto -177 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	ayrh
    //   88	23	1	i	int
    //   49	182	2	localObject	Object
    //   250	1	2	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   7	207	3	localPtt	im_msg_body.Ptt
    //   228	17	3	localException	Exception
    //   96	126	4	localElem	tencent.im.msg.im_msg_body.Elem
    // Exception table:
    //   from	to	target	type
    //   0	50	228	java/lang/Exception
    //   54	74	228	java/lang/Exception
    //   74	186	228	java/lang/Exception
    //   190	201	228	java/lang/Exception
    //   201	226	228	java/lang/Exception
    //   54	74	250	java/io/UnsupportedEncodingException
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
    //   3: getfield 79	ayrh:jdField_a_of_type_Aywa	Laywa;
    //   6: iconst_1
    //   7: putfield 406	aywa:jdField_l_of_type_Boolean	Z
    //   10: aload_0
    //   11: getfield 79	ayrh:jdField_a_of_type_Aywa	Laywa;
    //   14: getfield 84	aywa:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 97	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 158	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 100	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 408	ayrh:jdField_b_of_type_Boolean	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokevirtual 410	ayrh:d	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokevirtual 412	ayrh:b	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokevirtual 410	ayrh:d	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokevirtual 412	ayrh:b	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	ayrh
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
    Object localObject1;
    Object localObject2;
    if (!paramBoolean)
    {
      localObject1 = "Q.richmedia." + ayui.b(this.jdField_a_of_type_Aywa.jdField_a_of_type_Int) + "." + ayui.a(this.jdField_a_of_type_Aywa.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Aywa.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if ((!paramBoolean) && (this.v == 1))
    {
      this.jdField_c_of_type_Aypb.jdField_a_of_type_Int = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aywa.jdField_n_of_type_Boolean)
      {
        this.jdField_a_of_type_Aypb.a(this.jdField_k_of_type_Long);
        this.jdField_b_of_type_Aypb.a(this.jdField_k_of_type_Long);
      }
      localObject1 = this.jdField_a_of_type_Aypb.a(1) + ";" + this.jdField_b_of_type_Aypb.a(2) + ";" + this.jdField_c_of_type_Aypb.a(3);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPttUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
      }
      if (!paramBoolean)
      {
        if (this.jdField_j_of_type_Int == 9004) {
          break label360;
        }
        if (k()) {}
      }
      while (this.jdField_a_of_type_Aywa.e == 1030)
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
        label360:
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
        if ("connError_unreachable".equalsIgnoreCase((String)localObject2)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_1");
        } else if ("connError_noroute".equalsIgnoreCase((String)localObject2)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_2");
        }
      }
      if ((!paramBoolean) && (ayua.b(this.jdField_j_of_type_Int)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      if ((this.h) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      int j = this.jdField_m_of_type_Int;
      int i;
      label554:
      long l1;
      label562:
      long l3;
      long l2;
      if (paramBoolean)
      {
        i = 2;
        this.jdField_m_of_type_Int = (i | j);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString))
        {
          localObject2 = (MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          String str = this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString;
          if (localObject2 != null) {
            break label1394;
          }
          i = 0;
          if (localObject2 != null) {
            break label1404;
          }
          l1 = 0L;
          aytl.a(str, true, paramBoolean, i, l1);
        }
        this.jdField_l_of_type_Long = System.currentTimeMillis();
        l3 = System.nanoTime();
        l2 = (l3 - this.jdField_k_of_type_Long) / 1000000L;
        Log.i("AutoMonitor", "SendGrpPic, cost=" + (this.jdField_b_of_type_Aypb.jdField_b_of_type_Long - this.jdField_b_of_type_Aypb.jdField_a_of_type_Long) / 1000000L);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_fileid", String.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_Aywa.jdField_i_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.f + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", agqf.a() + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_NetType", bbev.a(BaseApplication.getContext()) + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_IsRawPic", this.jdField_l_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Aywa.jdField_a_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_i_of_type_Boolean));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picType", String.valueOf(this.jdField_u_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_Aywa.e));
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
        if (!this.jdField_a_of_type_Aywa.jdField_q_of_type_Boolean) {
          break label1414;
        }
        i = 1;
        label978:
        ((HashMap)localObject1).put("param_source_type", String.valueOf(i));
        if (this.g)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_pttNetDown", String.valueOf(this.jdField_b_of_type_Long / 1000000L));
          if (QLog.isColorLevel()) {
            QLog.d("weak_net", 2, String.valueOf(this.jdField_b_of_type_Long / 1000000L));
          }
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(avbv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
        f(paramBoolean);
        if (!paramBoolean) {
          break label1420;
        }
        p();
        if (this.jdField_a_of_type_Aywa.jdField_i_of_type_Boolean)
        {
          l1 = 0L;
          if (this.jdField_u_of_type_Long != 0L) {
            l1 = (l3 - this.jdField_u_of_type_Long) / 1000000L;
          }
          if (!this.jdField_a_of_type_Aywa.j) {
            break label1555;
          }
          l1 = l2;
        }
      }
      label1414:
      label1420:
      label1555:
      for (;;)
      {
        double d = l1 / l2;
        agqf.a(l1, this.jdField_q_of_type_Long, this.f, d);
        if ((d >= 0.0D) && (d <= 1.0D)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_AIOPercent", d + "");
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_AIODuration", l1 + "");
        if (QLog.isColorLevel()) {
          QLog.d("GroupPttUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_k_of_type_Long + ",mEnterAioTime = " + this.jdField_u_of_type_Long + ",finishTime  = " + l3 + ", aioDuration = " + l1 + ", duration = " + l2 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_Aywa.j + ",Percent = " + d);
        }
        axrl.a(BaseApplication.getContext()).a(null, b(), true, l2, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        for (;;)
        {
          b(paramBoolean, l2);
          l();
          AppNetConnInfo.unregisterNetEventHandler(this);
          return;
          i = 1;
          break;
          label1394:
          i = ((MessageForPtt)localObject2).voiceChangeFlag;
          break label554;
          label1404:
          l1 = ((MessageForPtt)localObject2).fileSize;
          break label562;
          i = 0;
          break label978;
          if (this.jdField_j_of_type_Int != -9527) {
            this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
          }
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_Aywa.jdField_a_of_type_Long));
          axrl.a(BaseApplication.getContext()).a(null, b(), false, l2, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    a("actRichMediaNetMonitor_pttUp", paramBoolean, paramInt, paramString1, paramString2, this.jdField_c_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString);
  }
  
  public void aR_()
  {
    super.aR_();
    if (!this.jdField_a_of_type_Aywa.jdField_l_of_type_Boolean)
    {
      if (bbzp.a(this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString, this)) {
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
    if ((this.jdField_a_of_type_Aywa.jdField_n_of_type_Boolean) && (this.jdField_a_of_type_Aywa.o))
    {
      i();
      g();
    }
    while (!this.jdField_k_of_type_Boolean) {
      return 0;
    }
    this.jdField_k_of_type_Boolean = false;
    this.o = false;
    d(1002);
    if (this.w != 1) {
      this.jdField_m_of_type_JavaLangString = null;
    }
    this.t = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_j_of_type_JavaLangString = "";
    t();
    this.jdField_a_of_type_Ayvv.a.post(new GroupPttUploadProcessor.3(this));
    return 0;
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return "actGrpPttUp";
    }
    return "actDisscusPttUp";
  }
  
  protected void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_Ayqm.a();
    d(1001);
    if ((this.jdField_a_of_type_ArrayOfByte == null) && (!j()))
    {
      d();
      return;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      try
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString, "r");
        if (this.jdField_a_of_type_JavaIoRandomAccessFile == null)
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
          this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        }
      }
    }
    MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    String str = this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString;
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
      aytl.a(str, false, false, i, l);
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
    if (!this.jdField_a_of_type_Aywa.jdField_l_of_type_Boolean) {
      return 0;
    }
    return d();
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_Aywa.jdField_l_of_type_Boolean) {
      return super.c();
    }
    return 7000L;
  }
  
  public void c()
  {
    super.c();
    if (!this.jdField_k_of_type_Boolean)
    {
      this.jdField_k_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        b("pause", "");
      }
      d(1006);
      if (this.jdField_a_of_type_Ayyn != null)
      {
        ayzt.b(this.jdField_a_of_type_Ayyn);
        this.jdField_a_of_type_Ayyn = null;
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
  
  protected int d()
  {
    b("uiParam", this.jdField_a_of_type_Aywa.toString());
    switch (this.jdField_a_of_type_Aywa.jdField_a_of_type_Int)
    {
    }
    for (this.jdField_a_of_type_Boolean = false; this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null; this.jdField_a_of_type_Boolean = true)
    {
      b(9302, a(new Exception("message null")));
      d();
      return -1;
    }
    String str = this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString;
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
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Ayqm.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    this.n = str;
    long l = localFile.length();
    this.jdField_a_of_type_Ayqm.jdField_a_of_type_Long = l;
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
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo != null)
    {
      auop localauop = new auop();
      localauop.jdField_a_of_type_Int = -1;
      localauop.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
      localauop.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo.b(localauop);
    }
    if (this.jdField_a_of_type_Aywa.jdField_n_of_type_Boolean) {
      avco.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(a());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      b("updateDb", "msg null");
    }
    label78:
    Object localObject;
    label316:
    axwt localaxwt;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
            b("updateDb", "findmsgbyMsgId,need fix");
            break;
            if (localMessageRecord.isMultiMsg)
            {
              b("updateDb", "is multiMsg");
              return;
            }
            if ((this.jdField_a_of_type_Aywa.jdField_b_of_type_Int != 2) || (!(localMessageRecord instanceof MessageForPtt))) {
              break label316;
            }
            localObject = (MessageForPtt)localMessageRecord;
            if (!this.jdField_a_of_type_Aywa.jdField_n_of_type_Boolean) {
              ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString);
            }
            ((MessageForPtt)localObject).fileSize = this.jdField_q_of_type_Long;
            ((MessageForPtt)localObject).urlAtServer = this.jdField_d_of_type_JavaLangString;
            ((MessageForPtt)localObject).itemType = 2;
            ((MessageForPtt)localObject).groupFileID = this.jdField_a_of_type_Long;
            ((MessageForPtt)localObject).groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
            ((MessageForPtt)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPtt)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPtt)localObject).msgData);
          } while ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForPtt)) || (!((ayah)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).b((MessageForPtt)localMessageRecord)));
          axqw.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
          ((ayae)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).b((MessageForPtt)localMessageRecord, 2);
          return;
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString;
            ((MessageForPic)localObject).size = this.jdField_q_of_type_Long;
            ((MessageForPic)localObject).uuid = this.jdField_d_of_type_JavaLangString;
            ((MessageForPic)localObject).groupFileID = this.jdField_a_of_type_Long;
            ((MessageForPic)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localaxwt = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localaxwt == null);
    localaxwt.U = this.jdField_c_of_type_JavaLangString;
    localaxwt.T = this.jdField_d_of_type_JavaLangString;
    localaxwt.d = this.jdField_q_of_type_Long;
    localaxwt.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    localaxwt.e = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo != null)
    {
      auop localauop = new auop();
      localauop.jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      localauop.jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      localauop.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      localauop.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString;
      localauop.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo.b(localauop);
    }
    for (;;)
    {
      d(1003);
      return;
      d(true);
    }
  }
  
  public void f()
  {
    int i = 3;
    if (QLog.isColorLevel()) {
      QLog.d("GroupPttUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.jdField_b_of_type_Aypb.a();
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject1 = new cmd0x388.ReqBody();
    ((cmd0x388.ReqBody)localObject1).setHasFlag(true);
    ((cmd0x388.ReqBody)localObject1).uint32_subcmd.set(3);
    int j = ayxz.a();
    ((cmd0x388.ReqBody)localObject1).uint32_net_type.set(j);
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + j + "]");
    }
    Object localObject2 = a();
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(((ayyx)localObject2).jdField_c_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(((ayyx)localObject2).jdField_d_of_type_JavaLangString).longValue());
    localTryUpPttReq.uint64_file_id.set(0L);
    localTryUpPttReq.uint64_file_size.set(((ayyx)localObject2).jdField_b_of_type_Int);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(((ayyx)localObject2).jdField_a_of_type_ArrayOfByte));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((ayyx)localObject2).jdField_a_of_type_JavaLangString));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (((ayyx)localObject2).f == 1) {}
    for (;;)
    {
      localPBUInt32Field.set(i);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(ayui.a()));
      localTryUpPttReq.uint32_voice_length.set(((ayyx)localObject2).jdField_a_of_type_Int);
      localTryUpPttReq.uint32_codec.set(((ayyx)localObject2).jdField_c_of_type_Int);
      localTryUpPttReq.uint32_voice_type.set(((ayyx)localObject2).jdField_d_of_type_Int);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + ((ayyx)localObject2).jdField_d_of_type_Int + "] type[" + ((ayyx)localObject2).jdField_c_of_type_Int + "] length[" + ((ayyx)localObject2).jdField_a_of_type_Int + "] size[" + ((ayyx)localObject2).jdField_b_of_type_Int + "]");
      }
      ((cmd0x388.ReqBody)localObject1).rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      localObject1 = ((cmd0x388.ReqBody)localObject1).toByteArray();
      localObject2 = new ayri(this, l);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 29, this.n, (int)this.jdField_r_of_type_Long, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject2, (byte[])localObject1, false);
      localObject1 = new ayrj(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject1);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPttUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Aywa.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 29);
      }
      if (i == 0) {
        break;
      }
      a(i, "sendFileByBDH SubmitError.", "", this.jdField_b_of_type_Aypb);
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
    this.jdField_c_of_type_Aypb.a();
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
      a(9368, "constructpberror", null, this.jdField_c_of_type_Aypb);
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
        a(9366, "illegal app", null, this.jdField_c_of_type_Aypb);
        d();
        return;
      }
      if (this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Aypb);
        d();
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
        break;
      }
      localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      a((im_msg_body.RichText)localObject2, localMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendGroupMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if ((this.jdField_a_of_type_Aywa.jdField_a_of_type_Int == 1026) && (QLog.isColorLevel())) {
        QLog.i("PttShow", 2, "sendGroupMsg, UIN_TYPE_HOTCHAT_TOPIC");
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if (ahjm.a((MessageRecord)localObject1))
        {
          ahjm.a().a((MessageRecord)localObject1, this.jdField_a_of_type_Akav, this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, null, this);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_Akav);
        return;
      }
    } while (this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo == null);
    localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString);
    localMessageForPtt.fileSize = this.jdField_q_of_type_Long;
    localMessageForPtt.urlAtServer = this.jdField_d_of_type_JavaLangString;
    localMessageForPtt.itemType = 2;
    localMessageForPtt.groupFileID = this.jdField_a_of_type_Long;
    localMessageForPtt.groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
    localMessageForPtt.md5 = this.jdField_c_of_type_JavaLangString;
    localMessageForPtt.serial();
    this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo.a((im_msg_body.RichText)localObject2);
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
      a(9368, "constructpberror", null, this.jdField_c_of_type_Aypb);
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
        a(9366, "illegal app", null, this.jdField_c_of_type_Aypb);
        d();
        return;
      }
      if (this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
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
        a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Aypb);
        d();
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywa.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywa.jdField_a_of_type_Int, this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
        break;
      }
      localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Aywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      a((im_msg_body.RichText)localObject2, localMessageForPtt);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---sendDiscussMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
      }
      ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (this.jdField_c_of_type_Boolean)
      {
        if (ahjm.a((MessageRecord)localObject1))
        {
          ahjm.a().a((MessageRecord)localObject1, this.jdField_a_of_type_Akav, this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, null, this);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_Akav);
        return;
      }
    } while (this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo == null);
    localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_Aywa.jdField_i_of_type_JavaLangString);
    localMessageForPtt.fileSize = this.jdField_q_of_type_Long;
    localMessageForPtt.urlAtServer = this.jdField_d_of_type_JavaLangString;
    localMessageForPtt.itemType = 2;
    localMessageForPtt.groupFileID = this.jdField_a_of_type_Long;
    localMessageForPtt.groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
    localMessageForPtt.md5 = this.jdField_c_of_type_JavaLangString;
    localMessageForPtt.serial();
    this.jdField_a_of_type_Aywa.jdField_a_of_type_Auoo.a((im_msg_body.RichText)localObject2);
  }
  
  public void s()
  {
    if (this.o) {
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
      aR_();
      return;
    }
    aR_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrh
 * JD-Core Version:    0.7.0.1
 */