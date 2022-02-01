package com.tencent.av.gaudio;

import java.util.Vector;

class AVNotifyCenter$GAudioRoomInfo
{
  public long a = 0L;
  public Vector<AVNotifyCenter.UserInfo> b = null;
  
  public AVNotifyCenter$GAudioRoomInfo(AVNotifyCenter paramAVNotifyCenter) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("roomNum[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], list[");
    Object localObject = this.b;
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