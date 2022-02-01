package com.google.protobuf;

public class TextFormat$UnknownFieldParseException
  extends TextFormat.ParseException
{
  private final String unknownField;
  
  public TextFormat$UnknownFieldParseException(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    super(paramInt1, paramInt2, paramString2);
    this.unknownField = paramString1;
  }
  
  public TextFormat$UnknownFieldParseException(String paramString)
  {
    this(-1, -1, "", paramString);
  }
  
  public String getUnknownField()
  {
    return this.unknownField;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.TextFormat.UnknownFieldParseException
 * JD-Core Version:    0.7.0.1
 */