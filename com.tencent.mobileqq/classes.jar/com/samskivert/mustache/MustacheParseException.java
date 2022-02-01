package com.samskivert.mustache;

public class MustacheParseException
  extends MustacheException
{
  public MustacheParseException(String paramString)
  {
    super(paramString);
  }
  
  public MustacheParseException(String paramString, int paramInt)
  {
    super(paramString + " @ line " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.MustacheParseException
 * JD-Core Version:    0.7.0.1
 */