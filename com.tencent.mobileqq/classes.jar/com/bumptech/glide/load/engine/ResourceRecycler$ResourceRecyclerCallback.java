package com.bumptech.glide.load.engine;

import android.os.Handler.Callback;
import android.os.Message;

final class ResourceRecycler$ResourceRecyclerCallback
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      ((Resource)paramMessage.obj).f();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.ResourceRecycler.ResourceRecyclerCallback
 * JD-Core Version:    0.7.0.1
 */