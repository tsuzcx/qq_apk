package com.tencent.av.gaudio;

import java.util.Vector;

class AVNotifyCenter$GAudioRoomInfo
{
  public long a;
  public Vector<AVNotifyCenter.UserInfo> a;
  
  public AVNotifyCenter$GAudioRoomInfo(AVNotifyCenter paramAVNotifyCenter)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilVector = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("roomNum[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], list[");
    Object localObject = this.jdField_a_of_type_JavaUtilVector;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(((Vector)localObject).size());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.GAudioRoomInfo
 * JD-Core Version:    0.7.0.1
 */