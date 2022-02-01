package com.tencent.device;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.cs.smart_device_proxy.smart_device_proxy.CgiRsp;
import tencent.im.cs.smart_device_proxy.smart_device_proxy.RspBody;

public class SmartDeviceServlet
  extends MSFServlet
{
  private void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ssoResultCode", paramInt1);
    localBundle.putInt("proxyResultCode", paramInt2);
    notifyObserver(paramIntent, 0, false, localBundle, null);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceServlet", 2, "onReceive " + paramFromServiceMsg.getServiceCmd() + ",resultCode=" + paramFromServiceMsg.getResultCode());
    }
    if ("smart_device_proxy.cgi".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramFromServiceMsg.getResultCode() != 1000) {
        a(paramIntent, paramFromServiceMsg.getResultCode(), 0);
      }
    }
    else {
      return;
    }
    if (paramFromServiceMsg.getWupBuffer() == null)
    {
      a(paramIntent, 0, -1);
      return;
    }
    int i = paramFromServiceMsg.getWupBuffer().length - 4;
    Object localObject = new byte[i];
    PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    smart_device_proxy.RspBody localRspBody = new smart_device_proxy.RspBody();
    smart_device_proxy.CgiRsp localCgiRsp = new smart_device_proxy.CgiRsp();
    try
    {
      localRspBody.mergeFrom((byte[])localObject);
      if (localRspBody.int32_errorCode.get() != 0)
      {
        a(paramIntent, 0, localRspBody.int32_errorCode.get());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
      a(paramIntent, 0, -1);
      return;
    }
    localCgiRsp.mergeFrom(localRspBody.bytes_info.get().toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceServlet", 2, "resultCode=" + localCgiRsp.int32_errorCode.get() + ",resultStr=" + localCgiRsp.bytes_rsp.get().toStringUtf8());
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("cgiResultCode", localCgiRsp.int32_errorCode.get());
    ((Bundle)localObject).putByteArray("data", localCgiRsp.bytes_rsp.get().toByteArray());
    notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceServlet", 2, "onSend");
    }
    paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
    byte[] arrayOfByte1 = paramIntent.getWupBuffer();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    PkgTools.DWord2Byte(arrayOfByte2, 0, arrayOfByte1.length + 4);
    PkgTools.copyData(arrayOfByte2, 4, arrayOfByte1, arrayOfByte1.length);
    paramIntent.putWupBuffer(arrayOfByte2);
    paramPacket.setSSOCommand(paramIntent.getServiceCmd());
    paramPacket.putSendData(paramIntent.getWupBuffer());
    paramPacket.setTimeout(paramIntent.getTimeout());
    paramPacket.setAttributes(paramIntent.getAttributes());
    if (!paramIntent.isNeedCallback()) {
      paramPacket.setNoResponse();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.SmartDeviceServlet
 * JD-Core Version:    0.7.0.1
 */