package com.tencent.aelight.camera.ae.camera.core;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.ae.camera.AECaptureParam;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;
import java.io.IOException;

class AECameraGLSurfaceView$12
  implements Runnable
{
  AECameraGLSurfaceView$12(AECameraGLSurfaceView paramAECameraGLSurfaceView, Bitmap paramBitmap) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AECameraGLSurfaceView.access$900(this.this$0).a);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(".jpg");
    localObject = ((StringBuilder)localObject).toString();
    FileUtils.createFileIfNotExits((String)localObject);
    File localFile = new File((String)localObject);
    try
    {
      ImageUtil.b(this.val$photo, localFile);
      ImageUtil.b(BaseApplicationImpl.getContext(), localFile.getAbsolutePath());
      AECameraGLSurfaceView.access$1100(this.this$0, new AEPhotoCaptureResult(0, 0, (String)localObject, null, AECameraGLSurfaceView.access$1000(this.this$0)));
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      AECameraGLSurfaceView localAECameraGLSurfaceView = this.this$0;
      AECameraGLSurfaceView.access$1100(localAECameraGLSurfaceView, new AEPhotoCaptureResult(0, -1, (String)localObject, null, AECameraGLSurfaceView.access$1000(localAECameraGLSurfaceView)));
    }
    this.val$photo.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView.12
 * JD-Core Version:    0.7.0.1
 */