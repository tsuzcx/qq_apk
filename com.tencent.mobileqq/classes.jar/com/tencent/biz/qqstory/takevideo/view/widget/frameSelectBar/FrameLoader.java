package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StringAppendTool;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.asyncImageLoader.ImageLoader;
import com.tencent.biz.qqstory.view.asyncImageLoader.Task;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils;

public class FrameLoader
  extends ImageLoader<Integer>
{
  public FrameLoader.GetFrameReport a = new FrameLoader.GetFrameReport();
  private MediaMetadataRetriever b;
  private String c;
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private boolean i = false;
  private LruCache<Integer, Drawable> j = new LruCache(180);
  
  public FrameLoader(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramString);
    this.d = paramInt1;
    this.e = paramInt2;
    this.h = paramBoolean;
  }
  
  public LruCache<Integer, Drawable> a()
  {
    return this.j;
  }
  
  public Task a(ImageView paramImageView, Integer paramInteger)
  {
    return new FrameLoader.FrameTask(paramImageView, this.b, paramInteger, this.d, this.e, this.g, this.f, this.h, this.a, this.i);
  }
  
  @TargetApi(10)
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    SLog.a("Q.qqstory.frameWidget.FrameLoader", "initVideo,duration=%s,path=%s", Integer.valueOf(paramInt1), paramString);
    try
    {
      if (this.h) {
        ThumbnailUtils.a(paramString, this.e, this.d, 0, 0, this.e, this.d);
      } else {
        ThumbnailUtils.a(paramString, this.d, this.e, 0, 0, this.d, this.e);
      }
      this.i = true;
    }
    catch (Exception localException1)
    {
      this.i = false;
      SLog.c("Q.qqstory.frameWidget.FrameLoader", "ThumbnailUtils init failed! e:%s", localException1);
    }
    try
    {
      this.b = new MediaMetadataRetriever();
      this.b.setDataSource(paramString);
      if (Build.VERSION.SDK_INT >= 26) {
        this.i = false;
      }
    }
    catch (Exception localException2)
    {
      SLog.e("Q.qqstory.frameWidget.FrameLoader", StringAppendTool.a(new Object[] { "MediaMetadataRetriever init failed! mVideoPath = ", paramString, "  e=", localException2 }));
      StoryReportor.b("story_local_video", "frame_loader", 0, 0, new String[] { paramString, localException2.getMessage() });
      this.b = null;
    }
    this.c = paramString;
    this.f = paramInt2;
    d();
  }
  
  @TargetApi(10)
  public void b()
  {
    super.b();
    this.j.evictAll();
    MediaMetadataRetriever localMediaMetadataRetriever = this.b;
    if (localMediaMetadataRetriever != null) {
      localMediaMetadataRetriever.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.FrameLoader
 * JD-Core Version:    0.7.0.1
 */