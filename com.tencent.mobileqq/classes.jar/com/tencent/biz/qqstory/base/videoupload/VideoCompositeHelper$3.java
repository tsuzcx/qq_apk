package com.tencent.biz.qqstory.base.videoupload;

import aanb;
import boiw;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import ykq;
import zeb;

class VideoCompositeHelper$3
  extends boiw
{
  private long mStartTime;
  
  VideoCompositeHelper$3(VideoCompositeHelper paramVideoCompositeHelper, PublishVideoEntry paramPublishVideoEntry, VideoCompositeHelper.RetCode paramRetCode, String paramString) {}
  
  public void onCancel(String paramString)
  {
    this.val$code.setCode(-3);
    this.val$code.setMessage("task canceled");
    VideoCompositeHelper.access$000(this.this$0, "needAndStartDownloadMusic");
  }
  
  public void onFinish(String paramString, boolean paramBoolean, int paramInt)
  {
    ykq.c(VideoCompositeHelper.TAG, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " music onStart download onFinish ");
    this.val$info.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.mStartTime;
    switch (paramInt)
    {
    default: 
      this.val$code.setCode(paramInt);
      this.val$code.setMessage("unknown error the music download failed");
    }
    for (;;)
    {
      aanb.a("edit_music_download", aanb.a(this.val$code.getCode(), l1 - l2, this.val$musicNeedDownloadUrl, zeb.a(paramString)));
      VideoCompositeHelper.access$000(this.this$0, "needAndStartDownloadMusic");
      return;
      this.val$code.setCode(0);
      this.val$code.setMessage("music downloadSuccess");
      continue;
      this.val$code.setCode(-2);
      this.val$code.setMessage("none network");
    }
  }
  
  public void onNetChange(int paramInt) {}
  
  public void onProgress(String paramString, int paramInt) {}
  
  public void onStart(String paramString, boolean paramBoolean)
  {
    ykq.c(VideoCompositeHelper.TAG, "[vs_publish_flow] | fakeid:" + this.val$info.fakeVid + " music onStart download");
    this.mStartTime = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.3
 * JD-Core Version:    0.7.0.1
 */