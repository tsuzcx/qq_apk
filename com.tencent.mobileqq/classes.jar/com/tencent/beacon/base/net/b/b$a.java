package com.tencent.beacon.base.net.b;

import com.tencent.beacon.e.g;
import com.tencent.beacon.pack.RequestPackageV2;

final class b$a
  implements c<RequestPackageV2, byte[]>
{
  private byte[] a(byte[] paramArrayOfByte)
  {
    g localg = g.b();
    byte[] arrayOfByte = paramArrayOfByte;
    if (localg != null) {
      arrayOfByte = com.tencent.beacon.base.util.b.b(paramArrayOfByte, 2, 3, localg.a());
    }
    return arrayOfByte;
  }
  
  public byte[] a(RequestPackageV2 paramRequestPackageV2)
  {
    if (paramRequestPackageV2 == null) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RequestPackageV2: ");
    ((StringBuilder)localObject).append(paramRequestPackageV2.toString());
    com.tencent.beacon.base.util.c.a("[BeaconNet]", ((StringBuilder)localObject).toString(), new Object[0]);
    localObject = new com.tencent.beacon.pack.b();
    paramRequestPackageV2.writeTo((com.tencent.beacon.pack.b)localObject);
    paramRequestPackageV2 = a(((com.tencent.beacon.pack.b)localObject).b());
    if (paramRequestPackageV2 != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("request package after processing size: ");
      ((StringBuilder)localObject).append(paramRequestPackageV2.length);
      com.tencent.beacon.base.util.c.a("[BeaconNet]", ((StringBuilder)localObject).toString(), new Object[0]);
    }
    return paramRequestPackageV2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.b.a
 * JD-Core Version:    0.7.0.1
 */