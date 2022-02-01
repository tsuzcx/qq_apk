package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoReqBody;
import com.tencent.mobileqq.pb.MessageMicro;
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
  private static int jdField_a_of_type_Int = 0;
  static long jdField_a_of_type_Long = 0L;
  private AudioTrans jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans = AudioTrans.a();
  private AudioTransClientInfoHandlerExtend.InfoInterfaceData jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData = AudioTransClientInfoHandlerExtend.InfoInterfaceData.a();
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private boolean jdField_a_of_type_Boolean = false;
  
  public AudioTransClientInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  abstract int a();
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Long);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  abstract void a(long paramLong1, long paramLong2);
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg(paramString2);
    AudioTransClientTransInfo.InfoHead localInfoHead = new AudioTransClientTransInfo.InfoHead();
    Object localObject2 = localInfoHead.str_session_id;
    if (TextUtils.isEmpty(paramString3)) {}
    for (Object localObject1 = "0";; localObject1 = paramString3)
    {
      ((PBStringField)localObject2).set((String)localObject1);
      localInfoHead.str_uin.set(this.appRuntime.getAccount());
      localInfoHead.uint32_seq.set((int)paramLong);
      localInfoHead.enum_body_type.set(1);
      localObject1 = new AudioTransClientTransInfo.InfoReqBody();
      localObject2 = new AudioTransClientTransInfo.InfoC2SCreateSessionReq();
      String str = b();
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_business_type.set(1);
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).rpt_member_list.set(Arrays.asList(new String[] { localInfoHead.str_uin.get(), str }));
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_business_direction.set(4);
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_term.set(4);
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).uint32_client_ver.set(b());
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).enum_net_type.set(a());
      ((AudioTransClientTransInfo.InfoC2SCreateSessionReq)localObject2).bool_translate.set(c());
      ((AudioTransClientTransInfo.InfoReqBody)localObject1).msg_create_session_req.set((MessageMicro)localObject2);
      localObject2 = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
      localToServiceMsg.putWupBuffer(AudioTrans.a(localInfoHead.toByteArray(), ((AudioTransClientTransInfo.InfoReqBody)localObject1).toByteArray()));
      boolean bool = NetworkUtil.g(this.appRuntime.getApplication().getApplicationContext());
      if (bool) {
        sendPbReq(localToServiceMsg);
      }
      long l1 = System.currentTimeMillis();
      long l2 = jdField_a_of_type_Long;
      jdField_a_of_type_Long = l1;
      QLog.w("AudioTransClientInfoHandler", 1, "sendCmdToService, cmd[" + paramString2 + "], seq[" + paramLong + "], sessionID[" + paramString3 + "], isNetworkAvailable[" + bool + "], from[" + paramString1 + "], sendInterval[" + (l1 - l2) + "]");
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  abstract int b();
  
  abstract String b();
  
  abstract boolean b();
  
  abstract boolean c();
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  /* Error */
  public void onReceive(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 267	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +643 -> 647
    //   7: aload_0
    //   8: getfield 35	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans	Lcom/tencent/av/business/handler/AudioTrans;
    //   11: astore_1
    //   12: aload_2
    //   13: invokevirtual 270	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   16: invokestatic 273	com/tencent/av/business/handler/AudioTrans:a	([B)Lcom/tencent/av/business/handler/AudioTrans$PBBytes;
    //   19: astore_2
    //   20: aload_2
    //   21: getfield 278	com/tencent/av/business/handler/AudioTrans$PBBytes:a	[B
    //   24: astore_1
    //   25: aload_2
    //   26: getfield 280	com/tencent/av/business/handler/AudioTrans$PBBytes:b	[B
    //   29: astore_2
    //   30: new 61	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead
    //   33: dup
    //   34: invokespecial 62	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:<init>	()V
    //   37: astore_3
    //   38: aload_3
    //   39: aload_1
    //   40: invokevirtual 284	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   43: checkcast 61	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead
    //   46: astore_1
    //   47: aload_1
    //   48: getfield 96	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   51: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   54: istore 4
    //   56: aload_1
    //   57: getfield 289	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_error_no	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   60: invokevirtual 292	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   63: ifeq +574 -> 637
    //   66: new 294	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody
    //   69: dup
    //   70: invokespecial 295	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:<init>	()V
    //   73: aload_2
    //   74: invokevirtual 296	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   77: checkcast 294	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody
    //   80: astore_2
    //   81: aload_1
    //   82: getfield 289	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:uint32_error_no	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   85: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   88: ifne +464 -> 552
    //   91: aload_2
    //   92: getfield 300	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:msg_create_session_rsp	Lcom/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp;
    //   95: invokevirtual 305	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 302	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 42	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   106: aload_2
    //   107: getfield 308	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:enum_channel_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   110: invokevirtual 309	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   113: putfield 310	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_Int	I
    //   116: aload_0
    //   117: getfield 42	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   120: aload_2
    //   121: getfield 313	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:enum_translator_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   124: invokevirtual 309	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   127: putfield 315	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:b	I
    //   130: aload_0
    //   131: getfield 42	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   134: aload_1
    //   135: getfield 66	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoHead:str_session_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   138: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   141: invokestatic 320	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   144: invokevirtual 323	java/lang/Long:longValue	()J
    //   147: putfield 47	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_Long	J
    //   150: aload_2
    //   151: getfield 327	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SCreateSessionRsp:rpt_msg_interface_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   154: invokevirtual 332	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   157: astore_1
    //   158: aload_0
    //   159: getfield 42	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   162: new 334	java/util/ArrayList
    //   165: dup
    //   166: invokespecial 335	java/util/ArrayList:<init>	()V
    //   169: putfield 338	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   172: aload_0
    //   173: invokevirtual 340	com/tencent/av/business/handler/AudioTransClientInfoHandler:b	()Z
    //   176: istore 5
    //   178: ldc 216
    //   180: iconst_1
    //   181: new 218	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 342
    //   191: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload 4
    //   196: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: ldc_w 347
    //   202: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_0
    //   206: getfield 42	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   209: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: ldc_w 352
    //   215: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload 5
    //   220: invokevirtual 237	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   223: ldc_w 354
    //   226: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_0
    //   230: getfield 44	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_Boolean	Z
    //   233: invokevirtual 237	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   236: ldc 243
    //   238: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 252	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: aload_1
    //   248: invokeinterface 360 1 0
    //   253: astore_1
    //   254: aload_1
    //   255: invokeinterface 365 1 0
    //   260: ifeq +233 -> 493
    //   263: aload_1
    //   264: invokeinterface 369 1 0
    //   269: checkcast 371	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr
    //   272: astore_2
    //   273: new 373	com/tencent/avcore/jni/data/NetAddr
    //   276: dup
    //   277: invokespecial 374	com/tencent/avcore/jni/data/NetAddr:<init>	()V
    //   280: astore_3
    //   281: aload_3
    //   282: aload_2
    //   283: getfield 378	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   286: invokevirtual 381	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   289: putfield 383	com/tencent/avcore/jni/data/NetAddr:fixed32_IP	I
    //   292: aload_3
    //   293: aload_2
    //   294: getfield 386	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:uint32_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   297: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   300: putfield 388	com/tencent/avcore/jni/data/NetAddr:uint32_port	I
    //   303: aload_3
    //   304: aload_2
    //   305: getfield 391	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:enum_proto_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   308: invokevirtual 309	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   311: putfield 393	com/tencent/avcore/jni/data/NetAddr:enum_proto_type	I
    //   314: aload_3
    //   315: aload_2
    //   316: getfield 396	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_inner_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   319: invokevirtual 381	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   322: putfield 398	com/tencent/avcore/jni/data/NetAddr:fixed32_inner_IP	I
    //   325: aload_0
    //   326: getfield 42	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   329: getfield 338	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   332: aload_3
    //   333: invokeinterface 402 2 0
    //   338: pop
    //   339: new 218	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   346: ldc_w 404
    //   349: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: astore_3
    //   353: aload_0
    //   354: getfield 35	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans	Lcom/tencent/av/business/handler/AudioTrans;
    //   357: astore 6
    //   359: aload_3
    //   360: aload_2
    //   361: getfield 378	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   364: invokevirtual 381	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   367: invokestatic 407	com/tencent/av/business/handler/AudioTrans:a	(I)Ljava/lang/String;
    //   370: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc_w 409
    //   376: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_2
    //   380: getfield 386	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:uint32_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   383: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   386: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: ldc_w 409
    //   392: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_2
    //   396: getfield 391	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:enum_proto_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   399: invokevirtual 309	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   402: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: ldc_w 409
    //   408: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: astore_3
    //   412: aload_0
    //   413: getfield 35	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans	Lcom/tencent/av/business/handler/AudioTrans;
    //   416: astore 6
    //   418: ldc 216
    //   420: iconst_2
    //   421: aload_3
    //   422: aload_2
    //   423: getfield 396	com/tencent/mobileqq/audiotrans/AudioTransCommon$NetAddr:fixed32_inner_IP	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   426: invokevirtual 381	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   429: invokestatic 407	com/tencent/av/business/handler/AudioTrans:a	(I)Ljava/lang/String;
    //   432: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 412	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: goto -187 -> 254
    //   444: astore_1
    //   445: aload_1
    //   446: invokevirtual 415	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   449: ldc 216
    //   451: iconst_2
    //   452: new 218	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   459: ldc_w 417
    //   462: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_1
    //   466: invokevirtual 420	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   469: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 423	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: return
    //   479: astore_1
    //   480: ldc 216
    //   482: iconst_1
    //   483: ldc_w 425
    //   486: aload_1
    //   487: invokestatic 428	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   490: goto -340 -> 150
    //   493: aload_0
    //   494: getfield 87	com/tencent/av/business/handler/AudioTransClientInfoHandler:appRuntime	Lcom/tencent/common/app/AppInterface;
    //   497: getstatic 433	com/tencent/av/business/handler/BusinessHandlerFactory:a	Ljava/lang/String;
    //   500: invokevirtual 437	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   503: checkcast 439	com/tencent/av/business/handler/AudioTransClientInterfaceHandler
    //   506: iload 4
    //   508: i2l
    //   509: iconst_1
    //   510: aload_0
    //   511: getfield 42	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   514: getfield 338	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   517: aload_0
    //   518: getfield 42	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   521: getfield 47	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_Long	J
    //   524: invokevirtual 442	com/tencent/av/business/handler/AudioTransClientInterfaceHandler:a	(JZLjava/util/List;J)V
    //   527: aload_0
    //   528: iconst_1
    //   529: putfield 44	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_Boolean	Z
    //   532: iload 5
    //   534: ifeq -56 -> 478
    //   537: aload_0
    //   538: iload 4
    //   540: i2l
    //   541: aload_0
    //   542: getfield 42	com/tencent/av/business/handler/AudioTransClientInfoHandler:jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData	Lcom/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData;
    //   545: getfield 47	com/tencent/av/business/handler/AudioTransClientInfoHandlerExtend$InfoInterfaceData:jdField_a_of_type_Long	J
    //   548: invokevirtual 444	com/tencent/av/business/handler/AudioTransClientInfoHandler:a	(JJ)V
    //   551: return
    //   552: aload_2
    //   553: getfield 448	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoRspBody:msg_failed_rsp	Lcom/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp;
    //   556: invokevirtual 451	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   559: checkcast 450	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp
    //   562: astore_1
    //   563: ldc 216
    //   565: iconst_2
    //   566: ldc_w 453
    //   569: invokestatic 412	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   572: ldc 216
    //   574: iconst_2
    //   575: new 218	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 455
    //   585: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_1
    //   589: getfield 458	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:uint32_errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   592: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   595: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   598: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 412	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: ldc 216
    //   606: iconst_2
    //   607: new 218	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   614: ldc_w 460
    //   617: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload_1
    //   621: getfield 463	com/tencent/mobileqq/audiotrans/AudioTransClientTransInfo$InfoC2SFailedRsp:str_errmsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   624: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   627: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 412	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: return
    //   637: ldc 216
    //   639: iconst_2
    //   640: ldc_w 465
    //   643: invokestatic 423	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: return
    //   647: ldc 216
    //   649: iconst_2
    //   650: new 218	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   657: ldc_w 467
    //   660: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: aload_2
    //   664: invokevirtual 470	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   667: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 246	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 423	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   676: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	677	0	this	AudioTransClientInfoHandler
    //   0	677	1	paramToServiceMsg	ToServiceMsg
    //   0	677	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	677	3	paramObject	Object
    //   54	485	4	i	int
    //   176	357	5	bool	boolean
    //   357	60	6	localAudioTrans	AudioTrans
    // Exception table:
    //   from	to	target	type
    //   38	130	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	150	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   150	254	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   254	441	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   480	490	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   493	532	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   537	551	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   552	636	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   637	646	444	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	150	479	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInfoHandler
 * JD-Core Version:    0.7.0.1
 */