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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive... ");
    if (paramFromServiceMsg != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(",failCode=");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getBusinessFailCode());
      ((StringBuilder)localObject).append("  errMsg:");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getBusinessFailMsg());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    QLog.d("Wadl_WadlBusinessServlet", 1, localStringBuilder.toString());
    long l = System.currentTimeMillis();
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceive success=");
    ((StringBuilder)localObject).append(bool);
    QLog.d("Wadl_WadlBusinessServlet", 1, ((StringBuilder)localObject).toString());
    localObject = null;
    if (bool)
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    if (paramIntent == null)
    {
      QLog.w("Wadl_WadlBusinessServlet", 1, "onReceive fail, request is null");
      return;
    }
    int i = paramIntent.getIntExtra("wadl_sso_type", 0);
    if (i == 1) {
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).onRespTrpcSso(paramIntent, bool, (byte[])localObject);
    } else if (i == 0) {
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).onRespWebSso(paramIntent, bool, (byte[])localObject);
    }
    paramIntent = new StringBuilder();
    paramIntent.append("onReceive exit|cost: ");
    paramIntent.append(System.currentTimeMillis() - l);
    QLog.d("Wadl_WadlBusinessServlet", 1, paramIntent.toString());
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QLog.d("Wadl_WadlBusinessServlet", 1, "onSend...");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("webssoReq");
    if (paramIntent.getIntExtra("wadl_sso_type", 0) == 1) {
      paramPacket.setSSOCommand("GDCTrpcProxy.service");
    } else {
      paramPacket.setSSOCommand("QQVacCommSvc.web_sso");
    }
    if (arrayOfByte != null)
    {
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.DWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.copyData(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
      return;
    }
    paramIntent = new byte[4];
    PkgTools.DWord2Byte(paramIntent, 0, 4L);
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.WadlBusinessServlet
 * JD-Core Version:    0.7.0.1
 */