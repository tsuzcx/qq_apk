package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

class TextCellLayout$4
  implements QzoneFontManager.OnFontLoadListener
{
  TextCellLayout$4(TextCellLayout paramTextCellLayout, int paramInt) {}
  
  public void a(Typeface paramTypeface)
  {
    if (TextCellLayout.b(this.b) != this.a) {
      return;
    }
    if (paramTypeface != null) {
      new Handler(Looper.getMainLooper()).post(new TextCellLayout.4.1(this, paramTypeface));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.4
 * JD-Core Version:    0.7.0.1
 */