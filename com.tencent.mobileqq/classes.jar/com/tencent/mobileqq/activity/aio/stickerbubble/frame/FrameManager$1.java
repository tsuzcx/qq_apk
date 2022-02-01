package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class FrameManager$1
  implements Runnable
{
  FrameManager$1(FrameManager paramFrameManager, String paramString) {}
  
  public void run()
  {
    try
    {
      IFrameDecode localIFrameDecode = FrameManager.a(this.this$0, this.a);
      if (localIFrameDecode == null) {
        return;
      }
      FrameManager.a(this.this$0).put(this.a, Integer.valueOf(localIFrameDecode.a()));
      BitmapDrawable[] arrayOfBitmapDrawable = new BitmapDrawable[localIFrameDecode.b()];
      localObject2 = FrameManager.a(this.this$0, localIFrameDecode.d(), 0.7D);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localIFrameDecode.d();
      }
      arrayOfBitmapDrawable[0] = new BitmapDrawable(FrameManager.b(this.this$0).getResources(), (Bitmap)localObject1);
      FrameManager.a(this.this$0, localIFrameDecode, arrayOfBitmapDrawable, this.a, localIFrameDecode.a());
      FrameManager.c(this.this$0).put(this.a, arrayOfBitmapDrawable);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("decoded first frame of gif: ");
        ((StringBuilder)localObject1).append(this.a);
        QLog.d("StickerBubble_FrameDecode", 2, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("oom when decode gif or scale first frame, ");
      ((StringBuilder)localObject2).append(localOutOfMemoryError);
      QLog.e("StickerBubble_FrameDecode", 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameManager.1
 * JD-Core Version:    0.7.0.1
 */