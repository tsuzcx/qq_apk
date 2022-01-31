package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import anuy;
import com.tencent.qphone.base.util.QLog;

public class VideoDrawableHandler$DecodeFrameTask
  implements Runnable
{
  int a;
  
  public VideoDrawableHandler$DecodeFrameTask(VideoDrawableHandler paramVideoDrawableHandler, int paramInt)
  {
    this.a = paramInt;
  }
  
  @TargetApi(10)
  public void run()
  {
    Bitmap localBitmap = this.this$0.a(this.a);
    int i;
    if (localBitmap == null)
    {
      localBitmap = VideoDrawableHandler.a(this.this$0);
      if (localBitmap == null) {
        i = 2;
      }
    }
    for (;;)
    {
      if ((localBitmap != null) && (this.this$0.jdField_a_of_type_AndroidGraphicsBitmap != localBitmap)) {}
      for (;;)
      {
        synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
        {
          this.this$0.b = this.this$0.jdField_a_of_type_AndroidGraphicsBitmap;
          this.this$0.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
          this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 0, 0).sendToTarget();
          if (this.this$0.jdField_a_of_type_Anuy != null) {
            this.this$0.jdField_a_of_type_Anuy.a(this.a, i);
          }
          if (QLog.isColorLevel()) {
            QLog.i("VideoDrawableHandler", 2, "task run at:" + this.a + " bmp:" + this.this$0.jdField_a_of_type_AndroidGraphicsBitmap);
          }
          return;
        }
        this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 1, 0).sendToTarget();
      }
      i = 1;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler.DecodeFrameTask
 * JD-Core Version:    0.7.0.1
 */