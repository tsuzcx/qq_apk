package androidx.core.provider;

import android.os.Handler.Callback;
import android.os.Message;

class SelfDestructiveThread$1
  implements Handler.Callback
{
  SelfDestructiveThread$1(SelfDestructiveThread paramSelfDestructiveThread) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      this.this$0.onInvokeRunnable((Runnable)paramMessage.obj);
      return true;
    }
    this.this$0.onDestruction();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.provider.SelfDestructiveThread.1
 * JD-Core Version:    0.7.0.1
 */