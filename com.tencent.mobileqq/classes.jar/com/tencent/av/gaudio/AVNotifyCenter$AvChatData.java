package com.tencent.av.gaudio;

class AVNotifyCenter$AvChatData
{
  final String a;
  boolean b = true;
  int c = 0;
  int d = 0;
  String e = null;
  String f = null;
  boolean g = false;
  long h = 0L;
  int i = 0;
  boolean j = false;
  boolean k = false;
  boolean l = false;
  
  AVNotifyCenter$AvChatData(AVNotifyCenter paramAVNotifyCenter, String paramString, long paramLong)
  {
    paramAVNotifyCenter = new StringBuilder();
    paramAVNotifyCenter.append("AvChatData_");
    paramAVNotifyCenter.append(paramString);
    paramAVNotifyCenter.append("_");
    paramAVNotifyCenter.append(paramLong);
    this.a = paramAVNotifyCenter.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mRelationId[");
    localStringBuilder.append(this.h);
    localStringBuilder.append("], mRelationType[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("], mUinType[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], mPeerUin[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], mIsChating[");
    localStringBuilder.append(this.k);
    localStringBuilder.append("], mIsWaitting[");
    localStringBuilder.append(this.j);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.AvChatData
 * JD-Core Version:    0.7.0.1
 */