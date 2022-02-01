package com.tencent.avgame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.qphone.base.util.QLog;

public class AVGameText
  extends View
{
  public static Typeface a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private AVGameText.Attribute jdField_a_of_type_ComTencentAvgameUiAVGameText$Attribute = new AVGameText.Attribute();
  private String jdField_a_of_type_JavaLangString = "";
  
  public AVGameText(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public AVGameText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private int a(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static Typeface a()
  {
    try
    {
      jdField_a_of_type_AndroidGraphicsTypeface = Typeface.createFromFile(AvGameResDownloadManager.d() + "GameFont.ttf");
      if (QLog.isColorLevel()) {
        QLog.d("AVGameText", 2, "typeface path = " + AvGameResDownloadManager.d() + "GameFont.ttf");
      }
      return jdField_a_of_type_AndroidGraphicsTypeface;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        QLog.e("AVGameText", 2, "create typeface failed : " + localRuntimeException.getMessage());
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(a(30.0F));
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(a());
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_ComTencentAvgameUiAVGameText$Attribute == null) || (!this.jdField_a_of_type_ComTencentAvgameUiAVGameText$Attribute.a())) {
      return;
    }
    float f1 = -this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent;
    f1 = getHeight() - (getHeight() - f1) / 2.0F;
    float f2 = (getWidth() - this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString)) / 2.0F;
    paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(this.jdField_a_of_type_ComTencentAvgameUiAVGameText$Attribute.b));
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(a(3.0F), 0.0F, a(1.0F), Color.parseColor("#33000000"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(a(4.0F));
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f2, a(0.4F) + f1, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor(this.jdField_a_of_type_ComTencentAvgameUiAVGameText$Attribute.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
    this.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(null);
    this.jdField_a_of_type_AndroidGraphicsPaint.clearShadowLayer();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f2, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension((int)(this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString) + 0.5F) + a(8.0F), getMeasuredHeight());
  }
  
  public void setAttribute(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText$Attribute.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText$Attribute.b = paramString2;
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameText
 * JD-Core Version:    0.7.0.1
 */