package com.tencent.biz.richframework.animation.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

class AnimationDrawableFactory$2
  implements Runnable
{
  public void run()
  {
    if ((this.a) && (AnimationDrawableFactory.b(this.this$0) != null) && (AnimationDrawableFactory.b(this.this$0).get(this.b) != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("animationDrawable use cache");
      ((StringBuilder)localObject1).append(this.b);
      QLog.i("AnimationDrawableFactory", 2, ((StringBuilder)localObject1).toString());
      localObject1 = (AnimationDrawable)AnimationDrawableFactory.b(this.this$0).get(this.b);
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      Object localObject3 = new File(this.b);
      localObject2 = localObject1;
      if (((File)localObject3).exists())
      {
        localObject2 = localObject1;
        if (((File)localObject3).isDirectory())
        {
          QLog.i("AnimationDrawableFactory", 2, "exist Animation Pic!");
          localObject3 = ((File)localObject3).listFiles();
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = localObject1;
            if (localObject3.length > 0)
            {
              Arrays.sort((Object[])localObject3, new AnimationDrawableFactory.2.1(this));
              int j = this.c / localObject3.length;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("createFromDirectory perDuration=");
              ((StringBuilder)localObject1).append(j);
              QLog.i("AnimationDrawableFactory", 2, ((StringBuilder)localObject1).toString());
              localObject2 = new AnimationDrawable();
              new ArrayList();
              int k = localObject3.length;
              int i = 0;
              while (i < k)
              {
                localObject1 = localObject3[i];
                try
                {
                  localObject1 = AnimationDrawableFactory.a(this.this$0, (File)localObject1);
                  if (localObject1 != null) {
                    ((AnimationDrawable)localObject2).addFrame(new BitmapDrawable((Bitmap)localObject1), j);
                  }
                  AnimationDrawableFactory.b(this.this$0).put(this.b, localObject2);
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  label319:
                  break label319;
                }
                localObject1 = this.d;
                if (localObject1 != null)
                {
                  ((AnimationDrawableFactory.CreateDrawableResultListener)localObject1).a(false, null);
                  QLog.e("AnimationDrawableFactory", 2, "createFromDirectory OutOfMemoryError");
                  return;
                }
                i += 1;
              }
            }
          }
        }
      }
    }
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      if (localObject2 != null)
      {
        ((AnimationDrawableFactory.CreateDrawableResultListener)localObject1).a(true, (Drawable)localObject2);
        return;
      }
      ((AnimationDrawableFactory.CreateDrawableResultListener)localObject1).a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.2
 * JD-Core Version:    0.7.0.1
 */