package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import java.util.TimerTask;

class TaskManager$25$1
  extends TimerTask
{
  TaskManager$25$1(TaskManager.25 param25, JSContext paramJSContext, String paramString) {}
  
  public void run()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.val$jsContext != null)
    {
      this.val$jsContext.evaluteStringWithException(this.val$func, localStringBuffer);
      TaskManager.access$1100(this.this$1.this$0, localStringBuffer, this.this$1.val$task, this.val$func);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.25.1
 * JD-Core Version:    0.7.0.1
 */