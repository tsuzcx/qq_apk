package com.tencent.ark.open.delegate;

import java.util.HashMap;

public abstract interface IArkDelegateNet
{
  public abstract void get(String paramString, HashMap<String, String> paramHashMap, IArkDelegateHTTPCallback paramIArkDelegateHTTPCallback);
  
  public abstract int getNetworkType();
  
  public abstract boolean isNetworkAvailable();
  
  public abstract void post(String paramString, HashMap<String, String> paramHashMap, byte[] paramArrayOfByte, IArkDelegateHTTPCallback paramIArkDelegateHTTPCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.delegate.IArkDelegateNet
 * JD-Core Version:    0.7.0.1
 */