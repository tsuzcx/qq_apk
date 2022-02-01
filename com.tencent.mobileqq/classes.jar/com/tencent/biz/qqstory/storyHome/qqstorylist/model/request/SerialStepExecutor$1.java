package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.ConcurrentLinkedQueue;

class SerialStepExecutor$1
  implements Runnable
{
  SerialStepExecutor$1(SerialStepExecutor paramSerialStepExecutor) {}
  
  public void run()
  {
    if (SerialStepExecutor.a(this.this$0).size() == 0)
    {
      if (this.this$0.h != null) {
        this.this$0.h.a();
      }
      SerialStepExecutor.a(this.this$0, 2);
      this.this$0.h();
      return;
    }
    Object localObject = this.this$0;
    ((SerialStepExecutor)localObject).a = ((Step)SerialStepExecutor.a((SerialStepExecutor)localObject).poll());
    if (this.this$0.a == null)
    {
      if (this.this$0.h != null) {
        this.this$0.h.a();
      }
      SerialStepExecutor.a(this.this$0, 2);
      this.this$0.h();
      return;
    }
    this.this$0.a.e();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("剩下step:");
    ((StringBuilder)localObject).append(SerialStepExecutor.a(this.this$0).size());
    SLog.b("Q.qqstory.home.SerialStepExecutor", ((StringBuilder)localObject).toString());
    this.this$0.a.a(this.this$0);
    this.this$0.a.a(this.this$0);
    if (this.this$0.c == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("step:");
      ((StringBuilder)localObject).append(this.this$0.a.c());
      ((StringBuilder)localObject).append(",return null result");
      SLog.e("Q.qqstory.home.SerialStepExecutor", ((StringBuilder)localObject).toString());
    }
    this.this$0.a.a(this.this$0.c);
    this.this$0.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SerialStepExecutor.1
 * JD-Core Version:    0.7.0.1
 */