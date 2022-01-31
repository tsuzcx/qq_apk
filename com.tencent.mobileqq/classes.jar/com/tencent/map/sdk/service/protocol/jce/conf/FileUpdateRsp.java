package com.tencent.map.sdk.service.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.l;

public final class FileUpdateRsp
  extends MapJceStruct
{
  public int iFileSize = 0;
  public int iFileUpdated = 0;
  public int iRet = 0;
  public int iVersion = 0;
  public String sMd5 = "";
  public String sName = "";
  public String sUpdateUrl = "";
  
  public FileUpdateRsp() {}
  
  public FileUpdateRsp(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, int paramInt4)
  {
    this.sName = paramString1;
    this.iRet = paramInt1;
    this.iVersion = paramInt2;
    this.iFileUpdated = paramInt3;
    this.sUpdateUrl = paramString2;
    this.sMd5 = paramString3;
    this.iFileSize = paramInt4;
  }
  
  public final String className()
  {
    return "MapConfProtocol.FileUpdateRsp";
  }
  
  public final void readFrom(k paramk)
  {
    this.sName = paramk.b(0, true);
    this.iRet = paramk.a(this.iRet, 1, true);
    this.iVersion = paramk.a(this.iVersion, 2, true);
    this.iFileUpdated = paramk.a(this.iFileUpdated, 3, false);
    this.sUpdateUrl = paramk.b(4, false);
    this.sMd5 = paramk.b(5, false);
    this.iFileSize = paramk.a(this.iFileSize, 6, false);
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.sName, 0);
    paraml.a(this.iRet, 1);
    paraml.a(this.iVersion, 2);
    paraml.a(this.iFileUpdated, 3);
    if (this.sUpdateUrl != null) {
      paraml.a(this.sUpdateUrl, 4);
    }
    if (this.sMd5 != null) {
      paraml.a(this.sMd5, 5);
    }
    paraml.a(this.iFileSize, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.jce.conf.FileUpdateRsp
 * JD-Core Version:    0.7.0.1
 */