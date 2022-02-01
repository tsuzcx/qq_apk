package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Request
  extends JceStruct
{
  static byte[] cache_body;
  static ReqHead cache_head;
  public byte[] body = null;
  public ReqHead head = null;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_head == null) {
      cache_head = new ReqHead();
    }
    this.head = ((ReqHead)paramJceInputStream.read(cache_head, 0, true));
    if (cache_body == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      cache_body = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.body = ((byte[])paramJceInputStream.read(cache_body, 1, false));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.head, 0);
    byte[] arrayOfByte = this.body;
    if (arrayOfByte != null) {
      paramJceOutputStream.write(arrayOfByte, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.Request
 * JD-Core Version:    0.7.0.1
 */