package com.Vas.ColorFont;

import android.util.LruCache;

class FastColorFontHelper$FontLruCache
  extends LruCache<Integer, String>
{
  public FastColorFontHelper$FontLruCache(FastColorFontHelper paramFastColorFontHelper, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, Integer paramInteger, String paramString1, String paramString2)
  {
    super.entryRemoved(paramBoolean, paramInteger, paramString1, paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("release start font ");
    paramString2.append(paramString1);
    FastColorFontLog.a("FastColorFontHelper", paramString2.toString());
    this.a.a(paramInteger.intValue());
    FastColorFontCache.a(paramInteger.intValue());
    paramInteger = new StringBuilder();
    paramInteger.append("release end   font ");
    paramInteger.append(paramString1);
    FastColorFontLog.a("FastColorFontHelper", paramInteger.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FastColorFontHelper.FontLruCache
 * JD-Core Version:    0.7.0.1
 */