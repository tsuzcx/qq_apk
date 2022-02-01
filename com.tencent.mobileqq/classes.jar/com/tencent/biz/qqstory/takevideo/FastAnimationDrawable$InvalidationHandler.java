package com.tencent.biz.qqstory.takevideo;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class FastAnimationDrawable$InvalidationHandler
  extends Handler
{
  private final WeakReference<Drawable> a;
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (Drawable)this.a.get();
    if (paramMessage != null) {
      paramMessage.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.FastAnimationDrawable.InvalidationHandler
 * JD-Core Version:    0.7.0.1
 */