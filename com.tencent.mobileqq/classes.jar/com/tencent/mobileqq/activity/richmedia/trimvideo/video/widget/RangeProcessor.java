package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.tencent.mobileqq.utils.ViewUtils;

public class RangeProcessor
{
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private FrameParent jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent;
  private RangeProcessor.OnRangeChangeListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener;
  private final float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 4;
  private final Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private final float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = Color.parseColor("#298be7");
  private final float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  
  public RangeProcessor(FrameParent paramFrameParent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent = paramFrameParent;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.getContext();
    this.jdField_a_of_type_Float = (ViewUtils.a() * 0.0375F);
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float * 0.5F);
    paramFloat2 = paramInt3;
    this.d = paramFloat2;
    paramFrameParent = a(((Context)localObject).getResources(), 2130849428, (int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    localObject = a(((Context)localObject).getResources(), 2130849430, (int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    ColorDrawable localColorDrawable = new ColorDrawable(this.jdField_c_of_type_Int);
    localColorDrawable.setBounds(0, 0, (int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localColorDrawable.draw(localCanvas);
    if (paramFrameParent != null) {
      localCanvas.drawBitmap(paramFrameParent, (this.jdField_a_of_type_Float - paramFrameParent.getWidth()) / 2.0F, (this.jdField_b_of_type_Float - paramFrameParent.getHeight()) / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float, Bitmap.Config.RGB_565);
    localCanvas.setBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
    localColorDrawable.draw(localCanvas);
    if (localObject != null) {
      localCanvas.drawBitmap((Bitmap)localObject, (this.jdField_a_of_type_Float - ((Bitmap)localObject).getWidth()) / 2.0F, (this.jdField_b_of_type_Float - ((Bitmap)localObject).getHeight()) / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    float f2 = paramInt4;
    float f1 = paramInt2;
    f2 = f2 * 1.0F / f1;
    float f3 = this.jdField_a_of_type_Float;
    this.h = (f2 * paramFloat1 + f3);
    this.g = (2000.0F / f1 * paramFloat1);
    this.j = (paramFloat2 - f3);
    this.k = f3;
    this.e = f3;
    this.f = this.h;
  }
  
  private void a(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, paramFloat, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (Math.abs(paramFloat1 - paramFloat3) <= this.jdField_a_of_type_Float * 2.0F) && (paramFloat2 > 0.0F) && (paramFloat2 < this.jdField_b_of_type_Float);
  }
  
  private void b(float paramFloat, Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, paramFloat - this.jdField_a_of_type_Float, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  public float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = paramOptions.outHeight;
    int i2 = paramOptions.outWidth;
    int n = 1;
    int m = 1;
    if ((i1 > paramInt2) || (i2 > paramInt1))
    {
      i1 /= 2;
      i2 /= 2;
      for (;;)
      {
        n = m;
        if (i1 / m <= paramInt2) {
          break;
        }
        n = m;
        if (i2 / m <= paramInt1) {
          break;
        }
        m *= 2;
      }
    }
    return n;
  }
  
  public Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramResources == null) {
      return null;
    }
    if (paramInt1 <= 0) {
      return null;
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      int m = 1;
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      if ((paramInt2 <= 0) && (paramInt3 <= 0)) {
        paramInt2 = m;
      } else {
        paramInt2 = a(localOptions, paramInt2, paramInt3);
      }
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = paramInt2;
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      return paramResources;
    }
    catch (OutOfMemoryError paramResources)
    {
      paramResources.printStackTrace();
      return null;
    }
    catch (Exception paramResources)
    {
      paramResources.printStackTrace();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0.0F) {
      this.k = (paramFloat1 + this.jdField_a_of_type_Float);
    } else {
      this.k = this.jdField_a_of_type_Float;
    }
    if (paramFloat2 >= 0.0F)
    {
      paramFloat1 = this.jdField_a_of_type_Float;
      this.j = Math.min(paramFloat2 + paramFloat1, this.d - paramFloat1);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    int m = this.jdField_a_of_type_AndroidGraphicsPaint.getColor();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    paramCanvas.drawRect(this.e, 0.0F, this.f, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    float f1 = this.e;
    float f2 = this.jdField_b_of_type_Float;
    paramCanvas.drawRect(f1, f2 - this.jdField_b_of_type_Int, this.f, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(m);
    b(this.e, paramCanvas);
    a(this.f, paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_a_of_type_Int = -1;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.i = paramMotionEvent.getX();
      return;
    }
    if (paramMotionEvent.getAction() == 2)
    {
      float f2 = f1 - this.i;
      int m = this.jdField_a_of_type_Int;
      float f3;
      if (m == 0)
      {
        f3 = Math.max(this.f - this.h, this.k);
        if (f1 < f3)
        {
          this.e = f3;
          return;
        }
        if ((f2 < 0.0F) && (this.e + f2 <= this.jdField_a_of_type_Float))
        {
          this.e = f3;
        }
        else
        {
          f2 = this.f;
          f3 = this.g;
          if (f2 - f1 < f3) {
            this.e = (f2 - f3);
          } else {
            this.e = f1;
          }
        }
      }
      else if (m == 1)
      {
        f3 = Math.min(this.e + this.h, this.j);
        if (f1 > f3)
        {
          this.f = f3;
          return;
        }
        if ((f2 > 0.0F) && (this.f + f2 >= this.h))
        {
          this.f = f3;
        }
        else
        {
          f2 = this.e;
          f3 = this.g;
          if (f1 - f2 < f3) {
            this.f = (f2 + f3);
          } else {
            this.f = f1;
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.invalidate();
    paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener;
    if (paramMotionEvent != null) {
      paramMotionEvent.a(this.e, this.f);
    }
  }
  
  public void a(RangeProcessor.OnRangeChangeListener paramOnRangeChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener = paramOnRangeChangeListener;
  }
  
  public boolean a()
  {
    return (!b(this.e, this.jdField_a_of_type_Float)) || (!b(this.f, this.h));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = a(paramFloat1, paramFloat2, this.e - this.jdField_c_of_type_Float);
    boolean bool2 = a(paramFloat1, paramFloat2, this.f + this.jdField_c_of_type_Float);
    if (bool1)
    {
      this.jdField_a_of_type_Int = 0;
      return true;
    }
    if (bool2)
    {
      this.jdField_a_of_type_Int = 1;
      return true;
    }
    return false;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetRangeProcessor$OnRangeChangeListener = null;
    this.e = 0.0F;
    this.f = 0.0F;
  }
  
  public float c()
  {
    return this.f - this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.RangeProcessor
 * JD-Core Version:    0.7.0.1
 */