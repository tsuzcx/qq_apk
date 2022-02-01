package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.graphics.Bitmap;
import java.util.List;

class DigitLottieAnimation$3
  implements Runnable
{
  DigitLottieAnimation$3(DigitLottieAnimation paramDigitLottieAnimation) {}
  
  public void run()
  {
    if (!DigitLottieAnimation.a(this.this$0).isEmpty())
    {
      int i = 0;
      while (i < DigitLottieAnimation.a(this.this$0).size())
      {
        Bitmap localBitmap = (Bitmap)DigitLottieAnimation.a(this.this$0).get(i);
        if (localBitmap != null)
        {
          localBitmap.recycle();
          DigitLottieAnimation.a(this.this$0).set(i, null);
        }
        i += 1;
      }
      DigitLottieAnimation.a(this.this$0).clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.DigitLottieAnimation.3
 * JD-Core Version:    0.7.0.1
 */