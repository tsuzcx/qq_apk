package com.tencent.av.video.effect.core.qqavimage;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.util.ArrayList;

class QQAVImageToneCurveFilter$1
  implements Runnable
{
  QQAVImageToneCurveFilter$1(QQAVImageToneCurveFilter paramQQAVImageToneCurveFilter) {}
  
  public void run()
  {
    GLES20.glActiveTexture(33987);
    Object localObject = QQAVImageToneCurveFilter.access$000(this.this$0);
    int i = 0;
    GLES20.glBindTexture(3553, localObject[0]);
    if ((QQAVImageToneCurveFilter.access$100(this.this$0).size() >= 256) && (QQAVImageToneCurveFilter.access$200(this.this$0).size() >= 256) && (QQAVImageToneCurveFilter.access$300(this.this$0).size() >= 256) && (QQAVImageToneCurveFilter.access$400(this.this$0).size() >= 256))
    {
      localObject = new byte[1024];
      while (i < 256)
      {
        int j = i * 4;
        float f = i;
        localObject[(j + 2)] = ((byte)((int)Math.min(Math.max(((Float)QQAVImageToneCurveFilter.access$300(this.this$0).get(i)).floatValue() + f + ((Float)QQAVImageToneCurveFilter.access$400(this.this$0).get(i)).floatValue(), 0.0F), 255.0F) & 0xFF));
        localObject[(j + 1)] = ((byte)((int)Math.min(Math.max(((Float)QQAVImageToneCurveFilter.access$200(this.this$0).get(i)).floatValue() + f + ((Float)QQAVImageToneCurveFilter.access$400(this.this$0).get(i)).floatValue(), 0.0F), 255.0F) & 0xFF));
        localObject[j] = ((byte)((int)Math.min(Math.max(f + ((Float)QQAVImageToneCurveFilter.access$100(this.this$0).get(i)).floatValue() + ((Float)QQAVImageToneCurveFilter.access$400(this.this$0).get(i)).floatValue(), 0.0F), 255.0F) & 0xFF));
        localObject[(j + 3)] = -1;
        i += 1;
      }
      GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap((byte[])localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageToneCurveFilter.1
 * JD-Core Version:    0.7.0.1
 */