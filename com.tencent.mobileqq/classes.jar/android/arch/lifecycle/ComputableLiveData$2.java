package android.arch.lifecycle;

import android.support.annotation.WorkerThread;
import java.util.concurrent.atomic.AtomicBoolean;

class ComputableLiveData$2
  implements Runnable
{
  ComputableLiveData$2(ComputableLiveData paramComputableLiveData) {}
  
  @WorkerThread
  public void run()
  {
    int i;
    do
    {
      if (ComputableLiveData.access$100(this.this$0).compareAndSet(false, true))
      {
        Object localObject1 = null;
        i = 0;
        try
        {
          while (ComputableLiveData.access$200(this.this$0).compareAndSet(true, false))
          {
            localObject1 = this.this$0.compute();
            i = 1;
          }
          if (i != 0) {
            ComputableLiveData.access$300(this.this$0).postValue(localObject1);
          }
        }
        finally
        {
          ComputableLiveData.access$100(this.this$0).set(false);
        }
      }
      i = 0;
    } while ((i != 0) && (ComputableLiveData.access$200(this.this$0).get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.arch.lifecycle.ComputableLiveData.2
 * JD-Core Version:    0.7.0.1
 */