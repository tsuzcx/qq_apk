package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ApkFileInfo
  extends JceStruct
{
  static Map cache_fileCRC32;
  public long apkId = 0L;
  public Map fileCRC32 = null;
  public String manifestMd5 = "";
  public String packageName = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.apkId = paramJceInputStream.read(this.apkId, 0, true);
    this.manifestMd5 = paramJceInputStream.readString(1, true);
    this.packageName = paramJceInputStream.readString(2, true);
    if (cache_fileCRC32 == null)
    {
      cache_fileCRC32 = new HashMap();
      cache_fileCRC32.put("", Long.valueOf(0L));
    }
    this.fileCRC32 = ((Map)paramJceInputStream.read(cache_fileCRC32, 3, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.apkId, 0);
    paramJceOutputStream.write(this.manifestMd5, 1);
    paramJceOutputStream.write(this.packageName, 2);
    paramJceOutputStream.write(this.fileCRC32, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.ApkFileInfo
 * JD-Core Version:    0.7.0.1
 */