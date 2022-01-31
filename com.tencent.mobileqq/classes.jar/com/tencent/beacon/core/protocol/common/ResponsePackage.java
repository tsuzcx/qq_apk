package com.tencent.beacon.core.protocol.common;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;

public final class ResponsePackage
  extends JceStruct
{
  static byte[] cache_sBuffer;
  public int cmd = 0;
  public String encryKey = "";
  public String encryPublicKey = "";
  public byte encryType = 0;
  public byte result = 0;
  public byte[] sBuffer = null;
  public long serverTime = 0L;
  public String srcGatewayIp = "";
  public byte zipType = 0;
  
  public ResponsePackage() {}
  
  public ResponsePackage(byte paramByte1, int paramInt, byte[] paramArrayOfByte, String paramString1, byte paramByte2, byte paramByte3, long paramLong, String paramString2, String paramString3)
  {
    this.result = paramByte1;
    this.cmd = paramInt;
    this.sBuffer = paramArrayOfByte;
    this.srcGatewayIp = paramString1;
    this.encryType = paramByte2;
    this.zipType = paramByte3;
    this.serverTime = paramLong;
    this.encryKey = paramString2;
    this.encryPublicKey = paramString3;
  }
  
  public final void readFrom(a parama)
  {
    this.result = parama.a(this.result, 0, true);
    this.cmd = parama.a(this.cmd, 1, true);
    if (cache_sBuffer == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_sBuffer = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.sBuffer = ((byte[])parama.c(2, true));
    this.srcGatewayIp = parama.b(3, true);
    this.encryType = parama.a(this.encryType, 4, true);
    this.zipType = parama.a(this.zipType, 5, true);
    this.serverTime = parama.a(this.serverTime, 6, true);
    this.encryKey = parama.b(7, false);
    this.encryPublicKey = parama.b(8, false);
  }
  
  public final void writeTo(b paramb)
  {
    paramb.a(this.result, 0);
    paramb.a(this.cmd, 1);
    paramb.a(this.sBuffer, 2);
    paramb.a(this.srcGatewayIp, 3);
    paramb.a(this.encryType, 4);
    paramb.a(this.zipType, 5);
    paramb.a(this.serverTime, 6);
    if (this.encryKey != null) {
      paramb.a(this.encryKey, 7);
    }
    if (this.encryPublicKey != null) {
      paramb.a(this.encryPublicKey, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.common.ResponsePackage
 * JD-Core Version:    0.7.0.1
 */