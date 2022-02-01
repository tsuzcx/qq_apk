package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.TextGraphMap;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import java.util.Arrays;

public class FounderHiBoomLayout
  extends FounderBaseLayout
{
  public static boolean a = false;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final HiBoomTextView jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView;
  private int[] jdField_a_of_type_ArrayOfInt;
  private Canvas jdField_b_of_type_AndroidGraphicsCanvas;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int[] jdField_b_of_type_ArrayOfInt;
  private int[] c;
  private int[] d;
  private int[] e;
  private int[] f;
  
  public FounderHiBoomLayout(HiBoomTextView paramHiBoomTextView)
  {
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView = paramHiBoomTextView;
    this.jdField_b_of_type_ArrayOfInt = new int[2];
    this.c = new int[2];
    this.d = new int[2];
    this.jdField_e_of_type_ArrayOfInt = new int[3];
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("drawMissingWord....char:");
    char c1 = (char)paramInt1;
    ((StringBuilder)localObject).append(String.valueOf(c1));
    ((StringBuilder)localObject).append("  code:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("  x:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("  y:");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("  width:");
    ((StringBuilder)localObject).append(paramInt4);
    ((StringBuilder)localObject).append("  height:");
    ((StringBuilder)localObject).append(paramInt5);
    FastColorFontLog.a("HiBoomFont.FounderHiBoomLayout", ((StringBuilder)localObject).toString());
    if ((paramInt4 > 0) && (paramInt5 > 0))
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsCanvas;
      if (localObject == null) {
        this.jdField_b_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      } else {
        ((Canvas)localObject).setBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
      float f1 = paramInt5;
      ((Paint)localObject).setTextSize(f1);
      f1 /= 2.0F;
      float f2 = (this.jdField_a_of_type_AndroidGraphicsPaint.descent() + this.jdField_a_of_type_AndroidGraphicsPaint.ascent()) / 2.0F;
      localObject = this.jdField_b_of_type_AndroidGraphicsCanvas;
      float f3 = paramInt2;
      float f4 = paramInt3;
      ((Canvas)localObject).drawText(String.valueOf(c1), f3, f1 - f2 + f4, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (jdField_a_of_type_Boolean)
      {
        localObject = new Paint();
        ((Paint)localObject).setStyle(Paint.Style.STROKE);
        ((Paint)localObject).setColor(-16776961);
        ((Paint)localObject).setStrokeWidth(1.0F);
        this.jdField_b_of_type_AndroidGraphicsCanvas.drawRect(f3, f4, paramInt2 + paramInt4, paramInt3 + paramInt5, (Paint)localObject);
      }
    }
  }
  
  private void a(String paramString) {}
  
  private boolean a()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length > 0)
    {
      int[] arrayOfInt = this.jdField_e_of_type_ArrayOfInt;
      if ((arrayOfInt[0] > 0) && (arrayOfInt[1] > 0)) {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    int[] arrayOfInt = this.f;
    if ((arrayOfInt != null) && (arrayOfInt.length > 5))
    {
      int i = 1;
      for (;;)
      {
        arrayOfInt = this.f;
        if (i >= arrayOfInt.length) {
          break;
        }
        int j = arrayOfInt[i];
        int k = arrayOfInt[(i + 1)];
        int m = arrayOfInt[(i + 2)];
        int n = arrayOfInt[(i + 3)];
        int i1 = arrayOfInt[(i + 4)];
        if (j >= 0)
        {
          arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
          if (j < arrayOfInt.length) {
            a(arrayOfInt[j], k, m, n, i1);
          }
        }
        i += 5;
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, TextGraphMap paramTextGraphMap)
  {
    return 0;
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new FounderHiBoomLayout.1(this));
  }
  
  public void a(ETFont paramETFont)
  {
    int j = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(0, null, 0.0F);
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont.copy(paramETFont);
    paramETFont = paramETFont.mText;
    if (TextUtils.isEmpty(paramETFont)) {
      return;
    }
    int k = paramETFont.length();
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i;
    if (arrayOfInt != null)
    {
      i = j;
      if (arrayOfInt.length == k) {}
    }
    else
    {
      this.jdField_a_of_type_ArrayOfInt = new int[k];
      i = j;
    }
    while (i < k)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = paramETFont.charAt(i);
      i += 1;
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    this.f = FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.i);
    if (a())
    {
      a("onDraw.....");
      Object localObject = this.jdField_e_of_type_ArrayOfInt;
      if (!a(localObject[0], localObject[1])) {
        return false;
      }
      c();
      d();
      System.nanoTime();
      FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.jdField_e_of_type_Int, this.jdField_a_of_type_AndroidGraphicsBitmap, this.c);
      if (FastColorFontHelper.jdField_a_of_type_Boolean) {
        System.nanoTime();
      }
      int i = this.jdField_e_of_type_ArrayOfInt[2];
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      int[] arrayOfInt1 = this.jdField_b_of_type_ArrayOfInt;
      ((Rect)localObject).set(0, 0, arrayOfInt1[0] * 1000 / i - 1, arrayOfInt1[1] * 1000 / i - 1);
      i = FounderHiBoomLayout.2.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.getScaleType().ordinal()];
      if (i != 4)
      {
        if (i != 5)
        {
          if (i != 6)
          {
            int j;
            if (i != 7)
            {
              localObject = this.d;
              i = localObject[0];
              arrayOfInt1 = this.jdField_b_of_type_ArrayOfInt;
              i = (i - arrayOfInt1[0]) / 2;
              j = (localObject[1] - arrayOfInt1[1]) / 2;
              this.jdField_b_of_type_AndroidGraphicsRect.set(i, j, arrayOfInt1[0] + i, arrayOfInt1[1] + j);
            }
            else
            {
              localObject = this.d;
              i = localObject[0];
              arrayOfInt1 = this.jdField_b_of_type_ArrayOfInt;
              float f1 = Math.max(i / arrayOfInt1[0] * 1.0F, localObject[1] / arrayOfInt1[1] * 1.0F);
              localObject = this.jdField_b_of_type_ArrayOfInt;
              float f2 = localObject[0];
              arrayOfInt1 = this.d;
              i = (int)((f2 * f1 - arrayOfInt1[0]) / 2.0F);
              j = (int)((localObject[1] * f1 - arrayOfInt1[1]) / 2.0F);
              this.jdField_b_of_type_AndroidGraphicsRect.set(-i, -j, localObject[0] + i, localObject[1] + j);
            }
          }
          else
          {
            localObject = this.jdField_b_of_type_AndroidGraphicsRect;
            arrayOfInt1 = this.jdField_b_of_type_ArrayOfInt;
            ((Rect)localObject).set(0, 0, arrayOfInt1[0], arrayOfInt1[1]);
          }
        }
        else
        {
          localObject = this.jdField_b_of_type_AndroidGraphicsRect;
          arrayOfInt1 = this.d;
          i = arrayOfInt1[0];
          int[] arrayOfInt2 = this.jdField_b_of_type_ArrayOfInt;
          ((Rect)localObject).set(i - arrayOfInt2[0], 0, arrayOfInt1[0] - arrayOfInt2[0] + arrayOfInt2[0], arrayOfInt2[1]);
        }
      }
      else
      {
        localObject = this.jdField_b_of_type_AndroidGraphicsRect;
        arrayOfInt1 = this.d;
        ((Rect)localObject).set(0, 0, arrayOfInt1[0], arrayOfInt1[1]);
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, null);
      if ((this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.jdField_a_of_type_Boolean) && (this.jdField_e_of_type_Int == 0)) {
        b();
      }
      return true;
    }
    a(HardCodeUtil.a(2131704958));
    return false;
  }
  
  public int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {
      j = 1;
    } else {
      j = 0;
    }
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    int[] arrayOfInt3;
    if (i != 0)
    {
      arrayOfInt1 = this.c;
      arrayOfInt2 = this.jdField_b_of_type_ArrayOfInt;
      arrayOfInt3 = this.d;
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      arrayOfInt3[0] = paramInt1;
      arrayOfInt2[0] = paramInt1;
      arrayOfInt1[0] = paramInt1;
    }
    else
    {
      arrayOfInt1 = this.c;
      this.jdField_b_of_type_ArrayOfInt[0] = 0;
      arrayOfInt1[0] = 0;
    }
    if (j != 0)
    {
      arrayOfInt1 = this.c;
      arrayOfInt2 = this.jdField_b_of_type_ArrayOfInt;
      arrayOfInt3 = this.d;
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      arrayOfInt3[1] = paramInt1;
      arrayOfInt2[1] = paramInt1;
      arrayOfInt1[1] = paramInt1;
    }
    else
    {
      arrayOfInt1 = this.c;
      this.jdField_b_of_type_ArrayOfInt[1] = 0;
      arrayOfInt1[1] = 0;
    }
    if (paramInt3 > 0)
    {
      arrayOfInt1 = this.c;
      if ((arrayOfInt1[0] > paramInt3) || (arrayOfInt1[0] == 0))
      {
        arrayOfInt1 = this.c;
        this.jdField_b_of_type_ArrayOfInt[0] = paramInt3;
        arrayOfInt1[0] = paramInt3;
      }
      arrayOfInt1 = this.c;
      if ((arrayOfInt1[1] > paramInt3) || (arrayOfInt1[1] == 0))
      {
        arrayOfInt1 = this.c;
        this.jdField_b_of_type_ArrayOfInt[1] = paramInt3;
        arrayOfInt1[1] = paramInt3;
      }
    }
    if (FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt) == 0)
    {
      arrayOfInt1 = this.d;
      arrayOfInt1[0] = 0;
      arrayOfInt1[1] = 0;
      return arrayOfInt1;
    }
    if (i == 0) {
      this.d[0] = this.jdField_b_of_type_ArrayOfInt[0];
    }
    if (j == 0) {
      this.d[1] = this.jdField_b_of_type_ArrayOfInt[1];
    }
    return this.d;
  }
  
  public int[] a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, ETFont paramETFont)
  {
    return new int[0];
  }
  
  public void b()
  {
    Object localObject = this.jdField_e_of_type_ArrayOfInt;
    if ((localObject[0] > 0) && (localObject[1] > 0))
    {
      if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()))
      {
        FastColorFontLog.b("HiBoomFont.FounderHiBoomLayout", "动画执行中....");
        return;
      }
      if ((this.i[0] > 0) && (this.i[1] > 0))
      {
        h();
        return;
      }
      this.jdField_e_of_type_Int = 0;
      FastColorFontHelper.a().a(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, this.jdField_e_of_type_ArrayOfInt, this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mAnimationId, this.i);
      if ((this.i[0] > 0) && (this.i[1] > 0))
      {
        h();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("该字体不支持动画....animInfo:");
      ((StringBuilder)localObject).append(Arrays.toString(this.i));
      ((StringBuilder)localObject).append("  ttf path:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontPath);
      FastColorFontLog.a("HiBoomFont.FounderHiBoomLayout", ((StringBuilder)localObject).toString());
      return;
    }
    a("bitmap宽高异常");
  }
  
  public void e()
  {
    super.e();
    FastColorFontLog.a("HiBoomFont.FounderHiBoomLayout", "release....");
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_b_of_type_AndroidGraphicsCanvas = null;
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (localPaint != null)
    {
      localPaint.reset();
      this.jdField_a_of_type_AndroidGraphicsPaint = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.FounderHiBoomLayout
 * JD-Core Version:    0.7.0.1
 */