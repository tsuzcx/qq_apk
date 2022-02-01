package com.tencent.av.business.handler;

import com.tencent.avcore.jni.data.NetAddr;
import java.util.List;

public class AudioTransClientInfoHandlerExtend$InfoInterfaceData
{
  private static InfoInterfaceData e = new InfoInterfaceData();
  public int a;
  public long b;
  public int c;
  public List<NetAddr> d;
  
  public static InfoInterfaceData a()
  {
    return e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mChannelType[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], mSessionId[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], mTransType[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.AudioTransClientInfoHandlerExtend.InfoInterfaceData
 * JD-Core Version:    0.7.0.1
 */