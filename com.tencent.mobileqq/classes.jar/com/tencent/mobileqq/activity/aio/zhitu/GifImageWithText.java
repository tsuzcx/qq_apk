package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GifImageWithText
  extends NativeGifImage
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private ZhituTextManager.DrawTextParam jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam;
  private boolean jdField_a_of_type_Boolean = false;
  private Paint b;
  
  public GifImageWithText(File paramFile, boolean paramBoolean, float paramFloat)
  {
    super(paramFile, paramBoolean, false, 0, 0, paramFloat);
  }
  
  private void a(Canvas paramCanvas, Rect paramRect)
  {
    if ((QLog.isColorLevel()) && (!this.jdField_a_of_type_Boolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" dst rect is ");
      localStringBuilder.append(paramRect);
      localStringBuilder.append(" but bitmap is ");
      localStringBuilder.append(getWidth());
      localStringBuilder.append(" / ");
      localStringBuilder.append(getHeight());
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
      this.jdField_a_of_type_Boolean = true;
    }
    float f2 = paramRect.width() / getWidth();
    float f1;
    if (Math.abs(f2 - 1.0F) < 0.01D)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.jdField_a_of_type_AndroidGraphicsPaint;
        this.b = this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.b;
      }
      f1 = 1.0F;
    }
    else
    {
      f1 = f2;
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.jdField_a_of_type_AndroidGraphicsPaint.getTextSize() * f2);
        f1 = f2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.b != null)
        {
          this.b = new Paint(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.b);
          this.b.setTextSize(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.b.getTextSize() * f2);
          f1 = f2;
        }
      }
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.jdField_a_of_type_ArrayOfFloat.length)
    {
      f2 = paramRect.top + this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.jdField_a_of_type_ArrayOfFloat[i] * f1;
      if (this.b != null) {
        paramCanvas.drawText(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.jdField_a_of_type_ArrayOfJavaLangString[i], paramRect.exactCenterX(), f2, this.b);
      }
      paramCanvas.drawText(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam.jdField_a_of_type_ArrayOfJavaLangString[i], paramRect.exactCenterX(), f2, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
  }
  
  public int a()
  {
    return this.mMetaData[POST_INVALIDATION_TIME_INDEX];
  }
  
  public Bitmap a()
  {
    return this.mCurrentFrameBitmap;
  }
  
  public void a()
  {
    getNextFrame();
    applyNextFrame();
  }
  
  public void a(Canvas paramCanvas)
  {
    Rect localRect = new Rect(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("draw text to file dst rect is ");
      localStringBuilder.append(localRect);
      localStringBuilder.append(" and bitmap is ");
      localStringBuilder.append(getWidth());
      localStringBuilder.append(" / ");
      localStringBuilder.append(getHeight());
      QLog.d("ZhituManager", 2, localStringBuilder.toString());
    }
    a(paramCanvas, localRect);
  }
  
  public void a(ZhituTextManager.DrawTextParam paramDrawTextParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituTextManager$DrawTextParam = paramDrawTextParam;
  }
  
  public int b()
  {
    return this.mMetaData[FRAME_COUNT_INDEX];
  }
  
  public int c()
  {
    return this.mCurrentFrameIndex;
  }
  
  public int d()
  {
    return this.mMetaData[WIDTH_INDEX];
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
    a(paramCanvas, paramRect);
  }
  
  public void drawFirstFrame(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    super.drawFirstFrame(paramCanvas, paramRect, paramPaint);
    a(paramCanvas, paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.GifImageWithText
 * JD-Core Version:    0.7.0.1
 */