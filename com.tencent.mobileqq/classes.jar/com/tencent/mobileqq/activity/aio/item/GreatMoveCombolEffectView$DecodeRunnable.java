package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

public class GreatMoveCombolEffectView$DecodeRunnable
  implements Runnable
{
  BitmapFactory.Options jdField_a_of_type_AndroidGraphicsBitmapFactory$Options = new BitmapFactory.Options();
  ArrayList<Bitmap> jdField_a_of_type_JavaUtilArrayList;
  
  public GreatMoveCombolEffectView$DecodeRunnable(ArrayList<Bitmap> paramArrayList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilArrayList = localObject;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() >= 2) || (this.this$0.b >= this.this$0.jdField_a_of_type_JavaUtilArrayList.size()) || (!GreatMoveCombolEffectView.jdField_a_of_type_Boolean)) {
          continue;
        }
        localObject1 = this.this$0.jdField_a_of_type_JavaUtilArrayList;
        localGreatMoveCombolEffectView = this.this$0;
        int i = localGreatMoveCombolEffectView.b;
        localGreatMoveCombolEffectView.b = (i + 1);
        localOneFrame = (GreatMoveCombolEffectView.OneFrame)((ArrayList)localObject1).get(i);
        if (localOneFrame == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inPreferredConfig = Bitmap.Config.ARGB_4444;
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
        i = GreatMoveCombolEffectView.a(this.this$0).size();
        localGreatMoveCombolEffectView = null;
        if (i <= 0) {
          continue;
        }
        localObject1 = (Bitmap)GreatMoveCombolEffectView.a(this.this$0).remove(0);
      }
      finally
      {
        Object localObject1;
        GreatMoveCombolEffectView localGreatMoveCombolEffectView;
        GreatMoveCombolEffectView.OneFrame localOneFrame;
        continue;
        throw localObject2;
        continue;
        Object localObject3 = null;
        continue;
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()) && (CustomFrameAnimationDrawable.a())) {
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = ((Bitmap)localObject1);
      }
      try
      {
        localObject1 = ImageUtil.a(localOneFrame.a, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = localGreatMoveCombolEffectView;
        if (QLog.isColorLevel())
        {
          QLog.d("GreatMove", 2, localOutOfMemoryError.toString());
          localObject1 = localGreatMoveCombolEffectView;
        }
      }
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
    if (!GreatMoveCombolEffectView.jdField_a_of_type_Boolean) {
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GreatMoveCombolEffectView.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */