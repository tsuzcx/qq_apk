package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

@SuppressLint({"HandlerLeak"})
class DefaultDrmSession$PostResponseHandler
  extends Handler
{
  public DefaultDrmSession$PostResponseHandler(DefaultDrmSession paramDefaultDrmSession, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      DefaultDrmSession.access$100(this.this$0, paramMessage.obj);
      return;
    }
    DefaultDrmSession.access$200(this.this$0, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSession.PostResponseHandler
 * JD-Core Version:    0.7.0.1
 */