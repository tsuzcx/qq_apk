package com.tencent.mobileqq.ar.arengine;

public class ARCloudReqFileInfo
{
  public String a = "";
  public int b = -1;
  public int c;
  public int d;
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCloudReqFileInfo{fileName='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileFormat=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", previewPath='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo
 * JD-Core Version:    0.7.0.1
 */