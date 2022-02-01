package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

class ZanCombolEffectView$1
  implements Runnable
{
  ZanCombolEffectView$1(ZanCombolEffectView paramZanCombolEffectView, Integer[] paramArrayOfInteger) {}
  
  public void run()
  {
    ZanCombolEffectView.a(this.this$0).clear();
    Object localObject = this.a;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      int k = localObject[i].intValue();
      try
      {
        try
        {
          Bitmap localBitmap = BitmapFactory.decodeResource(this.this$0.getResources(), k);
          if (localBitmap != null) {
            ZanCombolEffectView.a(this.this$0).add(localBitmap);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
        }
      }
      catch (Throwable localThrowable)
      {
        label80:
        break label80;
      }
      i += 1;
    }
    if (ZanCombolEffectView.a(this.this$0).size() > 0)
    {
      ZanCombolEffectView.a(this.this$0, System.currentTimeMillis());
      localObject = this.this$0;
      ZanCombolEffectView.b((ZanCombolEffectView)localObject, ZanCombolEffectView.a((ZanCombolEffectView)localObject));
      ZanCombolEffectView.a(this.this$0, true);
      ZanCombolEffectView.b(this.this$0, false);
      this.this$0.postInvalidate();
    }
    if (ZanCombolEffectView.a(this.this$0)) {
      ThreadManager.postImmediately(new ZanCombolEffectView.1.1(this), null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ZanCombolEffectView.1
 * JD-Core Version:    0.7.0.1
 */