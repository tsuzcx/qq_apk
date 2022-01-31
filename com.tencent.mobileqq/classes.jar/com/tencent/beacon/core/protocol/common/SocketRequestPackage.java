package com.tencent.beacon.core.protocol.common;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;
import java.util.HashMap;
import java.util.Map;

public final class SocketRequestPackage
  extends JceStruct
{
  static byte[] cache_body;
  static Map<String, String> cache_header = new HashMap();
  public byte[] body = null;
  public Map<String, String> header = null;
  
  static
  {
    cache_header.put("", "");
    byte[] arrayOfByte = (byte[])new byte[1];
    cache_body = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public SocketRequestPackage() {}
  
  public SocketRequestPackage(Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    this.header = paramMap;
    this.body = paramArrayOfByte;
  }
  
  public final void readFrom(a parama)
  {
    this.header = ((Map)parama.a(cache_header, 0, true));
    this.body = ((byte[])parama.c(1, true));
  }
  
  public final void writeTo(b paramb)
  {
    paramb.a(this.header, 0);
    paramb.a(this.body, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.core.protocol.common.SocketRequestPackage
 * JD-Core Version:    0.7.0.1
 */