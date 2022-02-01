package com.tencent.biz.pubaccount.weishi_new.net.common;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.config.WSConfigManager;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigBean;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeWnsConfigInfo;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.biz.pubaccount.weishi_new.report.WSLaunchDeltaTimeCalculator;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

public class WSServlet
  extends MSFServlet
{
  private String a(WSRequest paramWSRequest)
  {
    Object localObject = WSConfigManager.a().a();
    boolean bool;
    if ((localObject != null) && (((WeSeeConfigBean)localObject).a != null)) {
      bool = ((WeSeeConfigBean)localObject).a.a();
    } else {
      bool = false;
    }
    paramWSRequest.setRemoveWns(bool);
    if (bool) {
      return paramWSRequest.getRequestCmd();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append(paramWSRequest.getRequestCmd());
    return ((StringBuilder)localObject).toString();
  }
  
  private void a(Packet paramPacket, WeishiIntent paramWeishiIntent, WSRequest paramWSRequest)
  {
    Object localObject2 = paramWSRequest.encode();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[MSFServlet.java][handlePacket] request encode result is null.cmd=");
      ((StringBuilder)localObject1).append(paramWSRequest.getReqUniKey());
      WSLog.d("[WSService][Servlet]", ((StringBuilder)localObject1).toString());
      localObject1 = new byte[4];
    }
    long l = paramWeishiIntent.getLongExtra("timeout", 30000L);
    paramPacket.setTimeout(l);
    paramWeishiIntent = new StringBuilder();
    paramWeishiIntent.append("[MSFServlet.java][handlePacket]request = ");
    paramWeishiIntent.append(paramWSRequest.getCmdString());
    paramWeishiIntent.append("; timeout:");
    paramWeishiIntent.append(l);
    WSLog.d("[WSService][Servlet]", paramWeishiIntent.toString());
    paramWeishiIntent = a(paramWSRequest);
    paramPacket.setSSOCommand(paramWeishiIntent);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[MSFServlet.java][handlePacket]sso cmd: ");
    ((StringBuilder)localObject2).append(paramWeishiIntent);
    WSLog.a("[WSService][Servlet]", ((StringBuilder)localObject2).toString());
    paramWSRequest.reqSize = localObject1.length;
    paramPacket.putSendData((byte[])localObject1);
    paramWSRequest.getTimeRecord().d();
    if (paramWSRequest.isNeedLaunchCalculator()) {
      WSInitializeHelper.a().a().b();
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    WSLog.d("[WSService][Servlet]", "[MSFServlet.java][onReceive]");
    if (!(paramIntent instanceof WeishiIntent))
    {
      WSLog.d("[WSService][Servlet]", "[MSFServlet.java][onReceive] intent is null");
      return;
    }
    paramIntent = ((WeishiIntent)paramIntent).getObserver();
    if (paramIntent != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("response", paramFromServiceMsg);
      paramIntent.onReceive(0, true, localBundle);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null)
    {
      WSLog.d("[WSService][Servlet]", "[MSFServlet.java][onSend] request is null");
      return;
    }
    try
    {
      if ((paramIntent instanceof WeishiIntent))
      {
        paramIntent = (WeishiIntent)paramIntent;
        a(paramPacket, paramIntent, (WSRequest)paramIntent.getObserver());
        return;
      }
      WSLog.d("[WSService][Servlet]", "[MSFServlet.java][onSend] request instanceod WeishiIntent is false");
      return;
    }
    catch (Exception paramIntent)
    {
      paramPacket = new StringBuilder();
      paramPacket.append("[MSFServlet.java][onSend] occur exception.Exception detail=");
      paramPacket.append(Log.getStackTraceString(paramIntent));
      WSLog.d("[WSService][Servlet]", paramPacket.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSServlet
 * JD-Core Version:    0.7.0.1
 */