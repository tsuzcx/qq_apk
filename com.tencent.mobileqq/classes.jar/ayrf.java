import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor.1;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor.4;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class ayrf
  extends ayoy
  implements bcai, INetEventHandler
{
  long jdField_a_of_type_Long;
  akat jdField_a_of_type_Akat = new ayri(this);
  ayvx jdField_a_of_type_Ayvx;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = true;
  private long c;
  private long d;
  boolean g;
  public boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  
  public ayrf(ayvx paramayvx, aywc paramaywc)
  {
    super(paramayvx, paramaywc);
    this.jdField_g_of_type_Boolean = false;
    this.jdField_d_of_type_Long = -1L;
    if (!this.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_Bgbd = avbz.a();
    }
    this.jdField_a_of_type_Ayvx = paramayvx;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), this);
    if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && ((this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic)))
    {
      this.jdField_t_of_type_Boolean = ((MessageForPic)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).isStoryPhoto;
      if (this.jdField_t_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
    }
  }
  
  public static int a(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramString = paramString.split("\\.");
      arrayOfByte[0] = ((byte)(Integer.parseInt(paramString[0]) & 0xFF));
      arrayOfByte[1] = ((byte)(Integer.parseInt(paramString[1]) & 0xFF));
      arrayOfByte[2] = ((byte)(Integer.parseInt(paramString[2]) & 0xFF));
      arrayOfByte[3] = ((byte)(Integer.parseInt(paramString[3]) & 0xFF));
      int i = arrayOfByte[3];
      int j = arrayOfByte[2];
      int k = arrayOfByte[1];
      int m = arrayOfByte[0];
      return m << 24 & 0xFF000000 | i & 0xFF | j << 8 & 0xFF00 | k << 16 & 0xFF0000;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private im_msg_body.Elem a()
  {
    Object localObject = (akvq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(199);
    if ((localObject != null) && (((akvq)localObject).a()) && (((akvq)localObject).a() == 1L))
    {
      localObject = ((akvq)localObject).a();
      if (localObject != null)
      {
        int i = ((Setting)localObject).systemHeadID;
        int j = ((Setting)localObject).bHeadType;
        localObject = new im_msg_body.Elem();
        im_msg_body.CommonElem localCommonElem = new im_msg_body.CommonElem();
        localCommonElem.uint32_service_type.set(13);
        hummer_commelem.MsgElemInfo_servtype13 localMsgElemInfo_servtype13 = new hummer_commelem.MsgElemInfo_servtype13();
        localMsgElemInfo_servtype13.uint32_sys_head_id.set(i);
        localMsgElemInfo_servtype13.uint32_head_flag.set(j);
        localCommonElem.bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype13.toByteArray()));
        ((im_msg_body.Elem)localObject).common_elem.set(localCommonElem);
        return localObject;
      }
    }
    return null;
  }
  
  private void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/cgi-bin/httpconn?htcmd=0x6ff0071&ver=5468&term=android&ukey=");
    paramStringBuilder.append(this.jdField_m_of_type_JavaLangString);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.jdField_q_of_type_Long);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.jdField_s_of_type_Long);
    paramStringBuilder.append("&uin=");
    paramStringBuilder.append(this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString);
    paramStringBuilder.append("&groupcode=");
    paramStringBuilder.append(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString);
  }
  
  private void a(im_msg_body.RichText paramRichText, MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt != null) && (paramRichText != null))
    {
      paramRichText.ptt.uint32_format.set(paramMessageForPtt.voiceType);
      paramRichText.ptt.uint32_time.set(bbbr.a(paramMessageForPtt.voiceLength));
    }
  }
  
  public static byte[] a(MessageForPtt paramMessageForPtt)
  {
    Object localObject = new ptt_reserve.ReserveStruct();
    if (paramMessageForPtt != null)
    {
      ((ptt_reserve.ReserveStruct)localObject).uint32_change_voice.set(paramMessageForPtt.voiceChangeFlag);
      ((ptt_reserve.ReserveStruct)localObject).uint32_redpack_type.set(ahjk.a(paramMessageForPtt));
      ((ptt_reserve.ReserveStruct)localObject).uint32_autototext_voice.set(paramMessageForPtt.autoToText);
      if (paramMessageForPtt.hasSttTxt()) {
        ((ptt_reserve.ReserveStruct)localObject).bytes_voice_text_abs.set(ByteStringMicro.copyFrom(paramMessageForPtt.sttText.getBytes()));
      }
      ByteStringMicro localByteStringMicro = ahjk.a(paramMessageForPtt);
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
  
  private void b(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("/?ver=4679&ukey=");
    paramStringBuilder.append(this.jdField_m_of_type_JavaLangString);
    paramStringBuilder.append("&filekey=");
    paramStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    paramStringBuilder.append("&filesize=");
    paramStringBuilder.append(this.jdField_q_of_type_Long);
    paramStringBuilder.append("&range=");
    paramStringBuilder.append(this.jdField_s_of_type_Long);
    paramStringBuilder.append("&bmd5=");
    paramStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    paramStringBuilder.append("&mType=");
    if (this.jdField_b_of_type_Boolean)
    {
      paramStringBuilder.append("pttGu");
      return;
    }
    paramStringBuilder.append("pttDu");
  }
  
  private void x()
  {
    this.jdField_a_of_type_Ayqo.jdField_a_of_type_Ayqp.a();
    this.jdField_a_of_type_Ayqo.b.a();
    this.jdField_a_of_type_Ayqo.jdField_a_of_type_Ayqq.a();
    this.jdField_a_of_type_Ayqo.jdField_c_of_type_Ayqp.a();
    ayqo localayqo = this.jdField_a_of_type_Ayqo;
    long l = System.nanoTime();
    localayqo.g = l;
    this.jdField_k_of_type_Long = l;
    this.jdField_a_of_type_Ayqo.h = 0L;
  }
  
  public int a()
  {
    AppNetConnInfo.unregisterNetEventHandler(this);
    return super.a();
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.jdField_q_of_type_Long - paramLong;
    long l;
    if (!this.jdField_a_of_type_Boolean)
    {
      l = this.jdField_a_of_type_Bgbd.a(BaseApplication.getContext(), this.jdField_q_of_type_Long, this.jdField_s_of_type_Long, -1);
      if (QLog.isColorLevel()) {
        QLog.e("GroupPicUploadProcessor", 2, "get sscm size =" + l);
      }
    }
    for (paramLong = Math.min(paramLong, l);; paramLong = Math.min(paramLong, 14600L))
    {
      paramLong = Math.min(paramLong, 131072L);
      if (QLog.isColorLevel()) {
        QLog.e("GroupPicUploadProcessor", 2, "real sscm=" + paramLong);
      }
      return paramLong;
    }
  }
  
  protected ayrx a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = super.a(paramArrayOfByte);
    paramArrayOfByte.d = true;
    paramArrayOfByte.d = true;
    return paramArrayOfByte;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new StringBuilder();
    Object localObject = (ayuq)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    paramArrayOfByte.append("http://");
    paramArrayOfByte.append(((ayuq)localObject).jdField_a_of_type_JavaLangString);
    if (((ayuq)localObject).jdField_a_of_type_Int != 80)
    {
      paramArrayOfByte.append(":");
      paramArrayOfByte.append(((ayuq)localObject).jdField_a_of_type_Int);
    }
    if (!this.jdField_g_of_type_Boolean) {
      b(paramArrayOfByte);
    }
    for (;;)
    {
      if (!this.jdField_g_of_type_Boolean)
      {
        localObject = (MessageForPtt)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        paramArrayOfByte.append("&voice_codec=" + ((MessageForPtt)localObject).voiceType);
      }
      paramArrayOfByte = a(paramArrayOfByte.toString(), this.jdField_a_of_type_JavaUtilArrayList);
      aypb.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilArrayList);
      return paramArrayOfByte;
      a(paramArrayOfByte);
    }
  }
  
  /* Error */
  protected im_msg_body.RichText a()
  {
    // Byte code:
    //   0: new 236	tencent/im/msg/im_msg_body$Ptt
    //   3: dup
    //   4: invokespecial 449	tencent/im/msg/im_msg_body$Ptt:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getfield 452	tencent/im/msg/im_msg_body$Ptt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12: iconst_4
    //   13: invokevirtual 161	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   16: aload_2
    //   17: getfield 456	tencent/im/msg/im_msg_body$Ptt:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   20: aload_0
    //   21: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   24: getfield 223	aywc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokestatic 462	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   30: invokevirtual 467	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   33: aload_2
    //   34: getfield 470	tencent/im/msg/im_msg_body$Ptt:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   37: aload_0
    //   38: getfield 472	ayrf:jdField_a_of_type_Long	J
    //   41: l2i
    //   42: invokevirtual 161	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   45: aload_0
    //   46: getfield 473	ayrf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +23 -> 74
    //   54: aload_2
    //   55: getfield 476	tencent/im/msg/im_msg_body$Ptt:bytes_group_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   58: aload_0
    //   59: getfield 473	ayrf:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   62: ldc_w 478
    //   65: invokevirtual 481	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   68: invokestatic 184	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   71: invokevirtual 189	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   74: aload_0
    //   75: getfield 412	ayrf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   78: ifnull +50 -> 128
    //   81: aload_0
    //   82: getfield 412	ayrf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   85: invokevirtual 484	java/util/ArrayList:size	()I
    //   88: ifle +40 -> 128
    //   91: aload_0
    //   92: getfield 412	ayrf:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   95: iconst_0
    //   96: invokevirtual 418	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   99: checkcast 420	ayuq
    //   102: astore_3
    //   103: aload_2
    //   104: getfield 487	tencent/im/msg/im_msg_body$Ptt:uint32_server_ip	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: aload_3
    //   108: getfield 424	ayuq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokestatic 489	ayrf:a	(Ljava/lang/String;)I
    //   114: invokevirtual 161	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   117: aload_2
    //   118: getfield 492	tencent/im/msg/im_msg_body$Ptt:uint32_server_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   121: aload_3
    //   122: getfield 426	ayuq:jdField_a_of_type_Int	I
    //   125: invokevirtual 161	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   128: aload_0
    //   129: getfield 63	ayrf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   132: aload_0
    //   133: getfield 63	ayrf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: invokevirtual 495	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   139: invokestatic 500	axau:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)I
    //   142: istore_1
    //   143: new 146	tencent/im/msg/im_msg_body$Elem
    //   146: dup
    //   147: invokespecial 148	tencent/im/msg/im_msg_body$Elem:<init>	()V
    //   150: astore 4
    //   152: new 502	tencent/im/msg/im_msg_body$ElemFlags2
    //   155: dup
    //   156: invokespecial 503	tencent/im/msg/im_msg_body$ElemFlags2:<init>	()V
    //   159: astore_3
    //   160: aload_3
    //   161: getfield 506	tencent/im/msg/im_msg_body$ElemFlags2:uint32_vip_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   164: iload_1
    //   165: invokevirtual 161	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   168: aload 4
    //   170: getfield 510	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   173: aload_3
    //   174: invokevirtual 511	tencent/im/msg/im_msg_body$ElemFlags2:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   177: aload_2
    //   178: getfield 515	tencent/im/msg/im_msg_body$Ptt:bool_valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   181: iconst_1
    //   182: invokevirtual 520	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   185: aload_2
    //   186: getfield 523	tencent/im/msg/im_msg_body$Ptt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: aload_0
    //   190: getfield 212	ayrf:jdField_q_of_type_Long	J
    //   193: l2i
    //   194: invokevirtual 161	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   197: aload_2
    //   198: getfield 526	tencent/im/msg/im_msg_body$Ptt:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: aload_0
    //   202: getfield 529	ayrf:jdField_a_of_type_ArrayOfByte	[B
    //   205: invokestatic 184	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   208: invokevirtual 189	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   211: aload_2
    //   212: getfield 532	tencent/im/msg/im_msg_body$Ptt:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: aload_0
    //   216: getfield 534	ayrf:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   219: invokestatic 538	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   222: invokevirtual 189	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   225: aload_0
    //   226: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   229: getfield 83	aywc:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   232: checkcast 241	com/tencent/mobileqq/data/MessageForPtt
    //   235: invokestatic 540	ayrf:a	(Lcom/tencent/mobileqq/data/MessageForPtt;)[B
    //   238: astore_3
    //   239: aload_3
    //   240: ifnull +14 -> 254
    //   243: aload_2
    //   244: getfield 543	tencent/im/msg/im_msg_body$Ptt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   247: aload_3
    //   248: invokestatic 184	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   251: invokevirtual 189	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   254: new 230	tencent/im/msg/im_msg_body$RichText
    //   257: dup
    //   258: invokespecial 544	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   261: astore_3
    //   262: aload_3
    //   263: getfield 234	tencent/im/msg/im_msg_body$RichText:ptt	Ltencent/im/msg/im_msg_body$Ptt;
    //   266: aload_2
    //   267: invokevirtual 545	tencent/im/msg/im_msg_body$Ptt:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   270: aload_3
    //   271: getfield 549	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   274: aload 4
    //   276: invokevirtual 554	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   279: aload_0
    //   280: invokespecial 556	ayrf:a	()Ltencent/im/msg/im_msg_body$Elem;
    //   283: astore 4
    //   285: aload_3
    //   286: astore_2
    //   287: aload_3
    //   288: ifnull +48 -> 336
    //   291: aload_3
    //   292: astore_2
    //   293: aload_3
    //   294: getfield 549	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   297: ifnull +39 -> 336
    //   300: aload_3
    //   301: astore_2
    //   302: aload 4
    //   304: ifnull +32 -> 336
    //   307: aload_3
    //   308: getfield 549	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   311: aload 4
    //   313: invokevirtual 554	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   316: aload_3
    //   317: astore_2
    //   318: invokestatic 305	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +15 -> 336
    //   324: ldc_w 384
    //   327: iconst_2
    //   328: ldc_w 558
    //   331: invokestatic 389	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: aload_3
    //   335: astore_2
    //   336: aload_2
    //   337: areturn
    //   338: astore_3
    //   339: aconst_null
    //   340: astore_2
    //   341: invokestatic 305	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq -8 -> 336
    //   347: ldc_w 384
    //   350: iconst_2
    //   351: ldc_w 560
    //   354: aload_3
    //   355: invokestatic 563	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   358: aconst_null
    //   359: areturn
    //   360: astore_3
    //   361: goto -287 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	ayrf
    //   142	23	1	i	int
    //   7	334	2	localObject1	Object
    //   49	286	3	localObject2	Object
    //   338	17	3	localException	Exception
    //   360	1	3	localUnsupportedEncodingException	UnsupportedEncodingException
    //   150	162	4	localElem	im_msg_body.Elem
    // Exception table:
    //   from	to	target	type
    //   0	50	338	java/lang/Exception
    //   54	74	338	java/lang/Exception
    //   74	128	338	java/lang/Exception
    //   128	239	338	java/lang/Exception
    //   243	254	338	java/lang/Exception
    //   254	285	338	java/lang/Exception
    //   293	300	338	java/lang/Exception
    //   307	316	338	java/lang/Exception
    //   318	334	338	java/lang/Exception
    //   54	74	360	java/io/UnsupportedEncodingException
  }
  
  public im_msg_body.RichText a(MessageForPtt paramMessageForPtt)
  {
    im_msg_body.RichText localRichText = a();
    a(localRichText, paramMessageForPtt);
    return localRichText;
  }
  
  public void a(ayyp paramayyp, ayze paramayze)
  {
    super.a(paramayyp, paramayze);
    b(paramayyp, paramayze);
  }
  
  /* Error */
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   6: iconst_1
    //   7: putfield 577	aywc:jdField_l_of_type_Boolean	Z
    //   10: aload_0
    //   11: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   14: getfield 83	aywc:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   17: checkcast 241	com/tencent/mobileqq/data/MessageForPtt
    //   20: astore_1
    //   21: aload_1
    //   22: iload_3
    //   23: putfield 251	com/tencent/mobileqq/data/MessageForPtt:voiceLength	I
    //   26: aload_1
    //   27: iload_2
    //   28: putfield 245	com/tencent/mobileqq/data/MessageForPtt:voiceType	I
    //   31: aload_0
    //   32: getfield 579	ayrf:jdField_r_of_type_Boolean	Z
    //   35: ifne +18 -> 53
    //   38: aload_0
    //   39: invokevirtual 581	ayrf:d	()I
    //   42: ifne +8 -> 50
    //   45: aload_0
    //   46: iconst_0
    //   47: invokevirtual 583	ayrf:c	(Z)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: invokevirtual 581	ayrf:d	()I
    //   57: ifne -7 -> 50
    //   60: aload_0
    //   61: iconst_1
    //   62: invokevirtual 583	ayrf:c	(Z)V
    //   65: goto -15 -> 50
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	ayrf
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
      localObject1 = "Q.richmedia." + ayuk.b(this.jdField_a_of_type_Aywc.jdField_a_of_type_Int) + "." + ayuk.a(this.jdField_a_of_type_Aywc.jdField_b_of_type_Int);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("id:" + this.jdField_a_of_type_Aywc.jdField_a_of_type_Long + "  ");
      ((StringBuilder)localObject2).append("errCode:" + this.jdField_j_of_type_Int + "  ");
      ((StringBuilder)localObject2).append("errDesc:" + this.jdField_j_of_type_JavaLangString);
      QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if ((!paramBoolean) && (this.v == 1))
    {
      this.jdField_c_of_type_Aypd.jdField_a_of_type_Int = 1;
      paramBoolean = true;
    }
    for (;;)
    {
      if (!this.jdField_g_of_type_Boolean) {
        avbz.a(this.jdField_a_of_type_Bgbd);
      }
      if (this.jdField_a_of_type_Aywc.jdField_n_of_type_Boolean)
      {
        this.jdField_a_of_type_Aypd.a(this.jdField_k_of_type_Long);
        this.jdField_b_of_type_Aypd.a(this.jdField_k_of_type_Long);
      }
      localObject1 = this.jdField_a_of_type_Aypd.a(1) + ";" + this.jdField_b_of_type_Aypd.a(2) + ";" + this.jdField_c_of_type_Aypd.a(3);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "doDSReport : GroupPic doReport : result:" + paramBoolean);
      }
      if (!paramBoolean)
      {
        if (this.jdField_j_of_type_Int == 9004) {
          break label374;
        }
        if (k()) {}
      }
      while (this.jdField_a_of_type_Aywc.jdField_e_of_type_Int == 1030)
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
        label374:
        localObject2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason");
        if ("connError_unreachable".equalsIgnoreCase((String)localObject2)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_1");
        } else if ("connError_noroute".equalsIgnoreCase((String)localObject2)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_reason", "N_2");
        }
      }
      if ((!paramBoolean) && (ayuc.b(this.jdField_j_of_type_Int)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      if ((this.jdField_h_of_type_Boolean) || ((paramBoolean) && ((this.jdField_m_of_type_Int & 0x2) > 0)) || ((!paramBoolean) && ((this.jdField_m_of_type_Int & 0x1) > 0)))
      {
        AppNetConnInfo.unregisterNetEventHandler(this);
        return;
      }
      int j = this.jdField_m_of_type_Int;
      int i;
      label575:
      long l1;
      label583:
      long l3;
      long l2;
      if (paramBoolean)
      {
        i = 2;
        this.jdField_m_of_type_Int = (i | j);
        if ((!this.jdField_g_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString)))
        {
          localObject2 = (MessageForPtt)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          String str = this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString;
          if (localObject2 != null) {
            break label1434;
          }
          i = 0;
          if (localObject2 != null) {
            break label1444;
          }
          l1 = 0L;
          aytn.a(str, true, paramBoolean, i, l1);
        }
        this.jdField_l_of_type_Long = System.currentTimeMillis();
        l3 = System.nanoTime();
        l2 = (l3 - this.jdField_k_of_type_Long) / 1000000L;
        Log.i("AutoMonitor", "SendGrpPic, cost=" + (this.jdField_b_of_type_Aypd.jdField_b_of_type_Long - this.jdField_b_of_type_Aypd.jdField_a_of_type_Long) / 1000000L);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_step", localObject1);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_grpUin", this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_fileid", String.valueOf(this.jdField_a_of_type_Long));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isPresend", this.jdField_a_of_type_Aywc.jdField_i_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_isSecondTrans", this.jdField_f_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_PhoneType", agqd.a() + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_NetType", bbfj.a(BaseApplication.getContext()) + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_IsRawPic", this.jdField_l_of_type_Boolean + "");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uinType", String.valueOf(this.jdField_a_of_type_Aywc.jdField_a_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_quickHttp", String.valueOf(this.jdField_i_of_type_Boolean));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picType", String.valueOf(this.jdField_u_of_type_Int));
        this.jdField_a_of_type_JavaUtilHashMap.put("param_busi", String.valueOf(this.jdField_a_of_type_Aywc.jdField_e_of_type_Int));
        localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
        if (!this.jdField_a_of_type_Aywc.q) {
          break label1454;
        }
        i = 1;
        label999:
        ((HashMap)localObject1).put("param_source_type", String.valueOf(i));
        if ((this.jdField_s_of_type_Boolean) && (!this.jdField_g_of_type_Boolean))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_pttNetDown", String.valueOf(this.jdField_b_of_type_Long / 1000000L));
          if (QLog.isColorLevel()) {
            QLog.d("weak_net", 2, String.valueOf(this.jdField_b_of_type_Long / 1000000L));
          }
        }
        if (!this.jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_pttOpt", String.valueOf(avbx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
        }
        f(paramBoolean);
        if (!paramBoolean) {
          break label1460;
        }
        p();
        if (this.jdField_a_of_type_Aywc.jdField_i_of_type_Boolean)
        {
          l1 = 0L;
          if (this.jdField_u_of_type_Long != 0L) {
            l1 = (l3 - this.jdField_u_of_type_Long) / 1000000L;
          }
          if (!this.jdField_a_of_type_Aywc.j) {
            break label1595;
          }
          l1 = l2;
        }
      }
      label1434:
      label1444:
      label1454:
      label1460:
      label1595:
      for (;;)
      {
        double d1 = l1 / l2;
        agqd.a(l1, this.jdField_q_of_type_Long, this.jdField_f_of_type_Boolean, d1);
        if ((d1 >= 0.0D) && (d1 <= 1.0D)) {
          this.jdField_a_of_type_JavaUtilHashMap.put("param_AIOPercent", d1 + "");
        }
        this.jdField_a_of_type_JavaUtilHashMap.put("param_AIODuration", l1 + "");
        if (QLog.isColorLevel()) {
          QLog.d("GroupPicUploadProcessor", 2, "doReport ,mStartTime = " + this.jdField_k_of_type_Long + ",mEnterAioTime = " + this.jdField_u_of_type_Long + ",finishTime  = " + l3 + ", aioDuration = " + l1 + ", duration = " + l2 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.jdField_a_of_type_Aywc.j + ",Percent = " + d1);
        }
        axrn.a(BaseApplication.getContext()).a(null, b(), true, l2, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        for (;;)
        {
          b(paramBoolean, l2);
          l();
          super.a(paramBoolean);
          AppNetConnInfo.unregisterNetEventHandler(this);
          return;
          i = 1;
          break;
          i = ((MessageForPtt)localObject2).voiceChangeFlag;
          break label575;
          l1 = ((MessageForPtt)localObject2).fileSize;
          break label583;
          i = 0;
          break label999;
          if (this.jdField_j_of_type_Int != -9527) {
            this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
          }
          this.jdField_a_of_type_JavaUtilHashMap.remove("param_url");
          this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
          this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_q_of_type_Long));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_uniseq", String.valueOf(this.jdField_a_of_type_Aywc.jdField_a_of_type_Long));
          axrn.a(BaseApplication.getContext()).a(null, b(), false, l2, this.jdField_q_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
        }
      }
    }
  }
  
  public void aR_()
  {
    super.aR_();
    if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_a_of_type_Aywc.jdField_l_of_type_Boolean))
    {
      if (bcad.a(this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString, this)) {
        try
        {
          if (this.jdField_r_of_type_Boolean)
          {
            d(1001);
            this.jdField_r_of_type_Boolean = true;
          }
          return;
        }
        finally {}
      }
      if (d() == 0) {
        c(false);
      }
    }
    else
    {
      c(false);
    }
  }
  
  public int b()
  {
    if ((!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Aywc.jdField_n_of_type_Boolean) && (this.jdField_a_of_type_Aywc.o))
    {
      i();
      t();
    }
    while (!this.jdField_k_of_type_Boolean) {
      return 0;
    }
    this.jdField_k_of_type_Boolean = false;
    this.o = false;
    d(1002);
    if (this.w != 1)
    {
      this.jdField_s_of_type_Long = 0L;
      this.jdField_m_of_type_JavaLangString = null;
    }
    this.jdField_t_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_j_of_type_JavaLangString = "";
    this.jdField_a_of_type_Bgbd.a();
    x();
    this.jdField_a_of_type_Ayvx.a.post(new GroupPicUploadProcessor.4(this));
    return 0;
  }
  
  protected String b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.w == 1) {
        return "actGroupPicUploadV2";
      }
      return "actGroupPicUploadV1";
    }
    if (this.w == 1) {
      return "actDiscussPicUploadV2";
    }
    return "actDiscussPicUpload";
  }
  
  protected im_msg_body.RichText b()
  {
    for (;;)
    {
      Object localObject4;
      int i;
      Object localObject5;
      Object localObject3;
      Object localObject6;
      try
      {
        localObject4 = new im_msg_body.CustomFace();
        ((im_msg_body.CustomFace)localObject4).uint32_file_id.set((int)this.jdField_a_of_type_Long);
        if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
        {
          localObject1 = (ayuq)this.jdField_a_of_type_JavaUtilArrayList.get(0);
          ((im_msg_body.CustomFace)localObject4).uint32_server_ip.set(a(((ayuq)localObject1).jdField_a_of_type_JavaLangString));
          ((im_msg_body.CustomFace)localObject4).uint32_server_port.set(((ayuq)localObject1).jdField_a_of_type_Int);
        }
        g();
        ((im_msg_body.CustomFace)localObject4).uint32_file_type.set(Integer.valueOf(66).intValue());
        ((im_msg_body.CustomFace)localObject4).uint32_useful.set(1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
          ((im_msg_body.CustomFace)localObject4).bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
        }
        ((im_msg_body.CustomFace)localObject4).bytes_md5.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ArrayOfByte));
        ((im_msg_body.CustomFace)localObject4).str_file_path.set(this.jdField_d_of_type_JavaLangString);
        Object localObject1 = ((im_msg_body.CustomFace)localObject4).uint32_origin;
        if (!this.jdField_l_of_type_Boolean) {
          break label1249;
        }
        i = 1;
        ((PBUInt32Field)localObject1).set(i);
        localObject5 = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if (MessageForPic.class.isInstance(localObject5))
        {
          localObject3 = (MessageForPic)localObject5;
          ((im_msg_body.CustomFace)localObject4).uint32_show_len.set(((MessageForPic)localObject3).mShowLength);
          ((im_msg_body.CustomFace)localObject4).uint32_download_len.set(((MessageForPic)localObject3).mDownloadLength);
          ((im_msg_body.CustomFace)localObject4).image_type.set(((MessageForPic)localObject3).imageType);
          if (((MessageForPic)localObject3).picExtraData != null)
          {
            localObject1 = ((MessageForPic)localObject3).picExtraData.getCustomFaceResvAttr();
            ((CustomFaceExtPb.ResvAttr)localObject1).uint32_source.set(a((MessageForPic)localObject3));
            ((im_msg_body.CustomFace)localObject4).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject1).get()).toByteArray()), true);
            i = 200;
          }
        }
        switch (this.jdField_a_of_type_Aywc.jdField_e_of_type_Int)
        {
        case 1008: 
          ((im_msg_body.CustomFace)localObject4).uint32_width.set(this.p);
          ((im_msg_body.CustomFace)localObject4).uint32_height.set(this.jdField_q_of_type_Int);
          ((im_msg_body.CustomFace)localObject4).uint32_size.set((int)this.jdField_q_of_type_Long);
          ((im_msg_body.CustomFace)localObject4).uint32_source.set(i);
          if (QLog.isColorLevel()) {
            b("busiTypeStat", "uiBusiType:" + this.jdField_a_of_type_Aywc.jdField_e_of_type_Int + " protoBusiType:" + ((im_msg_body.CustomFace)localObject4).biz_type.get());
          }
          localObject3 = new im_msg_body.RichText();
          localObject1 = new im_msg_body.Elem();
          if (!ajyi.a((MessageRecord)localObject5)) {
            break label1064;
          }
          ((im_msg_body.Elem)localObject1).hc_flash_pic.set((MessageMicro)localObject4);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
          localObject1 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(ajya.a(2131705361)));
          localObject4 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject4).text.set((MessageMicro)localObject1);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject4);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
          if ((localObject1 instanceof MessageForStructing))
          {
            localObject4 = (MessageForStructing)localObject1;
            if ((((MessageForStructing)localObject4).structingMsg != null) && ((((MessageForStructing)localObject4).structingMsg instanceof StructMsgForImageShare)))
            {
              localObject6 = (StructMsgForImageShare)((MessageForStructing)localObject4).structingMsg;
              localObject5 = ((StructMsgForImageShare)localObject6).getFirstImageElement();
              if (localObject5 != null)
              {
                ((axwv)localObject5).U = this.jdField_c_of_type_JavaLangString;
                ((axwv)localObject5).T = this.jdField_d_of_type_JavaLangString;
                ((axwv)localObject5).jdField_c_of_type_Long = this.jdField_a_of_type_Long;
                ((axwv)localObject5).jdField_e_of_type_Long = ((MessageRecord)localObject1).time;
                ((axwv)localObject5).jdField_d_of_type_Long = this.jdField_q_of_type_Long;
                if (!aeht.b(((StructMsgForImageShare)localObject6).mMsgActionData)) {
                  break label1232;
                }
                localObject6 = ((axwv)localObject5).S;
                ((axwv)localObject5).S = "";
                localObject1 = ((MessageForStructing)localObject4).structingMsg.getXmlBytes();
                ((axwv)localObject5).S = ((String)localObject6);
                if ((!TextUtils.isEmpty(((MessageForStructing)localObject4).frienduin)) && (localObject1 != null))
                {
                  localObject4 = new im_msg_body.RichMsg();
                  ((im_msg_body.RichMsg)localObject4).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
                  localObject1 = new im_msg_body.Elem();
                  ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject4);
                  ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
                }
              }
            }
          }
          localObject1 = a();
          if ((localObject3 == null) || (((im_msg_body.RichText)localObject3).elems == null) || (localObject1 == null)) {
            break label1247;
          }
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject1);
          if (!QLog.isColorLevel()) {
            break label1247;
          }
          QLog.e("GroupPicUploadProcessor", 2, "QQ 18 constructPicRichText add richtext common_elem headid and type");
          break label1247;
          localObject1 = new CustomFaceExtPb.ResvAttr();
          continue;
          if (!MessageForStructing.class.isInstance(localObject5)) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("GroupPicUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      if (((MessageForStructing)localObject5).isHotPicsStruct())
      {
        Object localObject2 = new CustomFaceExtPb.ResvAttr();
        ((CustomFaceExtPb.ResvAttr)localObject2).uint32_image_biz_type.set(2);
        ((im_msg_body.CustomFace)localObject4).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((CustomFaceExtPb.ResvAttr)((CustomFaceExtPb.ResvAttr)localObject2).get()).toByteArray()), true);
        continue;
        ((im_msg_body.CustomFace)localObject4).biz_type.set(2);
        i = 105;
        continue;
        ((im_msg_body.CustomFace)localObject4).biz_type.set(3);
        i = 101;
        continue;
        ((im_msg_body.CustomFace)localObject4).biz_type.set(4);
        i = 104;
        continue;
        ((im_msg_body.CustomFace)localObject4).biz_type.set(5);
        i = 103;
        continue;
        ((im_msg_body.CustomFace)localObject4).biz_type.set(6);
        i = 106;
        continue;
        ((im_msg_body.CustomFace)localObject4).biz_type.set(7);
        continue;
        ((im_msg_body.CustomFace)localObject4).biz_type.set(8);
        continue;
        ((im_msg_body.CustomFace)localObject4).biz_type.set(9);
        continue;
        label1064:
        if (ajwb.a((MessageRecord)localObject5))
        {
          localObject5 = new im_msg_body.CommonElem();
          ((im_msg_body.CommonElem)localObject5).uint32_service_type.set(3);
          localObject6 = new hummer_commelem.MsgElemInfo_servtype3();
          ((hummer_commelem.MsgElemInfo_servtype3)localObject6).flash_troop_pic.set((MessageMicro)localObject4);
          ((im_msg_body.CommonElem)localObject5).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype3)localObject6).toByteArray()));
          ((im_msg_body.Elem)localObject2).common_elem.set((MessageMicro)localObject5);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("flash", 2, "GroupPicUploadProcessor constructPicRichText send flash");
          }
          localObject2 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(ajya.a(2131705360)));
          localObject4 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject4).text.set((MessageMicro)localObject2);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject4);
        }
        else
        {
          ((im_msg_body.Elem)localObject2).custom_face.set((MessageMicro)localObject4);
          ((im_msg_body.RichText)localObject3).elems.add((MessageMicro)localObject2);
          continue;
          label1232:
          localObject2 = ((MessageForStructing)localObject4).structingMsg.getXmlBytes();
          continue;
          continue;
          label1247:
          return localObject3;
          label1249:
          i = 0;
        }
      }
    }
  }
  
  protected void b(ayyp paramayyp, ayze paramayze)
  {
    this.jdField_a_of_type_Ayyp = null;
    int i;
    if (paramayze != null)
    {
      i = 0;
      if (i < paramayze.jdField_a_of_type_JavaUtilList.size())
      {
        paramayyp = (ayzr)paramayze.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          b("procUrl", paramayyp.toString());
        }
        this.jdField_i_of_type_Boolean = paramayyp.d;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.jdField_i_of_type_Boolean);
        }
        a(this.jdField_a_of_type_Aypd, paramayyp);
        if (!(paramayyp instanceof ayzj)) {
          break label340;
        }
        paramayyp = (ayzj)paramayyp;
        if (paramayyp.c != 0) {
          break label297;
        }
        b(paramayyp.jdField_a_of_type_Boolean);
        if (paramayyp.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp GroupPicUpResp.isExist.");
          }
          this.jdField_f_of_type_Boolean = true;
          this.jdField_a_of_type_Ayqo.jdField_e_of_type_Long = this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long;
          this.jdField_a_of_type_Long = paramayyp.jdField_a_of_type_Long;
          this.jdField_a_of_type_JavaUtilArrayList = paramayyp.jdField_a_of_type_JavaUtilArrayList;
          t();
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      d(1002);
      if (!a()) {
        return;
      }
      this.jdField_a_of_type_Long = paramayyp.jdField_a_of_type_Long;
      this.jdField_m_of_type_JavaLangString = paramayyp.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaUtilArrayList = paramayyp.jdField_a_of_type_JavaUtilArrayList;
      this.jdField_s_of_type_Long = paramayyp.jdField_b_of_type_Int;
      this.jdField_t_of_type_Long = paramayyp.jdField_a_of_type_Int;
      this.jdField_r_of_type_Long = paramayyp.jdField_b_of_type_Long;
      this.w = 1;
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
      }
      s();
      continue;
      label297:
      d("<BDH_LOG> onBusiProtoResp() error : " + paramayyp.c + " ,select HTTP channel");
      this.w = 2;
      d();
      return;
      label340:
      if (!(paramayyp instanceof ayzl)) {
        continue;
      }
      if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 1026) && (QLog.isColorLevel())) {
        QLog.i("PttShow", 2, "onBusiProtoResp, UIN_TYPE_HOTCHAT_TOPIC");
      }
      paramayyp = (ayzl)paramayyp;
      if (paramayyp.c == 0) {
        if (paramayyp.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Ayqo.jdField_e_of_type_Long = this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long;
          this.jdField_a_of_type_Long = paramayyp.jdField_a_of_type_Long;
          if (paramayyp.jdField_a_of_type_ArrayOfByte == null) {}
        }
      }
      try
      {
        this.jdField_a_of_type_JavaLangString = new String(paramayyp.jdField_a_of_type_ArrayOfByte, "utf-8");
        for (;;)
        {
          try
          {
            label442:
            if ((!this.jdField_a_of_type_Aywc.jdField_n_of_type_Boolean) || (this.jdField_a_of_type_Aywc.o))
            {
              t();
              if (this.jdField_a_of_type_Aywc.jdField_n_of_type_Boolean)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("PttPreSendManager", 4, "group group  upResp.isExist, can send msg, direct send");
                }
                avcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(a());
              }
              break;
            }
          }
          finally {}
          if (QLog.isDevelopLevel()) {
            QLog.d("PttPreSendManager", 4, "group group  upResp.isExist, can't send msg, wait");
          }
          this.jdField_a_of_type_Aywc.o = true;
        }
        this.jdField_a_of_type_Long = paramayyp.jdField_a_of_type_Long;
        if (paramayyp.jdField_a_of_type_ArrayOfByte != null) {}
        try
        {
          this.jdField_a_of_type_JavaLangString = new String(paramayyp.jdField_a_of_type_ArrayOfByte, "utf-8");
          label578:
          this.jdField_m_of_type_JavaLangString = paramayyp.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_JavaUtilArrayList = paramayyp.jdField_a_of_type_JavaUtilArrayList;
          this.jdField_s_of_type_Long = paramayyp.jdField_b_of_type_Int;
          this.jdField_t_of_type_Long = paramayyp.jdField_a_of_type_Int;
          b("OnProtoResp", " TryUpload response GrpFileKey:" + this.jdField_a_of_type_JavaLangString);
          this.w = 2;
          r();
          continue;
          d();
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          break label578;
        }
      }
      catch (UnsupportedEncodingException paramayyp)
      {
        break label442;
      }
    }
  }
  
  public int c()
  {
    super.c();
    if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_a_of_type_Aywc.jdField_l_of_type_Boolean)) {
      return 0;
    }
    return d();
  }
  
  public long c()
  {
    if ((this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Aywc.jdField_l_of_type_Boolean)) {
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
      if (this.jdField_a_of_type_Ayyp != null)
      {
        ayzv.b(this.jdField_a_of_type_Ayyp);
        this.jdField_a_of_type_Ayyp = null;
      }
    }
    switch (this.w)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return;
        d("<BDH_LOG> pause() BUT current status is INIT");
        return;
        d("<BDH_LOG> pause() pause HTTP channel");
      } while (this.jdField_a_of_type_Aysy == null);
      this.jdField_a_of_type_Aysa.b(this.jdField_a_of_type_Aysy);
      this.jdField_a_of_type_Aysy = null;
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
  
  protected void c(boolean paramBoolean)
  {
    if (!paramBoolean) {
      d(1001);
    }
    d(1000);
    this.jdField_a_of_type_Ayqo.a();
    d(1001);
    Object localObject = a();
    if ((localObject != null) && (((aywc)localObject).jdField_h_of_type_Boolean))
    {
      this.p = ((aywc)localObject).jdField_l_of_type_Int;
      this.jdField_q_of_type_Int = ((aywc)localObject).jdField_m_of_type_Int;
      this.jdField_q_of_type_Long = ((aywc)localObject).jdField_e_of_type_Long;
      this.jdField_a_of_type_ArrayOfByte = bbea.a(((aywc)localObject).f);
      this.jdField_d_of_type_JavaLangString = ((aywc)localObject).f;
      this.jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      this.jdField_a_of_type_Ayqo.f = this.jdField_d_of_type_JavaLangString;
      this.jdField_d_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString + "." + this.e);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
    }
    while (!a(this.jdField_g_of_type_Boolean)) {
      return;
    }
    String str;
    int i;
    if (!this.jdField_g_of_type_Boolean)
    {
      localObject = (MessageForPtt)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      str = this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString;
      if (localObject != null) {
        break label244;
      }
      i = 0;
      if (localObject != null) {
        break label253;
      }
    }
    label244:
    label253:
    for (long l = 0L;; l = ((MessageForPtt)localObject).fileSize)
    {
      aytn.a(str, false, false, i, l);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().preConnect();
      f();
      return;
      i = ((MessageForPtt)localObject).voiceChangeFlag;
      break;
    }
  }
  
  protected int d()
  {
    boolean bool = true;
    int j = 0;
    b("uiParam", this.jdField_a_of_type_Aywc.toString());
    int i;
    switch (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_b_of_type_Boolean = false;
      if (2 == this.jdField_a_of_type_Aywc.jdField_b_of_type_Int) {
        bool = false;
      }
      this.jdField_g_of_type_Boolean = bool;
      if ((!this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null))
      {
        b(9302, a(new Exception("message null")));
        d();
        i = -1;
      }
      break;
    }
    label193:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            this.jdField_b_of_type_Boolean = true;
            break;
            localObject = a();
            if ((localObject == null) || (!((aywc)localObject).jdField_h_of_type_Boolean)) {
              break label193;
            }
            i = j;
          } while (this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject == null);
          i = j;
        } while (!(this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject instanceof aywg));
        this.jdField_l_of_type_Boolean = ((aywg)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
        return 0;
        Object localObject = this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          b(9302, a(new Exception("filePath null")));
          d();
          return -1;
        }
        File localFile = new File((String)localObject);
        if (!localFile.exists())
        {
          b(9042, a(new Exception("sendFile not exist " + (String)localObject)));
          d();
          return -1;
        }
        if (!localFile.canRead())
        {
          b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_Ayqo.jdField_c_of_type_JavaLangString)));
          d();
          return -1;
        }
        long l = localFile.length();
        this.jdField_a_of_type_Ayqo.jdField_a_of_type_Long = l;
        this.jdField_q_of_type_Long = l;
        if (l <= 0L)
        {
          b(9071, a(new Exception("file size 0 " + (String)localObject)));
          d();
          return -1;
        }
        if (this.jdField_g_of_type_Boolean)
        {
          localObject = bbdx.b((String)localObject);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            if ((((String)localObject).contains(bbdx.jdField_a_of_type_JavaLangString)) || (!bbdx.g((String)localObject)))
            {
              a(9072, (String)localObject, d((String)localObject), null);
              d();
              new Handler(Looper.getMainLooper()).post(new GroupPicUploadProcessor.1(this));
              return -1;
            }
            this.e = ((String)localObject);
          }
          if (l >= ayxe.b())
          {
            a(9063, (String)localObject, d((String)localObject), null);
            d();
            return -1;
          }
        }
        else
        {
          this.e = "amr";
        }
        i = j;
      } while (this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject == null);
      i = j;
    } while (!(this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject instanceof aywg));
    this.jdField_l_of_type_Boolean = ((aywg)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Boolean;
    return 0;
  }
  
  void d()
  {
    super.d();
    d(1005);
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq != null)
    {
      auor localauor = new auor();
      localauor.jdField_a_of_type_Int = -1;
      localauor.jdField_b_of_type_Int = this.jdField_j_of_type_Int;
      localauor.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq.b(localauor);
    }
    if (this.jdField_a_of_type_Aywc.jdField_n_of_type_Boolean) {
      avcq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(a());
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (this.jdField_t_of_type_Boolean) {
      bjmu.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, paramInt, f());
    }
  }
  
  public void d(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
    {
      localMessageRecord = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (localMessageRecord != null) {
        break label78;
      }
      b("updateDb", "msg null");
    }
    label78:
    Object localObject;
    axwv localaxwv;
    do
    {
      do
      {
        do
        {
          return;
          localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
          b("updateDb", "findmsgbyMsgId,need fix");
          break;
          if (localMessageRecord.isMultiMsg)
          {
            b("updateDb", "is multiMsg");
            return;
          }
          if ((this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 2) && ((localMessageRecord instanceof MessageForPtt)))
          {
            localObject = (MessageForPtt)localMessageRecord;
            if (!this.jdField_a_of_type_Aywc.jdField_n_of_type_Boolean) {
              ((MessageForPtt)localObject).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject).voiceType, this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString);
            }
            ((MessageForPtt)localObject).fileSize = this.jdField_q_of_type_Long;
            ((MessageForPtt)localObject).urlAtServer = this.jdField_d_of_type_JavaLangString;
            ((MessageForPtt)localObject).itemType = 2;
            ((MessageForPtt)localObject).groupFileID = this.jdField_a_of_type_Long;
            ((MessageForPtt)localObject).groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
            ((MessageForPtt)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPtt)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPtt)localObject).msgData);
            return;
          }
          if ((localMessageRecord instanceof MessageForPic))
          {
            localObject = (MessageForPic)localMessageRecord;
            ((MessageForPic)localObject).path = this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString;
            ((MessageForPic)localObject).size = this.jdField_q_of_type_Long;
            ((MessageForPic)localObject).uuid = this.jdField_d_of_type_JavaLangString;
            ((MessageForPic)localObject).groupFileID = this.jdField_a_of_type_Long;
            ((MessageForPic)localObject).md5 = this.jdField_c_of_type_JavaLangString;
            ((MessageForPic)localObject).type = 1;
            ((MessageForPic)localObject).serial();
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForPic)localObject).msgData);
            return;
          }
        } while (!(localMessageRecord instanceof MessageForStructing));
        localObject = (MessageForStructing)localMessageRecord;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForImageShare)));
      localaxwv = ((StructMsgForImageShare)((MessageForStructing)localObject).structingMsg).getFirstImageElement();
    } while (localaxwv == null);
    localaxwv.U = this.jdField_c_of_type_JavaLangString;
    localaxwv.T = this.jdField_d_of_type_JavaLangString;
    localaxwv.jdField_d_of_type_Long = this.jdField_q_of_type_Long;
    localaxwv.jdField_c_of_type_Long = this.jdField_a_of_type_Long;
    localaxwv.jdField_e_of_type_Long = localMessageRecord.time;
    ((MessageForStructing)localObject).msgData = ((MessageForStructing)localObject).structingMsg.getBytes();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, localMessageRecord.uniseq, ((MessageForStructing)localObject).msgData);
  }
  
  void e()
  {
    super.e();
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq != null)
    {
      localObject = new auor();
      ((auor)localObject).jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      ((auor)localObject).jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      ((auor)localObject).jdField_c_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((auor)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString;
      ((auor)localObject).jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Aywc.jdField_r_of_type_Boolean) {
        ((auor)localObject).jdField_a_of_type_JavaLangObject = a();
      }
      this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq.b((auor)localObject);
      d(1003);
      if (!this.jdField_g_of_type_Boolean) {
        if (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
          break label224;
        }
      }
    }
    label224:
    for (Object localObject = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;; localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long))
    {
      if ((localObject != null) && ((localObject instanceof MessageForPtt)) && (((ayaj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).b((MessageForPtt)localObject)))
      {
        axqy.b(null, "dc00898", "", "", "0X8009DF6", "0X8009DF6", 0, 0, "", "", "", "");
        ((ayaj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).b((MessageForPtt)localObject, 2);
      }
      return;
      d(true);
      break;
    }
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Aypd.a();
    ayyp localayyp = new ayyp();
    Object localObject1;
    Object localObject2;
    if (this.jdField_g_of_type_Boolean)
    {
      localObject1 = new ayyy();
      ((ayyy)localObject1).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((ayyy)localObject1).jdField_a_of_type_Long = this.jdField_q_of_type_Long;
      ((ayyy)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((ayyy)localObject1).c = this.p;
      ((ayyy)localObject1).d = this.jdField_q_of_type_Int;
      ((ayyy)localObject1).jdField_b_of_type_Boolean = this.jdField_l_of_type_Boolean;
      ((ayyy)localObject1).jdField_b_of_type_Int = this.jdField_a_of_type_Aywc.jdField_e_of_type_Int;
      a((ayyy)localObject1);
      localObject2 = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (MessageForPic.class.isInstance(localObject2))
      {
        ((ayyy)localObject1).jdField_a_of_type_Int = ((MessageForPic)localObject2).imageType;
        this.jdField_u_of_type_Int = ((MessageForPic)localObject2).imageType;
      }
      ((ayza)localObject1).jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_b_of_type_JavaLangString;
      ((ayza)localObject1).jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString;
      ((ayza)localObject1).e = this.jdField_a_of_type_Aywc.jdField_d_of_type_JavaLangString;
      ((ayza)localObject1).jdField_f_of_type_Int = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 1026)
      {
        ((ayza)localObject1).jdField_f_of_type_Int = 1;
        if (QLog.isColorLevel()) {
          QLog.i("PttShow", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
        }
      }
      localayyp.jdField_a_of_type_Ayzw = this;
      if (!this.jdField_g_of_type_Boolean) {
        break label359;
      }
      localObject2 = "grp_pic_up";
      label227:
      localayyp.jdField_a_of_type_JavaLangString = ((String)localObject2);
      localayyp.jdField_a_of_type_JavaUtilList.add(localObject1);
      localayyp.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      if (e()) {
        break label366;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_Aypd);
      d();
    }
    label359:
    label366:
    do
    {
      return;
      localObject1 = new ayyz();
      ((ayyz)localObject1).jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
      ((ayyz)localObject1).jdField_b_of_type_Int = ((int)this.jdField_q_of_type_Long);
      ((ayyz)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ((ayyz)localObject1).jdField_a_of_type_Int = QQRecorder.a(this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      ((ayyz)localObject1).d = this.jdField_a_of_type_Aywc.jdField_n_of_type_Int;
      ((ayyz)localObject1).c = ((MessageForPtt)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).voiceType;
      break;
      localObject2 = "grp_ptt_up";
      break label227;
      if (QLog.isColorLevel()) {
        b("requestStart", localayyp.toString());
      }
    } while (!f());
    this.jdField_a_of_type_Ayyp = localayyp;
    ayzv.a(localayyp);
  }
  
  protected void n()
  {
    int i = this.jdField_a_of_type_Aywc.jdField_b_of_type_Int;
    if ((this.jdField_a_of_type_Aysy instanceof ayrx))
    {
      if (!this.jdField_b_of_type_Boolean) {
        break label58;
      }
      if (i != 2) {
        break label31;
      }
    }
    label31:
    label58:
    while (i == 2)
    {
      return;
      ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picGu", ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
      return;
    }
    ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString = MsfSdkUtils.insertMtype("picDu", ((ayrx)this.jdField_a_of_type_Aysy).jdField_a_of_type_JavaLangString);
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
      this.jdField_s_of_type_Boolean = true;
      return;
    }
  }
  
  /* Error */
  public void onResp(aysz paramaysz)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 1610	ayoy:onResp	(Laysz;)V
    //   8: aload_0
    //   9: getfield 880	ayrf:o	Z
    //   12: ifne +10 -> 22
    //   15: aload_0
    //   16: getfield 879	ayrf:jdField_k_of_type_Boolean	Z
    //   19: ifeq +4 -> 23
    //   22: return
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 1270	ayrf:jdField_a_of_type_Aysy	Laysy;
    //   28: aload_1
    //   29: getfield 1613	aysz:c	I
    //   32: istore_2
    //   33: aload_0
    //   34: ldc_w 1614
    //   37: new 201	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 1616
    //   47: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_1
    //   51: getfield 1617	aysz:jdField_a_of_type_Int	I
    //   54: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc_w 1619
    //   60: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: getfield 1620	aysz:jdField_b_of_type_Int	I
    //   67: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 1622
    //   73: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: getfield 1623	aysz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   80: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 317	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 1030	ayrf:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_1
    //   90: getfield 1617	aysz:jdField_a_of_type_Int	I
    //   93: ifne +670 -> 763
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 1624	ayrf:jdField_l_of_type_Int	I
    //   101: aload_0
    //   102: getfield 54	ayrf:jdField_a_of_type_Bgbd	Lbgbd;
    //   105: invokevirtual 1626	bgbd:b	()V
    //   108: aload_1
    //   109: getfield 1627	aysz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   112: ldc_w 1629
    //   115: invokevirtual 656	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: ifnull +779 -> 897
    //   121: aload_1
    //   122: getfield 1627	aysz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   125: ldc_w 1629
    //   128: invokevirtual 656	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 100	java/lang/String
    //   134: invokestatic 462	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   137: lstore 7
    //   139: lload 7
    //   141: lconst_0
    //   142: lcmp
    //   143: ifeq +87 -> 230
    //   146: lload 7
    //   148: ldc2_w 1630
    //   151: lcmp
    //   152: ifeq +78 -> 230
    //   155: aload_0
    //   156: aload_0
    //   157: getfield 633	ayrf:jdField_b_of_type_Aypd	Laypd;
    //   160: aload_1
    //   161: iconst_0
    //   162: invokevirtual 1634	ayrf:a	(Laypd;Laysz;Z)V
    //   165: lload 7
    //   167: l2i
    //   168: invokestatic 1638	ayyh:a	(I)Z
    //   171: ifne +59 -> 230
    //   174: aload_0
    //   175: sipush -9527
    //   178: aconst_null
    //   179: iload_2
    //   180: lload 7
    //   182: invokestatic 1641	ayrf:a	(IJ)Ljava/lang/String;
    //   185: aload_0
    //   186: getfield 633	ayrf:jdField_b_of_type_Aypd	Laypd;
    //   189: invokevirtual 1382	ayrf:a	(ILjava/lang/String;Ljava/lang/String;Laypd;)V
    //   192: aload_0
    //   193: invokevirtual 1205	ayrf:d	()V
    //   196: return
    //   197: astore_1
    //   198: aload_0
    //   199: sipush 9343
    //   202: new 96	java/lang/Exception
    //   205: dup
    //   206: ldc_w 1643
    //   209: invokespecial 1333	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   212: invokestatic 1646	ayoj:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   215: ldc_w 732
    //   218: aload_0
    //   219: getfield 633	ayrf:jdField_b_of_type_Aypd	Laypd;
    //   222: invokevirtual 1382	ayrf:a	(ILjava/lang/String;Ljava/lang/String;Laypd;)V
    //   225: aload_0
    //   226: invokevirtual 1205	ayrf:d	()V
    //   229: return
    //   230: aload_1
    //   231: getfield 1627	aysz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   234: ldc_w 1648
    //   237: invokevirtual 656	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   240: checkcast 100	java/lang/String
    //   243: astore 11
    //   245: aload 11
    //   247: ifnull +658 -> 905
    //   250: aload 11
    //   252: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   255: istore_2
    //   256: iload_2
    //   257: i2l
    //   258: lstore_3
    //   259: lload_3
    //   260: lstore 5
    //   262: lload_3
    //   263: ldc2_w 1630
    //   266: lcmp
    //   267: ifne +44 -> 311
    //   270: aload_1
    //   271: getfield 1627	aysz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   274: ldc_w 1650
    //   277: invokevirtual 656	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: checkcast 100	java/lang/String
    //   283: astore 10
    //   285: aload 10
    //   287: astore 9
    //   289: lload_3
    //   290: lstore 5
    //   292: aload 10
    //   294: ifnull +17 -> 311
    //   297: aload 10
    //   299: invokestatic 109	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   302: istore_2
    //   303: iload_2
    //   304: i2l
    //   305: lstore 5
    //   307: aload 10
    //   309: astore 9
    //   311: lload 5
    //   313: ldc2_w 1630
    //   316: lcmp
    //   317: ifne +124 -> 441
    //   320: aload_0
    //   321: aload_0
    //   322: getfield 633	ayrf:jdField_b_of_type_Aypd	Laypd;
    //   325: aload_1
    //   326: iconst_0
    //   327: invokevirtual 1634	ayrf:a	(Laypd;Laysz;Z)V
    //   330: aload_0
    //   331: sipush -9527
    //   334: new 201	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   341: ldc_w 1652
    //   344: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload 11
    //   349: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 1654
    //   355: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 9
    //   360: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 317	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: aload_0
    //   367: getfield 1656	ayrf:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   370: aload_0
    //   371: getfield 1658	ayrf:jdField_g_of_type_Int	I
    //   374: i2l
    //   375: invokestatic 1661	ayrf:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   378: aload_0
    //   379: getfield 633	ayrf:jdField_b_of_type_Aypd	Laypd;
    //   382: invokevirtual 1382	ayrf:a	(ILjava/lang/String;Ljava/lang/String;Laypd;)V
    //   385: aload_0
    //   386: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   389: ifnull +18 -> 407
    //   392: aload_0
    //   393: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   396: getfield 595	aywc:jdField_b_of_type_Int	I
    //   399: iconst_2
    //   400: if_icmpne +7 -> 407
    //   403: iconst_0
    //   404: invokestatic 1662	aytn:b	(Z)V
    //   407: aload_0
    //   408: invokevirtual 1205	ayrf:d	()V
    //   411: return
    //   412: astore 10
    //   414: aload 10
    //   416: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   419: goto +486 -> 905
    //   422: astore 9
    //   424: aload 9
    //   426: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   429: ldc2_w 1630
    //   432: lstore 5
    //   434: aload 10
    //   436: astore 9
    //   438: goto -127 -> 311
    //   441: aload_0
    //   442: ldc_w 1664
    //   445: new 201	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   452: ldc_w 1666
    //   455: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_0
    //   459: getfield 219	ayrf:jdField_s_of_type_Long	J
    //   462: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   465: ldc_w 1668
    //   468: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: lload 5
    //   473: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   476: ldc_w 1670
    //   479: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: lload 7
    //   484: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: invokevirtual 317	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokevirtual 1030	ayrf:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: lload 5
    //   495: aload_0
    //   496: getfield 219	ayrf:jdField_s_of_type_Long	J
    //   499: lcmp
    //   500: ifgt +31 -> 531
    //   503: aload_0
    //   504: getfield 885	ayrf:jdField_t_of_type_Int	I
    //   507: iconst_3
    //   508: if_icmpge +74 -> 582
    //   511: aload_0
    //   512: ldc_w 1672
    //   515: ldc_w 1674
    //   518: invokevirtual 1030	ayrf:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload_0
    //   522: aload_0
    //   523: getfield 885	ayrf:jdField_t_of_type_Int	I
    //   526: iconst_1
    //   527: iadd
    //   528: putfield 885	ayrf:jdField_t_of_type_Int	I
    //   531: aload_0
    //   532: getfield 337	ayrf:jdField_a_of_type_Ayqo	Layqo;
    //   535: lload 5
    //   537: putfield 1182	ayqo:jdField_e_of_type_Long	J
    //   540: aload_0
    //   541: lload 5
    //   543: putfield 219	ayrf:jdField_s_of_type_Long	J
    //   546: aload_0
    //   547: aload_0
    //   548: getfield 633	ayrf:jdField_b_of_type_Aypd	Laypd;
    //   551: aload_1
    //   552: iconst_1
    //   553: invokevirtual 1634	ayrf:a	(Laypd;Laysz;Z)V
    //   556: lload 5
    //   558: aload_0
    //   559: getfield 212	ayrf:jdField_q_of_type_Long	J
    //   562: lcmp
    //   563: ifge +92 -> 655
    //   566: aload_0
    //   567: getfield 880	ayrf:o	Z
    //   570: ifne -548 -> 22
    //   573: aload_0
    //   574: invokevirtual 875	ayrf:i	()V
    //   577: aload_0
    //   578: invokevirtual 1248	ayrf:r	()V
    //   581: return
    //   582: aload_0
    //   583: aload_0
    //   584: getfield 633	ayrf:jdField_b_of_type_Aypd	Laypd;
    //   587: aload_1
    //   588: iconst_0
    //   589: invokevirtual 1634	ayrf:a	(Laypd;Laysz;Z)V
    //   592: aload_0
    //   593: getfield 649	ayrf:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   596: ldc_w 1676
    //   599: new 201	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 308	java/lang/StringBuilder:<init>	()V
    //   606: ldc_w 732
    //   609: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: lload 7
    //   614: invokevirtual 215	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   617: invokevirtual 317	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokevirtual 668	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   623: pop
    //   624: aload_0
    //   625: sipush -9527
    //   628: ldc_w 732
    //   631: aload_0
    //   632: getfield 1656	ayrf:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   635: aload_0
    //   636: getfield 1677	ayrf:jdField_f_of_type_Int	I
    //   639: i2l
    //   640: invokestatic 1661	ayrf:a	(Ljava/lang/String;J)Ljava/lang/String;
    //   643: aload_0
    //   644: getfield 633	ayrf:jdField_b_of_type_Aypd	Laypd;
    //   647: invokevirtual 1382	ayrf:a	(ILjava/lang/String;Ljava/lang/String;Laypd;)V
    //   650: aload_0
    //   651: invokevirtual 1205	ayrf:d	()V
    //   654: return
    //   655: aload_0
    //   656: monitorenter
    //   657: aload_0
    //   658: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   661: getfield 627	aywc:jdField_n_of_type_Boolean	Z
    //   664: ifeq +13 -> 677
    //   667: aload_0
    //   668: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   671: getfield 873	aywc:o	Z
    //   674: ifeq +62 -> 736
    //   677: aload_0
    //   678: invokevirtual 877	ayrf:t	()V
    //   681: aload_0
    //   682: getfield 337	ayrf:jdField_a_of_type_Ayqo	Layqo;
    //   685: invokevirtual 1301	ayqo:a	()V
    //   688: aload_0
    //   689: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   692: getfield 627	aywc:jdField_n_of_type_Boolean	Z
    //   695: ifeq +33 -> 728
    //   698: invokestatic 1223	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   701: ifeq +13 -> 714
    //   704: ldc_w 1225
    //   707: iconst_4
    //   708: ldc_w 1679
    //   711: invokestatic 320	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   714: aload_0
    //   715: getfield 63	ayrf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   718: invokestatic 1232	avcq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lavcq;
    //   721: aload_0
    //   722: invokevirtual 1234	ayrf:a	()Ljava/lang/String;
    //   725: invokevirtual 1236	avcq:a	(Ljava/lang/String;)V
    //   728: aload_0
    //   729: monitorexit
    //   730: return
    //   731: astore_1
    //   732: aload_0
    //   733: monitorexit
    //   734: aload_1
    //   735: athrow
    //   736: aload_0
    //   737: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   740: iconst_1
    //   741: putfield 873	aywc:o	Z
    //   744: invokestatic 1223	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   747: ifeq -19 -> 728
    //   750: ldc_w 1225
    //   753: iconst_4
    //   754: ldc_w 1681
    //   757: invokestatic 320	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: goto -32 -> 728
    //   763: aload_0
    //   764: getfield 78	ayrf:jdField_a_of_type_Aywc	Laywc;
    //   767: getfield 83	aywc:jdField_a_of_type_ComTencentMobileqqDataMessageRecord	Lcom/tencent/mobileqq/data/MessageRecord;
    //   770: invokestatic 1682	ahjk:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   773: ifeq +12 -> 785
    //   776: invokestatic 1685	ahjk:a	()Lahjk;
    //   779: ldc_w 1687
    //   782: invokevirtual 1689	ahjk:c	(Ljava/lang/String;)V
    //   785: aload_1
    //   786: getfield 1620	aysz:jdField_b_of_type_Int	I
    //   789: sipush 9364
    //   792: if_icmpne +40 -> 832
    //   795: aload_0
    //   796: getfield 1624	ayrf:jdField_l_of_type_Int	I
    //   799: iconst_3
    //   800: if_icmpge +32 -> 832
    //   803: aload_0
    //   804: ldc_w 1691
    //   807: ldc_w 1693
    //   810: invokevirtual 1030	ayrf:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: aload_0
    //   814: aload_0
    //   815: getfield 1624	ayrf:jdField_l_of_type_Int	I
    //   818: iconst_1
    //   819: iadd
    //   820: putfield 1624	ayrf:jdField_l_of_type_Int	I
    //   823: aload_0
    //   824: invokevirtual 1695	ayrf:m	()V
    //   827: aload_0
    //   828: invokevirtual 1323	ayrf:f	()V
    //   831: return
    //   832: aload_1
    //   833: getfield 1696	aysz:jdField_a_of_type_Aysy	Laysy;
    //   836: getfield 1699	aysy:jdField_a_of_type_ArrayOfByte	[B
    //   839: arraylength
    //   840: ldc_w 1700
    //   843: if_icmplt +27 -> 870
    //   846: aload_1
    //   847: getfield 1620	aysz:jdField_b_of_type_Int	I
    //   850: invokestatic 1701	ayuc:a	(I)Z
    //   853: ifeq +17 -> 870
    //   856: aload_0
    //   857: iconst_1
    //   858: putfield 31	ayrf:jdField_a_of_type_Boolean	Z
    //   861: aload_0
    //   862: invokevirtual 1695	ayrf:m	()V
    //   865: aload_0
    //   866: invokevirtual 1248	ayrf:r	()V
    //   869: return
    //   870: aload_0
    //   871: aload_0
    //   872: getfield 633	ayrf:jdField_b_of_type_Aypd	Laypd;
    //   875: aload_1
    //   876: iconst_0
    //   877: invokevirtual 1634	ayrf:a	(Laypd;Laysz;Z)V
    //   880: aload_0
    //   881: aload_1
    //   882: getfield 1620	aysz:jdField_b_of_type_Int	I
    //   885: aload_1
    //   886: getfield 1623	aysz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   889: invokevirtual 1339	ayrf:b	(ILjava/lang/String;)V
    //   892: aload_0
    //   893: invokevirtual 1205	ayrf:d	()V
    //   896: return
    //   897: ldc2_w 1630
    //   900: lstore 7
    //   902: goto -763 -> 139
    //   905: ldc2_w 1630
    //   908: lstore_3
    //   909: goto -650 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	912	0	this	ayrf
    //   0	912	1	paramaysz	aysz
    //   32	272	2	i	int
    //   258	651	3	l1	long
    //   260	297	5	l2	long
    //   137	764	7	l3	long
    //   1	358	9	localObject1	Object
    //   422	3	9	localException1	Exception
    //   436	1	9	localObject2	Object
    //   283	25	10	str1	String
    //   412	23	10	localException2	Exception
    //   243	105	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   89	139	197	java/lang/Exception
    //   155	196	197	java/lang/Exception
    //   230	245	197	java/lang/Exception
    //   270	285	197	java/lang/Exception
    //   320	407	197	java/lang/Exception
    //   407	411	197	java/lang/Exception
    //   414	419	197	java/lang/Exception
    //   424	429	197	java/lang/Exception
    //   441	531	197	java/lang/Exception
    //   531	581	197	java/lang/Exception
    //   582	654	197	java/lang/Exception
    //   655	657	197	java/lang/Exception
    //   734	736	197	java/lang/Exception
    //   763	785	197	java/lang/Exception
    //   785	831	197	java/lang/Exception
    //   832	869	197	java/lang/Exception
    //   870	896	197	java/lang/Exception
    //   250	256	412	java/lang/Exception
    //   297	303	422	java/lang/Exception
    //   657	677	731	finally
    //   677	714	731	finally
    //   714	728	731	finally
    //   728	730	731	finally
    //   732	734	731	finally
    //   736	760	731	finally
  }
  
  public void r()
  {
    if (this.jdField_d_of_type_Long == -1L) {
      this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
    }
    super.aP_();
  }
  
  public void s()
  {
    if (this.jdField_d_of_type_Long == -1L) {
      this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
    }
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction + "  this:" + this);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {}
    int i;
    do
    {
      return;
      this.jdField_b_of_type_Aypd.a();
      Object localObject = bbea.a(this.jdField_m_of_type_JavaLangString);
      ayrg localayrg = new ayrg(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 2, this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString, (int)this.jdField_r_of_type_Long, (byte[])localObject, this.jdField_a_of_type_ArrayOfByte, localayrg);
      localObject = new ayrh(this);
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cbForReport = ((ITransCallbackForReport)localObject);
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      if (QLog.isColorLevel()) {
        QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_Aywc.jdField_a_of_type_Long + " MD5:" + this.jdField_c_of_type_JavaLangString + " uuid:" + this.jdField_l_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + 2);
      }
    } while (i == 0);
    a(i, "SubmitError.", "", this.jdField_b_of_type_Aypd);
    d();
  }
  
  void t()
  {
    if (!f())
    {
      d("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.w);
      return;
    }
    this.jdField_c_of_type_Aypd.a();
    if (QLog.isColorLevel()) {
      QLog.d("GroupPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
    }
    if (this.jdField_b_of_type_Boolean)
    {
      u();
      return;
    }
    v();
  }
  
  void u()
  {
    if (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 2)
    {
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Aypd);
        d();
      }
      label176:
      label203:
      MessageForPtt localMessageForPtt;
      do
      {
        return;
        if (!e())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_Aypd);
          d();
          return;
        }
        if (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject1 = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if ((localObject1 instanceof MessageForPtt)) {
            break label203;
          }
          localObject2 = new StringBuilder().append("Mr_");
          if (localObject1 != null) {
            break label176;
          }
        }
        for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
        {
          a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Aypd);
          d();
          return;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
          break;
        }
        localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        a((im_msg_body.RichText)localObject2, localMessageForPtt);
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "<---sendGroupMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
        }
        ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
        if ((this.jdField_a_of_type_Aywc.jdField_a_of_type_Int == 1026) && (QLog.isColorLevel())) {
          QLog.i("PttShow", 2, "sendGroupMsg, UIN_TYPE_HOTCHAT_TOPIC");
        }
        if (this.jdField_c_of_type_Boolean)
        {
          if (ahjk.a((MessageRecord)localObject1))
          {
            ahjk.a().a((MessageRecord)localObject1, this.jdField_a_of_type_Akat, this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, null, this);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_Akat);
          return;
        }
      } while (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq == null);
      localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString);
      localMessageForPtt.fileSize = this.jdField_q_of_type_Long;
      localMessageForPtt.urlAtServer = this.jdField_d_of_type_JavaLangString;
      localMessageForPtt.itemType = 2;
      localMessageForPtt.groupFileID = this.jdField_a_of_type_Long;
      localMessageForPtt.groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
      localMessageForPtt.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForPtt.serial();
      this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq.a((im_msg_body.RichText)localObject2);
      return;
    }
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Aywc.jdField_i_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Aywc.jdField_i_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.jdField_s_of_type_Long;
      }
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Aypd);
        d();
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Aywc.jdField_i_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
          ((MessageForPic)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
        }
        h();
        e();
        return;
        if (!e())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_Aypd);
          d();
          return;
        }
        if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq != null) {
          this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = b();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Aypd);
      d();
      return;
    }
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_Aypd);
      d();
      return;
    }
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq != null)
    {
      localObject1 = this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label852;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label825;
      }
    }
    label825:
    for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Aypd);
      d();
      return;
      if (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
      break;
    }
    label852:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.jdField_q_of_type_Long;
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    h();
    ((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a((MessageRecord)localObject1, this.jdField_a_of_type_Akat, this);
  }
  
  void v()
  {
    if (this.jdField_a_of_type_Aywc.jdField_b_of_type_Int == 2)
    {
      localObject2 = a();
      if (localObject2 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Aypd);
        d();
      }
      label180:
      label207:
      MessageForPtt localMessageForPtt;
      do
      {
        return;
        if (!e())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_Aypd);
          d();
          return;
        }
        if (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
        {
          localObject1 = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          if ((localObject1 != null) && ((localObject1 instanceof MessageForPtt))) {
            break label207;
          }
          localObject2 = new StringBuilder().append("Mr_");
          if (localObject1 != null) {
            break label180;
          }
        }
        for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
        {
          a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Aypd);
          d();
          return;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
          break;
        }
        localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        a((im_msg_body.RichText)localObject2, localMessageForPtt);
        if (QLog.isColorLevel()) {
          QLog.d("RecordParams", 2, "<---sendDiscussMsg voiceType：" + localMessageForPtt.voiceType + " voiceLengh:" + localMessageForPtt.voiceLength);
        }
        ((MessageForPtt)localObject1).richText = ((im_msg_body.RichText)localObject2);
        if (this.jdField_c_of_type_Boolean)
        {
          if (ahjk.a((MessageRecord)localObject1))
          {
            ahjk.a().a((MessageRecord)localObject1, this.jdField_a_of_type_Akat, this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, null, this);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((MessageRecord)localObject1, this.jdField_a_of_type_Akat);
          return;
        }
      } while (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq == null);
      localMessageForPtt.url = MessageForPtt.getMsgFilePath(localMessageForPtt.voiceType, this.jdField_a_of_type_Aywc.jdField_i_of_type_JavaLangString);
      localMessageForPtt.fileSize = this.jdField_q_of_type_Long;
      localMessageForPtt.urlAtServer = this.jdField_d_of_type_JavaLangString;
      localMessageForPtt.itemType = 2;
      localMessageForPtt.groupFileID = this.jdField_a_of_type_Long;
      localMessageForPtt.groupFileKeyStr = this.jdField_a_of_type_JavaLangString;
      localMessageForPtt.md5 = this.jdField_c_of_type_JavaLangString;
      localMessageForPtt.serial();
      this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq.a((im_msg_body.RichText)localObject2);
      return;
    }
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Aywc.jdField_i_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Aywc.jdField_i_of_type_Boolean) {
        ((MessageForPic)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = this.jdField_s_of_type_Long;
      }
      localObject1 = b();
      if (localObject1 == null)
      {
        a(9368, "constructpberror", null, this.jdField_c_of_type_Aypd);
        d();
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Aywc.jdField_i_of_type_Boolean) && (this.jdField_f_of_type_Boolean)) {
          ((MessageForPic)this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).mPresendTransferedSize = 0L;
        }
        h();
        e();
        return;
        if (!e())
        {
          a(9366, "illegal app", null, this.jdField_c_of_type_Aypd);
          d();
          return;
        }
        if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq != null) {
          this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq.a((im_msg_body.RichText)localObject1);
        }
      }
    }
    Object localObject2 = b();
    if (localObject2 == null)
    {
      a(9368, "constructpberror", null, this.jdField_c_of_type_Aypd);
      d();
      return;
    }
    if (!e())
    {
      a(9366, "illegal app", null, this.jdField_c_of_type_Aypd);
      d();
      return;
    }
    if (this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq != null)
    {
      localObject1 = this.jdField_a_of_type_Aywc.jdField_a_of_type_Auoq.a((im_msg_body.RichText)localObject2);
      if ((localObject1 != null) && (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForStructing)))) {
        break label827;
      }
      localObject2 = new StringBuilder().append("Mr_");
      if (localObject1 != null) {
        break label800;
      }
    }
    label800:
    for (Object localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
    {
      a(9368, "msgtypeError", (String)localObject1, this.jdField_c_of_type_Aypd);
      d();
      return;
      if (this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        localObject1 = this.jdField_a_of_type_Aywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aywc.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Aywc.jdField_a_of_type_Int, this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
      break;
    }
    label827:
    if ((localObject1 instanceof MessageForPic))
    {
      ((MessageForPic)localObject1).richText = ((im_msg_body.RichText)localObject2);
      ((MessageForPic)localObject1).size = this.jdField_q_of_type_Long;
    }
    if ((localObject1 instanceof MessageForStructing)) {
      ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
    }
    h();
    ((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a((MessageRecord)localObject1, this.jdField_a_of_type_Akat, this);
  }
  
  public void w()
  {
    if (this.o) {
      return;
    }
    if ((this.jdField_m_of_type_JavaLangString != null) && (this.jdField_a_of_type_Long != 0L))
    {
      if (this.jdField_s_of_type_Long >= this.jdField_q_of_type_Long)
      {
        t();
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
 * Qualified Name:     ayrf
 * JD-Core Version:    0.7.0.1
 */