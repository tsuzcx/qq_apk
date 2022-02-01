package com.tencent.map.sdk.service.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.l;

public final class FileUpdateReq
  extends MapJceStruct
{
  public int iVersion = 0;
  public String sMd5 = "";
  public String sName = "";
  
  public FileUpdateReq() {}
  
  public FileUpdateReq(String paramString1, int paramInt, String paramString2)
  {
    this.sName = paramString1;
    this.iVersion = paramInt;
    this.sMd5 = paramString2;
  }
  
  public final String className()
  {
    return "MapConfProtocol.FileUpdateReq";
  }
  
  public final void readFrom(k paramk)
  {
    this.sName = paramk.b(0, true);
    this.iVersion = paramk.a(this.iVersion, 1, true);
    this.sMd5 = paramk.b(2, false);
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.sName, 0);
    paraml.a(this.iVersion, 1);
    if (this.sMd5 != null) {
      paraml.a(this.sMd5, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.jce.conf.FileUpdateReq
 * JD-Core Version:    0.7.0.1
 */