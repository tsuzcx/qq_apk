package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.FileUtils;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.pic.Logger;
import java.io.ByteArrayOutputStream;
import java.util.List;

class VideoStoryCapturePart$13$1
  implements Runnable
{
  VideoStoryCapturePart$13$1(VideoStoryCapturePart.13 param13, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.a != null) && (!this.a.isRecycled()))
      {
        if ((this.a.getWidth() > 0) && (this.a.getHeight() > 0))
        {
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          Object localObject = FileUtils.a(this.a);
          long l = ((Long)VSConfigManager.a().a("SmartCutPicQuality_And", Long.valueOf(80L))).longValue();
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, (int)l, localByteArrayOutputStream);
          localObject = localByteArrayOutputStream.toByteArray();
          VideoStoryCapturePart.a(this.b.a, VideoStoryCapturePart.o(this.b.a) + localObject.length);
          if (VideoStoryCapturePart.o(this.b.a) > VideoStoryCapturePart.p(this.b.a))
          {
            VideoStoryCapturePart.a(this.b.a, VideoStoryCapturePart.o(this.b.a) - localObject.length);
            Logger.a("Q.videostory", "Q.videostory.capture", "onExtract", "size to larger");
            localByteArrayOutputStream.close();
            VideoStoryCapturePart.a(this.b.a).setCaptureRequest(null);
            return;
          }
          localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
          this.b.a.a.add(localObject);
          localByteArrayOutputStream.close();
          return;
        }
        AEQLog.d("VideoStoryCapturePart", "error bitmap width height.");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.13.1
 * JD-Core Version:    0.7.0.1
 */