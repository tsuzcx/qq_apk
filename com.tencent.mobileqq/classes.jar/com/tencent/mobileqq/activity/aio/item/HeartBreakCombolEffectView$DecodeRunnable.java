package com.tencent.mobileqq.activity.aio.item;

import adst;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import bbef;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

public class HeartBreakCombolEffectView$DecodeRunnable
  implements Runnable
{
  BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  ArrayList<Bitmap> jdField_a_of_type_JavaUtilArrayList;
  
  public HeartBreakCombolEffectView$DecodeRunnable(ArrayList<Bitmap> paramArrayList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  public void run()
  {
    Object localObject3;
    while ((this.jdField_a_of_type_JavaUtilArrayList.size() < 2) && (this.this$0.b < this.this$0.jdField_a_of_type_JavaUtilArrayList.size()) && (HeartBreakCombolEffectView.jdField_a_of_type_Boolean))
    {
      localObject1 = this.this$0.jdField_a_of_type_JavaUtilArrayList;
      localObject3 = this.this$0;
      int i = ((HeartBreakCombolEffectView)localObject3).b;
      ((HeartBreakCombolEffectView)localObject3).b = (i + 1);
      localObject3 = (adst)((ArrayList)localObject1).get(i);
      if (localObject3 != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inPreferredConfig = Bitmap.Config.ARGB_4444;
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
        if (HeartBreakCombolEffectView.a(this.this$0).size() <= 0) {
          break label218;
        }
      }
    }
    Object localObject2;
    label218:
    for (Object localObject1 = (Bitmap)HeartBreakCombolEffectView.a(this.this$0).remove(0);; localObject2 = null)
    {
      for (;;)
      {
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()) && (CustomFrameAnimationDrawable.a())) {
          this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = ((Bitmap)localObject1);
        }
        try
        {
          localObject1 = bbef.a(((adst)localObject3).a, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          if (localObject1 == null) {
            break;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("HeartBreak", 2, localOutOfMemoryError.toString());
            }
            localObject2 = null;
          }
        }
      }
      if (!HeartBreakCombolEffectView.jdField_a_of_type_Boolean) {
        this.this$0.c();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */