package com.tencent.ilivesdk.roomservice_interface.model;

import com.tencent.falco.utils.HexUtil;

public class LiveMediaInfo
{
  public byte[] sig;
  public long timeOut;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LiveMediaInfo is [sig= ");
    localStringBuilder.append(HexUtil.bytesToHexString(this.sig));
    localStringBuilder.append(";timeOut=");
    localStringBuilder.append(this.timeOut);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice_interface.model.LiveMediaInfo
 * JD-Core Version:    0.7.0.1
 */