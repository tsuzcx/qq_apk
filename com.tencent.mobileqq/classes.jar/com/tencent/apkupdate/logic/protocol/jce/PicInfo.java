package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PicInfo
  extends JceStruct
{
  public String url = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, true);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.url, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.PicInfo
 * JD-Core Version:    0.7.0.1
 */