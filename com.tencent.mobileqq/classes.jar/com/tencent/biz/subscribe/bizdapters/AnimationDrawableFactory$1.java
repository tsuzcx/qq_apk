package com.tencent.biz.subscribe.bizdapters;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.MQLruCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

class AnimationDrawableFactory$1
  implements Runnable
{
  AnimationDrawableFactory$1(AnimationDrawableFactory paramAnimationDrawableFactory, boolean paramBoolean, String paramString, int paramInt, AnimationDrawableFactory.CreateDrawableResultListener paramCreateDrawableResultListener) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (AnimationDrawableFactory.a(this.this$0) != null) && (AnimationDrawableFactory.a(this.this$0).get(this.jdField_a_of_type_JavaLangString) != null)) {
      QLog.i("AnimationDrawableFactory", 2, "animationDrawable use cache" + this.jdField_a_of_type_JavaLangString);
    }
    for (AnimationDrawable localAnimationDrawable = (AnimationDrawable)AnimationDrawableFactory.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);; localAnimationDrawable = null)
    {
      Object localObject1 = localAnimationDrawable;
      if (localAnimationDrawable == null)
      {
        Object localObject2 = new File(this.jdField_a_of_type_JavaLangString);
        localObject1 = localAnimationDrawable;
        if (((File)localObject2).exists())
        {
          localObject1 = localAnimationDrawable;
          if (((File)localObject2).isDirectory())
          {
            QLog.i("AnimationDrawableFactory", 2, "exist Animation Pic!");
            localObject2 = ((File)localObject2).listFiles();
            localObject1 = localAnimationDrawable;
            if (localObject2 != null)
            {
              localObject1 = localAnimationDrawable;
              if (localObject2.length > 0)
              {
                Arrays.sort((Object[])localObject2, new AnimationDrawableFactory.1.1(this));
                int j = this.jdField_a_of_type_Int / localObject2.length;
                QLog.i("AnimationDrawableFactory", 2, "createFromDirectory perDuration=" + j);
                localAnimationDrawable = new AnimationDrawable();
                new ArrayList();
                int k = localObject2.length;
                int i = 0;
                for (;;)
                {
                  localObject1 = localAnimationDrawable;
                  if (i >= k) {
                    break label330;
                  }
                  localObject1 = localObject2[i];
                  try
                  {
                    localObject1 = AnimationDrawableFactory.a(this.this$0, (File)localObject1);
                    if (localObject1 != null) {
                      localAnimationDrawable.addFrame(new BitmapDrawable((Bitmap)localObject1), j);
                    }
                    AnimationDrawableFactory.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, localAnimationDrawable);
                  }
                  catch (OutOfMemoryError localOutOfMemoryError)
                  {
                    while (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersAnimationDrawableFactory$CreateDrawableResultListener == null) {}
                    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersAnimationDrawableFactory$CreateDrawableResultListener.a(false, null);
                    QLog.e("AnimationDrawableFactory", 2, "createFromDirectory OutOfMemoryError");
                  }
                  i += 1;
                }
              }
            }
          }
        }
      }
      label330:
      while (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersAnimationDrawableFactory$CreateDrawableResultListener == null) {
        return;
      }
      if (localOutOfMemoryError != null)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersAnimationDrawableFactory$CreateDrawableResultListener.a(true, localOutOfMemoryError);
        return;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersAnimationDrawableFactory$CreateDrawableResultListener.a(false, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory.1
 * JD-Core Version:    0.7.0.1
 */