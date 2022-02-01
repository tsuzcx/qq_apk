package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.avcore.jni.data.NetAddr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoReqBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoRspBody;
import com.tencent.mobileqq.audiotrans.AudioTransCommon.NetAddr;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.MobileQQ;

public abstract class AudioTransClientInfoHandler
  extends BusinessHandler
{
  private static int jdField_a_of_type_Int;
  static long jdField_a_of_type_Long;
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
    if (TextUtils.isEmpty(paramString3)) {
      localObject1 = "0";
    } else {
      localObject1 = paramString3;
    }
    ((PBStringField)localObject2).set((String)localObject1);
    localInfoHead.str_uin.set(this.appRuntime.getAccount());
    localInfoHead.uint32_seq.set((int)paramLong);
    localInfoHead.enum_body_type.set(1);
    Object localObject1 = new AudioTransClientTransInfo.InfoReqBody();
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
    boolean bool = NetworkUtil.isNetworkAvailable(this.appRuntime.getApplication().getApplicationContext());
    if (bool) {
      sendPbReq(localToServiceMsg);
    }
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    jdField_a_of_type_Long = l1;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("sendCmdToService, cmd[");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("], seq[");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("], sessionID[");
    ((StringBuilder)localObject1).append(paramString3);
    ((StringBuilder)localObject1).append("], isNetworkAvailable[");
    ((StringBuilder)localObject1).append(bool);
    ((StringBuilder)localObject1).append("], from[");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("], sendInterval[");
    ((StringBuilder)localObject1).append(l1 - l2);
    ((StringBuilder)localObject1).append("]");
    QLog.w("AudioTransClientInfoHandler", 1, ((StringBuilder)localObject1).toString());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  abstract int b();
  
  abstract String b();
  
  abstract boolean b();
  
  abstract boolean c();
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
      paramFromServiceMsg = AudioTrans.a(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramFromServiceMsg.a;
      paramFromServiceMsg = paramFromServiceMsg.b;
      paramObject = new AudioTransClientTransInfo.InfoHead();
      try
      {
        paramToServiceMsg = (AudioTransClientTransInfo.InfoHead)paramObject.mergeFrom(paramToServiceMsg);
        int i = paramToServiceMsg.uint32_seq.get();
        if (paramToServiceMsg.uint32_error_no.has())
        {
          paramFromServiceMsg = (AudioTransClientTransInfo.InfoRspBody)new AudioTransClientTransInfo.InfoRspBody().mergeFrom(paramFromServiceMsg);
          if (paramToServiceMsg.uint32_error_no.get() == 0)
          {
            paramFromServiceMsg = (AudioTransClientTransInfo.InfoC2SCreateSessionRsp)paramFromServiceMsg.msg_create_session_rsp.get();
            this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Int = paramFromServiceMsg.enum_channel_type.get();
            this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.b = paramFromServiceMsg.enum_translator_type.get();
            try
            {
              this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Long = Long.valueOf(paramToServiceMsg.str_session_id.get()).longValue();
            }
            catch (Exception paramToServiceMsg)
            {
              QLog.w("AudioTransClientInfoHandler", 1, "onReceive, Exception", paramToServiceMsg);
            }
            paramToServiceMsg = paramFromServiceMsg.rpt_msg_interface_list.get();
            this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_JavaUtilList = new ArrayList();
            boolean bool = b();
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("onReceive, cmd[TransInfoCreate.CreateSession], seq[");
            paramFromServiceMsg.append(i);
            paramFromServiceMsg.append("], mInfoInterfaceData[");
            paramFromServiceMsg.append(this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData);
            paramFromServiceMsg.append("], isSender[");
            paramFromServiceMsg.append(bool);
            paramFromServiceMsg.append("], isSuccessCreateSession[");
            paramFromServiceMsg.append(this.jdField_a_of_type_Boolean);
            paramFromServiceMsg.append("]");
            QLog.w("AudioTransClientInfoHandler", 1, paramFromServiceMsg.toString());
            paramToServiceMsg = paramToServiceMsg.iterator();
            while (paramToServiceMsg.hasNext())
            {
              paramFromServiceMsg = (AudioTransCommon.NetAddr)paramToServiceMsg.next();
              paramObject = new NetAddr();
              paramObject.fixed32_IP = paramFromServiceMsg.fixed32_IP.get();
              paramObject.uint32_port = paramFromServiceMsg.uint32_port.get();
              paramObject.enum_proto_type = paramFromServiceMsg.enum_proto_type.get();
              paramObject.fixed32_inner_IP = paramFromServiceMsg.fixed32_inner_IP.get();
              this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_JavaUtilList.add(paramObject);
              paramObject = new StringBuilder();
              paramObject.append("IP = ");
              AudioTrans localAudioTrans = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
              paramObject.append(AudioTrans.a(paramFromServiceMsg.fixed32_IP.get()));
              paramObject.append("|");
              paramObject.append(paramFromServiceMsg.uint32_port.get());
              paramObject.append("|");
              paramObject.append(paramFromServiceMsg.enum_proto_type.get());
              paramObject.append("|");
              localAudioTrans = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
              paramObject.append(AudioTrans.a(paramFromServiceMsg.fixed32_inner_IP.get()));
              QLog.d("AudioTransClientInfoHandler", 2, paramObject.toString());
            }
            paramToServiceMsg = (AudioTransClientInterfaceHandler)this.appRuntime.getBusinessHandler(BusinessHandlerFactory.a);
            long l = i;
            paramToServiceMsg.a(l, true, this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Long);
            this.jdField_a_of_type_Boolean = true;
            if (!bool) {
              return;
            }
            a(l, this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Long);
            return;
          }
          paramToServiceMsg = (AudioTransClientTransInfo.InfoC2SFailedRsp)paramFromServiceMsg.msg_failed_rsp.get();
          QLog.d("AudioTransClientInfoHandler", 2, "create session rsp fail msg");
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("uint32_errcode = ");
          paramFromServiceMsg.append(paramToServiceMsg.uint32_errcode.get());
          QLog.d("AudioTransClientInfoHandler", 2, paramFromServiceMsg.toString());
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("str_errmsg = ");
          paramFromServiceMsg.append(paramToServiceMsg.str_errmsg.get());
          QLog.d("AudioTransClientInfoHandler", 2, paramFromServiceMsg.toString());
          return;
        }
        QLog.e("AudioTransClientInfoHandler", 2, "response not return uint32_error_no");
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("exception = ");
        paramFromServiceMsg.append(paramToServiceMsg.getMessage());
        QLog.e("AudioTransClientInfoHandler", 2, paramFromServiceMsg.toString());
        return;
      }
    }
    else
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("sso request fail, error msg is ");
      paramToServiceMsg.append(paramFromServiceMsg.getBusinessFailMsg());
      QLog.e("AudioTransClientInfoHandler", 2, paramToServiceMsg.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInfoHandler
 * JD-Core Version:    0.7.0.1
 */