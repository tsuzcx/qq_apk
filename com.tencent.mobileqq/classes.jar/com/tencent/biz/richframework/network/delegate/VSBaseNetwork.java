package com.tencent.biz.richframework.network.delegate;

import com.tencent.biz.richframework.network.VSNetworkHelper.OnReceivedCall;
import com.tencent.biz.richframework.network.request.BaseRequest;

public abstract class VSBaseNetwork
{
  public abstract String getAccountId();
  
  public abstract String getQUA();
  
  public boolean isValidLog(String paramString)
  {
    return true;
  }
  
  public boolean needReinitialize()
  {
    return false;
  }
  
  public abstract void onInit();
  
  public abstract void onRelease();
  
  public abstract void sendRequest(BaseRequest paramBaseRequest, byte[] paramArrayOfByte, VSNetworkHelper.OnReceivedCall paramOnReceivedCall);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.delegate.VSBaseNetwork
 * JD-Core Version:    0.7.0.1
 */