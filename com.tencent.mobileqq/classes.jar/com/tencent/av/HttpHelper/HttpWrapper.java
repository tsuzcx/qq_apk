package com.tencent.av.HttpHelper;

import android.util.Log;

public class HttpWrapper
{
  public static final String tag = "HttpWrapper";
  
  public static void send(byte[] paramArrayOfByte, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send called with Buffer");
    localStringBuilder.append(paramString);
    localStringBuilder.append("end");
    Log.e("HttpWrapper", localStringBuilder.toString());
    new Thread(new HttpWrapper.1(paramString, paramArrayOfByte)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.HttpHelper.HttpWrapper
 * JD-Core Version:    0.7.0.1
 */