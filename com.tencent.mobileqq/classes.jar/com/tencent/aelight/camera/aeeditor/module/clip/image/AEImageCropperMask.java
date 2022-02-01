package com.tencent.aelight.camera.aeeditor.module.clip.image;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.impl.R.styleable;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.tavcut.bean.CropConfig;

public class AEImageCropperMask
  extends View
{
  private static final int jdField_b_of_type_Int = Color.parseColor("#59C4C4C4");
  private static final int jdField_c_of_type_Int = ViewUtils.b(4.0F);
  private static final int jdField_d_of_type_Int = ViewUtils.b(16.0F);
  private float jdField_a_of_type_Float = 0.8F;
  public int a;
  private long jdField_a_of_type_Long = 200L;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected GestureDetector a;
  private AEImageCropperContainer jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float = 0.0F;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private boolean jdField_b_of_type_Boolean = false;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private boolean jdField_c_of_type_Boolean = true;
  private Rect jdField_d_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 268435455;
  private Rect jdField_e_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 200;
  private Rect jdField_f_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 3;
  private Rect jdField_g_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private int jdField_h_of_type_Int;
  private Rect jdField_h_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  private int jdField_i_of_type_Int;
  private Rect jdField_i_of_type_AndroidGraphicsRect = null;
  private int jdField_j_of_type_Int = 0;
  private Rect jdField_j_of_type_AndroidGraphicsRect = null;
  private int jdField_k_of_type_Int = 0;
  private Rect jdField_k_of_type_AndroidGraphicsRect = null;
  private int l = 0;
  
  public AEImageCropperMask(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    a(paramContext, null);
  }
  
  public AEImageCropperMask(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  public AEImageCropperMask(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    a(paramContext, paramAttributeSet);
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3)
  {
    return null;
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    int m = (int)(this.jdField_j_of_type_AndroidGraphicsRect.left - paramFloat1);
    int i1 = (int)(this.jdField_j_of_type_AndroidGraphicsRect.top - paramFloat2);
    int i2 = (int)(this.jdField_j_of_type_AndroidGraphicsRect.right - paramFloat1);
    int i3 = (int)(this.jdField_j_of_type_AndroidGraphicsRect.bottom - paramFloat2);
    Rect localRect = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.a().a();
    int n;
    if (m < localRect.left)
    {
      m = localRect.left;
      n = localRect.left + (this.jdField_j_of_type_AndroidGraphicsRect.right - this.jdField_j_of_type_AndroidGraphicsRect.left);
    }
    else
    {
      n = i2;
      if (i2 > localRect.right)
      {
        n = localRect.right;
        m = localRect.right - (this.jdField_j_of_type_AndroidGraphicsRect.right - this.jdField_j_of_type_AndroidGraphicsRect.left);
      }
    }
    if (i1 < localRect.top)
    {
      i1 = localRect.top;
      i2 = localRect.top + (this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top);
    }
    else
    {
      i2 = i3;
      if (i3 > localRect.bottom)
      {
        i2 = localRect.bottom;
        i1 = localRect.bottom - (this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top);
      }
    }
    this.jdField_j_of_type_AndroidGraphicsRect = new Rect(m, i1, n, i2);
    invalidate();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.c);
      this.jdField_e_of_type_Int = paramAttributeSet.getColor(0, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_Float = paramAttributeSet.getFloat(1, 1.0F);
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
      this.jdField_f_of_type_Int = ((int)f1);
      this.jdField_g_of_type_Int = paramAttributeSet.getDimensionPixelOffset(2, this.jdField_g_of_type_Int);
      paramAttributeSet.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_e_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(ViewUtils.b(2.0F));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new AEImageCropperMask.GestureListener(this, null), null, true);
  }
  
  private void a(Rect paramRect1, Rect paramRect2)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 20 });
    localValueAnimator.addUpdateListener(new AEImageCropperMask.1(this, paramRect1, paramRect2));
    localValueAnimator.addListener(new AEImageCropperMask.2(this));
    localValueAnimator.start();
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 != 0.0F)
    {
      if (paramFloat2 == 0.0F) {
        return;
      }
      int m = this.jdField_j_of_type_AndroidGraphicsRect.right;
      int n = this.jdField_j_of_type_AndroidGraphicsRect.left;
      int i1 = this.jdField_j_of_type_AndroidGraphicsRect.bottom;
      int i2 = this.jdField_j_of_type_AndroidGraphicsRect.top;
      float f2 = m - n;
      float f3 = i1 - i2;
      float f1 = f2 * 1.0F / f3;
      if (Math.abs(paramFloat2 / f3) > Math.abs(paramFloat1 / f2)) {
        paramFloat1 = paramFloat1 / Math.abs(paramFloat1) * Math.abs(f2 * paramFloat2 / f3);
      } else {
        paramFloat2 = paramFloat2 / Math.abs(paramFloat2) * Math.abs(f3 * paramFloat1 / f2);
      }
      paramMotionEvent1 = new Rect(this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.top, this.jdField_j_of_type_AndroidGraphicsRect.right, this.jdField_j_of_type_AndroidGraphicsRect.bottom);
      paramMotionEvent2 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.a().a();
      if ((this.jdField_j_of_type_Int == 0) && (paramFloat1 * paramFloat2 > 0.0F))
      {
        paramMotionEvent1.left -= (int)paramFloat1;
        paramMotionEvent1.top -= (int)paramFloat2;
        if ((paramMotionEvent1.left < paramMotionEvent2.left) && (paramMotionEvent1.top < paramMotionEvent2.top))
        {
          if ((paramMotionEvent2.left - paramMotionEvent1.left) * 1.0F / (paramMotionEvent2.top - paramMotionEvent1.top) > f1)
          {
            paramMotionEvent1.left = paramMotionEvent2.left;
            paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else
          {
            paramMotionEvent1.top = paramMotionEvent2.top;
            paramMotionEvent1.left = (paramMotionEvent1.right - (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
          }
        }
        else if (paramMotionEvent1.left < paramMotionEvent2.left)
        {
          paramMotionEvent1.left = paramMotionEvent2.left;
          paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
        }
        else if (paramMotionEvent1.top < paramMotionEvent2.top)
        {
          paramMotionEvent1.top = paramMotionEvent2.top;
          paramMotionEvent1.left = (paramMotionEvent1.right - (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
        }
        else
        {
          paramMotionEvent2 = this.jdField_i_of_type_AndroidGraphicsRect;
          if ((paramMotionEvent2 != null) && ((paramMotionEvent2.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.left = (paramMotionEvent1.right - (int)((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / 5.0F));
            paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((this.jdField_i_of_type_AndroidGraphicsRect.bottom - this.jdField_i_of_type_AndroidGraphicsRect.top) * 1.0F / 5.0F));
          }
        }
      }
      else if ((this.jdField_j_of_type_Int == 1) && (paramFloat1 * paramFloat2 < 0.0F))
      {
        paramMotionEvent1.top -= (int)paramFloat2;
        paramMotionEvent1.right -= (int)paramFloat1;
        if ((paramMotionEvent1.right > paramMotionEvent2.right) && (paramMotionEvent1.top < paramMotionEvent2.top))
        {
          if ((paramMotionEvent1.right - paramMotionEvent2.right) * 1.0F / (paramMotionEvent2.top - paramMotionEvent1.top) > f1)
          {
            paramMotionEvent1.right = paramMotionEvent2.right;
            paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else
          {
            paramMotionEvent1.top = paramMotionEvent2.top;
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
          }
        }
        else if (paramMotionEvent1.right > paramMotionEvent2.right)
        {
          paramMotionEvent1.right = paramMotionEvent2.right;
          paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
        }
        else if (paramMotionEvent1.top < paramMotionEvent2.top)
        {
          paramMotionEvent1.top = paramMotionEvent2.top;
          paramMotionEvent1.right = (paramMotionEvent1.left + (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
        }
        else
        {
          paramMotionEvent2 = this.jdField_i_of_type_AndroidGraphicsRect;
          if ((paramMotionEvent2 != null) && ((paramMotionEvent2.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / 5.0F));
            paramMotionEvent1.top = (paramMotionEvent1.bottom - (int)((this.jdField_i_of_type_AndroidGraphicsRect.bottom - this.jdField_i_of_type_AndroidGraphicsRect.top) * 1.0F / 5.0F));
          }
        }
      }
      else if ((this.jdField_j_of_type_Int == 2) && (paramFloat1 * paramFloat2 < 0.0F))
      {
        paramMotionEvent1.left -= (int)paramFloat1;
        paramMotionEvent1.bottom -= (int)paramFloat2;
        if ((paramMotionEvent1.left < paramMotionEvent2.left) && (paramMotionEvent1.bottom > paramMotionEvent2.bottom))
        {
          if ((paramMotionEvent2.left - paramMotionEvent1.left) * 1.0F / (paramMotionEvent1.bottom - paramMotionEvent2.bottom) > f1)
          {
            paramMotionEvent1.left = paramMotionEvent2.left;
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else
          {
            paramMotionEvent1.bottom = paramMotionEvent2.bottom;
            paramMotionEvent1.left = (paramMotionEvent1.right - (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
          }
        }
        else if (paramMotionEvent1.left < paramMotionEvent2.left)
        {
          paramMotionEvent1.left = paramMotionEvent2.left;
          paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
        }
        else if (paramMotionEvent1.bottom > paramMotionEvent2.bottom)
        {
          paramMotionEvent1.bottom = paramMotionEvent2.bottom;
          paramMotionEvent1.left = (paramMotionEvent1.right - (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
        }
        else
        {
          paramMotionEvent2 = this.jdField_i_of_type_AndroidGraphicsRect;
          if ((paramMotionEvent2 != null) && ((paramMotionEvent2.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.left = (paramMotionEvent1.right - (int)((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / 5.0F));
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((this.jdField_i_of_type_AndroidGraphicsRect.bottom - this.jdField_i_of_type_AndroidGraphicsRect.top) * 1.0F / 5.0F));
          }
        }
      }
      else if ((this.jdField_j_of_type_Int == 3) && (paramFloat1 * paramFloat2 > 0.0F))
      {
        paramMotionEvent1.right -= (int)paramFloat1;
        paramMotionEvent1.bottom -= (int)paramFloat2;
        if ((paramMotionEvent1.right > paramMotionEvent2.right) && (paramMotionEvent1.bottom > paramMotionEvent2.bottom))
        {
          if ((paramMotionEvent2.left - paramMotionEvent1.left) * 1.0F / (paramMotionEvent2.top - paramMotionEvent1.top) > f1)
          {
            paramMotionEvent1.right = paramMotionEvent2.right;
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
          }
          else
          {
            paramMotionEvent1.bottom = paramMotionEvent2.bottom;
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
          }
        }
        else if (paramMotionEvent1.right > paramMotionEvent2.right)
        {
          paramMotionEvent1.right = paramMotionEvent2.right;
          paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((paramMotionEvent1.right - paramMotionEvent1.left) / f1));
        }
        else if (paramMotionEvent1.bottom > paramMotionEvent2.bottom)
        {
          paramMotionEvent1.bottom = paramMotionEvent2.bottom;
          paramMotionEvent1.right = (paramMotionEvent1.left + (int)((paramMotionEvent1.bottom - paramMotionEvent1.top) * f1));
        }
        else
        {
          paramMotionEvent2 = this.jdField_i_of_type_AndroidGraphicsRect;
          if ((paramMotionEvent2 != null) && ((paramMotionEvent2.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / (paramMotionEvent1.right - paramMotionEvent1.left) > 5.0F))
          {
            paramMotionEvent1.right = (paramMotionEvent1.left + (int)((this.jdField_i_of_type_AndroidGraphicsRect.right - this.jdField_i_of_type_AndroidGraphicsRect.left) * 1.0F / 5.0F));
            paramMotionEvent1.bottom = (paramMotionEvent1.top + (int)((this.jdField_i_of_type_AndroidGraphicsRect.bottom - this.jdField_i_of_type_AndroidGraphicsRect.top) * 1.0F / 5.0F));
          }
        }
      }
      this.jdField_j_of_type_AndroidGraphicsRect = paramMotionEvent1;
      invalidate();
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    int m = this.jdField_j_of_type_AndroidGraphicsRect.right;
    int n = this.jdField_j_of_type_AndroidGraphicsRect.left;
    int i1 = this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top;
    float f3 = paramMotionEvent.getX();
    float f4 = this.jdField_j_of_type_AndroidGraphicsRect.left;
    float f2 = m - n;
    float f1 = f2 * 1.0F / 3.0F;
    if ((f3 - f4 < f1) && (paramMotionEvent.getY() - this.jdField_j_of_type_AndroidGraphicsRect.top < i1 * 1.0F / 3.0F))
    {
      this.jdField_j_of_type_Int = 0;
      return true;
    }
    f3 = paramMotionEvent.getX();
    f4 = this.jdField_j_of_type_AndroidGraphicsRect.left;
    f2 = f2 * 2.0F / 3.0F;
    if ((f3 - f4 > f2) && (paramMotionEvent.getY() - this.jdField_j_of_type_AndroidGraphicsRect.top < i1 * 1.0F / 3.0F))
    {
      this.jdField_j_of_type_Int = 1;
      return true;
    }
    if ((paramMotionEvent.getX() - this.jdField_j_of_type_AndroidGraphicsRect.left < f1) && (paramMotionEvent.getY() - this.jdField_j_of_type_AndroidGraphicsRect.top > i1 * 2.0F / 3.0F))
    {
      this.jdField_j_of_type_Int = 2;
      return true;
    }
    if ((paramMotionEvent.getX() - this.jdField_j_of_type_AndroidGraphicsRect.left > f2) && (paramMotionEvent.getY() - this.jdField_j_of_type_AndroidGraphicsRect.top > i1 * 2.0F / 3.0F))
    {
      this.jdField_j_of_type_Int = 3;
      return true;
    }
    return false;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    return (this.jdField_j_of_type_AndroidGraphicsRect != null) && (paramMotionEvent.getX() >= this.jdField_j_of_type_AndroidGraphicsRect.left - AEImageCropperContainer.jdField_a_of_type_Int) && (paramMotionEvent.getX() <= this.jdField_j_of_type_AndroidGraphicsRect.right + AEImageCropperContainer.jdField_a_of_type_Int) && (paramMotionEvent.getY() >= this.jdField_j_of_type_AndroidGraphicsRect.top - AEImageCropperContainer.jdField_a_of_type_Int) && (paramMotionEvent.getY() <= this.jdField_j_of_type_AndroidGraphicsRect.bottom + AEImageCropperContainer.jdField_a_of_type_Int);
  }
  
  public Rect a()
  {
    Rect localRect = this.jdField_j_of_type_AndroidGraphicsRect;
    if (localRect != null) {
      return localRect;
    }
    return null;
  }
  
  public Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 != 0)
    {
      float f1;
      float f2;
      float f3;
      float f4;
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3)
          {
            if (paramInt1 == 4)
            {
              if (paramInt3 * 16 >= paramInt2 * 9)
              {
                f1 = paramInt4;
                f2 = paramInt2;
                f3 = this.jdField_b_of_type_Float;
                paramInt1 = (int)(f1 - f2 * f3) / 2;
                f4 = paramInt5;
                return new Rect(paramInt1, (int)(f4 - f2 * f3 * 9.0F / 16.0F) / 2, (int)(f1 + f2 * f3) / 2, (int)(f4 + f2 * f3 * 9.0F / 16.0F) / 2);
              }
              f1 = paramInt4;
              f2 = paramInt3;
              f3 = this.jdField_b_of_type_Float;
              paramInt1 = (int)(f1 - f2 * f3 * 16.0F / 9.0F) / 2;
              f4 = paramInt5;
              return new Rect(paramInt1, (int)(f4 - f2 * f3) / 2, (int)(f1 + f2 * f3 * 16.0F / 9.0F) / 2, (int)(f4 + f2 * f3) / 2);
            }
          }
          else
          {
            if (paramInt3 * 4 >= paramInt2 * 3)
            {
              f1 = paramInt4;
              f2 = paramInt2;
              f3 = this.jdField_b_of_type_Float;
              paramInt1 = (int)(f1 - f2 * f3) / 2;
              f4 = paramInt5;
              return new Rect(paramInt1, (int)(f4 - f2 * f3 * 3.0F / 4.0F) / 2, (int)(f1 + f2 * f3) / 2, (int)(f4 + f2 * f3 * 3.0F / 4.0F) / 2);
            }
            f1 = paramInt4;
            f2 = paramInt3;
            f3 = this.jdField_b_of_type_Float;
            paramInt1 = (int)(f1 - f2 * f3 * 4.0F / 3.0F) / 2;
            f4 = paramInt5;
            return new Rect(paramInt1, (int)(f4 - f2 * f3) / 2, (int)(f1 + f2 * f3 * 4.0F / 3.0F) / 2, (int)(f4 + f2 * f3) / 2);
          }
        }
        else
        {
          if (paramInt3 * 3 >= paramInt2 * 4)
          {
            f1 = paramInt4;
            f2 = paramInt2;
            f3 = this.jdField_b_of_type_Float;
            paramInt1 = (int)(f1 - f2 * f3) / 2;
            f4 = paramInt5;
            return new Rect(paramInt1, (int)(f4 - f2 * f3 * 4.0F / 3.0F) / 2, (int)(f1 + f2 * f3) / 2, (int)(f4 + f2 * f3 * 4.0F / 3.0F) / 2);
          }
          f1 = paramInt4;
          f2 = paramInt3;
          f3 = this.jdField_b_of_type_Float;
          paramInt1 = (int)(f1 - f2 * f3 * 3.0F / 4.0F) / 2;
          f4 = paramInt5;
          return new Rect(paramInt1, (int)(f4 - f2 * f3) / 2, (int)(f1 + f2 * f3 * 3.0F / 4.0F) / 2, (int)(f4 + f2 * f3) / 2);
        }
      }
      else
      {
        if (paramInt3 > paramInt2)
        {
          f1 = paramInt4;
          f2 = paramInt2;
          f3 = this.jdField_b_of_type_Float;
          paramInt1 = (int)(f1 - f2 * f3) / 2;
          f4 = paramInt5;
          return new Rect(paramInt1, (int)(f4 - f2 * f3) / 2, (int)(f1 + f2 * f3) / 2, (int)(f4 + f2 * f3) / 2);
        }
        f1 = paramInt4;
        f2 = paramInt3;
        f3 = this.jdField_b_of_type_Float;
        paramInt1 = (int)(f1 - f2 * f3) / 2;
        f4 = paramInt5;
        return new Rect(paramInt1, (int)(f4 - f2 * f3) / 2, (int)(f1 + f2 * f3) / 2, (int)(f4 + f2 * f3) / 2);
      }
    }
    return null;
  }
  
  public CropConfig a()
  {
    int m = this.jdField_k_of_type_Int;
    if (m != 0)
    {
      int n = this.l;
      if (n != 0)
      {
        if (this.jdField_j_of_type_AndroidGraphicsRect == null) {
          return AEEditorCropperPanel.a(m, n);
        }
        m = (int)(getWidth() - this.jdField_k_of_type_Int * this.jdField_b_of_type_Float) / 2;
        n = (int)(getHeight() - this.l * this.jdField_b_of_type_Float) / 2;
        int i1 = (int)(getWidth() + this.jdField_k_of_type_Int * this.jdField_b_of_type_Float) / 2;
        i1 = (int)(getHeight() + this.l * this.jdField_b_of_type_Float) / 2;
        return new CropConfig((this.jdField_j_of_type_AndroidGraphicsRect.left - m) / (this.jdField_k_of_type_Int * this.jdField_b_of_type_Float), (this.jdField_j_of_type_AndroidGraphicsRect.top - n) / (this.l * this.jdField_b_of_type_Float), (this.jdField_j_of_type_AndroidGraphicsRect.right - this.jdField_j_of_type_AndroidGraphicsRect.left) / (this.jdField_k_of_type_Int * this.jdField_b_of_type_Float), (this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top) / (this.l * this.jdField_b_of_type_Float));
      }
    }
    return new CropConfig(0.0F, 0.0F, 1.0F, 1.0F);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_k_of_type_Int = paramInt2;
    this.l = paramInt3;
    this.jdField_a_of_type_Int = paramInt1;
    Rect localRect1 = a(paramInt1, paramInt2, paramInt3, getWidth(), getHeight());
    if (localRect1 == null)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_j_of_type_AndroidGraphicsRect = null;
      this.jdField_k_of_type_AndroidGraphicsRect = null;
      invalidate();
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    Rect localRect2 = this.jdField_k_of_type_AndroidGraphicsRect;
    if (localRect2 == null)
    {
      this.jdField_j_of_type_AndroidGraphicsRect = localRect1;
      invalidate();
      this.jdField_k_of_type_AndroidGraphicsRect = this.jdField_j_of_type_AndroidGraphicsRect;
      return;
    }
    a(localRect2, localRect1);
  }
  
  public void a(AEImageCropperContainer paramAEImageCropperContainer, int paramInt1, Bitmap paramBitmap, CropConfig paramCropConfig, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer = paramAEImageCropperContainer;
    this.jdField_h_of_type_Int = paramInt2;
    this.jdField_i_of_type_Int = paramInt3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_k_of_type_Int = paramBitmap.getWidth();
    this.l = paramBitmap.getHeight();
    this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.a().a();
    paramAEImageCropperContainer = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleClipImageAEImageCropperContainer.a().b();
    paramInt1 = (int)(paramAEImageCropperContainer.left + paramCropConfig.getX() * (paramAEImageCropperContainer.right - paramAEImageCropperContainer.left));
    paramInt2 = (int)(paramAEImageCropperContainer.top + paramCropConfig.getY() * (paramAEImageCropperContainer.bottom - paramAEImageCropperContainer.top));
    paramInt3 = (int)(paramAEImageCropperContainer.left + (paramCropConfig.getX() + paramCropConfig.getWidth()) * (paramAEImageCropperContainer.right - paramAEImageCropperContainer.left));
    int m = (int)(paramAEImageCropperContainer.top + (paramCropConfig.getY() + paramCropConfig.getHeight()) * (paramAEImageCropperContainer.bottom - paramAEImageCropperContainer.top));
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_j_of_type_AndroidGraphicsRect = null;
    } else {
      this.jdField_j_of_type_AndroidGraphicsRect = new Rect(paramInt1, paramInt2, paramInt3, m);
    }
    invalidate();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    Object localObject = this.jdField_j_of_type_AndroidGraphicsRect;
    if (localObject == null) {
      return;
    }
    int m = ((Rect)localObject).right - this.jdField_j_of_type_AndroidGraphicsRect.left;
    int n = this.jdField_j_of_type_AndroidGraphicsRect.bottom - this.jdField_j_of_type_AndroidGraphicsRect.top;
    paramCanvas.clipRect(this.jdField_j_of_type_AndroidGraphicsRect, Region.Op.XOR);
    paramCanvas.drawColor(jdField_b_of_type_Int);
    paramCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(ViewUtils.b(1.0F));
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.right, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.right, this.jdField_j_of_type_AndroidGraphicsRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.top);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(ViewUtils.b(0.5F));
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    int i1 = this.jdField_j_of_type_AndroidGraphicsRect.left;
    int i2 = m / 3;
    ((Path)localObject).moveTo(i1 + i2, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left + i2, this.jdField_j_of_type_AndroidGraphicsRect.top + n);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    i1 = this.jdField_j_of_type_AndroidGraphicsRect.left;
    i2 = m * 2 / 3;
    ((Path)localObject).moveTo(i1 + i2, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left + i2, this.jdField_j_of_type_AndroidGraphicsRect.top + n);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    float f1 = this.jdField_j_of_type_AndroidGraphicsRect.left;
    i1 = this.jdField_j_of_type_AndroidGraphicsRect.top;
    i2 = n / 3;
    ((Path)localObject).moveTo(f1, i1 + i2);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left + m, this.jdField_j_of_type_AndroidGraphicsRect.top + i2);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    f1 = this.jdField_j_of_type_AndroidGraphicsRect.left;
    i1 = this.jdField_j_of_type_AndroidGraphicsRect.top;
    n = n * 2 / 3;
    ((Path)localObject).moveTo(f1, i1 + n);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_j_of_type_AndroidGraphicsRect.left + m, this.jdField_j_of_type_AndroidGraphicsRect.top + n);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.left - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.left + jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.left - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top, this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.top + jdField_d_of_type_Int);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.right - jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.right + jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top);
    this.jdField_d_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.right, this.jdField_j_of_type_AndroidGraphicsRect.top, this.jdField_j_of_type_AndroidGraphicsRect.right + jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.top + jdField_d_of_type_Int);
    this.jdField_e_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.left - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom, this.jdField_j_of_type_AndroidGraphicsRect.left + jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom + jdField_c_of_type_Int);
    this.jdField_f_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.left - jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom - jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.left, this.jdField_j_of_type_AndroidGraphicsRect.bottom);
    this.jdField_g_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.right - jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom, this.jdField_j_of_type_AndroidGraphicsRect.right + jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom + jdField_c_of_type_Int);
    this.jdField_h_of_type_AndroidGraphicsRect.set(this.jdField_j_of_type_AndroidGraphicsRect.right, this.jdField_j_of_type_AndroidGraphicsRect.bottom - jdField_d_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.right + jdField_c_of_type_Int, this.jdField_j_of_type_AndroidGraphicsRect.bottom);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_e_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_f_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_g_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_h_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      AEQLog.a("CropperGridView", "onTouchEvent(isAdjusting) - Can't perform this action right now.");
      return true;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      AEQLog.a("CropperGridView", "onTouchEvent(isCropping) - Can't perform this action right now.");
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTouchEvent(");
    localStringBuilder.append(paramMotionEvent.getActionMasked());
    localStringBuilder.append(", ");
    localStringBuilder.append(paramMotionEvent.getAction());
    localStringBuilder.append(")");
    AEQLog.a("CropperGridView", localStringBuilder.toString());
    getParent().requestDisallowInterceptTouchEvent(true);
    int m = paramMotionEvent.getActionMasked();
    if (m == 0)
    {
      if (b(paramMotionEvent))
      {
        if (a(paramMotionEvent))
        {
          this.jdField_e_of_type_Boolean = true;
          this.jdField_f_of_type_Boolean = false;
          this.jdField_i_of_type_AndroidGraphicsRect = a(this.jdField_a_of_type_Int, this.jdField_k_of_type_Int, this.l, getWidth(), getHeight());
        }
        else
        {
          this.jdField_e_of_type_Boolean = false;
          this.jdField_f_of_type_Boolean = true;
        }
        AEReportUtils.g();
      }
    }
    else if (m == 1)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.clip.image.AEImageCropperMask
 * JD-Core Version:    0.7.0.1
 */