package com.tencent.ark.open.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.ark.Logger;
import java.lang.ref.WeakReference;

public class WeakReferenceHandler
  extends Handler
{
  private final WeakReference<Handler.Callback> mWeakReferCallback;
  
  public WeakReferenceHandler(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.mWeakReferCallback = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.mWeakReferCallback.get();
    if (localCallback != null)
    {
      localCallback.handleMessage(paramMessage);
      return;
    }
    paramMessage = new StringBuilder();
    paramMessage.append("handleMessage cb is null! handler = ");
    paramMessage.append(this);
    Logger.logD("WeakReferenceHandler", paramMessage.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.internal.WeakReferenceHandler
 * JD-Core Version:    0.7.0.1
 */