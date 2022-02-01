package com.tencent.biz.videostory.video;

import abbj;
import abbl;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.TMG.utils.QLog;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

class FrameVideoHelper$1
  implements Runnable
{
  FrameVideoHelper$1(FrameVideoHelper paramFrameVideoHelper, long paramLong, abbj paramabbj) {}
  
  public void run()
  {
    if (FrameVideoHelper.a(this.this$0) != -1L)
    {
      FrameVideoHelper.a(this.this$0, FrameVideoHelper.a(this.this$0));
      FrameVideoHelper.b(this.this$0, FrameVideoHelper.a(this.this$0));
    }
    FrameVideoHelper.a(this.this$0, new abbl(FrameVideoHelper.b(this.this$0), FrameVideoHelper.c(this.this$0)));
    long l3 = FrameVideoHelper.c(this.this$0, this.jdField_a_of_type_Long);
    long l2 = this.jdField_a_of_type_Long + l3;
    for (;;)
    {
      int i;
      try
      {
        FrameVideoHelper.a(this.this$0).a(FrameVideoHelper.a(this.this$0));
        localByteArrayOutputStream = new ByteArrayOutputStream();
        long l1 = 0L;
        i = 0;
        if ((i < FrameVideoHelper.d(this.this$0)) && (l2 < FrameVideoHelper.e(this.this$0)))
        {
          localObject = FrameVideoHelper.a(this.this$0).a(l2);
          l2 += l3;
          if (localObject == null) {
            break label438;
          }
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, (int)FrameVideoHelper.f(this.this$0), localByteArrayOutputStream);
          localObject = localByteArrayOutputStream.toByteArray();
          l1 += localObject.length;
          if (l1 < FrameVideoHelper.g(this.this$0)) {
            continue;
          }
          QLog.i("FrameVideoHelper", 0, "extract Frame out of limit readBytes:" + l1 + " | frameCount:" + i);
        }
        FrameVideoHelper.e(this.this$0, System.currentTimeMillis() - FrameVideoHelper.i(this.this$0));
        localByteArrayOutputStream.close();
        QLog.i("FrameVideoHelper", 0, "extract Frame cost time:" + FrameVideoHelper.j(this.this$0));
        if (this.jdField_a_of_type_Abbj != null) {
          this.jdField_a_of_type_Abbj.a(true, FrameVideoHelper.a(this.this$0), FrameVideoHelper.h(this.this$0));
        }
      }
      catch (Exception localException)
      {
        ByteArrayOutputStream localByteArrayOutputStream;
        Object localObject;
        localException.printStackTrace();
        this.jdField_a_of_type_Abbj.a(false, FrameVideoHelper.a(this.this$0), FrameVideoHelper.h(this.this$0));
        continue;
      }
      FrameVideoHelper.a(this.this$0, false);
      return;
      FrameVideoHelper.d(this.this$0, FrameVideoHelper.h(this.this$0) + localObject.length);
      FrameVideoHelper.a(this.this$0).add(new FrameVideoHelper.FrameBuffer((byte[])localObject));
      localByteArrayOutputStream.reset();
      label438:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.video.FrameVideoHelper.1
 * JD-Core Version:    0.7.0.1
 */