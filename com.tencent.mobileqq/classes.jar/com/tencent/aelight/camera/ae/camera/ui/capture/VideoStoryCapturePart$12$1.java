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

class VideoStoryCapturePart$12$1
  implements Runnable
{
  VideoStoryCapturePart$12$1(VideoStoryCapturePart.12 param12, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() > 0) && (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() > 0))
        {
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          Object localObject = FileUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
          long l = ((Long)VSConfigManager.a().a("SmartCutPicQuality_And", Long.valueOf(80L))).longValue();
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, (int)l, localByteArrayOutputStream);
          localObject = localByteArrayOutputStream.toByteArray();
          VideoStoryCapturePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiCaptureVideoStoryCapturePart$12.a, VideoStoryCapturePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiCaptureVideoStoryCapturePart$12.a) + localObject.length);
          if (VideoStoryCapturePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiCaptureVideoStoryCapturePart$12.a) > VideoStoryCapturePart.b(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiCaptureVideoStoryCapturePart$12.a))
          {
            VideoStoryCapturePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiCaptureVideoStoryCapturePart$12.a, VideoStoryCapturePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiCaptureVideoStoryCapturePart$12.a) - localObject.length);
            Logger.a("Q.videostory", "Q.videostory.capture", "onExtract", "size to larger");
            localByteArrayOutputStream.close();
            VideoStoryCapturePart.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiCaptureVideoStoryCapturePart$12.a).setCaptureRequest(null);
            return;
          }
          localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
          this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiCaptureVideoStoryCapturePart$12.a.a.add(localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.12.1
 * JD-Core Version:    0.7.0.1
 */