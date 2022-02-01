package com.tencent.biz.richframework.animation.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.util.LruCache;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

class AnimationDrawableFactory$2
  implements Runnable
{
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (AnimationDrawableFactory.a(this.this$0) != null) && (AnimationDrawableFactory.a(this.this$0).get(this.jdField_a_of_type_JavaLangString) != null)) {
      RFLog.i("AnimationDrawableFactory", RFLog.CLR, "animationDrawable use cache" + this.jdField_a_of_type_JavaLangString);
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
            RFLog.i("AnimationDrawableFactory", RFLog.CLR, "exist Animation Pic!");
            localObject2 = ((File)localObject2).listFiles();
            localObject1 = localAnimationDrawable;
            if (localObject2 != null)
            {
              localObject1 = localAnimationDrawable;
              if (localObject2.length > 0)
              {
                Arrays.sort((Object[])localObject2, new AnimationDrawableFactory.2.1(this));
                int j = this.jdField_a_of_type_Int / localObject2.length;
                RFLog.i("AnimationDrawableFactory", RFLog.CLR, "createFromDirectory perDuration=" + j);
                localAnimationDrawable = new AnimationDrawable();
                new ArrayList();
                int k = localObject2.length;
                int i = 0;
                for (;;)
                {
                  localObject1 = localAnimationDrawable;
                  if (i >= k) {
                    break label338;
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
                    while (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateDrawableResultListener == null) {}
                    this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateDrawableResultListener.a(false, null);
                    RFLog.e("AnimationDrawableFactory", RFLog.CLR, "createFromDirectory OutOfMemoryError");
                  }
                  i += 1;
                }
              }
            }
          }
        }
      }
      label338:
      while (this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateDrawableResultListener == null) {
        return;
      }
      if (localOutOfMemoryError != null)
      {
        this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateDrawableResultListener.a(true, localOutOfMemoryError);
        return;
      }
      this.jdField_a_of_type_ComTencentBizRichframeworkAnimationDrawableAnimationDrawableFactory$CreateDrawableResultListener.a(false, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.2
 * JD-Core Version:    0.7.0.1
 */