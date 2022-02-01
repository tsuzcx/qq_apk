package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.biz.qqstory.database.PublishVideoEntry;

class EncodeVideoTask$2$2
  implements Runnable
{
  EncodeVideoTask$2$2(EncodeVideoTask.2 param2, int paramInt, PublishVideoEntry paramPublishVideoEntry, long paramLong) {}
  
  public void run()
  {
    this.this$1.this$0.handleReportEvent(this.val$errorCode, this.val$publishVideoEntry, this.val$startMergeTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.2.2
 * JD-Core Version:    0.7.0.1
 */