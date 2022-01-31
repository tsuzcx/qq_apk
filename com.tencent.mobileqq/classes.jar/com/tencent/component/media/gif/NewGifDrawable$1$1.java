package com.tencent.component.media.gif;

import com.tencent.component.media.utils.ImageManagerLog;

class NewGifDrawable$1$1
  extends SafeRunnable
{
  NewGifDrawable$1$1(NewGifDrawable.1 param1, NewGifDrawable paramNewGifDrawable)
  {
    super(paramNewGifDrawable);
  }
  
  public void doWork()
  {
    ImageManagerLog.e("NewGifDrawable", "reset");
    if (this.this$1.this$0.mGifDecoder.reset()) {
      this.this$1.this$0.start();
    }
    NewGifDrawable.access$102(this.this$1.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDrawable.1.1
 * JD-Core Version:    0.7.0.1
 */