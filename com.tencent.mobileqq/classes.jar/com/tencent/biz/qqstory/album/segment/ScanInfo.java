package com.tencent.biz.qqstory.album.segment;

public class ScanInfo
{
  public String a = "";
  public String b = "";
  private long c = -1L;
  private long d = -1L;
  private boolean e;
  
  public long a()
  {
    return this.c;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public void b(long paramLong)
  {
    this.d = paramLong;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScanInfo{lastAlbum=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", lastPic=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isIncScan=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.segment.ScanInfo
 * JD-Core Version:    0.7.0.1
 */