package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Bitmap;
import android.util.LruCache;

class TextCellLayout$RecycleCacheTag
{
  public int a = -1;
  
  public TextCellLayout$RecycleCacheTag(TextCellLayout paramTextCellLayout, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void finalize()
  {
    if (this.a > 0)
    {
      Bitmap localBitmap = (Bitmap)TextCellLayoutCache.a().b().remove(Integer.valueOf(this.a));
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.RecycleCacheTag
 * JD-Core Version:    0.7.0.1
 */