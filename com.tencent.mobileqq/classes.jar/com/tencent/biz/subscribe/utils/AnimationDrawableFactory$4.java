package com.tencent.biz.subscribe.utils;

import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ygq;
import ygt;
import ygu;

public class AnimationDrawableFactory$4
  implements Runnable
{
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (ygq.b(this.this$0) != null)
      {
        localObject1 = localObject2;
        if (ygq.b(this.this$0).get(this.jdField_a_of_type_JavaLangString) != null)
        {
          QLog.i("AnimationDrawableFactory", 2, "animationDrawable use cache" + this.jdField_a_of_type_JavaLangString);
          localObject1 = (QQAnimationDrawable)ygq.b(this.this$0).get(this.jdField_a_of_type_JavaLangString);
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
              Arrays.sort((Object[])localObject3, new ygt(this));
              int i = this.jdField_a_of_type_Int / localObject3.length;
              QLog.i("AnimationDrawableFactory", 2, "createFromDirectory perDuration=" + i);
              localObject1 = new ArrayList();
              int j = localObject3.length;
              i = 0;
              while (i < j)
              {
                ((List)localObject1).add(localObject3[i].getPath());
                i += 1;
              }
              localObject2 = new QQAnimationDrawable();
              ((QQAnimationDrawable)localObject2).a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]));
              ygq.b(this.this$0).put(this.jdField_a_of_type_JavaLangString, localObject2);
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_Ygu != null)
    {
      if (localObject2 != null) {
        this.jdField_a_of_type_Ygu.a((QQAnimationDrawable)localObject2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ygu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.AnimationDrawableFactory.4
 * JD-Core Version:    0.7.0.1
 */