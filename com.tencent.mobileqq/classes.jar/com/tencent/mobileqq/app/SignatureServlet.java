package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class SignatureServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive cmd=");
      ((StringBuilder)localObject).append(paramIntent.getStringExtra("cmd"));
      QLog.d("SignatureServlet", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    new Bundle().putByteArray("data", (byte[])localObject);
    SignatureHandler localSignatureHandler = (SignatureHandler)((QQAppInterface)super.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
    if (localSignatureHandler != null) {
      localSignatureHandler.a(paramIntent, paramFromServiceMsg, (byte[])localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SignatureServlet", 2, "onReceive exit");
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    if ((!TextUtils.isEmpty(str)) && (arrayOfByte != null))
    {
      paramPacket.setSSOCommand(str);
      paramPacket.setTimeout(l);
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.dWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.copyData(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend exit cmd=");
      paramIntent.append(str);
      QLog.d("SignatureServlet", 2, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureServlet
 * JD-Core Version:    0.7.0.1
 */