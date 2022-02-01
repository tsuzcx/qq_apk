package com.tencent.map.sdk.a;

import com.tencent.map.sdk.service.MapServiceManager;
import com.tencent.map.sdk.service.protocol.jce.rtt.RttResponse;
import com.tencent.map.sdk.service.protocol.request.RttDataRequest;
import com.tencent.map.tools.net.NetResponse;

public final class jn
  extends qe
{
  private static jn a;
  
  public static jn a()
  {
    try
    {
      if (a == null) {
        a = new jn();
      }
      jn localjn = a;
      return localjn;
    }
    finally {}
  }
  
  private static RttResponse b(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < 3) {
      try
      {
        Object localObject = ((RttDataRequest)((ni)MapServiceManager.getService(ni.class)).c()).rttData(paramArrayOfByte);
        if ((localObject != null) && (((NetResponse)localObject).data != null))
        {
          e locale = new e();
          locale.a("UTF-8");
          locale.a(((NetResponse)localObject).data);
          localObject = (RttResponse)locale.a("res", true, null);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i += 1;
      }
    }
    return null;
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      paramArrayOfByte = b(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return null;
      }
      paramArrayOfByte = paramArrayOfByte.result;
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return null;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jn
 * JD-Core Version:    0.7.0.1
 */