package com.tencent.biz.pubaccount.weishi_new.net;

import android.content.Intent;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.config.WSConfigManager;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigBean;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeWnsConfigInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

@Deprecated
public class WeishiServlet
  extends MSFServlet
{
  private String a(WeishiRequest paramWeishiRequest, String paramString)
  {
    WeSeeConfigBean localWeSeeConfigBean = WSConfigManager.a().b();
    boolean bool;
    if ((localWeSeeConfigBean != null) && (localWeSeeConfigBean.d != null)) {
      bool = localWeSeeConfigBean.d.a();
    } else {
      bool = false;
    }
    paramWeishiRequest.b(bool);
    if (bool) {
      return paramString;
    }
    paramWeishiRequest = new StringBuilder();
    paramWeishiRequest.append("SQQzoneSvc.");
    paramWeishiRequest.append(paramString);
    return paramWeishiRequest.toString();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null)
    {
      Log.e("weishi", "***onReceive request is null");
      return;
    }
    if ((paramIntent instanceof WeishiIntent))
    {
      paramIntent = (WeishiIntent)paramIntent;
      if (paramIntent.a != null) {
        paramIntent.a.g.a(paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null)
    {
      Log.e("weishi", "onSend request is null");
      return;
    }
    try
    {
      if ((paramIntent instanceof WeishiIntent))
      {
        Object localObject3 = (WeishiIntent)paramIntent;
        WeishiTask localWeishiTask = ((WeishiIntent)localObject3).a;
        WeishiRequest localWeishiRequest = localWeishiTask.g;
        Object localObject2 = localWeishiRequest.encode();
        Object localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onSend request encode result is null.cmd=");
          ((StringBuilder)localObject1).append(localWeishiTask.g.uniKey());
          Log.e("weishi-Servlet", ((StringBuilder)localObject1).toString());
          localObject1 = new byte[4];
        }
        long l = ((WeishiIntent)localObject3).getLongExtra("timeout", 30000L);
        paramPacket.setTimeout(l);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("request = ");
        ((StringBuilder)localObject2).append(localWeishiTask.g.getCmdString());
        ((StringBuilder)localObject2).append("; timeout:");
        ((StringBuilder)localObject2).append(l);
        WSLog.d("weishi-Servlet", ((StringBuilder)localObject2).toString());
        localObject2 = a(localWeishiRequest, localWeishiRequest.i());
        paramPacket.setSSOCommand((String)localObject2);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("SSO命令字: ");
        ((StringBuilder)localObject3).append((String)localObject2);
        Log.i("weishi-Servlet", ((StringBuilder)localObject3).toString());
        localWeishiRequest.k = localObject1.length;
        paramPacket.putSendData((byte[])localObject1);
        paramPacket = new StringBuilder();
        paramPacket.append("onSend request cmd=");
        paramPacket.append(localWeishiTask.g.uniKey());
        paramPacket.append(" is correct");
        Log.i("weishi-Servlet", paramPacket.toString());
      }
      else
      {
        Log.e("weishi-Servlet", "onSend request instanceod WeishiIntent is false");
      }
      ((WeishiIntent)paramIntent).a.g.g = System.currentTimeMillis();
      return;
    }
    catch (Exception paramIntent)
    {
      paramPacket = new StringBuilder();
      paramPacket.append("onSend occur exception.Exception detail=");
      paramPacket.append(Log.getStackTraceString(paramIntent));
      Log.e("weishi-Servlet", paramPacket.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiServlet
 * JD-Core Version:    0.7.0.1
 */