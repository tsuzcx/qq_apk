package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class RoundRectLinearLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public RoundRectLinearLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  public RoundRectLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(0.0F, this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsPath.lineTo(0.0F, 0.0F);
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.d + 0, this.jdField_b_of_type_Int - 0);
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      f1 = 0;
      i = this.jdField_b_of_type_Int;
      j = this.d;
      localPath.arcTo(new RectF(f1, i - j * 2 - 0, j * 2 + 0, i - 0), 90.0F, 90.0F);
      localPath = this.jdField_a_of_type_AndroidGraphicsPath;
      i = this.d;
      localPath.arcTo(new RectF(f1, f1, i * 2 + 0, i * 2 + 0), 180.0F, 90.0F);
    }
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    int i = this.jdField_a_of_type_Int;
    int j = this.d;
    localPath.arcTo(new RectF(i - j * 2 - 0, 0, i - 0, j * 2 + 0), -90.0F, 90.0F);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    i = this.jdField_a_of_type_Int;
    j = this.d;
    float f1 = i - j * 2 - 0;
    int k = this.jdField_b_of_type_Int;
    localPath.arcTo(new RectF(f1, k - j * 2 - 0, i - 0, k - 0), 0.0F, 90.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    if (this.f > 0)
    {
      this.jdField_b_of_type_AndroidGraphicsPath = new Path();
      this.jdField_b_of_type_AndroidGraphicsPath.reset();
      localPath = this.jdField_b_of_type_AndroidGraphicsPath;
      i = this.g;
      localPath.moveTo(this.f + i, this.jdField_b_of_type_Int - i);
      localPath = this.jdField_b_of_type_AndroidGraphicsPath;
      i = this.g;
      f1 = i;
      j = this.jdField_b_of_type_Int;
      k = this.f;
      localPath.arcTo(new RectF(f1, j - k * 2 - i, k * 2 + i, j - i), 90.0F, 90.0F);
      localPath = this.jdField_b_of_type_AndroidGraphicsPath;
      i = this.g;
      f1 = i;
      float f2 = i;
      j = this.f;
      localPath.arcTo(new RectF(f1, f2, j * 2 + i, i + j * 2), 180.0F, 90.0F);
      localPath = this.jdField_b_of_type_AndroidGraphicsPath;
      i = this.jdField_a_of_type_Int;
      j = this.f;
      k = this.g;
      localPath.arcTo(new RectF(i - j * 2 - k, k, i - k, k + j * 2), -90.0F, 90.0F);
      localPath = this.jdField_b_of_type_AndroidGraphicsPath;
      i = this.jdField_a_of_type_Int;
      j = this.f;
      k = this.g;
      f1 = i - j * 2 - k;
      int m = this.jdField_b_of_type_Int;
      localPath.arcTo(new RectF(f1, m - j * 2 - k, i - k, m - k), 0.0F, 90.0F);
      this.jdField_b_of_type_AndroidGraphicsPath.close();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if ((this.f > 0) && (this.jdField_b_of_type_AndroidGraphicsPath != null))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.f);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.jdField_a_of_type_Int) || (paramInt2 != this.jdField_b_of_type_Int))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      a();
    }
  }
  
  public void setInnerRoundRect(int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  public void setRoundRect(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.d != paramInt1)
    {
      this.d = paramInt1;
      a();
    }
    this.c = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout
 * JD-Core Version:    0.7.0.1
 */