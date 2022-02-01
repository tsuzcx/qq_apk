package com.tencent.biz.now;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.now_proxy.pb_now_proxy.ForwardReq;
import com.tencent.now_proxy.pb_now_proxy.ForwardRsp;
import com.tencent.pb.now.ilive_get_record_info_svr.GetRoomStateReq;
import com.tencent.pb.now.ilive_get_record_info_svr.GetRoomStateRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class NowRecordInfo
  extends BusinessHandler
{
  public static String a = "NowRecordInfo";
  NowRecordInfo.GetRecordCallBack b;
  long c = 0L;
  boolean d = false;
  int e;
  String f;
  private QQAppInterface g;
  
  public NowRecordInfo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.g = paramQQAppInterface;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    this.d = false;
    this.c = 0L;
    int i = j;
    if (paramFromServiceMsg.isSuccess())
    {
      i = j;
      if (paramObject != null) {
        i = 1;
      }
    }
    if (i == 0)
    {
      this.e = paramFromServiceMsg.getBusinessFailCode();
      this.f = paramFromServiceMsg.getBusinessFailMsg();
      a(true, "", "", System.currentTimeMillis() - this.c, "");
      return;
    }
    paramToServiceMsg = new pb_now_proxy.ForwardRsp();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg.busi_error_code.get() == 0) && (paramToServiceMsg.busi_buf.get() != null))
      {
        a(paramToServiceMsg.busi_error_code.get(), paramToServiceMsg.busi_buf.get().toByteArray());
        return;
      }
      this.e = paramToServiceMsg.busi_error_code.get();
      a(true, "", "", System.currentTimeMillis() - this.c, "");
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label172:
      break label172;
    }
    a(true, "", "", System.currentTimeMillis() - this.c, "");
  }
  
  private void a(byte[] paramArrayOfByte, String paramString)
  {
    if (this.g == null) {
      return;
    }
    paramString = new ToServiceMsg("mobileqq.service", paramString, "NowGetRecordInfoSvr.get_record_info");
    paramString.putWupBuffer(paramArrayOfByte);
    sendPbReq(paramString);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    QLog.i(a, 0, "拉取录播信息成功");
    this.e = 0;
    this.f = "";
    try
    {
      localObject = new ilive_get_record_info_svr.GetRoomStateRsp();
      ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).mergeFrom(paramArrayOfByte);
      paramInt = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).is_on_live.get();
      paramArrayOfByte = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).vid.get();
      str = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).recorded_share_url.get();
      localObject = ((ilive_get_record_info_svr.GetRoomStateRsp)localObject).another_live_mqq.get();
      if (paramInt == 0) {
        break label116;
      }
      bool = true;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        Object localObject;
        String str;
        continue;
        boolean bool = false;
      }
    }
    a(bool, paramArrayOfByte, str, System.currentTimeMillis() - this.c, (String)localObject);
    return;
    QLog.e(a, 1, "NowRecordObserver InvalidProtocolBufferMicroException! ");
  }
  
  public void a(String paramString1, long paramLong, String paramString2, NowRecordInfo.GetRecordCallBack paramGetRecordCallBack)
  {
    this.b = null;
    this.b = paramGetRecordCallBack;
    this.c = System.currentTimeMillis();
    if (this.g == null)
    {
      QLog.e(a, 1, "getRecordInfo fail,app is null ");
      a(true, "", "", 0L, "");
      return;
    }
    this.d = true;
    paramGetRecordCallBack = new ilive_get_record_info_svr.GetRoomStateReq();
    paramGetRecordCallBack.source.set(paramString1);
    paramGetRecordCallBack.roomid.set((int)paramLong);
    paramString1 = new pb_now_proxy.ForwardReq();
    paramString1.cmd.set(26182);
    paramString1.subcmd.set(2);
    paramString1.uid.set(Long.valueOf(paramString2).longValue());
    paramString1.platform.set(1);
    paramString1.codec.set(0);
    paramString1.busi_buf.set(ByteStringMicro.copyFrom(((ilive_get_record_info_svr.GetRoomStateReq)paramGetRecordCallBack.get()).toByteArray()));
    paramString1.original_id_type.set(1);
    paramString1.original_id.set(paramString2);
    a(paramString1.toByteArray(), paramString2);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    NowRecordInfo.GetRecordCallBack localGetRecordCallBack = this.b;
    if (localGetRecordCallBack != null) {
      localGetRecordCallBack.a(paramBoolean, paramString2, paramString1, paramLong, paramString3);
    }
  }
  
  public String b()
  {
    return this.f;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("NowGetRecordInfoSvr.get_record_info".equals(paramFromServiceMsg.getServiceCmd()))
    {
      QLog.i(a, 1, "onReceive called.");
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.now.NowRecordInfo
 * JD-Core Version:    0.7.0.1
 */