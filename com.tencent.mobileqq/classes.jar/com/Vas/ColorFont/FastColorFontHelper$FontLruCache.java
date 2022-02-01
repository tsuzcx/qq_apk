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
    FastColorFontLog.a("FastColorFontHelper", "release start font " + paramString1);
    this.a.a(paramInteger.intValue());
    FastColorFontCache.a(paramInteger.intValue());
    FastColorFontLog.a("FastColorFontHelper", "release end   font " + paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.Vas.ColorFont.FastColorFontHelper.FontLruCache
 * JD-Core Version:    0.7.0.1
 */