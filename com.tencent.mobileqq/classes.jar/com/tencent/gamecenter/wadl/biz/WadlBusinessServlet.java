package com.tencent.gamecenter.wadl.biz;

import android.content.Intent;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class WadlBusinessServlet
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    long l;
    boolean bool;
    label93:
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onReceive... ");
      if (paramFromServiceMsg != null)
      {
        localObject = ",failCode=" + paramFromServiceMsg.getBusinessFailCode() + "  errMsg:" + paramFromServiceMsg.getBusinessFailMsg();
        QLog.d("WadlBusinessServlet", 2, (String)localObject);
      }
    }
    else
    {
      l = 0L;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
        break label189;
      }
      bool = true;
      if (QLog.isColorLevel())
      {
        l = System.currentTimeMillis();
        QLog.d("WadlBusinessServlet", 2, "onReceive success=" + bool);
      }
      if (!bool) {
        break label286;
      }
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    label286:
    for (paramFromServiceMsg = (FromServiceMsg)localObject;; paramFromServiceMsg = null)
    {
      if (paramIntent == null) {
        if (QLog.isColorLevel()) {
          QLog.e("WadlBusinessServlet", 2, "onReceive fail, request is null");
        }
      }
      for (;;)
      {
        return;
        localObject = "";
        break;
        label189:
        bool = false;
        break label93;
        i = paramIntent.getIntExtra("wadl_sso_type", 0);
        if (i == 1) {
          ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).onRespTrpcSso(paramIntent, bool, paramFromServiceMsg);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("WadlBusinessServlet", 2, "onReceive exit|cost: " + (System.currentTimeMillis() - l));
          return;
          if (i == 0) {
            ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).onRespWebSso(paramIntent, bool, paramFromServiceMsg);
          }
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlBusinessServlet", 2, "onSend...");
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("webssoReq");
    if (paramIntent.getIntExtra("wadl_sso_type", 0) == 1) {
      paramPacket.setSSOCommand("GDCTrpcProxy.service");
    }
    while (arrayOfByte != null)
    {
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.DWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.copyData(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
      return;
      paramPacket.setSSOCommand("QQVacCommSvc.web_sso");
    }
    paramIntent = new byte[4];
    PkgTools.DWord2Byte(paramIntent, 0, 4L);
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.WadlBusinessServlet
 * JD-Core Version:    0.7.0.1
 */