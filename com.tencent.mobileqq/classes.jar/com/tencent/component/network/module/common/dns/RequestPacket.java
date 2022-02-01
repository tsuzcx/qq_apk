package com.tencent.component.network.module.common.dns;

public class RequestPacket
{
  private static byte[] header = { 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 };
  private static byte[] question = { 0, 0, 1, 0, 1 };
  private String domain;
  private int reqId;
  
  public RequestPacket(String paramString)
  {
    this.domain = paramString;
    this.reqId = AtomicRequestId.getInstance().getId();
  }
  
  private void warpReqId(byte[] paramArrayOfByte)
  {
    int i = this.reqId;
    paramArrayOfByte[0] = ((byte)(i >>> 8 & 0xFF));
    paramArrayOfByte[1] = ((byte)(i & 0xFF));
  }
  
  public byte[] getQueryData()
  {
    Object localObject1 = this.domain;
    if (localObject1 == null) {
      return null;
    }
    this.domain = ((String)localObject1).trim().toLowerCase();
    if (this.domain.length() == 0) {
      return null;
    }
    localObject1 = new byte[header.length + question.length + this.domain.length() + 1];
    Object localObject2 = this.domain.split("\\.");
    int j = header.length;
    int i = 0;
    while (i < localObject2.length)
    {
      localObject1[j] = ((byte)localObject2[i].length());
      j += 1;
      byte[] arrayOfByte = localObject2[i].getBytes();
      System.arraycopy(arrayOfByte, 0, localObject1, j, arrayOfByte.length);
      j += arrayOfByte.length;
      i += 1;
    }
    localObject2 = header;
    System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
    localObject2 = question;
    System.arraycopy(localObject2, 0, localObject1, j, localObject2.length);
    warpReqId((byte[])localObject1);
    return localObject1;
  }
  
  public int getReqId()
  {
    return this.reqId;
  }
  
  public int getType()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.RequestPacket
 * JD-Core Version:    0.7.0.1
 */