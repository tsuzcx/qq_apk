package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.graphics.Bitmap;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aelight.camera.struct.camera.AEPhotoAIResult;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class VideoFilterViewPager$4
  implements Runnable
{
  VideoFilterViewPager$4(VideoFilterViewPager paramVideoFilterViewPager, Bitmap paramBitmap) {}
  
  public void run()
  {
    VideoFilterViewPager.a(this.this$0).updateLutGL(VideoFilterViewPager.a(this.this$0).a());
    VideoFilterViewPager.a(this.this$0).setLookupLevel((int)(VideoFilterViewPager.a(this.this$0).a() * 100.0F));
    VideoFilterViewPager.a(this.this$0).setSmoothLevel((int)(VideoFilterViewPager.a(this.this$0).b() * 100.0F));
    VideoFilterViewPager.a(this.this$0).setGlowAlpha(VideoFilterViewPager.a(this.this$0).c());
    VideoFilterViewPager.a(this.this$0).setPicNeedFlipBeforeRender(true);
    GlUtil.loadTexture(VideoFilterViewPager.b(this.this$0), this.a);
    Bitmap localBitmap = GlUtil.saveTexture(VideoFilterViewPager.a(this.this$0).drawFrame(VideoFilterViewPager.b(this.this$0), true, 0L), this.a.getWidth(), this.a.getHeight());
    ThreadManager.getUIHandler().post(new VideoFilterViewPager.4.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterViewPager.4
 * JD-Core Version:    0.7.0.1
 */