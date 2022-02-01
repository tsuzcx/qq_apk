package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ProtoServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MSFServlet", 2, "onReceive");
    }
    if (paramIntent == null) {
      return;
    }
    Bundle localBundle = paramIntent.getExtras();
    byte[] arrayOfByte = null;
    if (paramFromServiceMsg.isSuccess())
    {
      arrayOfByte = WupUtil.b(paramFromServiceMsg.getWupBuffer());
    }
    else
    {
      localBundle.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      localBundle.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
    }
    localBundle.putByteArray("data", arrayOfByte);
    notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
    if (QLog.isColorLevel()) {
      QLog.i("MSFServlet", 2, "onReceive exit");
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MSFServlet", 2, "onSend");
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(WupUtil.a(arrayOfByte));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    if (QLog.isColorLevel()) {
      QLog.i("MSFServlet", 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.ProtoServlet
 * JD-Core Version:    0.7.0.1
 */