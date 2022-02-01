package com.tencent.biz.richframework.network.observer;

import com.tencent.biz.richframework.network.request.BaseRequest;

public abstract interface VSDispatchObserver$onVSRspCallBack<T>
{
  public abstract void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack
 * JD-Core Version:    0.7.0.1
 */