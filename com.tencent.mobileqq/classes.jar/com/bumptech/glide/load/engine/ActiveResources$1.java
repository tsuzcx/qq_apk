package com.bumptech.glide.load.engine;

import android.os.Handler.Callback;
import android.os.Message;

class ActiveResources$1
  implements Handler.Callback
{
  ActiveResources$1(ActiveResources paramActiveResources) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.a.a((ActiveResources.ResourceWeakReference)paramMessage.obj);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.ActiveResources.1
 * JD-Core Version:    0.7.0.1
 */