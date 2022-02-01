package com.tencent.biz.game;

import OnlinePushPack.SvcRespPushMsg;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

class SensorAPIJavaScript$9
  implements MSFToWebViewConnector.IOnMsgReceiveListener
{
  SensorAPIJavaScript$9(SensorAPIJavaScript paramSensorAPIJavaScript) {}
  
  public void a(int paramInt, SvcRespPushMsg paramSvcRespPushMsg)
  {
    if (this.a.b != null)
    {
      AppInterface localAppInterface = this.a.mRuntime.b();
      if (localAppInterface != null)
      {
        ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", localAppInterface.getAccount(), "OnlinePush.RespPush");
        localToServiceMsg.setNeedCallback(false);
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        int i = MobileQQService.seq;
        MobileQQService.seq = i + 1;
        localUniPacket.setRequestId(i);
        localUniPacket.setServantName("OnlinePush");
        localUniPacket.setFuncName("SvcRespPushMsg");
        localUniPacket.setRequestId(paramInt);
        localUniPacket.put("resp", paramSvcRespPushMsg);
        localToServiceMsg.putWupBuffer(localUniPacket.encode());
        paramSvcRespPushMsg = new NewIntent(this.a.b.getApplicationContext(), TempServlet.class);
        paramSvcRespPushMsg.putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
        localAppInterface.startServlet(paramSvcRespPushMsg);
        if (QLog.isColorLevel()) {
          QLog.d("SensorApi", 2, "reply push");
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    String str = SensorAPIJavaScript.G.a(String.valueOf(paramInt));
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("send data to appId=");
        localStringBuilder.append(paramInt);
        QLog.d("SensorApi", 2, localStringBuilder.toString());
      }
      if (this.a.F == null) {
        this.a.F = new Handler(Looper.getMainLooper());
      }
      this.a.F.post(new SensorAPIJavaScript.9.1(this, str, paramString));
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("appId=");
      paramString.append(paramInt);
      paramString.append("'s callback is empty");
      QLog.d("SensorApi", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.9
 * JD-Core Version:    0.7.0.1
 */