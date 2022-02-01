package com.tencent.ilinkservice;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.ilink.tdi.b.a;
import com.tencent.ilink.tdi.b.c;
import com.tencent.ilink.tdi.b.d;
import com.tencent.ilink.tdi.b.z;

final class an
  implements ao
{
  private final String a = "IlinkServiceTdiClone";
  private as b;
  private ap c;
  private int d;
  
  public an(int paramInt, ap paramap)
  {
    this.d = paramInt;
    this.c = paramap;
  }
  
  public int a(b.c paramc)
  {
    return this.c.a(this.d, paramc);
  }
  
  public void a()
  {
    af.a().a("IlinkServiceTdiClone", "onCloneDestroyed", new Object[0]);
    as localas = this.b;
    if (localas != null) {
      localas.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    Object localObject = af.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clone onReceiveAppResponse error:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", taskid:");
    localStringBuilder.append(paramInt1);
    ((af)localObject).a("IlinkServiceTdiClone", localStringBuilder.toString(), new Object[0]);
    localObject = this.b;
    if (localObject != null) {
      try
      {
        ((as)localObject).a(paramInt1, paramInt2, b.d.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    this.c.a(paramInt1, paramArrayOfByte, paramBoolean1, paramInt2, paramBoolean2, paramInt3);
  }
  
  public void a(as paramas)
  {
    this.b = paramas;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    af.a().a("IlinkServiceTdiClone", "onReceiveAppMessage", new Object[0]);
    as localas = this.b;
    if (localas != null) {
      try
      {
        localas.a(b.a.a(paramArrayOfByte));
        return;
      }
      catch (InvalidProtocolBufferException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public b.z b()
  {
    return this.c.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilinkservice.an
 * JD-Core Version:    0.7.0.1
 */