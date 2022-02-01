package com.tencent.beacon.base.net.b;

import com.tencent.beacon.base.util.b;
import com.tencent.beacon.e.g;
import com.tencent.beacon.pack.ResponsePackageV2;
import com.tencent.beacon.pack.a;

final class b$b
  implements c<byte[], ResponsePackageV2>
{
  private byte[] b(byte[] paramArrayOfByte)
  {
    return b.a(paramArrayOfByte, 2, 3, g.b().a());
  }
  
  public ResponsePackageV2 a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = b(paramArrayOfByte);
    ResponsePackageV2 localResponsePackageV2 = new ResponsePackageV2();
    localResponsePackageV2.readFrom(new a(paramArrayOfByte));
    return localResponsePackageV2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.b.b
 * JD-Core Version:    0.7.0.1
 */