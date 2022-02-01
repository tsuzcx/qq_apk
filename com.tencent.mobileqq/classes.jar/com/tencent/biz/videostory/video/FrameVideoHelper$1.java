package com.tencent.biz.videostory.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.TMG.utils.QLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

class FrameVideoHelper$1
  implements Runnable
{
  FrameVideoHelper$1(FrameVideoHelper paramFrameVideoHelper, long paramLong, FrameVideoHelper.GetFrameByteArrayListener paramGetFrameByteArrayListener) {}
  
  public void run()
  {
    if (FrameVideoHelper.a(this.this$0) != -1L)
    {
      localObject1 = this.this$0;
      FrameVideoHelper.a((FrameVideoHelper)localObject1, FrameVideoHelper.a((FrameVideoHelper)localObject1));
      localObject1 = this.this$0;
      FrameVideoHelper.b((FrameVideoHelper)localObject1, FrameVideoHelper.a((FrameVideoHelper)localObject1));
    }
    Object localObject1 = this.this$0;
    FrameVideoHelper.a((FrameVideoHelper)localObject1, new MediaCodecGLFrameFetcher(FrameVideoHelper.b((FrameVideoHelper)localObject1), FrameVideoHelper.c(this.this$0)));
    long l3 = FrameVideoHelper.c(this.this$0, this.jdField_a_of_type_Long);
    long l2 = this.jdField_a_of_type_Long;
    for (;;)
    {
      int i;
      try
      {
        FrameVideoHelper.a(this.this$0).a(FrameVideoHelper.a(this.this$0));
        localObject1 = new ByteArrayOutputStream();
        long l1 = 0L;
        l2 += l3;
        i = 0;
        long l4 = i;
        long l5 = FrameVideoHelper.d(this.this$0);
        if ((l4 < l5) && (l2 < FrameVideoHelper.e(this.this$0)))
        {
          Object localObject2 = FrameVideoHelper.a(this.this$0).a(l2);
          l2 += l3;
          if (localObject2 == null) {
            break label485;
          }
          ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, (int)FrameVideoHelper.f(this.this$0), (OutputStream)localObject1);
          localObject2 = ((ByteArrayOutputStream)localObject1).toByteArray();
          l1 += localObject2.length;
          if (l1 >= FrameVideoHelper.g(this.this$0))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("extract Frame out of limit readBytes:");
            ((StringBuilder)localObject2).append(l1);
            ((StringBuilder)localObject2).append(" | frameCount:");
            ((StringBuilder)localObject2).append(i);
            QLog.i("FrameVideoHelper", 0, ((StringBuilder)localObject2).toString());
          }
          else
          {
            FrameVideoHelper.d(this.this$0, FrameVideoHelper.h(this.this$0) + localObject2.length);
            FrameVideoHelper.a(this.this$0).add(new FrameVideoHelper.FrameBuffer((byte[])localObject2));
            ((ByteArrayOutputStream)localObject1).reset();
            break label485;
          }
        }
        FrameVideoHelper.e(this.this$0, System.currentTimeMillis() - FrameVideoHelper.i(this.this$0));
        ((ByteArrayOutputStream)localObject1).close();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("extract Frame cost time:");
        ((StringBuilder)localObject1).append(FrameVideoHelper.j(this.this$0));
        QLog.i("FrameVideoHelper", 0, ((StringBuilder)localObject1).toString());
        if (this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper$GetFrameByteArrayListener != null) {
          this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper$GetFrameByteArrayListener.a(true, FrameVideoHelper.a(this.this$0), FrameVideoHelper.h(this.this$0));
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper$GetFrameByteArrayListener.a(false, FrameVideoHelper.a(this.this$0), FrameVideoHelper.h(this.this$0));
      }
      FrameVideoHelper.a(this.this$0, false);
      return;
      label485:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.video.FrameVideoHelper.1
 * JD-Core Version:    0.7.0.1
 */