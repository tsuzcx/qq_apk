import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import java.util.Arrays;
import java.util.List;

public class b
  extends l
{
  private final String a;
  private Paint c;
  private int[] h;
  
  public b(ETTextView paramETTextView, ETFont paramETFont)
  {
    super(paramETTextView, paramETFont);
    this.jdField_a_of_type_JavaLangString = getClass().getName();
  }
  
  private void k()
  {
    int i;
    label66:
    r localr;
    if (this.jdField_c_of_type_AndroidGraphicsCanvas == null)
    {
      this.jdField_c_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (this.jdField_c_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_c_of_type_AndroidGraphicsPaint.setColor(-16777216);
      }
      this.jdField_h_of_type_ArrayOfInt = new int[this.jdField_b_of_type_JavaUtilList.size()];
      i = 0;
      if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
        return;
      }
      localr = (r)this.jdField_b_of_type_JavaUtilList.get(i);
      if (localr.jdField_a_of_type_Boolean) {
        break label130;
      }
      this.jdField_h_of_type_ArrayOfInt[i] = 0;
    }
    for (;;)
    {
      i += 1;
      break label66;
      this.jdField_c_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      break;
      label130:
      this.jdField_h_of_type_ArrayOfInt[i] = 1;
      this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(localr.jdField_c_of_type_Int);
      float f1 = localr.jdField_c_of_type_Int / 2.0F;
      float f2 = (this.jdField_c_of_type_AndroidGraphicsPaint.descent() + this.jdField_c_of_type_AndroidGraphicsPaint.ascent()) / 2.0F;
      this.jdField_c_of_type_AndroidGraphicsCanvas.drawText(String.valueOf(localr.jdField_a_of_type_Char), localr.jdField_d_of_type_Int, localr.jdField_e_of_type_Int + (f1 - f2), this.jdField_c_of_type_AndroidGraphicsPaint);
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (b())
    {
      i.b(this.jdField_a_of_type_JavaLangString, "DynamicMultipleStyleLayout::onDraw view宽高为0或超过屏幕尺寸......");
      return false;
    }
    if (!a())
    {
      i.b(this.jdField_a_of_type_JavaLangString, "DynamicMultipleStyleLayout::onDraw 创建bitmap失败！");
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      i.b(this.jdField_a_of_type_JavaLangString, "DynamicMultipleStyleLayout::onDraw 行数为零！");
      return false;
    }
    if (this.jdField_a_of_type_ArrayOfInt.length <= 0)
    {
      i.b(this.jdField_a_of_type_JavaLangString, "DynamicMultipleStyleLayout::onDraw 字数为零！");
      return false;
    }
    long l1 = System.nanoTime();
    c();
    b(paramCanvas);
    k();
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mShouldDisplayAnimation) && (!this.jdField_b_of_type_Boolean) && (this.jdField_h_of_type_Int > 0) && (this.jdField_h_of_type_Int < 6))
    {
      g.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_h_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.f - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.g - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.j, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_i_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex);
      b_();
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
      if (this.jdField_e_of_type_Int == 0) {
        b();
      }
    }
    for (;;)
    {
      if (g.jdField_a_of_type_Boolean)
      {
        long l2 = System.nanoTime();
        i.b(this.jdField_a_of_type_JavaLangString, "动画帧耗时 frameIndex:" + this.jdField_e_of_type_Int + "  行：" + this.jdField_h_of_type_Int + "  列：" + this.jdField_i_of_type_Int + "  耗时：" + (float)(l2 - l1) / 1000000.0F + "ms");
        if (this.jdField_e_of_type_Int == 0) {
          a("drawAnimationText.....");
        }
      }
      return true;
      this.jdField_e_of_type_Int = 0;
      g.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_h_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.f - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.g - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.j, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, 0, this.jdField_i_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex);
      j();
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, null);
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) || (b())) {}
    do
    {
      return;
      if ((this.jdField_h_of_type_Int <= 0) || (this.jdField_h_of_type_Int > 5) || (this.jdField_b_of_type_Boolean))
      {
        i.b(this.jdField_a_of_type_JavaLangString, "0行或超过5行或全EMOJI不支持播放动画..." + this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath);
        return;
      }
    } while ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    if (g.jdField_a_of_type_Boolean) {
      i.a(this.jdField_a_of_type_JavaLangString, "StartAnimation......animInfo:" + Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
    }
    if ((this.jdField_i_of_type_ArrayOfInt[0] > 0) && (this.jdField_i_of_type_ArrayOfInt[1] > 0))
    {
      h();
      return;
    }
    this.jdField_e_of_type_Int = 0;
    g.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_c_of_type_ArrayOfInt, this.jdField_d_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_h_of_type_ArrayOfInt, this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.f - this.jdField_a_of_type_Int - this.jdField_b_of_type_Int, this.g - this.jdField_c_of_type_Int - this.jdField_d_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, this.j, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_i_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.m_comboIndex);
    if ((this.jdField_i_of_type_ArrayOfInt[0] <= 0) || (this.jdField_i_of_type_ArrayOfInt[1] <= 0))
    {
      i.b(this.jdField_a_of_type_JavaLangString, "StartAnimation......动画帧数和帧间隔数据异常 animInfo:" + Arrays.toString(this.jdField_i_of_type_ArrayOfInt));
      return;
    }
    h();
  }
  
  protected void b_()
  {
    int j = (int)(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getTextSize() / 15.0F);
    int i;
    label47:
    r localr;
    if (this.jdField_b_of_type_AndroidGraphicsCanvas == null)
    {
      this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      int k = this.jdField_b_of_type_JavaUtilList.size();
      i = 0;
      if (i >= k) {
        return;
      }
      localr = (r)this.jdField_b_of_type_JavaUtilList.get(i);
      switch (localr.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      i += 1;
      break label47;
      this.jdField_b_of_type_AndroidGraphicsCanvas.setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      break;
      Object localObject = a(localr.jdField_b_of_type_Int, j);
      this.jdField_b_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject, localr.jdField_d_of_type_Int, localr.jdField_e_of_type_Int + localr.jdField_c_of_type_Int - j, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      continue;
      this.jdField_b_of_type_AndroidGraphicsCanvas.drawRect(localr.jdField_d_of_type_Int, localr.jdField_e_of_type_Int, localr.jdField_d_of_type_Int + localr.jdField_b_of_type_Int, localr.jdField_e_of_type_Int + localr.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      if ((localr.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof bain))
      {
        ((bain)localr.jdField_a_of_type_AndroidTextStyleCharacterStyle).draw(this.jdField_b_of_type_AndroidGraphicsCanvas, null, 0, 0, localr.jdField_d_of_type_Int, localr.jdField_e_of_type_Int, localr.jdField_e_of_type_Int + localr.jdField_c_of_type_Int, localr.jdField_e_of_type_Int + localr.jdField_c_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
      else if ((localr.jdField_a_of_type_AndroidTextStyleCharacterStyle instanceof axye))
      {
        localObject = (axye)localr.jdField_a_of_type_AndroidTextStyleCharacterStyle;
        ((axye)localObject).jdField_a_of_type_Boolean = false;
        ((axye)localObject).draw(this.jdField_b_of_type_AndroidGraphicsCanvas, null, 0, 0, localr.jdField_d_of_type_Int, localr.jdField_e_of_type_Int, localr.jdField_e_of_type_Int, localr.jdField_e_of_type_Int + localr.jdField_c_of_type_Int, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaint());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     b
 * JD-Core Version:    0.7.0.1
 */