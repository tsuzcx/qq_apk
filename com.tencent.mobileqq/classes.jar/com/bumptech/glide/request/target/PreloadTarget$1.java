package com.bumptech.glide.request.target;

import android.os.Handler.Callback;
import android.os.Message;

class PreloadTarget$1
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      ((PreloadTarget)paramMessage.obj).b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.PreloadTarget.1
 * JD-Core Version:    0.7.0.1
 */