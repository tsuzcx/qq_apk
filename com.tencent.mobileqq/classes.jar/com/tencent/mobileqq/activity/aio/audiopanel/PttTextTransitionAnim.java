package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import bclx;
import com.tencent.qphone.base.util.QLog;

public class PttTextTransitionAnim
  extends ImageView
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  String jdField_a_of_type_JavaLangString;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int = 255;
  float jdField_e_of_type_Float;
  int jdField_e_of_type_Int = 0;
  float jdField_f_of_type_Float;
  int jdField_f_of_type_Int = 0;
  float jdField_g_of_type_Float;
  int jdField_g_of_type_Int = -1;
  
  public PttTextTransitionAnim(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PttTextTransitionAnim(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PttTextTransitionAnim(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131166975));
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(bclx.a(16.0F));
    this.jdField_d_of_type_Int = 255;
    this.jdField_e_of_type_Int = 0;
    this.jdField_e_of_type_Float = 0.0F;
    this.jdField_f_of_type_Float = 0.0F;
    this.jdField_g_of_type_Float = 0.0F;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131689920);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131689922);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131697664);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_b_of_type_JavaLangString);
    this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_c_of_type_JavaLangString);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString == null)) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_d_of_type_Int);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int + this.jdField_e_of_type_Float - this.jdField_b_of_type_Float / 2.0F, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_e_of_type_Int);
    paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int + this.jdField_f_of_type_Float - this.jdField_c_of_type_Float / 2.0F, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.jdField_f_of_type_Int);
    paramCanvas.drawText(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int + this.jdField_g_of_type_Float - this.jdField_d_of_type_Float / 2.0F, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = ((paramInt3 - paramInt1) / 2);
    this.jdField_b_of_type_Int = ((paramInt4 - paramInt2) / 2);
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.8D));
    if (QLog.isColorLevel()) {
      QLog.d("PttTextTransitionAnim", 2, "onLayout " + toString());
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Float = 0.0F;
      setProgress(this.jdField_a_of_type_Float);
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Float = 0.5F;
      setProgress(this.jdField_a_of_type_Float);
      return;
    }
    this.jdField_a_of_type_Float = 1.0F;
    setProgress(this.jdField_a_of_type_Float);
  }
  
  public void setProgress(float paramFloat)
  {
    if (paramFloat <= 0.5F)
    {
      this.jdField_d_of_type_Int = ((int)((0.5F - paramFloat) * 255.0F) * 2);
      this.jdField_e_of_type_Int = ((int)(255.0F * paramFloat) * 2);
      this.jdField_f_of_type_Int = 0;
      this.jdField_e_of_type_Float = (-this.jdField_c_of_type_Int * paramFloat * 2.0F);
      this.jdField_f_of_type_Float = (this.jdField_c_of_type_Int * (0.5F - paramFloat) * 2.0F);
    }
    for (;;)
    {
      invalidate();
      return;
      this.jdField_d_of_type_Int = 0;
      this.jdField_e_of_type_Int = ((int)((1.0F - paramFloat) * 255.0F * 2.0F));
      this.jdField_f_of_type_Int = ((int)((paramFloat - 0.5F) * 255.0F * 2.0F));
      this.jdField_f_of_type_Float = (-this.jdField_c_of_type_Int * (paramFloat - 0.5F) * 2.0F);
      this.jdField_g_of_type_Float = (this.jdField_c_of_type_Int * (1.0F - paramFloat) * 2.0F);
    }
  }
  
  public void setScrollDis(float paramFloat, int paramInt)
  {
    setProgress(paramFloat / paramInt / 2.0F + this.jdField_a_of_type_Float);
  }
  
  public String toString()
  {
    return "PttTextTransitionAnim{ progress=" + this.jdField_a_of_type_Float + ", alphaVoiceChange=" + this.jdField_d_of_type_Int + ", alphaPressToSpeak=" + this.jdField_e_of_type_Int + ", alphaRecord=" + this.jdField_f_of_type_Int + ", tranlateXVoiceChange=" + this.jdField_e_of_type_Float + ", tranlateXPressToSpeak=" + this.jdField_f_of_type_Float + ", tranlateXRecord=" + this.jdField_g_of_type_Float + ", centerX=" + this.jdField_a_of_type_Int + ", centerY=" + this.jdField_b_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PttTextTransitionAnim
 * JD-Core Version:    0.7.0.1
 */