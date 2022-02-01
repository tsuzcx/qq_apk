package com.tencent.mobileqq.auto.engine.loader.net;

public final class ASDataBaseInfo$ASDataBaseInfoBuilder
{
  public String a;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public boolean g;
  public String h;
  public String i;
  public long j;
  public long k;
  public boolean l;
  public long m;
  
  public static ASDataBaseInfoBuilder a()
  {
    return new ASDataBaseInfoBuilder();
  }
  
  public ASDataBaseInfoBuilder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public ASDataBaseInfoBuilder a(long paramLong)
  {
    this.j = paramLong;
    return this;
  }
  
  public ASDataBaseInfoBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public ASDataBaseInfoBuilder b(long paramLong)
  {
    this.k = paramLong;
    return this;
  }
  
  public ASDataBaseInfoBuilder b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public ASDataBaseInfo b()
  {
    ASDataBaseInfo localASDataBaseInfo = new ASDataBaseInfo();
    localASDataBaseInfo.mVersion = this.b;
    localASDataBaseInfo.mZipFileUrl = this.h;
    localASDataBaseInfo.mManagerFileUrl = this.i;
    localASDataBaseInfo.mZipFileLength = this.j;
    localASDataBaseInfo.mBusinessKey = this.a;
    localASDataBaseInfo.mQua = this.c;
    localASDataBaseInfo.mCookie = this.f;
    localASDataBaseInfo.mPluginManagerPath = this.e;
    localASDataBaseInfo.mIsInvalid = this.g;
    localASDataBaseInfo.mIsReady = this.l;
    localASDataBaseInfo.mManagerFileLength = this.k;
    localASDataBaseInfo.mUin = this.m;
    localASDataBaseInfo.mPluginZipPath = this.d;
    return localASDataBaseInfo;
  }
  
  public ASDataBaseInfoBuilder c(long paramLong)
  {
    this.m = paramLong;
    return this;
  }
  
  public ASDataBaseInfoBuilder c(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public ASDataBaseInfoBuilder d(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public ASDataBaseInfoBuilder e(String paramString)
  {
    this.i = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.net.ASDataBaseInfo.ASDataBaseInfoBuilder
 * JD-Core Version:    0.7.0.1
 */