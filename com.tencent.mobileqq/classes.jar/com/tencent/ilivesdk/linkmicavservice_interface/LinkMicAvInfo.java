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
    return "linkMicAvInfo is [uid= " + this.uid + ", roomId =" + this.roomId + ",businessUid= " + this.businessUid + ",linkMicSig= " + new String(this.linkMicSig) + ",linkMicType= " + this.linkMicType + ",tinyId=" + this.tinyId + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.linkmicavservice_interface.LinkMicAvInfo
 * JD-Core Version:    0.7.0.1
 */