package com.tencent.biz.qqstory.album.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import java.util.Arrays;

public class RoundCornerLayout
  extends RelativeLayout
{
  public static final float[] a;
  private static boolean jdField_b_of_type_Boolean;
  private float jdField_a_of_type_Float;
  private Resources jdField_a_of_type_AndroidContentResResources;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  public boolean a;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  RectF jdField_b_of_type_AndroidGraphicsRectF;
  float[] jdField_b_of_type_ArrayOfFloat;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 7.0F, 9.0F, 0.0F, 6.0F, 2.5F, 9.0F, 5.5F, 15.0F, 0.5F, 13.0F };
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("BV0720")) || (str.contains("M821")) || ((Build.VERSION.SDK_INT == 21) && ((str.contains("NX511J")) || (str.contains("MI 5")) || (str.contains("GT-I9508")) || (str.contains("X9077")) || (str.contains("COOLPAD 8675-A"))))) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  public RoundCornerLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RoundCornerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RoundCornerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Boolean = jdField_b_of_type_Boolean;
    this.jdField_a_of_type_AndroidContentResResources = getResources();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_ArrayOfFloat = new float[8];
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(4.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    setWillNotDraw(false);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
    this.jdField_b_of_type_AndroidGraphicsRectF.set(2.0F, 2.0F, paramFloat1 - 2.0F, paramFloat2 - 2.0F);
    this.jdField_b_of_type_AndroidGraphicsPath.reset();
    this.jdField_b_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_ArrayOfFloat, Path.Direction.CW);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    super.draw(paramCanvas);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_Boolean)
    {
      setLayerType(1, null);
      return;
    }
    setLayerType(2, null);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    setLayerType(0, null);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      a(getWidth(), getHeight());
    }
  }
  
  public void setRadius(float paramFloat)
  {
    this.jdField_a_of_type_Float = a(paramFloat, this.jdField_a_of_type_AndroidContentResResources);
    if (this.jdField_b_of_type_ArrayOfFloat != null) {
      Arrays.fill(this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_Float);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.RoundCornerLayout
 * JD-Core Version:    0.7.0.1
 */