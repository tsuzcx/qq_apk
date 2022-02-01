package com.tencent.biz.subscribe.videoplayer;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.TextureView;
import com.tencent.biz.qqstory.playvideo.StoryPlayerTest;
import com.tencent.biz.qqstory.support.logging.SLog;
import mqq.util.WeakReference;

public class VideoFrameCheckHelper
{
  private final String a = "VideoFrameCheckHelper";
  private final Handler b;
  private final Handler c;
  private final HandlerThread d = new HandlerThread("VideoFrameCheckHelper");
  private volatile Bitmap e;
  private long f;
  
  public VideoFrameCheckHelper()
  {
    this.d.start();
    this.b = new Handler(this.d.getLooper());
    this.c = new Handler(Looper.getMainLooper());
  }
  
  private void a(TextureView paramTextureView, VideoFrameCheckHelper.DarkFrameCheckListener paramDarkFrameCheckListener)
  {
    paramDarkFrameCheckListener = new WeakReference(paramDarkFrameCheckListener);
    paramTextureView = new WeakReference(paramTextureView);
    this.b.postDelayed(new VideoFrameCheckHelper.1(this, paramDarkFrameCheckListener, paramTextureView), 40L);
  }
  
  private boolean a(TextureView paramTextureView)
  {
    try
    {
      boolean bool = paramTextureView.isAvailable();
      if (bool)
      {
        if ((this.e != null) && (!this.e.isRecycled()))
        {
          this.e.recycle();
          this.e = null;
        }
        int i = paramTextureView.getWidth() / 16;
        int j = paramTextureView.getHeight() / 16;
        if ((i > 0) && (j > 0))
        {
          if (Build.VERSION.SDK_INT >= 17) {
            this.e = Bitmap.createBitmap(paramTextureView.getResources().getDisplayMetrics(), i, j, Bitmap.Config.ARGB_8888);
          } else {
            this.e = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          }
          this.e = paramTextureView.getBitmap(this.e);
          if (StoryPlayerTest.a(this.e, 4, 16))
          {
            SLog.b("VideoFrameCheckHelper", "isCurrentFrameBlack CheckVideoViewRealStartRunnable find dark bitmap ! current = %d");
            return true;
          }
          SLog.d("VideoFrameCheckHelper", "isCurrentFrameBlack StoryPlayerTest.isBlack false. treat as not-black frame");
          return false;
        }
      }
      else
      {
        SLog.d("VideoFrameCheckHelper", "isCurrentFrameBlack targetView.isAvailable() false. treat as not-black frame");
        return false;
      }
    }
    catch (Exception paramTextureView)
    {
      paramTextureView.printStackTrace();
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper
 * JD-Core Version:    0.7.0.1
 */