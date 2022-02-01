package com.tencent.beacon.pack;

import java.util.HashMap;
import java.util.Map;

public final class SocketRequestPackage
  extends AbstractJceStruct
{
  static byte[] cache_body;
  static Map<String, String> cache_header = new HashMap();
  public byte[] body = null;
  public Map<String, String> header = null;
  
  static
  {
    cache_header.put("", "");
    cache_body = new byte[1];
    cache_body[0] = 0;
  }
  
  public SocketRequestPackage() {}
  
  public SocketRequestPackage(Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    this.header = paramMap;
    this.body = paramArrayOfByte;
  }
  
  public void readFrom(a parama)
  {
    this.header = ((Map)parama.a(cache_header, 0, true));
    this.body = parama.a(cache_body, 1, true);
  }
  
  public void writeTo(b paramb)
  {
    paramb.a(this.header, 0);
    paramb.a(this.body, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.pack.SocketRequestPackage
 * JD-Core Version:    0.7.0.1
 */