package com.tencent.biz.qqcircle.publish.queue;

import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.NetworkState;
import java.util.concurrent.CopyOnWriteArrayList;

class QCircleTaskQueue$4
  implements Runnable
{
  QCircleTaskQueue$4(QCircleTaskQueue paramQCircleTaskQueue) {}
  
  public void run()
  {
    if (!NetworkState.isNetSupport()) {
      return;
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = this.this$0.h();
    if (localCopyOnWriteArrayList != null)
    {
      int j = localCopyOnWriteArrayList.size();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkRetry taskList size:");
      ((StringBuilder)localObject).append(j);
      QLog.i("[upload2_outbox_QCircleTaskQueue]", 1, ((StringBuilder)localObject).toString());
      int i = 0;
      while (i < j)
      {
        localObject = (IQueueTask)localCopyOnWriteArrayList.get(i);
        if ((QCircleTaskQueue.a(this.this$0, (IQueueTask)localObject)) && (QCircleTaskQueue.b(this.this$0, (IQueueTask)localObject)) && (!this.this$0.c((IQueueTask)localObject, true))) {
          this.this$0.d((IQueueTask)localObject);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue.4
 * JD-Core Version:    0.7.0.1
 */