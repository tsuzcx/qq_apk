package com.tencent.av.HttpHelper;

import android.util.Log;

public class HttpWrapper
{
  public static String tag;
  
  public static void send(final byte[] paramArrayOfByte, String paramString)
  {
    Log.e(tag, "send called with Buffer" + paramString + "end");
    new Thread(new Runnable()
    {
      public void run()
      {
        HttpHelper.httpPostRequest(this.val$url, paramArrayOfByte, null, null, null);
      }
    }).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.HttpHelper.HttpWrapper
 * JD-Core Version:    0.7.0.1
 */