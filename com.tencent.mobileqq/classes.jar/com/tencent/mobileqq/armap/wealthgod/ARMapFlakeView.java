package com.tencent.mobileqq.armap.wealthgod;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ARMapFlakeView
  extends View
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int = 100;
  long jdField_a_of_type_Long;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = true;
  int[] jdField_a_of_type_ArrayOfInt = { 2130842657, 2130842658, 2130842655, 2130842656 };
  Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = { null, null, null, null };
  int jdField_b_of_type_Int = 2130842312;
  long jdField_b_of_type_Long;
  int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 1200L;
  private int d = 1;
  
  public ARMapFlakeView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ARMapFlakeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ARMapFlakeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Matrix a(ARMapFlake paramARMapFlake)
  {
    float f1 = paramARMapFlake.jdField_a_of_type_Int * 1.0F / paramARMapFlake.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    float f2 = paramARMapFlake.jdField_b_of_type_Int * 1.0F / paramARMapFlake.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-paramARMapFlake.jdField_a_of_type_Int / 2 / f1, -paramARMapFlake.jdField_b_of_type_Int / 2 / f2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(paramARMapFlake.jdField_c_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((paramARMapFlake.jdField_a_of_type_Int / 2 + paramARMapFlake.jdField_a_of_type_Float) / f1, (paramARMapFlake.jdField_b_of_type_Int / 2 + paramARMapFlake.jdField_b_of_type_Float) / f2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f2);
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramInt)
      {
        int j = (int)(4.0D * Math.random()) % this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length;
        if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] == null) {}
        try
        {
          this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] = BitmapFactory.decodeResource(getResources(), this.jdField_a_of_type_ArrayOfInt[j]);
          if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] != null)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(ARMapFlake.a(getWidth(), this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], 1, getResources(), this.d));
            this.jdField_c_of_type_Int += 1;
          }
          i += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] = null;
            if (QLog.isColorLevel()) {
              QLog.i("FlakeView", 2, "OutOfMemoryError:" + localOutOfMemoryError.getMessage());
            }
          }
        }
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Long = l;
      this.jdField_b_of_type_Long = l;
      invalidate();
    }
  }
  
  public void b(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      if (i < paramInt)
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
        try
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), this.jdField_b_of_type_Int);
          if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            this.jdField_a_of_type_JavaUtilArrayList.add(ARMapFlake.a(getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap, 2, getResources(), this.d));
            this.jdField_c_of_type_Int += 1;
          }
          i += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = null;
            if (QLog.isColorLevel()) {
              QLog.i("FlakeView", 2, "OutOfMemoryError:" + localOutOfMemoryError.getMessage());
            }
          }
        }
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - (1000.0F * this.jdField_a_of_type_Float));
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
    paramInt = 0;
    while (paramInt < this.jdField_c_of_type_Int)
    {
      if ((((ARMapFlake)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_c_of_type_Int == 1) || (((ARMapFlake)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_c_of_type_Int == 2)) {
        ((ARMapFlake)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).e = ARMapFlake.a(this.d, getResources());
      }
      paramInt += 1;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.onDraw(paramCanvas);
    long l = System.currentTimeMillis();
    if (l - this.jdField_b_of_type_Long > this.jdField_c_of_type_Long)
    {
      this.jdField_b_of_type_Long = l;
      if (this.jdField_a_of_type_Int != 100) {
        break label281;
      }
      if (this.jdField_c_of_type_Int < 13) {
        a(3);
      }
    }
    int n = getHeight();
    int i1 = getWidth();
    this.jdField_a_of_type_Float = ((float)(l - this.jdField_a_of_type_Long) / 1000.0F);
    this.jdField_a_of_type_Long = l;
    int j = 0;
    int k = 0;
    label100:
    if (j < this.jdField_c_of_type_Int)
    {
      ARMapFlake localARMapFlake = (ARMapFlake)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      localARMapFlake.jdField_b_of_type_Float += localARMapFlake.e * this.jdField_a_of_type_Float;
      localARMapFlake.jdField_c_of_type_Float += localARMapFlake.d * this.jdField_a_of_type_Float;
      int i;
      if (this.jdField_a_of_type_Int == 100)
      {
        if (localARMapFlake.jdField_b_of_type_Float > localARMapFlake.jdField_b_of_type_Int + n)
        {
          localARMapFlake.jdField_a_of_type_Float = ((float)Math.random() * (i1 - localARMapFlake.jdField_a_of_type_Int));
          if (localARMapFlake.jdField_c_of_type_Int == 1)
          {
            localARMapFlake.jdField_b_of_type_Float = (0 - localARMapFlake.jdField_b_of_type_Int);
            localARMapFlake.jdField_a_of_type_Float = ((float)Math.random() * (getWidth() - localARMapFlake.jdField_a_of_type_Int));
          }
        }
        paramCanvas.drawBitmap(localARMapFlake.jdField_a_of_type_AndroidGraphicsBitmap, a(localARMapFlake), null);
        i = k;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break label100;
        if ((this.jdField_a_of_type_Int != 101) || (this.jdField_c_of_type_Int >= 16)) {
          break;
        }
        b(16);
        break;
        i = k;
        if (this.jdField_a_of_type_Int == 101)
        {
          if (localARMapFlake.jdField_b_of_type_Float <= localARMapFlake.jdField_b_of_type_Int + n) {
            break label346;
          }
          i = k + 1;
        }
      }
      int m = (int)(Math.cos((localARMapFlake.jdField_b_of_type_Float + localARMapFlake.jdField_b_of_type_Int) / n * 3.141592653589793D / 2.0D) * 175.0D);
      if (m < 0) {
        i = 0;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
        paramCanvas.drawBitmap(localARMapFlake.jdField_a_of_type_AndroidGraphicsBitmap, a(localARMapFlake), this.jdField_a_of_type_AndroidGraphicsPaint);
        i = k;
        break;
        i = m;
        if (m > 175) {
          i = 175;
        }
      }
    }
    label281:
    label346:
    if ((this.jdField_a_of_type_Int == 101) && (k >= this.jdField_c_of_type_Int))
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_c_of_type_Int = 0;
    }
    invalidate();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_Int = 0;
  }
  
  public void setDataType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 100: 
      this.jdField_c_of_type_Long = 1200L;
      c(1);
      return;
    }
    this.jdField_c_of_type_Long = 1000L;
    c(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.ARMapFlakeView
 * JD-Core Version:    0.7.0.1
 */