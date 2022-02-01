package com.tencent.beacon.base.net.b;

import com.tencent.beacon.pack.AbstractJceStruct;
import com.tencent.beacon.pack.RequestPackage;
import com.tencent.beacon.pack.ResponsePackage;

public final class a
  extends c.a<byte[], AbstractJceStruct>
{
  private final a.a a = new a.a();
  private final a.b b = new a.b();
  
  public static a a()
  {
    return new a();
  }
  
  public c<byte[], ResponsePackage> b()
  {
    return this.b;
  }
  
  public c<RequestPackage, byte[]> c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.a
 * JD-Core Version:    0.7.0.1
 */