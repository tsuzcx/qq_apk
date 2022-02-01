package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.util.ArrayList;
import java.util.Iterator;

public class TextDrawImplement
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private BaseBackgroundDrawer jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseBackgroundDrawer;
  private TextDrawer jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawer;
  private ArrayList<PerLineModel> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private float b = 0.0F;
  
  public TextDrawImplement(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextTextDrawer = new PerLineDrawer();
      return;
    }
    if (paramInt == 0) {
      return;
    }
    throw new IllegalArgumentException("TextDrawImplement init failed");
  }
  
  public float a()
  {
    RectF localRectF = new RectF();
    localRectF.left = 3.4028235E+38F;
    localRectF.top = 3.4028235E+38F;
    localRectF.right = 1.4E-45F;
    localRectF.bottom = 1.4E-45F;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      PerLineModel localPerLineModel = (PerLineModel)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localRectF.left > localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.left) {
        localRectF.left = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.left;
      }
      if (localRectF.right < localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.right) {
        localRectF.right = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.right;
      }
      if (localRectF.top > localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.top) {
        localRectF.top = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.top;
      }
      if (localRectF.bottom < localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
        localRectF.bottom = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.bottom;
      }
      i += 1;
    }
    return localRectF.width();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    return ((PerLineModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString.length();
  }
  
  public RectF a(int paramInt)
  {
    return ((PerLineModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public RectF a(int paramInt1, int paramInt2)
  {
    paramInt1 -= 1;
    paramInt2 -= 1;
    if ((paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size()) && (paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_JavaUtilArrayList.size()) && (paramInt2 >= paramInt1))
    {
      RectF localRectF = new RectF();
      localRectF.left = 3.4028235E+38F;
      localRectF.top = 3.4028235E+38F;
      localRectF.right = 1.4E-45F;
      localRectF.bottom = 1.4E-45F;
      while (paramInt1 <= paramInt2)
      {
        PerLineModel localPerLineModel = (PerLineModel)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1);
        if (localRectF.left > localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.left) {
          localRectF.left = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.left;
        }
        if (localRectF.right < localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.right) {
          localRectF.right = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.right;
        }
        if (localRectF.top > localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.top) {
          localRectF.top = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.top;
        }
        if (localRectF.bottom < localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
          localRectF.bottom = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.bottom;
        }
        paramInt1 += 1;
      }
      return localRectF;
    }
    return null;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseBackgroundDrawer;
      if (localObject != null) {
        ((BaseBackgroundDrawer)localObject).a(paramCanvas, this.jdField_a_of_type_JavaUtilArrayList, paramInt1, paramInt2);
      }
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PerLineModel localPerLineModel = (PerLineModel)((Iterator)localObject).next();
      if (this.jdField_a_of_type_Int == 1)
      {
        BaseBackgroundDrawer localBaseBackgroundDrawer = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseBackgroundDrawer;
        if (localBaseBackgroundDrawer != null) {
          localPerLineModel.a(paramCanvas, localBaseBackgroundDrawer, paramInt1, paramInt2);
        }
      }
      localPerLineModel.a(paramCanvas, paramInt1, paramInt2);
    }
  }
  
  public void a(BaseBackgroundDrawer paramBaseBackgroundDrawer)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseBackgroundDrawer = paramBaseBackgroundDrawer;
  }
  
  public void a(BaseCovert paramBaseCovert)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramBaseCovert.a(i, (PerLineModel)this.jdField_a_of_type_JavaUtilArrayList.get(i));
      i += 1;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint)
  {
    if (paramTextPaint == null) {
      paramTextPaint = new TextPaint();
    }
    paramTextPaint.setTextSize(paramInt2);
    StaticLayout localStaticLayout = new StaticLayout(paramCharSequence, paramTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    float f1 = 0.0F;
    paramInt1 = 0;
    while (paramInt1 < localStaticLayout.getLineCount())
    {
      Object localObject = new RectF();
      String str = paramCharSequence.subSequence(localStaticLayout.getLineStart(paramInt1), localStaticLayout.getLineEnd(paramInt1)).toString();
      Paint.FontMetrics localFontMetrics = paramTextPaint.getFontMetrics();
      float f2 = paramTextPaint.measureText(str, 0, str.length());
      float f3 = Math.abs(localFontMetrics.bottom - localFontMetrics.top);
      float f4 = Math.abs(localFontMetrics.ascent);
      ((RectF)localObject).left = 0.0F;
      ((RectF)localObject).right = (0.0F + f2);
      ((RectF)localObject).top = f1;
      f1 += f3;
      ((RectF)localObject).bottom = f1;
      localObject = new PerLineModel(0, 0, paramTextPaint, str, (RectF)localObject, f4);
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      if (this.jdField_a_of_type_Float < f2) {
        this.jdField_a_of_type_Float = f2;
      }
      this.b += f3;
      paramInt1 += 1;
    }
  }
  
  public float b()
  {
    RectF localRectF = new RectF();
    localRectF.left = 3.4028235E+38F;
    localRectF.top = 3.4028235E+38F;
    localRectF.right = 1.4E-45F;
    localRectF.bottom = 1.4E-45F;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      PerLineModel localPerLineModel = (PerLineModel)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localRectF.left > localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.left) {
        localRectF.left = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.left;
      }
      if (localRectF.right < localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.right) {
        localRectF.right = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.right;
      }
      if (localRectF.top > localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.top) {
        localRectF.top = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.top;
      }
      if (localRectF.bottom < localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
        localRectF.bottom = localPerLineModel.jdField_a_of_type_AndroidGraphicsRectF.bottom;
      }
      i += 1;
    }
    return localRectF.height();
  }
  
  public void b(BaseBackgroundDrawer paramBaseBackgroundDrawer)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseBackgroundDrawer = paramBaseBackgroundDrawer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.TextDrawImplement
 * JD-Core Version:    0.7.0.1
 */