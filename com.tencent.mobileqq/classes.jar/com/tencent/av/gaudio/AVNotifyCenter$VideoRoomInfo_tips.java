package com.tencent.av.gaudio;

public class AVNotifyCenter$VideoRoomInfo_tips
{
  public long a;
  public boolean b;
  public int c = 0;
  
  public AVNotifyCenter$VideoRoomInfo_tips(AVNotifyCenter paramAVNotifyCenter) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("relationId[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], isOffLine[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], avType[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo_tips
 * JD-Core Version:    0.7.0.1
 */