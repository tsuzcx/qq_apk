package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class EntryBgView
  extends View
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private View jdField_a_of_type_AndroidViewView;
  private int b;
  private int c;
  private int d;
  
  public EntryBgView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EntryBgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EntryBgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f2 = 0.0F;
    for (;;)
    {
      int k;
      try
      {
        super.onDraw(paramCanvas);
        int m;
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
          j = this.jdField_a_of_type_Int;
          int n = this.b;
          k = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
          m = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          if (j == 0) {
            break label234;
          }
          i = n;
          if (n == 0) {
            break label234;
          }
          if ((this.c == 0) || (this.d == 0))
          {
            this.c = k;
            this.d = m;
          }
          if (k * i > j * m)
          {
            f1 = i / m;
            this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f1);
            float f4 = k * f1;
            float f3 = m * f1;
            if (f4 <= this.c) {
              continue;
            }
            f1 = (this.c - f4) / 2.0F;
            if (f3 > this.d) {
              f2 = (this.d - f3) / 2.0F;
            }
            this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f1, f2);
            paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
          }
        }
        else
        {
          return;
        }
        float f1 = j / k;
        continue;
        f1 = 0.0F;
        continue;
        int i = m;
      }
      catch (Throwable paramCanvas)
      {
        QLog.e("springHb_EntryBgView", 1, "EntryBgView_onDraw", paramCanvas);
        return;
      }
      label234:
      int j = k;
    }
  }
  
  public void setTargetView(View paramView, Bitmap paramBitmap)
  {
    if ((paramView == null) || (paramBitmap == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewView.getWidth();
    this.b = this.jdField_a_of_type_AndroidViewView.getHeight();
    this.c = this.jdField_a_of_type_AndroidViewView.getWidth();
    this.d = this.jdField_a_of_type_AndroidViewView.getHeight();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.ui.EntryBgView
 * JD-Core Version:    0.7.0.1
 */