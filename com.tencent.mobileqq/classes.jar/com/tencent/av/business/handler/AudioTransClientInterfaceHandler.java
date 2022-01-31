package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SExitSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SExitSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SRawDataReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SRawDataRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntHead;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntReqBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntRspBody;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntS2CNotifyExitReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntS2CPushDataReq;
import com.tencent.mobileqq.audiotrans.AudioTransCommon.NetAddr;
import com.tencent.mobileqq.audiotrans.AudioTransCommon.TranslateResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import mqq.app.MobileQQ;

public abstract class AudioTransClientInterfaceHandler
  extends BusinessHandler
{
  private int jdField_a_of_type_Int;
  private AudioTrans jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans = AudioTrans.a();
  private AudioTransClientInfoHandlerExtend.InfoInterfaceData jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData = AudioTransClientInfoHandlerExtend.InfoInterfaceData.a();
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private int b;
  
  public AudioTransClientInterfaceHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private AudioTransClientTransInfo.IntHead a(int paramInt)
  {
    AudioTransClientTransInfo.IntHead localIntHead = new AudioTransClientTransInfo.IntHead();
    localIntHead.str_session_id.set(String.valueOf(this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Long));
    localIntHead.str_uin.set(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localIntHead.uint32_seq.set(this.jdField_a_of_type_JavaUtilRandom.nextInt());
    localIntHead.enum_body_type.set(paramInt);
    return localIntHead;
  }
  
  private AudioTransClientTransInfo.IntReqBody a(int paramInt1, boolean paramBoolean, int paramInt2, byte[] paramArrayOfByte)
  {
    AudioTransClientTransInfo.IntReqBody localIntReqBody = new AudioTransClientTransInfo.IntReqBody();
    if (paramInt1 == 1)
    {
      paramArrayOfByte = new AudioTransClientTransInfo.IntC2SJoinSessionReq();
      paramArrayOfByte.uint32_client_ver.set(0);
      paramArrayOfByte.enum_term.set(4);
      paramArrayOfByte.enum_net_type.set(2);
      paramArrayOfByte.uint32_client_port.set(12331);
      paramArrayOfByte.enum_business_direction.set(paramInt2);
      paramArrayOfByte.enum_data_source.set(3);
      paramArrayOfByte.bool_translate.set(paramBoolean);
      localIntReqBody.msg_join_session_req.set(paramArrayOfByte);
    }
    do
    {
      return localIntReqBody;
      if (paramInt1 == 3)
      {
        paramArrayOfByte = new AudioTransClientTransInfo.IntC2SExitSessionReq();
        localIntReqBody.msg_exit_session_req.set(paramArrayOfByte);
        return localIntReqBody;
      }
      if (paramInt1 == 7)
      {
        AudioTransClientTransInfo.IntC2SRawDataReq localIntC2SRawDataReq = new AudioTransClientTransInfo.IntC2SRawDataReq();
        if (paramArrayOfByte != null) {
          localIntC2SRawDataReq.bytes_data.set(ByteStringMicro.copyFrom(paramArrayOfByte));
        }
        localIntC2SRawDataReq.str_key.set("str_key");
        localIntReqBody.msg_raw_data_req.set(localIntC2SRawDataReq);
        return localIntReqBody;
      }
    } while (paramInt1 != 5);
    paramArrayOfByte = new AudioTransClientTransInfo.IntC2SChangeSessionReq();
    paramArrayOfByte.bool_translate.set(paramBoolean);
    localIntReqBody.msg_change_session_req.set(paramArrayOfByte);
    return localIntReqBody;
  }
  
  protected abstract int a();
  
  protected Class a()
  {
    return null;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
    localObject1 = AudioTrans.a(paramArrayOfByte);
    paramArrayOfByte = ((AudioTrans.PBBytes)localObject1).a;
    localObject1 = ((AudioTrans.PBBytes)localObject1).b;
    Object localObject2 = new AudioTransClientTransInfo.IntHead();
    try
    {
      paramArrayOfByte = (AudioTransClientTransInfo.IntHead)((AudioTransClientTransInfo.IntHead)localObject2).mergeFrom(paramArrayOfByte);
      paramInt = paramArrayOfByte.enum_body_type.get();
      QLog.d("AudioTransClientInterfaceHandler runhw", 2, "onReceivePush bodyType = " + paramInt + "|" + paramArrayOfByte.uint32_error_no.get());
      if (paramArrayOfByte.uint32_error_no.get() != 0) {
        return;
      }
      paramArrayOfByte = paramArrayOfByte.str_uin.get().toString();
      localObject1 = (AudioTransClientTransInfo.IntReqBody)new AudioTransClientTransInfo.IntReqBody().mergeFrom((byte[])localObject1);
      switch (paramInt)
      {
      case 11: 
        localObject1 = (AudioTransClientTransInfo.IntS2CPushDataReq)((AudioTransClientTransInfo.IntReqBody)localObject1).msg_push_data_req.get();
        ((AudioTransClientTransInfo.IntS2CPushDataReq)localObject1).str_key.get().toString();
        localObject2 = ((AudioTransClientTransInfo.IntS2CPushDataReq)localObject1).translate_result.get().toByteArray();
        localObject1 = new AudioTransCommon.TranslateResult();
        ((AudioTransCommon.TranslateResult)localObject1).mergeFrom((byte[])localObject2);
        localObject2 = new String(((AudioTransCommon.TranslateResult)localObject1).bytes_src_text.get().toByteArray());
        String str = new String(((AudioTransCommon.TranslateResult)localObject1).bytes_tar_text.get().toByteArray());
        paramInt = ((AudioTransCommon.TranslateResult)localObject1).int32_status.get();
        QLog.d("AudioTransClientInterfaceHandler runhw", 2, "onReceivePush data:" + paramArrayOfByte + "|" + paramInt + "|" + (String)localObject2 + "|" + str);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        a(paramArrayOfByte, (String)localObject2, str, paramInt);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      QLog.e("AudioTransClientInterfaceHandler runhw", 2, "onReceivePush exception = " + paramArrayOfByte.getMessage(), paramArrayOfByte);
      return;
    }
    paramInt = ((AudioTransClientTransInfo.IntS2CNotifyExitReq)((AudioTransClientTransInfo.IntReqBody)localObject1).msg_notify_exit_req.get()).uint32_reason.get();
    QLog.d("AudioTransClientInterfaceHandler runhw", 2, "onReceivePush exit:" + paramArrayOfByte + "|" + paramInt);
    return;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    QLog.d("AudioTransClientInterfaceHandler runhw", 2, "onReceive" + paramFromServiceMsg.getServiceCmd());
    if (paramFromServiceMsg.isSuccess())
    {
      paramToServiceMsg = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
      paramFromServiceMsg = AudioTrans.a(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramFromServiceMsg.a;
      paramFromServiceMsg = paramFromServiceMsg.b;
      paramObject = new AudioTransClientTransInfo.IntHead();
      int i;
      long l1;
      try
      {
        paramToServiceMsg = (AudioTransClientTransInfo.IntHead)paramObject.mergeFrom(paramToServiceMsg);
        if (!paramToServiceMsg.uint32_error_no.has()) {
          break label784;
        }
        paramFromServiceMsg = (AudioTransClientTransInfo.IntRspBody)new AudioTransClientTransInfo.IntRspBody().mergeFrom(paramFromServiceMsg);
        if (paramToServiceMsg.uint32_error_no.get() != 0) {
          break label676;
        }
        i = paramToServiceMsg.enum_body_type.get();
        l1 = 0L;
        try
        {
          long l2 = Long.valueOf(paramToServiceMsg.str_session_id.get()).longValue();
          l1 = l2;
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            int j;
            paramToServiceMsg.printStackTrace();
          }
        }
        QLog.d("AudioTransClientInterfaceHandler runhw", 2, "bodyType = " + i + "|" + l1);
        if (i == 2)
        {
          paramToServiceMsg = (AudioTransClientTransInfo.IntC2SJoinSessionRsp)paramFromServiceMsg.msg_join_session_rsp.get();
          i = paramToServiceMsg.uint32_combine_num.get();
          j = paramToServiceMsg.uint32_heartbeat_duration.get();
          this.b = 0;
          QLog.d("AudioTransClientInterfaceHandler runhw", 2, "combineNum = " + i + "\nheartBeatDuration = " + j);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        QLog.e("AudioTransClientInterfaceHandler runhw", 2, "exception = " + paramToServiceMsg.getMessage(), paramToServiceMsg);
        return;
      }
      if (i == 4)
      {
        paramToServiceMsg = (AudioTransClientTransInfo.IntC2SExitSessionRsp)paramFromServiceMsg.msg_exit_session_rsp.get();
        QLog.d("AudioTransClientInterfaceHandler runhw", 2, "receive raw data count is = " + this.b);
        this.b = 0;
        a(false, null, l1);
        return;
      }
      if (i == 8)
      {
        paramToServiceMsg = (AudioTransClientTransInfo.IntC2SRawDataRsp)paramFromServiceMsg.msg_raw_data_rsp.get();
        this.b += 1;
        return;
      }
      if (i == 6)
      {
        paramToServiceMsg = (AudioTransClientTransInfo.IntC2SChangeSessionRsp)paramFromServiceMsg.msg_change_session_rsp.get();
        i = paramToServiceMsg.uint32_combine_num.get();
        this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Int = paramToServiceMsg.enum_channel_type.get();
        QLog.d("AudioTransClientInterfaceHandler runhw", 2, "enum_channel_type = " + this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Int);
        QLog.d("AudioTransClientInterfaceHandler runhw", 2, "uint32_combine_num = " + i);
        paramToServiceMsg = paramToServiceMsg.rpt_msg_interface_list.get().iterator();
        while (paramToServiceMsg.hasNext())
        {
          paramFromServiceMsg = (AudioTransCommon.NetAddr)paramToServiceMsg.next();
          paramObject = new StringBuilder().append("fixed32_IP = ");
          AudioTrans localAudioTrans = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
          QLog.d("AudioTransClientInterfaceHandler runhw", 2, AudioTrans.a(paramFromServiceMsg.fixed32_IP.get()));
          QLog.d("AudioTransClientInterfaceHandler runhw", 2, "uint32_port = " + paramFromServiceMsg.uint32_port.get());
          QLog.d("AudioTransClientInterfaceHandler runhw", 2, "enum_proto_type = " + paramFromServiceMsg.enum_proto_type.get());
          paramObject = new StringBuilder().append("fixed32_inner_IP = ");
          localAudioTrans = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
          QLog.d("AudioTransClientInterfaceHandler runhw", 2, AudioTrans.a(paramFromServiceMsg.fixed32_inner_IP.get()));
        }
        label676:
        paramFromServiceMsg = (AudioTransClientTransInfo.IntC2SFailedRsp)paramFromServiceMsg.msg_failed_rsp.get();
        QLog.d("AudioTransClientInterfaceHandler runhw", 2, "create session rsp fail msg: " + paramToServiceMsg.uint32_error_no.get());
        QLog.d("AudioTransClientInterfaceHandler runhw", 2, "uint32_errcode = " + paramFromServiceMsg.uint32_errcode.get());
        QLog.d("AudioTransClientInterfaceHandler runhw", 2, "str_errmsg = " + paramFromServiceMsg.str_errmsg.get());
        return;
        label784:
        QLog.e("AudioTransClientInterfaceHandler runhw", 2, "response not return uint32_error_no");
      }
    }
    else
    {
      QLog.e("AudioTransClientInterfaceHandler runhw", 2, "sso request fail, error msg is " + paramFromServiceMsg.getBusinessFailMsg() + ", cmd = " + paramFromServiceMsg.getServiceCmd());
    }
  }
  
  protected abstract void a(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("AudioTransClientInterfaceHandler runhw", 2, "sendCmdToService cmd = " + paramString);
    }
    ToServiceMsg localToServiceMsg = a(paramString);
    int i = -1;
    int j = 4;
    if ("TransInfo.JoinSession".equals(paramString))
    {
      this.jdField_a_of_type_Int = 0;
      i = 1;
      bool = a();
      j = a();
    }
    for (;;)
    {
      paramString = a(i);
      paramArrayOfByte = a(i, bool, j, paramArrayOfByte);
      AudioTrans localAudioTrans = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
      localToServiceMsg.putWupBuffer(AudioTrans.a(paramString.toByteArray(), paramArrayOfByte.toByteArray()));
      if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getApplicationContext())) {
        break;
      }
      b(localToServiceMsg);
      return;
      if ("TransInfo.ExitSession".equals(paramString))
      {
        i = 3;
        QLog.d("AudioTransClientInterfaceHandler runhw", 2, "sent " + this.jdField_a_of_type_Int + " raw data packets");
      }
      else if ("TransInfo.ChangeSession".equals(paramString))
      {
        i = 5;
        bool = a();
        j = a();
      }
      else if ("TransInfo.RawData".equals(paramString))
      {
        this.jdField_a_of_type_Int += 1;
        i = 7;
      }
      else
      {
        QLog.e("AudioTransClientInterfaceHandler runhw", 2, "unknown cmd");
      }
    }
    QLog.e("AudioTransClientInterfaceHandler runhw", 2, "network is not available");
  }
  
  protected abstract void a(boolean paramBoolean, List paramList, long paramLong);
  
  protected abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInterfaceHandler
 * JD-Core Version:    0.7.0.1
 */