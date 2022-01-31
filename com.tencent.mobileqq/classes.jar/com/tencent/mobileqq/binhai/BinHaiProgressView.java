package com.tencent.mobileqq.binhai;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class BinHaiProgressView
  extends View
{
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_a_of_type_JavaLangString;
  
  public BinHaiProgressView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize((int)(paramContext.getResources().getDisplayMetrics().density * 18.0F));
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
  }
  
  public void a(float paramFloat, String paramString)
  {
    this.jdField_a_of_type_Float = Math.max(0.0F, Math.min(1.0F, paramFloat));
    this.jdField_a_of_type_JavaLangString = paramString;
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    int k = Math.min(i, j) / 2;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1728053247);
    paramCanvas.drawCircle(i / 2, j / 2, k, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-967876);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i / 2 - k, j / 2 - k, i / 2 + k, j / 2 + k);
    float f = (1.0F - this.jdField_a_of_type_Float) * 360.0F;
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F + f, 360.0F - f, true, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.drawCircle(i / 2, j / 2, k * 0.8245614F, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-967876);
      Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
      j = i / 2;
      k = (localFontMetricsInt.bottom - localFontMetricsInt.top) / 2;
      int m = localFontMetricsInt.bottom;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, i / 2, j + k - m, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setFont(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      QLog.d("BinHaiProgressView", 1, "setFont, not exist:" + paramString);
      return;
    }
    paramString = Typeface.createFromFile(localFile);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.binhai.BinHaiProgressView
 * JD-Core Version:    0.7.0.1
 */