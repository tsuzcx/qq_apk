package com.tencent.mobileqq.ark.dict;

class StringSplitter
{
  String a;
  int b = 0;
  int c = 0;
  
  public StringSplitter(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.a = str;
    this.b = 0;
    this.c = this.a.length();
  }
  
  public String a(int paramInt)
  {
    int i = this.b;
    if (i >= this.c) {
      return "";
    }
    try
    {
      paramInt = this.a.offsetByCodePoints(i, paramInt);
      str = this.a.substring(this.b, paramInt);
      this.b = paramInt;
      return str;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      String str;
      label46:
      break label46;
    }
    str = this.a.substring(this.b);
    this.b = this.c;
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.StringSplitter
 * JD-Core Version:    0.7.0.1
 */