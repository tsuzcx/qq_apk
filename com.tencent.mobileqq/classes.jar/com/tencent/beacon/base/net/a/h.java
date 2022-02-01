package com.tencent.beacon.base.net.a;

import com.tencent.beacon.base.net.NetException;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.b.a;
import com.tencent.beacon.base.net.e;
import com.tencent.beacon.pack.AbstractResponseCommon;
import com.tencent.beacon.pack.ResponsePackage;

class h
  implements b<byte[]>
{
  h(i parami, b paramb) {}
  
  public void a(e parame)
  {
    b localb = this.a;
    if (localb != null) {
      localb.a(parame);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("raw response size: ");
    ((StringBuilder)localObject).append(paramArrayOfByte.length);
    com.tencent.beacon.base.util.c.a("[BeaconNet]", ((StringBuilder)localObject).toString(), new Object[0]);
    if (i.a(this.b).g() == RequestType.EVENT)
    {
      localObject = (AbstractResponseCommon)com.tencent.beacon.base.net.d.c().f.b().a(paramArrayOfByte);
      if (localObject != null) {
        paramArrayOfByte = null;
      } else {
        throw new NetException("ResponsePackageV2 == null");
      }
    }
    else
    {
      localObject = (AbstractResponseCommon)com.tencent.beacon.base.net.d.c().e.b().a(paramArrayOfByte);
      if (localObject == null) {
        break label213;
      }
      paramArrayOfByte = (ResponsePackage)localObject;
      if (paramArrayOfByte.cmd != i.a(this.b).f()) {
        break label203;
      }
      if (paramArrayOfByte.result != 0) {
        break label193;
      }
      paramArrayOfByte = paramArrayOfByte.sBuffer;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
        break label183;
      }
    }
    com.tencent.beacon.base.net.c.d.a(((AbstractResponseCommon)localObject).serverTime, ((AbstractResponseCommon)localObject).srcGatewayIp);
    localObject = this.a;
    if (localObject != null) {
      ((b)localObject).a(paramArrayOfByte);
    }
    return;
    label183:
    throw new NetException("responsePackage.buffer == null");
    label193:
    throw new NetException("responsePackage.result != OK(0)");
    label203:
    throw new NetException("responsePackage.cmd != requestEntity.responseCmd");
    label213:
    throw new NetException("responsePackage == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.a.h
 * JD-Core Version:    0.7.0.1
 */