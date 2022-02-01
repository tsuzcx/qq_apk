package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.richstatus.SignatureActionSpan;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.font.api.IETextView;
import java.util.Arrays;
import java.util.List;

public class DynamicMultipleStyleLayout
  extends FounderColorLayout
{
  private Paint c;
  private int[] h;
  
  public DynamicMultipleStyleLayout(IETextView paramIETextView, ETFont paramETFont)
  {
    super(paramIETextView, paramETFont);
  }
  
  private void k()
  {
    if (this.jdField_c_of_type_AndroidGraphicsCanvas == null) {
      this.jdField_c_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    } else {
      this.jdField_c_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.jdField_c_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-16777216);
    }
    this.jdField_h_of_type_ArrayOfInt = new int[this.jdField_b_of_type_JavaUtilList.size()];
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilList.size())
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.jdField_b_of_type_JavaUtilList.get(i);
      if (!localModelFastColorFont.jdField_a_of_type_Boolean)
      {
        this.jdField_h_of_type_ArrayOfInt[i] = 0;
      }
      else
      {
        this.jdField_h_of_type_ArrayOfInt[i] = 1;
        this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(localModelFastColorFont.jdField_c_of_type_Int);
        float f1 = localModelFastColorFont.jdField_c_of_type_Int / 2.0F;
        float f2 = (this.jdField_c_of_type_AndroidGraphicsPaint.descent() + this.jdField_c_of_type_AndroidGraphicsPaint.ascent()) / 2.0F;
        this.jdField_c_of_type_AndroidGraphicsCanvas.drawText(String.valueOf(localModelFastColorFont.jdField_a_of_type_Char), localModelFastColorFont.jdField_d_of_type_Int, localModelFastColorFont.jdField_e_of_type_Int + (f1 - f2), this.jdField_c_of_type_AndroidGraphicsPaint);
      }
      i += 1;
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (b())
    {
      FastColorFontLog.b("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw view宽高为0或超过屏幕尺寸......");
      return false;
    }
    if (!a())
    {
      FastColorFontLog.b("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw 创建bitmap失败！");
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (this.jdField_a_of_type_ArrayOfInt.length <= 0)
      {
        FastColorFontLog.b("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw 字数为零！");
        return false;
      }
      long l1 = System.nanoTime();
      c();
      b(paramCanvas);
      k();
      if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation) && (!this.jdField_b_of_type_Boolean) && (this.jdField_h_of_type_Int > 0) && (this.jdField_h_of_type_Int < 6))
      {
        FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_h_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.f - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.g - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.j, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_i_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex);
        b_();
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
        if (this.jdField_e_of_type_Int == 0) {
          b();
        }
      }
      else
      {
        this.jdField_e_of_type_Int = 0;
        FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_h_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.f - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.g - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.j, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, 0, this.jdField_i_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex);
        j();
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
      }
      if (FastColorFontHelper.jdField_a_of_type_Boolean)
      {
        long l2 = System.nanoTime();
        paramCanvas = new StringBuilder();
        paramCanvas.append("动画帧耗时 frameIndex:");
        paramCanvas.append(this.jdField_e_of_type_Int);
        paramCanvas.append("  行：");
        paramCanvas.append(this.jdField_h_of_type_Int);
        paramCanvas.append("  列：");
        paramCanvas.append(this.jdField_i_of_type_Int);
        paramCanvas.append("  耗时：");
        paramCanvas.append((float)(l2 - l1) / 1000000.0F);
        paramCanvas.append("ms");
        FastColorFontLog.b("DynamicMultipleStyleLayout", paramCanvas.toString());
        if (this.jdField_e_of_type_Int == 0) {
          a("drawAnimationText.....");
        }
      }
      return true;
    }
    FastColorFontLog.b("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw 行数为零！");
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      if (b()) {
        return;
      }
      if ((this.jdField_h_of_type_Int > 0) && (this.jdField_h_of_type_Int <= 5) && (!this.jdField_b_of_type_Boolean))
      {
        if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
          return;
        }
        if (FastColorFontHelper.jdField_a_of_type_Boolean)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("StartAnimation......animInfo:");
          localStringBuilder.append(Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
          FastColorFontLog.a("DynamicMultipleStyleLayout", localStringBuilder.toString());
        }
        if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
        {
          h();
          return;
        }
        this.jdField_e_of_type_Int = 0;
        FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_h_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.f - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.g - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.j, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_i_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mComboIndex);
        if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
        {
          h();
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StartAnimation......动画帧数和帧间隔数据异常 animInfo:");
        localStringBuilder.append(Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
        FastColorFontLog.b("DynamicMultipleStyleLayout", localStringBuilder.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0行或超过5行或全EMOJI不支持播放动画...");
      localStringBuilder.append(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath);
      FastColorFontLog.b("DynamicMultipleStyleLayout", localStringBuilder.toString());
    }
  }
  
  protected void b_()
  {
    int j = (int)(this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getTextSize() / 15.0F);
    if (this.jdField_b_of_type_AndroidGraphicsCanvas == null) {
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    } else {
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    int k = this.jdField_b_of_type_JavaUtilList.size();
    int i = 0;
    while (i < k)
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.jdField_b_of_type_JavaUtilList.get(i);
      int m = localModelFastColorFont.jdField_a_of_type_Int;
      Object localObject;
      if (m != 1)
      {
        if (m == 2)
        {
          this.jdField_b_of_type_AndroidGraphicsCanvas.drawRect(localModelFastColorFont.jdField_d_of_type_Int, localModelFastColorFont.jdField_e_of_type_Int, localModelFastColorFont.jdField_d_of_type_Int + localModelFastColorFont.jdField_b_of_type_Int, localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
          if ((localModelFastColorFont.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof EmoticonSpan))
          {
            localObject = (EmoticonSpan)localModelFastColorFont.jdField_a_of_type_AndroidTextStyleCharacterStyle;
            Canvas localCanvas = this.jdField_b_of_type_AndroidGraphicsCanvas;
            float f = localModelFastColorFont.jdField_d_of_type_Int;
            m = localModelFastColorFont.jdField_e_of_type_Int;
            int n = localModelFastColorFont.jdField_e_of_type_Int;
            ((EmoticonSpan)localObject).draw(localCanvas, null, 0, 0, f, m, localModelFastColorFont.jdField_c_of_type_Int + n, localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint());
          }
          else if ((localModelFastColorFont.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof SignatureActionSpan))
          {
            localObject = (SignatureActionSpan)localModelFastColorFont.jdField_a_of_type_AndroidTextStyleCharacterStyle;
            ((SignatureActionSpan)localObject).jdField_a_of_type_Boolean = false;
            ((SignatureActionSpan)localObject).draw(this.jdField_b_of_type_AndroidGraphicsCanvas, null, 0, 0, localModelFastColorFont.jdField_d_of_type_Int, localModelFastColorFont.jdField_e_of_type_Int, localModelFastColorFont.jdField_e_of_type_Int, localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint());
          }
        }
      }
      else
      {
        localObject = a(localModelFastColorFont.jdField_b_of_type_Int, j);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject, localModelFastColorFont.jdField_d_of_type_Int, localModelFastColorFont.jdField_e_of_type_Int + localModelFastColorFont.jdField_c_of_type_Int - j, this.jdField_a_of_type_ComTencentMobileqqVasFontApiIETextView.getPaint());
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.DynamicMultipleStyleLayout
 * JD-Core Version:    0.7.0.1
 */