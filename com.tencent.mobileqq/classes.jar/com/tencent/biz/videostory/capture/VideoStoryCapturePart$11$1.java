package com.tencent.biz.videostory.capture;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import atpg;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import dov.com.qq.im.AECamera.View.AECameraGLSurfaceView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import wuh;
import wuk;
import wyd;

public class VideoStoryCapturePart$11$1
  implements Runnable
{
  public VideoStoryCapturePart$11$1(wuk paramwuk, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        wyd.a(this.jdField_a_of_type_AndroidGraphicsBitmap).compress(Bitmap.CompressFormat.JPEG, 30, localByteArrayOutputStream);
        Object localObject = localByteArrayOutputStream.toByteArray();
        wuh.a(this.jdField_a_of_type_Wuk.a, wuh.a(this.jdField_a_of_type_Wuk.a) + localObject.length);
        if (wuh.a(this.jdField_a_of_type_Wuk.a) > wuh.b(this.jdField_a_of_type_Wuk.a))
        {
          wuh.a(this.jdField_a_of_type_Wuk.a, wuh.a(this.jdField_a_of_type_Wuk.a) - localObject.length);
          atpg.a("Q.videostory", "Q.videostory.capture", "onCapture", "size to larger");
          localByteArrayOutputStream.close();
          wuh.a(this.jdField_a_of_type_Wuk.a).setCaptureRequest(null);
          return;
        }
        localObject = new FrameVideoHelper.FrameBuffer((byte[])localObject);
        this.jdField_a_of_type_Wuk.a.a.add(localObject);
        localByteArrayOutputStream.close();
        return;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.VideoStoryCapturePart.11.1
 * JD-Core Version:    0.7.0.1
 */