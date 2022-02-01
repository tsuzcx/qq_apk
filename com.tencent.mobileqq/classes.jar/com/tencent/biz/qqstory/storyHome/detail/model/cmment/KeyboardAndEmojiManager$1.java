package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class KeyboardAndEmojiManager$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean b;
  private int c;
  private Rect d = new Rect();
  
  KeyboardAndEmojiManager$1(KeyboardAndEmojiManager paramKeyboardAndEmojiManager) {}
  
  public void onGlobalLayout()
  {
    KeyboardAndEmojiManager.a(this.a).getWindowVisibleDisplayFrame(this.d);
    int i = this.d.bottom - this.d.top;
    if (i != this.c)
    {
      int j = KeyboardAndEmojiManager.a(this.a).getRootView().getHeight();
      if (j - i > j / 4)
      {
        this.b = true;
        KeyboardAndEmojiManager.b(this.a);
      }
      else if (this.b)
      {
        KeyboardAndEmojiManager.c(this.a);
      }
      this.c = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.KeyboardAndEmojiManager.1
 * JD-Core Version:    0.7.0.1
 */