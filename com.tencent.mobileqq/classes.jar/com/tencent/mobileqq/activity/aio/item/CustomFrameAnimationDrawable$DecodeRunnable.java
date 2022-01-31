package com.tencent.mobileqq.activity.aio.item;

import adda;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import babe;
import bacm;
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
    String str;
    if (CustomFrameAnimationDrawable.a(this.this$0)) {
      str = CustomFrameAnimationDrawable.a(this.this$0).a(CustomFrameAnimationDrawable.a(this.this$0), CustomFrameAnimationDrawable.b(this.this$0), this.jdField_a_of_type_Int);
    }
    for (Object localObject1 = babe.a(str);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
        if (CustomFrameAnimationDrawable.a(this.this$0).size() <= 0) {
          break label251;
        }
      }
      label251:
      Object localObject2;
      for (Bitmap localBitmap1 = (Bitmap)CustomFrameAnimationDrawable.a(this.this$0).remove(0);; localObject2 = null)
      {
        if ((!CustomFrameAnimationDrawable.a(this.this$0)) && (localBitmap1 != null) && (!localBitmap1.isRecycled()) && (CustomFrameAnimationDrawable.a())) {
          this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = localBitmap1;
        }
        if (this.b != 0) {}
        for (;;)
        {
          try
          {
            localBitmap1 = bacm.a(this.jdField_a_of_type_AndroidContentResResources, this.b);
            localObject1 = localBitmap1;
          }
          catch (OutOfMemoryError localOutOfMemoryError1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("CustomFrameAnimationDrawable", 2, localOutOfMemoryError1.toString());
            continue;
          }
          if (localObject1 != null)
          {
            if (CustomFrameAnimationDrawable.a(this.this$0)) {
              babe.a(str, (Bitmap)localObject1);
            }
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          }
          this.this$0.a = null;
          return;
          if (this.jdField_a_of_type_JavaLangString != null) {
            try
            {
              Bitmap localBitmap2 = bacm.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
              localObject1 = localBitmap2;
            }
            catch (OutOfMemoryError localOutOfMemoryError2)
            {
              if (QLog.isColorLevel()) {
                QLog.d("CustomFrameAnimationDrawable", 2, localOutOfMemoryError2.toString());
              }
            }
          }
        }
      }
      str = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */