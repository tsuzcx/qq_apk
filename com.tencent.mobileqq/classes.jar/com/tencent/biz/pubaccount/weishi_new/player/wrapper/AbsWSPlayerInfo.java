package com.tencent.biz.pubaccount.weishi_new.player.wrapper;

public abstract class AbsWSPlayerInfo<U, V>
{
  public String a;
  public String b;
  public int c;
  public int d;
  public long e;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i;
  
  public abstract V a();
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.e = paramLong;
    this.d = paramInt2;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    this.h = paramBoolean3;
    this.i = paramBoolean4;
  }
  
  public abstract V b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.AbsWSPlayerInfo
 * JD-Core Version:    0.7.0.1
 */