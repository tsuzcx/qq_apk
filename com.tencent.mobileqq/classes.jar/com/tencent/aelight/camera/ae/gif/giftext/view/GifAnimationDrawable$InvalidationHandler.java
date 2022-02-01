package com.tencent.aelight.camera.ae.gif.giftext.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class GifAnimationDrawable$InvalidationHandler
  extends Handler
{
  private final WeakReference<GifAnimationDrawable> a;
  
  public GifAnimationDrawable$InvalidationHandler(GifAnimationDrawable paramGifAnimationDrawable)
  {
    super(Looper.getMainLooper());
    this.a = new WeakReference(paramGifAnimationDrawable);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return;
    }
    GifAnimationDrawable localGifAnimationDrawable = (GifAnimationDrawable)this.a.get();
    if (localGifAnimationDrawable != null) {
      GifAnimationDrawable.a(localGifAnimationDrawable, (GifAnimationDrawable.Frame)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.view.GifAnimationDrawable.InvalidationHandler
 * JD-Core Version:    0.7.0.1
 */