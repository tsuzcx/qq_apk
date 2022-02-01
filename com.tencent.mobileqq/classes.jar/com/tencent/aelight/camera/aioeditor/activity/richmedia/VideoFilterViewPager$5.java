package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aelight.camera.struct.camera.AEPhotoAIResult;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class VideoFilterViewPager$5
  implements Runnable
{
  VideoFilterViewPager$5(VideoFilterViewPager paramVideoFilterViewPager, Bitmap paramBitmap) {}
  
  public void run()
  {
    VideoFilterViewPager.c(this.this$0).updateLutGL(VideoFilterViewPager.d(this.this$0).a());
    VideoFilterViewPager.c(this.this$0).updateLutAlpha((int)(VideoFilterViewPager.d(this.this$0).c() * 100.0F));
    VideoFilterViewPager.c(this.this$0).setSmoothLevel((int)(VideoFilterViewPager.d(this.this$0).d() * 100.0F));
    VideoFilterViewPager.c(this.this$0).setGlowAlpha(VideoFilterViewPager.d(this.this$0).e());
    VideoFilterViewPager.c(this.this$0).setPicNeedFlipBeforeRender(true);
    GlUtil.loadTexture(VideoFilterViewPager.i(this.this$0), this.a);
    Bitmap localBitmap = GlUtil.saveTexture(VideoFilterViewPager.c(this.this$0).drawFrame(VideoFilterViewPager.i(this.this$0), true, 0L), this.a.getWidth(), this.a.getHeight());
    ThreadManager.getUIHandler().post(new VideoFilterViewPager.5.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.5
 * JD-Core Version:    0.7.0.1
 */