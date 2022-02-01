package com.tencent.ilivesdk.roomservice_interface.model;

import com.tencent.falco.utils.HexUtil;

public class LiveMediaInfo
{
  public byte[] sig;
  public long timeOut;
  
  public String toString()
  {
    return "LiveMediaInfo is [sig= " + HexUtil.bytesToHexString(this.sig) + ";timeOut=" + this.timeOut + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.model.LiveMediaInfo
 * JD-Core Version:    0.7.0.1
 */