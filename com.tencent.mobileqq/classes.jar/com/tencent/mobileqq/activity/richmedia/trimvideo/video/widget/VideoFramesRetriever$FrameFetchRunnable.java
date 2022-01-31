package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import ajvu;
import ajvz;
import ajwg;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

class VideoFramesRetriever$FrameFetchRunnable
  implements Runnable
{
  VideoFramesRetriever$FrameFetchRunnable(VideoFramesRetriever paramVideoFramesRetriever) {}
  
  public void run()
  {
    if (VideoFramesRetriever.a(this.this$0) == null) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        long l = System.currentTimeMillis();
        ajwg localajwg;
        localObject2 = VideoFramesRetriever.a(this.this$0).getFrameAtTime((localajwg.jdField_a_of_type_Int + localajwg.b) / 2 * 1000L);
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFramesRetriever", 2, "getThumbnail Failed");
          }
          if ((VideoFramesRetriever.a(this.this$0)) || (VideoFramesRetriever.a(this.this$0) == null)) {
            break;
          }
          localajwg = (ajwg)VideoFramesRetriever.a(this.this$0).take();
          if (!VideoFramesRetriever.a(this.this$0)) {
            continue;
          }
          return;
        }
        if (((Bitmap)localObject2).getWidth() > ((Bitmap)localObject2).getHeight())
        {
          i = 1;
          if (i == 0) {
            break label338;
          }
          f = VideoFramesRetriever.a(this.this$0) / ((Bitmap)localObject2).getHeight();
          Object localObject1 = new Matrix();
          ((Matrix)localObject1).postScale(f, f);
          if (i == 0) {
            break label356;
          }
          localObject1 = Bitmap.createBitmap((Bitmap)localObject2, (((Bitmap)localObject2).getWidth() - ((Bitmap)localObject2).getHeight()) / 2, 0, ((Bitmap)localObject2).getHeight(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, true);
          ((Bitmap)localObject2).recycle();
          localObject2 = new ajvz();
          ((ajvz)localObject2).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1).copy(Bitmap.Config.RGB_565, true);
          ((ajvz)localObject2).jdField_a_of_type_Int = (localajwg.jdField_a_of_type_Int / VideoFramesRetriever.b(this.this$0));
          ((Bitmap)localObject1).recycle();
          QLog.i("VideoFramesRetriever", 1, "end get frame bitmap, cost time=" + (System.currentTimeMillis() - l));
          VideoFramesRetriever.a(this.this$0).a((ajvz)localObject2);
          VideoFramesRetriever.a(this.this$0).remove(Integer.valueOf(localajwg.jdField_a_of_type_Int));
          continue;
        }
        int i = 0;
      }
      catch (Throwable localThrowable)
      {
        localThrowable = localThrowable;
        QLog.e("VideoFramesRetriever", 2, "FrameFetchRunnable, Exception:", localThrowable);
        return;
      }
      finally {}
      continue;
      label338:
      float f = VideoFramesRetriever.a(this.this$0) / ((Bitmap)localObject2).getWidth();
      continue;
      label356:
      Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject2, 0, (((Bitmap)localObject2).getHeight() - ((Bitmap)localObject2).getWidth()) / 2, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getWidth(), localMatrix, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesRetriever.FrameFetchRunnable
 * JD-Core Version:    0.7.0.1
 */