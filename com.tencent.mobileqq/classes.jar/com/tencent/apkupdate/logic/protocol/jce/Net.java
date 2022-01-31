package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Net
  extends JceStruct
{
  public String extNetworkOperator = "";
  public int extNetworkType = 0;
  public byte isWap = 0;
  public byte netType = 0;
  
  public Net() {}
  
  public Net(byte paramByte1, String paramString, int paramInt, byte paramByte2)
  {
    this.netType = paramByte1;
    this.extNetworkOperator = paramString;
    this.extNetworkType = paramInt;
    this.isWap = paramByte2;
  }
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.netType = paramJceInputStream.read(this.netType, 0, true);
    this.extNetworkOperator = paramJceInputStream.readString(1, false);
    this.extNetworkType = paramJceInputStream.read(this.extNetworkType, 2, false);
    this.isWap = paramJceInputStream.read(this.isWap, 3, false);
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.netType, 0);
    if (this.extNetworkOperator != null) {
      paramJceOutputStream.write(this.extNetworkOperator, 1);
    }
    paramJceOutputStream.write(this.extNetworkType, 2);
    paramJceOutputStream.write(this.isWap, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.Net
 * JD-Core Version:    0.7.0.1
 */