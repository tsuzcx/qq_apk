package com.tencent.biz.subscribe.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ProtoBufRequest
{
  public static final AtomicInteger a = new AtomicInteger(0);
  
  public abstract byte[] a();
  
  public byte[] a(Intent paramIntent, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
      localStQWebReq.Seq.set(paramInt);
      localStQWebReq.qua.set(QUA.getQUA3());
      localStQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
      localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(a()));
      if (!TextUtils.isEmpty(paramString)) {
        localStQWebReq.traceid.set(paramString);
      }
      if (paramIntent != null) {
        paramIntent.putExtra("traceid", paramString);
      }
      return localStQWebReq.toByteArray();
    }
    throw new RuntimeException("req traceId is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.servlet.ProtoBufRequest
 * JD-Core Version:    0.7.0.1
 */