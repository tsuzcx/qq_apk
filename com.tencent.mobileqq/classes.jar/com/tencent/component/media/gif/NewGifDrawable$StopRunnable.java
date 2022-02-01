package com.tencent.component.media.gif;

import android.util.Log;
import com.tencent.component.media.utils.ImageManagerLog;

class NewGifDrawable$StopRunnable
  implements Runnable
{
  private NewGifDrawable$StopRunnable(NewGifDrawable paramNewGifDrawable) {}
  
  public void run()
  {
    NewGifDrawable.access$000(this.this$0);
    try
    {
      this.this$0.mGifDecoder.stop();
      return;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerLog.e("NewGifDrawable", Log.getStackTraceString(localThrowable));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.gif.NewGifDrawable.StopRunnable
 * JD-Core Version:    0.7.0.1
 */