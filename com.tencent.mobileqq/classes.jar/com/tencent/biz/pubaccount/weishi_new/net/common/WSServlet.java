package com.tencent.biz.pubaccount.weishi_new.net.common;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.config.WSConfigManager;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigBean;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeWnsConfigInfo;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
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
    WeSeeConfigBean localWeSeeConfigBean = WSConfigManager.a().a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localWeSeeConfigBean != null)
    {
      bool1 = bool2;
      if (localWeSeeConfigBean.a != null) {
        bool1 = localWeSeeConfigBean.a.a();
      }
    }
    paramWSRequest.setRemoveWns(bool1);
    if (bool1) {
      return paramWSRequest.getRequestCmd();
    }
    return "SQQzoneSvc." + paramWSRequest.getRequestCmd();
  }
  
  private void a(Packet paramPacket, WeishiIntent paramWeishiIntent, WSRequest paramWSRequest)
  {
    byte[] arrayOfByte2 = paramWSRequest.encode();
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      WSLog.d("[WSService][Servlet]", "[onSend] request encode result is null.cmd=" + paramWSRequest.getReqUniKey());
      arrayOfByte1 = new byte[4];
    }
    long l = paramWeishiIntent.getLongExtra("timeout", 30000L);
    paramPacket.setTimeout(l);
    WSLog.d("[WSService][Servlet]", "[onSend]request = " + paramWSRequest.getCmdString() + "; timeout:" + l);
    paramWeishiIntent = a(paramWSRequest);
    paramPacket.setSSOCommand(paramWeishiIntent);
    WSLog.a("[WSService][Servlet]", "[onSend]SSO命令字: " + paramWeishiIntent);
    paramWSRequest.reqSize = arrayOfByte1.length;
    paramPacket.putSendData(arrayOfByte1);
    WSLog.a("[WSService][Servlet]", "[onSend] request cmd=" + paramWSRequest.getReqUniKey() + " is correct");
    paramWSRequest.getTimeRecord().d();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    WSLog.d("[WSService][Servlet]", "[onReceive]");
    if (!(paramIntent instanceof WeishiIntent)) {
      WSLog.d("[WSService][Servlet]", "[onReceive] intent is null");
    }
    do
    {
      return;
      paramIntent = ((WeishiIntent)paramIntent).getObserver();
    } while (paramIntent == null);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("response", paramFromServiceMsg);
    paramIntent.onReceive(0, true, localBundle);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null)
    {
      WSLog.d("[WSService][Servlet]", "[onSend] request is null");
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
    }
    catch (Exception paramIntent)
    {
      WSLog.d("[WSService][Servlet]", "[onSend] occur exception.Exception detail=" + Log.getStackTraceString(paramIntent));
      return;
    }
    WSLog.d("[WSService][Servlet]", "[onSend] request instanceod WeishiIntent is false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSServlet
 * JD-Core Version:    0.7.0.1
 */