package com.tencent.mobileqq.app.face;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

class FaceDecodeTask$FaceDecodeRunnable
  implements Runnable
{
  private boolean isRunning = true;
  
  public void close()
  {
    this.isRunning = false;
  }
  
  public void run()
  {
    Object localObject1 = Thread.currentThread();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("FaceDecodeThread");
    ((StringBuilder)localObject3).append(((Thread)localObject1).getId());
    ((Thread)localObject1).setName(((StringBuilder)localObject3).toString());
    localObject1 = BaseApplication.processName;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals("com.tencent.mobileqq"))) {
      Process.setThreadPriority(-8);
    } else if (FaceDecodeTask.access$200().priority != -2147483648) {
      Process.setThreadPriority(FaceDecodeTask.access$200().priority);
    }
    localObject1 = null;
    while (this.isRunning) {
      synchronized (FaceDecodeTask.mDecodeQueue)
      {
        int i = FaceDecodeTask.mDecodeQueue.size();
        if (i == 0) {}
        try
        {
          FaceDecodeTask.mDecodeQueue.wait();
          localObject3 = localObject1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            Object localObject4 = localObject2;
          }
        }
        localObject3 = (FaceDecodeTask)FaceDecodeTask.mDecodeQueue.remove(0);
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          ((FaceDecodeTask)localObject3).doDecodeBitmap();
          localObject1 = localObject3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecodeTask.FaceDecodeRunnable
 * JD-Core Version:    0.7.0.1
 */