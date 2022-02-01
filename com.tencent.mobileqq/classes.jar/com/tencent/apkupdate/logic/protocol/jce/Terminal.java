package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Terminal
  extends JceStruct
{
  public String androidId = "";
  public String androidIdSdCard = "";
  public String imei = "";
  public String imsi = "";
  public String macAdress = "";
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.imei = paramJceInputStream.readString(0, false);
    this.macAdress = paramJceInputStream.readString(1, false);
    this.androidId = paramJceInputStream.readString(2, false);
    this.androidIdSdCard = paramJceInputStream.readString(3, false);
    this.imsi = paramJceInputStream.readString(4, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.imei;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.macAdress;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.androidId;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.androidIdSdCard;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.imsi;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.Terminal
 * JD-Core Version:    0.7.0.1
 */