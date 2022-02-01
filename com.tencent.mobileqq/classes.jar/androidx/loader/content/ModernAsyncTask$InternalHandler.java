package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ModernAsyncTask$InternalHandler
  extends Handler
{
  ModernAsyncTask$InternalHandler()
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    ModernAsyncTask.AsyncTaskResult localAsyncTaskResult = (ModernAsyncTask.AsyncTaskResult)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      localAsyncTaskResult.mTask.finish(localAsyncTaskResult.mData[0]);
      return;
    }
    localAsyncTaskResult.mTask.onProgressUpdate(localAsyncTaskResult.mData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.loader.content.ModernAsyncTask.InternalHandler
 * JD-Core Version:    0.7.0.1
 */