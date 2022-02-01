package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import xvv;

class VideoCompositeHelper$1
  implements Runnable
{
  VideoCompositeHelper$1(VideoCompositeHelper paramVideoCompositeHelper, PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack) {}
  
  public void run()
  {
    try
    {
      xvv.d(VideoCompositeHelper.TAG, "composite thread try get lock");
      try
      {
        xvv.c(VideoCompositeHelper.TAG, "composite thread get lock and start doComposite");
        this.this$0.doComposite(this.val$info, this.val$outPath, this.val$isClearDoodle, this.val$isLoopAudio, this.val$compositeCallBack);
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      xvv.c(VideoCompositeHelper.TAG, "do composite exception", localException);
      this.val$compositeCallBack.onVideoCompositeFinish(942012, localException.getMessage(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.1
 * JD-Core Version:    0.7.0.1
 */