package com.tencent.av.business.handler;

import android.text.TextUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.avcore.jni.data.NetAddr;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SExitSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SFailedRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionReq;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SJoinSessionRsp;
import com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SRawDataReq;
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
  
  private AudioTransClientTransInfo.IntHead a(int paramInt1, int paramInt2)
  {
    AudioTransClientTransInfo.IntHead localIntHead = new AudioTransClientTransInfo.IntHead();
    localIntHead.str_session_id.set(String.valueOf(this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Long));
    localIntHead.str_uin.set(this.appRuntime.getAccount());
    localIntHead.uint32_seq.set(paramInt2);
    localIntHead.enum_body_type.set(paramInt1);
    return localIntHead;
  }
  
  private AudioTransClientTransInfo.IntReqBody a(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    AudioTransClientTransInfo.IntReqBody localIntReqBody = new AudioTransClientTransInfo.IntReqBody();
    if (paramInt == 1)
    {
      paramArrayOfByte = new AudioTransClientTransInfo.IntC2SJoinSessionReq();
      paramArrayOfByte.uint32_client_ver.set(UITools.getQQVersion());
      paramArrayOfByte.enum_term.set(4);
      paramArrayOfByte.enum_net_type.set(2);
      paramArrayOfByte.uint32_client_port.set(12331);
      paramArrayOfByte.enum_business_direction.set(4);
      paramArrayOfByte.enum_data_source.set(3);
      paramArrayOfByte.bool_translate.set(paramBoolean);
      localIntReqBody.msg_join_session_req.set(paramArrayOfByte);
      return localIntReqBody;
    }
    if (paramInt == 3)
    {
      paramArrayOfByte = new AudioTransClientTransInfo.IntC2SExitSessionReq();
      localIntReqBody.msg_exit_session_req.set(paramArrayOfByte);
      return localIntReqBody;
    }
    if (paramInt == 7)
    {
      AudioTransClientTransInfo.IntC2SRawDataReq localIntC2SRawDataReq = new AudioTransClientTransInfo.IntC2SRawDataReq();
      if (paramArrayOfByte != null) {
        localIntC2SRawDataReq.bytes_data.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      localIntC2SRawDataReq.str_key.set("str_key");
      localIntReqBody.msg_raw_data_req.set(localIntC2SRawDataReq);
      return localIntReqBody;
    }
    if (paramInt == 5)
    {
      paramArrayOfByte = new AudioTransClientTransInfo.IntC2SChangeSessionReq();
      paramArrayOfByte.bool_translate.set(paramBoolean);
      localIntReqBody.msg_change_session_req.set(paramArrayOfByte);
    }
    return localIntReqBody;
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
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onReceivePush bodyType = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(paramArrayOfByte.uint32_error_no.get());
      QLog.d("AudioTransClientInterfaceHandler", 2, ((StringBuilder)localObject2).toString());
      if (paramArrayOfByte.uint32_error_no.get() == 0)
      {
        paramArrayOfByte = paramArrayOfByte.str_uin.get().toString();
        localObject1 = (AudioTransClientTransInfo.IntReqBody)new AudioTransClientTransInfo.IntReqBody().mergeFrom((byte[])localObject1);
        if (paramInt != 11)
        {
          if (paramInt != 13) {
            return;
          }
          paramInt = ((AudioTransClientTransInfo.IntS2CNotifyExitReq)((AudioTransClientTransInfo.IntReqBody)localObject1).msg_notify_exit_req.get()).uint32_reason.get();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onReceivePush exit:");
          ((StringBuilder)localObject1).append(paramArrayOfByte);
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(paramInt);
          QLog.d("AudioTransClientInterfaceHandler", 2, ((StringBuilder)localObject1).toString());
          return;
        }
        localObject1 = (AudioTransClientTransInfo.IntS2CPushDataReq)((AudioTransClientTransInfo.IntReqBody)localObject1).msg_push_data_req.get();
        ((AudioTransClientTransInfo.IntS2CPushDataReq)localObject1).str_key.get().toString();
        localObject2 = ((AudioTransClientTransInfo.IntS2CPushDataReq)localObject1).translate_result.get().toByteArray();
        localObject1 = new AudioTransCommon.TranslateResult();
        ((AudioTransCommon.TranslateResult)localObject1).mergeFrom((byte[])localObject2);
        localObject2 = new String(((AudioTransCommon.TranslateResult)localObject1).bytes_src_text.get().toByteArray());
        String str = new String(((AudioTransCommon.TranslateResult)localObject1).bytes_tar_text.get().toByteArray());
        paramInt = ((AudioTransCommon.TranslateResult)localObject1).int32_status.get();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onReceivePush data:");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(str);
        QLog.d("AudioTransClientInterfaceHandler", 2, ((StringBuilder)localObject1).toString());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          a(paramArrayOfByte, (String)localObject2, str, paramInt);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceivePush exception = ");
      ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
      QLog.e("AudioTransClientInterfaceHandler", 2, ((StringBuilder)localObject1).toString(), paramArrayOfByte);
    }
  }
  
  protected abstract void a(long paramLong1, boolean paramBoolean, List<NetAddr> paramList, long paramLong2);
  
  public void a(String paramString1, long paramLong, String paramString2, byte[] paramArrayOfByte)
  {
    int j = this.jdField_a_of_type_Int;
    ToServiceMsg localToServiceMsg = createToServiceMsg(paramString2);
    boolean bool2 = "TransInfo.JoinSession".equals(paramString2);
    boolean bool1 = false;
    int i;
    if (bool2)
    {
      this.jdField_a_of_type_Int = 0;
      bool1 = a();
      i = 1;
    }
    else if ("TransInfo.ExitSession".equals(paramString2))
    {
      i = 3;
    }
    else if ("TransInfo.ChangeSession".equals(paramString2))
    {
      i = 5;
      bool1 = a();
    }
    else if ("TransInfo.RawData".equals(paramString2))
    {
      this.jdField_a_of_type_Int += 1;
      i = 7;
    }
    else
    {
      i = -1;
    }
    AudioTransClientTransInfo.IntHead localIntHead = a(i, (int)paramLong);
    paramArrayOfByte = a(i, bool1, paramArrayOfByte);
    AudioTrans localAudioTrans = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
    localToServiceMsg.putWupBuffer(AudioTrans.a(localIntHead.toByteArray(), paramArrayOfByte.toByteArray()));
    if (NetworkUtil.isNetworkAvailable(this.appRuntime.getApplicationContext())) {
      sendPbReq(localToServiceMsg);
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("sendCmdToServiceSSO, cmd[");
    paramArrayOfByte.append(paramString2);
    paramArrayOfByte.append("], seq[");
    paramArrayOfByte.append(paramLong);
    paramArrayOfByte.append("], bodyType[");
    paramArrayOfByte.append(i);
    paramArrayOfByte.append("], trans_english[");
    paramArrayOfByte.append(bool1);
    paramArrayOfByte.append("], mSendRawDataCount[");
    paramArrayOfByte.append(j);
    paramArrayOfByte.append("->");
    paramArrayOfByte.append(this.jdField_a_of_type_Int);
    paramArrayOfByte.append("], from[");
    paramArrayOfByte.append(paramString1);
    paramArrayOfByte.append("]");
    QLog.w("AudioTransClientInterfaceHandler", 1, paramArrayOfByte.toString());
  }
  
  protected abstract void a(String paramString1, String paramString2, String paramString3, int paramInt);
  
  protected abstract boolean a();
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    paramObject = new StringBuilder();
    paramObject.append("onReceive, getServiceCmd[");
    paramObject.append(paramToServiceMsg);
    paramObject.append("], isSuccess[");
    paramObject.append(bool);
    paramObject.append("], failMsg[");
    paramObject.append(paramFromServiceMsg.getBusinessFailMsg());
    paramObject.append("]");
    QLog.w("AudioTransClientInterfaceHandler", 1, paramObject.toString());
    if (bool)
    {
      paramObject = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
      paramObject = AudioTrans.a(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg = paramObject.a;
      paramObject = paramObject.b;
      Object localObject = new AudioTransClientTransInfo.IntHead();
      try
      {
        paramFromServiceMsg = (AudioTransClientTransInfo.IntHead)((AudioTransClientTransInfo.IntHead)localObject).mergeFrom(paramFromServiceMsg);
        i = paramFromServiceMsg.uint32_seq.get();
        bool = paramFromServiceMsg.uint32_error_no.has();
        if (bool)
        {
          paramObject = (AudioTransClientTransInfo.IntRspBody)new AudioTransClientTransInfo.IntRspBody().mergeFrom(paramObject);
          j = paramFromServiceMsg.uint32_error_no.get();
          if (j == 0) {
            j = paramFromServiceMsg.enum_body_type.get();
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        int i;
        int j;
        long l;
        label209:
        int k;
        int m;
        int n;
        QLog.w("AudioTransClientInterfaceHandler", 1, "onReceive, Exception", paramToServiceMsg);
      }
    }
    try
    {
      l = Long.valueOf(paramFromServiceMsg.str_session_id.get()).longValue();
    }
    catch (Exception localException)
    {
      break label209;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceive, Exception, sessionid[");
    ((StringBuilder)localObject).append(paramFromServiceMsg.str_session_id.get());
    ((StringBuilder)localObject).append("]");
    QLog.w("AudioTransClientInterfaceHandler", 1, ((StringBuilder)localObject).toString());
    l = 0L;
    k = this.b;
    if (j == 2)
    {
      paramFromServiceMsg = (AudioTransClientTransInfo.IntC2SJoinSessionRsp)paramObject.msg_join_session_rsp.get();
      m = paramFromServiceMsg.uint32_combine_num.get();
      n = paramFromServiceMsg.uint32_heartbeat_duration.get();
      this.b = 0;
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("combineNum = ");
      paramFromServiceMsg.append(m);
      paramFromServiceMsg.append("\nheartBeatDuration = ");
      paramFromServiceMsg.append(n);
      QLog.d("AudioTransClientInterfaceHandler", 2, paramFromServiceMsg.toString());
    }
    else if (j == 4)
    {
      this.b = 0;
      a(i, false, null, l);
    }
    else if (j == 8)
    {
      this.b += 1;
    }
    else if (j == 6)
    {
      paramFromServiceMsg = (AudioTransClientTransInfo.IntC2SChangeSessionRsp)paramObject.msg_change_session_rsp.get();
      this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Int = paramFromServiceMsg.enum_channel_type.get();
      if (AudioHelper.b())
      {
        m = paramFromServiceMsg.uint32_combine_num.get();
        paramObject = new StringBuilder();
        paramObject.append("enum_channel_type = ");
        paramObject.append(this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTransClientInfoHandlerExtend$InfoInterfaceData.jdField_a_of_type_Int);
        QLog.d("AudioTransClientInterfaceHandler", 2, paramObject.toString());
        paramObject = new StringBuilder();
        paramObject.append("uint32_combine_num = ");
        paramObject.append(m);
        QLog.d("AudioTransClientInterfaceHandler", 2, paramObject.toString());
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_interface_list.get().iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (AudioTransCommon.NetAddr)paramFromServiceMsg.next();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fixed32_IP = ");
          AudioTrans localAudioTrans = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
          ((StringBuilder)localObject).append(AudioTrans.a(paramObject.fixed32_IP.get()));
          QLog.d("AudioTransClientInterfaceHandler", 2, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("uint32_port = ");
          ((StringBuilder)localObject).append(paramObject.uint32_port.get());
          QLog.d("AudioTransClientInterfaceHandler", 2, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("enum_proto_type = ");
          ((StringBuilder)localObject).append(paramObject.enum_proto_type.get());
          QLog.d("AudioTransClientInterfaceHandler", 2, ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fixed32_inner_IP = ");
          localAudioTrans = this.jdField_a_of_type_ComTencentAvBusinessHandlerAudioTrans;
          ((StringBuilder)localObject).append(AudioTrans.a(paramObject.fixed32_inner_IP.get()));
          QLog.d("AudioTransClientInterfaceHandler", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("onReceive, cmd[");
    paramFromServiceMsg.append(paramToServiceMsg);
    paramFromServiceMsg.append("], seq[");
    paramFromServiceMsg.append(i);
    paramFromServiceMsg.append("], bodyType[");
    paramFromServiceMsg.append(j);
    paramFromServiceMsg.append("], sessionid[");
    paramFromServiceMsg.append(l);
    paramFromServiceMsg.append("], mReceiveRawDataCount[");
    paramFromServiceMsg.append(k);
    paramFromServiceMsg.append("->");
    paramFromServiceMsg.append(this.b);
    paramFromServiceMsg.append("]");
    QLog.w("AudioTransClientInterfaceHandler", 1, paramFromServiceMsg.toString());
    return;
    paramToServiceMsg = (AudioTransClientTransInfo.IntC2SFailedRsp)paramObject.msg_failed_rsp.get();
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("onReceive, error, uint32_seq[");
    paramFromServiceMsg.append(i);
    paramFromServiceMsg.append("], uint32_error_no[");
    paramFromServiceMsg.append(j);
    paramFromServiceMsg.append("], uint32_errcode[");
    paramFromServiceMsg.append(paramToServiceMsg.uint32_errcode.get());
    paramFromServiceMsg.append("], str_errmsg[");
    paramFromServiceMsg.append(paramToServiceMsg.str_errmsg.get());
    paramFromServiceMsg.append("]");
    QLog.w("AudioTransClientInterfaceHandler", 1, paramFromServiceMsg.toString());
    return;
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("onReceive, error, uint32_seq[");
    paramToServiceMsg.append(i);
    paramToServiceMsg.append("]");
    QLog.w("AudioTransClientInterfaceHandler", 1, paramToServiceMsg.toString());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInterfaceHandler
 * JD-Core Version:    0.7.0.1
 */