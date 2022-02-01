package com.tencent.beacon.base.net.b;

import com.tencent.beacon.base.util.b;
import com.tencent.beacon.e.g;
import com.tencent.beacon.pack.RequestPackage;

final class a$a
  implements c<RequestPackage, byte[]>
{
  private byte[] a(byte[] paramArrayOfByte)
  {
    g localg = g.b();
    byte[] arrayOfByte = paramArrayOfByte;
    if (localg != null) {
      arrayOfByte = b.b(paramArrayOfByte, 2, 3, localg.a());
    }
    return arrayOfByte;
  }
  
  private byte[] b(RequestPackage paramRequestPackage)
  {
    com.tencent.beacon.pack.c localc = new com.tencent.beacon.pack.c();
    localc.a(1);
    localc.b("test");
    localc.a("test");
    localc.b("detail", paramRequestPackage);
    return localc.a();
  }
  
  public byte[] a(RequestPackage paramRequestPackage)
  {
    if (paramRequestPackage == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RequestPackage: ");
    localStringBuilder.append(paramRequestPackage.toString());
    com.tencent.beacon.base.util.c.a("[BeaconNet]", localStringBuilder.toString(), new Object[0]);
    paramRequestPackage = a(b(paramRequestPackage));
    if (paramRequestPackage != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("request package after processing size: ");
      localStringBuilder.append(paramRequestPackage.length);
      com.tencent.beacon.base.util.c.a("[BeaconNet]", localStringBuilder.toString(), new Object[0]);
    }
    return paramRequestPackage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.a.a
 * JD-Core Version:    0.7.0.1
 */