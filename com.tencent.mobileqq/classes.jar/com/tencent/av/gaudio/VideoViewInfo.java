package com.tencent.av.gaudio;

public class VideoViewInfo
{
  public long a;
  public int b = 0;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public long g = 4L;
  public String h = "";
  public boolean i = false;
  public boolean j = false;
  public boolean k = false;
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof VideoViewInfo)))
    {
      paramObject = (VideoViewInfo)paramObject;
      if (this.a == paramObject.a) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Uin[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], VideoSrcType[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], isBig[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("], isRender[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], isNeedRequest[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], hasRecvData[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], inviteId[");
    localStringBuilder.append(this.h);
    localStringBuilder.append("], isMirror[");
    localStringBuilder.append(this.k);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.VideoViewInfo
 * JD-Core Version:    0.7.0.1
 */