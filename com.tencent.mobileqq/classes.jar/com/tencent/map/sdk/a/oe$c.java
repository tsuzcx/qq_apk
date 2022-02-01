package com.tencent.map.sdk.a;

import java.io.File;

public final class oe$c
  extends of.c
{
  public File a = om.a;
  public String b = "tmp";
  public oe.a c = oe.c();
  long d = -1L;
  final ny.b<oe.b> e = new oe.c.1(this);
  ny.b<File> f;
  
  public oe$c()
  {
    super(of.a.a);
  }
  
  public final c a()
  {
    this.d = 1024L;
    return this;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Options{mCacheDirectory=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mCacheName='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", fileAccessStrategy=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.oe.c
 * JD-Core Version:    0.7.0.1
 */