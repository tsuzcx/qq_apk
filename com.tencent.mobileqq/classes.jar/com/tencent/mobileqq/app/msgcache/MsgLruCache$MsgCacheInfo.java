package com.tencent.mobileqq.app.msgcache;

public class MsgLruCache$MsgCacheInfo
{
  public int a;
  public String a;
  public int b;
  public int c;
  
  public MsgLruCache$MsgCacheInfo(MsgLruCache paramMsgLruCache, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.b = paramInt3;
  }
  
  public String toString()
  {
    String str;
    if (this.jdField_a_of_type_Int == CacheConstants.c) {
      str = "A";
    } else {
      str = "B";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(this.c);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgcache.MsgLruCache.MsgCacheInfo
 * JD-Core Version:    0.7.0.1
 */