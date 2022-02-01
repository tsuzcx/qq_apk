package com.tencent.mobileqq.ar;

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
  public static float a = 1.0F;
  public static int a = 0;
  public static float b = 1.0F;
  public static int b;
  public static int c;
  public static int d;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Handler jdField_a_of_type_AndroidOsHandler;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  List<DrawView2.FaceData> jdField_a_of_type_JavaUtilList;
  private Paint b;
  
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
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        DrawView2.FaceData localFaceData = (DrawView2.FaceData)((Iterator)localObject).next();
        paramCanvas.save();
        int i = 0;
        while (i < 90)
        {
          float f1 = jdField_a_of_type_Float;
          float f2 = 0.0F;
          float[] arrayOfFloat;
          int j;
          int k;
          float f3;
          if (f1 != 1.0F)
          {
            arrayOfFloat = localFaceData.jdField_a_of_type_ArrayOfFloat;
            j = i * 2;
            f1 = arrayOfFloat[j];
            k = jdField_a_of_type_Int;
            f2 = k / 2;
            int m = c;
            f3 = m / 2 / (k / 2 / jdField_a_of_type_Float);
            f2 = m / 2 + (f1 - f2) * f3;
            f1 = localFaceData.jdField_a_of_type_ArrayOfFloat[(j + 1)] * d / jdField_b_of_type_Int;
          }
          else if (jdField_b_of_type_Float != 1.0F)
          {
            arrayOfFloat = localFaceData.jdField_a_of_type_ArrayOfFloat;
            j = i * 2;
            f2 = arrayOfFloat[j] * c / jdField_a_of_type_Int;
            f1 = localFaceData.jdField_a_of_type_ArrayOfFloat[(j + 1)];
            j = jdField_b_of_type_Int;
            f3 = j / 2;
            k = d;
            f1 = (f1 - f3) * (k / 2 / (j / 2 / jdField_b_of_type_Float)) + k / 2;
          }
          else
          {
            f1 = 0.0F;
          }
          paramCanvas.drawPoint(f2, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
          if ((!TextUtils.isEmpty(localFaceData.jdField_a_of_type_JavaLangString)) && (i == 87)) {
            paramCanvas.drawText(localFaceData.jdField_a_of_type_JavaLangString, f2, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
          }
          i += 1;
        }
        paramCanvas.restore();
      }
    }
  }
  
  public void setFaceData(List<DrawView2.FaceData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.DrawView2
 * JD-Core Version:    0.7.0.1
 */