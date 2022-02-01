package com.tencent.mobileqq.ar.arengine;

public class ARCloudRecogRspFaceResult$StarInfo
{
  public long a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public float h;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StarInfo{faceID=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pinyin_name='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wiki='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wikiTitle='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wikiURL='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", confidence='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult.StarInfo
 * JD-Core Version:    0.7.0.1
 */