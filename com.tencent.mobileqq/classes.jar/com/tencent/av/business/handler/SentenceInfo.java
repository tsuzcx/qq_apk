package com.tencent.av.business.handler;

public class SentenceInfo
{
  public String a;
  public CharSequence b;
  public CharSequence c;
  public int d;
  public boolean e = false;
  
  public SentenceInfo(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    this.a = paramString;
    this.b = paramCharSequence1;
    this.c = paramCharSequence2;
    this.d = paramInt;
  }
  
  public boolean a()
  {
    return this.d == 2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SentenceInfo{uin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", src_text='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tra_text='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.SentenceInfo
 * JD-Core Version:    0.7.0.1
 */