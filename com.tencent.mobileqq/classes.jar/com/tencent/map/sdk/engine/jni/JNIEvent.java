package com.tencent.map.sdk.engine.jni;

import java.util.Arrays;

public class JNIEvent
{
  public byte[] data;
  public Object extra;
  public int id;
  public String name;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("JNIEvent{id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", data=");
    localStringBuilder.append(Arrays.toString(this.data));
    localStringBuilder.append(", extra=");
    localStringBuilder.append(this.extra);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.engine.jni.JNIEvent
 * JD-Core Version:    0.7.0.1
 */