package com.tencent.beacon.base.net.b;

import com.tencent.beacon.base.util.b;
import com.tencent.beacon.e.g;
import com.tencent.beacon.pack.ResponsePackage;

final class a$b
  implements c<byte[], ResponsePackage>
{
  private ResponsePackage b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length > 0)
      {
        com.tencent.beacon.pack.c localc = new com.tencent.beacon.pack.c();
        localc.a(paramArrayOfByte);
        paramArrayOfByte = new ResponsePackage();
        paramArrayOfByte = (ResponsePackage)localc.a("detail", paramArrayOfByte);
        return paramArrayOfByte;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      label43:
      break label43;
    }
    return null;
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    return b.a(paramArrayOfByte, 2, 3, g.b().a());
  }
  
  public ResponsePackage a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return b(c(paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.a.b
 * JD-Core Version:    0.7.0.1
 */