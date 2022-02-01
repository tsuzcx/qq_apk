package com.tencent.mobileqq.app.msgcache;

public class MsgLruCache$MsgCacheInfo
{
  public int a;
  public int b;
  public String c;
  public int d;
  
  public MsgLruCache$MsgCacheInfo(MsgLruCache paramMsgLruCache, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramString;
    this.d = paramInt1;
    this.a = paramInt2;
    this.b = paramInt3;
  }
  
  public String toString()
  {
    String str;
    if (this.a == CacheConstants.g) {
      str = "A";
    } else {
      str = "B";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(this.d);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgcache.MsgLruCache.MsgCacheInfo
 * JD-Core Version:    0.7.0.1
 */