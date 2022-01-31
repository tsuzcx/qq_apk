package com.tencent.av.report;

import java.io.Serializable;

public class VideoSerializeData
  implements Serializable
{
  int errCode;
  long fromUin;
  long msgSeq;
  long msgType;
  long time;
  long toUin;
  String type;
  
  public VideoSerializeData(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt)
  {
    this.type = paramString;
    this.msgType = paramLong1;
    this.msgSeq = paramLong2;
    this.time = paramLong3;
    this.toUin = paramLong4;
    this.fromUin = paramLong5;
    this.errCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.report.VideoSerializeData
 * JD-Core Version:    0.7.0.1
 */