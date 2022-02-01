package com.tencent.component.media.photogif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class NewAnimationDrawable$1
  extends Handler
{
  NewAnimationDrawable$1(NewAnimationDrawable paramNewAnimationDrawable, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      NewAnimationDrawable.access$102(this.this$0, NewAnimationDrawable.access$200(this.this$0));
      this.this$0.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.photogif.NewAnimationDrawable.1
 * JD-Core Version:    0.7.0.1
 */