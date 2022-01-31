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
  BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public HeartBreakCombolEffectView$DecodeRunnable(HeartBreakCombolEffectView paramHeartBreakCombolEffectView, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void run()
  {
    Object localObject3;
    while ((this.jdField_a_of_type_JavaUtilArrayList.size() < 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView.b < this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView.jdField_a_of_type_JavaUtilArrayList.size()) && (HeartBreakCombolEffectView.jdField_a_of_type_Boolean))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView.jdField_a_of_type_JavaUtilArrayList;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView;
      int i = ((HeartBreakCombolEffectView)localObject3).b;
      ((HeartBreakCombolEffectView)localObject3).b = (i + 1);
      localObject3 = (HeartBreakCombolEffectView.OneFrame)((ArrayList)localObject1).get(i);
      if (localObject3 != null)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inPreferredConfig = Bitmap.Config.ARGB_4444;
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
        if (HeartBreakCombolEffectView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView).size() <= 0) {
          break label218;
        }
      }
    }
    Object localObject2;
    label218:
    for (Object localObject1 = (Bitmap)HeartBreakCombolEffectView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView).remove(0);; localObject2 = null)
    {
      for (;;)
      {
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()) && (CustomFrameAnimationDrawable.a())) {
          this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = ((Bitmap)localObject1);
        }
        try
        {
          localObject1 = ImageUtil.a(((HeartBreakCombolEffectView.OneFrame)localObject3).a, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
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
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemHeartBreakCombolEffectView.c();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */