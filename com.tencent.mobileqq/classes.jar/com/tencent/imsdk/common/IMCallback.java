package com.tencent.imsdk.common;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMValueCallback;

public abstract class IMCallback<T>
{
  protected V2TIMCallback callback;
  protected V2TIMValueCallback<T> valueCallback;
  
  protected IMCallback(V2TIMCallback paramV2TIMCallback)
  {
    this.callback = paramV2TIMCallback;
  }
  
  protected IMCallback(V2TIMValueCallback<T> paramV2TIMValueCallback)
  {
    this.valueCallback = paramV2TIMValueCallback;
  }
  
  public void fail(int paramInt, String paramString)
  {
    IMContext.getInstance().runOnMainThread(new IMCallback.2(this, paramInt, paramString));
  }
  
  public void fail(int paramInt, String paramString, T paramT)
  {
    IMContext.getInstance().runOnMainThread(new IMCallback.3(this, paramInt, paramString));
  }
  
  public void success(T paramT)
  {
    IMContext.getInstance().runOnMainThread(new IMCallback.1(this, paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.IMCallback
 * JD-Core Version:    0.7.0.1
 */