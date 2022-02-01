package com.tencent.av.wtogether.data;

public class WTReqUrlResult
{
  public final int a;
  public final long b;
  public final int c;
  public final WTFileInfo d;
  public final boolean e;
  public final int f;
  public boolean g;
  public String h;
  public String i;
  public int j;
  public String k;
  public boolean l;
  
  public WTReqUrlResult(int paramInt1, long paramLong, int paramInt2, WTFileInfo paramWTFileInfo, int paramInt3, boolean paramBoolean)
  {
    this.a = paramInt1;
    this.b = paramLong;
    this.c = paramInt2;
    this.d = paramWTFileInfo;
    this.f = paramInt3;
    this.e = paramBoolean;
    this.h = null;
    this.i = null;
    this.j = -1;
    this.k = null;
    this.l = false;
    this.g = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReqUrlResult{seq: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",  fileInfo: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", retryCnt: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", needHttpsUrl: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", url: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", cookie: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", errCode: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", errMsg: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", isSuccess: ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", retry: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.data.WTReqUrlResult
 * JD-Core Version:    0.7.0.1
 */