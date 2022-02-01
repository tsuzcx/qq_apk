package com.bumptech.glide.load.engine;

import android.os.Handler.Callback;
import android.os.Message;

class EngineJob$MainThreadCallback
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = (EngineJob)paramMessage.obj;
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          ((EngineJob)localObject).e();
          return true;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unrecognized message: ");
        ((StringBuilder)localObject).append(paramMessage.what);
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
      ((EngineJob)localObject).f();
      return true;
    }
    ((EngineJob)localObject).c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.EngineJob.MainThreadCallback
 * JD-Core Version:    0.7.0.1
 */