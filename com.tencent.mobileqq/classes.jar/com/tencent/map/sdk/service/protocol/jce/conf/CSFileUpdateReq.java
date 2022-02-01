package com.tencent.map.sdk.service.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.l;
import java.util.ArrayList;

public final class CSFileUpdateReq
  extends MapJceStruct
{
  static ArrayList<FileUpdateReq> a = new ArrayList();
  public String sAppId = "";
  public String sCity = "";
  public String sEngineVersion = "";
  public String sId = "";
  public String sSDKVersion = "";
  public ArrayList<FileUpdateReq> vItems = null;
  
  static
  {
    FileUpdateReq localFileUpdateReq = new FileUpdateReq();
    a.add(localFileUpdateReq);
  }
  
  public CSFileUpdateReq() {}
  
  public CSFileUpdateReq(ArrayList<FileUpdateReq> paramArrayList, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.vItems = paramArrayList;
    this.sAppId = paramString1;
    this.sSDKVersion = paramString2;
    this.sCity = paramString3;
    this.sEngineVersion = paramString4;
    this.sId = paramString5;
  }
  
  public final String className()
  {
    return "MapConfProtocol.CSFileUpdateReq";
  }
  
  public final void readFrom(k paramk)
  {
    this.vItems = ((ArrayList)paramk.a(a, 0, true));
    this.sAppId = paramk.b(1, false);
    this.sSDKVersion = paramk.b(2, false);
    this.sCity = paramk.b(3, false);
    this.sEngineVersion = paramk.b(4, false);
    this.sId = paramk.b(5, false);
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.vItems, 0);
    if (this.sAppId != null) {
      paraml.a(this.sAppId, 1);
    }
    if (this.sSDKVersion != null) {
      paraml.a(this.sSDKVersion, 2);
    }
    if (this.sCity != null) {
      paraml.a(this.sCity, 3);
    }
    if (this.sEngineVersion != null) {
      paraml.a(this.sEngineVersion, 4);
    }
    if (this.sId != null) {
      paraml.a(this.sId, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.jce.conf.CSFileUpdateReq
 * JD-Core Version:    0.7.0.1
 */