package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

@SuppressLint({"HandlerLeak"})
class DefaultDrmSession$PostRequestHandler
  extends Handler
{
  public DefaultDrmSession$PostRequestHandler(DefaultDrmSession paramDefaultDrmSession, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private long getRetryDelayMillis(int paramInt)
  {
    return Math.min((paramInt - 1) * 1000, 5000);
  }
  
  private boolean maybeRetryRequest(Message paramMessage)
  {
    int i;
    if (paramMessage.arg1 == 1)
    {
      i = 1;
      if (i != 0) {
        break label21;
      }
    }
    label21:
    do
    {
      return false;
      i = 0;
      break;
      i = paramMessage.arg2 + 1;
    } while (i > DefaultDrmSession.access$300(this.this$0));
    paramMessage = Message.obtain(paramMessage);
    paramMessage.arg2 = i;
    sendMessageDelayed(paramMessage, getRetryDelayMillis(i));
    return true;
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 0: 
          throw new RuntimeException();
        }
      }
      catch (Exception localException)
      {
        if (maybeRetryRequest(paramMessage))
        {
          return;
          arrayOfByte = this.this$0.callback.executeProvisionRequest(this.this$0.uuid, (ExoMediaDrm.ProvisionRequest)paramMessage.obj);
        }
        this.this$0.postResponseHandler.obtainMessage(paramMessage.what, arrayOfByte).sendToTarget();
        return;
      }
      byte[] arrayOfByte = this.this$0.callback.executeKeyRequest(this.this$0.uuid, (ExoMediaDrm.KeyRequest)paramMessage.obj);
    }
  }
  
  Message obtainMessage(int paramInt, Object paramObject, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return obtainMessage(paramInt, i, 0, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSession.PostRequestHandler
 * JD-Core Version:    0.7.0.1
 */