package androidx.core.provider;

import android.os.Handler;
import java.util.concurrent.Callable;

class SelfDestructiveThread$2
  implements Runnable
{
  SelfDestructiveThread$2(SelfDestructiveThread paramSelfDestructiveThread, Callable paramCallable, Handler paramHandler, SelfDestructiveThread.ReplyCallback paramReplyCallback) {}
  
  public void run()
  {
    try
    {
      localObject = this.val$callable.call();
    }
    catch (Exception localException)
    {
      Object localObject;
      label13:
      break label13;
    }
    localObject = null;
    this.val$callingHandler.post(new SelfDestructiveThread.2.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.provider.SelfDestructiveThread.2
 * JD-Core Version:    0.7.0.1
 */