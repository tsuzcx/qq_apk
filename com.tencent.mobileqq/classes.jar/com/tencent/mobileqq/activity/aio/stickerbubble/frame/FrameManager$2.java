package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;

class FrameManager$2
  implements Runnable
{
  FrameManager$2(FrameManager paramFrameManager, BitmapDrawable[] paramArrayOfBitmapDrawable, IFrameDecode paramIFrameDecode, String paramString, int paramInt) {}
  
  public void run()
  {
    int j = 1;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = this.a;
      if (j >= localObject.length) {
        break;
      }
      this.b.e();
      localObject = FrameManager.a(this.this$0, this.b.d(), 0.7D);
      BitmapDrawable[] arrayOfBitmapDrawable = this.a;
      if (localObject != null) {
        localObject = new BitmapDrawable(FrameManager.b(this.this$0).getResources(), (Bitmap)localObject);
      } else {
        localObject = null;
      }
      arrayOfBitmapDrawable[j] = localObject;
      if (j != this.b.c()) {
        i = 1;
      } else {
        i = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.e("StickerBubble_FrameDecode", 2, new Object[] { "decode gif, i: ", Integer.valueOf(j), " index: ", Integer.valueOf(this.b.c()), " len: ", Integer.valueOf(this.a.length), " path: ", this.c });
      }
      j += 1;
    }
    if (i == 0) {
      FrameCache.a(this.c, (BitmapDrawable[])localObject, this.d);
    }
    this.b.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameManager.2
 * JD-Core Version:    0.7.0.1
 */