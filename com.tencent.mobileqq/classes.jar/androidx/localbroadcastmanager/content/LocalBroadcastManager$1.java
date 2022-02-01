package androidx.localbroadcastmanager.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class LocalBroadcastManager$1
  extends Handler
{
  LocalBroadcastManager$1(LocalBroadcastManager paramLocalBroadcastManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.localbroadcastmanager.content.LocalBroadcastManager.1
 * JD-Core Version:    0.7.0.1
 */