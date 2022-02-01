package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ViewUtils;
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
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131167045));
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(ViewUtils.a(16.0F));
    this.jdField_d_of_type_Int = 255;
    this.jdField_e_of_type_Int = 0;
    this.jdField_e_of_type_Float = 0.0F;
    this.jdField_f_of_type_Float = 0.0F;
    this.jdField_g_of_type_Float = 0.0F;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131689927);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131689929);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131698519);
    this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_b_of_type_JavaLangString);
    this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_c_of_type_JavaLangString);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString != null))
    {
      if (this.jdField_c_of_type_JavaLangString == null) {
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
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = ((paramInt3 - paramInt1) / 2);
    this.jdField_b_of_type_Int = ((paramInt4 - paramInt2) / 2);
    double d1 = this.jdField_a_of_type_Int;
    Double.isNaN(d1);
    this.jdField_c_of_type_Int = ((int)(d1 * 0.8D));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayout ");
      localStringBuilder.append(toString());
      QLog.d("PttTextTransitionAnim", 2, localStringBuilder.toString());
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
    float f1;
    int i;
    if (paramFloat <= 0.5F)
    {
      f1 = 0.5F - paramFloat;
      this.jdField_d_of_type_Int = ((int)(f1 * 255.0F) * 2);
      this.jdField_e_of_type_Int = ((int)(255.0F * paramFloat) * 2);
      this.jdField_f_of_type_Int = 0;
      i = this.jdField_c_of_type_Int;
      this.jdField_e_of_type_Float = (-i * paramFloat * 2.0F);
      this.jdField_f_of_type_Float = (i * f1 * 2.0F);
    }
    else
    {
      this.jdField_d_of_type_Int = 0;
      f1 = 1.0F - paramFloat;
      this.jdField_e_of_type_Int = ((int)(f1 * 255.0F * 2.0F));
      paramFloat -= 0.5F;
      this.jdField_f_of_type_Int = ((int)(255.0F * paramFloat * 2.0F));
      i = this.jdField_c_of_type_Int;
      this.jdField_f_of_type_Float = (-i * paramFloat * 2.0F);
      this.jdField_g_of_type_Float = (i * f1 * 2.0F);
    }
    invalidate();
  }
  
  public void setScrollDis(float paramFloat, int paramInt)
  {
    paramFloat = paramFloat / paramInt / 2.0F;
    setProgress(this.jdField_a_of_type_Float + paramFloat);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PttTextTransitionAnim{ progress=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", alphaVoiceChange=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", alphaPressToSpeak=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", alphaRecord=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", tranlateXVoiceChange=");
    localStringBuilder.append(this.jdField_e_of_type_Float);
    localStringBuilder.append(", tranlateXPressToSpeak=");
    localStringBuilder.append(this.jdField_f_of_type_Float);
    localStringBuilder.append(", tranlateXRecord=");
    localStringBuilder.append(this.jdField_g_of_type_Float);
    localStringBuilder.append(", centerX=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", centerY=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PttTextTransitionAnim
 * JD-Core Version:    0.7.0.1
 */