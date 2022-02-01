package com.tencent.biz.richframework.network;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;

public class VSNetworkHelper$OnReceivedCall
{
  public void onReceived(BaseRequest paramBaseRequest, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    VSNetworkHelper.getDispatchObserver().onReceive(paramBaseRequest.getContextHashCode(), paramBoolean, paramBaseRequest, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.VSNetworkHelper.OnReceivedCall
 * JD-Core Version:    0.7.0.1
 */