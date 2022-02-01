package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
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
      } else {
        i = 1;
      }
    }
    else
    {
      i = 0;
    }
    if ((localBitmap != null) && (this.this$0.b != localBitmap)) {
      synchronized (this.this$0.i)
      {
        this.this$0.c = this.this$0.b;
        this.this$0.b = localBitmap;
        this.this$0.g.obtainMessage(0, 0, 0).sendToTarget();
      }
    }
    this.this$0.g.obtainMessage(0, 1, 0).sendToTarget();
    if (this.this$0.j != null) {
      this.this$0.j.a(this.a, i);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("task run at:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" bmp:");
      localStringBuilder.append(this.this$0.b);
      QLog.i("VideoDrawableHandler", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler.DecodeFrameTask
 * JD-Core Version:    0.7.0.1
 */