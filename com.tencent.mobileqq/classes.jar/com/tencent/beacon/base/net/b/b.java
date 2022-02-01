package com.tencent.beacon.base.net.b;

import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackageV2;
import com.tencent.beacon.pack.ResponsePackageV2;

public class b
  extends c.a<byte[], AbstractJceStruct>
{
  private final b.a a = new b.a();
  private final b.b b = new b.b();
  
  public static b a()
  {
    return new b();
  }
  
  public c<byte[], ResponsePackageV2> b()
  {
    return this.b;
  }
  
  public c<RequestPackageV2, byte[]> c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.b
 * JD-Core Version:    0.7.0.1
 */