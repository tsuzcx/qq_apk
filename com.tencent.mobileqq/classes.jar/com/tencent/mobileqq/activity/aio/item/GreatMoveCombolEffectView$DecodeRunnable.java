package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

public class GreatMoveCombolEffectView$DecodeRunnable
  implements Runnable
{
  BitmapFactory.Options a = new BitmapFactory.Options();
  ArrayList<Bitmap> b;
  
  public GreatMoveCombolEffectView$DecodeRunnable(ArrayList<Bitmap> paramArrayList)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((this.b.size() >= 2) || (this.this$0.g >= this.this$0.k.size()) || (!GreatMoveCombolEffectView.h)) {
          continue;
        }
        localObject1 = this.this$0.k;
        localGreatMoveCombolEffectView = this.this$0;
        int i = localGreatMoveCombolEffectView.g;
        localGreatMoveCombolEffectView.g = (i + 1);
        localOneFrame = (GreatMoveCombolEffectView.OneFrame)((ArrayList)localObject1).get(i);
        if (localOneFrame == null) {
          continue;
        }
        this.a.inSampleSize = 1;
        this.a.inPreferredConfig = Bitmap.Config.ARGB_4444;
        this.a.inMutable = true;
        i = GreatMoveCombolEffectView.a(this.this$0).size();
        localGreatMoveCombolEffectView = null;
        if (i <= 0) {
          continue;
        }
        localObject1 = (Bitmap)GreatMoveCombolEffectView.a(this.this$0).remove(0);
      }
      finally
      {
        Object localObject1;
        GreatMoveCombolEffectView localGreatMoveCombolEffectView;
        GreatMoveCombolEffectView.OneFrame localOneFrame;
        continue;
        throw localObject2;
        continue;
        Object localObject3 = null;
        continue;
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()) && (CustomFrameAnimationDrawable.p())) {
        this.a.inBitmap = ((Bitmap)localObject1);
      }
      try
      {
        localObject1 = ImageUtil.a(localOneFrame.a, this.a);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = localGreatMoveCombolEffectView;
        if (QLog.isColorLevel())
        {
          QLog.d("GreatMove", 2, localOutOfMemoryError.toString());
          localObject1 = localGreatMoveCombolEffectView;
        }
      }
      if (localObject1 != null) {
        this.b.add(localObject1);
      }
    }
    if (!GreatMoveCombolEffectView.h) {
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GreatMoveCombolEffectView.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */