package com.tencent.avgame.qav;

public class AVGameMediaFileInfo
{
  public String a;
  public int b;
  public long c;
  public long d;
  public String e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVGameMediaFileInfo{mMediaFileUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMediaFormat=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mMediaFileDuration=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mMediaFileSize=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mMediaFileMd5='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameMediaFileInfo
 * JD-Core Version:    0.7.0.1
 */