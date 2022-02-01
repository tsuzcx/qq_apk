package com.tencent.map.sdk.service.protocol.jce.conf;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.map.sdk.a.k;
import com.tencent.map.sdk.a.l;
import java.util.ArrayList;

public final class SCFileUpdateRsp
  extends MapJceStruct
{
  static ArrayList<FileUpdateRsp> a = new ArrayList();
  public int iRet = 0;
  public ArrayList<FileUpdateRsp> vItems = null;
  
  static
  {
    FileUpdateRsp localFileUpdateRsp = new FileUpdateRsp();
    a.add(localFileUpdateRsp);
  }
  
  public SCFileUpdateRsp() {}
  
  public SCFileUpdateRsp(int paramInt, ArrayList<FileUpdateRsp> paramArrayList)
  {
    this.iRet = paramInt;
    this.vItems = paramArrayList;
  }
  
  public final String className()
  {
    return "MapConfProtocol.SCFileUpdateRsp";
  }
  
  public final void readFrom(k paramk)
  {
    this.iRet = paramk.a(this.iRet, 0, true);
    this.vItems = ((ArrayList)paramk.a(a, 1, false));
  }
  
  public final void writeTo(l paraml)
  {
    paraml.a(this.iRet, 0);
    if (this.vItems != null) {
      paraml.a(this.vItems, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.jce.conf.SCFileUpdateRsp
 * JD-Core Version:    0.7.0.1
 */