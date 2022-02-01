package com.tencent.biz.richframework.network.request;

import NS_COMM.COMM.Entry;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ProtoBufRequest
{
  public static final String TAG = "ProtoBufRequest";
  public static final AtomicInteger atomicInteger = new AtomicInteger(0);
  
  public static byte[] decode(byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localStQWebRsp.busiBuff.get().toByteArray();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      label27:
      break label27;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProtoBufRequest", 2, "inform QZoneGetGroupCountServlet resultcode fail.");
    }
    return null;
  }
  
  public static long getNewSeq()
  {
    return atomicInteger.getAndIncrement();
  }
  
  public byte[] encode(Intent paramIntent, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
      localStQWebReq.Seq.set(paramInt);
      localStQWebReq.qua.set(QUA.getQUA3());
      localStQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
      localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(getBusiBuf()));
      if (!TextUtils.isEmpty(paramString)) {
        localStQWebReq.traceid.set(paramString);
      }
      if (paramIntent != null) {
        paramIntent.putExtra("traceid", paramString);
      }
      if (StudyModeManager.h())
      {
        paramIntent = new COMM.Entry();
        paramIntent.key.set("teenager");
        paramIntent.value.set(String.valueOf(1));
        paramString = new ArrayList();
        paramString.add(paramIntent);
        localStQWebReq.Extinfo.set(paramString);
      }
      return localStQWebReq.toByteArray();
    }
    throw new RuntimeException("req traceId is null!");
  }
  
  public abstract byte[] getBusiBuf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.ProtoBufRequest
 * JD-Core Version:    0.7.0.1
 */