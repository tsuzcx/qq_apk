import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x5e3.oidb_0x5e3.GetQCallUinReq;
import tencent.im.oidb.cmd0x5e3.oidb_0x5e3.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class avee
  extends ajtd
{
  private avef jdField_a_of_type_Avef;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected Set<String> a;
  
  public avee(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 27	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifne +25 -> 29
    //   7: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 34
    //   15: iconst_2
    //   16: ldc 36
    //   18: invokestatic 40	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: iconst_1
    //   23: iconst_0
    //   24: aconst_null
    //   25: invokevirtual 44	avee:notifyUI	(IZLjava/lang/Object;)V
    //   28: return
    //   29: new 46	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   32: dup
    //   33: invokespecial 49	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   36: astore_1
    //   37: aload_1
    //   38: aload_3
    //   39: checkcast 51	[B
    //   42: checkcast 51	[B
    //   45: invokevirtual 55	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   48: checkcast 46	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: iconst_m1
    //   55: istore 5
    //   57: iload 5
    //   59: istore 4
    //   61: aload_1
    //   62: ifnull +66 -> 128
    //   65: iload 5
    //   67: istore 4
    //   69: aload_1
    //   70: getfield 59	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   73: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   76: ifeq +52 -> 128
    //   79: aload_1
    //   80: getfield 59	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: istore 5
    //   88: iload 5
    //   90: istore 4
    //   92: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   95: ifeq +33 -> 128
    //   98: ldc 34
    //   100: iconst_2
    //   101: new 70	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   108: ldc 73
    //   110: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload 5
    //   115: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 40	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: iload 5
    //   126: istore 4
    //   128: iload 4
    //   130: ifne +817 -> 947
    //   133: aload_1
    //   134: getfield 88	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   137: invokevirtual 91	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   140: ifeq +807 -> 947
    //   143: aload_1
    //   144: getfield 88	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   147: invokevirtual 94	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   150: ifnull +797 -> 947
    //   153: aload_1
    //   154: getfield 88	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   157: invokevirtual 94	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   160: invokevirtual 100	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   163: astore_2
    //   164: new 102	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$RspBody
    //   167: dup
    //   168: invokespecial 103	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$RspBody:<init>	()V
    //   171: astore_1
    //   172: aload_1
    //   173: aload_2
    //   174: invokevirtual 104	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   177: pop
    //   178: aload_1
    //   179: getfield 108	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$RspBody:rpt_uint64_not_exist_qcall_uins	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   182: invokevirtual 113	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   185: astore_2
    //   186: aload_2
    //   187: ifnull +118 -> 305
    //   190: aload_2
    //   191: invokeinterface 118 1 0
    //   196: ifle +109 -> 305
    //   199: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +43 -> 245
    //   205: ldc 34
    //   207: iconst_2
    //   208: new 70	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   215: ldc 120
    //   217: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_2
    //   221: iconst_0
    //   222: invokeinterface 123 2 0
    //   227: checkcast 125	java/lang/Long
    //   230: invokevirtual 129	java/lang/Long:longValue	()J
    //   233: invokestatic 134	avez:a	(J)Ljava/lang/String;
    //   236: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 40	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload_0
    //   246: getfield 15	avee:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   249: sipush 140
    //   252: invokevirtual 140	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   255: checkcast 142	aveh
    //   258: astore_3
    //   259: aload_3
    //   260: aload_2
    //   261: iconst_0
    //   262: invokeinterface 123 2 0
    //   267: checkcast 125	java/lang/Long
    //   270: invokevirtual 129	java/lang/Long:longValue	()J
    //   273: invokestatic 134	avez:a	(J)Ljava/lang/String;
    //   276: invokevirtual 145	aveh:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/qcall/QCallCardInfo;
    //   279: astore 6
    //   281: aload 6
    //   283: ifnull +504 -> 787
    //   286: aload 6
    //   288: iconst_1
    //   289: putfield 151	com/tencent/mobileqq/qcall/QCallCardInfo:in_use_flag	I
    //   292: aload_3
    //   293: aload 6
    //   295: invokevirtual 154	aveh:a	(Lcom/tencent/mobileqq/qcall/QCallCardInfo;)V
    //   298: aload_0
    //   299: iconst_1
    //   300: iconst_1
    //   301: aconst_null
    //   302: invokevirtual 44	avee:notifyUI	(IZLjava/lang/Object;)V
    //   305: aload_1
    //   306: getfield 158	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$RspBody:rpt_msg_get_qcall_uin_rsps	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   309: invokevirtual 161	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   312: astore_2
    //   313: new 163	java/util/ArrayList
    //   316: dup
    //   317: invokespecial 164	java/util/ArrayList:<init>	()V
    //   320: astore_1
    //   321: aload_2
    //   322: invokeinterface 168 1 0
    //   327: astore_2
    //   328: aload_2
    //   329: invokeinterface 173 1 0
    //   334: ifeq +505 -> 839
    //   337: aload_2
    //   338: invokeinterface 177 1 0
    //   343: checkcast 179	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp
    //   346: astore_3
    //   347: new 147	com/tencent/mobileqq/qcall/QCallCardInfo
    //   350: dup
    //   351: invokespecial 180	com/tencent/mobileqq/qcall/QCallCardInfo:<init>	()V
    //   354: astore 6
    //   356: aload 6
    //   358: aload_3
    //   359: getfield 184	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   362: invokevirtual 188	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   365: invokestatic 134	avez:a	(J)Ljava/lang/String;
    //   368: putfield 192	com/tencent/mobileqq/qcall/QCallCardInfo:uin	Ljava/lang/String;
    //   371: aload 6
    //   373: aload_3
    //   374: getfield 195	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:bytes_nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   377: invokevirtual 94	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   380: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   383: putfield 201	com/tencent/mobileqq/qcall/QCallCardInfo:nickname	Ljava/lang/String;
    //   386: aload 6
    //   388: aload_3
    //   389: getfield 204	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   392: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   395: putfield 207	com/tencent/mobileqq/qcall/QCallCardInfo:gender	I
    //   398: aload 6
    //   400: aload_3
    //   401: getfield 210	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_birthday	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   404: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   407: putfield 213	com/tencent/mobileqq/qcall/QCallCardInfo:birthday	I
    //   410: aload 6
    //   412: aload_3
    //   413: getfield 216	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:bytes_remark	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   416: invokevirtual 94	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   419: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   422: putfield 219	com/tencent/mobileqq/qcall/QCallCardInfo:remark	Ljava/lang/String;
    //   425: aload 6
    //   427: aload_3
    //   428: getfield 222	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_netstatus	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   431: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   434: putfield 225	com/tencent/mobileqq/qcall/QCallCardInfo:netstatus	I
    //   437: aload 6
    //   439: aload_3
    //   440: getfield 228	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_qq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   443: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   446: invokestatic 231	avez:a	(I)Ljava/lang/String;
    //   449: putfield 234	com/tencent/mobileqq/qcall/QCallCardInfo:qq	Ljava/lang/String;
    //   452: aload 6
    //   454: aload_3
    //   455: getfield 237	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:bytes_new_gsm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   458: invokevirtual 94	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   461: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   464: putfield 240	com/tencent/mobileqq/qcall/QCallCardInfo:phonenum	Ljava/lang/String;
    //   467: aload 6
    //   469: aload_3
    //   470: getfield 243	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_mask_gsm	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   473: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   476: putfield 246	com/tencent/mobileqq/qcall/QCallCardInfo:phone_mask	I
    //   479: aload 6
    //   481: aload_3
    //   482: getfield 249	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_is_call_free	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   485: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   488: putfield 252	com/tencent/mobileqq/qcall/QCallCardInfo:freeStatus	I
    //   491: aload 6
    //   493: aload_3
    //   494: getfield 255	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_pstn	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   497: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   500: putfield 258	com/tencent/mobileqq/qcall/QCallCardInfo:pstn_freeStatus	I
    //   503: aload 6
    //   505: aload_3
    //   506: getfield 261	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:bytes_qq_auto_remark	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   509: invokevirtual 94	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   512: invokevirtual 198	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   515: putfield 264	com/tencent/mobileqq/qcall/QCallCardInfo:autoRemark	Ljava/lang/String;
    //   518: aload 6
    //   520: aload_3
    //   521: getfield 267	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint64_contact_qq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   524: invokevirtual 188	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   527: invokestatic 134	avez:a	(J)Ljava/lang/String;
    //   530: putfield 270	com/tencent/mobileqq/qcall/QCallCardInfo:qqUin2	Ljava/lang/String;
    //   533: aload_3
    //   534: getfield 273	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_is_ever_pstn	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   537: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   540: ifeq +15 -> 555
    //   543: aload 6
    //   545: aload_3
    //   546: getfield 273	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_is_ever_pstn	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   549: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   552: putfield 276	com/tencent/mobileqq/qcall/QCallCardInfo:is_ever_pstn	I
    //   555: aload_3
    //   556: getfield 279	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_vip_all_free_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   559: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   562: ifeq +15 -> 577
    //   565: aload 6
    //   567: aload_3
    //   568: getfield 279	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_vip_all_free_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   571: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   574: putfield 282	com/tencent/mobileqq/qcall/QCallCardInfo:vip_all_free_time	I
    //   577: aload_3
    //   578: getfield 285	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_profile_card_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   581: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   584: ifeq +15 -> 599
    //   587: aload 6
    //   589: aload_3
    //   590: getfield 285	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_profile_card_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   593: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   596: putfield 288	com/tencent/mobileqq/qcall/QCallCardInfo:card_type	I
    //   599: aload_3
    //   600: getfield 291	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_bind_qq_netstatus	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   603: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   606: ifeq +15 -> 621
    //   609: aload 6
    //   611: aload_3
    //   612: getfield 291	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_bind_qq_netstatus	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   615: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   618: putfield 294	com/tencent/mobileqq/qcall/QCallCardInfo:qid_qq_status	I
    //   621: aload_3
    //   622: getfield 297	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_contact_qq_netstatus	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   625: invokevirtual 64	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   628: ifeq +15 -> 643
    //   631: aload 6
    //   633: aload_3
    //   634: getfield 297	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_contact_qq_netstatus	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   637: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   640: putfield 300	com/tencent/mobileqq/qcall/QCallCardInfo:contact_qq_status	I
    //   643: aload 6
    //   645: aload_3
    //   646: getfield 303	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_vip_left_free_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   649: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   652: putfield 306	com/tencent/mobileqq/qcall/QCallCardInfo:vip_left_free_time	I
    //   655: aload 6
    //   657: aload_3
    //   658: getfield 309	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_normal_all_free_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   661: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   664: putfield 312	com/tencent/mobileqq/qcall/QCallCardInfo:normal_all_free_time	I
    //   667: aload 6
    //   669: aload_3
    //   670: getfield 315	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_normal_left_free_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   673: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   676: putfield 318	com/tencent/mobileqq/qcall/QCallCardInfo:normal_left_free_time	I
    //   679: aload 6
    //   681: aload_3
    //   682: getfield 321	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_used_free_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   685: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   688: putfield 324	com/tencent/mobileqq/qcall/QCallCardInfo:used_free_time	I
    //   691: aload 6
    //   693: aload_3
    //   694: getfield 327	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_identity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   697: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   700: putfield 330	com/tencent/mobileqq/qcall/QCallCardInfo:identity	I
    //   703: aload 6
    //   705: aload_3
    //   706: getfield 333	tencent/im/oidb/cmd0x5e3/oidb_0x5e3$GetQCallUinRsp:uint32_if_pop_up	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   709: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   712: putfield 336	com/tencent/mobileqq/qcall/QCallCardInfo:isPopup	I
    //   715: aload_1
    //   716: aload 6
    //   718: invokeinterface 340 2 0
    //   723: pop
    //   724: goto -396 -> 328
    //   727: astore_2
    //   728: ldc 34
    //   730: iconst_4
    //   731: aload_2
    //   732: invokevirtual 343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   735: aload_2
    //   736: invokestatic 347	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   739: goto -685 -> 54
    //   742: astore_2
    //   743: ldc 34
    //   745: iconst_4
    //   746: aload_2
    //   747: invokevirtual 348	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   750: aload_2
    //   751: invokestatic 347	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   754: goto -700 -> 54
    //   757: astore_2
    //   758: ldc 34
    //   760: iconst_4
    //   761: aload_2
    //   762: invokevirtual 343	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   765: aload_2
    //   766: invokestatic 347	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   769: goto -591 -> 178
    //   772: astore_2
    //   773: ldc 34
    //   775: iconst_4
    //   776: aload_2
    //   777: invokevirtual 348	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   780: aload_2
    //   781: invokestatic 347	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   784: goto -606 -> 178
    //   787: new 147	com/tencent/mobileqq/qcall/QCallCardInfo
    //   790: dup
    //   791: invokespecial 180	com/tencent/mobileqq/qcall/QCallCardInfo:<init>	()V
    //   794: astore 6
    //   796: aload 6
    //   798: aload_2
    //   799: iconst_0
    //   800: invokeinterface 123 2 0
    //   805: checkcast 125	java/lang/Long
    //   808: invokevirtual 129	java/lang/Long:longValue	()J
    //   811: invokestatic 134	avez:a	(J)Ljava/lang/String;
    //   814: putfield 192	com/tencent/mobileqq/qcall/QCallCardInfo:uin	Ljava/lang/String;
    //   817: aload 6
    //   819: iconst_1
    //   820: putfield 151	com/tencent/mobileqq/qcall/QCallCardInfo:in_use_flag	I
    //   823: aload_3
    //   824: aload 6
    //   826: invokevirtual 154	aveh:a	(Lcom/tencent/mobileqq/qcall/QCallCardInfo;)V
    //   829: aload_0
    //   830: iconst_1
    //   831: iconst_1
    //   832: aconst_null
    //   833: invokevirtual 44	avee:notifyUI	(IZLjava/lang/Object;)V
    //   836: goto -531 -> 305
    //   839: aload_1
    //   840: invokeinterface 118 1 0
    //   845: ifne +20 -> 865
    //   848: ldc 34
    //   850: iconst_1
    //   851: ldc_w 350
    //   854: invokestatic 40	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   857: aload_0
    //   858: iconst_1
    //   859: iconst_0
    //   860: aconst_null
    //   861: invokevirtual 44	avee:notifyUI	(IZLjava/lang/Object;)V
    //   864: return
    //   865: invokestatic 32	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   868: ifeq +12 -> 880
    //   871: ldc 34
    //   873: iconst_2
    //   874: ldc_w 352
    //   877: invokestatic 40	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   880: aload_0
    //   881: getfield 15	avee:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   884: sipush 140
    //   887: invokevirtual 140	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   890: checkcast 142	aveh
    //   893: aload_1
    //   894: iconst_0
    //   895: invokeinterface 123 2 0
    //   900: checkcast 147	com/tencent/mobileqq/qcall/QCallCardInfo
    //   903: invokevirtual 154	aveh:a	(Lcom/tencent/mobileqq/qcall/QCallCardInfo;)V
    //   906: aload_0
    //   907: iconst_1
    //   908: iconst_1
    //   909: iload 4
    //   911: invokestatic 358	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   914: invokevirtual 44	avee:notifyUI	(IZLjava/lang/Object;)V
    //   917: aload_0
    //   918: getfield 360	avee:jdField_a_of_type_Avef	Lavef;
    //   921: ifnull -893 -> 28
    //   924: aload_0
    //   925: getfield 360	avee:jdField_a_of_type_Avef	Lavef;
    //   928: aload_1
    //   929: iconst_0
    //   930: invokeinterface 123 2 0
    //   935: checkcast 147	com/tencent/mobileqq/qcall/QCallCardInfo
    //   938: getfield 201	com/tencent/mobileqq/qcall/QCallCardInfo:nickname	Ljava/lang/String;
    //   941: invokeinterface 365 2 0
    //   946: return
    //   947: ldc 34
    //   949: iconst_1
    //   950: new 70	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   957: ldc_w 367
    //   960: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: iload 4
    //   965: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   968: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   971: invokestatic 40	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   974: aload_0
    //   975: iconst_1
    //   976: iconst_0
    //   977: iload 4
    //   979: invokestatic 358	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   982: invokevirtual 44	avee:notifyUI	(IZLjava/lang/Object;)V
    //   985: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	986	0	this	avee
    //   0	986	1	paramToServiceMsg	ToServiceMsg
    //   0	986	2	paramFromServiceMsg	FromServiceMsg
    //   0	986	3	paramObject	Object
    //   59	919	4	i	int
    //   55	70	5	j	int
    //   279	546	6	localQCallCardInfo	com.tencent.mobileqq.qcall.QCallCardInfo
    // Exception table:
    //   from	to	target	type
    //   37	52	727	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   37	52	742	java/lang/Exception
    //   172	178	757	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   172	178	772	java/lang/Exception
  }
  
  public void a(avef paramavef)
  {
    this.jdField_a_of_type_Avef = paramavef;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCallCardHandler", 2, "getQcallCardSimpleInfo uin: " + paramString);
    }
    if (!bbjw.c(paramString))
    {
      QLog.d("QCallCardHandler", 2, "Uin getQcallCardSimpleInfo uin is unValid!!!");
      return;
    }
    try
    {
      long l = avez.a(paramString);
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(Long.valueOf(l));
      paramString = new oidb_0x5e3.GetQCallUinReq();
      paramString.rpt_uint64_uins.set((List)localObject);
      paramString.uint32_req_nick.set(1);
      paramString.uint32_req_gender.set(1);
      paramString.uint32_req_birthday.set(1);
      localObject = new oidb_0x5e3.ReqBody();
      ((oidb_0x5e3.ReqBody)localObject).rpt_msg_get_qcall_uin_req.set(paramString);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1507);
      paramString.uint32_service_type.set(1);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5e3.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg("QcallOidbSvc.0x5e3_1");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.d("QCallCardHandler", 2, "Uin getQcallCardSimpleInfo uin String to long NumberFormatException!!!");
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("QcallOidbSvc.0x5e3_1");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return avei.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("QCallCardHandler", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      return;
      int i = paramFromServiceMsg.getResultCode();
      if (QLog.isColorLevel()) {
        QLog.i("QCallCardHandler", 2, String.format("onReceive FromServiceMsg(cmd=%s,resultCode=%d)", new Object[] { str, Integer.valueOf(i) }));
      }
    } while (!str.equals("QcallOidbSvc.0x5e3_1"));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avee
 * JD-Core Version:    0.7.0.1
 */