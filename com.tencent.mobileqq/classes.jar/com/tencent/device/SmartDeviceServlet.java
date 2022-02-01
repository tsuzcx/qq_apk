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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive ");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.getServiceCmd());
      ((StringBuilder)localObject1).append(",resultCode=");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.getResultCode());
      QLog.d("SmartDeviceServlet", 2, ((StringBuilder)localObject1).toString());
    }
    if ("smart_device_proxy.cgi".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(paramIntent, paramFromServiceMsg.getResultCode(), 0);
        return;
      }
      if (paramFromServiceMsg.getWupBuffer() == null)
      {
        a(paramIntent, 0, -1);
        return;
      }
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      Object localObject2 = new byte[i];
      PkgTools.copyData((byte[])localObject2, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      smart_device_proxy.RspBody localRspBody = new smart_device_proxy.RspBody();
      localObject1 = new smart_device_proxy.CgiRsp();
      try
      {
        localRspBody.mergeFrom((byte[])localObject2);
        if (localRspBody.int32_errorCode.get() != 0)
        {
          a(paramIntent, 0, localRspBody.int32_errorCode.get());
          return;
        }
        ((smart_device_proxy.CgiRsp)localObject1).mergeFrom(localRspBody.bytes_info.get().toByteArray());
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("resultCode=");
          ((StringBuilder)localObject2).append(((smart_device_proxy.CgiRsp)localObject1).int32_errorCode.get());
          ((StringBuilder)localObject2).append(",resultStr=");
          ((StringBuilder)localObject2).append(((smart_device_proxy.CgiRsp)localObject1).bytes_rsp.get().toStringUtf8());
          QLog.d("SmartDeviceServlet", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("cgiResultCode", ((smart_device_proxy.CgiRsp)localObject1).int32_errorCode.get());
        ((Bundle)localObject2).putByteArray("data", ((smart_device_proxy.CgiRsp)localObject1).bytes_rsp.get().toByteArray());
        notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        a(paramIntent, 0, -1);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceServlet", 2, "onSend");
    }
    paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
    byte[] arrayOfByte1 = paramIntent.getWupBuffer();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    PkgTools.dWord2Byte(arrayOfByte2, 0, arrayOfByte1.length + 4);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.SmartDeviceServlet
 * JD-Core Version:    0.7.0.1
 */