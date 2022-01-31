package com.tencent.component.media.gif;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class InvalidationHandler
  extends Handler
{
  private final WeakReference a;
  
  public InvalidationHandler(Drawable paramDrawable)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramDrawable);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (Drawable)this.a.get();
    if (paramMessage != null) {
      paramMessage.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.gif.InvalidationHandler
 * JD-Core Version:    0.7.0.1
 */