package com.tencent.imsdk.common;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class HttpClient$4
  implements HttpClient.HttpRequestListener
{
  HttpClient$4(long paramLong1, long paramLong2) {}
  
  public void onCompleted(int paramInt, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    if (this.val$responseCallback != 0L)
    {
      Object localObject;
      if (paramMap != null)
      {
        String[] arrayOfString = new String[paramMap.size()];
        localObject = new String[paramMap.size()];
        int i = 0;
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          arrayOfString[i] = ((String)localEntry.getKey());
          localObject[i] = ((String)localEntry.getValue());
          i += 1;
        }
        paramMap = arrayOfString;
      }
      else
      {
        paramMap = null;
        localObject = paramMap;
      }
      HttpClient.access$400(paramInt, paramMap, (String[])localObject, paramArrayOfByte, this.val$responseCallback);
    }
  }
  
  public void onProgress(int paramInt1, int paramInt2, int paramInt3)
  {
    long l = this.val$progressCallback;
    if (l != 0L) {
      HttpClient.access$300(paramInt1, paramInt2, paramInt3, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.HttpClient.4
 * JD-Core Version:    0.7.0.1
 */