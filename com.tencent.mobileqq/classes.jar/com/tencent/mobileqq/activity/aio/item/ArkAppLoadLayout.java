package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement;

public class ArkAppLoadLayout
  extends RelativeLayout
{
  public static int a;
  public static Paint a;
  public static int b;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private ArkViewImplement jdField_a_of_type_ComTencentArkArkViewImplement;
  public boolean a;
  int c = -2565408;
  
  static
  {
    jdField_a_of_type_Int = -2565408;
    b = -2565408;
    jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  }
  
  public ArkAppLoadLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ArkAppLoadLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ArkAppLoadLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint;
    if (!this.jdField_a_of_type_Boolean)
    {
      localPaint = jdField_a_of_type_AndroidGraphicsPaint;
      if (!isPressed()) {
        break label44;
      }
    }
    label44:
    for (int i = jdField_a_of_type_Int;; i = this.c)
    {
      localPaint.setColor(i);
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, jdField_a_of_type_AndroidGraphicsPaint);
      super.draw(paramCanvas);
      return;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_ComTencentArkArkViewImplement.makePath(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPath);
    }
  }
  
  public void setArkView(ArkViewImplement paramArkViewImplement)
  {
    this.jdField_a_of_type_ComTencentArkArkViewImplement = paramArkViewImplement;
    setWillNotDraw(false);
  }
  
  public void setBkgColorNormal(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout
 * JD-Core Version:    0.7.0.1
 */