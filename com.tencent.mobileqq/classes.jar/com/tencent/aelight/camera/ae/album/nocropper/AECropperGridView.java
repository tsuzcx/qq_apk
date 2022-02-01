package com.tencent.aelight.camera.ae.album.nocropper;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.aelight.camera.impl.R.styleable;

public class AECropperGridView
  extends View
{
  private float jdField_a_of_type_Float = 0.8F;
  private int jdField_a_of_type_Int = 268435455;
  private long jdField_a_of_type_Long = 200L;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AECropperGridView.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 200;
  private int c = 3;
  
  public AECropperGridView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public AECropperGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
    a(paramContext, paramAttributeSet);
  }
  
  public AECropperGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c);
      this.jdField_a_of_type_Int = paramContext.getColor(0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Float = paramContext.getFloat(1, 1.0F);
      float f2 = this.jdField_a_of_type_Float * 255.0F;
      float f1;
      if (f2 < 0.0F)
      {
        f1 = 0.0F;
      }
      else
      {
        f1 = f2;
        if (f2 > 255.0F) {
          f1 = 255.0F;
        }
      }
      this.b = ((int)f1);
      this.c = paramContext.getDimensionPixelOffset(2, this.c);
      paramContext.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.b);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if (isInEditMode()) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = paramCanvas.getWidth();
    int j = paramCanvas.getHeight();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    float f2 = i / 3;
    localPath.moveTo(f2, 0.0F);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    float f1 = j;
    localPath.lineTo(f2, f1);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    f2 = i * 2 / 3;
    localPath.moveTo(f2, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f2, f1);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    f2 = j / 3;
    localPath.moveTo(0.0F, f2);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    f1 = i;
    localPath.lineTo(f1, f2);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    f2 = j * 2 / 3;
    localPath.moveTo(0.0F, f2);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1, f2);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getContext().getResources().getConfiguration().orientation;
    if ((i != 1) && (i != 0))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt1);
      return;
    }
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    setMeasuredDimension(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
  }
  
  public void setShowGrid(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        setAlpha(this.jdField_a_of_type_Float);
        invalidate();
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.AECropperGridView
 * JD-Core Version:    0.7.0.1
 */