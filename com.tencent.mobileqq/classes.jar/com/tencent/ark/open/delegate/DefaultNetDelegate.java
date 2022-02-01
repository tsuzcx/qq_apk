package com.tencent.ark.open.delegate;

import java.util.HashMap;

public class DefaultNetDelegate
  implements IArkDelegateNet
{
  static final String TAG = "ArkApp.Net";
  
  static void runTask(String paramString, HashMap<String, String> paramHashMap, byte[] paramArrayOfByte, IArkDelegateHTTPCallback paramIArkDelegateHTTPCallback)
  {
    DefaultNetDelegate.HttpParam localHttpParam = new DefaultNetDelegate.HttpParam();
    localHttpParam.url = paramString;
    localHttpParam.headers = paramHashMap;
    localHttpParam.postData = paramArrayOfByte;
    localHttpParam.callback = paramIArkDelegateHTTPCallback;
    new DefaultNetDelegate.HttpTask().execute(new DefaultNetDelegate.HttpParam[] { localHttpParam });
  }
  
  public void get(String paramString, HashMap<String, String> paramHashMap, IArkDelegateHTTPCallback paramIArkDelegateHTTPCallback)
  {
    runTask(paramString, paramHashMap, null, paramIArkDelegateHTTPCallback);
  }
  
  public int getNetworkType()
  {
    return 0;
  }
  
  public boolean isNetworkAvailable()
  {
    return true;
  }
  
  public void post(String paramString, HashMap<String, String> paramHashMap, byte[] paramArrayOfByte, IArkDelegateHTTPCallback paramIArkDelegateHTTPCallback)
  {
    runTask(paramString, paramHashMap, paramArrayOfByte, paramIArkDelegateHTTPCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.delegate.DefaultNetDelegate
 * JD-Core Version:    0.7.0.1
 */