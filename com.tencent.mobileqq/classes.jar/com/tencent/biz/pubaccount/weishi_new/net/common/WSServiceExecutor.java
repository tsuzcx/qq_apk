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
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class WSServiceExecutor<T extends JceStruct>
{
  private WSRequest<T> a;
  
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[callbackFailure]failCode:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", failMsg:");
    ((StringBuilder)localObject).append(paramString);
    WSLog.d("[WSService][WSServiceExecutor]", ((StringBuilder)localObject).toString());
    if (paramServiceCallback != null)
    {
      localObject = new WSServiceErrorInfo(paramInt, paramString);
      paramServiceCallback.a((WSServiceErrorInfo)localObject);
      ThreadManager.getUIHandler().post(new WSServiceExecutor.3(this, paramInt, paramString, paramServiceCallback, (WSServiceErrorInfo)localObject));
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
  
  @NotNull
  private <E> IWSProtocolListener<T, UniAttribute> b(ServiceCallback<T, E> paramServiceCallback)
  {
    return new WSServiceExecutor.1(this, paramServiceCallback);
  }
  
  <E> void a(ServiceCallback<T, E> paramServiceCallback)
  {
    Object localObject1 = this.a;
    if (localObject1 == null)
    {
      a(1000004, "request is null", paramServiceCallback);
      return;
    }
    ((WSRequest)localObject1).getTimeRecord().b();
    this.a.setListener(b(paramServiceCallback));
    try
    {
      localObject2 = new WeishiIntent(BaseApplication.getContext(), WSServlet.class);
      ((WeishiIntent)localObject2).setWithouLogin(true);
      ((WeishiIntent)localObject2).setObserver(this.a);
      this.a.getClass();
      ((WeishiIntent)localObject2).putExtra("timeout", 30000L);
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject1 != null)
      {
        ((AppRuntime)localObject1).startServlet((NewIntent)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[execute]cmd=");
        ((StringBuilder)localObject2).append(this.a.getReqUniKey());
        ((StringBuilder)localObject2).append(", pkgId=");
        ((StringBuilder)localObject2).append(this.a.getRequestPkgId());
        ((StringBuilder)localObject2).append(" submit to MSF, isLogin: ");
        ((StringBuilder)localObject2).append(((AppRuntime)localObject1).isLogin());
        WSLog.e("[WSService][WSServiceExecutor]", ((StringBuilder)localObject2).toString());
        return;
      }
      WSLog.d("[WSService][WSServiceExecutor]", "[execute]app is null");
      a(2000000, "AppRuntime is null", paramServiceCallback);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[execute]occur exception. stack=");
      ((StringBuilder)localObject2).append(localException.getLocalizedMessage());
      WSLog.d("[WSService][WSServiceExecutor]", ((StringBuilder)localObject2).toString());
      a(2000001, "occur exception", paramServiceCallback);
    }
  }
  
  void a(WSRequest<T> paramWSRequest)
  {
    this.a = paramWSRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceExecutor
 * JD-Core Version:    0.7.0.1
 */