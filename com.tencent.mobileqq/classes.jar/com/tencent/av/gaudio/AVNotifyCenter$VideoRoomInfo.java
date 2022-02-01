package com.tencent.av.gaudio;

import com.tencent.av.utils.AudioHelper;

public class AVNotifyCenter$VideoRoomInfo
{
  final long a = AudioHelper.c();
  public long b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public long i;
  
  AVNotifyCenter$VideoRoomInfo(AVNotifyCenter paramAVNotifyCenter) {}
  
  public boolean a()
  {
    return (this.d == 2) && (this.f == 2) && (this.g == 4) && (this.e == 0);
  }
  
  public boolean b()
  {
    return (this.d == 2) && (this.f == 2) && (this.g == 5) && (this.e == 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], relationId[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], avtype[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], roomMode[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], gameId[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("], liveExtraMode[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], memberNum[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("], event[");
    localStringBuilder.append(this.h);
    localStringBuilder.append("], time[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo
 * JD-Core Version:    0.7.0.1
 */