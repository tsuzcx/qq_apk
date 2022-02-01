package com.tencent.mobileqq.ar.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public final class ViewfinderView
  extends View
{
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_a_of_type_JavaLangString;
  private List<AIRect> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 18;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private int jdField_d_of_type_Int;
  private Rect jdField_d_of_type_AndroidGraphicsRect = new Rect();
  private int e = 0;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public ViewfinderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130844889);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewfinderView);
    this.jdField_c_of_type_Int = paramAttributeSet.getDimensionPixelSize(4, a(paramContext, 3.0F));
    int j = this.jdField_c_of_type_Int;
    if ((j & 0x1) != 0) {
      this.jdField_c_of_type_Int = (j + 1);
    }
    this.jdField_d_of_type_Int = paramAttributeSet.getDimensionPixelSize(1, a(paramContext, 16.0F));
    this.f = paramAttributeSet.getDimensionPixelSize(3, a(paramContext, 2.0F));
    this.h = paramAttributeSet.getColor(0, Color.parseColor("#12B7F5"));
    this.g = paramAttributeSet.getColor(2, -16776961);
    this.jdField_a_of_type_Int = paramAttributeSet.getColor(5, Color.parseColor("#000000"));
    this.jdField_a_of_type_JavaLangString = paramAttributeSet.getString(7);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131716195);
    }
    this.i = paramAttributeSet.getColor(6, Color.parseColor("#FFFFFF"));
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(10, false);
    this.jdField_a_of_type_Float = paramAttributeSet.getDimensionPixelSize(8, a(paramContext, 20.0F));
    this.jdField_b_of_type_Float = paramAttributeSet.getDimensionPixelSize(9, b(paramContext, 14.0F));
    this.e = a(paramContext, 8.0F);
    paramAttributeSet.recycle();
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private void a(Rect paramRect, Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.reset();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsRect.set(paramRect.left - this.e, paramRect.top - this.e, paramRect.right + this.e, paramRect.bottom + this.e);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_d_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_c_of_type_Int);
    paramRect = this.jdField_a_of_type_AndroidGraphicsRectF;
    int j = this.jdField_c_of_type_Int;
    paramCanvas.drawRoundRect(paramRect, j / 2, j / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_d_of_type_Int);
    paramRect = this.jdField_a_of_type_AndroidGraphicsRectF;
    j = this.jdField_c_of_type_Int;
    paramCanvas.drawRoundRect(paramRect, j / 2, j / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRect.right - this.jdField_d_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_c_of_type_AndroidGraphicsRect.right, this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_c_of_type_Int);
    paramRect = this.jdField_a_of_type_AndroidGraphicsRectF;
    j = this.jdField_c_of_type_Int;
    paramCanvas.drawRoundRect(paramRect, j / 2, j / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRect.right - this.jdField_c_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.top, this.jdField_c_of_type_AndroidGraphicsRect.right, this.jdField_c_of_type_AndroidGraphicsRect.top + this.jdField_d_of_type_Int);
    paramRect = this.jdField_a_of_type_AndroidGraphicsRectF;
    j = this.jdField_c_of_type_Int;
    paramCanvas.drawRoundRect(paramRect, j / 2, j / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_c_of_type_AndroidGraphicsRect.bottom - this.jdField_d_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_c_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.bottom);
    paramRect = this.jdField_a_of_type_AndroidGraphicsRectF;
    j = this.jdField_c_of_type_Int;
    paramCanvas.drawRoundRect(paramRect, j / 2, j / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRect.left, this.jdField_c_of_type_AndroidGraphicsRect.bottom - this.jdField_c_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.left + this.jdField_d_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.bottom);
    paramRect = this.jdField_a_of_type_AndroidGraphicsRectF;
    j = this.jdField_c_of_type_Int;
    paramCanvas.drawRoundRect(paramRect, j / 2, j / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRect.right - this.jdField_d_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.bottom - this.jdField_c_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.right, this.jdField_c_of_type_AndroidGraphicsRect.bottom);
    paramRect = this.jdField_a_of_type_AndroidGraphicsRectF;
    j = this.jdField_c_of_type_Int;
    paramCanvas.drawRoundRect(paramRect, j / 2, j / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_AndroidGraphicsRect.right - this.jdField_c_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.bottom - this.jdField_d_of_type_Int, this.jdField_c_of_type_AndroidGraphicsRect.right, this.jdField_c_of_type_AndroidGraphicsRect.bottom);
    paramRect = this.jdField_a_of_type_AndroidGraphicsRectF;
    j = this.jdField_c_of_type_Int;
    paramCanvas.drawRoundRect(paramRect, j / 2, j / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.reset();
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  private void b(Rect paramRect, Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipRect(paramRect);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { paramRect.top - this.jdField_b_of_type_Int, paramRect.bottom - this.jdField_b_of_type_Int });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(3000L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ViewfinderView.1(this, paramRect));
      this.jdField_b_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect.left, (int)this.jdField_c_of_type_Float, paramRect.right, (int)this.jdField_c_of_type_Float + this.jdField_b_of_type_Int);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsPaint.reset();
  }
  
  private void c(Rect paramRect, Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.i);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
      Object localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
      String str = this.jdField_a_of_type_JavaLangString;
      ((Paint)localObject).getTextBounds(str, 0, str.length(), this.jdField_d_of_type_AndroidGraphicsRect);
      localObject = this.jdField_a_of_type_JavaLangString;
      paramCanvas.drawText((String)localObject, 0, ((String)localObject).length(), paramRect.centerX(), paramRect.centerY() + paramRect.height() / 2 + this.jdField_a_of_type_Float + this.jdField_d_of_type_AndroidGraphicsRect.height(), this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.reset();
    }
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  public void onDetachedFromWindow()
  {
    QLog.d("viewFinderView", 1, "onDetachedFromWindow ");
    super.onDetachedFromWindow();
    a();
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.jdField_b_of_type_AndroidGraphicsRect;
    if (localObject == null) {
      return;
    }
    if (localObject == null) {
      return;
    }
    paramCanvas.getWidth();
    paramCanvas.getHeight();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    a((Rect)localObject, paramCanvas);
    b((Rect)localObject, paramCanvas);
    c((Rect)localObject, paramCanvas);
    localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AIRect localAIRect = (AIRect)((Iterator)localObject).next();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(4.0F);
        paramCanvas.drawRect(localAIRect.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = new TextPaint();
      ((TextPaint)localObject).setColor(-65536);
      ((TextPaint)localObject).setStyle(Paint.Style.FILL);
      ((TextPaint)localObject).setStrokeWidth(2.0F);
      ((TextPaint)localObject).setTextSize(AIOUtils.b(12.0F, getResources()));
      paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, 90.0F, 90.0F, (Paint)localObject);
    }
  }
  
  public void onVisibilityChanged(View paramView, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVisibilityChanged ");
    localStringBuilder.append(paramInt);
    QLog.d("viewFinderView", 2, localStringBuilder.toString());
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt != 0) {
      a();
    }
  }
  
  public void setDetectRect(List<AIRect> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    postInvalidate();
  }
  
  public void setMiniText(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    postInvalidate();
  }
  
  public void setRect(Rect paramRect)
  {
    if ((paramRect != null) && (!paramRect.equals(this.jdField_b_of_type_AndroidGraphicsRect)))
    {
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      paramRect = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if (paramRect != null)
      {
        paramRect.cancel();
        this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ViewfinderView
 * JD-Core Version:    0.7.0.1
 */