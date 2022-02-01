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
    paramWeishiRequest.b(bool1);
    if (bool1) {
      return paramString;
    }
    return "SQQzoneSvc." + paramString;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null) {
      Log.e("weishi", "***onReceive request is null");
    }
    while ((!(paramIntent instanceof WeishiIntent)) || (((WeishiIntent)paramIntent).a == null)) {
      return;
    }
    ((WeishiIntent)paramIntent).a.a.a(paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null)
    {
      Log.e("weishi", "onSend request is null");
      return;
    }
    for (;;)
    {
      try
      {
        if ((paramIntent instanceof WeishiIntent))
        {
          WeishiIntent localWeishiIntent = (WeishiIntent)paramIntent;
          WeishiTask localWeishiTask = localWeishiIntent.a;
          WeishiRequest localWeishiRequest = localWeishiTask.a;
          Object localObject2 = localWeishiRequest.encode();
          Object localObject1 = localObject2;
          if (localObject2 == null)
          {
            Log.e("weishi-Servlet", "onSend request encode result is null.cmd=" + localWeishiTask.a.uniKey());
            localObject1 = new byte[4];
          }
          long l = localWeishiIntent.getLongExtra("timeout", 30000L);
          paramPacket.setTimeout(l);
          WSLog.d("weishi-Servlet", "request = " + localWeishiTask.a.getCmdString() + "; timeout:" + l);
          localObject2 = a(localWeishiRequest, localWeishiRequest.d());
          paramPacket.setSSOCommand((String)localObject2);
          Log.i("weishi-Servlet", "SSO命令字: " + (String)localObject2);
          localWeishiRequest.e = localObject1.length;
          paramPacket.putSendData((byte[])localObject1);
          Log.i("weishi-Servlet", "onSend request cmd=" + localWeishiTask.a.uniKey() + " is correct");
          ((WeishiIntent)paramIntent).a.a.a = System.currentTimeMillis();
          return;
        }
      }
      catch (Exception paramIntent)
      {
        Log.e("weishi-Servlet", "onSend occur exception.Exception detail=" + Log.getStackTraceString(paramIntent));
        return;
      }
      Log.e("weishi-Servlet", "onSend request instanceod WeishiIntent is false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.WeishiServlet
 * JD-Core Version:    0.7.0.1
 */