package com.samskivert.mustache;

public class MustacheException$Context
  extends MustacheException
{
  public final String key;
  public final int lineNo;
  
  public MustacheException$Context(String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
    this.key = paramString2;
    this.lineNo = paramInt;
  }
  
  public MustacheException$Context(String paramString1, String paramString2, int paramInt, Throwable paramThrowable)
  {
    super(paramString1, paramThrowable);
    this.key = paramString2;
    this.lineNo = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.MustacheException.Context
 * JD-Core Version:    0.7.0.1
 */