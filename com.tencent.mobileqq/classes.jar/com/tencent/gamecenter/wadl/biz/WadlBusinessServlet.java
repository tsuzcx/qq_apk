package com.tencent.gamecenter.wadl.biz;

import android.content.Intent;
import android.os.Bundle;
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
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onReceive... ");
    if (paramFromServiceMsg != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(",failCode=");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.getBusinessFailCode());
      ((StringBuilder)localObject1).append("  errMsg:");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.getBusinessFailMsg());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = "";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.d("Wadl_WadlBusinessServlet", 1, ((StringBuilder)localObject2).toString());
    long l = System.currentTimeMillis();
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onReceive success=");
    ((StringBuilder)localObject1).append(bool);
    QLog.d("Wadl_WadlBusinessServlet", 1, ((StringBuilder)localObject1).toString());
    localObject1 = null;
    if (bool)
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject1 = new byte[i];
      PkgTools.copyData((byte[])localObject1, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    if (paramIntent == null)
    {
      QLog.w("Wadl_WadlBusinessServlet", 1, "onReceive fail, request is null");
      return;
    }
    int i = paramIntent.getIntExtra("wadl_sso_type", 0);
    if (i == 1)
    {
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).onRespTrpcSso(paramIntent, bool, (byte[])localObject1);
    }
    else if (i == 0)
    {
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).onRespWebSso(paramIntent, bool, (byte[])localObject1);
    }
    else if (i == 2)
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("extra_result_code", paramFromServiceMsg.getResultCode());
      ((Bundle)localObject2).putString("extra_cmd", paramIntent.getStringExtra("extra_cmd"));
      ((Bundle)localObject2).putByteArray("webssoReq", (byte[])localObject1);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
    }
    paramIntent = new StringBuilder();
    paramIntent.append("onReceive exit|cost: ");
    paramIntent.append(System.currentTimeMillis() - l);
    QLog.d("Wadl_WadlBusinessServlet", 1, paramIntent.toString());
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("webssoReq");
    int i = paramIntent.getIntExtra("wadl_sso_type", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSend...ssoType:");
    localStringBuilder.append(i);
    localStringBuilder.append(",data is null:");
    boolean bool;
    if (arrayOfByte == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.d("Wadl_WadlBusinessServlet", 1, localStringBuilder.toString());
    if (i == 1) {
      paramPacket.setSSOCommand("GDCTrpcProxy.service");
    } else if (i == 2) {
      paramPacket.setSSOCommand(paramIntent.getStringExtra("extra_cmd"));
    } else {
      paramPacket.setSSOCommand("QQVacCommSvc.web_sso");
    }
    if (arrayOfByte != null)
    {
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.DWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.copyData(paramIntent, 4, arrayOfByte, arrayOfByte.length);
    }
    else
    {
      paramIntent = new byte[4];
      PkgTools.DWord2Byte(paramIntent, 0, 4L);
    }
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.WadlBusinessServlet
 * JD-Core Version:    0.7.0.1
 */