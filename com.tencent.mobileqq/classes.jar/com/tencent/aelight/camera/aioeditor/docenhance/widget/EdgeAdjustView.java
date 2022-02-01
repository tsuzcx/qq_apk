package com.tencent.aelight.camera.aioeditor.docenhance.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.Arrays;

public class EdgeAdjustView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private EdgeAdjustView.InteractionListener jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView$InteractionListener;
  private boolean jdField_a_of_type_Boolean = true;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[8];
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private final float[] jdField_b_of_type_ArrayOfFloat = new float[8];
  private int c;
  private int d;
  private int e;
  private int f = -2147483648;
  private int g = -16725252;
  private int h = -42646;
  
  public EdgeAdjustView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EdgeAdjustView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_b_of_type_Int = UIUtils.a(getContext(), 50.0F);
    this.c = UIUtils.a(getContext(), 16.5F);
    this.d = UIUtils.a(getContext(), 18.0F);
    this.e = UIUtils.a(getContext(), 18.0F);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2064056373);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2064056372);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
  }
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2) <= 100.0D;
  }
  
  private void b()
  {
    if (!this.jdField_b_of_type_AndroidGraphicsRectF.isEmpty())
    {
      int i = 0;
      while (i < 4)
      {
        float[] arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
        int j = i * 2;
        arrayOfFloat[j] = (this.jdField_b_of_type_AndroidGraphicsRectF.left + this.jdField_b_of_type_AndroidGraphicsRectF.width() * this.jdField_a_of_type_ArrayOfFloat[j]);
        arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
        j += 1;
        arrayOfFloat[j] = (this.jdField_b_of_type_AndroidGraphicsRectF.top + this.jdField_b_of_type_AndroidGraphicsRectF.height() * this.jdField_a_of_type_ArrayOfFloat[j]);
        i += 1;
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty()))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * 1.0F / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() > this.jdField_a_of_type_AndroidGraphicsRectF.height() * 1.0F / this.jdField_a_of_type_AndroidGraphicsRectF.width())
      {
        f1 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        f1 = (this.jdField_a_of_type_AndroidGraphicsRectF.width() - f2 * f1) / 2.0F;
        this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF.left + f1, this.jdField_a_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_AndroidGraphicsRectF.right - f1, this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
        return;
      }
      float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      float f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      f1 = (this.jdField_a_of_type_AndroidGraphicsRectF.height() - f2 * f1) / 2.0F;
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top + f1, this.jdField_a_of_type_AndroidGraphicsRectF.right, this.jdField_a_of_type_AndroidGraphicsRectF.bottom - f1);
    }
  }
  
  public float[] a()
  {
    return Arrays.copyOf(this.jdField_a_of_type_ArrayOfFloat, 8);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.g);
    } else {
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.h);
    }
    paramCanvas.drawColor(-16777216);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRectF, null);
    }
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    if (i >= 21)
    {
      paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null);
      i = 1;
    }
    else
    {
      i = 0;
    }
    paramCanvas.drawColor(this.f);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    float[] arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    ((Path)localObject).moveTo(arrayOfFloat[0], arrayOfFloat[1]);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    ((Path)localObject).lineTo(arrayOfFloat[2], arrayOfFloat[3]);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    ((Path)localObject).lineTo(arrayOfFloat[4], arrayOfFloat[5]);
    localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
    ((Path)localObject).lineTo(arrayOfFloat[6], arrayOfFloat[7]);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_Boolean) {
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    } else {
      localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    }
    if ((localObject != null) && (((Drawable)localObject).getIntrinsicWidth() > 0))
    {
      float f1 = ((Drawable)localObject).getIntrinsicWidth() / 2.0F;
      while (j < 4)
      {
        arrayOfFloat = this.jdField_b_of_type_ArrayOfFloat;
        int k = j * 2;
        int m = (int)(arrayOfFloat[k] - f1);
        int n = k + 1;
        ((Drawable)localObject).setBounds(m, (int)(arrayOfFloat[n] - f1), (int)(arrayOfFloat[k] + f1), (int)(arrayOfFloat[n] + f1));
        ((Drawable)localObject).draw(paramCanvas);
        j += 1;
      }
    }
    if (i != 0) {
      paramCanvas.restore();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramInt1, paramInt2);
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    localRectF.top += this.jdField_b_of_type_Int;
    localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    localRectF.bottom -= this.c;
    localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    localRectF.left += this.d;
    localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    localRectF.right -= this.e;
    c();
    b();
    invalidate();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() > 1) {
      return true;
    }
    int i = paramMotionEvent.getActionMasked();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        i = this.jdField_a_of_type_Int;
        if (i != -1)
        {
          this.jdField_b_of_type_ArrayOfFloat[(i * 2)] = Math.min(Math.max(f1, this.jdField_b_of_type_AndroidGraphicsRectF.left), this.jdField_b_of_type_AndroidGraphicsRectF.right);
          this.jdField_b_of_type_ArrayOfFloat[(this.jdField_a_of_type_Int * 2 + 1)] = Math.min(Math.max(f2, this.jdField_b_of_type_AndroidGraphicsRectF.top), this.jdField_b_of_type_AndroidGraphicsRectF.bottom);
          paramMotionEvent = this.jdField_a_of_type_ArrayOfFloat;
          i = this.jdField_a_of_type_Int;
          paramMotionEvent[(i * 2)] = ((this.jdField_b_of_type_ArrayOfFloat[(i * 2)] - this.jdField_b_of_type_AndroidGraphicsRectF.left) / this.jdField_b_of_type_AndroidGraphicsRectF.width());
          paramMotionEvent = this.jdField_a_of_type_ArrayOfFloat;
          i = this.jdField_a_of_type_Int;
          paramMotionEvent[(i * 2 + 1)] = ((this.jdField_b_of_type_ArrayOfFloat[(i * 2 + 1)] - this.jdField_b_of_type_AndroidGraphicsRectF.top) / this.jdField_b_of_type_AndroidGraphicsRectF.height());
          paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView$InteractionListener;
          if (paramMotionEvent != null)
          {
            this.jdField_a_of_type_Boolean = paramMotionEvent.a(this.jdField_a_of_type_ArrayOfFloat);
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView$InteractionListener.a(this.jdField_a_of_type_Boolean);
          }
          invalidate();
        }
        this.jdField_a_of_type_Float = f1;
        this.jdField_b_of_type_Float = f2;
        return true;
      }
      if (this.jdField_a_of_type_Int != -1)
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView$InteractionListener;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.b(this.jdField_a_of_type_Boolean);
          return true;
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Int = -1;
      if (!this.jdField_b_of_type_AndroidGraphicsRectF.isEmpty())
      {
        paramMotionEvent = this.jdField_b_of_type_ArrayOfFloat;
        if (a(paramMotionEvent[0], paramMotionEvent[1], f1, f2))
        {
          this.jdField_a_of_type_Int = 0;
        }
        else
        {
          paramMotionEvent = this.jdField_b_of_type_ArrayOfFloat;
          if (a(paramMotionEvent[2], paramMotionEvent[3], f1, f2))
          {
            this.jdField_a_of_type_Int = 1;
          }
          else
          {
            paramMotionEvent = this.jdField_b_of_type_ArrayOfFloat;
            if (a(paramMotionEvent[4], paramMotionEvent[5], f1, f2))
            {
              this.jdField_a_of_type_Int = 2;
            }
            else
            {
              paramMotionEvent = this.jdField_b_of_type_ArrayOfFloat;
              if (a(paramMotionEvent[6], paramMotionEvent[7], f1, f2)) {
                this.jdField_a_of_type_Int = 3;
              }
            }
          }
        }
      }
      this.jdField_a_of_type_Float = f1;
      this.jdField_b_of_type_Float = f2;
    }
    return true;
  }
  
  public void setAdjustPoints(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      if (paramArrayOfFloat.length != 8) {
        return;
      }
      int i = 0;
      while (i < 8)
      {
        this.jdField_a_of_type_ArrayOfFloat[i] = Math.min(Math.max(0.0F, paramArrayOfFloat[i]), 1.0F);
        i += 1;
      }
      b();
      invalidate();
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    c();
    b();
    invalidate();
  }
  
  public void setInteractionListener(EdgeAdjustView.InteractionListener paramInteractionListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDocenhanceWidgetEdgeAdjustView$InteractionListener = paramInteractionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.docenhance.widget.EdgeAdjustView
 * JD-Core Version:    0.7.0.1
 */