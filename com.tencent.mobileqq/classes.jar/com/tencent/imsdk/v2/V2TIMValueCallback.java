package com.tencent.imsdk.v2;

public abstract interface V2TIMValueCallback<T>
{
  public abstract void onError(int paramInt, String paramString);
  
  public abstract void onSuccess(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMValueCallback
 * JD-Core Version:    0.7.0.1
 */