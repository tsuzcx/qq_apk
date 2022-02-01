package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"HandlerLeak"})
class DefaultDrmSessionManager$MediaDrmHandler
  extends Handler
{
  public DefaultDrmSessionManager$MediaDrmHandler(DefaultDrmSessionManager paramDefaultDrmSessionManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    byte[] arrayOfByte = (byte[])paramMessage.obj;
    Iterator localIterator = DefaultDrmSessionManager.access$300(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      DefaultDrmSession localDefaultDrmSession = (DefaultDrmSession)localIterator.next();
      if (localDefaultDrmSession.hasSessionId(arrayOfByte)) {
        localDefaultDrmSession.onMediaDrmEvent(paramMessage.what);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSessionManager.MediaDrmHandler
 * JD-Core Version:    0.7.0.1
 */