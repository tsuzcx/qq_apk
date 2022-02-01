package com.tencent.mobileqq.activity.aio.anim.egg;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Iterator;
import java.util.Queue;

class QueuedEggsAnimation$QueueDriver
  implements Runnable
{
  private QueuedEggsAnimation$QueueDriver(QueuedEggsAnimation paramQueuedEggsAnimation) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    ((QueuedEggsAnimation)localObject1).e = true;
    if ((((QueuedEggsAnimation)localObject1).f.isEmpty()) && (this.this$0.g.isEmpty()) && (this.this$0.h.isEmpty()))
    {
      localObject1 = this.this$0;
      QueuedEggsAnimation.a((QueuedEggsAnimation)localObject1, QueuedEggsAnimation.a((QueuedEggsAnimation)localObject1));
      localObject1 = this.this$0;
      ((QueuedEggsAnimation)localObject1).d = null;
      ((QueuedEggsAnimation)localObject1).e = false;
      QLog.i("QueuedEggsAnimation", 1, "[QueueDriver] queues empty.");
      return;
    }
    if ((!this.this$0.f.isEmpty()) && (this.this$0.g.size() < this.this$0.i))
    {
      localObject1 = this.this$0.f.remove();
      this.this$0.g.add(localObject1);
      this.this$0.b(localObject1);
      if ((!this.this$0.f.isEmpty()) && (this.this$0.g.size() < this.this$0.i)) {
        QueuedEggsAnimation.b(this.this$0).postDelayed(this, this.this$0.j);
      }
    }
    if (!this.this$0.h.isEmpty())
    {
      localObject1 = this.this$0.h.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        this.this$0.a(localObject2);
      }
      this.this$0.h.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.egg.QueuedEggsAnimation.QueueDriver
 * JD-Core Version:    0.7.0.1
 */