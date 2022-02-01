package com.tencent.mobileqq.ar.ARRecord;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ARVideoRecordButtonView
  extends View
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 2;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = null;
  private float jdField_b_of_type_Float = 0.0F;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap = null;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = null;
  private Bitmap c = null;
  
  public ARVideoRecordButtonView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ARVideoRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ARVideoRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private Bitmap a(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-48606);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsBitmap = a(2130838604);
    this.c = a(2130838605);
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.addUpdateListener(new ARVideoRecordButtonView.3(this));
    localValueAnimator.start();
  }
  
  private void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    int k = this.jdField_a_of_type_Int;
    Object localObject;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3) {
          return;
        }
        localObject = this.c;
        if (localObject != null)
        {
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), this.c.getHeight());
          this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
          paramCanvas.drawBitmap(this.c, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        float f2 = i;
        float f1 = 0.08571429F * f2;
        f2 = Math.min(i, j) / 2 - f1 - f2 * 0.002857143F;
        localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
        float f3 = i / 2;
        float f4 = j / 2;
        ((RectF)localObject).set(f3 - f2, f4 - f2, f3 + f2, f4 + f2);
        this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
        paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F, false, this.jdField_b_of_type_AndroidGraphicsPaint);
        f1 = this.jdField_a_of_type_Float;
        paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F - (1.0F - f1) * 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localObject != null)
      {
        this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
  }
  
  public void setProgress(long paramLong1, long paramLong2)
  {
    float f = Math.min(1.0F, Math.max((float)paramLong1 * 1.0F / (float)paramLong2, 0.0F));
    if (this.jdField_a_of_type_Int == 3) {
      ThreadManager.getUIHandler().post(new ARVideoRecordButtonView.1(this, f));
    }
  }
  
  public void setShowState(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramInt = this.jdField_a_of_type_Int;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          this.jdField_a_of_type_Float = 0.0F;
        }
      }
      else
      {
        this.jdField_b_of_type_Float = 0.0F;
        this.jdField_a_of_type_Float = 0.0F;
        ThreadManager.getUIHandler().post(new ARVideoRecordButtonView.2(this));
      }
    }
    else {
      super.setAlpha(1.0F);
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView
 * JD-Core Version:    0.7.0.1
 */