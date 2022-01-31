package com.tencent.mobileqq.activity.aio.audiopanel;

import aciy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class MoveDistIndicateView
  extends ImageView
{
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public int b;
  private Bitmap b;
  private int c;
  private int d;
  private int e;
  
  public MoveDistIndicateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    paramContext = getResources();
    this.jdField_a_of_type_Int = aciy.a(29.0F, paramContext);
    this.jdField_b_of_type_Int = aciy.a(42.0F, paramContext);
    this.e = aciy.a(8.0F, paramContext);
    this.c = this.jdField_a_of_type_Int;
    if (QLog.isDevelopLevel()) {
      QLog.d("MoveDistIndicateView", 4, "init(), mRaidusMin:" + this.jdField_a_of_type_Int + ",mRaidusMax:" + this.jdField_b_of_type_Int);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    int m = i / 2;
    int n = j / 2;
    int k = paramCanvas.getSaveCount();
    paramCanvas.save();
    float f1;
    if (this.c > this.jdField_a_of_type_Int + this.e) {
      if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
      {
        f1 = this.jdField_b_of_type_Int / this.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        m = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
        n = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate((i - m * f1) / 2.0F, (j - f1 * n) / 2.0F);
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, m, n);
        paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      }
    }
    for (;;)
    {
      paramCanvas.restoreToCount(k);
      super.onDraw(paramCanvas);
      return;
      if (this.d == 1) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131101363));
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        paramCanvas.drawCircle(m, n, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
        break;
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131101364));
      }
      if (this.c > this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131101259));
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        paramCanvas.drawCircle(m, n, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      else
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          break;
        }
        f1 = this.c / this.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        m = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        n = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        float f2 = (i - m * f1) * 0.5F + 0.5F;
        float f3 = (j - n * f1) * 0.5F + 0.5F;
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "dx is:" + f2 + ",dy is:" + f3);
        }
        this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(f1, f1);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f2, f3);
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, m, n);
        paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
      }
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711423);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      paramCanvas.drawCircle(m, n, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
      break;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    }
  }
  
  public void setAfterBitmap(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setLevel(int paramInt)
  {
    this.c = (this.jdField_a_of_type_Int + (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int) * paramInt / 100);
    if (QLog.isDevelopLevel()) {
      QLog.d("MoveDistIndicateView", 4, "setLevel(), max=" + this.jdField_b_of_type_Int + " min=" + this.jdField_a_of_type_Int + " mRadius=" + this.c + " type =" + this.d + " level=" + paramInt);
    }
    if (paramInt == 100) {
      setPressed(true);
    }
    for (;;)
    {
      invalidate();
      return;
      setPressed(false);
    }
  }
  
  public void setScaleBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setType(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.MoveDistIndicateView
 * JD-Core Version:    0.7.0.1
 */