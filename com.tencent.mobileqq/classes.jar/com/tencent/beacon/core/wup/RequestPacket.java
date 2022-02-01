package com.tencent.beacon.core.wup;

import java.util.HashMap;
import java.util.Map;

public final class RequestPacket
  extends JceStruct
{
  static Map<String, String> cache_context;
  static byte[] cache_sBuffer;
  public byte cPacketType = 0;
  public Map<String, String> context;
  public int iMessageType = 0;
  public int iRequestId = 0;
  public int iTimeout = 0;
  public short iVersion = 3;
  public byte[] sBuffer;
  public String sFuncName = null;
  public String sServantName = null;
  public Map<String, String> status;
  
  public void readFrom(a parama)
  {
    try
    {
      this.iVersion = parama.a(this.iVersion, 1, true);
      this.cPacketType = parama.a(this.cPacketType, 2, true);
      this.iMessageType = parama.a(this.iMessageType, 3, true);
      this.iRequestId = parama.a(this.iRequestId, 4, true);
      this.sServantName = parama.a(5, true);
      this.sFuncName = parama.a(6, true);
      Object localObject = cache_sBuffer;
      if (localObject == null) {
        cache_sBuffer = new byte[] { 0 };
      }
      this.sBuffer = parama.a(cache_sBuffer, 7, true);
      this.iTimeout = parama.a(this.iTimeout, 8, true);
      if (cache_context == null)
      {
        cache_context = new HashMap();
        localObject = cache_context;
        ((Map)localObject).put("", "");
      }
      this.context = ((Map)parama.a(cache_context, 9, true));
      if (cache_context == null)
      {
        cache_context = new HashMap();
        localObject = cache_context;
        ((Map)localObject).put("", "");
      }
      this.status = ((Map)parama.a(cache_context, 10, true));
      return;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
      throw new RuntimeException(parama);
    }
  }
  
  public void writeTo(b paramb)
  {
    paramb.a(this.iVersion, 1);
    paramb.a(this.cPacketType, 2);
    paramb.a(this.iMessageType, 3);
    paramb.a(this.iRequestId, 4);
    paramb.a(this.sServantName, 5);
    paramb.a(this.sFuncName, 6);
    paramb.a(this.sBuffer, 7);
    paramb.a(this.iTimeout, 8);
    paramb.a(this.context, 9);
    paramb.a(this.status, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.wup.RequestPacket
 * JD-Core Version:    0.7.0.1
 */