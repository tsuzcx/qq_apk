package com.tencent.av.gaudio;

class AVNotifyCenter$OtherTerChatingRoomInfo
{
  public int a;
  public long a;
  
  AVNotifyCenter$OtherTerChatingRoomInfo(AVNotifyCenter paramAVNotifyCenter, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OtherTerChatingRoomInfo:mRoomId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mSessionType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.OtherTerChatingRoomInfo
 * JD-Core Version:    0.7.0.1
 */