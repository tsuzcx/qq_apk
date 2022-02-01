package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;

public class AnimationableProgressView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int c = 5;
  private int d = 3;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public AnimationableProgressView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AnimationableProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.f = -3946292;
    this.g = -1;
    this.h = -1972505;
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.d = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    if ((this.d >= 0) && (this.c > 0) && (this.jdField_a_of_type_Int != 0))
    {
      if (this.jdField_b_of_type_Int == 0) {
        return;
      }
      if (this.jdField_b_of_type_Long > 0L)
      {
        if (this.jdField_a_of_type_Long > 0L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131700487));
          ((StringBuilder)localObject).append(this.d);
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131700489));
          this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(HardCodeUtil.a(2131700484));
          ((StringBuilder)localObject).append(this.d);
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(this.c);
          this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
        }
        this.i = -34816;
      }
      else
      {
        this.i = -16777216;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131700486));
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131700485));
        this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
        if (this.d > 0)
        {
          if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
            this.jdField_a_of_type_AndroidGraphicsPath = new Path();
          }
          this.jdField_a_of_type_AndroidGraphicsPath.reset();
          paramInt1 = this.jdField_a_of_type_Int * this.d / this.c;
          this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.e, this.jdField_b_of_type_Int);
          localObject = this.jdField_a_of_type_AndroidGraphicsPath;
          paramInt2 = this.jdField_b_of_type_Int;
          int j = this.e;
          ((Path)localObject).arcTo(new RectF(0.0F, paramInt2 - j * 2, j * 2, paramInt2), 90.0F, 90.0F);
          localObject = this.jdField_a_of_type_AndroidGraphicsPath;
          paramInt2 = this.e;
          ((Path)localObject).arcTo(new RectF(0.0F, 0.0F, paramInt2 * 2, paramInt2 * 2), 180.0F, 90.0F);
          if (this.d >= this.c)
          {
            localObject = this.jdField_a_of_type_AndroidGraphicsPath;
            paramInt1 = this.jdField_a_of_type_Int;
            paramInt2 = this.e;
            ((Path)localObject).arcTo(new RectF(paramInt1 - paramInt2 * 2, 0.0F, paramInt1, paramInt2 * 2), -90.0F, 90.0F);
            localObject = this.jdField_a_of_type_AndroidGraphicsPath;
            paramInt1 = this.jdField_a_of_type_Int;
            paramInt2 = this.e;
            f1 = paramInt1 - paramInt2 * 2;
            j = this.jdField_b_of_type_Int;
            ((Path)localObject).arcTo(new RectF(f1, j - paramInt2 * 2, paramInt1, j), 0.0F, 90.0F);
          }
          else
          {
            localObject = this.jdField_a_of_type_AndroidGraphicsPath;
            f1 = paramInt1;
            ((Path)localObject).lineTo(f1, 0.0F);
            this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1, this.jdField_b_of_type_Int);
          }
          this.jdField_a_of_type_AndroidGraphicsPath.close();
        }
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(getResources().getDisplayMetrics().density * 14.0F);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131700488));
        this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
      }
      float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Float = ((this.jdField_a_of_type_Int - f1) / 2.0F);
      Object localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
      this.jdField_b_of_type_Float = ((this.jdField_b_of_type_Int - ((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top) / 2.0F);
      super.invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    if ((this.jdField_b_of_type_Long <= 0L) && (this.jdField_a_of_type_Long <= 0L) && (this.jdField_a_of_type_AndroidGraphicsRectF != null))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      int j = this.e;
      paramCanvas.drawRoundRect(localRectF, j, j, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_AndroidGraphicsPath != null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      j = this.e;
      paramCanvas.drawRoundRect(localRectF, j, j, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.i);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.restore();
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
      this.e = ((int)(this.jdField_b_of_type_Int * 0.16F));
      a(this.d, this.c, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long);
      if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      }
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      localRectF.left = 0.0F;
      localRectF.right = this.jdField_a_of_type_Int;
      localRectF.top = 0.0F;
      localRectF.bottom = this.jdField_b_of_type_Int;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.AnimationableProgressView
 * JD-Core Version:    0.7.0.1
 */