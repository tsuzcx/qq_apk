package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

public class HeartBreakCombolEffectView$DecodeRunnable
  implements Runnable
{
  BitmapFactory.Options a = new BitmapFactory.Options();
  ArrayList<Bitmap> b;
  
  public HeartBreakCombolEffectView$DecodeRunnable(ArrayList<Bitmap> paramArrayList)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public void run()
  {
    while ((this.b.size() < 2) && (this.this$0.g < this.this$0.i.size()) && (HeartBreakCombolEffectView.h))
    {
      Object localObject = this.this$0.i;
      HeartBreakCombolEffectView localHeartBreakCombolEffectView = this.this$0;
      int i = localHeartBreakCombolEffectView.g;
      localHeartBreakCombolEffectView.g = (i + 1);
      HeartBreakCombolEffectView.OneFrame localOneFrame = (HeartBreakCombolEffectView.OneFrame)((ArrayList)localObject).get(i);
      if (localOneFrame != null)
      {
        localObject = this.a;
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_4444;
        this.a.inMutable = true;
        i = HeartBreakCombolEffectView.a(this.this$0).size();
        localHeartBreakCombolEffectView = null;
        if (i > 0) {
          localObject = (Bitmap)HeartBreakCombolEffectView.a(this.this$0).remove(0);
        } else {
          localObject = null;
        }
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()) && (CustomFrameAnimationDrawable.p())) {
          this.a.inBitmap = ((Bitmap)localObject);
        }
        try
        {
          localObject = ImageUtil.a(localOneFrame.a, this.a);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject = localHeartBreakCombolEffectView;
          if (QLog.isColorLevel())
          {
            QLog.d("HeartBreak", 2, localOutOfMemoryError.toString());
            localObject = localHeartBreakCombolEffectView;
          }
        }
        if (localObject != null) {
          this.b.add(localObject);
        }
      }
    }
    if (!HeartBreakCombolEffectView.h) {
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */