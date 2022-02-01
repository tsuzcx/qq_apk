package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;

public class AEDoodlePenWidthSeekBar
  extends View
{
  private float jdField_a_of_type_Float = 0.5F;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private AEDoodlePenWidthSeekBar.OnSeekBarChangeListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar$OnSeekBarChangeListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  
  public AEDoodlePenWidthSeekBar(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AEDoodlePenWidthSeekBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public static float a(Context paramContext)
  {
    if (paramContext == null) {
      return 0.0F;
    }
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * a(paramContext) + 0.5F);
  }
  
  private void a()
  {
    Resources localResources = getResources();
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(localResources, 2130837741);
    this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(localResources, 2130837742);
    this.jdField_a_of_type_Int = a(getContext(), 21.25F);
    this.jdField_b_of_type_Int = a(getContext(), 15.5F);
    this.jdField_c_of_type_Int = a(getContext(), 270.0F);
    this.d = a(getContext(), 3.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getMeasuredHeight();
    float f1 = getMeasuredWidth() / 2;
    int j = this.jdField_b_of_type_Int / 2;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f2 = j;
    j = this.jdField_a_of_type_Int;
    int k = this.d;
    localRectF.set(f1 - f2, j - k, f1 + f2, i - j + k);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    j = this.jdField_a_of_type_Int;
    f1 = (i - j - j) * (1.0F - this.jdField_a_of_type_Float);
    localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    f2 = j;
    float f3 = j;
    float f4 = getMeasuredWidth();
    i = this.jdField_a_of_type_Int;
    localRectF.set(0.0F, f2 + f1 - f3, f4, i + f1 + i);
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_Int;
    paramInt1 += paramInt1;
    paramInt2 = this.jdField_c_of_type_Int;
    int i = this.d;
    setMeasuredDimension(paramInt1, paramInt2 - i - i + paramInt1);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          float f1 = paramMotionEvent.getY() - this.jdField_c_of_type_Float;
          float f2 = this.jdField_b_of_type_AndroidGraphicsRectF.centerY();
          i = getMeasuredHeight();
          float f3 = f2 + f1;
          int j = this.jdField_a_of_type_Int;
          if (f3 < j) {}
          for (f1 = j;; f1 = i - j)
          {
            f1 -= f2;
            break;
            if (f3 <= i - j) {
              break;
            }
          }
          if (f1 != 0.0F)
          {
            Object localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
            ((RectF)localObject).top += f1;
            localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
            ((RectF)localObject).bottom += f1;
            f1 = this.jdField_b_of_type_AndroidGraphicsRectF.centerY();
            j = this.jdField_a_of_type_Int;
            this.jdField_a_of_type_Float = (1.0F - (f1 - j) / (i - j - j));
            localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar$OnSeekBarChangeListener;
            if (localObject != null) {
              ((AEDoodlePenWidthSeekBar.OnSeekBarChangeListener)localObject).a(this.jdField_a_of_type_Float);
            }
            invalidate();
          }
        }
        this.jdField_c_of_type_Float = paramMotionEvent.getY();
        return true;
      }
      this.jdField_a_of_type_Boolean = false;
      return true;
    }
    this.jdField_b_of_type_Float = paramMotionEvent.getX();
    this.jdField_c_of_type_Float = paramMotionEvent.getY();
    if (this.jdField_b_of_type_AndroidGraphicsRectF.contains(this.jdField_b_of_type_Float, this.jdField_c_of_type_Float)) {
      this.jdField_a_of_type_Boolean = true;
    }
    return true;
  }
  
  public void setOnSeekBarChangeListener(AEDoodlePenWidthSeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiPanelAEDoodlePenWidthSeekBar$OnSeekBarChangeListener = paramOnSeekBarChangeListener;
  }
  
  public void setProgress(float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      if (paramFloat > 1.0F) {
        return;
      }
      this.jdField_a_of_type_Float = paramFloat;
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        invalidate();
        return;
      }
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.AEDoodlePenWidthSeekBar
 * JD-Core Version:    0.7.0.1
 */