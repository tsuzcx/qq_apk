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
    GLES20.glBindTexture(3553, QQAVImageToneCurveFilter.access$000(this.this$0)[0]);
    if ((QQAVImageToneCurveFilter.access$100(this.this$0).size() >= 256) && (QQAVImageToneCurveFilter.access$200(this.this$0).size() >= 256) && (QQAVImageToneCurveFilter.access$300(this.this$0).size() >= 256) && (QQAVImageToneCurveFilter.access$400(this.this$0).size() >= 256))
    {
      byte[] arrayOfByte = new byte[1024];
      int i = 0;
      while (i < 256)
      {
        float f1 = i;
        float f2 = ((Float)QQAVImageToneCurveFilter.access$300(this.this$0).get(i)).floatValue();
        arrayOfByte[(i * 4 + 2)] = ((byte)((int)Math.min(Math.max(((Float)QQAVImageToneCurveFilter.access$400(this.this$0).get(i)).floatValue() + (f1 + f2), 0.0F), 255.0F) & 0xFF));
        f1 = i;
        f2 = ((Float)QQAVImageToneCurveFilter.access$200(this.this$0).get(i)).floatValue();
        arrayOfByte[(i * 4 + 1)] = ((byte)((int)Math.min(Math.max(((Float)QQAVImageToneCurveFilter.access$400(this.this$0).get(i)).floatValue() + (f1 + f2), 0.0F), 255.0F) & 0xFF));
        f1 = i;
        f2 = ((Float)QQAVImageToneCurveFilter.access$100(this.this$0).get(i)).floatValue();
        arrayOfByte[(i * 4)] = ((byte)((int)Math.min(Math.max(((Float)QQAVImageToneCurveFilter.access$400(this.this$0).get(i)).floatValue() + (f1 + f2), 0.0F), 255.0F) & 0xFF));
        arrayOfByte[(i * 4 + 3)] = -1;
        i += 1;
      }
      GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(arrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageToneCurveFilter.1
 * JD-Core Version:    0.7.0.1
 */