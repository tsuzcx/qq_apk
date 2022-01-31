package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoReqBody;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Random;
import mqq.app.MobileQQ;

public abstract class AudioTransClientInfoHandler
  extends BusinessHandler
{
  private AudioTrans jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans = AudioTrans.a();
  private AudioTransClientInfoHandlerExtend.InfoInterfaceData jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData = AudioTransClientInfoHandlerExtend.InfoInterfaceData.a();
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private boolean jdField_a_of_type_Boolean;
  
  public AudioTransClientInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  abstract int a();
  
  protected Class a()
  {
    return null;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Long);
  }
  
  abstract void a(long paramLong);
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: ldc 55
    //   2: iconst_2
    //   3: ldc 57
    //   5: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aload_2
    //   9: invokevirtual 69	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   12: ifeq +596 -> 608
    //   15: aload_0
    //   16: getfield 27	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans	Lcom/tencent/av/business/handler/AudioTrans;
    //   19: astore_1
    //   20: aload_2
    //   21: invokevirtual 73	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   24: invokestatic 76	com/tencent/av/business/handler/AudioTrans:a	([B)Lcom/tencent/av/business/handler/AudioTrans$PBBytes;
    //   27: astore_2
    //   28: aload_2
    //   29: getfield 81	com/tencent/av/business/handler/AudioTrans$PBBytes:a	[B
    //   32: astore_1
    //   33: aload_2
    //   34: getfield 84	com/tencent/av/business/handler/AudioTrans$PBBytes:b	[B
    //   37: astore_2
    //   38: new 86	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead
    //   41: dup
    //   42: invokespecial 87	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:<init>	()V
    //   45: astore_3
    //   46: aload_3
    //   47: aload_1
    //   48: invokevirtual 91	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   51: checkcast 86	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead
    //   54: astore_1
    //   55: aload_1
    //   56: getfield 95	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_error_no	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   59: invokevirtual 100	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   62: ifeq +536 -> 598
    //   65: new 102	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody
    //   68: dup
    //   69: invokespecial 103	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:<init>	()V
    //   72: aload_2
    //   73: invokevirtual 104	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   76: checkcast 102	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody
    //   79: astore_2
    //   80: aload_1
    //   81: getfield 95	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_error_no	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   84: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   87: ifne +426 -> 513
    //   90: aload_2
    //   91: getfield 111	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:msg_create_session_rsp	Lcom/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp;
    //   94: invokevirtual 116	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   97: checkcast 113	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp
    //   100: astore_2
    //   101: ldc 55
    //   103: iconst_2
    //   104: ldc 118
    //   106: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: getfield 34	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   113: aload_2
    //   114: getfield 122	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:enum_channel_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   117: invokevirtual 125	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   120: putfield 128	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_Int	I
    //   123: aload_0
    //   124: getfield 34	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   127: aload_2
    //   128: getfield 131	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:enum_translator_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   131: invokevirtual 125	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   134: putfield 133	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:b	I
    //   137: aload_0
    //   138: getfield 34	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   141: aload_1
    //   142: getfield 137	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:str_session_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   145: invokevirtual 141	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   148: invokestatic 146	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   151: invokevirtual 150	java/lang/Long:longValue	()J
    //   154: putfield 41	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_Long	J
    //   157: aload_2
    //   158: getfield 154	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:rpt_msg_interface_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   161: invokevirtual 159	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   164: astore_1
    //   165: aload_0
    //   166: getfield 34	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   169: new 161	java/util/ArrayList
    //   172: dup
    //   173: invokespecial 162	java/util/ArrayList:<init>	()V
    //   176: putfield 165	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   179: ldc 55
    //   181: iconst_2
    //   182: new 167	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   189: ldc 170
    //   191: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_0
    //   195: getfield 34	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   198: getfield 41	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_Long	J
    //   201: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: ldc 179
    //   206: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_0
    //   210: getfield 34	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   213: getfield 128	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_Int	I
    //   216: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_1
    //   226: invokeinterface 191 1 0
    //   231: astore_1
    //   232: aload_1
    //   233: invokeinterface 196 1 0
    //   238: ifeq +222 -> 460
    //   241: aload_1
    //   242: invokeinterface 200 1 0
    //   247: checkcast 202	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr
    //   250: astore_2
    //   251: new 204	com/tencent/av/business/handler/NetAddr
    //   254: dup
    //   255: invokespecial 205	com/tencent/av/business/handler/NetAddr:<init>	()V
    //   258: astore_3
    //   259: aload_3
    //   260: aload_2
    //   261: getfield 209	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   264: invokevirtual 212	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   267: putfield 214	com/tencent/av/business/handler/NetAddr:fixed32_IP	I
    //   270: aload_3
    //   271: aload_2
    //   272: getfield 217	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:uint32_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   275: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   278: putfield 219	com/tencent/av/business/handler/NetAddr:uint32_port	I
    //   281: aload_3
    //   282: aload_2
    //   283: getfield 222	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:enum_proto_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   286: invokevirtual 125	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   289: putfield 224	com/tencent/av/business/handler/NetAddr:enum_proto_type	I
    //   292: aload_3
    //   293: aload_2
    //   294: getfield 227	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_inner_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   297: invokevirtual 212	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   300: putfield 229	com/tencent/av/business/handler/NetAddr:fixed32_inner_IP	I
    //   303: aload_0
    //   304: getfield 34	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   307: getfield 165	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   310: aload_3
    //   311: invokeinterface 233 2 0
    //   316: pop
    //   317: new 167	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   324: ldc 235
    //   326: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: astore_3
    //   330: aload_0
    //   331: getfield 27	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans	Lcom/tencent/av/business/handler/AudioTrans;
    //   334: astore 4
    //   336: aload_3
    //   337: aload_2
    //   338: getfield 209	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   341: invokevirtual 212	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   344: invokestatic 238	com/tencent/av/business/handler/AudioTrans:a	(I)Ljava/lang/String;
    //   347: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 240
    //   352: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_2
    //   356: getfield 217	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:uint32_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   359: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   362: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   365: ldc 240
    //   367: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_2
    //   371: getfield 222	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:enum_proto_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   374: invokevirtual 125	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   377: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: ldc 240
    //   382: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: astore_3
    //   386: aload_0
    //   387: getfield 27	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans	Lcom/tencent/av/business/handler/AudioTrans;
    //   390: astore 4
    //   392: ldc 55
    //   394: iconst_2
    //   395: aload_3
    //   396: aload_2
    //   397: getfield 227	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_inner_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   400: invokevirtual 212	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   403: invokestatic 238	com/tencent/av/business/handler/AudioTrans:a	(I)Ljava/lang/String;
    //   406: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: goto -183 -> 232
    //   418: astore_1
    //   419: aload_1
    //   420: invokevirtual 243	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   423: ldc 55
    //   425: iconst_2
    //   426: new 167	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   433: ldc 245
    //   435: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_1
    //   439: invokevirtual 248	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   442: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: return
    //   452: astore_1
    //   453: aload_1
    //   454: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   457: goto -300 -> 157
    //   460: aload_0
    //   461: getfield 255	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   464: iconst_0
    //   465: invokevirtual 261	com/tencent/common/app/AppInterface:getBusinessHandler	(I)Ljava/lang/Object;
    //   468: checkcast 263	com/tencent/av/business/handler/AudioTransClientInterfaceHandler
    //   471: iconst_1
    //   472: aload_0
    //   473: getfield 34	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   476: getfield 165	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   479: aload_0
    //   480: getfield 34	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   483: getfield 41	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_Long	J
    //   486: invokevirtual 266	com/tencent/av/business/handler/AudioTransClientInterfaceHandler:a	(ZLjava/util/List;J)V
    //   489: aload_0
    //   490: iconst_1
    //   491: putfield 268	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_Boolean	Z
    //   494: aload_0
    //   495: invokevirtual 270	com/tencent/av/business/handler/AudioTransClientInfoHandler:b	()Z
    //   498: ifeq -47 -> 451
    //   501: aload_0
    //   502: aload_0
    //   503: getfield 34	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   506: getfield 41	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_Long	J
    //   509: invokevirtual 272	com/tencent/av/business/handler/AudioTransClientInfoHandler:a	(J)V
    //   512: return
    //   513: aload_2
    //   514: getfield 276	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:msg_failed_rsp	Lcom/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp;
    //   517: invokevirtual 279	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   520: checkcast 278	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp
    //   523: astore_1
    //   524: ldc 55
    //   526: iconst_2
    //   527: ldc_w 281
    //   530: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   533: ldc 55
    //   535: iconst_2
    //   536: new 167	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   543: ldc_w 283
    //   546: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_1
    //   550: getfield 286	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:uint32_errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   553: invokevirtual 107	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   556: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: ldc 55
    //   567: iconst_2
    //   568: new 167	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 288
    //   578: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload_1
    //   582: getfield 291	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:str_errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   585: invokevirtual 141	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   588: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: return
    //   598: ldc 55
    //   600: iconst_2
    //   601: ldc_w 293
    //   604: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: return
    //   608: ldc 55
    //   610: iconst_2
    //   611: new 167	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 295
    //   621: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_2
    //   625: invokevirtual 298	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   628: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	this	AudioTransClientInfoHandler
    //   0	638	1	paramToServiceMsg	ToServiceMsg
    //   0	638	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	638	3	paramObject	Object
    //   334	57	4	localAudioTrans	AudioTrans
    // Exception table:
    //   from	to	target	type
    //   46	137	418	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   137	157	418	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   157	232	418	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   232	415	418	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   453	457	418	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   460	512	418	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   513	597	418	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   598	607	418	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   137	157	452	java/lang/Exception
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransClientInfoHandler runhw", 2, "sendCmdToService cmd = " + paramString1 + "|" + paramString2);
    }
    ToServiceMsg localToServiceMsg = a(paramString1);
    AudioTransClientTransInfo.InfoHead localInfoHead = new AudioTransClientTransInfo.InfoHead();
    Object localObject = localInfoHead.str_session_id;
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "0";
    }
    ((PBStringField)localObject).set(paramString1);
    localInfoHead.str_uin.set(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localInfoHead.uint32_seq.set(this.jdField_a_of_type_JavaUtilRandom.nextInt());
    localInfoHead.enum_body_type.set(1);
    paramString1 = new AudioTransClientTransInfo.InfoReqBody();
    paramString2 = new AudioTransClientTransInfo.InfoC2SCreateSessionReq();
    localObject = b();
    paramString2.enum_business_type.set(1);
    paramString2.rpt_member_list.set(Arrays.asList(new String[] { localInfoHead.str_uin.get(), localObject }));
    paramString2.enum_business_direction.set(4);
    paramString2.enum_term.set(4);
    paramString2.uint32_client_ver.set(b());
    paramString2.enum_net_type.set(a());
    paramString2.bool_translate.set(c());
    paramString1.msg_create_session_req.set(paramString2);
    paramString2 = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
    localToServiceMsg.putWupBuffer(AudioTrans.a(localInfoHead.toByteArray(), paramString1.toByteArray()));
    if (NetworkUtil.g(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext()))
    {
      b(localToServiceMsg);
      QLog.d("AudioTransClientInfoHandler runhw", 2, "sendPbReq");
      return;
    }
    QLog.e("AudioTransClientInfoHandler runhw", 2, "network is not available");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  abstract int b();
  
  abstract String b();
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  abstract boolean b();
  
  abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInfoHandler
 * JD-Core Version:    0.7.0.1
 */