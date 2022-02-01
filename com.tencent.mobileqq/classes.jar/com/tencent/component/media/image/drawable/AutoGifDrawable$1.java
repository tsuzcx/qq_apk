package com.tencent.component.media.image.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.util.Log;
import com.tencent.component.media.utils.ImageManagerLog;

class AutoGifDrawable$1
  implements Drawable.Callback
{
  AutoGifDrawable$1(AutoGifDrawable paramAutoGifDrawable) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    try
    {
      if (this.this$0.autoGifCallback != null)
      {
        this.this$0.autoGifCallback.invalidateGifView();
        return;
      }
    }
    catch (Throwable paramDrawable)
    {
      String str = AutoGifDrawable.access$100();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalidateDrawable,catch an exception:");
      localStringBuilder.append(Log.getStackTraceString(paramDrawable));
      ImageManagerLog.w(str, localStringBuilder.toString());
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.AutoGifDrawable.1
 * JD-Core Version:    0.7.0.1
 */