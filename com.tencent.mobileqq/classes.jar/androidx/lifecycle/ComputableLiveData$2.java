package androidx.lifecycle;

import androidx.annotation.WorkerThread;
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
      if (this.this$0.mComputing.compareAndSet(false, true))
      {
        Object localObject1 = null;
        i = 0;
        try
        {
          while (this.this$0.mInvalid.compareAndSet(true, false))
          {
            localObject1 = this.this$0.compute();
            i = 1;
          }
          if (i != 0) {
            this.this$0.mLiveData.postValue(localObject1);
          }
        }
        finally
        {
          this.this$0.mComputing.set(false);
        }
      }
      i = 0;
    } while ((i != 0) && (this.this$0.mInvalid.get()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.lifecycle.ComputableLiveData.2
 * JD-Core Version:    0.7.0.1
 */