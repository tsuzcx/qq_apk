package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class TextCellLayout$SideDrawable
{
  Drawable a;
  int b;
  Rect c;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof SideDrawable)) {
        return false;
      }
      return this.b == ((SideDrawable)paramObject).b;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.SideDrawable
 * JD-Core Version:    0.7.0.1
 */