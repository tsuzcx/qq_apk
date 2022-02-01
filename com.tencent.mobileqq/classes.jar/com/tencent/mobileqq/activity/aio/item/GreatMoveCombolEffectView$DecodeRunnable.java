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
          break label209;
        }
        localObject1 = this.this$0.jdField_a_of_type_JavaUtilArrayList;
        localObject4 = this.this$0;
        int i = ((GreatMoveCombolEffectView)localObject4).b;
        ((GreatMoveCombolEffectView)localObject4).b = (i + 1);
        localObject4 = (GreatMoveCombolEffectView.OneFrame)((ArrayList)localObject1).get(i);
        if (localObject4 == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inSampleSize = 1;
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inPreferredConfig = Bitmap.Config.ARGB_4444;
        this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inMutable = true;
        if (GreatMoveCombolEffectView.a(this.this$0).size() <= 0) {
          break label225;
        }
        localObject1 = (Bitmap)GreatMoveCombolEffectView.a(this.this$0).remove(0);
        if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()) && (CustomFrameAnimationDrawable.a())) {
          this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.inBitmap = ((Bitmap)localObject1);
        }
      }
      finally
      {
        try
        {
          Object localObject4;
          Object localObject1 = ImageUtil.a(((GreatMoveCombolEffectView.OneFrame)localObject4).a, this.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options);
          if (localObject1 == null) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            break label230;
          }
        }
        localObject2 = finally;
      }
      QLog.d("GreatMove", 2, localOutOfMemoryError.toString());
      break label230;
      label209:
      if (!GreatMoveCombolEffectView.jdField_a_of_type_Boolean) {
        this.this$0.c();
      }
      return;
      label225:
      Object localObject3 = null;
      continue;
      label230:
      localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GreatMoveCombolEffectView.DecodeRunnable
 * JD-Core Version:    0.7.0.1
 */