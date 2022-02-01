package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;

class VideoCompositeManager$1$1
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  VideoCompositeManager$1$1(VideoCompositeManager.1 param1, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    ThreadManager.postImmediately(new VideoCompositeManager.1.1.1(this, paramInt, paramString1, paramString2), null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager.1.1
 * JD-Core Version:    0.7.0.1
 */