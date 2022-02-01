package com.tencent.mobileqq.apollo.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class CanvasDrawer
  extends AbsDrawer<Canvas>
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(2);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Rect b = new Rect();
  
  public boolean a(Canvas paramCanvas, float paramFloat)
  {
    if (paramCanvas == null) {
      return false;
    }
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Barrage localBarrage = (Barrage)localIterator.next();
        localBarrage.b();
        Object localObject;
        if (!localBarrage.a())
        {
          localIterator.remove();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("remove invalidate barrage:");
            ((StringBuilder)localObject).append(localBarrage);
            QLog.d("[cmshow]CanvasDrawer", 2, ((StringBuilder)localObject).toString());
          }
        }
        else
        {
          localObject = localBarrage.a();
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
          {
            paramCanvas.save();
            float f = 1.0F;
            if (paramFloat == 1.0F)
            {
              if (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() != localBarrage.d) {
                this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(localBarrage.d);
              }
            }
            else {
              this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(255.0F * paramFloat));
            }
            if (localBarrage.h > 0.0F) {
              f = localBarrage.h;
            }
            paramCanvas.clipRect(localBarrage.jdField_e_of_type_Float, localBarrage.jdField_f_of_type_Float, localBarrage.jdField_e_of_type_Float + localBarrage.jdField_e_of_type_Int * f, localBarrage.jdField_f_of_type_Float + localBarrage.jdField_f_of_type_Int * f);
            paramCanvas.translate(localBarrage.jdField_e_of_type_Float, localBarrage.jdField_f_of_type_Float);
            if (localBarrage.h != 0.0F) {
              paramCanvas.scale(localBarrage.h, localBarrage.h);
            }
            this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            this.b.set(0, 0, localBarrage.jdField_e_of_type_Int, localBarrage.jdField_f_of_type_Int);
            paramCanvas.drawBitmap((Bitmap)localObject, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
            paramCanvas.restore();
          }
        }
      }
      boolean bool = this.jdField_a_of_type_JavaUtilList.isEmpty();
      return bool ^ true;
    }
    finally {}
    for (;;)
    {
      throw paramCanvas;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.CanvasDrawer
 * JD-Core Version:    0.7.0.1
 */