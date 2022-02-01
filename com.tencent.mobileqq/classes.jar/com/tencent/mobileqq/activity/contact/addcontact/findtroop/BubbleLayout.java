package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.qphone.base.util.QLog;

public class BubbleLayout
  extends RelativeLayout
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  boolean jdField_a_of_type_Boolean;
  int b;
  private int c;
  @BubbleLayout.Direction
  private int d;
  private int e;
  
  public BubbleLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.jdField_g_of_type_ArrayOfInt);
    this.b = paramContext.getColor(R.styleable.jdField_a_of_type_Int, -1);
    this.jdField_a_of_type_Int = Color.parseColor("#F5F6FA");
    int i = paramContext.getColor(R.styleable.e, Color.parseColor("#999999"));
    int j = (int)TypedValue.applyDimension(0, 0.0F, getResources().getDisplayMetrics());
    j = paramContext.getDimensionPixelSize(R.styleable.f, j);
    this.c = paramContext.getDimensionPixelSize(R.styleable.b, 0);
    this.jdField_a_of_type_Float = paramContext.getDimensionPixelSize(R.styleable.jdField_g_of_type_Int, 0);
    this.d = paramContext.getInt(R.styleable.c, 4);
    this.e = paramContext.getDimensionPixelOffset(R.styleable.d, 0);
    paramContext.recycle();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(j, 0.0F, 0.0F, i);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsPoint = new Point();
    setWillNotDraw(false);
    setLayerType(1, null);
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = getPaddingLeft();
    if (i == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    int j = this.c;
    ((Path)localObject).addRoundRect(localRectF, j, j, Path.Direction.CCW);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y - i);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x - i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y + i);
      localObject = new CornerPathEffect(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect((PathEffect)localObject);
    }
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void b()
  {
    int i = this.d;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label45;
        }
        if (i != 4) {
          return;
        }
      }
      localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
      localPoint.x += this.e;
      return;
    }
    label45:
    Point localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
    localPoint.y += this.e;
  }
  
  private void b(Canvas paramCanvas)
  {
    int i = getPaddingTop();
    if (i == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    int j = this.c;
    ((Path)localObject).addRoundRect(localRectF, j, j, Path.Direction.CCW);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsPoint.x + i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y - i);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x - i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      localObject = new CornerPathEffect(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect((PathEffect)localObject);
    }
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void c(Canvas paramCanvas)
  {
    int i = getPaddingRight();
    if (i == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    int j = this.c;
    ((Path)localObject).addRoundRect(localRectF, j, j, Path.Direction.CCW);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y - i);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x + i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y + i);
      localObject = new CornerPathEffect(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect((PathEffect)localObject);
    }
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void d(Canvas paramCanvas)
  {
    int i = getPaddingBottom();
    if (i == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    int j = this.c;
    ((Path)localObject).addRoundRect(localRectF, j, j, Path.Direction.CCW);
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsPath;
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      j = this.c;
      ((Path)localObject).addRoundRect(localRectF, j, j, Path.Direction.CCW);
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsPoint.x + i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y + i);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x - i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      if (Build.VERSION.SDK_INT > 21)
      {
        localObject = new CornerPathEffect(this.jdField_a_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect((PathEffect)localObject);
      }
      else
      {
        this.jdField_a_of_type_AndroidGraphicsPath.close();
      }
    }
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a()
  {
    int i = this.d;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label45;
        }
        if (i != 4) {
          return;
        }
      }
      localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
      localPoint.x -= this.e;
      return;
    }
    label45:
    Point localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
    localPoint.y -= this.e;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidGraphicsPoint.x > 0) && (this.jdField_a_of_type_AndroidGraphicsPoint.y > 0)) {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.b);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      }
    }
    int i = this.d;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          d(paramCanvas);
          return;
        }
        c(paramCanvas);
        return;
      }
      b(paramCanvas);
      return;
    }
    a(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = getPaddingLeft();
    this.jdField_a_of_type_AndroidGraphicsRectF.top = getPaddingTop();
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (paramInt1 - getPaddingRight());
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (paramInt2 - getPaddingBottom());
    paramInt3 = this.d;
    if (paramInt3 != 1)
    {
      Point localPoint;
      if (paramInt3 != 2)
      {
        if (paramInt3 != 3)
        {
          if (paramInt3 == 4)
          {
            localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
            localPoint.x = (paramInt1 / 2);
            localPoint.y = (paramInt2 - getPaddingBottom());
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidGraphicsPoint.x = (paramInt1 - getPaddingRight());
          this.jdField_a_of_type_AndroidGraphicsPoint.y = (paramInt2 / 2);
        }
      }
      else
      {
        localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
        localPoint.x = (paramInt1 / 2);
        localPoint.y = getPaddingTop();
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsPoint.x = getPaddingLeft();
      this.jdField_a_of_type_AndroidGraphicsPoint.y = (paramInt2 / 2);
    }
    if (this.e != 0) {
      b();
    }
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    postInvalidate();
  }
  
  public void setSelectedColor(String paramString)
  {
    try
    {
      this.b = Color.parseColor(paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.d("BubbleLayout", 1, "setSelectedColor error", paramString);
    }
  }
  
  public void setTriangleOffset(int paramInt)
  {
    a();
    this.e = paramInt;
    b();
    invalidate();
  }
  
  public void setUnselectedColor(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Int = Color.parseColor(paramString);
      return;
    }
    catch (IllegalArgumentException paramString)
    {
      QLog.d("BubbleLayout", 1, "setUnselectedColor error", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */