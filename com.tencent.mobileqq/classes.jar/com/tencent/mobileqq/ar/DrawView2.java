package com.tencent.mobileqq.ar;

import amxp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import java.util.Iterator;
import java.util.List;

public class DrawView2
  extends View
{
  public static float a;
  public static int a;
  public static float b;
  public static int b;
  public static int c;
  public static int d;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Handler jdField_a_of_type_AndroidOsHandler;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  List<amxp> jdField_a_of_type_JavaUtilList;
  private Paint b;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
    jdField_b_of_type_Float = 1.0F;
  }
  
  public DrawView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setARGB(255, 0, 255, 0);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(10.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(10.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(30.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-65536);
    setWillNotDraw(false);
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DrawViewThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    amxp localamxp;
    int i;
    label60:
    float f1;
    float f2;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        localamxp = (amxp)localIterator.next();
        paramCanvas.save();
        i = 0;
        if (i < 90) {
          if (jdField_a_of_type_Float != 1.0F)
          {
            f1 = localamxp.jdField_a_of_type_ArrayOfFloat[(i * 2)];
            f2 = jdField_a_of_type_Int / 2;
            float f3 = c / 2 / (jdField_a_of_type_Int / 2 / jdField_a_of_type_Float);
            f2 = c / 2 + (f1 - f2) * f3;
            f1 = localamxp.jdField_a_of_type_ArrayOfFloat[(i * 2 + 1)] * d / jdField_b_of_type_Int;
          }
        }
      }
    }
    for (;;)
    {
      paramCanvas.drawPoint(f2, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      if ((!TextUtils.isEmpty(localamxp.jdField_a_of_type_JavaLangString)) && (i == 87)) {
        paramCanvas.drawText(localamxp.jdField_a_of_type_JavaLangString, f2, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      i += 1;
      break label60;
      if (jdField_b_of_type_Float != 1.0F)
      {
        f2 = localamxp.jdField_a_of_type_ArrayOfFloat[(i * 2)] * c / jdField_a_of_type_Int;
        f1 = (localamxp.jdField_a_of_type_ArrayOfFloat[(i * 2 + 1)] - jdField_b_of_type_Int / 2) * (d / 2 / (jdField_b_of_type_Int / 2 / jdField_b_of_type_Float)) + d / 2;
        continue;
        paramCanvas.restore();
        break;
        return;
      }
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  public void setFaceData(List<amxp> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.DrawView2
 * JD-Core Version:    0.7.0.1
 */