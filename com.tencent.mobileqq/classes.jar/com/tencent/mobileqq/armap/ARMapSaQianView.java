package com.tencent.mobileqq.armap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.portal.SaQian;
import com.tencent.mobileqq.portal.SaQianView;
import java.util.ArrayList;

public class ARMapSaQianView
{
  private float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  public Context a;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public View a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = { 2130842277, 2130842278 };
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[2];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ARMapSaQianView(Context paramContext, int paramInt1, int paramInt2, View paramView)
  {
    this.jdField_a_of_type_Int = 255;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.f = AIOUtils.a(13.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.g = AIOUtils.a(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private void a(SaQian paramSaQian)
  {
    if (paramSaQian.jdField_d_of_type_Int == 0) {}
    for (paramSaQian.jdField_a_of_type_Int = this.f;; paramSaQian.jdField_a_of_type_Int = this.g)
    {
      if (paramSaQian.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramSaQian.jdField_b_of_type_Int = ((int)(paramSaQian.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / paramSaQian.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * paramSaQian.jdField_a_of_type_Int));
      }
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = (int)(2.0D * Math.random());
      if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j] != null)
      {
        SaQian localSaQian = SaQian.a(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j], this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, j, this.jdField_a_of_type_AndroidContentContext.getResources());
        a(localSaQian);
        localSaQian.jdField_a_of_type_Long = System.currentTimeMillis();
        localSaQian.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_JavaUtilArrayList.add(localSaQian);
      }
      i += 1;
    }
    this.jdField_b_of_type_Int += paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.e = (paramInt2 * 3 / 8);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 400L)
    {
      this.jdField_a_of_type_Long = l;
      if (this.jdField_b_of_type_Int <= 5) {
        a(1);
      }
    }
    int i = 0;
    SaQian localSaQian;
    float f1;
    float f2;
    if (i < this.jdField_b_of_type_Int)
    {
      localSaQian = (SaQian)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localSaQian.e = ((float)(System.currentTimeMillis() - localSaQian.jdField_a_of_type_Long) / 1000.0F);
      f1 = localSaQian.jdField_c_of_type_Float;
      f2 = localSaQian.e;
      float f3 = localSaQian.jdField_d_of_type_Float;
      float f4 = localSaQian.e;
      float f5 = SaQianView.a(400);
      float f6 = localSaQian.e;
      float f7 = localSaQian.e;
      localSaQian.jdField_a_of_type_ArrayOfFloat[0] = (f1 * f2 + this.jdField_a_of_type_Float);
      localSaQian.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_b_of_type_Float - (f3 * f4 - 0.5F * f5 * f6 * f7));
      if (localSaQian.jdField_c_of_type_Int > 200) {}
      for (localSaQian.jdField_c_of_type_Int -= 1;; localSaQian.jdField_c_of_type_Int -= (int)(5.0D * Math.random() + 26.0D))
      {
        if ((localSaQian.jdField_c_of_type_Int < 0) || ((this.e > 0) && (localSaQian.jdField_a_of_type_ArrayOfFloat[1] > this.e)))
        {
          localSaQian.jdField_a_of_type_ArrayOfFloat[0] = this.jdField_a_of_type_Float;
          localSaQian.jdField_a_of_type_ArrayOfFloat[1] = this.jdField_b_of_type_Float;
          localSaQian.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
          localSaQian.jdField_a_of_type_Long = System.currentTimeMillis();
          localSaQian.jdField_a_of_type_Double = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
          localSaQian.jdField_b_of_type_Float = (SaQianView.a(90) + (float)Math.random() * SaQianView.a(50));
          localSaQian.jdField_c_of_type_Float = ((float)(localSaQian.jdField_b_of_type_Float * Math.cos(localSaQian.jdField_a_of_type_Double)));
          localSaQian.jdField_d_of_type_Float = ((float)(localSaQian.jdField_b_of_type_Float * Math.sin(localSaQian.jdField_a_of_type_Double)));
          localSaQian.jdField_a_of_type_Float = ((float)Math.random() * SaQianView.a(18) - SaQianView.a(18));
          int j = (int)(2.0D * Math.random());
          Bitmap localBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[j];
          localSaQian.jdField_a_of_type_AndroidGraphicsBitmap = SaQian.a(j, localSaQian.jdField_a_of_type_Int, localSaQian.jdField_b_of_type_Int, localBitmap);
          a(localSaQian);
        }
        i += 1;
        break;
      }
    }
    i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      localSaQian = (SaQian)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localSaQian.jdField_a_of_type_ArrayOfFloat[0] < this.jdField_c_of_type_Int) && (localSaQian.jdField_a_of_type_ArrayOfFloat[0] > 0.0F) && (localSaQian.jdField_a_of_type_ArrayOfFloat[1] < this.jdField_d_of_type_Int) && (localSaQian.jdField_a_of_type_ArrayOfFloat[1] > 0.0F))
      {
        f1 = localSaQian.jdField_a_of_type_Int * 1.0F / localSaQian.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        f2 = localSaQian.jdField_b_of_type_Int * 1.0F / localSaQian.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(-localSaQian.jdField_a_of_type_Int / 2 / f1, -localSaQian.jdField_b_of_type_Int / 2 / f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(localSaQian.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(localSaQian.jdField_a_of_type_ArrayOfFloat[0] / f1, localSaQian.jdField_a_of_type_ArrayOfFloat[1] / f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f2);
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(localSaQian.jdField_c_of_type_Int);
        paramCanvas.drawBitmap(localSaQian.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      i += 1;
    }
    a();
  }
  
  public void b()
  {
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] == null) {
          this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_ArrayOfInt[i]);
        }
        i += 1;
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      this.jdField_a_of_type_Boolean = true;
      a();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapSaQianView
 * JD-Core Version:    0.7.0.1
 */