package com.tencent.mobileqq.activity.shortvideo;

import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.qphone.base.util.QLog;

class EncodeVideoTask$1
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  EncodeVideoTask$1(EncodeVideoTask paramEncodeVideoTask, PublishVideoEntry paramPublishVideoEntry, String paramString, long paramLong) {}
  
  public void onVideoCompositeFinish(int paramInt, String paramString1, String paramString2)
  {
    if (EncodeVideoTask.access$000(this.this$0)) {}
    for (int i = -24;; i = paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "onVideoCompositeFinish isCancel:" + EncodeVideoTask.access$000(this.this$0) + ", errCode:" + paramInt);
      }
      this.this$0.isEncodeFinish = true;
      EncodeVideoTask.access$100(this.this$0).onStoryMergeCompleted(i, paramString1, this.val$publishVideoEntry, this.val$targetPath, this.val$startMergeTime);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.1
 * JD-Core Version:    0.7.0.1
 */