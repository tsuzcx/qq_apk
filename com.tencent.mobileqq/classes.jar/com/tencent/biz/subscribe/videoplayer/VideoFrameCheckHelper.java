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
  private long jdField_a_of_type_Long;
  private volatile Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final HandlerThread jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("VideoFrameCheckHelper");
  private final String jdField_a_of_type_JavaLangString = "VideoFrameCheckHelper";
  private final Handler b;
  
  public VideoFrameCheckHelper()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.b = new Handler(Looper.getMainLooper());
  }
  
  private void a(TextureView paramTextureView, VideoFrameCheckHelper.DarkFrameCheckListener paramDarkFrameCheckListener)
  {
    paramDarkFrameCheckListener = new WeakReference(paramDarkFrameCheckListener);
    paramTextureView = new WeakReference(paramTextureView);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFrameCheckHelper.1(this, paramDarkFrameCheckListener, paramTextureView), 40L);
  }
  
  private boolean a(TextureView paramTextureView)
  {
    try
    {
      if (!paramTextureView.isAvailable()) {
        break label152;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      int i = paramTextureView.getWidth() / 16;
      int j = paramTextureView.getHeight() / 16;
      if ((i <= 0) || (j <= 0)) {
        break label159;
      }
      if (Build.VERSION.SDK_INT >= 17) {}
      for (this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramTextureView.getResources().getDisplayMetrics(), i, j, Bitmap.Config.ARGB_8888);; this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = paramTextureView.getBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        if (!StoryPlayerTest.a(this.jdField_a_of_type_AndroidGraphicsBitmap, 4, 16)) {
          break;
        }
        SLog.b("VideoFrameCheckHelper", "isCurrentFrameBlack CheckVideoViewRealStartRunnable find dark bitmap ! current = %d");
        return true;
      }
      SLog.d("VideoFrameCheckHelper", "isCurrentFrameBlack StoryPlayerTest.isBlack false. treat as not-black frame");
    }
    catch (Exception paramTextureView)
    {
      paramTextureView.printStackTrace();
      return false;
    }
    return false;
    label152:
    SLog.d("VideoFrameCheckHelper", "isCurrentFrameBlack targetView.isAvailable() false. treat as not-black frame");
    label159:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.videoplayer.VideoFrameCheckHelper
 * JD-Core Version:    0.7.0.1
 */