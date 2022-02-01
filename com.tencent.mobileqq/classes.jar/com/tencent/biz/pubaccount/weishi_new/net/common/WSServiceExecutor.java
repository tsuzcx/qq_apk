package com.tencent.biz.pubaccount.weishi_new.net.common;

import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiIntent;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class WSServiceExecutor<T extends JceStruct>
{
  private WSRequest<T> a;
  
  @NotNull
  private <E> IWSProtocolListener<T, UniAttribute> a(ServiceCallback<T, E> paramServiceCallback)
  {
    return new WSServiceExecutor.1(this, paramServiceCallback);
  }
  
  private void a()
  {
    this.a.getTimeRecord().m();
    WsBeaconReportPresenter.a().a(this.a);
  }
  
  private void a(int paramInt, String paramString)
  {
    WsBeaconReportPresenter.a().a(this.a, paramInt, paramString);
  }
  
  private <E> void a(int paramInt, String paramString, ServiceCallback<T, E> paramServiceCallback)
  {
    WSLog.d("[WSService][WSServiceExecutor]", "[callbackFailure]failCode:" + paramString + ", failMsg:" + paramString);
    if (paramServiceCallback != null)
    {
      WSServiceErrorInfo localWSServiceErrorInfo = new WSServiceErrorInfo(paramInt, paramString);
      paramServiceCallback.a(localWSServiceErrorInfo);
      ThreadManager.getUIHandler().post(new WSServiceExecutor.3(this, paramInt, paramString, paramServiceCallback, localWSServiceErrorInfo));
    }
  }
  
  private <E> void a(T paramT, ServiceCallback<T, E> paramServiceCallback, RspHeaderBean paramRspHeaderBean)
  {
    if (paramServiceCallback != null)
    {
      paramT = paramServiceCallback.a(this.a, paramT, paramRspHeaderBean);
      this.a.getTimeRecord().l();
      ThreadManager.getUIHandler().post(new WSServiceExecutor.2(this, paramServiceCallback, paramT));
    }
  }
  
  <E> void a(ServiceCallback<T, E> paramServiceCallback)
  {
    if (this.a == null)
    {
      a(1000004, "request is null", paramServiceCallback);
      return;
    }
    this.a.getTimeRecord().b();
    this.a.setListener(a(paramServiceCallback));
    try
    {
      WeishiIntent localWeishiIntent = new WeishiIntent(BaseApplication.getContext(), WSServlet.class);
      localWeishiIntent.setWithouLogin(true);
      localWeishiIntent.setObserver(this.a);
      this.a.getClass();
      localWeishiIntent.putExtra("timeout", 30000L);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime != null)
      {
        localAppRuntime.startServlet(localWeishiIntent);
        WSLog.e("[WSService][WSServiceExecutor]", "[execute]cmd=" + this.a.getReqUniKey() + ", pkgId=" + this.a.getRequestPkgId() + " submit to MSF, isLogin: " + localAppRuntime.isLogin());
        return;
      }
    }
    catch (Exception localException)
    {
      WSLog.d("[WSService][WSServiceExecutor]", "[execute]occur exception. stack=" + localException.getLocalizedMessage());
      a(2000001, "occur exception", paramServiceCallback);
      return;
    }
    WSLog.d("[WSService][WSServiceExecutor]", "[execute]app is null");
    a(2000000, "AppRuntime is null", paramServiceCallback);
  }
  
  void a(WSRequest<T> paramWSRequest)
  {
    this.a = paramWSRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceExecutor
 * JD-Core Version:    0.7.0.1
 */