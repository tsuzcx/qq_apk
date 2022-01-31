package com.tencent.biz.subscribe.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.MQLruCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import yld;
import yle;
import ylh;

public class AnimationDrawableFactory$2
  implements Runnable
{
  public AnimationDrawableFactory$2(yld paramyld, boolean paramBoolean, String paramString, int paramInt, ylh paramylh) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (yld.a(this.this$0) != null)
      {
        localObject1 = localObject2;
        if (yld.a(this.this$0).get(this.jdField_a_of_type_JavaLangString) != null)
        {
          QLog.i("AnimationDrawableFactory", 2, "animationDrawable use cache" + this.jdField_a_of_type_JavaLangString);
          localObject1 = (AnimationDrawable)yld.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
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
              Arrays.sort((Object[])localObject3, new yle(this));
              int j = this.jdField_a_of_type_Int / localObject3.length;
              QLog.i("AnimationDrawableFactory", 2, "createFromDirectory perDuration=" + j);
              localObject1 = new AnimationDrawable();
              new ArrayList();
              int k = localObject3.length;
              int i = 0;
              for (;;)
              {
                localObject2 = localObject1;
                if (i >= k) {
                  break label343;
                }
                localObject2 = localObject3[i];
                try
                {
                  localObject2 = yld.a(this.this$0, (File)localObject2);
                  if (localObject2 != null) {
                    ((AnimationDrawable)localObject1).addFrame(new BitmapDrawable((Bitmap)localObject2), j);
                  }
                  yld.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, localObject1);
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  while (this.jdField_a_of_type_Ylh == null) {}
                  this.jdField_a_of_type_Ylh.a();
                  QLog.e("AnimationDrawableFactory", 2, "createFromDirectory OutOfMemoryError");
                }
                i += 1;
              }
            }
          }
        }
      }
    }
    label343:
    while (this.jdField_a_of_type_Ylh == null) {
      return;
    }
    if (localOutOfMemoryError != null)
    {
      this.jdField_a_of_type_Ylh.a(localOutOfMemoryError);
      return;
    }
    this.jdField_a_of_type_Ylh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.AnimationDrawableFactory.2
 * JD-Core Version:    0.7.0.1
 */