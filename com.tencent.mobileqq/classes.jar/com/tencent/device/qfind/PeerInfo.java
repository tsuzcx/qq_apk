package com.tencent.device.qfind;

import java.util.List;

public class PeerInfo
{
  private static int o;
  public int a;
  public String b;
  public String c;
  public byte[] d;
  public List<String> e;
  public int f;
  public boolean g;
  public boolean h;
  public boolean i;
  public long j;
  public long k;
  public int l = 0;
  public int m = 0;
  public boolean n = false;
  
  public PeerInfo()
  {
    o += 1;
    this.a = o;
    this.g = false;
    this.h = false;
    this.j = 0L;
    this.f = 0;
    this.k = 0L;
    this.l = 0;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.replaceAll(":", ""));
    localStringBuilder.append("0000");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.PeerInfo
 * JD-Core Version:    0.7.0.1
 */