package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class BasicTextRegionTextItem
  extends DynamicTextItem
{
  float jdField_a_of_type_Float = 0.0F;
  Resources jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter = null;
  StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = null;
  BaseTextRegion jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseTextRegion = null;
  ArrayList<BaseTextRegion> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 0;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint = null;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = 0;
  float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int = 0;
  private float jdField_e_of_type_Float = 0.0F;
  private int jdField_e_of_type_Int = 0;
  private int f = 0;
  private int g = 0;
  
  public BasicTextRegionTextItem(int paramInt, @NonNull List<String> paramList)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(AIOUtils.b(3.0F, BaseApplicationImpl.getContext().getResources()));
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_b_of_type_Boolean)
    {
      this.g = paramInt;
      this.jdField_d_of_type_Int = AIOUtils.b(paramFloat1, BaseApplicationImpl.getApplication().getResources());
      this.jdField_e_of_type_Int = AIOUtils.b(paramFloat2, BaseApplicationImpl.getApplication().getResources());
      this.f = AIOUtils.b(paramFloat3, BaseApplicationImpl.getApplication().getResources());
    }
  }
  
  private void a(boolean paramBoolean, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Int = AIOUtils.b(paramFloat, BaseApplicationImpl.getContext().getResources());
      this.jdField_c_of_type_Int = paramInt;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, int paramInt6, Point paramPoint)
  {
    int j = paramInt3;
    while (j >= paramInt4)
    {
      Object localObject1 = this.jdField_a_of_type_AndroidTextTextPaint;
      float f1 = j;
      ((TextPaint)localObject1).setTextSize(f1);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(f1);
      localObject1 = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, paramInt6);
      Object localObject2 = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_b_of_type_AndroidTextTextPaint, paramInt1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, paramInt6);
      this.jdField_b_of_type_AndroidTextStaticLayout = ((StaticLayout)localObject1);
      this.jdField_a_of_type_AndroidTextStaticLayout = ((StaticLayout)localObject2);
      if (((StaticLayout)localObject1).getLineCount() > 1)
      {
        int i;
        if (((StaticLayout)localObject1).getLineVisibleEnd(1) < paramString.length()) {
          i = 0;
        } else {
          i = 1;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[");
          ((StringBuilder)localObject2).append(paramString.length());
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(paramInt5);
          ((StringBuilder)localObject2).append(",");
          ((StringBuilder)localObject2).append(((StaticLayout)localObject1).getLineEnd(0));
          QLog.d("BasicTextRegionTextItem", 2, ((StringBuilder)localObject2).toString());
        }
        paramInt3 = i;
        if (paramString.length() >= paramInt5)
        {
          paramInt3 = i;
          if (((StaticLayout)localObject1).getLineEnd(0) < paramInt5) {
            paramInt3 = 0;
          }
        }
      }
      else
      {
        paramInt3 = 1;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("==>");
        ((StringBuilder)localObject2).append(((StaticLayout)localObject1).getHeight());
        ((StringBuilder)localObject2).append(" ==>");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append(" ==>");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(" ==>");
        ((StringBuilder)localObject2).append(paramInt4);
        QLog.d("BasicTextRegionTextItem", 2, ((StringBuilder)localObject2).toString());
      }
      if (((StaticLayout)localObject1).getHeight() > paramInt2) {
        paramInt3 = 0;
      }
      if (paramInt3 != 0)
      {
        f1 = super.a((StaticLayout)localObject1);
        float f2 = ((StaticLayout)localObject1).getHeight();
        paramPoint.set((int)(paramInt1 - f1), (int)(paramInt2 - f2));
        return true;
      }
      paramPoint.set(0, 0);
      j -= 1;
    }
    return false;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseTextRegion.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
  }
  
  public int a()
  {
    return 1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new BasicTextRegionTextItem.1(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject1 = super.b(paramInt);
    paramString = (String)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramString = "  ";
    }
    Object localObject2 = a(10, paramString);
    Object localObject3 = new Point[this.jdField_a_of_type_JavaUtilArrayList.size()];
    localObject1 = new float[this.jdField_a_of_type_JavaUtilArrayList.size()];
    boolean[] arrayOfBoolean = new boolean[this.jdField_a_of_type_JavaUtilArrayList.size()];
    StaticLayout[] arrayOfStaticLayout1 = new StaticLayout[this.jdField_a_of_type_JavaUtilArrayList.size()];
    StaticLayout[] arrayOfStaticLayout2 = new StaticLayout[this.jdField_a_of_type_JavaUtilArrayList.size()];
    paramString = new int[this.jdField_a_of_type_JavaUtilArrayList.size()];
    paramInt = 0;
    float f1;
    float f2;
    while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject3[paramInt] = new Point(0, 0);
      BaseTextRegion localBaseTextRegion = (BaseTextRegion)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      arrayOfBoolean[paramInt] = false;
      f1 = localBaseTextRegion.jdField_c_of_type_Int;
      f2 = localBaseTextRegion.jdField_d_of_type_Int;
      arrayOfBoolean[paramInt] = a((int)f1, (int)f2, localBaseTextRegion.h, localBaseTextRegion.g, (String)localObject2, localBaseTextRegion.jdField_a_of_type_Int, localBaseTextRegion.i, localObject3[paramInt]);
      arrayOfStaticLayout1[paramInt] = this.jdField_b_of_type_AndroidTextStaticLayout;
      arrayOfStaticLayout2[paramInt] = this.jdField_a_of_type_AndroidTextStaticLayout;
      localObject1[paramInt] = this.jdField_b_of_type_AndroidTextStaticLayout.getPaint().getTextSize();
      paramInt += 1;
    }
    localObject2 = new float[this.jdField_a_of_type_JavaUtilArrayList.size()];
    paramInt = 0;
    while (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject3 = (BaseTextRegion)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localObject1[paramInt]);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(localObject1[paramInt]);
      paramString[paramInt] = arrayOfStaticLayout1[paramInt].getLineCount();
      if (arrayOfBoolean[paramInt] != 0)
      {
        f1 = AIOUtils.b(((BaseTextRegion)localObject3).jdField_c_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
        f2 = AIOUtils.b(((BaseTextRegion)localObject3).jdField_d_of_type_Int, this.jdField_a_of_type_AndroidContentResResources);
        localObject2[paramInt] = (super.a(arrayOfStaticLayout1[paramInt]) * arrayOfStaticLayout1[paramInt].getHeight() / (f1 * f2));
      }
      else
      {
        localObject2[paramInt] = 0.0F;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("scale:");
        ((StringBuilder)localObject3).append(localObject2[paramInt]);
        ((StringBuilder)localObject3).append(" index:");
        ((StringBuilder)localObject3).append(paramInt);
        QLog.i("BasicTextRegionTextItem", 2, ((StringBuilder)localObject3).toString());
      }
      paramInt += 1;
    }
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (paramInt >= 0)
    {
      int j;
      if ((arrayOfBoolean[paramInt] != 1) || (arrayOfBoolean[i] != 1))
      {
        j = i;
        if (localObject2[paramInt] > localObject2[i])
        {
          int k;
          if ((arrayOfBoolean[paramInt] == 1) && (arrayOfBoolean[i] == 1) && (paramString[paramInt] > paramString[i])) {
            k = 1;
          } else {
            k = 0;
          }
          j = i;
          if (k != 0) {}
        }
      }
      else
      {
        j = paramInt;
      }
      paramInt -= 1;
      i = j;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("curIndex:");
      paramString.append(i);
      QLog.i("BasicTextRegionTextItem", 2, paramString.toString());
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseTextRegion = ((BaseTextRegion)this.jdField_a_of_type_JavaUtilArrayList.get(i));
    this.jdField_b_of_type_AndroidTextStaticLayout = arrayOfStaticLayout1[i];
    this.jdField_a_of_type_AndroidTextStaticLayout = arrayOfStaticLayout2[i];
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(localObject1[i]);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(localObject1[i]);
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.drawBitmap(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseTextRegion.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      this.jdField_c_of_type_Float = super.a(this.jdField_b_of_type_AndroidTextStaticLayout);
      this.jdField_d_of_type_Float = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      this.jdField_a_of_type_Float = (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseTextRegion.jdField_e_of_type_Int + (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseTextRegion.jdField_c_of_type_Int - this.jdField_c_of_type_Float) / 2.0F);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseTextRegion.f + (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseTextRegion.jdField_d_of_type_Int - this.jdField_d_of_type_Float) / 2.0F);
      paramCanvas.translate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(this.jdField_b_of_type_Int);
        this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(this.jdField_d_of_type_Int);
        this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.g);
        paramCanvas.translate(this.jdField_e_of_type_Int, this.f);
        this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
        paramCanvas.translate(-this.jdField_e_of_type_Int, -this.f);
      }
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (super.b(0))
      {
        RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        float f1 = this.jdField_e_of_type_Float;
        localRectF.left = (0.0F - f1);
        localRectF.top = (0.0F - f1);
        localRectF.right = (this.jdField_c_of_type_Float + f1 * 2.0F);
        localRectF.bottom = (this.jdField_d_of_type_Float + f1 * 2.0F);
        paramCanvas.drawRoundRect(localRectF, 6.0F, 6.0F, a());
      }
    }
    paramCanvas.restore();
  }
  
  public void a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextBaseTextRegion.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BasicTextRegionTextItem
 * JD-Core Version:    0.7.0.1
 */