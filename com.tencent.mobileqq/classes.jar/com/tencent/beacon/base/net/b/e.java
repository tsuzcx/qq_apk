package com.tencent.beacon.base.net.b;

import com.tencent.beacon.base.net.c.d;
import com.tencent.beacon.pack.SocketResponsePackage;
import com.tencent.beacon.pack.a;

public final class e
  implements c<byte[], SocketResponsePackage>
{
  public SocketResponsePackage a(byte[] paramArrayOfByte)
  {
    SocketResponsePackage localSocketResponsePackage = new SocketResponsePackage();
    localSocketResponsePackage.readFrom(new a(paramArrayOfByte));
    d.c(localSocketResponsePackage.header);
    return localSocketResponsePackage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.e
 * JD-Core Version:    0.7.0.1
 */