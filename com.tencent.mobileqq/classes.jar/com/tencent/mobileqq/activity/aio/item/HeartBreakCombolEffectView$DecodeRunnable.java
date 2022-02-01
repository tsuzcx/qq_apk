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
  ArrayList<Bitmap> jdField_a_of_type_JavaUtilArrayList;
  
  public HeartBreakCombolEffectView$DecodeRunnable(ArrayList<Bitmap> paramArrayList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  public void run()
  {
    while ((this.jdField_a_of_type_JavaUtilArrayList.size() < 2) && (this.this$0.b < this.this$0.jdField_a_of_type_JavaUtilArrayList.size()) && (HeartBreakCombolEffectView.jdField_a_of_type_Boolean))
    {
      Object localObject = this.this$0.jdField_a_of_type_JavaUtilArrayList;
      HeartBreakCombolEffectView localHeartBreakCombolEffectView = this.this$0;
      int i = localHeartBreakCombolEffectView.b;
      localHeartBreakCombolEffectView.b = (i + 1);
      HeartBreakCombolEffectView.OneFrame localOneFrame = (HeartBreakCombolEffectView.OneFrame)((ArrayList)localObject).get(i);
      if (localOneFrame != null)
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options;
        ((BitmapFactory.Options)localObject).inSampleSize = 1;
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_4444;
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
        i = HeartBreakCombolEffectView.a(this.this$0).size();
        localHeartBreakCombolEffectView = null;
        if (i > 0) {
          localObject = (Bitmap)HeartBreakCombolEffectView.a(this.this$0).remove(0);
        } else {
          localObject = null;
        }
        if ((localObject != null) && (!((Bitmap)localObject).isRecycled()) && (CustomFrameAnimationDrawable.a())) {
          this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = ((Bitmap)localObject);
        }
        try
        {
          localObject = ImageUtil.a(localOneFrame.a, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject = localHeartBreakCombolEffectView;
          if (QLog.isColorLevel())
          {
            QLog.d("HeartBreak", 2, localOutOfMemoryError.toString());
            localObject = localHeartBreakCombolEffectView;
          }
        }
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
      }
    }
    if (!HeartBreakCombolEffectView.jdField_a_of_type_Boolean) {
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */