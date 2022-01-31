package com.tencent.biz.pubaccount.readinjoy.capture;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import lho;
import lhp;
import lhq;

public class ReadInJoyCameraProgressView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Paint c;
  
  public ReadInJoyCameraProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInJoyCameraProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyCameraProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2)
  {
    RectF localRectF = new RectF();
    localRectF.top = 0.0F;
    localRectF.bottom = this.jdField_b_of_type_Int;
    localRectF.left = paramFloat1;
    localRectF.right = (paramFloat1 + paramFloat2);
    paramCanvas.drawRect(localRectF, paramPaint);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() < 2) {
        break label90;
      }
    }
    label90:
    for (float f = ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 2)).floatValue();; f = 0.0F)
    {
      this.jdField_a_of_type_Float = f;
      this.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(new lho(this));
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    float f1 = 1.0F;
    if (paramLong2 < 0L) {}
    label78:
    label94:
    for (;;)
    {
      return;
      float f2 = (float)paramLong1 / (float)paramLong2;
      if (f2 > 1.0F)
      {
        if (f1 < this.jdField_a_of_type_Float) {
          break label78;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(Float.valueOf(f1));
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          break label94;
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new lhp(this));
        return;
        f1 = f2;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(Float.valueOf(this.jdField_a_of_type_Float));
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#07D0B0"));
    }
    if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FF6991"));
    }
    if (this.c == null)
    {
      this.c = new Paint();
      this.c.setColor(Color.parseColor("#FFFFFF"));
    }
    if ((this.jdField_a_of_type_Long > 0L) && (3000.0F / (float)this.jdField_a_of_type_Long > this.jdField_a_of_type_Float)) {
      a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_Int * (3000.0F / (float)this.jdField_a_of_type_Long), AIOUtils.a(1.0F, getResources()));
    }
    if (3000.0F / (float)this.jdField_a_of_type_Long > this.jdField_a_of_type_Float) {
      a(paramCanvas, this.jdField_b_of_type_AndroidGraphicsPaint, 0.0F, this.jdField_a_of_type_Int * this.jdField_a_of_type_Float);
    }
    for (;;)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        a(paramCanvas, this.c, ((Float)this.jdField_a_of_type_JavaUtilArrayList.get(i)).floatValue() * this.jdField_a_of_type_Int, AIOUtils.a(1.0F, getResources()));
        i += 1;
      }
      a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, 0.0F, this.jdField_a_of_type_Int * this.jdField_a_of_type_Float);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    this.jdField_b_of_type_Int = getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
  }
  
  public void setProgress(long paramLong1, long paramLong2)
  {
    if ((paramLong2 < 0L) || (paramLong1 > paramLong2)) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong2;
    float f = (float)paramLong1 / (float)paramLong2;
    if (f > this.jdField_a_of_type_Float) {}
    for (;;)
    {
      this.jdField_a_of_type_Float = f;
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new lhq(this));
      return;
      f = this.jdField_a_of_type_Float;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraProgressView
 * JD-Core Version:    0.7.0.1
 */