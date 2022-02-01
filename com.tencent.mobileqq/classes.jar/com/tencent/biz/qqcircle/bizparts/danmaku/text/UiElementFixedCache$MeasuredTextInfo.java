package com.tencent.biz.qqcircle.bizparts.danmaku.text;

class UiElementFixedCache$MeasuredTextInfo
{
  public int a;
  public int b;
  public String c;
  
  public UiElementFixedCache$MeasuredTextInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (getClass() == paramObject.getClass())
    {
      paramObject = (MeasuredTextInfo)paramObject;
      return (this.a == paramObject.a) && (this.b == paramObject.b) && (this.c.equals(paramObject.c));
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.a;
    int k = this.b;
    String str = this.c;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return j + k + i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.UiElementFixedCache.MeasuredTextInfo
 * JD-Core Version:    0.7.0.1
 */