package com.tencent.ilivesdk.linkmicavservice_interface;

public class LinkMicAvInfo
{
  public long anchorUid;
  public String businessUid;
  public boolean isMute = false;
  public byte[] linkMicSig;
  public int linkMicType;
  public long roomId;
  public long tinyId;
  public long uid;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("linkMicAvInfo is [uid= ");
    localStringBuilder.append(this.uid);
    localStringBuilder.append(", roomId =");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append(",businessUid= ");
    localStringBuilder.append(this.businessUid);
    localStringBuilder.append(",linkMicSig= ");
    localStringBuilder.append(new String(this.linkMicSig));
    localStringBuilder.append(",linkMicType= ");
    localStringBuilder.append(this.linkMicType);
    localStringBuilder.append(",tinyId=");
    localStringBuilder.append(this.tinyId);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.linkmicavservice_interface.LinkMicAvInfo
 * JD-Core Version:    0.7.0.1
 */