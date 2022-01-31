package com.tencent.beacon.core.wup;

import java.util.HashMap;
import java.util.Map;

public final class RequestPacket
  extends JceStruct
{
  static Map<String, String> cache_context = null;
  static byte[] cache_sBuffer = null;
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
  
  public final void readFrom(a parama)
  {
    try
    {
      this.iVersion = parama.a(this.iVersion, 1, true);
      this.cPacketType = parama.a(this.cPacketType, 2, true);
      this.iMessageType = parama.a(this.iMessageType, 3, true);
      this.iRequestId = parama.a(this.iRequestId, 4, true);
      this.sServantName = parama.b(5, true);
      this.sFuncName = parama.b(6, true);
      if (cache_sBuffer == null) {
        cache_sBuffer = new byte[] { 0 };
      }
      this.sBuffer = ((byte[])parama.c(7, true));
      this.iTimeout = parama.a(this.iTimeout, 8, true);
      HashMap localHashMap;
      if (cache_context == null)
      {
        localHashMap = new HashMap();
        cache_context = localHashMap;
        localHashMap.put("", "");
      }
      this.context = ((Map)parama.a(cache_context, 9, true));
      if (cache_context == null)
      {
        localHashMap = new HashMap();
        cache_context = localHashMap;
        localHashMap.put("", "");
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
  
  public final void writeTo(b paramb)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.wup.RequestPacket
 * JD-Core Version:    0.7.0.1
 */