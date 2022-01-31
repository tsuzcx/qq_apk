package com.tencent.component.network.module.common.dns;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import pit;

public class Lookup
{
  private String a = "";
  
  public Lookup(String paramString)
  {
    this.a = paramString;
  }
  
  public InetAddress[] a(String paramString, long paramLong)
  {
    InetAddress[] arrayOfInetAddress = null;
    RequestPacket localRequestPacket = new RequestPacket(paramString);
    Object localObject1 = localRequestPacket.a();
    if (localObject1 == null) {
      localObject1 = arrayOfInetAddress;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        Object localObject2 = new pit();
        ((pit)localObject2).a(paramLong);
        localObject2 = ((pit)localObject2).a(this.a, (byte[])localObject1);
        localObject1 = arrayOfInetAddress;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = new ResponsePacket(new DNSInput((byte[])localObject2), paramString);
        localObject1 = arrayOfInetAddress;
        if (((ResponsePacket)localObject2).a() != localRequestPacket.a()) {
          continue;
        }
        arrayOfInetAddress = ((ResponsePacket)localObject2).a();
        localObject1 = arrayOfInetAddress;
        if (arrayOfInetAddress == null) {
          continue;
        }
        localObject1 = arrayOfInetAddress;
        if (arrayOfInetAddress.length <= 0) {
          continue;
        }
        HostCacheManager.a().a(paramString, arrayOfInetAddress, ((ResponsePacket)localObject2).a());
        return arrayOfInetAddress;
      }
      catch (WireParseException paramString)
      {
        throw paramString;
      }
      catch (SocketTimeoutException paramString)
      {
        throw paramString;
      }
      catch (IOException paramString)
      {
        throw paramString;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.Lookup
 * JD-Core Version:    0.7.0.1
 */