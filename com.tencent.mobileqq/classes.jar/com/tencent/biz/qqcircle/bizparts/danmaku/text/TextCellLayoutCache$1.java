package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Bitmap;
import android.util.LruCache;

class TextCellLayoutCache$1
  extends LruCache<Integer, Bitmap>
{
  TextCellLayoutCache$1(TextCellLayoutCache paramTextCellLayoutCache, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(Integer paramInteger, Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayoutCache.1
 * JD-Core Version:    0.7.0.1
 */