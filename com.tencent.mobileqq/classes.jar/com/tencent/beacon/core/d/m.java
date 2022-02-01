package com.tencent.beacon.core.d;

import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.info.b;
import com.tencent.beacon.core.protocol.common.RequestPackage;
import java.nio.charset.Charset;

public class m
{
  public static RequestPackage a(int paramInt1, b paramb, byte[] paramArrayOfByte, int paramInt2, int paramInt3, String paramString)
  {
    if (paramb == null)
    {
      d.b("error no com info! ", new Object[0]);
      return null;
    }
    try
    {
      RequestPackage localRequestPackage = new RequestPackage();
      localRequestPackage.model = paramb.e();
      localRequestPackage.osVersion = paramb.f();
      localRequestPackage.platformId = paramb.g();
      localRequestPackage.appkey = paramString;
      localRequestPackage.appVersion = paramb.a(paramString);
      localRequestPackage.sdkId = paramb.h();
      localRequestPackage.sdkVersion = b.i();
      localRequestPackage.reserved = "";
      localRequestPackage.cmd = paramInt1;
      localRequestPackage.encryType = ((byte)paramInt3);
      localRequestPackage.zipType = ((byte)paramInt2);
      paramb = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramb = "".getBytes(Charset.forName("UTF-8"));
      }
      localRequestPackage.sBuffer = paramb;
      return localRequestPackage;
    }
    catch (Throwable paramb)
    {
      d.a(paramb);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.d.m
 * JD-Core Version:    0.7.0.1
 */