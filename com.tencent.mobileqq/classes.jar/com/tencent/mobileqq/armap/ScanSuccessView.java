package com.tencent.mobileqq.armap;

import aciy;
import ajjy;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;
import java.util.Random;

public class ScanSuccessView
  extends View
{
  private float jdField_a_of_type_Float = 51.0F;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  String jdField_a_of_type_JavaLangString = ajjy.a(2131647730);
  boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 70;
  private Paint jdField_d_of_type_AndroidGraphicsPaint;
  RectF jdField_d_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 180;
  private Paint jdField_e_of_type_AndroidGraphicsPaint;
  RectF jdField_e_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int = 10;
  private Paint jdField_f_of_type_AndroidGraphicsPaint;
  private float jdField_g_of_type_Float = 10.0F;
  private int jdField_g_of_type_Int;
  private Paint jdField_g_of_type_AndroidGraphicsPaint;
  private float jdField_h_of_type_Float;
  private int jdField_h_of_type_Int = 18;
  private float i;
  private float j = 1.6875F;
  
  public ScanSuccessView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + 4.0F + 6.0F);
    this.jdField_e_of_type_Float = (this.jdField_a_of_type_Float + 25.0F);
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_Float + 36.0F);
    this.jdField_d_of_type_Float = (this.jdField_a_of_type_Float + this.jdField_g_of_type_Float / 2.0F + 47.0F);
    this.jdField_f_of_type_Float = (this.jdField_a_of_type_Float + 72.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(2147483647);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(8.0F * this.j);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(2147483647);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStrokeWidth(this.j * 6.0F);
    this.jdField_e_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_e_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_e_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_e_of_type_AndroidGraphicsPaint.setStrokeWidth(16.0F * this.j);
    this.jdField_f_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_f_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_f_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_f_of_type_AndroidGraphicsPaint.setARGB(255, 255, 255, 255);
    this.jdField_f_of_type_AndroidGraphicsPaint.setTextSize(28.0F * this.j);
    this.jdField_g_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_g_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_g_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_g_of_type_AndroidGraphicsPaint.setARGB(255, 255, 255, 255);
    this.jdField_h_of_type_Int = aciy.a(18.0F, getResources());
    this.jdField_g_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_h_of_type_Int);
    Paint.FontMetrics localFontMetrics = this.jdField_f_of_type_AndroidGraphicsPaint.getFontMetrics();
    this.i = ((int)Math.ceil(localFontMetrics.descent - localFontMetrics.ascent));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_g_of_type_Int % 10 == 9) {
      this.jdField_b_of_type_Boolean = false;
    }
    if (this.jdField_g_of_type_Int % 10 == 0) {
      this.jdField_b_of_type_Boolean = true;
    }
    if (this.jdField_b_of_type_Boolean) {}
    for (this.jdField_g_of_type_Int += 1;; this.jdField_g_of_type_Int -= 1)
    {
      if (this.jdField_g_of_type_Int % 2 == 0) {}
      this.jdField_a_of_type_Int = (getWidth() / 2);
      this.jdField_b_of_type_Int = (getHeight() / 2);
      this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - this.jdField_b_of_type_Float * this.j);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - this.jdField_b_of_type_Float * this.j);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int + this.jdField_b_of_type_Float * this.j);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int + this.jdField_b_of_type_Float * this.j);
      this.jdField_b_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - this.jdField_c_of_type_Float * this.j);
      this.jdField_b_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - this.jdField_c_of_type_Float * this.j);
      this.jdField_b_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int + this.jdField_c_of_type_Float * this.j);
      this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int + this.jdField_c_of_type_Float * this.j);
      this.jdField_c_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - this.jdField_d_of_type_Float * this.j);
      this.jdField_c_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - this.jdField_d_of_type_Float * this.j);
      this.jdField_c_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int + this.jdField_d_of_type_Float * this.j);
      this.jdField_c_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int + this.jdField_d_of_type_Float * this.j);
      this.jdField_d_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - this.jdField_e_of_type_Float * this.j);
      this.jdField_d_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - this.jdField_e_of_type_Float * this.j);
      this.jdField_d_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int + this.jdField_e_of_type_Float * this.j);
      this.jdField_d_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int + this.jdField_e_of_type_Float * this.j);
      this.jdField_e_of_type_AndroidGraphicsRectF.left = (this.jdField_a_of_type_Int - this.jdField_f_of_type_Float * this.j - this.jdField_g_of_type_Int % 10);
      this.jdField_e_of_type_AndroidGraphicsRectF.top = (this.jdField_b_of_type_Int - this.jdField_f_of_type_Float * this.j - this.jdField_g_of_type_Int % 10);
      this.jdField_e_of_type_AndroidGraphicsRectF.right = (this.jdField_a_of_type_Int + this.jdField_f_of_type_Float * this.j + this.jdField_g_of_type_Int % 10);
      this.jdField_e_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_Int + this.jdField_f_of_type_Float * this.j + this.jdField_g_of_type_Int % 10);
      this.jdField_d_of_type_Int += 10;
      this.jdField_e_of_type_Int += 10;
      this.jdField_f_of_type_Int += 10;
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_d_of_type_Int + 270, 90.0F, false, this.jdField_b_of_type_AndroidGraphicsPaint);
      paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_e_of_type_Int + 270, 270.0F, false, this.jdField_d_of_type_AndroidGraphicsPaint);
      paramCanvas.drawArc(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_f_of_type_Int + 90, 90.0F, false, this.jdField_e_of_type_AndroidGraphicsPaint);
      paramCanvas.drawArc(this.jdField_e_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, false, this.jdField_c_of_type_AndroidGraphicsPaint);
      paramCanvas.drawArc(this.jdField_d_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, false, this.jdField_c_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_Boolean)
      {
        paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float * this.j, this.jdField_a_of_type_AndroidGraphicsPaint);
        if (this.jdField_c_of_type_Int > 99) {
          this.jdField_c_of_type_Int = 99;
        }
        String str = this.jdField_c_of_type_Int + "%";
        this.jdField_h_of_type_Float = this.jdField_f_of_type_AndroidGraphicsPaint.measureText(str, 0, str.length());
        if (this.jdField_c_of_type_Int != 0) {
          paramCanvas.drawText(str, this.jdField_a_of_type_Int - this.jdField_h_of_type_Float / 2.0F, this.jdField_b_of_type_Int + this.i / 4.0F, this.jdField_f_of_type_AndroidGraphicsPaint);
        }
      }
      float f2 = this.jdField_b_of_type_Int + this.i / 4.0F + 165.0F * this.j;
      float f1 = f2;
      if (f2 < this.jdField_b_of_type_Int + this.jdField_f_of_type_Float * this.j + this.jdField_h_of_type_Int / 2) {
        f1 = this.jdField_b_of_type_Int + this.jdField_f_of_type_Float * this.j + this.jdField_h_of_type_Int / 2;
      }
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int - this.jdField_g_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length()) / 2.0F, f1, this.jdField_g_of_type_AndroidGraphicsPaint);
      postInvalidateDelayed(15L);
      return;
    }
  }
  
  public void setFistAgree()
  {
    Random localRandom = new Random();
    int k = this.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = (localRandom.nextInt(20) + k);
  }
  
  public void setScale(int paramInt)
  {
    this.j = (paramInt / 640.0F);
  }
  
  public void setScanText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setTotalProgress(int paramInt)
  {
    if (paramInt > this.jdField_c_of_type_Int) {
      this.jdField_c_of_type_Int = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ScanSuccessView
 * JD-Core Version:    0.7.0.1
 */