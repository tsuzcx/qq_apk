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
    if (this.jdField_a_of_type_Int == CacheConstants.c) {}
    for (String str = "A";; str = "B") {
      return this.jdField_a_of_type_JavaLangString + "_" + this.c + "_" + str + "_" + this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgcache.MsgLruCache.MsgCacheInfo
 * JD-Core Version:    0.7.0.1
 */