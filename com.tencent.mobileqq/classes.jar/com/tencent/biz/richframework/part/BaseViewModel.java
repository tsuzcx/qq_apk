package com.tencent.biz.richframework.part;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.qphone.base.util.QLog;

public abstract class BaseViewModel
  extends ViewModel
{
  protected int D = -1;
  
  public abstract String a();
  
  public void a(int paramInt, BaseRequest paramBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    VSNetworkHelper.getInstance().sendRequest(paramInt, paramBaseRequest, paramonVSRspCallBack);
    if (paramBaseRequest != null)
    {
      paramonVSRspCallBack = a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a());
      localStringBuilder.append("->sendQCircleRequest: CmdName:");
      localStringBuilder.append(paramBaseRequest.getCmdName());
      localStringBuilder.append("| TraceId:");
      localStringBuilder.append(paramBaseRequest.getTraceId());
      localStringBuilder.append(" | SeqId:");
      localStringBuilder.append(paramBaseRequest.getCurrentSeq());
      QLog.d(paramonVSRspCallBack, 1, localStringBuilder.toString());
    }
  }
  
  public void a(Context paramContext, BaseRequest paramBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    a(paramContext.hashCode(), paramBaseRequest, paramonVSRspCallBack);
  }
  
  public void a(BaseRequest paramBaseRequest, VSDispatchObserver.onVSRspCallBack paramonVSRspCallBack)
  {
    a(this.D, paramBaseRequest, paramonVSRspCallBack);
  }
  
  public void b(int paramInt)
  {
    this.D = paramInt;
  }
  
  protected void c(Object[] paramArrayOfObject) {}
  
  public void d(String paramString)
  {
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadPreloadResult:");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    PreLoader.addListener(paramString, new BaseViewModel.PreloadListener(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.BaseViewModel
 * JD-Core Version:    0.7.0.1
 */