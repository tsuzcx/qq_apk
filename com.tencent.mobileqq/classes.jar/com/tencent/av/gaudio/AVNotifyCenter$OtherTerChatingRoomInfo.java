package com.tencent.av.gaudio;

class AVNotifyCenter$OtherTerChatingRoomInfo
{
  public long a;
  public int b;
  
  AVNotifyCenter$OtherTerChatingRoomInfo(AVNotifyCenter paramAVNotifyCenter, long paramLong, int paramInt)
  {
    this.a = paramLong;
    this.b = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OtherTerChatingRoomInfo:mRoomId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mSessionType=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.OtherTerChatingRoomInfo
 * JD-Core Version:    0.7.0.1
 */