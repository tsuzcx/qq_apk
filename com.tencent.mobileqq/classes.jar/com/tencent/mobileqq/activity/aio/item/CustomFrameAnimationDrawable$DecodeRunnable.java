package com.tencent.mobileqq.activity.aio.item;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

class CustomFrameAnimationDrawable$DecodeRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  Resources jdField_a_of_type_AndroidContentResResources;
  BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  String jdField_a_of_type_JavaLangString;
  ArrayList<Bitmap> jdField_a_of_type_JavaUtilArrayList;
  int b;
  
  public CustomFrameAnimationDrawable$DecodeRunnable(int paramInt1, String paramString, int paramInt2, ArrayList<Bitmap> paramArrayList)
  {
    this.jdField_a_of_type_Int = paramString;
    this.jdField_a_of_type_JavaLangString = paramInt2;
    this.b = paramArrayList;
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  public void a(Resources paramResources)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  public void run()
  {
    String str1;
    Object localObject1;
    if (CustomFrameAnimationDrawable.a(this.this$0))
    {
      str1 = CustomFrameAnimationDrawable.a(this.this$0).a(CustomFrameAnimationDrawable.a(this.this$0), CustomFrameAnimationDrawable.b(this.this$0), this.jdField_a_of_type_Int);
      localObject1 = CommonImageCacheHelper.a(str1);
    }
    else
    {
      str1 = null;
      localObject1 = str1;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options;
      ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      ((BitmapFactory.Options)localObject2).inMutable = true;
      if (CustomFrameAnimationDrawable.a(this.this$0).size() > 0) {
        localObject2 = (Bitmap)CustomFrameAnimationDrawable.a(this.this$0).remove(0);
      } else {
        localObject2 = null;
      }
      if ((!CustomFrameAnimationDrawable.a(this.this$0)) && (localObject2 != null) && (!((Bitmap)localObject2).isRecycled()) && (CustomFrameAnimationDrawable.a())) {
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = ((Bitmap)localObject2);
      }
      int i = this.b;
      if (i != 0)
      {
        try
        {
          localObject2 = BaseImageUtil.a(this.jdField_a_of_type_AndroidContentResResources, i);
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break label242;
          }
        }
        QLog.d("CustomFrameAnimationDrawable", 2, localOutOfMemoryError1.toString());
        localObject2 = localObject1;
      }
      else
      {
        String str2 = this.jdField_a_of_type_JavaLangString;
        localObject2 = localObject1;
        if (str2 != null) {
          try
          {
            localObject2 = BaseImageUtil.a(str2, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("CustomFrameAnimationDrawable", 2, localOutOfMemoryError2.toString());
              localObject2 = localObject1;
            }
          }
        }
      }
    }
    label242:
    if (localObject2 != null)
    {
      if (CustomFrameAnimationDrawable.a(this.this$0)) {
        CommonImageCacheHelper.a(str1, (Bitmap)localObject2);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
    }
    this.this$0.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */