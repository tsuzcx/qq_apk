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
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R.styleable;
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AddContactBubbleLayout);
    this.b = paramContext.getColor(0, -1);
    this.jdField_a_of_type_Int = Color.parseColor("#F5F6FA");
    int i = paramContext.getColor(4, Color.parseColor("#999999"));
    int j = paramContext.getDimensionPixelSize(5, (int)TypedValue.applyDimension(0, 0.0F, getResources().getDisplayMetrics()));
    this.c = paramContext.getDimensionPixelSize(1, 0);
    this.jdField_a_of_type_Float = paramContext.getDimensionPixelSize(6, 0);
    this.d = paramContext.getInt(2, 4);
    this.e = paramContext.getDimensionPixelOffset(3, 0);
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
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.c, this.c, Path.Direction.CCW);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y - i);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x - i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, i + this.jdField_a_of_type_AndroidGraphicsPoint.y);
      CornerPathEffect localCornerPathEffect = new CornerPathEffect(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(localCornerPathEffect);
    }
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void b()
  {
    switch (this.d)
    {
    default: 
      return;
    case 1: 
    case 3: 
      localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
      localPoint.y += this.e;
      return;
    }
    Point localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
    localPoint.x += this.e;
  }
  
  private void b(Canvas paramCanvas)
  {
    int i = getPaddingTop();
    if (i == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.c, this.c, Path.Direction.CCW);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsPoint.x + i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y - i);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x - i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      CornerPathEffect localCornerPathEffect = new CornerPathEffect(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(localCornerPathEffect);
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
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.c, this.c, Path.Direction.CCW);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y - i);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x + i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, i + this.jdField_a_of_type_AndroidGraphicsPoint.y);
      CornerPathEffect localCornerPathEffect = new CornerPathEffect(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(localCornerPathEffect);
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
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.c, this.c, Path.Direction.CCW);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.c, this.c, Path.Direction.CCW);
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_AndroidGraphicsPoint.x + i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y + i);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_AndroidGraphicsPoint.x - i, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      if (Build.VERSION.SDK_INT <= 21) {
        break label189;
      }
      CornerPathEffect localCornerPathEffect = new CornerPathEffect(this.jdField_a_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(localCornerPathEffect);
    }
    for (;;)
    {
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      label189:
      this.jdField_a_of_type_AndroidGraphicsPath.close();
    }
  }
  
  public void a()
  {
    switch (this.d)
    {
    default: 
      return;
    case 1: 
    case 3: 
      localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
      localPoint.y -= this.e;
      return;
    }
    Point localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
    localPoint.x -= this.e;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidGraphicsPoint.x > 0) && (this.jdField_a_of_type_AndroidGraphicsPoint.y > 0))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label77;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.b);
    }
    for (;;)
    {
      switch (this.d)
      {
      default: 
        return;
        label77:
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      }
    }
    a(paramCanvas);
    return;
    b(paramCanvas);
    return;
    c(paramCanvas);
    return;
    d(paramCanvas);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsRectF.left = getPaddingLeft();
    this.jdField_a_of_type_AndroidGraphicsRectF.top = getPaddingTop();
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (paramInt1 - getPaddingRight());
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (paramInt2 - getPaddingBottom());
    switch (this.d)
    {
    }
    for (;;)
    {
      if (this.e != 0) {
        b();
      }
      return;
      this.jdField_a_of_type_AndroidGraphicsPoint.x = getPaddingLeft();
      this.jdField_a_of_type_AndroidGraphicsPoint.y = (paramInt2 / 2);
      continue;
      this.jdField_a_of_type_AndroidGraphicsPoint.x = (paramInt1 / 2);
      this.jdField_a_of_type_AndroidGraphicsPoint.y = getPaddingTop();
      continue;
      this.jdField_a_of_type_AndroidGraphicsPoint.x = (paramInt1 - getPaddingRight());
      this.jdField_a_of_type_AndroidGraphicsPoint.y = (paramInt2 / 2);
      continue;
      this.jdField_a_of_type_AndroidGraphicsPoint.x = (paramInt1 / 2);
      this.jdField_a_of_type_AndroidGraphicsPoint.y = (paramInt2 - getPaddingBottom());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout
 * JD-Core Version:    0.7.0.1
 */