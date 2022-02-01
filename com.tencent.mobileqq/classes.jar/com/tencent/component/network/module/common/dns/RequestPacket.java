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
    paramArrayOfByte[0] = ((byte)(this.reqId >>> 8 & 0xFF));
    paramArrayOfByte[1] = ((byte)(this.reqId & 0xFF));
  }
  
  public byte[] getQueryData()
  {
    if (this.domain == null) {}
    do
    {
      return null;
      this.domain = this.domain.trim().toLowerCase();
    } while (this.domain.length() == 0);
    byte[] arrayOfByte1 = new byte[header.length + question.length + this.domain.length() + 1];
    String[] arrayOfString = this.domain.split("\\.");
    int j = header.length;
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfByte1[j] = ((byte)arrayOfString[i].length());
      j += 1;
      byte[] arrayOfByte2 = arrayOfString[i].getBytes();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
      j += arrayOfByte2.length;
      i += 1;
    }
    System.arraycopy(header, 0, arrayOfByte1, 0, header.length);
    System.arraycopy(question, 0, arrayOfByte1, j, question.length);
    warpReqId(arrayOfByte1);
    return arrayOfByte1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.RequestPacket
 * JD-Core Version:    0.7.0.1
 */