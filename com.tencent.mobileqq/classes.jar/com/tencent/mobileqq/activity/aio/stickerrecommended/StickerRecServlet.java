package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class StickerRecServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof AppInterface))) {
      StickerRecManagerImpl.get((AppInterface)localAppRuntime).handleResponse(paramIntent, paramFromServiceMsg);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null)
    {
      QLog.e("StickerRecServlet", 1, "onSend : req is null");
      return;
    }
    paramPacket.setSSOCommand(paramIntent.getStringExtra("key_cmd"));
    paramPacket.putSendData(paramIntent.getByteArrayExtra("key_body"));
    paramPacket.setTimeout(paramIntent.getLongExtra("key_timeout", 6000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecServlet
 * JD-Core Version:    0.7.0.1
 */